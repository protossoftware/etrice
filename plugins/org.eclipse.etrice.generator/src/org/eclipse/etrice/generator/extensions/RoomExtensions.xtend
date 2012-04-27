/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/

package org.eclipse.etrice.generator.extensions

import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.File
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.SimpleState
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.etrice.core.room.InitialTransition
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageHandler
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RefinedState
import org.eclipse.etrice.core.room.SAPRef
import org.eclipse.etrice.core.room.ServiceImplementation
import org.eclipse.etrice.core.room.State
import org.eclipse.etrice.core.room.StateGraph
import org.eclipse.etrice.core.room.Transition
import org.eclipse.etrice.core.room.Trigger
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.etricegen.ActiveTrigger
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.TransitionChain

import static extension org.eclipse.etrice.generator.extensions.RoomNameProv.*

@Singleton
class RoomExtensions {

	// for the time being we need a delegate to the static methods of the RoomNameProvider
	@Inject extension RoomNameProv nameProvider

	//-------------------------------------------------------
	// union methods
	
	def <T> List<T> union(List<T> l1, List<T> l2) {
		var ret = new ArrayList<T>()
		ret.addAll(l1)
		ret.addAll(l2)
		return ret
	}
    
	def List<Port> punion(List<Port> in1, List<ExternalPort> in2){
		var ret=new ArrayList<Port>();
		for(ele : in2){
			ret.add(ele.ifport)
		}
		ret.addAll(in1)
		return ret
	}
	
	//-------------------------------------------------------
	// path related methods
	
	def String getGenerationPathSegment() {
		return "/src-gen/"
	}

	def String getModelPath(EObject e) {
		var res = e.eResource;
		if (res==null) {
			return ""
		}
		else {
			return res.URI.toFileString
		}
	}


	//-------------------------------------------------------
	// packages and pathes
	
	def String getPackage(RoomClass rc) {
		return (rc.eContainer as RoomModel).name
	}
	
	def String getPathFromPackage(String packageName) {
		return packageName.replaceAll("\\.", "/") + "/"
	}
	
	def String getPath(RoomClass rc) {
		getPathFromPackage(getPackage(rc))
	}
	
	// a directory is a eclipse project if it contains a ".project" file
	def String getProjectPath(EObject e) {
		var res = e.eResource;
		if (res==null) {
			return ""
		}
		else {
			var tmpf = new File("")
			tmpf = new File(res.URI.toFileString)
			if (!tmpf.file)
				return ""
			var isProject = false;
			do {
				tmpf = tmpf.parentFile
				var contents = tmpf.list
				for (f : contents)
					if (f.equals(".project")) {
						isProject = true
					}
			}
			while (!isProject && tmpf.parentFile!=null)
			
			return tmpf.absolutePath
		}
	}
	
	def String getGenerationTargetPath(EObject e){
		return getProjectPath(e)+getGenerationPathSegment();
	}

	def List<Port> getEndPorts(ActorClass ac) {
		ac.intPorts.punion(ac.extPorts)
	}
	
	// make a valid identifier from a path string
	def String getPathName(String path){
		path.replaceAll("/","_");
	}

	//-------------------------------------------------------
	// protocol related methods
	
	def String getPortClassName(ProtocolClass p, boolean conj) {
		var ret=p.name
		if(conj) {
			ret=ret+"ConjPort"
		}else{
			ret=ret+"Port"
		}
		return ret
	}

	def String getPortClassName(Port p){
		var ret=p.protocol.getPortClassName(p.conjugated)
		if (p.replicated){
			ret = ret+"Repl"
		}
		return ret
	}

	def String getPortClassName(ExternalPort p){
		return p.ifport.getPortClassName()
	}

	def String getPortClassName(SAPRef sap) {
		return sap.protocol.getPortClassName(true)
	}

	def String getPortClassName(ServiceImplementation svc) {
		return svc.spp.protocol.getPortClassName(false)+"Repl"
	}
	// message lists with super class messages, super classes first
	def List<Message> getAllIncomingMessages(ProtocolClass pc) {
		if (pc.base!=null)
			return pc.base.getAllIncomingMessages().union(pc.incomingMessages)
		else
			return pc.incomingMessages
	}
	
	def List<Message> getAllOutgoingMessages(ProtocolClass pc) {
		if (pc.base!=null)
			return pc.base.getAllOutgoingMessages().union(pc.outgoingMessages)
		else
			pc.outgoingMessages
	}
		
	def List<Message> getIncoming(ProtocolClass pc, boolean conj) {
		if (conj)
			return pc.getAllOutgoingMessages()
		else
			return pc.getAllIncomingMessages()
	}

	def List<Message> getOutgoing(ProtocolClass pc, boolean conj) {
		if (conj)
			return pc.getAllIncomingMessages()
		else
			return pc.getAllOutgoingMessages()
	}
	
	def PortClass getPortClass(ProtocolClass pc, boolean conj) {
		if (conj)
			return pc.conjugate
		else
			return pc.regular
	}
	
