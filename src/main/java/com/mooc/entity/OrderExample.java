package com.mooc.entity;

import java.util.Date;

public class OrderExample {
    private Long orderId;

    private Long driverId;

    private Long ownerId;

    private String fromP;

    private String toP;

    private Byte orderType;

    private Byte level;

    private Long superId;

    private Byte state;

    private String goodsType;

    private Float goodsV;

    private Float goodsW;

    private Boolean isUrgent;

    private Date fromT;

    private Date toT;

    private String remarks;

    private Float score;

    private String evaluate;

    private Float price;

    private Boolean flag;

    public OrderExample(Long orderId, Long driverId, Long ownerId, String fromP, String toP, Byte orderType, Byte level, Long superId, Byte state, String goodsType, Float goodsV, Float goodsW, Boolean isUrgent, Date fromT, Date toT,  String remarks, Float score, String evaluate, Float price, Boolean flag) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.ownerId = ownerId;
        this.fromP = fromP;
        this.toP = toP;
        this.orderType = orderType;
        this.level = level;
        this.superId = superId;
        this.state = state;
        this.goodsType = goodsType;
        this.goodsV = goodsV;
        this.goodsW = goodsW;
        this.isUrgent = isUrgent;
        this.fromT = fromT;
        this.toT = toT;
        this.remarks = remarks;
        this.score = score;
        this.evaluate = evaluate;
        this.price = price;
        this.flag = flag;
    }

    public OrderExample() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFromP() {
        return fromP;
    }

    public void setFromP(String fromP) {
        this.fromP = fromP == null ? null : fromP.trim();
    }

    public String getToP() {
        return toP;
    }

    public void setToP(String toP) {
        this.toP = toP == null ? null : toP.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Float getGoodsV() {
        return goodsV;
    }

    public void setGoodsV(Float goodsV) {
        this.goodsV = goodsV;
    }

    public Float getGoodsW() {
        return goodsW;
    }

    public void setGoodsW(Float goodsW) {
        this.goodsW = goodsW;
    }

    public Boolean getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public Date getFromT() {
        return fromT;
    }

    public void setFromT(Date fromT) {
        this.fromT = fromT;
    }

    public Date getToT() {
        return toT;
    }

    public void setToT(Date toT) {
        this.toT = toT;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
