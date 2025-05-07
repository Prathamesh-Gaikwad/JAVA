import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo
{
	public static void main(String args[])
	{
		short size;
		
		Connection conn = null;
		ResultSet result = null;
		DatabaseMetaData meta = null;
		ResultSetMetaData resultMeta = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				meta = conn.getMetaData();
				
				result = meta.getTables(null, null, null, new String[]{"TABLE"});
				
				resultMeta = result.getMetaData();
				
				size = (short)resultMeta.getColumnCount();
				
				System.out.println("\n\t[TABLE NAME] : " + resultMeta.getTableName(1));
				
				for(int i = 1; i <= size; i++)
				{
					System.out.println("\n\t[COLUMN NAME] : " + resultMeta.getColumnName(i) + 
							   " [COLUMN TYPE NAME] : " + resultMeta.getColumnTypeName(i) + 
							   " [COLUMN TYPE] : " + resultMeta.getColumnType(i)
							  );
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

/*
	o/p:
	
	[TABLE NAME] : 

	[COLUMN NAME] : TABLE_CAT [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : TABLE_SCHEM [COLUMN TYPE NAME] : name [COLUMN TYPE] : 12

	[COLUMN NAME] : TABLE_NAME [COLUMN TYPE NAME] : name [COLUMN TYPE] : 12

	[COLUMN NAME] : TABLE_TYPE [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : REMARKS [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : TYPE_CAT [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : TYPE_SCHEM [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : TYPE_NAME [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : SELF_REFERENCING_COL_NAME [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12

	[COLUMN NAME] : REF_GENERATION [COLUMN TYPE NAME] : text [COLUMN TYPE] : 12
*/
