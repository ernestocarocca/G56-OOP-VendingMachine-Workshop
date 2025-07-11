package se.lexicon.model;

public interface VendingMachine {
    void addCurrency(int amount);

    int getBalance();

    int request(int id);

    String getDescription(int id);

    String[] getProducts();
}