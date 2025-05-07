import java.awt.*;

class BorderLayoutDemo extends Frame
{
	BorderLayoutDemo()
	{
		Button button1 = new Button("EAST");
		Button button2 = new Button("WEST");
		Button button3 = new Button("NORTH");
		Button button4 = new Button("SOUTH");
		Button button5 = new Button("CENTER");
		
		setLayout(new BorderLayout(5, 5));
		
		add(button1, BorderLayout.EAST);
		add(button2, BorderLayout.WEST);
		add(button3, BorderLayout.NORTH);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.CENTER);
		
		setSize(500, 500);
		setVisible(true);
		setTitle("[BORDER-LAYOUT]");
	}
	
	public static void main(String args[])
	{
		new BorderLayoutDemo();
	}
}

