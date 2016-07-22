/*
 * ActorWithImplementationSubclassImpl.h
 *
 *  Created on: 13.07.2016
 *      Author: tschuetz
 */

#ifndef ACTORWITHIMPLEMENTATIONSUBCLASS_IMPL_H_
#define ACTORWITHIMPLEMENTATIONSUBCLASS_IMPL_H_

#include <ReferenceCPP_ActorClasses/ActorWithImplementationSubclass.h>

class ActorWithImplementationSubclass_Impl: public ActorWithImplementationSubclass {
public:
	ActorWithImplementationSubclass_Impl(etRuntime::IRTObject* parent, const std::string& name);

	virtual ~ActorWithImplementationSubclass_Impl();

	// Overrides
	/* Entry and Exit Codes */
	virtual void entry_State1();
	virtual void exit_State1();
	virtual void entry_State2();
	virtual void exit_State2();
	virtual void do_State2();

	/* Action Codes */
	virtual void action_TRANS_INITIAL_TO__State1();
	virtual void action_TRANS_tr0_FROM_State1_TO_State2_GUARD_tr0();

};

#endif /* ACTORWITHIMPLEMENTATIONSUBCLASS_IMPL_H_ */
