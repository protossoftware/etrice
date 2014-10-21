/**
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;
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
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class CExtensions implements ILanguageExtension {
  @Inject
  protected IDiagnostician diagnostician;
  
  @Inject
  @Extension
  protected RoomHelpers _roomHelpers;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String[] _generateArglistAndTypedData = this.generateArglistAndTypedData(_data);
    return _generateArglistAndTypedData[1];
  }
  
  public String accessLevelPrivate() {
    return "static ";
  }
  
  public String accessLevelProtected() {
    return "static ";
  }
  
  public String accessLevelPublic() {
    return "";
  }
  
  public String memberAccess() {
    return "self->";
  }
  
  public String selfPointer(final String classname, final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "* self, ";
    } else {
      _xifexpression = "* self";
    }
    return (classname + _xifexpression);
  }
  
  public String selfPointer(final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "self, ";
    } else {
      _xifexpression = "self";
    }
    return _xifexpression;
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    return (classname + "_");
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    return ((namespace + "_") + member);
  }
  
  public String memberInUse(final String namespace, final String member) {
    return ((namespace + "_") + member);
  }
  
  /**
   * TODO: move specific code elsewhere
   */
  public String getCHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".h");
  }
  
  public String getCSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".c");
  }
  
  public String getCUtilsFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Utils.h");
  }
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Inst.h");
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Disp.h");
  }
  
  public String getCHeaderFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = (_name + "_");
    String _name_1 = ssi.getName();
    String _plus_1 = (_plus + _name_1);
    return (_plus_1 + ".h");
  }
  
  public String getCSourceFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = (_name + "_");
    String _name_1 = ssi.getName();
    String _plus_1 = (_plus + _name_1);
    return (_plus_1 + ".c");
  }
  
  public String getInstSourceFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = (_name + "_");
    String _name_1 = ssi.getName();
    String _plus_1 = (_plus + _name_1);
    return (_plus_1 + "_Inst.h");
  }
  
  public String getDispSourceFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = (_name + "_");
    String _name_1 = ssi.getName();
    String _plus_1 = (_plus + _name_1);
    return (_plus_1 + "_Disp.h");
  }
  
  public CharSequence getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _upperCase = filename.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_H_");
    return _builder;
  }
  
  public CharSequence generateIncludeGuardBegin(final RoomClass rc) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = rc.eContainer();
      String _name = ((RoomModel) _eContainer).getName();
      String _replaceAll = _name.replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name_1 = rc.getName();
      final String filename = (_plus + _name_1);
      _xblockexpression = this.generateIncludeGuardBegin(filename);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateIncludeGuardEnd(final RoomClass rc) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = rc.eContainer();
      String _name = ((RoomModel) _eContainer).getName();
      String _replaceAll = _name.replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name_1 = rc.getName();
      final String filename = (_plus + _name_1);
      _xblockexpression = this.generateIncludeGuardEnd(filename);
    }
    return _xblockexpression;
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
  
  public boolean usesInheritance() {
    return false;
  }
  
  public boolean usesPointers() {
    return true;
  }
  
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = entries.isEmpty();
      if (_isEmpty) {
        return "/* empty enum not generated */";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum ");
      _builder.append(name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements = false;
        for(final Pair<String, String> entry : entries) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t");
          }
          _builder.append("\t");
          String _first = entry.getFirst();
          _builder.append(_first, "\t");
          _builder.append(" = ");
          String _second = entry.getSecond();
          _builder.append(_second, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String booleanConstant(final boolean b) {
    String _xifexpression = null;
    if (b) {
      _xifexpression = "ET_TRUE";
    } else {
      _xifexpression = "ET_FALSE";
    }
    return _xifexpression;
  }
  
  public String pointerLiteral() {
    return "*";
  }
  
  public String nullPointer() {
    return "NULL";
  }
  
  public String voidPointer() {
    return "void*";
  }
  
  public String arrayDeclaration(final String type, final int size, final String name, final boolean isRef) {
    String _xifexpression = null;
    if (isRef) {
      _xifexpression = (((((type + "* ") + name) + "[") + Integer.valueOf(size)) + "]");
    } else {
      _xifexpression = (((((type + " ") + name) + "[") + Integer.valueOf(size)) + "]");
    }
    return _xifexpression;
  }
  
  public String constructorName(final String cls) {
    return "ctor";
  }
  
  public String destructorName(final String cls) {
    return "dtor";
  }
  
  public String constructorReturnType() {
    return "void";
  }
  
  public String destructorReturnType() {
    return "void";
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    return "";
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    boolean _matched = false;
    if (!_matched) {
      boolean _and = false;
      String _targetName_1 = type.getTargetName();
      boolean _equals = _targetName_1.equals("char");
      if (!_equals) {
        _and = false;
      } else {
        int _length = value.length();
        boolean _equals_1 = (_length == 1);
        _and = _equals_1;
      }
      if (_and) {
        _matched=true;
        _switchResult = (("\'" + value) + "\'");
      }
    }
    if (!_matched) {
      LiteralType _type = type.getType();
      boolean _equals_2 = Objects.equal(_type, LiteralType.CHAR);
      if (_equals_2) {
        _matched=true;
        _switchResult = (("\"" + value) + "\"");
      }
    }
    if (!_matched) {
      boolean _or = false;
      boolean _contains = value.contains(",");
      if (_contains) {
        _or = true;
      } else {
        boolean _contains_1 = value.contains("{");
        _or = _contains_1;
      }
      if (_or) {
        _matched=true;
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
              String _valueLiteral = this.toValueLiteral(type, _trim_1);
              _builder.append(_valueLiteral, "");
            }
          }
          _builder.append(" }");
          _xblockexpression = _builder.toString();
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_targetName, "boolean")) {
        _matched=true;
        _switchResult = value.toUpperCase();
      }
    }
    if (!_matched) {
      _switchResult = value;
    }
    return _switchResult;
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
        String _plus_1 = (_name_3 + "_");
        String _name_4 = l.getName();
        return (_plus_1 + _name_4);
      }
    }
    return null;
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
        String _xblockexpression = null;
        {
          String _defaultValueLiteral = ((ExternalType)dt).getDefaultValueLiteral();
          boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
          if (_notEquals) {
            return ((ExternalType)dt).getDefaultValueLiteral();
          }
          String _name = ((ExternalType)dt).getName();
          String _plus = ("external type " + _name);
          String _plus_1 = (_plus + "has no default initialization");
          EObject _eContainer = ((ExternalType)dt).eContainer();
          EStructuralFeature _eContainingFeature = ((ExternalType)dt).eContainingFeature();
          this.diagnostician.error(_plus_1, _eContainer, _eContainingFeature);
          _xblockexpression = "";
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (dt instanceof DataClass) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        {
          List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(((DataClass)dt));
          boolean _hasElements = false;
          for(final Attribute att : _allAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "\t");
            }
            _builder.append("\t");
            String _initializationWithDefaultValues = this.initializationWithDefaultValues(att);
            _builder.append(_initializationWithDefaultValues, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
        _switchResult = _builder.toString();
      }
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
      _xblockexpression = this.initializer(dv, size);
    }
    return _xblockexpression;
  }
  
  private String initializer(final String dv, final int size) {
    String _xifexpression = null;
    if ((size > 1)) {
      String _xblockexpression = null;
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
        _xblockexpression = (res + "}");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = dv;
    }
    return _xifexpression;
  }
  
  public String initializationWithDefaultValues(final Attribute att) {
    String _xblockexpression = null;
    {
      final String dv = att.getDefaultValueLiteral();
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(dv, null));
      if (_notEquals) {
        String _xifexpression_1 = null;
        boolean _startsWith = dv.startsWith("{");
        if (_startsWith) {
          _xifexpression_1 = dv;
        } else {
          int _size = att.getSize();
          _xifexpression_1 = this.initializer(dv, _size);
        }
        _xifexpression = _xifexpression_1;
      } else {
        String _xifexpression_2 = null;
        RefableType _type = att.getType();
        boolean _isRef = _type.isRef();
        if (_isRef) {
          int _size_1 = att.getSize();
          _xifexpression_2 = this.initializer("NULL", _size_1);
        } else {
          RefableType _type_1 = att.getType();
          DataType _type_2 = _type_1.getType();
          int _size_2 = att.getSize();
          _xifexpression_2 = this.initializationWithDefaultValues(_type_2, _size_2);
        }
        _xifexpression = _xifexpression_2;
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
    String deRef = "*";
    RefableType _refType_8 = data.getRefType();
    final boolean isRef = _refType_8.isRef();
    boolean _or = false;
    RefableType _refType_9 = data.getRefType();
    DataType _type_8 = _refType_9.getType();
    if ((_type_8 instanceof PrimitiveType)) {
      _or = true;
    } else {
      RefableType _refType_10 = data.getRefType();
      DataType _type_9 = _refType_10.getType();
      _or = (_type_9 instanceof EnumerationType);
    }
    final boolean isPrim = _or;
    if (isRef) {
      typeName = (typeName + "*");
      castTypeName = (castTypeName + "*");
    } else {
      if ((!isPrim)) {
        typeName = (typeName + "*");
        deRef = "";
      }
    }
    String _name = data.getName();
    String _plus = ((typeName + " ") + _name);
    String _plus_1 = (_plus + " = ");
    String _plus_2 = (_plus_1 + deRef);
    String _plus_3 = (_plus_2 + "((");
    String _plus_4 = (_plus_3 + castTypeName);
    final String typedData = (_plus_4 + ") generic_data__et);\n");
    String _name_1 = data.getName();
    final String dataArg = (", " + _name_1);
    String _name_2 = data.getName();
    final String typedArgList = (((", " + typeName) + " ") + _name_2);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
  
  public String getIncludePath(final RoomClass rc) {
    EObject _eContainer = rc.eContainer();
    String _name = ((RoomModel) _eContainer).getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = ("\"" + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _cHeaderFileName = this.getCHeaderFileName(rc);
    String _plus_2 = (_plus_1 + _cHeaderFileName);
    return (_plus_2 + "\"");
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
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
}
