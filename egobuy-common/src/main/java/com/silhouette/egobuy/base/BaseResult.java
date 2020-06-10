package com.silhouette.egobuy.base;

import com.silhouette.egobuy.base.BaseConst;

import java.io.Serializable;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 22:18
 * @description:
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -2018917431349764266L;

    private String resCode = BaseConst.ACTION_SUCCESS_CODE;
    private String resMsg;

    public BaseResult() {
    }

    public BaseResult(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

}
