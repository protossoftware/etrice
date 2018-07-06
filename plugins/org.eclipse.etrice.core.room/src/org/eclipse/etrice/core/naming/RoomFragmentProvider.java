/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.core.naming;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.naming.FSMFragmentProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomSwitch;


public class RoomFragmentProvider extends FSMFragmentProvider {

	protected class RoomPathProvider extends RoomSwitch<String> {

		private Switch<String> topSwitch;

		public RoomPathProvider(Switch<String> topSwitch) {
			this.topSwitch = topSwitch;
		}

		@Override
		public String caseRoomClass(RoomClass rc) {
			return rc.getName();
		}

		@Override
		public String casePort(Port port) {
			return topSwitch.doSwitch(port.eContainer())+SEP+port.getName();
		}

		@Override
		public String caseSPP(SPP spp) {
			return topSwitch.doSwitch(spp.eContainer())+SEP+spp.getName();
		}

		@Override
		public String caseActorContainerRef(ActorContainerRef acr) {
			return topSwitch.doSwitch(acr.eContainer())+SEP+acr.getName();
		}

		@Override
		public String caseBinding(Binding bi) {
			return topSwitch.doSwitch(bi.eContainer())+SEP
			+caseBindingEndPointShort(bi.getEndpoint1())+BIND_SEP
			+caseBindingEndPointShort(bi.getEndpoint2());
		}

		private String caseBindingEndPointShort(BindingEndPoint ep) {
			if(ep==null)
				return "null";
			String loc = ep.getActorRef()==null? LOCAL:ep.getActorRef().getName();
			if(ep.getPort()==null)
				return "null" + loc;
			else if (ep.getSub()!=null)
				return ep.getPort().getName()+EP_SEP+loc+SUB_SEP+ep.getSub().getName();
			else
				return ep.getPort().getName()+EP_SEP+loc;
		}

		@Override
		public String caseLayerConnection(LayerConnection bi) {
			return topSwitch.doSwitch(bi.eContainer())+SEP
			+caseSAPointShort(bi.getFrom())+CONN_SEP
			+caseSPPointShort(bi.getTo());
		}

		private String caseSAPointShort(SAPoint sapt) {
			if (sapt==null)
				return "null";
			if (sapt instanceof RefSAPoint)
				return ((RefSAPoint) sapt).getRef().getName();
			else if (sapt instanceof RelaySAPoint)
				return ((RelaySAPoint) sapt).getRelay().getName();

			assert(false): "unexpectd sub type";
			return null;
		}

		private String caseSPPointShort(SPPoint sppt) {
			if(sppt == null || (sppt.getRef() == null && sppt.getService() == null))
				return "null";
			String ref = (sppt.getRef() == null) ? "null" : sppt.getRef().getName();
			String service = (sppt.getService() == null) ? "null" : sppt.getService().getName();
			
			return ref+EP_SEP+service;
		}
	}

	private class CombinedPathProvider extends ComposedSwitch<String> {
		public CombinedPathProvider() {
			this.addSwitch(new BasePathProvider());
			this.addSwitch(new FSMPathProvider(this));
			this.addSwitch(new RoomPathProvider(this));
		}
	}

	private static final char BIND_SEP = '-';
	private static final char SUB_SEP = '/';
	private static final char CONN_SEP = '-';
	private static final char EP_SEP = '!';
	private static final String LOCAL = ".";

	private CombinedPathProvider roomPathProvider = new CombinedPathProvider();

	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		String path = getFragment(obj);
		if (path != null)
			return path;

