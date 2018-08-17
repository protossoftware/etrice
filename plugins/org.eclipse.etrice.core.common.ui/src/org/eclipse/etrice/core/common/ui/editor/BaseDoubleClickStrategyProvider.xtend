/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.editor

import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider
import org.eclipse.jface.text.source.ISourceViewer
import org.eclipse.xtext.ui.editor.doubleClicking.FixedCharCountPartitionDoubleClickSelector

import static org.eclipse.etrice.core.common.ui.editor.model.BaseTokenTypeToPartitionMapper.*

class BaseDoubleClickStrategyProvider extends DoubleClickStrategyProvider {
	
	override getStrategy(ISourceViewer sourceViewer, String contentType, String documentPartitioning) {
		switch contentType {
			case CCSTRING_LITERAL_PARTITION: return new FixedCharCountPartitionDoubleClickSelector(documentPartitioning, 0, 0)
			default: return new FixedCharCountPartitionDoubleClickSelector(documentPartitioning, 0, 0)
		}
	}
	
}
	