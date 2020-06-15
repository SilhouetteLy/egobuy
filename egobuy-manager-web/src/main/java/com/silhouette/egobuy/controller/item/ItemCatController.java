package com.silhouette.egobuy.controller.item;

import com.silhouette.egobuy.pojo.EasyUITreeNode;
import com.silhouette.egobuy.service.item.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 09:46
 * @description:
 */
@Controller
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/getItemCatList")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(defaultValue="0") long id){
        return  itemCatService.getItemCatByParentId(id);
    }
}
