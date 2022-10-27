//SU2018LAB1_AverageTestScores_Amaya
import java.util.Scanner;//need this to use Scanner
public class Simple_input_output_print_string {
	
	
	
	public static void main(String[] args)
	{
		String aString,bString; //instantiating String variables
		double aDouble,bDouble,cDouble; //instantiating double variables
		
		Scanner keyboard = new Scanner(System.in); //Need Scanner to read input from user
				
		System.out.println("What is your last name: "); //asking user for first name
		aString = keyboard.nextLine();
		System.out.println("What is your first name: "); //asking user for second name
		bString = keyboard.nextLine();
		System.out.println("What is the first test score: "); //asking user for 1st test
		aDouble = keyboard.nextDouble();
		System.out.println("What is the second test score: "); //asking user for 2nd test
		bDouble = keyboard.nextDouble();
		System.out.println("What is the third test score: "); //asking user for 3rd test
		cDouble = keyboard.nextDouble();
		
		//Output:
		System.out.println("-------------------------------------------");
		System.out.println("Your name: "+aString +" "+bString);
		System.out.println("Your 3 test scores: "+aDouble+" "+bDouble+" "+cDouble);
		System.out.println("Your average: "+((aDouble+bDouble+cDouble)/3.0));
		System.out.println("-------------------------------------------");
				
		
	}	

}
