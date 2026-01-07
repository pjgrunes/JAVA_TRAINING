package module4_activity3;


import java.text.NumberFormat;
import java.util.Locale;

public class ATMTrans {

 
    public static void checkBalance(String accountNumber, double balance) {
        System.out.println("Processing balance inquiry...");

        try {
            Integer.parseInt(accountNumber);

            char typeChar = accountNumber.charAt(0);
            String accountType = determineAccountType(typeChar);

            // Print details
            System.out.println("Account Type: " + accountType);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: " + currency(balance));
            System.out.println("Balance inquiry successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred during balance inquiry.");
        } finally {
            printReceipt();
        }

        // Spacer line between test outputs
        System.out.println();
    }

    private static String determineAccountType(char firstChar) {
        if (firstChar == '1') return "Savings";
        if (firstChar == '2') return "Checking";
        return "Unknown";
    }

    private static String currency(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
        return nf.format(amount);
    }

    private static void printReceipt() {
        System.out.println("=========== RECEIPT ===========");
        System.out.println("Transaction Date: December 3, 2025");
        System.out.println("Transaction Type: Balance Inquiry");
        System.out.println("ATM Location: Main Branch");
        System.out.println("Thank you for banking with us!");
        System.out.println("================================");
    }

    public static void main(String[] args) {
        System.out.println("==== ATM BALANCE INQUIRY SYSTEM ====\n");

        // --- Test Case 1: Valid Savings Account ---
        System.out.println("--- Test Case 1: Valid Savings Account ---");
        checkBalance("100123456", 15000.00); // Expected: Success (Savings)

        // --- Test Case 2: Valid Checking Account ---
        System.out.println("--- Test Case 2: Valid Checking Account ---");
        checkBalance("200987654", 25000.00); // Expected: Success (Checking)

        // --- Test Case 3: Invalid Account Number Format ---
        System.out.println("--- Test Case 3: Invalid Account Number Format ---");
        checkBalance("ABC12345", 15000.00);   // Expected: NumberFormatException handled

        // --- Test Case 4: Empty Account Number ---
        System.out.println("--- Test Case 4: Empty Account Number ---");
        checkBalance("", 15000.00);           // Expected: StringIndexOutOfBoundsException handled

        System.out.println("==== All tests completed! ====");
    }
}

