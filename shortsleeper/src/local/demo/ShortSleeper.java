package local.demo;

public class ShortSleeper {

  public static void main(String[] args)
  {
    System.out.println("Good night");
    try {
      Thread.sleep(60*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Good morning");
  }
  
}
