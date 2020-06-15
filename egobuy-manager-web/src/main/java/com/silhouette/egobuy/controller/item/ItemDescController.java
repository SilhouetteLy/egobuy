package com.silhouette.egobuy.controller.item;

import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.service.item.ItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:30
 * @description:
 */
@Controller
@RequestMapping("/itemDesc")
public class ItemDescController {

    @Autowired
    private ItemDescService itemDescService;


    @RequestMapping("/queryItemDesc/{itemId}")
    @ResponseBody
    public BuyResult queryItemDesc(@PathVariable long itemId){
        return itemDescService.showItemDescByItemId(itemId);
    }
}
