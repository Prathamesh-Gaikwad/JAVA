import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class writeCollection
{
	public static void main(String args[])
	{
		int no;
		int size;
		File obj;
		Record record;
		Iterator move;
		Scanner scanner;
		FileWriter file;
		StringBuilder str;
		LinkedList<Record> list;
		
		try
		{
			str = new StringBuilder();

			list = new LinkedList<Record>();

			obj = new File("fileName1.txt");
			
			scanner = new Scanner(System.in);			
				
			if(obj.createNewFile())
				System.out.println("\n\tFile Created : " + obj.getName());
			else
				System.out.println("\n\tFile Already Exist");

			file = new FileWriter(obj.getName());
			
			System.out.print("\n\tHow Many Records You Wanted To Insert : ");
			size = scanner.nextInt();
			
			for(int i = 0; i < size; i++)
			{
				System.out.print("\n\tEnter Name : ");
				str.replace(0, str.length(), scanner.next());
				
				System.out.print("\n\tEnter No. : ");
				no = scanner.nextInt();
				
				Record rObj = new Record(str.toString(), no);
				list.add(rObj);
			}
			
			move = list.iterator();
			while(move.hasNext())
			{
				record = (Record)move.next();
				str.replace(0, str.length(), record.name + "	" + record.no + "\n");
				
				file.write(str.toString());
			}
			
			file.close();
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}
}

class Record
{
	int no;
	String name;
	
	Record(String strName, int number)
	{
		no = number;
		name = strName;
	}
}

