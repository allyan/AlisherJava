package com.alisher;

public class Products {

    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}