import java.util.Random;//Needed for generatinf Credit Card Number
import java.util.Scanner;//Needed for receiving input from user
import java.io.File;//Needed to save to file
import java.io.FileWriter;//Needed to append to Files
import java.io.IOException;//Needed if file error occurs
import java.text.SimpleDateFormat;//Needed for creating date format
import java.util.Date;//Needed for pring date

/*
 *This is the Data Class for managing the Credit Card account. 
 */
public class SU2018LAB5_CreditCardAccount_Amaya {
	//private members for storing needed information
	private String name;
	private String cardNumber ="";
	private String ssNumber;
	private String phoneNumber;
	private String address;
	private String username;
	private String password;
	private double creditLine =2000;
	private double availableCredit = creditLine;
	private double currentBalance;
	private double minimumBalance;
	private double interestRate;
	
	private File file = new File("Temp.txt");
	
	/*
	 *This is the no-arg Constructor 
	 */
	public SU2018LAB5_CreditCardAccount_Amaya()
	{
		this.name ="";
		this.ssNumber ="";
		this.phoneNumber ="";
		this.address ="";
		this.username ="";
		this.password ="";
		this.creditLine =2000;
		this.availableCredit = creditLine;
		this.currentBalance = 0;
		this.minimumBalance = 0;
		this.interestRate = 0;	
		
		Random rand = new Random();
		//Generating the Credit Card Number
		int concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
	}
	/*
	 *This is the Parameter Constructor.
	 *It saves the values from the method call into the instance memebers. 
	 */
	public SU2018LAB5_CreditCardAccount_Amaya(String name,String ssNumber,String phoneNumber,
			String address,String username,String password)
	{
		this.name =name;
		this.cardNumber ="";
		this.ssNumber =ssNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.creditLine =2000;
		this.availableCredit = creditLine;
		this.currentBalance = 0;
		this.minimumBalance = 0;
		this.interestRate = 16.99;
		//Also Generates a Card Number when called
		Random rand = new Random();
		int concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
		concat = rand.nextInt(9000)+1000;
		this.cardNumber += String.valueOf(concat);
	}
	/*
	 * This is the method for performing the first Call
	 */
	public String task1()
	{
		//Generating the desired output using the members' values
		String str="";
		str += "Credit Card is available for you.\n";
		str += String.format("Name:%38s\n",this.name);
		str += String.format("Card number:%31s\n",this.cardNumber);
		str += String.format("Credit Line:%31.1f\n",this.creditLine);
		str += String.format("Available Credit:%26.1f\n",this.availableCredit);
		str += String.format("Current Balance:%27.1f\n",this.currentBalance);
		str += String.format("Interest Rate:%28.2f%%\n",this.interestRate);
		str += String.format("Minimum payment amount Due: %15.1f\n",this.minimumBalance);

		
		return str;		
	}
	/*
	 * This second method makes one transaction.
	 * It also writes the transaction to the Output File.
	 */
	public void task2(String u,String p) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);//Scanner for saving input
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");//date format
        Date dateObj = new Date();//for printing date
        String date = dateFormat.format(dateObj);//date format saved to a String 
		
		//Comparing username and password from user
		int differenceu = u.compareTo(this.username);
		int differencep = p.compareTo(this.password);
		if(differenceu == 0 && differencep == 0)
		{
			//Executes if password and username match
			System.out.println("Please enter description for the transaction");
			String desc = keyboard.nextLine();
			System.out.println("Please enter the type of transaction");
			String type = keyboard.nextLine();
			System.out.println("Please enter the amount for the transaction");
			double amount = keyboard.nextInt();
			keyboard.nextLine();
			//Updating account values and saving results to file.
			if(amount <= this.availableCredit)
			{
				this.currentBalance += amount;
				this.availableCredit -= amount;
				FileWriter append = new FileWriter(file,true);
				String str ="";
				str += String.format("%-20s"+"%-30s"+"%-20s"+"$%-10.2f\n",date,desc,type,amount);
				append.write(str);
				System.out.println("Transaction Complete.\n");
				append.close();
			}
			else//This occurs is amount is greater than balance
				System.out.println("Transaction is denied");		
			
		}
		else //This occurs when username or password dosen't match.
			System.out.println("The username or password does not match\n");
	}
	/*
	 * This is the third task. This method prints the Credit Card Statement
	 * and saves the statement to the file.
	 */
	public void task3() throws IOException
	{
		this.minimumBalance +=25.0;
		//Generating the Statement
		String stri="";
		String title = "CREDIT CARD STATEMENT";
		stri += String.format("%31s.\n",title);
		stri += String.format("Name:%38s\n",this.name);
		stri += String.format("Card number:%31s\n",this.cardNumber);
		stri += String.format("Credit Line:%31.1f\n",this.creditLine);
		stri += String.format("Available Credit:%26.1f\n",this.availableCredit);
		stri += String.format("Current Balance:%27.1f\n",this.currentBalance);
		stri += String.format("Interest Rate:%28.2f%%\n",this.interestRate);
		stri += String.format("Minimum payment amount Due: %15.1f\n",this.minimumBalance);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/30/yyyy");
        Date dateObj = new Date();
        String date = dateFormat.format(dateObj);
        stri += String.format("Payment Due Date:%26s\n",date);//Adding payment due date to the statement
		//Printing the transactions and saving to file.
		System.out.println(stri);
		File statement = new File("statement.txt");
		FileWriter outFile = new FileWriter(statement);
		outFile.write(stri);
		String lines ="--------------------------------------------------------------------------------\n";
		System.out.print(lines);
		outFile = new FileWriter(statement,true);
		outFile.write(lines);
		Scanner append = new Scanner(this.file);
		while(append.hasNext())
		{
			System.out.println(append.nextLine());
			outFile.write(append.nextLine());
		}
		System.out.println(lines);
		outFile.write(lines);
		outFile.close();
		file.delete();
	}
	/*
	 * This is the fourth task. It receives a payment and updates the Credit Account
	 */
	public void task4(double a)
	{
		double interestAmount;
		if(this.currentBalance>0)
			{
			interestAmount = this.currentBalance*this.interestRate;
			this.currentBalance += interestAmount;
			}
		this.availableCredit = this.creditLine - this.currentBalance;
		System.out.println("Task 4 Complete.\n");
	}
	/*
	 * This is the fifth task. This method displays the Available Credit
	 */
	public void task5()
	{
		System.out.println();
		System.out.printf("Current available credit amount: %.2f\n",this.currentBalance);
		System.out.println();
	}
	/*
	 * This is the sisth task. This method displays the interest rate.
	 */
	public void task6()
	{
		System.out.println();
		System.out.printf("Interest rate: %.2f%%\n\n",this.interestRate);
		
	}
	
}
