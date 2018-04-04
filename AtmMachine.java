import java.util.Scanner;

public class AtmMachine
{
	
	private double totalBal =1000;
	Scanner input = new Scanner(System.in);

	public String userAccount()
	{
		System.out.print("Enter your account number: ");
		String account;
		account = input.nextLine();
		if(account.length()==16)
			return account;
		else
		{
			System.out.println("Invalid account number");
			return userAccount();
		}
	}

	public String userPin()
	{
		System.out.print("Enter your pin number: ");
		String pin;
		pin =input.nextLine();
		if(pin.length()==4)
		return pin;
		else
		{
			System.out.println("Invalid pin number");
			return userPin();
		}
	}

	public void startAtm()
	{
		userAccount();
		userPin();
		drawMainMenu();
	}

	public void drawMainMenu()
	{
		int selection;

		System.out.println("\nATM main menu:");
		System.out.println("1 - View account balance");
		System.out.println("2 - Withdraw funds");
		System.out.println("3 - Add funds");
		System.out.println("4 - Terminate transaction");
		System.out.print("Choice: ");
		selection =input.nextInt();

		switch(selection)
		{
			case 1:
			viewAccountInfo();
			break;
			case 2:
			withdraw();
			break;
			case 3:
			addFunds();
			break;
			case 4:
			System.out.println("Thank you for using this ATM!!! goodbye");
		}
	}

	public void viewAccountInfo()
	{
		System.out.println("Account Information:");
		System.out.println("\t--Total balance: $"+totalBal);
		
		System.out.println("Thank you for using this ATM!!! goodbye");
	}

	public void deposit(int depAmount)
	{
		System.out.println("\n***Please insert your money now...***");
		totalBal =totalBal +depAmount;
	}	

	public void checkNsf(int withdrawAmount)
	{
		if(totalBal -withdrawAmount < 0)
			System.out.println("\n***ERROR!!! Insufficient funds in you accout***");
		else
		{
			totalBal =totalBal -withdrawAmount;
			
			System.out.println("\n***Please take your money now...***");
		}
	}

	public void addFunds()
	{
		int addSelection;

		System.out.println("Deposit funds:");

		addSelection =input.nextInt();

		deposit(addSelection);
		
	}

	public void withdraw()
	{
		int withdrawSelection;

		System.out.println("Withdraw money:");

		withdrawSelection =input.nextInt();

		checkNsf(withdrawSelection);
		drawMainMenu();
	}

	public static void main(String args[])
	{
		AtmMachine myAtm = new AtmMachine();
		myAtm.startAtm();
	}
}
