
//FA2018LAB4_EvaluatingInfixedExpression_Amaya.java
import java.util.Scanner; //This class is needed for receiving input from user
import java.io.File; //This class is needed to use files.
import java.io.FileNotFoundException;//Exception needed if File is not found

/*
 * This is the FA2018LAB4_EvaluatingInfixedExpression_Amaya class
 */
public class FA2018LAB4_EvaluatingInfixedExpression_Amaya {

	/*
	 * This is the main method
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner object to save input
		Scanner keyboard = new Scanner(System.in);
		// String array for processing
		String[] expSplit = null;
		// Stack for operators and operands
		GenericStack<String> operatorStack = new GenericStack<String>();
		GenericStack<String> operandStack = new GenericStack<String>();
		// File Objects for reading from Files
		File inFile;
		// String for holding expression
		String expression;
		// Asking user to choose method of input
		System.out.println("Choose input method for the expression:");
		System.out.println("1.   One Expression from the keyboard");
		System.out.println("2.   Expression from the input file");
		// integer for receiving input choice
		int choice = keyboard.nextInt();
		// removing leftover newLine character
		keyboard.nextLine();
		// do-while loop for input validation
		do {
			// switch statement for executing menu choice
			switch (choice) {
			// case 1: Input from Keyboard
			case 1:
				// Saving keyboard input
				System.out.println("Please enter the expression:");
				expression = keyboard.nextLine();
				// Splitting expression into String array
				expSplit = expression.split("(?<=[-+*/()])|(?=[-+*/()])");
				
				// executing phase 1 & 2
				phase1(expSplit, operatorStack, operandStack);
				phase2(operatorStack, operandStack);
				// Displaying results
				display(expSplit, operatorStack, operandStack);
				break;
			// case 2: Input from keyboard
			case 2:
				// Asking and reading file name
				System.out.println("Please enter the file name:");
				Scanner readFile = new Scanner(new File(keyboard.nextLine()));
				// Looping to read File
				while (readFile.hasNext()) // Continue while file has more lines to read
				{
					expression = readFile.nextLine();					
					// Splitting expression into String array
					expSplit = expression.split("(?<=[-+*/()])|(?=[-+*/()])");
					// executing phase 1 & 2
					phase1(expSplit, operatorStack, operandStack);
					phase2(operatorStack, operandStack);
					// Displaying results
					display(expSplit, operatorStack, operandStack);
				} 					
				break;
			default:
				System.out.println("** Invalid Input **");
				System.out.println("Choose input method for the expression:");
				System.out.println("1.   One Expression from the keyboard");
				System.out.println("2.   Expression from the input file");
			}// end of switch statement
		} while (choice != 1 && choice != 2);// repeat while input is invalid

	}// end of main method

	/*
	 * This is the PHASE 1 method
	 */
	public static void phase1(String[] exp, GenericStack<String> operators, GenericStack<String> operands) {
		// if number push to operators
		for (String s : exp) {
			// if a number, push to operand stack
			if (Character.isDigit(s.charAt(0)))
				operands.push(s);
			// if +,-,*,or / push to operators if empty
			if (s.charAt(0) == '+' | s.charAt(0) == '-' | s.charAt(0) == '*' | s.charAt(0) == '/') {
				if (operators.peek() == null)
					operators.push(s);
				else // if not empty
				{
					// if + or - operator, process all operators
					if (s.charAt(0) == '+' | s.charAt(0) == '-') {
						while (operators.peek().charAt(0) == '+' | operators.peek().charAt(0) == '-'
								| operators.peek().charAt(0) == '*' | operators.peek().charAt(0) == '/') {
							oneOperation(operands, operators);
						}
						operators.push(s);
					}
					// if + or - operator, process all * and / operators
					if (s.charAt(0) == '*' | s.charAt(0) == '/') {
						while (operators.peek().charAt(0) == '*' | operators.peek().charAt(0) == '/') {
							oneOperation(operands, operators);
						}
						operators.push(s);
					}
				}

			} // end of operator if statement
				// if '(' push to operator stack
			if (s.charAt(0) == '(')
				operators.push(s);
			if (s.charAt(0) == ')') {
				while (operators.peek().charAt(0) != '(') {
					oneOperation(operands, operators);
				}
				// popping '(' from operators stack
				operators.pop();
			}

		} // end of for loop
	}// end of phase 1

	/*
	 * This is the PHASE 2 method
	 */
	public static void phase2(GenericStack<String> operators, GenericStack<String> operands) {
		// process any remaining operators
		while (operators.peek() != null)
			oneOperation(operands, operators);

	}

	/*
	 * This is the oneOperation method
	 */
	public static void oneOperation(GenericStack<String> operands, GenericStack<String> operators) {
		// pop operator plus operands
		char operator = operators.pop().charAt(0);
		int operand2 = Integer.parseInt(operands.pop());
		int operand1 = Integer.parseInt(operands.pop());
		// calculate result and push to operand stack
		operands.push(Integer.toString(processOneExpression(operand1, operand2, operator)));
	}

	/*
	 * This is the processOneExpression
	 */
	public static int processOneExpression(int first, int second, char operator) {
		// Declaration to save result
		int result = 0;
		// calculate one simple expression
		switch (operator) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;
		}
		// return result
		return result;
	}

	/*
	 * This is the display method
	 */
	public static void display(String[] exp, GenericStack<String> operators, GenericStack<String> operands) {
		// Print the separated expression
		for (String s : exp) {
			System.out.println(s);
		}
		// Display Result
		System.out.print("\nRESULT: ");
		System.out.print(operands.pop()+"\n");
	}// end of display method
}// end of FA2018LAB4_EvaluatingInfixedExpression_Amaya class
