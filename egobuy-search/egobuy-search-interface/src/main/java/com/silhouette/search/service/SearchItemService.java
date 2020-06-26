package com.silhouette.search.service;

import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.SearchResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:56
 * @description:
 */
public interface SearchItemService {

    /**
     * 将数据库的数据导入索引库
     * @return
     */
    public BuyResult importItemIndex();

    /**
     * 从索引库查询数据，返回itemList，totalPages，recourdCount
     * @param keyword
     * @param page
     * @param rows
     * @return
     */
    public SearchResult search(String keyword, int page, int rows);
}
