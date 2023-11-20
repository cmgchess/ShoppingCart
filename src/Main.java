import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Shopping Cart CLI =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Sort Cart Items");
            System.out.println("5. Calculate Total Price");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product type: (Food, Cloth) ");
                    String productType = scanner.next();
                    Product newProduct;
                    switch (productType.toLowerCase()){
                        case "food":
                            System.out.print("Enter food name: ");
                            String foodName = scanner.next();
                            System.out.print("Enter food price: ");
                            double foodPrice = scanner.nextDouble();
                            newProduct = new Food(foodName, foodPrice);
                            break;
                        case "cloth":
                            System.out.print("Enter cloth name: ");
                            String clothName = scanner.next();
                            System.out.print("Enter cloth price: ");
                            double clothPrice = scanner.nextDouble();
                            newProduct = new Cloth(clothName, clothPrice);
                            break;
                        default:
                            System.out.println("Invalid product type.");
                            continue;
                    }
                    cart.cartItems.add(newProduct);
                    System.out.println(newProduct.name + " added to cart!");
                    break;
                case 2:
                    Product productToRemove = null;
                    System.out.print("Enter product type: (Food, Cloth) ");
                    String productTypeToDelete = scanner.next();
                    System.out.print("Enter food name to remove: ");
                    String productName = scanner.next();
                    for (Product product : cart.cartItems) {
                        String productClass = product.getClass().getName().toLowerCase();
                        if (product.name.equals(productName) && productClass.equals(productTypeToDelete.toLowerCase())) {
                            productToRemove = product;
                            break;
                        }
                    }
                    if (productToRemove != null){
                        cart.removeItem(productToRemove);
                        System.out.println(productToRemove.name + " removed from cart!");
                    } else {
                        System.out.println(productName + " not found in cart");
                    }
                    break;
                case 3:
                    cart.printCart();
                    break;
                case 4:
                    cart.sortCart();
                    break;
                case 5:
                    System.out.println("Total price: " + cart.calculateTotalPrice());
                    break;
                case 0:
                    System.out.println("Exiting the shopping cart CLI.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        }
    }
}
