package com.example;

public class Visitor {
  
  private String name;
  
  public Visitor(String name) {
    this.name = name;
  }
  
  public String greet() {
    return "Hello, I am " + name + ".";
  }
}
