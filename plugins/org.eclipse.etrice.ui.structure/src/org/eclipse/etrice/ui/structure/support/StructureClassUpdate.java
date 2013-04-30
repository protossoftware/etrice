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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.structure.support.context.ConnectionUpdateContext;
import org.eclipse.etrice.ui.structure.support.context.InitialAddConnectionContext;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.feature.ShapeUpdateFeature;
import org.eclipse.etrice.ui.structure.support.provider.ConnectionProvider;
import org.eclipse.etrice.ui.structure.support.provider.DefaultPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class StructureClassUpdate extends ShapeUpdateFeature {

	public StructureClassUpdate(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	protected boolean canUpdate(EObject bo, PictogramElement pe) {
		return bo instanceof StructureClass && !(pe instanceof Diagram);
	}
	
	@Override
	protected boolean update(EObject bo, IUpdateContext context) {		
		StructureClass sc = (StructureClass)bo;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		Map<EObject, PictogramElement> newPes = new HashMap<EObject, PictogramElement>();
		
		IPositionProvider positionProvider = null;
		if(context instanceof PositionUpdateContext){
			positionProvider = ((PositionUpdateContext)context).getPositionProvider();
			GraphicsAlgorithm invRect = containerShape.getGraphicsAlgorithm();
			GraphicsAlgorithm innerRect = containerShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
			positionProvider = positionProvider.setNewParent(sc, DiagramUtil.getPosAndSize(invRect), DiagramUtil.getPosAndSize(innerRect));
		}
		ConnectionProvider connectionProvider = new ConnectionProvider(getFeatureProvider());
		
		// ACTOR_CONTAINER_REF
		{
			Map<EObject, Shape> present = getChildrenShapesForBoClass(containerShape, RoomPackage.Literals.ACTOR_CONTAINER_REF);
			List<ActorContainerRef> toAdd = RoomHelpers.getAllActorContainerRefs(sc);
			toAdd.removeAll(present.keySet());
			
			Map<EObject, Shape> newShapes = addShapesInitial(toAdd, containerShape);
			// initial add on actorRef does not create anchors of its interface items
			updateShapes(newShapes.values(), positionProvider);
			connectionProvider.insertAnchors(newShapes.values());
			newPes.putAll(newShapes);
			
			updateShapes(present.values(), positionProvider);
			connectionProvider.insertAnchors(present.values());
		}
		// INTERFACE_ITEM
		{
			Map<EObject, Shape> present = getChildrenShapesForBoClass(containerShape, RoomPackage.Literals.INTERFACE_ITEM);
			List<InterfaceItem> toAdd = RoomHelpers.getInterfaceItems(sc, true);
			if(sc instanceof ActorClass){
				ActorClass base = (ActorClass)sc;
				while(base != null){
					toAdd.addAll(base.getIntPorts());
					base = base.getBase();
				}
			}
			toAdd.removeAll(present.keySet());
			
			Map<EObject, Shape> newShapes = addShapesInitial(toAdd, containerShape);
			connectionProvider.insertAnchors(newShapes.values());
			newPes.putAll(newShapes);
			
			updateShapes(present.values(), positionProvider);
			connectionProvider.insertAnchors(present.values());
		}
		// LAYER_CONNECTION		
		{
			Map<EObject, Connection> present = getAllConnectionsForBoClass(getDiagram(), RoomPackage.Literals.LAYER_CONNECTION);
			List<LayerConnection> toAdd = RoomHelpers.getConnections(sc, true);
			toAdd.removeAll(present.keySet());
			
			Map<EObject, Connection> newConns = addConnectionsInitial(toAdd, connectionProvider);
			updateConnections(newConns.values(), null, positionProvider);
			updateConnections(present.values(), connectionProvider, positionProvider);
		}
		// BINDING
		{
			Map<EObject, Connection> present = getAllConnectionsForBoClass(getDiagram(), RoomPackage.Literals.BINDING);
			List<Binding> toAdd = RoomHelpers.getBindings(sc, true);
			toAdd.removeAll(present.keySet());
			
			Map<EObject, Connection> newConns = addConnectionsInitial(toAdd, connectionProvider);
			updateConnections(newConns.values(), null, positionProvider);
			updateConnections(present.values(), connectionProvider, positionProvider);
		}
		
		// set position of new elements (actorRef, interface items)
		
		Map<EObject, PictogramElement> withPosition = new HashMap<EObject, PictogramElement>();
		Map<EObject, PictogramElement> withoutPosition = new HashMap<EObject, PictogramElement>();
		if(positionProvider == null)
			withoutPosition = newPes;
		else {
			for(EObject obj : newPes.keySet())
				if(positionProvider.contains(obj))
					withPosition.put(obj, newPes.get(obj));
				else
					withoutPosition.put(obj, newPes.get(obj));
		}
		
		updatePictogramElements(withPosition.values(), positionProvider);
		if(!withoutPosition.isEmpty()){
			IPositionProvider autoPositionsProvider = new DefaultPositionProvider(sc, containerShape, withoutPosition.keySet());
			updatePictogramElements(withoutPosition.values(), autoPositionsProvider);
		}
		
		return true;
	}
	
	private void updateShapes(Collection<Shape> toUpdate, IPositionProvider pp) {
		if(pp != null)
			updatePictogramElements(toUpdate, pp);
		else
			updatePictogramElements(toUpdate);
	}

	private void updateConnections(Collection<Connection> toUpdate, ConnectionProvider cp, IPositionProvider pp) {
		if(cp != null){
			for(PictogramElement pe : toUpdate){
				IUpdateContext context = new ConnectionUpdateContext(pe, cp);
				getFeatureProvider().updateIfPossibleAndNeeded(context);
			}
		}
		if(pp != null)
			updatePictogramElements(toUpdate, pp);
		if(cp == null && pp == null)
			updatePictogramElements(toUpdate);
		
	}

	@Override
	protected IReason updateNeeded(EObject bo, IUpdateContext context) {
		return Reason.createTrueReason();
	}
	
	private Map<EObject,Connection> addConnectionsInitial(List<? extends EObject> toAdd, ConnectionProvider cp){
		Map<EObject,Connection> created = new HashMap<EObject, Connection>();
		
		for(EObject bo : toAdd){
			PictogramElement pe = getFeatureProvider().addIfPossible(new InitialAddConnectionContext(bo, cp));
			if(pe != null){
				assert(pe instanceof Connection) : "unexpected type";
				created.put(bo, (Connection) pe);
			} 
		}
		
		return created;
	}

}
