package transfers;

public class TransactionFactory {

    public Transaction createTransaction(String type, double amount) {
        return new Transaction(type, amount);
    }
}