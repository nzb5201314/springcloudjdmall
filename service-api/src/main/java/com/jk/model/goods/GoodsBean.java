/**
 * Copyright (C), 2019, 金科
 * FileName: GoodsBean
 * Author:   Administrator
 * Date:     2019/4/17 20:50
 * History:
 */
package com.jk.model.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈念如心〉<br> 
 * 〈goods〉
 *
 * @author liangh
 * @create 2019/4/17
 * @since 1.0.0
 */
public class GoodsBean implements Serializable {

    private static final long serialVersionUID = 7910728422958251816L;

    private Integer goodsId;
    private String goodsName;
    private Integer goodsType;
    private Date goodsTime;
    private String goodsStatus;
    private String goodsMorR;
    private String goodsTypeName;
    private String goodsImg;
    private double goodsPrice;
    private String goodsBrand;
    private String goodsArea;
    private String goodsBusiness;

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

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Date getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Date goodsTime) {
        this.goodsTime = goodsTime;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsMorR() {
        return goodsMorR;
    }

    public void setGoodsMorR(String goodsMorR) {
        this.goodsMorR = goodsMorR;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsArea() {
        return goodsArea;
    }

    public void setGoodsArea(String goodsArea) {
        this.goodsArea = goodsArea;
    }

    public String getGoodsBusiness() {
        return goodsBusiness;
    }

    public void setGoodsBusiness(String goodsBusiness) {
        this.goodsBusiness = goodsBusiness;
    }


    @Override
    public String toString() {
        return "GoodsBean{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType=" + goodsType +
                ", goodsTime=" + goodsTime +
                ", goodsStatus='" + goodsStatus + '\'' +
                ", goodsMorR='" + goodsMorR + '\'' +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsArea='" + goodsArea + '\'' +
                ", goodsBusiness='" + goodsBusiness + '\'' +
                '}';
    }
}
