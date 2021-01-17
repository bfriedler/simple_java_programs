package supermarket;

public class Item 
{
	private int [] upcArray;
	private String upc;
	private String name;
	private String company;
	private Category category;
	private double price;
	
	public Item()
	{
		;
	}
	
	//**need setters now**
	public Item(String upc ) 
	{	
		verifyUPCLength(upc);
		this.upc=upc;//for the getter
		makeUPCArray(upc);	
	}
	
	public Item(String name, String company, String upc, Category category, double price)
	{
		verifyUPCLength(upc);
		this.name=name;
		this.company=company;
		this.upc=upc;//for the getter
		makeUPCArray(upc);
		this.category=category;	
		this.price=price;
	}
	/*public Item(int upc)
	{
		String temp = Integer.toString(upc);
		makeUPCArray(temp);
		
		
	}*/
	public Item copy(Item i)
	{
		return new Item(i.name, i.company, i.upc, i.category, i.price);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public String getUPC() 
	{
		return upc;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	private void verifyUPCLength(String upc)
	{
		if(upc.length() !=12 && upc.length() !=13)
		{
			Exception e = new IllegalArgumentException ("error: upc may only be either 12 or 13 digits");
			System.out.println(e.getMessage());//change this
			System.exit(1);	
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category != other.category)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (upc == null) {
			if (other.upc != null)
				return false;
		} else if (!upc.equals(other.upc))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("Item Name: "+name);
		s.append(" Category: "+category);
		s.append(" Company: "+company);
		s.append(" UPC: "+upc);
		s.append(" Price: "+price);
		
		return s.toString();
	}

	private void makeUPCArray(String upc)
	{
		this.upcArray= new int[upc.length()];
		for(int i=upcArray.length-1; i>=0; i--)
		{
			this.upcArray[(upcArray.length-1)-i]=Character.getNumericValue(upc.charAt(i));
		}	
	}
	
	public boolean verify(Item item)
	{
		
		int total=0;
		int checkDigit;
		
		total+=addOddNums(item.upcArray);
		total *=3;
		total+=addEvenNums(item.upcArray);
		
		if(upcArray.length==12) 
		{
			if(total%10==0)
			{
				checkDigit=0;
			}
			else
			{
				
				checkDigit= 10-(total%10);
			}
		}
		
		else
		{
			String checkDigitString=Integer.toString(total);
			int finalDigit = (Character.getNumericValue(checkDigitString.charAt(checkDigitString.length()-1)));
			checkDigit=10-finalDigit;
		}
		
		if (checkDigit==upcArray[0])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	private int addOddNums(int [] upcArray)
	{
		int sum=0;
		for(int i=upcArray.length-1; i>=1; i--)//change to other way?
		{
			if((i%2) !=0)
			{
				sum+=upcArray[i];
			}
		}
		
		return sum;
	}
	
	
	private int addEvenNums(int [] upcArray)
	{
		int sum=0;
		for(int i=upcArray.length-1; i>=1; i--)
		{
			if((i%2)==0)
			{
				sum+=upcArray[i];
			}
		}
		
		return sum;
	}
}
