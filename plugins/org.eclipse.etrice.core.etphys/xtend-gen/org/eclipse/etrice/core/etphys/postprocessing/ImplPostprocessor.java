/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert
 */
package org.eclipse.etrice.core.etphys.postprocessing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.postprocessing.PostprocessingHelpers;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostprocessor {
  public void process(final GeneratedMetamodel metamodel) {
    final EPackage pckg = metamodel.getEPackage();
    EClass pt = PostprocessingHelpers.getClass(pckg, "PhysicalThread");
    EAttribute tm = PostprocessingHelpers.getAttribute(pt, "time");
    tm.setUnsettable(true);
  }
}
