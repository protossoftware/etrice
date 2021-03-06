/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.ArrayList;

import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.util.DiagramEditingUtil;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IDiagramBehavior;

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
		IStateGraphContext tree = createStateGraphContext();
		
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
		
		// check for dangling connections or connections to update
		for (Connection conn : getDiagram().getConnections()) {
			if (conn.getStart()==null || conn.getEnd()==null)
				return Reason.createTrueReason();

			UpdateContext uf = new UpdateContext(conn);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(uf);
			if (updateFeature!=null && updateFeature.canUpdate(uf)) {
				IReason needUpdate = updateFeature.updateNeeded(uf);
				if (needUpdate.toBoolean())
					return needUpdate;
			}
		}
		
		return Reason.createFalseReason();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.func.IUpdate#update(org.eclipse.graphiti.features.context.IUpdateContext)
	 */
	@Override
	public boolean update(IUpdateContext context) {
		IStateGraphContext tree = createStateGraphContext();

		StateGraph currentStateGraph = ContextSwitcher.getCurrentStateGraph(getDiagram());
		
		usedShapes.clear();
		
		boolean changed = update(tree);
		
		// remove unused state graph shapes
		ArrayList<Shape> children = new ArrayList<Shape>(getDiagram().getChildren());
		for (Shape sgshape : children) {
			if (!usedShapes.contains(sgshape)) {
				IRemoveContext rc = new RemoveContext(sgshape);
				IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(rc);
				if (removeFeature != null) {
					removeFeature.remove(rc);
					if (removeFeature.hasDoneChanges())
						changed = true;
				}
			}
		}
		
		// remove dangling connections and update other ones
		ArrayList<Connection> connections = new ArrayList<Connection>(getDiagram().getConnections());
		for (Connection conn : connections) {
			if (conn.getStart()==null || conn.getEnd()==null) {
				IRemoveContext rc = new RemoveContext(conn);
				IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(rc);
				if (removeFeature != null) {
					removeFeature.remove(rc);
					if (removeFeature.hasDoneChanges())
						changed = true;
				}
			}
			else {
				UpdateContext uf = new UpdateContext(conn);
				IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(uf);
				if (updateFeature!=null && updateFeature.canUpdate(uf)) {
					if (updateFeature.update(uf))
						changed = true;
				}
			}
		}
		
		// if we inserted states they have been selected: reset the selection
		IDiagramBehavior diagramBehavior = getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior();
		if (diagramBehavior != null)
			diagramBehavior.getDiagramContainer().setPictogramElementForSelection(null);
		
		
		ContextSwitcher.switchTo(getDiagram(), currentStateGraph);
		
		return changed;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private IReason updateNeeded(IStateGraphContext ctx) {
		StateGraph sg = ctx.getStateGraph();
		ContainerShape cont = findStateGraphContainer(sg);
		if (cont==null)
			return Reason.createTrueReason("sub graph missing");
		
		usedShapes.add(cont);
		
		StateGraphUpdateContext context = new StateGraphUpdateContext(cont, ctx);
		IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
		if (updateFeature!=null && updateFeature.canUpdate(context)) {
			IReason needUpdate = updateFeature.updateNeeded(context);
			if (needUpdate.toBoolean())
				return needUpdate;
		}
		
		for (Shape child : cont.getChildren()) {
			UpdateContext uf = new UpdateContext(child);
			updateFeature = getFeatureProvider().getUpdateFeature(uf);
			if (updateFeature!=null && updateFeature.canUpdate(uf)) {
				IReason needUpdate = updateFeature.updateNeeded(uf);
				if (needUpdate.toBoolean())
					return needUpdate;
			}
		}
		
		// recursion
		for (IStateGraphContext child : ctx.getChildren()) {
			IReason needUpdate = updateNeeded(child);
			if (needUpdate.toBoolean())
				return needUpdate;
		}
		
		return Reason.createFalseReason();
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean update(IStateGraphContext ctx) {
		boolean changed = false;
		
		StateGraph sg = ctx.getStateGraph();
		ContainerShape cont = findStateGraphContainer(sg);
		if (cont==null) {
			// create
			cont = DiagramEditingUtil.getInstance().addStateGraph(ctx, getDiagram(), getFeatureProvider());
			changed = true;
			usedShapes.add(cont);
		}
		else {
			// update
			StateGraphUpdateContext context = new StateGraphUpdateContext(cont, ctx);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context)) {
				changed = updateFeature.update(context);
			}
			usedShapes.add(cont);
			
			// need a copy since original list may be modified by removal of shapes
			ArrayList<Shape> children = new ArrayList<Shape>(cont.getChildren());
			
			for (Shape child : children) {
				UpdateContext uf = new UpdateContext(child);
				updateFeature = getFeatureProvider().getUpdateFeature(uf);
				if (updateFeature!=null && updateFeature.canUpdate(uf)) {
					changed = updateFeature.update(uf);
				}
			}
		}
		
		// recursion
		for (IStateGraphContext child : ctx.getChildren()) {
			if (update(child))
				changed = true;
		}
		
		return changed;
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
	
	private IStateGraphContext createStateGraphContext(){
		ModelComponent mc = FSMSupportUtil.getInstance().getModelComponent(getDiagram());
//    	Injector injector = ((IInjectorProvider) getFeatureProvider()).getInjector();
//		StateGraphContext tree = StateGraphContext.createContextTree(mc, injector);
		
		// side effect on model, but diagram needs that for initial graph shape
		if(mc.getStateMachine() == null || mc.getStateMachine().eIsProxy()){
			mc.setStateMachine(FSMFactory.eINSTANCE.createStateGraph());
		}
		
		IStateGraphContext tree = new GenModelStateGraphContext((AbstractFSMDiagramTypeProvider)getFeatureProvider().getDiagramTypeProvider());
		
		return tree;
	}

}
