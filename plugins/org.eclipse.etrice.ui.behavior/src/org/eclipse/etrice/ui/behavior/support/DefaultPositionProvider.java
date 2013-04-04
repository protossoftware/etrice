/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.etrice.ui.behavior.commands.StateGraphContext;
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

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class DefaultPositionProvider implements IPositionProvider {
	private static class Position {
		double x;
		double y;
		double sx;
		double sy;
	}
	
	private HashMap<String, Position> obj2pos = new HashMap<String, Position>();
	private HashMap<String, ArrayList<Position>> trans2points = new HashMap<String, ArrayList<Position>>();
	private HashMap<String, StateGraph> initialPointObj = new HashMap<String, StateGraph>();
	private HashMap<String, PosAndSize> sg2sz = new HashMap<String, PosAndSize>();
	private double scaleX;
	private double scaleY;
	
	public DefaultPositionProvider(ActorClass ac) {
		mapPositions(ac.getBase());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.support.IPositionProvider#setScale(double, double)
	 */
	@Override
	public void setScale(double sx, double sy) {
		this.scaleX = sx;
		this.scaleY = sy;
	}

	public PosAndSize getPosition(StateGraphNode node) {
		Position pos = obj2pos.get(RoomNameProvider.getFullPath(node));
		if (pos==null)
			return null;
		
		int margin = getMargin(node);
		PosAndSize pt = new PosAndSize(
				(int) (pos.x * scaleX) + margin,
				(int) (pos.y * scaleY) + margin,
				(int) (pos.sx * scaleX),
				(int) (pos.sy * scaleY)
			);
		return pt;
	}
	
	@Override
	public PosAndSize getPosition(StateGraph graph) {
		EObject container = graph.eContainer();
		String path = "#init";
		if(container instanceof StateGraphNode)
			path = RoomNameProvider.getFullPath((StateGraphNode)container) + path;
		Position pos = obj2pos.get(path);
		
		if (pos==null)
			return null;
		
		int margin = getMargin(graph);
		PosAndSize pt = new PosAndSize(
			(int) (pos.x * scaleX) + margin,
			(int) (pos.y * scaleY) + margin,
			(int) (pos.sx * scaleX),
			(int) (pos.sy * scaleY)
		);
		return pt;
	}

	public List<Pos> getPoints(Transition trans) {
		ArrayList<Pos> result = new ArrayList<Pos>();
		
		ArrayList<Position> list = trans2points.get(RoomNameProvider.getFullPath(trans));
		if (list!=null) {
			for (Position p : list) {
				Pos pos = 
					new Pos(
						(int) (p.x * scaleX),
						(int) (p.y * scaleY)
					);
				result.add(pos);
			}
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.support.IPositionProvider#getPositions(java.util.List)
	 */
	@Override
	public <T extends StateGraphNode> List<PosAndSize> getPositions(List<T> nodes) {
		ArrayList<PosAndSize> result = new ArrayList<PosAndSize>(nodes.size());
		
		if (nodes.isEmpty())
			return result;
		
		int n = 0;
		for (T node : nodes) {
			PosAndSize pt = getPosition(node);
			result.add(pt);
			if (pt==null)
				n++;
		}

		int delta = (int) (scaleX/(n+1));
		int pos = delta;
		
		int h = StateGraphSupport.MARGIN;
		if (nodes.get(0) instanceof State)
			h = StateGraphSupport.MARGIN + StateGraphSupport.DEFAULT_SIZE_Y/4;
		else if (nodes.get(0) instanceof ChoicePoint)
			h = StateGraphSupport.MARGIN + StateGraphSupport.DEFAULT_SIZE_Y/2;
		else if (nodes.get(0) instanceof TrPoint)
			h = StateGraphSupport.MARGIN;
		else {
			assert(false): "unexpected sub type";
		}
		
		for (int i=0; i<nodes.size(); ++i) {
			if (result.get(i)==null) {
				PosAndSize pt = new PosAndSize(
						pos,
						h,
						0,
						0
					);
				result.set(i, pt);
				
				pos += delta;
			}
		}
		
		return result;
	}

	/**
	 * Load base class diagrams recursively and put midpoint positions relative to boundary rectangle into map.
	 * 
	 * Positions are relative to the invisible rectangle. They are transformed to the border rectangle and normalized.
	 * 
	 * @param ac
	 * @param obj2pos
	 */
	private void mapPositions(ActorClass ac) {
		if (ac==null)
			return;

		Diagram diagram = new DiagramAccess().getDiagram(ac);
		if (diagram==null)
			return;
		
		StateGraphContext tree = StateGraphContext.createContextTree(SupportUtil.getActorClass(diagram));
		
		ILinkService linkService = Graphiti.getLinkService();
		for (Shape sgShape : diagram.getChildren()) {
			// this is the level of StateGraphs
			if (sgShape instanceof ContainerShape) {
				EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(sgShape);
				GraphicsAlgorithm borderRect = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
				double width = borderRect.getWidth();
				double height = borderRect.getHeight();
				PosAndSize sz = new PosAndSize(
						sgShape.getGraphicsAlgorithm().getX(), sgShape.getGraphicsAlgorithm().getY(),
						borderRect.getWidth(), borderRect.getHeight());
				sg2sz.put(RoomNameProvider.getFullPath((StateGraph) obj), sz);
				for (Shape sgItemShape : ((ContainerShape)sgShape).getChildren()) {
					// this is the level of States, TrPoints and ChoicePoints
					obj = linkService.getBusinessObjectForLinkedPictogramElement(sgItemShape);
					GraphicsAlgorithm ga = sgItemShape.getGraphicsAlgorithm();
					if(ga==null)
						continue;
					int margin = 0;
					String path = null;
					if (obj instanceof StateGraphNode) {
						StateGraphNode node = (StateGraphNode)obj;
						margin = getMargin(node);
						path = RoomNameProvider.getFullPath((StateGraphItem) obj);						
					} else if(obj instanceof StateGraph){
						StateGraph graph = (StateGraph)obj;
						margin = getMargin(graph);
						EObject container = graph.eContainer();
						path = "#init";
						if(container instanceof StateGraphNode)
							path = RoomNameProvider.getFullPath((StateGraphNode)container) + path;
						initialPointObj.put(path, graph);
					}
					if(path != null){
						Position pos = new Position();
						pos.x = ga.getX() / width;
						pos.y = ga.getY() / height;
						pos.sx = (ga.getWidth() - 2*margin) / width;
						pos.sy = (ga.getHeight()- 2*margin) / height;
						obj2pos.put(path, pos);
					}
					
					// Entry and Exit Points on State borders are treated by the insertion of the State
				}
			}
		}
		
		for (Connection conn : diagram.getConnections()) {
			EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(conn);
			if (obj instanceof Transition) {
				ConnectionDecorator cd = conn.getConnectionDecorators().get(1);
				if (cd.getGraphicsAlgorithm() instanceof Text) {
					Transition trans = (Transition) obj;
					StateGraph sg = tree.getContext(trans).getStateGraph();
					
					// graph size
					PosAndSize sz = sg2sz.get(RoomNameProvider.getFullPath(sg));
					ArrayList<Position> points = new  ArrayList<Position>();
					trans2points.put(RoomNameProvider.getFullPath((Transition) obj), points);
					
					// label position
					Position pos = new Position();
					pos.x = cd.getGraphicsAlgorithm().getX() / ((double)sz.getWidth());
					pos.y = cd.getGraphicsAlgorithm().getY() / ((double)sz.getHeight());
					points.add(pos);
					
					if (conn instanceof FreeFormConnection) {
						for (Point bp : ((FreeFormConnection) conn).getBendpoints()) {
							pos = new Position();
							pos.x = bp.getX() / ((double)sz.getWidth());
							pos.y = bp.getY() / ((double)sz.getHeight());
							points.add(pos);
						}
					}
				}

			}
		}
		
		// recursion
		mapPositions(ac.getBase());
	}

	private int getMargin(StateGraphNode node) {
		if (node instanceof State)
			return StateSupport.MARGIN;
		else if (node instanceof TrPoint)
			return TrPointSupport.MARGIN;
		
		return 0;
	}
	
	private int getMargin(StateGraph graph) {
		return 0;
	}
	
	public StateGraph getInitialPoint(StateGraph graph){
		EObject container = graph.eContainer();
		String path = "#init";
		if(container instanceof StateGraphNode)
			path = RoomNameProvider.getFullPath((StateGraphNode)container) + path;
		return initialPointObj.get(path);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.support.IPositionProvider#getGraphSize(org.eclipse.etrice.core.room.StateGraph)
	 */
	@Override
	public PosAndSize getGraphPosAndSize(StateGraph sg) {
		return sg2sz.get(RoomNameProvider.getFullPath(sg));
	}
}
