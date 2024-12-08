import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

class SavingsAccount extends Account {
    private double interestRate; // Attribute for interest rate
    private LocalDate lastInterestApplied; // To track the last date interest was applied

    public SavingsAccount(double interestRate) { // Constructor
        this.interestRate = interestRate; // Initialize interest rate
        this.lastInterestApplied = LocalDate.now(); // Set the initial date to now
    }

    @Override
    public void menu() {
        // Check if a year has passed since the last interest application
        applyInterestDue();

        int choice;
        do {
            System.out.println("===================================");
            System.out.println("\tATM(Savings Account)");
            System.out.println("===================================");
            System.out.println("  1. Check Balance");
            System.out.println("  2. Deposit");
            System.out.println("  3. Withdraw");
            System.out.println("  4. Back");
            System.out.println("===================================");
            System.out.print("  Select an option: ");

            try { //Error Handling
                choice = input.nextInt();

                System.out.println("===================================");
                switch (choice) {
                    case 1:
                        showBalance(); // Call the 'showBalance' method to display the balance
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: "); 
                        double depositAmount = input.nextDouble(); // Get the deposit amount from the user
                        if (depositAmount <= 0){  // Check if the deposit amount is valid
                            System.out.println("Deposit amount must be greater than zero.");
                        } else {
                            deposit(depositAmount); // depositAmount is passed to the 'deposit' method
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = input.nextDouble(); // Get the withdraw amount from the user
                        if (withdrawAmount <= 0) { // Check if the withdraw amount is valid
                            System.out.println("Withdrawal amount must be greater than zero.");
                        } else if (withdrawAmount > getBalance()) { // Check if the withdraw amount exceeds the balance
                            System.out.println("Insufficient balance.");
                        } else {
                            withdraw(withdrawAmount); // withdrawAmount is passed to the 'withdraw' method
                        }
                        break;
                    case 4:
                        System.out.println("Returning to the Main Menu..."); // Exit the ATM menu
                        return; 
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine(); 
                choice = 0;
            }
        } while (choice != 4);
            input.close();
    }

    private void applyInterestDue() { // Method to check if a year has passed and apply interest if due
        LocalDate today = LocalDate.now(); // Get the current date
        long yearsElapsed = ChronoUnit.YEARS.between(lastInterestApplied, today); // Calculate the years elapsed since the last interest was applied

        if (yearsElapsed >= 1) { // Check if a year has passed
            double interest = getBalance() * (interestRate / 100) * yearsElapsed; // Calculate interest for the elapsed years
            setBalance(getBalance() + interest); // Directly add interest to the balance
            lastInterestApplied = today; // Update the last interest applied date
            System.out.printf("Interest applied: %.2f. New balance: %.2f PHP\n", interest, getBalance());
        }
    }
}
