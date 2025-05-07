import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MouseEventDemo extends JFrame
{
	String msg;
	
	MouseEventDemo()
	{
		addMouseListener(new MyMouseAdapter());
		addMouseMotionListener(new MyMouseAdapter());

		setSize(400, 400);
		setVisible(true);
		setTitle("[MOUSE-EVENT-DEMO]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void paint(Graphics graphic)
	{
		super.paint(graphic);
		
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Arial", Font.BOLD, 20));
		graphic.drawString(msg, (getWidth()/2)-50,  getHeight()/2);
	}

	class MyMouseAdapter extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			msg = "[MOUSE-CLICKED]";
			
			repaint();
		}
		
		public void mouseEntered(MouseEvent event)
		{
			msg = "[MOUSE-ENTERED]";
			
			repaint();
		}

		public void mouseExited(MouseEvent event)
		{
			msg = "[MOUSE-EXITED]";
			
			repaint();
		}

		public void mousePressed(MouseEvent event)
		{
			msg = "[MOUSE-PRESSED]";
			
			repaint();
		}

		public void mouseReleased(MouseEvent event)
		{
			msg = "[MOUSE-RELEASED]";
			
			repaint();
		}
		
		//how they imlemented hered...
		public void mouseDragged(MouseEvent event)
		{
			msg = "[MOUSE-DRAGGED]";
			
			repaint();
		}

		public void mouseMoved(MouseEvent event)
		{
			msg = "[MOUSE-MOVED]";
			
			repaint();
		}
	}
	
	public static void main(String args[])
	{
		new MouseEventDemo();
	}
}

