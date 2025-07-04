public class ExpirableShippableProduct extends Product implements Shippable , Expirable {
    private String expirationDate;
    private double weight;
    private double shippingCost;

    public ExpirableShippableProduct(String name, double price, int quantity, String expirationDate, double weight, double shippingCost) {
        super(name , quantity , price);
        this.expirationDate = expirationDate;
        this.weight = weight;
        this.shippingCost = shippingCost;
    }

    @Override
    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getShippingFees() {
        return shippingCost;
    }

    @Override
    public boolean isShiped() {
        return true;
    }

    @Override
    public boolean isExpired() {
        java.time.LocalDate expDate = java.time.LocalDate.parse(expirationDate);
        java.time.LocalDate today = java.time.LocalDate.now();
        if (expDate.isBefore(today)) {
            return true;
        }
        return false;
    }
    
    @Override
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
}
