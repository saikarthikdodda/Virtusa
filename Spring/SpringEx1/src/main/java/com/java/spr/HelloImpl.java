package com.java.spr;

public class HelloImpl implements Hello {
  private String greetings;

  public String getGreetings() {
    return greetings;
  }

  public void setGreetings(String greetings) {
    this.greetings = greetings;
  }

  @Override
  public String sayHello(String name) {

    return greetings + name;
  }

}
