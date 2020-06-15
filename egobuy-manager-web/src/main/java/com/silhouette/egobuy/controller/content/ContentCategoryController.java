package com.silhouette.egobuy.controller.content;

import com.silhouette.content.service.ContentCategoryService;
import com.silhouette.egobuy.pojo.EasyUITreeNode;
import com.silhouette.egobuy.result.BuyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:28
 * @description:
 */
@Controller
@RequestMapping("/contentCategory")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/CategoryList")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(name="id",defaultValue="0") long parentId){
        List<EasyUITreeNode> contentCatList = contentCategoryService.getContentCatList(parentId);
        return contentCatList;
    }

    @RequestMapping("/create")
    @ResponseBody
    public BuyResult createCat(long parentId, String name){
        BuyResult result = contentCategoryService.saveContentCat(parentId, name);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public BuyResult update(long id,String name){
        return contentCategoryService.updateContentCat(id,name);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public BuyResult delete(long id){
        return contentCategoryService.deleteContentCat(id);
    }
}
