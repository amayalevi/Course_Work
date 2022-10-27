//COSC2436_FA2018_BANK_SERVICE_Amaya.java
import java.io.File;//Needed for using Files
import java.io.FileNotFoundException;//Needed in case File is not found.
import java.io.PrintWriter;//Needed for Writing to Files
import java.util.LinkedList;//Needed to go through all nodes
import java.util.Scanner;//Needed for input(keyboard,files)

/*
 * This is the COSC2436_FA2018_BANK_SERVICE_Amaya driver class
 */
public class COSC2436_FA2018_BANK_SERVICE_Amaya {
	/*
	 * This is the main method of the program
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// BankCustomer Data Structure
		SinglyLinkedListIterator list = new SinglyLinkedListIterator();
		// Creating and opening input file
		File file = new File("bankCustomer.csv");
		Scanner inFile = new Scanner(file);
		// Welcome message
		System.out.println("**BANK SERVICE APPLICATION**");
		System.out.print("\nReading Input File...");

		// Reading each line
		while (inFile.hasNextLine()) {
			// Splitting input String 
			String[] input = inFile.nextLine().split(",");
			// Creating temp BankCustomer
			BankCustomer_Amaya temp = new BankCustomer_Amaya(input[0], input[1], input[2], input[3], input[4],
					input[5]);
			// temp int for counting
			int count = 6;
			while (count < input.length && input[count].compareTo("") != 0)// if next String is not empty AND not out of
																			// bounds, continue reading
			{
				// temp BankAccount for inserting
				BankAccount_Amaya tempAccount = new BankAccount_Amaya(input[count], Float.parseFloat(input[count + 1]));
				// Checking if Checking or Saving Account
				// by looking at the third variable
				if (Float.parseFloat(input[count + 3]) < 1.0f)
					tempAccount = new BankSavingAccount_Amaya(input[count], Float.parseFloat(input[count + 1]),
							Float.parseFloat(input[count + 2]), Float.parseFloat(input[count + 3]));
				else
					tempAccount = new BankCheckingAccount_Amaya(input[count], Float.parseFloat(input[count + 1]),
							Float.parseFloat(input[count + 2]), Float.parseFloat(input[count + 3]));
				// inserting Account to LinkedList
				temp.addNewAccount(tempAccount);
				// update
				count += 4;
			} // end of inner while loop
				// inserting BankCustomer to list before the next iteration
			list.insert(temp);
		} // end of reading while loop
		System.out.println("Done!");
		// Showing All Accounts
		System.out.println("\n**Showing All Accounts**");
		list.showAll();
		System.out.print("...Done!\n\n");

		// Menu variables
		int choice;
		Scanner keyboard = new Scanner(System.in);
		do {// User type selection dp-while loop
			do {// Main Menu do-while loop
				// Displaying Main Menu
				System.out.println("COSC2436 FA2018 BANK SERVICE APPLICATION");
				System.out.println("1.   Bank Employee");
				System.out.println("2.   Bank Customer");
				System.out.println("0.   Exit");
				// Reading and saving user input
				choice = keyboard.nextInt();
				keyboard.nextLine();// clearing leftover newLine character
				// invalid message if choice is invalid
				if (choice != 1 && choice != 2 && choice != 0)
					System.out.println("\n**INVALID INPUT**\n");
				// repeat menu if choice is invalid
			} while (choice != 1 && choice != 2 && choice != 0);

			// Main Menu switch statement
			switch (choice) {
			case 1:// Bank Employee
				employee(list);
				break;
			case 2:// Bank Customer
				customer(list);
				break;
			case 0:// Write to file and exit
					// Creating Output file
				PrintWriter outFile = new PrintWriter(file);
				// Reseting Data Structure Iterator
				list.i.reset();
				// Processing nodes
				System.out.print("** Writing Customers to File... ");
				while (list.i.hasNext()) {
					outFile.println(list.i.next().writeToFile());
				}
				// Done Writing
				outFile.close();
				System.out.println("Done! **\n");
				break;
			default:// Technically Unreachable
				break;
			}// end of menu switch statement
		} while (choice != 0);// continue looping while choice is not 0
		//Closing inFile
		inFile.close();
		// Terminating Program
		System.out.println("** Exiting Program... **");

	}// end of main method

	/*
	 * This is the employee method. It handles the Bank Employee Menu and
	 * corresponding tasks.
	 */
	public static void employee(SinglyLinkedListIterator list) {
		// variables for reading and Saving user input
		int choice;
		Scanner keyboard = new Scanner(System.in);
		do {// Employee program do-while loop
			do {// Menu do-while loop
				// Printing Employee Menu
				System.out.println("TASKS FOR BANK EMPLOYEES");
				System.out.println("1.   Add a New Customer – Open New Account");
				System.out.println("2.   Display a Customer With All Accounts");
				System.out.println("3.   Open New Account for Current Customer");
				System.out.println("4.   Read One Account of One Customer");
				System.out.println("5.   Remove One Account of Current Customer");
				System.out.println("6.   Display all Customers with their accounts");
				System.out.println("7.   Process Monthly Statement");
				System.out.println("0.   DONE");
				// reading input
				choice = keyboard.nextInt();
				keyboard.nextLine();
				// Print if choice is invalid
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
						&& choice != 7 && choice != 0)
					System.out.println("\n**INVALID INPUT**\n");
				// Repeat Menu if choice is invalid
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
					&& choice != 7 && choice != 0);
			// switch for Employee Menu
			switch (choice) {
			case 1:// Add a new Customer/Open Account
				System.out.println("Creating a new Customer with at least one account...");
				// Strings for creating new Customer
				String i, last, first, user, pass, add;
				// Asking customer for information
				System.out.println("Please enter your ID:");
				i = keyboard.nextLine();
				System.out.println("Please enter your first name:");
				first = keyboard.nextLine();
				System.out.println("Please enter your last name:");
				last = keyboard.nextLine();
				System.out.println("Please enter your username:");
				user = keyboard.nextLine();
				System.out.println("Please enter your password:");
				pass = keyboard.nextLine();
				System.out.println("Please enter your address:");
				add = keyboard.nextLine();
				// Creating Customer object
				BankCustomer_Amaya temp = new BankCustomer_Amaya(i, last, first, user, pass, add);
				// Creating BankAccount
				BankAccount_Amaya account = generateAccount(list);
				// adding new account
				temp.addNewAccount(account);
				// and inserting to structure
				System.out.println("\nInserting new Customer into Structure...");
				if (list.insert(temp)) {
					System.out.println("\n**Insert was Successful**\n");
					// displaying Customer
					System.out.println(list.fetch(temp.getKey()));
				} else
					System.out.println("\n**Insert Failed**\n");
				break;
			case 2:// Display a Customer With All Accounts
					// Asking for Customer's ID
				System.out.println("Please enter Customer's ID:");
				String id = keyboard.nextLine();
				BankCustomer_Amaya temp2 = list.fetch(id);
				if (temp2 != null)
					// Customer Found
					System.out.println(temp2.toString());
				else// Customer not found
					System.out.println("\n**Bank Customer with ID " + id + " could not be found**\n");
				break;
			case 3:// Open New Account for Current Customer
					// Asking for Customer id
				System.out.println("Please enter the Customer's ID:");
				id = keyboard.nextLine();
				// Saving Customer
				temp = list.fetch(id);
				if (temp != null) {
					// if Customer exists- Create an account
					account = generateAccount(list);
					// Adding account
					temp.addNewAccount(account);
					// Updating Customer in Data Structure
					if (list.update(temp.getKey(), temp))
						// Verifying add account Completion
						System.out.println(
								String.format("Open new Account for Customer with id: " + "%s SUCCESS", temp.getKey()));
					else
						// if verification failed
						System.out.println(
								String.format("Open new Account for Customer with id: " + "%s FAILED", temp.getKey()));
				} else
					// if customer dosen't exist
					System.out.println("\n**Bank Customer with ID " + id + " could not be found**\n");
				break;
			case 4:// Read One Account of One Customer
				BankCustomer_Amaya temp3 = null;
				String iD = "";
				int menuChoice;
				// sub menu loop
				do {
					// Print sub menu
					System.out.println("SELECT LOGIN TYPE");
					System.out.println("1. Customer id");
					System.out.println("2. User name and password");
					System.out.println("0. DO NOT CONTINUE");
					menuChoice = keyboard.nextInt();
					keyboard.nextLine();
					// if input is invalid
					if (menuChoice != 1 && menuChoice != 2 && menuChoice != 0)
						System.out.println("\n**INVALID INPUT**\n");
					// Repeat while input is invalid
				} while (menuChoice != 1 && menuChoice != 2 && menuChoice != 0);
				// Continue if input is not 0
				if (menuChoice != 0) {
					// Continue Read account operation
					switch (menuChoice) {
					case 1:// Customer id
							// Asking for Customer id
						System.out.println("Please enter the Customer's ID:");
						iD = keyboard.nextLine();
						// Saving Customer
						temp3 = list.fetch(iD);
						break;
					case 2:// User name and password
							// Asking for Customer username
						System.out.println("Please enter the Customer's username:");
						user = keyboard.nextLine();
						// Asking for Customer password
						System.out.println("Please enter the Customer's password:");
						pass = keyboard.nextLine();
						// Saving Customer
						temp3 = list.fetch(user, pass);
						break;
					default:// do nothing
						break;
					}// end of inner switch statement
						// Checking Customer
					if (temp3 != null) {
						// Asking for account Number to read
						System.out.println("Please enter the account number:");
						String accountNum = keyboard.nextLine();
						// fetching Bank Account
						BankAccount_Amaya searchAccount = temp3.fetchAccount(accountNum);
						// Displaying Account/Message
						if (searchAccount != null)
							System.out.println(searchAccount);
						else
							System.out
									.println("\n**Bank Account with number " + accountNum + " could not be found**\n");
					} else// Customer temp is null
						System.out.println("\n**Bank Customer with ID " + iD + " could not be found**\n");
				} else// DO NOT CONTINUE
					System.out.println("\n**OPERATION ABORTED**\n");
				break;
			case 5:// Remove One Account of Current Customer
					// Asking for Customer id
				System.out.println("Please enter the Customer's ID:");
				id = keyboard.nextLine();
				// Saving Customer
				temp = list.fetch(id);
				if (temp != null)
				// if Customer exists
				{// Asking for account number to read
					System.out.println("Please enter the account number:");
					String accountNum = keyboard.nextLine();
					// fetching Bank Account
					BankAccount_Amaya searchAccount = temp.fetchAccount(accountNum);
					if (searchAccount != null)// Account exists
						if (temp.getAccounts().size() == 1) {// if only one account exists
							char answer;
							// Printing warning
							do {
								System.out.println("This customer only has one account.");
								System.out.println("Closing this account will remove this customer off of the system.");
								System.out.println("Do you still want to close account (Y/N)?");
								// Saving input
								answer = keyboard.nextLine().charAt(0);
								// If input is invalid
								if ((answer != 'Y' || answer != 'y') && (answer != 'N' || answer != 'n'))
									System.out.println("\n**INVALID INPUT**\n");
							} // While input is invalid, repeat delete menu
							while ((answer != 'Y' || answer != 'y') && (answer != 'N' || answer != 'n'));

							// if delete Customer confirmed
							if (answer == 'Y' || answer == 'y') {
								// removing account
								System.out.println("Deleting Bank Account...");
								temp.closeAccount(searchAccount);
								// Deleting Customer
								System.out.println("Deleting Customer...");
								if (list.delete(temp.getKey()))
									System.out.println("\n**Customer successfully deleted**\n");
								else
									System.out.println("\n**Customer deletion failed**\n");
							} else// DO NOT DELETE
								System.out.println("\n**OPERATION ABORTED**\n");

						} // More than one account exists
						else// Delete account only
						if (temp.closeAccount(searchAccount))
							// Printing Message
							System.out.println("\n**Bank Account successfully deleted**\n");
						else
							System.out.println("\n**Bank Account deletion failed**\n");

					else
						System.out.println("\n**Bank Account with number " + accountNum + " could not be found**\n");
				} // Customer not found
				else
					System.out.println("\n**Bank Customer with ID " + id + " could not be found**\n");
				break;
			case 6:// Display all Customers with their accounts
				list.showAll();
				break;
			case 7:// Process Monthly Statement
				list.printMonthly();
				break;
			case 0:// DONE
				break;
			default:// Technically Unreachable
				break;
			}// end of switch statement
		} while (choice != 0);// if choice is not 0, continue loop
	}// end of employee method

	/*
	 * This is the customer method. It handles the Bank Customer Menu and
	 * corresponding tasks.
	 */
	public static void customer(SinglyLinkedListIterator list) {
		// Variables for saving input
		int choice;
		Scanner keyboard = new Scanner(System.in);
		do {// Login do-while loop
			// Asking users to select type to logging:
			System.out.println("SELECT LOGIN TYPE");
			System.out.println("1.   Customer id");
			System.out.println("2.   User name and password");
			System.out.println("0.   DO NOT CONTINUE");
			// Reading and Saving input
			choice = keyboard.nextInt();
			keyboard.nextLine();
			// Print message if choice is invalid
			if (choice != 1 && choice != 2 && choice != 0)
				System.out.println("\n**INVALID INPUT**\n");
			// loop menu while choice is invalid
		} while (choice != 1 && choice != 2 && choice != 0);
		// Looking for Customer
		BankCustomer_Amaya temp = null;
		String iD = "";
		// Continue if input is not 0
		if (choice != 0) {
			// Continue Read account operation
			switch (choice) {
			case 1:// Customer id
					// Asking for Customer id
				System.out.println("Please enter the Customer's ID:");
				iD = keyboard.nextLine();
				// Saving Customer
				temp = list.fetch(iD);
				break;
			case 2:// User name and password
					// Asking for Customer username
				System.out.println("Please enter the Customer's username:");
				String user = keyboard.nextLine();
				// Asking for Customer password
				System.out.println("Please enter the Customer's password:");
				String pass = keyboard.nextLine();
				// Saving Customer
				temp = list.fetch(user, pass);
				break;
			default:// do nothing
				break;
			}// end of inner switch statement
				// Checking Customer
			if (temp != null) {
				// Displaying found Customer
				System.out.println("\nYOU ARE:");
				System.out.printf("Customer Name:        %s\n", temp.getName());
				System.out.printf("Customer id:          %s\n", temp.getKey());
				System.out.printf("Address:              %s\n\n", temp.getAddress());
				do {// Customer program do-while loop
					do {// Menu do-while loop
						// Printing Customer Menu

						System.out.println("TASKS FOR BANK CUSTOMERS");
						System.out.println("1.   Print Information of Customer");
						System.out.println("2.   Check balance");
						System.out.println("3.   Deposit");
						System.out.println("4.   Withdraw");
						System.out.println("5.   Print Monthly Statement");
						System.out.println("0.   DONE");
						choice = keyboard.nextInt();
						keyboard.nextLine();
						// print if choice is invalid
						if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 0)
							System.out.println("\n**INVALID INPUT**\n");
						// Repeat menu while choice is Invalid
					} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 0);

					// Switch Statement for Customer Menu tasks
					switch (choice) {
					case 1:// Print Information of Customer
						System.out.println(temp.toString());
						break;
					case 2:// Check balance
							// Asking for account number
						System.out.println("Enter the Bank Account number:");
						String accNum = keyboard.nextLine();
						// Fetching Account
						BankAccount_Amaya account = temp.fetchAccount(accNum);
						// Checking Account
						if (account != null)// account exists
							// Printing check Balance
							account.checkBalance();
						else// Print not found message
							System.out.println("\n**Bank Account with number " + accNum + " could not be found**\n");
						break;
					case 3:// Deposit
							// Asking for account number
						System.out.println("Enter the Bank Account number:");
						accNum = keyboard.nextLine();
						// Asking for deposit amount
						System.out.println("Enter the deposit amount:");
						float deposit = keyboard.nextFloat();
						keyboard.nextLine();
						// Fetching Account
						account = temp.fetchAccount(accNum);
						// Checking Account
						if (account != null)// account exists
							// Printing Deposit Balance
							account.deposit(deposit);
						else// Print not found message
							System.out.println("\n**Bank Account with number " + accNum + " could not be found**\n");
						break;
					case 4:// Withdraw
							// Asking for account number
						System.out.println("Enter the Bank Account number:");
						accNum = keyboard.nextLine();
						// Asking for withdraw amount
						System.out.println("Enter the withdraw amount:");
						float withdraw = keyboard.nextFloat();
						keyboard.nextLine();
						// Fetching Account
						account = temp.fetchAccount(accNum);
						// Checking Account
						if (account != null)// account exists
							// Printing Withdraw Balance
							account.withdraw(withdraw);
						else// Print not found message
							System.out.println("\n**Bank Account with number " + accNum + " could not be found**\n");
						break;
					case 5:// Print Monthly Statement
							// Asking for account number
						System.out.println("Enter the Bank Account number:");
						accNum = keyboard.nextLine();
						// Fetching Account
						account = temp.fetchAccount(accNum);
						// Checking Account
						if (account != null)// account exists
						{
							// Printing Monthly Statement
							System.out.println("-------MONTHLY STATEMENT:-------");
							// Processing fee/interest
							account.printMonthly();
							// Printing account
							System.out.println(account.toString());
						} else// Print not found message
							System.out.println("\n**Bank Account with number " + accNum + " could not be found**\n");
						break;
					case 0:// DONE
						break;
					default:// do nothing
						break;

					}// end of switch statement
						// Continue Customer program while choice is not 0
				} while (choice != 0);
			} // Customer temp is null
			else
				System.out.println("\n**Bank Customer could not be found**\n");
		} // end of outer if statement
	}// end of customer method

	/*
	 * This is the generateAccount method. Used to Create BankAccounts
	 */
	public static BankAccount_Amaya generateAccount(SinglyLinkedListIterator list) {// Scanner for reading input
		Scanner keyboard = new Scanner(System.in);
		// Creating Bank Account
		// float for new Account
		float bal;
		System.out.println("Please enter the account's new balance:");
		bal = keyboard.nextFloat();
		keyboard.nextLine();
		// For Generating Account Number
		int accNum1;
		int accNum2;
		String newAccountNum;
		boolean notUnique = true;
		// Account number checking loop
		do {
			// number generating loop
			do {
				accNum1 = (int) (java.lang.Math.random() * 100000);// 0-99999
				accNum2 = (int) (java.lang.Math.random() * 100000);// 0-99999

			} while (accNum1 < 9999 && accNum2 < 9999);// at least 5 digits

			// "Gluing" new generated account number
			newAccountNum = String.format("%d" + "%d", accNum1, accNum2);
			// Checking if key is already in the Structure
			list.i.reset();// start from beginning
			while (list.i.hasNext()) {
				// fetching accounts
				LinkedList<BankAccount_Amaya> accList = list.i.next().getAccounts();
				// Converting LinkedList to Array
				BankAccount_Amaya[] accListArray = accList.toArray(new BankAccount_Amaya[0]);

				// Comparing generated account number to existing account numbers
				for (BankAccount_Amaya account : accListArray)
					if (newAccountNum.compareTo(account.getAccountNum()) != 0)
						notUnique = false;
					else
						notUnique = true;
			} // end of inner while loop
		} while (notUnique);
		// Asking for more account information
		System.out.println("Please enter the account's limit amount:");
		float limit = keyboard.nextFloat();
		keyboard.nextLine();
		System.out.println("Please enter the account's serive fee or interest rate:");
		float feeOrRate = keyboard.nextFloat();
		keyboard.nextLine();
		// Creating new Account with generated Number
		BankAccount_Amaya account;
		if (feeOrRate < 1.0) {
			// fixing interest rate
			feeOrRate = feeOrRate / 100.0f;
			account = new BankSavingAccount_Amaya(newAccountNum, bal, limit, feeOrRate);
		} else
			account = new BankCheckingAccount_Amaya(newAccountNum, bal, limit, feeOrRate);
		return account;
	}// end of generateAccount method
}// end of COSC2436_FA2018_BANK_SERVICE_Amaya class
