import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Cart {
    Map<Product,Integer> products;

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Cart() {
        this.products = new HashMap<Product, Integer>();
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void add(Product product , int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Not enough quantity for product " + product.getName() + ". Available: " + product.getQuantity());
            return;
        }
        else
        {
            this.products.put(product, quantity);
            product.setQuantity(product.getQuantity() - quantity);
        }
    }
    public void remove(Product product) {
        if (!products.containsKey(product)) {
            System.out.println("Product " + product.getName() + " is not in the cart.");
            return;
        }
        else
        {
            product.setQuantity(product.getQuantity() + products.get(product));
            this.products.remove(product);
        }
    }
}
