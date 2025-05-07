import java.io.*;

class FileCopy
{
	public static void main(String args[])throws Exception
	{
		int Ascii = 0;
		
		FileInputStream source = new FileInputStream(args[0]);
		FileOutputStream destination = new FileOutputStream(args[1]);		
		
		while(Ascii != -1)
		{
			//read character by character..
			Ascii = source.read();
			
			if(Ascii != -1)
			{
				//replace numbers with '*' if found...
				if(Ascii > 47 && Ascii < 58)
					Ascii = 42;
				else
				{
					if(Ascii > 64 && Ascii < 91)
						Ascii = Ascii + 32;		//make uppercase --> lowercase
					else if(Ascii > 96 && Ascii < 123)
						Ascii = Ascii - 32;		//make lowercase --> uppercase
				}

				destination.write(Ascii);			//finally write character to file..
			}
		}
		
		source.close();
		destination.close();
	}		
}

