package com.java.main;

import com.java.dao.AgentDao;
import com.java.dao.AgentDaoImpl;
import com.java.exam.Agent;

import java.sql.SQLException;
import java.util.List;

public class ShowAgentMain {
  public static void main(String[] args) {
    AgentDao agentDao=new AgentDaoImpl();
    try {
      List<Agent> agentList=agentDao.showAgentdao();
      agentList.forEach(System.out::println);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
