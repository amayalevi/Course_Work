//Account_UnsortedOptimizedArray.java
public class Account_UnsortedOptimizedArray {
	
	private int next;
	private int size;
	private Account_Amaya[] data;
	
	public Account_UnsortedOptimizedArray()
	{
		next = 0;
		size =100;
		data = new Account_Amaya[size];
	}//end of constructor
	
	public boolean insert(Account_Amaya newNode)
	{	if(next >= size)	//the structure is full
		return false;
		data[next] = newNode.deepCopy(newNode);	//store a deep copy of the 
											//client's node
		if(data[next] == null) // inufficient system memory
			return false;
		next = next +1; //prepare for the next insert
		return true;		
	}//end of insert method
	
	public Account_Amaya fetch(String targetKey)
	{
		Account_Amaya node;
		Account_Amaya temp;
		//access the node using a sequential search
		int i =0;
		while(i < next && !(data[i].compareTo(targetKey) == 0))
		{ i++;
		}
		if(i == next)//node not found
			return null;
		//deep copy the node's information into the client's node
		node = data[i].deepCopy(data[i]);
		//move the node up one position in the array, unless it is the
		//first node
		if(i != 0)	//bubble up accessed node
		{	temp = data[i-1];
		data[i-1] = data[i];
		data[i] = temp;
		}
		return node;
	}// end of fetch method
	
	public boolean delete(String targetKey)
	{//access the node using a sequential search
		int i=0;
		
		while(i < next && !(data[i].compareTo(targetKey) == 0))
		{i++;
		
		}
		if(i==next) //node not found
			return false;
		// move the last node into the deleted node's position
		data[i] = data[next - 1];
		data[next -1] = null;
		next = next - 1;
		return true;// node found and deleted
	}// end of the delete method
	
	public boolean update(String targetKey,Account_Amaya newNode)
	{
		if(delete(targetKey) == false)	// node not in structure
			return false;
		else if(insert(newNode) == false) // insufficient memory
			return false;
		else
			return true;	// node found and updated
	}	// end of update method
	/*
	 * ShowAll Method - displays the Nodes
	 */
	public String showAll()
	{
		String str= "";
		int i = 0;
		//if Data Structure is empty return "null"
		if(data[i] == null)
			return "-null-\n";
		while(data[i] != null && i != size)
			{
			str+= data[i].toString() + "\n";
			i++;
			}
		
		return str;
	}
}//end of Class Account_UnsortedOptimizedArray.java
