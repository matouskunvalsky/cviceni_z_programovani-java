package accounts;

import notifiers.ConsoleNotifier;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;
import transfers.Withdraw;

public abstract class BankAccount implements Withdraw {

    private String uuid;

    private String accountNumber; // 2102405518

    private Owner owner;

    protected double balance;

    protected Notifier notifier = new EmailNotifier();

    public BankAccount(String uuid, String accountNumber, Owner owner) {}

    public BankAccount(Owner owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(Owner owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void sub(double amount) {
        this.notifier.notify("Sub amount is " + amount);
        System.out.println("Sub amount is " + amount);

        double newBalance = balance - amount;

        if (newBalance < 0) {
            throw new RuntimeException("Balance is negative");
        }

        this.balance = newBalance;
    }

    public void add(double amount) {
        System.out.println("Add amount is " + amount);

        this.balance = this.balance + amount;
    }

    @Override
    public void setNewBalance(double balance) {
        this.balance = balance;
    }
}