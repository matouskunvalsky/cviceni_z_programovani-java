package accounts;

import people.AccountOwner;

public class StudentAccount extends BankAccount {
    private String school;

    public StudentAccount(AccountOwner owner, String school) {
        super(owner);
        this.school = school;
    }

    public StudentAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    public String getSchool() {
        return this.school;
    }

    @Override
    public void sub(double amount) {
        System.out.println("Sub amount is " + amount);

        double newBalance = this.balance - amount;

        if (newBalance < -5000) {
            throw new RuntimeException("Balance cannot go below -5000");
        }

        this.balance = newBalance;
    }
}