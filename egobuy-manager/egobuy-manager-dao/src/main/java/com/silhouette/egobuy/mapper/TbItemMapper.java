package com.silhouette.egobuy.mapper;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.pojo.TbItemExample;
import com.silhouette.egobuy.query.ItemQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemMapper {
    int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    List<TbItem> findByPages(ItemQuery itemQuery);
}