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
package org.eclipse.etrice.core.common.converter;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * TODO: Handling mixed line endings
 * 
 *  Improvement: Too much strings matching => use token scanner
 */
@SuppressWarnings("all")
public class CCStringIndentation {
  private final static String JAVA_NL = Strings.newLine();
  
  private final static String CRLF = "\r\n";
  
  private final static String LF = "\n";
  
  private final static String CR = "\r";
  
  public static boolean hasLineBreak(final String nodeText) {
    int _countLineBreaks = Strings.countLineBreaks(nodeText);
    return (_countLineBreaks > 0);
  }
  
  public static String getLineEnding(final String it) {
    String _switchResult = null;
    boolean _matched = false;
    int _indexOf = it.indexOf(CCStringIndentation.CRLF);
    boolean _greaterEqualsThan = (_indexOf >= 0);
    if (_greaterEqualsThan) {
      _matched=true;
      _switchResult = CCStringIndentation.CRLF;
    }
    if (!_matched) {
      int _indexOf_1 = it.indexOf(CCStringIndentation.LF);
      boolean _greaterEqualsThan_1 = (_indexOf_1 >= 0);
      if (_greaterEqualsThan_1) {
        _matched=true;
        _switchResult = CCStringIndentation.LF;
      }
    }
    if (!_matched) {
      int _indexOf_2 = it.indexOf(CCStringIndentation.CR);
      boolean _greaterEqualsThan_2 = (_indexOf_2 >= 0);
      if (_greaterEqualsThan_2) {
        _matched=true;
        _switchResult = CCStringIndentation.CR;
      }
    }
    if (!_matched) {
      _switchResult = CCStringIndentation.JAVA_NL;
    }
    return _switchResult;
  }
  
  private final String ccString;
  
  private final String lineEnding;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ImmutableList<String> splittedLines;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final boolean ignoreFirst;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final boolean ignoreLast;
  
  /**
   * CCString without delimiters. Caller should handle their own delims.
   */
  public CCStringIndentation(final String ccString) {
    this.ccString = ccString;
    String _lineEnding = CCStringIndentation.getLineEnding(ccString);
    this.lineEnding = _lineEnding;
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    final Procedure1<ArrayList<String>> _function = (ArrayList<String> lines) -> {
      Pattern _compile = Pattern.compile(this.lineEnding);
      final Matcher matcher = _compile.matcher(ccString);
      int lastOffset = 0;
      while (matcher.find()) {
        {
          int _start = matcher.start();
          String _substring = ccString.substring(lastOffset, _start);
          lines.add(_substring);
          int _end = matcher.end();
          lastOffset = _end;
        }
      }
      int _length = ccString.length();
      boolean _lessThan = (lastOffset < _length);
      if (_lessThan) {
        String _substring = ccString.substring(lastOffset);
        lines.add(_substring);
      } else {
        boolean _endsWith = ccString.endsWith(this.lineEnding);
        if (_endsWith) {
          lines.add("");
        }
      }
    };
    ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
    ImmutableList<String> _copyOf = ImmutableList.<String>copyOf(_doubleArrow);
    this.splittedLines = _copyOf;
    this.ignoreFirst = ((this.splittedLines.size() >= 2) && IterableExtensions.<String>head(this.splittedLines).trim().isEmpty());
    this.ignoreLast = ((this.splittedLines.size() >= 2) && IterableExtensions.<String>last(this.splittedLines).trim().isEmpty());
  }
  
  /**
   * Returns ccString without editor white space and delims.
   * 
   * @see #highlight()
   */
  public String removeEditorWhiteSpace() {
    return this.removeEditorWhiteSpace("");
  }
  
  protected String removeEditorWhiteSpace(final String indent) {
    List<Pair<Integer, Integer>> _highlight = this.highlight();
    final Function2<String, Pair<Integer, Integer>, String> _function = (String lines, Pair<Integer, Integer> offsetLength) -> {
      Integer _key = offsetLength.getKey();
      Integer _key_1 = offsetLength.getKey();
      Integer _value = offsetLength.getValue();
      int _plus = ((_key_1).intValue() + (_value).intValue());
      String _substring = this.ccString.substring((_key).intValue(), _plus);
      return ((lines + indent) + _substring);
    };
    return IterableExtensions.<Pair<Integer, Integer>, String>fold(_highlight, "", _function);
  }
  
