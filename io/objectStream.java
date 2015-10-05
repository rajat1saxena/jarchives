/*
 * This demonstrate how serialization and object streams work
 */

import java.io.*;

class collar implements Serializable{
  int size;
  String color;
  public collar(int size,String color){
    this.size = size;
    this.color = color;
  }
}
// A 'Dog' has a 'collar'
class Dog implements Serializable{
  //transient collar c; // Note: transient keyword ignore the chain serialization of 'collar'
  transient collar c;
  String breed;
  public Dog(collar c,String breed){
    this.c = c;
    this.breed = breed;
  }
}
class objectStream{
  public static void main(String args[]) throws IOException,ClassNotFoundException{
    FileOutputStream out = null;
    FileInputStream in = null;
    ObjectOutputStream obOut = null;
    ObjectInputStream obIn = null;
    
    Dog dog = new Dog(new collar(78,"red"),"Doberman");
    try{
      // writing 
      out = new FileOutputStream("Dog.ser");
      
      obOut = new ObjectOutputStream(out);
      
      obOut.writeObject(dog);
      obOut.close();
      
      // reading
      in = new FileInputStream("Dog.ser");
      
      obIn = new ObjectInputStream(in);
      
      // Note: readObject returns 'Object' so we will require a type cast here to 'Dog'
      Dog dogIn = (Dog) obIn.readObject();
      
      System.out.println("Dog is '" +dogIn.breed+ "' and has collar with size "+dogIn.c.size);
    }finally{
      if(out!=null){
        out.close();
      }
      if(obOut != null){
        obOut.close();
      }
      if(obIn != null){
        obIn.close();
      }
      if(in != null){
        in.close();
      }
    }
  }
}