/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class ImageProvider extends AbstractImageProvider {

	// The prefix for all identifiers of this image provider
	protected static final String PREFIX = "org.eclipse.etrice.ui.structure.";

	// The image identifier for an EReference.
	public static final String IMG_PORT = PREFIX + "port";
	public static final String IMG_SPP = PREFIX + "spp";
	public static final String IMG_REF = PREFIX + "ref";
	public static final String IMG_BINDING = PREFIX + "binding";
	public static final String IMG_LAYER_CONNECTION = PREFIX + "layer_connection";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(IMG_PORT, "icons/Port.gif");
		addImageFilePath(IMG_SPP, "icons/SPP.gif");
		addImageFilePath(IMG_REF, "icons/ActorRef.gif");
		addImageFilePath(IMG_BINDING, "icons/Binding.gif");
		addImageFilePath(IMG_LAYER_CONNECTION, "icons/LayerConnection.gif");
	}

}
