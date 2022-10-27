import java.io.File;//needed to create files
//Data Class
public class SU2018PROJECT_Student_Amaya {

	
	/*Class SU2018PROJECT_Student_LastName
	
	//data members 2
	/*-Read information of one student that includes: student id, last name, first name, phone then create the object of
	*class Student to have all information that need for one student.
	*/
	private int iD;
	private String last;
	private String first;
	private int phone;
	//grade arrays
	private float[] quizzes= {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}; ;
	private float[] homework = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
	private float[] labs = {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f};
	private float[] tests = {0.0f,0.0f,0.0f};
	private float proj;
	private float disc;
	private float teamwork;
	private float extra;
	//calculating members
	private float sum;
	private float percentage;
	private char letter;
	//Data class only members
	private float scores;
	private File temp;
	private int counter=0;
	private int Acounter=0;
	private int Bcounter=0;
	private int Ccounter=0;
	private int Dcounter=0;
	private int Fcounter=0;
	private int totalStudents=0;
	/*Default
	*/
	public SU2018PROJECT_Student_Amaya()
	{
	
	}
	/* Constructor pass a String as parameter, split information and assign to data members*/
	public SU2018PROJECT_Student_Amaya(int iD, String last, String first, int phone) {
		super();
		this.iD = iD;
		this.last = last;
		this.first = first;
		this.phone = phone;
	}
	/*Used to store the File*/
	public void setFile(File f)
	{
		this.temp = f;
		
	}
	/*Used to return current File*/
	public File getFile()
	{
		 return this.temp;
		
	}
	/*
	Method to calculate the total of scores
	*/
	public float totalScores()
	{
		for(float f: this.quizzes)
			{
			this.scores +=f;
			}
		for(float f: this.homework)
			{
			this.scores +=f;
			}
		for(float f: this.labs)
			{
			this.scores +=f;
			}
		for(float f: this.tests)
			{
			this.scores +=f;
			}
		
		this.scores +=proj;
		this.scores +=disc;
		this.scores +=teamwork;
		this.scores +=extra;
		this.sum = this.scores;
		
		return scores;
		
	}
	
	/*Method to calculate the percentage, sum of score*/
	public void percent()
	{
		float sum = this.scores;
		this.percentage = (sum/800)*100;
	}
	/*Method to determine the letter grade*/
	public void letterGrade()
	{
		if(this.percentage>90)
		{
			this.letter = 'A';
			this.Acounter++;
			this.totalStudents++;
			}
		else if(this.percentage>80)
			{
			this.letter = 'B';
			this.Bcounter++;
			this.totalStudents++;
			}
		else if(this.percentage>70)
			{
			this.letter = 'C';
			this.Ccounter++;
			this.totalStudents++;
			}
		else if(this.percentage>60)
			{
			this.letter = 'D';
			this.Dcounter++;
			this.totalStudents++;
			}
		else
			{
			this.letter = 'F';
			this.Fcounter++;
			this.totalStudents++;
			}
	}
	
