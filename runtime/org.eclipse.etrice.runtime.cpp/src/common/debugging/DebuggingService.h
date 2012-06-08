/*
 * DebuggingService.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef DEBUGGINGSERVICE_H_
#define DEBUGGINGSERVICE_H_

#include "common/messaging/Address.h"

namespace etRuntime {

class MSCLogger;
class ActorClassBase;
class PortBase;

class DebuggingService {
private:
	static DebuggingService* s_instance;

public:
	virtual ~DebuggingService();

	static DebuggingService& getInstance() {
		if (s_instance == 0) {
			s_instance = new DebuggingService();
		}
		return *s_instance;
	}

	void addMessageAsyncOut(Address source, Address target, const char * msg);
	void addMessageAsyncIn(Address source, Address target, const char * msg);
	void addMessageSyncCall(Address source, Address target, const char * msg);
	void addMessageSyncReturn(Address source, Address target, const char * msg);
	void addActorState(const ActorClassBase& actor, const char * state);
	void addPortInstance(const PortBase& port);
	MSCLogger getSyncLogger();
	MSCLogger getAsyncLogger();

private:
	DebuggingService();
	DebuggingService(const DebuggingService& right);
	DebuggingService& operator=(const DebuggingService& right);

};

} /* namespace etRuntime */
#endif /* DEBUGGINGSERVICE_H_ */





