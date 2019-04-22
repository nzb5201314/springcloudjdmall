/**
 * Copyright (C), 2019, 金科
 * FileName: Paymodel
 * Author:   Administrator
 * Date:     2019/4/22 22:19
 * History:
 */
package com.jk.model.PayModel;

import java.io.Serializable;

/**
 * 〈念如心〉<br> 
 * 〈a〉
 *
 * @author liangh
 * @create 2019/4/22
 * @since 1.0.0
 */
public class Paymodel implements Serializable {

    private static final long serialVersionUID = -7048609107544217010L;
    private Integer goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Integer goodsCount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "Paymodel{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
