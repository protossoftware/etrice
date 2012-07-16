package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;

@Singleton
@SuppressWarnings("all")
public class JavaExtensions implements ILanguageExtension {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    return this.chainGenerator.generateTypedData(_data);
  }
  
  public String getJavaFileName(final RoomClass rc) {
    String _name = rc.getName();
    String _plus = (_name + ".java");
    return _plus;
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
  
  public String toCharArrayExpr(final String s) {
    String _plus = ("\"" + s);
    String _plus_1 = (_plus + "\".toCharArray()");
    return _plus_1;
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    String _plus = ("super." + method);
    String _plus_1 = (_plus + "(");
    String _plus_2 = (_plus_1 + args);
    String _plus_3 = (_plus_2 + ");");
    return _plus_3;
  }
}
