package com.java.main;

import com.java.dao.AgentDao;
import com.java.dao.AgentDaoImpl;
import com.java.exam.Agent;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAgentMain {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Agent Id:");
    int agentId=sc.nextInt();
    AgentDao agentDao=new AgentDaoImpl();
    try {
       Agent agent=agentDao.searchAgentdao(agentId);
       if(agent!=null){
         System.out.println(agent);
       }else{
         System.out.println("Agent not found");
       }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
