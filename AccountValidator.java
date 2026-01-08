package module4_activity5;
public class AccountValidator {

    public void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        // 1) check if null
        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null");
        }

        // 2) check format
        for (char ch : accountNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new InvalidAccountFormatException("Account number must contain only digits");
            }
        }

        // 3) check length
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
        }

        // 4) Valid
        System.out.println("Valid account: " + accountNumber);
    }

    private static void ValidateTest(String testName, String accntNum, AccountValidator validator) {
        System.out.println("Test " + testName + ": " + (accntNum == null ? "null" : accntNum));
        try {
            validator.validateAccountNumber(accntNum);
        } catch (InvalidAccountNumberException e) {
            System.out.println("Message: " + e.getMessage());
        } catch (InvalidAccountFormatException e) {
            System.out.println("Message: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AccountValidator validator = new AccountValidator();

        System.out.println("=== Account Number Validation Test ===\n");

        ValidateTest("1 - Valid account", "1234567890", validator);     
        ValidateTest("2 - Too short", "123", validator);                
        ValidateTest("3 - Contains letters", "12345AB890", validator);  
        ValidateTest("4 - Contains space", "1234 567890", validator);   
        ValidateTest("5 - Null value", null, validator);                
    }
}

