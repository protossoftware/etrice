package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ConfigExtension;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@Singleton
@SuppressWarnings("all")
public class CppExtensions implements ILanguageExtension {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  @Inject
  private ILanguageExtension languageExt;
  
  @Inject
  private ConfigExtension _configExtension;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    return this.chainGenerator.generateTypedData(_data);
  }
  
  public String getCppHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".h");
    return _plus;
  }
  
  public String getCppSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".cpp");
    return _plus;
  }
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "_Inst.h");
    return _plus;
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + "_Disp.h");
    return _plus;
  }
  
  public String accessLevelPrivate() {
    return "";
  }
  
  public String accessLevelProtected() {
    return "";
  }
  
  public String accessLevelPublic() {
    return "";
  }
  
  public String memberAccess() {
    return "this->";
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
  
  public String genEnumeration(final String name, final List<Pair<String,String>> entries) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef enum {");
    _builder.newLine();
    {
      for(final Pair<String,String> entry : entries) {
        String _first = entry.getFirst();
        _builder.append(_first, "");
        _builder.append(" = ");
        String _second = entry.getSecond();
        _builder.append(_second, "");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    _builder.append(name, "");
    _builder.append(";");
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
    return "0";
  }
  
  public String voidPointer() {
    return "void*";
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
  
  public CharSequence getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _replaceAll = filename.replaceAll("\\/.", "_");
    String _upperCase = _replaceAll.toUpperCase();
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
  
  public String superCall(final String baseClassName, final String method, final String arguments) {
    String _plus = (baseClassName + "::");
    String _plus_1 = (_plus + method);
    String _plus_2 = (_plus_1 + "(");
    String _plus_3 = (_plus_2 + arguments);
    String _plus_4 = (_plus_3 + ");");
    return _plus_4;
  }
  
  public String toCharArrayExpr(final String s) {
    String _plus = ("\"" + s);
    String _plus_1 = (_plus + "\"");
    return _plus_1;
  }
  
  public CharSequence attributeConstructorInitList(final List<Attribute> attribs, final boolean useClassDefaultsOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// initialize attributes");
    _builder.newLine();
    {
      for(final Attribute a : attribs) {
        String value = this._configExtension.getInitValue(a);
        _builder.newLineIfNotEmpty();
        {
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            {
              boolean _isArray = this._configExtension.isArray(a);
              boolean _not = (!_isArray);
              if (_not) {
                String _name = a.getName();
                _builder.append(_name, "");
                _builder.append(" ( ");
                _builder.append(value, "");
                _builder.append(" ),");
                _builder.newLineIfNotEmpty();
              } else {
                String _name_1 = a.getName();
                _builder.append(_name_1, "");
                _builder.append(" ( {");
                _builder.newLineIfNotEmpty();
                {
                  int _size = a.getSize();
                  IntegerRange _upTo = new IntegerRange(0, _size);
                  for(final Integer i : _upTo) {
                    _builder.append("value,");
                    _builder.newLine();
                  }
                }
                _builder.append("} )");
                _builder.newLine();
              }
            }
          } else {
            boolean _or = false;
            boolean _or_1 = false;
            RefableType _refType = a.getRefType();
            DataType _type = _refType.getType();
            if ((_type instanceof ComplexType)) {
              _or_1 = true;
            } else {
              int _size_1 = a.getSize();
              boolean _greaterThan = (_size_1 > 1);
              _or_1 = ((_type instanceof ComplexType) || _greaterThan);
            }
            if (_or_1) {
              _or = true;
            } else {
              boolean _not_1 = (!useClassDefaultsOnly);
              _or = (_or_1 || _not_1);
            }
            if (_or) {
              {
                int _size_2 = a.getSize();
                boolean _equals = (_size_2 == 0);
                if (_equals) {
                  {
                    RefableType _refType_1 = a.getRefType();
                    boolean _isRef = _refType_1.isRef();
                    if (_isRef) {
                      String _name_2 = a.getName();
                      _builder.append(_name_2, "");
                      _builder.append(" ( ");
                      String _nullPointer = this.languageExt.nullPointer();
                      _builder.append(_nullPointer, "");
                      _builder.append(" ),");
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _name_3 = a.getName();
                      _builder.append(_name_3, "");
                      _builder.append(" ( ");
                      RefableType _refType_2 = a.getRefType();
                      DataType _type_1 = _refType_2.getType();
                      String _defaultValue = this._typeHelpers.defaultValue(_type_1);
                      _builder.append(_defaultValue, "");
                      _builder.append(" ),");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  String _name_4 = a.getName();
                  _builder.append(_name_4, "");
                  _builder.append(" ( new ");
                  RefableType _refType_3 = a.getRefType();
                  DataType _type_2 = _refType_3.getType();
                  String _typeName = this._typeHelpers.typeName(_type_2);
                  _builder.append(_typeName, "");
                  _builder.append("[");
                  int _size_3 = a.getSize();
                  _builder.append(_size_3, "");
                  _builder.append("] ),");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _not_2 = (!useClassDefaultsOnly);
                    if (_not_2) {
                      _builder.append("for (int i=0;i<");
                      int _size_4 = a.getSize();
                      _builder.append(_size_4, "");
                      _builder.append(";i++){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      String _name_5 = a.getName();
                      _builder.append(_name_5, "	");
                      _builder.append("[i] = ");
                      {
                        RefableType _refType_4 = a.getRefType();
                        boolean _isRef_1 = _refType_4.isRef();
                        if (_isRef_1) {
                          String _nullPointer_1 = this.languageExt.nullPointer();
                          _builder.append(_nullPointer_1, "	");
                        } else {
                          RefableType _refType_5 = a.getRefType();
                          DataType _type_3 = _refType_5.getType();
                          String _defaultValue_1 = this._typeHelpers.defaultValue(_type_3);
                          _builder.append(_defaultValue_1, "	");
                        }
                      }
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
}
