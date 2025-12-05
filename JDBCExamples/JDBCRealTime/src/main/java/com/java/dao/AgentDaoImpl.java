package com.java.dao;

import com.java.exam.Agent;
import com.java.exam.Gender;
import com.java.util.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgentDaoImpl implements AgentDao{
    Connection conn = null;
    PreparedStatement pst = null;


  @Override
  public List<Agent> showAgentdao() throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd="select * from Agent";
    pst= conn.prepareStatement(cmd);
    ResultSet rs=pst.executeQuery();
    List<Agent> agentList=new ArrayList<Agent>();
    while(rs.next()){
       Agent  agent=new Agent();
        agent.setAgentId(rs.getInt("agentID"));
        agent.setName(rs.getString("name"));
        agent.setCity(rs.getString("city"));
        agent.setGender(Gender.valueOf(rs.getString("gender")));
        agent.setMaritalStatus(rs.getInt("maritalStatus"));
        agent.setPremium(rs.getInt("premium"));
        agentList.add(agent);
    }

     return agentList;
  }

  @Override
  public String addAgentdao(Agent agent) throws SQLException, ClassNotFoundException {
    String cmd="insert into Agent  (AgentId,Name,City,Gender,MaritalStatus,Premium) values (?,?,?,?,?,?)";
    conn = ConnectionHelper.getConnection();
    pst=conn.prepareStatement(cmd);
    pst.setInt(1, agent.getAgentId());
    pst.setString(2, agent.getName());
    pst.setString(3, agent.getCity());
    pst.setString(4, agent.getGender().toString());
    pst.setInt(5, agent.getMaritalStatus());
    pst.setDouble(6,agent.getPremium());
    pst.executeUpdate();
    return "Record Inserted";
  }

  @Override
  public String updateAgentdao(Agent agent) throws SQLException, ClassNotFoundException {

    String cmd="update Agent set Name=?,City=?,Gender=?,MaritalStatus=?,Premium=? where AgentId=?";
    conn = ConnectionHelper.getConnection();
    pst=conn.prepareStatement(cmd);
    pst.setString(1, agent.getName());
    pst.setString(2, agent.getCity());
    pst.setString(3, agent.getGender().toString());
    pst.setInt(4, agent.getMaritalStatus());
    pst.setDouble(5,agent.getPremium());
    pst.setInt(6, agent.getAgentId());
    pst.executeUpdate();

    return "Record Updated";
  }

  @Override
  public String deleteAgentdao(int agentId) throws SQLException, ClassNotFoundException {
    String cmd="delete from Agent where AgentId=?";
    conn = ConnectionHelper.getConnection();
    pst=conn.prepareStatement(cmd);
    pst.setInt(1,agentId);
    pst.executeUpdate();
    return "Record Deleted";
  }

  @Override
  public Agent searchAgentdao(int agentId) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String cmd="select * from Agent where AgentId=?";
    pst=conn.prepareStatement(cmd);
    pst.setInt(1, agentId);
    ResultSet rs=pst.executeQuery();
    Agent agent=null;

    if(rs.next()){
      agent=new  Agent();
      agent.setAgentId(rs.getInt("AgentId"));
      agent.setName(rs.getString("Name"));
      agent.setCity(rs.getString("City"));
      agent.setGender(Gender.valueOf(rs.getString("Gender")));
      agent.setMaritalStatus(rs.getInt("MaritalStatus"));
      agent.setPremium(rs.getInt("Premium"));

    }
    return agent;
  }
}
