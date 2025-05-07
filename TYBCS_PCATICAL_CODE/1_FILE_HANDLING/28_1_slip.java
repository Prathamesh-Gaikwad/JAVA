import java.io.File;
import java.util.Scanner;

class FileStats
{
	public static void main(String args[])
	{
		String name = " ";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter File Name With Full Path : ");
		name = scanner.nextLine();
		
		File file = new File(name);
		
		if(file.exists())
		{
			System.out.println("[FILE-EXIST]");
			System.out.println("Readable : " + file.canRead());
			System.out.println("Writable : " + file.canWrite());
			
			if(file.isFile())
				System.out.println("[IT IS NORMAL FILE]");
			else
				System.out.println("[MIGHT BE A NAMED PIPE]");

			if(file.isDirectory())
				System.out.println("[IT IS DIRECTORY]");
			else
				System.out.println("[IT IS NOT A DIRECTORY]");

			System.out.println("File Length : " + file.length() + " bytes");
		}
		
		scanner.close();
	}
}

