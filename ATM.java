import java.util.Scanner;

public class ATM {

    // Properties to store balance and user PIN
    private double balance;
    private int pin;

    // Constructor to initialize with a balance and PIN
    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Methods for different functionalities
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdraw amount.");
        }
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize ATM with initial balance and PIN
        ATM atm = new ATM(1000.0, 1234);

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        while (true) {
            System.out.println("\nWelcome to Simple ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using Simple ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
