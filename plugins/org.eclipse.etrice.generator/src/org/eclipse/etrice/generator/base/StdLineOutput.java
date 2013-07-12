/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

/**
 * A line output that prints to {@link java.lang.System#out System.out}
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class StdLineOutput implements ILineOutput {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ILineOutput#println(java.lang.String)
	 */
	@Override
	public void println(String txt) {
		System.out.println(txt);
	}

}
