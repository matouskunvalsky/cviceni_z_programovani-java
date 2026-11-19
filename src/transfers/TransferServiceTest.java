package transfers;

import accounts.BusinessAccount;
import accounts.CurrentAccount;
import accounts.StudentAccount;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import people.Owner;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {

    private static final double DELTA = 0.001;

    private TransferService transferService;
    private Owner owner;

    @BeforeEach
    public void setUp() {
        Notifier notifier = new ConsoleNotifier();
        TransferLoggerService loggerService = new TransferLoggerService();
        TransactionFactory transactionFactory = new TransactionFactory();

        transferService = new TransferService(notifier, loggerService, transactionFactory);
        owner = new Owner("Zdenek", "Slezak");
    }

    // ... zbytek testů zůstává beze změny
}