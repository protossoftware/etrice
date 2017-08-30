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
package org.eclipse.etrice.expressions.ui.contentassist;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.expressions.detailcode.DetailExpressionAssistParser;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.DetailExpressionUIProvider;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class RoomExpressionProposals {
  @Inject
  private DetailExpressionUIProvider uiExpressionProvider;
  
  @Inject
  private PrefixMatcher prefixMatcher;
  
  public List<ICompletionProposal> createProposals(final IDetailExpressionProvider exprProvider, final String text, final int offset, final int globalOffset) {
    try {
      List<ICompletionProposal> _xblockexpression = null;
      {
        Document _document = new Document(text);
        final DetailExpressionAssistParser parser = new DetailExpressionAssistParser(_document, offset, exprProvider);
        ArrayList<IDetailExpressionProvider.ExpressionFeature> _newArrayList = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newArrayList();
        final Procedure1<ArrayList<IDetailExpressionProvider.ExpressionFeature>> _function = (ArrayList<IDetailExpressionProvider.ExpressionFeature> it) -> {
          boolean _isContextExpression = parser.isContextExpression();
          if (_isContextExpression) {
            IDetailExpressionProvider.ExpressionFeature _resolveLatestCompleted = null;
            if (parser!=null) {
              _resolveLatestCompleted=parser.resolveLatestCompleted();
            }
            final IDetailExpressionProvider.ExpressionFeature contextFeature = _resolveLatestCompleted;
            List<IDetailExpressionProvider.ExpressionFeature> _xifexpression = null;
            if ((contextFeature != null)) {
              _xifexpression = exprProvider.getContextFeatures(contextFeature);
            } else {
              _xifexpression = exprProvider.getInitialFeatures();
            }
            Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(it, _xifexpression);
          } else {
            List<IDetailExpressionProvider.ExpressionFeature> _initialFeatures = exprProvider.getInitialFeatures();
            Iterables.<IDetailExpressionProvider.ExpressionFeature>addAll(it, _initialFeatures);
          }
        };
        final ArrayList<IDetailExpressionProvider.ExpressionFeature> availableFeatures = ObjectExtensions.<ArrayList<IDetailExpressionProvider.ExpressionFeature>>operator_doubleArrow(_newArrayList, _function);
        final String prefix = parser.computeIdentifierPrefix(offset);
        final Function1<IDetailExpressionProvider.ExpressionFeature, Boolean> _function_1 = (IDetailExpressionProvider.ExpressionFeature it) -> {
          String _id = it.getId();
          return Boolean.valueOf(_id.startsWith(prefix));
        };
        Iterable<IDetailExpressionProvider.ExpressionFeature> _filter = IterableExtensions.<IDetailExpressionProvider.ExpressionFeature>filter(availableFeatures, _function_1);
        final Function1<IDetailExpressionProvider.ExpressionFeature, ICompletionProposal> _function_2 = (IDetailExpressionProvider.ExpressionFeature feature) -> {
          String _displayString = this.uiExpressionProvider.getDisplayString(feature);
          final StyledString displayString = new StyledString(_displayString);
          final Image image = this.uiExpressionProvider.getImage(feature);
          String _id = feature.getId();
          ConfigurableCompletionProposal _doCreateProposal = this.doCreateProposal(_id, displayString, image, prefix, globalOffset);
          final Procedure1<ConfigurableCompletionProposal> _function_3 = (ConfigurableCompletionProposal it) -> {
            this.processPostfix(it, feature);
          };
          final ConfigurableCompletionProposal prop = ObjectExtensions.<ConfigurableCompletionProposal>operator_doubleArrow(_doCreateProposal, _function_3);
          return ((ICompletionProposal) prop);
        };
        Iterable<ICompletionProposal> _map = IterableExtensions.<IDetailExpressionProvider.ExpressionFeature, ICompletionProposal>map(_filter, _function_2);
        _xblockexpression = IterableExtensions.<ICompletionProposal>toList(_map);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ConfigurableCompletionProposal doCreateProposal(final String proposal, final StyledString displayString, final Image image, final String prefix, final int globalOffset) {
    int _length = prefix.length();
    int _minus = (globalOffset - _length);
    int _length_1 = prefix.length();
    int _length_2 = proposal.length();
    ConfigurableCompletionProposal _configurableCompletionProposal = new ConfigurableCompletionProposal(proposal, _minus, _length_1, _length_2, image, displayString, null, null);
    final Procedure1<ConfigurableCompletionProposal> _function = (ConfigurableCompletionProposal it) -> {
      it.setMatcher(this.prefixMatcher);
      it.setAutoInsertable(false);
      int _length_3 = proposal.length();
      it.setReplaceContextLength(_length_3);
    };
    return ObjectExtensions.<ConfigurableCompletionProposal>operator_doubleArrow(_configurableCompletionProposal, _function);
  }
  
  protected ConfigurableCompletionProposal processPostfix(final ConfigurableCompletionProposal proposal, final IDetailExpressionProvider.ExpressionFeature feature) {
    final Procedure1<ConfigurableCompletionProposal> _function = (ConfigurableCompletionProposal it) -> {
      final Pair<String, Point> postfix = this.uiExpressionProvider.getPostfixReplacement(feature);
      String _key = postfix.getKey();
      boolean _isEmpty = Strings.isEmpty(_key);
      boolean _not = (!_isEmpty);
      if (_not) {
        Point _value = postfix.getValue();
        boolean _notEquals = (!Objects.equal(_value, null));
        if (_notEquals) {
          int _replacementOffset = it.getReplacementOffset();
          String _replacementString = it.getReplacementString();
          int _length = _replacementString.length();
          int _plus = (_replacementOffset + _length);
          Point _value_1 = postfix.getValue();
          int _plus_1 = (_plus + _value_1.x);
          it.setSelectionStart(_plus_1);
          int _cursorPosition = it.getCursorPosition();
          Point _value_2 = postfix.getValue();
          int _plus_2 = (_cursorPosition + _value_2.x);
          it.setCursorPosition(_plus_2);
          Point _value_3 = postfix.getValue();
          it.setSelectionLength(_value_3.y);
        } else {
          int _cursorPosition_1 = it.getCursorPosition();
          String _key_1 = postfix.getKey();
          int _length_1 = _key_1.length();
          int _plus_3 = (_cursorPosition_1 + _length_1);
          it.setCursorPosition(_plus_3);
        }
        String _replacementString_1 = it.getReplacementString();
        String _key_2 = postfix.getKey();
        String _plus_4 = (_replacementString_1 + _key_2);
        it.setReplacementString(_plus_4);
      }
    };
    return ObjectExtensions.<ConfigurableCompletionProposal>operator_doubleArrow(proposal, _function);
  }
}
