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
package org.eclipse.etrice.core.common.ui.editor;

import org.eclipse.ui.ISaveablePart2;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface ISaveOnFocusLostEditor extends ISaveablePart2 {

	/**
	 * if this editor is currently being closed (check in {@link #promptToSaveOnClose()}) this should return true
	 * @return
	 */
	boolean isClosing();
}
