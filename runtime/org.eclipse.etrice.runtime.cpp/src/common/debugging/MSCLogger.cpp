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

#include "common/debugging/MSCFilter.h"
#include "common/debugging/MSCLogger.h"
#include "debugging/etLogger.h"
#include "etDatatypes.h"
#include <list>
#include <string>

namespace etRuntime {

MSCLogger::MSCLogger() :
		m_commandList(),
		m_filter(0),
		m_path(),
		m_msc_name(),
		m_is_open(false),
		m_objectName() {
	etMutex_construct(&m_mutex);
}

MSCLogger::~MSCLogger() {
	delete m_filter;
	m_filter = 0;
	etMutex_destruct(&m_mutex);
}

void MSCLogger::setMSC(const std::string& msc_name, const std::string& path) {
	m_msc_name = msc_name;
	m_path = path;
	delete m_filter;
	m_filter = new MSCFilter();
}

void MSCLogger::open() {
	etMutex_enter(&m_mutex);
	m_is_open = true;
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageAsyncOut(const std::string& source, const std::string& target, const std::string& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " >-- ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageAsyncIn(const std::string& source, const std::string& target, const std::string& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " --> ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageSyncCall(const std::string& source, const std::string& target, const std::string& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " ==> ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageSyncReturn(const std::string& source, const std::string& target, const std::string& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " <== ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageActorCreate(const std::string& source, const std::string& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (!) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageActorDestroy(const std::string& source, const std::string& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (X) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addNote(const std::string& actor, const std::string& note) {
	etMutex_enter(&m_mutex);
	//if (filter.applyTo(actor))
	getCommandList().push_back("\t" + m_filter->reduceString(actor) + " note: " + note);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageCreate(const std::string& source, const std::string& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (!) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addActorState(const std::string& actor, const std::string& state) {
	etMutex_enter(&m_mutex);
	//if (filter->applyTo(actor))
	getCommandList().push_back("\t" + m_filter->reduceString(actor) + " >>> " + state);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addVisibleComment(const std::string& comment) {
	etMutex_enter(&m_mutex);
	getCommandList().push_back("# " + comment);
	etMutex_leave(&m_mutex);
}

void MSCLogger::createLine(const std::string& source, const std::string& mid, const std::string& target,
		const std::string& message) {
	//if (filter->applyTo(source) && filter->applyTo(target)) {
	getCommandList().push_back(
			"\t" + m_filter->reduceString(source) + mid + m_filter->reduceString(target) + " " + message);
}

void MSCLogger::close() {
	if (m_is_open) {
		std::string path = m_path + m_msc_name + ".seq";
		etFileHandle handle = etLogger_fopen(path.c_str(), "w+");
		etMutex_enter(&m_mutex);
		if (handle != 0) {
			saveMSCforTrace2UML(handle);
			etLogger_fclose(handle);
		}
	}
	m_is_open = false;
	etMutex_leave(&m_mutex);
}

void MSCLogger::saveMSCforTrace2UML(etFileHandle handle) {
	etLogger_fprintf(handle, "; generated MSC for Trace2UML\n");

	std::list<std::string>::iterator it = getCommandList().begin();
	for (; it != getCommandList().end(); ++it){
		etLogger_fprintf(handle, (*it).c_str());
		etLogger_fprintf(handle, "\n");
	}
}

}
