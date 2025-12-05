package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int empno;
    System.out.print("Enter empno : ");
    empno = sc.nextInt();
    String cmd="delete from Employ where empno = ?";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa","root","root");
      PreparedStatement pst=con.prepareStatement(cmd);
      pst.setInt(1, empno);
      pst.executeUpdate();
      System.out.println("Employ deleted successfully");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
