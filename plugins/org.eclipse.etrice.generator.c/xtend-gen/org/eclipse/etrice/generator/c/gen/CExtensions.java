package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;

@Singleton
@SuppressWarnings("all")
public class CExtensions implements ILanguageExtension {
  @Inject
  private AbstractTransitionChainGenerator chainGenerator;
  
  @Inject
  private IDiagnostician diagnostician;
  
  public String getTypedDataDefinition(final Message m) {
    VarDecl _data = m.getData();
    return this.chainGenerator.generateTypedData(_data);
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
  
  public String toCharArrayExpr(final String s) {
    String _plus = ("\"" + s);
    String _plus_1 = (_plus + "\"");
    return _plus_1;
  }
  
  public String superCall(final String baseClassName, final String method, final String args) {
    return "";
  }
  
  public String toValueLiteral(final PrimitiveType type, final String value) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO Config for C");
    throw _unsupportedOperationException;
  }
  
  public String defaultValue(final DataType dt) {
    String _xifexpression = null;
    if ((dt instanceof PrimitiveType)) {
      return ((PrimitiveType) dt).getDefaultValueLiteral();
    } else {
      String _xifexpression_1 = null;
      if ((dt instanceof ExternalType)) {
        String _name = dt.getName();
        String _plus = ("cannot initialize external type " + _name);
        EObject _eContainer = dt.eContainer();
        EStructuralFeature _eContainingFeature = dt.eContainingFeature();
        this.diagnostician.error(_plus, _eContainer, _eContainingFeature);
        String _name_1 = dt.getName();
        return ("cannot instantiate external data type " + _name_1);
      } else {
        String _xblockexpression = null;
        {
          final DataClass dc = ((DataClass) dt);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{");
          _builder.newLine();
          {
            EList<Attribute> _attributes = dc.getAttributes();
            boolean _hasElements = false;
            for(final Attribute att : _attributes) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              RefableType _refType = att.getRefType();
              DataType _type = _refType.getType();
              int _size = att.getSize();
              String _initializationWithDefaultValues = this.initializationWithDefaultValues(_type, _size);
              _builder.append(_initializationWithDefaultValues, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
          _xblockexpression = (_builder.toString());
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
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
}
