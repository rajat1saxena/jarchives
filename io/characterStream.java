/*
* Writes a new file from this java file using Character Stream
*
* Note: All character stream classes are descended from Reader and Writer.
*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class characterStream{
  public static void main(String args[]) throws IOException{
    FileReader in = null;
    FileWriter out = null;
    
    try{
      in = new FileReader("byteStream.java");
      out = new FileWriter("output.txt");
      int c;
      
      while((c = in.read()) != -1){
        out.write(c);
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