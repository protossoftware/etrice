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
package org.eclipse.etrice.core.common.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.etrice.core.common.BaseTestInjectorProvider;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BaseTestInjectorProvider.class)
@SuppressWarnings("all")
public class CCStringTest {
  private final String JAVA_NL = Strings.newLine();
  
  private final String CRLF = "\r\n";
  
  private final String LF = "\n";
  
  private final String CR = "\r";
  
  private final String NL = this.JAVA_NL;
  
  private final String DELIM = "\'\'\'";
  
  @Inject
  private BaseConverterService baseConverterService;
  
  protected String toValue(final String withoutDelim) {
    CCStringConverter _cC_StringConverter = this.baseConverterService.getCC_StringConverter();
    String _value = _cC_StringConverter.toValue(withoutDelim, null);
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String convertedWithoutDelim) {
        CCStringConverter _cC_StringConverter = CCStringTest.this.baseConverterService.getCC_StringConverter();
        final String convertedWithDelim = _cC_StringConverter.toValue(((CCStringTest.this.DELIM + withoutDelim) + CCStringTest.this.DELIM), null);
        Assert.assertEquals(convertedWithoutDelim, convertedWithDelim);
      }
    };
    return ObjectExtensions.<String>operator_doubleArrow(_value, _function);
  }
  
  @Test
  public void noLineBreak() {
    StringConcatenation _builder = new StringConcatenation();
    String _value = this.toValue(_builder.toString());
    Assert.assertEquals("", _value);
    StringConcatenation _builder_1 = new StringConcatenation();
    String _string = _builder_1.toString();
    StringConcatenation _builder_2 = new StringConcatenation();
    String _value_1 = this.toValue(_builder_2.toString());
    Assert.assertEquals(_string, _value_1);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(" ");
    String _value_2 = this.toValue(_builder_3.toString());
    Assert.assertEquals(" ", _value_2);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append(" ");
    String _string_1 = _builder_4.toString();
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append(" ");
    String _value_3 = this.toValue(_builder_5.toString());
    Assert.assertEquals(_string_1, _value_3);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("\t");
    String _value_4 = this.toValue(_builder_6.toString());
    Assert.assertEquals("\t", _value_4);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("\t");
    String _string_2 = _builder_7.toString();
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("\t");
    String _value_5 = this.toValue(_builder_8.toString());
    Assert.assertEquals(_string_2, _value_5);
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append(" ");
    _builder_9.append("text ");
    String _value_6 = this.toValue(_builder_9.toString());
    Assert.assertEquals(" text ", _value_6);
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append(" ");
    _builder_10.append("text ");
    String _string_3 = _builder_10.toString();
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append(" ");
    _builder_11.append("text ");
    String _value_7 = this.toValue(_builder_11.toString());
    Assert.assertEquals(_string_3, _value_7);
    String _value_8 = this.toValue("\'");
    Assert.assertEquals("\'", _value_8);
    String _value_9 = this.toValue("\'\'");
    Assert.assertEquals("\'\'", _value_9);
    String _value_10 = this.toValue("\"");
    Assert.assertEquals("\"", _value_10);
    CCStringIndentation _cCStringIndentation = new CCStringIndentation(" \t");
    boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
    Assert.assertTrue(_hasConsistentIndentation);
  }
  
  @Test
  public void singleLineBreak() {
    String _value = this.toValue("\r");
    Assert.assertEquals("", _value);
    String _value_1 = this.toValue("\r\n");
    Assert.assertEquals("", _value_1);
    String _value_2 = this.toValue("\n");
    Assert.assertEquals("", _value_2);
    StringConcatenation _builder = new StringConcatenation();
    String _string = _builder.toString();
    String _value_3 = this.toValue(this.NL);
    Assert.assertEquals(_string, _value_3);
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals("", _value);
        StringConcatenation _builder = new StringConcatenation();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ("\t" + this.NL), _function);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(("text" + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ("text" + this.NL), _function_1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((" text\t" + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("text\t");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (" text\t" + this.NL), _function_2);
    final Procedure1<String> _function_3 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(("text\\n" + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text\\n");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (("text\\n" + this.NL) + "\t"), _function_3);
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals("text ", _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text ");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + "text "), _function_4);
    final Procedure1<String> _function_5 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals("text", _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((" " + this.NL) + "text"), _function_5);
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals("text ", _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text ");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + " text "), _function_6);
  }
  
  @Test
  public void twoLineBreaks() {
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(CCStringTest.this.NL, _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + this.NL), _function);
    final Procedure1<String> _function_1 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text" + CCStringTest.this.NL) + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (("text" + this.NL) + this.NL), _function_1);
    final Procedure1<String> _function_2 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(((("text" + CCStringTest.this.NL) + "\t\t\t\tindent") + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("indent");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((("text" + this.NL) + "\t\t\t\tindent") + this.NL), _function_2);
    final Procedure1<String> _function_3 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(("text" + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((this.NL + "text") + this.NL), _function_3);
    final Procedure1<String> _function_4 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals(("text\t" + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text\t");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((this.NL + "\t\t\t\ttext\t") + this.NL), _function_4);
    final Procedure1<String> _function_5 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text" + CCStringTest.this.NL) + "text2 "), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        _builder.append("text2 ");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "text") + this.NL) + "text2 "), _function_5);
    final Procedure1<String> _function_6 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text\\r" + CCStringTest.this.LF) + "text2 "), _value);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.CRLF + "text\\r") + this.LF) + "text2 "), _function_6);
    final Procedure1<String> _function_7 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text" + CCStringTest.this.CR) + "text2 "), _value);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.LF + "text") + this.CR) + "text2 "), _function_7);
    final Procedure1<String> _function_8 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text" + CCStringTest.this.CRLF) + "text2 "), _value);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.LF + "text") + this.CRLF) + "text2 "), _function_8);
    final Procedure1<String> _function_9 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("\ttext" + CCStringTest.this.NL) + "text2 "), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\t");
        _builder.append("text");
        _builder.newLine();
        _builder.append("text2 ");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "\ttext") + this.NL) + "text2 "), _function_9);
    final Procedure1<String> _function_10 = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((("text" + CCStringTest.this.NL) + "\t\t\tindent"), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("text");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("indent");
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertTrue(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "text") + this.NL) + "\t\t\tindent"), _function_10);
    CCStringIndentation _cCStringIndentation = new CCStringIndentation("\r \r\t\n");
    boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
    Assert.assertTrue(_hasConsistentIndentation);
    CCStringIndentation _cCStringIndentation_1 = new CCStringIndentation("\r Text\r\tText\n");
    boolean _hasConsistentIndentation_1 = _cCStringIndentation_1.hasConsistentIndentation();
    Assert.assertFalse(_hasConsistentIndentation_1);
  }
  
  @Test
  public void multiLineBreaks() {
    final Procedure1<String> _function = new Procedure1<String>() {
      @Override
      public void apply(final String text) {
        String _value = CCStringTest.this.toValue(text);
        Assert.assertEquals((((((("   " + CCStringTest.this.NL) + CCStringTest.this.NL) + "\t\t ") + CCStringTest.this.NL) + "text") + CCStringTest.this.NL), _value);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("   ");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t ");
        _builder.newLine();
        _builder.append("text");
        _builder.newLine();
        String _string = _builder.toString();
        String _value_1 = CCStringTest.this.toValue(text);
        Assert.assertEquals(_string, _value_1);
        CCStringIndentation _cCStringIndentation = new CCStringIndentation(text);
        boolean _hasConsistentIndentation = _cCStringIndentation.hasConsistentIndentation();
        Assert.assertFalse(_hasConsistentIndentation);
      }
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((((((this.NL + "\t\t\t   ") + this.NL) + this.NL) + "\t\t ") + this.NL) + "\t\t\ttext") + this.NL), _function);
  }
  
  @Test
  public void testReplaceEditorIndentation() {
    CCStringIndentation _cCStringIndentation = new CCStringIndentation("\r\t\t\tText\r\n\t\t\t\n");
    final Procedure1<CCStringIndentation> _function = new Procedure1<CCStringIndentation>() {
      @Override
      public void apply(final CCStringIndentation it) {
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String indent) {
            final Procedure1<String> _function = new Procedure1<String>() {
              @Override
              public void apply(final String lineSep) {
                final String replaced = it.replaceEditorIndentation(indent, lineSep);
                int _countLineBreaks = Strings.countLineBreaks(replaced);
                Assert.assertEquals(3, _countLineBreaks);
                final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
                  @Override
                  public Boolean apply(final String it) {
                    return Boolean.valueOf((!Objects.equal(it, lineSep)));
                  }
                };
                Iterable<String> _filter = IterableExtensions.<String>filter(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(CCStringTest.this.CRLF, CCStringTest.this.LF, CCStringTest.this.CR)), _function);
                final Procedure1<String> _function_1 = new Procedure1<String>() {
                  @Override
                  public void apply(final String otherLineSep) {
                    boolean _matches = replaced.matches(otherLineSep);
                    Assert.assertFalse(_matches);
                  }
                };
                IterableExtensions.<String>forEach(_filter, _function_1);
                int _indexOf = replaced.indexOf("\t\t\t");
                Assert.assertEquals((-1), _indexOf);
                int _indexOf_1 = replaced.indexOf(indent);
                boolean _greaterThan = (_indexOf_1 > 0);
                Assert.assertTrue(_greaterThan);
              }
            };
            IterableExtensions.<String>forEach(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(CCStringTest.this.CRLF, CCStringTest.this.LF, CCStringTest.this.CR)), _function);
          }
        };
        IterableExtensions.<String>forEach(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\t", " ")), _function);
      }
    };
    ObjectExtensions.<CCStringIndentation>operator_doubleArrow(_cCStringIndentation, _function);
    CCStringIndentation _cCStringIndentation_1 = new CCStringIndentation("\r\t\t\tText\r\n\t\t\t\n");
    final Procedure1<CCStringIndentation> _function_1 = new Procedure1<CCStringIndentation>() {
      @Override
      public void apply(final CCStringIndentation it) {
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String lineSep) {
            final String replaced = it.replaceEditorIndentation(null, lineSep);
            int _countLineBreaks = Strings.countLineBreaks(replaced);
            Assert.assertEquals(3, _countLineBreaks);
            final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
              @Override
              public Boolean apply(final String it) {
                return Boolean.valueOf((!Objects.equal(it, lineSep)));
              }
            };
            Iterable<String> _filter = IterableExtensions.<String>filter(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(CCStringTest.this.CRLF, CCStringTest.this.LF, CCStringTest.this.CR)), _function);
            final Procedure1<String> _function_1 = new Procedure1<String>() {
              @Override
              public void apply(final String otherLineSep) {
                boolean _matches = replaced.matches(otherLineSep);
                Assert.assertFalse(_matches);
              }
            };
            IterableExtensions.<String>forEach(_filter, _function_1);
            int _indexOf = replaced.indexOf("\t\t\t");
            boolean _greaterThan = (_indexOf > 0);
            Assert.assertTrue(_greaterThan);
          }
        };
        IterableExtensions.<String>forEach(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(CCStringTest.this.CRLF, CCStringTest.this.LF, CCStringTest.this.CR)), _function);
      }
    };
    ObjectExtensions.<CCStringIndentation>operator_doubleArrow(_cCStringIndentation_1, _function_1);
    CCStringIndentation _cCStringIndentation_2 = new CCStringIndentation("\r\t\t\tText\r\n\t\t\t\n");
    final Procedure1<CCStringIndentation> _function_2 = new Procedure1<CCStringIndentation>() {
      @Override
      public void apply(final CCStringIndentation it) {
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String indent) {
            final String replaced = it.replaceEditorIndentation(indent, null);
            int _indexOf = replaced.indexOf("\t\t\t");
            Assert.assertEquals((-1), _indexOf);
            int _indexOf_1 = replaced.indexOf(indent);
            boolean _greaterThan = (_indexOf_1 > 0);
            Assert.assertTrue(_greaterThan);
          }
        };
        IterableExtensions.<String>forEach(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("\t", " ")), _function);
      }
    };
    ObjectExtensions.<CCStringIndentation>operator_doubleArrow(_cCStringIndentation_2, _function_2);
    CCStringIndentation _cCStringIndentation_3 = new CCStringIndentation("\r\tText\n\r\t\n");
    String _replaceEditorIndentation = _cCStringIndentation_3.replaceEditorIndentation(null, null);
    Assert.assertEquals("\r\tText\n\r\t\n", _replaceEditorIndentation);
  }
}
