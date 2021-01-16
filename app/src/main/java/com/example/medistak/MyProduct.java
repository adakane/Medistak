package com.example.medistak;

public class MyProduct {
    private String productName;
    private String productDesc;
    private Integer productImg;
    private String productPrice;

    public MyProduct(String productName, String productDesc,String productPrice, Integer productImg) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productImg = productImg;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductImg() {
        return productImg;
    }

    public void setProductImg(Integer productImg) {
        this.productImg = productImg;
    }
}
