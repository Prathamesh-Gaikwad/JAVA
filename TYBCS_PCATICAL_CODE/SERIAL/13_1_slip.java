import java.io.*;

class FileHandling
{
	public static void main(String args[]) throws IOException
	{
		int lc = 0;
		int wc = 0;
		String name = args[0];
		
		File fHandle = new File(name);
		
		if(fHandle.isFile())
		{
			FileReader file = new FileReader(fHandle);
			
			BufferedReader read = new BufferedReader(file);
			
			while((name = read.readLine()) != null)
			{
				lc++;
				String words[] = name.split(" ");
				wc = wc + words.length;
			}
			
			System.out.println("Total Lines : " + lc);
			System.out.println("Total Words : " + wc);			
		}
	}
}

