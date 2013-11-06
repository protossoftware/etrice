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

package org.eclipse.etrice.ui.behavior;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class ImageProvider extends AbstractImageProvider {

	// The prefix for all identifiers of this image provider
	protected static final String PREFIX = "org.eclipse.etrice.ui.behavior.";

	// The image identifier for an EReference.
	public static final String IMG_STATE = PREFIX + "state";
	public static final String IMG_TRPOINT = PREFIX + "trpoint";
	public static final String IMG_ENTRYPOINT = PREFIX + "entrypoint";
	public static final String IMG_EXITPOINT = PREFIX + "exitpoint";
	public static final String IMG_CP = PREFIX + "cp";
	public static final String IMG_INITIAL = PREFIX + "initial";
	public static final String IMG_TRANSITION = PREFIX + "transition";
	public static final String IMG_QUICKFIX = PREFIX + "quickfix";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(IMG_STATE, "icons/State.gif");
		addImageFilePath(IMG_TRPOINT, "icons/TrPoint.gif");
		addImageFilePath(IMG_ENTRYPOINT, "icons/EntryPoint.gif");
		addImageFilePath(IMG_EXITPOINT, "icons/ExitPoint.gif");
		addImageFilePath(IMG_INITIAL, "icons/InitialPoint.gif");
		addImageFilePath(IMG_CP, "icons/ChoicePoint.gif");
		addImageFilePath(IMG_TRANSITION, "icons/Transition.gif");
		addImageFilePath(IMG_QUICKFIX, "icons/quickfix/quickassist.gif");
	}

}
