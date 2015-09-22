/*
* Writes a new file from this java file using Character Stream. 
* This is basically line-oriented IO as compared to characterStream.java
*
* Note: All character stream classes are descended from Reader and Writer.
*/
import java.io.FileReader;
import java.io.FileWriter;
// line oriented io reader,writer
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

class characterStreamBuffer{
  public static void main(String args[]) throws IOException{
    BufferedReader in = null;
    PrintWriter out = null;
    
    try{
      in = new BufferedReader(new FileReader("byteStream.java"));
      out = new PrintWriter(new FileWriter("output.txt"));
      
      // NOTICE: 'c' if of type 'String' here as compared to 'int' in-case of character IO
      String c;
      
      while((c = in.readLine()) != null){
        out.println(c);
      }
    }finally{
      if(in != null){
        in.close();
      }
      if(out != null){
        out.close();
      }
    }
    
  }
}