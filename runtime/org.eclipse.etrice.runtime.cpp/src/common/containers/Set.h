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

#ifndef SET_H_
#define SET_H_

#include "etDatatypes.h"
#include "Vector.h"

namespace etRuntime {

/**
 * common set base class with counters for allocations and deallocations
 */
class SetStats {
public:
	static size_t getNCreated() { return ncreated; }
	static size_t getNDestroyed() { return ndestroyed; }

private:
	template<class T> friend class Set;
	static size_t ncreated;
	static size_t ndestroyed;
};

template<class Type>
class Set {
public:

	typedef typename Vector<Type>::iterator iterator;
	typedef typename Vector<Type>::const_iterator const_iterator;
	typedef typename Vector<Type>::reverse_iterator reverse_iterator;

	/**
	 * default constructor
	 */
	Set()
	: _container()
	{
		++SetStats::ncreated;
	}

	/**
	 * copy constructor
	 */
	Set(const Set<Type> &rhs)
	: _container(rhs._container)
	{
		++SetStats::ncreated;
	}

	/**
	 * virtual destructor
	 */
	virtual ~Set(void) {
		++SetStats::ndestroyed;
	}

	/**
	 * Requests that the set capacity be at least enough to contain n elements.
	 *
	 * If n is greater than the current set capacity, the function causes the container
	 * to reallocate its storage increasing its capacity to n (or greater).
	 * In all other cases, the function call does not cause a reallocation and the set
	 * capacity is not affected.
	 *
	 * This function has no effect on the set size and cannot alter its elements.
	 */
	void reserve(size_t n) {
		_container.reserve(n);
	}

	/**
	 * returns the _size of this set
	 */
	int size(void) const {
		return _container.size();
	}

	/**
	 *  Returns whether the set is empty (i.e. whether its size is 0).
	 *  This function does not modify the container in any way.
	 *  To clear the content of a set, see Set::clear.
	 */
	bool empty(void) const {
		return _container.empty();
	}

	void clear() {
		_container.clear();
	}

	bool insert(const Type& t) {
		iterator it = find(t);
		if (it==end()) {
			_container.push_back(t);
			return true;
		}
		else {
			return false;
		}
	}

	iterator find(const Type& t) {
		for (iterator it=begin(); it!=end(); ++it) {
			if (t==*it) {
				return it;
			}
		}
		return end();
	}

	const_iterator find(const Type& t) const {
		for (const_iterator it=begin(); it!=end(); ++it) {
			if (t==*it) {
				return it;
			}
		}
		return end();
	}

	iterator erase(iterator position) {
		return _container.erase(position);
	}

	size_t erase(const Type& t) {
		iterator it = find(t);
		if (it==end()) {
			return 0;
		}
		else {
			_container.erase(it);
			return 1;
		}
	}

	/**
	 * returns a pointer to the _data of this set (as a C array)
	 */
	Type* getData(void) {
		return _container.getData();
	}

	/**
	 * returns a const pointer to the _data of this set (as a C array)
	 */
	const Type* getData(void) const {
		return _container.getData();
	}

	/**
	 * copy assignment makes a deep copy
	 */
	Set<Type>& operator=(const Set<Type> &rhs) {
		_container = rhs._container;
		return *this;
	}

	const_iterator begin() const {
		return _container.begin();
	}

	const_iterator end() const {
		return _container.end();
	}

	iterator begin() {
		return _container.begin();
	}

	iterator end() {
		return _container.end();
	}

	reverse_iterator rbegin() {
		return _container.rbegin();
	}

	reverse_iterator rend() {
		return _container.rend();
	}

protected:
	Vector<Type> _container;
};

/**
 * comparison operator (expensive because not ordered - O(n^2))
 */
template<class Type>
inline bool operator==(const Set<Type> lhs, const Set<Type> rhs) {
	if (rhs.size()!=lhs.size()) {
		return false;
	}

	// are all elements contained in rhs?
	for (typename Set<Type>::const_iterator it=lhs.begin(); it!=lhs.end(); ++it) {
		if (rhs.find(*it)==rhs.end()) {
			return false;
		}
	}

	return true;
}

template<class Type>
inline bool operator!=(const Set<Type> &lhs, const Set<Type> &rhs) {
	return !(lhs==rhs);
}

} /* namespace etRuntime */
#endif /* SET_H_ */

