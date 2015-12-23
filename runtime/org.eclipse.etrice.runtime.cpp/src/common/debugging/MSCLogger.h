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

#include "osal/etMutex.h"
#include <iostream>
#include <list>
#include <string>

namespace etRuntime {

class MSCFilter;

class MSCLogger {
public:
	MSCLogger();
	virtual ~MSCLogger();

	void setMSC(const std::string& msc_name, const std::string& path);

	/* synchronized */
	void open();
	void addMessageAsyncOut(const std::string& source, const std::string& target, const std::string& message);
	void addMessageAsyncIn(const std::string& source, const std::string& target, const std::string& message);
	void addMessageSyncCall(const std::string& source, const std::string& target, const std::string& message);
	void addMessageSyncReturn(const std::string& source, const std::string& target, const std::string& message);
	void addMessageActorCreate(const std::string& source, const std::string& target);
	void addMessageActorDestroy(const std::string& source, const std::string& target);
	void addNote(const std::string& actor, const std::string& note);
	void addMessageCreate(const std::string& source, const std::string& target);
	void addActorState(const std::string& actor, const std::string& state);
	void addVisibleComment(const std::string& comment);
	void close();
	/* --- */

	std::list<std::string>& getCommandList() {	return m_commandList; };
	MSCFilter* getMSCFilter(){ return m_filter; };

private:

	void createLine(const std::string& source, const std::string& mid, const std::string& target, const std::string& message);
	void saveMSCforTrace2UML(etFileHandle handle);

	std::list<std::string> m_commandList;
	MSCFilter* m_filter;

	std::string m_path;
	std::string m_msc_name ;
	etBool m_is_open;

	etMutex m_mutex;

	MSCLogger(const MSCLogger& right);
	MSCLogger& operator=(const MSCLogger& right);


};


} /* namespace etRuntime */
#endif /* MSCLOGGER_H_ */
