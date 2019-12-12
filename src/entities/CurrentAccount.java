package entities;

public class CurrentAccount implements IBankAccount {

    private Double accountBalance;
    private Double interestOnBalance;

    public CurrentAccount(Double accountBalance, Double interestOnBalance) {
        this.accountBalance = accountBalance;
        this.interestOnBalance = interestOnBalance;
    }

    @Override
    public void withdraw(double money) {
        if(accountBalance > 0) {
            accountBalance -= money;

        }
    }

    @Override
    public void fund(double money) {
        accountBalance+=money;
    }

    @Override
    public void transfer(IBankAccount account1, IBankAccount account2, double money) {
        account1.withdraw(money);
        account2.fund(money);
    }

    public void charge(){
        //TODO
    }

}
