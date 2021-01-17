/**
 * This class creates an address
 */
package cruiseAndCargoShips;

public class Address
{
	private String street;
	private String city;
	private String state;
	private String zipcode;
	

	public Address(String street, String city, String state, String zip)
	{
		this.street=street;
		this.city=city;
		this.state=state;
		setZipIfValid(zip);
	}
	
	
	public Address()
	{
		;
	}
	
	
	public Address (Address anotherAddress)
	{
		this.street=anotherAddress.street;
		this.city=anotherAddress.city;
		this.state=anotherAddress.state;
		this.zipcode=anotherAddress.zipcode;
	}
	
	
	public String getStreet() 
	{
		return street;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getZip() 
	{
		return zipcode;
	}
	
	
	public void setStreet(String street)
	{
		this.street=street;
	}
	
	public void setCity(String city)
	{
		this.city=city;
	}
	
	public void setState(String state) 
	{
		this.state=state;
	}
	
	public void setZip(String zip) 
	{
		setZipIfValid(zip);
	}
	
	public void setZipIfValid(String zip)
	{
		if(zip.length()<5 || zip.length()>10) //>10 because some ZIPS have an extra dash with 4 numbers after
		{
			throw new IllegalArgumentException("ERROR: INVALID ZIP. ZIP NOT SET");
		}
		
		else 
		{
			zipcode=zip;
		}
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder str= new StringBuilder();
		str.append(street+"\n");
		str.append(city+" "+state+" "+zipcode);
		
		return str.toString();
	}
}