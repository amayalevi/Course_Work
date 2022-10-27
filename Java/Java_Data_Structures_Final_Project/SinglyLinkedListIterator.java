//SinglyLinkedListIterator.java
/*
 * This is the SinglyLinkedListIterator Data class
 */
public class SinglyLinkedListIterator {

	private Node h; // list header
	public Iterator i;
	/*
	 * This is the No argument constructor
	 */

	public SinglyLinkedListIterator() {
		h = new Node();// allocates the dummy Node
		i = new Iterator();
		h.l = null;
		h.next = null;
	}//end of Constructor

	/*
	 * This is the insert method for the Singly Linked List
	 */
	public boolean insert(BankCustomer_Amaya newNode) {
		Node n = new Node();
		if (n == null)// out of memory
			return false;
		else {
			n.next = h.next;
			h.next = n;
			n.l = newNode.deepCopy();
			return true;
		}
	}//end of insert method

	/*
	 * This is the fetch method for the Singly Linked List
	 */
	public BankCustomer_Amaya fetch(String targetKey) {
		Node p = h.next;
		while (p != null && !(p.l.compareTo(targetKey) == 0)) {
			p = p.next;
		}
		if (p != null)
			return p.l.deepCopy();
		else
			return null;
	}//end of fetch method

	/*
	 * This is the fetch method for the Singly Linked List. This version searches by
	 * matching the username and password.
	 */
	public BankCustomer_Amaya fetch(String user, String pass) {
		Node p = h.next;
		while (p != null && (p.l.getUsername().compareTo(user) != 0) && (p.l.getPassword().compareTo(pass) != 0)) {
			p = p.next;
		}
		if (p != null && (p.l.getUsername().compareTo(user) == 0) && (p.l.getPassword().compareTo(pass) == 0))
			return p.l.deepCopy();// only if all three conditions are met
		else
			return null;
	}//end of fetch method

	/*
	 * This is the delete method for the Singly Linked List
	 */
	public boolean delete(String targetKey) {
		Node q = h;
		Node p = h.next;
		while (p != null && !(p.l.compareTo(targetKey) == 0)) {
			q = p;
			p = p.next;
		}
		if (p != null) {
			q.next = p.next;
			return true;
		} else
			return false;
	}//end of delete method

	/*
	 * This is the update method for the Singly Linked List
	 */
	public boolean update(String targetKey, BankCustomer_Amaya newNode) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newNode) == false)
			return false;
		return true;
	}//end of update method

	/*
	 * This is the showAll method for the Singly Linked List
	 */
	public void showAll() {

		Node p = h.next;
		while (p != null)// continue to traverse the list
		{
			System.out.println(p.l.toString());
			p = p.next;
		}
	}//end of showAll method

	/*
	 * This is the printMonthly method. This method processes the monthly statements
	 * for all the Customers.
	 */
	public void printMonthly() {
		Node p = h.next;
		while (p != null)// continue to traverse the list
		{
			// Processes the Monthly Statement
			System.out.println(p.l.printMonthly());
			// Print results
			System.out.println(p.l.toString());
			p = p.next;
		}
	}//end of printMonthly method

	/*
	 * This is the inner class Node for the Singly Linked List
	 */
	public class Node {
		// data members for Singly linked List
		private BankCustomer_Amaya l;
		private Node next;

		// No argument constructor for Node
		public Node() {

		}
	}// end of inner class Node

	/*
	 * This is the no argument constructor for the Iterator inner class
	 */
	public class Iterator {
		private Node ip;

		/*
		 * No-arg Constructor for Iterator
		 */
		public Iterator() {
			ip = h;
		}

		/*
		 * This is the reset method for the iterator
		 */
		public void reset() {
			ip = h;
		}

		/*
		 * This is the hasNext method for the Iterator
		 */
		public boolean hasNext() {
			if (ip.next != null)
				return true;
			else
				return false;
		}

		/*
		 * This is the next method for the SinglyLinkedListIterator class
		 */
		public BankCustomer_Amaya next() {
			ip = ip.next;
			return ip.l.deepCopy();
		}

		/*
		 * This is the set method for the SinglyLinkedListIterator class
		 */
		public void set(BankCustomer_Amaya newNode) {
			ip.l = newNode.deepCopy();
		}
	}// end of inner class Iterator
}// end of SinglyLinkedListIterator class
