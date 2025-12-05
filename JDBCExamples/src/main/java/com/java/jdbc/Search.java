package com.java.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Search {
  public static void main(String[] args) {
    int empno;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter empno : ");
    empno = sc.nextInt();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa","root","root");
      String cmd= "select * from employ where empno = ?";
      PreparedStatement pst=con.prepareStatement(cmd);
      pst.setInt(1, empno);
      ResultSet rs=pst.executeQuery();
      if(rs.next()){
        System.out.println("Emp no : "+rs.getInt("empno"));
        System.out.println("Name : "+rs.getString("name"));
        System.out.println(" gender: "+rs.getString("gender"));
        System.out.println(" dept : "+rs.getString("dept"));
        System.out.println("desig : "+rs.getString("desig"));
        System.out.println(" basic : "+rs.getDouble("basic"));


      }else{
        System.out.println("employ not found");
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
