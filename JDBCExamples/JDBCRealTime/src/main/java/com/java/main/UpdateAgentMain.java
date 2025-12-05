package com.java.main;

import com.java.dao.AgentDao;
import com.java.dao.AgentDaoImpl;
import com.java.exam.Agent;
import com.java.exam.Gender;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAgentMain {
  public static void main(String[] args) {
    Agent agent = new Agent();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Agent ID");
    agent.setAgentId(sc.nextInt());
    System.out.println("Enter Agent Name");
    agent.setName(sc.next());
    System.out.println("Enter Agent City");
    agent.setCity(sc.next());
    System.out.println("Enter Gender");
    agent.setGender(Gender.valueOf(sc.next()));
    System.out.println("Enter MaritalStatus");
    agent.setMaritalStatus(sc.nextInt());
    System.out.println("Enter Premium");
    agent.setPremium(sc.nextDouble());

    AgentDao agentDao = new AgentDaoImpl();
    try {
      System.out.println(agentDao.updateAgentdao(agent));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
