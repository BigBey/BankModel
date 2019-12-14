package entities;

import java.util.Date;

public class DebitAccount extends BankAccount{

    private Double interestOnBalance;
    private Date checkDate;
    private Double addingAmount;

    public DebitAccount(Double accountBalance, Integer accountNumber, Double interestOnBalance) {
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.interestOnBalance = interestOnBalance;
    }

    @Override
    public boolean withdraw(double money) {
        if(accountBalance - money > 0) {
            accountBalance -= money;
            return true;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
            return false;
        }
    }

    @Override
    void fund(double money) {
        accountBalance+=money;
    }

    public void charge(){
        if ((new Date()).getMonth() !=  checkDate.getMonth()){
            accountBalance += addingAmount;
            addingAmount = 0.0;
        }
        if(checkDate.equals(new Date())){
            addingAmount += accountBalance * (interestOnBalance/365);
        }
        checkDate = new Date();
    }

}
