
public class Alumno 
{
	private String firstName = " ";
	private String lastName = " ";
//	Test[] studentTests;
	
	public Alumno(String fn, String ln) 
	{
		this.firstName = fn;
		this.lastName = ln;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	
	public void setFirstName(String newFirstName)
	{
		this.firstName = newFirstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	
	public void seLastName(String newLastName)
	{
		this.lastName = newLastName;
	}
}
