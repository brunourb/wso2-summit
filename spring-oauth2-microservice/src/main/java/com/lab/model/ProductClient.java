package com.lab.model;

public class ProductClient {
    private String clientName;
    private String location;

    public ProductClient() {
    }

    public ProductClient(String clientName, String location) {
        this.clientName = clientName;
        this.location = location;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
