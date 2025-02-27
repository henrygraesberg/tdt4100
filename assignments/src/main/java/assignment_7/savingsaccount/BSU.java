package assignment_7.savingsaccount;

public class BSU extends SavingsAccount {
  private double maxDeposit, depositThisYear, withdrawableThisYear;
  
  public BSU(double rent, double maxDeposit) {
    super(rent);

    this.maxDeposit = maxDeposit;
    this.depositThisYear = 0d;
    this.withdrawableThisYear = 0d;
  }

  @Override
  public void deposit(double amount) {
    if(this.depositThisYear + amount > maxDeposit)
      throw new IllegalStateException("Cannot deposit this amount money for this year");

    this.depositThisYear += amount;
    this.withdrawableThisYear += amount;
    super.deposit(amount);
  }

  @Override
  public void withdraw(double amount) {
    if(amount > this.withdrawableThisYear)
      throw new IllegalStateException("Cannot withdraw more money than depositied this year");

    this.withdrawableThisYear -= amount;
    super.withdraw(amount);
  }

  @Override
  public void endYearUpdate() {
    this.depositThisYear = 0d;

    super.endYearUpdate();
  }

  public double getTaxDeduction() {
    return this.depositThisYear * 0.20;
  }
}
