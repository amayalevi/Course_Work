import java.util.Scanner;//needed to receive input from the user
/*
 * This is the driver Class for the Vendor Data Class
 */
public class SP2018LAB4_CalculationVendorSalary_Amaya {
	/*
	 * This is the main method
	 */
	public static void main(String[] args)
	{
		//These are the variables to hold the input from the user
		String name;
		int iD;
		double sales;
		
		//Creating new Scanner to recieve input
		Scanner keyboard = new Scanner(System.in);
		
		//Asking the user for the Vendor name,id, and sales amount		
		System.out.println("Please enter the vendor name: ");
		name = keyboard.nextLine();
		System.out.println("Please enter the vendor ID: ");
		iD = keyboard.nextInt();
		keyboard.nextLine();//removing extra new line 
		System.out.println("Please enter the sales amount: ");
		sales = keyboard.nextDouble();
		keyboard.nextLine();//removing extra new line 
		
		//creating vendor object using parameter Constructor
		SP2018LAB4_Vendor_Amaya vendor = new SP2018LAB4_Vendor_Amaya(name,iD,sales);
		
		//Displaying the vendor information in receipt format
		System.out.println(vendor);
		
	}
	
}
