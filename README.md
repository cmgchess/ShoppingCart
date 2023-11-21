# Overview

This project implements a simple shopping cart in Java. It includes classes for different types of products and a shopping cart to manage items.

## Running the tests

This project uses JUnit for testing. Make sure to have JUnit in your classpath.

Install project dependencies:

```bash
mvn install
```

Run tests:

```bash
mvn test
```

## Running the app

The main class is `Main`, which provides a sample usage of the shopping cart functionality. You can run it from your IDE or by compiling and executing the Java files.

```bash
javac Main.java
java Main
```

## Tasks to complete

### Task-1: Restrict Direct Product Instantiation

- Currently, instances of the `Product` class can be created directly using the `new` keyword, for example: `Product product = new Product("product name", 1, 1)`.
 - Implement necessary changes in the `Product` class to prevent direct instantiation using `new`.

### Task-2: Encapsulate Public Attributes

- Public attributes in the `Product` and `ShoppingCart` classes are directly accessible from other classes.
- Encapsulate all public attributes by making them private and providing appropriate getter and setter methods.

### Task-3: Implement addItem Method in ShoppingCart

- Create a method named `addItem` in the `ShoppingCart` class to add products to the cart.
- Utilize this method throughout the codebase for adding products to the shopping cart.

### Task-4: Fix Total Price Calculation Bug

- The displayed total price of the shopping cart is incorrect.
- Go through the codebase and identify the bug causing the miscalculation. Implement necessary changes to fix the issue and ensure the accurate calculation of the total price.

### Task-5: Implement Sort by Product Name functionality

- Selecting the "Sort Cart Items" option currently has no effect.
- When the sort option is selected, ensure the cart items are sorted alphabetically by product name.

### Task-6: Implement Remove Product Functionality

- The current implementation of the "Remove Product" functionality is not removing items as intended.
- Your task is to enhance the functionality to ensure that selecting the "Remove Product" option effectively removes the chosen product from the shopping cart.
- Consider that product names are unique in this scenario to simplify the implementation.
- HINT: You may have to change both the Main class and the ShoppingCart class.
