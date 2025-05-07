import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Circle extends MouseAdapter
{
	JFrame frame;
	
	Circle()
	{
		frame = new JFrame("[CONCENTRIC-CIRCLE]");

		frame.setLayout(new FlowLayout());
		
		frame.addMouseListener(this);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);		
	}
	
	public void mouseClicked(MouseEvent event)
	{
		int x = event.getX();
		int y = event.getY();
		
		frame.getGraphics().clearRect(0, 0, frame.getWidth(), frame.getHeight());
		drawConcentricCircles(x, y);
	}
	
	public void drawConcentricCircles(int x, int y)
	{
		Graphics graphic = frame.getGraphics();
		
		graphic.setColor(Color.RED);
		graphic.fillOval(x-50, y-50, 100, 100);

		graphic.setColor(Color.BLUE);
		graphic.fillOval(x-35, y-35, 70, 70);

		graphic.setColor(Color.ORANGE);
		graphic.fillOval(x-20, y-20, 40, 40);
		
	}
	
	public static void main(String args[])
	{
		new Circle();
	}
}

