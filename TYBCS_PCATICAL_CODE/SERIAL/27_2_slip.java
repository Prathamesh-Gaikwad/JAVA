import java.io.*;

class FileOperation
{
	public static void main(String args[]) throws IOException
	{
		int i;
		int ch;
		int cnt = 0;
		String dirName = args[0];
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		File file = new File(dirName);
		
		if(file.isFile())
		{
			System.out.println(file + " is file");
			System.out.println("File Path : " + file.getAbsolutePath());
			System.out.println("File Size : " + file.length() + " bytes");
		}
		else if(file.isDirectory())
		{
			System.out.println(dirName + " is a directory");
			System.out.println("Contents of " + dirName);
			
			String arr[] = file.list();
			
			for(String name : arr)
			{
				File dirFile = new File(dirName, name);
				
				if(dirFile.isFile())
				{
					cnt++;
					System.out.println(dirFile + " is file");
				}
				else
				{
					System.out.println(dirFile + " is a directory");
				}
			}
			
			System.out.println("Total Number Of File : " + cnt);
			
			System.out.println("Do You Want To Delete File With txt extension(1/0)? : ");
			ch = Integer.parseInt(reader.readLine());
			
			if(1 == ch)
			{
				for(String name : arr)
				{
					File deleFile = new File(dirName, name);
					
					if(deleFile.isFile() && name.endsWith("txt"))
					{
						System.out.println(name + " deleted");
						deleFile.delete();
					}
				}
			}
		}
	}
}

