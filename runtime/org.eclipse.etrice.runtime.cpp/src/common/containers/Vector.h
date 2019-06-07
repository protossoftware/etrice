/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#ifndef VECTOR_H_
#define VECTOR_H_

#include "etDatatypes.h"
#include <cstring>

namespace etRuntime {

/**
 * common vector base class with counters for allocations and deallocations
 */
class VectorStats {
public:
	static size_t getNAllocations() { return nallocs; }
	static size_t getNDeallocations() { return ndeallocs; }
	static size_t getNCreated() { return ncreated; }
	static size_t getNDestroyed() { return ndestroyed; }

private:
	template<class T> friend class Vector;
	static size_t nallocs;
	static size_t ndeallocs;
	static size_t ncreated;
	static size_t ndestroyed;
};

template<class Type>
class Vector {
public:

	typedef Type* iterator;
	typedef const Type* const_iterator;

	class reverse_iterator {
	public:
		reverse_iterator(Type* d) : _current(d) {}
		reverse_iterator(const reverse_iterator& rhs) : _current(rhs._current) {}

		reverse_iterator& operator=(const reverse_iterator& rhs) {
			_current = rhs._current;
			return *this;
		}

		Type operator*() const {
			Type* tmp = _current;
			return *(--tmp);
		}
		Type* operator->() const {
			return &(operator*());
		}

		reverse_iterator& operator++() {
			--_current;
			return *this;
		}
		reverse_iterator operator++(int) {
			reverse_iterator tmp = *this;
			--_current;
			return tmp;
		}
		reverse_iterator& operator--() {
			++_current;
			return *this;
		}
		reverse_iterator operator--(int) {
			reverse_iterator tmp = *this;
			++_current;
			return tmp;
		}

		bool operator==(const reverse_iterator& rhs) const {
			return _current == rhs._current;
		}
		bool operator!=(const reverse_iterator& rhs) const {
			return !(operator==(rhs));
		}
	private:
		Type* _current;
	};

	/**
	 * default constructor
	 */
	Vector()
	: _size(0)
	, _capacity(0)
	, _data(0)
	{
		++VectorStats::ncreated;
	}

	/**
	 * copy constructor
	 */
	Vector(const Vector<Type> &rhs)
	: _size(rhs._size)
	, _capacity(rhs._size)
	, _data(new Type[rhs._size])
	{
		++VectorStats::ncreated;
		++VectorStats::nallocs;
		for (int i = 0; i < _size; i++) {
			_data[i] = rhs[i];
		}
	}

	/**
	 * initializes each vector element to t
	 */
	Vector(size_t size, const Type& t=Type())
	: _size(size)
	, _capacity(size)
	, _data(new Type[size])
	{
		++VectorStats::ncreated;
		++VectorStats::nallocs;
		for (int i = 0; i < _size; i++) {
			_data[i] = t;
		}
	}

	/**
	 * virtual destructor
	 */
	virtual ~Vector(void) {
		++VectorStats::ndestroyed;
		if (_data) {
			delete[] _data;
			++VectorStats::ndeallocs;
		}
	}

	/**
	 * Requests that the vector capacity be at least enough to contain n elements.
	 *
	 * If n is greater than the current vector capacity, the function causes the container
	 * to reallocate its storage increasing its capacity to n (or greater).
	 * In all other cases, the function call does not cause a reallocation and the vector
	 * capacity is not affected.
	 *
	 * This function has no effect on the vector size and cannot alter its elements.
	 */
	void reserve(size_t n) {
		if (n > _capacity) {
			_capacity = n;
			Type* new_data = new Type[_capacity];
			++VectorStats::nallocs;
			if (_data) {
				for (int i = 0; i < _size; i++) {
					new_data[i] = _data[i];
				}
				delete[] _data;
				++VectorStats::ndeallocs;
			}
			_data = new_data;
		}
	}

	/**
	 * returns the _size of this vector
	 */
	int size(void) const {
		return _size;
	}

	/**
	 *  Returns whether the vector is empty (i.e. whether its size is 0).
	 *  This function does not modify the container in any way.
	 *  To clear the content of a vector, see Vector::clear.
	 */
	bool empty(void) const {
		return _size==0;
	}

	void clear() {
		_size = 0;
		_capacity = 0;
		if (_data) {
			delete[] _data;
			++VectorStats::ndeallocs;
		}
		_data = 0;
	}

	void push_back(const Type& t) {
		if (_size>=_capacity) {
			reserve(_size + const_grow_by);
		}

		_data[_size++] = t;
	}

	void pop_back() {
		if (_size>0) {
			--_size;
		}
	}

	iterator erase (iterator position) {
		if (_size>0 && (position >= _data) && (position < _data+_size)) {
			// copy following elements one position down each
			iterator curr = position;
			iterator next = position + 1;
			for (; next!=end(); ++curr, ++next) {
				*curr = *next;
			}
			--_size;
		}
		return position;
	}

	/**
	 * returns a pointer to the _data of this vector (as a C array)
	 */
	Type* getData(void) {
		return this->_data;
	}

	/**
	 * returns a const pointer to the _data of this vector (as a C array)
	 */
	const Type* getData(void) const {
		return this->_data;
	}

	/**
	 * indexed access without range check
	 */
	Type& operator[](int index) {
		return _data[index];
	}

	/**
	 * indexed access without range check
	 */
	const Type& operator[](int index) const {
		return _data[index];
	}

	Type& front() {
		return _data[0];
	}

	const Type& front() const {
		return _data[0];
	}

	Type& back() {
		return _data[_size-1];
	}

	const Type& back() const {
		return _data[_size-1];
	}

	/**
	 * copy assignment makes a deep copy
	 */
	Vector<Type>& operator=(const Vector<Type> &rhs) {
		if (&rhs!=this) {
			_size = rhs._size;
			if (_size > _capacity) {
				_capacity = _size;
				if (_data) {
					delete[] _data;
					++VectorStats::ndeallocs;
				}
				_data = new Type[_capacity];
				++VectorStats::nallocs;
			}
			for (int i = 0; i < _size; i++) {
				_data[i] = rhs[i];
			}
		}
		return *this;
	}

	/**
	 * comparison operator based on memcmp()
	 */
	bool operator==(const Vector<Type> &rhs) const {
		return _size!=rhs._size ? false : std::memcmp(this->_data, rhs._data, _size*sizeof(*_data)) == 0;
	}
	bool operator!=(const Vector<Type> &rhs) const {
		return !(operator==(rhs));
	}

	const_iterator begin() const {
		return _data;
	}

	const_iterator end() const {
		return _data + _size;
	}

	iterator begin() {
		return _data;
	}

	iterator end() {
		return _data + _size;
	}

	reverse_iterator rbegin() {
		return reverse_iterator(_data + _size);
	}

	reverse_iterator rend() {
		return reverse_iterator(_data);
	}

protected:
	size_t _size;
	size_t _capacity;
	Type* _data;		///< the C array holding the _data

	static const size_t const_grow_by = 4;
};

} /* namespace etRuntime */
#endif /* VECTOR_H_ */

