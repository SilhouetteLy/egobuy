package com.silhouette.egobuy.exception;

import com.silhouette.egobuy.utils.ValidateUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 14:58
 * @description:
 */
public class BaseAppException extends Exception{
    private static final long serialVersionUID = 5258918019864390794L;

    private String exceptionCode;
    private String exceptionMsg;
    private String exceptionMethod;
    private String exceptionMethodName;

    public BaseAppException() {
    }

    public BaseAppException(Throwable cause) {
        super(cause);
    }

    public BaseAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseAppException(String exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

    public BaseAppException(String exceptionMethod, String exceptionMethodName,
                            String exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
        this.exceptionMethod = exceptionMethod;
        this.exceptionMethodName = exceptionMethodName;
    }

    public BaseAppException(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMsg() {
        if (ValidateUtils.isBlank(exceptionMsg)) {
            return "";
        }
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMethod() {
        if (ValidateUtils.isBlank(exceptionMethod)) {
            return "";
        }
        return exceptionMethod;
    }

    public void setExceptionMethod(String exceptionMethod) {
        this.exceptionMethod = exceptionMethod;
    }

    public String getExceptionMethodName() {
        if (ValidateUtils.isBlank(exceptionMethodName)) {
            return "";
        }
        return exceptionMethodName;
    }

    public void setExceptionMethodName(String exceptionMethodName) {
        this.exceptionMethodName = exceptionMethodName;
    }

    public String getStackTraceString() {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.printStackTrace(pw);
        return sw.toString();
    }

    @Override
    public String getMessage(){
        if(!ValidateUtils.isNullOrEmpty(this.exceptionMsg)) {
            return this.exceptionMsg;
        }
        return super.getMessage();
    }
}

