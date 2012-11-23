package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

@Singleton
@SuppressWarnings("all")
public class CExtensions implements ILanguageExtension {
  @Inject
  private IDiagnostician diagnostician;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String[] _generateArglistAndTypedData = this.generateArglistAndTypedData(_data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(1);
    return _get;
  }
  
  public String accessLevelPrivate() {
    return "static ";
  }
  
  public String accessLevelProtected() {
    return "static ";
  }
  
  public String accessLevelPublic() {
    return "";
  }
  
  public String memberAccess() {
    return "self->";
  }
  
  public String selfPointer(final String classname, final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "* self, ";
    } else {
      _xifexpression = "* self";
    }
    String _plus = (classname + _xifexpression);
    return _plus;
  }
  
  public String selfPointer(final boolean hasArgs) {
    String _xifexpression = null;
    if (hasArgs) {
      _xifexpression = "self, ";
    } else {
      _xifexpression = "self";
    }
    return _xifexpression;
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    String _plus = (classname + "_");
    return _plus;
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    String _plus = (namespace + "_");
    return (_plus + member);
  }
  
  public String memberInUse(final String namespace, final String member) {
    String _plus = (namespace + "_");
    return (_plus + member);
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
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Inst.h");
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + "_Disp.h");
  }
  
  public CharSequence getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _upperCase = filename.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_H_");
    return _builder;
  }
  
  public CharSequence generateIncludeGuardBegin(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    CharSequence _includeGuardString_1 = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateIncludeGuardEnd(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    CharSequence _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean usesInheritance() {
    return false;
  }
  
  public String genEnumeration(final String name, final List<Pair<String,String>> entries) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = entries.isEmpty();
      if (_isEmpty) {
        return "/* empty enum not generated */";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum ");
      _builder.append(name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements = false;
        for(final Pair<String,String> entry : entries) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "	");
          }
          _builder.append("\t");
          String _first = entry.getFirst();
          _builder.append(_first, "	");
          _builder.append(" = ");
          String _second = entry.getSecond();
          _builder.append(_second, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLine();
      String _string = _builder.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public String booleanConstant(final boolean b) {
    String _xifexpression = null;
    if (b) {
      _xifexpression = "TRUE";
    } else {
      _xifexpression = "FALSE";
    }
    return _xifexpression;
  }
  
  public String pointerLiteral() {
    return "*";
  }
  
  public String nullPointer() {
    return "NULL";
  }
  
  public String voidPointer() {
    return "void*";
  }
  
  public String arrayDeclaration(final String type, final int size, final String name, final boolean isRef) {
    String _xifexpression = null;
    if (isRef) {
      String _plus = (type + "* ");
      String _plus_1 = (_plus + name);
      String _plus_2 = (_plus_1 + "[");
      String _plus_3 = (_plus_2 + Integer.valueOf(size));
      String _plus_4 = (_plus_3 + "]");
      _xifexpression = _plus_4;
    } else {
      String _plus_5 = (type + " ");
      String _plus_6 = (_plus_5 + name);
      String _plus_7 = (_plus_6 + "[");
      String _plus_8 = (_plus_7 + Integer.valueOf(size));
      String _plus_9 = (_plus_8 + "]");
      _xifexpression = _plus_9;
    }
    return _xifexpression;
  }
  
  public String constructorName(final String cls) {
    return "ctor";
  }
  
  public String destructorName(final String cls) {
    return "dtor";
  }
  
  public String constructorReturnType() {
    return "void";
  }
  
  public String destructorReturnType() {
    return "void";
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    return "";
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    final String _switchValue = _targetName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        String _plus = ("\'" + value);
        String _plus_1 = (_plus + "\'");
        _switchResult = _plus_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"charPtr")) {
        _matched=true;
        String _plus_2 = ("\"" + value);
        String _plus_3 = (_plus_2 + "\"");
        _switchResult = _plus_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"stringPtr")) {
        _matched=true;
        String _plus_4 = ("\"" + value);
        String _plus_5 = (_plus_4 + "\"");
        _switchResult = _plus_5;
      }
    }
    if (!_matched) {
      _switchResult = value;
    }
    return _switchResult;
  }
  
  public String defaultValue(final DataType dt) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (dt instanceof PrimitiveType) {
        final PrimitiveType _primitiveType = (PrimitiveType)dt;
        _matched=true;
        String _defaultValueLiteral = _primitiveType.getDefaultValueLiteral();
        String _valueLiteral = this.toValueLiteral(_primitiveType, _defaultValueLiteral);
        _switchResult = _valueLiteral;
      }
    }
    if (!_matched) {
      if (dt instanceof ExternalType) {
        final ExternalType _externalType = (ExternalType)dt;
        _matched=true;
        String _xblockexpression = null;
        {
          String _defaultValueLiteral = _externalType.getDefaultValueLiteral();
          boolean _notEquals = (!Objects.equal(_defaultValueLiteral, null));
          if (_notEquals) {
            return _externalType.getDefaultValueLiteral();
          }
          String _name = _externalType.getName();
          String _plus = ("cannot initialize external type " + _name);
          EObject _eContainer = _externalType.eContainer();
          EStructuralFeature _eContainingFeature = _externalType.eContainingFeature();
          this.diagnostician.error(_plus, _eContainer, _eContainingFeature);
          String _name_1 = _externalType.getName();
          String _plus_1 = ("cannot instantiate external data type " + _name_1);
          _xblockexpression = (_plus_1);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (dt instanceof DataClass) {
        final DataClass _dataClass = (DataClass)dt;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        {
          List<Attribute> _allAttributes = this._roomExtensions.getAllAttributes(_dataClass);
          boolean _hasElements = false;
          for(final Attribute att : _allAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "	");
            }
            _builder.append("\t");
            String _initializationWithDefaultValues = this.initializationWithDefaultValues(att);
            _builder.append(_initializationWithDefaultValues, "	");
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
  
  public String initializationWithDefaultValues(final DataType dt, final int size) {
    String _xblockexpression = null;
    {
      final String dv = this.defaultValue(dt);
      String _initializer = this.initializer(dv, size);
      _xblockexpression = (_initializer);
    }
    return _xblockexpression;
  }
  
  private String initializer(final String dv, final int size) {
    String _xifexpression = null;
    boolean _greaterThan = (size > 1);
    if (_greaterThan) {
      String _xblockexpression = null;
      {
        String res = "{";
        int i = 0;
        boolean _lessThan = (i < size);
        boolean _while = _lessThan;
        while (_while) {
          {
            String _plus = (res + dv);
            res = _plus;
            int _plus_1 = (i + 1);
            i = _plus_1;
            boolean _lessThan_1 = (i < size);
            if (_lessThan_1) {
              String _plus_2 = (res + ",");
              res = _plus_2;
            }
          }
          boolean _lessThan_1 = (i < size);
          _while = _lessThan_1;
        }
        String _plus = (res + "}");
        _xblockexpression = (_plus);
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
          int _size = att.getSize();
          String _initializer = this.initializer(dv, _size);
          _xifexpression_1 = _initializer;
        }
        _xifexpression = _xifexpression_1;
      } else {
        String _xifexpression_2 = null;
        RefableType _refType = att.getRefType();
        boolean _isRef = _refType.isRef();
        if (_isRef) {
          int _size_1 = att.getSize();
          String _initializer_1 = this.initializer("NULL", _size_1);
          _xifexpression_2 = _initializer_1;
        } else {
          RefableType _refType_1 = att.getRefType();
          DataType _type = _refType_1.getType();
          int _size_2 = att.getSize();
          String _initializationWithDefaultValues = this.initializationWithDefaultValues(_type, _size_2);
          _xifexpression_2 = _initializationWithDefaultValues;
        }
        _xifexpression = _xifexpression_2;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String[] generateArglistAndTypedData(final VarDecl data) {
    boolean _equals = Objects.equal(data, null);
    if (_equals) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    String _xifexpression = null;
    RefableType _refType = data.getRefType();
    DataType _type = _refType.getType();
    if ((_type instanceof PrimitiveType)) {
      RefableType _refType_1 = data.getRefType();
      DataType _type_1 = _refType_1.getType();
      String _targetName = ((PrimitiveType) _type_1).getTargetName();
      _xifexpression = _targetName;
    } else {
      RefableType _refType_2 = data.getRefType();
      DataType _type_2 = _refType_2.getType();
      String _name = _type_2.getName();
      _xifexpression = _name;
    }
    String typeName = _xifexpression;
    String _xifexpression_1 = null;
    RefableType _refType_3 = data.getRefType();
    DataType _type_3 = _refType_3.getType();
    if ((_type_3 instanceof PrimitiveType)) {
      String _xblockexpression = null;
      {
        RefableType _refType_4 = data.getRefType();
        DataType _type_4 = _refType_4.getType();
        final String ct = ((PrimitiveType) _type_4).getCastName();
        String _xifexpression_2 = null;
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(ct, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _isEmpty = ct.isEmpty();
          boolean _not = (!_isEmpty);
          _and = (_notEquals && _not);
        }
        if (_and) {
          _xifexpression_2 = ct;
        } else {
          _xifexpression_2 = typeName;
        }
        _xblockexpression = (_xifexpression_2);
      }
      _xifexpression_1 = _xblockexpression;
    } else {
      _xifexpression_1 = typeName;
    }
    String castTypeName = _xifexpression_1;
    String _plus = (castTypeName + "*");
    castTypeName = _plus;
    String deRef = "*";
    RefableType _refType_4 = data.getRefType();
    final boolean isRef = _refType_4.isRef();
    RefableType _refType_5 = data.getRefType();
    DataType _type_4 = _refType_5.getType();
    final boolean isPrim = (_type_4 instanceof PrimitiveType);
    if (isRef) {
      String _plus_1 = (typeName + "*");
      typeName = _plus_1;
      String _plus_2 = (castTypeName + "*");
      castTypeName = _plus_2;
    } else {
      boolean _not = (!isPrim);
      if (_not) {
        String _plus_3 = (typeName + "*");
        typeName = _plus_3;
        deRef = "";
      }
    }
    String _plus_4 = (typeName + " ");
    String _name_1 = data.getName();
    String _plus_5 = (_plus_4 + _name_1);
    String _plus_6 = (_plus_5 + " = ");
    String _plus_7 = (_plus_6 + deRef);
    String _plus_8 = (_plus_7 + "((");
    String _plus_9 = (_plus_8 + castTypeName);
    final String typedData = (_plus_9 + ") generic_data);\n");
    String _name_2 = data.getName();
    final String dataArg = (", " + _name_2);
    String _plus_10 = (", " + typeName);
    String _plus_11 = (_plus_10 + " ");
    String _name_3 = data.getName();
    final String typedArgList = (_plus_11 + _name_3);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
}
