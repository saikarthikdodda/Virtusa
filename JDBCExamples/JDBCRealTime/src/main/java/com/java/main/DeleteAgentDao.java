package com.java.main;

import com.java.dao.AgentDao;
import com.java.dao.AgentDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAgentDao {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Agent ID");
    int agentId = sc.nextInt();
    AgentDao agentDao = new AgentDaoImpl();
    try {
      System.out.println(agentDao.deleteAgentdao(agentId));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
