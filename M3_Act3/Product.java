package module3_activity3;
import java.util.*;


import java.util.*;

public class Product {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> products = new LinkedHashMap<>();
        initialProducts(products);

        while (true) {
            int choice = displayMenu(scanner);

            switch (choice) {
                case 1 -> searchProduct(scanner, products);
                case 2 -> addProduct(scanner, products);
                case 3 -> printAll(products);
                case 4 -> findCheapest(products);
                case 5 -> {
                    exit(scanner);
                    return;
                }
                default -> System.out.println("Invalid. Try again.");
            }
        }
    }

    private static void initialProducts(Map<String, Integer> products) {
        products.put("Laptop", 50000);
        products.put("Monitor", 7000);
        products.put("Mouse", 500);
        products.put("Keyboard", 1000);
        products.put("Printer", 6000);
    }

    private static int displayMenu(Scanner scanner) {
        System.out.println("\nSelect an option:");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
        System.out.print("Enter number: ");
        return scanner.nextInt();
    }

    private static void searchProduct(Scanner scanner, Map<String, Integer> products) {

        scanner.nextLine(); 
            System.out.print("Enter product name: ");
            String prod = scanner.nextLine().trim();

            String matchedKey = null;
            for (String key : products.keySet()) {
                if (key.equalsIgnoreCase(prod)) {
                    matchedKey = key;
                    break;
                }
            }
            if (matchedKey != null) {
            	System.out.println("Product found. \nPrice: " + products.get(matchedKey)
                               + " (stored as: " + matchedKey + ")");
            } else {
            	System.out.println("Product not found.");
            }
    	}	

    private static void addProduct(Scanner scanner, Map<String, Integer> products) {
        scanner.nextLine();
        System.out.print("Enter product name to add: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter price: ");
        int price = scanner.nextInt();

        products.put(name, price);
        System.out.println("Product added: " + name);
    }
    
    private static void printAll(Map<String, Integer> products) {
        System.out.println("All products and prices:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("Total products: " + products.size());
    }


    private static void findCheapest(Map<String, Integer> products) {
        String cheapestProduct = null;
        int cheapestPrice = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() < cheapestPrice) {
                cheapestPrice = entry.getValue();
                cheapestProduct = entry.getKey();
            }
        }

        System.out.println("Cheapest product: " + cheapestProduct + " - " + cheapestPrice);
    }

    private static void exit(Scanner scanner) {
        System.out.println("EXIT");
        scanner.close();
    }
}
