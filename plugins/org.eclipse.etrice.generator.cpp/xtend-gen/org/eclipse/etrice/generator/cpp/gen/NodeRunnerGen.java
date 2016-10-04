/**
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class NodeRunnerGen {
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  @Extension
  private CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  public void doGenerate(final Root root) {
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          if (((!Objects.equal(ssi, null)) && this._fileSystemHelpers.isValidGenerationLocation(ssi.getSubSystemClass()))) {
            SubSystemClass _subSystemClass = ssi.getSubSystemClass();
            String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
            SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
            String _path = this.roomExt.getPath(_subSystemClass_1);
            final String filepath = (_generationTargetPath + _path);
            SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
            String _generationInfoPath = this.roomExt.getGenerationInfoPath(_subSystemClass_2);
            SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
            String _path_1 = this.roomExt.getPath(_subSystemClass_3);
            final String infopath = (_generationInfoPath + _path_1);
            String _cppClassName = this._cppExtensions.getCppClassName(nr, ssi);
            String _plus = (_cppClassName + "Runner.h");
            CharSequence _generateHeaderFile = this.generateHeaderFile(root, ssi);
            this.fileIO.generateFile("generating SubSystemRunner declaration", filepath, infopath, _plus, _generateHeaderFile);
            String _cppClassName_1 = this._cppExtensions.getCppClassName(nr, ssi);
            String _plus_1 = (_cppClassName_1 + "Runner.cpp");
            CharSequence _generateSourceFile = this.generateSourceFile(root, ssi);
            this.fileIO.generateFile("generating SubSystemRunner implementation", filepath, infopath, _plus_1, _generateSourceFile);
          }
        }
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final SubSystemInstance ssc) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = ssc.getSubSystemClass();
      final NodeRef nr = ETMapUtil.getNodeRef(ssc);
      final String clsname = this._cppExtensions.getCppClassName(nr, ssc);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* this class contains the main function running component ");
      String _name = ssc.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* it instantiates ");
      String _name_1 = ssc.getName();
      _builder.append(_name_1, " ");
      _builder.append(" and starts and ends the lifecycle");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(cc, "Runner");
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/modelbase/SubSystemRunnerBase.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ");
      _builder.append((clsname + "Runner"), "");
      _builder.append(" : public etRuntime::SubSystemRunnerBase {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(cc, "Runner");
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance ssc) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = ssc.getSubSystemClass();
      final NodeRef nr = ETMapUtil.getNodeRef(ssc);
      final String clsname = this._cppExtensions.getCppClassName(nr, ssc);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* this class contains the main function running component ");
      String _name = ssc.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* it instantiates ");
      String _name_1 = ssc.getName();
      _builder.append(_name_1, " ");
      _builder.append(" and starts and ends the lifecycle");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      _builder.append(clsname, "");
      _builder.append("Runner.h\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"");
      _builder.append(clsname, "");
      _builder.append(".h\"");
      _builder.newLineIfNotEmpty();
      _builder.append("#include \"common/modelbase/RTSystem.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* ");
      GlobalGeneratorSettings _settings = Main.getSettings();
      String _mainMethodName = _settings.getMainMethodName();
      _builder.append(_mainMethodName, " ");
      _builder.append(" function");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* creates components and starts and stops the lifecycle");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("int ");
      GlobalGeneratorSettings _settings_1 = Main.getSettings();
      String _mainMethodName_1 = _settings_1.getMainMethodName();
      _builder.append(_mainMethodName_1, "");
      _builder.append("(int argc, char* argv[]) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// instantiate the main component");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("RTSystem* sys = ");
      {
        EObject _eContainer = ssc.eContainer();
        if ((_eContainer instanceof SystemInstance)) {
          _builder.append("new RTSystem(\"");
          EObject _eContainer_1 = ssc.eContainer();
          String _name_2 = ((SystemInstance) _eContainer_1).getName();
          _builder.append(_name_2, "\t");
          _builder.append("\")");
        } else {
          _builder.append("0");
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("* main_component = new ");
      _builder.append(clsname, "\t");
      _builder.append("(sys, \"");
      String _name_3 = ssc.getName();
      _builder.append(_name_3, "\t");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("Runner::run(*main_component, argc, argv);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//delete sys;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return 0;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
