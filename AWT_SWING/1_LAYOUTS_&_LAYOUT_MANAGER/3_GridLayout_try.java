import java.awt.*;

public class GridLayout_try extends Frame
{
	GridLayout refGL;
	
	GridLayout_try()
	{
		refGL = new GridLayout(2, 5, 25, 10);	//rows, columns, horizontal space between components, vertical space between components...
		
		setLayout(refGL);
		setTitle("GridLayout JAVA");
		setSize(500, 500);
		setVisible(true);
		
		Button refJB1 = new Button("1");
		Button refJB2 = new Button("2");
		Button refJB3 = new Button("3");
		Button refJB4 = new Button("4");
		Button refJB5 = new Button("5");
		Button refJB6 = new Button("6");
		Button refJB7 = new Button("7");
		Button refJB8 = new Button("8");
		Button refJB9 = new Button("9");
		Button refJB10 = new Button("10");
		
		add(refJB1);
		add(refJB2);
		add(refJB3);
		add(refJB4);
		add(refJB5);
		add(refJB6);
		add(refJB7);
		add(refJB8);
		add(refJB9);
		add(refJB10);
	}
	
	public static void main(String args[])
	{
		GridLayout_try refGLT = new GridLayout_try();
	}
}

