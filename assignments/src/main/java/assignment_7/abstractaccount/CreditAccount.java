package assignment_7.abstractaccount;

/**
 * A {@code CreditAccount} has in addition to {@code balance} a state for
 * {@code creditLine}, i.e.
 * available credit on the account. This credit line allows the account to be
 * overdrawn (that the
 * balance is negative) within the credit line. If {@link #internalWithdraw()}
 * tries to withdraw
 * more money than is available, taking the credit line into account, an
 * {@code IllegalArgumentException} should be thrown.
 * 
 * @see AbstractAccount
 */
public class CreditAccount extends AbstractAccount {
  private double creditLine;

  /**
   * Initializes a new {@code CreditAccount} with the specified credit line.
   * 
   * @param creditLine the credit line
   * @throws IllegalArgumentException if the credit line is negative
   */
  public CreditAccount(double creditLine) {
    setCreditLine(creditLine);
  }

  @Override
  void internalWithdraw(double amount) {
    if((this.balance + this.creditLine) - amount < 0)
      throw new IllegalArgumentException("Trying to withdraw too much money");
    
    this.balance -= amount;
  }

  /**
   * @return the credit line
   * 
   * @see CreditAccountTest#testCreditLine()
   */
  public double getCreditLine() {
    return this.creditLine;
  }

  /**
   * Sets the credit line.
   * 
   * @param creditLine the credit line
   * @throws IllegalArgumentException if the credit line is negative, or if the
   *                                  new credit line
   *                                  does not cover the existing balance
   * 
   * @see CreditAccountTest#testCreditLine()
   */
  public void setCreditLine(double creditLine) {
    if (creditLine < 0)
      throw new IllegalArgumentException("Cannot set negative credit line");
    if(this.balance < creditLine * -1)
      throw new IllegalArgumentException("Cannot set credit line lower than current negative balance");

    this.creditLine = creditLine;
  }
}
