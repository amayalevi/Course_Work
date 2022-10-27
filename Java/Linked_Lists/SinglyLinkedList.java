//SinglyLinkedList.java
/*
 * This is the Singly Linked List Data Class
 */
public class SinglyLinkedList {

	private Node h; // list header
	/*
	 * This is the No argument constructor
	 */

	public SinglyLinkedList() {
		h = new Node();// dummy Node
		h.l = null;
		h.next = null;
	}

	/*
	 * This is the insert method for the Singly Linked List
	 */
	public boolean insert(Account_Amaya newNode) {
		Node n = new Node();
		if (n == null)// out of memory
			return false;
		else {
			n.next = h.next;
			h.next = n;
			n.l = newNode.deepCopy();
			return true;
		}
	}

	/*
	 * This is the fetch method for the Singly Linked List
	 */
	public Account_Amaya fetch(String targetKey) {
		Node p = h.next;
		while (p != null && !(p.l.compareTo(targetKey) == 0)) {
			p = p.next;
		}
		if (p != null)
			return p.l.deepCopy();
		else
			return null;
	}

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
	}

	/*
	 * This is the update method for the Singly Linked List
	 */
	public boolean update(String targetKey, Account_Amaya newNode) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newNode) == false)
			return false;
		return true;
	}

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
	}

	/*
	 * This is the peek method for the SLL Data Structure
	 */
	public Account_Amaya peek() {
		Node p = h.next;
		if (p != null)
			return p.l.deepCopy();
		else
			return null;

	}

	/*
	 * This is the inner class Node for the Singly Linked List
	 */
	public class Node {
		// data members for Singly linked List
		private Account_Amaya l;
		private Node next;

		// No argument constructor for Node
		public Node() {

		}
	}// end of inner class Node
}// end of SinglyLinkedList class
