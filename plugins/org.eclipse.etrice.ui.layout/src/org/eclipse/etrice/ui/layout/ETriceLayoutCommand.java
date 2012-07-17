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

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KGraphElement;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.core.math.KVectorChain;
import de.cau.cs.kieler.kiml.graphiti.GraphitiLayoutCommand;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;

/**
 * A command for applying the result of automatic layout to an eTrice
 * editor(Graphiti) diagram.
 * 
 * @author jayant
 */
public class ETriceLayoutCommand extends GraphitiLayoutCommand {

	public ETriceLayoutCommand(TransactionalEditingDomain domain,
			IFeatureProvider thefeatureProvider) {
		super(domain, thefeatureProvider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void applyPortLayout(KPort kport, PictogramElement pelem) {

		ContainerShape shape = (ContainerShape) ((Anchor) pelem).getParent();

		setCalculatedPositionAndSize(kport, kport.getNode(), shape);
	};

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void applyNodeLayout(KNode knode, PictogramElement pelem) {

		setCalculatedPositionAndSize(knode, knode.getParent(),
				(ContainerShape) pelem);

	};

	/**
	 * {@inheritDoc}
	 * 
	 */
	/*
	 * The code used in this function has been taken from
	 * GraphitilayoutCommand.applyEdgeLayout() method. (Removing some unwanted
	 * code)
	 */
	@Override
	protected void applyEdgeLayout(final KEdge kedge,
			final PictogramElement pelem) {
		// create bend points for the edge
		KVectorChain bendPoints = getBendPoints(kedge);

		if (pelem instanceof FreeFormConnection) {
			FreeFormConnection connection = (FreeFormConnection) pelem;
			List<Point> pointList = connection.getBendpoints();
			// add the bend points to the connection, reusing existing points
			for (int i = 0; i < bendPoints.size(); i++) {
				KVector kpoint = bendPoints.get(i);
				if (i >= pointList.size()) {
					Point point = Graphiti.getGaService().createPoint(
							(int) Math.round(kpoint.x),
							(int) Math.round(kpoint.y));
					pointList.add(point);
				} else {
					Point point = pointList.get(i);
					point.setX((int) Math.round(kpoint.x));
					point.setY((int) Math.round(kpoint.y));
				}
			}
			while (pointList.size() > bendPoints.size()) {
				pointList.remove(pointList.size() - 1);
			}
		}
	}

	/**
	 * Sets the calculated position and size from a KGraph Model-Element (Node or
	 * Port) back to the corresponding diagram shape.
	 * 
	 * @param kelem
	 *            the KGraph Model Element (Node/Port)
	 * @param parentNode
	 *            for nodes : the parent node , for ports : the containing node
	 * @param shape
	 *            the corresponding pictogram element for Node/Port
	 * 
	 * @author jayant
	 */
	/*
	 * This function derives its code majorly from
	 * GraphitilayoutCommand.applyNodeLayout() method
	 */
	private void setCalculatedPositionAndSize(final KGraphElement kelem,
			KNode parentNode, final ContainerShape shape) {

		KShapeLayout shapeLayout = kelem.getData(KShapeLayout.class);
		float xpos = shapeLayout.getXpos();
		float ypos = shapeLayout.getYpos();

		if (parentNode != null) {
			KInsets parentInsets = parentNode.getData(KShapeLayout.class)
					.getProperty(INVIS_INSETS);
			if (parentInsets != null) {
				xpos += parentInsets.getLeft();
				ypos += parentInsets.getRight();
			}
		}

		float width = shapeLayout.getWidth();
		float height = shapeLayout.getHeight();

		KInsets nodeInsets = shapeLayout.getProperty(INVIS_INSETS);
		if (nodeInsets != null) {
			xpos -= nodeInsets.getLeft();
			ypos -= nodeInsets.getTop();
			width += nodeInsets.getLeft() + nodeInsets.getRight();
			height += nodeInsets.getTop() + nodeInsets.getBottom();
		}

		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		ga.setX(Math.round(xpos));
		ga.setY(Math.round(ypos));
		ga.setWidth(Math.round(width));
		ga.setHeight(Math.round(height));

		featureProvider.layoutIfPossible(new LayoutContext(shape));
	}
}
