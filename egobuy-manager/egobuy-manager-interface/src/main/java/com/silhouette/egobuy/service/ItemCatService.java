package com.silhouette.egobuy.service;

import com.silhouette.egobuy.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:49
 * @description: 商品类目服务接口
 */
public interface ItemCatService {

    /**
     *
     * @Title: getItemCatByParentId
     * @Description: 通过父ID查询对应的子类目
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getItemCatByParentId(long parentId);
}
