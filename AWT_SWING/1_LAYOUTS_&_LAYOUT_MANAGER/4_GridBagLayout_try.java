import java.awt.*;

public class GridBagLayout_try extends Frame
{
	GridBagLayout refGBL;
	GridBagConstraints refGBC;
	
	GridBagLayout_try()
	{
		refGBL = new GridBagLayout();
		refGBC = new GridBagConstraints();
		
		setLayout(refGBL);
		setTitle("GridBagLayout JAVA");
		setSize(500, 500);
		setVisible(true);
		
		Button refB1 = new Button("1");
		Button refB2 = new Button("2");
		Button refB3 = new Button("3");
		Button refB4 = new Button("4");
		Button refB5 = new Button("5");
		
		refGBC.fill = GridBagConstraints.HORIZONTAL;
		refGBC.gridx = 0;
		refGBC.gridy = 0;
		add(refB1, refGBC);

		refGBC.fill = GridBagConstraints.HORIZONTAL;
		refGBC.gridx = 1;
		refGBC.gridy = 0;		
		add(refB2, refGBC);
		
		refGBC.fill = GridBagConstraints.HORIZONTAL;
		refGBC.gridx = 2;
		refGBC.gridy = 3;
		refGBC.gridwidth = 5;
		refGBC.gridheight = 8;
		add(refB3, refGBC);
		
		add(refB4);
		add(refB5);
	}
	
	public static void main(String args[])
	{
		GridBagLayout_try refGBLT = new GridBagLayout_try();
	}
}

