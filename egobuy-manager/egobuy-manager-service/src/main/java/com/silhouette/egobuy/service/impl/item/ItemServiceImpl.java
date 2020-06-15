package com.silhouette.egobuy.service.impl.item;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silhouette.egobuy.mapper.TbItemDescMapper;
import com.silhouette.egobuy.mapper.TbItemMapper;
import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.pojo.TbItemDesc;
import com.silhouette.egobuy.query.ItemQuery;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.EasyUIDataGridResult;
import com.silhouette.egobuy.service.item.ItemService;
import com.silhouette.egobuy.utils.IDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 11:09
 * @description: 商品的服务实现类
 */
//@Service("itemService")
@Service(interfaceClass = ItemService.class)
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public TbItem findItemById(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUIDataGridResult findByPages(ItemQuery query) {
        PageHelper.startPage(query.getPageNumber(),query.getPageSize());
        List<TbItem> list = itemMapper.findByPages(query);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        return new EasyUIDataGridResult(pageInfo.getTotal(),list);
    }

    @Override
    public BuyResult saveItem(TbItem item, String desc) {
        long  itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte)1);
        //保存商品信息
        itemMapper.insert(item);
        //创建一个TbItemDesc对象
        TbItemDesc itemDesc = new  TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //保存商品描述对象
        itemDescMapper.insert(itemDesc);
        return BuyResult.ok();
    }

    @Override
    public BuyResult delete(String ids) {
        String[] idArrys = ids.split(",");
        List<TbItem> list = itemMapper.findByIds(idArrys);
        if (CollectionUtils.isEmpty(list)){
            return BuyResult.build(999,"系统无此商品编号");
        }
        for (TbItem tbItem : list) {
            if (2 != tbItem.getStatus().intValue()){
                return BuyResult.build(999,"非下架商品不可删除");
            }
        }
        itemMapper.batchUpdateItemStatus((byte)3, idArrys, new Date());
        return BuyResult.ok();
    }

    @Override
    public BuyResult instock(String ids) {
        String[] idArrys = ids.split(",");
        List<TbItem> list = itemMapper.findByIds(idArrys);
        if (CollectionUtils.isEmpty(list)){
            return BuyResult.build(999,"系统无此商品编号");
        }
        for (TbItem tbItem : list) {
            if (1 != tbItem.getStatus().intValue()){
                return BuyResult.build(999,"非上架商品不可下架");
            }
        }
        itemMapper.batchUpdateItemStatus((byte)2, idArrys, new Date());
        return BuyResult.ok();
    }

    @Override
    public BuyResult reshelf(String ids) {
        String[] idArrys = ids.split(",");
        List<TbItem> list = itemMapper.findByIds(idArrys);
        if (CollectionUtils.isEmpty(list)){
            return BuyResult.build(999,"系统无此商品编号");
        }
        for (TbItem tbItem : list) {
            if (2 != tbItem.getStatus().intValue()){
                return BuyResult.build(999,"非下架商品不可上架");
            }
        }
        itemMapper.batchUpdateItemStatus((byte)1, idArrys,new Date());
        return BuyResult.ok();
    }

    @Override
    public BuyResult updateItem(TbItem item, String desc) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(item.getId());
        if (tbItem == null){
            return BuyResult.build(999,"系统无此商品编号");
        }
        itemMapper.updateByPrimaryKeySelective(item);
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(item.getId());
        if (itemDesc == null){
            itemDesc = new TbItemDesc();
            itemDesc.setItemId(item.getId());
            itemDesc.setItemDesc(desc);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(new Date());
            itemDescMapper.insert(itemDesc);
        }else{
            itemDesc.setItemDesc(desc);
            itemDesc.setUpdated(new Date());
            itemDescMapper.updateByPrimaryKeySelective(itemDesc);
        }
        return BuyResult.ok();
    }
}
