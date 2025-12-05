package com.java.exam;

public class Agent {

  private int agentId;
  private String name;
  private String city;
  private Gender gender;
  private int maritalStatus;
  private double premium;

  public Agent(){

  }

  public Agent(int agentId, String name, String city, Gender gender, int maritalStatus, double premium) {
    this.agentId = agentId;
    this.name = name;
    this.city = city;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
    this.premium = premium;
  }
  public int getAgentId() {
    return agentId;
  }
  public void setAgentId (int agentId) {
    this.agentId = agentId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public Gender getGender() {
    return gender;
  }
  public void setGender(Gender gender) {
    this.gender = gender;
  }
  public int getMaritalStatus() {
    return maritalStatus;
  }
  public void setMaritalStatus(int maritalStatus) {
    this.maritalStatus = maritalStatus;
  }
  public double getPremium() {
    return premium;
  }
  public void setPremium(double premium) {
    this.premium = premium;
  }
  @Override
  public String toString() {
    return "Agent {AgentId=" + agentId + ", Name=" + name
      + ", City=" + city + ", Gender=" + gender + ", MaritalStatus="
      + maritalStatus + ", Premium=" + premium + "}";

  }

}
