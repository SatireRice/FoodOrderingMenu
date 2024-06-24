package main.java;

public class DrinkItem extends MenuItem {
    private boolean isAlcoholic;

    public DrinkItem(String name, double price, boolean isAlcoholic) {
        super(name, price);
        this.isAlcoholic = isAlcoholic;
    }

    @Override
    public void display() {
        System.out.println("Drink: " + getName() + " | Price: " + getPrice() + " | Alcoholic: " + isAlcoholic);
    }
}
