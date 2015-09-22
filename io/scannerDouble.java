/*
 * This class calculater sum of doublevalues using Scanner.hasNextDouble()
 */
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileReader;
import java.io.BufferedReader;

class scannerDouble{
  public static void main(String args[]) throws IOException{
    Scanner s=null;
    double sum=0;
    
    try{
      // the following is a valid statement, I put that mistakenly but it worked out
      // s = new Scanner(new FileReader("scannerStream.java"));
      
      // According to the Oracle documentation
      s = new Scanner(new BufferedReader(new FileReader("doublefile")));
      
      // use locale
      // s.useLocale(Locale.US);
      
      while(s.hasNext()){
        while(s.hasNextDouble()){
          sum += s.nextDouble();
        }
      }
      
      System.out.println("Output: "+sum);
      
    }finally{
      if(s!=null){
        s.close();
      }
    }
  }
}