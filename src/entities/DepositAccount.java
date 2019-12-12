package entities;

import utils.Utils;

import java.util.Date;

public class DepositAccount implements IBankAccount{

    private Double accountBalance;
    private Double initialAmount;
    private Date expirationDate;

    public DepositAccount(Double accountBalance, Date expirationDate) {
        this.accountBalance = accountBalance;
        this.initialAmount = accountBalance;
        this.expirationDate = expirationDate;
    }

    @Override
    public void withdraw(double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account");
        }else{
            accountBalance -= money;
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
    }

    @Override
    public void transfer(IBankAccount account1, IBankAccount account2, double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account");
        }else{
            account1.withdraw(money);
            account2.fund(money);
        }
    }

    public void charge(){
        if((new Date()).before(expirationDate)){
            accountBalance += accountBalance * Utils.getInterestOnBalance(initialAmount);
        }
    }
}
