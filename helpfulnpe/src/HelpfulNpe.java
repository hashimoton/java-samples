import java.util.HashMap;

public class HelpfulNpe {

  public static void main(String[] args)
  {
    int i = 1;
    String str = "foo";
    HashMap<String, String> map = null;
    String value = map.get("key");
    System.out.println(value);
  }
  
}
