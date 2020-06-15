package com.silhouette.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silhouette.content.service.ContentService;
import com.silhouette.egobuy.mapper.TbContentMapper;
import com.silhouette.egobuy.pojo.TbContent;
import com.silhouette.egobuy.pojo.TbContentExample;
import com.silhouette.egobuy.query.ContentQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
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
        return BuyResult.ok();
    }

    @Override
    public List<TbContent> getContentList(long categoryId) {
        // TODO Auto-generated method stub
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        // 开始查询
        List<TbContent> list = contentMapper.selectByExample(example);
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
