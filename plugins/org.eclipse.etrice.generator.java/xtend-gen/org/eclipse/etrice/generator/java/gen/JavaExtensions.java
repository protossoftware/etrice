/**
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class JavaExtensions implements ILanguageExtension {
  @Inject
  private TypeHelpers typeHelpers;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String[] _generateArglistAndTypedData = this.generateArglistAndTypedData(_data);
    return _generateArglistAndTypedData[1];
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".java");
  }
  
  public String getJavaFactoryName(final ActorClass rc) {
    String _name = rc.getName();
    return (_name + "Factory");
  }
  
  public String getJavaFactoryFileName(final ActorClass rc) {
    String _javaFactoryName = this.getJavaFactoryName(rc);
    return (_javaFactoryName + ".java");
  }
  
  public String getJavaScalarInterfaceName(final ActorClass rc) {
    String _name = rc.getName();
    return (_name + "Interface");
  }
  
  public String getJavaScalarInterfaceFileName(final ActorClass rc) {
    String _javaScalarInterfaceName = this.getJavaScalarInterfaceName(rc);
    return (_javaScalarInterfaceName + ".java");
  }
  
  public String getJavaReplicatedInterfaceName(final ActorClass rc) {
    String _name = rc.getName();
    return (_name + "ReplicatedInterface");
  }
  
  public String getJavaReplicatedInterfaceFileName(final ActorClass rc) {
    String _javaReplicatedInterfaceName = this.getJavaReplicatedInterfaceName(rc);
    return (_javaReplicatedInterfaceName + ".java");
  }
  
  public String getJavaInterfaceName(final ActorClass ac, final boolean replicated) {
    String _xifexpression = null;
    if (replicated) {
      _xifexpression = this.getJavaReplicatedInterfaceName(ac);
    } else {
      _xifexpression = this.getJavaScalarInterfaceName(ac);
    }
    return _xifexpression;
  }
  
  public String getJavaInterfaceFileName(final ActorClass ac, final boolean replicated) {
    String _xifexpression = null;
    if (replicated) {
      _xifexpression = this.getJavaReplicatedInterfaceFileName(ac);
    } else {
      _xifexpression = this.getJavaScalarInterfaceFileName(ac);
    }
    return _xifexpression;
  }
  
  public String getJavaClassName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = ("Node_" + _name);
    String _plus_1 = (_plus + "_");
    String _name_1 = ssi.getName();
    return (_plus_1 + _name_1);
  }
  
  public String getJavaFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _javaClassName = this.getJavaClassName(nr, ssi);
    return (_javaClassName + ".java");
  }
  
  public String toWrapper(final String type) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type, "int")) {
        _matched=true;
        _switchResult = "Integer";
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "char")) {
        _matched=true;
        _switchResult = "Character";
      }
    }
    if (!_matched) {
      _switchResult = StringExtensions.toFirstUpper(type);
    }
    return _switchResult;
  }
  
  public boolean needsInitialization(final Attribute a) {
    boolean _or = false;
    boolean _or_1 = false;
    int _size = a.getSize();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _or_1 = true;
    } else {
      RefableType _type = a.getType();
      DataType _type_1 = _type.getType();
      boolean _isEnumerationOrPrimitive = this.typeHelpers.isEnumerationOrPrimitive(_type_1);
      boolean _not = (!_isEnumerationOrPrimitive);
      _or_1 = _not;
    }
    if (_or_1) {
      _or = true;
    } else {
      RefableType _type_2 = a.getType();
      DataType _type_3 = _type_2.getType();
      String _typeName = this.typeHelpers.typeName(_type_3);
      boolean _equals = _typeName.equals("String");
      _or = _equals;
    }
    return _or;
  }
  
  public String accessLevelPrivate() {
    return "private ";
  }
  
  public String accessLevelProtected() {
    return "protected ";
  }
  
  public String accessLevelPublic() {
    return "public ";
  }
  
  public String memberAccess() {
    return "this.";
  }
  
  public String selfPointer(final String classname, final boolean hasArgs) {
    return "";
  }
  
  public String selfPointer(final boolean hasArgs) {
    return "";
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    return "";
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
    return false;
  }
  
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Pair<String, String> entry : entries) {
        _builder.append("public static final int ");
        String _first = entry.getFirst();
        _builder.append(_first, "");
        _builder.append(" = ");
        String _second = entry.getSecond();
        _builder.append(_second, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String booleanConstant(final boolean b) {
    return Boolean.valueOf(b).toString();
  }
  
  public String pointerLiteral() {
    return "";
  }
  
  public String nullPointer() {
    return "null";
  }
  
  public String voidPointer() {
    return "Object";
  }
  
  public String arrayDeclaration(final String type, final int size, final String name, final boolean isRef) {
    return (((type + " ") + name) + "[]");
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
  
  public String superCall(final String baseClassName, final String method, final String args) {
    return (((("super." + method) + "(") + args) + ");");
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _isCharacterType = this.typeHelpers.isCharacterType(type);
    boolean _not = (!_isCharacterType);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _contains = value.contains(",");
      if (_contains) {
        _or = true;
      } else {
        boolean _contains_1 = value.contains("{");
        _or = _contains_1;
      }
      _and = _or;
    }
    if (_and) {
      String _xblockexpression = null;
      {
        String _replace = value.replace("{", "");
        String _replace_1 = _replace.replace("}", "");
        String _trim = _replace_1.trim();
        String[] singleValues = _trim.split(",");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{ ");
        {
          boolean _hasElements = false;
          for(final String v : singleValues) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _trim_1 = v.trim();
            String _castValue = this.castValue(type, _trim_1);
            _builder.append(_castValue, "");
          }
        }
        _builder.append(" }");
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = this.castValue(type, value);
    }
    return _xifexpression;
  }
  
  public String toEnumLiteral(final EnumerationType type, final String value) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _contains = value.contains(",");
    if (_contains) {
      _or = true;
    } else {
      boolean _contains_1 = value.contains("{");
      _or = _contains_1;
    }
    if (_or) {
      String _xblockexpression = null;
      {
        String _replace = value.replace("{", "");
        String _replace_1 = _replace.replace("}", "");
        String _trim = _replace_1.trim();
        String[] singleValues = _trim.split(",");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{ ");
        {
          boolean _hasElements = false;
          for(final String v : singleValues) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _trim_1 = v.trim();
            String _convertStringEnumLiteral = this.convertStringEnumLiteral(type, _trim_1);
            _builder.append(_convertStringEnumLiteral, "");
          }
        }
        _builder.append(" }");
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = this.convertStringEnumLiteral(type, value);
    }
    return _xifexpression;
  }
  
  private String convertStringEnumLiteral(final EnumerationType type, final String value) {
    String v = value;
    String _name = type.getName();
    boolean _startsWith = v.startsWith(_name);
    if (_startsWith) {
      String _name_1 = type.getName();
      int _length = _name_1.length();
      int _plus = (_length + 1);
      String _substring = v.substring(_plus);
      v = _substring;
    }
    EList<EnumLiteral> _literals = type.getLiterals();
    for (final EnumLiteral l : _literals) {
      String _name_2 = l.getName();
      boolean _equals = _name_2.equals(v);
      if (_equals) {
        String _name_3 = type.getName();
        String _plus_1 = (_name_3 + ".");
        String _name_4 = l.getName();
        return (_plus_1 + _name_4);
      }
    }
    return null;
  }
  
  private String castValue(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_targetName, "boolean")) {
        _matched=true;
        _switchResult = value.toLowerCase();
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "byte")) {
        _matched=true;
        _switchResult = ("(byte)" + value);
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "short")) {
        _matched=true;
        _switchResult = ("(short)" + value);
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "int")) {
        _matched=true;
        _switchResult = value;
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "long")) {
        _matched=true;
        _switchResult = (value + "L");
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "float")) {
        _matched=true;
        _switchResult = (value + "f");
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "double")) {
        _matched=true;
        _switchResult = (value + "d");
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "char")) {
        _matched=true;
        String _xifexpression = null;
        boolean _isEmpty = value.isEmpty();
        if (_isEmpty) {
          _xifexpression = "(char) 0";
        } else {
          String _xifexpression_1 = null;
          int _length = value.length();
          boolean _equals = (_length == 1);
          if (_equals) {
            char _charAt = value.charAt(0);
            String _plus = ("\'" + Character.valueOf(_charAt));
            _xifexpression_1 = (_plus + "\'");
          } else {
            String _replace = value.replace("\\", "\\\\");
            String _replace_1 = _replace.replace("\"", "\\\"");
            String _plus_1 = ("\"" + _replace_1);
            _xifexpression_1 = (_plus_1 + "\".toCharArray()");
          }
          _xifexpression = _xifexpression_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "String")) {
        _matched=true;
        String _replace_2 = value.replace("\\", "\\\\");
        String _replace_3 = _replace_2.replace("\"", "\\\"");
        String _plus_2 = ("\"" + _replace_3);
        _switchResult = (_plus_2 + "\"");
      }
    }
    if (!_matched) {
      String _targetName_1 = type.getTargetName();
      throw new UnsupportedOperationException(_targetName_1);
    }
    return _switchResult;
  }
  
  public String defaultValue(final DataType dt) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (dt instanceof PrimitiveType) {
        _matched=true;
        String _defaultValueLiteral = ((PrimitiveType)dt).getDefaultValueLiteral();
        _switchResult = this.toValueLiteral(((PrimitiveType)dt), _defaultValueLiteral);
      }
    }
    if (!_matched) {
      if (dt instanceof EnumerationType) {
        _matched=true;
        _switchResult = this.getDefaultValue(((EnumerationType)dt));
      }
    }
    if (!_matched) {
      if (dt instanceof ExternalType) {
        _matched=true;
        String _targetName = ((ExternalType) dt).getTargetName();
        String _plus = ("new " + _targetName);
        _switchResult = (_plus + "()");
      }
    }
    if (!_matched) {
      String _name = dt.getName();
      String _plus = ("new " + _name);
      _switchResult = (_plus + "()");
    }
    return _switchResult;
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
    boolean _equals = Objects.equal(data, null);
    if (_equals) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    RefableType _refType = data.getRefType();
    DataType _type = _refType.getType();
    String typeName = _type.getName();
    String castTypeName = typeName;
    RefableType _refType_1 = data.getRefType();
    DataType _type_1 = _refType_1.getType();
    if ((_type_1 instanceof PrimitiveType)) {
      RefableType _refType_2 = data.getRefType();
      DataType _type_2 = _refType_2.getType();
      String _targetName = ((PrimitiveType) _type_2).getTargetName();
      typeName = _targetName;
      RefableType _refType_3 = data.getRefType();
      DataType _type_3 = _refType_3.getType();
      final String ct = ((PrimitiveType) _type_3).getCastName();
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
        castTypeName = ct;
      }
    } else {
      RefableType _refType_4 = data.getRefType();
      DataType _type_4 = _refType_4.getType();
      if ((_type_4 instanceof EnumerationType)) {
        RefableType _refType_5 = data.getRefType();
        DataType _type_5 = _refType_5.getType();
        String _targetType = this.getTargetType(((EnumerationType) _type_5));
        typeName = _targetType;
        RefableType _refType_6 = data.getRefType();
        DataType _type_6 = _refType_6.getType();
        String _castType = this.getCastType(((EnumerationType) _type_6));
        castTypeName = _castType;
      }
    }
    String _name = data.getName();
    String _plus = ((typeName + " ") + _name);
    String _plus_1 = (_plus + " = (");
    String _plus_2 = (_plus_1 + castTypeName);
    final String typedData = (_plus_2 + ") generic_data;\n");
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
      _xifexpression = "int";
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
      boolean _equals = Objects.equal(_primitiveType, null);
      if (_equals) {
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
      _xifexpression = "int";
    }
    return _xifexpression;
  }
}
