import java.util.Locale;

class locale{
  public static void main(String args[]){
    int x = 40;
    float y = 45.56f;
    String s = "Rajat";
    System.out.format(Locale.FRANCE,"%s : %f",s,y);
  }
}