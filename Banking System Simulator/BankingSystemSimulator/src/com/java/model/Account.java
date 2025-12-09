package com.java.model;

import com.java.exception.InsufficientBalanceException;
import com.java.exception.InvalidAmountException;
import com.java.exception.InvalidNameException;

import java.util.Random;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;

    public Account(String name) throws InvalidNameException{
        if(name==null||name.trim().isEmpty()){
            throw new InvalidNameException("Name cannot be empty");
        }
        this.name = name;
        this.balance = 0;
        this.accountNumber = generateAccountNumber(name);
    }
    private String generateAccountNumber(String name){
        String initials=name.substring(0, 2).toUpperCase();
        int random=new Random().nextInt(9000)+1000;
        return initials+random;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) throws InvalidAmountException {
        if(amount<=0){
            throw new InvalidAmountException("Amount cannot be negative or Zero");
        }
        balance += amount;
    }



    public void withdraw(double amount)  throws InvalidAmountException ,InsufficientBalanceException{
        if(amount<=0){
            throw new InvalidAmountException("Withdraw Amount cannot be negative or Zero");
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Withdraw Amount cannot be greater than Balance");
        }
        balance -= amount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

}
