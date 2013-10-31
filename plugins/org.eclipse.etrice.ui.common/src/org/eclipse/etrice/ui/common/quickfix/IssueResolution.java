/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.quickfix;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class IssueResolution {
	private String description;
	private String label;
	private String image;
	private IDiagramModification modification;
	
	/**
	 * @param description
	 * @param label
	 * @param image
	 */
	public IssueResolution(String label, String description, String image, IDiagramModification modification) {
		this.description = description;
		this.label = label;
		this.image = image;
		this.modification = modification;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * @param diagram
	 */
	public boolean apply(Diagram diagram, IFeatureProvider fp) {
		try {
			return modification.apply(diagram, fp);
		} catch(Exception exc) {
			throw new WrappedException(exc);
		}
	}

}
