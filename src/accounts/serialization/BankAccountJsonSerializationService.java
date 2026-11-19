package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public class BankAccountJsonSerializationService {

    private final BankAccountSerializeFactory bankAccountSerializeFactory;

    public BankAccountJsonSerializationService(BankAccountSerializeFactory bankAccountSerializeFactory) {
        this.bankAccountSerializeFactory = bankAccountSerializeFactory;
    }

    public String serializeAll(List<BankAccount> bankAccounts) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (BankAccount bankAccount : bankAccounts) {
            builder.append(serialize(bankAccount));
            builder.append(",");
        }

        builder.append("]");

        return builder.toString();
    }

    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"accountNumber\":");
        builder.append("\"");
        builder.append(bankAccountSerialize.bankAccountNumber);
        builder.append("\"");
        builder.append("}");

        return builder.toString();
    }
}