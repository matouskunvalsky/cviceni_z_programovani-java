package accounts.factories;

import accounts.BankAccount;
import accounts.SavingAccount;
import people.Owner;

import java.util.UUID;

public class BankAccountFactory {

    public BankAccount createSavingBankAccount(Owner owner) {

        String uuid = UUID.randomUUID().toString();
        String accountNumber = "";

        return new SavingAccount(uuid, accountNumber, owner);
    }
}