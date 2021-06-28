package com.company;

public class Account {
    private String ID;
    private int balance = 0;

    public Account(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void addBalance(int money) {
        this.balance += money;
    }
    public void displayBalance(){
        System.out.println(this.getBalance());
    }
    public void withdrawBalance(int money){
        if(this.getBalance()>=money)this.balance -= money;
        else System.out.println("Not enough money");
    }
}
