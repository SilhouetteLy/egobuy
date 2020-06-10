package com.silhouette.egobuy.pojo;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:42
 * @description: 封装easyUItree的节点
 */
public class EasyUITreeNode implements java.io.Serializable{

    private static final long serialVersionUID = 3291190995715410015L;

    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
