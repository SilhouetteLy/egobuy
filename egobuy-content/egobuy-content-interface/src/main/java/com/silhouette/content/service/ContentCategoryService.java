package com.silhouette.content.service;

import com.silhouette.egobuy.pojo.EasyUITreeNode;
import com.silhouette.egobuy.result.BuyResult;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:47
 * @description: 内容类型的服务接口
 */
public interface ContentCategoryService {

    /**
     *
     * @Title: getContenCatList
     * @Description: 通过parentid查询内容类别列表
     * @param parentId
     * @return
     */
    public List<EasyUITreeNode> getContentCatList(long parentId);

    /**
     *
     * @Title: saveContentCat
     * @Description: 保存一个内容类型
     * @param parentId
     * @param name
     * @return
     */
    public BuyResult saveContentCat(long parentId, String name);

    public BuyResult updateContentCat(long id, String name);

    public BuyResult deleteContentCat(long id);
}
