# ATM SYSTEM 💻
<p align="center">
  <a href="https://gitpoint.co/">
    <img alt="ATM SYSTEM" title="ATM SYSTEM" src="https://github.com/Rikku1/OOP-Final-Project/blob/main/atm.png" width="250">
  </a>
</p>

<p align="center">
  <i><b><code>Jenrick Magtaas IT-2104</code></b></i>
</p>

---

## 🔍 About
An ATM System project is a basic implementation that simulates the core functions of an Automated Teller Machine. It allows users to create accounts, log in, and manage their banking activities. The system supports two types of accounts—checking and savings—and includes functionalities for viewing account balances, making withdrawals, and depositing funds. This simple project focuses on applying fundamental programming concepts like user authentication, conditional logic, and basic data storage to replicate essential banking operations.

<p align="center">
  <img src="https://media.giphy.com/media/AslZw11iNXkkx33XZM/giphy.gif" width="300">
</p>

---

## 🏛️ OOP Principles
### Encapsulation 💊
- Restricts direct access to class properties and ensures controlled interaction using getter and setter methods.
- Properties like `accountName, accountNumber, pin, and balance` are **private**. They are accessed or modified only through their respective **public getter and setter methods**.

```java
//example from my project
private String accountName;
public String getAccountName() {
    return accountName; }
public void setAccountName(String accountName) {
    this.accountName = accountName; }
```

---

### Inheritance 👨🏻‍👩🏻‍👧🏻
- Allows one class to inherit properties and methods from another class.
- Both `CheckingAccount` and `SavingsAccount` inherit from the `Account class`. This allows code reuse for shared functionality like `deposit`, `withdraw`, `showBalance()`, and `menu()`.

```java
//example from my project
public class CheckingAccount extends Account { ... }
public class SavingsAccount extends Account { ... }
```

---

### Abstraction 🫥
- Hides implementation details and only exposes essential methods to subclasses.
- The `menu()` method is declared as abstract in the `Account class` and implemented by `CheckingAccount` and `SavingsAccount`. This creates a blueprint for functionality while hiding implementation details.

```java
//example from my project
public abstract void menu();
```

---

### Polymorphism 🐘🦣
- Allows objects to take on multiple forms and execute methods based on their actual class type.
- The `menu()` method behaves differently depending on the actual object type (`CheckingAccount` or `SavingsAccount`) while being referenced by the parent type `Account`. This demonstrates polymorphism.

```java
//example from my project
Account checkingMenu = (CheckingAccount) accounts.stream()
                                .filter(acc -> acc instanceof CheckingAccount)
                                .findFirst().orElse(null);
checkingMenu.menu();
```

---

## 🪧 SDG
<p align="center">
  <img src="SDG_9.png" width="1000">
</p>

The program aligns with **SDG 9: Industry, Innovation, and Infrastructure** by simulating digital financial services like account management, deposits, and withdrawals. It promotes financial inclusion and innovation by providing access to essential financial tools for economic empowerment.

---

## 💻 Running the Program
### 1️⃣ Compile the Java files
Open a terminal in the project directory and run:

```bash
Account.java 
CheckingAccount.java 
SavingsAccount.java 
ATM.java 
Main.java
```

---

### 2️⃣ Run the program
Execute the following command:

```bash
java Main
```

---

### 3️⃣ Interact with the ATM
- 📝 Create an account (Checking and Savings accounts are linked).
- 🔑 Log in with your account number and PIN.
- 💰 Perform transactions like deposits, withdrawals, or checking balances.
- 💸 Savings Account automatically applies annual interest if eligible.

---

## 🤝 Acknowledgments
- sa aking sarili, for understanding the OOP Principles first rather than adding GUI
- sa inyo SIR, salute! (weird po ba na fav. ko ang java? hehe)
<p align="center">
  <img src="https://media.giphy.com/media/dvU73impCIEKoDcCHE/giphy.gif?cid=790b76114lgusy8612og6s9dwzceu2j2savj3djt59qb62e6&ep=v1_gifs_search&rid=giphy.gif&ct=g" width="800">
</p>
 
