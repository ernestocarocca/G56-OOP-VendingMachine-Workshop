package se.lexicon;

import se.lexicon.model.*;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product[] products = new Product[] {
                new Snack(1, 15, "Chips", "Sour Cream"),
                new Snack(2, 10, "Candy Bar", "Chocolate"),
                new Snack(3, 20, "Nuts", "Salted")
        };

        // Create the vending machine with these products
        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);

        // Example usage
        vendingMachine.addCurrency(20); // Add 20 SEK
        System.out.println("Balance: " + vendingMachine.getBalance());

        // Try to buy product with id 2
        int price = vendingMachine.request(2);
        if (price > 0) {
            System.out.println("Purchase successful! Paid: " + price);
        }

        // Get product description
        System.out.println(vendingMachine.getDescription(2));

        // End session and get change
        int change = vendingMachine.getBalance();
        System.out.println("Change returned: " + change);
    }
}
