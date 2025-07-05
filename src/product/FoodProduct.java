package product;

import java.time.LocalDate;

public class FoodProduct implements IShippableProduct, IExpirableProduct {
    private String name;
    private double price;
    private int quantity;
    private double weight;
    private LocalDate expiryDate;

    public FoodProduct(String n, double p, int q, double w, LocalDate d) {
        this.name = n;
        this.price = p;
        this.quantity = q;
        this.weight = w;
        this.expiryDate = d;
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
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return (expiryDate.isAfter(LocalDate.now()));
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
