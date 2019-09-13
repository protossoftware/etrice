package org.eclipse.etrice.core.scoping

import static org.eclipse.etrice.core.fsm.fSM.FSMPackage.Literals.*
import static org.eclipse.etrice.core.room.RoomPackage.Literals.*

import com.google.common.collect.ImmutableList
import com.google.inject.Inject
import java.util.Collections
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule
import org.eclipse.etrice.core.fsm.fSM.Trigger
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ActorContainerRef
import org.eclipse.etrice.core.room.ActorRef
import org.eclipse.etrice.core.room.BindingEndPoint
import org.eclipse.etrice.core.room.CompoundProtocolClass
import org.eclipse.etrice.core.room.ExternalPort
import org.eclipse.etrice.core.room.InMessageHandler
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.LogicalSystem
import org.eclipse.etrice.core.room.MessageHandler
import org.eclipse.etrice.core.room.OutMessageHandler
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PortOperation
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RefSAPoint
import org.eclipse.etrice.core.room.RelaySAPoint
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.SPPoint
import org.eclipse.etrice.core.room.StructureClass
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.core.room.SubSystemRef
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.xtext.scoping.IScope
import java.util.List
import org.eclipse.etrice.core.room.Binding
import org.eclipse.xtext.scoping.Scopes

class RoomScopeProviderDelegate {

	@Inject
	extension RoomHelpers
	
	def IScope getScope(EObject context, EReference reference) {
		try context.scopeFor(reference)
		catch(NullPointerException | IllegalArgumentException e) null	// Ignore
	}

	// the fall back method delegates to super
	protected def dispatch IScope scopeFor(EObject obj, EReference ref) {
		null
	}
	
	protected def dispatch IScope scopeFor(Trigger trigger, EReference ref) {
		switch(ref) {
			case MESSAGE_FROM_IF__MESSAGE: scopeTriggerMessages(trigger.actorClass.allInterfaceItems)
			default: emptyScope
		}
	}
	
	protected def dispatch IScope scopeFor(MessageFromIf mfi, EReference ref) {
		switch (ref) {
			case MESSAGE_FROM_IF__MESSAGE: {
				// returns a flat list of Message scopes for a {@link MessageFromIf}
				val InterfaceItem item = (mfi.from as InterfaceItem)
				if (item !== null) scopeTriggerMessages(Collections.singletonList(item))
				else scopeTriggerMessages(mfi.actorClass.allInterfaceItems)
			}
			case MESSAGE_FROM_IF__FROM:
				// returns a flat list of InterfaceItem scopes for a {@link MessageFromIf}
				mfi.actorClass.allInterfaceItems.simpleScope
			default: emptyScope
		}
	}
	
	/** Computes a scope with all messages of the passed interface items */
	private def scopeTriggerMessages(List<InterfaceItem> ifitems) {
		ifitems.flatMap[
			switch(it) {
				Port case generalProtocol instanceof ProtocolClass:
					(generalProtocol as ProtocolClass).getAllMessages(!conjugated)
				SAP: protocol.getAllMessages(false)
				SPP: protocol.getAllMessages(true)
				default: emptyList
			}
		].simpleScope
	}
	
	protected def dispatch IScope scopeFor(Binding binding, EReference ref) {
		switch(ref) {
			case BINDING_END_POINT__ACTOR_REF: scopeBindingActorRef(binding.structureClass)
			case BINDING_END_POINT__PORT: scopeBindingPort(binding.structureClass, null)
			default: emptyScope
		}
	}
	
	protected def dispatch IScope scopeFor(BindingEndPoint ep, EReference ref) {
		switch (ref) {
			case BINDING_END_POINT__ACTOR_REF: scopeBindingActorRef(ep.structureClass)
			case BINDING_END_POINT__PORT: scopeBindingPort(ep.structureClass, ep.actorRef)
			case BINDING_END_POINT__SUB: scopeBindingSub(ep.port)
			default: emptyScope
		}
	}
	
	/** returns a flat list of ActorRef scopes for a {@link BindingEndPoint} */
	private def IScope scopeBindingActorRef(StructureClass sc) {
		switch (sc) {
			ActorClass: 
				return sc.classHierarchy.flatMap[actorRefs].simpleScope
			SubSystemClass:
				return sc.actorRefs.simpleScope
			LogicalSystem:
				return sc.subSystems.simpleScope
		}
	}
	
