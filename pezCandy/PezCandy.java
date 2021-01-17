package pezCandy;

import java.util.*;

public class PezCandy 
{
	public static void main(String[] args)
	{		
		Stack<PezColor> pezStack = generatePezPackage();
		System.out.println("Original Pez package:");
		System.out.println(pezStack);
		pezStack=removeAllReturnNonYellow(pezStack);
		System.out.println("Pez Package after Phil ate yellows:");
		System.out.println(pezStack);
	}
	
	/**
	 * Generates a pez package with random colors
	 * @return
	 */
	public static Stack<PezColor> generatePezPackage()
	{
		Stack<PezColor> pezStack = new Stack<>();
		Random rand = new Random();
		int c;
		for (int i=0; i<12; i++)
		{
			c=rand.nextInt(4);
			if(c==0)
			{
				pezStack.push(PezColor.ORANGE);
			}
			else if(c==1)
			{
				pezStack.push(PezColor.PINK);
			}
			else if(c==2)
			{
				pezStack.push(PezColor.PURPLE);
			}
			else
			{
				pezStack.push(PezColor.YELLOW);
			}
		}
		
		return pezStack;
	}
	
	/**
	 * This method removes all the pez, if it is non yellow
	 * it adds it to a new stack. Then it transfers the new 
	 * stack to the old stack, in order to preserve th order
	 * @param pezStack accepts the original package
	 * @return
	 */
	public static Stack<PezColor> removeAllReturnNonYellow(Stack<PezColor> pezStack)
	{
		PezColor pc;
		Stack <PezColor> removed = new Stack<>();
		for(int i=0; i<12; i++)
		{
			pc = pezStack.peek();
			if(pc.equals(PezColor.YELLOW))
			{
				pezStack.pop();
			}
			else
			{
				removed.push(pezStack.pop());
			}
		}
		
		while (!removed.empty())
		{
			pezStack.push(removed.pop());
		}
		
		return pezStack;
	}
}
