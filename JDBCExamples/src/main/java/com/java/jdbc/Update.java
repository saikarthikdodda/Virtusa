package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter empno");
    int empno = sc.nextInt();
    System.out.println("Enter ename");
    String name = sc.next();
    System.out.println("Enter gender");
    String gender = sc.next();
    System.out.println("Enter dept");
    String dept = sc.next();
    System.out.println("Enter desig");
    String desig = sc.next();
    System.out.println("Enter basic");
    double basic = sc.nextDouble();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa","root","root");
      String cmd="update   Employ set name =?,gender=?,dept=?,desig=?,basic=? where empno=?";
      PreparedStatement pst=con.prepareStatement(cmd);
      pst.setString(1,name);
      pst.setString(2,gender);
      pst.setString(3,dept);
      pst.setString(4,desig);
      pst.setDouble(5,basic);
      pst.setInt(6,empno);
      pst.executeUpdate();
      System.out.println("Updated");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
