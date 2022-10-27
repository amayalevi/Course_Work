//BankAccount_Amaya.java
import java.text.DecimalFormat;//Needed for formatting float values

/*
 * This is the BankAccount_Amaya class
 */
public class BankAccount_Amaya {
	// fields
	protected String accountNumber;
	protected float balance;

	/*
	 * No-arg Constructor
	 */
	public BankAccount_Amaya() {
		accountNumber = "";
		balance = 0.0f;
	}//end of constructor

	/*
	 * Argument Constructor
	 */
	public BankAccount_Amaya(String accNum, float bal) {
		//setting parameter fields
		this.accountNumber = accNum;
		this.balance = bal;
	}//end of arg constructor

	/*
	 * This getAccountNum method. 
	 * Returns the account number.
	 */
	public String getAccountNum() {
		return this.accountNumber;
	}//end of getAccountNum method

	/*
	 * This is the checkBalance method. 
	 * This prints the Account's status as a String.
	 */
	public void checkBalance() {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		//Printing the account balance
		String print = String.format("Account Type:       Bank Account\n");
		print += String.format("Account Number:       %s\n", this.accountNumber);
		print += String.format("Current Balance:      %10s\n", formatter.format(this.balance));
		System.out.println(print);

	}//end of checkBalance method

	/*
	 * This is the deposit method. This increases the account balance with the
	 * deposit amount and prints the deposit statement.
	 */
	public void deposit(float amount) {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		// Print regular check balance
		this.checkBalance();
		// Depositing amount to balance
		this.balance += amount;
		// Printing new balance
		System.out.printf("Deposit amount:           %s\n", formatter.format(amount));
		System.out.printf("New Balance:          %10s\n\n", formatter.format(this.balance));
	}//end of deposit method

	/*
	 * This is the withdraw method. It checks and removes the amount specified from
	 * the account balance. It also prints the result from the withdrawal.
	 */
	public void withdraw(float amount) {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		// Checking if withdrawal lowers the balance $0.00
		if ((this.balance - amount) < 0.0)
		// past the allowed limit
		{
			// Printing regular check balance
			String print = String.format("Account Type:   Checking Account\n");
			print += String.format("Account Number:       %s\n", this.accountNumber);
			print += String.format("Current Balance:      %10s", formatter.format(this.balance));
			System.out.println(print);
			// Printing denial statement
			System.out.printf("Withdraw amount:         %s - denied\n", formatter.format(amount));
			System.out.printf("Current Balance:      %10s\n\n", formatter.format(this.balance));

		}
		// Balance is equal too or greater than the limit
		else {
			// Print regular check balance
			this.checkBalance();
			// Withdrawing amount from balance
			this.balance -= amount;
			// Printing new balance
			System.out.printf("Withdraw amount:          %s\n", formatter.format(amount));
			System.out.printf("New Balance:          %10s\n\n", formatter.format(this.balance));
		}//end of if statement
	}//end of withdraw method

	/*
	 * This is the printMonthly method.
	 * It processes the Monthly Statement for the account.
	 */
	public void printMonthly() {
		// There is nothing to process for this type of account.
	}//end of printMonthly method

	/*
	 * This is the toString method.
	 * It return a String for the Object.
	 */
	public String toString() {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		//Creating Output String
		String print = String.format("Account Type:       Bank Account\n");
		print += String.format("Account Number:       %s\n", this.accountNumber);
		print += String.format("Current Balance:      %10s\n", formatter.format(this.balance));
		return print;
	}//end of toString method

	/*
	 * This is the compareTo method.
	 * This method compares the targetKey with the Account's number.
	 */
	public int compareTo(String targetKey) {
		return this.accountNumber.compareTo(targetKey);
	}//end of compareTo method

	/*
	 * This is the writeToFile method. This method returns the to-File String
	 */
	public String writeToFile() {
		return String.format(",%s,%f", this.accountNumber, this.balance);
	}//end of writeToFile method
}// end of BankAccount_Amaya class
