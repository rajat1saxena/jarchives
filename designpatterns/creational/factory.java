/**
 * Demonstrates Factory design pattern
 */

// The core interface from which individual shapes like circle,rectangle will derive
interface shape{
  void draw();
}

class circle implements shape{
  // remember the method should be marked "public" as in interface the method is public
  @Override
  public void draw(){
    System.out.println("Circle shape drawn");
  }
}

class square implements shape{
  // remember the method should be marked "public" as in interface the method is public
  @Override
  public void draw(){
    System.out.println("Square shape drawn");
  }
}

class rectangle implements shape{
  // remember the method should be marked "public" as in interface the method is public
  @Override
  public void draw(){
    System.out.println("Rectangle shape drawn");
  }
}

// factory class
class shapeFactory{
  shape getShape(String shape){
    switch(shape){
      case "RECTANGLE":
         return new rectangle();
      case "SQUARE":
         return new square();
      case "CIRCLE":
         return new circle();
      default:
         return new circle();
    }
  }
}

// main class, to run the program
class factory{
  public static void main(String args[]){
    // get implementation object of shape interface and then call its member method.
    new shapeFactory().getShape("SQUARE").draw();
  }
}