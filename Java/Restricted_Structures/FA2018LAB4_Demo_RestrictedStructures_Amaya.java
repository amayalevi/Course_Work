
//FA2018LAB4_Demo_RestrictedStructures_Amaya.java
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FA2018LAB4_Demo_RestrictedStructures_Amaya {
	/*
	 * This is the main method
	 */
	public static void main(String[] args) {
		// Declaring restricted structures
		Account_Stack stack = new Account_Stack();
		;
		Account_Queue queue = new Account_Queue();
		// boolean for using stack or queue
		boolean SorQ = true;
		// Scanner object for saving user input
		Scanner keyboard = new Scanner(System.in);
		// Integer for Menu choice
		int choice;

		// do-while loop for continuing program
		do {// Printing MENU
			System.out.println("Please select from the following options: ");
			System.out.println("1.   Stack");
			System.out.println("2.   Queue");
			System.out.println("0.   Exit");
			// Saving input
			choice = keyboard.nextInt();
			keyboard.nextLine();// Consuming leftover newline

			// do-while loop for input validation
			do {
				// switch statement for executing user choice
				switch (choice) {
				case 1:
					SorQ = true;// true == stack
					break;
				case 2:
					SorQ = false;// queue == queue
					break;
				case 0://exit choice
					break;
				default:// if input is invalid
					System.out.println("Invalid choice. Please select from the following: \n");
					System.out.println("1.   Stack");
					System.out.println("2.   Queue");
					System.out.println("0.   Exit");
					// Saving input
					choice = keyboard.nextInt();
					keyboard.nextLine();// Consuming leftover newline
					break;
				}
			} while (choice != 1 && choice != 2 && choice != 0);// continue looping if input is invalid
			// if statement to handle TASK 1
			if (choice != 0) {
				// Repeat "Task 1" X 3 times
				for (int i = 0; i < 3; i++) {

					// - TASK 1 - Insert Node to Structure
					Account_Amaya account = null;
					// this do-while loops assures that an account is created
					do {
						// Asking for account type
						System.out.println("Please select an account type: \"1\" for Checking OR \"2\" for Saving");
						choice = keyboard.nextInt();
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
						switch (choice)

						{
						// This case initializes a Checking Account
						case 1:
							System.out.println("Enter the account's Service Fee:");
							double fee = keyboard.nextDouble();
							keyboard.nextLine();
							account = new CheckingAccount_Amaya(first, last, address, fee);
							break;
						// This case intializes a Saving Account
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
					} while (choice != 1 && choice != 2); // loop repeats if input is invalid
					// Setting down payment in account
					System.out.println("Enter the down payment for the account:");
					double down = keyboard.nextDouble();
					keyboard.nextLine();
					account.openAccount(down);

					// Inserting into Restricted Structure
					if (SorQ) {
						if (stack.push(account))// Checking if insert was successful
							javax.swing.JOptionPane.showMessageDialog(null, "Insert Account - *Success*\n");
						else
							javax.swing.JOptionPane.showMessageDialog(null, "Insert Account - *Failed*\n");
					} // end of if statement
					else {
						if (queue.enque(account))// Checking if insert was successful
							javax.swing.JOptionPane.showMessageDialog(null, "Insert Account - *Success*\n");
						else
							javax.swing.JOptionPane.showMessageDialog(null, "Insert Account - *Failed*\n");
					} // end of else statement

				} // end of for loop
				choice = 1;
			} // end of task 1 if statement

			// TASK 2 - Delete ONE NODE
			// if statement to handle TASK 2
			if (choice != 0) {
				// temp node
				Account_Amaya temp;
				// Removing top/front node
				if (SorQ) {
					// Stack
					// removing node
					temp = stack.pop();
					if (temp == null) {
						System.out.println("Stack is empty.");
						// Message Box
						javax.swing.JOptionPane.showMessageDialog(null, "*Delete Failed*\n");
					} else {
						System.out.println("Displaying Deleted Node:");
						System.out.println(temp);
						// Message Box
						javax.swing.JOptionPane.showMessageDialog(null, "*Delete Successfully*\n");
					}

				} else {
					// Queue
					// removing node
					temp = queue.deque();
					if (temp == null) {
						System.out.println("Queue is empty.");
						// Message Box
						javax.swing.JOptionPane.showMessageDialog(null, "*Delete Failed*\n");
					} else {
						System.out.println("Displaying Deleted Node:");
						System.out.println(temp);
						// Message Box
						javax.swing.JOptionPane.showMessageDialog(null, "*Delete Successfully*\n");
					}
				} // end of else statement

			} // end of Task 2 if statement

			// - TASK 3 - Display Node at Top or Front
			// if statement to handle TASK 3
			if (choice != 0) {
				// temp node
				Account_Amaya temp;

				if (SorQ) {
					// Stack
					// Getting top/front node
					temp = stack.peek();
					if (temp == null)
						System.out.println("Stack is empty.");
					else {
						System.out.println("Displaying Top Node:");
						System.out.println(temp);
					}
				} else {
					// Queue
					// Getting top/front node
					temp = queue.peek();
					if (temp == null)

						System.out.println("Queue is empty.");
					else {
						System.out.println("Displaying Front Node:");
						System.out.println(temp);
					}
				} // end of else statement
			} // end of Task 3 if statement

			// - TASK 5 - Show All
			// if statement to handle TASK 5
			if (choice != 0) {
				if (SorQ) {
					// Stack
					System.out.println("Displaying ALL Nodes:");
					stack.showAll();
				} else {
					// Queue
					System.out.println("Displaying ALL Nodes:");
					queue.showAll();
				}
			} // end of TASK 5 if statement

			// Ask user if they want to continue
			do {
				System.out.println("Continue using the Program?");
				System.out.println("Yes = 1");
				System.out.println("No  = 0");
				choice = keyboard.nextInt();
				keyboard.nextLine();
			} while (choice != 1 && choice != 0);// while input is invalid
		} while (choice != 0);// continue program if choice dosen't equal 0
	}// end of main method
}// end of Demo Class
