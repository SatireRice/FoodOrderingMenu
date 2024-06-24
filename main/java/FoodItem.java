package main.java;

public class FoodItem extends MenuItem {
    private String category;

    public FoodItem(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    @Override
    public void display() {
        System.out.println("Food: " + getName() + " | Price: " + getPrice() + " | Category: " + category);
    }
}
