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
	if(m_filter != NULL)
		delete m_filter;
	m_filter = 0;
	etMutex_destruct(&m_mutex);
}

void MSCLogger::setMSC(const String& msc_name, const String& path) {
	m_msc_name = msc_name;
	m_path = path;
	if(m_filter != NULL)
		delete m_filter;
	m_filter = new MSCFilter();
}

void MSCLogger::open() {
	etMutex_enter(&m_mutex);
	m_is_open = true;
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageAsyncOut(const String& source, const String& target, const String& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " >-- ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageAsyncIn(const String& source, const String& target, const String& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " --> ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageSyncCall(const String& source, const String& target, const String& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " ==> ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageSyncReturn(const String& source, const String& target, const String& message) {
	etMutex_enter(&m_mutex);
	createLine(source, " <== ", target, message);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageActorCreate(const String& source, const String& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (!) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageActorDestroy(const String& source, const String& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (X) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addNote(const String& actor, const String& note) {
	etMutex_enter(&m_mutex);
	//if (filter.applyTo(actor))
	String reduced = m_filter->reduceString(actor.c_str());
	getCommandList().push_back("\t" + reduced + " note: " + note);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addMessageCreate(const String& source, const String& target) {
	etMutex_enter(&m_mutex);
	createLine(source, " (!) ", target, "");
	etMutex_leave(&m_mutex);
}

void MSCLogger::addActorState(const String& actor, const String& state) {
	etMutex_enter(&m_mutex);
	//if (filter->applyTo(actor))
	String reduced = m_filter->reduceString(actor.c_str());
	getCommandList().push_back("\t" + reduced + " >>> " + state);
	etMutex_leave(&m_mutex);
}

void MSCLogger::addVisibleComment(const String& comment) {
	etMutex_enter(&m_mutex);
	getCommandList().push_back("# " + comment);
	etMutex_leave(&m_mutex);
}

void MSCLogger::createLine(const String& source, const String& mid, const String& target,
		const String& message) {
	//if (filter->applyTo(source) && filter->applyTo(target)) {
	String reduced_src = m_filter->reduceString(source.c_str());
	String reduced_tgt = m_filter->reduceString(target.c_str());
	getCommandList().push_back(
			"\t" + reduced_src + mid + reduced_tgt + " " + message);
}

void MSCLogger::close() {
	if (m_is_open) {
		String path = m_path + m_msc_name + ".seq";
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

	Vector<String>::iterator it = getCommandList().begin();
	for (; it != getCommandList().end(); ++it){
		etLogger_fprintf(handle, (*it).c_str());
		etLogger_fprintf(handle, "\n");
	}
}

}
