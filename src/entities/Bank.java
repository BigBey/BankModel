package entities;

import utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private final String title;
    private final HashMap<String, Client> clients;
    private final HashMap<String, BankAccount> accounts;
    private final Double interestOnBalance;
    private final ArrayList<Pair<Pair<Double, Double>,Double>> depositChoices;
    private final Integer depositPeriod;
    private final Double commission;
    private final Pair<Double, Double> creditLimit;
    private final Pair<Double, Double> safeLimit;

    public Bank(String title, Double interestOnBalance, ArrayList<Pair<Pair<Double, Double>, Double>> depositChoices,
                Integer depositPeriod, Double commission, Pair<Double, Double> creditLimit, Pair<Double, Double> safeLimit) {
        this.title = title;
        this.clients = new HashMap<>();
        this.accounts = new HashMap<>();
        this.interestOnBalance = interestOnBalance;
        this.depositChoices = depositChoices;
        this.depositPeriod = depositPeriod;
        this.commission = commission;
        this.creditLimit = creditLimit;
        this.safeLimit = safeLimit;
    }

    public void addClient(Client client){
        clients.put(client.getSurname() + client.getName(), client);
    }

    public Client findClient(String surname, String name){
        return clients.get(surname + name);
    }

    public void addAccount(BankAccount account){
        accounts.put(account.accountNumber.toString(), account);
    }

    BankAccount findAccount(Integer accountNumber){
        return accounts.get(accountNumber.toString());
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

    public HashMap<String, BankAccount> getAccounts() {
        return accounts;
    }

    public Double getInterestOnBalance() {
        return interestOnBalance;
    }

    public ArrayList<Pair<Pair<Double, Double>, Double>> getDepositChoices() {
        return depositChoices;
    }

    public Double getCommission() {
        return commission;
    }

    public Pair<Double, Double> getCreditLimit() {
        return creditLimit;
    }

    public Pair<Double, Double> getSafeLimit() {
        return safeLimit;
    }

    public Integer getDepositPeriod() {
        return depositPeriod;
    }
}
