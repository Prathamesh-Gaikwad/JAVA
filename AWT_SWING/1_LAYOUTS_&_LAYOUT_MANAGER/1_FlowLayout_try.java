import java.awt.*;

class FlowLayoutDemo extends Frame
{
	FlowLayoutDemo()
	{
		int Counter;
		
		Button arrB[] = new Button[10];
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 250, 250));
		/**
			250 chi horizonatl space pratek component madhe aani 250 chi vertical space pratek componet madhe...
		*/
		for(Counter = 0; Counter < arrB.length; Counter++)
		{
			arrB[Counter] = new Button("Button " + (Counter + 1));
			
			add(arrB[Counter]);
		}
	}
}

class FlowLayout_try
{
	public static void main(String args[])
	{
		FlowLayoutDemo fObj = new FlowLayoutDemo();
		
		fObj.setTitle("\nFlowLayout JAVA\n");	//window ch title
		
		fObj.setSize(1000, 1000);	//first parameter length, and second is breadth
		
		fObj.setVisible(true);		//window dakhavnaar ki nahi...
	}
}

