package com.java.service;

import com.java.exception.InsufficientBalanceException;
import com.java.exception.InvalidAmountException;
import com.java.exception.InvalidNameException;
import com.java.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, Account> accounts=new HashMap<>();
    public Account createAccount(String name) throws InvalidNameException {
        Account acc=new Account(name);
        accounts.put(acc.getAccountNumber(), acc);
        return acc;

    }
    public Account getAccount(String  accNo) throws AccountNotFoundException {
        if(!accounts.containsKey(accNo)){
            throw new AccountNotFoundException("Account not found "+accNo);
        }
        return accounts.get(accNo);
    }
    public void deposit(String accNo, double amount) throws AccountNotFoundException , InvalidAmountException {
        Account acc=getAccount(accNo);
        acc.deposit(amount);
    }
    public void withdraw(String accNo, double amount) throws AccountNotFoundException, InvalidAmountException , InsufficientBalanceException {
        Account acc=getAccount(accNo);
        acc.withdraw(amount);
    }
    public void transfer(String from , String to , double amount) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Account fromAccount=getAccount(from);
        Account toAccount=getAccount(to);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
    public void showBalance(String accNo) throws AccountNotFoundException {
        System.out.println(getAccount(accNo));

    }
    public void showAllAccounts(){
        accounts.values().forEach(System.out::println);
    }
}
