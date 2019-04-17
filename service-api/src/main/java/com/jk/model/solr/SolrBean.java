/**
 * Copyright (C), 2019, 金科
 * FileName: SolrBean
 * Author:   Administrator
 * Date:     2019/4/17 11:15
 * History:
 */
package com.jk.model.solr;

import java.io.Serializable;

/**
 * 〈念如心〉<br> 
 * 〈a〉
 *
 * @author liangh
 * @create 2019/4/17
 * @since 1.0.0
 */
public class SolrBean implements Serializable {

    private static final long serialVersionUID = 4485640596680429377L;

    private String  id;

    private String  product_title;

    private String  product_sell_point;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_sell_point() {
        return product_sell_point;
    }

    public void setProduct_sell_point(String product_sell_point) {
        this.product_sell_point = product_sell_point;
    }

    @Override
    public String toString() {
        return "SolrBean{" +
                "id=" + id +
                ", product_title='" + product_title + '\'' +
                ", product_sell_point='" + product_sell_point + '\'' +
                '}';
    }
}
