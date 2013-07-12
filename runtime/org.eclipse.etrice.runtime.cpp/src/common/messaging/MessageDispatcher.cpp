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

#include "MessageDispatcher.h"

namespace etRuntime {


MessageDispatcher::~MessageDispatcher() {
}

MessageDispatcher::MessageDispatcher(IRTObject* parent, Address addr, std::string name)
: RTObject(parent, name) ,
  IMessageReceiver(),
  m_local_map(),
  m_thread_map(),
  m_node_map(),
  m_address(addr)
{};

void MessageDispatcher::addMessageReceiver(IMessageReceiver& receiver){
if (! receiver.getAddress().isValid() )
	return;

// TODO: does only work same thread (else)
if (receiver.getAddress().m_nodeID != m_address.m_nodeID){
	m_node_map[receiver.getAddress().m_objectID] = &receiver;
}
else if(receiver.getAddress().m_threadID != m_address.m_threadID){
	m_thread_map[receiver.getAddress().m_threadID] = &receiver;
}
else {
	m_local_map[receiver.getAddress().m_objectID] = &receiver;
}
};

void MessageDispatcher::receive(Message* msg) {
// TODO: does only work same thread (else)
	//TODO: assert msg != 0
IMessageReceiver* receiver = 0;
std::map<int, IMessageReceiver*>::iterator it;
if (msg->getAddress().m_nodeID != m_address.m_nodeID){
	it = m_node_map.find(msg->getAddress().m_objectID);
	if (it != m_node_map.end() ) {
		receiver = (*it).second;
	}
}
else if(msg->getAddress().m_threadID != m_address.m_threadID){
	it = m_thread_map.find(msg->getAddress().m_objectID);
	if (it != m_thread_map.end() ) {
		receiver = (*it).second;
	}
}
else {
	// Same node, same thread -> local call Dispatch Map
	it = m_local_map.find(msg->getAddress().m_objectID);
	if (it != m_local_map.end() ) {
		receiver = (*it).second;
	}
}
if (receiver!=0)
{
	receiver->receive(msg);
	// TODO: error handling for not found addresses
}
}

} /* namespace etRuntime */

