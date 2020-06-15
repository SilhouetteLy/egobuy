package com.silhouette.egobuy.service.item;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;

import java.util.List;

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

    /**
     *
     * @Title: saveItem
     * @Description: 保存商品信息的业务
     * @param item
     * @param desc
     * @return
     */
    public BuyResult saveItem(TbItem item, String desc);


    /**
     * 删除指定商品
     * @param ids
     * @return
     */
    BuyResult delete(String ids);

    /**
     * 批量下架指定商品
     * @param ids
     * @return
     */
    BuyResult instock(String ids);

    /**
     * 批量上架指定商品
     * @param ids
     * @return
     */
    BuyResult reshelf(String ids);

    /**
     * 修改商品信息
     * @param item
     * @param desc
     * @return
     */
    BuyResult updateItem(TbItem item, String desc);
}
