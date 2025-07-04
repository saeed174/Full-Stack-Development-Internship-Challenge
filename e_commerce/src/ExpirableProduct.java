public class ExpirableProduct extends Product implements Expirable{
    private String expirationDate;

    public ExpirableProduct(String name, double price, int quantity, String expirationDate) {
        super(name, quantity,  price);
        this.expirationDate = expirationDate;
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
    public boolean isShiped() {
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
