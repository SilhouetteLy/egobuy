package com.silhouette.egobuy.service.item;

import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:49
 * @description:
 */
public interface ItemParamService {

    EasyUIDataGridResult findByPages(ItemQuery query);

    BuyResult queryItemParamDetailByItemId(Long itemId);
}
