import javax.swing.*;
import java.sql.*;

public class slip12_table extends JFrame
{
	public slip12_table()
	{
		try
		{
			int i;
			int cnt = 0;
			
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM employee");
			
			ResultSetMetaData rsm = rs.getMetaData();
			
			//cnt = rsm.getRowCount();
			
			Object data[][] = new Object[40][4];
			
			String columns[] = new String[]
			{
				"Employee ID", "Employee Name", "Employee Designation", "Employee Salary"
			};
			
			i = 0;
			while(rs.next())
			{
				data[i][0] = rs.getInt(1);
				data[i][1] = (Object)rs.getString(2);
				data[i][2] = (Object)rs.getString(3);
				data[i][3] = rs.getInt(4);
				i++;
			}
			
			JTable table = new JTable(data, columns);
			this.add(new JScrollPane(table));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		this.setTitle("Table Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new slip12_table();
	}
}
