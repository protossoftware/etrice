package org.eclipse.etrice.core.scoping

import com.google.inject.Inject
import java.util.Collections
import org.apache.commons.lang3.tuple.MutablePair
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.etrice.core.fsm.fSM.FSMPackage
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule
import org.eclipse.etrice.core.room.ActorClass
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
import org.eclipse.etrice.core.room.RoomPackage
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.SPPoint
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.core.room.SubSystemRef
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope

class RoomScopeProviderDelegate {

	@Inject
	extension RoomHelpers
	
	def getScope(EObject context, EReference reference) {
		context.scopeFor(reference)
	}

	// the fall back method delegates to super
	protected def dispatch IScope scopeFor(EObject obj, EReference ref) {
		null
	}
	
	protected def dispatch IScope scopeFor(MessageFromIf mfi, EReference ref) {
		switch (ref) {
			case FSMPackage.Literals.MESSAGE_FROM_IF__MESSAGE: {
				// returns a flat list of Message scopes for a {@link MessageFromIf}
				val InterfaceItem item = (mfi.from as InterfaceItem) 
				if (item !== null) {
					val directedProtocol = new MutablePair => [
						// left is the protocol
						// right is the conjugated or not
						if (item instanceof Port && item.generalProtocol instanceof ProtocolClass) {
							left = item.generalProtocol as ProtocolClass 
							right = item.conjugated 
						} else if (item instanceof SAP) {
							left = item.protocol 
							right = true 
						} else if (item instanceof SPP) {
							left = item.protocol 
							right = false 
						}
					]
					if (directedProtocol.left !== null) {
						return getAllMessages(directedProtocol.left, !directedProtocol.right).map[EObjectDescription.create(name, it)].toSimpleScope
					}
				}
			}
			/*
			 * TODO: this was scope_MessageFromIf_port
			case FSMPackage.Literals.MESSAGE_FROM_IF__FROM: {
				// returns a flat list of Port scopes for a {@link MessageFromIf}
				val ActorClass ac=getActorClass(mfi) 
				for (Port p : ac.getInternalPorts()) {
					scopes.add(EObjectDescription.create(p.getName(), p)) 
				}
				for (ExternalPort p : ac.getExternalPorts()) {
					scopes.add(EObjectDescription.create(p.getInterfacePort().getName(), p.getInterfacePort())) 
				}
			}
			 */
			case FSMPackage.Literals.MESSAGE_FROM_IF__FROM: {
				// returns a flat list of InterfaceItem scopes for a {@link MessageFromIf}
				return getAllInterfaceItems(mfi.actorClass).map[EObjectDescription.create(name, it)].toSimpleScope
			}
		}
		return emptyScope
	}
	
