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

package org.eclipse.etrice.ui.structure.support.feature;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.ui.structure.support.context.InitialAddShapeContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.PosAndSize;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public abstract class ShapeUpdateFeature extends CommonUpdateFeature {

	public ShapeUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	protected void setPosition(EObject bo, Shape shape, PositionUpdateContext context){
		PosAndSize pos = context.getPositionProvider().getPosition(bo);
		if(pos != null){
			GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			ga.setX(pos.getX());
			ga.setY(pos.getY());
			if(pos.getW() > 0)
				ga.setWidth(pos.getW());
			if(pos.getH() > 0)
				ga.setHeight(pos.getH());
		}
	}
	
	protected Map<EObject, Shape> getChildrenShapesForBoClass(ContainerShape containerShape, EClass boEClass){
		Map<EObject, Shape> items = new HashMap<EObject ,Shape>();
		
		for(Shape shape : containerShape.getChildren()){
			Object bo = getBusinessObjectForPictogramElement(shape);
			if(boEClass.isInstance(bo))
				items.put((EObject)bo, shape);
		}
		
		return items;
	}
	
	protected Map<EObject, Shape> addShapesInitial(List<? extends EObject> toAdd, ContainerShape containerShape) {
		Map<EObject, Shape> shapes = new HashMap<EObject, Shape>();
		for(EObject bo : toAdd){
			PictogramElement pe = getFeatureProvider().addIfPossible(new InitialAddShapeContext(bo, containerShape));
			if(pe != null){
				assert(pe instanceof Shape) : "unexpected type";
				Shape shape = (Shape)pe;
				shapes.put(bo, shape);
			}
		}
		
		return shapes;
	}
	
	protected void updatePictogramElements(Collection<? extends PictogramElement> toUpdate, IPositionProvider pp) {
		for(PictogramElement pe : toUpdate)
			getFeatureProvider().updateIfPossibleAndNeeded(new PositionUpdateContext(pe, pp));
	}
	
	protected void updatePictogramElements(Collection<? extends PictogramElement> toUpdate) {
		for(PictogramElement pe : toUpdate)
			getFeatureProvider().updateIfPossibleAndNeeded(new UpdateContext(pe));
	}

}
