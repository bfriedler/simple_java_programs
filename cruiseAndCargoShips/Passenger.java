/**
 * This class creates a passenger- a person with the addtional fields of passport ID and amount of luggage pieces
 */
package cruiseAndCargoShips;

public class Passenger extends Person
{
	private String passportID;
	private int luggagePieces;
	
	
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, String passportID, int luggage) 
	{
		super(f, l, g, addr, birthdate);
		this.passportID=passportID;
		if(luggage>-1 && luggage<=9)
		{
			luggagePieces=luggage;
		}
		else throw new IllegalArgumentException("ERROR: Invalid Luggage Amount");
	}
	
	public Passenger(Passenger p) 
	{
		super(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(),p.getBirthdate());
		passportID=p.passportID;
		luggagePieces=p.luggagePieces;
	}
	
	
	
	@Override
	public String toString()
	{
		StringBuilder str=new StringBuilder();
		str.append(super.toString());
		str.append("Passport ID: "+passportID+"\n");
		str.append("Luggage Pieces: "+luggagePieces);
		
		return str.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((passportID == null) ? 0 : passportID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		//if (!super.equals(obj))
			//return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (passportID == null) {
			if (other.passportID != null)
				return false;
		} else if (!passportID.equals(other.passportID))
			return false;
		return true;
	}

	public static void invalidDataMessage() 
	{
		System.out.println("invalid entry. please enter a valid entry");
	}
	
}
