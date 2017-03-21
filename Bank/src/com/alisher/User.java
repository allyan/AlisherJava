package com.alisher;


public class User {

    private String name;
    private static int accountNumber = 1;
    private int balance;
    private int accountNum;

    public int getAccountNum() {
        return accountNum;
    }

    public User(String name) {
        this.name = name;
        accountNum = accountNumber++;
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + " $" + balance;
    }

}
