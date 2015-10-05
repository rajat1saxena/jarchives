/*
 * This program demonstrate uses of System.in/out/err
 */

import java.io.*;

class sysInOutErr{
  public static void main(String args[]) throws IOException{
    BufferedReader in = null;
   
    String c;
 
    try{
      in  = new BufferedReader(new InputStreamReader(System.in)); //InputStreamReader converts System.in(byte stream) into character stream
      
      while((c=in.readLine()) != null){
        System.out.println(c);
      }
    }finally{
      if(in!=null){
        in.close();
      }
    }
    
  }
}