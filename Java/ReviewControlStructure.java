//ReviewControlStructure.java
import java.text.DecimalFormat;//For formatting decimal outputs.
import java.util.Scanner;//Used for receiving user input.
/*
 * This class does simple 2 operand calculations with integers and decimal numbers.
 */
public class ReviewControlStructure {
	/*
	 * Main Method.
	 */
	public static void main(String[] args)
	{
		//Scanner object for receiving user input
		Scanner keyboard = new Scanner(System.in);
		//int to store user selection
		int answer =0;
		//Displaying the instructions
		System.out.println("Welcome. Please select from the following options:\n");
		//Start of do-while loop
		do {
			//prints the Menu
			System.out.print(menu());
			//Save input to answer variable
			answer = keyboard.nextInt();
			keyboard.nextLine();//remove newline in queue
			//Calls the Calculator method which handles the operation
			calc(answer);
		}while(answer !=0);	//Checks if input is not zero to continue	
		System.out.println("Goodbye!");//Last message before termination
		}//end main
	/*
	 * This method returns the selection menu as a String.
	 */
	public static String menu()
	{
		String str = "MENU – CALCULATOR ON TWO NUMBERS\n";
		str += "1. Add two integers\n";
		str += "2. Subtract two integers\n";
		str += "3. Multiply two integers\n";
		str += "4. Divide two integers\n";
		str += "5. Add two decimal numbers\n";
		str += "6. Subtract two decimal numbers\n";
		str += "7. Multiply two decimal numbers\n";
		str += "8. Divide two decimal numbers\n";
		str += "0. Exit\n";
		
		return str;
	}//end menu
	
	/*
	 * This method handles the Calculation and the result output.
	 */
	public static void calc(int c)
	{	//DecimalFormat object for formating the decimal output
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		//Scanner object for the calc Method
		Scanner keyboard = new Scanner(System.in);
		//Variables used for integer calculations
		int x,y;
		//Variables used for Decimal calculations
		double a,b;
		//Start of switch statement
		//This Statement does one of 8 operations depending on the user's input
		switch(c)
		{
		case 1:
			//1st calculation
			System.out.println("Please enter the first integer:");
			x= keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Please enter the second integer:");
			y= keyboard.nextInt();
			keyboard.nextLine();
			//1st calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("ADD TWO INTEGERS");
			System.out.println(x+" + "+y+" = "+(x+y)+"\n");
			break;
		case 2:
			//2nd calculation
			System.out.println("Please enter the first integer:");
			x= keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Please enter the second integer:");
			y= keyboard.nextInt();
			keyboard.nextLine();
			//2nd calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("SUBTRACT TWO INTEGERS");
			System.out.println(x+" - "+y+" = "+(x-y)+"\n");
			break;
		case 3:
			//3rd calculation
			System.out.println("Please enter the first integer:");
			x= keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Please enter the second integer:");
			y= keyboard.nextInt();
			keyboard.nextLine();	
			//3rd calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("MULTIPLY TWO INTEGERS");
			System.out.println(x+" * "+y+" = "+(x*y)+"\n");
			break;
		case 4:
			//4th calculation
			System.out.println("Please enter the first integer:");
			x= keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Please enter the second integer:");
			y= keyboard.nextInt();
			keyboard.nextLine();
			//4th calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("DIVIDE TWO INTEGERS");
			System.out.println(x+" / "+y+" = "+(x/y)+"\n");
			break;
		case 5:
			//5th calculation
			System.out.println("Please enter the first decimal:");
			a= keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Please enter the second decimal:");
			b= keyboard.nextDouble();
			keyboard.nextLine();
			//5th calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("ADD TWO DECIMAL NUMBERS");
			System.out.println(a+" + "+b+" = "+decimalFormat.format(a+b)+"\n");
			break;
		case 6:
			//6th calculation
			System.out.println("Please enter the first decimal:");
			a= keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Please enter the second decimal:");
			b= keyboard.nextDouble();
			keyboard.nextLine();	
			//6th calculation output	
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("SUBTRACT TWO DECIMAL NUMBERS");
			System.out.println(a+" - "+b+" = "+decimalFormat.format(a-b)+"\n");
			break;	
		case 7:
			//7th calculation
			System.out.println("Please enter the first decimal:");
			a= keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Please enter the second decimal:");
			b= keyboard.nextDouble();
			keyboard.nextLine();
			//7th calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("MULTIPLY TWO DECIMAL NUMBERS");
			System.out.println(a+" * "+b+" = "+decimalFormat.format(a*b)+"\n");
			break;
		case 8:
			//8th calculation
			System.out.println("Please enter the first decimal:");
			a= keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Please enter the second decimal:");
			b= keyboard.nextDouble();
			keyboard.nextLine();
			//8th calculation output
			System.out.println("CALCULATOR OF LEVI AMAYA");
			System.out.println("DIVIDE TWO DECIMAL NUMBERS");
			System.out.println(a+" / "+b+" = "+decimalFormat.format(a/b)+"\n");
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid choice. Please try a different selection.\n");
		
		}
	}
}//end class