	protected def dispatch IScope scopeFor(BindingEndPoint ep, EReference ref) {
		switch (ref) {
			case RoomPackage.Literals.BINDING_END_POINT__ACTOR_REF: {
				// returns a flat list of ActorRef scopes for a {@link BindingEndPoint}
				val sc = ep.structureClass
				switch (sc) {
					ActorClass: 
						return sc.classHierarchy.flatMap[actorRefs].map[EObjectDescription.create(name, it)].toSimpleScope
					SubSystemClass:
						return sc.actorRefs.map[EObjectDescription.create(name, it)].toSimpleScope
					LogicalSystem:
						return sc.subSystems.map[EObjectDescription.create(name, it)].toSimpleScope
				} 
			}
			case RoomPackage.Literals.BINDING_END_POINT__PORT: {
				// returns a flat list of Port scopes for a {@link BindingEndPoint}
				if (ep.actorRef === null) {
					val sc = ep.structureClass
					if (sc instanceof ActorClass) {
						// for all super classes (including this class)
						// collect internal and relay ports, i.e.
						// structure ports not in interface (internal)
						// interface ports not in structure (relay)
						return sc
							.classHierarchy
							.map[(internalPorts + relayPorts)
								.map[EObjectDescription.create(name, it)]
							]
							.flatten.toSimpleScope
					} else if (sc instanceof SubSystemClass) {
						return sc.relayPorts.map[EObjectDescription.create(name, it)].toSimpleScope
					}
				} else {
					// all ports in the sub actor's interface
					val epref = ep.actorRef
					switch (epref) {
						ActorRef:
							return epref.type.classHierarchy.flatMap[interfacePorts].map[EObjectDescription.create(name, it)].toSimpleScope
						SubSystemRef:
							return epref.type.relayPorts.map[EObjectDescription.create(name, it)].toSimpleScope
					}
				}
			}
			case RoomPackage.Literals.BINDING_END_POINT__SUB: {
				// returns a flat list of SubProtocol scopes for a {@link BindingEndPoint}
				if (ep.port !== null) {
					if (ep.port.protocol instanceof CompoundProtocolClass) {
						val pc = (ep.port.protocol as CompoundProtocolClass)
						return pc.subProtocols.map[EObjectDescription.create(name, it)].toSimpleScope
					}
				}
			}
		}
		return emptyScope 
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
			return pc.classHierarchy.flatMap[incomingMessages].map[EObjectDescription.create(name, it)].toSimpleScope
		}
		else if (sr instanceof OutSemanticsRule) {
			return pc.classHierarchy.flatMap[outgoingMessages].map[EObjectDescription.create(name, it)].toSimpleScope
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
			return acc.classHierarchy.flatMap[actorRefs].map[EObjectDescription.create(name, it)].toSimpleScope
		}
		else {
			return acc.actorRefs.map[EObjectDescription.create(name, it)].toSimpleScope
		}
	}
	
	/** 
	 * returns a flat list of SPP scopes for a {@link RelaySAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	protected def dispatch IScope scopeFor(RelaySAPoint pt, EReference ref) {
		if (ref==RoomPackage.Literals.RELAY_SA_POINT__RELAY) {
			return pt.actorClass.classHierarchy.flatMap[serviceProvisionPoints].map[EObjectDescription.create(name, it)].toSimpleScope 
		}
		
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(SPPoint pt, EReference ref) {
		switch (ref) {
			case RoomPackage.Literals.SP_POINT__REF: {
				// returns a flat list of ActorRef scopes for a {@link SPPoint}
				val acc = pt.actorContainerClass 
				if (acc instanceof ActorClass) {
					return acc.classHierarchy.flatMap[actorRefs].map[EObjectDescription.create(name, it)].toSimpleScope
				}
				else {
					return acc.actorRefs.map[EObjectDescription.create(name, it)].toSimpleScope
				}
			}
			case RoomPackage.Literals.SP_POINT__SERVICE: {
				val sppref = pt.ref
				if (sppref instanceof ActorRef) {
					return sppref.type.classHierarchy.flatMap[serviceProvisionPoints].map[EObjectDescription.create(name, it)].toSimpleScope
				} else if (sppref instanceof SubSystemRef) {
					return sppref.type.serviceProvisionPoints.map[EObjectDescription.create(name, it)].toSimpleScope 
				}
			}
		}
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(MessageHandler handler, EReference ref) {
		if (ref==RoomPackage.Literals.MESSAGE_HANDLER__MSG) {
			val pc = handler.protocolClass 
			if (pc !== null) {
				if (handler instanceof InMessageHandler)
					return pc.incomingMessages.map[EObjectDescription.create(name, it)].toSimpleScope
				else if (handler instanceof OutMessageHandler)
					return pc.outgoingMessages.map[EObjectDescription.create(name, it)].toSimpleScope
			}
		}
		
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(PortOperation op, EReference ref) {
		val pcls = op.eContainer() as PortClass 
		val pc = op.protocolClass 
		if (pc !== null) {
			if (pcls === pc.getConjugated()) {
				return pc.incomingMessages.map[EObjectDescription.create(name, it)].toSimpleScope
			}
			else {
				return pc.outgoingMessages.map[EObjectDescription.create(name, it)].toSimpleScope
			}
		}
		return emptyScope 
	}
	
	protected def dispatch IScope scopeFor(ExternalPort ep, EReference ref) {
		ep.actorClass.interfacePorts.map[EObjectDescription.create(name, it)].toSimpleScope
	}

	/*
	 * two helper methods for scopes
	 */
	 
	protected def toSimpleScope(Iterable<IEObjectDescription> scopes) {
		new SimpleScope(IScope.NULLSCOPE, scopes)
	}
	
	protected def emptyScope() {
		new SimpleScope(IScope.NULLSCOPE, Collections.emptyList)
	}
}
