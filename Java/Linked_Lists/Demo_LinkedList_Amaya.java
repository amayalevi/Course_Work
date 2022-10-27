
//Demo_LinkedList_Amaya.java
import java.util.LinkedList;//Java provided Linked list class
import java.util.ListIterator;//Iterator for Java LinkedList
import java.util.Random; //Used for Verifying Encapsulation
import java.util.Scanner;//Needed for receiving user input
/*
 * This is the Demo_LinkedList_Amaya Driver Class.
 * This class demonstrated the Singly Linked List, SLL with Iterator
 * and the java Linked List Class - LinkedList
 */

public class Demo_LinkedList_Amaya {

	/*
	 * This is the main method of the Demo_LinkedList_Amaya class
	 */
	public static void main(String[] args) {
		// Scanner object for receiving input
		Scanner keyboard = new Scanner(System.in);
		// int variable for processing menu choices
		int choice = 1;
		while (choice != 0)// for continuing to use the program
		{
			// Printing Menu
			do {
				System.out.println("Please select from the following choices:");
				System.out.println("1.   Singly Linked List");
				System.out.println("2.   Singly Linked List with Iterator");
				System.out.println("3.   Java Linked List with Iterator");
				choice = keyboard.nextInt();// receiving input
				keyboard.nextLine();// clearing new line character
				// switch statement executes the menu choice
				switch (choice) {
				case 1:// Menu choice 1
					SLL();
					break;
				case 2:// Menu choice 2
					SLLI();
					break;
				case 3:// Menu choice 3
					javaLL();
					break;
				default:// Invalid menu choice
					System.out.println("** Invalid menu choice! **");
				}// end of switch statement
			} while (choice != 1 && choice != 2 && choice != 3);// while choice is invalid

			// Asking to Continue Program
			do {
				System.out.println("Continue Program?");
				System.out.println("1.   Yes - Continue");
				System.out.println("0.   No - Exit");
				choice = keyboard.nextInt();// receiving input
				keyboard.nextLine();// clearing new line character
			} while (choice != 1 && choice != 0);// repeat while choice is invalid
		} // end of while-loop
	}// end of main method

	/*
	 * This is the SLL method of the Demo_LinkedList_Amaya class This method handles
	 * the Singly Linked List Structure.
	 */
	public static void SLL() {
		Scanner keyboard = new Scanner(System.in);
		int choice;
		// Singly Linked List Data Structure variable
		SinglyLinkedList list = new SinglyLinkedList();
		do {
			// Printing SLL menu
			System.out.println("Singly Linked List MENU :");
			System.out.println("1.   Insert Account");
			System.out.println("2.   Read Account");
			System.out.println("3.   Verify Encapsulation");
			System.out.println("4.   Update Account");
			System.out.println("5.   Delete Account");
			System.out.println("6.   Show All Accounts");
			System.out.println("0.   Exit");
			// Receiving choice
			choice = keyboard.nextInt();
			keyboard.nextLine();// removing remaining new line character

			// switch statement for processing menu choice
			switch (choice) {
			case 1:// Insert Account
					// inserting into Singly Linked List
				if (list.insert(SLL_createAcc()))// insert method returns boolean
					// Displaying message if insert was successful
					javax.swing.JOptionPane.showMessageDialog(null, "SLL Insert Account - *Success*\n");
				else
					javax.swing.JOptionPane.showMessageDialog(null, "SLL Insert Account - *Failed*\n");
				;
				break;
			case 2:// Read Account
					// Asking user for Account number
				System.out.println("Please enter the Account number to serach: ");
				String searchString = keyboard.nextLine();
				// if SLL is empty display message
				if (list.peek() == null)
					javax.swing.JOptionPane.showMessageDialog(null, "There is no node in the Singly Linked List");
				else if (list.fetch(searchString) == null)// if account not found
					javax.swing.JOptionPane.showMessageDialog(null, "Account cannot be found");
				else// Displaying account info if found
					System.out.println(list.fetch(searchString));
				break;
			case 3:// Verify Encapsulation
					// Random object to change account value
				Random rand = new Random();
				int randnumber = rand.nextInt(10) + 1;
				// creating an account
				Account_Amaya temp1 = SLL_createAcc();
				// inserting temp1 Account
				list.insert(temp1);
				// changing temp1 field balance
				temp1.balance += randnumber;
				// fetching temp1 from SLL as "temp2"
				Account_Amaya temp2 = list.fetch(temp1.accountNumber);
				// Comparing balances to verify encapsulation
				if (temp1.balance == temp2.balance)
					// Displaying corresponding message from encapsulation verification
					javax.swing.JOptionPane.showMessageDialog(null, "“Singly Lnked List is not encapsulated");
				else
					javax.swing.JOptionPane.showMessageDialog(null, "Singly Lnked List is encapsulated");
				break;
			case 4:// Update Account
					// creating a new account "temp"
				Account_Amaya temp = SLL_createAcc();
				// inserting temp into SLL
				list.insert(temp);
				// Changing address
				System.out.println("Please enter the new Address for the Account:");
				String newAddress = keyboard.nextLine();
				temp.address = newAddress;
				// Updating new temp Account
				if (list.update(temp.accountNumber, temp))
					// Displaying corresponding message from Update verification
					javax.swing.JOptionPane.showMessageDialog(null, "Update Successfully");
				else
					javax.swing.JOptionPane.showMessageDialog(null, "Update Not Successfully");
				break;
			case 5:// Delete Account
					// Asking for Account Id
				System.out.println("Please enter the Accoun ID # for deletion:");
				String deleteNum = keyboard.nextLine();
				// Deleting Account
				if (list.delete(deleteNum))
					// Displaying corresponding message from Delete verification
					javax.swing.JOptionPane.showMessageDialog(null, "Account is closed");
				else
					javax.swing.JOptionPane.showMessageDialog(null, "Delete account failed");
				break;
			case 6:// Show All
					// Displaying all nodes
				list.showAll();
				break;
			case 0:// 0 exits loop
				break;
			default:// Invalid menu choice
				System.out.println("** Invalid menu choice! **");
			}// end of switch statement
		} while (choice != 0);
	}// end of SLL method

