public class SqlDate
{
	public static void main(String args[])
	{
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		System.out.println(sqlDate);
	}
}

