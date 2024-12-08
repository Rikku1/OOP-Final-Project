import java.util.InputMismatchException;
import java.util.Scanner;

class ATM{
        Scanner input = new Scanner(System.in);
        
        Account checkingMenu = new CheckingAccount();
        Account savingsMenu = new SavingsAccount(3.0);  
        
        public void accountMenu(){
            int choice;
        do{
        System.out.println("===================================");
        System.out.println("\t\tATM");
        System.out.println("===================================");
        System.out.println("  1. Checking Account");
        System.out.println("  2. Savings Account");
        System.out.println("  3. Exit");
        System.out.println("===================================");
        System.out.print("  Select an option: ");
        try{    
            choice = input.nextInt();
            System.out.println("===================================");

            switch (choice) {
                case 1:
                    checkingMenu.menu();
                    continue;import java.util.*;

                    class ATM {
                        private Scanner input = new Scanner(System.in);
                        private List<Account> accounts = new ArrayList<>();
                        private Account loggedInAccount = null;
                    
                        public void accountMenu() {
                            int choice;
                            do {
                                System.out.println("===================================");
                                System.out.println("\t\tATM");
                                System.out.println("===================================");
                                System.out.println("  1. Create Account");
                                System.out.println("  2. Login");
                                System.out.println("  3. Exit");
                                System.out.println("===================================");
                                System.out.print("  Select an option: ");
                                try {
                                    choice = input.nextInt();
                                    System.out.println("===================================");
                                    switch (choice) {
                                        case 1:
                                            createAccount();
                                            break;
                                        case 2:
                                            login();
                                            break;
                                        case 3:
                                            System.out.println("Thank you for using the ATM. Goodbye!");
                                            break;
                                        default:
                                            System.out.println("Invalid option! Try again.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.err.println("Invalid input! Please enter a number.");
                                    input.nextLine(); // Clear invalid input
                                }
                            } while (choice != 3);
                        }
                    
                        private void createAccount() {
                            input.nextLine(); // Clear buffer
                            System.out.println("===================================");
                            System.out.println("CREATE NEW ACCOUNT");
                            System.out.println("===================================");
                            System.out.print("Enter Account Name: ");
                            String name = input.nextLine();
                            System.out.print("Enter Account Number: ");
                            String accountNumber = input.nextLine();
                            System.out.print("Set a PIN: ");
                            String pin = input.nextLine();
                            System.out.println("Select Account Type:");
                            System.out.println("  1. Checking Account");
                            System.out.println("  2. Savings Account (3% Interest Rate)");
                            System.out.print("Enter your choice: ");
                            int type = input.nextInt();
                    
                            Account newAccount;
                            if (type == 1) {
                                newAccount = new CheckingAccount();
                            } else if (type == 2) {
                                newAccount = new SavingsAccount(3.0); // Fixed interest rate of 3%
                            } else {
                                System.out.println("Invalid account type. Returning to menu.");
                                return;
                            }
                    
                            newAccount.setAccountName(name);
                            newAccount.setAccountNumber(accountNumber);
                            newAccount.setPin(pin);
                            accounts.add(newAccount);
                    
                            System.out.println("Account created successfully!");
                        }
                    
                        private void login() {
                            input.nextLine(); // Clear buffer
                            System.out.println("===================================");
                            System.out.println("LOGIN");
                            System.out.println("===================================");
                            System.out.print("Enter Account Number: ");
                            String accountNumber = input.nextLine();
                            System.out.print("Enter PIN: ");
                            String pin = input.nextLine();
                    
                            loggedInAccount = accounts.stream()
                                    .filter(acc -> acc.getAccountNumber().equals(accountNumber) && acc.getPin().equals(pin))
                                    .findFirst()
                                    .orElse(null);
                    
                            if (loggedInAccount != null) {
                                System.out.println("Login successful! Welcome, " + loggedInAccount.getAccountName());
                                loggedInAccount.menu(); // Call the specific menu for the logged-in account
                            } else {
                                System.out.println("Invalid account number or PIN. Please try again.");
                            }
                        }
                    }
                    
                case 2:
                    savingsMenu.menu();
                    continue;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                    continue;
            }
        }catch (InputMismatchException e){
            System.err.println("Invalid Input!");
            input.nextLine(); // Clear invalid input
            choice = 0; // Reset choice to prevent exiting the loop
        }
            
        } while(choice != 3);
        }
}