#include "Rational.h"

/**
 * @brief This program acts as a representation of arbitrarily large Rationals. The methods in this
 * program allow us to do operations with these Rationals using unary, binary, assignment, and
 * relational operators.
 */
namespace cosc326 {

    // Constructors

    /**
     * @brief Construct a new Rational:: Rational object with a value of 0.
     */
	Rational::Rational() {
		sign = 1;
		a = Integer("0");
		b = Integer("1");
	}

    /**
     * @brief Construct a new Rational:: Rational object that takes a string of digits as a parameter.
     * 
     * @param data 
     */
    Rational::Rational(std::string data) {
		setData(data);
	}

    /**
     * @brief Construct a new Rational:: Rational object that duplicates the provided Rational.
     * 
     * @param r 
     */
    Rational::Rational(const Rational& r) {
		sign = r.sign;
		a = r.a;
		b = r.b;
	}

    /**
     * @brief Construct a new Rational:: Rational object and sets this->a to the parameter a.
     * 
     * @param a 
     */
    Rational::Rational(const Integer& a) {
		sign = 1;
		this->a = a;
		b = Integer("1");
		this->normalize();
	}

    /**
     * @brief Construct a new Rational:: Rational object and sets this->a to a and this->b to b.
     * 
     * @param a 
     * @param b 
     */
    Rational::Rational(const Integer& a, const Integer b) {
		sign = 1;
		this->a = a;
		this->b = b;
		this->normalize();
	}

    /**
     * @brief Construct a new Rational:: Rational object and sets this->a to a + b and this->b to c.
     * 
     * @param a 
     * @param b 
     * @param c 
     */
	Rational::Rational(const Integer& a, const Integer b, const Integer c) {
		sign = 1;
		this->a = a * c + b;
		this->b = c;
		this->normalize();
	}


    // Destructor

    /**
     * @brief Destroy the Rational:: Rational object
     * 
     */
	Rational::~Rational() {}

    // The Assignment Operator

    /**
     * @brief Assigns the parameter objects values to this objects values.
     * 
     * @param in 
     * @return Integer& 
     */
	Rational& Rational::operator =(const Rational& r) {
		sign = r.sign;
		a = r.a;
		b = r.b;

		return *this;
	}


    // Unary Operators

    /**
     * @brief Returns the Rational with a negative sign.
     * 
     * @return Rational 
     */
    Rational Rational::operator -() const {
		Rational r = *this;
		r.sign *= -1;
		return r;
	}    
    
    /**
     * @brief Returns the Rational with a positive sign.
     * 
     * @return Rational 
     */
	Rational Rational::operator +() const {
		return *this;
	}


    // Arithmetic Assignment Operators

    /**
     * @brief  Adds the parameter to the Rational and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator +=(const Rational& r) {
		*this = *this + r;
		return *this;
	}
    
    /**
     * @brief Takes the parameter off of the Rational and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator -=(const Rational& r) {
		*this = *this - r;
		return *this;
	}
    
    /**
     * @brief Multiplies the Rational with the parameter and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator *=(const Rational& r) {
		*this = *this * r;
		return *this;
	}

    /**
     * @brief Divides the Rational by the parameter then returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator /=(const Rational& r) {
		*this = *this / r;
		return *this;
	}


    //Binary Operators

    /**
     * @brief Adds the parameter to the Rational and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
    Rational Rational::operator +(const Rational& r) const {
		Integer down = b * r.b;
		Integer up = a * r.b + r.a * b;
		return Rational(up, down);
	}

    /**
     * @brief Minuses the parameter from the Rational and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator -(const Rational& r) const {
		Integer down = b * r.b;
		Integer up = a * r.b - r.a * b;
		return Rational(up, down);
	}

    /**
     * @brief Multiplies the Rational by the parameter and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator *(const Rational& r) const {
		return Rational(a * r.a, b * r.b);
	}

    /**
     * @brief Divides the Rational by the parameter and returns the result.
     * 
     * @param r 
     * @return Rational 
     */
	Rational Rational::operator /(const Rational& r) const {
		return Rational(a * r.b, b * r.a);
	}


