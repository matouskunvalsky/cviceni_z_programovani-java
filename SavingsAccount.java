package accounts;

import people.AccountOwner;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(AccountOwner owner) {
        super(owner);
    }

    public SavingsAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void add(double amount) {
        System.out.println("Add amount is " + amount + " (with 0.5% interest)");

        double interest = amount * 0.005;
        this.balance = this.balance + amount + interest;
    }
}