package com.lab.model;

public class ProductItem {
    private String productName;
    private String productVersion;
    private double productPrice;

    public ProductItem() {
    }

    public ProductItem(String productName, String productVersion, double productPrice) {
        this.productName = productName;
        this.productVersion = productVersion;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
