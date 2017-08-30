/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.core.common.ui.editor.model;

import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

@SuppressWarnings("all")
public class BaseTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _switchResult = null;
    switch (tokenName) {
      case "RULE_CC_STRING":
        _switchResult = TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION;
        break;
      default:
        _switchResult = super.calculateId(tokenName, tokenType);
        break;
    }
    return _switchResult;
  }
}
