
//FA2018LAB7_Demo_BinarySearchTree_Amaya.java
import java.util.Scanner;//needed to read user input

/*
 * This is the FA2018LAB7_Demo_BinarySearchTree_Amaya class
 */
public class FA2018LAB7_Demo_BinarySearchTree_Amaya {

	/*
	 * this is the main method
	 */
	public static void main(String args[]) {
		// variables to read and save user input
		int choice;
		Scanner keyboard = new Scanner(System.in);
		// Declaring Binary Search Tree Structure
		BinarySearchTree list = new BinarySearchTree();
		// welcoming message
		System.out.println("Please select from the following options");
		do {// Program do-while loop
			do {// printing MENU
				System.out.println("\nBankCustomer MENU:");
				System.out.println("1.   Insert");
				System.out.println("2.   Fetch");
				System.out.println("3.   Encapsulation");
				System.out.println("4.   Update");
				System.out.println("5.   Delete");
				System.out.println("6.   Show all");
				System.out.println("0.   Exit");
				// saving input
				choice = keyboard.nextInt();
				keyboard.nextLine();// removing leftover newLine character
				// printing invalid message if input is invalid
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
						&& choice != 0)
					System.out.println("\n**INVALID INPUT**");
				// repeat MENU if input is invalid
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
					&& choice != 0);

			// switch statement to handle the MENU tasks
			switch (choice) {
			case 1:// Insert
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
				System.out.println("\nInserting new node into Structure...");

				if (list.insert(temp)) {
					System.out.println("\n**Insert was Successful**\n");
					// displaying Customer
					System.out.println(list.fetch(temp.getKey()));
				} else
					System.out.println("\n**Insert Failed**");
				break;
			case 2:// Fetch
					// Asking for information on Customer
				System.out.println("Please enter the Customer's ID:");
				String search = keyboard.nextLine();
				// fetching node from the structure
				temp = list.fetch(search);
				if (temp != null) {
					System.out.println("**Customer Found**\n");
					// displaying Customer
					System.out.println(temp);
				} // customer not found
				else
					System.out.println("\n**The bank customer cannot be found**");
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
						System.out.println("\n**LQHashed data structure is not encapsulated**");
					else
						System.out.println("\n**LQHashed data structure is encapsulated**");
				}
				// Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**");
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
						System.out.println("\n**Customer Account Updated Succesfully**");
					else
						System.out.println("\n**Customer Account Update Failed**");
				} // Account not in Structure
				else
					System.out.println("\n**The bank customer cannot be found**");
				break;
			case 5:// Delete
				System.out.println("Please enter the Customer's ID:");
				search = keyboard.nextLine();
				// Deleting Account
				if (list.delete(search))
					System.out.println("\n**Customer Account Deleted Succesfully**");
				else
					System.out.println("\n**Customer Account Delete Failed**");
				break;
			case 6:// Show all
				list.showAll();
				break;
			case 0:// Exit
				System.out.println("Terminating program...");
				break;
			default:// do nothing
				break;
			}

		} while (choice != 0);// continue program if choice does not equal 0
	}// end of main method

}// end of FA2018LAB7_Demo_BinarySearchTree_Amaya class
