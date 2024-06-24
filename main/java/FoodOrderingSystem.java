package main.java;

import java.util.Scanner;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("Mao", "Lalaport");

        System.out.println("Welcome to the Food Ordering System");

        FileManager fileManager = new FileManager(); // Load menu once at the start

        while (true) {
            System.out.println("\n1. Display Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. Delete Item from Order");
            System.out.println("4. Update Item in Order");
            System.out.println("5. Display Order");
            System.out.println("6. Calculate Total");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    for (MenuItem item : fileManager.loadMenu("src/main/resources/menu.txt")) {
                        item.display();
                    }
                    break;
                case 2:
                    System.out.print("Enter item name to add: ");
                    String addItemName = scanner.nextLine();
                    customer.addOrderItem(addItemName);
                    break;
                case 3:
                    System.out.print("Enter item name to delete: ");
                    String deleteItemName = scanner.nextLine();
                    customer.deleteOrderItem(deleteItemName);
                    break;
                case 4:
                    System.out.print("Enter old item name: ");
                    String oldItemName = scanner.nextLine();
                    System.out.print("Enter new item name: ");
                    String newItemName = scanner.nextLine();
                    customer.updateOrderItem(oldItemName, newItemName);
                    break;
                case 5:
                    customer.displayOrder();
                    break;
                case 6:
                    double total = customer.calculateTotal();
                    System.out.println("Total: $" + total);
                    break;
                case 7:
                    System.out.println("Thank you for using the Food Ordering System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
