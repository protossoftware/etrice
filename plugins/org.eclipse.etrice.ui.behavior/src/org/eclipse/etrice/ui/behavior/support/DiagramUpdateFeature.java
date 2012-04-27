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

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.ui.behavior.commands.StateGraphContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class DiagramUpdateFeature extends AbstractUpdateFeature {

	private ArrayList<Shape> usedShapes = new ArrayList<Shape>();
	
	/**
	 * @param fp
	 */
	public DiagramUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.IUpdate#canUpdate(org.eclipse.graphiti.features.context.IUpdateContext)
	 */
	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.IUpdate#updateNeeded(org.eclipse.graphiti.features.context.IUpdateContext)
	 */
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		ActorClass ac = SupportUtil.getActorClass(getDiagram());
		StateGraphContext tree = StateGraphContext.createContextTree(ac);
		
		usedShapes.clear();
		
		IReason needed = updateNeeded(tree);
		if (needed.toBoolean())
			return needed;
		
		// check for unused state graph shapes
		for (Shape sgshape : getDiagram().getChildren()) {
			if (!usedShapes.contains(sgshape))
				return Reason.createTrueReason();
			
			if (sgshape instanceof ContainerShape) {
				for (Shape child : ((ContainerShape) sgshape).getChildren()) {
					if (child instanceof ContainerShape && !usedShapes.contains(child))
						return Reason.createTrueReason();
				}
			}
		}
		
		return Reason.createFalseReason();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.IUpdate#update(org.eclipse.graphiti.features.context.IUpdateContext)
	 */
	@Override
	public boolean update(IUpdateContext context) {
		IReason needed = updateNeeded(context);
		return false;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private IReason updateNeeded(StateGraphContext ctx) {
		StateGraph sg = ctx.getStateGraph();
		ContainerShape cont = findStateGraphContainer(sg);
		if (cont==null)
			return Reason.createTrueReason();
		
		usedShapes.add(cont);
		
		// check contents
		IReason needed = itemsNeeded(cont, ctx.getStates());
		if (needed.toBoolean())
			return needed;
		needed = itemsNeeded(cont, ctx.getChPoints());
		if (needed.toBoolean())
			return needed;
		needed = itemsNeeded(cont, ctx.getTrPoints());
		if (needed.toBoolean())
			return needed;
		
		// recursion
		for (StateGraphContext child : ctx.getChildren()) {
			needed = updateNeeded(child);
			if (needed.toBoolean())
				return needed;
		}
		
		return Reason.createFalseReason();
	}

	/**
	 * @param cont
	 * @param items
	 */
	private IReason itemsNeeded(ContainerShape cont, ArrayList<? extends StateGraphItem> items) {
		for (StateGraphItem item : items) {
			ContainerShape child = findStateGraphItemContainer(item, cont);
			if (child==null)
				return Reason.createTrueReason();

			usedShapes.add(child);

			UpdateContext context = new UpdateContext(child);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context)) {
				IReason needed = updateFeature.updateNeeded(context);
				if (needed.toBoolean())
					return needed;
			}
		}
		
		return Reason.createFalseReason();
	}

	/**
	 * @param stateGraph
	 * @return
	 */
	private ContainerShape findStateGraphContainer(StateGraph sg) {
		for (Shape child : getDiagram().getChildren()) {
			Object bo = getBusinessObjectForPictogramElement(child);
			if (bo==sg)
				return (ContainerShape) child;
		}
		return null;
	}

	/**
	 * @param stateGraph
	 * @return
	 */
	private ContainerShape findStateGraphItemContainer(StateGraphItem item, ContainerShape cont) {
		for (Shape child : cont.getChildren()) {
			Object bo = getBusinessObjectForPictogramElement(child);
			if (bo==item)
				return (ContainerShape) child;
		}
		return null;
	}

}
