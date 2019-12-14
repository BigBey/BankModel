package entities;

import subject_observer.IObserver;
import utils.Pair;
import utils.Utils;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;

public class DepositAccount extends BankAccount{

    private Double interestOnBalance;
    private Date expirationDate;
    private Date checkDate;
    private Double addingAmount;


    public Double getInterestOnBalance() {
        return interestOnBalance;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public Double getAddingAmount() {
        return addingAmount;
    }

    public DepositAccount(Double accountBalance, Integer accountNumber,
                          ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices, Date expirationDate) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.interestOnBalance = Utils.getInterestOnBalance(depositChoices, accountBalance);
        this.expirationDate = expirationDate;
        this.checkDate = new Date();
        this.addingAmount = 0.0;
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

    @Override
    public void update(){
        if (checkDate.getYear() == new Date().getYear() && checkDate.getMonth() == checkDate.getMonth()
                && checkDate.getDay() == new Date().getDay()){
            accountBalance += addingAmount;
            addingAmount = 0.0;
        }
        if((new Date()).before(expirationDate) && !checkDate.equals(new Date())){
            addingAmount += accountBalance * (interestOnBalance/365);
        }
        checkDate = new Date();
    }
}
