package product;

public class PhysicalProduct implements IShippableProduct {
    private String name;
    private double price;
    private int quantity;
    private double weight;

    public PhysicalProduct(String n, double p, int q, double w) {
        this.name = n;
        this.price = p;
        this.quantity = q;
        this.weight = w;
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

    @Override
    public double getWeight() {
        return weight;
    }
}