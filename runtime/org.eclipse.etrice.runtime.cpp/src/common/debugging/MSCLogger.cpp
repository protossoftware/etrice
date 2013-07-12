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

#include "MSCLogger.h"

namespace etRuntime {

MSCLogger::MSCLogger()
: commandList(),
  filter(0),
  path(),
  msc_name(),
is_open(false)
{
}

MSCLogger::~MSCLogger() {
	delete filter;
	filter = 0;
}

void MSCLogger::setMSC(const std::string& msc_name_, const std::string& path_) {
	msc_name = msc_name_;
	path = path_;
	delete filter;
	filter = new MSCFilter();
}

void MSCLogger::addMessageAsyncOut(const std::string& source, const std::string& target,
		const std::string& message) {
	createLine(source, " >-- ", target, message);
}

void MSCLogger::addMessageAsyncIn(const std::string& source, const std::string& target,
		const std::string& message) {
	createLine(source, " --> ", target, message);
}

void MSCLogger::addMessageSyncCall(const std::string& source, const std::string& target,
		const std::string& message) {
	createLine(source, " ==> ", target, message);
}

void MSCLogger::addMessageSyncReturn(const std::string& source, const std::string& target,
		const std::string& message) {
	createLine(source, " <== ", target, message);
}

void MSCLogger::addActorState(const std::string& actor, const std::string& state) {
	if (filter->applyTo(actor))
		commandList.push_back("\t" + filter->reduceString(actor) + " >>> " + state);
}

void MSCLogger::createLine(const std::string& source, const std::string& mid, const std::string& target, const std::string& message) {
	if (filter->applyTo(source) && filter->applyTo(target)) {
		commandList.push_back( "\t"+filter->reduceString(source)+mid+filter->reduceString(target)+ " " + message);
	}
}

void MSCLogger::close() {
	if (is_open) {
//		try {
		//TODO: error handling
			// Create file
			std::ofstream myfile;
			//TODO: where to create the file
			// std::string dir = "tmp/log"; doesn't work on windows
			std::string dir = "";
			myfile.open (std::string(dir + path + msc_name + ".seq").c_str(), std::ios::out);
			if (myfile.is_open()) { /* ok, proceed with output */
				saveMSCforTrace2UML(myfile);
				myfile.close();
			}
//		};
	}
	is_open = false;
}

void MSCLogger::saveMSCforTrace2UML(std::ofstream& out) {
	//try {
	//TODO: errorhandling
		out << "#generated MSC for Trace2UML";
		out << std::endl ;
		std::list<std::string>::iterator it = commandList.begin();
		for ( ; it != commandList.end(); ++it) {
			out << (*it) << std::endl;
		}
//	} catch (IOException e) {
//		System.err.println("Error: " + e.getMessage());
//	}

}


}
