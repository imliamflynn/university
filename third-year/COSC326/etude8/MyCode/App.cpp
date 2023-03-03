#include <iostream>
#include "Integer.h"
#include "Rational.h"
using namespace std;


/**
 * @brief This file has the main method for Integer.cpp and Rational.cpp
 */
using namespace cosc326;

int main(){

	// Integer test cases

	cout << "\nIntegers:\n";
	cout << Integer() << "\n";
	Integer integer1 = Integer(45);
	Integer integer2 = Integer(integer1);
	cout << integer1 << "\n";
	cout << integer2 << "\n";
	cout << Integer("-7") << "\n";
	cout << Integer("+7") << "\n";
	cout << Integer(5) << "\n";
	cout << Integer(21) + Integer(6) << "\n";
	cout << Integer(21) - Integer(6) << "\n";
	cout << Integer(-10) + Integer(5) << "\n";
	cout << Integer(14) / Integer(7) << "\n";
	cout << Integer(2) * Integer(50) << "\n";
	cout << Integer(14) % Integer(7) << "\n";
	Integer integer3 = Integer(18);
	Integer integer4 = Integer(36);
	cout << gcd(integer3, integer4) << "\n";


	cout << "\n\n";

	// Rational test cases

	cout << "Rationals:\n";
	cout << Rational("1") << "\n";
	cout << Rational("2/3") << "\n";
	cout << Rational("-3.1/2") << "\n";
	cout << Rational("0.1/3") << "\n";
	cout << Rational("4/3") << "\n";
	cout << Rational("-3.2/4") << "\n";
	cout << Rational("+15.32/2") << "\n";
	cout << Rational("-3/2") << "\n";

	return 0;
}