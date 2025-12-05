package com.java.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
  public static void main(String[] args)  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter empno");
    int empno=sc.nextInt();
    System.out.println("Enter name");
    String name=sc.next();
    System.out.println("Enter gender");
    String gender=sc.next();
    System.out.println("Enter dept");
    String dept=sc.next();
    System.out.println("Enter desig");
    String desig=sc.next();
    System.out.println("Enter basic");
    double basic=sc.nextDouble();
    String cmd="insert into Employ(empno,name,gender,dept,desig,basic) values(?,?,?,?,?,?)";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa","root","root");
      PreparedStatement pst=con.prepareStatement(cmd);
      pst.setInt(1,empno);
      pst.setString(2,name);
      pst.setString(3,gender);
      pst.setString(4,dept);
      pst.setString(5,desig);
      pst.setDouble(6,basic);
      pst.executeUpdate();
      System.out.println("Employ has been inserted");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
