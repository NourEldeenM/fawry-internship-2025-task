package product;

public class DigitalProduct implements IProduct {
    private String name;
    private double price;
    private int quantity;

    public DigitalProduct(String n, double p, int q) {
        this.name = n;
        this.price = p;
        this.quantity = q;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void updateQuantity(int q) {
        this.quantity = q;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
