/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Singleton
import java.util.ArrayList
import java.util.List
import javax.inject.Inject
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageHandler
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.ServiceImplementation
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.generic.FSMExtensions
import java.util.Collections

/**
	collection of convenience functions for code generation
*/
@Singleton
class RoomExtensions extends FSMExtensions {

	public val NEWLINE = System.getProperty("line.separator")

	private static String genDir = "/src-gen/"
	private static String genInfoDir = "/src-gen-info/"

	@Inject protected extension RoomHelpers

	def static setDefaultGenDir() {
		genDir = "/src-gen/"
	}
	def static setDefaultGenInfoDir() {
		genInfoDir = "/src-gen-info/"
	}
	def static setGenDir(String dir) {
		genDir = "/"+dir+"/"
	}
	def static setGenInfoDir(String dir) {
		genInfoDir = "/"+dir+"/"
	}

	//-------------------------------------------------------
	// union methods

	/**
	 * a specialized version of {@link #union(Iterable, Iterable)}
	 * @param in1 an iterable of type T
	 * @param in2 a second iterable of type T
	 * @return the union of the two iterables as new list
	 */
	def List<Port> punion(Iterable<Port> in1, Iterable<ExternalPort> in2){
		val ret=new ArrayList<Port>()
		in2.forEach(e|ret.add(e.interfacePort))
		ret.addAll(in1)
		return ret
	}

	//-------------------------------------------------------
	// path related methods

	/**
	 * @return the relative path to the destination folder for the generated code
	 */
	def String getGenerationPathSegment() {
		genDir
	}

	/**
	 * @return the relative path to the destination folder for the generated code
	 */
	def String getGenerationInfoSegment() {
		genInfoDir
	}

	/**
	 * @param e an {@link EObject}
	 * @return the URI of the EObject's resource as file string
	 * 		(or an empty string if no such resource exists)
	 */
	def String getModelPath(EObject e) {
		var res = e.eResource;
		if (res===null) {
			return ""
		}
		else {
			return res.URI.toFileString
		}
	}


	//-------------------------------------------------------
	// packages and paths

	/**
	 * @param rc a {@link RoomClass}
	 * @return the name of the room model which also serves as a package name
	 */
	def String getPackage(RoomClass rc) {
		return (rc.eContainer as RoomModel).name
	}

	/**
	 * @param rc a {@link RoomClass}
	 * @return the name of the room model followed by the class name and all . replaced with _
	 */
	def String getFullyQualifiedName(RoomClass rc) {
		rc.package.replace(".", "_")+"_"+rc.name
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
		val res = FileSystemHelpers::getProjectURI(e)
		if (res===null) {
			return ""
		}

		return res.toFileString
	}

	/**
	 * @param e an {@link EObject}
	 * @return the concatenation of the object's project path
	 * 		with the {@link #getGenerationPathSegment()}
	 */
	def String getGenerationTargetPath(EObject e){
		return getProjectPath(e)+getGenerationPathSegment()
	}

	/**
	 * @param e an {@link EObject}
	 * @return the concatenation of the object's project path
	 * 		with the {@link #getGenerationInfoSegment()}
	 */
	def String getGenerationInfoPath(EObject e){
		return getProjectPath(e)+getGenerationInfoSegment()
	}

	/**
	 * makes a valid identifier from a path string
	 * @param path a slash (/) separated path
	 * @return the path with slashes (and colons as in replicated actors) replaced by underscores (_)
	 */
	def String getPathName(String path){
		path.replaceAll("/","_").replaceAll(":","_")
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
		return p.interfacePort.getPortClassName()
	}

	/**
	 * @param sap a {@link SAP}
	 * @return a name for the associated port class
	 */
	def dispatch getPortClassName(SAP sap) {
		return sap.protocol.getPortClassName(true)
	}

