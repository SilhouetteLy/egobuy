package com.silhouette.egobuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.silhouette.egobuy.mapper.TbItemCatMapper;
import com.silhouette.egobuy.pojo.EasyUITreeNode;
import com.silhouette.egobuy.pojo.TbItemCat;
import com.silhouette.egobuy.pojo.TbItemCatExample;
import com.silhouette.egobuy.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:51
 * @description:
 */
@Service(interfaceClass = ItemCatService.class)
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatByParentId(long parentId) {
        List<EasyUITreeNode> nodes = null;
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andParentIdEqualTo(parentId);
        criteria.andStatusEqualTo(1);
        //开始查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //将list<TbItemCat> 转换为List<EasyUITreeNode>
        nodes = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //将node加入集合
            nodes.add(node);
        }
        return nodes;
    }
}
