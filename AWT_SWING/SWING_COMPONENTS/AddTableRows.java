import javax.swing.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

class AddTableRows
{			
	DefaultTableModel inputData(DefaultTableModel model)
	{
		int i = 0;
		int size = 0;
		
		String date;
		String title;
		String status;
				
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t-->How many Records You Want to insert : ");
		size = scan.nextInt();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\t-->Enter Title : ");
			title = scan.next();
			
			System.out.print("\n\t-->Enter Date : ");
			date = scan.next();

			System.out.print("\n\t-->Enter Status : ");
			status = scan.next();
			
			Object obj[] = {title, date, status};
			
			model.addRow(obj);
		}
		
		return model;
	}
	
	public static void main(String args[])
	{	
		AddTableRows obj = new AddTableRows();
		
		String colName[] = {"TITLE", "BIRTHDATE", "STATUS"};
			
		JFrame frame = new JFrame();	
	
		DefaultTableModel model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);
		
		JTable table = new JTable();
		
		table.setModel(obj.inputData(model));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

