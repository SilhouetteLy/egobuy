package com.silhouette.egobuy.result;

import com.silhouette.egobuy.pojo.SearchItem;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 18:13
 * @description:
 */
public class SearchResult implements Serializable {

    private static final long serialVersionUID = 3761480020839920321L;

    private List<SearchItem> itemList;

    private int totalPages;

    private int recourdCount;

    public List<SearchItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SearchItem> itemList) {
        this.itemList = itemList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRecourdCount() {
        return recourdCount;
    }

    public void setRecourdCount(int recourdCount) {
        this.recourdCount = recourdCount;
    }
}
