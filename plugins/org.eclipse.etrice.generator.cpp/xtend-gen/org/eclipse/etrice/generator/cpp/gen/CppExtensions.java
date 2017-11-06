/**
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class CppExtensions implements ILanguageExtension {
  @Inject
  private IDiagnostician diagnostician;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Override
  public String getTypedDataDefinition(final EObject msg) {
    return this.generateArglistAndTypedData(((Message) msg).getData())[ILanguageExtensionBase.TypedDataKind.DECLARATION_AND_INITIALIZATION.ordinal()];
  }
  
  public String getCppHeaderFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".h");
  }
  
  public String getCppSourceFileName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".cpp");
  }
  
  public String getCppClassName(final NodeRef nr, final SubSystemInstance ssi) {
    String _name = nr.getName();
    String _plus = ("Node_" + _name);
    String _plus_1 = (_plus + "_");
    String _name_1 = ssi.getName();
    return (_plus_1 + _name_1);
  }
  
  public String getCppHeaderFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _cppClassName = this.getCppClassName(nr, ssi);
    return (_cppClassName + ".h");
  }
  
  public String getCppSourceFileName(final NodeRef nr, final SubSystemInstance ssi) {
    String _cppClassName = this.getCppClassName(nr, ssi);
    return (_cppClassName + ".cpp");
  }
  
  @Override
  public String accessLevelPrivate() {
    return "";
  }
  
  @Override
  public String accessLevelProtected() {
    return "";
  }
  
  @Override
  public String accessLevelPublic() {
    return "";
  }
  
  @Override
  public String memberAccess() {
    return "this->";
  }
  
  @Override
  public String selfPointer(final String classname, final boolean hasArgs) {
    return "";
  }
  
  @Override
  public String selfPointer(final boolean hasArgs) {
    return "";
  }
  
  @Override
  public String scopeSeparator() {
    return "::";
  }
  
  @Override
  public String operationScope(final String classname, final boolean isDeclaration) {
    String _xifexpression = null;
    if (isDeclaration) {
      _xifexpression = "";
    } else {
      _xifexpression = (classname + "::");
    }
    return _xifexpression;
  }
  
  @Override
  public String memberInDeclaration(final String namespace, final String member) {
    return member;
  }
  
  @Override
  public String memberInUse(final String namespace, final String member) {
    return ((namespace + ".") + member);
  }
  
  @Override
  public boolean usesInheritance() {
    return true;
  }
  
  @Override
  public boolean usesPointers() {
    return true;
  }
  
  @Override
  public String genEnumeration(final String name, final List<Pair<String, String>> entries) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = entries.isEmpty();
      if (_isEmpty) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("typedef enum {");
      _builder.newLine();
      {
        boolean _hasElements = false;
        for(final Pair<String, String> entry : entries) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t");
          }
          _builder.append("\t");
          String _first = entry.getFirst();
          _builder.append(_first, "\t");
          _builder.append(" = ");
          String _second = entry.getSecond();
          _builder.append(_second, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("} ");
      _builder.append(name);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  @Override
  public String booleanConstant(final boolean b) {
    return Boolean.valueOf(b).toString();
  }
  
  @Override
  public String pointerLiteral() {
    return "*";
  }
  
  @Override
  public String nullPointer() {
    return "0";
  }
  
  @Override
  public String voidPointer() {
    return "void*";
  }
  
  @Override
  public String arrayType(final String type, final int size, final boolean isRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("StaticArray<");
    _builder.append(type);
    {
      if (isRef) {
        _builder.append("*");
      }
    }
    _builder.append(", ");
    _builder.append(size);
    _builder.append(">");
    return _builder.toString();
  }
  
  @Override
  public String arrayDeclaration(final String type, final int size, final boolean isRef, final String name) {
    String _arrayType = this.arrayType(type, size, isRef);
    String _plus = (_arrayType + " ");
    return (_plus + name);
  }
  
  public String getIncludeGuardString(final RoomClass roomClass, final String appendSegments) {
    String[] _split = this._roomExtensions.getPackage(roomClass).split("\\.");
    String _name = roomClass.getName();
    Iterable<String> _plus = Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(_split)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name)));
    String[] _split_1 = appendSegments.split("\\.");
    final Function1<String, Boolean> _function = (String it) -> {
      boolean _isEmpty = it.isEmpty();
      return Boolean.valueOf((!_isEmpty));
    };
    String _upperCase = IterableExtensions.join(IterableExtensions.<String>filter(Iterables.<String>concat(_plus, ((Iterable<? extends String>)Conversions.doWrapArray(_split_1))), _function), "_").toUpperCase();
    String _plus_1 = ("_" + _upperCase);
    return (_plus_1 + "_H_");
  }
  
  public CharSequence generateIncludeGuardBegin(final RoomClass roomClass, final String appendSegments) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef ");
    String _includeGuardString = this.getIncludeGuardString(roomClass, appendSegments);
    _builder.append(_includeGuardString);
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    String _includeGuardString_1 = this.getIncludeGuardString(roomClass, appendSegments);
    _builder.append(_includeGuardString_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateIncludeGuardEnd(final RoomClass roomClass, final String appendSegments) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#endif /* ");
    String _includeGuardString = this.getIncludeGuardString(roomClass, appendSegments);
    _builder.append(_includeGuardString);
    _builder.append(" */");
    return _builder;
  }
  
  public String generateNamespaceBegin(final RoomClass roomClass) {
    return "";
  }
  
  public String generateNamespaceEnd(final RoomClass roomClass) {
    return "";
  }
  
  @Override
  public String superCall(final String baseClassName, final String method, final String arguments) {
    return (((((baseClassName + "::") + method) + "(") + arguments) + ");");
  }
  
  @Override
  public String toValueLiteral(final PrimitiveType type, final String value) {
    throw new UnsupportedOperationException("TODO Config for Cpp");
  }
  
  @Override
  public String toEnumLiteral(final EnumerationType type, final String value) {
    throw new UnsupportedOperationException("TODO Config for Cpp");
  }
  
  @Override
  public String defaultValue(final DataType dt) {
    String _switchResult = null;
    final DataType it = dt;
    boolean _matched = false;
    if (it instanceof PrimitiveType) {
      _matched=true;
      _switchResult = ((PrimitiveType)it).getDefaultValueLiteral();
    }
    if (!_matched) {
      if (it instanceof EnumerationType) {
        _matched=true;
        String _xblockexpression = null;
        {
          this.diagnostician.error("Enumeration not supported", dt, null);
          _xblockexpression = "/* TODO */";
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (it instanceof ExternalType) {
        _matched=true;
        _switchResult = ((ExternalType)it).getDefaultValueLiteral();
      }
    }
    return _switchResult;
  }
  
  public String getDefaultValue(final EnumerationType type) {
    String _xifexpression = null;
    boolean _isEmpty = type.getLiterals().isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      _xifexpression = this.getCastedValue(type.getLiterals().get(0));
    }
    return _xifexpression;
  }
  
  @Override
  public String initializationWithDefaultValues(final DataType dt, final int size) {
    String _xblockexpression = null;
    {
      final String dv = this.defaultValue(dt);
      String _xifexpression = null;
      if ((size > 1)) {
        String _xblockexpression_1 = null;
        {
          String res = "{";
          int i = 0;
          while ((i < size)) {
            {
              res = (res + dv);
              i = (i + 1);
              if ((i < size)) {
                res = (res + ",");
              }
            }
          }
          _xblockexpression_1 = (res + "}");
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = dv;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String[] generateArglistAndTypedData(final EObject d) {
    if ((Objects.equal(d, null) || (!(d instanceof VarDecl)))) {
      return ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("", "", ""), String.class));
    }
    final VarDecl data = ((VarDecl) d);
    String _switchResult = null;
    DataType _type = data.getRefType().getType();
    final DataType it = _type;
    boolean _matched = false;
    if (it instanceof PrimitiveType) {
      boolean _isEmpty = Strings.isEmpty(((PrimitiveType)it).getCastName());
      boolean _not = (!_isEmpty);
      if (_not) {
        _matched=true;
        _switchResult = ((PrimitiveType)it).getCastName();
      }
    }
    if (!_matched) {
      if (it instanceof EnumerationType) {
        _matched=true;
        _switchResult = this.getCastType(((EnumerationType)it));
      }
    }
    if (!_matched) {
      _switchResult = this._typeHelpers.typeName(it);
    }
    final String castExpr = (_switchResult + "*");
    String _typeName = this._typeHelpers.typeName(data.getRefType().getType());
    String _switchResult_1 = null;
    RefableType _refType = data.getRefType();
    final RefableType it_1 = _refType;
    boolean _matched_1 = false;
    boolean _isRef = it_1.isRef();
    if (_isRef) {
      _matched_1=true;
      _switchResult_1 = "*";
    }
    if (!_matched_1) {
      boolean _isPrimitive = this._typeHelpers.isPrimitive(it_1.getType());
      if (_isPrimitive) {
        _matched_1=true;
        _switchResult_1 = "";
      }
    }
    if (!_matched_1) {
      _switchResult_1 = "&";
    }
    final String typeExpr = (_typeName + _switchResult_1);
    String _xifexpression = null;
    boolean _isRef_1 = data.getRefType().isRef();
    boolean _not = (!_isRef_1);
    if (_not) {
      _xifexpression = "*";
    } else {
      _xifexpression = "";
    }
    String deRef = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(", ");
    _builder.append(ILanguageExtension.GENERIC_DATA_NAME);
    final String dataArg = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(typeExpr);
    _builder_1.append(" ");
    _builder_1.append(ILanguageExtension.GENERIC_DATA_NAME);
    _builder_1.append(" = ");
    _builder_1.append(deRef);
    _builder_1.append("(static_cast<");
    _builder_1.append(castExpr);
    _builder_1.append(">(generic_data__et));");
    final String typedData = (_builder_1.toString() + this._roomExtensions.NEWLINE);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(", ");
    _builder_2.append(typeExpr);
    _builder_2.append(" ");
    _builder_2.append(ILanguageExtension.GENERIC_DATA_NAME);
    final String typedArgList = _builder_2.toString();
    return new String[] { dataArg, typedData, typedArgList };
  }
  
  @Override
  public String getTargetType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      _xifexpression = type.getPrimitiveType().getTargetName();
    } else {
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
  
  @Override
  public String getCastedValue(final EnumLiteral literal) {
    String _xblockexpression = null;
    {
      EObject _eContainer = literal.eContainer();
      final EnumerationType type = ((EnumerationType) _eContainer);
      final String cast = this.getTargetType(type);
      String _xifexpression = null;
      PrimitiveType _primitiveType = type.getPrimitiveType();
      boolean _notEquals = (!Objects.equal(_primitiveType, null));
      if (_notEquals) {
        _xifexpression = Long.toString(literal.getLiteralValue());
      } else {
        String _string = Long.toString(literal.getLiteralValue());
        String _plus = ((("((" + cast) + ")") + _string);
        _xifexpression = (_plus + ")");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getCastType(final EnumerationType type) {
    String _xifexpression = null;
    PrimitiveType _primitiveType = type.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      _xifexpression = type.getPrimitiveType().getCastName();
    } else {
      _xifexpression = type.getName();
    }
    return _xifexpression;
  }
  
  @Override
  public String makeOverridable() {
    return "virtual ";
  }
  
  /**
   * check if there is an ImplementationSubclass annotation and return its fully qualified name or the actor class name
   */
  public String getImplementationClassName(final ActorClass ac) {
    String _xblockexpression = null;
    {
      final List<KeyValue> attributes = this._roomHelpers.getAttributes(ac, "ImplementationSubclass");
      String _xifexpression = null;
      boolean _isEmpty = attributes.isEmpty();
      if (_isEmpty) {
        _xifexpression = ac.getName();
      } else {
        final Function1<KeyValue, Boolean> _function = (KeyValue it) -> {
          String _key = it.getKey();
          return Boolean.valueOf(Objects.equal(_key, "fqnClassName"));
        };
        _xifexpression = this._roomHelpers.literalToString(IterableExtensions.<KeyValue>head(IterableExtensions.<KeyValue>filter(attributes, _function)).getValue());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * check if there is an ImplementationSubclass annotation. If it also has an includePath use it.
   * If there is not includePath, use the class name as base file name.
   * If there is no annotation use the default path.
   */
  public String getActorIncludePath(final ActorClass ac) {
    String _xblockexpression = null;
    {
      final List<KeyValue> attributes = this._roomHelpers.getAttributes(ac, "ImplementationSubclass");
      String _xifexpression = null;
      boolean _isEmpty = attributes.isEmpty();
      if (_isEmpty) {
        String _path = this._roomExtensions.getPath(ac);
        String _name = ac.getName();
        String _plus = (_path + _name);
        _xifexpression = (_plus + ".h");
      } else {
        String _xblockexpression_1 = null;
        {
          final Function1<KeyValue, Boolean> _function = (KeyValue it) -> {
            String _key = it.getKey();
            return Boolean.valueOf(Objects.equal(_key, "includePath"));
          };
          final Iterable<KeyValue> path = IterableExtensions.<KeyValue>filter(attributes, _function);
          String _xifexpression_1 = null;
          boolean _isEmpty_1 = IterableExtensions.isEmpty(path);
          if (_isEmpty_1) {
            String _xblockexpression_2 = null;
            {
              final Function1<KeyValue, Boolean> _function_1 = (KeyValue it) -> {
                String _key = it.getKey();
                return Boolean.valueOf(Objects.equal(_key, "fqnClassName"));
              };
              final String baseName = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(this._roomHelpers.literalToString(IterableExtensions.<KeyValue>head(IterableExtensions.<KeyValue>filter(attributes, _function_1)).getValue()).split("::"))));
              _xblockexpression_2 = (baseName + ".h");
            }
            _xifexpression_1 = _xblockexpression_2;
          } else {
            _xifexpression_1 = this._roomHelpers.literalToString(IterableExtensions.<KeyValue>head(path).getValue());
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
