package transfers;

import java.util.ArrayList;
import java.util.List;

public class TransferLoggerService {

    private List<Transaction> transactions = new ArrayList<>();

    public void logTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        System.out.println("Zaevidovanaa transakce: " + transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}