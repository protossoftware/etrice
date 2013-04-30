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
package org.eclipse.etrice.ui.structure.support.provider;

import java.util.ArrayList;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.tb.BorderDecorator;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DecorationProvider {
	
	private static ArrayList<Shape> allowedPortShapes = new ArrayList<Shape>();
	
	public static void clearAllowedPortShapes() {
		allowedPortShapes.clear();
	}
	
	public static void addAllowedPortShape(Shape portShape) {
		allowedPortShapes.add(portShape);
	}
	
	public static IDecorator[] getDecorators(PictogramElement pe) {
		if (allowedPortShapes.contains(pe)) {
			BorderDecorator decorator = new BorderDecorator();
			decorator.setBorderColor(IColorConstant.GREEN);
			decorator.setBorderWidth(2);
//			ColorDecorator decorator = new ColorDecorator();
//			decorator.setForegroundColor(IColorConstant.GREEN);
//			decorator.setBackgroundColor(IColorConstant.GREEN);
			return new IDecorator[] { decorator };
		}
		return new IDecorator[0];
	}

}
