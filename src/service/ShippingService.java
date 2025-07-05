package service;

import java.util.List;

import product.IProduct;
import product.IShippableProduct;

public class ShippingService {

    private double shippingFees;

    public ShippingService() {
        shippingFees = 10.0;
    }

    public double getShippingFee() {
        return shippingFees;
    }

    public boolean ship(List<IProduct> shippableProducts) {
        for (IProduct p : shippableProducts) {
            double weight = ((IShippableProduct)p).getWeight();
            System.out.println("Shipping " + p.getName() + "\t" + Double.toString(weight));
        }
        return true;
    }
}
