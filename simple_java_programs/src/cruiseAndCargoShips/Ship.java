/**
 * this class creates a ship with the name and year built
 */
package cruiseAndCargoShips;

import java.time.LocalDate;

public class Ship
{
	private String name;
	private String yearBuilt;
	
	public Ship() 
	{
		;
	}
	
	public Ship(String name, String yearBuilt) throws InvalidYearException
	{
		if(Integer.valueOf(yearBuilt)>LocalDate.now().getYear())
		{
			throw new InvalidYearException();
		}
		this.name=name;
		this.yearBuilt=yearBuilt;	
	}
	
	public Ship(Ship anotherShip)
	{
		this.name=anotherShip.name;
		this.yearBuilt=anotherShip.yearBuilt;
	}
	
	public Ship(String name)
	{
		this.name=name;
	}
	
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setYearBuilt(String yearBuilt) throws InvalidYearException
	{
		if(Integer.valueOf(yearBuilt)>LocalDate.now().getYear() || Integer.valueOf(yearBuilt)<0)
		{
			throw new InvalidYearException();
		}
		this.yearBuilt=yearBuilt;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public String getYearBuilt() 
	{
		return yearBuilt;
	}

	
	@Override
	public String toString()
	{
		StringBuilder str= new StringBuilder();
		str.append("Name: "+name);
		str.append("\nYear built: "+ yearBuilt);
		return str.toString();
	}
	
	
}

