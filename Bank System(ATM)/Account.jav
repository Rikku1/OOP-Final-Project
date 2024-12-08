import java.util.Scanner;

abstract class Account{
    Scanner input = new Scanner(System.in);
    
    private double balance = 0; // Private attribute to store balance
    double transactionFee = 12;
    
    public double getBalance() { // Method to get balance
        return balance;
    }
    
    public void setBalance(double balance) { // Method to set balance
        this.balance = balance;
    }

    public abstract void menu(); // Abstract method to be implemented by subclasses

    public void showBalance(){ // Method to display balance
        System.out.printf("Account Balance: %.2f PHP\n", balance);
    }

    public double deposit(double amount){ // Method to deposit money
        try { // Error Handling
            if(0 > amount){
                throw new IllegalArgumentException("Cannot deposit negative amount!");    
            } else if(getBalance() + amount > 500000) {
                    System.out.printf(" %.2f",amount);
                    System.out.println(" exceeds the Maximum \nBalance limit of 500,000!");
            } else {
                    setBalance(getBalance() + amount);
                    System.out.printf("New Balance: %.2f\n", getBalance());
            }
        } 
        catch (IllegalArgumentException e) {  // Error Handling
            System.err.println(e.getMessage());
        }
        return balance;
    }

    public double withdraw(double amount){ // Method to withdraw money
        try { // Error Handling
            if(0 >= amount){
                throw new IllegalArgumentException("Invalid Amount! Cannot withdraw negative or zero value.");
            } else if((amount + transactionFee) > getBalance()){
                System.out.println("Insufficient balance!");
            } else {
            setBalance(getBalance() - (amount + transactionFee ));
            System.out.printf("New Balance: %.2f\n", balance);
            }
        }
        catch (IllegalArgumentException e) { // Error Handling
            System.err.println(e.getMessage());
        } 
        return balance;     
    }
}