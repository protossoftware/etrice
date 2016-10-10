/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef MSCFILTER_H_
#define MSCFILTER_H_

#include "etDatatypes.h"
#include <list>
#include <string>

namespace etRuntime {

class MSCFilter {
public:
	class FilterItem {
	public:
		FilterItem(const std::string& filter_, etBool exclude_) :
				exclude(exclude_),
				filter(filter_) {
		}
		etBool exclude;
		std::string filter;
	private:
		FilterItem();
	};

	MSCFilter();
	virtual ~MSCFilter() {
	}

	void addFilter(FilterItem filter);
	etBool applyTo(const std::string& text);
	std::string reduceString(const std::string& string);

private:
	std::list<FilterItem> filterList;

};

} /* namespace etRuntime */
#endif /* MSCFILTER_H_ */
