import customer.Customer;
import product.DigitalProduct;
import product.PhysicalProduct;
import product.FoodProduct;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // Create products
        DigitalProduct scratchCard = new DigitalProduct("Scratch Card", 1.5, 3);
        FoodProduct cheese = new FoodProduct("Cheese", 2.99, 5, 3, LocalDate.now().plusDays(3));
        PhysicalProduct tv = new PhysicalProduct("TV", 15, 2, 4);

        // Create customer
        Customer customer = new Customer();
        customer.deposit(25);

        // Add products to cart
        customer.addProduct(cheese, 2);
        customer.addProduct(scratchCard, 1);
        customer.addProduct(tv, 1);
        customer.viewCart();

        customer.checkout();
    }
}