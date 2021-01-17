/**
 * This class creates a cruise ship- a ship with the additional fields of max passengers, and an array list of passengers
 */
package cruiseAndCargoShips;
import java.util.ArrayList;

public class CruiseShip extends Ship
{
	private int maxPassengers;
	private ArrayList <Passenger> passengers=new ArrayList<>();
	
	
	public CruiseShip()
	{
		;
	}
	
	public CruiseShip(String name, String yearBuilt, int maxPassengers) 
	{
		super(name, yearBuilt);
		if (maxPassengers<0)
		{
			throw new IllegalArgumentException("ERROR: INVALID MAX PASSENGER AMOUNT");
		}
		this.maxPassengers=maxPassengers;
	}
	
	public CruiseShip(String name, String yearBuilt, String maxPassengers) 
	{
		super(name, yearBuilt);
		setMaxPassIfValid(Integer.valueOf(maxPassengers));
	}
	
	public CruiseShip(String name, String yearBuilt, int maxPassengers, ArrayList<Passenger> passengers) 
	{
		super(name, yearBuilt);
		setMaxPassIfValid(maxPassengers);
		//this.passengers=passengers;
		for(Passenger p: passengers) //*4 ?necessary or just do this.passengers=passengers?
		{
			addPassenger(p);
		}
	}
	
	public CruiseShip(int maxPassengers) 
	{
		super();
		setMaxPassIfValid(maxPassengers);
		//passengers=new ArrayList<>();
	}
	
	public CruiseShip(String name, String yearBuilt)
	{
		super(name, yearBuilt);
	}
	
	public CruiseShip(CruiseShip c) 
	{
		super(c.getName(), c.getYearBuilt()); 
		this.maxPassengers=c.maxPassengers;
		for(Passenger p: c.getPassengers())
		{
			this.passengers.add(p);
		}
	}
	
	
	public int getMaxPassengers() 
	{
		return maxPassengers;
	}
	
	public ArrayList<Passenger> getPassengers() 
	{
		ArrayList <Passenger> passengersR=new ArrayList<>();
		for(Passenger p: passengers) 
		{
			passengersR.add(p);
		}
		
		return passengersR;
	}
	
	public int getCurrentPassengerAmount()
	{
		return passengers.size();
	}
	
	
	public void setMaxPassengers(int maxPassengers) 
	{
		setMaxPassIfValid(maxPassengers);
	}
	
	public void setMaxPassengers(String maxPassengers) 
	{
		setMaxPassIfValid(Integer.valueOf(maxPassengers));
	}
	
	public void setPassengers(ArrayList <Passenger> passengers)
	{
		//this.passengers=passengers;
		for(Passenger p: passengers) //*4 ?necessary or just do this.passengers=passengers?
		{
			addPassenger(p);
		}
	}
	
	
	public void addPassenger(Passenger p) throws PassengerExistsException
	{
		if(passengers.size()>=maxPassengers) 
		{
			throw new IllegalArgumentException("ERROR: SHIP IS FULL");
		}
		else if(!passengers.contains(p))
			{
				passengers.add(p);
			}
			else 
			{
				throw new PassengerExistsException();
			}
	}
	
	public void setMaxPassIfValid(int maxPassengers) {
		if (maxPassengers<0)
		{
			throw new IllegalArgumentException("ERROR: INVALID MAX PASSENGER AMOUNT");
		}
		this.maxPassengers=maxPassengers;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder str=new StringBuilder();
		str.append(super.toString());
		str.append("\nMax Passengers: "+maxPassengers+"\n");
		str.append("Passengers: \n");
		for(Passenger p: passengers) 
		{
			str.append(p+"\n");
		}
		
		return str.toString();
	}
	
}
