#include<iostream>
using namespace std;

//1)
int sumArray(int x[], int length)
{
	int sum = 0;
	for (int i = 0; i < length; i++)
	{
		sum += x[i];
	}
	return sum;
}
//2)
int convertToDecimal(int x[], int length)
{
	int result = 0;
	for (int i = 0; i < length; i++)
	{
		
		result += x[i] * (pow(10, length - 1 - i));
	}
	return result;
}
//3)
void printAccending(int x[], int length)
{
	cout << x[0]<<',';
	for (int i = 1; i < length; i++)
	{
		if (x[i] < x[i - 1])
		{
			cout << endl << x[i] << ',';
		}
		else
		{
			cout << x[i];
		}
	}

}
//4)
void reverseArrayEven(int x[], int length)
{

	for (int i = 0; i <= (length / 2); i++)
	{
		if (x[i] % 2 == 0 && x[length - 1 - i] % 2 == 0)
		{
			//don't switch
			continue;
		}
		if (x[i] % 2 == 0 && x[length - 1 - i] % 2 == 1)
		{
			//switch
			int temp = x[i];
			x[i] = x[length - 1 - i];
			x[length - 1 - i] = temp;
			continue;
		}
		if (x[i] % 2 == 1 && x[length - 1 - i] % 2 == 0)
		{
			//switch
			int temp = x[i];
			x[i] = x[length - 1 - i];
			x[length - 1 - i] = temp;
			continue;
		}
		if (x[i] % 2 == 1 && x[length - 1 - i] % 2 == 1)
		{
			//don't switch
			continue;
		}
	}
}
//5)
void TwoDimSearch(int x[][])
{




}
int main()
{
	int x[] = { 4,3,4,2,5,3,5,8,9,1};
	
	system("Pause");
	return 0;
}