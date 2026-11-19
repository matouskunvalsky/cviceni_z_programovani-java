package accounts.factories;

import accounts.BankAccount;
import accounts.BusinessAccount;
import accounts.CurrentAccount;
import accounts.SavingAccount;
import accounts.StudentAccount;
import accounts.services.AccountNumberGenerator;
import people.Owner;

import java.util.UUID;

public class BankAccountFactory {

    private final AccountNumberGenerator numberGenerator;

    public BankAccountFactory(AccountNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public BankAccount createCurrentAccount(Owner owner, double balance) {
        CurrentAccount account = new CurrentAccount(owner, balance);
        account.setUuid(UUID.randomUUID().toString());
        account.setAccountNumber(numberGenerator.generate());
        return account;
    }

    public BankAccount createStudentAccount(Owner owner, double balance, String school) {
        StudentAccount account = new StudentAccount(owner, school);
        account.setNewBalance(balance);
        account.setUuid(UUID.randomUUID().toString());
        account.setAccountNumber(numberGenerator.generate());
        return account;
    }

    public BankAccount createSavingAccount(Owner owner, double balance) {
        SavingAccount account = new SavingAccount(owner, balance);
        account.setUuid(UUID.randomUUID().toString());
        account.setAccountNumber(numberGenerator.generate());
        return account;
    }

    public BankAccount createBusinessAccount(Owner owner, double balance) {
        BusinessAccount account = new BusinessAccount(owner, balance);
        account.setUuid(UUID.randomUUID().toString());
        account.setAccountNumber(numberGenerator.generate());
        return account;
    }
}