package entities;

public abstract class BankAccount {

    protected double accountBalance;
    protected Integer accountNumber;


    public Integer getAccountNumber() {
        return accountNumber;
    }

    abstract boolean withdraw(double money);
    abstract void fund(double money);

    void trasfer(BankAccount otherAccount, double money){
        if(this.withdraw(money)){
            otherAccount.fund(money);
        }
    }
}
