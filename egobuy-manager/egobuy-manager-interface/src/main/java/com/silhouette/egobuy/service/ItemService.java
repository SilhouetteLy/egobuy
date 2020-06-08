package com.silhouette.egobuy.service;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.EasyUIDataGridResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:08
 * @company: http://www.u7power.cn
 * @description:
 */
public interface ItemService {

    TbItem findItemById(Long itemId);

    EasyUIDataGridResult findByPages(ItemQuery query);
}
