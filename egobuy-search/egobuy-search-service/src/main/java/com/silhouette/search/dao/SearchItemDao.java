package com.silhouette.search.dao;

import com.silhouette.egobuy.pojo.SearchItem;
import com.silhouette.egobuy.result.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 17:21
 * @description:
 */
@Component
public class SearchItemDao {

    @Autowired
    private SolrServer solrServer;

    public SearchResult search(SolrQuery query) throws Exception {
        SearchResult result = new SearchResult();
        // 查询数据
        QueryResponse response = solrServer.query(query);
        // 取出查询结果
        SolrDocumentList docList = response.getResults();
        //获取高亮显示的结果
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        // 总条数
        long recourdCount = docList.getNumFound();
        result.setRecourdCount((int) recourdCount);
        // 准备 List<SearchItem>
        List<SearchItem> items = new ArrayList<SearchItem>();
        //遍历查询的结果
        for (SolrDocument doc : docList) {
            SearchItem item = new SearchItem();
            item.setId(doc.get("id")+"");
            item.setTitle(doc.get("item_title")+"");
            item.setSell_point(doc.get("item_sell_point")+"");
            item.setPrice(new Long(doc.get("item_price")+""));
            item.setCategory_name(doc.get("item_category_name")+"");
            //图片处理
            String image = doc.get("item_image")+"";
            if(StringUtils.isNoneBlank(image)){
                String[] images = image.split(",");
                item.setImage(images[0]);
            }
            //判断是否有高亮查询
            if(highlighting!=null){
                Map<String, List<String>> hmap = highlighting.get(item.getId());
                if(hmap!=null || hmap.size()>0){
                    List<String> list = hmap.get("item_title");
                    if(list!=null && list.size()>0){
                        item.setTitle(list.get(0));
                    }
                }
            }
            //将item加入集合
            items.add(item);
        }

        //将集合设置给result；
        result.setItemList(items);
        return result;
    }
}
