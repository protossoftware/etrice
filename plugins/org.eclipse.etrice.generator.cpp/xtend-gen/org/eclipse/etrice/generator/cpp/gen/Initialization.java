/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Initialization {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  public CharSequence generateCtorInitializerList(final Iterable<? extends CharSequence> items) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final CharSequence s : items) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(":", "");
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append(s, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence genArrayInitializers(final Iterable<Attribute> attributes) {
    CharSequence _xblockexpression = null;
    {
      final Function1<Attribute, Boolean> _function = new Function1<Attribute, Boolean>() {
        public Boolean apply(final Attribute it) {
          boolean _and = false;
          boolean _and_1 = false;
          int _size = it.getSize();
          boolean _greaterThan = (_size > 0);
          if (!_greaterThan) {
            _and_1 = false;
          } else {
            String _defaultValueLiteral = it.getDefaultValueLiteral();
            boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
            _and_1 = _notEquals;
          }
          if (!_and_1) {
            _and = false;
          } else {
            String _defaultValueLiteral_1 = it.getDefaultValueLiteral();
            boolean _startsWith = _defaultValueLiteral_1.startsWith("{");
            _and = _startsWith;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Attribute> arrayInitAttrs = IterableExtensions.<Attribute>filter(attributes, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(arrayInitAttrs);
      if (_isEmpty) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// array initialization");
      _builder.newLine();
      {
        for(final Attribute it : arrayInitAttrs) {
          String _typeName = this.typeHelpers.getTypeName(it);
          _builder.append(_typeName, "");
          _builder.append(" ");
          String _name = it.getName();
          _builder.append(_name, "");
          _builder.append("InitValues[");
          int _size = it.getSize();
          _builder.append(_size, "");
          _builder.append("] = ");
          String _defaultValueLiteral = it.getDefaultValueLiteral();
          _builder.append(_defaultValueLiteral, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          String _name_1 = it.getName();
          _builder.append(_name_1, "");
          _builder.append(" = ");
          String _name_2 = it.getName();
          _builder.append(_name_2, "");
          _builder.append("InitValues;");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String getInitializerListValue(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    if (!_matched) {
      String _defaultValueLiteral = it.getDefaultValueLiteral();
      boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
      if (_notEquals) {
        _matched=true;
        String _xifexpression = null;
        String _defaultValueLiteral_1 = it.getDefaultValueLiteral();
        boolean _startsWith = _defaultValueLiteral_1.startsWith("{");
        if (_startsWith) {
          _xifexpression = null;
        } else {
          _xifexpression = it.getDefaultValueLiteral();
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      RefableType _type = it.getType();
      boolean _isRef = _type.isRef();
      if (_isRef) {
        _matched=true;
        _switchResult = this.languageExt.nullPointer();
      }
    }
    if (!_matched) {
      RefableType _type_1 = it.getType();
      DataType _type_2 = _type_1.getType();
      _switchResult = this.languageExt.defaultValue(_type_2);
    }
    return _switchResult;
  }
}
