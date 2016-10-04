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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
@SuppressWarnings("all")
public class ProcedureHelpers {
  protected final String NEWLINE = System.getProperty("line.separator");
  
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
      if (((!Objects.equal(code, null)) && (!code.isEmpty()))) {
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
  public CharSequence attributes(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    {
      for(final Attribute it : attributes) {
        CharSequence _attributeDeclaration = this.attributeDeclaration(it);
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
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(" ");
    String _declarationString = this.declarationString(attribute);
    _builder.append(_declarationString, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
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
  public CharSequence attributeSettersGettersDeclaration(final List<Attribute> attributes, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    {
      for(final Attribute attribute : attributes) {
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
  public CharSequence attributeSettersGettersImplementation(final List<Attribute> attributes, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    {
      for(final Attribute attribute : attributes) {
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
  protected CharSequence setterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append("void set");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, true);
    _builder.append(_selfPointer, "");
    String _argList = this.argList(Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList(attribute)));
    _builder.append(_argList, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param attribute an {@link Attribute}
   * @param classname the name of the defining class
   * @return code for the attribute getter declaration
   */
  protected CharSequence getterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    String _signatureString = this.signatureString(attribute);
    _builder.append(_signatureString, "");
    _builder.append(" get");
    String _name = attribute.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    String _selfPointer = this.languageExt.selfPointer(classname, false);
    _builder.append(_selfPointer, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * @param attributes a list of {@link Attribute}s
   * @return an argument list for the attributes
   */
  public String argList(final Iterable<Attribute> attributes) {
    final Function1<Attribute, String> _function = new Function1<Attribute, String>() {
      @Override
      public String apply(final Attribute it) {
        String _signatureString = ProcedureHelpers.this.signatureString(it);
        String _plus = (_signatureString + " ");
        String _name = it.getName();
        return (_plus + _name);
      }
    };
    Iterable<String> _map = IterableExtensions.<Attribute, String>map(attributes, _function);
    return IterableExtensions.join(_map, ", ");
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
        CharSequence _operationSignature = this.operationSignature(operation, classname, true);
        _builder.append(_operationSignature, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
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
        CharSequence _operationSignature = this.operationSignature(operation, classname, false);
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
    return _builder;
  }
  
  public CharSequence asBlock(final CharSequence str) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(str, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * invoke user structor, if (inherited) present - <b>C only</b>
   * 
   * @param cls {@link ActorClass} or {@link DataClass}
   * @param args self pointer to instance
   */
  public String invokeUserStructor(final RoomClass cls, final String args, final boolean ctor) {
    boolean _usesInheritance = this.languageExt.usesInheritance();
    boolean _not = (!_usesInheritance);
    List<ClassStructor> _structors = this.getStructors(cls, _not);
    final Function1<ClassStructor, Boolean> _function = new Function1<ClassStructor, Boolean>() {
      @Override
      public Boolean apply(final ClassStructor it) {
        boolean _isConstructor = it.isConstructor();
        return Boolean.valueOf((_isConstructor == ctor));
      }
    };
    boolean _exists = IterableExtensions.<ClassStructor>exists(_structors, _function);
    if (_exists) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = cls.getName();
      String _xifexpression = null;
      if (ctor) {
        _xifexpression = "ctor";
      } else {
        _xifexpression = "dtor";
      }
      String _memberInDeclaration = this.languageExt.memberInDeclaration(_name, _xifexpression);
      _builder.append(_memberInDeclaration, "");
      _builder.append("(");
      _builder.append(args, "");
      _builder.append(");");
      return _builder.toString();
    }
    return "";
  }
  
  /**
   * declaration of user constructor + destructor, if (inherited) present - <b>C only</b>
   * 
   * @param cls {@link ActorClass} or {@link DataClass}
   */
  public String userStructorsDeclaration(final RoomClass cls) {
    String _xblockexpression = null;
    {
      String _name = cls.getName();
      final String namePrefix = this.languageExt.operationScope(_name, true);
      final ArrayList<String> declBlock = CollectionLiterals.<String>newArrayList();
      declBlock.add("/*--------------------- user constructor/destructor ---------------------*/");
      boolean _usesInheritance = this.languageExt.usesInheritance();
      boolean _not = (!_usesInheritance);
      List<ClassStructor> _structors = this.getStructors(cls, _not);
      final Function1<ClassStructor, Boolean> _function = new Function1<ClassStructor, Boolean>() {
        @Override
        public Boolean apply(final ClassStructor it) {
          return Boolean.valueOf(it.isConstructor());
        }
      };
      boolean _exists = IterableExtensions.<ClassStructor>exists(_structors, _function);
      if (_exists) {
        String _name_1 = cls.getName();
        CharSequence _functionSignature = this.functionSignature(_name_1, (namePrefix + "ctor"), "void", "");
        String _plus = (_functionSignature + ";");
        declBlock.add(_plus);
      }
      boolean _usesInheritance_1 = this.languageExt.usesInheritance();
      boolean _not_1 = (!_usesInheritance_1);
      List<ClassStructor> _structors_1 = this.getStructors(cls, _not_1);
      final Function1<ClassStructor, Boolean> _function_1 = new Function1<ClassStructor, Boolean>() {
        @Override
        public Boolean apply(final ClassStructor it) {
          boolean _isConstructor = it.isConstructor();
          return Boolean.valueOf((!_isConstructor));
        }
      };
      boolean _exists_1 = IterableExtensions.<ClassStructor>exists(_structors_1, _function_1);
      if (_exists_1) {
        String _name_2 = cls.getName();
        CharSequence _functionSignature_1 = this.functionSignature(_name_2, (namePrefix + "dtor"), "void", "");
        String _plus_1 = (_functionSignature_1 + ";");
        declBlock.add(_plus_1);
      }
      _xblockexpression = IterableExtensions.join(declBlock, this.NEWLINE);
    }
    return _xblockexpression;
  }
  
  /**
   * implementation of user constructor + destructor, if (inherited) present - <b>C only</b>
   * 
   * @param cls {@link ActorClass} or {@link DataClass}
   */
  public String userStructorsImplementation(final RoomClass cls) {
    String _xblockexpression = null;
    {
      final ArrayList<String> declBlock = CollectionLiterals.<String>newArrayList();
      declBlock.add("/*--------------------- user constructor/destructor ---------------------*/");
      String _userStuctorImplementation = this.userStuctorImplementation(cls, true);
      declBlock.add(_userStuctorImplementation);
      String _userStuctorImplementation_1 = this.userStuctorImplementation(cls, false);
      declBlock.add(_userStuctorImplementation_1);
      Iterable<String> _filterNull = IterableExtensions.<String>filterNull(declBlock);
      _xblockexpression = IterableExtensions.join(_filterNull, this.NEWLINE);
    }
    return _xblockexpression;
  }
  
  protected String userStuctorImplementation(final RoomClass cls, final boolean ctor) {
    String _xblockexpression = null;
    {
      String _name = cls.getName();
      final String namePrefix = this.languageExt.operationScope(_name, false);
      boolean _usesInheritance = this.languageExt.usesInheritance();
      boolean _not = (!_usesInheritance);
      List<ClassStructor> _structors = this.getStructors(cls, _not);
      final Function1<ClassStructor, Boolean> _function = new Function1<ClassStructor, Boolean>() {
        @Override
        public Boolean apply(final ClassStructor it) {
          boolean _isConstructor = it.isConstructor();
          return Boolean.valueOf((_isConstructor == ctor));
        }
      };
      boolean _exists = IterableExtensions.<ClassStructor>exists(_structors, _function);
      boolean _not_1 = (!_exists);
      if (_not_1) {
        return null;
      }
      StringConcatenation _builder = new StringConcatenation();
      String _name_1 = cls.getName();
      String _xifexpression = null;
      if (ctor) {
        _xifexpression = "ctor";
      } else {
        _xifexpression = "dtor";
      }
      String _plus = (namePrefix + _xifexpression);
      CharSequence _functionSignature = this.functionSignature(_name_1, _plus, "void", "");
      _builder.append(_functionSignature, "");
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _userStructorBody = this.userStructorBody(cls, ctor);
      _builder.append(_userStructorBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * implementation of user structor, if (inherited) present
   */
  public String userStructorBody(final RoomClass cls, final boolean ctor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* user defined ");
    {
      if (ctor) {
        _builder.append("con");
      } else {
        _builder.append("de");
      }
    }
    _builder.append("structor body */");
    final String comment = _builder.toString();
    boolean _usesInheritance = this.languageExt.usesInheritance();
    boolean _not = (!_usesInheritance);
    List<ClassStructor> _structors = this.getStructors(cls, _not);
    final Function1<ClassStructor, Boolean> _function = new Function1<ClassStructor, Boolean>() {
      @Override
      public Boolean apply(final ClassStructor it) {
        boolean _isConstructor = it.isConstructor();
        return Boolean.valueOf((_isConstructor == ctor));
      }
    };
    final Iterable<ClassStructor> implementedStructors = IterableExtensions.<ClassStructor>filter(_structors, _function);
    final Function1<ClassStructor, DetailCode> _function_1 = new Function1<ClassStructor, DetailCode>() {
      @Override
      public DetailCode apply(final ClassStructor it) {
        return it.getDetailCode();
      }
    };
    Iterable<DetailCode> _map = IterableExtensions.<ClassStructor, DetailCode>map(implementedStructors, _function_1);
    final Function1<DetailCode, String> _function_2 = new Function1<DetailCode, String>() {
      @Override
      public String apply(final DetailCode it) {
        AbstractGenerator _instance = AbstractGenerator.getInstance();
        return _instance.getTranslatedCode(it);
      }
    };
    final Iterable<String> translatedCodes = IterableExtensions.<DetailCode, String>map(_map, _function_2);
    final Function1<String, CharSequence> _function_3 = new Function1<String, CharSequence>() {
      @Override
      public CharSequence apply(final String it) {
        CharSequence _xifexpression = null;
        int _size = IterableExtensions.size(translatedCodes);
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          _xifexpression = ProcedureHelpers.this.asBlock(it);
        } else {
          _xifexpression = it;
        }
        return _xifexpression;
      }
    };
    Iterable<CharSequence> _map_1 = IterableExtensions.<String, CharSequence>map(translatedCodes, _function_3);
    String _join = IterableExtensions.join(_map_1);
    return ((comment + this.NEWLINE) + _join);
  }
  
  protected List<ClassStructor> getStructors(final RoomClass cls, final boolean inherited) {
    List<ClassStructor> _switchResult = null;
    final RoomClass it = cls;
    boolean _matched = false;
    if (it instanceof ActorClass) {
      if ((!inherited)) {
        _matched=true;
        _switchResult = ((ActorClass)it).getStructors();
      }
    }
    if (!_matched) {
      if (it instanceof DataClass) {
        if ((!inherited)) {
          _matched=true;
          _switchResult = ((DataClass)it).getStructors();
        }
      }
    }
    if (!_matched) {
      if (it instanceof ActorClass) {
        if (inherited) {
          _matched=true;
          _switchResult = this._roomHelpers.getAllStructors(((ActorClass)it));
        }
      }
    }
    if (!_matched) {
      if (it instanceof DataClass) {
        if (inherited) {
          _matched=true;
          _switchResult = this._roomHelpers.getAllStructors(((DataClass)it));
        }
      }
    }
    return _switchResult;
  }
  
  /**
   * @param operation an {@link Operation}
   * @return the operation signature (with special care for
   * 		constructor and destructor
   */
  protected CharSequence operationSignature(final Operation operation, final String classname, final boolean isDeclaration) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      {
        EList<VarDecl> _arguments = operation.getArguments();
        boolean _hasElements = false;
        for(final VarDecl argument : _arguments) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          RefableType _refType = argument.getRefType();
          String _signatureString = this.signatureString(_refType);
          _builder.append(_signatureString, "");
          _builder.append(" ");
          String _name = argument.getName();
          _builder.append(_name, "");
        }
      }
      final String arguments = _builder.toString();
      RefableType _returnType = operation.getReturnType();
      final String returnType = this.signatureString(_returnType);
      String _operationScope = this.languageExt.operationScope(classname, isDeclaration);
      String _name_1 = operation.getName();
      String _plus = (_operationScope + _name_1);
      _xblockexpression = this.functionSignature(classname, _plus, returnType, arguments);
    }
    return _xblockexpression;
  }
  
  /**
   * @param type a {@link RefableType}
   * @return a string for the type (also for pointers)
   */
  public String signatureString(final RefableType type) {
    String _switchResult = null;
    final RefableType it = type;
    boolean _matched = false;
    if (Objects.equal(it, null)) {
      _matched=true;
      _switchResult = "void";
    }
    if (!_matched) {
      boolean _isRef = it.isRef();
      if (_isRef) {
        _matched=true;
        DataType _type = type.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        String _pointerLiteral = this.languageExt.pointerLiteral();
        _switchResult = (_typeName + _pointerLiteral);
      }
    }
    if (!_matched) {
      DataType _type_1 = type.getType();
      _switchResult = this._typeHelpers.typeName(_type_1);
    }
    return _switchResult;
  }
  
  public String signatureString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    int _size = it.getSize();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _matched=true;
      RefableType _type = it.getType();
      DataType _type_1 = _type.getType();
      String _typeName = this._typeHelpers.typeName(_type_1);
      int _size_1 = it.getSize();
      RefableType _type_2 = it.getType();
      boolean _isRef = _type_2.isRef();
      _switchResult = this.languageExt.arrayType(_typeName, _size_1, _isRef);
    }
    if (!_matched) {
      RefableType _type_3 = it.getType();
      _switchResult = this.signatureString(_type_3);
    }
    return _switchResult;
  }
  
  /**
   * @param attribute a {@link Attribute}
   * @return a string for <code>type name</code>
   */
  public String declarationString(final Attribute attribute) {
    String _switchResult = null;
    final Attribute it = attribute;
    boolean _matched = false;
    int _size = it.getSize();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _matched=true;
      RefableType _type = it.getType();
      DataType _type_1 = _type.getType();
      String _typeName = this._typeHelpers.typeName(_type_1);
      int _size_1 = it.getSize();
      RefableType _type_2 = it.getType();
      boolean _isRef = _type_2.isRef();
      String _name = it.getName();
      _switchResult = this.languageExt.arrayDeclaration(_typeName, _size_1, _isRef, _name);
    }
    if (!_matched) {
      RefableType _type_3 = it.getType();
      String _signatureString = this.signatureString(_type_3);
      String _plus = (_signatureString + " ");
      String _name_1 = it.getName();
      _switchResult = (_plus + _name_1);
    }
    return _switchResult;
  }
  
  protected CharSequence functionSignature(final String className, final String fullFctName, final String returnType, final String arguments) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(" ");
    _builder.append(returnType, "");
    _builder.append(" ");
    _builder.append(fullFctName, "");
    _builder.append("(");
    boolean _isEmpty = arguments.isEmpty();
    boolean _not = (!_isEmpty);
    String _selfPointer = this.languageExt.selfPointer(className, _not);
    _builder.append(_selfPointer, "");
    _builder.append(arguments, "");
    _builder.append(")");
    return _builder;
  }
}
