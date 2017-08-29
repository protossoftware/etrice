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
package org.eclipse.etrice.core.common.formatting2;

import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.AbstractTextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class CCStringReplacer extends AbstractTextReplacer {
  private final CCStringConverter converter;
  
  @Override
  public ITextReplacerContext createReplacements(final ITextReplacerContext context) {
    ITextSegment _region = this.getRegion();
    boolean _isMultiline = _region.isMultiline();
    if (_isMultiline) {
      ITextSegment _region_1 = this.getRegion();
      String _text = _region_1.getText();
      String _trim = _text.trim();
      String _stripDelim = this.converter.stripDelim(_trim);
      final CCStringIndentation ccIndent = new CCStringIndentation(_stripDelim);
      String _xifexpression = null;
      boolean _isIgnoreLast = ccIndent.isIgnoreLast();
      if (_isIgnoreLast) {
        _xifexpression = context.getIndentationString();
      } else {
        _xifexpression = "";
      }
      final String endIndent = _xifexpression;
      int _indentation = context.getIndentation();
      int _plus = (_indentation + 1);
      String _indentationString = context.getIndentationString(_plus);
      String _replaceEditorIndentation = ccIndent.replaceEditorIndentation(_indentationString);
      final String replacement = (_replaceEditorIndentation + endIndent);
      final Procedure1<ITextReplacerContext> _function = (ITextReplacerContext it) -> {
        ITextSegment _region_2 = this.getRegion();
        String _delim = this.converter.getDelim();
        String _plus_1 = (_delim + replacement);
        String _delim_1 = this.converter.getDelim();
        String _plus_2 = (_plus_1 + _delim_1);
        ITextReplacement _replaceWith = _region_2.replaceWith(_plus_2);
        it.addReplacement(_replaceWith);
      };
      ObjectExtensions.<ITextReplacerContext>operator_doubleArrow(context, _function);
    }
    return context;
  }
  
  public CCStringReplacer(final IFormattableDocument document, final ITextSegment region, final CCStringConverter converter) {
    super(document, region);
    this.converter = converter;
  }
}
