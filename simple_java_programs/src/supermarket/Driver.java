//exception in item
package supermarket;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver 
{
	public static void main(String[] args)
	{
		
			ArrayList <Purchase> purchases = new ArrayList <>();
			ArrayList<Item> items = new ArrayList<>();
			FoodItem sourSticks = new FoodItem("soursticks", "paskez", "036000241457", Category.SNACK, 2.99, LocalDate.parse("2020-12-01"));
			FoodItem cucumbers=new FoodItem("cucumbers","farmerfresh", "7290000572673", Category.PRODUCE, .50, LocalDate.parse("2020-10-23"));
			FoodItem babyCorn = new FoodItem("baby corn", "gefen", "306000241457", Category.CAN, 1.25, LocalDate.parse("2021-10-17"));
			FoodItem pizzaBagels = new FoodItem("pizza bagels", "amnon's", "630000241457", Category.FROZEN, 8.99, LocalDate.parse("2020-12-10"));
			Item garbageBags = new Item("garbage bags", "glad", "236000041457", Category.OTHER, 4.99);
			Item plasticForks = new Item("plastic forks", "goodie papergoods", "436000201457", Category.OTHER, 5.99);
			Item flour = new Item("flour", "gefen", "1036000240457", Category.OTHER, 2.99);
			items.add(sourSticks);
			items.add(cucumbers);
			items.add(babyCorn);
			items.add(pizzaBagels);
			items.add(garbageBags);
			items.add(plasticForks);
			items.add(flour);
			
			Scanner keyboard= new Scanner(System.in);
			int choice=0;
			while(choice !=6)
			{
				System.out.println("To record purchases, enter 1");
				System.out.println("To find a purchase, enter 2");
				System.out.println("To get the total cost of a purchase, enter 3");
				System.out.println("To get the tax incurred for a specific purchase, enter 4");
				System.out.println("To list all purchases recorded, enter 5");
				System.out.println("To exit, enter 6");
				choice=keyboard.nextInt();
				keyboard.nextLine();
				if(choice == 1)
				{
					addPurchases(keyboard, items, purchases);
				}
				else if (choice == 2)
				{
					Purchase p = makeTemp(keyboard, purchases);
					if(p==null)
					{
						System.out.println("purchase not found");
						
					}
					else
					{
						System.out.println(p);
						System.out.println();
					}
				}
				else if (choice ==3)
				{
					Purchase p = makeTemp(keyboard, purchases);
					if(p !=null)
					{
						System.out.printf("Purchase cost: $%,.2f", p.getPurchaseCost());
						System.out.println();
					}
					else
					{
						System.out.println("Purchase not found");
					}
				}
				else if (choice==4)
				{
					Purchase p=makeTemp(keyboard, purchases);
					if(p != null)
					{
						System.out.printf("Tax: $%,.2f", p.getTax());
						System.out.println();
					}
					else
					{
						System.out.println("purchase not found. ");
					}
					
				}
				else if (choice==5)
				{
					for(int i = 0; i<purchases.size(); i++)
					{
						System.out.println("Purchase 1:"+purchases.get(i).getCustomerName()+" "+purchases.get(i).getPurchaseDate());
					}
					System.out.println();
				}
				else if(choice==6)
				{
					System.exit(0);
				}
				else
				{
					System.out.println("invalid entry");
					continue;
				}
			}
			System.out.println("Goodbye!");
	}
	
	public static void addPurchases(Scanner keyboard, ArrayList<Item> items, ArrayList<Purchase> purchases)
	{
		String customerName;
		String purchaseDate;
		String again="y";
		int quantity;
		
		System.out.println("let's enter a purchase. To begin, press any key.");
		keyboard.nextLine();
		
		while(again.equalsIgnoreCase("y"))
		{
			System.out.println("Enter customer name: ");
			customerName=keyboard.nextLine();
			System.out.println("Enter purchase date: (yyyy-mm-dd)");
			purchaseDate=keyboard.nextLine();
			Purchase purchase=new Purchase(customerName, purchaseDate);
			System.out.println("Now lets add items. To continue adding items, press enter. To stop, press s.");
			String anotherItem="c";
			boolean validItem;
			while(!anotherItem.equalsIgnoreCase("s"))
			{
				validItem=false;
				System.out.print("Item: ");
				String itemName=keyboard.nextLine();
				for(int i=0; i<items.size(); i++)
				{
					if(itemName.equalsIgnoreCase(items.get(i).getName()))
					{
						validItem=true;
						System.out.print("quantity: ");
						quantity=keyboard.nextInt();
						keyboard.nextLine();
						purchase.addPurchasedItem(new PurchasedItem (items.get(i).copy(items.get(i)),quantity ,items.get(i).getPrice()));
						System.out.println("Item added.");
						break;
					}
				}
				if (validItem==false)
				{
					System.out.println("INVALID ITEM");
					continue;
				}
				
				anotherItem=keyboard.nextLine();
			}
			purchases.add(purchase);
			System.out.println("purchase recorded. ");
			System.out.println("Enter another purchase? (enter y for yes): ");
			again = keyboard.nextLine();		
		}
		System.out.println("Purchases stored in list.");
	}
	
	public static Purchase findPurchase(ArrayList<Purchase> purchases, String customerName, String purchaseDate)
	{
		Purchase temp = new Purchase(customerName, purchaseDate);
		for(int i=0; i<purchases.size(); i++)
		{
			if(purchases.get(i).equals(temp))
			{
				return(purchases.get(i));
			}
		}
		return null;
	}
	
	public static Purchase makeTemp(Scanner keyboard, ArrayList<Purchase> purchases)
	{
		System.out.println("Enter customer name: ");
		String customerName = keyboard.nextLine();
		System.out.println("Enter purchase date: (yyyy-mm-dd)");
		String purchaseDate = keyboard.nextLine();
		Purchase p = findPurchase(purchases, customerName, purchaseDate);
		return p;
	}

}
