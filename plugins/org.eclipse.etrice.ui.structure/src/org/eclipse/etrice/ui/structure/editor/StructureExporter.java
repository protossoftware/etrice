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

package org.eclipse.etrice.ui.structure.editor;

import java.io.File;

import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.editor.DiagramExporter;
import org.eclipse.etrice.ui.structure.DiagramAccess;

public class StructureExporter {

	private static final String SUFFIX = "_structure";

	public static void export(StructureClass ac, String folder) {
		DiagramAccess da = new DiagramAccess();
		DiagramExporter.export(ac, da, folder+File.separatorChar+ac.getName()+SUFFIX);
	}

}
