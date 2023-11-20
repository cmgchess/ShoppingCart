package com.example.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Product>();
    }

    public void addItem(Product product){
        cartItems.add(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void removeItem(Product product){
        cartItems.remove(product);
    }

    public void sortCart() {
        cartItems.sort(Comparator.comparing(cartItem -> cartItem.getName()));
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