	/** returns a flat list of Port scopes for a {@link BindingEndPoint} */
	private def scopeBindingPort(StructureClass sc, ActorContainerRef actorRef) {
		if (actorRef === null) {
			if (sc instanceof ActorClass) {
				// for all super classes (including this class)
				// collect internal and relay ports, i.e.
				// structure ports not in interface (internal)
				// interface ports not in structure (relay)
				return sc.classHierarchy.flatMap[internalPorts + relayPorts].simpleScope
			} else if (sc instanceof SubSystemClass) {
				return sc.relayPorts.simpleScope
			}
		} else {
			// all ports in the sub actor's interface
			val epref = actorRef
			switch (epref) {
				ActorRef:
					return epref.type.classHierarchy.flatMap[interfacePorts].simpleScope
				SubSystemRef:
					return epref.type.relayPorts.simpleScope
			}
		}
	}
	
	/** returns a flat list of SubProtocol scopes for a {@link BindingEndPoint} */
	private def scopeBindingSub(Port port) {
		if (port !== null) {
			if (port.protocol instanceof CompoundProtocolClass) {
				val pc = (port.protocol as CompoundProtocolClass)
				return pc.subProtocols.simpleScope
			}
		}
	}
	
	/** 
	 * returns a flat list of Message scopes for a {@link InSemanticsRule}
	 * @param sr - the semantics rule for incoming messages
	 * @param ref - not used
	 * @return a list of scopes
	 */
	protected def dispatch IScope scopeFor(SemanticsRule sr, EReference ref) {
		val pc = sr.protocolClass 
		if (sr instanceof InSemanticsRule) {
			return pc.classHierarchy.flatMap[incomingMessages].simpleScope
		}
		else if (sr instanceof OutSemanticsRule) {
			return pc.classHierarchy.flatMap[outgoingMessages].simpleScope
		}
		return emptyScope 
	}
	
	/** 
	 * returns a flat list of ActorRef scopes for a {@link RefSAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	protected def dispatch IScope scopeFor(RefSAPoint pt, EReference ref) {
		val acc = pt.actorContainerClass
		if (acc instanceof ActorClass) {
			return acc.classHierarchy.flatMap[actorRefs].simpleScope
		}
		else {
			return acc.actorRefs.simpleScope
		}
	}
	
	/** 
	 * returns a flat list of SPP scopes for a {@link RelaySAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	protected def dispatch IScope scopeFor(RelaySAPoint pt, EReference ref) {
		if (ref==RELAY_SA_POINT__RELAY) {
			return pt.actorClass.classHierarchy.flatMap[serviceProvisionPoints].simpleScope
		}
		
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(SPPoint pt, EReference ref) {
		switch (ref) {
			case SP_POINT__REF: {
				// returns a flat list of ActorRef scopes for a {@link SPPoint}
				val acc = pt.actorContainerClass 
				if (acc instanceof ActorClass) {
					return acc.classHierarchy.flatMap[actorRefs].simpleScope
				}
				else {
					return acc.actorRefs.simpleScope
				}
			}
			case SP_POINT__SERVICE: {
				val sppref = pt.ref
				if (sppref instanceof ActorRef) {
					return sppref.type.classHierarchy.flatMap[serviceProvisionPoints].simpleScope
				} else if (sppref instanceof SubSystemRef) {
					return sppref.type.serviceProvisionPoints.simpleScope
				}
			}
		}
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(MessageHandler handler, EReference ref) {
		if (ref==MESSAGE_HANDLER__MSG) {
			val pc = handler.protocolClass 
			if (pc !== null) {
				if (handler instanceof InMessageHandler)
					return pc.incomingMessages.simpleScope
				else if (handler instanceof OutMessageHandler)
					return pc.outgoingMessages.simpleScope
			}
		}
		
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(PortOperation op, EReference ref) {
		val pcls = op.eContainer() as PortClass 
		val pc = op.protocolClass 
		if (pc !== null) {
			if (pcls === pc.getConjugated()) {
				return pc.incomingMessages.simpleScope
			}
			else {
				return pc.outgoingMessages.simpleScope
			}
		}
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(ExternalPort ep, EReference ref) {
		ep.actorClass.interfacePorts.simpleScope
	}

	/*
	 * helper methods for scopes
	 */
	
	protected def IScope emptyScope() {
		IScope.NULLSCOPE
	}
	
	protected def IScope simpleScope(Iterable<? extends EObject> elements) {
		// Create copy to force evaluation of elements
		Scopes.scopeFor(ImmutableList.copyOf(elements))
	}
}
