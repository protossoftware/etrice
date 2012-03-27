package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class DataClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private TypeHelpers typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(dc);
        String _path = this.roomExt.getPath(dc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _javaFileName = this.stdExt.getJavaFileName(dc);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating DataClass implementation \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generate = this.generate(root, dc);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final DataClass dc) {
    StringConcatenation _xblockexpression = null;
    {
      EList<StandardOperation> _operations = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isConstructor = RoomHelpers.isConstructor(op);
            return ((Boolean)_isConstructor);
          }
        };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      StandardOperation _head = IterableExtensions.<StandardOperation>head(_filter);
      final StandardOperation ctor = _head;
      EList<StandardOperation> _operations_1 = dc.getOperations();
      final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isDestructor = op.isDestructor();
            return ((Boolean)_isDestructor);
          }
        };
      Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
      StandardOperation _head_1 = IterableExtensions.<StandardOperation>head(_filter_1);
      final StandardOperation dtor = _head_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this.roomExt.getPackage(dc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      EList<RoomModel> _referencedModels = root.getReferencedModels(dc);
      EList<RoomModel> models = _referencedModels;
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
      DetailCode _userCode1 = dc.getUserCode1();
      StringConcatenation _userCode = this.helpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _name_1 = dc.getName();
      _builder.append(_name_1, "");
      {
        DataClass _base = dc.getBase();
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_base, null);
        if (_operator_notEquals) {
          _builder.append(" extends ");
          DataClass _base_1 = dc.getBase();
          String _name_2 = _base_1.getName();
          _builder.append(_name_2, "");
        }
      }
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      DetailCode _userCode2 = dc.getUserCode2();
      StringConcatenation _userCode_1 = this.helpers.userCode(_userCode2);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes = dc.getAttributes();
      StringConcatenation _attributes_1 = this.helpers.attributes(_attributes);
      _builder.append(_attributes_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes_2 = dc.getAttributes();
      String _name_3 = dc.getName();
      StringConcatenation _attributeSettersGettersImplementation = this.helpers.attributeSettersGettersImplementation(_attributes_2, _name_3);
      _builder.append(_attributeSettersGettersImplementation, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<StandardOperation> _operations_2 = dc.getOperations();
      String _name_4 = dc.getName();
      StringConcatenation _operationsImplementation = this.helpers.operationsImplementation(_operations_2, _name_4);
      _builder.append(_operationsImplementation, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// default constructor");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_5 = dc.getName();
      _builder.append(_name_5, "	");
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      EList<Attribute> _attributes_3 = dc.getAttributes();
      StringConcatenation _attributeInitialization = this.helpers.attributeInitialization(_attributes_3, true);
      _builder.append(_attributeInitialization, "		");
      _builder.newLineIfNotEmpty();
      {
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(ctor, null);
        if (_operator_notEquals_1) {
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
            EList<String> _commands = _detailCode.getCommands();
            for(final String l : _commands) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append(l, "			");
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
      String _name_6 = dc.getName();
      _builder.append(_name_6, "	");
      _builder.append("(");
      String _argList = this.argList(dc);
      _builder.append(_argList, "	");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        DataClass _base_2 = dc.getBase();
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_base_2, null);
        if (_operator_notEquals_2) {
          _builder.append("\t\t");
          _builder.append("super(");
          DataClass _base_3 = dc.getBase();
          String _paramList = this.paramList(_base_3);
          _builder.append(_paramList, "		");
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
          String _name_7 = a.getName();
          _builder.append(_name_7, "		");
          _builder.append(" = ");
          String _name_8 = a.getName();
          _builder.append(_name_8, "		");
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
      String _name_9 = dc.getName();
      _builder.append(_name_9, "	");
      _builder.append(" deepCopy() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _name_10 = dc.getName();
      _builder.append(_name_10, "		");
      _builder.append(" copy = new ");
      String _name_11 = dc.getName();
      _builder.append(_name_11, "		");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _deepCopy = this.deepCopy(dc);
      _builder.append(_deepCopy, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return copy;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public String paramList(final DataClass _dc) {
      String result = "";
      DataClass dc = _dc;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      Boolean _xwhileexpression = _operator_notEquals;
      while (_xwhileexpression) {
        {
          EList<Attribute> _attributes = dc.getAttributes();
          StringConcatenation _paramList = this.paramList(_attributes);
          String _string = _paramList.toString();
          String _operator_plus = StringExtensions.operator_plus(_string, result);
          result = _operator_plus;
          DataClass _base = dc.getBase();
          dc = _base;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(dc, null);
          if (_operator_notEquals_1) {
            String _operator_plus_1 = StringExtensions.operator_plus(", ", result);
            result = _operator_plus_1;
          }
        }
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(dc, null);
        _xwhileexpression = _operator_notEquals_2;
      }
      return result;
  }
  
  public StringConcatenation paramList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean hasAnyElements = false;
      for(final Attribute a : attributes) {
        if (!hasAnyElements) {
          hasAnyElements = true;
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
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      Boolean _xwhileexpression = _operator_notEquals;
      while (_xwhileexpression) {
        {
          EList<Attribute> _attributes = dc.getAttributes();
          StringConcatenation _argList = this.helpers.argList(_attributes);
          String _string = _argList.toString();
          String _operator_plus = StringExtensions.operator_plus(_string, result);
          result = _operator_plus;
          DataClass _base = dc.getBase();
          dc = _base;
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(dc, null);
          if (_operator_notEquals_1) {
            String _operator_plus_1 = StringExtensions.operator_plus(", ", result);
            result = _operator_plus_1;
          }
        }
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(dc, null);
        _xwhileexpression = _operator_notEquals_2;
      }
      return result;
  }
  
  public String deepCopy(final DataClass _dc) {
      String result = "";
      DataClass dc = _dc;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(dc, null);
      Boolean _xwhileexpression = _operator_notEquals;
      while (_xwhileexpression) {
        {
          EList<Attribute> _attributes = dc.getAttributes();
          StringConcatenation _deepCopy = this.deepCopy(_attributes);
          String _string = _deepCopy.toString();
          String _operator_plus = StringExtensions.operator_plus(_string, result);
          result = _operator_plus;
          DataClass _base = dc.getBase();
          dc = _base;
        }
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(dc, null);
        _xwhileexpression = _operator_notEquals_1;
      }
      return result;
  }
  
  public StringConcatenation deepCopy(final List<Attribute> attributes) {
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
              boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)0));
              if (_operator_equals) {
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
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_size_1), ((Integer)0));
              if (_operator_equals_1) {
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
