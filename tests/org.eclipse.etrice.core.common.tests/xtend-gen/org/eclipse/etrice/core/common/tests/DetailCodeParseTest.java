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

import com.google.inject.Inject;
import org.eclipse.etrice.core.common.BaseTestInjectorProvider;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(BaseTestInjectorProvider.class)
@SuppressWarnings("all")
public class DetailCodeParseTest {
  private final String NL = Strings.newLine();
  
  private final String DELIM = "\'\'\'";
  
  @Inject
  private BaseConverterService baseConverterService;
  
  protected String toValue(final String withoutDelim) {
    CCStringConverter _cC_StringConverter = this.baseConverterService.getCC_StringConverter();
    String _value = _cC_StringConverter.toValue(withoutDelim, null);
    final Procedure1<String> _function = (String convertedWithoutDelim) -> {
      CCStringConverter _cC_StringConverter_1 = this.baseConverterService.getCC_StringConverter();
      final String convertedWithDelim = _cC_StringConverter_1.toValue(((this.DELIM + withoutDelim) + this.DELIM), null);
      Assert.assertEquals(convertedWithoutDelim, convertedWithDelim);
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
    final Procedure1<String> _function = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals("", _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ("\t" + this.NL), _function);
    final Procedure1<String> _function_1 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals(("text" + this.NL), _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("text");
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ("text" + this.NL), _function_1);
    final Procedure1<String> _function_2 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals((" text\t" + this.NL), _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("text\t");
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (" text\t" + this.NL), _function_2);
    final Procedure1<String> _function_3 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals(("text" + this.NL), _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("text");
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (("text" + this.NL) + "\t"), _function_3);
    final Procedure1<String> _function_4 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals("text ", _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("text ");
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + "text "), _function_4);
    final Procedure1<String> _function_5 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals("text", _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("text");
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((" " + this.NL) + "text"), _function_5);
    final Procedure1<String> _function_6 = (String text) -> {
      String _value_4 = this.toValue(text);
      Assert.assertEquals("text ", _value_4);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("text ");
      String _string_1 = _builder_1.toString();
      String _value_5 = this.toValue(text);
      Assert.assertEquals(_string_1, _value_5);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + " text "), _function_6);
  }
  
  @Test
  public void twoLineBreaks() {
    final Procedure1<String> _function = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals(this.NL, _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (this.NL + this.NL), _function);
    final Procedure1<String> _function_1 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals((("text" + this.NL) + this.NL), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text");
      _builder.newLine();
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (("text" + this.NL) + this.NL), _function_1);
    final Procedure1<String> _function_2 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals(((("text" + this.NL) + "\t\t\t\tindent") + this.NL), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("indent");
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((("text" + this.NL) + "\t\t\t\tindent") + this.NL), _function_2);
    final Procedure1<String> _function_3 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals(("text" + this.NL), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text");
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((this.NL + "text") + this.NL), _function_3);
    final Procedure1<String> _function_4 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals(("text\t" + this.NL), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text\t");
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      ((this.NL + "\t\t\t\ttext\t") + this.NL), _function_4);
    final Procedure1<String> _function_5 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals((("text" + this.NL) + "text2 "), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text");
      _builder.newLine();
      _builder.append("text2 ");
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "text") + this.NL) + "text2 "), _function_5);
    final Procedure1<String> _function_6 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals((("\ttext" + this.NL) + "text2 "), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("text");
      _builder.newLine();
      _builder.append("text2 ");
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "\ttext") + this.NL) + "text2 "), _function_6);
    final Procedure1<String> _function_7 = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals((("text" + this.NL) + "\t\t\tindent"), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("text");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("indent");
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((this.NL + "text") + this.NL) + "\t\t\tindent"), _function_7);
  }
  
  @Test
  public void multiLineBreaks() {
    final Procedure1<String> _function = (String text) -> {
      String _value = this.toValue(text);
      Assert.assertEquals((((((("   " + this.NL) + this.NL) + "\t\t ") + this.NL) + "text") + this.NL), _value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("   ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t ");
      _builder.newLine();
      _builder.append("text");
      _builder.newLine();
      String _string = _builder.toString();
      String _value_1 = this.toValue(text);
      Assert.assertEquals(_string, _value_1);
    };
    ObjectExtensions.<String>operator_doubleArrow(
      (((((((this.NL + "\t\t\t   ") + this.NL) + this.NL) + "\t\t ") + this.NL) + "\t\t\ttext") + this.NL), _function);
  }
}
