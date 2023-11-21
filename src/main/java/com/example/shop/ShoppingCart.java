package com.example.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Product>();
    }

    public void addItem(Product product) {
        cartItems.add(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public void removeItem(Product product){
        //TODO
    }

    public void sortCart() {
        //TODO
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product: cartItems) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void printCart(){
        System.out.println("Printing Cart Items");
        for (Product product: cartItems) {
            System.out.println(product.getName() + " => Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        }
    }

}
