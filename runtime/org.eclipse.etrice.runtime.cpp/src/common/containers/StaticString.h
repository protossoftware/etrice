/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef STATICSTRING_H_
#define STATICSTRING_H_

#include "StaticArray.h"

namespace etRuntime {

/**
 * a static size string class that basically encapsulates a C string
 */
template<int Size>
class StaticString: public StaticArray<char, Size> {
public:
	/**
	 * default constructor is empty string
	 */
	StaticString()
	{
		this->data[0] = 0;
	}

	/**
	 * copy constructor calls operator=(const char *rhs)
	 */
	template<int RhsSize> StaticString(const StaticString<RhsSize> &rhs)
	{
		operator=(rhs.getData());
	}

	/**
	 * constructor calls operator=(const char *rhs)
	 */
	StaticString(const char *rhs)
	{
		operator=(rhs);
	}

	/**
	 * virtual destructor
	 */
	virtual ~StaticString(void) {
	}

	/**
	 * returns the length of the C string stored
	 */
	int length(void) const {
		return std::strlen(this->data);
	}

	/**
	 * returns a const char * pointer to the data of this array
	 */
	const char* c_str(void) const {
		return this->data;
	}


	/**
	 * forwards to operator=(const char *rhs)
	 */
	template<int RhsSize> StaticString<Size>& operator=(const StaticString<RhsSize> &rhs) {
		return operator=(rhs.data);
	}

	/**
	 * works like strncpy() with the size of this string. Will be 0 terminated.
	 */
	StaticString<Size>& operator=(const char *rhs) {
		if (rhs && rhs!=this->data) {
			std::strncpy(this->data, rhs, Size);
			this->data[Size-1] = 0;
		}
		return *this;
	}

	/**
	 * concatenates the rhs to the end of the string if the result fits.
	 * If it doesn't fit nothing is done.
	 */
	template<int RhsSize> const StaticString<Size> operator+(const StaticString<RhsSize> &other) const {
		// make a copy and add
		return StaticString<Size>(*this) += other;
	}

	/**
	 * concatenates the rhs to the end of the string if the result fits.
	 * If it doesn't fit nothing is done.
	 */
	const StaticString<Size> operator+(const char* other) const {
		// make a copy and add
		return StaticString<Size>(*this) += other;
	}

	/*
	 * concatenates the rhs to the end of the string if the result fits.
	 * If it doesn't fit nothing is done.
	 */
	template<int RhsSize> const StaticString<Size> operator+=(const StaticString<RhsSize>& rhs) {
		return operator+=(rhs.data);
	}

	/*
	 * concatenates the rhs to the end of the string if the result fits.
	 * If it doesn't fit nothing is done.
	 */
	const StaticString<Size> operator+=(const char* rhs) {
		if (rhs && (this->length() + std::strlen(rhs)) < Size) {
			std::strcat(this->data, rhs);
		};

		// Note: this function returns a const, not a const&!
		// this prohibits things like (a + b) = c
		return *this;
	}

	/**
	 * compares two strings using std::strcmp()
	 */
	template<int RhsSize> bool operator==(const StaticString<RhsSize> &rhs) {
		return operator==(rhs.data);
	}

	/**
	 * compares two strings using std::strcmp()
	 */
	bool operator==(const char *rhs) {
		return strcmp(this->data, rhs)==0;
	}
};

} /* namespace etRuntime */

#endif /* STATICSTRING_H_ */

