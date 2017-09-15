/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Henrik Rentz-Reichert
 */
@SuppressWarnings("all")
public class EnumerationTypeGen {
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
  private FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    EList<EnumerationType> _enumClasses = root.getEnumClasses();
    final Function1<EnumerationType, Boolean> _function = new Function1<EnumerationType, Boolean>() {
      @Override
      public Boolean apply(final EnumerationType cl) {
        return Boolean.valueOf(EnumerationTypeGen.this._fileSystemHelpers.isValidGenerationLocation(cl));
      }
    };
    Iterable<EnumerationType> _filter = IterableExtensions.<EnumerationType>filter(_enumClasses, _function);
    for (final EnumerationType et : _filter) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(et);
        String _path = this._roomExtensions.getPath(et);
        String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(et);
        String _path_1 = this._roomExtensions.getPath(et);
        String infopath = (_generationInfoPath + _path_1);
        String file = this._javaExtensions.getJavaFileName(et);
        CharSequence _generate = this.generate(root, et);
        this.fileIO.generateFile("generating Enumeration implementation", path, infopath, file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final EnumerationType et) {
    CharSequence _xblockexpression = null;
    {
      final String type = this._javaExtensions.getTargetType(et);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(et);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public interface ");
      String _name = et.getName();
      _builder.append(_name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        EList<EnumLiteral> _literals = et.getLiterals();
        for(final EnumLiteral lit : _literals) {
          _builder.append("\t");
          _builder.append("static final ");
          _builder.append(type, "\t");
          _builder.append(" ");
          String _name_1 = lit.getName();
          _builder.append(_name_1, "\t");
          _builder.append(" = ");
          long _literalValue = lit.getLiteralValue();
          _builder.append(_literalValue, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
