package creators;

import entities.Bank;
import entities.BankAccount;
import entities.DebitAccount;
import entities.DepositAccount;

public class DebitCreator extends AccountCreator {
    @Override
    public BankAccount createAccount(Bank bank, double startBalance) {
        if(bank.getInterestOnBalance() != null) {
            return new DebitAccount(startBalance, bank.getAccounts().size(), bank.getInterestOnBalance());
        }else{
            System.out.println("This bank hasn't got Debit services");
            return null;
        }
    }
}
