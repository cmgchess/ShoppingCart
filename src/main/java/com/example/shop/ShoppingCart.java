package com.example.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Product>();
    }


    public void removeItem(Product product){
        //TODO
    }

    public void sortCart() {
        //TODO
    }

    //BUG - wrong total
    public double calculateTotalPrice() {
        double total = 0;
        for (Product product: cartItems) {
            total += product.price;
        }
        return total;
    }

    public void printCart(){
        System.out.println("Printing Cart Items");
        for (Product product: cartItems) {
            System.out.println(product.name + " => Price: " + product.price + ", Quantity: " + product.quantity);
        }
    }

}
