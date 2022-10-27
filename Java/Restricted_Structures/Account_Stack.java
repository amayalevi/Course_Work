//Account_Stack.java
public class Account_Stack {
	// Data members
	private Account_Amaya[] data;
	private int top;
	private int size;

	/*
	 * No argument Constructor
	 */
	public Account_Stack() {
		top = -1;
		size = 100;
		data = new Account_Amaya[100];
	}

	/*
	 * Argument Constructor for custom size
	 */
	public Account_Stack(int n) {
		top = -1;
		size = n;
		data = new Account_Amaya[n];
	}

	/*
	 * push method
	 */
	public boolean push(Account_Amaya newNode) {
		if (top == size - 1)
			return false; // ** overflow error **
		else {
			top = top + 1;
			data[top] = newNode.deepCopy();
			return true;
		}
	}// end of push method

	/*
	 * pop method
	 */
	public Account_Amaya pop() {
		int topLocation;
		if (top == -1)
			return null;
		else {
			topLocation = top;
			top = top - 1;
			return data[topLocation];
		}
	}// end of pop method

	/*
	 * showAll method
	 */
	public void showAll() {
		for (int i = top; i >= 0; i--)
			System.out.println(data[i].toString());
	}// end of showAll method

	/*
	 * Peek method
	 */
	public Account_Amaya peek() {
		if (top == -1)
			return null;
		else
			return data[top].deepCopy();
	}
}// end of Stack Class
