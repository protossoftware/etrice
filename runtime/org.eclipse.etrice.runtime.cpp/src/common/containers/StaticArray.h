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

#ifndef STATICARRAY_H_
#define STATICARRAY_H_

#include "etDatatypes.h"
#include <cstring>

namespace etRuntime {

template<class Type, int Size>
class StaticArray {
public:
	/**
	 * default constructor
	 */
	StaticArray() {
	}

	/**
	 * copy constructor forwards to deepCopy()
	 */
	StaticArray(const StaticArray<Type, Size> &rhs) {
		this->deepCopy(rhs);
	}

	/**
	 * initializes each array element to t
	 */
	StaticArray(const Type& t) {
		for (int i = 0; i < Size; i++) {
			data[i] = t;
		}
	}

	/**
	 * virtual destructor
	 */
	virtual ~StaticArray(void) {
	}

	/**
	 * returns the size of this array
	 */
	int getSize(void) const {
		return Size;
	}

	/**
	 * returns a pointer to the data of this array (as a C array)
	 */
	Type* getData(void) {
		return this->data;
	}

	/**
	 * returns a const pointer to the data of this array (as a C array)
	 */
	const Type* getData(void) const {
		return this->data;
	}

	/**
	 * indexed access without range check
	 */
	Type& operator[](int index) {
		return data[index];
	}

	/**
	 * copy assignment makes a deep copy
	 */
	StaticArray<Type, Size>& operator=(const StaticArray<Type, Size> &rhs) {
		if (&rhs!=this) {
			this->deepCopy(rhs);
		}
		return *this;
	}

	/**
	 * copy assignment from c++ array
	 */
	StaticArray<Type, Size>& operator=(const Type data[Size]) {
		memcpy(this->data, data, sizeof(this->data));
		return *this;
	}

	/**
	 * comparison operator based on memcmp()
	 */
	bool operator==(const StaticArray<Type, Size> &rhs) const {
		return std::memcmp(this->data, rhs.data, sizeof(data)) == 0;
	}

protected:
	/**
	 * the C array holding the data
	 */
	Type data[Size];

	/**
	 * makes a copy of the array including all elements
	 */
	void deepCopy(const StaticArray<Type, Size> &rhs) {
		std::memcpy(this->data, rhs.data, sizeof(data));
	}

	// TODO: use this to copy because it uses T::operator=() ?
	void deepCopy2(const StaticArray<Type, Size> &rhs) {
		for (int i=0; i<Size; ++i) {
			data[i] = rhs.data[i];
		}
	}

};

} /* namespace etRuntime */
#endif /* STATICARRAY_H_ */

