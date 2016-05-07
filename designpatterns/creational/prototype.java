package creational;

/*
* Demonstration of Prototype pattern
* This pattern must provide clone() method to easily reproduce object
*/
import java.util.*;

abstract class Shape implements Cloneable{
	private String name;

	abstract void draw();

	// setter
	public void setName(String name){
		this.name = name;
	}

	// getters
	public String getName(){
		return this.name;
	}

	@Override
	public Object clone(){
		Object clone = null;
		try{
			clone = super.clone();
		}catch(CloneNotSupportedException e){
			System.out.println("Cloning not supported");
		}

		return clone;
	}
}

// concrete classes
class Circle extends Shape{
	public Circle(){
		// name = "Circle";
		super.setName("Circle");
	}

	@Override
	public void draw(){
		System.out.println("Circle drawn");
	}
}
class Rectangle extends Shape{
	public Rectangle(){
		// name = "Rectangle";
		super.setName("Rectangle");
	}
	
	@Override
	public void draw(){
		System.out.println("Rectangle drawn");
	}
}
class Square extends Shape{
	public Square(){
		// name = "Square";
		super.setName("Square");
	}
	
	@Override
	public void draw(){
		System.out.println("Square drawn");
	}
}

// Prototype provider :: this class helps us in getting clonable objects
class ShapeCache{
	// We could have used HashTable here as well, which is thread-safe and does not allow nulls
	private static HashMap<String, Shape> cachedShapes = new HashMap<String, Shape>();

	public static Shape getItem(String id){
		Shape shape = cachedShapes.get(id);
		return (Shape)shape.clone(); // main step of this pattern
	}

	public static void loadCache(){
		// Create instances of all 3 concrete classes and store it for later user
		cachedShapes.put("circle", new Circle());
		cachedShapes.put("rectangle", new Rectangle());
		cachedShapes.put("square", new Square());
	}
}

public class prototype{
	public static void main(String args[]){
		// load all shapes into cache 
		// without this step you will get NPE
		ShapeCache.loadCache();

		// create any shape using ShapeCache
		Circle circle = (Circle)ShapeCache.getItem("circle");
		circle.draw();

		Square square = (Square)ShapeCache.getItem("square");
		square.draw();
	}
}

