package se.lexicon.model;

public class Snack extends Product {
    private String flavor; // Unique field

    public Snack(int id, double price, String productName, String flavor) {
        super(id, price, productName); // Call the superclass constructor
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "Snack: " + getProductName() + " (Flavor: " + flavor + ", Price: " + getPrice() + ")";
    }

    @Override
    public String use() {
        return "Eat the " + flavor + " snack!";
    }
}
