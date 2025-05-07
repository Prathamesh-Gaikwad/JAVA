import java.awt.*;
import javax.swing.*;

class PanelImage extends JPanel
{
	Image image;
	
	public PanelImage()
	{
		ImageIcon file = new ImageIcon("registration.jpeg");
		image = file.getImage();
	}
	
	public void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		graphic.drawImage(image, 0, 0, null);
	}
	
	public static void main(String args[])
	{
		JFrame frame;
		PanelImage background;
		
		frame = new JFrame("BACKGROUND-IMAGE");
		
		background = new PanelImage();
		
		background.setBounds(0, 0, 250, 500);
		background.setBorder(BorderFactory.createLineBorder(Color.black));

		frame.add(background);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