	/**
	 * @param spp a {@link SPP}
	 * @return a name for the associated port class
	 */
	def dispatch String getPortClassName(SPP spp) {
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

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired {@link PortClass}
	 * @return the port class
	 */
	def PortClass getPortClass(ProtocolClass pc, boolean conj) {
		if (conj)
			return pc.conjugated
		else
			return pc.regular
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired {@link PortClass}
	 * @return the port class
	 */
	def List<PortClass> getAllPortClasses(ProtocolClass pc, boolean conj) {
		val ArrayList<PortClass> result = newArrayList()
		
		var protocol = pc
		while (protocol!==null) {
			if (conj) {
				if (protocol.conjugated!==null)
					result.add(protocol.conjugated)
			}
			else {
				if (protocol.regular!==null)
					result.add(protocol.regular)
			}
			
			protocol = protocol.base
		}
			
		return result
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return <code>true</code> if a send handler is specified for this direction
	 */
	def boolean handlesSend(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)===null)
			return false
		else {
			val allMessages = pc.getAllMessages(conj)
			for (hdlr : getSafeList(pc.getPortClass(conj).msgHandlers))
				if (allMessages.contains(hdlr.msg))
					return true;
		}
		return false;
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return <code>true</code> if a receive handler is specified for this direction
	 */
	def boolean handlesReceive(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)===null)
			return false
		else {
			val allMessages = pc.getAllMessages(!conj)
			for (hdlr : getSafeList(pc.getPortClass(conj).msgHandlers))
				if (allMessages.contains(hdlr.msg))
					return true;
		}
		return false;
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return <code>true</code> if a receive handler is specified for this direction including base classes
	 */
	def boolean handlesReceiveIncludingSuper(ProtocolClass pc, boolean conj) {
		val allPortClasses = pc.getAllPortClasses(conj)
		val allMessages = pc.getAllMessages(!conj)
		for (p : allPortClasses)
			for (hdlr : getSafeList(p.msgHandlers))
				if (allMessages.contains(hdlr.msg))
					return true;
		return false;
	}

	/**
	 * @param iii an {@link InterfaceItemInstance}
	 * @return <code>true</code> if the interface item instance is logically conjugate
	 */
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

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return a list of defined receive {@link MessageHandler} for this direction
	 */
	def List<MessageHandler> getReceiveHandlers(ProtocolClass pc, boolean conj) {
		val res = new ArrayList<MessageHandler>()
		if (pc.getPortClass(conj)!==null) {
			val allMessages = pc.getAllMessages(!conj)
			for (hdlr : getSafeList(pc.getPortClass(conj).msgHandlers)) {
				if (allMessages.contains(hdlr.msg))
					res.add(hdlr)
			}
		}
		return res
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return a list of defined receive {@link MessageHandler} for this direction including base classes
	 */
	def List<MessageHandler> getReceiveHandlersIncludingSuper(ProtocolClass pc, boolean conj) {
		val res = new ArrayList<MessageHandler>()
		val allPortClasses = pc.getAllPortClasses(conj)
		val allMsgs = pc.getAllMessages(!conj)
		for (p : allPortClasses) {
			for (hdlr : getSafeList(p.msgHandlers)) {
				if (allMsgs.contains(hdlr.msg))
					res.add(hdlr)
			}
		}
		return res
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param conj flag indicating the desired communication direction
	 * @return a list of defined send {@link MessageHandler} for this direction
	 */
	def List<MessageHandler> getSendHandlers(ProtocolClass pc, boolean conj) {
		if (pc.getPortClass(conj)===null)
			return Collections.emptyList
		else {
			val res = new ArrayList<MessageHandler>()
			val allMessages = pc.getAllMessages(conj)
			for (hdlr : getSafeList(pc.getPortClass(conj).msgHandlers)) {
				if (allMessages.contains(hdlr.msg))
					res.add(hdlr)
			}
			return res
		}
	}

	/**
	 * @param m a {@link Message}
	 * @param conj flag indicating the desired communication direction
	 * @return a send {@link MessageHandler} for this direction if it is defined, <code>null</code> else
	 */
	def MessageHandler getSendHandler(Message m, boolean conj) {
		return (m.eContainer as ProtocolClass).getSendHandlers(conj).findFirst(e|e.msg==m)
	}

	/**
	 * @param m a {@link Message}
	 * @return <code>true</code> if this message is an incoming message
	 */
	def boolean isIncoming(Message m) {
		return (m.eContainer as ProtocolClass).allIncomingMessages.contains(m)
	}

	/*
	 * @param m a {@link Message}
	 * @return a string that can be used as identifier for the message. It is prefixed with IN_ or OUT_
	 * 		to avoid ambiguities
	 */
	def String getCodeName(Message m) {
		if (m.isIncoming())
			return "IN_"+m.name
		else
			return "OUT_"+m.name
	}

	/**
	 * @param ac an {@link ActorClass}
	 * @return <code>true</code> if an operation named 'stop' is defined with a void argument list and
	 * 		void return type
	 */
	def boolean overridesStop(ActorClass ac) {
		ac.operations.exists(e|e.name=="stop" && e.arguments.isEmpty && e.returnType===null)
			|| (ac.actorBase!==null && ac.actorBase.overridesStop())
	}

	def getAllSubInstances(StructureInstance ssi) {
		val BasicEList<AbstractInstance> result = new BasicEList<AbstractInstance>();
		val TreeIterator<EObject> it = ssi.eAllContents();
		while (it.hasNext()) {
			val EObject obj = it.next();
			if (obj instanceof AbstractInstance)
				result.add(obj as AbstractInstance);
		}
		return result;
	}

	def static List<MessageHandler> getSafeList(List<MessageHandler> msgHandlers) {
		return if (msgHandlers===null) Collections.emptyList else msgHandlers 
	}

}