	/*
	 * This is the create account method for the SLL method.
	 */
	public static Account_Amaya SLL_createAcc() {
		Account_Amaya account = null;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please select an account type: \"1\" for Checking OR \"2\" for Saving");
		int choice = keyboard.nextInt();
		keyboard.nextLine();

		// Asking for information
		System.out.println("Please enter your first name:");
		String first = keyboard.nextLine();
		System.out.println("Please enter your last name:");
		String last = keyboard.nextLine();
		System.out.println("Please enter your address:");
		String address = keyboard.nextLine();
		// This switch statement decides between initializing a Checking or Saving
		// Account.
		switch (choice) {
		// This case initializes a Checking Account
		case 1:
			System.out.println("Enter the account's Service Fee:");
			double fee = keyboard.nextDouble();
			keyboard.nextLine();
			account = new CheckingAccount_Amaya(first, last, address, fee);
			break;
		// This case initializes a Saving Account
		case 2:
			System.out.println("Enter the account's Interest Rate:");
			double rate = keyboard.nextDouble();
			keyboard.nextLine();
			account = new SavingAccount_Amaya(first, last, address, rate);
			break;
		// default is for any invalid choices.
		default:
			System.out.println("Invalid Choice.");
			break;
		}
		// Setting down payment in account
		System.out.println("Enter the down payment for the account:");
		double down = keyboard.nextDouble();
		keyboard.nextLine();
		account.openAccount(down);
		// Returning new Account
		return account;
	}

	/*
	 * This is the SLLI method This method handles the Singly Linked List with
	 * iterator Data Structure
	 */
	public static void SLLI() {
		// Creating SLL with Iterator Data Structure
		SinglyLinkedListIterator list = new SinglyLinkedListIterator();
		// inserting 5 accounts
		for (int i = 1; i <= 5; i++) {
			// Creating an account and inserting to SLLI
			list.insert(SLL_createAcc());
		}
		// Showing the Accounts
		System.out.println("Showing All Accounts:\n");
		list.showAll();
		// Deleting Third Account
		System.out.println("Deleting 3rd Account:\n");
		list.i.reset();// i=h
		list.i.next();// i=node 1
		list.i.next();// i=node 2
		// Iterator is set to 3rd node and the node is deleted
		list.delete(list.i.next().accountNumber);
		// Showing the New list of Accounts
		System.out.println("Showing new list of Accounts:\n");
		list.showAll();
	}// end of SLLI method

	/*
	 * This is the javaLL method of the Demo_LinkedList_Amaya class This method
	 * handles the Java Data Structure Class - LinkedList
	 */
	public static void javaLL() {
		//Creating a LinkedList Data Structure
		LinkedList list = new LinkedList();
		//Scanner object for updating Account
		Scanner keyboard = new Scanner(System.in);
		// inserting 5 accounts
		for (int i = 1; i <= 5; i++) {
			// Creating an account and inserting to SLLI
			list.add(SLL_createAcc());
		}
		//Declaring Iterator
		ListIterator lI = list.listIterator();
		//Fetching first two Accounts
		System.out.println("Fetching first two Accounts:\n");
		System.out.println(lI.next());
		System.out.println(lI.next());
		// -- Updating Account --
		//fetching using iterator
		Account_Amaya temp = (Account_Amaya) lI.next();
		// Changing address
		System.out.println("Please enter the new Address for the Account:");
		String newAddress = keyboard.nextLine();
		temp.address = newAddress;
		// Updating new temp Account
		lI.set(temp);
		lI.previous();
		if (lI.next().equals(temp))
			// Displaying corresponding message from Update verification
			javax.swing.JOptionPane.showMessageDialog(null, "Account is updated");
		else
			javax.swing.JOptionPane.showMessageDialog(null, "Update Failed");
		//Showing all nodes
		System.out.println("Showing All Accounts:\n");
		while(lI.hasPrevious())
			lI.previous();
		while(lI.hasNext())
			System.out.println(lI.next());
	}//end of javaLL class
}// end of Demo_LinkedList_Amaya class
