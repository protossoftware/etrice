/**
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.cpp.GeneratorOptions;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Peter Karlitschek
 */
@Singleton
@SuppressWarnings("all")
public class DataClassGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private CppExtensions stdExt;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  @Extension
  private TypeHelpers typeHelpers;
  
  @Inject
  @Extension
  private Initialization _initialization;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    this.logger.logInfo("generating code");
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(dc);
        String _path = this.roomExt.getPath(dc);
        String path = (_generationTargetPath + _path);
        String _cppHeaderFileName = this.stdExt.getCppHeaderFileName(dc);
        String _plus = ("generating DataClass header \'" + _cppHeaderFileName);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        String _cppHeaderFileName_1 = this.stdExt.getCppHeaderFileName(dc);
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, dc);
        this.fileAccess.generateFile(_cppHeaderFileName_1, _generateHeaderFile);
        String _cppSourceFileName = this.stdExt.getCppSourceFileName(dc);
        String _plus_4 = ("generating DataClass source \'" + _cppSourceFileName);
        String _plus_5 = (_plus_4 + "\' in \'");
        String _plus_6 = (_plus_5 + path);
        String _plus_7 = (_plus_6 + "\'");
        this.logger.logInfo(_plus_7);
        this.fileAccess.setOutputPath(path);
        String _cppSourceFileName_1 = this.stdExt.getCppSourceFileName(dc);
        CharSequence _generateSourceFile = this.generateSourceFile(root, dc);
        this.fileAccess.generateFile(_cppSourceFileName_1, _generateSourceFile);
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final DataClass dc) {
    CharSequence _xblockexpression = null;
    {
      EList<StandardOperation> _operations = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isConstructor = RoomHelpers.isConstructor(op);
            return Boolean.valueOf(_isConstructor);
          }
        };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      EList<StandardOperation> _operations_1 = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isDestructor = op.isDestructor();
            return Boolean.valueOf(_isDestructor);
          }
        };
      Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
      final StandardOperation dtor = IterableExtensions.<StandardOperation>head(_filter_1);
      StringConcatenation _builder = new StringConcatenation();
      String _path = this.roomExt.getPath(dc);
      String _name = dc.getName();
      String _plus = (_path + _name);
      CharSequence _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(_plus);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        DataClass _base = dc.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          _builder.append("#include \"");
          DataClass _base_1 = dc.getBase();
          String _path_1 = this.roomExt.getPath(_base_1);
          _builder.append(_path_1, "");
          DataClass _base_2 = dc.getBase();
          String _name_1 = _base_2.getName();
          _builder.append(_name_1, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(dc);
        for(final DataClass classes : _referencedDataClasses) {
          _builder.append("#include \"");
          String _path_2 = this.roomExt.getPath(classes);
          _builder.append(_path_2, "");
          String _name_2 = classes.getName();
          _builder.append(_name_2, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      EList<RoomModel> models = root.getReferencedModels(dc);
      _builder.newLineIfNotEmpty();
      {
        for(final RoomModel model : models) {
          {
            EList<DataClass> _dataClasses = model.getDataClasses();
            for(final DataClass classes_1 : _dataClasses) {
              _builder.append("#include \"");
              String _path_3 = this.roomExt.getPath(classes_1);
              _builder.append(_path_3, "");
              String _name_3 = classes_1.getName();
              _builder.append(_name_3, "");
              _builder.append(".h\"");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      DetailCode _userCode1 = dc.getUserCode1();
      CharSequence _userCode = this.helpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ");
      String _name_4 = dc.getName();
      _builder.append(_name_4, "");
      {
        DataClass _base_3 = dc.getBase();
        boolean _notEquals_1 = (!Objects.equal(_base_3, null));
        if (_notEquals_1) {
          _builder.append(" : public ");
          DataClass _base_4 = dc.getBase();
          String _name_5 = _base_4.getName();
          _builder.append(_name_5, "");
        }
      }
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t");
      DetailCode _userCode2 = dc.getUserCode2();
      CharSequence _userCode_1 = this.helpers.userCode(_userCode2);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes = dc.getAttributes();
      CharSequence _attributes_1 = this.helpers.attributes(_attributes);
      _builder.append(_attributes_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes_2 = dc.getAttributes();
      String _name_6 = dc.getName();
      CharSequence _attributeSettersGettersImplementation = this.helpers.attributeSettersGettersImplementation(_attributes_2, _name_6);
      _builder.append(_attributeSettersGettersImplementation, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<StandardOperation> _operations_2 = dc.getOperations();
      String _name_7 = dc.getName();
      CharSequence _operationsDeclaration = this.helpers.operationsDeclaration(_operations_2, _name_7);
      _builder.append(_operationsDeclaration, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// default constructor, copy constructor and assignment operator");
      _builder.newLine();
      _builder.append("\t");
      String _name_8 = dc.getName();
      _builder.append(_name_8, "	");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _name_9 = dc.getName();
      _builder.append(_name_9, "	");
      _builder.append("(const ");
      String _name_10 = dc.getName();
      _builder.append(_name_10, "	");
      _builder.append("& rhs);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _name_11 = dc.getName();
      _builder.append(_name_11, "	");
      _builder.append("& operator=(const ");
      String _name_12 = dc.getName();
      _builder.append(_name_12, "	");
      _builder.append("& rhs);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// constructor using fields");
      _builder.newLine();
      _builder.append("\t");
      String _name_13 = dc.getName();
      _builder.append(_name_13, "	");
      _builder.append("(");
      String _argList = this.argList(dc);
      _builder.append(_argList, "	");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        DataClass _base_5 = dc.getBase();
        boolean _notEquals_2 = (!Objects.equal(_base_5, null));
        if (_notEquals_2) {
          _builder.append("\t");
          _builder.append("// constructor using base class constructor");
          _builder.newLine();
          _builder.append("\t");
          String _name_14 = dc.getName();
          _builder.append(_name_14, "	");
          _builder.append("(");
          DataClass _base_6 = dc.getBase();
          String _name_15 = _base_6.getName();
          _builder.append(_name_15, "	");
          _builder.append(" _super, ");
          EList<Attribute> _attributes_3 = dc.getAttributes();
          CharSequence _argListConstructor = this.argListConstructor(_attributes_3);
          String _string = _argListConstructor.toString();
          _builder.append(_string, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _name_16 = dc.getName();
      CharSequence _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(_name_16);
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateSourceFile(final Root root, final DataClass dc) {
    CharSequence _xblockexpression = null;
    {
      EList<StandardOperation> _operations = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isConstructor = RoomHelpers.isConstructor(op);
            return Boolean.valueOf(_isConstructor);
          }
        };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      EList<StandardOperation> _operations_1 = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isDestructor = op.isDestructor();
            return Boolean.valueOf(_isDestructor);
          }
        };
      Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
      final StandardOperation dtor = IterableExtensions.<StandardOperation>head(_filter_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Source File of DataClass ");
      String _name = dc.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cppHeaderFileName = this.stdExt.getCppHeaderFileName(dc);
      _builder.append(_cppHeaderFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      {
        boolean _isUseEtUnit = GeneratorOptions.isUseEtUnit();
        if (_isUseEtUnit) {
          _builder.append("extern \"C\" {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("#include \"etUnit.h\"");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      DetailCode _userCode3 = dc.getUserCode3();
      CharSequence _userCode = this.helpers.userCode(_userCode3);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("// default constructor");
      _builder.newLine();
      String _name_1 = dc.getName();
      _builder.append(_name_1, "");
      _builder.append("::");
      String _name_2 = dc.getName();
      _builder.append(_name_2, "");
      _builder.append("() ");
      _builder.newLineIfNotEmpty();
      {
        DataClass _base = dc.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append(":");
          DataClass _base_1 = dc.getBase();
          String _name_3 = _base_1.getName();
          _builder.append(_name_3, "	");
          _builder.append("()");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes = dc.getAttributes();
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes, false);
      _builder.append(_attributeInitialization, "	");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals_1 = (!Objects.equal(ctor, null));
        if (_notEquals_1) {
          _builder.append("\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("// user defined constructor body");
          _builder.newLine();
          {
            DetailCode _detailCode = ctor.getDetailCode();
            EList<String> _commands = _detailCode.getCommands();
            for(final String l : _commands) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append(l, "		");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("// copy constructor");
      _builder.newLine();
      String _name_4 = dc.getName();
      _builder.append(_name_4, "");
      _builder.append("::");
      String _name_5 = dc.getName();
      _builder.append(_name_5, "");
      _builder.append("(const ");
      String _name_6 = dc.getName();
      _builder.append(_name_6, "");
      _builder.append("& rhs)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(":");
      _builder.newLine();
      {
        DataClass _base_2 = dc.getBase();
        boolean _notEquals_2 = (!Objects.equal(_base_2, null));
        if (_notEquals_2) {
          _builder.append("\t");
          DataClass _base_3 = dc.getBase();
          String _name_7 = _base_3.getName();
          _builder.append(_name_7, "	");
          _builder.append("(rhs),");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<Attribute> _attributes_1 = dc.getAttributes();
        boolean _hasElements = false;
        for(final Attribute a : _attributes_1) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "	");
          }
          _builder.append("\t");
          String _name_8 = a.getName();
          _builder.append(_name_8, "	");
          _builder.append("(rhs.");
          String _name_9 = a.getName();
          _builder.append(_name_9, "	");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// constructor using fields");
      _builder.newLine();
      String _name_10 = dc.getName();
      _builder.append(_name_10, "");
      _builder.append("::");
      String _name_11 = dc.getName();
      _builder.append(_name_11, "");
      _builder.append("(");
      String _argList = this.argList(dc);
      _builder.append(_argList, "");
      _builder.append(") ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(":");
      _builder.newLine();
      {
        DataClass _base_4 = dc.getBase();
        boolean _notEquals_3 = (!Objects.equal(_base_4, null));
        if (_notEquals_3) {
          _builder.append("\t");
          DataClass _base_5 = dc.getBase();
          String _name_12 = _base_5.getName();
          _builder.append(_name_12, "	");
          _builder.append("(");
          DataClass _base_6 = dc.getBase();
          String _paramList = this.paramList(_base_6);
          _builder.append(_paramList, "	");
          _builder.append("),");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<Attribute> _attributes_2 = dc.getAttributes();
        boolean _hasElements_1 = false;
        for(final Attribute a_1 : _attributes_2) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "	");
          }
          _builder.append("\t");
          String _name_13 = a_1.getName();
          _builder.append(_name_13, "	");
          _builder.append("(");
          String _name_14 = a_1.getName();
          _builder.append(_name_14, "	");
          _builder.append("_)");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        DataClass _base_7 = dc.getBase();
        boolean _notEquals_4 = (!Objects.equal(_base_7, null));
        if (_notEquals_4) {
          _builder.append("// constructor using base class constructor");
          _builder.newLine();
          String _name_15 = dc.getName();
          _builder.append(_name_15, "");
          _builder.append("::");
          String _name_16 = dc.getName();
          _builder.append(_name_16, "");
          _builder.append("(");
          DataClass _base_8 = dc.getBase();
          String _name_17 = _base_8.getName();
          _builder.append(_name_17, "");
          _builder.append(" _super, ");
          EList<Attribute> _attributes_3 = dc.getAttributes();
          CharSequence _argListConstructor = this.argListConstructor(_attributes_3);
          String _string = _argListConstructor.toString();
          _builder.append(_string, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(":");
          _builder.newLine();
          _builder.append("\t");
          DataClass _base_9 = dc.getBase();
          String _name_18 = _base_9.getName();
          _builder.append(_name_18, "	");
          _builder.append("(_super),");
          _builder.newLineIfNotEmpty();
          {
            EList<Attribute> _attributes_4 = dc.getAttributes();
            boolean _hasElements_2 = false;
            for(final Attribute a_2 : _attributes_4) {
              if (!_hasElements_2) {
                _hasElements_2 = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              String _name_19 = a_2.getName();
              _builder.append(_name_19, "	");
              _builder.append("(");
              String _name_20 = a_2.getName();
              _builder.append(_name_20, "	");
              _builder.append("_)");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("{");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("// assignment operator");
      _builder.newLine();
      String _name_21 = dc.getName();
      _builder.append(_name_21, "");
      _builder.append("& ");
      String _name_22 = dc.getName();
      _builder.append(_name_22, "");
      _builder.append("::operator=(const ");
      String _name_23 = dc.getName();
      _builder.append(_name_23, "");
      _builder.append("& rhs)");
      _builder.newLineIfNotEmpty();
      _builder.append("{\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (this == &rhs) { return *this; };");
      _builder.newLine();
      {
        DataClass _base_10 = dc.getBase();
        boolean _notEquals_5 = (!Objects.equal(_base_10, null));
        if (_notEquals_5) {
          _builder.append("\t");
          DataClass _base_11 = dc.getBase();
          String _name_24 = _base_11.getName();
          _builder.append(_name_24, "	");
          _builder.append("::operator=(rhs);");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<Attribute> _attributes_5 = dc.getAttributes();
        for(final Attribute a_3 : _attributes_5) {
          _builder.append("\t");
          String _name_25 = a_3.getName();
          _builder.append(_name_25, "	");
          _builder.append("= rhs.");
          String _name_26 = a_3.getName();
          _builder.append(_name_26, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("return *this;");
      _builder.newLine();
      _builder.append("}\t\t\t");
      _builder.newLine();
      _builder.newLine();
      EList<StandardOperation> _operations_2 = dc.getOperations();
      String _name_27 = dc.getName();
      CharSequence _operationsImplementation = this.helpers.operationsImplementation(_operations_2, _name_27);
      _builder.append(_operationsImplementation, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public String paramList(final DataClass _dc) {
    String result = "";
    DataClass dc = _dc;
    boolean _notEquals = (!Objects.equal(dc, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        EList<Attribute> _attributes = dc.getAttributes();
        CharSequence _paramList = this.paramList(_attributes);
        String _string = _paramList.toString();
        String _plus = (_string + result);
        result = _plus;
        DataClass _base = dc.getBase();
        dc = _base;
        boolean _notEquals_1 = (!Objects.equal(dc, null));
        if (_notEquals_1) {
          String _plus_1 = (", " + result);
          result = _plus_1;
        }
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  public CharSequence paramList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Attribute a : attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = a.getName();
        _builder.append(_name, "");
        _builder.append("_");
      }
    }
    return _builder;
  }
  
  public String argList(final DataClass _dc) {
    String result = "";
    DataClass dc = _dc;
    boolean _notEquals = (!Objects.equal(dc, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        EList<Attribute> _attributes = dc.getAttributes();
        CharSequence _argListConstructor = this.argListConstructor(_attributes);
        String _string = _argListConstructor.toString();
        String _plus = (_string + result);
        result = _plus;
        DataClass _base = dc.getBase();
        dc = _base;
        boolean _notEquals_1 = (!Objects.equal(dc, null));
        if (_notEquals_1) {
          String _plus_1 = (", " + result);
          result = _plus_1;
        }
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  public CharSequence argListConstructor(final List<Attribute> attributes) {
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
        String _typeName = this.typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        {
          int _size = a.getSize();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name = a.getName();
        _builder.append(_name, "");
        _builder.append("_");
      }
    }
    return _builder;
  }
  
  public String deepCopy(final DataClass _dc) {
    String result = "";
    DataClass dc = _dc;
    boolean _notEquals = (!Objects.equal(dc, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        EList<Attribute> _attributes = dc.getAttributes();
        CharSequence _deepCopy = this.deepCopy(_attributes);
        String _string = _deepCopy.toString();
        String _plus = (_string + result);
        result = _plus;
        DataClass _base = dc.getBase();
        dc = _base;
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  public CharSequence deepCopy(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute a : attributes) {
        {
          RefableType _refType = a.getRefType();
          DataType _type = _refType.getType();
          if ((_type instanceof ComplexType)) {
            _builder.append("if (");
            String _name = a.getName();
            _builder.append(_name, "");
            _builder.append("!=null) {");
            _builder.newLineIfNotEmpty();
            {
              int _size = a.getSize();
              boolean _equals = (_size == 0);
              if (_equals) {
                _builder.append("\t");
                _builder.append("copy.");
                String _name_1 = a.getName();
                _builder.append(_name_1, "	");
                _builder.append(" = ");
                String _name_2 = a.getName();
                _builder.append(_name_2, "	");
                _builder.append(".deepCopy();");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("for (int i=0;i<");
                String _name_3 = a.getName();
                _builder.append(_name_3, "	");
                _builder.append(".length;i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("copy.");
                String _name_4 = a.getName();
                _builder.append(_name_4, "		");
                _builder.append("[i] = ");
                String _name_5 = a.getName();
                _builder.append(_name_5, "		");
                _builder.append("[i].deepCopy();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("}");
            _builder.newLine();
          } else {
            {
              int _size_1 = a.getSize();
              boolean _equals_1 = (_size_1 == 0);
              if (_equals_1) {
                _builder.append("copy.");
                String _name_6 = a.getName();
                _builder.append(_name_6, "");
                _builder.append(" = ");
                String _name_7 = a.getName();
                _builder.append(_name_7, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("for (int i=0;i<");
                String _name_8 = a.getName();
                _builder.append(_name_8, "");
                _builder.append(".length;i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("copy.");
                String _name_9 = a.getName();
                _builder.append(_name_9, "	");
                _builder.append("[i] = ");
                String _name_10 = a.getName();
                _builder.append(_name_10, "	");
                _builder.append("[i];");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
}
