package com.silhouette.egobuy.result;

import com.github.pagehelper.PageInfo;
import com.silhouette.egobuy.base.BaseResult;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 22:26
 * @company: http://www.u7power.cn
 * @description:
 */
public class PageInfoResult<T> extends BaseResult {

    private PageInfo<T> page;

    public PageInfoResult() {
    }

    public PageInfoResult(String resCode, String resMsg) {
        super(resCode, resMsg);
    }

    public PageInfoResult(String resCode, String resMsg, PageInfo<T> page) {
        super(resCode, resMsg);
        this.page = page;
    }

    public PageInfo<T> getPage() {
        return page;
    }

    public void setPage(PageInfo<T> page) {
        this.page = page;
    }
}
