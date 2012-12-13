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
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.core.kgraph.KGraphData;
import de.cau.cs.kieler.kiml.LayoutContext;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.config.DefaultLayoutConfig;
import de.cau.cs.kieler.kiml.config.ILayoutConfig;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.service.EclipseLayoutConfig;

/**
 * A layout config for option configuration in eTrice. It configures the diagram
 * types of diagram elements based on the domain model and the specific diagram
 * editor.
 * 
 * @author jayant
 */
public class ETriceLayoutConfig implements ILayoutConfig {

	/** The priority for this layout configurations. */
	public static final int PRIORITY = 40;

	/**
	 * The diagram type for the diagram elements in eTrice behavior diagrams.
	 */
	public static final String BEHAVIOR_DIAGRAM_TYPE = "org.eclipse.etrice.ui.layout.eTriceBehaviorDiagram";

	/**
	 * The diagram type for the diagram elements in eTrice structure diagrams.
	 */
	public static final String STRUCTURE_DIAGRAM_TYPE = "org.eclipse.etrice.ui.layout.eTriceStructureDiagram";

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public int getPriority() {
		return PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public void enrich(LayoutContext context) {
		Object element = context.getProperty(LayoutContext.DOMAIN_MODEL);

		if (element instanceof ActorContainerClass
				|| element instanceof StateGraph) {
			IWorkbenchPart workbenchPart = context
					.getProperty(EclipseLayoutConfig.WORKBENCH_PART);
			Object diagramType = getDiagramType(element, workbenchPart);

			if (diagramType != null)
				context.setProperty(DefaultLayoutConfig.CONTENT_DIAGT,
						diagramType);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public Object getValue(LayoutOptionData<?> optionData, LayoutContext context) {
		if (optionData.equals(LayoutOptions.DIAGRAM_TYPE)) {
			EObject element = context.getProperty(LayoutContext.DOMAIN_MODEL);

			if (element instanceof ActorContainerClass
					|| element instanceof StateGraph) {
				IWorkbenchPart workbenchPart = context
						.getProperty(EclipseLayoutConfig.WORKBENCH_PART);
				return getDiagramType(element, workbenchPart);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public void transferValues(KGraphData graphData, LayoutContext context) {
		// not required : no other options to set dynamically
	}

	/**
	 * Returns the diagram type(string) for a domain model element depending
	 * upon the diagram editor which contains the corresponding diagram element
	 * 
	 * @param modelElement
	 *            the domain model element
	 * @param workbenchPart
	 *            the editor containing the corresspnding diagram element
	 * @return the diagram type for the domain model element
	 * 
	 * @author jayant
	 */
	private String getDiagramType(final Object modelElement,
			IWorkbenchPart workbenchPart) {
		if (modelElement instanceof StateGraph) {
			return BEHAVIOR_DIAGRAM_TYPE;
		} else if (modelElement instanceof ActorContainerClass) {
			if (workbenchPart instanceof BehaviorEditor)
				return BEHAVIOR_DIAGRAM_TYPE;
			else
				return STRUCTURE_DIAGRAM_TYPE;
		}

		return null;
	}
}
