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
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
@SuppressWarnings("all")
public class ProcedureHelpers {
  @Inject
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
  public CharSequence userCode(final ActorContainerClass ac, final int id) {
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
    return _switchResult;
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
    {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(code, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isEmpty = code.isEmpty();
        boolean _not = (!_isEmpty);
        _and = (_notEquals && _not);
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
   * @param attribs a list of {@link Attribute}s
   * @return code declaring the attributes
   */
  public CharSequence attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
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
        RefableType _refType = attribute.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          RefableType _refType_1 = attribute.getRefType();
          boolean _isRef = _refType_1.isRef();
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
        RefableType _refType_2 = attribute.getRefType();
        DataType _type_1 = _refType_2.getType();
        String _typeName_1 = this._typeHelpers.typeName(_type_1);
        int _size_1 = attribute.getSize();
        String _name_1 = attribute.getName();
        RefableType _refType_3 = attribute.getRefType();
        boolean _isRef_1 = _refType_3.isRef();
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
      String _defaultValueLiteral_1 = att.getDefaultValueLiteral();
      _xifexpression = _defaultValueLiteral_1;
    } else {
      RefableType _refType = att.getRefType();
      DataType _type = _refType.getType();
      String _defaultValue = this.languageExt.defaultValue(_type);
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
    {
      for(final Attribute attribute : attribs) {
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
   * @param attribs a list of {@link Attribute}s
   * @param classname the name of the defining class
   * @return code defining setters and getters for the attributes
   */
  public CharSequence attributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* --------------------- attribute setters and getters */");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        CharSequence _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        String _memberAccess = this.languageExt.memberAccess();
        _builder.append(_memberAccess, "	 ");
        String _name = attribute.getName();
        _builder.append(_name, "	 ");
        _builder.append(" = ");
        String _name_1 = attribute.getName();
        _builder.append(_name_1, "	 ");
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
        _builder.append(_memberAccess_1, "	");
        String _name_2 = attribute.getName();
        _builder.append(_name_2, "	");
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
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
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
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
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
   * @param attribs a list of {@link Attribute}s
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
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
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
   * @param attribs an iterable of {@link Attribute}s representing a path
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
    _builder.append(_memberAccess, "	");
    _builder.append(name, "	");
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
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _and = (_usesInheritance && _isConstructor);
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
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _and = (_usesInheritance && _isConstructor);
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
            _builder.append(_translatedCode, "	");
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
        RefableType _returntype = operation.getReturntype();
        String _dataTypeToString = this.dataTypeToString(_returntype);
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
