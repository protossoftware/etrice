/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef ADDRESS_H_
#define ADDRESS_H_

#include "etDatatypes.h"
#include "common/containers/String.h"

namespace etRuntime {

class Address {
public:

	static const Address EMPTY;

	Address();
	Address(int nodeID, int threadID, int objectID);
	Address(const Address& right);
	~Address();

	Address& operator =(const Address& right);
	bool operator==(const Address& other) const;
	bool operator!=(const Address& other) const;
	bool operator< (const Address& right) const;

	String toString() const;
	String toID() const;

	Address createInc() const;

	inline etBool isValid() const {
		return *this != EMPTY;
	}

	int m_nodeID;
	int m_threadID;
	int m_objectID;

private:

};

} /* namespace etRuntime */
#endif /* ADDRESS_H_ */

