package entities;

import utils.Utils;

import java.time.Month;
import java.time.YearMonth;
import java.util.Date;

public class DepositAccount extends BankAccount{

    private Double interestOnBalance;
    private Date expirationDate;
    private Date checkDate;
    private Double addingAmount;

    public DepositAccount(Double accountBalance, Integer accountNumber, Double interestOnBalance, Date expirationDate) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.interestOnBalance = Utils.getInterestOnBalance(accountBalance);
        this.expirationDate = expirationDate;
        this.checkDate = new Date();
        addingAmount = 0.0;
    }

    @Override
    public boolean withdraw(double money) {
        if((new Date()).before(expirationDate)) {
            System.out.println("You can't withdraw money, because it is deposit account");
            return false;
        }else if(accountBalance - money > 0){
            accountBalance -= money;
            return true;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
            return false;
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
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
