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
package org.eclipse.etrice.generator.doc.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etmap.util.ETMapUtil.MappedThread;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class InstanceDiagramGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<RoomModel> _models = root.getModels();
    for (final RoomModel model : _models) {
      {
        String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
        String path = (_docGenerationTargetPath + "/images");
        this.fileAccess.setOutputPath(path);
        String batchFile = "dot2jpg.bat";
        EList<SystemInstance> _systemInstances = root.getSystemInstances();
        for (final SystemInstance sys : _systemInstances) {
          {
            String _name = sys.getName();
            String file = (_name + "_instanceTree.dot");
            String _plus = ("generating instance tree diagram: \'" + file);
            String _plus_1 = (_plus + "\' in \'");
            String _plus_2 = (_plus_1 + path);
            String _plus_3 = (_plus_2 + "\'");
            this.logger.logInfo(_plus_3);
            CharSequence _generate = this.generate(root, sys);
            this.fileAccess.generateFile(file, _generate);
          }
        }
        CharSequence _generate2jpg = this.generate2jpg(root);
        this.fileAccess.generateFile(batchFile, _generate2jpg);
        this.runDot2Jpg(path, batchFile);
      }
    }
  }
  
  private CharSequence generate2jpg(final Root root) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR sys : root.systemInstances�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("dot -Tjpg -o �sys.name�_instanceTree.jpg �sys.name�_instanceTree.dot");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generate(final Root root, final SystemInstance sys) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph �sys.name� {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rankdir=TD;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node [shape=box];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�sys.path.getPathName()� [label=\"�sys.name�\\n(�sys.name�)\" style=filled color=red];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR ssi : sys.instances�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ssi.path.getPathName()� [label=\"�ssi.name�\\n(�ssi.subSystemClass.name�)\" style=filled color=yellow];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�sys.path.getPathName()� -> �ssi.path.getPathName()�;  ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�FOR ai : ssi.instances�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�instance(ai)�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String instance(final AbstractInstance ai) {
    String _xblockexpression = null;
    {
      EObject _eContainer = ai.eContainer();
      final StructureInstance parent = ((StructureInstance) _eContainer);
      final MappedThread pthread = ETMapUtil.getMappedThread(ai);
      String _xifexpression = null;
      boolean _equals = Objects.equal(pthread, null);
      if (_equals) {
        _xifexpression = "?";
      } else {
        PhysicalThread _thread = pthread.getThread();
        String _name = _thread.getName();
        _xifexpression = _name;
      }
      final String tname = _xifexpression;
      final NodeRef node = ETMapUtil.getNodeRef(ai);
      String _xifexpression_1 = null;
      boolean _equals_1 = Objects.equal(node, null);
      if (_equals_1) {
        _xifexpression_1 = "?";
      } else {
        String _name_1 = node.getName();
        _xifexpression_1 = _name_1;
      }
      final String nname = _xifexpression_1;
      String _xifexpression_2 = null;
      if ((ai instanceof ActorInterfaceInstance)) {
        _xifexpression_2 = "optional ";
      } else {
        _xifexpression_2 = "";
      }
      final String optional = _xifexpression_2;
      String _xifexpression_3 = null;
      if ((ai instanceof ActorInstance)) {
        ActorClass _actorClass = ((ActorInstance) ai).getActorClass();
        String _name_2 = _actorClass.getName();
        _xifexpression_3 = _name_2;
      } else {
        String _xifexpression_4 = null;
        if ((ai instanceof ActorInterfaceInstance)) {
          ActorClass _actorClass_1 = ((ActorInterfaceInstance) ai).getActorClass();
          String _name_3 = _actorClass_1.getName();
          _xifexpression_4 = _name_3;
        } else {
          _xifexpression_4 = "?";
        }
        _xifexpression_3 = _xifexpression_4;
      }
      final String clsname = _xifexpression_3;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�ai.path.getPathName()� [label=\"�optional��ai.name�\\n(�clsname�)\\n@�nname�:�tname�\"�IF !optional.empty� color=blue style=dashed�ENDIF�];");
      _builder.newLine();
      _builder.append("�parent.path.getPathName()� -> �ai.path.getPathName()�;");
      _builder.newLine();
      _builder.append("�IF ai instanceof StructureInstance�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR sub_ai : (ai as StructureInstance).instances�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�instance(sub_ai)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("�ENDIF� ");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  private void runDot2Jpg(final String path, final String bat) {
    File _file = new File(path);
    File wdir = _file;
    try {
      Runtime _runtime = Runtime.getRuntime();
      String _plus = ("cmd /C " + bat);
      final Process p = _runtime.exec(_plus, null, wdir);
      String _plus_1 = (bat + " finished with ");
      int _waitFor = p.waitFor();
      String _plus_2 = (_plus_1 + Integer.valueOf(_waitFor));
      this.logger.logInfo(_plus_2);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
