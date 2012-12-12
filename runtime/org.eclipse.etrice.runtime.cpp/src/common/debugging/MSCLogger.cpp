/*
 * MSCLogger.cpp
 *
 *  Created on: 16.08.2012
 *      Author: karlitsc
 */

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

void MSCLogger::setMSC(std::string msc_name_, std::string path_) {
	msc_name = msc_name_;
	path = path_;
	delete filter;
	filter = new MSCFilter();
}

void MSCLogger::addMessageAsyncOut(std::string source, std::string target,
		std::string message) {
	createLine(source, " >-- ", target, message);
}

void MSCLogger::addMessageAsyncIn(std::string source, std::string target,
		std::string message) {
	createLine(source, " --> ", target, message);
}

void MSCLogger::addMessageSyncCall(std::string source, std::string target,
		std::string message) {
	createLine(source, " ==> ", target, message);
}

void MSCLogger::addMessageSyncReturn(std::string source, std::string target,
		std::string message) {
	createLine(source, " <== ", target, message);
}

void MSCLogger::addActorState(std::string actor, std::string state) {
	if (filter->applyTo(actor))
		commandList.push_back("\t" + filter->reduceString(actor) + " >>> " + state);
}

void MSCLogger::createLine(std::string source, std::string mid, std::string target, std::string message) {
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
