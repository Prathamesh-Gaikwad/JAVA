import java.util.Scanner;

interface Operation
{
	public static final float PI = 3.14f;
	
	public abstract float volume();
}

class Cylinder implements Operation
{
	float radius;
	float height;
	
	Cylinder(float fRadius, float fHeight)
	{
		radius = fRadius;
		height = fHeight;
	}
	
	public float volume()
	{
		return (4/3)*PI*(radius*radius)*height;
	}
	
	public static void main(String args[])
	{
		Cylinder cylinder = new Cylinder(2.34f, 7.6f);
		
		System.out.println("Volume : " + cylinder.volume());
	}
}

