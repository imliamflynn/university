#include "Integer.h"
using namespace std;


/**
 * @brief This program acts as a representation of arbitrarily large Integers. The methods in this
 * program allow us to do operations with these Integers using unary, binary, assignment, and
 * relational operators.
 */
namespace cosc326 {

    // Constructors

    /**
     * @brief Construct a new Integer:: Integer object with a value of 0.
     */
	Integer::Integer() {
		sign = true;
		data.push_back(0);
	}

    /**
     * @brief Construct a new Integer:: Integer object that duplicates the provided Integer.
     * 
     * @param in 
     */
    Integer::Integer(const Integer& in) {
		sign = in.sign;
		data = in.data;
	}

    /**
     * @brief Construct a new Integer:: Integer object that takes a string of digits, possible with a
     * leading + or -
     * 
     * @param s 
     */
    Integer::Integer(std::string s) {
		setData(s);
	}

    /**
     * @brief Construct a new Integer:: Integer object it inserts an integer in alternative form for 
     * presentation as rational and if data is 0 kicks it out.
     * 
     * @param i 
     */
    Integer::Integer(int i){
		sign = true;

		while(i > 0){
			data.insert(data.begin() + 0, i % 10);
			i /= 10;
		}

		if(data.size() == 0){
			data.push_back(0);
		}
	}


    // Destructor

    /**
     * @brief Destroy the Integer:: Integer object
     */
    Integer::~Integer(){}


    // The Assignment Operator

    /**
     * @brief Assigns the parameter objects values to this objects values.
     * 
     * @param in 
     * @return Integer& 
     */
    Integer& Integer::operator =(const Integer& in) {
		sign = in.sign;
		data = in.data;
		return *this;
	}


    // Unary Operators

    /**
     * @brief Returns the Integer with a negative sign.
     * 
     * @return Integer 
     */
	Integer Integer::operator -() const {
		return Integer(!sign, data);
	}

    /**
     * @brief Returns the Integer with a positive sign.
     * 
     * @return Integer 
     */
    Integer Integer::operator +() const {
		return Integer(sign, data);
	}

    
    // Arithmetic Assignment Operators

    /**
     * @brief Adds the parameter to the Integer and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator +=(const Integer& in) {
		Integer result = *this + in;
		this->sign = result.sign;
		this->data = result.data;
		return result;
	}
    
    /**
     * @brief Takes the parameter off of the Integer and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator -=(const Integer& in) {
		Integer result = *this - in;
		this->sign = result.sign;
		this->data = result.data;
		return result;
	}

    /**
     * @brief Multiplies the Integer with the parameter and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator *=(const Integer& in) {
		Integer result = *this * in;
		this->sign = result.sign;
		this->data = result.data;
		return result;
	}

    /**
     * @brief Divides the Integer by the parameter then returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator /=(const Integer& in) {
		Integer result = *this / in;
		this->sign = result.sign;
		this->data = result.data;
		return result;
	}
    
    /**
     * @brief Divides the Integer by the parameter then returns the remainder.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator %=(const Integer& in) {
		Integer a = this->abs();
		while (a > in) {
			a -= in;
		}

		a.sign = sign;
		return a;
	}


    // Binary Operators

    /**
     * @brief Adds the parameter to the Integer and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
    Integer Integer::operator +(const Integer& in) const {
		if ((sign && in.sign) || (!sign && !in.sign)) {
			std::vector<int> data_result = add(data, in.data);
            
			Integer result;
			if (!sign && !in.sign) {
				result.sign = false;
			}
			result.data = data_result;

			if(result.data.size()==1 && result.data[0] == 0){
				result.sign = true;
			}
			return result;
		} else if (sign && !in.sign) {
			return this->operator -(-in);
		} else {
			return in.operator -(-(*this));
		}
	}
    
    /**
     * @brief Minuses the parameter from the Integer and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator -(const Integer& in) const {
		if ((sign && !in.sign)) {
			return this->operator +(-in);
		} else if ((!sign && in.sign)) {
			return -(in.operator +(-(*this)));
		} else if (sign && in.sign) {
			if (*this >= in) {
				Integer result;
				result.sign = true;
				result.data = subtract(this->data, in.data);

				return result;
			} else {
				Integer result;
				result.sign = false;
				result.data = subtract(in.data, this->data);

				if(result.data.size()==1 && result.data[0] == 0){
					result.sign = true;
				}
				return result;
			}
		} else {
			Integer temp = -in;
			return temp.operator -(*this);
		}
	}
    
    /**
     * @brief Multiplies the Integer by the parameter and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator *(const Integer& in) const {
		Integer a = this->abs();
		Integer b = in.abs();

		Integer zero;
		Integer one("1");
        
		Integer result;
		while (b > zero) {
			result += a;
			b -= one;
		}

		if (sign && in.sign) {
			return result;
		} else if (!sign && !in.sign) {
			return result;
		} else {
			if(result.data.size()==1 && result.data[0] == 0){
				return result;
			}else{
				result.sign = false;
				return result;
			}
		}
	}
    
    /**
     * @brief Divides the Integer by the parameter and returns the result.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator /(const Integer& in) const {

		Integer result; 
		Integer temp; 

		result.data.clear();
		temp.data.clear();

		result.sign = this->sign && in.sign;

		Integer a = this->abs();
		Integer b = in.abs();

		for (int i = 0, k = 0; i < a.data.size(); i++) {
			temp.data.push_back(a.data[i]);
			if (temp >= b) {
				int r = 0;
				while (temp >= b) {
					temp = temp - b;
					r++;
				}
				result.data.push_back(r);
			}
		}
		return result;
	}

    /**
     * @brief Divides the Integer by the parameter and returns the remainder.
     * 
     * @param in 
     * @return Integer 
     */
	Integer Integer::operator %(const Integer& in) const {
		Integer iabs = in.abs();

		Integer result = this->abs();
		while (result >= iabs) {
			result -= iabs;
		}

		if (sign && in.sign) {
			return result;
		} else if (!sign && !in.sign) {
			return result;
		} else {
			if(result.data.size()==1 && result.data[0] == 0){
				return result;
			}else{
				result.sign = false;
				return result;
			}
		}
	}


