
//DemoRecursion_Amaya.java
import java.util.Scanner;//Needed to read input from user

/*
 * This is the Driver Class for the recursion methods class.
 */
public class DemoRecursion_Amaya {

	/*
	 * This is the main method of the DemoRecursion_Amaya class.
	 */
	public static void main(String args[]) {
		// Variables for reading and storing user input
		int choice;
		Scanner keyboard = new Scanner(System.in);
		// Welcoming message
		System.out.println("Please select from the following options:");
		do {//do while loop for Demo program
			do {// Printing MENU
				System.out.println("\nRECURSIVE FUNTION MENU");
				System.out.println("1.   n!  (Factorial of an integer n)");
				System.out.println("2.   a^n (a power n)");
				System.out.println("3.   Sum(n) = 1 + 2 + 3 + .. + n ");
				System.out.println("4.   Sum(m, n) = m + (m+1), (m+2) + … + n");
				System.out.println("5.   Fibonacci sequence Fn");
				System.out.println("6.   GCD (The greatest common divisor of m and n)");
				System.out.println("0.   Exit");
				choice = keyboard.nextInt();// reading input
				keyboard.nextLine();// consuming extra new line character
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
						&& choice != 0)
					System.out.println("\n**Invalid Choice**\n");
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
					&& choice != 0);

			switch (choice) {
			case 1:// Factorial Function
					// Receiving input from user
				int n;
				System.out.println("Please enter a positive integer number:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				System.out.print("Factorial of " + n + " = ");
				// Printing result
				System.out.println(RecursionStaticMethods_Amaya.factorial(n));
				break;
			case 2:// a power n
					// Receiving input from user
				int a;
				System.out.println("Please enter the BASE number for the exponential funtion:");
				a = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Please enter the EXPONENT number for the base:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				System.out.print(a + " to the power of " + n + " = ");
				// Printing result
				System.out.println(RecursionStaticMethods_Amaya.aPowern(a, n));
				break;
			case 3:// sum(n)
					// Receiving input from user
				System.out.println("Please enter a postive integer number for the Sum function:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				// Printing result
				System.out.println("The Sum of (" + n + ") = " + RecursionStaticMethods_Amaya.sum(n));
				break;
			case 4:// sum(m,n)
					// Receiving input from user
				System.out.println("Please enter the integer numbers m & n where m < n:");
				System.out.println("Enter m:");
				int m = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Enter n:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				// Printing result
				System.out.println("The Sum of (" + m + "," + n + ") = " + RecursionStaticMethods_Amaya.sum(m, n));
				break;
			case 5:// fibonacci
					// Receiving input from user
				System.out.println("Please enter a positive integer number for fibonacci sequence position:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				// Printing result
				System.out.println("The Fibonacci postition '" + n + "' = " + RecursionStaticMethods_Amaya.fibonacci(n));
				break;
			case 6:// GCD
					// Receiving input from user
				System.out.println("Please enter the integer numbers m & n where m > n:");
				System.out.println("Enter m:");
				m = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Enter n:");
				n = keyboard.nextInt();
				keyboard.nextLine();
				// Printing result
				System.out.println("The GCD of " + m + " and " + n + " = " + RecursionStaticMethods_Amaya.gcd(n, m));
				break;
			case 0:// Exit
				System.out.println("Terminating Program...");
				break;
			default:// Technically Unreachable
				break;
			}// end of switch statement
		} while (choice != 0);// if 0, end program

	}// end of main method
}// end of DemoRecursion_Amaya class
