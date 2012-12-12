/*
 * MSCFilter.cpp
 *
 *  Created on: 16.08.2012
 *      Author: karlitsc
 */

#include "MSCFilter.h"

namespace etRuntime {

MSCFilter::MSCFilter() :
		filterList() {
}
MSCFilter::~MSCFilter() {
}

void MSCFilter::addFilter(FilterItem filter) {
	filterList.push_back(filter);
}

bool MSCFilter::applyTo(std::string text) {
	if (filterList.empty())
		return true; // no filters -> all messages will be logged
	std::list<FilterItem>::iterator it = filterList.begin();
	for ( ; it != filterList.end(); ++it) {
		if (text.compare((*it).filter) == 0)
			return !(*it).exclude;
	}
	return false;
}

std::string MSCFilter::reduceString(std::string string) {
	if (filterList.size() == 1)
		//TODO: filtering with regular expression
		// return string.replaceFirst(filterList.front().filter, "");
		return string;
	else
		return string;
}

} /* namespace etRuntime */

