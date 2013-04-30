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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.ui.structure.support.DiagramUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class ConnectionProvider {

	private Map<String, Anchor> connectionMap;
	private IFeatureProvider fp;
	
	public ConnectionProvider(IFeatureProvider featureProvider){
		connectionMap = new HashMap<String, Anchor>();
		fp = featureProvider;
	}
	
	public void insertAnchors(Collection<Shape> collection){
		for(Shape shape : collection){
			if(!shape.getAnchors().isEmpty()){
				EObject bo = (EObject) fp.getBusinessObjectForPictogramElement(shape);
				Object parentBo = fp.getBusinessObjectForPictogramElement(shape.getContainer());
				if(bo instanceof InterfaceItem){
					if(parentBo instanceof ActorContainerRef)
						connectionMap.put(getKey(bo, (ActorContainerRef)parentBo), shape.getAnchors().get(0));
					else
						connectionMap.put(getKey(bo, null), shape.getAnchors().get(0));	
				}
			}
			if(shape instanceof ContainerShape)
				insertAnchors(((ContainerShape)shape).getChildren());
		}
	}
	
	public Anchor getAnchor(BindingEndPoint endPoint){
		return connectionMap.get(getKey(endPoint.getPort(), endPoint.getActorRef()));
	}
	
	public Anchor getAnchor(SAPoint point){
		if(point instanceof RelaySAPoint)
			return connectionMap.get(getKey(((RelaySAPoint) point).getRelay(), null));
		assert(false) : "unexpected type";
		return null;
	}
	
	public Anchor getAnchor(SPPoint point){
		return connectionMap.get(getKey(point.getService(), point.getRef()));
	}
	
	private String getKey(EObject item, ActorContainerRef acr){
		if(acr != null)
			return DiagramUtil.getResourcePath(acr)+DiagramUtil.getResourcePath(item);
		return DiagramUtil.getResourcePath(item);
	}
}
