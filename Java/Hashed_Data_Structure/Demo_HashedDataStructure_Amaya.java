//Demo_HashedDataStructure_Amaya.java
import java.io.File;//Needed to use file in the program
import java.io.FileNotFoundException;//Needed if file is not found
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;//java provided hashed structure program
import java.util.Scanner;//Needed to read user input

/*
 * This is the Demo_HashedDataStructure_Amaya Demo class
 */
public class Demo_HashedDataStructure_Amaya {

	/*
	 * main method - The program starts here
	 */
	public static void main(String args[]) throws FileNotFoundException // needed if file is not found
	{
		// Integer variable and Scanner object to read user input
		int choice;
		Scanner keyboard = new Scanner(System.in);
		// Displaying Hashed Structure MENU

		do {
			System.out.println("Please select the type of Hashed Structure to use:");
			System.out.println("1.   LQHashed Data Structure");
			System.out.println("2.   Java Hashtable Data Structure");
			System.out.println("0.   Exit");
			// reading input
			choice = keyboard.nextInt();
			keyboard.nextLine();// removing extra newLine character
			// Print invalid if input is invalid
			if (choice != 1 && choice != 2 && choice != 0)
				System.out.println("**Invalid input**");

		} // repeat menu while input is invalid
		while (choice != 1 && choice != 2 && choice != 0);
		// if true, continue program
		if (choice != 0) {
			// Creating chosen structure
			switch (choice) {
			case 1:// LqHashed Structure
				lqStructure();
				break;
			case 2:// Java Hashtable data structure
				htStructure();
				break;
			case 0:// Do nothing since this option exits the program
				break;
			default:// Technically this case should not be accessible

			}
		}
		// ending program
		System.out.println("Terminating Program...");
	}// end of the main method

