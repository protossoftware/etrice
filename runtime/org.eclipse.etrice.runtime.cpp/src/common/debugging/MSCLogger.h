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

	void setMSC(const std::string& msc_name_, const std::string& path_);

	//TODO synchronized
	void open() {is_open = true; };
	//TODO synchronized
	void addMessageAsyncOut(const std::string& source, const std::string& target, const std::string& message);
	//TODO synchronized
	void addMessageAsyncIn(const std::string& source, const std::string& target, const std::string& message);
	//TODO synchronized
	void addMessageSyncCall(const std::string& source, const std::string& target, const std::string& message);
	//TODO synchronized
	void addMessageSyncReturn(const std::string& source, const std::string& target, const std::string& message);
	//TODO synchronized
	void addActorState(const std::string& actor, const std::string& state);
	//TODO synchronized
	void close();

	const std::list<std::string>& getCommandList() {	return commandList; };
	MSCFilter* getMSCFilter(){ return filter; };

private:
	void createLine(const std::string& source, const std::string& mid, const std::string& target, const std::string& message);
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
