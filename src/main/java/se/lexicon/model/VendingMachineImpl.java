package se.lexicon.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VendingMachineImpl implements VendingMachine { // <-- Correct name!
    private Product[] products;
    private int depositPool;

    // Allowed currency denominations
    private static final Set<Integer> ALLOWED_DENOMINATIONS = new HashSet<>(
            Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 1000)
    );

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    @Override
    public void addCurrency(int amount) {
        if (ALLOWED_DENOMINATIONS.contains(amount)) {
            depositPool += amount;
        } else {
            System.out.println("Invalid denomination: " + amount);
        }
    }

    @Override
    public int request(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                int price = (int) product.getPrice();
                if (depositPool >= price) {
                    depositPool -= price;
                    System.out.println("You bought: " + product.getProductName());
                    return price;
                } else {
                    System.out.println("Not enough money in deposit pool.");
                    return -1;
                }
            }
        }
        System.out.println("Product not found.");
        return -2;
    }


    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine();
            }
        }
        return "Product not found";
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        String[] names = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            names[i] = products[i].getProductName();
        }
        return names;
    }
}
