import accounts.decorators.AccountLoggingWithTimeService;
import accounts.factories.BankAccountFactory;
import accounts.services.AccountNumberGenerator;
import accounts.services.AccountService;
import accounts.services.IAccountService;
import notifiers.ConsoleNotifier;
import notifiers.Notifier;
import people.factories.OwnerFactory;
import people.services.OwnerService;
import transfers.TransactionFactory;
import transfers.TransferLoggerService;
import transfers.TransferService;

public class Container {

    private final OwnerService ownerService;
    private final IAccountService accountService;
    private final TransferService transferService;

    public Container() {
        // lide
        OwnerFactory ownerFactory = new OwnerFactory();
        this.ownerService = new OwnerService(ownerFactory);

        // ucty
        AccountNumberGenerator numberGenerator = new AccountNumberGenerator("2010");
        BankAccountFactory bankAccountFactory = new BankAccountFactory(numberGenerator);
        IAccountService baseAccountService = new AccountService(bankAccountFactory);
        this.accountService = new AccountLoggingWithTimeService(baseAccountService);

        // prevvody
        Notifier notifier = new ConsoleNotifier();
        TransferLoggerService loggerService = new TransferLoggerService();
        TransactionFactory transactionFactory = new TransactionFactory();
        this.transferService = new TransferService(notifier, loggerService, transactionFactory);
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public TransferService getTransferService() {
        return transferService;
    }
}