package com.silhouette.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.silhouette.content.service.ContentCategoryService;
import com.silhouette.egobuy.mapper.TbContentCategoryMapper;
import com.silhouette.egobuy.pojo.EasyUITreeNode;
import com.silhouette.egobuy.pojo.TbContentCategory;
import com.silhouette.egobuy.pojo.TbContentCategoryExample;
import com.silhouette.egobuy.result.BuyResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:48
 * @description: 内容类型的服务实现
 */
@Service(interfaceClass = ContentCategoryService.class)
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCatList(long parentId) {
        List<EasyUITreeNode> nodes = null;
        //开始查询
        List<TbContentCategory> contentCatgoryList = contentCategoryMapper.selectByParentId(parentId);
        //将List<TbContentCategory>转换成List<EasyUITreeNode>
        nodes = new ArrayList<>();
        for (TbContentCategory tbContentCategory : contentCatgoryList) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            nodes.add(node);
        }
        return nodes;
    }

    @Override
    public BuyResult saveContentCat(long parentId, String name) {
        //创建一个ContentCatgory对象
        TbContentCategory contentCat = new TbContentCategory();
        //设置属性
        contentCat.setParentId(parentId);
        contentCat.setName(name);
        contentCat.setIsParent(false);
        contentCat.setSortOrder(1);
        contentCat.setStatus(1);
        contentCat.setCreated(new Date());
        contentCat.setUpdated(new Date());
        //保存
        contentCategoryMapper.insert(contentCat);
        //返回值  {"status":200,"data":{"id":102}}
        Map data = new HashMap();
        data.put("id", contentCat.getId());
        BuyResult reslut = new BuyResult(data);
        return reslut;
    }

    @Override
    public BuyResult updateContentCat(long id, String name) {
        TbContentCategory contentCat = contentCategoryMapper.selectByPrimaryKey(id);
        if (contentCat == null) {
            return BuyResult.build(999,"系统无此项内容分类");
        }
        contentCategoryMapper.updateContentCat(id,name);
        return BuyResult.ok();
    }

    @Override
    public BuyResult deleteContentCat(long id) {
        TbContentCategory contentCat = contentCategoryMapper.selectByPrimaryKey(id);
        if (contentCat == null) {
            return BuyResult.build(999,"系统无此项内容分类");
        }
        contentCategoryMapper.deleteByPrimaryKey(id);
        return BuyResult.ok();
    }
}
