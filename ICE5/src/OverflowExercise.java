import java.util.Scanner;

public final class OverflowExercise
{
	public static void main(String[] args)
	{
		short acctBal = Short.MAX_VALUE - 3000; // Take note of the data type for acctBal!
		
		String input = "0";
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("You currently have an account balance of $" + acctBal + ".");
			System.out.print("Deposit how much? ");
			
			input = scanner.nextLine().trim();
			
			try
			{
				// Used 2147483647
				Math.addExact(acctBal, Integer.parseInt(input));
				//tryDeposit(Integer.parseInt(input), acctBal);
				//acctBal += Integer.parseInt(input);
			}
			catch(NumberFormatException nfe)
			{
				if(input.toLowerCase().equals("quit"))
				{
					break;
				}
				else
				{
					System.out.println("Sorry, I don't recognize that number.");
				}
			}catch(ArithmeticException mathExce)
			{
				System.out.println("Number would be larger than $" + Short.MAX_VALUE);
			}
		}
		
		System.out.println("Thank you, and goodbye.");
		scanner.close();
	}	
	
	private static void tryDeposit(int incoming, short acctBal)
	{
		if(incoming + acctBal > Short.MAX_VALUE)
		{
			throw new ArithmeticException();
		}else
		{
			acctBal += incoming;
		}
	}
}
