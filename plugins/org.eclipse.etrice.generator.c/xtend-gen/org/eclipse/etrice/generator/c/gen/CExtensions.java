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
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;
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
  
  @Override
  public String accessLevelPrivate() {
    return "static ";
  }
  
  @Override
  public String accessLevelProtected() {
    return "static ";
  }
  
  @Override
  public String accessLevelPublic() {
    return "";
  }
  
  @Override
  public String memberAccess() {
    return "self->";
  }
  
  @Override
  public String selfPointer(final String classname, final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "* self, ";
    } else {
      _xifexpression = "* self";
    }
    return (classname + _xifexpression);
  }
  
  @Override
  public String selfPointer(final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "self, ";
    } else {
      _xifexpression = "self";
    }
    return _xifexpression;
  }
  
  @Override
  public String scopeSeparator() {
    return "";
  }
  
  @Override
  public String operationScope(final String classname, final boolean isDeclaration) {
    return (classname + "_");
  }
  
  @Override
  public String memberInDeclaration(final String namespace, final String member) {
    return ((namespace + "_") + member);
  }
  
  @Override
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
    _builder.append(_upperCase);
    _builder.append("_H_");
    return _builder;
  }
  
  public CharSequence generateIncludeGuardBegin(final RoomClass rc) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = rc.eContainer();
      String _replaceAll = ((RoomModel) _eContainer).getName().replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name = rc.getName();
      final String filename = (_plus + _name);
      _xblockexpression = this.generateIncludeGuardBegin(filename);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateIncludeGuardEnd(final RoomClass rc) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = rc.eContainer();
      String _replaceAll = ((RoomModel) _eContainer).getName().replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name = rc.getName();
      final String filename = (_plus + _name);
      _xblockexpression = this.generateIncludeGuardEnd(filename);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateIncludeGuardBegin(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString);
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    CharSequence _includeGuardString_1 = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateIncludeGuardEnd(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString);
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public boolean usesInheritance() {
    return false;
  }
  
  @Override
  public boolean usesPointers() {
    return true;
  }
  
  @Override
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = entries.isEmpty();
      if (_isEmpty) {
        return "/* empty enum not generated */";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum ");
      _builder.append(name);
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
  
  @Override
  public String booleanConstant(final boolean b) {
    String _xifexpression = null;
    if (b) {
      _xifexpression = "ET_TRUE";
    } else {
      _xifexpression = "ET_FALSE";
    }
    return _xifexpression;
  }
  
  @Override
  public String pointerLiteral() {
    return "*";
  }
  
  @Override
  public String nullPointer() {
    return "NULL";
  }
  
  @Override
  public String voidPointer() {
    return "void*";
  }
  
  @Override
  public String arrayType(final String type, final int size, final boolean isRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(type);
    {
      if (isRef) {
        _builder.append("*");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  public String arrayDeclaration(final String type, final int size, final boolean isRef, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(type);
    {
      if (isRef) {
        _builder.append("*");
      }
    }
    _builder.append(" ");
    _builder.append(name);
    _builder.append("[");
    _builder.append(size);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  public String superCall(final String baseClassName, final String method, final String args) {
    return "";
  }
  
  @Override
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    boolean _matched = false;
    if ((type.getTargetName().equals("char") && (value.length() == 1))) {
      _matched=true;
      _switchResult = (("\'" + value) + "\'");
    }
    if (!_matched) {
      LiteralType _type = type.getType();
      boolean _equals = Objects.equal(_type, LiteralType.CHAR);
      if (_equals) {
        _matched=true;
        _switchResult = (("\"" + value) + "\"");
      }
    }
    if (!_matched) {
      if ((value.contains(",") || value.contains("{"))) {
        _matched=true;
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
              String _valueLiteral = this.toValueLiteral(type, v.trim());
              _builder.append(_valueLiteral);
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
        String _xifexpression = null;
        boolean _equals_1 = value.equals("true");
        if (_equals_1) {
          _xifexpression = "ET_TRUE";
        } else {
          _xifexpression = "ET_FALSE";
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      _switchResult = value;
    }
    return _switchResult;
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
        String _plus_1 = (_name + "_");
        String _name_1 = l.getName();
        return (_plus_1 + _name_1);
      }
    }
    return null;
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
          this.diagnostician.error(_plus_1, ((ExternalType)dt).eContainer(), ((ExternalType)dt).eContainingFeature());
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
        while ((i < size)) {
          {
            res = (res + dv);
            i = (i + 1);
            if ((i < size)) {
              res = (res + ",");
            }
          }
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
          _xifexpression_1 = this.initializer(dv, att.getSize());
        }
        _xifexpression = _xifexpression_1;
      } else {
        String _xifexpression_2 = null;
        boolean _isRef = att.getType().isRef();
        if (_isRef) {
          _xifexpression_2 = this.initializer("NULL", att.getSize());
        } else {
          _xifexpression_2 = this.initializationWithDefaultValues(att.getType().getType(), att.getSize());
        }
        _xifexpression = _xifexpression_2;
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
    boolean _equals = Objects.equal(data, null);
    if (_equals) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    String _xifexpression = null;
    DataType _type = data.getRefType().getType();
    if ((_type instanceof PrimitiveType)) {
      DataType _type_1 = data.getRefType().getType();
      _xifexpression = ((PrimitiveType) _type_1).getTargetName();
    } else {
      String _xifexpression_1 = null;
      DataType _type_2 = data.getRefType().getType();
      if ((_type_2 instanceof EnumerationType)) {
        DataType _type_3 = data.getRefType().getType();
        _xifexpression_1 = this.getTargetType(((EnumerationType) _type_3));
      } else {
        String _xifexpression_2 = null;
        DataType _type_4 = data.getRefType().getType();
        if ((_type_4 instanceof ExternalType)) {
          DataType _type_5 = data.getRefType().getType();
          _xifexpression_2 = ((ExternalType) _type_5).getTargetName();
        } else {
          _xifexpression_2 = data.getRefType().getType().getName();
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    String typeName = _xifexpression;
    String _xifexpression_3 = null;
    DataType _type_6 = data.getRefType().getType();
    if ((_type_6 instanceof PrimitiveType)) {
      String _xblockexpression = null;
      {
        DataType _type_7 = data.getRefType().getType();
        final String ct = ((PrimitiveType) _type_7).getCastName();
        String _xifexpression_4 = null;
        if (((!Objects.equal(ct, null)) && (!ct.isEmpty()))) {
          _xifexpression_4 = ct;
        } else {
          _xifexpression_4 = typeName;
        }
        _xblockexpression = _xifexpression_4;
      }
      _xifexpression_3 = _xblockexpression;
    } else {
      String _xifexpression_4 = null;
      DataType _type_7 = data.getRefType().getType();
      if ((_type_7 instanceof EnumerationType)) {
        DataType _type_8 = data.getRefType().getType();
        _xifexpression_4 = this.getCastType(((EnumerationType) _type_8));
      } else {
        _xifexpression_4 = typeName;
      }
      _xifexpression_3 = _xifexpression_4;
    }
    String castTypeName = _xifexpression_3;
    castTypeName = (castTypeName + "*");
    String deRef = "*";
    final boolean isRef = data.getRefType().isRef();
    final boolean isPrim = ((data.getRefType().getType() instanceof PrimitiveType) || (data.getRefType().getType() instanceof EnumerationType));
    if (isRef) {
      typeName = (typeName + "*");
      castTypeName = (castTypeName + "*");
    } else {
      if ((!isPrim)) {
        typeName = (typeName + "*");
        deRef = "";
      }
    }
    final String dataArg = (", " + ILanguageExtension.GENERIC_DATA_NAME);
    final String typedData = (((((((typeName + " ") + ILanguageExtension.GENERIC_DATA_NAME) + " = ") + deRef) + "((") + castTypeName) + ") generic_data__et);\n");
    final String typedArgList = (((", " + typeName) + " ") + ILanguageExtension.GENERIC_DATA_NAME);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
  
  public String getIncludePath(final RoomClass rc) {
    EObject _eContainer = rc.eContainer();
    String _replaceAll = ((RoomModel) _eContainer).getName().replaceAll("\\.", "/");
    String _plus = ("\"" + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _cHeaderFileName = this.getCHeaderFileName(rc);
    String _plus_2 = (_plus_1 + _cHeaderFileName);
    return (_plus_2 + "\"");
  }
  
  public String getUtilsIncludePath(final RoomClass rc) {
    EObject _eContainer = rc.eContainer();
    String _replaceAll = ((RoomModel) _eContainer).getName().replaceAll("\\.", "/");
    String _plus = ("\"" + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _cUtilsFileName = this.getCUtilsFileName(rc);
    String _plus_2 = (_plus_1 + _cUtilsFileName);
    return (_plus_2 + "\"");
  }
  
  @Override
  public String getTargetType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      _xifexpression = type.getPrimitiveType().getTargetName();
    } else {
      _xifexpression = type.getName();
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
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
  
  @Override
  public String makeOverridable() {
    return "";
  }
}
