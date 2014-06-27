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
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
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
    return _generateArglistAndTypedData[1];
  }
  
  public String getCppHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".h");
  }
  
  public String getCppSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".cpp");
  }
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Inst.h");
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Disp.h");
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
      _xifexpression = (classname + "::");
    }
    return _xifexpression;
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    return member;
  }
  
  public String memberInUse(final String namespace, final String member) {
    return ((namespace + ".") + member);
  }
  
  public boolean usesInheritance() {
    return true;
  }
  
  public boolean usesPointers() {
    return true;
  }
  
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
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
    return _builder.toString();
  }
  
  public String booleanConstant(final boolean b) {
    return Boolean.valueOf(b).toString();
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
    return (((((type + " ") + name) + "[") + Integer.valueOf(size)) + "]");
  }
  
  public String constructorName(final String cls) {
    return cls;
  }
  
  public String destructorName(final String cls) {
    return (cls + "_dtor");
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
    return (((((baseClassName + "::") + method) + "(") + arguments) + ");");
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    throw new UnsupportedOperationException("TODO Config for Cpp");
  }
  
  public String toEnumLiteral(final EnumerationType type, final String value) {
    throw new UnsupportedOperationException("TODO Config for Cpp");
  }
  
  public String defaultValue(final DataType dt) {
    String _xifexpression = null;
    if ((dt instanceof PrimitiveType)) {
      return ((PrimitiveType) dt).getDefaultValueLiteral();
    } else {
      String _xifexpression_1 = null;
      if ((dt instanceof EnumerationType)) {
        return this.getDefaultValue(((EnumerationType) dt));
      } else {
        String _xifexpression_2 = null;
        if ((dt instanceof ExternalType)) {
          String _name = ((ExternalType)dt).getName();
          String _plus = ("initialize external type with default constructor" + _name);
          EObject _eContainer = ((ExternalType)dt).eContainer();
          EStructuralFeature _eContainingFeature = ((ExternalType)dt).eContainingFeature();
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
                  _builder.appendImmediate(",", "\t");
                }
                _builder.append("\t");
                RefableType _type = att.getType();
                DataType _type_1 = _type.getType();
                int _size = att.getSize();
                String _initializationWithDefaultValues = this.initializationWithDefaultValues(_type_1, _size);
                _builder.append(_initializationWithDefaultValues, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _xblockexpression = _builder.toString();
          }
          _xifexpression_2 = _xblockexpression;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String getDefaultValue(final EnumerationType type) {
    String _xifexpression = null;
    EList<EnumLiteral> _literals = type.getLiterals();
    boolean _isEmpty = _literals.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      EList<EnumLiteral> _literals_1 = type.getLiterals();
      EnumLiteral _get = _literals_1.get(0);
      _xifexpression = this.getCastedValue(_get);
    }
    return _xifexpression;
  }
  
  public String initializationWithDefaultValues(final DataType dt, final int size) {
    String _xblockexpression = null;
    {
      final String dv = this.defaultValue(dt);
      String _xifexpression = null;
      if ((size > 1)) {
        String _xblockexpression_1 = null;
        {
          String res = "{";
          int i = 0;
          boolean _while = (i < size);
          while (_while) {
            {
              res = (res + dv);
              i = (i + 1);
              if ((i < size)) {
                res = (res + ",");
              }
            }
            _while = (i < size);
          }
          _xblockexpression_1 = (res + "}");
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = dv;
      }
      _xblockexpression = _xifexpression;
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
      _xifexpression = ((PrimitiveType) _type_1).getTargetName();
    } else {
      String _xifexpression_1 = null;
      RefableType _refType_2 = data.getRefType();
      DataType _type_2 = _refType_2.getType();
      if ((_type_2 instanceof EnumerationType)) {
        RefableType _refType_3 = data.getRefType();
        DataType _type_3 = _refType_3.getType();
        _xifexpression_1 = this.getTargetType(((EnumerationType) _type_3));
      } else {
        RefableType _refType_4 = data.getRefType();
        DataType _type_4 = _refType_4.getType();
        _xifexpression_1 = _type_4.getName();
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
          _and = _not;
        }
        if (_and) {
          _xifexpression_3 = ct;
        } else {
          _xifexpression_3 = typeName;
        }
        _xblockexpression = _xifexpression_3;
      }
      _xifexpression_2 = _xblockexpression;
    } else {
      String _xifexpression_3 = null;
      RefableType _refType_6 = data.getRefType();
      DataType _type_6 = _refType_6.getType();
      if ((_type_6 instanceof EnumerationType)) {
        RefableType _refType_7 = data.getRefType();
        DataType _type_7 = _refType_7.getType();
        _xifexpression_3 = this.getCastType(((EnumerationType) _type_7));
      } else {
        _xifexpression_3 = typeName;
      }
      _xifexpression_2 = _xifexpression_3;
    }
    String castTypeName = _xifexpression_2;
    castTypeName = (castTypeName + "*");
    RefableType _refType_8 = data.getRefType();
    boolean _isRef = _refType_8.isRef();
    if (_isRef) {
      typeName = (typeName + "*");
      castTypeName = (castTypeName + "*");
    } else {
      RefableType _refType_9 = data.getRefType();
      DataType _type_8 = _refType_9.getType();
      if ((!(_type_8 instanceof PrimitiveType))) {
        typeName = (typeName + "*");
        castTypeName = (castTypeName + "*");
      } else {
        castTypeName = typeName;
        deref = "";
      }
    }
    String _name = data.getName();
    String _plus = ((typeName + " ") + _name);
    String _plus_1 = (_plus + " = ");
    String _plus_2 = (_plus_1 + deref);
    String _plus_3 = (_plus_2 + "((");
    String _plus_4 = (_plus_3 + castTypeName);
    final String typedData = (_plus_4 + ") generic_data);\n");
    String _name_1 = data.getName();
    final String dataArg = (", " + _name_1);
    String _name_2 = data.getName();
    final String typedArgList = (((", " + typeName) + " ") + _name_2);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
  
  public String getTargetType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      PrimitiveType _primitiveType_1 = type.getPrimitiveType();
      _xifexpression = _primitiveType_1.getTargetName();
    } else {
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
  
  public String getCastedValue(final EnumLiteral literal) {
    String _xblockexpression = null;
    {
      EObject _eContainer = literal.eContainer();
      final EnumerationType type = ((EnumerationType) _eContainer);
      final String cast = this.getTargetType(type);
      String _xifexpression = null;
      PrimitiveType _primitiveType = type.getPrimitiveType();
      boolean _notEquals = (!Objects.equal(_primitiveType, null));
      if (_notEquals) {
        long _literalValue = literal.getLiteralValue();
        _xifexpression = Long.toString(_literalValue);
      } else {
        long _literalValue_1 = literal.getLiteralValue();
        String _string = Long.toString(_literalValue_1);
        String _plus = ((("((" + cast) + ")") + _string);
        _xifexpression = (_plus + ")");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getCastType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      PrimitiveType _primitiveType_1 = type.getPrimitiveType();
      _xifexpression = _primitiveType_1.getCastName();
    } else {
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
}
