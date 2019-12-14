package entities;

import subject_observer.IObserver;

public abstract class BankAccount implements IObserver {

    protected double accountBalance;
    protected Integer accountNumber;


    public Integer getAccountNumber() {
        return accountNumber;
    }

    abstract boolean withdraw(double money);
    abstract void fund(double money);

    void transfer(BankAccount otherAccount, double money){
        if(this.withdraw(money)){
            otherAccount.fund(money);
        }
    }

    @Override
    public void update() {

    }
}
