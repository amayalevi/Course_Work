#include<iostream>
using namespace std;

//1)	Summation: Write a function Summation which accept two integers as an argument and return its sum.
//Call this function from main() and print the results in main().
int Summation(int a, int b)
{
	return a + b;
}
//2)	Raising to a Power : Raising a number to a power p is the same as multiplying n by itself p times.
//Write a function called RaisePower that takes two arguments, a double value for n and an int value for p,
//and return the result as double value.You should calculate the value yourself(not use cmath::pow()).
//Use default argument of 2 for p, so that if this argument is omitted the number will be squared.
//Write the main function that gets value from the user to test power function.
double raisedPower(double n, int p=2)
{
	double val = n;
	if (p == 0)
	{
		return 1;
	}
	while (p > 1)
	{
		val *= n;
		p--;
	}
	return val;
}
//3)	IsEven: Write a function isEven that accepts an integer and returns a bool indicating if the integer is even.
bool isEven(int e)
{
	return (e%2==0);
}
//4)	Using Reference Variables : Write a function called ZeroSmall that has three integer arguments being passed by reference
//and sets the smallest of the three numbers to 0.
void ZeroSmall(int& x, int& y, int& z)
{
	if (x < y && x < z)
	{
		x = 0;
	}
	else if (y < x&&y < z)
	{
		y = 0;
	}
	else 
	{
		z = 0;
	}
}
//5)	Practice is over : Write a function AddLargest2EvenNumbers, that takes 3 numbers.
//Check if the numbers are odd using the isEven function and if so adds 1 to the number.
//Now take the 3 numbers and add the two largest of the numbers by using the ZeroSmall and the Summation
//(you should not need to modify the summation function for this problem).Return the result to main.
int AddLargest2EvenNumbers(int x, int y, int z)
{
	if (isEven(x)) {}
	else
		x += 1;
	if (isEven(y)) {}
	else 
		y += 1;
	if (isEven(z)) {}
	else
	{
		z += 1;
	}
	ZeroSmall(x, y, z);
	int w = 0;
	if (x == 0)
		w = Summation(y, z);
	else if (y == 0)
		w = Summation(x, z);
	else 
		w = Summation(x, y);
	
	return w;
}
//6)
int LargestDivisor(int a)
{
	int divisor = 1;

	for (int r = 1; r <= a; r++)
	{
		if (a == 1)
		{
			divisor = 1;
			break;
		}
		if (a%r == 0)
		divisor = r;
		
	}
	return divisor;
}
//7)
int PowerToTheDivisor(int p)
{
	int LargestDiv =LargestDivisor(p);

	return raisedPower(p, LargestDiv);

}
//8)
int SumOfDigits(int s)
{
	int Sum=0;
	int NumberOfDigits = 0;
	
	for (int t = s; t != 0;NumberOfDigits++)
	{
		
		t%10



	}
	if (s < 10)
	{


	}

	while ()
		


	return Sum;
}
//9)


int main()
{
	
	cout << "1): " << Summation(3, 3) << endl;

	cout << "2) Please enter Base(floating point) and Power(Integer) seperated by a space: " << endl;
	double n;
	int p;
	cin >> n;
	cin >> p;
	cout << "2): " << raisedPower(n,p) << endl;

	cout << "5): " << AddLargest2EvenNumbers(5,4,3) << endl;

	system("Pause");
	return 0;
}


