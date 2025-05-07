import java.util.Date;

public class Task 
{
	private String title;
	private String descrip;
	private Date dueDate;
	private String status;

	public Task() 
	{
		// this empty constructor is required
	}

	public Task(String title, String descrip,  Date dueDate, String status)
	{
		this.title = title;
		this.descrip = descrip;
		this.dueDate = dueDate;
		this.status = status;
	}

	// getters 
	public String getTitle()
	{
		return this.title;
	}

	public String getDescrip()
	{
		return this.descrip;
	}

	public Date getDueDate()
	{
		return this.dueDate;
	}

	public String getStatus()
	{
		return this.status;
	}

	//setters
	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setDescrip(String descrip)
	{
		this.descrip = descrip;
	}

	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}

