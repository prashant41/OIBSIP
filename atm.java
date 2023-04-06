import java.util.ArrayList;
import java.util.Scanner;

public class atm {

    public static void main(String[] args) {

        // initialize variables
        int balance = 0;
        int pin = 1234; // default pin
        int attempts = 0;
        int maxAttempts = 3;
        ArrayList<String> transactionHistory = new ArrayList<>();

        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // display welcome message
        System.out.println("Welcome to the ATM Machine");

        // loop until correct pin is entered or max attempts are reached
        while (attempts < maxAttempts) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == pin) {
                System.out.println("PIN accepted");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Please try again.");
            }
        }

        // check if max attempts have been reached
        if (attempts == maxAttempts) {
            System.out.println("Max attempts reached. Your account is locked.");
            System.exit(0);
        }

        // loop until user quits
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View balance");
            System.out.println("2. View transaction history");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your balance is: " + balance);
                    break;
                case 2:
                    System.out.println("Transaction history:");
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    balance += depositAmount;
                    transactionHistory.add("Deposit: +" + depositAmount);
                    System.out.println("Deposit successful. Your new balance is: " + balance);
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawalAmount = scanner.nextInt();
                    if (balance < withdrawalAmount) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= withdrawalAmount;
                        transactionHistory.add("Withdrawal: -" + withdrawalAmount);
                        System.out.println("Withdrawal successful. Your new balance is: " + balance);
                    }
                    break;
                case 5:
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    System.out.print("Enter transfer amount: ");
                    int transferAmount = scanner.nextInt();
                    if (balance < transferAmount) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= transferAmount;
                        transactionHistory.add("Transfer: -" + transferAmount);
                        System.out.println("Transfer successful. Your new balance is: " + balance);
                        // update recipient's balance
                        // transaction history
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM machine.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
