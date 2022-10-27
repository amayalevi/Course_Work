//GenericStack.java

/*
 * This is the Generic Stack class
 */
public class GenericStack<T> {
	private T[] data;
	private int top;
	private int size;

	/*
	 * This is the No-arg constructor
	 */
	public GenericStack() {
		top = -1;
		size = 100;
		data = (T[]) new Object[100];
	}

	/*
	 * This is the argument Constructor
	 */
	public GenericStack(int n) {
		top = -1;
		size = n;
		data = (T[]) new Object[n];
	}

	/*
	 * This is the push method
	 */
	public boolean push(T newNode) {
		if (top == size - 1)
			return false;// ** underflow error **
		else {
			top = top + 1;
			data[top] = (T) newNode;
			return true;// push operation successful
		}
	}

	/*
	 * This is the pop method
	 */
	public T pop() {
		int topLocation;
		if (top == -1)
			return null; // ** underflow error **
		else {
			topLocation = top;
			top = top - 1;
			return data[topLocation];
		}

	}

	/*
	 * This is the peek method
	 */
	public T peek()
	{
		if (top == -1)
			return null; // ** underflow error **
		else
			return data[top];
	}
	/*
	 * This is the showAll method
	 */
	public void showAll() {
		for (int i = top; 1 >= 0; i--)
			System.out.println(data[i].toString());
	}// end of showAll method
}// end of GenericStack class
