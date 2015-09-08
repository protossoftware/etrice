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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class OptionalActorInterfaceGen extends GenericActorClassGenerator {
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
    EList<ActorClass> _optionalActorClasses = root.getOptionalActorClasses();
    final Function1<ActorClass, Boolean> _function = new Function1<ActorClass, Boolean>() {
      public Boolean apply(final ActorClass cl) {
        return Boolean.valueOf(OptionalActorInterfaceGen.this._fileSystemHelpers.isValidGenerationLocation(cl));
      }
    };
    Iterable<ActorClass> _filter = IterableExtensions.<ActorClass>filter(_optionalActorClasses, _function);
    for (final ActorClass ac : _filter) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(ac);
        String _path = this._roomExtensions.getPath(ac);
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(ac);
        String _path_1 = this._roomExtensions.getPath(ac);
        final String infopath = (_generationInfoPath + _path_1);
        String file = this._javaExtensions.getJavaInterfaceFileName(ac, false);
        CharSequence _generate = this.generate(root, ac, false);
        this.fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, _generate);
        String _javaInterfaceFileName = this._javaExtensions.getJavaInterfaceFileName(ac, true);
        file = _javaInterfaceFileName;
        CharSequence _generate_1 = this.generate(root, ac, true);
        this.fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, _generate_1);
      }
    }
  }
  
  public CharSequence generate(final Root root, final ActorClass ac, final boolean replicated) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      if (replicated) {
        _xifexpression = "ReplicatedOptionalActorInterfaceBase";
      } else {
        _xifexpression = "ScalarOptionalActorInterfaceBase";
      }
      final String baseClass = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        GlobalSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
          _builder.newLine();
        }
      }
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.");
      _builder.append(baseClass, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _javaInterfaceName = this._javaExtensions.getJavaInterfaceName(ac, replicated);
      _builder.append(_javaInterfaceName, "");
      _builder.append(" extends ");
      _builder.append(baseClass, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("//--------------------- brokers for ports on the interface");
      _builder.newLine();
      {
        List<Port> _allInterfacePorts = this._roomHelpers.getAllInterfacePorts(ac);
        for(final Port ep : _allInterfacePorts) {
          _builder.append("\t");
          _builder.append("protected InterfaceItemBroker ");
          String _name = ep.getName();
          _builder.append(_name, "\t");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      String _genInterfaceItemConstantsForOptionalActor = this.genInterfaceItemConstantsForOptionalActor(ac);
      _builder.append(_genInterfaceItemConstantsForOptionalActor, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _javaInterfaceName_1 = this._javaExtensions.getJavaInterfaceName(ac, replicated);
      _builder.append(_javaInterfaceName_1, "\t");
      _builder.append(" (IEventReceiver parent, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(parent, name, \"");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "\t\t");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      {
        List<Port> _allInterfacePorts_1 = this._roomHelpers.getAllInterfacePorts(ac);
        for(final Port ep_1 : _allInterfacePorts_1) {
          {
            boolean _isReplicated = ep_1.isReplicated();
            if (_isReplicated) {
              _builder.append("\t\t");
              String _name_2 = ep_1.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append(" = new ReplicatedInterfaceItemBroker(this, \"");
              String _name_3 = ep_1.getName();
              _builder.append(_name_3, "\t\t");
              _builder.append("\", ");
              String _ifItemId = this.getIfItemId(ep_1);
              _builder.append(_ifItemId, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              String _name_4 = ep_1.getName();
              _builder.append(_name_4, "\t\t");
              _builder.append(" = new InterfaceItemBroker(this, \"");
              String _name_5 = ep_1.getName();
              _builder.append(_name_5, "\t\t");
              _builder.append("\", ");
              String _ifItemId_1 = this.getIfItemId(ep_1);
              _builder.append(_ifItemId_1, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        GlobalSettings _settings_1 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_1 = _settings_1.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void logCreation(String actorClass, String name) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, actorClass, name);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void logDeletion(String name) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this, name);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
