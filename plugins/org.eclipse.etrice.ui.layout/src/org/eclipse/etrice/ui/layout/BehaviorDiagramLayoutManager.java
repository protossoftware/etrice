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
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.etrice.ui.behavior.support.StateSupport;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.internal.parts.IPictogramElementEditPart;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.config.VolatileLayoutConfig;
import de.cau.cs.kieler.kiml.graphiti.KimlGraphitiUtil;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.diagram.LayoutMapping;
import de.cau.cs.kieler.kiml.util.KimlUtil;

/**
 * Layout Manager implementation for eTrice Structure Editor.
 * 
 * @author jayant
 */
@SuppressWarnings("restriction")
public class BehaviorDiagramLayoutManager extends ETriceDiagramLayoutManager {

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public boolean supports(final Object object) {

		return object instanceof BehaviorEditor
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

		if (onlyVisible) {
			for (Shape boundingBox : ((Diagram) diagram).getChildren()) {
				if (boundingBox.isVisible()) {
					buildAllLevels(mapping, boundingBox, diagramNode);
					break;
				}
			}
		} else {
			// This happens when the user requests Layout of the whole hierarchy
			// of Diagrams in the behavior editor
			// FIXME need to be corrected.
			for (Shape boundingBox : ((Diagram) diagram).getChildren())
				buildAllLevels(mapping, boundingBox, diagramNode);
		}

	}

	/** the fixed minimal height of nodes. */
	public static final float MIN_HEIGHT = StateSupport.DEFAULT_SIZE_Y;
	/** the fixed minimal width of shapes. */
	public static final float MIN_WIDHT = StateSupport.DEFAULT_SIZE_X;

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	protected KNode createNode(final LayoutMapping<PictogramElement> mapping,
			final KNode parentNode, final Shape shape) {
		KNode node = KimlUtil.createInitializedNode();
		node.setParent(parentNode);

		setCurrentPositionAndSize(mapping, parentNode, node, shape);

		VolatileLayoutConfig staticConfig = mapping
				.getProperty(KimlGraphitiUtil.STATIC_CONFIG);
		// FIXME find a way to specify the minimal size dynamically

		staticConfig.setValue(LayoutOptions.MIN_WIDTH, node,
				LayoutContext.GRAPH_ELEM, MIN_WIDHT);
		staticConfig.setValue(LayoutOptions.MIN_HEIGHT, node,
				LayoutContext.GRAPH_ELEM, MIN_HEIGHT);

		mapping.getGraphMap().put(node, shape);

		// gather all connections directly connected to the Node (not the
		// connections connected via ports). These only exist in the behavior
		// editor.
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
	protected boolean isPort(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof TrPoint)
			return true;
		
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected boolean isTopLevelBoundingBox(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof StateGraph)
			return true;
		
		return false;
	}
}
