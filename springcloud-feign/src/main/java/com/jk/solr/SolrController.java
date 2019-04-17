/**
 * Copyright (C), 2019, 金科
 * FileName: SolrController
 * Author:   Administrator
 * Date:     2019/4/17 11:01
 * History:
 */
package com.jk.solr;

import com.jk.model.solr.SolrBean;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈念如心〉<br> 
 * 〈a〉
 *
 * @author liangh
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("solr")
public class SolrController {

        @Autowired
        private SolrClient client;

        @RequestMapping(value="search")
        @ResponseBody
        public Map<String,Object> userlist(SolrBean bean, Integer page, Integer rows) throws IOException, SolrServerException {
                //因为使用easyui返回数据
                Map<String,Object> mSolr=new HashMap<String,Object>();
                //把所有查询的高亮显示内容发到list中
                List<SolrBean> userslist=new ArrayList<SolrBean>();
                //查询条件的对象
                SolrQuery params = new SolrQuery();
                //判断前台传递的关键字是否为空
                if(!"".equals(bean.getProduct_title()) && bean.getProduct_title()!=null ){
                        //不为空设置条件为关键字
                        params.set("q", bean.getProduct_title());
                }else{//如果为空查询所有
                        params.set("q", "*:*");
                }
                //默认查询字段  一般默认指定
                params.set("df", "product_title");
                //指定查询结果返回哪些字段
                params.set("fl", "id,product_title,product_sell_point,product_price,product_num,product_keywords");
                // 设置高亮字段
                params.addHighlightField("product_title"); // 高亮字段
                //分页
                if(page==null){
                        params.setStart(0);
                }else {
                        params.setStart((page-1)*rows);
                }
                if(rows==null){
                        params.setRows(5);
                }else {
                        params.setRows(rows);
                }


                //高亮
                //打开开关
                params.setHighlight(true);
                //设置前缀
                params.setHighlightSimplePre("<span style='color:red'>");
                //设置后缀
                params.setHighlightSimplePost("</span>");
                //QueryResponse是查询返回的对象数据   client.query("core1",params)  查询的是哪个索引库和条件
                QueryResponse queryResponse = client.query("core1",params);
                ///查询返回的结果list对象   不包括高亮
                SolrDocumentList results = queryResponse.getResults();
                //查询出来总条数
                long numFound = results.getNumFound();
                //查询返回的高亮结果
                Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
                //循环查询的所有结果
                for (SolrDocument result : results) {
                        //创建对象接收循环的对象数据
                        SolrBean solrBean=new SolrBean();
                        //设置高亮的字段
                        String highname="";
                        //根据id获得高亮的内容
                        Map<String, List<String>> map = highlight.get(result.get("id"));
                        //根据高亮字段拿到数据
                        List<String> list = map.get("product_title");
                        //判断数据是否为空
                        if(list==null){
                                //如果为空把普通字段放到对象中
                                highname=(String)result.get("product_title");
                        }else{
                                //获得高亮字段查询的值放到变量
                                highname=list.get(0);
                        }
                        solrBean.setId((String) result.get("id"));
                        solrBean.setProduct_sell_point((String)result.get("product_sell_point"));
                        solrBean.setProduct_title(highname);
                        userslist.add(solrBean);
                }
                mSolr.put("total",numFound);
                mSolr.put("rows",userslist);
                return mSolr;
        }



}
