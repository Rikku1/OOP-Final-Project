import java.util.InputMismatchException; // Import for invalid user input

public class CheckingAccount extends Account{
    
    @Override
    public void menu(){  // Implementation of the abstract 'menu' method from Account class
        
        int choice;
        do {
        System.out.println("===================================");
        System.out.println("\tATM(Checking Account)");
        System.out.println("===================================");
        System.out.println("  1. Check Balance");
        System.out.println("  2. Deposit");
        System.out.println("  3. Withdraw");
        System.out.println("  4. Back");
        System.out.println("===================================");
        System.out.print("  Select an option: ");
        
        try{  // Error Handling
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
                    System.out.println("-----------------------------------");
                    System.out.println("Note: 12 PHP Transaction fee will\nbe applied in every transaction");
                    System.out.println("-----------------------------------");
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
        }catch (InputMismatchException e) { // Error Handling
            System.err.println("Invalid input! Please enter a number.");
            input.nextLine(); // Clear invalid input
            choice = 0;
        }
            
        } while (choice != 4);
            input.close();
    }
}
