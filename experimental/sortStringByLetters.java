/**
* Sorts characters of any string in alphabetical order
*/
import java.util.Arrays;

class sortStringByLetters{
  public static void main(String[] args) {
    String s = "rajat saxena";
    char[] a= s.toCharArray();
    Arrays.sort(a);
    System.out.println(""+new String(a));
  }
}