#include <iostream>

using namespace std;

int main()
{
	//Each sequence should be programed with only 1 loop and 1 cout statement. 
	//Hint: a selection statement may be needed for the last 2 problems.
	int start;
	//	Series 1:
	//	15, 14, 13, 12, 11, ...
	cout << "Series 1: ";
	for (start = 15; start > 9; start--)
		cout <<  start << " ";

	cout << '\n' << '\n';

	//	Series 2 :
	//	1, 2, 5, 14, 41, ...
	cout << "Series 2: ";
	start = 1;
	int SeqAdd = 1;

	while (start <123)
	{
		cout << start << " ";
		start += SeqAdd;		
		SeqAdd *= 3;
	}

	cout << '\n' << '\n';

	//	Series 3 :
	//	2, 3, 5, 8, 12, 17, ...
	cout << "Series 3: ";
	start = 2;
	SeqAdd = 1;

	while (start <24)
	{
		cout << start << " ";
		start += SeqAdd++;
	}

	cout << '\n' << '\n';


	//	Series 4 :
	//	1, 2, 5, 26, 677, ...
	cout << "Series 4: ";
	start = 1;

	for (int i = 1; i < 7; i++)
	{
		cout << start << " ";
		start = (start * start) + 1;
	}
	cout << '\n' << '\n';

	//	Series 5 :
	//	10, 5, 1, -2, -4, -5, -5, -4, -2, ...
	cout << "Series 5: ";
	start = 10;
	SeqAdd = 5;

	for (int i = 0; i < 10; i++)
	{
		cout << start << " ";
		start -= SeqAdd--;
	}
	cout << '\n' << '\n';

	//	Series 6 :
	//	1, 8, 27, 64, 125, 216, ...

	cout << "Series 6: ";
	
	for (int i = 1; i <= 7; i++)
	{
		start = (i*i*i);
		cout << start << " ";
		
	}
	cout << '\n' << '\n';

	//	Series 7 :
	//	0, 1, 3, 7, 15, 31, 63, ...
	cout << "Series 7: ";
	start = 0;
	SeqAdd = 1;

	for (int i = 1; i <= 8; i++)
	{
		
		cout << start << " ";
		start += SeqAdd;
		SeqAdd *= 2;
	}
	cout << '\n' << '\n';

	//	Series 8 :
	//	0, 1, 4, 13, 40, 121, ...
	cout << "Series 8: ";
	start = 0;
	SeqAdd = 1;
	for (int i = 1; i <= 7; i++)
	{

		cout << start << " ";
		start += SeqAdd;
		SeqAdd *= 3;
	}
	cout << '\n' << '\n';
	
	//	series 9 :
	//	0, 1, 3, 6, 10, 10, 11, 13, 16, 16, 17, 19, 19, ...

	//	series 10 :
	//	7, 9, 14, 20, 27, 33, 42, 52, 63, 73, 86, ...

	//	Bonus Series :
	//	0, 1, 4, 12, 32, 80, 192, ...

	system("Pause");
	return 0;
}