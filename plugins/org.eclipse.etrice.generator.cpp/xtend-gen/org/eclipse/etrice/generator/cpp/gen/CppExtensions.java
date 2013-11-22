/**
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class CppExtensions implements ILanguageExtension {
  @Inject
  private IDiagnostician diagnostician;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String[] _generateArglistAndTypedData = this.generateArglistAndTypedData(_data);
    String _get = _generateArglistAndTypedData[1];
    return _get;
  }
  
  public String getCppHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".h");
    return _plus;
  }
  
  public String getCppSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".cpp");
    return _plus;
  }
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "_Inst.h");
    return _plus;
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "_Disp.h");
    return _plus;
  }
  
  public String accessLevelPrivate() {
    return "";
  }
  
  public String accessLevelProtected() {
    return "";
  }
  
  public String accessLevelPublic() {
    return "";
  }
  
  public String memberAccess() {
    return "this->";
  }
  
  public String selfPointer(final String classname, final boolean hasArgs) {
    return "";
  }
  
  public String selfPointer(final boolean hasArgs) {
    return "";
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    String _xifexpression = null;
    if (isDeclaration) {
      _xifexpression = "";
    } else {
      String _plus = (classname + "::");
      _xifexpression = _plus;
    }
    return _xifexpression;
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    return member;
  }
  
  public String memberInUse(final String namespace, final String member) {
    String _plus = (namespace + ".");
    return (_plus + member);
  }
  
  public boolean usesInheritance() {
    return true;
  }
  
  public boolean usesPointers() {
    return true;
  }
  
  public String genEnumeration(final String name, final List<Pair<String,String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef enum {");
    _builder.newLine();
    {
      for(final Pair<String, String> entry : entries) {
        String _first = entry.getFirst();
        _builder.append(_first, "");
        _builder.append(" = ");
        String _second = entry.getSecond();
        _builder.append(_second, "");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    _builder.append(name, "");
    _builder.append(";");
    String _string = _builder.toString();
    return _string;
  }
  
  public String booleanConstant(final boolean b) {
    String _string = Boolean.valueOf(b).toString();
    return _string;
  }
  
  public String pointerLiteral() {
    return "*";
  }
  
  public String nullPointer() {
    return "0";
  }
  
  public String voidPointer() {
    return "void*";
  }
  
  public String arrayDeclaration(final String type, final int size, final String name, final boolean isRef) {
    String _plus = (type + " ");
    String _plus_1 = (_plus + name);
    String _plus_2 = (_plus_1 + "[");
    String _plus_3 = (_plus_2 + Integer.valueOf(size));
    String _plus_4 = (_plus_3 + "]");
    return _plus_4;
  }
  
  public String constructorName(final String cls) {
    return cls;
  }
  
  public String destructorName(final String cls) {
    String _plus = (cls + "_dtor");
    return _plus;
  }
  
  public String constructorReturnType() {
    return "";
  }
  
  public String destructorReturnType() {
    return "void";
  }
  
  public CharSequence getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _replaceAll = filename.replaceAll("\\/.", "_");
    String _upperCase = _replaceAll.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_H_");
    return _builder;
  }
  
  public CharSequence generateIncludeGuardBegin(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    CharSequence _includeGuardString_1 = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateIncludeGuardEnd(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String superCall(final String baseClassName, final String method, final String arguments) {
    String _plus = (baseClassName + "::");
    String _plus_1 = (_plus + method);
    String _plus_2 = (_plus_1 + "(");
    String _plus_3 = (_plus_2 + arguments);
    String _plus_4 = (_plus_3 + ");");
    return _plus_4;
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO Config for Cpp");
    throw _unsupportedOperationException;
  }
  
  public String defaultValue(final DataType dt) {
    String _xifexpression = null;
    if ((dt instanceof PrimitiveType)) {
      return ((PrimitiveType) dt).getDefaultValueLiteral();
    } else {
      String _xifexpression_1 = null;
      if ((dt instanceof EnumerationType)) {
        return RoomHelpers.getDefaultValue(((EnumerationType) dt));
      } else {
        String _xifexpression_2 = null;
        if ((dt instanceof ExternalType)) {
          String _name = dt.getName();
          String _plus = ("initialize external type with default constructor" + _name);
          EObject _eContainer = dt.eContainer();
          EStructuralFeature _eContainingFeature = dt.eContainingFeature();
          this.diagnostician.warning(_plus, _eContainer, _eContainingFeature);
          String _typeName = this._typeHelpers.typeName(dt);
          return (_typeName + "()");
        } else {
          String _xblockexpression = null;
          {
            final DataClass dc = ((DataClass) dt);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("{");
            _builder.newLine();
            {
              EList<Attribute> _attributes = dc.getAttributes();
              boolean _hasElements = false;
              for(final Attribute att : _attributes) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",", "	");
                }
                _builder.append("\t");
                RefableType _type = att.getType();
                DataType _type_1 = _type.getType();
                int _size = att.getSize();
                String _initializationWithDefaultValues = this.initializationWithDefaultValues(_type_1, _size);
                _builder.append(_initializationWithDefaultValues, "	");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _xblockexpression = (_builder.toString());
          }
          _xifexpression_2 = _xblockexpression;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String initializationWithDefaultValues(final DataType dt, final int size) {
    String _xblockexpression = null;
    {
      final String dv = this.defaultValue(dt);
      String _xifexpression = null;
      boolean _greaterThan = (size > 1);
      if (_greaterThan) {
        String _xblockexpression_1 = null;
        {
          String res = "{";
          int i = 0;
          boolean _lessThan = (i < size);
          boolean _while = _lessThan;
          while (_while) {
            {
              String _plus = (res + dv);
              res = _plus;
              int _plus_1 = (i + 1);
              i = _plus_1;
              boolean _lessThan_1 = (i < size);
              if (_lessThan_1) {
                String _plus_2 = (res + ",");
                res = _plus_2;
              }
            }
            boolean _lessThan_1 = (i < size);
            _while = _lessThan_1;
          }
          String _plus = (res + "}");
          _xblockexpression_1 = (_plus);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = dv;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String[] generateArglistAndTypedData(final VarDecl data) {
    String deref = "*";
    boolean _equals = Objects.equal(data, null);
    if (_equals) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    String _xifexpression = null;
    RefableType _refType = data.getRefType();
    DataType _type = _refType.getType();
    if ((_type instanceof PrimitiveType)) {
      RefableType _refType_1 = data.getRefType();
      DataType _type_1 = _refType_1.getType();
      String _targetName = ((PrimitiveType) _type_1).getTargetName();
      _xifexpression = _targetName;
    } else {
      String _xifexpression_1 = null;
      RefableType _refType_2 = data.getRefType();
      DataType _type_2 = _refType_2.getType();
      if ((_type_2 instanceof EnumerationType)) {
        RefableType _refType_3 = data.getRefType();
        DataType _type_3 = _refType_3.getType();
        String _targetType = RoomHelpers.getTargetType(((EnumerationType) _type_3));
        _xifexpression_1 = _targetType;
      } else {
        RefableType _refType_4 = data.getRefType();
        DataType _type_4 = _refType_4.getType();
        String _name = _type_4.getName();
        _xifexpression_1 = _name;
      }
      _xifexpression = _xifexpression_1;
    }
    String typeName = _xifexpression;
    String _xifexpression_2 = null;
    RefableType _refType_5 = data.getRefType();
    DataType _type_5 = _refType_5.getType();
    if ((_type_5 instanceof PrimitiveType)) {
      String _xblockexpression = null;
      {
        RefableType _refType_6 = data.getRefType();
        DataType _type_6 = _refType_6.getType();
        final String ct = ((PrimitiveType) _type_6).getCastName();
        String _xifexpression_3 = null;
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(ct, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _isEmpty = ct.isEmpty();
          boolean _not = (!_isEmpty);
          _and = (_notEquals && _not);
        }
        if (_and) {
          _xifexpression_3 = ct;
        } else {
          _xifexpression_3 = typeName;
        }
        _xblockexpression = (_xifexpression_3);
      }
      _xifexpression_2 = _xblockexpression;
    } else {
      String _xifexpression_3 = null;
      RefableType _refType_6 = data.getRefType();
      DataType _type_6 = _refType_6.getType();
      if ((_type_6 instanceof EnumerationType)) {
        RefableType _refType_7 = data.getRefType();
        DataType _type_7 = _refType_7.getType();
        String _castType = RoomHelpers.getCastType(((EnumerationType) _type_7));
        _xifexpression_3 = _castType;
      } else {
        _xifexpression_3 = typeName;
      }
      _xifexpression_2 = _xifexpression_3;
    }
    String castTypeName = _xifexpression_2;
    String _plus = (castTypeName + "*");
    castTypeName = _plus;
    RefableType _refType_8 = data.getRefType();
    boolean _isRef = _refType_8.isRef();
    if (_isRef) {
      String _plus_1 = (typeName + "*");
      typeName = _plus_1;
      String _plus_2 = (castTypeName + "*");
      castTypeName = _plus_2;
    } else {
      RefableType _refType_9 = data.getRefType();
      DataType _type_8 = _refType_9.getType();
      boolean _not = (!(_type_8 instanceof PrimitiveType));
      if (_not) {
        String _plus_3 = (typeName + "*");
        typeName = _plus_3;
        String _plus_4 = (castTypeName + "*");
        castTypeName = _plus_4;
      } else {
        castTypeName = typeName;
        deref = "";
      }
    }
    String _plus_5 = (typeName + " ");
    String _name_1 = data.getName();
    String _plus_6 = (_plus_5 + _name_1);
    String _plus_7 = (_plus_6 + " = ");
    String _plus_8 = (_plus_7 + deref);
    String _plus_9 = (_plus_8 + "((");
    String _plus_10 = (_plus_9 + castTypeName);
    final String typedData = (_plus_10 + ") generic_data);\n");
    String _name_2 = data.getName();
    final String dataArg = (", " + _name_2);
    String _plus_11 = (", " + typeName);
    String _plus_12 = (_plus_11 + " ");
    String _name_3 = data.getName();
    final String typedArgList = (_plus_12 + _name_3);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
}
