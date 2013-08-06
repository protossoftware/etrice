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

package org.eclipse.etrice.ui.structure.support;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider.PosAndSize;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.PropertyContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.services.IPeService;

public class DiagramUtil {
	
	public static boolean isSupported(Object obj){
		 return  obj instanceof StructureClass
				 || obj instanceof ActorContainerRef
				 || obj instanceof InterfaceItem
				 || obj instanceof Binding 
				 || obj instanceof LayerConnection;
	}
	
	public static boolean isConnection(EObject bo){
		return bo instanceof Binding
				|| bo instanceof LayerConnection;
	}
	
	public static String getResourcePath(EObject bo){
		assert(isSupported(bo)) : "unexpected type";
		return bo.eResource().getURI().toString()+bo.eResource().getURIFragment(bo);
	}
	
	public static ContainerShape findScShape(Diagram diagram){
		ILinkService linkService = Graphiti.getLinkService();
		for(Shape child : diagram.getChildren()){
			Object bo = linkService.getBusinessObjectForLinkedPictogramElement(child);
			if(bo instanceof StructureClass)
				return (ContainerShape) child;
		}
		
		return null;
	}
	
	public static PosAndSize getPosAndSize(GraphicsAlgorithm ga){
		return new PosAndSize(ga.getX(), ga.getY(), ga.getWidth(), ga.getHeight());
	}
	
	public static PropertyContainer findProp(List<? extends PropertyContainer> items, String key, String value){
		IPeService peService = Graphiti.getPeService();
		for(PropertyContainer p : items)
			if(value.equals(peService.getPropertyValue(p, key)))
				return p;
		
		return null;
	}
}
