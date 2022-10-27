//BankCustomer_Amaya.java
import java.io.File;//Needed to use Files
import java.io.FileNotFoundException;
import java.io.PrintWriter;//Needed to Write to File


/*
 * This is the BankCustomer_Amaya Data class
 */
public class BankCustomer_Amaya {

	// Class fields
	private String id;// should be SS number
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;

	/*
	 * No-arg Constructor
	 */
	public BankCustomer_Amaya() {
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.userName = "";
		this.password = "";
		this.address = "";

	}

	/*
	 * Argument Constructor
	 */
	public BankCustomer_Amaya(String i, String last, String first, String user, String pass, String add) {
		// passes the Strings and save them in the object's fields
		this.id = i;
		this.firstName = first;
		this.lastName = last;
		this.userName = user;
		this.password = pass;
		this.address = add;
	}

	/*
	 * Copy Constructor - Used in conjunction with deepCopy method
	 */
	public BankCustomer_Amaya(BankCustomer_Amaya original) {
		this.id = original.id;
		this.firstName = original.firstName;
		this.lastName = original.lastName;
		this.userName = original.userName;
		this.password = original.password;
		this.address = original.address;
	}

	/*
	 * getKey method This method uses id field as the object's "Key"
	 */
	public String getKey() {
		return this.id;
	}

	/*
	 * getAddress method- for use in the encapsulation phase
	 */
	public String getAddress() {
		return this.address;
	}

	/*
	 * setAddress method- for use in the encapsulation phase
	 */
	public void setAddress(String newAdd) {
		this.address = newAdd;
	}

	/*
	 * deepCopy method - Returns a deep copy of the object
	 */
	public BankCustomer_Amaya deepCopy() {
		return new BankCustomer_Amaya(this);
	}

	/*
	 * compareTo method
	 */
	public int compareTo(String compare) {
		return this.id.compareTo(compare);
	}

	/*
	 * toString method
	 */
	public String toString() {
		String print = "";
		print += String.format("Account Number:%17s\n", this.id);
		print += String.format("Account Name:%9s,%9s\n", this.lastName, this.firstName);
		print += String.format("Account Username:%15s\n", this.userName);
		print += String.format("Account Address:%16s\n", this.address);
		return print;
	}

	/*
	 * writeString method - returns a file formated String
	 */
	public String writeString() {
		
		return this.id + "," + this.lastName + "," + this.firstName + "," + this.userName + "," + this.password + ","
				+ this.address;

	}

	/*
	 * writeToFile method - Write to Output File
	 
	public void writeToFile(File outFile, LqHashed list) throws FileNotFoundException//If file doesn't exist
	{
		PrintWriter writeTo = new PrintWriter(outFile);
		BankCustomer_Amaya[] nodeList= list.getData();
		for(BankCustomer_Amaya node:nodeList)
		{
			if(node !=null)
				writeTo.println(node.writeString());
		}
		writeTo.close();
	}*/
}// end of BankCustomer_Amaya class
