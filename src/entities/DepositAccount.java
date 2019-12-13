package entities;

import utils.Utils;

import java.time.Month;
import java.time.YearMonth;
import java.util.Date;

public class DepositAccount implements IBankAccount{

    private Double accountBalance;
    private Double interestOnBalance;
    private Date expirationDate;
    private Date checkDate;
    private Double addingAmount;

    public DepositAccount(Double accountBalance, Double interestOnBalance, Date expirationDate) {
        this.accountBalance = accountBalance;
        this.interestOnBalance = Utils.getInterestOnBalance(accountBalance);
        this.expirationDate = expirationDate;
        this.checkDate = new Date();
        addingAmount = 0.0;
    }

    @Override
    public void withdraw(double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account");
        }else if(accountBalance - money > 0){
            accountBalance -= money;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
    }

    @Override
    public void transfer(IBankAccount account, double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account");
        }else if(accountBalance - money > 0){
            this.withdraw(money);
            account.fund(money);
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
        }
    }

    public void charge(){
        if ((new Date()).getMonth() != checkDate.getMonth()){
            accountBalance += addingAmount;
            addingAmount = 0.0;
        }
        if((new Date()).before(expirationDate) && !checkDate.equals(new Date())){
            addingAmount += accountBalance * (interestOnBalance/365);
        }
        checkDate = new Date();
    }
}
