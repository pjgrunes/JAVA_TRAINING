package module4_activity2;
public class ATM {

    // Sample account balances
    private static double[] accounts = {10000.0, 15000.0, 20000.0};

    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===\n");

        System.out.println("--- Test 1: Valid Withdrawal ---");
        System.out.println(processWithdrawal("1", "5000"));
        System.out.println();

        System.out.println("--- Test 2: Invalid Account Index ---");
        System.out.println(processWithdrawal("abc", "5000"));
        System.out.println();

        System.out.println("--- Test 3: Account Not Found ---");
        System.out.println(processWithdrawal("10", "5000"));
        System.out.println();

        System.out.println("--- Test 4: Insufficient Funds ---");
        System.out.println(processWithdrawal("1", "20000"));
        System.out.println();

        System.out.println("=== All tests completed! ===");
    }

    public static String processWithdrawal(String accountIndexInput, String amountInput) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Account=%s, Amount=%s%n", accountIndexInput, amountInput));

        Integer index = parseIndex(accountIndexInput);
        if (index == null) {
            sb.append("Error: Invalid input!\n");
            sb.append("Please enter valid numbers.\n");
            return sb.toString();
        }
        if (!isValidIndex(index)) {
            sb.append("Error: Account not found!\n");
            sb.append("Invalid account index.\n");
            return sb.toString();
        }
        Double amount = parseAmount(amountInput);
        if (amount == null) {
            sb.append("Error: Invalid input!\n");
            sb.append("Please enter valid numbers.\n");
            return sb.toString();
        }

        double currentBalance = accounts[index];
        sb.append(String.format("Current balance: ₱%.2f%n", currentBalance));
        sb.append(String.format("Withdrawal: ₱%.2f%n", amount));
        if (amount <= 0) {
            sb.append("Invalid amount! Please enter a positive value.\n");
            return sb.toString();
        }

        if (amount > currentBalance) {
            sb.append(String.format("Insufficient funds! Cannot withdraw ₱%.2f%n", amount));
            return sb.toString();
        }
        accounts[index] = currentBalance - amount;
        sb.append(String.format("New balance: ₱%.2f%n", accounts[index]));
        sb.append("Withdrawal successful!");

        return sb.toString();
    }

    private static Integer parseIndex(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }


    private static Double parseAmount(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }


    private static boolean isValidIndex(int index) {
        return index >= 0 && index < accounts.length;
    }
}
