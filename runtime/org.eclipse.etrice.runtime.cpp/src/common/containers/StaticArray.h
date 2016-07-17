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
#include <string.h>

namespace etRuntime {

template<class Type, int Size>
class StaticArray {
public:
	StaticArray() {
	}

	StaticArray(const StaticArray<Type, Size> &rhs) {
		this->deepCopy(rhs);
	}

	StaticArray(const Type& t) {
		for (int i = 0; i < Size; i++) {
			data[i] = t;
		}
	}

	virtual ~StaticArray(void) {
	}

	int getSize(void) const {
		return Size;
	}

	Type* getData(void) {
		return this->data;
	}

	Type& operator[](int index) {
		return data[index];
	}

	StaticArray<Type, Size>& operator=(const StaticArray<Type, Size> &rhs) {
		this->deepCopy(rhs);
		return *this;
	}

	StaticArray<Type, Size>& operator=(const Type data[Size]) {
		memcpy(this->data, data, sizeof(this->data));
		return *this;
	}

	// TODO: fix implementation of operator==
//	bool operator==(const StaticArray<Type, Size> &rhs) const {
//		if (memcmp(this->data, rhs.data, sizeof(data)) == 0) {
//			return true;
//		} else {
//			return false;
//		}
//	}

protected:
	Type data[Size];
	void deepCopy(const StaticArray<Type, Size> &rhs) {
		memcpy(this->data, rhs.data, sizeof(data));
	}

};

} /* namespace etRuntime */
#endif /* STATICARRAY_H_ */

