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
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
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
  
  public void doGenerate(final Root root) {
    EList<DataClass> _usedDataClasses = root.getUsedDataClasses();
    for (final DataClass dc : _usedDataClasses) {
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
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
        public Boolean apply(final StandardOperation op) {
          boolean _isConstructor = RoomHelpers.isConstructor(op);
          return Boolean.valueOf(_isConstructor);
        }
      };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �dc.getPackage()�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
      _builder.newLine();
      _builder.append("import java.io.Serializable;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�var models = root.getReferencedModels(dc)�");
      _builder.newLine();
      _builder.append("�FOR model : models�import �model.name�.*;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�dc.userCode(1)�");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �dc.name��IF dc.base!=null� extends �dc.base.name��ENDIF� implements Serializable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final long serialVersionUID = �(dc.package+dc.name).hashCode�L;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�dc.userCode(2)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�dc.attributes.attributes�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�dc.attributes.attributeSettersGettersImplementation(dc.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�dc.operations.operationsImplementation(dc.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// default constructor");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �dc.name�() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�dc.attributes.attributeInitialization(dc, true)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF ctor!=null�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// user defined constructor body");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR l : ctor.detailCode.lines�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�l�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// constructor using fields");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �dc.name�(�dc.argList�) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF dc.base!=null�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(�dc.base.paramList�);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR a : dc.attributes�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("this.�a.name� = �a.name�;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// deep copy");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �dc.name� deepCopy() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�dc.name� copy = new �dc.name�();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�deepCopy(dc)�");
      _builder.newLine();
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
          String _plus_1 = (", " + result);
          result = _plus_1;
        }
      }
      boolean _notEquals_1 = (!Objects.equal(dc, null));
      _while = _notEquals_1;
    }
    return result;
  }
  
  private CharSequence paramList(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR a: attributes SEPARATOR \", \"��a.name��ENDFOR�");
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
          String _plus_1 = (", " + result);
          result = _plus_1;
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
    _builder.append("�FOR a : attributes�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF a.type.ref�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("copy.�a.name� = �a.name�;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ELSEIF a.type.type instanceof ComplexType�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (�a.name�!=null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�IF a.size<=1�");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("copy.�a.name� = �a.name�.deepCopy();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (int i=0;i<�a.name�.length;i++){");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("copy.�a.name�[i] = �a.name�[i].deepCopy();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�IF a.size==0�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("copy.�a.name� = �a.name�;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (int i=0;i<�a.name�.length;i++){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("copy.�a.name�[i] = �a.name�[i];");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
}
