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
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.etrice.ui.structure.support.ActorContainerRefSupport;
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
public class StructureDiagramLayoutmanager extends ETriceDiagramLayoutManager {

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

	/** the fixed minimal height of nodes. */
	public static final float MIN_HEIGHT = ActorContainerRefSupport.DEFAULT_SIZE_Y;
	/** the fixed minimal width of shapes. */
	public static final float MIN_WIDHT = ActorContainerRefSupport.DEFAULT_SIZE_X;

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
		if (modelObject instanceof InterfaceItem
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
	protected boolean isTopLevelBoundingBox(Shape shape) {
		EObject modelObject = shape.getLink().getBusinessObjects().get(0);
		if (modelObject instanceof ActorClass)
			return true;

		return false;
	}

}
