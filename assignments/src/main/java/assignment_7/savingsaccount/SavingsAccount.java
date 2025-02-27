package assignment_7.savingsaccount;

public class SavingsAccount implements Account {
  private double rent;
  private double balance;

  public SavingsAccount(double rent) {
    this.rent = rent;
    this.balance = 0d;
  }

  public void deposit(double amount) {
    if(amount < 0) throw new IllegalArgumentException("Cannot deposit negative value");

    this.balance += amount;
  }

  public void withdraw(double amount) {
    if(amount < 0) throw new IllegalArgumentException("Cannot withdraw negative value");
    if(this.balance - amount < 0) throw new IllegalStateException("Account does not have sufficient coverage");

    this.balance -= amount;
  }

  public double getBalance() {
    return this.balance;
  }

  public void endYearUpdate() {
    this.balance *= 1 + rent;
  }
}
