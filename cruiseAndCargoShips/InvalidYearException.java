package cruiseAndCargoShips;

public class InvalidYearException extends RuntimeException
{
	public InvalidYearException() 
	{
		super("ERROR: INVALID YEAR");
	}
	
	public InvalidYearException(String message) 
	{
		super(message);
	}
}
