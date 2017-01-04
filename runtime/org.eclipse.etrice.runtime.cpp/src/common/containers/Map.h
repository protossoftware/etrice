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

#ifndef MAP_H_
#define MAP_H_

#include "etDatatypes.h"
#include "Pair.h"
#include "Vector.h"

namespace etRuntime {

/**
 * common map base class with counters for creations and destructions
 */
class MapStats {
public:
	static size_t getNCreated() { return ncreated; }
	static size_t getNDestroyed() { return ndestroyed; }

private:
	template<class K, class V> friend class Map;
	static size_t ncreated;
	static size_t ndestroyed;
};

template<class Key, class Value>
class Map {
public:

	typedef Pair<Key, Value> Entry;
	typedef typename Vector<Entry>::iterator iterator;
	typedef typename Vector<Entry>::const_iterator const_iterator;
	typedef typename Vector<Entry>::reverse_iterator reverse_iterator;

	/**
	 * default constructor
	 */
	Map()
	: _container()
	{
		++MapStats::ncreated;
	}

	/**
	 * copy constructor
	 */
	Map(const Map<Key, Value> &rhs)
	: _container(rhs._container)
	{
		++MapStats::ncreated;
	}

	/**
	 * virtual destructor
	 */
	virtual ~Map(void) {
		++MapStats::ndestroyed;
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
	 *  To clear the content of a set, see Map::clear.
	 */
	bool empty(void) const {
		return _container.empty();
	}

	void clear() {
		_container.clear();
	}

	Value& operator[](const Key& key) {
		for (iterator it=begin(); it!=end(); ++it) {
			if (key==it->first) {
				return it->second;
			}
		}

		_container.push_back(Entry(key, Value()));
		return _container.back().second;
	}

	iterator find(const Key& key) {
		for (iterator it=begin(); it!=end(); ++it) {
			if (key==(*it).first) {
				return it;
			}
		}
		return end();
	}

	const_iterator find(const Key& key) const {
		for (const_iterator it=begin(); it!=end(); ++it) {
			if (key==(*it).first) {
				return it;
			}
		}
		return end();
	}

	iterator erase(iterator position) {
		return _container.erase(position);
	}

	size_t erase(const Key& key) {
		iterator it = find(key);
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
	Entry* getData(void) {
		return _container.getData();
	}

	/**
	 * returns a const pointer to the _data of this set (as a C array)
	 */
	const Entry* getData(void) const {
		return _container.getData();
	}

	/**
	 * copy assignment makes a deep copy
	 */
	Map<Key, Value>& operator=(const Map<Key, Value> &rhs) {
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
	Vector<Entry> _container;
};

/**
 * comparison operator (expensive because not ordered - O(n^2))
 */
template<class Key, class Value>
inline bool operator==(const Map<Key, Value> lhs, const Map<Key, Value> rhs) {
	if (rhs.size()!=lhs.size()) {
		return false;
	}

	// are all elements contained in rhs?
	for (typename Map<Key, Value>::const_iterator it=lhs.begin(); it!=lhs.end(); ++it) {
		// find key
		typename Map<Key, Value>::const_iterator rit = rhs.find(it->first);
		if (rit==rhs.end()) {
			return false;
		}
		else {
			// compare value
			if (rit->second!=it->second) {
				return false;
			}
		}
	}

	return true;
}

template<class Key, class Value>
inline bool operator!=(const Map<Key, Value> &lhs, const Map<Key, Value> &rhs) {
	return !(lhs==rhs);
}

} /* namespace etRuntime */
#endif /* MAP_H_ */