  /**
   * Returns whether editor indentation can be removed safely.
   */
  public boolean canRemoveEditorIndentation() {
    return (((this.splittedLines.size() >= 2) && this.ignoreFirst) && this.hasConsistentIndentation());
  }
  
  /**
   * Returns ccString replaced with given indentation if possible. Ignored lines are trimmed. No delims included.
   * 
   * @see #highlight()
   */
  public String replaceEditorIndentation(final String indentation) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if ((indentation == null)) {
        _xifexpression = "";
      } else {
        _xifexpression = indentation;
      }
      final String indent = _xifexpression;
      String _xifexpression_1 = null;
      boolean _canRemoveEditorIndentation = this.canRemoveEditorIndentation();
      if (_canRemoveEditorIndentation) {
        String _xifexpression_2 = null;
        if ((this.ignoreFirst && (this.splittedLines.size() == 2))) {
          _xifexpression_2 = this.removeEditorWhiteSpace("");
        } else {
          String _xifexpression_3 = null;
          if (this.ignoreFirst) {
            _xifexpression_3 = this.lineEnding;
          } else {
            _xifexpression_3 = "";
          }
          String _removeEditorWhiteSpace = this.removeEditorWhiteSpace(indent);
          _xifexpression_2 = (_xifexpression_3 + _removeEditorWhiteSpace);
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        String _xblockexpression_1 = null;
        {
          LinkedList<String> _newLinkedList = CollectionLiterals.<String>newLinkedList(((String[])Conversions.unwrapArray(this.splittedLines, String.class)));
          final Procedure1<LinkedList<String>> _function = (LinkedList<String> it) -> {
            if (this.ignoreFirst) {
              it.set(0, "");
            }
            if (this.ignoreLast) {
              int _size = it.size();
              int _minus = (_size - 1);
              it.set(_minus, "");
            }
          };
          final LinkedList<String> lines = ObjectExtensions.<LinkedList<String>>operator_doubleArrow(_newLinkedList, _function);
          _xblockexpression_1 = IterableExtensions.join(lines, this.lineEnding);
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  /**
   * Returns highlighted positions without editor's indentation.<br>
   * Positions are pairs of (offset, length) relative to {@link #CCStringIndentation(String)}
   * 
   * @see #removeEditorWhiteSpace()
   */
  public List<Pair<Integer, Integer>> highlight() {
    final ArrayList<Pair<Integer, Integer>> offsetLengthLines = CollectionLiterals.<Pair<Integer, Integer>>newArrayList();
    final String editorIndent = this.computeEditorIndent(false);
    final int skip = editorIndent.length();
    int offset = 0;
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.splittedLines, Object.class)).length); i++) {
      {
        final String line = this.splittedLines.get(i);
        if (((i == 0) && this.ignoreFirst)) {
          int _offset = offset;
          int _length = line.length();
          int _length_1 = this.lineEnding.length();
          int _plus = (_length + _length_1);
          offset = (_offset + _plus);
        } else {
          if (((i == (this.splittedLines.size() - 1)) && this.ignoreLast)) {
          } else {
            Pair<Integer, Integer> _xblockexpression = null;
            {
              int _xifexpression = (int) 0;
              int _size = this.splittedLines.size();
              int _minus = (_size - 1);
              boolean _lessThan = (i < _minus);
              if (_lessThan) {
                _xifexpression = this.lineEnding.length();
              } else {
                _xifexpression = 0;
              }
              final int NL = _xifexpression;
              Pair<Integer, Integer> _xifexpression_1 = null;
              boolean _startsWith = line.startsWith(editorIndent);
              if (_startsWith) {
                int _length_2 = line.length();
                int _minus_1 = (_length_2 - skip);
                int _plus_1 = (_minus_1 + NL);
                _xifexpression_1 = Pair.<Integer, Integer>of(Integer.valueOf((offset + skip)), Integer.valueOf(_plus_1));
              } else {
                int _length_3 = line.length();
                int _plus_2 = (_length_3 + NL);
                _xifexpression_1 = Pair.<Integer, Integer>of(Integer.valueOf(offset), Integer.valueOf(_plus_2));
              }
              _xblockexpression = _xifexpression_1;
            }
            offsetLengthLines.add(_xblockexpression);
            int _offset_1 = offset;
            int _length_2 = line.length();
            int _length_3 = this.lineEnding.length();
            int _plus_1 = (_length_2 + _length_3);
            offset = (_offset_1 + _plus_1);
          }
        }
      }
    }
    return offsetLengthLines;
  }
  
  /**
   * Check consistent indentation
   */
  public boolean hasConsistentIndentation() {
    String _computeEditorIndent = this.computeEditorIndent(true);
    return (_computeEditorIndent != null);
  }
  
  protected String computeEditorIndent(final boolean consistentOnly) {
    String _xblockexpression = null;
    {
      if (((this.splittedLines.size() <= 1) || (!this.ignoreFirst))) {
        return "";
      }
      List<Pair<String, String>> _xblockexpression_1 = null;
      {
        int _xifexpression = (int) 0;
        if (this.ignoreFirst) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        final int begin = _xifexpression;
        int _size = this.splittedLines.size();
        int _xifexpression_1 = (int) 0;
        if (this.ignoreLast) {
          _xifexpression_1 = 1;
        } else {
          _xifexpression_1 = 0;
        }
        final int end = (_size - _xifexpression_1);
        ImmutableList<String> _subList = this.splittedLines.subList(begin, end);
        final Function1<String, Pair<String, String>> _function = (String line) -> {
          String _leadingWhiteSpace = Strings.getLeadingWhiteSpace(line);
          return Pair.<String, String>of(_leadingWhiteSpace, line);
        };
        List<Pair<String, String>> _map = ListExtensions.<String, Pair<String, String>>map(_subList, _function);
        _xblockexpression_1 = IterableExtensions.<Pair<String, String>>toList(_map);
      }
      final List<Pair<String, String>> wsLinePairs = _xblockexpression_1;
      final Function1<Iterable<String>, String> _function = (Iterable<String> it) -> {
        String _xifexpression = null;
        boolean _isEmpty = IterableExtensions.isEmpty(it);
        if (_isEmpty) {
          _xifexpression = "";
        } else {
          _xifexpression = IterableExtensions.<String>min(it);
        }
        return _xifexpression;
      };
      final Function1<? super Iterable<String>, ? extends String> minWSComputor = _function;
      final Function1<Pair<String, String>, Boolean> _function_1 = (Pair<String, String> it) -> {
        String _value = it.getValue();
        String _trim = _value.trim();
        boolean _isEmpty = _trim.isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      Iterable<Pair<String, String>> _filter = IterableExtensions.<Pair<String, String>>filter(wsLinePairs, _function_1);
      final Function1<Pair<String, String>, String> _function_2 = (Pair<String, String> it) -> {
        return it.getKey();
      };
      Iterable<String> _map = IterableExtensions.<Pair<String, String>, String>map(_filter, _function_2);
      final String textIndent = minWSComputor.apply(_map);
      final Function1<Pair<String, String>, String> _function_3 = (Pair<String, String> it) -> {
        return it.getKey();
      };
      List<String> _map_1 = ListExtensions.<Pair<String, String>, String>map(wsLinePairs, _function_3);
      final Function1<String, Boolean> _function_4 = (String it) -> {
        boolean _isEmpty = it.isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      Iterable<String> _filter_1 = IterableExtensions.<String>filter(_map_1, _function_4);
      final Function1<String, Boolean> _function_5 = (String nonEmptyIndent) -> {
        return Boolean.valueOf(nonEmptyIndent.startsWith(textIndent));
      };
      final boolean consistent = IterableExtensions.<String>forall(_filter_1, _function_5);
      String _switchResult = null;
      boolean _matched = false;
      if (consistent) {
        _matched=true;
        _switchResult = textIndent;
      }
      if (!_matched) {
        if (consistentOnly) {
          _matched=true;
          _switchResult = null;
        }
      }
      if (!_matched) {
        final Function1<Pair<String, String>, String> _function_6 = (Pair<String, String> it) -> {
          return it.getKey();
        };
        List<String> _map_2 = ListExtensions.<Pair<String, String>, String>map(wsLinePairs, _function_6);
        final Function1<String, Boolean> _function_7 = (String it) -> {
          boolean _isEmpty = it.isEmpty();
          return Boolean.valueOf((!_isEmpty));
        };
        Iterable<String> _filter_2 = IterableExtensions.<String>filter(_map_2, _function_7);
        _switchResult = minWSComputor.apply(_filter_2);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Pure
  public ImmutableList<String> getSplittedLines() {
    return this.splittedLines;
  }
  
  @Pure
  public boolean isIgnoreFirst() {
    return this.ignoreFirst;
  }
  
  @Pure
  public boolean isIgnoreLast() {
    return this.ignoreLast;
  }
}
