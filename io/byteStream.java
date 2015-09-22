/*
* Writes a new file from this java file using Byte Stream
*
* Note: All byte stream classes are descended from InputStream and OutputStream.
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class byteStream{
  public static void main(String args[]) throws IOException{
    FileInputStream in = null;
    FileOutputStream out = null;
    
    try{
      in = new FileInputStream("byteStream.java");
      out = new FileOutputStream("output.txt");
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