/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.support.ActorContainerRefSupport;
import org.eclipse.etrice.ui.structure.support.DiagramUtil;
import org.eclipse.etrice.ui.structure.support.InterfaceItemSupport;
import org.eclipse.etrice.ui.structure.support.StructureClassSupport;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;


public class DefaultPositionProvider implements IPositionProvider {

	private class Position {
		
		public Position(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		double x;
		double y;
	}
	
	private class Parent {
		EObject bo;
		PosAndSize inner;
	}
	
	private Map<String, Position> obj2pos;
	private Map<String, Position> obj2text;
	private Set<RoomClass> mappedClasses;
	private Parent parent;
	
	private DefaultPositionProvider(){
		obj2pos = new HashMap<String, Position>();
		obj2text = new HashMap<String, Position>();
		mappedClasses = new HashSet<RoomClass>();
		
		parent = new Parent();
		parent.bo = null;
		parent.inner = new PosAndSize(StructureClassSupport.MARGIN, StructureClassSupport.MARGIN,
				StructureClassSupport.DEFAULT_SIZE_X, StructureClassSupport.DEFAULT_SIZE_Y);
	}
	
	public DefaultPositionProvider(ActorContainerRef acr) {
		this();
		
		parent.bo = acr;
		parent.inner = new PosAndSize(ActorContainerRefSupport.MARGIN, ActorContainerRefSupport.MARGIN,
				ActorContainerRefSupport.DEFAULT_SIZE_X, ActorContainerRefSupport.DEFAULT_SIZE_Y);
		
		mapChildrenInterfaceItems(acr);
	}

	public DefaultPositionProvider(StructureClass sc, ContainerShape scShape,
			Set<EObject> toLayout) {
		this();
		parent.bo = sc;
		parent.inner = DiagramUtil.getPosAndSize(scShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0));
		
		int width = parent.inner.getW();
		int height = parent.inner.getH();
		int y = ActorContainerRefSupport.DEFAULT_SIZE_Y*5/2;
		
		List<ActorContainerRef> refs = new ArrayList<ActorContainerRef>();
		List<InterfaceItem> ifItems = new ArrayList<InterfaceItem>();
		List<InterfaceItem> intPorts = new ArrayList<InterfaceItem>();
		
		for(EObject obj : toLayout){
			if(obj instanceof ActorContainerRef)
				refs.add((ActorContainerRef) obj);
			else if(obj instanceof InterfaceItem)
				if(obj.eContainer() == sc)
					intPorts.add((InterfaceItem) obj);
				else
					ifItems.add((InterfaceItem) obj);
		}
		
		layoutInterfaceItems(ifItems, width, height, -InterfaceItemSupport.MARGIN);
		
		layoutActorRefs(refs, width, height, y);
		y += ActorContainerRefSupport.DEFAULT_SIZE_Y*5/2;
		
		layoutInterfaceItems(intPorts, width, height, y);
	}

	public DefaultPositionProvider(StructureClass sc) {
		this();
		parent.bo = sc;
		
		int width = StructureClassSupport.DEFAULT_SIZE_X;
		int height = StructureClassSupport.DEFAULT_SIZE_Y;
		int y = ActorContainerRefSupport.DEFAULT_SIZE_Y*5/2;
		
		layoutInterfaceItems(RoomHelpers.getInterfaceItems(sc, true), width, height, -InterfaceItemSupport.MARGIN);
		
		layoutActorRefs(RoomHelpers.getAllActorContainerRefs(sc), width, height, y);
		y += ActorContainerRefSupport.DEFAULT_SIZE_Y*5/2;
		
		List<InterfaceItem> intPorts = new ArrayList<InterfaceItem>();
		if(sc instanceof ActorClass){
			ActorClass base = (ActorClass)sc;
			while(base != null){
				intPorts.addAll(base.getIntPorts());
				base = base.getBase();
			}
		}
		layoutInterfaceItems(intPorts, width, height, y);
		
	}

	@Override
	public IPositionProvider setNewParent(EObject parent,
			PosAndSize invisibleRect, PosAndSize innerRect) {
		DefaultPositionProvider pp = new DefaultPositionProvider();
		pp.mappedClasses = this.mappedClasses;
		pp.obj2pos = this.obj2pos;
		pp.obj2text = this.obj2text;
		
		pp.parent.bo = parent;
		pp.parent.inner = innerRect;
		
		return pp;
	}

