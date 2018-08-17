/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base;
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;


public class BaseImageProvider extends AbstractImageProvider {

	// The prefix for all identifiers of this image provider
	private static final String PREFIX = "org.eclipse.etrice.ui.common.base.";

	// The image identifier for an EReference.
	public static final String IMG_HELP = PREFIX + "help";
	
	@Override
	protected void addAvailableImages() {
		addImageFilePath(IMG_HELP, "icons/Help.gif");
	}

}
