package com.silhouette.search.controller;

import com.silhouette.egobuy.result.SearchResult;
import com.silhouette.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 17:19
 * @description:
 */
@Controller
public class SearchController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(String keyword, Model model, @RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="60")int rows){
        SearchResult result = searchItemService.search(keyword, page, rows);
        model.addAttribute("itemList",result.getItemList());
        model.addAttribute("recourdCount", result.getRecourdCount());
        model.addAttribute("page",page);
        model.addAttribute("rows", rows);
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("query", keyword);
        return "search";
    }
}
