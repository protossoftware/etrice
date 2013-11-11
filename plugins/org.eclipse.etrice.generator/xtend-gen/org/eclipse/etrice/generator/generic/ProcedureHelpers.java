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
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
@SuppressWarnings("all")
public class ProcedureHelpers {
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private ILogger logger;
  
  /**
   * @param dc a {@link DataClass}
   * @param id 0, 1 or 2 for the corresponding user codes
   * @return the generated code
   */
  public CharSequence userCode(final DataClass dc, final int id) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id,1)) {
        _matched=true;
        String _deepUserCode1 = RoomHelpers.getDeepUserCode1(dc);
        CharSequence _userCode = this.userCode(_deepUserCode1);
        _switchResult = _userCode;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,2)) {
        _matched=true;
        String _deepUserCode2 = RoomHelpers.getDeepUserCode2(dc);
        CharSequence _userCode_1 = this.userCode(_deepUserCode2);
        _switchResult = _userCode_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,3)) {
        _matched=true;
        String _deepUserCode3 = RoomHelpers.getDeepUserCode3(dc);
        CharSequence _userCode_2 = this.userCode(_deepUserCode3);
        _switchResult = _userCode_2;
      }
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
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(id,1)) {
        _matched=true;
        String _deepUserCode1 = RoomHelpers.getDeepUserCode1(pc);
        CharSequence _userCode = this.userCode(_deepUserCode1);
        _switchResult = _userCode;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,2)) {
        _matched=true;
        String _deepUserCode2 = RoomHelpers.getDeepUserCode2(pc);
        CharSequence _userCode_1 = this.userCode(_deepUserCode2);
        _switchResult = _userCode_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(id,3)) {
        _matched=true;
        String _deepUserCode3 = RoomHelpers.getDeepUserCode3(pc);
        CharSequence _userCode_2 = this.userCode(_deepUserCode3);
        _switchResult = _userCode_2;
      }
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
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(id,1)) {
          _matched=true;
          String _deepUserCode1 = RoomHelpers.getDeepUserCode1(ac);
          CharSequence _userCode = this.userCode(_deepUserCode1);
          _switchResult = _userCode;
        }
      }
      if (!_matched) {
        if (Objects.equal(id,2)) {
          _matched=true;
          String _deepUserCode2 = RoomHelpers.getDeepUserCode2(ac);
          CharSequence _userCode_1 = this.userCode(_deepUserCode2);
          _switchResult = _userCode_1;
        }
      }
      if (!_matched) {
        if (Objects.equal(id,3)) {
          _matched=true;
          String _deepUserCode3 = RoomHelpers.getDeepUserCode3(ac);
          CharSequence _userCode_2 = this.userCode(_deepUserCode3);
          _switchResult = _userCode_2;
        }
      }
      _xifexpression = _switchResult;
    } else {
      CharSequence _switchResult_1 = null;
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (Objects.equal(id,1)) {
          _matched_1=true;
          DetailCode _userCode1 = ac.getUserCode1();
          CharSequence _userCode_3 = this.userCode(_userCode1);
          _switchResult_1 = _userCode_3;
        }
      }
      if (!_matched_1) {
        if (Objects.equal(id,2)) {
          _matched_1=true;
          DetailCode _userCode2 = ac.getUserCode2();
          CharSequence _userCode_4 = this.userCode(_userCode2);
          _switchResult_1 = _userCode_4;
        }
      }
      if (!_matched_1) {
        if (Objects.equal(id,3)) {
          _matched_1=true;
          DetailCode _userCode3 = ac.getUserCode3();
          CharSequence _userCode_5 = this.userCode(_userCode3);
          _switchResult_1 = _userCode_5;
        }
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
    String _detailCode = RoomHelpers.getDetailCode(dc);
    CharSequence _userCode = this.userCode(_detailCode);
    return _userCode;
  }
  
  private CharSequence userCode(final String code) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF code!=null && !code.empty�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/*--------------------- begin user code ---------------------*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�code�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/*--------------------- end user code ---------------------*/");
    _builder.newLine();
    _builder.append("�ENDIF�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param attribs a list of {@link Attribute}s
   * @return code declaring the attributes
   */
  public CharSequence attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    _builder.append("�FOR attribute : attribs�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�attributeDeclaration(attribute)�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @return the code declaring the attribute
   */
  public CharSequence attributeDeclaration(final Attribute attribute) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF attribute.size==0�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�attribute.type.type.typeName��IF attribute.type.ref��languageExt.pointerLiteral()��ENDIF� �attribute.name�;");
    _builder.newLine();
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�languageExt.arrayDeclaration(attribute.type.type.typeName, attribute.size, attribute.name, attribute.type.ref)�;");
    _builder.newLine();
    _builder.append("�ENDIF� \t");
    _builder.newLine();
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
      String _defaultValueLiteral_1 = att.getDefaultValueLiteral();
      _xifexpression = _defaultValueLiteral_1;
    } else {
      RefableType _type = att.getType();
      DataType _type_1 = _type.getType();
      String _defaultValue = this.languageExt.defaultValue(_type_1);
      _xifexpression = _defaultValue;
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
    int _size_3 = att.getSize();
    boolean _lessThan = (i < _size_3);
    boolean _while = _lessThan;
    while (_while) {
      {
        String _plus_6 = (result + dflt);
        result = _plus_6;
        int _plus_7 = (i + 1);
        i = _plus_7;
        int _size_4 = att.getSize();
        boolean _lessThan_1 = (i < _size_4);
        if (_lessThan_1) {
          String _plus_8 = (result + ", ");
          result = _plus_8;
        }
      }
      int _size_4 = att.getSize();
      boolean _lessThan_1 = (i < _size_4);
      _while = _lessThan_1;
    }
    return (result + "}");
  }
  
  /**
   * @param attribs a list of {@link Attribute}s
   * @param classname the name of the defining class
   * @return code declaring setters and getters for the attributes
   */
  public CharSequence attributeSettersGettersDeclaration(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    _builder.append("�FOR attribute : attribs�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�setterHeader(attribute, classname)�;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�getterHeader(attribute, classname)�;");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param attribs a list of {@link Attribute}s
   * @param classname the name of the defining class
   * @return code defining setters and getters for the attributes
   */
  public CharSequence attributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    _builder.append("�FOR attribute : attribs��setterHeader(attribute, classname)� {");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("�languageExt.memberAccess()��attribute.name� = �attribute.name�;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("�getterHeader(attribute, classname)� {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return �languageExt.memberAccess()��attribute.name�;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @param classname the name of the defining class
   * @return code for the attribute setter declaration
   */
  private CharSequence setterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�languageExt.accessLevelPublic()�void set�attribute.name.toFirstUpper()� (�languageExt.selfPointer(classname, true)��attribute.type.type.typeName��IF attribute.size!=0�[]�ENDIF� �attribute.name�)");
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @param classname the name of the defining class
   * @return code for the attribute getter declaration
   */
  private CharSequence getterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�languageExt.accessLevelPublic()��attribute.type.type.typeName��IF attribute.size!=0�[]�ENDIF� get�attribute.name.toFirstUpper()� (�languageExt.selfPointer(classname, false)�)");
    return _builder;
  }
  
  /**
   * @param attribs a list of {@link Attribute}s
   * @return an argument list for the attributes
   */
  public CharSequence argList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a : attributes SEPARATOR \", \"��a.type.type.typeName��IF a.size>0�[]�ENDIF� �a.name��ENDFOR�");
    return _builder;
  }
  
  /**
   * @param attribs an iterable of {@link Attribute}s representing a path
   * @param classname the name of the defining class
   * @return the invocation code for the call of a setter
   */
  public CharSequence invokeGetters(final Iterable<Attribute> path, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a : path SEPARATOR \'.\'��invokeGetter(a.name, classname)��ENDFOR�");
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
    _builder.append("�languageExt.accessLevelPublic()��typeName� get�name.toFirstUpper()� (�languageExt.selfPointer(classname, false)�){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return �languageExt.memberAccess()��name�;");
    _builder.newLine();
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
    _builder.append("get�name.toFirstUpper�(�languageExt.selfPointer(classname, true)�)");
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
    _builder.append("set�name.toFirstUpper�(�languageExt.selfPointer(classname, true)��value�)");
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
    _builder.append("�FOR operation : operations�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF !(languageExt.usesInheritance && operation.constructor)�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�operationSignature(operation, classname)�;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
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
    _builder.append("�FOR operation : operations�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF !(languageExt.usesInheritance && operation.constructor)�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�operationSignature(operation, classname)� {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�AbstractGenerator::getInstance().getTranslatedCode(operation.detailCode)�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return code defining all operations of the actor class
   */
  public CharSequence operationsImplementation(final ActorClass ac) {
    EList<StandardOperation> _operations = ac.getOperations();
    String _name = ac.getName();
    CharSequence _operationsImplementation = this.operationsImplementation(_operations, _name);
    return _operationsImplementation;
  }
  
  /**
   * @param classname the name of a class
   * @return code calling the destructor of the class
   */
  public String destructorCall(final String classname) {
    String _destructorName = this.languageExt.destructorName(classname);
    String _plus = (_destructorName + "()");
    return _plus;
  }
  
  /**
   * @param operation an {@link Operation}
   * @return the operation signature (with special care for
   * 		constructor and destructor
   */
  private CharSequence operationSignature(final Operation operation, final String classname) {
    CharSequence _xifexpression = null;
    boolean _isConstructor = RoomHelpers.isConstructor(operation);
    if (_isConstructor) {
      String _constructorName = this.languageExt.constructorName(classname);
      String _constructorReturnType = this.languageExt.constructorReturnType();
      CharSequence _classOperationSignature = this.classOperationSignature(classname, _constructorName, "", _constructorReturnType);
      _xifexpression = _classOperationSignature;
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _isDestructor = RoomHelpers.isDestructor(operation);
      if (_isDestructor) {
        String _destructorName = this.languageExt.destructorName(classname);
        String _destructorReturnType = this.languageExt.destructorReturnType();
        CharSequence _classOperationSignature_1 = this.classOperationSignature(classname, _destructorName, "", _destructorReturnType);
        _xifexpression_1 = _classOperationSignature_1;
      } else {
        String _name = operation.getName();
        EList<VarDecl> _arguments = operation.getArguments();
        CharSequence _BuildArgumentList = this.BuildArgumentList(_arguments);
        String _string = _BuildArgumentList.toString();
        RefableType _returnType = operation.getReturnType();
        String _dataTypeToString = this.dataTypeToString(_returnType);
        CharSequence _classOperationSignature_2 = this.classOperationSignature(classname, _name, _string, _dataTypeToString);
        _xifexpression_1 = _classOperationSignature_2;
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
        String _plus = (_typeName + _pointerLiteral);
        _xifexpression_1 = _plus;
      } else {
        DataType _type_1 = type.getType();
        String _typeName_1 = this._typeHelpers.typeName(_type_1);
        _xifexpression_1 = _typeName_1;
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
    _builder.append("�FOR argument : arguments SEPARATOR \", \"��argument.refType.type.typeName��IF argument.refType.ref��languageExt.pointerLiteral()��ENDIF� �argument.name��ENDFOR�");
    return _builder;
  }
  
  private CharSequence classOperationSignature(final String classname, final String operationname, final String argumentList, final String returnType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�languageExt.accessLevelPublic()��returnType� �languageExt.memberInDeclaration(classname, operationname)�(�languageExt.selfPointer(classname, !argumentList.empty)��argumentList�)");
    return _builder;
  }
}
