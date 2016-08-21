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
    CharSequence _xblockexpression = null;
    {
      boolean _isEmpty = IterableExtensions.isEmpty(items);
      if (_isEmpty) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(": ");
      CharSequence _head = IterableExtensions.head(items);
      _builder.append(_head, "");
      _builder.newLineIfNotEmpty();
      {
        Iterable<? extends CharSequence> _tail = IterableExtensions.tail(items);
        for(final CharSequence item : _tail) {
          _builder.append(", ");
          _builder.append(item, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Generate array and struct initialization
   */
  public CharSequence genExtraInitializers(final Iterable<Attribute> attributes) {
    CharSequence _xblockexpression = null;
    {
      final Function1<Attribute, Boolean> _function = new Function1<Attribute, Boolean>() {
        public Boolean apply(final Attribute it) {
          boolean _and = false;
          boolean _and_1 = false;
          String _initializerListValue = Initialization.this.getInitializerListValue(it);
          boolean _equals = Objects.equal(_initializerListValue, null);
          if (!_equals) {
            _and_1 = false;
          } else {
            String _initValue = Initialization.this.getInitValue(it);
            boolean _notEquals = (!Objects.equal(_initValue, null));
            _and_1 = _notEquals;
          }
          if (!_and_1) {
            _and = false;
          } else {
            String _initValue_1 = Initialization.this.getInitValue(it);
            boolean _startsWith = _initValue_1.startsWith("{");
            _and = _startsWith;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Attribute> extraInitAttrs = IterableExtensions.<Attribute>filter(attributes, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(extraInitAttrs);
      if (_isEmpty) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// extra initialization");
      _builder.newLine();
      {
        final Function1<Attribute, Boolean> _function_1 = new Function1<Attribute, Boolean>() {
          public Boolean apply(final Attribute it) {
            int _size = it.getSize();
            return Boolean.valueOf((_size > 0));
          }
        };
        Iterable<Attribute> _filter = IterableExtensions.<Attribute>filter(extraInitAttrs, _function_1);
        for(final Attribute it : _filter) {
          String _typeName = this.typeHelpers.getTypeName(it);
          _builder.append(_typeName, "");
          _builder.append(" ");
          String _name = it.getName();
          _builder.append(_name, "");
          _builder.append("InitValues[");
          int _size = it.getSize();
          _builder.append(_size, "");
          _builder.append("] = ");
          String _initValue = this.getInitValue(it);
          _builder.append(_initValue, "");
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
      {
        final Function1<Attribute, Boolean> _function_2 = new Function1<Attribute, Boolean>() {
          public Boolean apply(final Attribute it) {
            int _size = it.getSize();
            return Boolean.valueOf((_size == 0));
          }
        };
        Iterable<Attribute> _filter_1 = IterableExtensions.<Attribute>filter(extraInitAttrs, _function_2);
        for(final Attribute it_1 : _filter_1) {
          String _typeName_1 = this.typeHelpers.getTypeName(it_1);
          _builder.append(_typeName_1, "");
          _builder.append(" ");
          String _name_3 = it_1.getName();
          _builder.append(_name_3, "");
          _builder.append("InitValue = ");
          String _initValue_1 = this.getInitValue(it_1);
          _builder.append(_initValue_1, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          String _name_4 = it_1.getName();
          _builder.append(_name_4, "");
          _builder.append(" = ");
          String _name_5 = it_1.getName();
          _builder.append(_name_5, "");
          _builder.append("InitValue;");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String getInitializerListValue(final Attribute attribute) {
    final String initValue = this.getInitValue(attribute);
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(initValue, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _startsWith = initValue.startsWith("{");
      _and = _startsWith;
    }
    if (_and) {
      _xifexpression = null;
    } else {
      _xifexpression = initValue;
    }
    return _xifexpression;
  }
  
  protected String getInitValue(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    if (!_matched) {
      String _defaultValueLiteral = it.getDefaultValueLiteral();
      boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
      if (_notEquals) {
        _matched=true;
        _switchResult = it.getDefaultValueLiteral();
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
