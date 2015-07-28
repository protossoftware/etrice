/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
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

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware;

import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeColorManager;
import org.eclipse.swt.graphics.RGB;

/**
 * Color Manager for general language features for Action Code Editors.
 * 
 * @author jayant
 */
public class GeneralActionCodeColorManager extends ActionCodeColorManager{

	// Standard coloring eclipse
	public static final RGB TARGET_KEYWORD = new RGB(127, 0, 85);
	public static final RGB COMMENT = new RGB(63, 127, 95);
	public static final RGB STRING = new RGB(42, 0, 255);
	public static final RGB NUMBER = new RGB(125, 125, 125); // new RGB(0, 0, 0);

}