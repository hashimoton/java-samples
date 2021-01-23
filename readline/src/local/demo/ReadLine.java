package local.demo;

import java.util.Scanner;

public class ReadLine{

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input: ");
    String line = scanner.nextLine();
    System.out.println("[" + line + "]");
  }
  
}
