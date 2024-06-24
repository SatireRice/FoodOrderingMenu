package main.java;

public interface OrderManagement {
    void addItem(String itemName);
    void deleteItem(String itemName);
    void updateItem(String oldItemName, String newItemName);
    void displayOrder();
    double calculateTotal();
}
