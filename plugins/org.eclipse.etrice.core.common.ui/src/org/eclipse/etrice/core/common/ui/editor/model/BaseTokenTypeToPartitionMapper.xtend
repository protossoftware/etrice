/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.editor.model

import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper

class BaseTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {
		
	override protected calculateId(String tokenName, int tokenType) {
		switch tokenName {
			case 'RULE_CC_STRING': STRING_LITERAL_PARTITION
			default: super.calculateId(tokenName, tokenType)
		}
	}

}
