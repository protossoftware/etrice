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

#include "common/debugging/MSCFilter.h"
#include "etStdDatatypes.h"

namespace etRuntime {

MSCFilter::MSCFilter() :
		filterList() {
}

void MSCFilter::addFilter(FilterItem filter) {
	filterList.push_back(filter);
}

etBool MSCFilter::applyTo(const String& text) {
	if (filterList.empty())
		return true; // no filters -> all messages will be logged
	Vector<FilterItem>::iterator it = filterList.begin();
	for (; it != filterList.end(); ++it) {
		if (text.compare((*it).filter) == 0)
			return !(*it).exclude;
	}
	return false;
}

String MSCFilter::reduceString(const String& text) {
//	if (filterList.size() == 1)
//		//TODO: filtering with regular expression
//		// return string.replaceFirst(filterList.front().filter, "");
//		return string;
//	else
		return text;
}

} /* namespace etRuntime */

