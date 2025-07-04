public class App {
    public static void main(String[] args) throws Exception {
        Product cheese = new ExpirableShippableProduct("Cheese", 5.99, 10, "2024-12-31", 0.5, 2.99);
        Product book = new ShippableProduct("Java Programming", 29.99, 5, 500, 3.99);
        Product laptop = new ShippableProduct("Laptop", 999.99, 2, 2500, 15.99);
        Product mobileScratchCards = new Product("mobileScratchCards", 20, 75.0);

        Customer customer = null;
        try
        {
            customer = new Customer("John Doe", "123 Main St", "012-3456789", 1500.5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error creating customer: " + e.getMessage());
        }
        
        Cart customerCart = null;
        if (customer != null) {
            customerCart = customer.getCart();
        }

        if (customerCart != null) {
            customerCart.add(cheese , 2);
            customerCart.add(book , 1);
            customerCart.add(laptop , 1);
            customerCart.add(mobileScratchCards , 5);

            customer.checkout();
        }
        
    }
}
