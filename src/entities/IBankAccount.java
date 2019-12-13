package entities;

public interface IBankAccount {
    boolean withdraw(double money);
    void fund(double money);
    void transfer(IBankAccount account, double money);
}
