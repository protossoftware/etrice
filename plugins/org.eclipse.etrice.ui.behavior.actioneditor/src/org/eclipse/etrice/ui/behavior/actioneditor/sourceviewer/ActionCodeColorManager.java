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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Manages SWT color objects for the given {@code RGB} objects. Until the
 * {@link #dispose()} method is called, the same color object is returned for
 * equal {@code RGB} values.
 * <p>
 * This class may be sub-classed.
 * </p>
 * 
 * @author jayant
 */
public class ActionCodeColorManager {

	/** RGB object for member color */
	public static final RGB MEMBER = new RGB(128, 128, 0);
	/** RGB object for interface item color */
	public static final RGB INTERFACE_ITEM = new RGB(0, 0, 128);
	/** Default RGB color object */
	public static final RGB DEFAULT = new RGB(0, 0, 0);

	/** Local cache mapping {@link RGB} values with {@link Color} Objects */
	protected Map<RGB, Color> fColorTable = new HashMap<RGB, Color>(10);

	/**
	 * Disposes the cached {@link Color} objects by this Color Manager.
	 */
	public void dispose() {
		Iterator<Color> e = fColorTable.values().iterator();
		while (e.hasNext())
			(e.next()).dispose();
	}

	/**
	 * Gets the SWT {@link Color} object given the {@link RGB} value. The method
	 * internally caches the {@code Color} objects to save system resources.
	 * 
	 * @author jayant
	 * 
	 * @param rgb
	 *            the {@code RGB} object of the color
	 * @return the SWT {@code Color} object for the color
	 */
	public Color getColor(RGB rgb) {
		Color color = (Color) fColorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}