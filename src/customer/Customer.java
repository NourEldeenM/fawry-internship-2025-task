package customer;

import product.IProduct;
import service.Cart;
import service.CheckoutService;

public class Customer {
    private Cart cart;
    private CheckoutService checkoutService;
    private double balance;

    public Customer() {
        this.cart = new Cart();
        this.checkoutService = new CheckoutService();
        this.balance = 0;
    }

    public boolean addProduct(IProduct p, int quantity) {
        boolean success = cart.addProduct(p, quantity);
        if (success) {
            System.out.println("Info: Added x" + Integer.toString(quantity) + " " + p.getName() + " to cart");
            return true;
        } else {
            System.out.println("Err: Product quantity not available or product out of stock");
            return false;
        }
    }

    public boolean checkout() {
        double totalPrice = cart.getTotalPrice();
        if (balance < totalPrice) {
            System.out.println("Err: Insufficient balance. Wanted: " + Double.toString(totalPrice)
                    + " | Balance: " + Double.toString(balance));
            return false;
        }
        withdraw(totalPrice);
        return checkoutService.checkout(cart);
    }

    public double deposit(double money) {
        System.out.println("Info: Added " + Double.toString(money) + " to your wallet");
        balance += money;
        return balance;
    }

    public double withdraw(double money) {
        if (money > balance) {
            System.out.printf("Err: Insufficient balance for this withdraw. Wanted: %.2f | Balance: %.2f%n",
                    cart.getTotalPrice(), balance);
            balance = 0;
        } else {
            System.out.printf("Info: Withdrawn %.2f from your wallet%n", money);
            balance -= money;
        }
        displayBalance();
        return balance;
    }

    public void displayBalance() {
        System.out.println("Current balance: " + Double.toString(balance));
    }

    public void viewCart() {
        cart.displayCartItems();
    }
}
