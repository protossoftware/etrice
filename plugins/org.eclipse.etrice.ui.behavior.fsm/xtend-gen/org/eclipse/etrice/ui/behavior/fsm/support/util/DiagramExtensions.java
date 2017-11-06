/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.fsm.support.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

@SuppressWarnings("all")
public class DiagramExtensions {
  public static <T extends PictogramElement> T getCastedPe(final IPictogramElementContext ctx) {
    PictogramElement _pictogramElement = ctx.getPictogramElement();
    return ((T) _pictogramElement);
  }
  
  public static <T extends EObject> T getCastedBo(final PictogramElement pe) {
    EObject _businessObjectForLinkedPictogramElement = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    return ((T) _businessObjectForLinkedPictogramElement);
  }
}
