package accounts.serialization;

import accounts.BankAccount;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BankAccountGsonSerealizationService implements BankAccountSerealization {

    private final BankAccountSerializeFactory bankAccountSerializeFactory;
    private final Gson gson;

    public BankAccountGsonSerealizationService(BankAccountSerializeFactory bankAccountSerializeFactory, Gson gson) {
        this.bankAccountSerializeFactory = bankAccountSerializeFactory;
        this.gson = gson;
    }

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        List<BankAccountSerialize> bankAccountsSerialize = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            bankAccountsSerialize.add(bankAccountSerializeFactory.createBankAccountSerialize(bankAccount));
        }

        return gson.toJson(bankAccountsSerialize);
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        return gson.toJson(bankAccountSerialize);
    }
}