package module4_activity1;


public class BankAcc {

    public static String getAccountName(String accountNumber) {
        if ("ACC-001".equals(accountNumber)) {
            return "Juan Dela Cruz";
        } else if ("ACC-002".equals(accountNumber)) {
            return "Maria Santos";
        } else {
            return null; // Not found
        }
    }

   
    public static void testCase(String accountNumber) {
        System.out.println();
        System.out.println("Looking up account: " + accountNumber);

        try {
            String name = getAccountName(accountNumber);
            String upperName = name.toUpperCase();
            System.out.println("Account holder: " + upperName);
        } catch (NullPointerException ex) {
            System.out.println("Error: Account not found!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===");

        testCase("ACC-001");
        testCase("ACC-999");

        System.out.println();
        System.out.println("=== Program completed successfully! ===");
    }
}
