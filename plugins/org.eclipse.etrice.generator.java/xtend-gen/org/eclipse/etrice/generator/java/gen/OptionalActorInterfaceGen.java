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
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

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
  
  public void doGenerate(final Root root) {
    EList<ActorClass> _optionalActorClasses = root.getOptionalActorClasses();
    for (final ActorClass ac : _optionalActorClasses) {
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
      _builder.append("package �ac.getPackage�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.�baseClass�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class �ac.getJavaInterfaceName(replicated)� extends �baseClass� {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- brokers for ports on the interface");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR ep : ac.allInterfacePorts�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected InterfaceItemBroker �ep.name� = null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ac.genInterfaceItemConstantsForOptionalActor�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �ac.getJavaInterfaceName(replicated)� (IEventReceiver parent, String name) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(parent, name, \"�ac.name�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ep : ac.allInterfacePorts�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF ep.replicated�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ep.name� = new ReplicatedInterfaceItemBroker(this, \"�ep.name�\", IFITEM_�ep.name�);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ep.name� = new InterfaceItemBroker(this, \"�ep.name�\", IFITEM_�ep.name�);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void logCreation(String actorClass, String name) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, actorClass, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void logDeletion(String name) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
