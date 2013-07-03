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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.support.ActorContainerRefSupport;
import org.eclipse.etrice.ui.structure.support.DiagramUtil;
import org.eclipse.etrice.ui.structure.support.InterfaceItemSupport;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

public class SuperDiagramPositionProvider implements IPositionProvider {

	private class Position {
		double x;
		double y;
		double sx = -1;
		double sy = -1;
	}
	
	private class Parent {
		EObject bo;
		String key;
		PosAndSize inv, inner;
	}

	private PosAndSize superDiagramPosition;
	private HashMap<String, Position> obj2pos;
	private HashMap<String, Position> obj2text;
	private HashMap<String, ArrayList<Position>> obj2bendpoints;
	private Parent parent;

	private SuperDiagramPositionProvider(){	}
	
	public SuperDiagramPositionProvider(StructureClass sc) {
		obj2pos = new HashMap<String, Position>();
		obj2text = new HashMap<String, Position>();
		obj2bendpoints = new HashMap<String, ArrayList<Position>>();
		
		// defaults
		parent = new Parent();
		parent.bo = sc;
		parent.key = getKey(sc);
		// parent.inv & parent.inner at mapPositions()
		
		if (sc instanceof ActorClass) {
			ActorClass base = ((ActorClass) sc).getBase();
			if (base != null)
				mapPositions(base);
		}
	}

	@Override
	public SuperDiagramPositionProvider setNewParent(EObject parent, PosAndSize invisibleRect, PosAndSize innerRect) {
		SuperDiagramPositionProvider pp = new SuperDiagramPositionProvider();
		pp.obj2pos = this.obj2pos;
		pp.obj2text = this.obj2text;
		pp.obj2bendpoints = this.obj2bendpoints;
		pp.superDiagramPosition = this.superDiagramPosition;
		
		Parent newParent = new Parent();
		newParent.bo = parent;
		newParent.key = getKey(parent);
		newParent.inv = invisibleRect;
		newParent.inner = innerRect;
		
		pp.parent = newParent;
		
		return pp;
	}

	@Override
	public boolean contains(EObject obj) {
		String key = getKey(obj);
		return obj2pos.containsKey(key) || obj2text.containsKey(key) || obj2bendpoints.containsKey(key);
	}

	@Override
	public PosAndSize getDiagramPosition() {
		return superDiagramPosition;
	}

	@Override
	public PosAndSize getPosition(EObject bo) {
		Position pos = obj2pos.get(getKey(bo));
		if (pos==null)
			return null;
		
		boolean fixedSize = false;
		int width = 0, height = 0;
		if(bo instanceof InterfaceItem){
			if(parent.bo instanceof ActorContainerRef)
				width = height = 2*InterfaceItemSupport.MARGIN_SMALL;
			else
				width = height = 2*InterfaceItemSupport.MARGIN;
			fixedSize = true;
		} else if(bo instanceof ActorContainerRef){
			int margin = ActorContainerRefSupport.MARGIN;
			width = (int) (pos.sx * parent.inner.getW()) + 2*margin;
			height = (int) (pos.sy * parent.inner.getH()) + 2*margin;
		}
		
		return new PosAndSize(
			(int) (pos.x * parent.inner.getW()) - width/2 + parent.inner.getX(),
			(int) (pos.y * parent.inner.getH()) - height/2 + parent.inner.getY(),
			(fixedSize)?-1:width, 
			(fixedSize)?-1:height);
	}

	@Override
	public Pos getConnectionText(EObject obj) {
		Position pos = obj2text.get(getKey(obj));
		if(pos == null)
			return null;
		
		return new Pos(
				(int) (pos.x * parent.inner.getW()) + parent.inner.getX() + parent.inv.getX(),
				(int) (pos.y * parent.inner.getH()) + parent.inner.getY() + parent.inv.getY());
	}

	@Override
	public List<Pos> getConnectionBendpoints(EObject obj) {
		ArrayList<Pos> result = new ArrayList<Pos>();
		
		ArrayList<Position> list = obj2bendpoints.get(getKey(obj));
		if(list == null)
			return result;
		
		for (Position p : list) {
			Pos pos = new Pos(
					(int) (p.x * parent.inner.getW()) + parent.inner.getX() + parent.inv.getX(),
					(int) (p.y * parent.inner.getH()) + parent.inner.getY() + parent.inv.getY());
			result.add(pos);
		}
		
		return result;
	}

