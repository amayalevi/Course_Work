//Demo_ArrayList_Amaya
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Demo_ArrayList_Amaya {

		public static void main(String[] args)
		{
			//creating ArrayList structure
			ArrayList data = new ArrayList();
			
			//inserting 52 numbers(0-51) to ArrayList
			for(int i =0;i<52;i++)
			{
				data.add(i);
			}
			
			//Prompt User to insert 3 accounts
			for(int i=0 ; i<3 ; i++)
			{
				Account_Amaya account = null;
				Scanner keyboard = new Scanner(System.in);
				
				System.out.println("Creating account #"+(i+1));
				System.out.println("Please select an account type: \"1\" for Checking OR \"2\" for Saving");
				int choice = keyboard.nextInt();
				keyboard.nextLine();
				
				//Asking for information
				System.out.println("Please enter your first name:");
				String first = keyboard.nextLine();
				System.out.println("Please enter your last name:");
				String last = keyboard.nextLine();
				System.out.println("Please enter your address:");
				String address = keyboard.nextLine();
				//This switch statement decides between initializing a Checking or Saving Account.
				switch(choice)
				{
				//This case initializes a Checking Account
				case 1:					
					System.out.println("Enter the account's Service Fee:");
					double fee = keyboard.nextDouble();
					keyboard.nextLine();
					account = new CheckingAccount_Amaya(first,last,address,fee);
					break;
				//This case initializes a Saving Account	
				case 2:	
					System.out.println("Enter the account's Interest Rate:");
					double rate = keyboard.nextDouble();
					keyboard.nextLine();			
					account = new SavingAccount_Amaya(first,last,address,rate);
					break;
				//default is for any invalid choices.	
				default:
					System.out.println("Invalid Choice.");
					break;
				}
				//Setting down payment in account
				System.out.println("Enter the down payment for the account:");
				double down = keyboard.nextDouble();
				keyboard.nextLine();	
				account.openAccount(down);
				
				//Adding account to ArrayList 
				if(data.add(account))
					javax.swing.JOptionPane.showMessageDialog(null,"Insert Account - *Success*\n");
				else
					javax.swing.JOptionPane.showMessageDialog(null,"Insert Account - *Failed*\n");
				
		}//end of for loop
			
		//inserting 52-59 to ArrayList
		for(int i =52;i<100;i++)
		{
			data.add(i);
		}
		
		//Displaying size of ArrayList
		System.out.println("Size of the ArrayList: "+data.size()+"\n");
		
		//Delete object at index #52
		System.out.println("Deleting object at index #52...\n");
		data.remove(52);
		
		//Displaying size of ArrayList
		System.out.println("Size of the ArrayList: "+data.size()+"\n");
		
		//fetching nodes 25
		int temp = (int) data.get(25); 
		//Displaying info of node 25
		System.out.println(data.get(25).toString()+"\n");
		//fetching nodes 52
		Account_Amaya temp1 = (Account_Amaya)data.get(52);
		System.out.println(data.get(52).toString());
		
		//Verifying ArrayList encapsulation
		Random rand = new Random();
		int randnumber = rand.nextInt(10)+1;
		//modifying temp1
		if(temp1.checkOrSave())
			//if true modify serviceFee		
			temp1.serviceFee += randnumber;
		else
			//if false modify interest rate
			temp1.interestRate += randnumber;
		//fetching temp2 again
		Account_Amaya temp2 = (Account_Amaya)data.get(52);
		if(temp1.checkOrSave())
		{
			if(temp1.serviceFee == temp2.serviceFee)
				javax.swing.JOptionPane.showMessageDialog(null,"Java ArrayList is not encapsulated");
			else
				javax.swing.JOptionPane.showMessageDialog(null,"Java ArrayList is encapsulated");
		}
		else
		{
			if(temp1.interestRate == temp2.interestRate)
				javax.swing.JOptionPane.showMessageDialog(null,"Java ArrayList is not encapsulated");
			else
				javax.swing.JOptionPane.showMessageDialog(null,"Java ArrayList is encapsulated");
		}
		
		System.exit(0);	
		}//end of main method
}// end of Demo Class
