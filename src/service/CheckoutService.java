package service;

import java.util.List;

import product.IProduct;

public class CheckoutService {
    private ShippingService shippingService;

    public CheckoutService() {
        shippingService = new ShippingService();
    }

    public boolean checkout(Cart cart) {
        if (cart.getCartSize() == 0) {
            System.out.println("Err: Checkout cart empty");
            return false;
        }
        double itemsCash = cart.getTotalPrice();
        List<IProduct> shippableProducts = cart.getShippableItems();
        shippingService.ship(shippableProducts);
        System.out.println("** Checkout receipt **");
        cart.displayCartItemsWithPrices();
        System.out.println("-------------------");
        double shippingCost = shippableProducts.size() * shippingService.getShippingFee();
        System.out.println("Subtotal:\t" + Double.toString(itemsCash));
        System.out.println("Shipping:\t" + Double.toString(shippingCost));
        System.out.println("Amount:\t" + Double.toString(shippingCost + itemsCash));
        
        return true;        
    }
}
