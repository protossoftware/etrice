/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		juergen.haug@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.expressions.ui

import org.eclipse.swt.graphics.RGB

class HighlightConstants {
		
	public static val String INTERFACE_ITEM = 'room_InterfaceItem'
	public static val String ATTRIBUTE = 'room_Attribute'
	public static val String OPERATION = 'room_Operation'
	public static val String SPECIAL_FEATURE = 'room_EObject'
	
	// Standard coloring eclipse
	public static final RGB COLOR_TARGET_KEYWORD = new RGB(127, 0, 85);
	public static final RGB COLLOR_COMMENT = new RGB(63, 127, 95);
	public static final RGB COLOR_STRING = new RGB(42, 0, 255);
	public static final RGB COLOR_NUMBER = new RGB(125, 125, 125); // new RGB(0, 0, 0);
}
