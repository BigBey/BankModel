import builders.*;
import creators.AccountCreator;
import creators.DebitCreator;
import creators.DepositCreator;
import entities.Bank;
import entities.BankAccount;

public class Main {

    public static void main(String[] args) {
        BankBuilder bankBuilder = new BankBuilder();
        BankDirector bankDirector = new BankDirector();

        ClientBuilder clientBuilder = new ClientBuilder();
        ClientDirector clientDirector = new ClientDirector();

        AccountCreator accountCreator = new DebitCreator();

        bankDirector.buildSberbank(bankBuilder);
        Bank sberbank = bankBuilder.getResult();
        bankBuilder.reset();

        bankDirector.buildAlfaBank(bankBuilder);
        Bank alfabank = bankBuilder.getResult();
        bankBuilder.reset();

        clientDirector.createFullClient(clientBuilder, "Иван", "Иванов", "Ивановская, 7", "4012 453534");
        clientBuilder.getResult(sberbank);
        clientBuilder.getResult(alfabank);
        clientBuilder.reset();

        accountCreator.linkNewAccountToClient(sberbank, "Иванов Иван", 10000);
        accountCreator = new DepositCreator();
        accountCreator.linkNewAccountToClient(sberbank, "Иванов Иван", 50000);
        System.out.println(sberbank.findClient("Иванов", "Иван").getAccounts().toString());

    }
}
