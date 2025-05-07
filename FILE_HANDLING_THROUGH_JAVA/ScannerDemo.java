import java.io.File;
import java.util.Scanner;

public class ScannerDemo
{
	public static void main(String args[])
	{
		Scanner obj = new Scanner(new File("Demo.txt"));
		
		obj.useDelimiter("\n\n");
		
		while(obj.hasNext())
			System.out.println(obj.next());
	}
}
