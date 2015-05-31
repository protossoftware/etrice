/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (refactoring, adapted for other target languages)
 */
package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
@SuppressWarnings("all")
public class ProcedureHelpers {
  @Inject
  @Extension
  protected RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  protected TypeHelpers _typeHelpers;
  
  @Inject
  protected ILanguageExtension languageExt;
  
  @Inject
  protected ILogger logger;
  
  /**
   * @param dc a {@link DataClass}
   * @param id 0, 1 or 2 for the corresponding user codes
   * @return the generated code
   */
  public CharSequence userCode(final DataClass dc, final int id) {
    CharSequence _switchResult = null;
    switch (id) {
      case 1:
        String _deepUserCode1 = this._roomHelpers.getDeepUserCode1(dc);
        _switchResult = this.userCode(_deepUserCode1);
        break;
      case 2:
        String _deepUserCode2 = this._roomHelpers.getDeepUserCode2(dc);
        _switchResult = this.userCode(_deepUserCode2);
        break;
      case 3:
        String _deepUserCode3 = this._roomHelpers.getDeepUserCode3(dc);
        _switchResult = this.userCode(_deepUserCode3);
        break;
    }
    return _switchResult;
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param id 0, 1 or 2 for the corresponding user codes
   * @return the generated code
   */
  public CharSequence userCode(final ProtocolClass pc, final int id) {
    CharSequence _switchResult = null;
    switch (id) {
      case 1:
        String _deepUserCode1 = this._roomHelpers.getDeepUserCode1(pc);
        _switchResult = this.userCode(_deepUserCode1);
        break;
      case 2:
        String _deepUserCode2 = this._roomHelpers.getDeepUserCode2(pc);
        _switchResult = this.userCode(_deepUserCode2);
        break;
      case 3:
        String _deepUserCode3 = this._roomHelpers.getDeepUserCode3(pc);
        _switchResult = this.userCode(_deepUserCode3);
        break;
    }
    return _switchResult;
  }
  
  /**
   * @param ac an {@link ActorContainerClass}
   * @param id 0, 1 or 2 for the corresponding user codes
   * @return the generated code
   */
  public CharSequence userCode(final ActorContainerClass ac, final int id, final boolean includeInherited) {
    CharSequence _xifexpression = null;
    if (includeInherited) {
      CharSequence _switchResult = null;
      switch (id) {
        case 1:
          String _deepUserCode1 = this._roomHelpers.getDeepUserCode1(ac);
          _switchResult = this.userCode(_deepUserCode1);
          break;
        case 2:
          String _deepUserCode2 = this._roomHelpers.getDeepUserCode2(ac);
          _switchResult = this.userCode(_deepUserCode2);
          break;
        case 3:
          String _deepUserCode3 = this._roomHelpers.getDeepUserCode3(ac);
          _switchResult = this.userCode(_deepUserCode3);
          break;
      }
      _xifexpression = _switchResult;
    } else {
      CharSequence _switchResult_1 = null;
      switch (id) {
        case 1:
          DetailCode _userCode1 = ac.getUserCode1();
          _switchResult_1 = this.userCode(_userCode1);
          break;
        case 2:
          DetailCode _userCode2 = ac.getUserCode2();
          _switchResult_1 = this.userCode(_userCode2);
          break;
        case 3:
          DetailCode _userCode3 = ac.getUserCode3();
          _switchResult_1 = this.userCode(_userCode3);
          break;
      }
      _xifexpression = _switchResult_1;
    }
    return _xifexpression;
  }
  
  /**
   * @param dc some {@link DetailCode}
   * @return a string containing the expanded code surrounded by
   * 		comments (no tag replacement will happen)
   */
  public CharSequence userCode(final DetailCode dc) {
    String _detailCode = this._roomHelpers.getDetailCode(dc);
    return this.userCode(_detailCode);
  }
  
  private CharSequence userCode(final String code) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(code, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isEmpty = code.isEmpty();
        boolean _not = (!_isEmpty);
        _and = _not;
      }
      if (_and) {
        _builder.append("/*--------------------- begin user code ---------------------*/");
        _builder.newLine();
        _builder.append(code, "");
        _builder.newLineIfNotEmpty();
        _builder.append("/*--------------------- end user code ---------------------*/");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * @param EnumTest a list of {@link Attribute}s
   * @return code declaring the attributes
   */
  public CharSequence attributes(final List<Attribute> EnumTest) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    {
      for(final Attribute attribute : EnumTest) {
        CharSequence _attributeDeclaration = this.attributeDeclaration(attribute);
        _builder.append(_attributeDeclaration, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @return the code declaring the attribute
   */
  public CharSequence attributeDeclaration(final Attribute attribute) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = attribute.getSize();
      boolean _equals = (_size == 0);
      if (_equals) {
        RefableType _type = attribute.getType();
        DataType _type_1 = _type.getType();
        String _typeName = this._typeHelpers.typeName(_type_1);
        _builder.append(_typeName, "");
        {
          RefableType _type_2 = attribute.getType();
          boolean _isRef = _type_2.isRef();
          if (_isRef) {
            String _pointerLiteral = this.languageExt.pointerLiteral();
            _builder.append(_pointerLiteral, "");
          }
        }
        _builder.append(" ");
        String _name = attribute.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        RefableType _type_3 = attribute.getType();
        DataType _type_4 = _type_3.getType();
        String _typeName_1 = this._typeHelpers.typeName(_type_4);
        int _size_1 = attribute.getSize();
        String _name_1 = attribute.getName();
        RefableType _type_5 = attribute.getType();
        boolean _isRef_1 = _type_5.isRef();
        String _arrayDeclaration = this.languageExt.arrayDeclaration(_typeName_1, _size_1, _name_1, _isRef_1);
        _builder.append(_arrayDeclaration, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @return the code for an array initializer
   */
  public String arrayInitializer(final Attribute att) {
    String _xifexpression = null;
    String _defaultValueLiteral = att.getDefaultValueLiteral();
    boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
    if (_notEquals) {
      _xifexpression = att.getDefaultValueLiteral();
    } else {
      RefableType _type = att.getType();
      DataType _type_1 = _type.getType();
      _xifexpression = this.languageExt.defaultValue(_type_1);
    }
    final String dflt = _xifexpression;
    boolean _startsWith = dflt.startsWith("{");
    if (_startsWith) {
      String[] _split = dflt.split(",");
      int _size = ((List<String>)Conversions.doWrapArray(_split)).size();
      int _size_1 = att.getSize();
      boolean _notEquals_1 = (_size != _size_1);
      if (_notEquals_1) {
        String _name = att.getName();
        String _plus = ("WARNING: array size determined by initializer differs from attribute size (" + _name);
        String _plus_1 = (_plus + "[");
        int _size_2 = att.getSize();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_2));
        String _plus_3 = (_plus_2 + "] <-> ");
        String _plus_4 = (_plus_3 + dflt);
        String _plus_5 = (_plus_4 + ")");
        this.logger.logInfo(_plus_5);
      }
      return dflt;
    }
    String result = "{";
    int i = 0;
    while ((i < att.getSize())) {
      {
        result = (result + dflt);
        i = (i + 1);
        int _size_3 = att.getSize();
        boolean _lessThan = (i < _size_3);
        if (_lessThan) {
          result = (result + ", ");
        }
      }
    }
    return (result + "}");
  }
  
  /**
   * @param EnumTest a list of {@link Attribute}s
   * @param classname the name of the defining class
   * @return code declaring setters and getters for the attributes
   */
  public CharSequence attributeSettersGettersDeclaration(final List<Attribute> EnumTest, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    {
      for(final Attribute attribute : EnumTest) {
        CharSequence _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        CharSequence _terHeader = this.getterHeader(attribute, classname);
        _builder.append(_terHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * @param EnumTest a list of {@link Attribute}s
   * @param classname the name of the defining class
   * @return code defining setters and getters for the attributes
   */
  public CharSequence attributeSettersGettersImplementation(final List<Attribute> EnumTest, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    {
      for(final Attribute attribute : EnumTest) {
        CharSequence _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        String _memberAccess = this.languageExt.memberAccess();
        _builder.append(_memberAccess, "\t ");
        String _name = attribute.getName();
        _builder.append(_name, "\t ");
        _builder.append(" = ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "\t ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        CharSequence _terHeader = this.getterHeader(attribute, classname);
        _builder.append(_terHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return ");
        String _memberAccess_1 = this.languageExt.memberAccess();
        _builder.append(_memberAccess_1, "\t");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @param classname the name of the defining class
   * @return code for the attribute setter declaration
   */
  private CharSequence setterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append("void set");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    RefableType _type = attribute.getType();
    DataType _type_1 = _type.getType();
    String _typeName = this._typeHelpers.typeName(_type_1);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" ");
    String _name_1 = attribute.getName();
    _builder.append(_name_1, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @param classname the name of the defining class
   * @return code for the attribute getter declaration
   */
  private CharSequence getterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    RefableType _type = attribute.getType();
    DataType _type_1 = _type.getType();
    String _typeName = this._typeHelpers.typeName(_type_1);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" get");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, false);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param attributes a list of {@link Attribute}s
   * @return an argument list for the attributes
   */
  public CharSequence argList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _type = a.getType();
        DataType _type_1 = _type.getType();
        String _typeName = this._typeHelpers.typeName(_type_1);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name = a.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  /**
   * @param EnumTest an iterable of {@link Attribute}s representing a path
   * @param classname the name of the defining class
   * @return the invocation code for the call of a setter
   */
  public CharSequence invokeGetters(final Iterable<Attribute> path, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : path) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(".", "");
        }
        String _name = a.getName();
        CharSequence _invokeGetter = this.invokeGetter(_name, classname);
        _builder.append(_invokeGetter, "");
      }
    }
    return _builder;
  }
  
  /**
   * @param typeName the type name of the attribute
   * @param name the name of the attribute
   * @param classname the name of the type defining the getter
   * @return code defining the attribute getter
   */
  public CharSequence getterImplementation(final String typeName, final String name, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(typeName, "");
    _builder.append(" get");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append(" (");
    String _selfPointer = this.languageExt.selfPointer(classname, false);
    _builder.append(_selfPointer, "");
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _memberAccess = this.languageExt.memberAccess();
    _builder.append(_memberAccess, "\t");
    _builder.append(name, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param name the name of the attribute
   * @param classname the name of the type defining the getter
   * @return code defining the getter call
   */
  public CharSequence invokeGetter(final String name, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param name the name of the attribute
   * @param classname the name of the type defining the getter
   * @param value the value to be assigned
   * @return code defining the setter call
   */
  public CharSequence invokeSetter(final String name, final String classname, final String value) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("set");
    String _firstUpper = StringExtensions.toFirstUpper(name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    _builder.append(value, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param operations a list of {@link Operation}s
   * @param classname the name of the type defining the getter
   * @return code declaring the operations
   */
  public CharSequence operationsDeclaration(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _and = false;
          } else {
            boolean _isConstructor = this._roomHelpers.isConstructor(operation);
            _and = _isConstructor;
          }
          boolean _not = (!_and);
          if (_not) {
            CharSequence _operationSignature = this.operationSignature(operation, classname);
            _builder.append(_operationSignature, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  /**
   * @param operations a list of {@link Operation}s
   * @param classname the name of the type defining the getter
   * @return code defining the operations
   */
  public CharSequence operationsImplementation(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _and = false;
          } else {
            boolean _isConstructor = this._roomHelpers.isConstructor(operation);
            _and = _isConstructor;
          }
          boolean _not = (!_and);
          if (_not) {
            CharSequence _operationSignature = this.operationSignature(operation, classname);
            _builder.append(_operationSignature, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            AbstractGenerator _instance = AbstractGenerator.getInstance();
            DetailCode _detailCode = operation.getDetailCode();
            String _translatedCode = _instance.getTranslatedCode(_detailCode);
            _builder.append(_translatedCode, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return code defining all operations of the actor class
   */
  public CharSequence operationsImplementation(final ActorClass ac) {
    EList<StandardOperation> _operations = ac.getOperations();
    String _name = ac.getName();
    return this.operationsImplementation(_operations, _name);
  }
  
  /**
   * @param classname the name of a class
   * @return code calling the destructor of the class
   */
  public String destructorCall(final String classname) {
    String _destructorName = this.languageExt.destructorName(classname);
    return (_destructorName + "()");
  }
  
  /**
   * @param operation an {@link Operation}
   * @return the operation signature (with special care for
   * 		constructor and destructor
   */
  private CharSequence operationSignature(final Operation operation, final String classname) {
    CharSequence _xifexpression = null;
    boolean _isConstructor = this._roomHelpers.isConstructor(operation);
    if (_isConstructor) {
      String _constructorName = this.languageExt.constructorName(classname);
      String _constructorReturnType = this.languageExt.constructorReturnType();
      _xifexpression = this.classOperationSignature(classname, _constructorName, "", _constructorReturnType);
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _isDestructor = this._roomHelpers.isDestructor(operation);
      if (_isDestructor) {
        String _destructorName = this.languageExt.destructorName(classname);
        String _destructorReturnType = this.languageExt.destructorReturnType();
        _xifexpression_1 = this.classOperationSignature(classname, _destructorName, "", _destructorReturnType);
      } else {
        String _name = operation.getName();
        EList<VarDecl> _arguments = operation.getArguments();
        CharSequence _BuildArgumentList = this.BuildArgumentList(_arguments);
        String _string = _BuildArgumentList.toString();
        RefableType _returnType = operation.getReturnType();
        String _dataTypeToString = this.dataTypeToString(_returnType);
        _xifexpression_1 = this.classOperationSignature(classname, _name, _string, _dataTypeToString);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * @param type a {@link RefableType}
   * @return a string for the type (also for pointers)
   */
  private String dataTypeToString(final RefableType type) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      _xifexpression = "void";
    } else {
      String _xifexpression_1 = null;
      boolean _isRef = type.isRef();
      if (_isRef) {
        DataType _type = type.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        String _pointerLiteral = this.languageExt.pointerLiteral();
        _xifexpression_1 = (_typeName + _pointerLiteral);
      } else {
        DataType _type_1 = type.getType();
        _xifexpression_1 = this._typeHelpers.typeName(_type_1);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * builds comma separated argument list as string from EList<VarDecl> arguments
   */
  private CharSequence BuildArgumentList(final EList<VarDecl> arguments) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final VarDecl argument : arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = argument.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          RefableType _refType_1 = argument.getRefType();
          boolean _isRef = _refType_1.isRef();
          if (_isRef) {
            String _pointerLiteral = this.languageExt.pointerLiteral();
            _builder.append(_pointerLiteral, "");
          }
        }
        _builder.append(" ");
        String _name = argument.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  private CharSequence classOperationSignature(final String classname, final String operationname, final String argumentList, final String returnType) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(returnType, "");
    _builder.append(" ");
    String _memberInDeclaration = this.languageExt.memberInDeclaration(classname, operationname);
    _builder.append(_memberInDeclaration, "");
    _builder.append("(");
    boolean _isEmpty = argumentList.isEmpty();
    boolean _not = (!_isEmpty);
    String _selfPointer = this.languageExt.selfPointer(classname, _not);
    _builder.append(_selfPointer, "");
    _builder.append(argumentList, "");
    _builder.append(")");
    return _builder;
  }
}
