abstract class Shape
{
	int x;
	int y;
	
	abstract void printArea();
}

class Rectangle extends Shape
{
	Rectangle(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
	
	void printArea()
	{
		System.out.println("\nArea Of Rectangle : " + (x*y));
	}
}

class Triangle extends Shape
{
	Triangle(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
	
	void printArea()
	{
		System.out.println("\nArea Of Traingle : " + (0.5 * (x * y)));
	}
}

class Circle extends Shape
{
	Circle(int _x)
	{
		x = y = _x;
	}
	
	void printArea()
	{
		System.out.println("\nArea Of Circle : " + (3.14 * (x * x)));
	}
}

class Area
{
	public static void main(String args[])
	{
		Rectangle rectangle = new Rectangle(11, 22);
		rectangle.printArea();
		
		Triangle triangle = new Triangle(10, 20);
		triangle.printArea();
		
		Circle circle = new Circle(10);
		circle.printArea();
	}
}

