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
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;
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
  
  @Override
  public String getTypedDataDefinition(final EObject msg) {
    String _xifexpression = null;
    if ((msg instanceof Message)) {
      _xifexpression = this.generateArglistAndTypedData(((Message) msg).getData())[ILanguageExtensionBase.TypedDataKind.DECLARATION_AND_INITIALIZATION.ordinal()];
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
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
    if (type != null) {
      switch (type) {
        case "int":
          _switchResult = "Integer";
          break;
        case "char":
          _switchResult = "Character";
          break;
        default:
          _switchResult = StringExtensions.toFirstUpper(type);
          break;
      }
    } else {
      _switchResult = StringExtensions.toFirstUpper(type);
    }
    return _switchResult;
  }
  
  public boolean needsInitialization(final Attribute a) {
    return (((a.getSize() > 0) || (!this.typeHelpers.isEnumerationOrPrimitive(a.getType().getType()))) || this.typeHelpers.typeName(a.getType().getType()).equals("String"));
  }
  
  @Override
  public String accessLevelPrivate() {
    return "private ";
  }
  
  @Override
  public String accessLevelProtected() {
    return "protected ";
  }
  
  @Override
  public String accessLevelPublic() {
    return "public ";
  }
  
  @Override
  public String memberAccess() {
    return "this.";
  }
  
  @Override
  public String selfPointer(final String classname, final boolean hasArgs) {
    return "";
  }
  
  @Override
  public String selfPointer(final boolean hasArgs) {
    return "";
  }
  
  @Override
  public String operationScope(final String classname, final boolean isDeclaration) {
    return "";
  }
  
  @Override
  public String scopeSeparator() {
    return ".";
  }
  
  @Override
  public String memberInDeclaration(final String namespace, final String member) {
    return member;
  }
  
  @Override
  public String memberInUse(final String namespace, final String member) {
    return ((namespace + ".") + member);
  }
  
  @Override
  public boolean usesInheritance() {
    return true;
  }
  
  @Override
  public boolean usesPointers() {
    return false;
  }
  
  @Override
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Pair<String, String> entry : entries) {
        _builder.append("public static final int ");
        String _first = entry.getFirst();
        _builder.append(_first);
        _builder.append(" = ");
        String _second = entry.getSecond();
        _builder.append(_second);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  @Override
  public String booleanConstant(final boolean b) {
    return Boolean.valueOf(b).toString();
  }
  
  @Override
  public String pointerLiteral() {
    return "";
  }
  
  @Override
  public String nullPointer() {
    return "null";
  }
  
  @Override
  public String voidPointer() {
    return "Object";
  }
  
  @Override
  public String arrayType(final String type, final int size, final boolean isRef) {
    return (type + "[]");
  }
  
  @Override
  public String arrayDeclaration(final String type, final int size, final boolean isRef, final String name) {
    return (((type + " ") + name) + "[]");
  }
  
  @Override
  public String superCall(final String baseClassName, final String method, final String args) {
    return (((("super." + method) + "(") + args) + ");");
  }
  
  @Override
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _xifexpression = null;
    if (((!this.typeHelpers.isCharacterType(type)) && (value.contains(",") || value.contains("{")))) {
      String _xblockexpression = null;
      {
        String[] singleValues = value.replace("{", "").replace("}", "").trim().split(",");
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
            String _castValue = this.castValue(type, v.trim());
            _builder.append(_castValue);
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
  
  @Override
  public String toEnumLiteral(final EnumerationType type, final String value) {
    String _xifexpression = null;
    if ((value.contains(",") || value.contains("{"))) {
      String _xblockexpression = null;
      {
        String[] singleValues = value.replace("{", "").replace("}", "").trim().split(",");
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
            String _convertStringEnumLiteral = this.convertStringEnumLiteral(type, v.trim());
            _builder.append(_convertStringEnumLiteral);
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
    boolean _startsWith = v.startsWith(type.getName());
    if (_startsWith) {
      int _length = type.getName().length();
      int _plus = (_length + 1);
      v = v.substring(_plus);
    }
    EList<EnumLiteral> _literals = type.getLiterals();
    for (final EnumLiteral l : _literals) {
      boolean _equals = l.getName().equals(v);
      if (_equals) {
        String _name = type.getName();
        String _plus_1 = (_name + ".");
        String _name_1 = l.getName();
        return (_plus_1 + _name_1);
      }
    }
    return null;
  }
  
  private String castValue(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    if (_targetName != null) {
      switch (_targetName) {
        case "boolean":
          _switchResult = value.toLowerCase();
          break;
        case "byte":
          _switchResult = ("(byte)" + value);
          break;
        case "short":
          _switchResult = ("(short)" + value);
          break;
        case "int":
          _switchResult = value;
          break;
        case "long":
          _switchResult = (value + "L");
          break;
        case "float":
          _switchResult = (value + "f");
          break;
        case "double":
          _switchResult = (value + "d");
          break;
        case "char":
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
              String _replace = value.replace("\\", "\\\\").replace("\"", "\\\"");
              String _plus_1 = ("\"" + _replace);
              _xifexpression_1 = (_plus_1 + "\".toCharArray()");
            }
            _xifexpression = _xifexpression_1;
          }
          _switchResult = _xifexpression;
          break;
        case "String":
          String _replace_1 = value.replace("\\", "\\\\").replace("\"", "\\\"");
          String _plus_2 = ("\"" + _replace_1);
          _switchResult = (_plus_2 + "\"");
          break;
        default:
          String _targetName_1 = type.getTargetName();
          throw new UnsupportedOperationException(_targetName_1);
      }
    } else {
      String _targetName_1 = type.getTargetName();
      throw new UnsupportedOperationException(_targetName_1);
    }
    return _switchResult;
  }
  
  @Override
  public String defaultValue(final DataType dt) {
    String _switchResult = null;
    boolean _matched = false;
    if (dt instanceof PrimitiveType) {
      _matched=true;
      _switchResult = this.toValueLiteral(((PrimitiveType)dt), ((PrimitiveType)dt).getDefaultValueLiteral());
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
    boolean _isEmpty = type.getLiterals().isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      _xifexpression = this.getCastedValue(type.getLiterals().get(0));
    }
    return _xifexpression;
  }
  
  @Override
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
          while ((i < size)) {
            {
              res = (res + dv);
              i = (i + 1);
              if ((i < size)) {
                res = (res + ",");
              }
            }
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
  
  @Override
  public String[] generateArglistAndTypedData(final EObject d) {
    if ((Objects.equal(d, null) || (!(d instanceof VarDecl)))) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    final VarDecl data = ((VarDecl) d);
    String typeName = data.getRefType().getType().getName();
    String castTypeName = typeName;
    DataType _type = data.getRefType().getType();
    if ((_type instanceof PrimitiveType)) {
      DataType _type_1 = data.getRefType().getType();
      typeName = ((PrimitiveType) _type_1).getTargetName();
      DataType _type_2 = data.getRefType().getType();
      final String ct = ((PrimitiveType) _type_2).getCastName();
      if (((!Objects.equal(ct, null)) && (!ct.isEmpty()))) {
        castTypeName = ct;
      }
    } else {
      DataType _type_3 = data.getRefType().getType();
      if ((_type_3 instanceof EnumerationType)) {
        DataType _type_4 = data.getRefType().getType();
        typeName = this.getTargetType(((EnumerationType) _type_4));
        DataType _type_5 = data.getRefType().getType();
        castTypeName = this.getCastType(((EnumerationType) _type_5));
      }
    }
    final String dataArg = (", " + ILanguageExtension.GENERIC_DATA_NAME);
    final String typedData = (((((typeName + " ") + ILanguageExtension.GENERIC_DATA_NAME) + " = (") + castTypeName) + ") generic_data__et;\n");
    final String typedArgList = (((", " + typeName) + " ") + ILanguageExtension.GENERIC_DATA_NAME);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
  
  @Override
  public String getTargetType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      _xifexpression = type.getPrimitiveType().getTargetName();
    } else {
      _xifexpression = "int";
    }
    return _xifexpression;
  }
  
  @Override
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
        _xifexpression = Long.toString(literal.getLiteralValue());
      } else {
        String _string = Long.toString(literal.getLiteralValue());
        String _plus = ((("((" + cast) + ")") + _string);
        _xifexpression = (_plus + ")");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getCastType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      _xifexpression = type.getPrimitiveType().getCastName();
    } else {
      _xifexpression = "int";
    }
    return _xifexpression;
  }
  
  @Override
  public String makeOverridable() {
    return "";
  }
}
