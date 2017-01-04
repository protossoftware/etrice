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
#include "common/containers/String.h"
#include "common/containers/Vector.h"

namespace etRuntime {

class MSCFilter {
public:
	class FilterItem {
	public:
		FilterItem(const String& filter_, etBool exclude_)
		: exclude(exclude_)
		, filter(filter_)
		{
		}
		FilterItem()
		: exclude()
		, filter()
		{
		}
		etBool exclude;
		String filter;
	};

	MSCFilter();
	virtual ~MSCFilter() {
	}

	void addFilter(FilterItem filter);
	etBool applyTo(const String& text);
	String reduceString(const String& text);

private:
	Vector<FilterItem> filterList;

};

} /* namespace etRuntime */
#endif /* MSCFILTER_H_ */
