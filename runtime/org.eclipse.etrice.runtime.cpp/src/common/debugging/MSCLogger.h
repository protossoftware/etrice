/*
 * MSCLogger.h
 *
 *  Created on: 16.08.2012
 *      Author: karlitsc
 */

#ifndef MSCLOGGER_H_
#define MSCLOGGER_H_

#include <string>
#include <list>
#include <iostream>
#include <fstream>
#include "MSCFilter.h"

namespace etRuntime {

class MSCLogger {
public:
	MSCLogger();
	virtual ~MSCLogger();

	void setMSC(std::string msc_name_, std::string path_);

	//TODO synchronized
	void open() {is_open = true; };
	//TODO synchronized
	void addMessageAsyncOut(std::string source, std::string target, std::string message);
	//TODO synchronized
	void addMessageAsyncIn(std::string source, std::string target, std::string message);
	//TODO synchronized
	void addMessageSyncCall(std::string source, std::string target, std::string message);
	//TODO synchronized
	void addMessageSyncReturn(std::string source, std::string target, std::string message);
	//TODO synchronized
	void addActorState(std::string actor, std::string state);
	//TODO synchronized
	void close();

	std::list<std::string> getCommandList() {	return commandList; };
	MSCFilter* getMSCFilter(){ return filter; };

private:
	void createLine(std::string source, std::string mid, std::string target, std::string message);
	void saveMSCforTrace2UML(std::ofstream& out);

	std::list<std::string> commandList;
	MSCFilter* filter;

	std::string path;
	std::string msc_name ;
	bool is_open;

	MSCLogger(const MSCLogger& right);
	MSCLogger& operator=(const MSCLogger& right);


};


} /* namespace etRuntime */
#endif /* MSCLOGGER_H_ */
