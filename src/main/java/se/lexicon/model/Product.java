package se.lexicon.model;

public abstract class Product {
    int id;
    double price;
    String productName;

    public Product(int id, double price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;
    }


    public int getId() { return id; }
    public double getPrice() { return price; }
    public String getProductName() { return productName; }

    // Abstract methods
    public abstract String examine();
    public abstract String use();

}
