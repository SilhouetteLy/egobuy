package com.silhouette.egobuy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silhouette.egobuy.mapper.TbItemMapper;
import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:09
 * @description: 商品的服务实现类
 */
//@Service("itemService")
@Service(interfaceClass = ItemService.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem findItemById(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUIDataGridResult findByPages(ItemQuery query) {
        PageHelper.startPage(query.getPageNumber(),query.getPageSize());
        List<TbItem> list = itemMapper.findByPages(query);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        return new EasyUIDataGridResult(pageInfo.getTotal(),list);
    }
}
