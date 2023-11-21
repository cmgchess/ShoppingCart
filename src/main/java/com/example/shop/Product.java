package com.example.shop;

public abstract class Product {
    public String name;
    public double price;
    public int quantity;

    public Product (String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}