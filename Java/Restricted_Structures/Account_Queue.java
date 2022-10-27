//Account_Queue.java
public class Account_Queue {
	// pg160
	private Account_Amaya[] data;
	private int size;
	private int numOfNodes;
	private int front;
	private int rear;
	/*
	 * No-arg Constructor
	 */
	public Account_Queue()
	{
		size =100;
		numOfNodes =0;
		front =0;
		rear =0;
		data = new Account_Amaya[100];
	}
	/*
	 * Argument Constructor
	 */
	public Account_Queue(int n) {
		size = n;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data = new Account_Amaya[100];
	}

	/*
	 * Enque method
	 */
	public boolean enque(Account_Amaya newNode) {
		if (numOfNodes == size)
			return false; // ** overflow error**
		else {
			numOfNodes = numOfNodes + 1;
			data[rear] = newNode.deepCopy();
			rear = (rear + 1) % size;
			return true; // push operation successful
		}
	}

	/*
	 * deque method
	 */
	public Account_Amaya deque() {
		int frontLocation;
		if (numOfNodes == 0)
			return null; // ** underflow error **
		else {
			frontLocation = front;
			front = (front + 1) % size;
			numOfNodes = numOfNodes - 1;
			return data[frontLocation];
		}
	}

	/*
	 * showAll method
	 */
	public void showAll() {
		int i = front;
		for (int c = 1; c <= numOfNodes; c++) {
			System.out.println(data[i].toString());
			i = (i + 1) % size;
		}
	}// end of showAll method
	
	/*
	 * Peek method
	 */
	public Account_Amaya peek() {
		if (numOfNodes == 0)
			return null;
		else
			return data[front].deepCopy();
	}
}// end of class Queue
