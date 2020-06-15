package com.silhouette.content.service;

import com.silhouette.egobuy.pojo.TbContent;
import com.silhouette.egobuy.query.ContentQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:46
 * @description: 内容服务接口
 */
public interface ContentService {


    /**
     * @Title: getContentList
     * @Description: 根据内容类别分页查询内容数据
     * @param query
     * @return
     */
    public EasyUIDataGridResult getContentList(ContentQuery query);

    /**
     *
     * @Title: saveContent
     * @Description: 保存一个内容
     * @param content
     * @return
     */
    public BuyResult saveContent(TbContent content);

    /**
     * 通过内内容的类别查询内容列表
     * @Title: getContentList
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param categoryId
     * @return
     */
    public List<TbContent> getContentList(long categoryId);


    BuyResult deleteContentList(String ids);

    BuyResult editContent(TbContent content);
}
