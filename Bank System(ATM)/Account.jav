import java.util.Scanner;

abstract class Account {
    Scanner input = new Scanner(System.in);

    private String accountName;
    private String accountNumber;
    private String pin;
    private double balance = 0; 
    double transactionFee = 12;
    //Getter and Setter methods for accountName
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    //Getter and Setter methods for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    //Getter and Setter methods for pin
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    //Getter and Setter methods for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void menu(); //Abstract method for menu

    public void showBalance() { //Method to show balance
        System.out.printf("Account Balance: %.2f PHP\n", balance);
    }

    public double deposit(double amount) { //Method to deposit
        if (amount <= 0) {
            System.err.println("Cannot deposit a non-positive amount.");
            return balance;
        }
        if (getBalance() + amount > 500000) {
            System.out.printf("%.2f exceeds the maximum balance limit of 500,000 PHP.\n", amount);
        } else {
            setBalance(getBalance() + amount);
            System.out.printf("Deposit successful! New Balance: %.2f PHP\n", getBalance());
        }
        return balance;
    }

    public double withdraw(double amount) { //Method to withdraw
        if (amount <= 0) {
            System.err.println("Invalid withdrawal amount.");
            return balance;
        }

        if ((amount + transactionFee) > getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            setBalance(getBalance() - (amount + transactionFee));
            System.out.printf("Withdrawal successful. New Balance: %.2f PHP\n", balance);
        }
        return balance;
    }
}
