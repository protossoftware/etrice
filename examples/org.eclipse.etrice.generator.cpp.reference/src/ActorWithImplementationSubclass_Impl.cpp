/*
 * ActorWithImplementationSubclassImpl.cpp
 *
 *  Created on: 13.07.2016
 *      Author: tschuetz
 */

#include <ActorWithImplementationSubclass_Impl.h>

ActorWithImplementationSubclass_Impl::ActorWithImplementationSubclass_Impl(
		etRuntime::IRTObject* parent, const std::string& name) :
		ActorWithImplementationSubclass(parent, name) {
}

ActorWithImplementationSubclass_Impl::~ActorWithImplementationSubclass_Impl() {
}

void ActorWithImplementationSubclass_Impl::entry_State1() {
	printf("\n2-entry_State1");
}

void ActorWithImplementationSubclass_Impl::exit_State1() {
	printf("\n3-entry_State1");
}
void ActorWithImplementationSubclass_Impl::entry_State2() {
	printf("\n5-entry_State2");
}
void ActorWithImplementationSubclass_Impl::exit_State2() {
	printf("\n7-exit_State2 - should never happen");

}

void ActorWithImplementationSubclass_Impl::do_State2() {
	printf("\n6-do_State2");

}

/* Action Codes */
void ActorWithImplementationSubclass_Impl::action_TRANS_INITIAL_TO__State1() {
	printf("\n1-Initial");
}
void ActorWithImplementationSubclass_Impl::action_TRANS_tr0_FROM_State1_TO_State2_GUARD_tr0() {
	printf("\n4-action_State1_to_State2");
}

