package main.java;

import java.io.*;
import java.util.*;

public class FileManager {
    private List<MenuItem> menu;

    public FileManager() {
        menu = loadMenu("src/main/resources/menu.txt");
    }

    public List<MenuItem> loadMenu(String filename) {
        List<MenuItem> menu = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                if (type.equalsIgnoreCase("Food")) {
                    String category = parts[3];
                    menu.add(new FoodItem(name, price, category));
                } else if (type.equalsIgnoreCase("Drink")) {
                    boolean isAlcoholic = Boolean.parseBoolean(parts[3]);
                    menu.add(new DrinkItem(name, price, isAlcoholic));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading menu file: " + e.getMessage());
        }
        return menu;
    }

    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
