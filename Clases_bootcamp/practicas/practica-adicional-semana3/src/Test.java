
public class Test 
{
	private byte testId = 0;
	private float testScore = 0;
	
	public Test(byte tId, float tSc)
	{
		this.testId = tId;
		this.testScore = tSc;
	}
	
	public byte getTestId()
	{
		return this.testId;
	}
	
	public void setTestId(byte sTid)
	{
		this.testId = sTid;
	}
	
	public float getTestScore()
	{
		return this.testScore;
	}
	
	public void setTestScore(float sTestScore)
	{
		this.testScore = sTestScore;
	}
}
