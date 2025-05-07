import java.io.*;

class FileHandling
{
	public static void main(String args[]) throws IOException
	{
		String str1;
		String str2 = " ";
		
		FileReader file = new FileReader(args[0]);
		
		BufferedReader reader = new BufferedReader(file);
		
		while((str1 = reader.readLine()) != null)
		{
			str2 = str2 + str1 + "\n";
		}
		
		StringBuffer string = new StringBuffer(str2);
		
		System.out.println("Reverse : " + string.reverse());
		
		System.out.println("Upper case : " + str2.toUpperCase());
		
		file.close();		
	}
}

