/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.imports;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class NamespaceSelectionLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof QualifiedName) {
			return element.toString();
		}
		else return super.getText(element);
	}

}
