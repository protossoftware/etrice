/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.ui.layout;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.ui.behavior.support.TrPointSupport;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
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
 * eTrice Behavior Editor.
 * 
 * @author jayant
 */
public class BehaviorLayoutCommand extends ETriceLayoutCommand {

	public BehaviorLayoutCommand(TransactionalEditingDomain domain,
			IFeatureProvider thefeatureProvider) {
		super(domain, thefeatureProvider);
		// TODO Auto-generated constructor stub
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

		getFeatureProvider().layoutIfPossible(new LayoutContext(pelem));

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

		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
		EObject bo = shape.getContainer().getLink().getBusinessObjects().get(0);

		// margin and size for bounding box (State Graph)
		int margin = TrPointSupport.MARGIN;
		int size = TrPointSupport.ITEM_SIZE;

		if (bo instanceof State) {
			// margin and size for a State
			margin = TrPointSupport.MARGIN_SMALL;
			size = TrPointSupport.ITEM_SIZE_SMALL;
		}

		Text label = (Text) (shape.getChildren().get(0).getGraphicsAlgorithm());

		adjustLabel(label, ga.getX(), ga.getY(), ga.getWidth(), margin, size);

		getFeatureProvider().layoutIfPossible(new LayoutContext(shape));

	}

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
	 * This method has been copied from TrPointSuppot.FeatureProvider class
	 * since its visibility is not public there
	 */
	private static void adjustLabel(Text label, int x, int y, int width,
			int margin, int size) {
		Orientation halign = Orientation.ALIGNMENT_CENTER;
		Orientation valign = Orientation.ALIGNMENT_CENTER;

		int pos = 0;

		if (x <= margin)
			halign = Orientation.ALIGNMENT_LEFT;
		else if ((width - margin) <= x)
			halign = Orientation.ALIGNMENT_RIGHT;
		if (y <= margin) {
			pos = 0;
			valign = Orientation.ALIGNMENT_BOTTOM;
		} else {
			pos = 5 * margin / 4;
			valign = Orientation.ALIGNMENT_TOP;
		}

		label.setHorizontalAlignment(halign);
		label.setVerticalAlignment(valign);

		if (pos != label.getY()) {
			IGaService gaService = Graphiti.getGaService();
			gaService.setLocationAndSize(label, 0, pos, 2 * margin,
					3 * margin / 4);
		}
	}

}
