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
package org.eclipse.etrice.expressions.ui.highlight;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.expressions.ui.DetailExpressionUIProvider;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class RoomExpressionHighlighter {
  @Accessors
  public static class HighlightResult {
    private final int offset;
    
    private final int length;
    
    private final String id;
    
    public HighlightResult(final int offset, final int length, final String id) {
      super();
      this.offset = offset;
      this.length = length;
      this.id = id;
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public int getLength() {
      return this.length;
    }
    
    @Pure
    public String getId() {
      return this.id;
    }
  }
  
  @Inject
  private DetailExpressionUIProvider expressionProvider;
  
  public List<RoomExpressionHighlighter.HighlightResult> getHighlighting(final String text, final int offset) {
    ArrayList<RoomExpressionHighlighter.HighlightResult> _xblockexpression = null;
    {
      final ArrayList<RoomExpressionHighlighter.HighlightResult> result = CollectionLiterals.<RoomExpressionHighlighter.HighlightResult>newArrayList();
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
