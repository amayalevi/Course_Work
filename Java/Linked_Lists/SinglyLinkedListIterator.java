//SinglyLinkedListIterator.java
/*
 * This is the SinglyLinkedListIterator Data class
 */
public class SinglyLinkedListIterator {
	// PAGE 21333333333333333333333333333333333333
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
		public Account_Amaya next() {
			ip = ip.next;
			return ip.l.deepCopy();
		}

		/*
		 * This is the set method for the SinglyLinkedListIterator class
		 */
		public void set(Account_Amaya newNode) {
			ip.l = newNode.deepCopy();
		}
	}// end of inner class Iterator

}// end of SinglyLinkedListIterator class
