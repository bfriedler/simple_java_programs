/**
 * This program lets a user input data for either a cruise or cargo ship, then displays the data.
 */
package cruiseAndCargoShips;

import java.util.*;
import java.time.LocalDate;

public class ShipProgram
{
	public static void main(String[] args) 
	{
		ArrayList <CruiseShip> cruiseShips= new ArrayList<>();
		ArrayList <CargoShip> cargoShips= new ArrayList<>();
		Scanner keyboard = new Scanner(System.in);
		String again="Y";
		String shipName;
		String yearBuilt;
		int shipOption;
		String shipType;
		try
		{
			System.out.println("Welcome to the Ship Data program!");
			System.out.println("Press any key to get started!");
			keyboard.nextLine();
			do 
			{
				shipOption=shipMenu(keyboard);
				shipType=getShipType(shipOption);
				System.out.println("Okay, lets enter the data for a "+shipType+" ship:");
				shipName=inputShipName(keyboard);
				yearBuilt=inputYearBuilt(keyboard);
				
				if (shipOption==1) 
				{
					enterCruiseShip(cruiseShips, shipName, yearBuilt, keyboard);
				}
				
				else
				{
					enterCargoShip(cargoShips, shipName, yearBuilt, keyboard);
				}
				
				System.out.printf("Would you like to create another ship entry? (enter Y for yes)");
				again=keyboard.nextLine();
			} while (again.toUpperCase().equals("Y"));
			displayShips(cruiseShips, cargoShips);

		}
		catch(RuntimeException e) 
		{
			System.out.print("ERROR: ");
			System.out.println(e.getMessage());
			System.exit(1);
		}	
	}
	
	
	/**
	 * Lets the user chose 1 to enter a cruise ship, or 2 to enter a cargo ship
	 * @param keyboard
	 * @return the user option
	 */
	public static int shipMenu(Scanner keyboard)
	{
		System.out.println("To create a cruise ship entry, enter 1");
		System.out.println("To create a cargo ship entry, enter 2");
		
		int option = keyboard.nextInt();
		
		while(option !=1 && option !=2) 
		{
			try 
			{
				System.out.println("That is not a valid option. Please enter 1 or 2, or any letter to exit");
				option=keyboard.nextInt();
			}
			
			catch (InputMismatchException e)
			{
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
		keyboard.nextLine();
		
		return option;
	}
	
	/**
	 * receives the user option and returns either the string "cruise" or "cargo"
	 * @param shipOption
	 * @return String "cruise" or String "option"
	 */
	public static String getShipType(int shipOption) 
	{
		if(shipOption==1) 
		{
			return "cruise";
		}
		
		else 
		{
			return "cargo";
		}
	}

	/**
	 * user inputs the ship name
	 * @param keyboard
	 * @return the shipName
	 */
	public static String inputShipName(Scanner keyboard)
	{
		System.out.printf("ship name: ");
		String shipName=keyboard.nextLine();
		
		return shipName;
	}
	
	/**
	 * user inputs the year built
	 * @param keyboard
	 * @return the year built
	 */
	public static String inputYearBuilt(Scanner keyboard) 
	{
		System.out.printf("year built: ");
		int yearBuilt=keyboard.nextInt();
		while(Integer.valueOf(yearBuilt)>LocalDate.now().getYear()|| Integer.valueOf(yearBuilt)<0)
		{
			invalidDataMessage();
			yearBuilt=keyboard.nextInt();	
		}
		
		return Integer.toString(yearBuilt);
	}
	
	/**
	 * User finishes entering data about ship. the method then creates the ship and adds it to an ArrayList of cruise ships
	 * if the user wants to add passengers now then it brings them to the addPassenger method
	 * @param cruiseShips the ArrayList of cruise ships
	 * @param shipName
	 * @param yearBuilt
	 * @param keyboard
	 */
	public static void enterCruiseShip(ArrayList <CruiseShip> cruiseShips, String shipName, String yearBuilt, Scanner keyboard)
	{
		int maxPassengers;

		System.out.print("maximum passengers: ");
		maxPassengers=keyboard.nextInt();
		while (maxPassengers<=0) 
		{
			invalidDataMessage();
			maxPassengers=keyboard.nextInt();		
		}
		keyboard.nextLine();
		CruiseShip cruiseShip=new CruiseShip(shipName, yearBuilt, maxPassengers);
		cruiseShips.add(cruiseShip);
		System.out.println("Okay, we got your ship info. Would you like to add passengers now? (enter Y for yes):  ");
		if(keyboard.nextLine().toUpperCase().equals("Y"))
		{
			addPassengers(cruiseShips, keyboard, cruiseShip);
		}
		else{
			System.out.print("Okay. ");
		}
		
		
	}

	/**
	 * User finishes entering data for a cargo ship. ship is created and added to an ArrayList of cargo ships
	 * @param cargoShips the ArrayList of cargo ships
	 * @param shipName
	 * @param yearBuilt
	 * @param keyboard
	 */
	public static void enterCargoShip(ArrayList <CargoShip> cargoShips, String shipName, String yearBuilt, Scanner keyboard)
	{
		int cargoCapacity;
		System.out.print("cargo capacity, in tonnage: ");
		cargoCapacity=keyboard.nextInt();
		while(cargoCapacity<=0 || cargoCapacity>100000) 
		{
			invalidDataMessage();
			cargoCapacity=keyboard.nextInt();		
		}
		keyboard.nextLine();
		CargoShip c=new CargoShip(shipName, yearBuilt, cargoCapacity);
		cargoShips.add(c);
		System.out.println("\nShip Data Entered\n");
	}
	
	/**
	 * displays invalid data message and prompts user to reenter correct data
	 */
	public static void invalidDataMessage() 
	{
		System.out.println("invalid entry. please enter a valid entry");
	}
	
	/**
	 * user inputs passenger info. passenger is added to cruise ship
	 * @param cruiseShips cruise ship ArrayList
	 * @param keyboard
	 * @param c the specific cruise ship to add the passengers to
	 */
	public static void addPassengers(ArrayList <CruiseShip> cruiseShips, Scanner keyboard, CruiseShip c) 
	{
		String another;
		String firstName;
		String lastName;
		Gender gender;
		String genderString;
		Address address;
		String streetAddress;
		String city;
		String state;
		String zip;
		String birthdate;
		String year;
		int month;
		int day;
		String passport;
		int luggage;
		int num;
		
		System.out.println("Okay. Let's enter passenger information.");
		do 
		{
			System.out.println("Passenger "+(c.getCurrentPassengerAmount()+1));
			System.out.print("first name: ");
			firstName=keyboard.nextLine();
			System.out.print("last name: ");
			lastName=keyboard.nextLine();
			System.out.print("Gender: (Enter F for female or M for male): ");
			genderString=keyboard.nextLine().toUpperCase();
			while(!genderString.equals("F") && !genderString.equals("M"))
			{
				invalidDataMessage();
				genderString=keyboard.nextLine().toUpperCase();
			}
			if (genderString.equals("F"))
			{
				gender=Gender.F;
			}
			else
			{
				gender=Gender.M;
			}
			System.out.println("Address");
			System.out.print("street address: ");
			streetAddress=keyboard.nextLine();
			System.out.print("city: ");
			city=keyboard.nextLine();
			System.out.print("state: ");
			state=keyboard.nextLine();
			System.out.print("ZIP code: ");
			zip=keyboard.nextLine();
			while(zip.length()<5 || zip.length()>9) // > 9 because some ZIPs have a four digit addition with a dash
			{
				invalidDataMessage();
				zip=keyboard.nextLine();
			}
			System.out.println("Date of Birth ");
			do
			{
				System.out.print("month NUMBER: ");
				num=getNum(keyboard);
				keyboard.nextLine();
				while(num<1 || num > 12)
				{
					invalidDataMessage();
					num=getNum(keyboard);
					keyboard.nextLine();
				}
			}while(num==-1);
			month=num;
			System.out.print("day: ");
			day=keyboard.nextInt();
			while(day<0 || day>31)
			{
				invalidDataMessage();
				day=keyboard.nextInt();			
			}
			keyboard.nextLine();
			System.out.print("Year: ");
			year=keyboard.nextLine();
			while(Integer.valueOf(year)<LocalDate.now().getYear()-125 || Integer.valueOf(year)>LocalDate.now().getYear()) 
			{
				invalidDataMessage();
				year=keyboard.nextLine();
			}
			
			System.out.print("passport ID:");
			passport=keyboard.nextLine();
			while(passport.length()<6 || passport.length()>9)
			{
				invalidDataMessage();
				passport=keyboard.nextLine();
			}
			System.out.println("amount of luggage pieces: (max 9): ");
			luggage=keyboard.nextInt();
			while (luggage<0 || luggage > 9) 
			{
				invalidDataMessage();
				luggage=keyboard.nextInt();
			}
			keyboard.nextLine();
			
			
			address = new Address(streetAddress, city, state, zip);
			birthdate=String.format(year+"-%02d-%02d",month, day);
			Passenger p = new Passenger(firstName, lastName, gender, address, birthdate, passport, luggage);
			if(!c.getPassengers().contains(p)) 
			{
				c.addPassenger(p);
				System.out.println("Passenger Added\n");
			}
			else 
			{
				System.out.println("ERROR: THIS PASSENGER ALREADY EXISTS\n");
			}

			if(c.getCurrentPassengerAmount()==c.getMaxPassengers()) 
			{
				System.out.println("Ship is now full");
				break;
			}
			System.out.print("Add another passenger? (enter Y for yes): ");
			another=keyboard.nextLine();
			System.out.println();
		}while (another.toUpperCase().equals("Y") && c.getCurrentPassengerAmount()<c.getMaxPassengers());// I know its double validation but just in case
	}
	
	/**
	 * gets a number for the month. catches if user enters letters by mistake
	 * @param keyboard
	 * @return the month number
	 */
	public static int getNum(Scanner keyboard) 
	{
		int num;
		
		try 
		{
			num=keyboard.nextInt();
		}
		
		catch(InputMismatchException e) 
		{
			invalidDataMessage();
			num=-1;
			keyboard.nextLine();
		}
		
		return num;
	}
	
	/**
	 * Displays the ships with all their info
	 * @param cruiseShips cruise ship ArrayList
	 * @param cargoShips cargoShip ArrayList
	 */
	public static void displayShips(ArrayList<CruiseShip> cruiseShips, ArrayList <CargoShip> cargoShips) 
	{
		if(cruiseShips.size() !=0) 
		{
			System.out.println("\nCruise Ships");
			System.out.println();
			for(CruiseShip c: cruiseShips) 
			{
				System.out.println(c);
			}
		}
		if(cargoShips.size() !=0) 
		{
			System.out.println("Cargo Ships");
			System.out.println();
			for(CargoShip c: cargoShips) 
			{
				System.out.println(c);
			}
		}
		
	}
	
	
}
