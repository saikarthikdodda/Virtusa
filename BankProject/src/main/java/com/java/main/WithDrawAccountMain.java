package com.java.main;

import com.java.dao.BankDao;
import com.java.dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class WithDrawAccountMain {
  public static void main(String[] args) {
    double amount;
    int accountNo;
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Account No:");
    accountNo = sc.nextInt();

    System.out.println("Enter Amount to Withdraw  :");
    amount = sc.nextDouble();


    BankDao dao = new BankDaoImpl();
    try {
      System.out.println(dao.withdrawAccount(accountNo,amount ));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
