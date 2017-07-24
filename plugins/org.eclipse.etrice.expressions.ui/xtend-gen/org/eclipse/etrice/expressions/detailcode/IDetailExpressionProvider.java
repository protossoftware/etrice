/**
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.expressions.detailcode;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Defines detail expressions = <i>ExpressionFeature ('.' ExpressionFeature)* </i>
 */
@SuppressWarnings("all")
public interface IDetailExpressionProvider {
  /**
   * ExpressionFeature = <i>id(postfix)?</i> with <i> postfix = '(' .* ')' | '[' .* ']'
   */
  @Accessors
  public static class ExpressionFeature {
    private final String id;
    
    private final IDetailExpressionProvider.ExpressionPostfix postfix;
    
    private Object data;
    
    public ExpressionFeature(final String id, final IDetailExpressionProvider.ExpressionPostfix postfix) {
      super();
      this.id = id;
      this.postfix = postfix;
    }
    
    @Pure
    public String getId() {
      return this.id;
    }
    
    @Pure
    public IDetailExpressionProvider.ExpressionPostfix getPostfix() {
      return this.postfix;
    }
    
    @Pure
    public Object getData() {
      return this.data;
    }
    
    public void setData(final Object data) {
      this.data = data;
    }
  }
  
  public enum ExpressionPostfix {
    NONE,
    
    PARENTHESES,
    
    BRACKETS;
  }
  
  public static class EmptyDetailExpressionProvider implements IDetailExpressionProvider {
    private final List<IDetailExpressionProvider.ExpressionFeature> EMPTY_LIST = ImmutableList.<IDetailExpressionProvider.ExpressionFeature>of();
    
    @Override
    public List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures() {
      return this.EMPTY_LIST;
    }
    
    @Override
    public List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx) {
      return this.EMPTY_LIST;
    }
  }
  
  public final static char SEPARATOR = '.';
  
  /**
   * A list of ExpressionFeatures, without preceding '.' and that can start a context
   * @return not null
   */
  public abstract List<IDetailExpressionProvider.ExpressionFeature> getInitialFeatures();
  
  /**
   * A list of ExpressionFeatures, that can follow ctx
   * @param ctx having non-null entries
   * @return not null
   */
  public abstract List<IDetailExpressionProvider.ExpressionFeature> getContextFeatures(final IDetailExpressionProvider.ExpressionFeature ctx);
}
