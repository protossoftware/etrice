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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.ui.structure.support.InterfaceItemSupport;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;

/**
 * A command for applying the result of automatic layout to diagram elements in
 * eTrice Structure Editor.
 * 
 * @author jayant
 */
public class StructureLayoutCommand extends ETriceLayoutCommand {

	public StructureLayoutCommand(TransactionalEditingDomain domain,
			IFeatureProvider thefeatureProvider) {
		super(domain, thefeatureProvider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void applyNodeLayout(KNode knode, PictogramElement pelem) {

		setCalculatedPositionAndSize(knode, knode.getParent(),
				(ContainerShape) pelem);

		// Checking whether this node corresponds to an internal port or
		// ActorContainerRef
		EObject modelObject = pelem.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof InterfaceItem) {
			// adjust label for internal port
			adjustLabelForPort((ContainerShape) pelem);
		}
	};

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void applyPortLayout(KPort kport, PictogramElement pelem) {

		ContainerShape shape = (ContainerShape) ((Anchor) pelem).getParent();

		setCalculatedPositionAndSize(kport, kport.getNode(), shape);

		// adjust label for this (boundary)port
		adjustLabelForPort(shape);
	}

	/**
	 * Extracts relevant information and delegates it to
	 * {@link #adjustLabel(Text, int, int, int, int, int)} for proper adjustment
	 * of port label
	 * 
	 * @param shape
	 *            the Shape for the port
	 * 
	 * @author jayant
	 */
	private static void adjustLabelForPort(ContainerShape shape) {
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		EObject boContainer = shape.getContainer().getLink()
				.getBusinessObjects().get(0);

		// First make sure that the shape corresponds to a Port
		EObject bo = shape.getLink().getBusinessObjects().get(0);
		if (bo instanceof InterfaceItem) {
			// margin and size for bounding box (ActorClass )
			int margin = InterfaceItemSupport.MARGIN;
			int size = InterfaceItemSupport.ITEM_SIZE;

			if (boContainer instanceof ActorContainerRef) {
				// margin and size for ActorContainerRef
				margin = InterfaceItemSupport.MARGIN_SMALL;
				size = InterfaceItemSupport.ITEM_SIZE_SMALL;
			}

			Text label = (Text) (shape.getChildren().get(0)
					.getGraphicsAlgorithm());

			adjustLabel(label, ga.getX(), ga.getY(), ga.getWidth(), margin,
					size);
		}
	};

	/**
	 * Sets correct port label position depending on the corresponding port
	 * position.
	 * 
	 * @param label
	 *            Text Graphics Algorithm to be placed
	 * @param x
	 *            The x coordinate of the containing shape
	 * @param y
	 *            The y coordinate of the containing shape
	 * @param width
	 *            The width of the containing shape
	 * @param margin
	 *            The margin of the containing shape
	 * @param size
	 *            The size(length/width) of the port's visible graphics
	 *            algorithm
	 * 
	 */
	/*
	 * This method has been copied from InterfaceItemSuppot.FeatureProvider
	 * class since its visibility is not public there
	 */
	private static void adjustLabel(Text label, int x, int y, int width,
			int margin, int size) {
		Orientation align = Orientation.ALIGNMENT_CENTER;
		label.setHorizontalAlignment(align);

		int pos = margin + size / 2;

		if (x <= margin)
			align = Orientation.ALIGNMENT_LEFT;
		else if ((width - margin) <= x)
			align = Orientation.ALIGNMENT_RIGHT;
		if (y <= margin)
			pos = (margin - size) / 2;

		if (align != label.getHorizontalAlignment()) {
			label.setHorizontalAlignment(align);
		}
		if (pos != label.getY()) {
			IGaService gaService = Graphiti.getGaService();
			gaService.setLocationAndSize(label, 0, pos, 2 * margin, margin / 2);
		}
	}
}
