import javax.swing.*;
import java.awt.*;   

public class TableExample 
{
	JFrame f;    
	
	TableExample()
	{    
		f=new JFrame();    
		
		JButton b1 = new JButton("[SAVE]");
		
		String data[][]={ 
				{"101","Amit","670000"},    
				{"102","Jai","780000"},    
		                {"101","Sachin","700000"}};
		                 
		String column[]={"ID","NAME","SALARY"}; 
		        
		f.setLayout(new BorderLayout());

		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,200,300);          
		
		JScrollPane sp=new JScrollPane(jt);    
		f.add(sp, BorderLayout.CENTER);
		f.add(b1, BorderLayout.SOUTH);      
		
		f.setSize(300,400);    
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}     
	
	public static void main(String[] args) 
	{    
		new TableExample();    
	}    
}

