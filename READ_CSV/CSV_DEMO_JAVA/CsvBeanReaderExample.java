import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * This program demonstrates how to read CSV file using SuperCSV library.
 * Each line is read into a JavaBean class (POJO).
 * @author www.codejava.net
 *
 */

public class CsvBeanReaderExample 
{

	static void readCSVFile(String csvFileName) 
	{
		ICsvBeanReader beanReader = null;
		CellProcessor[] processors = new CellProcessor[] {
				new NotNull(), // ISBN
				new NotNull(), // title
				new NotNull(), // author
				new NotNull(), // publisher
				new ParseDate("MM/dd/yyyy"), // published date
				new ParseDouble() // price
		};

		try 
		{
			beanReader = new CsvBeanReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE);
			
			String[] header = beanReader.getHeader(true);
			
			Book bookBean = null;
			
			while ((bookBean = beanReader.read(Book.class, header, processors)) != null) 
			{
				System.out.printf("%s %-30s %-30s %-20s %tD $%.2f",
						bookBean.getIsbn(), bookBean.getTitle(),
						bookBean.getAuthor(), bookBean.getPublisher(),
						bookBean.getPublished(), bookBean.getPrice());
				System.out.println();
			}
		} 
		catch (FileNotFoundException ex) 
		{
			System.err.println("Could not find the CSV file: " + ex);
		} 
		catch (IOException ex) 
		{
			System.err.println("Error reading the CSV file: " + ex);
		} 
		finally 
		{
			if (beanReader != null) 
			{
				try 
				{
					beanReader.close();
				} 
				catch (IOException ex) 
				{
					System.err.println("Error closing the reader: " + ex);
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		String csvFileName = "task.csv";
		
		readCSVFile(csvFileName);
	}
}

