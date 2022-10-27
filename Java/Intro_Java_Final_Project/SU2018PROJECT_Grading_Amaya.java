import java.util.Scanner; //This class is needed for receiving input from user
import java.io.File; //This class is needed to use files.
import java.io.PrintWriter; //This class is needed to write to files.
import java.io.FileNotFoundException;//This exception class is needed to use PrintWriter class.
/*
 * This is the Driver Class for the Student Class
 */
public class SU2018PROJECT_Grading_Amaya {
	/*
	 * This is the main method
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in); //Scanner to read input form user
		System.out.println("Please enter the file name to save the grades: ");
		 File file = new File(keyboard.nextLine()); //Creating new File object with input from user
		//Loop Control Variable
		int choice;
		//Start Loop of main method
		do{
		/*Provides the menu to allow users to select the following tasks and
		only terminate the program when users select exit
		Each task has to be handled in a user-defined function*/
		System.out.println("GRADING STUDENTS");
		System.out.println("1. Enter Information of Students in class");
		System.out.println("2. Enter the scores of Students");
		System.out.println("3. Grading");
		System.out.println("0. Exit");
		
		choice = keyboard.nextInt();
		keyboard.nextLine();
		//Creating Student Class Object 
		SU2018PROJECT_Student_Amaya info = new SU2018PROJECT_Student_Amaya();
		//Switch statement for choosing specific task.
		switch(choice)
		{
		case 1:
			task1(file,info);
			break;
		case 2:
			task2(file,info);
			break;	
		case 3:
			task3(file,info);
			break;
		case 0:
			break;
			//Correct input Please 
		default:
			System.out.println("Invalid Entry. Please enter 1-3 or 0.");
			break;
		}
		}while(choice!=0);//0 Exits main method
		
		System.out.println("Program Terminated"); // End Program
	}		
	/* TASK 1 Method:
	 * This method receives all the information 
	 * for the student and saves is to the Student Object.	
	 */
	public static void task1(File file,SU2018PROJECT_Student_Amaya info) throws FileNotFoundException
		{	
			
			PrintWriter outFile = new PrintWriter(file);//Output file for saving data
			Scanner keyboard = new Scanner(System.in);
			
			boolean continu =true;//Used to continue writing info to file
			while(continu)
			{
			//asking for information and saving to local variables
			System.out.println("Please enter the student's ID: ");
			int iD = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Please enter the student's Last name: ");
			String last = keyboard.nextLine();
			System.out.println("Please enter the student's First name: ");
			String first= keyboard.nextLine();
			System.out.println("Please enter the student's Phone number: ");
			int phone = keyboard.nextInt();
			keyboard.nextLine();
			//Sending info to Student Object through Second Constructor
			info = new SU2018PROJECT_Student_Amaya( iD,  last,  first,  phone);
			//Writing Student data to Output File
			outFile.println(info.writeInfo());
			System.out.println("Add another student?(Y/N)");
			char choice = keyboard.nextLine().charAt(0);
			//If statement to continue writing or to Exit Task 1
			if(choice != 'Y' || choice !='y')
				continu = false;
				
			}
			
			outFile.close();
		}
	
		
		/*TASK2 Method:
		*Read the line from file, create the object of student 
		*read scores and place to object student correctly 
		*Create the line with correct format by calling the 
		*method of class Student – write to output file 
		*Delete, rename file 1
		*/
		public static void task2(File file,SU2018PROJECT_Student_Amaya info ) throws FileNotFoundException
		{
			Scanner keyboard = new Scanner(System.in);
			Scanner inFile = new Scanner(file);//Creating input file
			File temp = new File("tempFile.txt");
			PrintWriter outFile = new PrintWriter (temp);//Creating output file
			//main loop for inputing all the grades
			do{
			String s = inFile.nextLine();	
			String[] buffer = s.split(",|-");
			System.out.println("Please enter scores for student with ID# "+ buffer[0]);
			System.out.println("Enter the Quiz grades seperated by spaces: ");
			String[] inputQuiz = keyboard.nextLine().split(" ");
			float[] quizzes = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
			for(int i = 0;i<inputQuiz.length;i++)
			{
				quizzes[i] = Float.parseFloat(inputQuiz[i]);
			}
			
			System.out.println("Enter the Homework grades seperated by spaces: ");
			String[] inputHomework = keyboard.nextLine().split(" ");
			float[] homework = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
			for(int i = 0;i<inputHomework.length;i++)
			{
				homework[i] = Float.parseFloat(inputHomework[i]);
			}
			
			System.out.println("Enter the Lab grades seperated by spaces: ");
			String[] inputLabs = keyboard.nextLine().split(" ");
			float[] labs = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
			for(int i = 0;i<inputLabs.length;i++)
			{
				labs[i] = Float.parseFloat(inputLabs[i]);
			}
			
			System.out.println("Enter the Test grades seperated by spaces: ");
			String[] inputTests = keyboard.nextLine().split(" ");
			float[] tests = {0.0f,0.0f,0.0f};
			for(int i = 0;i<inputTests.length;i++)
			{
				tests[i] = Float.parseFloat(inputTests[i]);
			}
			//Non Array grades
			System.out.println("Enter the Project grade: ");
			float proj = keyboard.nextFloat();
			
			System.out.println("Enter the Discussion grade: ");
			float disc = keyboard.nextFloat();
			
			System.out.println("Enter the Teamwork grade: ");
			float team = keyboard.nextFloat();
			
			System.out.println("Enter the Extra Credit grade: ");
			float extra = keyboard.nextFloat();
			//Writing new info to output file
			String write = info.writeInfo(quizzes, homework, labs, tests, proj, disc, team, extra);
			outFile.println(write);
			}while(inFile.hasNext());//Checking if input file has more info
			
			
			/*
			* close input file
			* close output file 
			* delete input file
			* rename input file
			*/
			inFile.close();
			outFile.close();
			file.delete();
			temp.renameTo(file);
			info.setFile(temp);
		}
		/*TASK 3 Method:
		 * This method Does all the calculations for the student's grades, 
		 * Total, Percentage, and Letter Grade.
		 * The Method write the complete information on students to File.
		 * The Method also Displays the Final Statistics on the students
		 */
		public static void task3(File file,SU2018PROJECT_Student_Amaya info) throws FileNotFoundException
		{
			Scanner inFile = new Scanner(file);
			
			File temp = new File("temp.txt");
			PrintWriter outFile = new PrintWriter(temp);
			
			do
				{info.splitter(inFile.nextLine());
			info.totalScores();
			info.percent();
			info.letterGrade();
			outFile.println(info.completeWrite());
			info.counter();
				}
			while(inFile.hasNext());
			
			inFile.close();
			outFile.close();
			file.delete();// input file delete
			temp.renameTo(file); //rename tempFile to input file name
			 
			//Display the result of class on the screen in the following format;
			
			System.out.println(info);
				 
		}
		
}
