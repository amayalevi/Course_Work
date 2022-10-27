//BinarySearchTree

/*
 * This is the BinarySearchTree class
 */
public class BinarySearchTree {

	TreeNode root;

	/*
	 * This is the No-arg binary Tree Constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

	/*
	 * This is the insert method
	 */
	public boolean insert(BankCustomer_Amaya newNode) {
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		TreeNode n = new TreeNode();
		if (n == null)// out of memory
			return false;
		else// insert the node
		{
			n.node = newNode.deepCopy();// fill in the TreeNodes's fields
			n.lc = null;
			n.rc = null;
			if (root == null)// tree is empty
			{
				root = n;
			}
			//tree is not empty 
			else {
				findNode(newNode.getKey(), p, c);// find the node's parent
				if (newNode.getKey().compareTo(p.get().node.getKey()) <= 0)// if same id, make left child
					p.get().lc = n; // insert new node as a left child
				else
					p.get().rc = n; // insert new node as a right child
			}
			return true;
		}

	}// end of insert method

	/*
	 * This is the fetch method
	 */
	public BankCustomer_Amaya fetch(String targetKey) {
		boolean found;
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		found = findNode(targetKey, p, c);// locate the node
		if (found == true)
			return c.get().node.deepCopy();
		else
			return null;
	}// end of fetch method

	/*
	 * This is the delete method
	 */
	public boolean delete(String targetKey) {
		boolean found;
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		TreeNode largest;
		TreeNode nextLargest;
		found = findNode(targetKey, p, c);
		if (found == false)// node not found
			return false;
		else// identify the case number
		{
			if (c.get().lc == null && c.get().rc == null) // case 1: deleted node has no children
			{
				if (c.get() == root)// if delete node is the root node
					root = null;
				else {
					if (p.get().lc == c.get()) // deleted node is a left child
						p.get().lc = null;
					else // deleted node is a right child
						p.get().rc = null;
				}
			} // end of case 1
			else if (c.get().lc == null || c.get().rc == null) // case 2: 1 child
			{
				if (c.get() == root) // if deleted node is the root node
				{
					if (c.get().lc != null)// if root has a left child
						root = c.get().lc;
					else // root has a right child
						root = c.get().rc;
				} else // deleted node is not the root node
				{
					if (p.get().lc == c.get()) // deleted node is a left child
					{
						if (c.get().lc != null) // deleted node has a left child
							p.get().lc = c.get().lc;
						else
							p.get().lc = c.get().rc;
					} else // deleted node is a right child
					{
						if (c.get().lc != null) // deleted node has a left child
							p.get().rc = c.get().lc;
						else
							p.get().rc = c.get().rc;
					}
				} // end of root if statement
			} // end of case 2
			else // case 3: deleted node has two children
			{
				nextLargest = c.get().lc;
				largest = nextLargest.rc;
				if (largest != null) // left child has a right subtree
				{
					while (largest.rc != null) // move down right subtree
					{
						nextLargest = largest;
						largest = largest.rc;
					}
					if (c.get() == root) // if delete node is the root node
						root.node = largest.node;
					else
						c.get().node = largest.node;// overwrite deleted node
					nextLargest.rc = largest.lc;// save the left subtree

				} else // left child does not have a right subtree
				{
					nextLargest.rc = c.get().rc; // save the right subtree
					if (c.get() == root)// if deleted node is the root node
						root = c.get().lc;
					else { // deleted node is not the root node
						if (p.get().lc == c.get()) // deleted node is a left child
							p.get().lc = nextLargest; // jump around deleted node
						else // deleted node is a right child
							p.get().rc = nextLargest; // jump around deleted node
					}
				}
			} // end of case 3
			return true;
		}
	}// end of delete method

	/*
	 * This is the update method
	 */
	public boolean update(String targetKey, BankCustomer_Amaya newNode) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newNode) == false)
			return false;
		return true;
	}// end of update method

	/*
	 * This is the showAll method
	 */
	public void showAll() {
		if (root == null) // check for empty tree
			System.out.println("**The Structure is empty**");
		else
			LNRoutputTraversal(root);

	}// end of showAll method

	/*
	 * This is the LNR output Traversal method. Used in conjunction with the showAll
	 * method
	 */
	public void LNRoutputTraversal(TreeNode root) {
		//Left to right - AKA Ascending order
		if (root.lc != null)
			LNRoutputTraversal(root.lc); // traverse the entire left subtree
		System.out.println(root.node); // output the root node
		if (root.rc != null)
			LNRoutputTraversal(root.rc); // traverse the entire right subtree
	}// end of the LNRoutputTraversal method
	/*
	 * This is the TreeNode inner class
	 */

	public class TreeNode {
		private BankCustomer_Amaya node;
		private TreeNode lc;
		private TreeNode rc;

		/*
		 * This is the no-arg constructor for TreeNode
		 */
		public TreeNode() {
		}
	}// end of TreeNode class

	/*
	 * This is the findNode method
	 */
	public boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
		parent.set(root);
		child.set(root);
		if (root == null) // tree is empty
			return false;
		while (child.get() != null) {
			if (child.get().node.compareTo(targetKey) == 0)// node found
				return true;
			else {
				parent.set(child.get());
				if (targetKey.compareTo(child.get().node.getKey()) <= 0)// if key is less than or equal to
					child.set(child.get().lc);
				else
					child.set(child.get().rc);
			}
		} // end while
		return false;
	}// end of findNode

	/*
	 * This is the TreeNodeWrapper inner class
	 */
	public class TreeNodeWrapper {
		TreeNode treeRef = null;

		/*
		 * TreeNodeWrapper no-arg constructor
		 */
		public TreeNodeWrapper() {
		}

		/*
		 * TreeNodeWrapper get method
		 */
		public TreeNode get() {
			return treeRef;
		}

		/*
		 * TreeNodeWrapper set method
		 */
		public void set(TreeNode t) {
			treeRef = t;
		}
	}// end of TreeNodeWrapper inner class
}// end of BinarySearchTree class
