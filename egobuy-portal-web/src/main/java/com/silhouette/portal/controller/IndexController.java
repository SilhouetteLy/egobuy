package com.silhouette.portal.controller;

import com.silhouette.content.service.ContentService;
import com.silhouette.egobuy.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 15:47
 * @description:
 */
@Controller
public class IndexController {

    @Value("${LUNBOTU_CONTENT_CATEGORY}")
    private long LUNBOTU_CONTENT_CATEGORY;

    @Autowired
    private ContentService contentSrevice;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(Model model){
        //准备数据    ad1List -- 轮播图
        long categoryId = LUNBOTU_CONTENT_CATEGORY;
        List<TbContent> list = contentSrevice.getContentList(categoryId);
        model.addAttribute("ad1List", list);

        //其他数据
        return "index";
    }
}
