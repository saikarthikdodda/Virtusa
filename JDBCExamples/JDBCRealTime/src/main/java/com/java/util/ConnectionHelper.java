package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {
  public static Connection getConnection() throws SQLException, ClassNotFoundException {

    String driver =  "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/Exam" ;
    String username =  "root" ;
    String password = "root" ;
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }



}
