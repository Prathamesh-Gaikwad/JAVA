import java.util.Date;

public class Book 
{
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private Date published;
	private double price;

	public Book() 
	{
		// this empty constructor is required
	}

	public Book(String isbn, String title, String author, String publisher, Date published, double price)
	{
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.published = published;
		this.price = price;
	}

	// getters and setters
	public String getIsbn()
	{
		return this.isbn;
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public Date getPublished()
	{
		return this.published;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public void setPublished(Date published)
	{
		this.published = published;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
}

