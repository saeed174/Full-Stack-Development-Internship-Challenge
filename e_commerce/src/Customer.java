import java.util.Map;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    double balance;
    private Cart cart;

    public Customer(String name, String email, String phoneNumber , double balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void checkout() {
        double total = 0.0;
        double shippingFees = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
            if(product instanceof ShippableProduct) {
                shippingFees += ((ShippableProduct) product).getShippingFees();
            }
        }
        

        if ((total + shippingFees) > balance) {
            System.out.println("Insufficient balance for checkout. Total: " + total + ", Balance: " + balance);
            return;
        }

        balance -= total;
        
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if(product instanceof ShippableProduct) {
                System.out.printf("%dx %-20s %.2f g\n", quantity, product.getName(), ((ShippableProduct) product).getWeight());
                totalWeight += ((ShippableProduct) product).getWeight();
            }
        }
        System.out.println("Total package weight " + totalWeight/1000 + " kg");

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) 
        {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%dx %-20s %.2f\n", quantity, product.getName(), product.getPrice());
        }
        System.out.println("------------------------------------------");
        System.out.println("Subtotal: " + total);
        System.out.println("Shipping Fees: " + shippingFees);
        total += shippingFees;
        System.out.println("Amount: " + total);

        cart = new Cart();
    }
}
