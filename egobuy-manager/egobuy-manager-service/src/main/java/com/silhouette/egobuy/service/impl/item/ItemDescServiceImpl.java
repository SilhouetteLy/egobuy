package com.silhouette.egobuy.service.impl.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.silhouette.egobuy.mapper.TbItemDescMapper;
import com.silhouette.egobuy.pojo.TbItemDesc;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.service.item.ItemDescService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:34
 * @description:
 */
@Service(interfaceClass = ItemDescService.class)
public class ItemDescServiceImpl implements ItemDescService{

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public BuyResult showItemDescByItemId(Long itemId) {
        TbItemDesc tbItemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        if (tbItemDesc == null){
            return BuyResult.build(999,"系统无此商品编号，请联系管理员");
        }
        return BuyResult.ok(tbItemDesc);
    }
}
