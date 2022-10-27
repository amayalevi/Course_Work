import java.io.IOException;//Needed in case of file error
import java.util.Scanner;//Needed to receive user input
/*
 * This is the Driver Class for the Credit Card Account Data Class
 */
public class SU2018LAB5_CreditCardService_Amaya {

	/*
	 * This is the Main Method.
	 */
	public static void main(String[] args) throws IOException
	{
		
		int choice=0;//This int if the loop control variable for the Task Menu.
		Scanner keyboard = new Scanner(System.in);
		//Creating an object using the no-arg constructor
		SU2018LAB5_CreditCardAccount_Amaya account = new SU2018LAB5_CreditCardAccount_Amaya();
		//Displaying the Task Menu in a do-while loop.
		do{		
		System.out.println("CREDIT CARD SERVICE MENU\r\n" + 
				"1. Open new credit card\r\n" + 
				"2. One transaction\r\n" + 
				"3. Print statement\r\n" + 
				"4. Payment\r\n" + 
				"5. Get Available credit amount\r\n" + 
				"6. Get Interest rate\r\n" + 
				"0. Exit\n ");
		System.out.print("Enter choice here(1-6): ");
		choice = keyboard.nextInt();//Saving user choice
		keyboard.nextLine();//Removing leftover newLine
		//The switch Statement which handles the method calls
		switch(choice)
		{
		case 1://Asking for user information
			System.out.println("Please enter your name: ");
			String name = keyboard.nextLine();
			System.out.println("Please enter your Social Security Number: ");
			String ssNumber = keyboard.nextLine();
			System.out.println("Please enter your phone number: ");
			String phone = keyboard.nextLine();
			System.out.println("Please enter your address: ");
			String address = keyboard.nextLine();
			System.out.println("Please enter your username: ");
			String username = keyboard.nextLine();
			System.out.println("Please enter your password: ");
			String password = keyboard.nextLine();
			//Creating new object using the Parameter Constructor.
			//Sending input as values to the Constructor
			account = new SU2018LAB5_CreditCardAccount_Amaya(name,ssNumber,phone,
					address,username,password);
			//Displaying the Account info by calling the task1 method
			System.out.println(account.task1());
			break;
			//Task 2 asks for username and password again.
		case 2:			
			System.out.println("Please enter your username: ");
			username = keyboard.nextLine();
			System.out.println("Please enter your password: ");
			password = keyboard.nextLine();
			//Sending username and password to the task2 method
			account.task2(username,password);
			break;
			//Task3 method call
		case 3:
			account.task3();
			break;
			//Task 4 handles a payment for the credit card.
		case 4:
			System.out.println("Please enter the payment amount: ");
			double amount = keyboard.nextInt();
			keyboard.nextLine();
			//calling the task 4 method and sending the payment amount.
			account.task4(amount);
			break;
			//Calling the task 5 method
		case 5:
			account.task5();
			break;
			//Calling the task 6 method
		case 6:
			account.task6();
			break;
			//Choosing 0 exits the program
		case 0:
			choice =0;
			break;
			//Default case if input if invalid.
		default:
			System.out.print("\n**Invalid choice. Please select from the following options.**\n");
			break;
		}
		
		}
		while(choice != 0);//do-while loop end
		//Last program message
		System.out.println("\n   * * * * * * * * * * * * * * *    ");
		System.out.println("***Thank you for banking with us.***");
		System.out.println("   * * * * * * * * * * * * * * *    ");

		
	}
}
