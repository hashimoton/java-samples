package local.demo;

import com.example.Visitor;

public class Entrance {

  public static void main(String[] args)
  {
    Visitor visitor1 = new Visitor("One");
    System.out.println(visitor1.greet());
  }
  
}
