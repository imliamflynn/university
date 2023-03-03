#pragma once

// Most compilers understand the once pragma, but just in case...
#ifndef RATIONAL_H_INCLUDED
#define RATIONAL_H_INCLUDED

#include <iostream>
#include <string>
#include "Integer.h"


/**
 * @brief Header file for Rational.cpp, contains a class and method declerations for Rational.
 */
namespace cosc326 {

	class Rational {

	private: // Can add internal storage or methods here

		Integer a;
		Integer b;
		int sign;

		void normalize();
		void setData(std::string data);

	public:

		Rational();
        Rational(std::string data);
		Rational(const Rational& r);
		Rational(const Integer& a); // a
		Rational(const Integer& a, const Integer b); // a/b
		Rational(const Integer& a, const Integer b, const Integer c); // a + b/c
        
		~Rational();
        Rational& operator=(const Rational& r); // q = r

        Rational operator-() const; // -r
		Rational operator+() const; // +r

        Rational operator+=(const Rational& r); // q += r
		Rational operator-=(const Rational& r); // q -= r
		Rational operator*=(const Rational& r); // q *= r
		Rational operator/=(const Rational& r); // q /= r

		Rational operator+(const Rational& r) const; // q + r
		Rational operator-(const Rational& r) const; // q - r
		Rational operator*(const Rational& r) const; // q * r
		Rational operator/(const Rational& r) const; // q / r

        friend std::ostream& operator<<(std::ostream& os, const Rational& r); // std::cout << r << std::endl
		friend std::istream& operator>>(std::istream& is, Rational& r); // std::cin >> r

		bool operator==(const Rational& r) const;   // q == r
		bool operator!=(const Rational& r) const;   // q != r
		bool operator<(const Rational& r) const;    // q < r
		bool operator<=(const Rational& r) const;   // q <= r
		bool operator>(const Rational& r) const;    // q > r
		bool operator>=(const Rational& r) const;   // q >= r

	};
}
#endif
