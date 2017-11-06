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
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.CppProcedureHelpers;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
  private CppProcedureHelpers helpers;
  
  @Inject
  private Initialization initHelper;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    this.logger.logInfo("generating code");
    EList<DataClass> _dataClasses = root.getDataClasses();
    for (final DataClass dc : _dataClasses) {
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
        this.fileAccess.generateFile(this.stdExt.getCppHeaderFileName(dc), this.generateHeaderFile(root, dc));
        String _cppSourceFileName = this.stdExt.getCppSourceFileName(dc);
        String _plus_4 = ("generating DataClass source \'" + _cppSourceFileName);
        String _plus_5 = (_plus_4 + "\' in \'");
        String _plus_6 = (_plus_5 + path);
        String _plus_7 = (_plus_6 + "\'");
        this.logger.logInfo(_plus_7);
        this.fileAccess.setOutputPath(path);
        this.fileAccess.generateFile(this.stdExt.getCppSourceFileName(dc), this.generateSourceFile(root, dc));
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(dc, "");
    _builder.append(_generateIncludeGuardBegin);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"common/etDatatypesCpp.hpp\"");
    _builder.newLine();
    {
      DataClass _base = dc.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        _builder.append("#include \"");
        String _path = this.roomExt.getPath(dc.getBase());
        _builder.append(_path);
        String _name = dc.getBase().getName();
        _builder.append(_name);
        _builder.append(".h\"");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(dc);
      for(final DataClass classes : _referencedDataClasses) {
        _builder.append("#include \"");
        String _path_1 = this.roomExt.getPath(classes);
        _builder.append(_path_1);
        String _name_1 = classes.getName();
        _builder.append(_name_1);
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<RoomModel> _referencedModels = root.getReferencedModels(dc);
      for(final RoomModel model : _referencedModels) {
        {
          EList<DataClass> _dataClasses = model.getDataClasses();
          for(final DataClass classes_1 : _dataClasses) {
            _builder.append("#include \"");
            String _path_2 = this.roomExt.getPath(classes_1);
            _builder.append(_path_2);
            String _name_2 = classes_1.getName();
            _builder.append(_name_2);
            _builder.append(".h\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    CharSequence _userCode = this.helpers.userCode(dc.getUserCode1());
    _builder.append(_userCode);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("using namespace etRuntime; // TODO JH remove");
    _builder.newLine();
    _builder.newLine();
    String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(dc);
    _builder.append(_generateNamespaceBegin);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _name_3 = dc.getName();
    _builder.append(_name_3);
    {
      DataClass _base_1 = dc.getBase();
      boolean _notEquals_1 = (!Objects.equal(_base_1, null));
      if (_notEquals_1) {
        _builder.append(" : public ");
        String _name_4 = dc.getBase().getName();
        _builder.append(_name_4);
      }
    }
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _userCode_1 = this.helpers.userCode(dc.getUserCode2());
    _builder.append(_userCode_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _attributes = this.helpers.attributes(dc.getAttributes());
    _builder.append(_attributes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _attributeSettersGettersImplementation = this.helpers.attributeSettersGettersImplementation(dc.getAttributes(), dc.getName());
    _builder.append(_attributeSettersGettersImplementation, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _operationsDeclaration = this.helpers.operationsDeclaration(dc.getOperations(), dc.getName());
    _builder.append(_operationsDeclaration, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// default constructor, copy constructor and assignment operator");
    _builder.newLine();
    _builder.append("\t");
    String _name_5 = dc.getName();
    _builder.append(_name_5, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _name_6 = dc.getName();
    _builder.append(_name_6, "\t");
    _builder.append("(const ");
    String _name_7 = dc.getName();
    _builder.append(_name_7, "\t");
    _builder.append("& rhs);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("// constructor using fields");
    _builder.newLine();
    _builder.append("\t");
    {
      boolean _isEmpty = this._roomHelpers.getAllAttributes(dc).isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _name_8 = dc.getName();
        _builder.append(_name_8, "\t");
        _builder.append("(");
        String _constArgList = this.helpers.constArgList(this._roomHelpers.getAllAttributes(dc));
        _builder.append(_constArgList, "\t");
        _builder.append(");");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    String _name_9 = dc.getName();
    _builder.append(_name_9, "\t");
    _builder.append("& operator=(const ");
    String _name_10 = dc.getName();
    _builder.append(_name_10, "\t");
    _builder.append("& rhs);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(dc);
    _builder.append(_generateNamespaceEnd);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(dc, "");
    _builder.append(_generateIncludeGuardEnd);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateSourceFile(final Root root, final DataClass dc) {
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
    _builder.append(_cppHeaderFileName);
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"etUnit/etUnit.h\"");
    _builder.newLine();
    _builder.newLine();
    String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(dc);
    _builder.append(_generateNamespaceBegin);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _userCode = this.helpers.userCode(dc.getUserCode3());
    _builder.append(_userCode);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// default constructor");
    _builder.newLine();
    String _name_1 = dc.getName();
    _builder.append(_name_1);
    _builder.append("::");
    String _name_2 = dc.getName();
    _builder.append(_name_2);
    _builder.append("()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateDefaultInitalizerList = this.generateDefaultInitalizerList(dc);
    _builder.append(_generateDefaultInitalizerList, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _genExtraInitializers = this.initHelper.genExtraInitializers(dc.getAttributes());
    _builder.append(_genExtraInitializers, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _userStructorBody = this.helpers.userStructorBody(dc, true);
    _builder.append(_userStructorBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// copy constructor");
    _builder.newLine();
    String _name_3 = dc.getName();
    _builder.append(_name_3);
    _builder.append("::");
    String _name_4 = dc.getName();
    _builder.append(_name_4);
    _builder.append("(const ");
    String _name_5 = dc.getName();
    _builder.append(_name_5);
    _builder.append("& rhs)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateCopyInitalizerList = this.generateCopyInitalizerList(dc);
    _builder.append(_generateCopyInitalizerList, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// constructor using fields");
    _builder.newLine();
    _builder.append("// TODO");
    _builder.newLine();
    {
      boolean _isEmpty = this._roomHelpers.getAllAttributes(dc).isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _name_6 = dc.getName();
        _builder.append(_name_6);
        _builder.append("::");
        String _name_7 = dc.getName();
        _builder.append(_name_7);
        _builder.append("(");
        String _constArgList = this.helpers.constArgList(this._roomHelpers.getAllAttributes(dc));
        _builder.append(_constArgList);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _generateFieldInitializerList = this.generateFieldInitializerList(dc);
        _builder.append(_generateFieldInitializerList, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("// assignment operator");
    _builder.newLine();
    String _name_8 = dc.getName();
    _builder.append(_name_8);
    _builder.append("& ");
    String _name_9 = dc.getName();
    _builder.append(_name_9);
    _builder.append("::operator=(const ");
    String _name_10 = dc.getName();
    _builder.append(_name_10);
    _builder.append("& rhs)");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (this == &rhs) { return *this; };");
    _builder.newLine();
    _builder.append("\t");
    {
      DataClass _base = dc.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        String _name_11 = dc.getBase().getName();
        _builder.append(_name_11, "\t");
        _builder.append("::operator=(rhs);");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = dc.getAttributes();
      for(final Attribute attr : _attributes) {
        _builder.append("\t");
        _builder.append("this->");
        String _name_12 = attr.getName();
        _builder.append(_name_12, "\t");
        _builder.append(" = rhs.");
        String _name_13 = attr.getName();
        _builder.append(_name_13, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("return *this;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _operationsImplementation = this.helpers.operationsImplementation(dc.getOperations(), dc.getName());
    _builder.append(_operationsImplementation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(dc);
    _builder.append(_generateNamespaceEnd);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateDefaultInitalizerList(final DataClass dataClass) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      ArrayList<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
      DataClass _base = dataClass.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        String _name = dataClass.getBase().getName();
        String _plus = (_name + "()");
        initList.add(_plus);
      }
      final Function1<Attribute, String> _function = (Attribute it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name_1 = it.getName();
        _builder.append(_name_1);
        _builder.append("(");
        String _initializerListValue = initHelper.getInitializerListValue(it);
        _builder.append(_initializerListValue);
        _builder.append(")");
        return _builder.toString();
      };
      List<String> _map = ListExtensions.<Attribute, String>map(dataClass.getAttributes(), _function);
      Iterables.<CharSequence>addAll(initList, _map);
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateCopyInitalizerList(final DataClass dataClass) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      ArrayList<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
      DataClass _base = dataClass.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        String _name = dataClass.getBase().getName();
        String _plus = (_name + "(rhs)");
        initList.add(_plus);
      }
      final Function1<Attribute, String> _function = (Attribute it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name_1 = it.getName();
        _builder.append(_name_1);
        _builder.append("(rhs.");
        String _name_2 = it.getName();
        _builder.append(_name_2);
        _builder.append(")");
        return _builder.toString();
      };
      List<String> _map = ListExtensions.<Attribute, String>map(dataClass.getAttributes(), _function);
      Iterables.<CharSequence>addAll(initList, _map);
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFieldInitializerList(final DataClass dataClass) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      ArrayList<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
      DataClass _base = dataClass.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        String _name = dataClass.getBase().getName();
        _builder.append(_name);
        _builder.append("(");
        final Function1<Attribute, String> _function = (Attribute it) -> {
          return it.getName();
        };
        String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(this._roomHelpers.getAllAttributes(dataClass.getBase()), _function), ", ");
        _builder.append(_join);
        _builder.append(")");
        initList.add(_builder.toString());
      }
      final Function1<Attribute, String> _function_1 = (Attribute it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(");
        String _name_2 = it.getName();
        _builder_1.append(_name_2);
        _builder_1.append(")");
        return _builder_1.toString();
      };
      List<String> _map = ListExtensions.<Attribute, String>map(dataClass.getAttributes(), _function_1);
      Iterables.<CharSequence>addAll(initList, _map);
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  public String deepCopy(final DataClass _dc) {
    String result = "";
    DataClass dc = _dc;
    while ((!Objects.equal(dc, null))) {
      {
        String _string = this.deepCopy(dc.getAttributes()).toString();
        String _plus = (_string + result);
        result = _plus;
        dc = dc.getBase();
      }
    }
    return result;
  }
  
  public CharSequence deepCopy(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute a : attributes) {
        {
          DataType _type = a.getType().getType();
          if ((_type instanceof ComplexType)) {
            _builder.append("if (");
            String _name = a.getName();
            _builder.append(_name);
            _builder.append("!=null) {");
            _builder.newLineIfNotEmpty();
            {
              int _size = a.getSize();
              boolean _equals = (_size == 0);
              if (_equals) {
                _builder.append("\t");
                _builder.append("copy.");
                String _name_1 = a.getName();
                _builder.append(_name_1, "\t");
                _builder.append(" = ");
                String _name_2 = a.getName();
                _builder.append(_name_2, "\t");
                _builder.append(".deepCopy();");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("for (int i=0;i<");
                String _name_3 = a.getName();
                _builder.append(_name_3, "\t");
                _builder.append(".length;i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("copy.");
                String _name_4 = a.getName();
                _builder.append(_name_4, "\t\t");
                _builder.append("[i] = ");
                String _name_5 = a.getName();
                _builder.append(_name_5, "\t\t");
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
                _builder.append(_name_6);
                _builder.append(" = ");
                String _name_7 = a.getName();
                _builder.append(_name_7);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("for (int i=0;i<");
                String _name_8 = a.getName();
                _builder.append(_name_8);
                _builder.append(".length;i++){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("copy.");
                String _name_9 = a.getName();
                _builder.append(_name_9, "\t");
                _builder.append("[i] = ");
                String _name_10 = a.getName();
                _builder.append(_name_10, "\t");
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
