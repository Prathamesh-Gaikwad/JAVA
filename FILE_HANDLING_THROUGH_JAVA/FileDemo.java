import java.io.File;

public class FileDemo
{
	public static void main(String args[])
	{
		File fObj1 = new File("~/Documents/JAVA/FILE_HANDLING_THROUGH_JAVA");
		
		System.out.println("\nFile Name : " + fObj1.getName());
		
		System.out.println("\nParent Directory Name : " + fObj1.getParent());
		
		System.out.println("\nLength Of File : " + fObj1.length());
		
		System.out.println("\nIs File : " + fObj1.isFile());
		
		System.out.println("\nRelative Path Of File : " + fObj1.getPath());
		
		System.out.println("\nIs Directory : " + fObj1.isDirectory());
		
		System.out.println("\nIs Absolute : " + fObj1.isAbsolute());		
	}
}

