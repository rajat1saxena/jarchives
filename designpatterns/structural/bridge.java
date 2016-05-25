package structural;

/**
* Representative of "Bridge Design Pattern".
*
* Suppose we have a graphical kit which can draw
* colored shapes. We have three colors i.e Red, Green,
* Blue which can be ported to any shape.
*
* Now, we want to create two shapes i.e Rectangle and 
* Circle. So we want all possible combinations of shapes
* and colors. If we were to design it without a pattern
* it will lead to 3*2=6 classes. Using this pattern, it
* will lead to 3+2=5 classes (1 less class).
*/

interface Graphics {
	void draw();
}

// Concrete implementation for Blue
class BlueGraphics implements Graphics {
	@Override public void draw() {
		System.out.println("using Blue graphics");
	}
}
// Concrete implementation for Green 
class GreenGraphics implements Graphics {
	@Override public void draw() {
		System.out.println("using Green graphics");
	}
}
// Concrete implementation for Red
class RedGraphics implements Graphics {
	@Override public void draw() {
		System.out.println("using Red graphics");
	}
}

// This is the "abstraction" class, as mentioned in
// the study materials all over the internet.
//
// This class follows "prefer composition over inheritance"
abstract class Shape {
	protected Graphics graphics;

	public Shape(Graphics graphics) {
		this.graphics = graphics;
	}

	// this method looks similar to one enforced by 'Graphics'
	// interface
	abstract void draw();
}

// Concrete implementation of Shape for Rectangle
final class Rectangle extends Shape {
	public Rectangle(Graphics graphics) {
		super(graphics);
	}
	
	// class specific implementation of draw()
	void draw() {
		System.out.print("Rectangle ");
		graphics.draw();
	}
}
// Concrete implementation of Shape for Circle 
final class Circle extends Shape {
	public Circle(Graphics graphics) {
		super(graphics);
	}
	
	// class specific implementation of draw()
	void draw() {
		System.out.print("Circle ");
		graphics.draw();
	}
}

class Bridge {
	public static void main(String args[]) {
		Shape s = new Rectangle(new RedGraphics());
		s.draw();		
		s = new Circle(new BlueGraphics());
		s.draw();		
	}
}
