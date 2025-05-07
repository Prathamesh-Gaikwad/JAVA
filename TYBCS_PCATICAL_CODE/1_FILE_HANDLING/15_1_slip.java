import java.io.*;

class FileCopy
{
	public static void main(String args[]) throws IOException
	{
		int read = 0;
		
		FileInputStream source = new FileInputStream(args[0]);
		FileOutputStream destination = new FileOutputStream(args[1]);
		
		while(read != -1)
		{
			read = source.read();
			if(read != -1)
				destination.write(read);
		}
		
		source.close();
		destination.close();
	}
}

