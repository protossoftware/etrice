/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.ui.documentation

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider
import org.eclipse.xtext.util.Strings

class CommentDocumentationProvider extends MultiLineCommentDocumentationProvider {
	
	override getDocumentation(EObject o) {
		val text = super.getDocumentation(o)
		if (Strings.isEmpty(text)) {
			return text
		}

		text.replace('\r\n', '<br>').replace('\n', '<br>')
	}
	
}
