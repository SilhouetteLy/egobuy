package com.silhouette.egobuy.controller.content;

import com.silhouette.content.service.ContentService;
import com.silhouette.egobuy.pojo.TbContent;
import com.silhouette.egobuy.query.ContentQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:27
 * @description:
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/{pageName}")
    public String showPage(@PathVariable String pageName){
        return "content/" + pageName;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult contentList(@RequestParam(defaultValue="0") Long categoryId, Integer page, Integer rows){
        ContentQuery query = new ContentQuery();
        query.setCategoryId(categoryId);
        query.setPageNumber(page);
        query.setPageSize(rows);
        EasyUIDataGridResult contentList = contentService.getContentList(query);
        return contentList;
    }

    @RequestMapping("/save")
    @ResponseBody
    public BuyResult saveContent(TbContent content){
        BuyResult result = contentService.saveContent(content);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BuyResult delete(String ids){
        return contentService.deleteContentList(ids);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public BuyResult editContent(TbContent content){
        return contentService.editContent(content);
    }
}
