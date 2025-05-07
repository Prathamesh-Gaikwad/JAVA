import java.awt.*;
class BorderLayout_try extends Frame
{
	Button East;
	Button West;
	Button North;
	Button South;
	Button Center;
	TextField name;
	TextField pass;
	BorderLayout refBL;
	
	BorderLayout_try(String Param)
	{
		super(Param);	//?
		
		setVisible(true);
		
		setSize(500, 500);
		
		refBL = new BorderLayout(100,50);
		/**
			ABOVE(21) : first parameter is horizontal space and second is vertical space between components...
		*/
		setLayout(refBL);
		
		East = new Button("East");
		West = new Button("West");
		North = new Button("North");
		South = new Button("South");
		Center = new Button("Center");
		
		add(East, BorderLayout.EAST);
		add(West, BorderLayout.WEST);
		add(North, BorderLayout.NORTH);
		add(South, BorderLayout.SOUTH);
		add(Center, BorderLayout.CENTER);
	}
	
	public static void main(String args[])
	{
		BorderLayout_try refBLt = new BorderLayout_try("BorderLayout JAVA");
	}
}

