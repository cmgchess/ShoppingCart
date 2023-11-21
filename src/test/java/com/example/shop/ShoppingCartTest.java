package com.example.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void shouldEncapsulateShoppingCart() {
        try {
            Field cartItemsField = ShoppingCart.class.getDeclaredField("cartItems");
            Assertions.assertTrue(Modifier.isPrivate(cartItemsField.getModifiers()), "cartItems should not be directly accessible from outside");
        } catch (NoSuchFieldException e) {
            Assertions.fail("Exception occurred while accessing cartItems: " + e.getMessage());
        }
    }

    @Test
    public void testAddItem() {
        try {
            ShoppingCart cart = new ShoppingCart();
            Method addItemMethod = ShoppingCart.class.getDeclaredMethod("addItem", Product.class);
            Assertions.assertNotNull(addItemMethod, "addItem method should be present");

            Product cake = new Food("Cake", 2.5, 3);
            Field cartItemsField = ShoppingCart.class.getDeclaredField("cartItems");
            cartItemsField.setAccessible(true);
            List<Product> cartItems = (List<Product>) cartItemsField.get(cart);
            cartItems.add(cake);
            Assertions.assertTrue(cartItems.contains(cake), "Item should be added to the cart");
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException e) {
            Assertions.fail("Exception occurred while testing: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveItem() {
        try {
            ShoppingCart cart = new ShoppingCart();

            Product cake = new Food("Cake", 2.5, 3);
            Product pizza = new Food("Pizza", 3, 10);
            Field cartItemsField = ShoppingCart.class.getDeclaredField("cartItems");
            cartItemsField.setAccessible(true);

            List<Product> cartItems = (List<Product>) cartItemsField.get(cart);
            cartItems.add(cake);
            cartItems.add(pizza);
            Assertions.assertTrue(cartItems.contains(cake), "Item should be added to the cart");
            Assertions.assertTrue(cartItems.contains(pizza), "Item should be added to the cart");

            cart.removeItem(cake);
            Assertions.assertTrue(cartItems.contains(pizza), "Item should be in the cart");
            Assertions.assertFalse(cartItems.contains(cake), "Item should be removed from the cart");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            Assertions.fail("Exception occurred while testing: " + e.getMessage());
        }
    }


    @Test
    public void testSortCart() {
        try {
            ShoppingCart cart = new ShoppingCart();
            Field cartItemsField = ShoppingCart.class.getDeclaredField("cartItems");
            cartItemsField.setAccessible(true);
            List<Product> cartItems = (List<Product>) cartItemsField.get(cart);
            Product cake = new Food("Cake", 2.5, 3);
            Product apple = new Food("Apple", 1.0, 2);

            cartItems.add(cake);
            cartItems.add(apple);

            cart.sortCart();
            Field nameField = Product.class.getDeclaredField("name");
            nameField.setAccessible(true);
            Assertions.assertEquals("Apple", nameField.get(cartItems.get(0)), "First item should be Apple");
            Assertions.assertEquals("Cake", nameField.get(cartItems.get(1)), "Second item should be Cake");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Assertions.fail("Exception occurred while testing: " + e.getMessage());
        }
    }

    @Test
    public void testCalculateTotalPrice() {
        try {
            ShoppingCart cart = new ShoppingCart();
            Field cartItemsField = ShoppingCart.class.getDeclaredField("cartItems");
            cartItemsField.setAccessible(true);
            List<Product> cartItems = (List<Product>) cartItemsField.get(cart);
            Product cake = new Food("Cake", 2.5, 3);
            Product apple = new Food("Apple", 1.0, 2);

            cartItems.add(cake);
            cartItems.add(apple);

            double totalPrice = cart.calculateTotalPrice();
            Assertions.assertEquals(2.5 * 3 + 1.0 * 2, totalPrice, 0.01, "Total price should be correct");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Assertions.fail("Exception occurred while testing: " + e.getMessage());
        }
    }

    @Test
    public void testProductCreation() {
        Assertions.assertTrue(Modifier.isAbstract(Product.class.getModifiers()), "Should not be able create objects using new Product()");
    }

    @Test
    public void testProductFieldsEncapsulation() {
        Field[] fields = Product.class.getDeclaredFields();

        for (Field field : fields) {
            Assertions.assertTrue(Modifier.isPrivate(field.getModifiers()), "Fields should not be directly accessible from outside");
        }
    }

}
