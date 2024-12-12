public class BankAccount {
    // Private fields to store account details
    private String accountNumber;
    private double balance;


    // Constructor to initialize the bank account
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }


    // Public method to get the current balance
    public double getBalance() {
        return balance;
    }


    // Public method to get the account number (optional)
    public String getAccountNumber() {
        return accountNumber;
    }
}
