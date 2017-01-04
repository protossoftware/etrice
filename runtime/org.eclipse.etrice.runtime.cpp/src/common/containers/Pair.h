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

#ifndef PAIR_H_
#define PAIR_H_

#include "etDatatypes.h"

namespace etRuntime {


template<class T1, class T2>
struct Pair {
	Pair()
	: first(), second()
	{ }
	Pair(const T1& f, const T2& s)
	: first(f), second(s)
	{ }

	// copy constructor
	// works if T1==U1 and T1==U2 or implicit conversions T1(U1) and T2(U2) exist
	template<class U1, class U2>
	Pair(const Pair<U1, U2>& p)
	: first(p.first)
	, second(p.second)
	{
	}

	T1 first;
	T2 second;
};

/**
 * two pairs of the same pair of types are equal iff their members are equal.
 */
template<class T1, class T2>
inline bool operator==(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return lhs.first == rhs.first && lhs.second == rhs.second;
}

// uses operator==
template<class T1, class T2>
inline bool operator!=(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return !(lhs==rhs);
}

// see http://www.cplusplus.com/reference/utility/pair/operators/
template<class T1, class T2>
inline bool operator<(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return lhs.first < rhs.first
			|| (!(rhs.first < lhs.first) && lhs.second < rhs.second);
}

// uses operator<
template<class T1, class T2>
inline bool operator>(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return rhs < lhs;
}

// uses operator<
template<class T1, class T2>
inline bool operator<=(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return !(rhs < lhs);
}

// uses operator<
template<class T1, class T2>
inline bool operator>=(const Pair<T1, T2>& lhs, const Pair<T1, T2>& rhs) {
	return !(lhs < rhs);
}

} /* namespace etRuntime */
#endif /* PAIR_H_ */

