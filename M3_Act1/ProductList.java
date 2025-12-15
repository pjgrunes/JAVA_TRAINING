package module3_activity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        System.out.println("All products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println();

        products.add("Webcam");
        products.remove("Mouse");

        System.out.println("After adding and removing products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String search = scanner.nextLine();

        boolean found = false;
        for (String product : products) {
            if (product.equalsIgnoreCase(search)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Product found: " + search);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }
}
