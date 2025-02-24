package example.model;

import example.exception.MismatchingUserIdException;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    public static final int WITHDRAW_FEE = 1;

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (!checkUser(userID)) {
            throw new MismatchingUserIdException(userID);
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (!checkUser(userID)) {
            throw new MismatchingUserIdException(userID);
        }

        if (!isWithdrawAllowed(amount)) {
            throw new IllegalStateException("Requested " + amount + ", but " + this.balance + " available.");
        }

        this.balance -= amount + WITHDRAW_FEE;
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + WITHDRAW_FEE;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
