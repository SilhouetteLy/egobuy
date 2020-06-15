package com.silhouette.egobuy.service.impl.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silhouette.egobuy.mapper.TbItemMapper;
import com.silhouette.egobuy.mapper.TbItemParamMapper;
import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.pojo.TbItemParam;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.service.item.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 16:49
 * @description:
 */
@Service(interfaceClass = ItemParamService.class)
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGridResult findByPages(ItemQuery query) {
        PageHelper.startPage(query.getPageNumber(),query.getPageSize());
        List<TbItemParam> list = tbItemParamMapper.findByPages(query);
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        return new EasyUIDataGridResult(pageInfo.getTotal(),list);
    }

    @Override
    public BuyResult queryItemParamDetailByItemId(Long itemId) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        if (tbItem == null) {
            return BuyResult.build(999,"系统无此商品编号，请联系管理员");
        }
        TbItemParam tbItemParam = tbItemParamMapper.queryItemParamByItemCatId(tbItem.getCid());
        return BuyResult.ok(tbItemParam);
    }
}
