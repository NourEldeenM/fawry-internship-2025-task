package service;

import java.util.List;

import product.IProduct;

public class ShippingService {

    private double shippingFees;

    public ShippingService() {
        shippingFees = 10.0;
    }

    public double getShippingFee() {
        return shippingFees;
    }

    public boolean ship(List<IProduct> shippableProducts) {
        String items = "[ ";
        for (IProduct p : shippableProducts) {
            items += p.getName() + " "; 
        }
        items += "]";
        System.out.println("Shipping " + items);
        return true;
    }
}
