package database;

import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database
{	
	public Connection connectDB()
	{
		String user = "postgres";
		String pass = "Pratham@2002";
		String dbURL = "jdbc:postgresql://localhost:5432/postgres";

		Connection conn = null;	
	
		try
		{
			conn = DriverManager.getConnection(dbURL, user, pass);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return conn;
	}
	
	public int getUserID(String userName, Connection conn) throws SQLException
	{
		ResultSet result = null;
		PreparedStatement statement = null;
	
		String sql = "select UserID from Users where UserName = ?;";
		
		try
		{
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, userName);
			
			result = statement.executeQuery();			
	
			result.next();

		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}

		return result.getInt(1);
	}

	public int getUserID(String userName, Connection conn, boolean bool) throws SQLException
	{
		ResultSet result = null;
		PreparedStatement statement = null;
	
		String sql = "select UserID from manager where UserName = ?;";
		
		try
		{
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, userName);
			
			result = statement.executeQuery();			
	
			result.next();

		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}

		return result.getInt("userid");
	}
	
	public ResultSet getRecords(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where managerid = ?;");
			else
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where userID = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;
	}
	
	public ResultSet getCompRecords(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where managerid = ? and status = ?;");
			else
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where userID = ? and status = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			statement.setString(2, "Completed");
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;	
	}
	
	public ResultSet getPendRecords(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where managerid = ? and status = ?;");	
			else
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status from Tasks where userID = ? and status = ?;");	
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			statement.setString(2, "Pending");
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;			
	}
	
	public ResultSet getTaskCount(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select count(managerid) from Tasks where managerid = ?;");
			else
				sql.replace(0, sql.length(), "select count(userID) from Tasks where userID = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;
	}

	public ResultSet getCompTaskCount(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select count(managerid) from Tasks where managerid = ? and status = 'Completed';");
			else
				sql.replace(0, sql.length(), "select count(userID) from Tasks where userID = ? and status = 'Completed';");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;
	}

	public ResultSet getPendTaskCount(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select count(managerid) from Tasks where managerid = ? and status = 'Pending';");
			else
				sql.replace(0, sql.length(), "select count(userID) from Tasks where userID = ? and status = 'Pending';");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;
	}
	
	public ResultSet getDueTaskCount(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select count(managerid) from Tasks where managerid = ? and duedate < ? and status = 'Pending';");
			else
				sql.replace(0, sql.length(), "select count(userID) from Tasks where userID = ? and duedate < ? and status = 'Pending';");
			
			statement = conn.prepareStatement(sql.toString());
			
			//current date from system..
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());			
			
			statement.setInt(1, userID);
			statement.setDate(2, sqlDate);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;	
	}
	
	public ResultSet getDueTasks(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select Title, DueDate from Tasks where managerid = ? and duedate < ? and status = 'Pending' order by updatedat limit 2;");
			else
				sql.replace(0, sql.length(), "select Title, DueDate from Tasks where userID = ? and duedate < ? and status = 'Pending' order by updatedat limit 2;");
			
			statement = conn.prepareStatement(sql.toString());
			
			//current date from system..
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());			
			
			statement.setInt(1, userID);
			statement.setDate(2, sqlDate);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;	
	}
	
	public ResultSet getRecentTasks(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;

		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select title, duedate, status from tasks where managerid = ? order by updatedat desc limit 2;");
			else
				sql.replace(0, sql.length(), "select title, duedate, status from tasks where userID = ? order by updatedat desc limit 2;");

			statement = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			statement.setInt(1, userID);

			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;
	}
	
	public ResultSet getIDRecords(int taskID, int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select Title, Description, DueDate, Status from Tasks where managerid = ? and taskID = ?;");
			else
				sql.replace(0, sql.length(), "select Title, Description, DueDate, Status from Tasks where userID = ? and taskID = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			statement.setInt(2, taskID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;
	}
	
	public int getTaskID(String title, int userID, Connection conn, boolean bool) throws SQLException
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select taskid from Tasks where managerid = ? and title = ?;");
			else
				sql.replace(0, sql.length(), "select taskid from Tasks where userID = ? and title = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			statement.setString(2, title);
			
			result = statement.executeQuery();
			
			result.next();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result.getInt(1);		
	}
	
	public int setRecords(String title, String description, Date date, String status, int taskID, int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		int rowsUpdated = 0;
		PreparedStatement statement;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "UPDATE tasks SET title = ?, description = ?, duedate = ?, status = ?, updatedat = DEFAULT WHERE managerid = ? and taskid = ?;");
			else
				sql.replace(0, sql.length(), "UPDATE tasks SET title = ?, description = ?, duedate = ?, status = ?, updatedat = DEFAULT WHERE userid = ? and taskid = ?;");
			 
			statement = conn.prepareStatement(sql.toString());
			
			statement.setString(1, title);
			statement.setString(2, description);
			statement.setDate(3, date);
			statement.setString(4, status);
			statement.setInt(5, userID);
			statement.setInt(6, taskID);
			 
			rowsUpdated = statement.executeUpdate();			
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return rowsUpdated;
	}
	
	public int removeRecord(int taskID, int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		int rowsDeleted = 0;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "DELETE FROM tasks WHERE taskid = ? and managerid = ?");
			else
				sql.replace(0, sql.length(), "DELETE FROM tasks WHERE taskid = ? and userID = ?");
			 
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, taskID);
			statement.setInt(2, userID);
			 
			rowsDeleted = statement.executeUpdate();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println();
		}
		
		return rowsDeleted;		
	}
	
	public int insertRecord(String title, String descrip, java.sql.Date sqlDate, String status, int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		int rowInserted = 0;
		PreparedStatement statement;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "insert into Tasks (Title, Description, DueDate, Status, managerid) values (?, ?, ?, ?, ?);");
			else
				sql.replace(0, sql.length(), "insert into Tasks (Title, Description, DueDate, Status, UserID) values (?, ?, ?, ?, ?);");

			statement = conn.prepareStatement(sql.toString());

			statement.setString(1, title);
			statement.setString(2, descrip);
			statement.setDate(3, sqlDate);				
			statement.setString(4, status);
			statement.setInt(5, userID);
			
			rowInserted = statement.executeUpdate();

		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println();
		}
		
		return rowInserted;
	}

	public int setTaskReminderTime(String str, int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		int rowsUpdated = 0;
		PreparedStatement statement;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "UPDATE manager SET reminder = ? WHERE userid = ?;");
			else
				sql.replace(0, sql.length(), "UPDATE users SET reminder = ? WHERE userid = ?;");
			 
			statement = conn.prepareStatement(sql.toString());
			
			statement.setString(1, str);
			statement.setInt(2, userID);
			 
			rowsUpdated = statement.executeUpdate();			
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return rowsUpdated;
	}

	public ResultSet getReminder(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select reminder from manager where userID = ?;");
			else
				sql.replace(0, sql.length(), "select reminder from users where userID = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;
	}

	public ResultSet getMail(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select gmail from manager where userID = ?;");
			else
				sql.replace(0, sql.length(), "select gmail from users where userID = ?;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;
	}			

	public ResultSet getOverDueTasks(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select Title, DueDate from Tasks where managerid = ? and duedate < ? and status = 'Pending' order by updatedat;");
			else
				sql.replace(0, sql.length(), "select Title, DueDate from Tasks where userID = ? and duedate < ? and status = 'Pending' order by updatedat;");
			
			statement = conn.prepareStatement(sql.toString());
			
			//current date from system..
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());			
			
			statement.setInt(1, userID);
			statement.setDate(2, sqlDate);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;	
	}
	
	public ResultSet getManagerName(Connection conn)
	{
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			statement = conn.createStatement();			
			result = statement.executeQuery("select username from manager;");
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}

	public ResultSet getManagerName(int managerID, Connection conn)
	{
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			statement = conn.prepareStatement("select username from manager where userid = ?;");
			statement.setInt(1, managerID);		
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}
	
	public boolean setManagerName(int userID, int managerID, Connection conn)
	{
		boolean bool = true;
		ResultSet result = null;
		Statement statement = null;
		PreparedStatement statementPrepare = null;
		
		try
		{
			statementPrepare = conn.prepareStatement("insert into team (userid, managerid) values (?, ?);");
			statementPrepare.setInt(1, userID);
			statementPrepare.setInt(2, managerID);
			bool = statementPrepare.execute();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return bool;		
	}

	public ResultSet getManagerID(String managerName, Connection conn)
	{
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			statement = conn.prepareStatement("select userid from manager where username = ?;");
			statement.setString(1, managerName);			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}

	public ResultSet getManagerID(int userID, Connection conn)
	{
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			statement = conn.prepareStatement("select managerid from team where userid = ?;");
			statement.setInt(1, userID);			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}
	
	public ResultSet getEmployeeID(int managerID, Connection conn)
	{
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			statement = conn.prepareStatement("select userid from team where managerid = ?;");
			statement.setInt(1, managerID);			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}
	
	public ResultSet getUserName(int userID, Connection conn)
	{
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			statement = conn.prepareStatement("select username from users where userid = ?;");
			statement.setInt(1, userID);			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;		
	}
	
	public ResultSet getAssignRecords(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status, userid from Tasks where managerid = ? and owner = 1;");	
			else
				sql.replace(0, sql.length(), "select TaskID, Title, Description, DueDate, Status, userid from Tasks where userID = ? and owner = 1;");	
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		return result;			
	
	}

	public ResultSet getAssignTaskCount(int userID, Connection conn, boolean bool)
	{
		StringBuilder sql;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		sql = new StringBuilder();
		
		try
		{
			if(bool)
				sql.replace(0, sql.length(), "select count(managerid) from Tasks where managerid = ? and owner = 1;");
			else
				sql.replace(0, sql.length(), "select count(userID) from Tasks where userID = ? and owner = 1;");
			
			statement = conn.prepareStatement(sql.toString());
			
			statement.setInt(1, userID);
			
			result = statement.executeQuery();
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);			
		}
		
		return result;
	}
}