		return fallback.getFragment(obj);
	}
	
	protected String getFragment(EObject obj) {
		String path = roomPathProvider.doSwitch(obj);		
		return (path != null) ? obj.eClass().getName()+TYPE_SEP+path : null;
	}

	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {

		if (!resource.getContents().isEmpty()) {
			RoomModel model = (RoomModel) resource.getContents().get(0);
			EObject result = getEObject(model, fragment);
			if (result!=null)
				return result;
		}

		return fallback.getEObject(fragment);
	}

	public static boolean isActorClass(String fragment) {
		if (fragment.startsWith(RoomPackage.eINSTANCE.getActorClass().getName()))
			return true;

		return false;
	}

	public static boolean isStructureClass(String fragment) {
		if (fragment.startsWith(RoomPackage.eINSTANCE.getActorClass().getName()))
			return true;
		if (fragment.startsWith(RoomPackage.eINSTANCE.getSubSystemClass().getName()))
			return true;
		if (fragment.startsWith(RoomPackage.eINSTANCE.getLogicalSystem().getName()))
			return true;

		return false;
	}

	public static boolean isStructureClass(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			return isStructureClass(uri.fragment());
		}
		return false;
	}

	public static boolean isPort(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getPort().getName());
	}

	public static boolean isSPP(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getSPP().getName());
	}

	public static boolean isBinding(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getBinding().getName());
	}

	public static boolean isLayerConnection(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getLayerConnection().getName());
	}

	public static boolean isRef(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorContainerRef().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorRef().getName()))
				return true;
		}
		return false;
	}

	protected EObject getEObject(RoomModel model, String fragment) {
		int begin = 0;
		int end = fragment.indexOf(TYPE_SEP);
		if (end<0)
			return null;
		String type = fragment.substring(begin, end);

		begin = end+1;
		end = fragment.indexOf(SEP, begin);
		if (end<0)
			end = fragment.length();
		String className = fragment.substring(begin, end);

		if(type.equals(BasePackage.eINSTANCE.getAnnotationType().getName())) {
			return getAnnotationType(model, className);
		}

		RoomClass rc = getRoomClass(model, className);
		if (type.equals(RoomPackage.eINSTANCE.getDataClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getPrimitiveType().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getEnumerationType().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getExternalType().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getProtocolClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getCompoundProtocolClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getActorClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getSubSystemClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getLogicalSystem().getName())) {
			return rc;
		}

		if (end<fragment.length()) {
			String remainder = fragment.substring(end+1, fragment.length());

			if (type.equals(RoomPackage.eINSTANCE.getPort().getName())) {
				return getPort(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getSPP().getName())) {
				return getSPP(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getSubSystemRef().getName())
					|| type.equals(RoomPackage.eINSTANCE.getActorRef().getName())) {
				return getActorContainerRef(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getBinding().getName())) {
				return getBinding(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getLayerConnection().getName())) {
				return getLayerConnection(rc, remainder);
			}

			if (rc instanceof ModelComponent) {
				ModelComponent mc = (ModelComponent) rc;

				if (type.equals("BaseState")
						|| type.equals(FSMPackage.eINSTANCE.getSimpleState().getName())
						|| type.equals(FSMPackage.eINSTANCE.getRefinedState().getName())) {
					return getState(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getTransitionPoint().getName())
						|| type.equals(FSMPackage.eINSTANCE.getEntryPoint().getName())
						|| type.equals(FSMPackage.eINSTANCE.getExitPoint().getName())) {
					return getTrPoint(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getChoicePoint().getName())) {
					return getChoicePoint(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getInitialTransition().getName())) {
					return getInitialTransition(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getRefinedTransition().getName())) {
					return getRefinedTransition(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getContinuationTransition().getName())
						|| type.equals(FSMPackage.eINSTANCE.getCPBranchTransition().getName())
						|| type.equals(FSMPackage.eINSTANCE.getTriggeredTransition().getName())
						|| type.equals(FSMPackage.eINSTANCE.getGuardedTransition().getName())) {
					return getTransition(mc, remainder);
				}
				else if (type.equals(FSMPackage.eINSTANCE.getStateGraph().getName())
						|| type.equals("StateMachine")) {
					return getStateGraph(mc, remainder);
				}
			}
		}

		return null;
	}

	private EObject getBinding(RoomClass rc, String name) {
		int pos = name.indexOf(BIND_SEP);
		if (pos<0)
			return null;

		if (rc instanceof StructureClass) {
			String ep1name = name.substring(0, pos);
			String ep2name = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			BindingEndPoint ep1 = getEndpoint(sc, ep1name);
			BindingEndPoint ep2 = getEndpoint(sc, ep2name);
			for (Binding bi : sc.getBindings()) {
				if (isEP(bi.getEndpoint1(),ep1) && isEP(bi.getEndpoint2(),ep2))
					return bi;
				if (isEP(bi.getEndpoint1(),ep2) && isEP(bi.getEndpoint2(),ep1))
					return bi;
			}
		}
		return null;
	}

	private boolean isEP(BindingEndPoint a, BindingEndPoint b) {
		if (a.getPort().getName().equals(b.getPort().getName())) {
			if (a.getSub()==null && b.getSub()!=null)
				return false;
			if (a.getSub()!=null && b.getSub()==null)
				return false;
			if (a.getSub()!=null && b.getSub()!=null)
				if (!a.getSub().getName().equals(b.getSub().getName()))
					return false;
			if (a.getActorRef()==null && b.getActorRef()==null)
				return true;
			if (a.getActorRef()!=null && b.getActorRef()!=null)
				if (a.getActorRef().getName().equals(b.getActorRef().getName()))
					return true;
		}
		return false;
	}

	private BindingEndPoint getEndpoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;

		String portName = name.substring(0, pos);
		String refName = name.substring(pos+1);
		String sub = null;
		int subIdx = refName.indexOf(SUB_SEP);
		if (subIdx>=0) {
			sub = refName.substring(subIdx+1);
			refName = refName.substring(0, subIdx);
		}
		ActorContainerRef ar = null;
		if (!refName.equals(LOCAL))
			ar = getActorContainerRef(sc, refName);
		if (ar!=null) {
			if (ar instanceof ActorRef)
				sc = ((ActorRef) ar).getType();
			else if (ar instanceof SubSystemRef)
				sc = ((SubSystemRef) ar).getType();
		}
		Port port = getPort(sc, portName);
		BindingEndPoint ep = RoomFactory.eINSTANCE.createBindingEndPoint();
		ep.setPort(port);
		ep.setActorRef(ar);
		if (subIdx>=0)
			ep.setSub(getSubProtocol(sub, port));
		return ep;
	}

	private SubProtocol getSubProtocol(String sub, Port port) {
		if (port==null)
			return null;

		if (port.getProtocol() instanceof CompoundProtocolClass) {
			CompoundProtocolClass cpc = (CompoundProtocolClass) port.getProtocol();
			for (SubProtocol sp : cpc.getSubProtocols()) {
				if (sp.getName().equals(sub))
					return sp;
			}
		}

		return null;
	}

	private EObject getLayerConnection(RoomClass rc, String name) {
		int pos = name.indexOf(CONN_SEP);
		if (pos<0)
			return null;

		if (rc instanceof StructureClass) {
			String saptname = name.substring(0, pos);
			String spptname = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			SAPoint sapt = getSAPoint(sc, saptname);
			SPPoint sppt = getSPPoint(sc, spptname);
			for (LayerConnection bi : sc.getConnections()) {
				if (isSAPoint(bi.getFrom(),sapt) && isSPPoint(bi.getTo(),sppt))
					return bi;
			}
		}
		return null;
	}

	private SPPoint getSPPoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;
		String refName = name.substring(0, pos);
		String sppName = name.substring(pos+1, name.length());

		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) sc).getActorRefs()) {
				if (ar.getName().equals(refName)) {
					for (SPP spp : ar.getType().getServiceProvisionPoints())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ar);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}
		else if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(refName)) {
					for (SPP spp: ssr.getType().getServiceProvisionPoints())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ssr);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}

		return null;
	}

	private SAPoint getSAPoint(StructureClass sc, String name) {
		SAPoint sapt = getRelaySAPoint(sc, name);
		if (sapt!=null)
			return sapt;
		return getRefSAPoint(sc, name);
	}

	private SAPoint getRefSAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass)sc).getActorRefs()) {
				if (ar.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ar);
					return sapt;
				}
			}
		}
		if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ssr);
					return sapt;
				}
			}
		}
		return null;
	}

	private SAPoint getRelaySAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (SPP spp : ((ActorContainerClass) sc).getServiceProvisionPoints()) {
				if (spp.getName().equals(name)) {
					RelaySAPoint sapt = RoomFactory.eINSTANCE.createRelaySAPoint();
					sapt.setRelay(spp);
					return sapt;
				}
			}
		}
		return null;
	}

	private boolean isSAPoint(SAPoint a, SAPoint b) {
		if (a instanceof RefSAPoint && b instanceof RefSAPoint) {
			return ((RefSAPoint)a).getRef().getName().equals(((RefSAPoint)b).getRef().getName());
		}
		else if (a instanceof RelaySAPoint && b instanceof RelaySAPoint) {
			return ((RelaySAPoint)a).getRelay().getName().equals(((RelaySAPoint)b).getRelay().getName());
		}
		return false;
	}

	private boolean isSPPoint(SPPoint a, SPPoint b) {
		if (!a.getRef().getName().equals(b.getRef().getName()))
			return false;

		if (!a.getService().getName().equals(b.getService().getName()))
			return false;

		return true;
	}

	private ActorContainerRef getActorContainerRef(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) rc).getActorRefs()) {
				if (ar.getName().equals(name))
					return ar;
			}
			if (rc instanceof ActorClass)
				if (((ActorClass) rc).getActorBase()!=null)
					return getActorContainerRef(((ActorClass) rc).getActorBase(), name);
		}
		else if (rc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) rc).getSubSystems()) {
				if (ssr.getName().equals(name))
					return ssr;
			}
		}
		return null;
	}

	protected Port getPort(RoomClass rc, String name) {
		if (rc instanceof ActorClass) {
			for (Port p : ((ActorClass) rc).getInterfacePorts()) {
				if (p.getName().equals(name))
					return p;
			}
			for (Port p : ((ActorClass) rc).getInternalPorts()) {
				if (p.getName().equals(name))
					return p;
			}
			if (((ActorClass) rc).getActorBase()!=null)
				return getPort(((ActorClass) rc).getActorBase(), name);
		}
		else if (rc instanceof SubSystemClass) {
			for (Port p : ((SubSystemClass) rc).getRelayPorts()) {
				if (p.getName().equals(name))
					return p;
			}
		}
		return null;
	}

	protected SPP getSPP(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (SPP spp : ((ActorContainerClass) rc).getServiceProvisionPoints()) {
				if (spp.getName().equals(name))
					return spp;
			}
			if (rc instanceof ActorClass)
				if (((ActorClass)rc).getActorBase()!=null)
					return getSPP(((ActorClass)rc).getActorBase(), name);
		}
		return null;
	}

	protected AnnotationType getAnnotationType(RoomModel model, String name) {
		for(AnnotationType at : model.getAnnotationTypes()) {
			if(at.getName().equals(name)) {
				return at;
			}
		}
		return null;
	}

	private RoomClass getRoomClass(RoomModel model, String className) {
		for (DataClass dc : model.getDataClasses()) {
			if (dc.getName() != null && dc.getName().equals(className))
				return dc;
		}
		for (ExternalType et : model.getExternalTypes()) {
			if (et.getName() != null && et.getName().equals(className))
				return et;
		}
		for (PrimitiveType pt : model.getPrimitiveTypes()) {
			if (pt.getName() != null && pt.getName().equals(className))
				return pt;
		}
		for (EnumerationType et : model.getEnumerationTypes()) {
			if (et.getName() != null && et.getName().equals(className))
				return et;
		}
		for (GeneralProtocolClass pc : model.getProtocolClasses()) {
			if (pc.getName() != null && pc.getName().equals(className))
				return pc;
		}
		for (ActorClass ac : model.getActorClasses()) {
			if (ac.getName() != null && ac.getName().equals(className))
				return ac;
		}
		for (SubSystemClass ssc : model.getSubSystemClasses()) {
			if (ssc.getName() != null && ssc.getName().equals(className))
				return ssc;
		}
		for (LogicalSystem ls : model.getSystems()) {
			if (ls.getName() != null && ls.getName().equals(className))
				return ls;
		}
		return null;
	}

}
