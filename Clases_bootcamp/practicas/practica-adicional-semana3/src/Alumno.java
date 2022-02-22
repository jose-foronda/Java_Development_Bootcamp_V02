
public class Alumno 
{
	private String firstName = " ";
	private String lastName = " ";
	Test[] studentTests = null;
	float studentMeanScore = 0;
	
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
	
	public void computeMeanScore()
	{	
		this.studentMeanScore = 0;
		
		int studentTestsLength = this.studentTests.length;
		
		float divider = studentTestsLength == 0 ? 1 : studentTestsLength;
		
		for (int i = 0; i < studentTestsLength; i++) 
		{
			this.studentMeanScore += this.studentTests[i].getTestScore();
		}
		 
		this.studentMeanScore /= divider;
	}
	
	public float getMeanScore()
	{
		return this.studentMeanScore;
	}
}
