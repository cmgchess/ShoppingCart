package com.example.shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Product>();
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void addItem (Product product){
        this.cartItems.add(product);
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public void removeItem(Product product){
        //TODO
        this.cartItems.remove(product);
    }

    public void sortCart() {
        //TODO
        this.cartItems.sort(Comparator.comparing(cartItem -> cartItem.getName()));
    }

    //BUG - wrong total
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
