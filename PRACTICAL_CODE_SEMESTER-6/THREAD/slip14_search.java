import java.io.*;

public class slip14_search extends Thread
{
	File file;
	String line;
	String name;
	static String str;
	LineNumberReader reader = null;
	
	public slip14_search(String name)
	{
		this.name = name;
		file = new File(name);
	}
	
	public void run()
	{
		try
		{
			FileReader fReader = new FileReader(file);
			
			reader = new LineNumberReader(fReader);
			
			while((line = reader.readLine()) != null)
			{
				if(line.indexOf(str) != -1)
				{
					System.out.println("String Found In " + name + " at " + reader.getLineNumber() + " line");
					stop();
				}
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	public static void main(String args[])throws IOException
	{
		Thread thread[] = new Thread[20];
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter String To Search : ");
		
		str = bReader.readLine();
		
		FilenameFilter filter = new FilenameFilter()
		{
			public boolean accept(File file, String name)
			{
				if(name.endsWith(".txt"))
					return true;
				else
					return false;
			}
		};
		
		File dir1 = new File(".");
		
		File files[] = dir1.listFiles(filter);
		
		if(0 == files.length)
			System.out.println("NO FILES AVAILABLE WITH THIS EXTENSION");
		else
		{
			for(int i = 0; i < files.length; i++)
			{
				for(File file1 : files)
				{
					thread[i] = new slip14_search(file1.getName());
					thread[i].start();
				}
			}
		}
	}
}

