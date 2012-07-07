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

package org.eclipse.etrice.generator.generic

import com.google.inject.Singleton
import java.io.File
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.etrice.core.room.InitialTransition
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageHandler
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.SAPRef
import org.eclipse.etrice.core.room.SPPRef
import org.eclipse.etrice.core.room.ServiceImplementation
import org.eclipse.etrice.core.room.SimpleState
import org.eclipse.etrice.core.room.State
import org.eclipse.etrice.core.room.StateGraph
import org.eclipse.etrice.core.room.Transition
import org.eclipse.etrice.core.room.TransitionPoint
import org.eclipse.etrice.core.room.Trigger

import static org.eclipse.etrice.generator.base.CodegenHelpers.*

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*

@Singleton
class RoomExtensions {

	//-------------------------------------------------------
	// union methods
	
	def <T> List<T> union(List<T> l1, List<T> l2) {
		var ret = new ArrayList<T>()
		ret.addAll(l1)
		ret.addAll(l2)
		return ret
	}
	
	def <T> Iterable<T> union(Iterable<T> l1, Iterable<T> l2) {
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

	def String getDocGenerationPathSegment() {
		return "/doc-gen/"
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

	def String getDocGenerationTargetPath(EObject e){
		return getProjectPath(e)+getDocGenerationPathSegment();
	}

	def List<Port> getEndPorts(ActorClass ac) {
		ac.intPorts.punion(ac.extPorts)
	}

	def List<Port> getAllEndPorts(ActorClass ac) {
		if (ac.base==null)
			return ac.getEndPorts()
		else
			ac.base.getAllEndPorts().union(ac.getEndPorts())
	}

	def List<SAPRef> getAllSAPs(ActorClass ac) {
		if (ac.base==null)
			return ac.strSAPs
		else
			ac.base.allSAPs.union(ac.strSAPs)
	}

	def List<ServiceImplementation> getAllServiceImplementations(ActorClass ac) {
		if (ac.base==null)
			return ac.serviceImplementations
		else
			ac.base.allServiceImplementations.union(ac.serviceImplementations)
	}
	
	// make a valid identifier from a path string
	def String getPathName(String path){
		path.replaceAll("/","_");
	}

	def List<Attribute> getAllAttributes(DataClass dc) {
		if (dc.base==null)
			return dc.attributes
		else
			dc.base.allAttributes.union(dc.attributes)
	}

	def List<Attribute> getAllAttributes(ActorClass ac) {
		if (ac.base==null)
			return ac.attributes
		else
			ac.base.allAttributes.union(ac.attributes)
	}

	//-------------------------------------------------------
	// protocol related methods
	
	def dispatch String getPortClassName(Port p){
		if (p.protocol instanceof ProtocolClass)
			(p.protocol as ProtocolClass).getPortClassName(p.conjugated, p.replicated)
		else
			""
	}
	
	def dispatch getPortClassName(SAPRef sap) {
		return sap.protocol.getPortClassName(true)
	}

	def dispatch String getPortClassName(SPPRef spp) {
		return spp.protocol.getPortClassName(false, true)
	}
	
	def String getPortClassName(ProtocolClass p, boolean conj) {
		getPortClassName(p, conj, false)
	}
	
	def String getPortClassName(ProtocolClass p, boolean conj, boolean repl) {
		p.name + (if (conj) "Conj" else "") + (if (repl) "Repl" else "") +"Port"
	}

	def String getPortClassName(ExternalPort p){
		return p.ifport.getPortClassName()
	}

	def String getPortClassName(ServiceImplementation svc) {
		return svc.spp.protocol.getPortClassName(false, true)
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

	def boolean isConjugated(InterfaceItemInstance iii) {
		if (iii instanceof PortInstance) {
			return (iii as PortInstance).port.conjugated
		}
		else if (iii instanceof SAPInstance)  {
			return true
		}
		else if (iii instanceof ServiceImplInstance) {
			return false
		}
		else {
			// should not happen
			return false
		}
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
		if (sg!=null) {
			for (e : sg.states){
				ret.add(e)
				if (e.subgraph!=null){
					ret.addAll(e.subgraph.stateList)
				}
			}
		}
		return ret
	}

	def List<State> getBaseStateList(StateGraph sg) {
		var ret = new ArrayList<State>()
		if (sg!=null) {
			for (e : sg.getStateList()){
				if (e instanceof SimpleState){
					ret.add(e)
				}
			}
		}
		return ret
	}

	def getLeafStatesLast(List<State> states) {
		var leaf = new ArrayList<State>()
		var nonLeaf = new ArrayList<State>()
		for (state : states) {
			if (state.leaf)
				leaf.add(state)
			else
				nonLeaf.add(state)
		}
		nonLeaf.addAll(leaf)
		
		return nonLeaf
	}

	def List<State> getAllBaseStates(ActorClass ac) {
		if (ac.base==null)
			return ac.stateMachine.getBaseStateList()
		else
			ac.base.getAllBaseStates().union(ac.stateMachine.getBaseStateList())
	}

	def List<State> getAllBaseStatesLeavesLast(ActorClass ac) {
		if (ac.base==null)
			return ac.stateMachine.getBaseStateList().getLeafStatesLast
		else
			ac.base.getAllBaseStates().getLeafStatesLast.union(ac.stateMachine.getBaseStateList().getLeafStatesLast)
	}

	def List<State> getAllLeafStates(ActorClass ac) {
		if (ac.base==null)
			return ac.stateMachine.getLeafStateList()
		else
			ac.base.getAllLeafStates().union(ac.stateMachine.getLeafStateList())
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
	
	// TODO. in the following methods handle inheritance language independent and proper
	
	def boolean empty(DetailCode dc) {
		dc.detailCode==""
	}

	def boolean hasEntryCode(State s) {
		if (!s.entryCode.empty)
			return true
			
		if (s instanceof ExpandedRefinedState)
			return !(s as ExpandedRefinedState).inheritedEntry.empty
			
		return false
	}

	def boolean hasExitCode(State s) {
		if (!s.exitCode.empty)
			return true
			
		if (s instanceof ExpandedRefinedState)
			return !(s as ExpandedRefinedState).inheritedExit.empty
			
		return false
	}

	def boolean hasDoCode(State s) {
		if (!s.doCode.empty)
			return true
			
		if (s instanceof ExpandedRefinedState)
			return !(s as ExpandedRefinedState).inheritedDo.empty
			
		return false
	}
	
	def boolean hasActionCode(Transition t) {
		t.action!=null && t.action.commands.size>0
	}
	
	def String getContextId(TransitionChain tc) {
		tc.getStateContext().getStateId()
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
	

	def List<Transition> getOutgoingTransitionsHierarchical(ExpandedActorClass ac, State s) {
		var result = new ArrayList<Transition>()
		
		// own transitions
		result.addAll(ac.getOutgoingTransitions(s))

		// transition points on same level
		var sg = s.eContainer() as StateGraph
		for (tp : sg.getTrPoints()) {
			if (tp instanceof TransitionPoint)
				result.addAll(ac.getOutgoingTransitions(tp))
		}
		
		// recurse to super states
		if (sg.eContainer() instanceof State) {
			result.addAll(getOutgoingTransitionsHierarchical(ac, sg.eContainer() as State))
		}
		
		return result;
	}
	
}