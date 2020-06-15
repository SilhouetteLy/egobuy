package com.silhouette.egobuy.controller.item;

import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.service.item.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:45
 * @description:
 */
@Controller
@RequestMapping("/itemParam")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/showItemParamList")
    @ResponseBody
    public EasyUIDataGridResult showItemParamList(int page, int rows){
        ItemQuery query = new ItemQuery();
        query.setPageNumber(page);
        query.setPageSize(rows);
        return itemParamService.findByPages(query);
    }

    @RequestMapping("/queryItemParam/{itemId}")
    @ResponseBody
    public BuyResult queryItemParam(@PathVariable Long itemId) {
        return itemParamService.queryItemParamDetailByItemId(itemId);
    }

}
