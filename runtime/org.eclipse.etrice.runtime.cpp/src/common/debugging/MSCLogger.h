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
#include "common/containers/String.h"
#include "common/containers/Vector.h"

namespace etRuntime {

class MSCFilter;

class MSCLogger {
public:
	MSCLogger();
	virtual ~MSCLogger();

	void setMSC(const String& msc_name, const String& path);

	/* synchronized */
	void open();
	void addMessageAsyncOut(const String& source, const String& target, const String& message);
	void addMessageAsyncIn(const String& source, const String& target, const String& message);
	void addMessageSyncCall(const String& source, const String& target, const String& message);
	void addMessageSyncReturn(const String& source, const String& target, const String& message);
	void addMessageActorCreate(const String& source, const String& target);
	void addMessageActorDestroy(const String& source, const String& target);
	void addNote(const String& actor, const String& note);
	void addMessageCreate(const String& source, const String& target);
	void addActorState(const String& actor, const String& state);
	void addVisibleComment(const String& comment);
	void close();
	/* --- */

	const String& getObjectName(void) { return m_objectName; }
	void setObjectName(const String& name) { m_objectName = name; }

	Vector<String>& getCommandList() {	return m_commandList; };
	MSCFilter* getMSCFilter(){ return m_filter; };

private:

	void createLine(const String& source, const String& mid, const String& target, const String& message);
	void saveMSCforTrace2UML(etFileHandle handle);

	Vector<String> m_commandList;
	MSCFilter* m_filter;

	String m_path;
	String m_msc_name ;
	etBool m_is_open;

	etMutex m_mutex;

	String m_objectName;

	MSCLogger(const MSCLogger& right);
	MSCLogger& operator=(const MSCLogger& right);


};


} /* namespace etRuntime */
#endif /* MSCLOGGER_H_ */
