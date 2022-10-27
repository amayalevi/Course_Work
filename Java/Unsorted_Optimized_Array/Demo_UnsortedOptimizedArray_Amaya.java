// Demo_UnsortedOptimizedArray_Amaya
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;	

public class Demo_UnsortedOptimizedArray_Amaya {
	
	
/*
 * This is the Main method of this program.
 */
	public static void main(String[] args)
	{
		Account_UnsortedOptimizedArray accountArray = new Account_UnsortedOptimizedArray();
		Scanner keyboard = new Scanner(System.in);
		int choice;
		//do while loop that handles the Menu.
		do {
			
			
			System.out.println("1.   Insert One Account");
			System.out.println("2.   Verify encapsulation of Unsorted Optimized Array");
			System.out.println("3.   Update an account");
			System.out.println("4.   Remove an account");
			System.out.println("5.   Show all accounts");
			System.out.println("0.   Exit");
			
			System.out.println("Please select an option from the menu:");
			choice = keyboard.nextInt();
			keyboard.nextLine(); //consume leftover newline in input stream.
		
			switch(choice)
			{
			// 1.	Insert
			case 1:
				insert(accountArray);
				break;
			// 2.	Verify	
			case 2:
				verify(accountArray);
				break;
			// 3.	Update
			case 3:
				update(accountArray);
				break;
			//4.	remove
			case 4:
				remove(accountArray);
				break;
			//5.	showAll	
			case 5:
				showAll(accountArray);
				break;
			//0.	Exit
			case 0:
				break;
			//Incorrect Input
			default:
				System.out.println("Incvalid choice. Please select from the choices in the Menu.");
				break;
			}
		}while(choice != 0);	//0 exits the loop
	}	//end of main method
	/*
	 * Insert method for Menu choice 1: Insert One Account
	 */
	public static Account_Amaya insert(Account_UnsortedOptimizedArray accountArray)
	{
		Account_Amaya account = null;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please select an account type: \"1\" for Checking OR \"2\" for Saving");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		
		//Asking for information
		System.out.println("Please enter your first name:");
		String first = keyboard.nextLine();
		System.out.println("Please enter your last name:");
		String last = keyboard.nextLine();
		System.out.println("Please enter your address:");
		String address = keyboard.nextLine();
		//This switch statement decides between initializing a Checking or Saving Account.
		switch(choice)
		{
		//This case initializes a Checking Account
		case 1:					
			System.out.println("Enter the account's Service Fee:");
			double fee = keyboard.nextDouble();
			keyboard.nextLine();
			account = new CheckingAccount_Amaya(first,last,address,fee);
			break;
		//This case intializes a Saving Account	
		case 2:	
			System.out.println("Enter the account's Interest Rate:");
			double rate = keyboard.nextDouble();
			keyboard.nextLine();			
			account = new SavingAccount_Amaya(first,last,address,rate);
			break;
		//default is for any invalid choices.	
		default:
			System.out.println("Invalid Choice.");
			break;
		}
		//Setting down payment in account
		System.out.println("Enter the down payment for the account:");
		double down = keyboard.nextDouble();
		keyboard.nextLine();	
		account.openAccount(down);
		
		//Inserting into Account_UnsortedOptimizedArray
		if(accountArray.insert(account))
			javax.swing.JOptionPane.showMessageDialog(null,"Insert Account - *Success*\n");
		else
			javax.swing.JOptionPane.showMessageDialog(null,"Insert Account - *Failed*\n");
		return account;
	}
	/*
	 * Verify method for MENU choice 2: Verify Encapsulation
	 */
	public static void verify(Account_UnsortedOptimizedArray accountArray)
	{
		//Random object to change account value
		Random rand = new Random();
		int randnumber = rand.nextInt(10)+1;
		
		//Method Call asks for account and inserts
		Account_Amaya account = insert(accountArray);
		
		//Modify service fee or interest rate
		if(account.checkOrSave())
			//if true modify serviceFee		
			account.serviceFee += randnumber;
		else
			//if false modify interest rate
			account.interestRate += randnumber;
		
		//fetch encapsulated node and save to copy
		Account_Amaya copy = accountArray.fetch(account.accountNumber);
		
		//Checking to see if inserted Node is encapsulated
		if(account.checkOrSave())
		{
			if(account.serviceFee == copy.serviceFee)
				javax.swing.JOptionPane.showMessageDialog(null,"Unsorted Optimized Array is not encapsulated");
			else
				javax.swing.JOptionPane.showMessageDialog(null,"Unsorted Optimized Array is encapsulated");
		}
		else
		{
			if(account.interestRate == copy.interestRate)
				javax.swing.JOptionPane.showMessageDialog(null,"Unsorted Optimized Array is not encapsulated");
			else
				javax.swing.JOptionPane.showMessageDialog(null,"Unsorted Optimized Array is encapsulated");
		}
	}
	/*
	 * Update method for MENU choice 3.	Update an acccount
	 */
	public static void update(Account_UnsortedOptimizedArray accountArray)
	{
		Scanner keyboard = new Scanner(System.in);
		//Ask for account to insert
		Account_Amaya account = insert(accountArray);
		double newAmount;
		
		//Modifying the serice fee or interest rate
		if(account.checkOrSave())
		{
			//if true change service fee
			System.out.println("Please enter the new Service Fee: ");
			newAmount = keyboard.nextDouble();
			keyboard.nextLine();
			account.serviceFee = newAmount;
		}	
		else
		{
			//if false change interest rate
			System.out.println("Please enter the new Interest Rate: ");
			newAmount = keyboard.nextDouble();
			keyboard.nextLine();
			account.interestRate = newAmount;
		}
		//Update account in Data Structure
		if(accountArray.update(account.accountNumber, account))
			javax.swing.JOptionPane.showMessageDialog(null,"Update - *Succesfully*");
		else
			javax.swing.JOptionPane.showMessageDialog(null,"Update - *Failed*");
	}
	/*
	 * Remove method for MENU choice 4.	Remove an account
	 */
	public static void remove(Account_UnsortedOptimizedArray accountArray)
	{
		Scanner keyboard = new Scanner(System.in);
		//Ask for account number to remove
		System.out.println("Please enter the Account Number you wish to remove: ");
		//get input
		String delKey = keyboard.nextLine();
		//Delete account and verification
		if(accountArray.delete(delKey))
			javax.swing.JOptionPane.showMessageDialog(null,"Delete - *Successfully*");
		else
			javax.swing.JOptionPane.showMessageDialog(null,"Delete - *Failed*");		
	}
	/*
	 * Showall method for MENU choice 5. Show all accounts
	 */
	public static void showAll(Account_UnsortedOptimizedArray accountArray)
	{
		System.out.println(accountArray.showAll());
	}
}	// end of Demo Class
