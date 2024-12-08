import java.util.*; //For Scanner and ArrayList

public class ATM {
    Account checkingAccount = new CheckingAccount();
    Account savingsAccount = new SavingsAccount(3.0);

    private Scanner input = new Scanner(System.in);
    private List<Account> accounts = new ArrayList<>(); //arraylist of accounts
    private Account loggedInAccount = null; //account currently logged in

    public void accountMenu() {
        int choice;
        do {
            System.out.println("****************************************************************************");
            System.out.println("*\t\t\t\t\t\t\t\t\t   *");
            System.out.println("*\t\t\t\t  ATM Menu\t\t\t\t   *");
            System.out.println("*\t\t\t\t\t\t\t\t\t   *");
            System.out.println("****************************************************************************");
            System.out.println("  1. Create Account");
            System.out.println("  2. Login");
            System.out.println("  3. Exit");
            System.out.println("****************************************************************************");
            System.out.print("  Select an option: ");
            try {
                choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    createAccount(); //call the createAccount method
                    break;
                case 2:
                    login(); //call the login method
                    break;
                case 3:
                    System.out.println("Exiting..."); //exit the program
                    break;
                default:
                    System.out.println("Invalid option. Try again."); //invalid option
                } 
            }
            catch (InputMismatchException e) { // Error Handling
                System.err.println("Invalid input! Please enter a number.");
                input.nextLine(); // Clear invalid input
                choice = 0;
            }
    }       while (choice != 3);
}

    private void createAccount() {
        input.nextLine();
        System.out.println("****************************************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("*\t\t\t     CREATE NEW ACCOUNT\t\t\t\t   *");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("****************************************************************************");
        System.out.print("Enter Account Name: ");
        String name = input.nextLine();
        
        String accountNumber;
        while (true) {
            System.out.print("Enter 8-digit Account Number: ");
            accountNumber = input.nextLine();
            if (accountNumber.matches("\\d{8}")) { // Ensure it is exactly 8 digits
                break;
            } else {
                System.out.println("Invalid account number. Please enter exactly 8 digits.");
            }
        }
    
        String pin;
        while (true) {
            System.out.print("Enter 4-digit PIN: ");
            pin = input.nextLine();
            if (pin.matches("\\d{4}")) { // Ensure it is exactly 4 digits
                break;
            } else {
                System.out.println("Invalid PIN. Try Again.");
            }
        }
    
        // Create a Combined Account (Both Checking and Savings)
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount(3.0);
    
        // Set Details for Both Accounts
        checkingAccount.setAccountName(name);
        checkingAccount.setAccountNumber(accountNumber);
        checkingAccount.setPin(pin);
    
        savingsAccount.setAccountName(name);
        savingsAccount.setAccountNumber(accountNumber);
        savingsAccount.setPin(pin);
    
        // Add Both Accounts to the List
        accounts.add(checkingAccount);
        accounts.add(savingsAccount);
    
        System.out.println("Account created successfully!");
    }
    

    private void login() {
        System.out.println("****************************************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("*\t\t\t\t   LOG IN\t\t\t\t   *");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("****************************************************************************");
        System.out.print("Enter Account Number: ");
        String accountNumber = input.next();
        System.out.print("Enter PIN: ");
        String pin = input.next();
        // Find the account with the matching account number and PIN
        loggedInAccount = accounts.stream() 
                                .filter(acc -> acc.getAccountNumber().equals(accountNumber) && acc.getPin().equals(pin))
                                .findFirst() 
                                .orElse(null);
        // If account found
        if (loggedInAccount != null) { 
            System.out.println("Login successful! Welcome, " + loggedInAccount.getAccountName());
            accountSelectionMenu();
        } else {
            System.out.println("Login failed. Invalid credentials."); 
        }
    }

    public void accountSelectionMenu() {
        int choice;
        do {
            System.out.println("****************************************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("*\t\t\t        ACCOUNT MENU\t\t\t\t   *");
        System.out.println("*\t\t\t\t\t\t\t\t\t   *");
        System.out.println("****************************************************************************");
            System.out.println("1. Checking Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        CheckingAccount checkingMenu = (CheckingAccount) accounts.stream() //object of Checking Account to search for accounts
                                            .filter(acc -> acc instanceof CheckingAccount && acc.getAccountNumber().equals(loggedInAccount.getAccountNumber()))
                                            .findFirst()
                                            .orElse(null);
                        if (checkingMenu != null) {
                            checkingMenu.menu(); // Go to the checking menu
                        }
                        break;

                    case 2:
                        
                        SavingsAccount savingsMenu = (SavingsAccount) accounts.stream() //object of SavingsAccount to search for accounts
                                            .filter(acc -> acc instanceof SavingsAccount && acc.getAccountNumber().equals(loggedInAccount.getAccountNumber())) 
                                            .findFirst() 
                                            .orElse(null);
                        if (savingsMenu != null) {
                            savingsMenu.menu();// Go to the savings menu
                        }
                        break;

                    case 3:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.err.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a valid number.");
                input.nextLine(); 
                choice = 0;
            }
        } while (choice != 3);
    }
}
