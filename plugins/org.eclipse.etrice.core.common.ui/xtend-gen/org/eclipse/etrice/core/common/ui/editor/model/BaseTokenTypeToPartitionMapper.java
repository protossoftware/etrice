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

import com.google.common.base.Objects;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

@SuppressWarnings("all")
public class BaseTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(tokenName, "RULE_CC_STRING")) {
      _matched=true;
      _switchResult = TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION;
    }
    if (!_matched) {
      _switchResult = super.calculateId(tokenName, tokenType);
    }
    return _switchResult;
  }
}
