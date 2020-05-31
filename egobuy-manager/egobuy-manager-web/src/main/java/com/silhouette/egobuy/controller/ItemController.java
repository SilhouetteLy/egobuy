package com.silhouette.egobuy.controller;

import com.silhouette.egobuy.pojo.TbItem;
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
 * @company: http://www.u7power.cn
 * @description:
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/tbItem/{itemId}")
    @ResponseBody
    public TbItem getById(@PathVariable long itemId){
        //调用service查询
        TbItem item = itemService.findItemById(itemId);
        return item;
    }
}
