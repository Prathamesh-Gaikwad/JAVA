import java.io.File;
import java.util.Scanner;

public class FileParsing
{
	public static void main(String args[])
	{
		File file;
		Scanner scanner;

		int rollNo;
		StringBuilder str;
		
		str = new StringBuilder();
		
		try
		{
			file = new File("fileName1.txt");
			
			scanner = new Scanner(file);
			
			while(scanner.hasNext())
			{
				str.replace(0, str.length(), scanner.next());
				
				scanner.next();		// "," skip 
				
				rollNo = Integer.parseInt(scanner.next());
				
				System.out.println("\n\t Name : [" + str + "] \tRoll No : [" + rollNo + "]");
			}		
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}
}
