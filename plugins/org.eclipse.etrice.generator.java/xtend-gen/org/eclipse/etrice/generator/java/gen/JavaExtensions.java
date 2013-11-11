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
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
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
    String _get = _generateArglistAndTypedData[1];
    return _get;
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".java");
    return _plus;
  }
  
  public String getJavaFactoryName(final ActorClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "Factory");
    return _plus;
  }
  
  public String getJavaFactoryFileName(final ActorClass rc) {
    String _javaFactoryName = this.getJavaFactoryName(rc);
    String _plus = (_javaFactoryName + ".java");
    return _plus;
  }
  
  public String getJavaScalarInterfaceName(final ActorClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "Interface");
    return _plus;
  }
  
  public String getJavaScalarInterfaceFileName(final ActorClass rc) {
    String _javaScalarInterfaceName = this.getJavaScalarInterfaceName(rc);
    String _plus = (_javaScalarInterfaceName + ".java");
    return _plus;
  }
  
  public String getJavaReplicatedInterfaceName(final ActorClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "ReplicatedInterface");
    return _plus;
  }
  
  public String getJavaReplicatedInterfaceFileName(final ActorClass rc) {
    String _javaReplicatedInterfaceName = this.getJavaReplicatedInterfaceName(rc);
    String _plus = (_javaReplicatedInterfaceName + ".java");
    return _plus;
  }
  
  public String getJavaInterfaceName(final ActorClass ac, final boolean replicated) {
    String _xifexpression = null;
    if (replicated) {
      String _javaReplicatedInterfaceName = this.getJavaReplicatedInterfaceName(ac);
      _xifexpression = _javaReplicatedInterfaceName;
    } else {
      String _javaScalarInterfaceName = this.getJavaScalarInterfaceName(ac);
      _xifexpression = _javaScalarInterfaceName;
    }
    return _xifexpression;
  }
  
  public String getJavaInterfaceFileName(final ActorClass ac, final boolean replicated) {
    String _xifexpression = null;
    if (replicated) {
      String _javaReplicatedInterfaceFileName = this.getJavaReplicatedInterfaceFileName(ac);
      _xifexpression = _javaReplicatedInterfaceFileName;
    } else {
      String _javaScalarInterfaceFileName = this.getJavaScalarInterfaceFileName(ac);
      _xifexpression = _javaScalarInterfaceFileName;
    }
    return _xifexpression;
  }
  
  public String getJavaClassName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = ("Node_" + _name);
    String _plus_1 = (_plus + "_");
    String _name_1 = ssi.getName();
    String _plus_2 = (_plus_1 + _name_1);
    return _plus_2;
  }
  
  public String getJavaFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _javaClassName = this.getJavaClassName(nr, ssi);
    String _plus = (_javaClassName + ".java");
    return _plus;
  }
  
  public String toWrapper(final String type) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type,"int")) {
        _matched=true;
        _switchResult = "Integer";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"char")) {
        _matched=true;
        _switchResult = "Character";
      }
    }
    if (!_matched) {
      String _firstUpper = StringExtensions.toFirstUpper(type);
      _switchResult = _firstUpper;
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
      boolean _isPrimitive = this.typeHelpers.isPrimitive(_type_1);
      boolean _not = (!_isPrimitive);
      _or_1 = (_greaterThan || _not);
    }
    if (_or_1) {
      _or = true;
    } else {
      RefableType _type_2 = a.getType();
      DataType _type_3 = _type_2.getType();
      String _typeName = this.typeHelpers.typeName(_type_3);
      boolean _equals = _typeName.equals("String");
      _or = (_or_1 || _equals);
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
    String _plus = (namespace + ".");
    return (_plus + member);
  }
  
  public boolean usesInheritance() {
    return true;
  }
  
  public boolean usesPointers() {
    return false;
  }
  
  public String genEnumeration(final String name, final List<Pair<String,String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR entry: entries�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final int �entry.first� = �entry.second�;");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    String _string = _builder.toString();
    return _string;
  }
  
  public String booleanConstant(final boolean b) {
    String _string = Boolean.valueOf(b).toString();
    return _string;
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
    String _plus = (type + " ");
    String _plus_1 = (_plus + name);
    String _plus_2 = (_plus_1 + "[]");
    return _plus_2;
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
  
  public String superCall(final String baseClassName, final String method, final String args) {
    String _plus = ("super." + method);
    String _plus_1 = (_plus + "(");
    String _plus_2 = (_plus_1 + args);
    String _plus_3 = (_plus_2 + ");");
    return _plus_3;
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    final String _switchValue = _targetName;
    boolean _matched = false;
    if (!_matched) {
      boolean _and = false;
      boolean _isCharacterType = this.typeHelpers.isCharacterType(type);
      boolean _not = (!_isCharacterType);
      if (!_not) {
        _and = false;
      } else {
        boolean _contains = value.contains(",");
        _and = (_not && _contains);
      }
      if (_and) {
        _matched=true;
        String _xblockexpression = null;
        {
          String _replace = value.replace("{", "");
          String _replace_1 = _replace.replace("}", "");
          String _trim = _replace_1.trim();
          String[] singleValues = _trim.split(",");
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{ �FOR v: singleValues SEPARATOR \', \'��castValue(type, v.trim)��ENDFOR� }");
          String _string = _builder.toString();
          _xblockexpression = (_string);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      String _castValue = this.castValue(type, value);
      _switchResult = _castValue;
    }
    return _switchResult;
  }
  
  private String castValue(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    final String _switchValue = _targetName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"boolean")) {
        _matched=true;
        String _lowerCase = value.toLowerCase();
        _switchResult = _lowerCase;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        String _plus = ("(byte)" + value);
        _switchResult = _plus;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        String _plus_1 = ("(short)" + value);
        _switchResult = _plus_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"int")) {
        _matched=true;
        _switchResult = value;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"long")) {
        _matched=true;
        String _plus_2 = (value + "L");
        _switchResult = _plus_2;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        String _plus_3 = (value + "f");
        _switchResult = _plus_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"double")) {
        _matched=true;
        String _plus_4 = (value + "d");
        _switchResult = _plus_4;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
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
            String _plus_5 = ("\'" + Character.valueOf(_charAt));
            String _plus_6 = (_plus_5 + "\'");
            _xifexpression_1 = _plus_6;
          } else {
            String _replace = value.replace("\\", "\\\\");
            String _replace_1 = _replace.replace("\"", "\\\"");
            String _plus_7 = ("\"" + _replace_1);
            String _plus_8 = (_plus_7 + "\".toCharArray()");
            _xifexpression_1 = _plus_8;
          }
          _xifexpression = _xifexpression_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"String")) {
        _matched=true;
        String _replace_2 = value.replace("\\", "\\\\");
        String _replace_3 = _replace_2.replace("\"", "\\\"");
        String _plus_9 = ("\"" + _replace_3);
        String _plus_10 = (_plus_9 + "\"");
        _switchResult = _plus_10;
      }
    }
    if (!_matched) {
      String _targetName_1 = type.getTargetName();
      UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_targetName_1);
      throw _unsupportedOperationException;
    }
    return _switchResult;
  }
  
  public String defaultValue(final DataType dt) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (dt instanceof PrimitiveType) {
        final PrimitiveType _primitiveType = (PrimitiveType)dt;
        _matched=true;
        String _defaultValueLiteral = _primitiveType.getDefaultValueLiteral();
        String _valueLiteral = this.toValueLiteral(_primitiveType, _defaultValueLiteral);
        _switchResult = _valueLiteral;
      }
    }
    if (!_matched) {
      if (dt instanceof ExternalType) {
        final ExternalType _externalType = (ExternalType)dt;
        _matched=true;
        String _targetName = ((ExternalType) _externalType).getTargetName();
        String _plus = ("new " + _targetName);
        String _plus_1 = (_plus + "()");
        _switchResult = _plus_1;
      }
    }
    if (!_matched) {
      String _name = dt.getName();
      String _plus = ("new " + _name);
      String _plus_1 = (_plus + "()");
      _switchResult = _plus_1;
    }
    return _switchResult;
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
        _and = (_notEquals && _not);
      }
      if (_and) {
        castTypeName = ct;
      }
    }
    String _plus = (typeName + " ");
    String _name = data.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + " = (");
    String _plus_3 = (_plus_2 + castTypeName);
    final String typedData = (_plus_3 + ") generic_data;\n");
    String _name_1 = data.getName();
    final String dataArg = (", " + _name_1);
    String _plus_4 = (", " + typeName);
    String _plus_5 = (_plus_4 + " ");
    String _name_2 = data.getName();
    final String typedArgList = (_plus_5 + _name_2);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
}
