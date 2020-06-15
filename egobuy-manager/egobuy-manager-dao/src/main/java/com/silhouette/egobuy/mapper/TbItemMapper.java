package com.silhouette.egobuy.mapper;

import com.silhouette.egobuy.pojo.TbItem;
import com.silhouette.egobuy.pojo.TbItemExample;
import com.silhouette.egobuy.query.ItemQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
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

    @Update("update tb_item set status = #{status} where id = #{id}")
    int updateTbItemStatus(@Param("status") Byte status, @Param("id") Long id);

    List<TbItem> findByIds(@Param("ids") String[] ids);

    int batchUpdateItemStatus(@Param("status") Byte status, @Param("ids") String[] ids, @Param("updated")Date updated);

}