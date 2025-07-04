public class ExpirableProduct extends Product implements Expirable{
    private String expirationDate;

    public ExpirableProduct(String name, double price, int quantity, String expirationDate) {
        super(name, quantity,  price);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpirable() {
        return true;
    }

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate;
    }
    
}
