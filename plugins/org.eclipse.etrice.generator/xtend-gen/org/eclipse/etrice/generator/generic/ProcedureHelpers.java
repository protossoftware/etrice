package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.DetailCodeTranslator;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProcedureHelpers {
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  public ITranslationProvider translator;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public StringConcatenation userCode(final DetailCode dc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      if (_operator_notEquals) {
        _builder.append("/*--------------------- begin user code ---------------------*/");
        _builder.newLine();
        {
          EList<String> _commands = dc.getCommands();
          for(final String command : _commands) {
            _builder.append("\t");
            _builder.append(command, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("/*--------------------- end user code ---------------------*/");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * TODO: add ref type
   */
  public StringConcatenation attributes(final List<Attribute> attribs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- attributes ---------------------*/");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        {
          int _size = attribute.getSize();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
          if (_operator_equals) {
            RefableType _refType = attribute.getRefType();
            DataType _type = _refType.getType();
            String _typeName = this._typeHelpers.typeName(_type);
            _builder.append(_typeName, "");
            _builder.append(" ");
            String _name = attribute.getName();
            _builder.append(_name, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            RefableType _refType_1 = attribute.getRefType();
            DataType _type_1 = _refType_1.getType();
            String _typeName_1 = this._typeHelpers.typeName(_type_1);
            int _size_1 = attribute.getSize();
            String _name_1 = attribute.getName();
            String _arrayDeclaration = this.languageExt.arrayDeclaration(_typeName_1, _size_1, _name_1);
            _builder.append(_arrayDeclaration, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String arrayInitializer(final Attribute att) {
      String _xifexpression = null;
      String _defaultValueLiteral = att.getDefaultValueLiteral();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
      if (_operator_notEquals) {
        String _defaultValueLiteral_1 = att.getDefaultValueLiteral();
        _xifexpression = _defaultValueLiteral_1;
      } else {
        RefableType _refType = att.getRefType();
        DataType _type = _refType.getType();
        String _defaultValue = this._typeHelpers.defaultValue(_type);
        _xifexpression = _defaultValue;
      }
      String dflt = _xifexpression;
      boolean _startsWith = dflt.startsWith("{");
      if (_startsWith) {
        {
          String[] _split = dflt.split(",");
          int _size = ((List<String>)Conversions.doWrapArray(_split)).size();
          int _size_1 = att.getSize();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)_size_1));
          if (_operator_notEquals_1) {
            String _name = att.getName();
            String _operator_plus = StringExtensions.operator_plus("WARNING: array size determined by initializer differs from attribute size (", _name);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "[");
            int _size_2 = att.getSize();
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ((Integer)_size_2));
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "] <-> ");
            String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, dflt);
            String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, ")");
            this.logger.logInfo(_operator_plus_5);
          }
          return dflt;
        }
      }
      String result = "{";
      int i = 0;
      int _size_3 = att.getSize();
      boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_3));
      Boolean _xwhileexpression = _operator_lessThan;
      while (_xwhileexpression) {
        {
          String _operator_plus_6 = StringExtensions.operator_plus(result, dflt);
          result = _operator_plus_6;
          int _operator_plus_7 = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
          i = _operator_plus_7;
          int _size_4 = att.getSize();
          boolean _operator_lessThan_1 = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_4));
          if (_operator_lessThan_1) {
            String _operator_plus_8 = StringExtensions.operator_plus(result, ", ");
            result = _operator_plus_8;
          }
        }
        int _size_5 = att.getSize();
        boolean _operator_lessThan_2 = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_5));
        _xwhileexpression = _operator_lessThan_2;
      }
      String _operator_plus_9 = StringExtensions.operator_plus(result, "}");
      return _operator_plus_9;
  }
  
  public StringConcatenation attributeInitialization(final List<Attribute> attribs, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        {
          String _defaultValueLiteral = a.getDefaultValueLiteral();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, null);
          if (_operator_notEquals) {
            {
              int _size = a.getSize();
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
              if (_operator_equals) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" = ");
                String _defaultValueLiteral_1 = a.getDefaultValueLiteral();
                _builder.append(_defaultValueLiteral_1, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                String _defaultValueLiteral_2 = a.getDefaultValueLiteral();
                boolean _startsWith = _defaultValueLiteral_2.startsWith("{");
                if (_startsWith) {
                  String _name_1 = a.getName();
                  _builder.append(_name_1, "");
                  _builder.append(" = new ");
                  RefableType _refType = a.getRefType();
                  DataType _type = _refType.getType();
                  String _typeName = this._typeHelpers.typeName(_type);
                  _builder.append(_typeName, "");
                  _builder.append("[] ");
                  String _defaultValueLiteral_3 = a.getDefaultValueLiteral();
                  _builder.append(_defaultValueLiteral_3, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  String _name_2 = a.getName();
                  _builder.append(_name_2, "");
                  _builder.append(" = new ");
                  RefableType _refType_1 = a.getRefType();
                  DataType _type_1 = _refType_1.getType();
                  String _typeName_1 = this._typeHelpers.typeName(_type_1);
                  _builder.append(_typeName_1, "");
                  _builder.append("[");
                  int _size_1 = a.getSize();
                  _builder.append(_size_1, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  _builder.append("for (int i=0;i<");
                  int _size_2 = a.getSize();
                  _builder.append(_size_2, "");
                  _builder.append(";i++){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _name_3 = a.getName();
                  _builder.append(_name_3, "	");
                  _builder.append("[i] = ");
                  String _defaultValueLiteral_4 = a.getDefaultValueLiteral();
                  _builder.append(_defaultValueLiteral_4, "	");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          } else {
            boolean _operator_or = false;
            boolean _operator_or_1 = false;
            RefableType _refType_2 = a.getRefType();
            DataType _type_2 = _refType_2.getType();
            if ((_type_2 instanceof ComplexType)) {
              _operator_or_1 = true;
            } else {
              int _size_3 = a.getSize();
              boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size_3), ((Integer)1));
              _operator_or_1 = BooleanExtensions.operator_or((_type_2 instanceof ComplexType), _operator_greaterThan);
            }
            if (_operator_or_1) {
              _operator_or = true;
            } else {
              boolean _operator_not = BooleanExtensions.operator_not(useClassDefaultsOnly);
              _operator_or = BooleanExtensions.operator_or(_operator_or_1, _operator_not);
            }
            if (_operator_or) {
              {
                int _size_4 = a.getSize();
                boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_4), ((Integer)0));
                if (_operator_equals_1) {
                  String _name_4 = a.getName();
                  _builder.append(_name_4, "");
                  _builder.append(" = ");
                  RefableType _refType_3 = a.getRefType();
                  DataType _type_3 = _refType_3.getType();
                  String _defaultValue = this._typeHelpers.defaultValue(_type_3);
                  _builder.append(_defaultValue, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  String _name_5 = a.getName();
                  _builder.append(_name_5, "");
                  _builder.append(" = new ");
                  RefableType _refType_4 = a.getRefType();
                  DataType _type_4 = _refType_4.getType();
                  String _typeName_2 = this._typeHelpers.typeName(_type_4);
                  _builder.append(_typeName_2, "");
                  _builder.append("[");
                  int _size_5 = a.getSize();
                  _builder.append(_size_5, "");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _operator_not_1 = BooleanExtensions.operator_not(useClassDefaultsOnly);
                    if (_operator_not_1) {
                      _builder.append("for (int i=0;i<");
                      int _size_6 = a.getSize();
                      _builder.append(_size_6, "");
                      _builder.append(";i++){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _name_6 = a.getName();
                      _builder.append(_name_6, "	");
                      _builder.append("[i] = ");
                      RefableType _refType_5 = a.getRefType();
                      DataType _type_5 = _refType_5.getType();
                      String _defaultValue_1 = this._typeHelpers.defaultValue(_type_5);
                      _builder.append(_defaultValue_1, "	");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation attributeSettersGettersDeclaration(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _setterHeader = this.setterHeader(attribute, classname);
        _builder.append(_setterHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        StringConcatenation _terHeader = this.getterHeader(attribute, classname);
        _builder.append(_terHeader, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public StringConcatenation attributeSettersGettersImplementation(final List<Attribute> attribs, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//--------------------- attribute setters and getters");
    _builder.newLine();
    {
      for(final Attribute attribute : attribs) {
        StringConcatenation _setterHeader = this.setterHeader(attribute, classname);
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
        StringConcatenation _terHeader = this.getterHeader(attribute, classname);
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
  
  private StringConcatenation setterHeader(final Attribute attribute, final String classname) {
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
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
        _builder.append("[]");
      }
    }
    _builder.append(" ");
    String _name_1 = attribute.getName();
    _builder.append(_name_1, "");
    _builder.append(")");
    return _builder;
  }
  
  private StringConcatenation getterHeader(final Attribute attribute, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    RefableType _refType = attribute.getRefType();
    DataType _type = _refType.getType();
    String _typeName = this._typeHelpers.typeName(_type);
    _builder.append(_typeName, "");
    {
      int _size = attribute.getSize();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_size), ((Integer)0));
      if (_operator_notEquals) {
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
  
  public StringConcatenation argList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final Attribute a : attributes) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = a.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)1));
          if (_operator_greaterThan) {
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
  
  public StringConcatenation operationsDeclaration(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _operator_and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _operator_and = false;
          } else {
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _operator_and = BooleanExtensions.operator_and(_usesInheritance, _isConstructor);
          }
          boolean _operator_not = BooleanExtensions.operator_not(_operator_and);
          if (_operator_not) {
            StringConcatenation _operationSignature = this.operationSignature(operation, classname, true);
            _builder.append(_operationSignature, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation operationsImplementation(final List<? extends Operation> operations, final String classname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*--------------------- operations ---------------------*/");
    _builder.newLine();
    {
      for(final Operation operation : operations) {
        {
          boolean _operator_and = false;
          boolean _usesInheritance = this.languageExt.usesInheritance();
          if (!_usesInheritance) {
            _operator_and = false;
          } else {
            boolean _isConstructor = RoomHelpers.isConstructor(operation);
            _operator_and = BooleanExtensions.operator_and(_usesInheritance, _isConstructor);
          }
          boolean _operator_not = BooleanExtensions.operator_not(_operator_and);
          if (_operator_not) {
            StringConcatenation _operationSignature = this.operationSignature(operation, classname, false);
            _builder.append(_operationSignature, "");
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            {
              DetailCode _detailCode = operation.getDetailCode();
              EList<String> _commands = _detailCode.getCommands();
              for(final String command : _commands) {
                _builder.append("\t");
                _builder.append(command, "	");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation operationsImplementation(final ActorClass ac) {
    StringConcatenation _xblockexpression = null;
    {
      this.translator.setActorClass(ac);
      DetailCodeTranslator _detailCodeTranslator = new DetailCodeTranslator(ac, this.translator);
      DetailCodeTranslator dct = _detailCodeTranslator;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*--------------------- operations ---------------------*/");
      _builder.newLine();
      {
        EList<StandardOperation> _operations = ac.getOperations();
        for(final StandardOperation operation : _operations) {
          {
            boolean _operator_and = false;
            boolean _usesInheritance = this.languageExt.usesInheritance();
            if (!_usesInheritance) {
              _operator_and = false;
            } else {
              boolean _isConstructor = RoomHelpers.isConstructor(operation);
              _operator_and = BooleanExtensions.operator_and(_usesInheritance, _isConstructor);
            }
            boolean _operator_not = BooleanExtensions.operator_not(_operator_and);
            if (_operator_not) {
              String _name = ac.getName();
              StringConcatenation _operationSignature = this.operationSignature(operation, _name, false);
              _builder.append(_operationSignature, "");
              _builder.append(" {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              DetailCode _detailCode = operation.getDetailCode();
              String _translateDetailCode = dct.translateDetailCode(_detailCode);
              _builder.append(_translateDetailCode, "	");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private StringConcatenation operationSignature(final Operation operation, final String classname, final boolean isDeclaration) {
    StringConcatenation _xifexpression = null;
    boolean _isConstructor = RoomHelpers.isConstructor(operation);
    if (_isConstructor) {
      String _constructorName = this.languageExt.constructorName(classname);
      String _constructorReturnType = this.languageExt.constructorReturnType();
      StringConcatenation _classOperationSignature = this.classOperationSignature(classname, _constructorName, "", _constructorReturnType, isDeclaration);
      _xifexpression = _classOperationSignature;
    } else {
      StringConcatenation _xifexpression_1 = null;
      boolean _isDestructor = RoomHelpers.isDestructor(operation);
      if (_isDestructor) {
        String _destructorName = this.languageExt.destructorName(classname);
        String _destructorReturnType = this.languageExt.destructorReturnType();
        StringConcatenation _classOperationSignature_1 = this.classOperationSignature(classname, _destructorName, "", _destructorReturnType, isDeclaration);
        _xifexpression_1 = _classOperationSignature_1;
      } else {
        String _name = operation.getName();
        EList<VarDecl> _arguments = operation.getArguments();
        StringConcatenation _BuildArgumentList = this.BuildArgumentList(_arguments);
        String _string = _BuildArgumentList.toString();
        RefableType _returntype = operation.getReturntype();
        String _dataTypeToString = this.dataTypeToString(_returntype);
        StringConcatenation _classOperationSignature_2 = this.classOperationSignature(classname, _name, _string, _dataTypeToString, isDeclaration);
        _xifexpression_1 = _classOperationSignature_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String dataTypeToString(final RefableType type) {
    String _xifexpression = null;
    boolean _operator_equals = ObjectExtensions.operator_equals(type, null);
    if (_operator_equals) {
      _xifexpression = "void";
    } else {
      DataType _type = type.getType();
      String _typeName = this._typeHelpers.typeName(_type);
      _xifexpression = _typeName;
    }
    return _xifexpression;
  }
  
  /**
   * builds comma separated argument list as string from EList<VarDecl> arguments
   */
  private StringConcatenation BuildArgumentList(final EList<VarDecl> arguments) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final VarDecl argument : arguments) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        RefableType _refType = argument.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        _builder.append(" ");
        String _name = argument.getName();
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  private StringConcatenation classOperationSignature(final String classname, final String operationname, final String argumentList, final String returnType, final boolean isDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    String _accessLevelPublic = this.languageExt.accessLevelPublic();
    _builder.append(_accessLevelPublic, "");
    _builder.append(returnType, "");
    _builder.append(" ");
    String _memberInDeclaration = this.languageExt.memberInDeclaration(classname, operationname);
    _builder.append(_memberInDeclaration, "");
    _builder.append("(");
    boolean _isEmpty = argumentList.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    String _selfPointer = this.languageExt.selfPointer(classname, _operator_not);
    _builder.append(_selfPointer, "");
    _builder.append(argumentList, "");
    _builder.append(")");
    return _builder;
  }
}
