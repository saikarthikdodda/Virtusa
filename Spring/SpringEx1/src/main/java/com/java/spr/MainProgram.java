package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainProgram {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    HelloImpl helloWorld = (HelloImpl) context.getBean("bean1");
    System.out.println(helloWorld.sayHello("  Iam"));
  }
}