	def boolean handlesSend(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)==null)
			return false
		else {
			for (hdlr : pc.getPortClass(conj).msgHandlers)
				if (pc.getOutgoing(conj).contains(hdlr.msg))
					return true;
		}
		return false;
	}
	
	def boolean handlesReceive(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)==null)
			return false
		else {
			for (hdlr : pc.getPortClass(conj).msgHandlers)
				if (pc.getIncoming(conj).contains(hdlr.msg))
					return true;
		}
		return false;
	}

	def List<MessageHandler> getReceiveHandlers(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)==null)
			return new ArrayList<MessageHandler>()
		else {
			var res = new ArrayList<MessageHandler>()
			for (hdlr : pc.getPortClass(conj).msgHandlers) {
				if (pc.getIncoming(conj).contains(hdlr.msg))
					res.add(hdlr)
			}
			return res
		}
	}

	def List<MessageHandler> getSendHandlers(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)==null)
			return new ArrayList<MessageHandler>()
		else {
			var res = new ArrayList<MessageHandler>()
			for (hdlr : pc.getPortClass(conj).msgHandlers) {
				if (pc.getOutgoing(conj).contains(hdlr.msg))
					res.add(hdlr)
			}
			return res
		}
	}
	
	def MessageHandler getSendHandler(Message m, boolean conj) {
		return (m.eContainer as ProtocolClass).getSendHandlers(conj).findFirst(e|e.msg==m)
	}
	
	def boolean isIncoming(Message m) {
		return (m.eContainer as ProtocolClass).allIncomingMessages.contains(m)
	}
	
	def String getCodeName(Message m) {
		if (m.isIncoming())
			return "IN_"+m.name
		else
			return "OUT_"+m.name
	}

	//-------------------------------------------------------
	// state graph related methods
	
	// state lists
	def boolean isLeaf(State s){
		s.subgraph==null
	}

	def List<State> getLeafStateList(StateGraph sg) {
		var ArrayList<State> res = new ArrayList<State>()
		for (s : sg.states) {
			res.addAll(s.leafStateList)
		}
		return res
	}
	
	def List<State> getLeafStateList(State s) {
		if (s.isLeaf()) {
			var res = new ArrayList<State>()
			res.add(s)
			return res
		}
		else
			return s.subgraph.getLeafStateList()
	}

	def List<State> getStateList(StateGraph sg){
		var ret = new ArrayList<State>()
		for (e : sg.states){
			ret.add(e)
			var tmp=e.subgraph
			if(tmp!=null){
				ret.addAll(e.subgraph.stateList)
			}
		}
		return ret
	}

	def List<State> getBaseStateList(StateGraph sg) {
		var ret = new ArrayList<State>()
		for(e : sg.getStateList()){
			if(e instanceof SimpleState){
				ret.add(e)
			}
		}
		return ret
	}

	def List<State> getAllBaseStates(ActorClass ac) {
		if (ac.base==null)
			return ac.stateMachine.getBaseStateList()
		else
			ac.base.getAllBaseStates().union(ac.stateMachine.getBaseStateList())
	}

	def boolean overridesStop(ActorClass ac) {
		return ac.operations.exists(e|e.name=="stop"&&e.arguments.isEmpty&&e.returntype==null)
			|| (ac.base!=null && ac.base.overridesStop())
	}

	def int getNumberOfInheritedStates(ActorClass ac) {
		if (ac.base==null)
			return 0
		else
			return ac.base.stateMachine.getStateList().size+ac.base.getNumberOfInheritedStates()
	}
	
	def int getNumberOfInheritedBaseStates(ActorClass ac) {
		if (ac.base==null)
			return 0
		else
			return ac.base.stateMachine.getBaseStateList().size+ac.base.getNumberOfInheritedBaseStates()
	}

	def String getStateId(State s) {
		return getGenStateId(s)
	}

	def String getStatePathName(State s) {
		return getGenStatePathName(s);
	}
	
	def String getChainId(TransitionChain t) {
		return getGenChainId(t)
	}
	
	def boolean hasGuard(Trigger tr) {
		return tr.guard!=null && tr.guard.guard!=null && tr.guard.guard.commands.size>0
	}
	
	def boolean hasGuard(ExpandedActorClass ac, ActiveTrigger at) {
		var hasGuard = false
		for (t : at.transitions) {
			if (t.triggers.exists(e|ac.isMatching(e, at.trigger) && e.hasGuard()))
				hasGuard = true
		}
		return hasGuard
	}
	
	def boolean hasEntryCode(State s) {
		return s.entryCode!=null && s.entryCode.commands.size>0
	}

	def boolean hasExitCode(State s) {
		return s.exitCode!=null && s.exitCode.commands.size>0
	}

	def String getEntryCode(ExpandedActorClass ac, State s) {
		if (s instanceof RefinedState)
			return "super."+s.getEntryCodeOperationName()+"();\n"+ac.getCode(s.entryCode)
		else
			return ac.getCode(s.entryCode)
	}

	def String getExitCode(ExpandedActorClass ac, State s) {
		if (s instanceof RefinedState)
			return ac.getCode(s.exitCode)+"super."+s.getEntryCodeOperationName()+"();\n"
		else
			ac.getCode(s.exitCode)
	}
	
	def boolean hasActionCode(Transition t) {
		return t.action!=null && t.action.commands.size>0
	}
	def String getActionCode(ExpandedActorClass ac, Transition t) {
		return ac.getCode(t.action)
	}
	
	def String getContextId(TransitionChain tc) {
		return tc.getStateContext().getStateId()
	}
	
	def Transition getInitTransition(StateGraph sg) {
		for (tr : sg.transitions) {
			if (tr instanceof InitialTransition)
				return tr
		}
		return null
	}
	
	def boolean hasInitTransition(StateGraph sg) {
		for (tr : sg.transitions) {
			if (tr instanceof InitialTransition)
				return true
		}
		return false
	}
	
	def List<Transition> getTransitionList(State s) {
		if (s.isLeaf())
			return new ArrayList<Transition>()
		else
			return s.subgraph.getTransitionList()
		}

	def List<Transition> getTransitionList(StateGraph sg) {
		var res = new ArrayList<Transition>(sg.transitions)
		for (s : sg.states) {
			res.addAll(s.transitionList)
		}
		return res
	}
	
	
}