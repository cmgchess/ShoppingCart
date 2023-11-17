import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Product>();
    }

    public void addItem(Product product){
        cartItems.add(product);
    }

    public void removeItem(Product product){
        cartItems.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product: cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    public void printCart(){
        System.out.println("Printing Cart Items");
        for (Product product: cartItems) {
            System.out.println(product.getName() + ": Rs." + product.getPrice());
        }
    }

}
