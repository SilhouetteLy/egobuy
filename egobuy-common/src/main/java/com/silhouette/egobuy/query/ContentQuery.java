package com.silhouette.egobuy.query;

import com.silhouette.egobuy.base.BaseQuery;

import java.io.Serializable;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 14:16
 * @description:
 */
public class ContentQuery extends BaseQuery implements Serializable {

    private static final long serialVersionUID = 5807525070092259999L;

    private Long id;

    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
