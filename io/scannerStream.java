/*
 * This class demonstrates the concept of buffered read, one word at a time
 */
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileReader;
import java.io.BufferedReader;

class scannerStream{
  public static void main(String args[]) throws IOException{
    Scanner s=null;
    
    try{
      // the following is a valid statement, I put that mistakenly but it worked out
      // s = new Scanner(new FileReader("scannerStream.java"));
      
      // According to the Oracle documentation
      s = new Scanner(new BufferedReader(new FileReader("lolfile")));
      
      // user another delimiter
      s.useDelimiter("\\*");
      
      while(s.hasNext()){
        System.out.println(s.next());
      }
      
    }finally{
      if(s!=null){
        s.close();
      }
    }
  }
}