	@Override
	public PosAndSize getPosition(EObject bo) {
		Position pos = obj2pos.get(getKey(bo));
		
		int width = 0, height = 0;
		// interface items of actore refs are mid points
		if(bo instanceof InterfaceItem && parent.bo instanceof ActorContainerRef)
			width = height = 2*InterfaceItemSupport.MARGIN_SMALL;
		
		if(pos != null){
			return new PosAndSize(
					(int) (pos.x*parent.inner.getW()) + parent.inner.getX() - width/2,
					(int) (pos.y*parent.inner.getH()) + parent.inner.getY() - height/2,
					-1, -1);
		}
		
		return null;
	}

	@Override
	public boolean contains(EObject obj) {
		String key = getKey(obj);
		return obj2pos.containsKey(key) || obj2text.containsKey(key);
	}

	private void mapChildrenInterfaceItems(ActorContainerRef acr) {
		ActorContainerClass acc = null;
		if(acr instanceof ActorRef)
			acc = ((ActorRef) acr).getType();
		else if(acr instanceof SubSystemRef)
			acc = ((SubSystemRef) acr).getType();
		
		if(acc == null || mappedClasses.contains(acc))
			return;
		
		Diagram diagram = new DiagramAccess().getDiagram(acc);
		if (diagram == null)
			return;

		ContainerShape scShape = DiagramUtil.findScShape(diagram);
		if(scShape == null)
			return;
		
		ILinkService linkService = Graphiti.getLinkService();
		EObject acc2 = linkService.getBusinessObjectForLinkedPictogramElement(scShape);
		if(!acc2.eResource().getURI().equals(acc.eResource().getURI()))
			return;
		
		if(scShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().isEmpty())
			return;
		
		GraphicsAlgorithm borderRect = scShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
		
		for(Shape child : scShape.getChildren()){
			Object bo = linkService.getBusinessObjectForLinkedPictogramElement(child);
			if(bo instanceof InterfaceItem){
				GraphicsAlgorithm ga = child.getGraphicsAlgorithm();
				Position pos = new Position(
						(double)(ga.getX()-borderRect.getX()+ga.getWidth()/2)/borderRect.getWidth(),
						(double)(ga.getY()-borderRect.getY()+ga.getHeight()/2)/borderRect.getHeight());
				obj2pos.put(getKey((EObject) bo), pos);
			}
		}
		
		mappedClasses.add(acc);
	}

	private void layoutActorRefs(List<? extends ActorContainerRef> actorRefs, int width, int height, int y0){
		int ncols = width/ActorContainerRefSupport.DEFAULT_SIZE_X;
		int nrows = actorRefs.size()/ncols;
		int gap = (width-(ncols*ActorContainerRefSupport.DEFAULT_SIZE_X))/(ncols+1);
		int delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
		int x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
		int i = 0;
		for (ActorContainerRef ar : actorRefs) {
			int row = i/ncols;
			int col = i%ncols;
			if (row>=nrows) {
				int nc = actorRefs.size()%ncols;
				gap = (width-(nc*ActorContainerRefSupport.DEFAULT_SIZE_X))/(nc+1);
				delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
				x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
			}
			int x = x0+delta*col;
			int y = y0+(ActorContainerRefSupport.MARGIN+ActorContainerRefSupport.DEFAULT_SIZE_Y)*row;
			obj2pos.put(getKey(ar), new Position((double)x/width, (double)y/height));
			++i;
		}
	}
	
	private void layoutInterfaceItems(List<? extends InterfaceItem> items, int width, int height, int y0){
		int n = items.size();
		int delta = width/(n+1);
		int pos = delta;
		for (InterfaceItem item : items) {
			obj2pos.put(getKey(item),  new Position((double)pos/width, (double)y0/height));
			pos += delta;
		}
	}
	
	private String getKey(EObject obj){
		return DiagramUtil.getResourcePath(obj);
	}


	@Override
	public List<Pos> getConnectionBendpoints(EObject obj) {
		return new ArrayList<Pos>();
	}

	@Override
	public PosAndSize getDiagramPosition() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Pos getConnectionText(EObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
