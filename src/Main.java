public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product apple = new Food("Apple", 30.50);
        Product shirt = new Cloth("Shirt", 1000);
        Product cake = new Food("Cake", 400);
        Product denim = new Cloth("Denim", 800);

        cart.addItem(apple);
        cart.addItem(shirt);
        cart.addItem(cake);
        cart.addItem(denim);

        cart.printCart();
        System.out.println("Total price: " + cart.calculateTotalPrice());

        cart.sortCart();
        cart.printCart();

        cart.removeItem(cake);

        cart.printCart();
        System.out.println("Total price: " + cart.calculateTotalPrice());
    }
}
