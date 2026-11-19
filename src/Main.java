import accounts.BankAccount;
import accounts.services.IAccountService;
import creditCards.CreditCard;
import people.Owner;
import people.services.OwnerService;
import transfers.TransferService;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();

        OwnerService ownerService = container.getOwnerService();
        IAccountService accountService = container.getAccountService();
        TransferService transferService = container.getTransferService();

        Owner owner = ownerService.createOwner("Matous", "Kunvalsky");

        BankAccount bankAccount = accountService.createCurrentAccount(owner, 1000);
        BankAccount studentAccount = accountService.createStudentAccount(owner, 100, "DELTA");

        System.out.println("Cislo uctu: " + bankAccount.getAccountNumber());

        transferService.withdraw(bankAccount, 500);
        transferService.addToBalance(bankAccount, 300);
        System.out.println("balance: " + bankAccount.getBalance());

        CreditCard creditCard = new CreditCard(owner, 500);
        transferService.withdraw(creditCard, 100);
    }
}