package com.silhouette.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silhouette.content.service.ContentService;
import com.silhouette.egobuy.mapper.TbContentMapper;
import com.silhouette.egobuy.pojo.TbContent;
import com.silhouette.egobuy.pojo.TbContentExample;
import com.silhouette.egobuy.query.ContentQuery;
import com.silhouette.egobuy.utils.redis.JedisClient;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:48
 * @description:
 */
@Service(interfaceClass = ContentService.class)
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public EasyUIDataGridResult getContentList(ContentQuery query) {
        PageHelper.startPage(query.getPageNumber(), query.getPageSize());
        // 开始查询
        List<TbContent> list = contentMapper.findByPages(query);
        // 将list封装成PageInfo
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        // 创建返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult(pageInfo.getTotal(), list);
        return result;
    }

    @Override
    public BuyResult saveContent(TbContent content) {
        // 补全属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);
        //同步缓存（更新缓存）
        jedisClient.del("CONTENT:"+content.getCategoryId());
        return BuyResult.ok();
    }

    @Override
    public List<TbContent> getContentList(long categoryId) {
        // 先查缓存，缓存查不到再从数据库查询
        try {
            //先查询缓存
            String json = jedisClient.get("CONTENT:"+categoryId);
            //如果缓存中存在数据，直接从缓存中获取
            if(StringUtils.isNoneBlank(json)){
                List<TbContent> jsonList = JsonUtils.jsonToList(json, TbContent.class);
                return jsonList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果缓存中不存在数据再从数据库查询
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        // 开始查询
        List<TbContent> list = contentMapper.selectByExample(example);
        //向缓存中存入查询出来的数据
        try {
            jedisClient.set("CONTENT:"+categoryId, JsonUtils.objectToJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BuyResult deleteContentList(String ids) {
        String[] array = ids.split(",");
        for (String id : array){
            contentMapper.deleteByPrimaryKey(Long.parseLong(id));
        }
        return BuyResult.ok();
    }

    @Override
    public BuyResult editContent(TbContent content) {
        contentMapper.updateByPrimaryKeySelective(content);
        return BuyResult.ok();
    }
}
