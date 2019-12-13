package entities;

public interface IBankAccount {
    void withdraw(double money);
    void fund(double money);
    void transfer(IBankAccount account, double money);
}
