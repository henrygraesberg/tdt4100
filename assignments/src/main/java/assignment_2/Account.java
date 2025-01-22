package assignment_2;

public class Account {
  private double balance, interestRate;
  
  public Account() {
    this.balance = 0.0;
    this.interestRate = 0.0;
  }
  public Account(double balance, double interestRate) {
    if(balance < 0.0 || interestRate < 0.0) 
      throw new IllegalArgumentException("Balance and interest must be positive");
    
    this.balance = balance;
    this.interestRate = interestRate;
  }

  public double getBalance() {
    return this.balance;
  }

  public double getInterestRate() {
    return this.interestRate;
  }

  public void setInterestRate(double newInterestRate) {
    if(newInterestRate < 0.0)
      throw new IllegalArgumentException("Interest rate cannot be negative");
    
    this.interestRate = newInterestRate;
  }

  public void deposit(double deposit) {
    if(deposit < 0.0)
      throw new IllegalArgumentException("Deposit cannot be negative");
    
    this.balance += deposit;
  }

  public void withdraw(double value) {
    if(value < 0.0)
      throw new IllegalArgumentException("You cannot withdraw negative money");
    
    if(value > this.balance)
      throw new IllegalArgumentException("You cannot withdraw more money than you have on your account");
    
    this.balance -= value;
  }

  public void addInterest() {
    this.balance += this.balance * (1 + this.interestRate);
  }
}
