package entities;

import java.util.Date;

public class DebitAccount implements IBankAccount {

    private Double accountBalance;
    private Double interestOnBalance;
    private Date checkDate;
    private Double addingAmount;

    public DebitAccount(Double accountBalance, Double interestOnBalance) {
        this.accountBalance = accountBalance;
        this.interestOnBalance = interestOnBalance;
    }

    @Override
    public void withdraw(double money) {
        if(accountBalance - money > 0) {
            accountBalance -= money;
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
        }
    }

    @Override
    public void fund(double money) {
        accountBalance+=money;
    }

    @Override
    public void transfer(IBankAccount account, double money) {
        if( accountBalance > 0) {
            this.withdraw(money);
            account.fund(money);
        }else{
            System.out.println("You can't withdraw money, because insufficient funds");
        }
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
