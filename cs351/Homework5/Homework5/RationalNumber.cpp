//Sean Coady
//CS 351
//RationalNumber.cpp

#include "stdafx.h"
#include <iostream>
#include <iomanip>
using namespace std;

class Rational
{
private:
	 int numerator;
     int denominator;
public:  
	 Rational(); 
     Rational(int num, int dem); 
     void simplify(); //reduces fraction if possible
     int gcd(int u, int v); //finds greatest common denominator
 
     //overloaded ops with friend functions
      friend istream& operator>>(istream&, Rational& f);
      friend ostream& operator<<(ostream&, Rational& f);
      friend Rational operator+(Rational fraction1, Rational fraction2);
      friend Rational operator-(Rational fraction1, Rational fraction2);
      friend Rational operator*(Rational fraction1, Rational fraction2);
      friend Rational operator/(Rational fraction1, Rational fraction2);
  
};

//default constructor Rational 
Rational::Rational()
{
    numerator = 0;
    denominator = 1;
}
 
 
 
Rational::Rational(int num, int dem)
{
    numerator = num;
    denominator = dem;
}
 
 
 
//function for adding
Rational operator+(Rational fraction1, Rational fraction2)
{
    int numerator = (fraction1.numerator * fraction2.denominator + fraction1.denominator * fraction2.numerator);
    int denominator = (fraction1.denominator * fraction2.denominator);
    return Rational(numerator, denominator); 
}
//function for multiplication
Rational operator*(Rational fraction1, Rational fraction2)
{
    int numerator = (fraction1.numerator * fraction2.numerator);
    int denominator = (fraction1.denominator * fraction2.denominator);
    return Rational(numerator, denominator);
}
//function for subtraction 
Rational operator-(Rational fraction1, Rational fraction2)
{
    int numerator = (fraction1.numerator * fraction2.denominator - fraction1.denominator * fraction2.numerator);
    int denominator = (fraction1.denominator * fraction2.denominator);
    return Rational(numerator, denominator);
}
//function for division 
//checks for negative in the denominator
Rational operator/(Rational fraction1, Rational fraction2)
{
    int numerator = (fraction1.numerator * fraction2.denominator);
    int denominator = (fraction1.denominator * fraction2.numerator);
    if( denominator <= -1) 
    {
        denominator *= -1;
        numerator *= -1;
     }
    return Rational(numerator, denominator);
}
//if possible, simplifies and takes care of negative denominator
void Rational::simplify() 
{
    int temp, absValue = abs(numerator);
    if(numerator != 0 && absValue != 1 && denominator != 1) {
        temp = gcd(absValue, denominator);
        if(temp > 1)
		{
            numerator = numerator / temp;
            denominator = denominator / temp;
        }
    }
}
//find greatest common denominator
int Rational::gcd(int n, int d) 
{
    int temp = n % d;
    while(temp > 0) 
	{
        n = d;
        d = temp;
        temp = n % d;
    }
    return d;
}

//overloading ostream to output fractions as num/den
//unless denominator = 1, to avoid redunancy (ex 9/1 == 9)
ostream& operator<<(ostream& out, Rational& f) 
{
    if (f.denominator == 1)
       out << f.numerator<<endl;
    else
         out << f.numerator << "/" << f.denominator;
         return out;
}
 
 
 
//overloads istream for fraction entries
//checks to see if denominator is 0
istream &operator>>(istream &input, Rational &f) 
{
 
 
 
 
    char forwardSlash;
 
 
 
 
    cout <<"Enter a fraction (i.e. 3/4):  ";
    input >> f.numerator >> forwardSlash >> f.denominator;
 
 
 
 
    if (f.denominator <= 0)            
    {
        cout <<"Denominator was 0 - no division by 0 allowed. Automatically set to 1."<<endl;
        f.denominator = 1;
    }
 
 
 
 
    return input;
}
 
 
//driver program for RationalNumber
//menu driven application for testing operation overloading
//choose an operation to perform on the fraction 1-4, 5 to exit
int main()
{
    Rational fraction1, fraction2, answer, temp;
    int choice;
    
	while (true)
    {
    //user menu
    cout << "1 Addition\n";
    cout << "2 Subtraction\n";
    cout << "3 Multiplication\n";
    cout << "4 Division\n";
    cout << "5 Quit program.\n";
    cout << "------------------";
    cout << "\nOperation to perform:  ";
 
    cin >> choice;

    if (choice == 5 || choice == 5)
	{
        cout<<"Goodbye.\n";
	    system("PAUSE");
	    return 0;
	}
    switch (choice)
    {
    case 1:

    cin>>fraction1;
    cin>>fraction2;
    answer = fraction1 + fraction2;
    answer.simplify();
   cout<<"\nResult of addition: ";
   cout << answer <<endl<<endl;
   break;

	case 2:
    cin>>fraction1;
    cin>>fraction2;
    answer = fraction1 - fraction2;
    answer.simplify();
   cout<<"\nResult of subtraction: ";
    cout << answer <<endl<<endl;
    break;
 
    case 3:
    cin>>fraction1;
    cin>>fraction2;
    answer = fraction1 * fraction2;
    answer.simplify();
   cout<<"\nResult of multiplication: ";
    cout << answer <<endl<<endl;
    break;

    case 4:
    cin>>fraction1;
    cin>>fraction2;
    answer = fraction1 / fraction2;
    answer.simplify();
   cout<<"\nResult of division: ";
    cout << answer <<endl<<endl;
    break;
    }
}
    system("PAUSE");
    return 0;
}
