/*
 * This class demonstrates formatting
 */

import java.io.*;

class formatting{
  public static void main(String args[]){
    int i=2;
    
    // hexadecimal
    System.out.format("%x%n",i);
    // decimal
    System.out.format("%d%n",i);
    // string
    System.out.format("%s%n",i);
    // floating
    System.out.format("%f%n",Float.valueOf(i));
    
  }
}