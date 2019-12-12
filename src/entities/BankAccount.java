package entities;

import types.BankAccountType;

public class BankAccount {
    private final BankAccountType type;
    private final Double interestOnBalance;

    public BankAccount(BankAccountType type, Double interestOnBalance) {
        this.type = type;
        this.interestOnBalance = interestOnBalance;
    }

    public BankAccountType getType() {
        return type;
    }

    public Double getInterestOnBalance() {
        return interestOnBalance;
    }
}
