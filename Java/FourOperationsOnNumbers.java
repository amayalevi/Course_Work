//SU20187LAB2_FourOperationsOnNumbers_Amaya
import javax.swing.JOptionPane;//need this to display message at the end
import java.util.Scanner;//need this to read input from user
public class FourOperationsOnNumbers {
	
public static void main(String[] args)
{
	//declaring 2 int variables
	int num1,num2;
	
	//Creating Scanner to read input
	Scanner keyboard = new Scanner(System.in);
	
	//calculator title
	System.out.println("INTEGER/DECIMAL Calculator\n");
		
	//asking user for the first 2 integers and reading input
	//into the 2 int variables
	System.out.print("Enter a first integer number: ");
	num1=keyboard.nextInt();
	System.out.println("");
	System.out.print("Enter a second integer number: ");
	num2=keyboard.nextInt();
	System.out.println("");
	
	//displaying addition
	System.out.println("ADD 2 INTEGER NUMBERS");
	System.out.println(num1+" + "+num2+" = "+(num1+num2));
	System.out.println("");
	System.out.println("");
	
	//same for MINUS 2 integers
	System.out.print("Enter a first integer number: ");
	num1=keyboard.nextInt();
	System.out.println("");
	System.out.print("Enter a second integer number: ");
	num2=keyboard.nextInt();
	System.out.println("");
	
	System.out.println("MINUS 2 INTEGER NUMBERS");
	System.out.println(num1+" - "+num2+" = "+(num1-num2));
	System.out.println("");
	System.out.println("");
	
	
	//same for MULTIPLY 2 integers
	System.out.print("Enter a first integer number: ");
	num1=keyboard.nextInt();
	System.out.println("");
	System.out.print("Enter a second integer number: ");
	num2=keyboard.nextInt();
	System.out.println("");
	
	System.out.println("MULTIPLY 2 INTEGER NUMBERS");
	System.out.println(num1+" * "+num2+" = "+(num1*num2));
	System.out.println("");
	System.out.println("");
	
	//same for DIVIDE 2 integers
	System.out.print("Enter a first integer number: ");
	num1=keyboard.nextInt();
	System.out.println("");
	System.out.print("Enter a second integer number: ");
	num2=keyboard.nextInt();
	System.out.println("");
	
	System.out.println("DIVIDE 2 INTEGER NUMBERS");
	System.out.println(num1+" / "+num2+" = "+(num1/num2));
	System.out.println("");
	System.out.println("");
	
	//moving along to the decimal portion
	System.out.println("-----------------------------------------------------");
	System.out.println("");
	System.out.println("");
	
	//declaring 2 double variables
	double dec1,dec2;
	
	//asking user for the first 2 decimals and reading input
	//into the 2 double variables
	System.out.print("Enter a first decimal number: ");
	dec1=keyboard.nextDouble();
	System.out.println("");
	System.out.print("Enter a second decimal number: ");
	dec2=keyboard.nextDouble();
	System.out.println("");
	//making the formated String to display one decimal place
	//for the answer
	String display = String.format("%.2f"+" + "+"%.2f"+" = "+"%.1f",dec1,dec2,dec1+dec2);
	
	//displaying addition
	System.out.println("ADD 2 DECIMAL NUMBERS");
	System.out.println(display);
	System.out.println("");
	System.out.println("");
	
	//Same for MINUS 2 decimals
	System.out.print("Enter a first decimal number: ");
	dec1=keyboard.nextDouble();
	System.out.println("");
	System.out.print("Enter a second decimal number: ");
	dec2=keyboard.nextDouble();
	System.out.println("");
	
	display = String.format("%.2f"+" - "+"%.2f"+" = "+"%.1f",dec1,dec2,dec1-dec2);
	
	System.out.println("MINUS 2 DECIMAL NUMBERS");
	System.out.println(display);
	System.out.println("");
	System.out.println("");
	
	//Same for MULTIPLY 2 decimals
	System.out.print("Enter a first decimal number: ");
	dec1=keyboard.nextDouble();
	System.out.println("");
	System.out.print("Enter a second decimal number: ");
	dec2=keyboard.nextDouble();
	System.out.println("");
	
	display = String.format("%.2f"+" * "+"%.2f"+" = "+"%.1f",dec1,dec2,dec1*dec2);
	
	System.out.println("MULTIPLY 2 DECIMAL NUMBERS");
	System.out.println(display);
	System.out.println("");
	System.out.println("");
	
	
	//Same for DIVIDE 2 decimals
	System.out.print("Enter a first decimal number: ");
	dec1=keyboard.nextDouble();
	System.out.println("");
	System.out.print("Enter a second decimal number: ");
	dec2=keyboard.nextDouble();
	System.out.println("");
	
	display = String.format("%.2f"+" / "+"%.2f"+" = "+"%.1f",dec1,dec2,dec1/dec2);
	
	System.out.println("DIVIDE 2 DECIMAL NUMBERS");
	System.out.println(display);
	System.out.println("");
	System.out.println("");
	
	//final Message
	JOptionPane.showMessageDialog(null,"We have finished Math Operations");
	System.exit(0);

	
}
}
