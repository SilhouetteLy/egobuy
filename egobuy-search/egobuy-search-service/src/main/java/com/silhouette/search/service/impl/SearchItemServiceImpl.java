package com.silhouette.search.service.impl;

import com.silhouette.egobuy.pojo.SearchItem;
import com.silhouette.egobuy.result.BuyResult;
import com.silhouette.egobuy.result.SearchResult;
import com.silhouette.search.dao.SearchItemDao;
import com.silhouette.search.mapper.SearchItemMapper;
import com.silhouette.search.service.SearchItemService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 10:00
 * @description:
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private SearchItemMapper searchItemMapper ;
    @Autowired
    private SearchItemDao searchItemDao;
    @Autowired
    private SolrServer solrServer;


    @Override
    public BuyResult importItemIndex() {
        try {
            // 从数据库查询数据列表
            List<SearchItem> searchItemList = searchItemMapper.getSearchItemList();
            // 将数据导入索引库
            for (SearchItem searchItem : searchItemList) {
                // 创建文档对象
                SolrInputDocument doc = new SolrInputDocument();
                // 设置域
                doc.addField("id", searchItem.getId());
                doc.addField("item_title", searchItem.getTitle());
                doc.addField("item_price", searchItem.getPrice());
                doc.addField("item_image", searchItem.getImage());
                doc.addField("item_sell_point", searchItem.getSell_point());
                doc.addField("item_category_name", searchItem.getCategory_name());
                // 将文档加入索引库
                solrServer.add(doc);
            }
            // 提交
            solrServer.commit();

            return BuyResult.ok();
        } catch (Exception e){
            e.printStackTrace();
            return BuyResult.build(500, " 导入索引库失败" );
        }
    }

    @Override
    public SearchResult search(String keyword, int page, int rows) {
        SearchResult result = null;
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(keyword);
        //设置默认搜索域
        query.set("df", "item_title");
        //设置分页相关
        query.setStart((page-1)*rows);
        query.setRows(rows);
        //设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style='color:red;'>");
        query.setHighlightSimplePost("</em>");

        // 查索引库
        try {
            result = searchItemDao.search(query);
            //计算最大页码
            int recourdCount = result.getRecourdCount();
            int totalPage = (int)Math.ceil(recourdCount*1.0/rows);
            result.setTotalPages(totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
