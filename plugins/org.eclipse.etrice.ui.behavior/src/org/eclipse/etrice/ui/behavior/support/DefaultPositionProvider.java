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
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
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

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.support.IPositionProvider#getPositions(java.util.List)
	 */
	@Override
	public <T extends StateGraphNode> List<PosAndSize> getPositions(List<T> items) {
		ArrayList<PosAndSize> result = new ArrayList<PosAndSize>(items.size());
		
		if (items.isEmpty())
			return result;
		
		int n = 0;
		int idx = 0;
		for (T item : items) {
			Position pos = obj2pos.get(RoomNameProvider.getFullPath(item));
			if (pos!=null) {
				int margin = 0;
				if (item instanceof State)
					margin = StateSupport.MARGIN;
				else if (item instanceof TrPoint)
					margin = TrPointSupport.MARGIN;
				PosAndSize pt = new PosAndSize(
						(int) (pos.x * scaleX) + margin,
						(int) (pos.y * scaleY) + margin,
						(int) (pos.sx * scaleX),
						(int) (pos.sy * scaleY)
					);
				result.add(idx, pt);
			}
			else {
				result.add(idx, null);
				n++;
			}
			idx++;
		}

		int delta = (int) (scaleX/(n+1));
		int pos = delta;
		
		int h = StateGraphSupport.MARGIN;
		if (items.get(0) instanceof State)
			h = StateGraphSupport.MARGIN + StateGraphSupport.DEFAULT_SIZE_Y/4;
		else if (items.get(0) instanceof ChoicePoint)
			h = StateGraphSupport.MARGIN + StateGraphSupport.DEFAULT_SIZE_Y/2;
		else if (items.get(0) instanceof TrPoint)
			h = StateGraphSupport.MARGIN;
		else {
			assert(false): "unexpected sub type";
		}
		
		for (int i=0; i<items.size(); ++i) {
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
			idx++;
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
		
		ILinkService linkService = Graphiti.getLinkService();
		for (Shape sgShape : diagram.getChildren()) {
			// this is the level of StateGraphs
			if (sgShape instanceof ContainerShape) {
				GraphicsAlgorithm borderRect = sgShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
				double width = borderRect.getWidth();
				double height = borderRect.getHeight();
				for (Shape sgItemShape : ((ContainerShape)sgShape).getChildren()) {
					// this is the level of States, TrPoints and ChoicePoints
					EObject obj = linkService.getBusinessObjectForLinkedPictogramElement(sgItemShape);
					if (obj instanceof StateGraphItem) {
						GraphicsAlgorithm ga = sgItemShape.getGraphicsAlgorithm();
						if (ga!=null) {
							int margin = 0;
							if (obj instanceof State)
								margin = StateSupport.MARGIN;
							else if (obj instanceof TrPoint)
								margin = TrPointSupport.MARGIN;
							Position pos = new Position();
							pos.x = ga.getX() / width;
							pos.y = ga.getY() / height;
							pos.sx = (ga.getWidth() - 2*margin) / width;
							pos.sy = (ga.getHeight()- 2*margin) / height;
							obj2pos.put(RoomNameProvider.getFullPath((StateGraphItem) obj), pos);
						}
						// Entry and Exit Points on State borders are treated by the insertion of the State
					}
				}
			}
		}
		
		// recursion
		mapPositions(ac.getBase());
	}

}
