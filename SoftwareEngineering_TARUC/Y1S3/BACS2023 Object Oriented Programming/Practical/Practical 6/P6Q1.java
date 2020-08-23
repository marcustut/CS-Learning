import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Account {
  private String accountNum;
  private double balance;
  private Date dateCreated;

  // Constructors 
  public Account() {
    this("", 0.0);
  }

  public Account(String accountNum, double balance) {
    this.accountNum = accountNum;
    this.balance = balance;
    this.dateCreated = new Date();
  }

  public Account(String accountNum, double balance, Date dateCreated) {
    this.accountNum = accountNum;
    this.balance = balance;
    this.dateCreated = dateCreated;
  }

  // Getters and Setters
  public String getAccountNum() {
    return this.accountNum;
  }

  public void setAccountNum(String accountNum) {
    this.accountNum = accountNum;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public Date getDateCreated() {
    return this.dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  // User-defined methods
  public void deposit(double amount) {
    this.balance += amount;
  }

  public boolean withdraw(double amount) {
    if (amount > this.balance) return false;

    this.balance -= amount;
    return true;
  }

  public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String title = "\nAccount Info"; 
    String sep = "\n-------------------------------------------------------------------";
    String accountNo = "\nAccount Number: " + this.getAccountNum();
    String balance = String.format("\nBalance: %.2f", this.getBalance());
    String dateCreated = String.format("\nDate Created: %s", dateFormat.format(this.getDateCreated()));

    return title + sep + accountNo + balance + dateCreated + sep;
  }

  @Override
  public boolean equals(Object obj) {
    Account accountToCheck = (Account) obj;

    return this.getAccountNum().equalsIgnoreCase(accountToCheck.getAccountNum());
  }
}

class SavingsAccount extends Account {
  private final double INTEREST_RATE = 0.05;

  // Constructors
  public SavingsAccount(String accountNum, double balance) {
    super(accountNum, balance);
  }

  // User-defined methods
  public double calcInterest() {
    return this.getBalance() * INTEREST_RATE / 12;
  }

  public void addInterest() {
    this.deposit(calcInterest());
  }
}

class CurrentAccount extends Account {
  private int numFreeTransaction = 5;
  private final double TRANSACTION_FEE = 1.0;

  // Constructors
  public CurrentAccount(String accountNum, double balance) {
    super(accountNum, balance);
  }

  // Getters and Setters
  public int getNumFreeTransaction() {
    return this.numFreeTransaction;
  }

  public void setNumFreeTransaction(int numFreeTransaction) {
    this.numFreeTransaction = numFreeTransaction;
  }

  public double getTransactionFee() {
    return this.TRANSACTION_FEE;
  }
  // User-defined methods
  public void deductNumFreeTransaction() {
    this.numFreeTransaction--;
  }

  public void deductTransactionFee() {
    super.withdraw(TRANSACTION_FEE);
  }

  @Override
  public boolean withdraw(double amount) {
    if ((this.numFreeTransaction) <= 0) {
      this.deductNumFreeTransaction();
      return super.withdraw(amount);
    }

    this.deductNumFreeTransaction();
    return super.withdraw(amount);
  }

  @Override
  public void deposit(double amount) {
    if ((this.numFreeTransaction) <= 0) {
      this.deductNumFreeTransaction();
      super.deposit(amount);
    }

    this.deductNumFreeTransaction();
    super.deposit(amount);
  }

  @Override
  public String toString() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    String title = "\nAccount Info"; 
    String sep = "\n-------------------------------------------------------------------";
    String accountNo = "\nAccount Number: " + this.getAccountNum();
    String balance = String.format("\nBalance: %.2f", this.getBalance());
    String dateCreated = String.format("\nDate Created: %s", dateFormat.format(this.getDateCreated()));
    String numFreeTransaction = String.format("\nNumber of Free Transactions left: %d", this.getNumFreeTransaction());

    return title + sep + accountNo + balance + dateCreated + numFreeTransaction + sep;
  }
}

public class P6Q1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    SavingsAccount s = new SavingsAccount("123123123", 2000);
    SavingsAccount s2 = new SavingsAccount("123123123", 2000);
    CurrentAccount c = new CurrentAccount("12312312312", 2000);

    System.out.println("s1 and s2 are equals - " + s.equals(s2));

    boolean cont = true;

    while (cont) {
      int accountType = 0;

      do {
        System.out.println("\nAccount Type");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("What is your account type?");
        System.out.print(">");
        accountType = scanner.nextInt();
      } while (accountType == 0);

      int userInput = 0;

      do {
        System.out.println("\nBank Menu");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. Check Account");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("What do you want to do?");
        System.out.print(">");
        userInput = scanner.nextInt();
      } while (userInput == 0);

      if (userInput == 1) {
        if (accountType == 1) System.out.println(s.toString());
        else System.out.println(c.toString());
      }
      else if (userInput == 2) {
        System.out.println("\nHow much money you want to withdraw?");
        System.out.print(">");

        double amount = scanner.nextDouble();

        if (accountType == 1) {
          s.withdraw(amount);
          System.out.println(s.toString());
        }
        else {
          c.withdraw(amount);
          System.out.println(c.toString());
        }
      }
      else {
        System.out.println("\nHow much money you want to deposit?");
        System.out.print(">");

        double amount = scanner.nextDouble();

        if (accountType == 1) {
          s.deposit(amount);
          System.out.println(s.toString());
        }
        else {
          c.deposit(amount);
          System.out.println(c.toString());
        }
      }
      System.out.println("\n\nDo you want to continue?");
      System.out.print(">");

      String temp = scanner.next();

      if (temp.equalsIgnoreCase("y")) cont = true;
      else {
        cont = false;
        scanner.close();
      };
    }
  }
}