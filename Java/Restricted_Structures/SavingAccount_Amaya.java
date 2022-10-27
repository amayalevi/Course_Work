//SavingAccount.java
/*
 * This is the Saving Account Data Class.
 */
public class SavingAccount_Amaya extends Account_Amaya {// Saving Account inherents from Account Class
	// new field interestRate
	private double interestRate;

	/*
	 * This is the No-arg Constructor. It calls the super class constructor.
	 */
	public SavingAccount_Amaya() {
		super();
		interestRate = 0.0;
	}

	/*
	 * This is the Argument Constructor. It calls the argument constructor from the
	 * supper class.
	 */
	public SavingAccount_Amaya(String first, String last, String address, double intRate) {
		super(first, last, address, 0.0);
		this.interestRate = intRate;
	}

	/*
	 * Copy Constructor
	 */
	public SavingAccount_Amaya(SavingAccount_Amaya copy) {
		super(copy);
		this.interestRate = copy.interestRate;
	}

	/*
	 * This is the open Account method. It calls the super class's openAccount
	 * method after checking the correct deposit amount.
	 */
	public void openAccount(double down) {
		// update balance
		this.balance += down;
		// Checks deposit amount
		if (this.balance < 50.0) {
			System.out.println("\"invalid open account amount\"\n");
		} else {
			System.out.printf("Account Type:%20s\n", "Saving Account");
			super.openAccount(down);
		}

	}

	/*
	 * This method prints the current account information.
	 */
	public void currentBalance() {
		System.out.printf("Account Type:%20s\n", "Saving Account");
		super.currentBalance();
	}

	/*
	 * This method adds a deposit to the account's balance.
	 */
	public void deposit(double amount) {
		System.out.printf("Account Type:%20s\n", "Saving Account");
		super.deposit(amount);
	}

	/*
	 * This method withdraws an amount from the account's balance. If the balance is
	 * too low, the withdraw is denied.
	 */
	public void withdraw(double amount) {
		if (this.balance - amount < 50.0) {
			System.out.printf("Account Type:%20s\n", "Saving Account");
			System.out.printf("Account Name:%9s, %9s\n", this.lastName, this.firstName);
			System.out.printf("Account Number:%18s\n", this.accountNumber);
			System.out.printf("Withdraw Amount:%17.1f - denied\n", amount);
			System.out.printf("New Balance:%21.1f\n\n", this.balance);
		} else {
			System.out.printf("Account Type:%20s\n", "Saving Account");
			super.withdraw(amount);
		}
	}

	/*
	 * This method prints the monthly report and increases the balance with the
	 * interest amount.
	 */
	public void printMonthly() {
		double amount = (this.interestRate / 100.0) * this.balance;
		this.balance += amount;
		System.out.printf("Account Type:%20s\n", "Saving Account");
		System.out.printf("Interest rate:%19.1f\n", this.interestRate);
		System.out.printf("Interest amount:%17.1f\n", amount);
		super.printMonthly();

	}

	/*
	 * DeepCopy Method
	 */
	public SavingAccount_Amaya deepCopy() {
		return new SavingAccount_Amaya(this);
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
		return false;
	}

	/*
	 * toString method
	 */
	public String toString() {
		String str = "";
		System.out.printf("Account Type:%20s\n", "Saving Account");
		str += super.toString();
		return str;
	}
}// end class
