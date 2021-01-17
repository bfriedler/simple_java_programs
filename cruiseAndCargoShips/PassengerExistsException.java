package cruiseAndCargoShips;

public class PassengerExistsException extends RuntimeException
{
	public PassengerExistsException()
	{
		super("ERROR: PASSENGER ALREADY EXISTS");
	}
	
	public PassengerExistsException(String message) 
	{
		super(message);
	}

}
