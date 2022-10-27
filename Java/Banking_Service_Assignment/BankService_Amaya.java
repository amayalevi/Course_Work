//BankService_Amaya.java
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * This is the Driver Class for the Account_Amaya Data Class.
 */
public class BankService_Amaya {
	/*
	 * This is the main method for the Driver Class.
	 */
	public static void main(String[] args) {
		//Data class variable declaration
		Account_Amaya account = null;
		//Scanner object to read input
		Scanner keyboard = new Scanner(System.in);
		//integer for saving input
		int choice;
		//This do-while loop displays the menu as long as '0' is not selected.
		do{
			//These statements display the menu.
			System.out.println("MAIN MENU");
			System.out.println("1.    Open new account");
			System.out.println("2.    Check current balance");
			System.out.println("3.    Deposit");
			System.out.println("4.    Withdraw");
			System.out.println("5.    Print monthly statement");
			System.out.println("0.    Exit");
			
			System.out.println("\nPlease select from the following options:");
			//reading input as an integer
			choice = keyboard.nextInt();
			//consuming the leftover newline in stream
			keyboard.nextLine();
			//this switch statement uses the input variable to determine which task to execute
			switch(choice)
			{
			//task 1 initializes the account variable through the task1 method. 
			case 1:
				//the new account from task1() is assigned to the account variable.
				account = task1(account);
				break;
			//task 2 calls the currentBalance method.
			case 2:
				//Tasks 2-5 check if an account exists. If not, the task1 method is called.
				if(account == null)
				{
				System.out.println("YOU HAVE TO OPEN ACCOUNT BEFORE SELECTING THIS TASK\n");
				account = task1(account);
				}
				account.currentBalance();
				break;
			//task 3 asks for an amount and sends it to the deposit method.
			case 3:
				if(account == null)
				{
				System.out.println("YOU HAVE TO OPEN ACCOUNT BEFORE SELECTING THIS TASK\n");
				account = task1(account);
				}
				System.out.println("Enter the amount you wish to deposit:");
				double deposit = keyboard.nextDouble();
				keyboard.nextLine();
				account.deposit(deposit);
				break;
			//task 4 asks for an amount and sends it to the withdraw method.
			case 4:
				if(account == null)
				{
				System.out.println("YOU HAVE TO OPEN ACCOUNT BEFORE SELECTING THIS TASK\n");
				account = task1(account);
				}
				System.out.println("Enter the amount you wish to withdraw:");
				double withdraw = keyboard.nextDouble();
				keyboard.nextLine();
				account.withdraw(withdraw);
				break;
				//task 5 prints a monthly statement by calling the printMonthly method.
			case 5:
				if(account == null)
				{
				System.out.println("YOU HAVE TO OPEN ACCOUNT BEFORE SELECTING THIS TASK\n");
				account = task1(account);
				}
				account.printMonthly();
				break;
			//choice 0 exits the do-while loop
			case 0:
				break;
				//displays invalid choice as default
			default:
				System.out.println("Invalid choice, please try again.");
			}
		//Loop continues to execute until choice = 0.
		}while(choice != 0);
	//Exit message upon the termination of this program.	
	JOptionPane.showMessageDialog(null, "\"Thank you. The application is terminating..\"");	
	System.exit(0);//Terminates JOptionPane	
	}//end main
	/*
	 *This method creates and returns a new Account_Amaya object. 
	 */
	public static Account_Amaya task1(Account_Amaya account)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please select an account type: \"1\" for Checking OR \"2\" for Saving");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		//This switch statement decides between initializing a Checking or Saving Account.
		switch(choice)
		{
		//This case initializes a Checking Account
		case 1:			
			System.out.println("Please enter your first name:");
			String first = keyboard.nextLine();
			System.out.println("Please enter your last name:");
			String last = keyboard.nextLine();
			System.out.println("Please enter your address:");
			String address = keyboard.nextLine();
			
			System.out.println("Enter the account's Service Fee:");
			double fee = keyboard.nextDouble();
			keyboard.nextLine();
			account = new CheckingAccount_Amaya(first,last,address,fee);
			System.out.println("Enter the down payment for the account:");
			double downC = keyboard.nextDouble();
			keyboard.nextLine();	
			account.openAccount(downC);
			return account;
		//This case intializes a Saving Account	
		case 2:
			System.out.println("Please enter your first name:");
			first = keyboard.nextLine();
			System.out.println("Please enter your last name:");
			last = keyboard.nextLine();
			System.out.println("Please enter your address:");
			address = keyboard.nextLine();
			
			System.out.println("Enter the account's Interest Rate:");
			double rate = keyboard.nextDouble();
			keyboard.nextLine();			
			account = new SavingAccount_Amaya(first,last,address,rate);
			System.out.println("Enter the down payment for the account:");
			double downS = keyboard.nextDouble();
			keyboard.nextLine();	
			account.openAccount(downS);
			return account;
		//default is for any invalid choices.	
		default:
			System.out.println("Invalid Choice.");
			break;
		}
		//This statement is a fail-safe for the task1 method.
		return account;
	}
	
}//end Class
