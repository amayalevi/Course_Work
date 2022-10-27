
//Account_Amaya.java
/*
 * This is the Data Type Class for using a bank account.
 */
import java.util.Random;

public class Account_Amaya {
	// These are the private fields that are used by the Class.
	protected String accountNumber;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected double balance;

	protected double serviceFee;
	protected double interestRate;

	/*
	 * This is the No-arg Constructor. It initializes the fields to default values.
	 */
	public Account_Amaya() {
		this.accountNumber = "0";
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.balance = 0.0;
	}

	/*
	 * This is the Argument Constructor. It accepts 3 Strings and one double and
	 * initializes the fields.
	 */
	public Account_Amaya(String firstName, String lastName, String address, double balance) {
		// rand object to generate random 10 digit string
		Random rand = new Random();
		int number = (rand.nextInt((int) 9000000000l) + 1) + 999999999;
		this.accountNumber = Integer.toString(number);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.balance = balance;
	}

	/*
	 * Copy Constructor
	 */
	public Account_Amaya(Account_Amaya copy) {
		this.accountNumber = copy.accountNumber;
		this.firstName = copy.firstName;
		this.lastName = copy.lastName;
		this.address = copy.address;
		this.balance = copy.balance;
	}

	/*
	 * This method displays the information on the account after it has been
	 * created.
	 */
	public void openAccount(double d) {
		System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		System.out.printf("Account Number:%18s\n", this.accountNumber);
		System.out.printf("New Account Balance:%13.1f\n\n", this.balance);
	}

	/*
	 * This method is used to CHECK the current balance in the account.
	 */
	public void currentBalance() {
		System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		System.out.printf("Account Number:%18s\n", this.accountNumber);
		System.out.printf("Current Balance:%17.1f\n\n", this.balance);

	}

	/*
	 * This method DEPOSITS an amount to the account.
	 */
	public void deposit(double amount) {
		this.balance += amount;
		System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		System.out.printf("Account Number:%18s\n", this.accountNumber);
		System.out.printf("Deposit Amount:%18.1f\n", amount);
		System.out.printf("New Balance:%21.1f\n\n", this.balance);
	}

	/*
	 * This method WITHDRAWS an amount from an account
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		System.out.printf("Account Number:%18s\n", this.accountNumber);
		System.out.printf("Withdraw Amount:%17.1f\n", amount);
		System.out.printf("New Balance:%21.1f\n\n", this.balance);
	}

	/*
	 * This method displays a Monthly Statement of the account.
	 */
	public void printMonthly() {
		System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		System.out.printf("Account Number:%18s\n", this.accountNumber);
		System.out.printf("End Balance:%21.1f\n\n", this.balance);

	}

	/*
	 * DeepCopy Method
	 */
	public Account_Amaya deepCopy() {
		return new Account_Amaya(this);
	}

	/*
	 * compareTo Method
	 */
	public int compareTo(String s) {
		return this.accountNumber.compareTo(s);
	}

	/*
	 * CheckorSave Method
	 */
	public boolean checkOrSave() {
		return true;
	}

	/*
	 * toString method
	 */
	public String toString() {
		String str = "";
		str += String.format("Account Name:%9s, %9s\n", this.lastName, this.firstName);
		str += String.format("Account Number:%18s\n", this.accountNumber);
		str += String.format("Current Balance:%17.1f\n", this.balance);

		return str;
	}
}
