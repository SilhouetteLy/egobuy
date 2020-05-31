package com.silhouette.egobuy.service.impl;

import com.silhouette.egobuy.mapper.TbItemMapper;
import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:09
 * @company: http://www.u7power.cn
 * @description:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem findItemById(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }
}