	/*
	 * lqStructure method
	 */
	public static void lqStructure() throws FileNotFoundException {
		System.out.println("Creating LqHashed Structure for 100 nodes...\n");
		// Creating LqHashed Structure based on 100 nodes
		LqHashed list = new LqHashed(100);

		// Opening file
		File file = new File("customerInfo.txt");
		Scanner inFile = new Scanner(file);
		System.out.println("Reading the customerInfo file...\n");

		// Reading the file
		System.out.println("Inserting nodes into structure...\n");
		while (inFile.hasNextLine()) {
			// Splitting information
			String[] input;
			input = inFile.nextLine().split("[,]");
			// temp node to help in inserting nodes
			BankCustomer_Amaya temp = new BankCustomer_Amaya(input[0], input[1], input[2], input[3], input[4],
					input[5]);
			// Constructing Bank account and inserting node to Structure
			list.insert(temp);
		} // end of while loop
			// Displaying all inserted nodes
		System.out.println("--DISPLAYING ALL INSERTED NODES--\n");
		list.showAll();

		// Integer variable and Scanner object for MENU selection
		int choice;
		Scanner keyboard = new Scanner(System.in);
		// do-while loop for structure program
		do {

			// do-while loop for MENU
			do {
				// Printing MENU tasks
				System.out.println("--LqHashed MENU--");
				System.out.println("1.   Insert Customer");
				System.out.println("2.   Fetch");
				System.out.println("3.   Verify Encapsulation");
				System.out.println("4.   Update");
				System.out.println("5.   Delete");
				System.out.println("6.   Show All");
				System.out.println("0.   Exit");
				choice = keyboard.nextInt();// saving input
				keyboard.nextLine();// removing extra \n

				// Validating input
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
						&& choice != 0)
					System.out.println("\n**INVALID Choice**\n");

				// repeat menu if choice is invalid
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
					&& choice != 0);
			// switch statement for executing the tasks
			switch (choice) {
			case 1:// Insert Customer
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
				// Creating object and inserting to structure
				BankCustomer_Amaya temp = new BankCustomer_Amaya(i, last, first, user, pass, add);
				System.out.println("\nInserting new node into Structure...\n");

				if (list.insert(temp)) {
					System.out.println("\n**Insert was Successful**\n");
					// displaying Customer
					System.out.println(temp);
				} else
					System.out.println("\n**Insert Failed**\n");

				break;
			case 2:// Fetch
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				String search = keyboard.nextLine();
				temp = list.fetch(search);
				if (temp != null) {
					System.out.println("\n**Customer Found**\n");
					// displaying Customer
					System.out.println(temp);
				} else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 3:// Encapsulation
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				BankCustomer_Amaya temp1 = list.fetch(search);
				// if account is found
				if (temp1 != null) {
					// Asking for address
					System.out.println("Please enter the Customer's new Address");
					search = keyboard.nextLine();
					// Changing account address
					temp1.setAddress(search);
					// fetching Structure node as "temp2"
					BankCustomer_Amaya temp2 = list.fetch(temp1.getKey());
					// Comparing the 2 nodes
					System.out.println("Checking if Structure is encapsulated...");
					if (temp1.getAddress().compareTo(temp2.getAddress()) == 0)
						System.out.println("\n**LQHashed data structure is not encapsulated**\n");
					else
						System.out.println("\n**LQHashed data structure is encapsulated**\n");
				}
				// Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 4:// Update
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				// saving customer account to temp3
				BankCustomer_Amaya temp3 = list.fetch(search);
				if (temp3 != null) {
					// Asking for address
					System.out.println("Please enter the Customer's new Address");
					search = keyboard.nextLine();
					// Changing account address
					temp3.setAddress(search);
					// Updating customer account in Data Structure
					if (list.update(temp3.getKey(), temp3))
						System.out.println("\n**Customer Account Updated Succesfully**\n");
					else
						System.out.println("\n**Customer Account Update Failed**\n");
				} // Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 5:// Delete
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				// Deleting Account
				if (list.delete(search))
					System.out.println("\n**Customer Account Deleted Succesfully**\n");
				else
					System.out.println("\n**Customer Account Delete Failed**\n");
				break;
			case 6:// Show All
				list.showAll();
				System.out.println("**Show All Accounts - Finished**\n");
				break;
			case 0:// Writing to customerInfo.txt and Exit
				BankCustomer_Amaya temp4 = new BankCustomer_Amaya();
				temp4.writeToFile(file, list);
				break;
			default:// Technically this case should not be accessible
				break;

			}// end of switch statement

		} while (choice != 0);// repeat while choice is not 0
		inFile.close();

	}// end of lqStructure method

	/*
	 * htStructure method
	 */
	public static void htStructure() throws FileNotFoundException // needed if file dosen't exist
	{
		// creating HashTable Structure - based on 100 nodes
		Hashtable<String, BankCustomer_Amaya> list = new Hashtable<String, BankCustomer_Amaya>(100);

		// Opening file
		File file = new File("customerInfo.txt");
		Scanner inFile = new Scanner(file);
		System.out.println("Reading the customerInfo file...\n");

		// Reading the file
		System.out.println("Inserting nodes into structure...\n");
		while (inFile.hasNextLine()) {
			// Splitting information
			String[] input;
			input = inFile.nextLine().split("[,]");
			// temp node to help in inserting nodes
			BankCustomer_Amaya temp = new BankCustomer_Amaya(input[0], input[1], input[2], input[3], input[4],
					input[5]);
			// Constructing Bank account and inserting node to Structure
			list.put(temp.getKey(), temp);
		} // end of while loop
			// Displaying all inserted nodes
		System.out.println("--DISPLAYING ALL INSERTED NODES--\n");
		Enumeration nodes = list.elements();
		while (nodes.hasMoreElements()) {
			System.out.println(nodes.nextElement());
		}

		// Integer variable and Scanner object for MENU selection
		int choice;
		Scanner keyboard = new Scanner(System.in);
		// do-while loop for structure program
		do {

			// do-while loop for MENU
			do {
				// Printing MENU tasks
				System.out.println("--Hashtable MENU--");
				System.out.println("1.   Insert Customer");
				System.out.println("2.   Fetch");
				System.out.println("3.   Verify Encapsulation");
				System.out.println("4.   Update");
				System.out.println("5.   Delete");
				System.out.println("6.   Show All");
				System.out.println("0.   Exit");
				choice = keyboard.nextInt();// saving input
				keyboard.nextLine();// removing extra \n

				// Validating input
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
						&& choice != 0)
					System.out.println("\n**INVALID Choice**\n");

				// repeat menu if choice is invalid
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
					&& choice != 0);
			// switch statement for executing the tasks

			switch (choice) {
			case 1:// Insert Customer
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
				// Creating object and inserting to structure
				BankCustomer_Amaya temp = new BankCustomer_Amaya(i, last, first, user, pass, add);
				System.out.println("\nInserting new node into Structure...\n");
				list.put(temp.getKey(), temp);
				// Checking Insertion
				if (list.containsKey(temp.getKey())) {
					System.out.println("\n**Insert was Successful**\n");
					// displaying Customer
					System.out.println(temp);
				} else
					System.out.println("\n**Insert Failed**\n");

				break;
			case 2:// Fetch
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				String search = keyboard.nextLine();
				temp = list.get(search);
				if (temp != null) {
					System.out.println("\n**Customer Found**\n");
					// displaying Customer
					System.out.println(temp);
				} else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 3:// Encapsulation
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				BankCustomer_Amaya temp1 = list.get(search);
				// if account is found
				if (temp1 != null) {
					// Asking for address
					System.out.println("Please enter the Customer's new Address");
					search = keyboard.nextLine();
					// Changing account address
					temp1.setAddress(search);
					// fetching Structure node as "temp2"
					BankCustomer_Amaya temp2 = list.get(temp1.getKey());
					// Comparing the 2 nodes
					System.out.println("Checking if Structure is encapsulated...");
					if (temp1.getAddress().compareTo(temp2.getAddress()) == 0)
						System.out.println("\n**LQHashed data structure is not encapsulated**\n");
					else
						System.out.println("\n**LQHashed data structure is encapsulated**\n");
				}
				// Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 4:// Update
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				// saving customer account to temp3
				BankCustomer_Amaya temp3 = list.get(search);
				if (temp3 != null) {
					// Asking for address
					System.out.println("Please enter the Customer's new Address");
					search = keyboard.nextLine();
					// Changing account address
					temp3.setAddress(search);
					// Updating customer account in Data Structure
					list.replace(temp3.getKey(), temp3);
					// Checking Update
					if (list.contains(temp3))
						System.out.println("\n**Customer Account Updated Succesfully**\n");
					else
						System.out.println("\n**Customer Account Update Failed**\n");
				} // Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**\n");
				break;
			case 5:// Delete
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				// Deleting Account
				list.remove(search);
				// Checking Delete
				if (list.get(search) == null)
					System.out.println("\n**Customer Account Deleted Succesfully**\n");
				else
					System.out.println("\n**Customer Account Delete Failed**\n");
				break;
			case 6:// Show All
					// obtaining "fresh" nodes
				nodes = list.elements();
				// Printing all nodes
				while (nodes.hasMoreElements()) {
					System.out.println(nodes.nextElement());
				}
				System.out.println("**Show All Accounts - Finished**\n");
				break;
			case 0:// Writing to customerInfo.txt and Exit
					// obtaining "fresh" nodes
				nodes = list.elements();
				// creating printWriter Object with input file
				PrintWriter writeTo = new PrintWriter(file);

				// Writing all nodes to file
				while (nodes.hasMoreElements()) {

					writeTo.println(((BankCustomer_Amaya) nodes.nextElement()).writeString());
				}
				writeTo.close();
				break;
			default:// Technically this case should not be accessible
				break;
			}// end of switch statement

		} while (choice != 0);// repeat while choice is not 0
		inFile.close();

	}// end of htStructure method
}// end of Demo_HashedDataStructure_Amaya class
