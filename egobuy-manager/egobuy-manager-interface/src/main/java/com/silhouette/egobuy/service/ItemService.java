package com.silhouette.egobuy.service;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.EasyUIDataGridResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:08
 * @description: 商品服务接口
 */
public interface ItemService {

    /**
     *
     * @Title: getById
     * @Description: 根据商品的ID查询商品信息
     * @param itemId
     * @return
     */
    TbItem findItemById(Long itemId);

    /**
     *
     * @Title: getByPageInfo
     * @Description: 根据页码和每页大小查询数据
     * @param query
     * @return
     */
    EasyUIDataGridResult findByPages(ItemQuery query);
}
