/*******************************************************************************
 * Copyright (c) 2012 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.layout;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.etrice.ui.structure.support.ActorContainerRefSupport;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.graphiti.KimlGraphitiUtil;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * Layout Manager implementation for eTrice Structure Editor.
 * 
 * @author jayant
 */
@SuppressWarnings("restriction")
public class StructureDiagramLayoutManager extends ETriceDiagramLayoutManager {

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean supports(final Object object) {

		return object instanceof StructureEditor
				|| object instanceof IPictogramElementEditPart
				|| object instanceof PictogramElement;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void buildLayoutGraphForBoundingBox(
			LayoutMapping<PictogramElement> mapping, Diagram diagram,
			KNode diagramNode, boolean onlyVisible) {

		for (Shape boundingBox : ((Diagram) diagram).getChildren()) {
			if (boundingBox.isVisible()) {
				buildAllLevels(mapping, boundingBox, diagramNode);
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected Dimension getDefaultSize(Shape shape) {

		Dimension defaultSize = new Dimension();

		// This code sets the same minimal default size for both Actor Class and
		// Actor Container Refs
		defaultSize.setSize(ActorContainerRefSupport.MIN_SIZE_X,
				ActorContainerRefSupport.MIN_SIZE_Y);

		/*
		 * This code snippet sets default the size for Actor Class and Actor
		 * Container Refs differently. With this the top-level container remains
		 * large after layout (according to the default size in
		 * StructureSupport), which might not look proper.
		 */
		/*
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof ActorClass) {
			defaultSize.setSize(StructureClassSupport.DEFAULT_SIZE_X,
					StructureClassSupport.DEFAULT_SIZE_Y);
		} else if (modelObject instanceof ActorContainerRef) {
			defaultSize.setSize(ActorContainerRefSupport.MIN_SIZE_X,
					ActorContainerRefSupport.MIN_SIZE_Y);
		} else {
			defaultSize.setSize(20, 20);
		}*/

		return defaultSize;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected KNode createNode(final LayoutMapping<PictogramElement> mapping,
			final KNode parentNode, final Shape shape) {
		KNode node = KimlUtil.createInitializedNode();
		node.setParent(parentNode);

		setCurrentPositionAndSize(mapping, parentNode, node, shape);

		mapping.getGraphMap().put(node, shape);

		// gather all connections connected to Internal ports in the diagram.
		// It is of no use to ActorRefs as they do-not possess direct
		// connection(They have all connections via port).
		for (Anchor anchor : shape.getAnchors()) {
			mapping.getProperty(KimlGraphitiUtil.CONNECTIONS).addAll(
					anchor.getOutgoingConnections());
		}

		return node;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean isBoundaryPort(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if ((modelObject instanceof InterfaceItem && !isInternal((InterfaceItem) modelObject))
				|| modelObject instanceof SPPoint
				|| modelObject instanceof SAPoint)
			return true;

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean isInternalPort(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);

		if ((modelObject instanceof InterfaceItem && isInternal((InterfaceItem) modelObject)))
			return true;

		return false;
	}

	/*
	 * This method has been derived from
	 * org.eclipse.eTrice.ui.structure.InterfaceItem.FeatureProvider
	 */
	private static boolean isInternal(InterfaceItem item) {
		if (item instanceof Port) {
			Port port = (Port) item;

			// NB: the port's container might be a base class of the depicted
			// actor class
			ActorContainerClass acc = (ActorContainerClass) port.eContainer();
			if (acc instanceof ActorClass) {
				ActorClass ac = (ActorClass) acc;
				if (ac.getInternalPorts().contains(port))
					return true;
			}
		} else if (item instanceof SPP) {
			return false;
		} else {
			assert (false) : "unexpected sub type";
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean isTopLevelBoundingBox(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof ActorClass)
			return true;

		return false;
	}

}
