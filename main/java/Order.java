package main.java;

import java.util.*;

public class Order implements OrderManagement {
    private List<MenuItem> items;
    private FileManager fileManager;

    public Order() {
        items = new ArrayList<>();
        fileManager = new FileManager();
    }

    @Override
    public void addItem(String itemName) {
        MenuItem item = fileManager.findMenuItemByName(itemName);
        if (item != null) {
            items.add(item);
            System.out.println(itemName + " added to order.");
        } else {
            System.out.println("Item not found: " + itemName);
        }
    }

    @Override
    public void deleteItem(String itemName) {
        MenuItem item = fileManager.findMenuItemByName(itemName);
        if (item != null && items.remove(item)) {
            System.out.println(itemName + " removed from order.");
        } else {
            System.out.println("Item not found in order: " + itemName);
        }
    }

    @Override
    public void updateItem(String oldItemName, String newItemName) {
        MenuItem oldItem = fileManager.findMenuItemByName(oldItemName);
        MenuItem newItem = fileManager.findMenuItemByName(newItemName);
        if (oldItem != null && newItem != null) {
            int index = items.indexOf(oldItem);
            items.set(index, newItem);
            System.out.println(oldItemName + " updated to " + newItemName + ".");
        } else {
            System.out.println("Update failed: one or both items not found.");
        }
    }

    @Override
    public void displayOrder() {
        System.out.println("Current Order:");
        for (MenuItem item : items) {
            item.display();
        }
    }

    @Override
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
