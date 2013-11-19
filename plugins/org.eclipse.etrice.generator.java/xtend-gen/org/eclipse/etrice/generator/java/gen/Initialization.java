/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Initialization {
  @Inject
  @Extension
  private TypeHelpers typeHelpers;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private JavaExtensions languageExt;
  
  @Inject
  @Extension
  private ProcedureHelpers procedureHelpers;
  
  public CharSequence attributeInitialization(final List<Attribute> attribs, final EObject roomClass, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        CharSequence _attributeClassInit = this.attributeClassInit(a, roomClass, useClassDefaultsOnly);
        _builder.append(_attributeClassInit, "");
        _builder.newLineIfNotEmpty();
        {
          RefableType _type = a.getType();
          DataType _type_1 = _type.getType();
          boolean _isDataClass = this.typeHelpers.isDataClass(_type_1);
          if (_isDataClass) {
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            CharSequence _attributeInitPrimitiveRec = this.attributeInitPrimitiveRec(_union, roomClass);
            _builder.append(_attributeInitPrimitiveRec, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence attributeClassInit(final Attribute a, final EObject roomClass, final boolean useClassDefaultsOnly) {
    CharSequence _xblockexpression = null;
    {
      RefableType _type = a.getType();
      DataType aType = _type.getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        RefableType _type_1 = a.getType();
        boolean _isRef = _type_1.isRef();
        if (_isRef) {
          _matched=true;
          CharSequence _xifexpression = null;
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
          if (_notEquals) {
            String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
            CharSequence _attributeInit = this.attributeInit(a, _defaultValueLiteral_1);
            _xifexpression = _attributeInit;
          } else {
            CharSequence _xifexpression_1 = null;
            boolean _needsInitialization = this.languageExt.needsInitialization(a);
            if (_needsInitialization) {
              String _nullPointer = this.languageExt.nullPointer();
              CharSequence _attributeInit_1 = this.attributeInit(a, _nullPointer);
              _xifexpression_1 = _attributeInit_1;
            }
            _xifexpression = _xifexpression_1;
          }
          _switchResult = _xifexpression;
        }
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          final PrimitiveType _primitiveType = (PrimitiveType)aType;
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            String value = this.getDataConfigValue(_union, roomClass);
            boolean _equals = Objects.equal(value, null);
            if (_equals) {
              String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
              value = _defaultValueLiteral_2;
            }
            CharSequence _xifexpression_2 = null;
            boolean _notEquals_1 = (!Objects.equal(value, null));
            if (_notEquals_1) {
              String _valueLiteral = this.languageExt.toValueLiteral(_primitiveType, value);
              CharSequence _attributeInit_2 = this.attributeInit(a, _valueLiteral);
              _xifexpression_2 = _attributeInit_2;
            } else {
              CharSequence _xifexpression_3 = null;
              boolean _or = false;
              boolean _not = (!useClassDefaultsOnly);
              if (_not) {
                _or = true;
              } else {
                boolean _needsInitialization_1 = this.languageExt.needsInitialization(a);
                _or = (_not || _needsInitialization_1);
              }
              if (_or) {
                String _defaultValue = this.languageExt.defaultValue(_primitiveType);
                CharSequence _attributeInit_3 = this.attributeInit(a, _defaultValue);
                _xifexpression_3 = _attributeInit_3;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_1 = (_xifexpression_2);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (aType instanceof EnumerationType) {
          final EnumerationType _enumerationType = (EnumerationType)aType;
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
            List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
            String value = this.getDataConfigValue(_union, roomClass);
            boolean _equals = Objects.equal(value, null);
            if (_equals) {
              String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
              value = _defaultValueLiteral_2;
            }
            CharSequence _xifexpression_2 = null;
            boolean _notEquals_1 = (!Objects.equal(value, null));
            if (_notEquals_1) {
              String _enumLiteral = this.languageExt.toEnumLiteral(_enumerationType, value);
              CharSequence _attributeInit_2 = this.attributeInit(a, _enumLiteral);
              _xifexpression_2 = _attributeInit_2;
            } else {
              CharSequence _xifexpression_3 = null;
              boolean _or = false;
              boolean _not = (!useClassDefaultsOnly);
              if (_not) {
                _or = true;
              } else {
                boolean _needsInitialization_1 = this.languageExt.needsInitialization(a);
                _or = (_not || _needsInitialization_1);
              }
              if (_or) {
                String _defaultValue = this.languageExt.defaultValue(_enumerationType);
                CharSequence _attributeInit_3 = this.attributeInit(a, _defaultValue);
                _xifexpression_3 = _attributeInit_3;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_1 = (_xifexpression_2);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  private CharSequence attributeInitPrimitiveRec(final List<Attribute> path, final EObject roomClass) {
    CharSequence _xblockexpression = null;
    {
      Attribute a = IterableExtensions.<Attribute>last(path);
      RefableType _type = a.getType();
      DataType aType = _type.getType();
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (aType instanceof DataClass) {
          final DataClass _dataClass = (DataClass)aType;
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          {
            List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(((DataClass) _dataClass));
            for(final Attribute e : _allAttributes) {
              List<Attribute> _union = this._roomExtensions.<Attribute>union(path, e);
              CharSequence _attributeInitPrimitiveRec = this.attributeInitPrimitiveRec(_union, roomClass);
              _builder.append(_attributeInitPrimitiveRec, "");
              _builder.newLineIfNotEmpty();
            }
          }
          return _builder;
        }
      }
      if (!_matched) {
        if (aType instanceof PrimitiveType) {
          final PrimitiveType _primitiveType = (PrimitiveType)aType;
          _matched=true;
          String value = this.getDataConfigValue(path, roomClass);
          CharSequence _xifexpression = null;
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            String _valueLiteral = this.languageExt.toValueLiteral(_primitiveType, value);
            CharSequence _attributeInit = this.attributeInit(path, _valueLiteral);
            _xifexpression = _attributeInit;
          }
          return _xifexpression;
        }
      }
      if (!_matched) {
        if (aType instanceof EnumerationType) {
          final EnumerationType _enumerationType = (EnumerationType)aType;
          _matched=true;
          String value = this.getDataConfigValue(path, roomClass);
          CharSequence _xifexpression = null;
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            String _enumLiteral = this.languageExt.toEnumLiteral(_enumerationType, value);
            CharSequence _attributeInit = this.attributeInit(path, _enumLiteral);
            _xifexpression = _attributeInit;
          }
          return _xifexpression;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  private CharSequence attributeInit(final Attribute a, final String value) {
    ArrayList<Attribute> _arrayList = new ArrayList<Attribute>();
    List<Attribute> _union = this._roomExtensions.<Attribute>union(_arrayList, a);
    CharSequence _attributeInit = this.attributeInit(_union, value);
    return _attributeInit;
  }
  
  private CharSequence attributeInit(final List<Attribute> path, final String value) {
    String _xifexpression = null;
    int _size = path.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      _xifexpression = "this";
    } else {
      int _size_1 = path.size();
      int _minus = (_size_1 - 1);
      Iterable<Attribute> _take = IterableExtensions.<Attribute>take(path, _minus);
      CharSequence _invokeGetters = this.procedureHelpers.invokeGetters(_take, null);
      String _string = _invokeGetters.toString();
      _xifexpression = _string;
    }
    final String getter = _xifexpression;
    Attribute _last = IterableExtensions.<Attribute>last(path);
    return this.genAttributeInitializer(_last, value, getter);
  }
  
  public CharSequence genAttributeInitializer(final Attribute a, final String value, final String invokes) {
    CharSequence _xblockexpression = null;
    {
      RefableType _type = a.getType();
      DataType aType = _type.getType();
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _or = false;
        int _size = a.getSize();
        boolean _equals = (_size == 0);
        if (_equals) {
          _or = true;
        } else {
          boolean _and = false;
          boolean _and_1 = false;
          int _size_1 = a.getSize();
          boolean _greaterThan = (_size_1 > 0);
          if (!_greaterThan) {
            _and_1 = false;
          } else {
            String _typeName = this.typeHelpers.typeName(aType);
            boolean _equals_1 = "char".equals(_typeName);
            _and_1 = (_greaterThan && _equals_1);
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _matches = value.matches("\'.\'|\\(char\\).*");
            boolean _not = (!_matches);
            _and = (_and_1 && _not);
          }
          _or = (_equals || _and);
        }
        if (_or) {
          _builder.append(invokes, "");
          _builder.append(".");
          String _name = a.getName();
          CharSequence _invokeSetter = this.procedureHelpers.invokeSetter(_name, null, value);
          _builder.append(_invokeSetter, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _or_1 = false;
          String _trim = value.trim();
          boolean _startsWith = _trim.startsWith("{");
          boolean _not_1 = (!_startsWith);
          if (_not_1) {
            _or_1 = true;
          } else {
            String _typeName_1 = this.typeHelpers.typeName(aType);
            boolean _equals_2 = "char".equals(_typeName_1);
            _or_1 = (_not_1 || _equals_2);
          }
          if (_or_1) {
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            String _typeName_2 = this.typeHelpers.typeName(aType);
            _builder.append(_typeName_2, "	");
            _builder.append("[] array = new ");
            String _typeName_3 = this.typeHelpers.typeName(aType);
            _builder.append(_typeName_3, "	");
            _builder.append("[");
            int _size_2 = a.getSize();
            _builder.append(_size_2, "	");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            {
              boolean _and_2 = false;
              RefableType _type_1 = a.getType();
              boolean _isRef = _type_1.isRef();
              if (!_isRef) {
                _and_2 = false;
              } else {
                boolean _isPrimitive = this.typeHelpers.isPrimitive(aType);
                _and_2 = (_isRef && _isPrimitive);
              }
              boolean _not_2 = (!_and_2);
              if (_not_2) {
                _builder.append("\t");
                _builder.append("for (int i=0;i<");
                int _size_3 = a.getSize();
                _builder.append(_size_3, "	");
                _builder.append(";i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("array[i] = ");
                _builder.append(value, "		");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append(invokes, "	");
            _builder.append(".");
            String _name_1 = a.getName();
            CharSequence _invokeSetter_1 = this.procedureHelpers.invokeSetter(_name_1, null, "array");
            _builder.append(_invokeSetter_1, "	");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append(invokes, "");
            _builder.append(".");
            String _name_2 = a.getName();
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("new ");
            String _typeName_4 = this.typeHelpers.typeName(aType);
            _builder_1.append(_typeName_4, "");
            _builder_1.append("[] ");
            _builder_1.append(value, "");
            CharSequence _invokeSetter_2 = this.procedureHelpers.invokeSetter(_name_2, null, _builder_1.toString());
            _builder.append(_invokeSetter_2, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getDataConfigValue(final List<Attribute> path, final EObject roomClass) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (roomClass instanceof ActorClass) {
        final ActorClass _actorClass = (ActorClass)roomClass;
        _matched=true;
        String _attrClassConfigValue = this.typeHelpers.getAttrClassConfigValue(path, _actorClass, false);
        _switchResult = _attrClassConfigValue;
      }
    }
    if (!_matched) {
      if (roomClass instanceof PortClass) {
        final PortClass _portClass = (PortClass)roomClass;
        _matched=true;
        String _attrClassConfigValue = this.typeHelpers.getAttrClassConfigValue(path, _portClass);
        _switchResult = _attrClassConfigValue;
      }
    }
    if (!_matched) {
      if (roomClass instanceof DataClass) {
        final DataClass _dataClass = (DataClass)roomClass;
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }
}
