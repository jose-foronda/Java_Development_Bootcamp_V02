
public class Alumno 
{
	private String firstName = " ";
	private String lastName = " ";
	Test[] studentTests = null;
	
	public Alumno(String fn, String ln, Test[] scoreTest) 
	{
		this.firstName = fn;
		this.lastName = ln;
		this.studentTests = scoreTest;
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
	
	public Test[] getTestArray()
	{
		return this.studentTests;
	}
	
	public void setTestArray(Test[] newTestArray)
	{
		this.studentTests = newTestArray;
	}
}
