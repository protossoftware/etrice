/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.doc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.help.HelpSystem;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class ContextHelpProvider {

	public final static String ID_PREFIX = "featureContextHelp_";
	public final static String HELP_SYSTEM_ID_PREFIX = "org.eclipse.etrice.doc." + ID_PREFIX;

	private final static Map<String, String> featureMapping = new HashMap<String, String>();
	static {
		featureMapping.put("RoomEditor", "TextualROOMEditor");
		featureMapping.put("StructureEditor", "GraphicalStructureEditor");
		featureMapping.put("BehaviorEditor", "GraphicalBehaviorEditor");
	}

	public static String getContextId(String featureId) {
		String mappedFeatureId = featureMapping.get(featureId);
		return HELP_SYSTEM_ID_PREFIX + ((mappedFeatureId != null) ? mappedFeatureId : featureId);
	}

	public static void setHelp(Control control, String featureId) {
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(control, ContextHelpProvider.HELP_SYSTEM_ID_PREFIX + featureId);
	}

	public static void showHelp(String featureId) {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp(ContextHelpProvider.HELP_SYSTEM_ID_PREFIX + featureId);
	}

	public static boolean isAvailable(String featureId) {
		if (featureId == null || featureId.equals(""))
			return false;

		return HelpSystem.getContext(HELP_SYSTEM_ID_PREFIX + featureId) != null;
	}
}
