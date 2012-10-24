/*
 * SubSystemClassBase.h
 *
 * The base class for all SubSystems.
 * It and its derived classes take care of the instantiation, binding (connection) and complete lifecycle of all Actor Classes of a SubSystem
 *
 *  Created on: 31.08.2012
 *      Author: karlitsc
 */

#ifndef SUBSYSTEMCLASSBASE_H_
#define SUBSYSTEMCLASSBASE_H_

#include "common/messaging/RTSystemServicesProtocol.h"
#include "common/messaging/IRTObject.h"
#include "common/debugging/MSCLogger.h"
#include "common/modelbase/TestSemaphore.h"
#include <string>
#include <vector>
#include <iostream>

namespace etRuntime {

class MessageService;
class ActorClassBase;

class SubSystemClassBase: public RTObject, public IEventReceiver {
public:
	SubSystemClassBase(IRTObject* parent, std::string name);
	virtual ~SubSystemClassBase();

	void init();
	virtual void instantiateMessageServices() = 0;
	virtual void instantiateActors() = 0;

	void start();
	void stop();
	void runOnce();

	void destroy();

	MessageService* getMsgService(int idx) const;

	ActorClassBase* getInstance(unsigned int i);
	ActorClassBase* getInstance(std::string path);

	//---------------------------------------------
	// this is to run integration tests
	//---------------------------------------------
	// TODO synchronized
	void setTestSemaphore(TestSemaphore* sem);
	//TODO synchronized
	int getTestErrorCode() const;
	void testFinished(int errorCode);

protected:
	RTSystemServicesProtocolConjPortRepl* m_RTSystemPort;
	//--------------------- interface item IDs
	static const int IFITEM_RTSystemPort = 0;
	std::vector<ActorClassBase*> m_instances;
private:
	TestSemaphore* m_testSem;
	int m_testErrorCode;

	SubSystemClassBase();
	SubSystemClassBase(const SubSystemClassBase& right);
	SubSystemClassBase& operator=(const SubSystemClassBase& right);
};

} /* namespace etRuntime */
#endif /* SUBSYSTEMCLASSBASE_H_ */
