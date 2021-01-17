/**
 * this class creates a cargo ship- a ship with the addtional field of cargo capacity
 */
package cruiseAndCargoShips;

public class CargoShip extends Ship
{
	private int cargoCapacity;
	
	
	public CargoShip()
	{
		;
	}
	
	public CargoShip(String name, String yearBuilt, String cargoCapacity) 
	{
		super(name, yearBuilt);
		setCargoCapIfValid(Integer.valueOf(cargoCapacity));
		
	}
	
	public CargoShip(String name, String yearBuilt, int cargoCapacity)
	{
		super(name, yearBuilt);
		setCargoCapIfValid(cargoCapacity);
	}
	
	public CargoShip(CargoShip anotherCargoShip) 
	{
		super(anotherCargoShip);
		setCargoCapIfValid(anotherCargoShip.cargoCapacity);
	}
	
	public CargoShip(int cargoCapacity) 
	{
		setCargoCapIfValid(cargoCapacity);
	}
	
	public CargoShip(String name ) 
	{
		super(name);
	}
	
	
	public void setCargoCapacity(int cargoCapacity) 
	{
		setCargoCapIfValid(cargoCapacity);
	}
	
	public void setCargoCapacity(String cargoCapacity) 
	{
		setCargoCapIfValid(Integer.valueOf(cargoCapacity));
	}
	
	
	public int getCargoCapacity() 
	{
		return cargoCapacity;
	}
	
	public void setCargoCapIfValid(int cargoCapacity)
	{
		if(cargoCapacity<0 || cargoCapacity>100000)
		{
			throw new IllegalArgumentException("ERROR: INVALID CARGO CAPACITY");
		}
		this.cargoCapacity=cargoCapacity;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str= new StringBuilder();
		str.append("Name: "+super.getName()+" \n");
		str.append("Cargo Capacity: "+cargoCapacity+"\n");
		
		return str.toString();
		
	}
		
		
}
