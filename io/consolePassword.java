/*
 * This program demonstrate the use of Console and readPassword which silences the echoing of text 
 */
import java.io.Console;
import java.io.IOException;

class consolePassword{
  public static void main(String args[]){
    Console c = System.console();
    
    if(c == null){
      System.err.println("Console absent");
      System.exit(1);
    }
    
    char[] input;
    String cin = "";
    
    System.out.println("Password required: ");
    
    while(true){
      cin = new String(c.readPassword());
      if(cin.equals("lol")){
        System.out.println("Password correct!");
        break;
      }else{
        System.out.println("Password incorrect");
      }
    }
    
  }
}