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
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

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
 * An abstract class to support creation of commands for applying the result of
 * automatic layout to eTrice diagrams. Help create the
 * {@link BehaviorLayoutCommand} and the {@link StructureLayoutCommand}.
 * 
 * @author jayant
 */
public abstract class ETriceLayoutCommand extends GraphitiLayoutCommand {

	public ETriceLayoutCommand(TransactionalEditingDomain domain,
			IFeatureProvider thefeatureProvider) {
		super(domain, thefeatureProvider);
	}

	/**
	 * {@inheritDoc} Also responsible for the layout of internal ports in eTrice
	 * (which are considered as KNodes)
	 * 
	 * @author jayant
	 */
	@Override
	protected abstract void applyNodeLayout(KNode knode, PictogramElement pelem);

	/**
	 * {@inheritDoc} Only Boundary Ports are lay-outed by this method
	 * 
	 * @author jayant
	 */
	@Override
	protected abstract void applyPortLayout(KPort kport, PictogramElement pelem);

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
	 * Sets the calculated position and size from a KGraph Model-Element (Node
	 * or Port) back to the corresponding diagram shape.
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
	protected void setCalculatedPositionAndSize(final KGraphElement kelem,
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

		KInsets shapeInsets = shapeLayout.getProperty(INVIS_INSETS);
		if (shapeInsets != null) {
			xpos -= shapeInsets.getLeft();
			ypos -= shapeInsets.getTop();
			width += shapeInsets.getLeft() + shapeInsets.getRight();
			height += shapeInsets.getTop() + shapeInsets.getBottom();
		}

		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		IGaService gaService = Graphiti.getGaService();
		gaService.setLocationAndSize(ga, Math.round(xpos), Math.round(ypos),
				Math.round(width), Math.round(height));

	}

}
