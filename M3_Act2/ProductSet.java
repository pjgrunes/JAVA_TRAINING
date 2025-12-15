package module3_activity2;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductSet {
    public static void main(String[] args) {
        // Create a HashSet with 5 initial products
        Set<String> products = new HashSet<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu loop
        do {
            System.out.println("Select an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("> ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: // Search
                    System.out.print("Enter product name to search: ");
                    String search = scanner.nextLine();
                    boolean found = false;
                    for (String p : products) {
                        if (p.equalsIgnoreCase(search)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Product found: " + search);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 2: // Add
                    System.out.print("Enter product name to add: ");
                    String newProduct = scanner.nextLine();
                    boolean exists = false;
                    for (String p : products) {
                        if (p.equalsIgnoreCase(newProduct)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Product already exists!");
                    } else {
                        products.add(newProduct);
                        System.out.println("Product added: " + newProduct);
                    }
                    break;

                case 3: // Print all
                    System.out.println("All products:");
                    for (String p : products) {
                        System.out.println(p);
                    }
                    System.out.println("Total unique products: " + products.size());
                    break;

                case 4: // Exit
                    System.out.println("End of system.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
            System.out.println();
               } while (choice != 4);

        scanner.close();
    }
} 