	private void mapPositions(ActorClass ac) {
		Diagram diagram = new DiagramAccess().getDiagram(ac);
		if (diagram == null)
			return;

		ContainerShape acShape = DiagramUtil.findScShape(diagram);
		if(acShape == null)
			return;
		
		ILinkService linkService = Graphiti.getLinkService();
		EObject sc = linkService.getBusinessObjectForLinkedPictogramElement(acShape);
		if(!sc.eResource().getURI().equals(ac.eResource().getURI()))
			return;

		PosAndSize acInv = DiagramUtil.getPosAndSize(acShape.getGraphicsAlgorithm());
		PosAndSize acInner = DiagramUtil.getPosAndSize(acShape.getGraphicsAlgorithm()
					.getGraphicsAlgorithmChildren().get(0));
		
		superDiagramPosition = acInv;
		// default
		parent.inv = acInv;
		parent.inner = acInner;
		
		// refs & interface items
		for (Shape shape : ((ContainerShape) acShape).getChildren()) {
			EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(shape);
			
			// positions
			if (obj instanceof ActorContainerRef || obj instanceof InterfaceItem) {
				
				PosAndSize objInv = DiagramUtil.getPosAndSize(shape.getGraphicsAlgorithm());
				PosAndSize objInner = DiagramUtil.getPosAndSize(shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0));
				
				Position pos = new Position();
				pos.x =  (double)(objInv.getX() - acInner.getX() + objInv.getW()/2) / acInner.getW();
				pos.y =  (double)(objInv.getY() - acInner.getY() + objInv.getH()/2) / acInner.getH();
				pos.sx = (double)(objInner.getW()) / acInner.getW();
				pos.sy = (double)(objInner.getH()) / acInner.getH();
				obj2pos.put(getKey(obj), pos);
				
				// refs interface items
				if (obj instanceof ActorContainerRef){
					for(Shape child : ((ContainerShape)shape).getChildren()){
						EObject childBo = linkService.getBusinessObjectForLinkedPictogramElement(child);
						
						if(!(childBo instanceof InterfaceItem))
							continue;
						PosAndSize ifInv = DiagramUtil.getPosAndSize(child.getGraphicsAlgorithm());
						
						Position p = new Position();
						p.x = (double)(ifInv.getX() - objInner.getX() + ifInv.getW()/2) / objInner.getW();
						p.y = (double)(ifInv.getY() - objInner.getY() + ifInv.getH()/2) / objInner.getH();
						obj2pos.put(getKey(obj)+getKey(childBo), p);
						
					}
				}
			}
		}

		// bindings & layer connections
		for (Connection conn : diagram.getConnections()) {
			EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(conn);

			if (obj instanceof Binding || obj instanceof LayerConnection) {

				// label position
				if (conn.getConnectionDecorators().size() > 1) {
					ConnectionDecorator cd = conn.getConnectionDecorators().get(1);
					if (cd.getGraphicsAlgorithm() instanceof Text) {
						GraphicsAlgorithm ga = cd.getGraphicsAlgorithm();
						Position pos = new Position();
						pos.x = (double)(ga.getX() - acInv.getX() - acInner.getX()) / acInner.getW();
						pos.y = (double)(ga.getY() - acInv.getY() - acInner.getY()) / acInner.getH();
						obj2text.put(getKey(obj), pos);
					}
				}
				
				// bend points
				if (conn instanceof FreeFormConnection) {
					ArrayList<Position> points = new ArrayList<Position>();
					for (Point bp : ((FreeFormConnection) conn).getBendpoints()) {
						Position pos = new Position();
						pos.x = (double)(bp.getX() - acInv.getX() - acInner.getX()) / acInner.getW();
						pos.y = (double)(bp.getY() - acInv.getY() - acInner.getY()) / acInner.getH();
						points.add(pos);
					}
					if(!points.isEmpty())
						obj2bendpoints.put(getKey(obj), points);
				}
			}
		}
		
	}
	
	private String getKey(EObject bo){
		// short path
		if(bo instanceof StructureClass)
			return "";
		
		return parent.key+DiagramUtil.getResourcePath(bo);
	}
}
