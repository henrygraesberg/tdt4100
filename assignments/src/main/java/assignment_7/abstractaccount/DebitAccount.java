package assignment_7.abstractaccount;

/**
 * A debit account is the simplest form of account, where the only requirement is that the balance
 * at any time must be greater than or equal to {@code 0.0}. {@code DebitAccount} extends (inherits
 * from) {@link AbstractAccount} and ensure that the balance never falls below {@code 0.0}. If an
 * attempt is made to withdraw more money than is available, an {@code IllegalArgumentException}
 * should be thrown.
 * 
 * @see AbstractAccount
 */
public class DebitAccount extends AbstractAccount {
  @Override
  void internalWithdraw(double amount) {
    if(this.balance - amount < 0)
      throw new IllegalArgumentException("Cannot withdraw more money than is in the account");
    
    this.balance -= amount;
  }
}
