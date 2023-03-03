// Most compilers understand the once pragma, but just in case...
#ifndef INTEGER_H_INCLUDED
#define INTEGER_H_INCLUDED

#include <iostream>
#include <string>
#include <vector>

/**
 * @brief Header file for Integer.cpp, contains a class and method declerations for Integer.
 */
namespace cosc326 {

	class Integer {

	private: // Can add internal storage or methods here

        std::vector<int> data;
        bool sign;

		Integer(bool sign, const std::vector<int> data);
		Integer abs() const;
		void setData(std::string);
		std::vector<int> deleteLeadingZero(const std::vector<int>& data) const;
		std::vector<int> reverse(const std::vector<int>& data) const;
		int compare(const std::vector<int>& a, const std::vector<int>& b) const;
		std::vector<int> add(const std::vector<int>& a, const std::vector<int>& b) const;
		std::vector<int> subtract(const std::vector<int>& a, const std::vector<int>& b) const;

	public:

		Integer();                              // Integer i;
        Integer(const Integer& in);             // Integer j(i);
		Integer(std::string);                   // Integer k("123");          
        Integer(int i);

		~Integer();

		Integer& operator=(const Integer& in);  // j = i;

        // Unary operators
		Integer operator-() const;              // -j;
        Integer operator+() const;              // +j;

        // Arithmetic assignment operators
        Integer operator+=(const Integer& in);  // j += i;
		Integer operator-=(const Integer& in);  // j -= i;
		Integer operator*=(const Integer& in);  // j *= i;
		Integer operator/=(const Integer& in);  // j /= i;
		Integer operator%=(const Integer& in);  // j %= i;

        // Binary operators
		Integer operator+(const Integer& in) const; // lhs + rhs;
		Integer operator-(const Integer& in) const; // lhs - rhs;
		Integer operator*(const Integer& in) const; // lhs * rhs;
		Integer operator/(const Integer& in) const; // lhs / rhs;
		Integer operator%(const Integer& in) const; // lhs % rhs;

        friend std::ostream& operator<<(std::ostream& os, const Integer& in); 	// std::cout << i << std::endl;
		friend std::istream& operator>>(std::istream& is, Integer& in);		    // std::cin >> i;

        bool operator<(const Integer& in) const;    // lhs < rhs
		bool operator>(const Integer& in) const;    // lhs > rhs
		bool operator<=(const Integer& in) const;   // lhs <= rhs
		bool operator>=(const Integer& in) const;   // lhs >= rhs
        bool operator==(const Integer& in) const;   // lhs == rhs
		bool operator!=(const Integer& in) const;   // lhs != rhs
	};

	Integer gcd(const Integer& in1, const Integer& in2);  // i = gcd(a, b);
}
#endif
