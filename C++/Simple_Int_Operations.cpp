#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main()
{
	/*
	//Problem 0:
	cout << "Problem 0 :" << endl;

	//1. 	Take any random number the user enters(cin >> varname)
	cout << "Enter a number." << endl;
	int number;
	cin >> number;

	//2. 	Multiply the number by 2
	number *= 2;
	cout << endl<<"The number * 2 = " << number << endl;

	//3. 	Add 10 to the number
	number += 10;
	cout << "The number + 10 = " << number << endl;

	//4. 	Divide the number by 2
	number /= 2;
	cout << "The number / 2 = " << number << endl;

	//5. 	Subtract 5 from the number
	number -= 5;
	cout << "The number - 5 = " << number << endl;

	//6. 	The result should be the original number
	cout << "The number should be the original number: " << number << endl;

	

	//Problem 1:
	cout <<endl<< "Problem 1 :" << endl;

	//1.	Take any random number the user enters
	cout << "Enter a number." << endl;
	int number2;
	cin >> number2;

	//2.	Add 3 to the number
	number2 += 3;
	cout <<endl<<  "The number + 3 = " << number2 << endl;

	//3.	Multiply the number by 2
	number2 *= 2;
	cout <<  "The number * 2 = " << number2 << endl;

	//4.	Subtract 6 from the number
	number2 -= 6;
	cout <<   "The number - 6 = " << number2 << endl;

	//5.	Divide by 2
	number2 /= 2;
	cout << "The number / 2 = " << number2 << endl;

	//6.	The result should be the original number
	cout << "The number should be the original number: " << number2 << endl;

	

	//Problem 2:
	cout << endl << "Problem 2 :" << endl;

	//1.	Enter a random number
	cout << "Enter a number." << endl;
	int number3;
	cin >> number3;
	int number3_original = number3;
	
	//2.	Multiply the number by 3
	number3 *= 3;
	cout << "The number * 3 = " << number3 << endl;	
	
	//3.	Add 45 to the number
	number3 += 45;
	cout << "The number + 45 = " << number3 << endl;
	
	//4.	Multiply the number by 2
	number3 *= 2;
	cout << "The number * 2 = " << number3 << endl;
	
	//5.	Divide the number by 6
	number3 /= 6;
	cout << "The number / 6 = " << number3 << endl;
	
	//6.	Subtract the original number
	number3 -= number3_original;
	cout << "The number - the original number = " << number3 << endl;
	
	//7.	The result should be 15
	cout << "The resulting number should be 15." << endl;

	

	//Problem 3:
	cout << endl << "Problem 3 :" << endl;
	

	//1.	Take any 2 digit number from 31 to 99. (You do not have to check the numbers just assume the user will enter a valid number so long as you tell them to).
	cout << "Enter any 2 digit number from 31 to 99 :" << endl;
	int number4;
	cin >> number4;

	//2.	Store an extra copy of this number for later
	int number4_Copy = number4;

	//3.    Add 82 to the number.
	number4 += 82;
	cout << "The number + 82 = " << number4 << endl;

	//4. 	Remove the hundreds place from your number and add 1 to the remaining two digits.
	number4 %= 100 ;
	number4 += 1;
	cout << "The number without the hundreds place and + 1: " << number4 << endl;

	//5.	Subtract this from your original number(stored in step 2).
	number4 -= number4_Copy;
	cout << "The number - the original number: " << number4 << endl;
	
	//6. 	Output the result obtained
	cout << "Final Result: " << number4 << endl;

	

	//Problem 4:
	//#1: Have the person write down any three digits number with decreasing digits(432 or 875).
	cout << endl << "Problem 4 :" << endl;

	//#2: Reverse the number you wrote in #1.
	number2 = (number2 / 100)+((number2%100)/10)+((number2%10)*100);
	
	cout << "The reversed number from Problem 1: " << number2 << endl;

	//#3: Subtract the number obtained in #2 from the number you wrote in #1

	//#4: Reverse the number obtained in #3

	//#5: Add the numbers found in #3 and #4

	//What is the answer ?

	


	//Problem 5:
	cout << endl << "Problem 5 :" << endl;
	//1. Select two, single digit, numbers, the first being in the range 2 to 6 and the second being in the range 1 to 9.
	int number5, number6;
	cout  << "Please enter two, single digit, numbers, the first being in the range 2 to 6 and the second being in the range 1 to 9 :" << endl;
	cin >> number5;
	cin >> number6;
	
	//3. Multiply the first number by five.
	number5 *= 5;
	cout << "The first number * 5 : " << number5 << endl;
	
	//4. Add three to that number.
	number5 += 3;
	cout << "The number + 3 : " << number5 << endl;
	
	//5. Double the number.
	number5 *= 2;
	cout << "The number doubled : " << number5 << endl;

	//6. Add the second number to your previous step.
	number5 += number6;
	cout << "The second number added to the first number : " << number5 << endl;

	//7. Subtract 6 from the new total and:
	number5 -= 6;
	cout << "The number - 6 : " << number5 << endl;

	//The tens place should be the first number given and the ones place should be the second.

	cout << "The tens place should be the first number given and the ones place should be the second : " << number5 << endl;

	*/

	//Problem 6:
	cout << endl << "Problem 6 :" << endl;

	//1.	Take a random number from the user
	int number7;
	cout << "Please enter a random number : " << endl;
	cin >> number7;
	int number8 = number7;

	//2.	Multiply the number by 4
	number7 *= 4;
	cout << "The number * 4 : " << number7 << endl;

	//3.	Add 1 to the number
	number7 += 1;
	cout << "The number + 1 : " << number7 << endl;

	//4.	Multiply by the original number that the user input
	number7 *= number8;
	cout << "The number * the original number entered : " << number7 << endl;

	//5.	Subtract the original number away
	number7 -= number8;
	cout << "The number - the original number entered : " << number7 << endl;

	//6.	Take the square root of the number(you can use cmath’s sqrt function)
	number7 = sqrt(number7);
	cout << "The squareroot of the number : " << number7 << endl;

	//7.	Divide the number by 2
	number7 /= 2;
	cout << "The number / 2 : " << number7 << endl;

	//8.	The result should be the original number
	
	cout << "The number should be the original number entered : " << number7 << endl;


	system("Pause");
	return 0;
}