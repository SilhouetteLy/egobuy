package com.silhouette.egobuy.controller.index;

import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:23
 * @description:
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/{pageName}")  //  /item-add
    public String showPage(@PathVariable String pageName){
        return "index/" + pageName;
    }

    @RequestMapping("/importIndex")
    @ResponseBody
    public BuyResult importIndex(){
        BuyResult result = searchItemService.importItemIndex();
        return  result;
    }
}
