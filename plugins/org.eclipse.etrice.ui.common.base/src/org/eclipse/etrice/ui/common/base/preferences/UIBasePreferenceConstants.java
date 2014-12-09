/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public interface UIBasePreferenceConstants {

	public static final String USE_GRID = "UseGrid";
	public static final String SNAP_TO_GRID = "SnapToGrid";
	public static final String HOR_GRID_UNIT = "HorGridUnit";
	public static final String VER_GRID_UNIT = "VerGridUnit";
	public static final String CONFIRM_DELETE = "ConfirmDelete";
	public static final String SAVE_DIAG_ON_FOCUS_LOST = "SaveDiagOnFocusLost";
	public static final String SAVE_TEXT_ON_FOCUS_LOST = "SaveTextOnFocusLost";
	public static final String EXPORT_DIAGRAM_PATH = "ExportDiagramPath";
	public static final String EXPORT_DIAGRAM_FORMAT = "ExportDiagramFormat";
	public static final String EXPORT_DIAGRAM_PATH_RELATIVE_TO = "ExportDiagramPathRelativeTo";
	
	public static final String MAX_LABEL_LINE_LENGTH = "MaxLabelLineLength";
	public static final String MAX_LABEL_LINES = "MaxLabelLines";
	public static final int MAX_LINE_LENGTH_DEFAULT = 20;
	public static final int MAX_LINES_DEFAULT = 1;
	
	// possible values for EXPORT_DIAGRAM_PATH_RELATIVE_TO
	public static final String PATH_REL_TO_PROJECT = "project";
	public static final String PATH_REL_TO_MODEL = "model";
	
	// possible values for EXPORT_DIAGRAM_FORMAT
	public static final String FORMAT_BMP = "bmp";
	public static final String FORMAT_JPG = "jpg";
	public static final String FORMAT_PNG = "png";
	public static final String FORMAT_GIF = "gif";
}
