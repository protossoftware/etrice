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

package org.eclipse.etrice.core.common.ui.editor.model

import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper

class BaseTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {
	
	public val static String CCSTRING_LITERAL_PARTITION = "__ccstring";
		
	override protected calculateId(String tokenName, int tokenType) {
		switch tokenName {
			// custom behavior for ccstring
			case 'RULE_CC_STRING': CCSTRING_LITERAL_PARTITION
			default: super.calculateId(tokenName, tokenType)
		}
	}

}
