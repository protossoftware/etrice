/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef STRING_H_
#define STRING_H_

#include <cstddef>
#include <cstring>

namespace etRuntime {

/**
 * a static size string class that basically encapsulates a C string
 */
class String {
public:
	/**
	 * default constructor is empty string
	 */
	String();

	/**
	 * copy constructor calls operator=(const char *rhs)
	 */
	String(const String &rhs)
	: _size(0)
	, _data(0)
	{
		++ncreated;
		operator=(rhs._data);
	}

	/**
	 * constructor calls operator=(const char *rhs)
	 */
	String(const char *rhs)
	: _size(0)
	, _data(0)
	{
		++ncreated;
		operator=(rhs);
	}

	/**
	 * virtual destructor
	 */
	virtual ~String(void);


	/**
	 * returns the length of the C string stored
	 */
	size_t length(void) const
	{
		return std::strlen(this->_data);
	}

	/**
	 * returns a const char * pointer to the data of this array
	 */
	const char* c_str(void) const
	{
		return this->_data;
	}

	/**
	 * returns the character at the given position. If index is out of range 0 is returned
	 */
	char operator[](int index) const {
		return (index < 0 || index >= (int)_size) ? 0 : _data[index];
	}

	/**
	 * forwards to operator=(const char *rhs)
	 */
	String& operator=(const String &rhs)
	{
		return operator=(rhs._data);
	}

	/**
	 * creates a copy of the rhs
	 */
	String& operator=(const char *rhs);

	//
	// string concatenation
	//

	/*
	 * concatenates the rhs to the end of the string.
	 */
	const String operator+=(const String& rhs) {
		return operator+=(rhs._data);
	}

	/*
	 * concatenates the rhs to the end of the string.
	 */
	const String operator+=(const char* rhs);

	/*
	 * concatenates the c to the end of the string.
	 */
	const String operator+=(char c);

	//
	// comparison
	//

	/**
	 * compares two strings
	 */
	int compare(const String& rhs) const {
		return std::strcmp(this->_data, rhs._data);
	}
	int compareXX(const String& rhs) const {
		return std::strcmp(this->_data, rhs._data);
	}
//
//	/**
//	 * compares a string with a C-String
//	 */
//	int compare(const char *rhs) const {
//		return strcmp(this->_data, rhs);
//	}

	//
	// find
	//
	static const size_t npos = -1;

	size_t find(const String& str, size_t pos = 0) const;
	size_t find(const char* str, size_t pos = 0) const;
	size_t find(char c, size_t pos = 0) const;

	size_t rfind(const String& str) const;
	size_t rfind(const char* str) const;
	size_t rfind(char c) const;

	//
	// sub strings
	//
	String substr(size_t pos = 0, size_t len = npos) const;

	static size_t getNAllocations() { return nallocs; }
	static size_t getNDeallocations() { return ndeallocs; }
	static size_t getNCreated() { return ncreated; }
	static size_t getNDestroyed() { return ndestroyed; }

private:
	static size_t nallocs;
	static size_t ndeallocs;
	static size_t ncreated;
	static size_t ndestroyed;

	size_t _size;
	char* _data;
};

//
// string concatenation
//

/**
 * concatenates lhs and rhs.
 */
inline const String operator+(const String &lhs, const String &rhs) {
	// make a copy and add
	return String(lhs) += rhs;
}

/**
 * concatenates lhs and rhs.
 */
inline const String operator+(const String &lhs, const char* rhs) {
	// make a copy and add
	return String(lhs) += rhs;
}

/**
 * concatenates lhs and c
 */
inline const String operator+(const String &lhs, char c) {
	// make a copy and add
	String result(lhs);
	result += c;
	return result;
}

/**
 * concatenates lhs and rhs.
 */
inline const String operator+(const char* lhs, const String& rhs) {
	// create a string and add
	String result(lhs);
	result += rhs;
	return result;
}

/**
 * concatenates c and rhs.
 */
inline const String operator+(char c, const String& rhs) {
	// create a string and add
	String result("");
	result += c;
	result += rhs;
	return result;
}

//
// string comparison
//

/**
 * compares two strings
 */
inline bool operator==(const String& lhs, const String &rhs) {
	return lhs.compare(rhs)==0;
}

/**
 * compares a string with a C-string
 */
inline bool operator==(const String& lhs, const char *rhs) {
	return lhs.compare(rhs)==0;
}

/**
 * compares a C-string with a string
 */
inline bool operator==(const char* lhs, const String& rhs) {
	return rhs.compare(lhs)==0;
}

/**
 * compares two strings
 */
inline bool operator!=(const String &lhs, const String &rhs) {
	return !(lhs == rhs);
}

/**
 * compares a string and a C-string
 */
inline bool operator!=(const String &lhs, const char *rhs) {
	return !(lhs == rhs);
}

/**
 * compares a C-string and a string
 */
inline bool operator!=(const char* lhs, const String& rhs) {
	return !(lhs == rhs);
}

inline bool operator<(const String &lhs, const String& rhs) {
	return lhs.compare(rhs) < 0;
}

inline bool operator<(const String &lhs, const char* rhs) {
	return lhs.compare(rhs) < 0;
}

inline bool operator<(const char* lhs, const String& rhs) {
	return rhs.compare(lhs) > 0;
}

inline bool operator<=(const String &lhs, const String& rhs) {
	return lhs.compare(rhs) <= 0;
}

inline bool operator<=(const String &lhs, const char* rhs) {
	return lhs.compare(rhs) <= 0;
}

inline bool operator<=(const char* lhs, const String& rhs) {
	return rhs.compare(lhs) >= 0;
}

inline bool operator>(const String &lhs, const String& rhs) {
	return lhs.compare(rhs) > 0;
}

inline bool operator>(const String &lhs, const char* rhs) {
	return lhs.compare(rhs) > 0;
}

inline bool operator>(const char* lhs, const String& rhs) {
	return rhs.compare(lhs) < 0;
}

inline bool operator>=(const String &lhs, const String& rhs) {
	return lhs.compare(rhs) >= 0;
}

inline bool operator>=(const String &lhs, const char* rhs) {
	return lhs.compare(rhs) >= 0;
}

inline bool operator>=(const char* lhs, const String& rhs) {
	return rhs.compare(lhs) <= 0;
}

} /* namespace etRuntime */

#endif /* STRING_H_ */

