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
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.StateGraph;

import de.cau.cs.kieler.core.properties.IProperty;
import de.cau.cs.kieler.kiml.LayoutOptionData;
import de.cau.cs.kieler.kiml.config.SemanticLayoutConfig;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * @author jayant
 * 
 */
public class ETriceSemanticLayoutConfig extends SemanticLayoutConfig {

	/**
	 * The diagram type for the top-level bounding box containers in eTrice
	 * Behavior Diagram.
	 */
	public static final String BEHAVIOR_DIAGRAM_TYPE = "org.eclipse.etrice.ui.layout.eTriceBehaviorDiagram";

	/**
	 * The diagram type for the top-level bounding box containers in eTrice
	 * Structure Diagram.
	 */
	public static final String STRUCTURE_DIAGRAM_TYPE = "org.eclipse.etrice.ui.layout.eTriceStructureDiagram";

	/** the priority for eTrice Semantic layout configurations. */
	public static final int PRIORITY = 20;

	/**
	 * {@inheritDoc}
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
	protected IProperty<?>[] getAffectedOptions(EObject semanticElem) {
		if (semanticElem instanceof ActorContainerClass
				|| semanticElem instanceof StateGraph)
			return new IProperty<?>[] { LayoutOptions.DIAGRAM_TYPE };

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected Object getSemanticValue(EObject semanticElem,
			LayoutOptionData<?> layoutOption) {
		if (layoutOption.getId().equals(LayoutOptions.DIAGRAM_TYPE.getId())) {
			if (semanticElem instanceof ActorContainerClass)
				return STRUCTURE_DIAGRAM_TYPE;
			else if (semanticElem instanceof StateGraph)
				return BEHAVIOR_DIAGRAM_TYPE;
			else
				return "de.cau.cs.kieler.layout.diagrams.general";
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	protected void setSemanticValue(EObject semanticElem,
			LayoutOptionData<?> layoutOption, Object value) {
		// not supported by this layout configuration
	}

}
