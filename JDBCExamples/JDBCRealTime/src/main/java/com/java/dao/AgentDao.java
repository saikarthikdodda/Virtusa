package com.java.dao;


import com.java.exam.Agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDao {
  List<Agent> showAgentdao() throws SQLException, ClassNotFoundException;
  String addAgentdao(Agent agent) throws SQLException, ClassNotFoundException;
  String updateAgentdao(Agent agent) throws SQLException, ClassNotFoundException;
  String deleteAgentdao(int agentId) throws SQLException, ClassNotFoundException;
  Agent searchAgentdao(int agentId) throws SQLException, ClassNotFoundException;
}
