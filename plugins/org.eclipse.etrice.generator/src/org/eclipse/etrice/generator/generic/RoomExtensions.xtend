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

package org.eclipse.etrice.generator.generic

import com.google.inject.Singleton
import java.io.File
import java.util.ArrayList
import java.util.Collections
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
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.etrice.core.room.InitialTransition
import org.eclipse.etrice.core.room.InterfaceItem
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


/**
	collection of convenience functions for code generation
*/
@Singleton
class RoomExtensions {

	//-------------------------------------------------------
	// union methods
	
	/**
	 * the template type is T
	 * @param l an iterable of type T
	 * @param e a single element of type T
	 * @return the union of the iterable and the element as new list
	 */
	def <T> List<T> union(Iterable<T> l, T e) {
		var ret = new ArrayList<T>()
		ret.addAll(l)
		ret.add(e)
		return ret
	}
	
	/**
	 * the template type is T
	 * @param l1 an iterable of type T
	 * @param l2 a second iterable of type T
	 * @return the union of the two iterables as new list
	 */
	def <T> List<T> union(Iterable<T> l1, Iterable<T> l2) {
		var ret = new ArrayList<T>()
		ret.addAll(l1)
		ret.addAll(l2)
		return ret
	}
    
	/**
	 * a specialized version of {@link #union(Iterable, Iterable)}
	 * @param l1 an iterable of type T
	 * @param l2 a second iterable of type T
	 * @return the union of the two iterables as new list
	 */
	def List<Port> punion(Iterable<Port> in1, Iterable<ExternalPort> in2){
		val ret=new ArrayList<Port>()
		in2.forEach(e|ret.add(e.ifport))
		ret.addAll(in1)
		return ret
	}
	
	/**
	 * the template type is T
	 * @param l1 a list of elements of type T
	 * @param l2 a second list of elements of type T
	 * @return a new list with the contents of l1 
	 */
	def <T> List<T> minus(List<T> l1, List<T> l2){
		var ret = new ArrayList<T>(l1)
		ret.removeAll(l2)
		return ret;
	}
	
	//-------------------------------------------------------
	// path related methods
	
	/**
	 * @return the relative path to the destination folder for the generated code
	 */
	def String getGenerationPathSegment() {
		return "/src-gen/"
	}

	/**
	 * @return the relative path to the destination folder for the generated documentation
	 */
	def String getDocGenerationPathSegment() {
		return "/doc-gen/"
	}

	/**
	 * @param e an {@link EObject}
	 * @return the URI of the EObject's resource as file string
	 * 		(or an empty string if no such resource exists)
	 */
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
	
	/**
	 * @param rc a {@link RoomClass}
	 * @return the name of the room model which also serves as a package name
	 */
	def String getPackage(RoomClass rc) {
		return (rc.eContainer as RoomModel).name
	}
	
	/**
	 * @param packageName a dot (.) separated package anem
	 * @return the input with dots replaced with slashes (/)
	 */
	def String getPathFromPackage(String packageName) {
		return packageName.replaceAll("\\.", "/") + "/"
	}
	
	/**
	 * @param rc a {@link RoomClass}
	 * @return the relative folder path of the package
	 * 		(as defined by the Java convention)
	 */
	def String getPath(RoomClass rc) {
		getPathFromPackage(getPackage(rc))
	}
	
	// a directory is a eclipse project if it contains a ".project" file
	/**
	 * @param e an {@link EObject}
	 * @return the path of the Eclipse project containing the EObject's resource
	 */
	def String getProjectPath(EObject e) {
		val res = e.eResource;
		if (res==null) {
			return ""
		}
		else {
			var tmpf = new File(res.URI.toFileString)
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
	
	/**
	 * @param e an {@link EObject}
	 * @return the concatenation of the objects project path
	 * 		with the {@link #getGenerationPathSegment()}
	 */
	def String getGenerationTargetPath(EObject e){
		return getProjectPath(e)+getGenerationPathSegment()
	}

	/**
	 * @param e an {@link EObject}
	 * @return the concatenation of the objects project path
	 * 		with the {@link #getDocGenerationPathSegment()}
	 */
	def String getDocGenerationTargetPath(EObject e){
		return getProjectPath(e)+getDocGenerationPathSegment()
	}
	
	/**
	 * makes a valid identifier from a path string
	 * @param path a slash (/) separated path
	 * @return the path with slashes replaced by underscores (_)
	 */
	def String getPathName(String path){
		path.replaceAll("/","_");
	}

	//-------------------------------------------------------
	// protocol related methods
	
	/**
	 * @param p a {@link Port}
	 * @return a name for the associated port class
	 */
	def dispatch String getPortClassName(Port p){
		if (p.protocol instanceof ProtocolClass)
			(p.protocol as ProtocolClass).getPortClassName(p.conjugated, p.replicated)
		else
			""
	}

	/**
	 * @param p a {@link ExternalPort}
	 * @return a name for the associated port class
	 */
	def dispatch String getPortClassName(ExternalPort p){
		return p.ifport.getPortClassName()
	}
	
	/**
	 * @param sap a {@link SAPRef}
	 * @return a name for the associated port class
	 */
	def dispatch getPortClassName(SAPRef sap) {
		return sap.protocol.getPortClassName(true)
	}

	/**
	 * @param spp a {@link SPPRef}
	 * @return a name for the associated port class
	 */
	def dispatch String getPortClassName(SPPRef spp) {
		return spp.protocol.getPortClassName(false, true)
	}

	/**
	 * @param svc a {@link ServiceImplementation}
	 * @return a name for the associated port class
	 */
	def dispatch String getPortClassName(ServiceImplementation svc) {
		return svc.spp.protocol.getPortClassName(false, true)
	}
	
	/**
	 * @param p a {@link ProtocolClass}
	 * @param conj if <code>true</code> consider conjugate port, else regular
	 * @return a name for the associated port class
	 */
	def String getPortClassName(ProtocolClass p, boolean conj) {
		getPortClassName(p, conj, false)
	}
	
	/**
	 * @param p a {@link ProtocolClass}
	 * @param conj if <code>true</code> consider conjugate port, else regular
	 * @param repl if <code>true</code> class name for replicated port
	 * 		else for plain port
	 * @return a name for the associated port class
	 */
	def String getPortClassName(ProtocolClass p, boolean conj, boolean repl) {
		p.name + (if (conj) "Conj" else "") + (if (repl) "Repl" else "") +"Port"
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
	
	def List<Message> getIncoming(InterfaceItem p) {
		if (p.protocol!=null)
			p.protocol.getIncoming(p.conjugated)
		else
			Collections::emptyList()
	}
		
	def List<Message> getOutgoing(InterfaceItem p) {
		if (p.protocol!=null)
			p.protocol.getOutgoing(p.conjugated)
		else
			Collections::emptyList()
	}
	
	def boolean isOnlyOutgoing(InterfaceItem p){
		getIncoming(p).empty
	}

	def boolean isOnlyIncoming(InterfaceItem p){
		getOutgoing(p).empty
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

	def boolean isConjugated(InterfaceItem iii) {
		if (iii instanceof Port) {
			return (iii as Port).conjugated
		}
		else if (iii instanceof SAPRef)  {
			return true
		}
		else if (iii instanceof SPPRef) {
			return false
		}
		else {
			// should not happen
			return false
		}
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
		if (sg!=null)
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
