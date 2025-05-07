import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MouseEventDemo extends JFrame implements MouseListener, MouseMotionListener
{
	String msg;
	JTextField textField;
	
	MouseEventDemo()
	{
		textField = new JTextField(80);
		
		setLayout(new FlowLayout());
		
		add(textField);

		addMouseListener(this);
		addMouseMotionListener(this);
		
		setSize(300, 400);
		setVisible(true);
		setTitle("Mouse-Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//MouseListener Implementation
	public void mouseClicked(MouseEvent event)
	{
		msg = "Mouse clicked at X[CO-ORDINATE] = " + event.getX() + " Y[CO-ORDINATE] = " + event.getY();
		textField.setText(msg);		
	}

	public void mouseEntered(MouseEvent event)
	{
		//inteface implementation hence need to defined like this	
	}

	public void mouseExited(MouseEvent event)
	{
		//inteface implementation hence need to defined like this
	}

	public void mousePressed(MouseEvent event)
	{
		//inteface implementation hence need to defined like this
	}

	public void mouseReleased(MouseEvent event)
	{
		//inteface implementation hence need to defined like this
	}
	
	//MouseMotionListener Implementation
	public void mouseMoved(MouseEvent event)
	{
		msg = "Mouse moved at X[CO-ORDINATE] = " + event.getX() + " Y[CO-ORDINATE] = " + event.getY();
		textField.setText(msg);		
	}
	
	public void mouseDragged(MouseEvent event)
	{
		//inteface implementation hence need to defined like this
	}
	
	//main method	
	public static void main(String args[])
	{
		new MouseEventDemo();
	}
}

