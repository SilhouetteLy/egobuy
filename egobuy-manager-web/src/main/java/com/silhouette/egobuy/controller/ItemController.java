package com.silhouette.egobuy.controller;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:09
 * @description:
 */
@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    @RequestMapping("/{pageName}")  //  /item-add
    public String showPage(@PathVariable String pageName){
        return "item/" + pageName;
    }

    @RequestMapping("/tbItem/{itemId}")
    @ResponseBody
    public TbItem getById(@PathVariable long itemId){
        //调用service查询
        TbItem item = itemService.findItemById(itemId);
        return item;
    }


    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page,int rows){
        ItemQuery query = new ItemQuery();
        query.setPageNumber(page);
        query.setPageSize(rows);
        return itemService.findByPages(query);
    }

    @RequestMapping("/showItemParamList")
    @ResponseBody
    public EasyUIDataGridResult showItemParamList(int page,int rows){
        ItemQuery query = new ItemQuery();
        query.setPageNumber(page);
        query.setPageSize(rows);
        return itemService.findByPages(query);
    }
}
