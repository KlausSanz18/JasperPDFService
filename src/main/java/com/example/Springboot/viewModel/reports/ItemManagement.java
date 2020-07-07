package com.example.Springboot.viewModel.reports;

import java.util.Date;



public class ItemManagement {

    private Date startDate;
    private Integer orderNo;
    private String location;
    private Double quantity;

    // private IntersectionActivity ia;

    public ItemManagement(){}

    public ItemManagement(Date startDate, Integer orderNo, String location, Double quantity){
        this.startDate = startDate;
        this.orderNo = orderNo;
        this.location = location;
        this.quantity = quantity;
    }


    // public ItemManagement(IntersectionActivity ia, GeneralReport gr){
    //     this.startDate = gr.getStartDate();
    //     this.noItem = ia.getIntersectionId();
    //     this.ubication = gr.getLocation();
    //     this.quantity = gr.getQuantity();
    // }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNoItem() {
        return noItem;
    }

    public void setNoItem(Integer noItem) {
        this.noItem = noItem;
    }

    

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}