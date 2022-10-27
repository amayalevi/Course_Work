//CheckingAccount_Amaya.java
/*
 * This is the Checking Account Data Class.
 */
public class CheckingAccount_Amaya extends Account_Amaya // Checking Account inherents from Account Class
{
	// new field serviceFee
	private double serviceFee;

	/*
	 * This is the No-arg Constructor. It calls the super class constructor.
	 */
	public CheckingAccount_Amaya() {
		super();
		serviceFee = 0.0;
	}

	/*
	 * This is the Argument Constructor. It calls the argument constructor from the
	 * supper class.
	 */
	public CheckingAccount_Amaya(String first, String last, String address, double servFee) {
		super(first, last, address, 0.0);
		this.serviceFee = servFee;
	}

	/*
	 * Copy Constructor
	 */
	public CheckingAccount_Amaya(CheckingAccount_Amaya copy) {
		super(copy);
		this.serviceFee = copy.serviceFee;
	}

	/*
	 * This is the open Account method. It calls the super class's openAccount
	 * method after checking the correct deposit amount.
	 */
	public void openAccount(double down) {
		// update balance
		this.balance += down;
		// Checks deposit amount
		if (this.balance < 20.0) {
			System.out.println("\"invalid open account amount\"\n");
		} else {
			System.out.printf("Account Type:%20s\n", "Checking Account");
			super.openAccount(down);
		}
	}

	/*
	 * This method prints the current account information.
	 */
	public void currentBalance() {
		System.out.printf("Account Type:%20s\n", "Checking Account");
		super.currentBalance();
	}

	/*
	 * This method adds a deposit to the account's balance.
	 */
	public void deposit(double amount) {
		System.out.printf("Account Type:%20s\n", "Checking Account");
		super.deposit(amount);
	}

	/*
	 * This method withdraws an amount from the account's balance. If the balance is
	 * too low, the withdraw is denied.
	 */
	public void withdraw(double amount) {
		if (this.balance - amount < 20.0) {
			System.out.printf("Account Type:%20\n", "Checking Account");
			System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
			System.out.printf("Account Number:%18s\n", this.accountNumber);
			System.out.printf("Withdraw Amount:%17.1f - denied\n", amount);
			System.out.printf("New Balance:%21.1f\n\n", this.balance);

		} else {
			System.out.printf("Account Type:%20s\n", "Checking Account");
			super.withdraw(amount);
		}
	}

	/*
	 * This method prints the monthly report and charges the monthly fee.
	 */
	public void printMonthly() {
		this.balance -= this.serviceFee;
		System.out.printf("Account Type:%20s\n", "Checking Account");
		System.out.printf("Service Fee:%21.0f\n", this.serviceFee);
		super.printMonthly();

	}

	/*
	 * DeepCopy Method
	 */
	public CheckingAccount_Amaya deepCopy() {
		return new CheckingAccount_Amaya(this);

	}

	/*
	 * CompareTo method
	 */
	public int compareTo(String s) {
		return super.compareTo(s);
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
		str += String.format("Account Type:%20s\n", "Checking Account");
		str += super.toString();
		return str;
	}
}// end class
