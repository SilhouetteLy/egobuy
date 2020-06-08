package com.silhouette.egobuy.base;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 22:23
 * @company: http://www.u7power.cn
 * @description:
 */
public class BaseQuery {

    private Integer pageNumber = 1;
    private Integer pageSize = 10;

    private Integer pageSizeQuery = 0;

    private String param;


    // 是否有前一页
    private boolean hasPreviousPage = true;
    // 是否有下一页
    private boolean hasNextPage = true;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSizeQuery() {
        return pageSizeQuery;
    }

    public void setPageSizeQuery(Integer pageSizeQuery) {
        this.pageSizeQuery = pageSizeQuery;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
