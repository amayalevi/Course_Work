//SU20187LAB2_AdultBMI_Amaya
import java.util.Scanner;//need this to read input

public class Simple_formatting_floats {

	public static void main(String[] args)
	{
		//declaring variables
		String name;
		double weight,height;
		
		//Scanner to read input
		Scanner keyboard = new Scanner(System.in);
		
		//Asking user for info and storing input in variables
		System.out.print("Enter your name: ");
		name =keyboard.nextLine();
		System.out.print("Enter your weight in pounds: ");
		weight =keyboard.nextDouble();
		System.out.print("Enter your height in inches: ");
		height =keyboard.nextDouble();
		System.out.println("");
		System.out.println("");
		
		//displaying the results:
		System.out.println("BMI CALCULATION - "+name);
		System.out.println("BMI Healthy Rate: 18.5-24.9");
		System.out.println("---------------------------");
		//formatted Strings to align results
		System.out.print("Your name: ");
		String display = String.format("%16s",name);
		System.out.print(display);
		System.out.println("");
		
		System.out.print("Your weight:");
		display = String.format("%15.2f",weight);
		System.out.print(display);
		System.out.println("");
		
		System.out.print("Your height:");
		display = String.format("%15.2f",height);
		System.out.print(display);
		System.out.println("");
		
		System.out.print("Your BMI:");
		//used BMI formula for output
		display = String.format("%18.2f",(weight*703)/(height*height));
		System.out.print(display);
		System.out.println("");
	}
}
