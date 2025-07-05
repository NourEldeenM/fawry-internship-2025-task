package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product.IProduct;
import product.IShippableProduct;

public class Cart {
    private HashMap<IProduct, Integer> productList;

    public Cart() {
        productList = new HashMap<>();
    }

    public boolean addProduct(IProduct p, int quantity) {
        if (quantity <= p.getQuantity()) {
            p.updateQuantity(p.getQuantity() - quantity);
            productList.put(p, quantity);
            return true;
        }
        return false;
    }

    public void displayCartItems() {
        System.out.println("** Cart Items **");
        for (Map.Entry<IProduct, Integer> entry : productList.entrySet()) {
            System.out.println("x" + Integer.toString(entry.getValue()) + "\t" + entry.getKey().getName());
        }
    }

    public void displayCartItemsWithPrices() {
        for (Map.Entry<IProduct, Integer> entry : productList.entrySet()) {
            System.out.println("x" + Integer.toString(entry.getValue()) + entry.getKey().getName() + "\t" + entry.getKey().getPrice());
        }
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Map.Entry<IProduct, Integer> entry : productList.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public int getCartSize() {
        return productList.size();
    }

    public List<IProduct> getShippableItems() {
        List<IProduct> shippableProducts = new ArrayList<>();
        for (Map.Entry<IProduct, Integer> entry : productList.entrySet()) {
            if (entry.getKey() instanceof IShippableProduct) {
                shippableProducts.add(entry.getKey());
            }
        }
        return shippableProducts;
    }
}