    // Streaming Insertion and Extraction Operators

    /**
     * @brief Passes the Rational/parameter to the output stream.
     * 
     * @param os 
     * @param r 
     * @return std::ostream& 
     */
    std::ostream& operator<<(std::ostream& os, const Rational& r) {
		
		if (r.a > r.b) {
			if (r.sign == -1) {
				os << "-";
			}

			Integer one("1");
			if (r.b == one) {
				os << r.a;
			} else {

				Integer whole = r.a / r.b;
				Integer mod = r.a % r.b;

				os << whole << "." << mod << "/" << r.b;
			}
		} else {
			if (r.sign == -1) {
				os << "-";
			}

			Integer one("1");
			if (r.b == one) {
				os << r.a;
			} else {
				os << r.a << "/" << r.b;
			}
		}
		return os;
	}

    /**
     * @brief Sets the parameter Rational to the input stream.
     * 
     * @param is 
     * @param r 
     * @return std::istream& 
     */
	std::istream& operator>>(std::istream& is, Rational& r) {
		std::string data;
		is >> data;
		r.setData(data);

		return is;
	}


    // Relational Operators

    /**
     * @brief Figures out if the Rational is smaller than the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
	bool Rational::operator <(const Rational& r) const {
		return a * r.b < r.a * b;
	}

    /**
     * @brief Figures out if the Rational is larger than the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
	bool Rational::operator >(const Rational& r) const {
		return a * r.b > r.a * b;
	}
    
    /**
     * @brief Figures out if the Rational is smaller than or equal to the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
	bool Rational::operator <=(const Rational& r) const {
		return a * r.b <= r.a * b;
	}
    
    /**
     * @brief Figures out if the Rational is larger than or equal to the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
	bool Rational::operator >=(const Rational& r) const {
		return a * r.b >= r.a * b;
	}

    /**
     * @brief Figures out if the Rational is equal to the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
	bool Rational::operator ==(const Rational& r) const {
		return a * r.b == r.a * b;
	}
    
    /**
     * @brief Figures out if the Rational is not equal to the parameter and returns the result.
     * 
     * @param r 
     * @return true 
     * @return false 
     */
    bool Rational::operator !=(const Rational& r) const {
		return a * r.b != r.a * b;
    }
    

    // Private Methods
    
    /**
     * @brief Normalizes the data for optimal output.
     */
    void Rational::normalize() {
		Integer zero; // 0

		sign = 1;
		if (a < zero) {
			sign *= -1;
			a = -a;
		}

		if (b < zero) {
			sign *= -1;
			b = -b;
		}
		
		Integer g = gcd(a, b);
		Integer one("1");
		if (g > one) {
			a /= g;
			b /= g;
		}
		if (a == zero) {
			sign = 1;
			b = Integer("1");
		}
	}

    /**
     * @brief Processes the string data and turns it into actual data that is saved to this object.
     * 
     * @param data 
     */
    void Rational::setData(std::string data) {
		sign = 1;

		int indexOfDot = -1;
		int indexOfSeperator = -1;

		for (size_t i = 0; i < data.size(); i++) {
			if (data[i] == '/') {
				indexOfSeperator = i;
			}

			if (data[i] == '.') {
				indexOfDot = i;
			}
		}

		if (indexOfDot == -1) {
			if (indexOfSeperator != -1) {
				a = Integer(data.substr(0, indexOfSeperator));
				b = Integer(data.substr(indexOfSeperator + 1, data.size() - indexOfSeperator - 1));
			} else {
				a = Integer(data); 
				b = Integer("1");
			}
		} else {
			Integer zero("0");
			Integer w(data.substr(0, indexOfDot));
			if(w < zero){
				w = -w;
				sign = -1;
			}
			
			a = Integer(data.substr(indexOfDot + 1, indexOfSeperator - indexOfDot - 1));
			b = Integer(data.substr(indexOfSeperator + 1, data.size() - indexOfSeperator - 1));

            a += w * b;

            if(sign == -1){
				a = -a;
			}
		}

		this->normalize();
	}


}