	/*Method to split one line read from file into pieces of information and scores of student*/
	public void splitter(String in)
	{
		String[] process;
		process = in.split(",|-");
		this.iD = Integer.parseInt(process[0]);
		this.last = process[1];
		this.first = process[2];
		this.phone = Integer.parseInt(process[3]);
		
		for(int counter = 4;counter<18;counter++)
			{
			this.quizzes[counter-4] = Float.parseFloat(process[counter]) ;
			}
		for(int counter = 18;counter<28;counter++)
		{
			this.homework[counter-18] = Float.parseFloat(process[counter]) ;
		}
		for(int counter = 28;counter<35;counter++)
		{
			this.labs[counter-28] = Float.parseFloat(process[counter]) ;
		}
		for(int counter = 35;counter<38;counter++)
		{
			this.tests[counter-35] = Float.parseFloat(process[counter]) ;
		}
		
		this.proj = Float.parseFloat(process[38]);
		this.disc = Float.parseFloat(process[39]);
		this.teamwork = Float.parseFloat(process[40]);
		this.extra = Float.parseFloat(process[41]);
		
		this.sum = Float.parseFloat(process[42]);
		this.percentage = Float.parseFloat(process[43]);
		this.letter = process[44].charAt(0);
		
	}
	/* This method writes the line to file the first time.*/
	public String writeInfo()
	{
		
		return ""+iD+","+last+","+first+","+phone+"-0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,"
				+ "0.0,0.0,0.0,0.0,0.0,0.0-0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,"
				+ "0.0,0.0-0.0,0.0,0.0,0.0,0.0,0.0,0.0-0.0,0.0,0.0-0.0-0.0-0.0-0.0-0.0-0.0-X";
	}
	//This method writes to the File with more information of the Student
	public String writeInfo(float[] quizzes, float[] homework, float[] labs, float[] tests, float proj, float disc,float teamwork,float extra)
	{
		int counter;
		for(counter =0;counter<quizzes.length;counter++)
			{
			this.quizzes[counter] = quizzes[counter];
			}
		counter =0;
		for(float f:homework)
		{
		this.homework[counter] = f;
		counter++;
		}
		counter =0;
		for(float f:labs)
		{
		this.labs[counter] = f;
		counter++;
		}
		counter =0;
		for(float f:tests)
		{
		this.tests[counter] = f;
		counter++;
		}
		this.proj = proj;
		this.disc = disc;
		this.teamwork = teamwork;
		this.extra = extra;
		
		String str = "";
		
		str += iD+","+last+","+first+","+phone+"-";
		
		for(float q:quizzes)
		{
			str += q + ",";
		}
		str = str.substring(0,str.length()-1);
		str+= "-";
		
		for(float h:homework)
		{
			str += h + ",";
		}
		str = str.substring(0,str.length()-1);
		str+= "-";
		
		for(float l:labs)
		{
			str += l + ",";
		}
		str = str.substring(0,str.length()-1);
		str+= "-";
		
		for(float t:tests)
		{
			str += t + ",";
		}
		str = str.substring(0,str.length()-1);
		str+= "-";
		//float proj, float disc,float teamwork,float extra
		str += proj+"-";
		str += disc+"-";
		str += teamwork+"-";
		str += extra+"-";
		
		//-total score-percentage-letter grade
		str += 0.0+"-";
		str += 0.0+"-";
		str += "X";
		return str;
	}
	/* This method writes the line with all the information on the Student
	 * including calculations and letter grade
	 */
	public String completeWrite()
	{
		String complete = "";
		complete += +iD+","+last+","+first+","+phone+"-";
		for(float f:this.quizzes)
		{
			complete += f+",";
		}
		complete = complete.substring(0,complete.length()-1);
		complete += "-";
		for(float f:this.homework)
		{
			complete += f+",";
		}
		complete = complete.substring(0,complete.length()-1);
		complete += "-";
		for(float f:this.labs)
		{
			complete += f+",";
		}
		complete = complete.substring(0,complete.length()-1);
		complete += "-";
		for(float f:this.tests)
		{
			complete += f+",";
		}
		complete = complete.substring(0,complete.length()-1);
		complete += "-";
		complete += this.proj;
		complete += "-";
		complete += this.disc;
		complete += "-";
		complete += this.teamwork;
		complete += "-";
		complete += this.extra;
		complete += "-";
		complete += this.sum;
		complete += "-";
		complete += this.percentage;
		complete += "-";
		complete += this.letter;
		
				
		return complete;
		
	}
	/*This in an internal Data Class only method*/
	public void counter()
	{
	this.counter++;			
	}
	/*
	 * This method gives the final Output for Task 3.
	 */
	public String toString()
	{
		String print="GRADING CLASS\n";
		print += "Total students:        "+this.counter+"\n";	
		print += "Grade A:               "+this.Acounter+"            "+(this.Acounter/this.totalStudents)*100+"%\n";	
		print += "Grade B:               "+this.Bcounter+"            "+(this.Bcounter/this.totalStudents)*100+"%\n";	
		print += "Grade C:               "+this.Ccounter+"            "+(this.Ccounter/this.totalStudents)*100+"%\n";	
		print += "Grade D:               "+this.Dcounter+"            "+(this.Dcounter/this.totalStudents)*100+"%\n";	
		print += "Grade F:               "+this.Fcounter+"            "+(this.Fcounter/this.totalStudents)*100+"%\n";	
		
				
		/*
			
			Grade A: 5 25%
			Grade B: 10 50%
			Grade C: 4 20%
			Grade D: 0 0%
			Grade F: 1 5%
		 */
		return print;
	}
	
}
