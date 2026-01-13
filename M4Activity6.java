package module4_Activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class M4Activity6 {

	//1. Create Custom Exceptions
    public static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }
    public static class InsufficientFundsException extends Exception {
        private final double balance;
        private final double requestedAmount;

        public InsufficientFundsException(String message, double balance, double requestedAmount) {
            super(message);
            this.balance = balance;
            this.requestedAmount = requestedAmount;
        }

        public double getBalance() { return balance; }
        public double getRequestedAmount() { return requestedAmount; }
    }

    //2. Create Functional Interface
    @FunctionalInterface
    public interface BankTestOperation {
        void execute() throws InvalidAmountException, InsufficientFundsException;
    }
    
    //3. Create Bank Account Class
    public static class BankAccount {
        private static final Logger log = LoggerFactory.getLogger(M4Activity6.class);
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() { return balance; }

        
        //4. Withdraw 
        public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
            log.info("Withdrawal requested: ₱{}", amount);

            if (amount < 0) {
            	log.error("Invalid withdrawal amount: ₱{}", amount);
           		throw new InvalidAmountException("Withdrawal amount must be positive");
           	}

           	if (amount > balance) {
           		log.warn("Insufficient funds: ₱{} available", balance);
           		throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
           	}

           	balance -= amount;
           	log.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
        }
     
        //5. Deposit
        public void deposit(double amount) throws InvalidAmountException {
            log.info("Deposit requested: ₱{}", amount);

            if (amount <= 0) {
                log.error("Invalid deposit amount: ₱{}", amount);
                throw new InvalidAmountException("Deposit amount must be positive");
            }

            if (amount > 50_000) {
                log.warn("Large deposit: ₱{} — requires verification", amount);
            }

            balance += amount;
            log.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
        }
     
      //6. runTest
      public static void runTest(Logger logger, BankTestOperation op, String name) {
            try {
                op.execute();
            } catch (InvalidAmountException ex) {
                logger.error("{} failed: {}", name, ex.getMessage(), ex);
            } catch (InsufficientFundsException ex) {
                logger.error("{} failed: {}", name, ex.getMessage(), ex);
            }
        }
    }
    
    //7. Test in Main
    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger(M4Activity6.class);
        BankAccount account = new BankAccount(10_000);

        BankAccount.runTest(log, () -> account.deposit(5_000), "Deposit");
        BankAccount.runTest(log, () -> account.withdraw(3_000), "Withdrawal");
        BankAccount.runTest(log, () -> account.deposit(-500), "Deposit");
        BankAccount.runTest(log, () -> account.withdraw(20_000), "Withdrawal");
        BankAccount.runTest(log, () -> account.deposit(60_000), "Deposit");
    }
}