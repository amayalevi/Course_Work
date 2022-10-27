#include<iostream>

using namespace std;

int main()
{
	////1.//Program 2 additional loops that are equivalent to the following:


		//1. while loop
		cout <<"1."<< "While Loop: ";
		int i = 6;
		while (i < 10)
		{
			cout << i << " ";
			i++;
		}
	
		cout << endl;
		//1. do-while loop
		cout << "Do-while loop: ";
		i = 6;
		do{
			cout << i << " ";
			i++;
				
		} while (i<10);

		cout << endl << endl;
		//2.	//Program 1 additional loop equivalent the this the following
	
		cout << "2."<< "Do-while Loop: ";
		int w = 34;
		do {
			if (w > 5)
				w -= 4;
			cout << "T-" << w << ", ";


		} while (--w>0);
		cout << "Lift-off" << endl;

		//3.	//program 1 loop equivalent to the following:

		cout << "3." << "For Loop: ";
		for (int loop = 10; loop > 5;)
		{
			cout << --loop << " ";
		}

		cout << endl;

		//4.	//program 1 loop equivalent to the following

		cout << endl << "4." << "While Loop: ";
		int j = 17;
		i = 0;
		while (i<j) 
		{
			cout << i << " ";
			if (j-- % ++i == 0)
				i += j / 2;
		}
		cout << endl;

		//Part 2: Output the following using loops
		//1.10pts Multiplication table










	system("Pause");

	return 0;
}