package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public interface BankAccountSerealization {

    String serializeAll(List<BankAccount> bankAccounts);

    String serialize(BankAccount bankAccount);
}
