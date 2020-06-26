package com.silhouette;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author liuyi
 * @version 1.0
 * @create -- 17:58
 * @description: 使用 SolrJ 可以实现索引库的增删改查操作。
 */
public class SolrjTest {

    @Test
    public void testQueryDocumentBuHeightLighting() throws Exception {
        // 1、创建一个SolrServer对象
        SolrServer server = new HttpSolrServer("http://192.168.0.101:8080/solr/");
        // 2、创建一个SolrQuery对象
        SolrQuery query = new SolrQuery();
        // 3、向 SolrQuery 中添加查询条件、过滤条件。。。
        query.setQuery("item_title:不行");
        //设置默认搜索域
        query.set("df", "item_title");
        //设置高亮显示的域
        query.addHighlightField("item_title");
        //开启高亮显示
        query.setHighlight(true);
        query.setHighlightSimplePre("<em style='color:red'>");
        query.setHighlightSimplePost("</em>");
        //4、查询数据
        QueryResponse response = server.query(query);
        //5、取出查询结果
        SolrDocumentList docList = response.getResults();
        //6、循环显示查询结果
        for (SolrDocument solrDocument : docList) {
            System.out.println("-------------------------------");
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("item_title"));
            System.out.println("高亮显示内容:");
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            Map<String, List<String>> hlist = highlighting.get(solrDocument.get("id"));
            List<String> list = hlist.get("item_title");
            if(list!=null && list.size()>0){
                String hitemTitle = list.get(0);
                System.out.println(hitemTitle);
            }
        }
    }

    @Test
    public void testQuerySimple() throws Exception {
        // 第一步：创建一个 SolrServer 对象
        SolrServer server = new HttpSolrServer("http://192.168.8.118:8080/solr/");
        // 第二步：创建一个 SolrQuery 对象。
        SolrQuery query = new SolrQuery();
        // 第三步：向 SolrQuery 中添加查询条件、过滤条件。。。
        query.setQuery("item_title:不行");
        // 第四步：执行查询。得到一个 Response 对象。
        QueryResponse response = server.query(query);
        // 第五步：取查询结果。
        SolrDocumentList docList = response.getResults();
        // 第六步：遍历结果并打印。
        for (SolrDocument solrDocument : docList) {
            System.out.println(solrDocument.get("id") + ":" + solrDocument.get("item_title"));
        }
    }

    @Test
    public void testDeleteDocumentByQuery() throws Exception {
        // 第一步：创建一个 SolrServer 对象。
        SolrServer server = new HttpSolrServer("http://192.168.0.101:8080/solr/");
        // 第二步：调用 SolrServer 对象的根据 id 删除的方法。
        server.deleteByQuery("title:solrJ测试");
        // 第三步：提交。
        server.commit();
    }

    @Test
    public void testDeleteDocumentById() throws Exception {
        // 第一步：创建一个 SolrServer 对象。
        SolrServer server = new HttpSolrServer("http://192.168.0.101:8080/solr/");
        // 第二步：调用 SolrServer 对象的根据 id 删除的方法。
        server.deleteById("9527");
        // 第三步：提交。
        server.commit();
    }

    @Test
    public void testAddDocument() throws SolrServerException, IOException {
        // 第一步：把 solrJ 的 jar 包添加到工程中。
        // 第二步：创建一个 SolrServer，使用 HttpSolrServer 创建对象。
        SolrServer server = new HttpSolrServer("http://192.168.0.101:8080/solr/");
        // 第三步：创建一个文档对象 SolrInputDocument 对象。
        SolrInputDocument document = new SolrInputDocument();
        // 第四步：向文档中添加域。必须有 id 域，域的名称必须在 schema.xml 中定义。
        document.addField("id", "9527");
        document.addField("title", "solrJ测试");
        document.addField("price", 980000);
        // 第五步：把文档添加到索引库中。
        server.add(document);
        // 第六步：提交。
        server.commit();
    }

}
