class Product
{
    private String name;
    private double price;
    private static int quantity;
    public Product() {
        this.name = "Unknown";
        this.price = 0.0;
    }

    public Product(String name , int quantity , double price) {
        this.name = name;
        this.price = price;
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setQuantity(int quantity)
    {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean isExpired()
    {
        return false;
    }
    public boolean isShiped()
    {
        return false;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}