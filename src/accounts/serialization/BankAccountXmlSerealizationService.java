package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public class BankAccountXmlSerealizationService implements BankAccountSerealization {

    private final BankAccountSerializeFactory bankAccountSerializeFactory;

    public BankAccountXmlSerealizationService(BankAccountSerializeFactory bankAccountSerializeFactory) {
        this.bankAccountSerializeFactory = bankAccountSerializeFactory;
    }

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        StringBuilder builder = new StringBuilder();
        builder.append("<root>\n");
        builder.append("<accountList>\n");

        for (BankAccount bankAccount : bankAccounts) {
            builder.append(serialize(bankAccount));
        }

        builder.append("</accountList>\n");
        builder.append("</root>\n");

        return builder.toString();
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        StringBuilder builder = new StringBuilder();
        builder.append("<bankAccount>\n");
        builder.append("<number>");
        builder.append(escapeXmlText(bankAccountSerialize.bankAccountNumber));
        builder.append("</number>\n");
        builder.append("</bankAccount>\n");

        return builder.toString();
    }

    private String escapeXmlText(String text) {
        return String.valueOf(text)
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}