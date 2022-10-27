//BankCheckingAccount_Amaya.java
import java.text.DecimalFormat;//Needed for formatting float values

/*
 * This is the BankCheckingAccount_Amaya class
 */
public class BankCheckingAccount_Amaya extends BankAccount_Amaya
// This class is a child class of the BankAccount_Amaya class
{
	// fields
	private float limitAmount;
	private float serviceFee;

	/*
	 * No-arg Constructor
	 */
	public BankCheckingAccount_Amaya() {
		super();
		limitAmount = 0.0f;
		serviceFee = 0.0f;
	}//end of constructor

	/*
	 * Argument Constructor
	 */
	public BankCheckingAccount_Amaya(String accNum, float bal, float limit, float servFee) {
		//Assigning fields
		super(accNum, bal);
		this.limitAmount = limit;
		this.serviceFee = servFee;
	}//end of arg constructor

	/*
	 * This is the checkBalance method. This method prints the account status as a
	 * String.
	 */
	public void checkBalance() {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		//Printing the account balance
		String print = String.format("Account Type:   Checking Account\n");
		print += String.format("Account Number:       %s\n", this.accountNumber);
		print += String.format("Current Balance:      %10s\n", formatter.format(this.balance));
		System.out.println(print);
	}//end of checkBalance statement

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
	}//end of deposit statement

	/*
	 * This is the withdraw method. It checks and removes the amount specified from
	 * the account balance. It also prints the result from the withdrawal.
	 */
	public void withdraw(float amount) {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		// Checking if withdrawal lowers the balance past the limit
		if ((this.balance - amount) < this.limitAmount)
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
		//Balance is equal too or greater than the limit
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
	 * This is the printMonthly method. It processes the Monthly Statement for the
	 * account.
	 */
	public void printMonthly() {
		// Monthly Service Fee is applied
		this.balance -= this.serviceFee;
	}//end of printMonthly method

	/*
	 * This is the toString method It return a String for the Object
	 */
	public String toString() {
		// Number formatter for Currency values
		DecimalFormat formatter = new DecimalFormat("$#.0");
		//Creating Output String
		String print = String.format("Account Type:   Checking Account\n");
		print += String.format("Account Number:       %s\n", super.accountNumber);
		print += String.format("Current Balance:      %10s\n", formatter.format(super.balance));
		print += String.format("Limit Amount:         %10s\n", formatter.format(this.limitAmount));
		print += String.format("Service Fee:          %10s\n", formatter.format(this.serviceFee));
		return print;
	}//end of toString method

	/*
	 * compareTo method. This method compares the targetKey with the Account's
	 * number
	 */
	public int compareTo(String targetKey) {
		return super.compareTo(targetKey);
	}//end of compareTo method

	/*
	 * This is the writeToFile method. This method returns the to-File String
	 */
	public String writeToFile() {
		return super.writeToFile() + String.format(",%f,%f", this.limitAmount, this.serviceFee);
	}
}// end of BankCheckingAccount_Amaya class
