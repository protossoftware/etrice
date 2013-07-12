/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

/**
 * Interface that accept URI strings.
 * It is used by the {@link AbstractGenerator} to recursively add imported
 * models.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public interface IResourceURIAcceptor {

	/**
	 * @param uri a file {@link org.eclipse.emf.common.util.URI URI} as String
	 * @return <code>true</code> if the URI wasn't added previously and no error occurred
	 */
	public boolean addResourceURI(String uri);
}
