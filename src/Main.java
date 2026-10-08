import accounts.BankAccount;
import accounts.CurrentAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import creditCards.CreditCard;
import people.Owner;
import people.OwnerFactory;
import transfers.TransferService;

import java.util.ArrayList;
import java.util.List;


public class Main {




    public static void main(String[] args) {

        TransferService transferService = new TransferService();
        OwnerFactory ownerFactory = new OwnerFactory();



        Owner owner = ownerFactory.createAccountOwner("Matous", "Kunvalsky");

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount bankAccount = new CurrentAccount(owner, 1000);
        accounts.add(bankAccount);

        BankAccount studentAccount = new StudentAccount(owner, 100);
        accounts.add(studentAccount);

        for (BankAccount account : accounts) {
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }


        for (BankAccount account : accounts) {

            if (account instanceof StudentAccount) {
                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("skola: " + overrideAccount.getSchool());
            }
        }

        transferService.withdraw(bankAccount, 500);
        transferService.addToBalance(bankAccount,300);
        transferService.addToBalance(bankAccount,100);
        System.out.println("balance: " + bankAccount.getBalance());


        CreditCard creditCard = new CreditCard(owner, 500);
        transferService.addToBalance(creditCard,1000);
        transferService.withdraw(creditCard,100);



        // transferService.withdraw(bankAccount,500);



        System.out.println("balance: " + bankAccount.getBalance());
    }
}