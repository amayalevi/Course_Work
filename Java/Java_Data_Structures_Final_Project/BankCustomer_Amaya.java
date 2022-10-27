//BankCustomer_Amaya.java
import java.util.LinkedList;//Java provided linked List Structure

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
	// Linked List Data Structure field to hold all bank accounts
	private LinkedList<BankAccount_Amaya> listAccount;

	/*
	 * No-arg Constructor
	 */
	public BankCustomer_Amaya() {
		//Declaring fields
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.userName = "";
		this.password = "";
		this.address = "";
		listAccount = new LinkedList<BankAccount_Amaya>();
	}//end of constructor

	/*
	 * Argument Constructor
	 */
	public BankCustomer_Amaya(String i, String last, String first, String user, String pass, String add) {
		// Passes the parameter Strings and saves them in the object's fields
		this.id = i;
		this.firstName = first;
		this.lastName = last;
		this.userName = user;
		this.password = pass;
		this.address = add;
		listAccount = new LinkedList<BankAccount_Amaya>();
	}//end of arg constructor

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
		// Copying the Linked List
		this.listAccount = new LinkedList<BankAccount_Amaya>();
		BankAccount_Amaya[] temp = original.listAccount.toArray(new BankAccount_Amaya[0]);
		for (BankAccount_Amaya account : temp)
			this.listAccount.add(account);
	}//end of Copy Constructor

	/*
	 * This is the printMonthly method. It returns a String of the Monthly
	 * Statement.
	 */
	public String printMonthly() {

		// Saving all Accounts
		BankAccount_Amaya[] temp = this.listAccount.toArray(new BankAccount_Amaya[0]);
		// Processing Monthly Statement
		for (BankAccount_Amaya account : temp)
			account.printMonthly();
		// Returning Statement Header
		return "-------MONTHLY STATEMENT:-------";
	}//end of printMonthly method

	/*
	 * This is the insertAccount method. It adds one account to the Bank Customer's
	 * account(s)
	 */
	public void addNewAccount(BankAccount_Amaya account) {
		this.listAccount.add(account);
	}//end of addNewAccount method

	/*
	 * getKey method - This method uses the id field
	 * as the object's node "Key"
	 */
	public String getKey() {
		return this.id;
	}//end of getKey method

	/*
	 * getName method - Return's output String of Customer's name
	 */
	public String getName() {
		return String.format("%s, %s", this.lastName, this.firstName);
	}//end of getName

	/*
	 * getAddress method- For use in the encapsulation phase
	 */
	public String getAddress() {
		return this.address;
	}//end of getAddress method

	/*
	 * setAddress method- for use in the encapsulation phase
	 */
	public void setAddress(String newAdd) {
		this.address = newAdd;
	}//end of setAddress method

	/*
	 * getUsername method
	 */
	public String getUsername() {
		return this.userName;
	}//end of getUsername method

	/*
	 * getPassword method
	 */
	public String getPassword() {
		return this.password;
	}//end of getPassword method

	/*
	 * fetchAccount method. This method looks through the Customer's account
	 * and returns an account if there is a match.
	 */
	public BankAccount_Amaya fetchAccount(String targetKey) {
		// Creating accounts array
		BankAccount_Amaya[] temp = this.listAccount.toArray(new BankAccount_Amaya[0]);
		// Creating found account
		BankAccount_Amaya found = null;
		// Searching for Account
		for (BankAccount_Amaya account : temp)
			if (account.compareTo(targetKey) == 0)// account found!
				found = account;
		return found;
	}//end of fetchAccount

	/*
	 * closeAccount method. This method closes a bank account of the Customer.
	 */
	public boolean closeAccount(BankAccount_Amaya account) {
		return this.listAccount.remove(account);
	}//end of closeAccount method

	/*
	 * getAccounts method.This method returns the 
	 * listAccount field.
	 */
	public LinkedList<BankAccount_Amaya> getAccounts() {
		return this.listAccount;
	}//end of getAccounts method

	/*
	 * deepCopy method - Returns a deep copy of the object
	 */
	public BankCustomer_Amaya deepCopy() {
		return new BankCustomer_Amaya(this);
	}//end of deepCopy method

	/*
	 * compareTo method
	 */
	public int compareTo(String compare) {
		return this.id.compareTo(compare);
	}//end of compareTo method

	/*
	 * toString method
	 */
	public String toString() {
		// toString format
		String print = "";
		print += String.format("Customer Name:        %s, %s\n", this.lastName, this.firstName);
		print += String.format("Customer id:          %s\n", this.id);
		print += String.format("Address:              %s\n", this.address);
		print += String.format("\nList of accounts:\n");
		// Adding Bank Accounts to the toString
		BankAccount_Amaya[] listArray = this.listAccount.toArray(new BankAccount_Amaya[0]);
		for (BankAccount_Amaya account : listArray)
			print += account.toString() + "\n";
		return print;
	}//end of toString method

	/*
	 * showAll method - Displays all BankAccounts
	 */
	public void showAll() {
		for (BankAccount_Amaya account : this.listAccount)
			System.out.println(account);
	}//end of showAll method

	/*
	 * This is the writeToFile method. This method return an Output File String.
	 */
	public String writeToFile() {
		// Creating wrtie to file String
		// Writing Customer information
		String toFile = String.format("%s,%s,%s,%s,%s,%s", this.id, this.lastName, this.firstName, this.userName,
				this.password, this.address);
		// Creating Bank Account Array
		BankAccount_Amaya[] temp = this.listAccount.toArray(new BankAccount_Amaya[0]);
		// Writing Bank Account Information
		for (BankAccount_Amaya account : temp)
			toFile += account.writeToFile();
		return toFile;
	}//end of writeToFile method
}// end of BankCustomer_Amaya class
