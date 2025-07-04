public class ShippableProduct extends Product implements Shippable {
    private double weight;
    private double shippingFees;

    public ShippableProduct(String name, double price, int quantity, double weight, double shippingFees) {
        super(name, quantity,  price);
        this.weight = weight;
        this.shippingFees = shippingFees;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isShiped() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getShippingFees() {
        return shippingFees;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weight + "kg, Shipping Fees: $" + shippingFees;
    }
    
}
