/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class DataClassGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private Initialization _initialization;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    final Function1<DataClass, Boolean> _function = new Function1<DataClass, Boolean>() {
      public Boolean apply(final DataClass cl) {
        return Boolean.valueOf(DataClassGen.this._fileSystemHelpers.isValidGenerationLocation(cl));
      }
    };
    Iterable<DataClass> _filter = IterableExtensions.<DataClass>filter(_usedDataClasses, _function);
    for (final DataClass dc : _filter) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(dc);
        String _path = this._roomExtensions.getPath(dc);
        String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(dc);
        String _path_1 = this._roomExtensions.getPath(dc);
        String infopath = (_generationInfoPath + _path_1);
        String file = this._javaExtensions.getJavaFileName(dc);
        CharSequence _generate = this.generate(root, dc);
        this.fileIO.generateFile("generating DataClass implementation", path, infopath, file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final DataClass dc) {
    CharSequence _xblockexpression = null;
    {
      EList<StandardOperation> _operations = dc.getOperations();
      final Function1<StandardOperation, Boolean> _function = new Function1<StandardOperation, Boolean>() {
        public Boolean apply(final StandardOperation op) {
          return Boolean.valueOf(DataClassGen.this._roomHelpers.isConstructor(op));
        }
      };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(dc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
      _builder.newLine();
      _builder.append("import java.io.Serializable;");
      _builder.newLine();
      _builder.newLine();
      EList<RoomModel> models = root.getReferencedModels(dc);
      _builder.newLineIfNotEmpty();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(dc, 1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _name_1 = dc.getName();
      _builder.append(_name_1, "");
      {
        DataClass _base = dc.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          _builder.append(" extends ");
          DataClass _base_1 = dc.getBase();
          String _name_2 = _base_1.getName();
          _builder.append(_name_2, "");
        }
      }
      _builder.append(" implements Serializable {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final long serialVersionUID = ");
      String _package_1 = this._roomExtensions.getPackage(dc);
      String _name_3 = dc.getName();
      String _plus = (_package_1 + _name_3);
      int _hashCode = _plus.hashCode();
      _builder.append(_hashCode, "\t");
      _builder.append("L;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(dc, 2);
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes = dc.getAttributes();
      CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
      _builder.append(_attributes_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes_2 = dc.getAttributes();
      String _name_4 = dc.getName();
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_attributes_2, _name_4);
      _builder.append(_attributeSettersGettersImplementation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<StandardOperation> _operations_1 = dc.getOperations();
      String _name_5 = dc.getName();
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(_operations_1, _name_5);
      _builder.append(_operationsImplementation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// default constructor");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_6 = dc.getName();
      _builder.append(_name_6, "\t");
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      EList<Attribute> _attributes_3 = dc.getAttributes();
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes_3, dc, true);
      _builder.append(_attributeInitialization, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals_1 = (!Objects.equal(ctor, null));
        if (_notEquals_1) {
          _builder.append("\t\t");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("// user defined constructor body");
          _builder.newLine();
          {
            DetailCode _detailCode = ctor.getDetailCode();
            EList<String> _lines = _detailCode.getLines();
            for(final String l : _lines) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append(l, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// constructor using fields");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_7 = dc.getName();
      _builder.append(_name_7, "\t");
      _builder.append("(");
      String _argList = this.argList(dc);
      _builder.append(_argList, "\t");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        DataClass _base_2 = dc.getBase();
        boolean _notEquals_2 = (!Objects.equal(_base_2, null));
        if (_notEquals_2) {
          _builder.append("\t\t");
          _builder.append("super(");
          DataClass _base_3 = dc.getBase();
          String _paramList = this.paramList(_base_3);
          _builder.append(_paramList, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t\t");
          _builder.append("super();");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        EList<Attribute> _attributes_4 = dc.getAttributes();
        for(final Attribute a : _attributes_4) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _name_8 = a.getName();
          _builder.append(_name_8, "\t\t");
          _builder.append(" = ");
          String _name_9 = a.getName();
          _builder.append(_name_9, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// deep copy");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_10 = dc.getName();
      _builder.append(_name_10, "\t");
      _builder.append(" deepCopy() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _name_11 = dc.getName();
      _builder.append(_name_11, "\t\t");
      _builder.append(" copy = new ");
      String _name_12 = dc.getName();
      _builder.append(_name_12, "\t\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _deepCopy = this.deepCopy(dc);
      _builder.append(_deepCopy, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return copy;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
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
          result = (", " + result);
        }
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  private CharSequence paramList(final List<Attribute> attributes) {
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
        CharSequence _argList = this._procedureHelpers.argList(_attributes);
        String _string = _argList.toString();
        String _plus = (_string + result);
        result = _plus;
        DataClass _base = dc.getBase();
        dc = _base;
        boolean _notEquals_1 = (!Objects.equal(dc, null));
        if (_notEquals_1) {
          result = (", " + result);
        }
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  private String deepCopy(final DataClass _dc) {
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
  
  private CharSequence deepCopy(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute a : attributes) {
        {
          RefableType _type = a.getType();
          boolean _isRef = _type.isRef();
          if (_isRef) {
            _builder.append("copy.");
            String _name = a.getName();
            _builder.append(_name, "");
            _builder.append(" = ");
            String _name_1 = a.getName();
            _builder.append(_name_1, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            RefableType _type_1 = a.getType();
            DataType _type_2 = _type_1.getType();
            if ((_type_2 instanceof ComplexType)) {
              _builder.append("if (");
              String _name_2 = a.getName();
              _builder.append(_name_2, "");
              _builder.append("!=null) {");
              _builder.newLineIfNotEmpty();
              {
                int _size = a.getSize();
                boolean _lessEqualsThan = (_size <= 1);
                if (_lessEqualsThan) {
                  _builder.append("\t");
                  _builder.append("copy.");
                  String _name_3 = a.getName();
                  _builder.append(_name_3, "\t");
                  _builder.append(" = ");
                  String _name_4 = a.getName();
                  _builder.append(_name_4, "\t");
                  _builder.append(".deepCopy();");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t");
                  _builder.append("for (int i=0;i<");
                  String _name_5 = a.getName();
                  _builder.append(_name_5, "\t");
                  _builder.append(".length;i++){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("copy.");
                  String _name_6 = a.getName();
                  _builder.append(_name_6, "\t\t");
                  _builder.append("[i] = ");
                  String _name_7 = a.getName();
                  _builder.append(_name_7, "\t\t");
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
                boolean _equals = (_size_1 == 0);
                if (_equals) {
                  _builder.append("copy.");
                  String _name_8 = a.getName();
                  _builder.append(_name_8, "");
                  _builder.append(" = ");
                  String _name_9 = a.getName();
                  _builder.append(_name_9, "");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("for (int i=0;i<");
                  String _name_10 = a.getName();
                  _builder.append(_name_10, "");
                  _builder.append(".length;i++){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("copy.");
                  String _name_11 = a.getName();
                  _builder.append(_name_11, "\t");
                  _builder.append("[i] = ");
                  String _name_12 = a.getName();
                  _builder.append(_name_12, "\t");
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
    }
    return _builder;
  }
}
