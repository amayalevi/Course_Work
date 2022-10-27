#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	//Reading File
	ifstream fileInput;
	cout << "Reading File..." << endl;
	fileInput.open("Person.txt");

	//Min and Max hour variables
	int MinHours;
	int MaxHours;

	fileInput >> MinHours;
	fileInput >> MaxHours;
	//min will always be less than max
	// < Min = Docked Pay, > Max = Overtime Pay

	//week 1
	int PlaceHolder;
	int HoursWorked;
	int DaysWorked;
	fileInput >> DaysWorked;
	
	switch (DaysWorked)
	{
		case 0:
			if (MinHours == 0)
				cout << "NORMAL" << endl;
			else
			{	cout << "DOCK " << MinHours << endl;
			}
			break;

		case 1:
			fileInput >> HoursWorked;
			if (HoursWorked < MinHours)
				cout << "DOCK " << MinHours - HoursWorked << endl;
			else if (HoursWorked = MinHours || HoursWorked <= MaxHours)
			{
				cout << "NORMAL " << endl;
			}
			else
			{
				cout << "OVERTIME " << HoursWorked - MaxHours << endl;
			}
			break;

		case 2:
			fileInput >> HoursWorked;
			PlaceHolder = HoursWorked;
			fileInput >> HoursWorked;
			HoursWorked += PlaceHolder;

			if (HoursWorked < MinHours)
				cout << "DOCK " << MinHours - HoursWorked << endl;
			else if (HoursWorked = MinHours || HoursWorked <= MaxHours)
			{
				cout << "NORMAL " << endl;
			}
			else
			{
				cout << "OVERTIME " << HoursWorked - MaxHours << endl;
			}
			break;

		case 3:
			fileInput >> HoursWorked;
			PlaceHolder = HoursWorked;
			fileInput >> HoursWorked;
			PlaceHolder += HoursWorked;
			fileInput >> HoursWorked;
			HoursWorked += PlaceHolder;

			if (HoursWorked < MinHours)
				cout << "DOCK " << MinHours - HoursWorked << endl;
			else if (HoursWorked = MinHours || HoursWorked <= MaxHours)
			{
				cout << "NORMAL " << endl;
			}
			else
			{
				cout << "OVERTIME " << HoursWorked - MaxHours << endl;
			}
			break;

		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
	}





	//week 2

	//week 3

	//week 4
	
	//week 5, you must prorate according to how many days are indicated.

	system("Pause");
	return 0;
}