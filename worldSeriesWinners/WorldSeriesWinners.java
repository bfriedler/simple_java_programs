package worldSeriesWinners;
/**
 * This program lets a user pick a team, then diplays how many times that 
 * team has won the world series between 1903 and 2009
 */
import java.io.*;
import java.util.Scanner;
public class WorldSeriesWinners {
	
	public static void main(String[]args) throws IOException, ArrayIndexOutOfBoundsException
	{	
		char again;
		String [] winnersList= new String[150];
		int i = 0;
		String searchTeam;
		Scanner keyboard = new Scanner(System.in);
		int totalWins;
		
		try 
		{
			File winners = new File("WorldSeriesWinners.txt");
			Scanner inputFile = new Scanner(winners);
			
			while(inputFile.hasNext()) 
			{
				winnersList[i]=inputFile.nextLine();
				i++;
			}
			inputFile.close();
			
		 }

		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(1);
		}
		
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("error-file to large!");
			System.exit(1);
		}

			do 
			{
				System.out.println("Enter a team name to see how many times it "+
									"won the world series between 1903 and 2009: ");
				
				searchTeam = keyboard.nextLine();
	
				totalWins= searchWinners(winnersList, i, searchTeam );
				
				displayResults(searchTeam, totalWins);
				
				System.out.println("Would you like to lookup another team? (enter 'Y' for yes): ");	
				again = keyboard.nextLine().charAt(0);
			
			}while (again=='Y'|| again=='y');
		
		keyboard.close();
		System.out.println("Goodbye!");
		
	}	
	/**
	 * This method goes through the array of teams and keeps a count of how many times the chosen
	 * team is there
	 * @param winnersList2 The array of World Series Winners.
	 * @param i2 An integer that is one more than how many filled in elements are in the array.
	 * @param searchTeam2 The team the user chose to search for.
	 * @return Returns how many times the chosen team has won.
	 */
	public static int searchWinners(String [] winnersList2, int i2, String searchTeam2)
	{
		int totalWins2=0;
	
		for ( int i=0; i<i2; i++)
		{
			if(winnersList2[i].equalsIgnoreCase(searchTeam2))
			{
				totalWins2+=1;
			}
		}
		
		return totalWins2;
	}
	/**
	 * This method displays the results of how many times the chosen team one.
	 * @param searchTeam2b The team the user chose.
	 * @param totalWins2 The amount of times that team has one.
	 */
	public static void displayResults(String searchTeam2b, int totalWins2) 
	{
		if (totalWins2==1) 
		{
			System.out.println("The "+searchTeam2b+" won the world series "+totalWins2+
					" time between 1903 and 2009.");
		}
		else
		{
			System.out.println("The "+searchTeam2b+" won the world series "+totalWins2+
							" times between 1903 and 2009.");
		}
	}
}
