

public class DateValidation 
{	
	/* Fields section */
	private final short MIN_YEAR = 1900;
	private final short MAX_YEAR = 2099;
	
	private final byte MIN_MONTH = 1;
	private final byte MAX_MONTH = 12;
	
	private final byte MIN_DAY = 1;
	
	private final short FOUR_YEARS = 4;
	private final short ONE_HUNDRED_YEARS = 100;
	private final short FOUR_HUNDRED_YEARS = 400;
	
	private final byte[] MAX_DAYS_NORMAL_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	/* Methods Section*/
	public boolean validateDate(String date) 
	{
		String[] dateStringArray = date.split("/");
 
//		String day = dateStringArray[0];
//		String month = dateStringArray[1];
//		String yearString = dateStringArray[2]; 
		
		if ( !validateYear(dateStringArray[2]) )  
			return false; 
		
		if ( !validateMonth(dateStringArray[1]) )  
			return false; 
		
		return validateDay(dateStringArray[0], dateStringArray[1], dateStringArray[2]); 
	}
	
	public boolean validateDay(String dayString, String monthString, String yearString)
	{
		short yearValue = Short.parseShort(yearString);
		byte monthValue = Byte.parseByte(monthString);
		byte dayValue = Byte.parseByte(dayString);
		
//		Año bisiesto es el divisible entre 4, salvo que sea año secular -último de cada siglo, 
//		terminado en «00»-, en cuyo caso también ha de ser divisible entre 400.
		if ( (yearValue % this.FOUR_YEARS == 0) ) 
		{
			//año terminado en 00 que es bisiesto
			if ( (yearValue % this.ONE_HUNDRED_YEARS == 0) )
				if ((yearValue % this.FOUR_HUNDRED_YEARS == 0)) 
					return ( dayValue >=  this.MIN_DAY && dayValue <= (this.MAX_DAYS_NORMAL_MONTH[ monthValue - 1 ] + 1) );
				else 
					return ( dayValue >= this.MIN_DAY && dayValue <= (this.MAX_DAYS_NORMAL_MONTH[ monthValue - 1 ]) );
			else
				return ( dayValue >=  this.MIN_DAY && dayValue <= (this.MAX_DAYS_NORMAL_MONTH[ monthValue - 1 ] + 1) );
		}
		else 
		{
			return ( dayValue >=  this.MIN_DAY && dayValue <= this.MAX_DAYS_NORMAL_MONTH[ monthValue - 1 ] );
		}
	}
	
	public boolean validateMonth(String monthString)
	{
		byte monthValue = Byte.parseByte(monthString);
		return (monthValue >= this.MIN_MONTH) && (monthValue <= this.MAX_MONTH);
	}
	
	public boolean validateYear(String yearString)
	{
		short yearValue = Short.parseShort(yearString);
		return (yearValue >= this.MIN_YEAR) && (yearValue <= this.MAX_YEAR);
	}
}
