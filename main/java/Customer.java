package main.java;

public class Customer {
    private String name;
    private String address;
    private Order order;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.order = new Order();
    }

    public void addOrderItem(String itemName) {
        order.addItem(itemName);
    }

    public void deleteOrderItem(String itemName) {
        order.deleteItem(itemName);
    }

    public void updateOrderItem(String oldItemName, String newItemName) {
        order.updateItem(oldItemName, newItemName);
    }

    public void displayOrder() {
        order.displayOrder();
    }

    public double calculateTotal() {
        return order.calculateTotal();
    }
}
