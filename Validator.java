package module4_activity4;


public class Validator {

    // Method to validate account number
    public static void validateAcctNumber(String accountNum) throws Exception {
        if (accountNum == null) {
            throw new NullPointerException("Cannot be null");
        }

        if (accountNum.length() != 10) {
            throw new Exception("Must be 10 digits");
        }

        System.out.println("Valid account: " + accountNum);
    }

    public static void main(String[] args) {
        String[] testCases = {"1234567890", "123", null};

        for (String account : testCases) {
            try {
                validateAcctNumber(account);
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

