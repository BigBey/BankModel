package entities;

public interface IBankAccount {
    void withdraw(double money);
    void fund(double money);
    void transfer(IBankAccount account1, IBankAccount account2, double money);
}
