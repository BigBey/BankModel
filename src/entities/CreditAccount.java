package entities;

import utils.Pair;

public class CreditAccount implements IBankAccount{

    private Double accountBalance;
    private Double debt;
    private Pair<Double, Double> creditLimit;
    private Double commission;


    @Override
    public void withdraw(double money) {
        if(accountBalance - money > 0){
            accountBalance -= money;
            debt += money;
        }else if(accountBalance - money >= creditLimit.first){
            accountBalance -= money;
            debt += money*(1 + commission);
        }else{
            System.out.println("You can't withdraw money, because your limit is reached");
        }
    }

    @Override
    public void fund(double money) {
        accountBalance += money;
    }

    @Override
    public void transfer(IBankAccount account, double money) {

    }
}
