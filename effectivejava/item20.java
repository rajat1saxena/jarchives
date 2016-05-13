/**
* Prefer class hierarchies to tagged classes
*/

// Here we will derive all shapes out of one abstract class and establish
// proper class hierarchies among dependent shapes like square.

abstract class Shape {
	// put common fields and methods in this class
	boolean fillState = false;
	abstract double area();
}

// Note that this class in concrete and allows subclasses as it is not 
// marked 'final'
class Circle extends Shape {
	private final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	// accessor method
	double getRadius() {
		return radius;
	}

	@Override double area() {
		return 3.14 * radius * radius;
	}
}

class Rectangle extends Shape {
	private final double width;
	private final double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	// accessor method
	double getWidth() {
		return width;
	}
	double getHeight() {
		return height;
	}

	@Override double area() {
		return width * height;
	}
}

// This is the concrete final subclass of Rectangle
final class Square extends Rectangle {
	Square(double side) {
		super(side, side); // calling super class constructor
	}
}

class item20 {
	public static void main(String[] args) {
		if ((new Square(20.03)).fillState) {
			System.out.println("Square is filled");
		} else {
			System.out.println("Square is empty");
		}
	}
}