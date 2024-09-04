import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Banking Application!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    Account account = new Account(accountNumber, customerName, initialBalance);
                    bank.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    bank.deposit(depositAccountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    bank.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String checkBalanceAccountNumber = scanner.nextLine();

                    bank.checkBalance(checkBalanceAccountNumber);
                    break;
                case 5:
                    System.out.println("Exiting the Banking Application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

class Account {
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully.");
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }
}

