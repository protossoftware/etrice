/*
 * MSCFilter.h
 *
 *  Created on: 16.08.2012
 *      Author: karlitsc
 */

#ifndef MSCFILTER_H_
#define MSCFILTER_H_

#include <list>
#include <string>

namespace etRuntime {

class MSCFilter {
public:
	class FilterItem{
	public:
		FilterItem(std::string filter_, bool exclude_)
		: exclude(exclude_),
		  filter(filter_)
		{};
		bool exclude;
		std::string filter;
	private:
		FilterItem();
	};

	MSCFilter();
	virtual ~MSCFilter();

	void addFilter(FilterItem filter);
	bool applyTo(std::string text);
	std::string reduceString(std::string string);

private:
	std::list<FilterItem> filterList;

};

} /* namespace etRuntime */
#endif /* MSCFILTER_H_ */
