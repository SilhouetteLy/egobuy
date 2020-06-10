package com.silhouette.egobuy.result;

import com.silhouette.egobuy.base.BaseResult;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 22:41
 * @description:
 */
public class GenericResult<T> extends BaseResult {

    private T t;

    private List<T> list;

    public GenericResult() {
    }

    public GenericResult(String resCode, String resMsg) {
        super(resCode, resMsg);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
