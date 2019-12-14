package creators;

import entities.Bank;
import entities.BankAccount;
import entities.Client;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class AccountCreator {

    public void linkNewAccountToClient(Bank bank, String fullName, double money){
        BankAccount bankAccount = createAccount(bank, money);
        if(bankAccount != null) {
            String[]  name = fullName.split(" ");
            bank.findClient(name[0], name[1]).addAccount(bankAccount.getAccountNumber());
            bank.addAccount(bankAccount);
        }
    }

    public abstract BankAccount createAccount(Bank bank, double startBalance);
}
