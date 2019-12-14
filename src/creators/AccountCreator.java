package creators;

import entities.BankAccount;
import entities.Client;

public abstract class AccountCreator {

    public void linkAccountToClient(Client client, BankAccount account){

    }

    public abstract void createAccount();
}