    // Streaming Insertion and Extraction Operators

    /**
     * @brief Passes the Integer/parameter to the output stream.
     * 
     * @param os 
     * @param in 
     * @return std::ostream& 
     */
    std::ostream& operator<<(std::ostream& os, const Integer& in) {
		if (!in.sign) {
			os << "-";
		}

		for (size_t i = 0; i < in.data.size(); i++) {
			os << in.data[i];
		}
		return os;
	}
    
    /**
     * @brief Sets the parameter Integer to the input stream.
     * 
     * @param is 
     * @param in 
     * @return std::istream& 
     */
	std::istream& operator>>(std::istream& is, Integer& in) {
		std::string str;
		is >> str;

		in.setData(str);
		return is;
	}


    // Relational Operators

    /**
     * @brief Figures out if the Integer is smaller than the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
    bool Integer::operator <(const Integer& in) const {
		if (sign && in.sign) {
			return compare(data, in.data) < 0;
		} else if (!sign && !in.sign) {
			return compare(data, in.data) > 0;
		} else if (sign && !in.sign) {
			return false;
		} else {
			return true;
		}
	}

    /**
     * @brief Figures out if the Integer is larger than the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
    bool Integer::operator >(const Integer& in) const {
		return !(*this < in) && *this != in;
	}

    /**
     * @brief Figures out if the Integer is smaller than or equal to the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
    bool Integer::operator <=(const Integer& in) const {
		return *this < in || *this == in;
	}

    /**
     * @brief Figures out if the Integer is larger than or equal to the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
    bool Integer::operator >=(const Integer& in) const {
		return !(*this < in);
	}

    /**
     * @brief Figures out if the Integer is equal to the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
	bool Integer::operator ==(const Integer& in) const {
		return compare(data, in.data) == 0 && sign == in.sign;
	}

    /**
     * @brief Figures out if the Integer is not equal to the parameter and returns the result.
     * 
     * @param in 
     * @return true 
     * @return false 
     */
	bool Integer::operator !=(const Integer& in) const {
		return !this->operator ==(in);
	}


    // Greatest Common Divisor

    /**
     * @brief Returns the greatest common divisor of the two parameters.
     * 
     * @param in1 
     * @param in2 
     * @return Integer 
     */
    Integer gcd(const Integer& in1, const Integer& in2){
		if(in2 == Integer("0")) {
			return in1;
		}
		return gcd(in2, in1 % in2);
	}


    // Private Methods

