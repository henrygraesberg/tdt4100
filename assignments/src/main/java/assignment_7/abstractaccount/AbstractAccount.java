package assignment_7.abstractaccount;

/**
 * A bank consists of many different types of accounts: credit accounts, debit accounts, savings
 * accounts, etc. Since these have a lot in common, e.g. all have a balance, it is practical to
 * collect as much of the common logic as possible in a superclass, which all can inherit from.
 * However, this superclass is not a type of account in itself, and therefore we make it
 * {@code abstract}, so that it cannot be instantiated. The concrete account classes that inherit
 * from it, must of course be instantiable. The methods defined in the {@code AbstractAccount} class
 * is similar to that of the Account interface in the SavingsAccount task.
 */
public abstract class AbstractAccount {

    // AbstractAccount has a state {@code balance} for the account balance. The balance should
    // either be set to 0.0 by default or in the constructor

    protected double balance = 0;

    /**
     * Decreases the account balance by the specified amount. Note that the rules for withdrawals
     * are different for the classes that implement {@code AbstractAccount}, and must therefore be
     * implemented in each class.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount cannot be withdrawn
     */
    abstract void internalWithdraw(double amount);

    /**
     * Increases the account balance by the specified amount.
     * 
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void deposit(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot deposit negative amount");

        this.balance += amount;
    }

    /**
     * This method calls the {@link #internalWithdraw()} method, which is implemented in each
     * subclass.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void withdraw(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot deposit negative amount");

        this.internalWithdraw(amount);
    }

    /**
     * @return the current balance of the account
     */
    public double getBalance() {
        return this.balance;
    }
}
