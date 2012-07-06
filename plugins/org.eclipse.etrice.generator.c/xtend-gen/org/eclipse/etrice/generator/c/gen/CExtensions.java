package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class CExtensions implements ILanguageExtension {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    String _generateTypedData = this.chainGenerator.generateTypedData(_data);
    return _generateTypedData;
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
    String _operator_plus = StringExtensions.operator_plus(classname, _xifexpression);
    return _operator_plus;
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
    String _operator_plus = StringExtensions.operator_plus(classname, "_");
    return _operator_plus;
  }
  
  public String memberInDeclaration(final String namespace, final String member) {
    String _operator_plus = StringExtensions.operator_plus(namespace, "_");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, member);
    return _operator_plus_1;
  }
  
  public String memberInUse(final String namespace, final String member) {
    String _operator_plus = StringExtensions.operator_plus(namespace, "_");
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, member);
    return _operator_plus_1;
  }
  
  /**
   * TODO: move specific code elsewhere
   */
  public String getCHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".h");
    return _operator_plus;
  }
  
  public String getCSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ".c");
    return _operator_plus;
  }
  
  public String getInstSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, "_Inst.h");
    return _operator_plus;
  }
  
  public String getDispSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, "_Disp.h");
    return _operator_plus;
  }
  
  public StringConcatenation getIncludeGuardString(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_");
    String _upperCase = filename.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_H_");
    return _builder;
  }
  
  public StringConcatenation generateIncludeGuardBegin(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    StringConcatenation _includeGuardString = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString, "");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    StringConcatenation _includeGuardString_1 = this.getIncludeGuardString(filename);
    _builder.append(_includeGuardString_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation generateIncludeGuardEnd(final String filename) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    StringConcatenation _includeGuardString = this.getIncludeGuardString(filename);
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
        boolean hasAnyElements = false;
        for(final Pair<String,String> entry : entries) {
          if (!hasAnyElements) {
            hasAnyElements = true;
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
      String _operator_plus = StringExtensions.operator_plus(type, "* ");
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, name);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "[");
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ((Integer)size));
      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "]");
      _xifexpression = _operator_plus_4;
    } else {
      String _operator_plus_5 = StringExtensions.operator_plus(type, " ");
      String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, name);
      String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, "[");
      String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, ((Integer)size));
      String _operator_plus_9 = StringExtensions.operator_plus(_operator_plus_8, "]");
      _xifexpression = _operator_plus_9;
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
  
  public String toCharArrayExpr(final String s) {
    String _operator_plus = StringExtensions.operator_plus("\"", s);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\"");
    return _operator_plus_1;
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    return "";
  }
}
