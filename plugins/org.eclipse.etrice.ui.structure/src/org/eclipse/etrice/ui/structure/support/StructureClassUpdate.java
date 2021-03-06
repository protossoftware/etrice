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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StructureClass;
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

import com.google.common.collect.Sets;

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
			Set<ActorContainerRef> expected = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getAllActorContainerRefs(sc));
			
			for(EObject obj : Sets.difference(present.keySet(), expected))
				removeGraphicalRepresentation(present.get(obj));
			
			Map<EObject, Shape> newShapes = addShapesInitial(Sets.difference(expected, present.keySet()), containerShape);
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
			Set<InterfaceItem> expected = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getInterfaceItems(sc, true));
			if(sc instanceof ActorClass){
				ActorClass base = (ActorClass)sc;
				while(base != null){
					expected.addAll(base.getInternalPorts());
					base = base.getActorBase();
				}
			}
			
			for(EObject obj : Sets.difference(present.keySet(), expected))
				removeGraphicalRepresentation(present.get(obj));
			
			Map<EObject, Shape> newShapes = addShapesInitial(Sets.difference(expected, present.keySet()), containerShape);
			connectionProvider.insertAnchors(newShapes.values());
			newPes.putAll(newShapes);
			
			updateShapes(present.values(), positionProvider);
			connectionProvider.insertAnchors(present.values());
		}
		// LAYER_CONNECTION		
		{
			Map<EObject, Connection> present = getAllConnectionsForBoClass(getDiagram(), RoomPackage.Literals.LAYER_CONNECTION);
			Set<LayerConnection> expected = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getConnections(sc, true));
			
			for(EObject obj : Sets.difference(present.keySet(), expected))
				removeGraphicalRepresentation(present.get(obj));
			
			Map<EObject, Connection> newConns = addConnectionsInitial(Sets.difference(expected, present.keySet()), connectionProvider);
			updateConnections(newConns.values(), null, positionProvider);
			updateConnections(present.values(), connectionProvider, positionProvider);
		}
		// BINDING
		{
			Map<EObject, Connection> present = getAllConnectionsForBoClass(getDiagram(), RoomPackage.Literals.BINDING);
			Set<Binding> expected = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getBindings(sc, true));
			
			for(EObject obj : Sets.difference(present.keySet(), expected))
				removeGraphicalRepresentation(present.get(obj));
			
			Map<EObject, Connection> newConns = addConnectionsInitial(Sets.difference(expected, present.keySet()), connectionProvider);
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
		StructureClass sc = (StructureClass) bo;
		ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
		String reason = "";
		
		// TODO: refactor to single method for updateNeeded/update
		Set<InterfaceItem> expectedItems = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getInterfaceItems(sc, true));
		Set<InterfaceItem> presentItems = Sets.newHashSet(SupportUtil.getInstance().getInterfaceItems(containerShape, getFeatureProvider()));
		if(sc instanceof ActorClass){
			ActorClass base = (ActorClass)sc;
			while(base != null){
				expectedItems.addAll(base.getInternalPorts());
				base = base.getActorBase();
			}
		}
		if(!expectedItems.equals(presentItems))
			reason += "interface item(s) missing or outdated\n";
		
		
		Set<ActorContainerRef> expectedRefs = Sets.newHashSet(SupportUtil.getInstance().getRoomHelpers().getAllActorContainerRefs(sc));
		Set<ActorContainerRef> presentRefs = Sets.newHashSet(SupportUtil.getInstance().getRefs(containerShape, getFeatureProvider()));
		if(!expectedRefs.equals(presentRefs))
			reason += "actor ref(s) missing or outdated\n";
		
		if(!reason.isEmpty())
			return Reason.createTrueReason();
		
		return Reason.createFalseReason();
	}
	
	private Map<EObject,Connection> addConnectionsInitial(Collection<? extends EObject> toAdd, ConnectionProvider cp){
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
