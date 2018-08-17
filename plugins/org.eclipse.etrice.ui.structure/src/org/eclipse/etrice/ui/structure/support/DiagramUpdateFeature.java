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
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.DiagramAccess;
import org.eclipse.etrice.ui.structure.support.context.DeleteContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.PosAndSize;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class DiagramUpdateFeature extends AbstractUpdateFeature {

	public DiagramUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof EObject) || ((EObject) bo).eIsProxy())
			return false;
		
		return true;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if(bo instanceof EObject){
			EObject eBo = (EObject)bo;
			if (eBo.eIsProxy()) 
				return Reason.createTrueReason("Deleted from model");
			
			StructureClass sc = (StructureClass) bo;
			if(sc instanceof ActorClass && ((ActorClass)sc).getBase() != null)
				return new Reason(true);
			if(updateConnectionsNeeded(getDiagram()))
				return new Reason(true);
			if(updateNeeded(getDiagram()))
				return new Reason(true);
			if(!new DiagramAccess().getDiagramName(sc).equals(getDiagram().getName()))
				return new Reason(true);
		}

		return new Reason(false);
	}

	/**
	 * This just removes dangling connections (bindings and layer connections).
	 * New or changed ones are handled by the structure class support.
	 * 
	 * @param diagram
	 * @return
	 */
	private boolean updateConnectionsNeeded(Diagram diagram) {
		boolean needed = false;

		for (Connection conn : new ArrayList<Connection>(diagram.getConnections())) {
			UpdateContext context = new DeleteContext(conn);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context))
				if (updateFeature.updateNeeded(context).toBoolean())
					needed = true;
		}
		return needed;
	}

	/**
	 * @param diagram
	 * @return
	 */
	private boolean updateNeeded(ContainerShape container) {
		boolean needed = false;
		
		for (Shape child : new ArrayList<Shape>(container.getChildren())) {
			if (child instanceof ContainerShape)
				if (updateNeeded((ContainerShape) child))
					needed = true;
		}
		
		// avoid infinite recursion by not entering with diagram again
		if (!(container instanceof Diagram)) {
			UpdateContext context = new UpdateContext(container);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context))
				if (updateFeature.updateNeeded(context).toBoolean())
					needed = true;
		}
		
		return needed;
	}

	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		StructureClass sc = (StructureClass) bo;
		ContainerShape scShape = DiagramUtil.findScShape(getDiagram());
		IPositionProvider positionProvider = null;
		if(context instanceof PositionUpdateContext)
			positionProvider = ((PositionUpdateContext) context).getPositionProvider();
		
		if(scShape == null)
			scShape = createStructureClass(sc, positionProvider);
				
		boolean doneChanges = updateConnections(getDiagram());
		
		if (updateIfNeeded(getDiagram()))
			doneChanges = true;
		
		// structure class update
		if(scShape != null){
			IUpdateContext ctx;
			if(positionProvider != null)
				ctx = new PositionUpdateContext(scShape, positionProvider);
			else
				ctx = new UpdateContext(scShape);
			
			doneChanges |= getFeatureProvider().updateIfPossible(ctx).toBoolean();
		} 
		
		String diagramName = new DiagramAccess().getDiagramName(sc);
		if(!diagramName.equals(getDiagram().getName())){
			getDiagram().setName(new DiagramAccess().getDiagramName(sc));
			doneChanges = true;
		}
		
		return doneChanges;
	}

	/**
	 * This just removes dangling connections (bindings and layer connections).
	 * New or changed ones are handled by the structure class support.
	 * 
	 * @param diagram
	 * @return
	 */
	private boolean updateConnections(Diagram diagram) {
		boolean doneChanges = false;

		ArrayList<Connection> connections = new ArrayList<Connection>(diagram.getConnections());
		for (Connection conn : connections) {
			UpdateContext context = new DeleteContext(conn);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context))
				if (updateFeature.updateNeeded(context).toBoolean())
					if (updateFeature.update(context))
						doneChanges = true;
		}
		return doneChanges;
	}

	/**
	 * @param diagram
	 * @return
	 */
	private boolean updateIfNeeded(ContainerShape container) {
		boolean doneChanges = false;
		
		// first recursion because ref ports might be needed for bindings
		// we need to make a copy since children might be removed
		ArrayList<Shape> children = new ArrayList<Shape>(container.getChildren());
		for (Shape child : children) {
			if (child instanceof ContainerShape)
				if (updateIfNeeded((ContainerShape) child))
					doneChanges = true;
		}
		
		// avoid infinite recursion by not entering with diagram again
		if (!(container instanceof Diagram)) {
			UpdateContext context = new UpdateContext(container);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature!=null && updateFeature.canUpdate(context))
				if (updateFeature.updateNeeded(context).toBoolean())
					if (updateFeature.update(context))
						doneChanges = true;
		}
		
		return doneChanges;
	}
	
	private ContainerShape createStructureClass(StructureClass sc, IPositionProvider positionProvider){
		AddContext addContext = new AddContext();
		addContext.setNewObject(sc);
		addContext.setTargetContainer(getDiagram());
		addContext.setX(StructureClassSupport.MARGIN);
		addContext.setY(StructureClassSupport.MARGIN);
				
		ContainerShape scShape = (ContainerShape) getFeatureProvider().addIfPossible(addContext);
		
		if(positionProvider != null){
			PosAndSize pos = positionProvider.getDiagramPosition();
			GraphicsAlgorithm ga = scShape.getGraphicsAlgorithm();
			if(pos != null){
				ga.setX(pos.getX());
				ga.setY(pos.getY());
				if(pos.getW() > 0)
					ga.setWidth(pos.getW());
				if(pos.getH() > 0)
					ga.setHeight(pos.getH());
			}
		}
		
		return scShape;
	}

}
