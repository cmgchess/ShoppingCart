package com.example.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

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
            Method addItemMethod = ShoppingCart.class.getDeclaredMethod("addItem", Product.class);
            Assertions.assertNotNull(addItemMethod, "addItem method should be present");

            Product cake = new Food("Cake", 2.5, 3);
            cart.addItem(cake);
            List<Product> cartItems = cart.getCartItems();
            Assertions.assertTrue(cartItems.contains(cake), "Item should be added to the cart");
        } catch (NoSuchMethodException e) {
            Assertions.fail("addItem method is not implemented");
        }
    }

    @Test
    public void testRemoveItem() {
        try {
            Method addItemMethod = ShoppingCart.class.getDeclaredMethod("addItem", Product.class);
            Assertions.assertNotNull(addItemMethod, "addItem method should be present");

            Product cake = new Food("Cake", 2.5, 3);
            cart.addItem(cake);
            cart.removeItem(cake);
            List<Product> cartItems = cart.getCartItems();

            Assertions.assertFalse(cartItems.contains(cake), "Item should be removed from the cart");
        } catch (NoSuchMethodException e) {
            Assertions.fail("addItem method is not implemented");
        }
    }

    @Test
    public void testSortCart() {
        try {
            Method addItemMethod = ShoppingCart.class.getDeclaredMethod("addItem", Product.class);
            Assertions.assertNotNull(addItemMethod, "addItem method should be present");
            Method getCartItemsMethod = ShoppingCart.class.getDeclaredMethod("getCartItems");
            Assertions.assertNotNull(getCartItemsMethod, "getCartItems method should be present");
            Product cake = new Food("Cake", 2.5, 3);
            Product apple = new Food("Apple", 1.0, 2);

            cart.addItem(cake);
            cart.addItem(apple);

            cart.sortCart();

            List<Product> cartItems = cart.getCartItems();

            Assertions.assertEquals("Apple", cartItems.get(0).getName(), "First item should be Apple");
            Assertions.assertEquals("Cake", cartItems.get(1).getName(), "Second item should be Cake");
        } catch (NoSuchMethodException e) {
            Assertions.fail("addItem or getCartItems method is not implemented");
        }
    }

    @Test
    public void testCalculateTotalPrice() {
        try {
            Method addItemMethod = ShoppingCart.class.getDeclaredMethod("addItem", Product.class);
            Assertions.assertNotNull(addItemMethod, "addItem method should be present");
            Product cake = new Food("Cake", 2.5, 3);
            Product apple = new Food("Apple", 1.0, 2);

            cart.addItem(cake);
            cart.addItem(apple);

            double totalPrice = cart.calculateTotalPrice();
            Assertions.assertEquals(2.5 * 3 + 1.0 * 2, totalPrice, 0.01, "Total price should be correct");
        } catch (NoSuchMethodException e) {
            Assertions.fail("addItem or getCartItems method is not implemented");
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
