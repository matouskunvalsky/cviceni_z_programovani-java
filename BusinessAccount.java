package accounts;

import people.AccountOwner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(AccountOwner owner) {
        super(owner);
    }

    public BusinessAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void sub(double amount) {
        System.out.println("Sub amount is " + amount + " (+ 1% fee)");

        double fee = amount * 0.01;
        double newBalance = this.balance - (amount + fee);

        if (newBalance < 0) {
            throw new RuntimeException("Balance is negative");
        }

        this.balance = newBalance;
    }
}