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

package org.eclipse.etrice.core.common.tests

import org.eclipse.etrice.core.common.documentation.DocumentationMarkup
import org.junit.Test

import static org.junit.Assert.*

class DocumentationMarkupTest extends DocumentationMarkup {
	
	@Test
	def void getMarkupTypeTest() {
		assertEquals('html', getMarkupType('text'))
		assertEquals('html', getMarkupType('<!--html-->'))
		assertEquals('html', getMarkupType('<!-- html -->'))
		assertEquals('html', getMarkupType('<!-- html -->\\n'))
		assertEquals('html', getMarkupType(' <!-- html -->\\r\\n'))
		assertEquals('asciidoc', getMarkupType('<!-- asciidoc -->'))
	}
	
}