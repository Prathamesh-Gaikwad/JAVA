import java.io.File;
import java.io.FileReader;

import java.util.Scanner;

public class FileScanner
{
	public static void main(String args[])
	{
		int ch;
		int i = 0;
		StringBuilder str1;
		StringBuilder str2;
		StringBuilder str3;
		StringBuilder str4;
		
		File file;
		FileReader fRead;
		
		str1 = new StringBuilder();
		str2 = new StringBuilder();
		str3 = new StringBuilder();
		str4 = new StringBuilder();
				
		try
		{
			file = new File("task1.txt");

			fRead = new FileReader(file);
			
			ch = fRead.read();
			while(ch != -1)
			{
				str1.delete(0, str1.length());
				while(ch != '|')
				{
					str1.append((char)ch);
				
					ch = fRead.read();
				}
				
				ch = fRead.read();
				
				str2.delete(0, str2.length());
				while(ch != '|')
				{
					str2.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();

				str3.delete(0, str3.length());
				while(ch != '|')
				{
					str3.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();

				str4.delete(0, str4.length());
				while(ch != '|')
				{
					str4.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();
				
				System.out.println("\tTitle : " + str1 + "\n\tDate : " + str2 + "\n\tStatus : " + str3 + "\n\tDescrption : " + str4 + "\n\n");
				if(ch == '\n')
					ch = fRead.read();
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}

