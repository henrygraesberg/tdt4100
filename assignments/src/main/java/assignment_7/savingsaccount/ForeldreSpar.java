package assignment_7.savingsaccount;

public class ForeldreSpar extends SavingsAccount {
  private int maxWithdrawals, withdrawls;
  
  public ForeldreSpar(double rent, int maxWithdrawals) {
    super(rent);

    this.maxWithdrawals = maxWithdrawals;
  }

  @Override
  public void withdraw(double amount) {
    super.withdraw(amount);

    if(++this.withdrawls > this.maxWithdrawals) {
      super.deposit(amount);

      throw new IllegalStateException("Cannot withdraw more times this year");
    }
  }

  @Override
  public void endYearUpdate() {
    this.withdrawls = 0;

    super.endYearUpdate();
  }

  public int getRemainingWithdrawals() {
    return Math.max(0, this.maxWithdrawals - this.withdrawls);
  }
}
