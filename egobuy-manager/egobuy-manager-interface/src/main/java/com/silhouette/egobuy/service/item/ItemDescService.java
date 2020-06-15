package com.silhouette.egobuy.service.item;

import com.silhouette.egobuy.pojo.TbItemDesc;
import com.silhouette.egobuy.result.BuyResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:33
 * @description:
 */
public interface ItemDescService {

    BuyResult showItemDescByItemId(Long itemId);
}
