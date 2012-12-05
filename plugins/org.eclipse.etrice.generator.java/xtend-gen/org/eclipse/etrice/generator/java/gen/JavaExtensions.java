package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class JavaExtensions implements ILanguageExtension {
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String[] _generateArglistAndTypedData = this.generateArglistAndTypedData(_data);
    String _get = ((List<String>)Conversions.doWrapArray(_generateArglistAndTypedData)).get(1);
    return _get;
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".java");
    return _plus;
  }
  
  public String toWrapper(final String type) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type,"int")) {
        _matched=true;
        _switchResult = "Integer";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"char")) {
        _matched=true;
        _switchResult = "Character";
      }
    }
    if (!_matched) {
      String _firstUpper = StringExtensions.toFirstUpper(type);
      _switchResult = _firstUpper;
    }
    return _switchResult;
  }
  
  public String accessLevelPrivate() {
    return "private ";
  }
  
  public String accessLevelProtected() {
    return "protected ";
  }
  
  public String accessLevelPublic() {
    return "public ";
  }
  
  public String memberAccess() {
    return "this.";
  }
  
  public String selfPointer(final String classname, final boolean hasArgs) {
    return "";
  }
  
  public String selfPointer(final boolean hasArgs) {
    return "";
  }
  
  public String operationScope(final String classname, final boolean isDeclaration) {
    return "";
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    return member;
  }
  
  public String memberInUse(final String namespace, final String member) {
    String _plus = (namespace + ".");
    return (_plus + member);
  }
  
  public boolean usesInheritance() {
    return true;
  }
  
  public boolean usesPointers() {
    return false;
  }
  
  public String genEnumeration(final String name, final List<Pair<String,String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Pair<String,String> entry : entries) {
        _builder.append("public static final int ");
        String _first = entry.getFirst();
        _builder.append(_first, "");
        _builder.append(" = ");
        String _second = entry.getSecond();
        _builder.append(_second, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  public String booleanConstant(final boolean b) {
    String _string = Boolean.valueOf(b).toString();
    return _string;
  }
  
  public String pointerLiteral() {
    return "";
  }
  
  public String nullPointer() {
    return "null";
  }
  
  public String voidPointer() {
    return "Object";
  }
  
  public String arrayDeclaration(final String type, final int size, final String name, final boolean isRef) {
    String _plus = (type + " ");
    String _plus_1 = (_plus + name);
    String _plus_2 = (_plus_1 + "[]");
    return _plus_2;
  }
  
  public String constructorName(final String cls) {
    return cls;
  }
  
  public String destructorName(final String cls) {
    String _plus = (cls + "_dtor");
    return _plus;
  }
  
  public String constructorReturnType() {
    return "";
  }
  
  public String destructorReturnType() {
    return "void";
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    String _plus = ("super." + method);
    String _plus_1 = (_plus + "(");
    String _plus_2 = (_plus_1 + args);
    String _plus_3 = (_plus_2 + ");");
    return _plus_3;
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    String _switchResult = null;
    String _targetName = type.getTargetName();
    final String _switchValue = _targetName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        String _castValue = this.castValue(type, value);
        _switchResult = _castValue;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"string")) {
        _matched=true;
        String _castValue_1 = this.castValue(type, value);
        _switchResult = _castValue_1;
      }
    }
    if (!_matched) {
      boolean _contains = value.contains(",");
      if (_contains) {
        _matched=true;
        String _xblockexpression = null;
        {
          String _replace = value.replace("{", "");
          String _replace_1 = _replace.replace("}", "");
          String _trim = _replace_1.trim();
          String[] singleValues = _trim.split(",");
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{ ");
          {
            boolean _hasElements = false;
            for(final String v : singleValues) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(", ", "");
              }
              String _trim_1 = v.trim();
              String _castValue_2 = this.castValue(type, _trim_1);
              _builder.append(_castValue_2, "");
            }
          }
          _builder.append(" }");
          String _string = _builder.toString();
          _xblockexpression = (_string);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      String _castValue_2 = this.castValue(type, value);
      _switchResult = _castValue_2;
    }
    return _switchResult;
  }
  
  private String castValue(final PrimitiveType type, final String value) {
    String _targetName = type.getTargetName();
    final String _switchValue = _targetName;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"boolean")) {
        _matched=true;
        return value;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        return ("(byte)" + value);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"short")) {
        _matched=true;
        return ("(short)" + value);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"int")) {
        _matched=true;
        return value;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"long")) {
        _matched=true;
        return (value + "L");
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        return (value + "f");
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"double")) {
        _matched=true;
        return (value + "d");
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        int _length = value.length();
        boolean _equals = (_length == 1);
        if (_equals) {
          String _plus = ("\'" + value);
          return (_plus + "\'");
        } else {
          String _replace = value.replace("\\", "\\\\");
          String _replace_1 = _replace.replace("\"", "\\\"");
          String _plus_1 = ("\"" + _replace_1);
          return (_plus_1 + "\".toCharArray()");
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"String")) {
        _matched=true;
        String _replace_2 = value.replace("\\", "\\\\");
        String _replace_3 = _replace_2.replace("\"", "\\\"");
        String _plus_2 = ("\"" + _replace_3);
        return (_plus_2 + "\"");
      }
    }
    String _targetName_1 = type.getTargetName();
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_targetName_1);
    throw _unsupportedOperationException;
  }
  
  public String defaultValue(final DataType dt) {
    if ((dt instanceof PrimitiveType)) {
      return ((PrimitiveType) dt).getDefaultValueLiteral();
    } else {
      if ((dt instanceof ExternalType)) {
        String _targetName = ((ExternalType) dt).getTargetName();
        String _plus = ("new " + _targetName);
        return (_plus + "()");
      } else {
        String _name = dt.getName();
        String _plus_1 = ("new " + _name);
        return (_plus_1 + "()");
      }
    }
  }
  
  public String initializationWithDefaultValues(final DataType dt, final int size) {
    String _xblockexpression = null;
    {
      final String dv = this.defaultValue(dt);
      String _xifexpression = null;
      boolean _greaterThan = (size > 1);
      if (_greaterThan) {
        String _xblockexpression_1 = null;
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
          _xblockexpression_1 = (_plus);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = dv;
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
    RefableType _refType = data.getRefType();
    DataType _type = _refType.getType();
    String typeName = _type.getName();
    String castTypeName = typeName;
    RefableType _refType_1 = data.getRefType();
    DataType _type_1 = _refType_1.getType();
    if ((_type_1 instanceof PrimitiveType)) {
      RefableType _refType_2 = data.getRefType();
      DataType _type_2 = _refType_2.getType();
      String _targetName = ((PrimitiveType) _type_2).getTargetName();
      typeName = _targetName;
      RefableType _refType_3 = data.getRefType();
      DataType _type_3 = _refType_3.getType();
      final String ct = ((PrimitiveType) _type_3).getCastName();
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
        castTypeName = ct;
      }
    }
    String _plus = (typeName + " ");
    String _name = data.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + " = (");
    String _plus_3 = (_plus_2 + castTypeName);
    final String typedData = (_plus_3 + ") generic_data;\n");
    String _name_1 = data.getName();
    final String dataArg = (", " + _name_1);
    String _plus_4 = (", " + typeName);
    String _plus_5 = (_plus_4 + " ");
    String _name_2 = data.getName();
    final String typedArgList = (_plus_5 + _name_2);
    return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(dataArg, typedData, typedArgList), String.class));
  }
}
