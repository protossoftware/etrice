package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class JavaExtensions implements ILanguageExtension {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String _generateTypedData = this.chainGenerator.generateTypedData(_data);
    return _generateTypedData;
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".java");
    return _operator_plus;
  }
  
  public String toWrapper(final String type) {
    String _switchResult = null;
    final String type_1 = type;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(type_1,"int")) {
        matched=true;
        _switchResult = "Integer";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(type_1,"char")) {
        matched=true;
        _switchResult = "Character";
      }
    }
    if (!matched) {
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
    String _operator_plus = StringExtensions.operator_plus(namespace, ".");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, member);
    return _operator_plus_1;
  }
  
  public boolean usesInheritance() {
    return true;
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
    String _string = ((Boolean)b).toString();
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
    String _operator_plus = StringExtensions.operator_plus(type, " ");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, name);
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "[]");
    return _operator_plus_2;
  }
  
  public String constructorName(final String cls) {
    return cls;
  }
  
  public String destructorName(final String cls) {
    String _operator_plus = StringExtensions.operator_plus(cls, "_dtor");
    return _operator_plus;
  }
  
  public String constructorReturnType() {
    return "";
  }
  
  public String destructorReturnType() {
    return "void";
  }
  
  public String toCharArrayExpr(final String s) {
    String _operator_plus = StringExtensions.operator_plus("\"", s);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\".toCharArray()");
    return _operator_plus_1;
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    String _operator_plus = StringExtensions.operator_plus("super.", method);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "(");
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, args);
    String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ");");
    return _operator_plus_3;
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
      String _targetName = type.getTargetName();
      final String __valOfSwitchOver = _targetName;
      boolean matched = false;
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"boolean")) {
          matched=true;
          return value;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"byte")) {
          matched=true;
          String _operator_plus = StringExtensions.operator_plus("(byte)", value);
          return _operator_plus;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"short")) {
          matched=true;
          String _operator_plus_1 = StringExtensions.operator_plus("(short)", value);
          return _operator_plus_1;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"int")) {
          matched=true;
          return value;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"long")) {
          matched=true;
          String _operator_plus_2 = StringExtensions.operator_plus(value, "L");
          return _operator_plus_2;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"float")) {
          matched=true;
          String _operator_plus_3 = StringExtensions.operator_plus(value, "f");
          return _operator_plus_3;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"double")) {
          matched=true;
          String _operator_plus_4 = StringExtensions.operator_plus(value, "d");
          return _operator_plus_4;
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"char")) {
          matched=true;
          {
            String _valueOf = String.valueOf(value);
            String string = _valueOf;
            int _length = string.length();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_length), ((Integer)1));
            if (_operator_equals) {
              String _operator_plus_5 = StringExtensions.operator_plus("\'", value);
              String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\'");
              return _operator_plus_6;
            } else {
              String _charArrayExpr = this.toCharArrayExpr(value);
              return _charArrayExpr;
            }
          }
        }
      }
      if (!matched) {
        if (ObjectExtensions.operator_equals(__valOfSwitchOver,"String")) {
          matched=true;
          String _operator_plus_7 = StringExtensions.operator_plus("\"", value);
          String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\"");
          return _operator_plus_8;
        }
      }
      String _targetName_1 = type.getTargetName();
      UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException(_targetName_1);
      throw _unsupportedOperationException;
  }
}