    /**
     * @brief Iterates through each character of a string and if it is a digit it pushes it to the data vector.
     * 
     * @param s 
     */
    void Integer::setData(std::string s) {
		if (s.size() > 0) {
			sign = true;

			for (size_t i = 0; i < s.size(); i++) {
				char ch = s[i];
				if (ch >= '0' && ch <= '9') {
					data.push_back(ch - '0');
				} else if (i == 0 && ch == '+') {
					sign = true;
				} else if (i == 0 && ch == '-') {
					sign = false;
				}
			}
		} else {
			sign = true;
			data.push_back(0);
		}
	}

    /**
     * @brief Subtracts each int in "b" vector from each int in "a" vector and returns the result.
     * 
     * @param a 
     * @param b 
     * @return std::vector<int> 
     */
    std::vector<int> Integer::subtract(const std::vector<int>& a,const std::vector<int>& b) const {
		std::vector<int> result;

		int borrow = 0;
		int i = a.size() - 1;
		int j = b.size() - 1;
		while (i >= 0 && j >= 0) {
			int diff = a[i] - borrow - b[j];

			if (diff < 0) {
				borrow = 1;
				int v = 10 + diff;
				result.push_back(v);
			} else {
				borrow = 0;
				int v = diff;
				result.push_back(v);
			}

			i--;
			j--;
		}

		while (i >= 0) {
			int diff = a[i] - borrow - 0;

			if (diff < 0) {
				borrow = 1;
				int v = 10 + diff;
				result.push_back(v);
			} else {
				borrow = 0;
				int v = diff;
				result.push_back(v);
			}

			i--;
		}

		result = reverse(result);
		result = deleteLeadingZero(result);
		return result;
	}

    /**
     * @brief Adds each int in "b" vector to each int in "a" vector.
     * 
     * @param a 
     * @param b 
     * @return std::vector<int> 
     */
    std::vector<int> Integer::add(const std::vector<int>& a,const std::vector<int>& b) const {
		std::vector<int> result;

		int carry = 0;
		int i = a.size() - 1;
		int j = b.size() - 1;
		while (i >= 0 && j >= 0) {
			int sum = a[i] + b[j] + carry;
			int v = sum % 10;
			carry = sum / 10;
			result.push_back(v);

			i--;
			j--;
		}

		while (i >= 0) {
			int sum = a[i] + carry;
			int v = sum % 10;
			carry = sum / 10;
			result.push_back(v);

			i--;
		}

		while (j >= 0) {
			int sum = b[j] + carry;
			int v = sum % 10;
			carry = sum / 10;
			result.push_back(v);

			j--;
		}

		if (carry > 0) {
			result.push_back(carry);
		}

		result = reverse(result);
		return result;
	}

    /**
     * @brief Returns the absolute value of the this Integer value.
     * 
     * @return Integer 
     */
    Integer Integer::abs() const {
		if (sign) {
			return *this;
		} else {
			return Integer(!sign, data);
		}
	}

    /**
     * @brief Construct a new Integer:: Integer object and sets this Integers values to the paramater values.
     * 
     * @param sign 
     * @param data 
     */
	Integer::Integer(bool sign, const std::vector<int> data) {
		this->sign = sign;
		this->data = data;
	}

    /**
     * @brief Compares the two vector paramaters and returns 1 if a > b, and returns -1 if a < b.
     * 
     * @param a 
     * @param b 
     * @return int 
     */
    int Integer::compare(const std::vector<int>& a,const std::vector<int>& b) const {
		if (a.size() == b.size()) {
			for (size_t i = 0; i < a.size(); i++) {
				if (a[i] > b[i]) {
					return 1;
				} else if (a[i] < b[i]) {
					return -1;
				}
			}
			return 0;
		} else {
			if (a.size() > b.size()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

    /**
     * @brief Reverses the order of the ints in the parameter vector.
     * 
     * @param data 
     * @return std::vector<int> 
     */
	std::vector<int> Integer::reverse(const std::vector<int>& data) const {
		std::vector<int> result;
		for (int i = data.size() - 1; i >= 0; i--) {
			result.push_back(data[i]);
		}
		return result;
	}

    /**
     * @brief Deletes the leading zero from the parameter data.
     * 
     * @param data 
     * @return std::vector<int> 
     */
    std::vector<int> Integer::deleteLeadingZero(const std::vector<int>& data) const {
		std::vector<int> result;

		int start = -1;
		for (size_t i = 0; i < data.size(); i++) {
			if (data[i] != 0) {
				start = i;
				break;
			}
		}

		if (start == -1) {
			result.push_back(0);
		} else {
			for (size_t i = start; i < data.size(); i++) {
				result.push_back(data[i]);
			}
		}

		return result;
	}


}