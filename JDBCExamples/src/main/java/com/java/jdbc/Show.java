package com.java.jdbc;

import java.sql.*;

public class Show {
  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/virtusa","root","root");
      String cmd="select * from employ";
      PreparedStatement ps=con.prepareStatement(cmd);
      ResultSet rs=ps.executeQuery();
      while(rs.next()){
        System.out.println("empno is : "+rs.getInt("empno"));
        System.out.println( "ename is  : "+rs.getString("name"));
        System.out.println("gender is  : "+rs.getString("gender"));
        System.out.println("dept is  : "+rs.getString("dept"));
        System.out.println("designation is  : "+rs.getString("desig"));
        System.out.println("basic is  : "+rs.getDouble("basic"));
        System.out.println("-------------------------");
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
