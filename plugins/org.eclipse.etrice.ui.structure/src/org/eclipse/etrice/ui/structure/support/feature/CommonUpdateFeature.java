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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.ui.structure.support.context.DeleteContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public abstract class CommonUpdateFeature extends AbstractUpdateFeature {
	
	public CommonUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public final boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (bo instanceof EObject){
			EObject eBo = (EObject)bo;
			if(eBo.eIsProxy())
				return true;
			
			return canUpdate(eBo, context.getPictogramElement());
		}
		
		return false;
	}
	
	protected abstract boolean canUpdate(EObject bo, PictogramElement pe);

	@Override
	public final IReason updateNeeded(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if(bo instanceof EObject){
			EObject eBo = (EObject)bo;
			if (eBo.eIsProxy()) 
				return Reason.createTrueReason("Deleted from model");
			if(context instanceof PositionUpdateContext)
				return new Reason(true);
		
			return updateNeeded(eBo, context);
		}
		
		return new Reason(false);
	}
	
	protected abstract IReason updateNeeded(EObject bo, IUpdateContext context);

	@Override
	public final boolean update(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof EObject){
			EObject eBo = (EObject)bo;
			if(eBo.eIsProxy()) {
				IRemoveContext rc = new RemoveContext(pe);
				IFeatureProvider featureProvider = getFeatureProvider();
				IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
				if (removeFeature != null)
					removeFeature.remove(rc);
				EcoreUtil.delete((EObject) bo);
				return true;
			}
			
			if(!(context instanceof DeleteContext))
				return update(eBo, context);
		}
		
		return false;
	}
	
	protected abstract boolean update(EObject bo, IUpdateContext context);
	
	protected Map<EObject, Connection> getAllConnectionsForBoClass(Diagram diagram,
			EClass boEClass) {
		Map<EObject, Connection> connections = new HashMap<EObject, Connection>();
		for(Connection conn : diagram.getConnections()){
			Object bo = getBusinessObjectForPictogramElement(conn);
			if(boEClass.isInstance(bo))
				connections.put((EObject)bo, conn);
		}
		
		return connections;
	}

}
