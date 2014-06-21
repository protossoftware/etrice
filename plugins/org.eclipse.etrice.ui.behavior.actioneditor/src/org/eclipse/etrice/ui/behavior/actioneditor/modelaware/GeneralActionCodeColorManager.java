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
public class GeneralActionCodeColorManager extends ActionCodeColorManager {

	public static final RGB MULTI_LINE_COMMENT = new RGB(128, 0, 0);
	public static final RGB SINGLE_LINE_COMMENT = new RGB(128, 0, 0);
	public static final RGB KEYWORD = new RGB(0, 0, 128);
	public static final RGB TYPE = new RGB(0, 0, 128);
	public static final RGB STRING = new RGB(0, 128, 0);

}