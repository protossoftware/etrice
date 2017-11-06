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
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
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
            this.logger.logInfo((((("generating instance tree diagram: \'" + file) + "\' in \'") + path) + "\'"));
            this.fileAccess.generateFile(file, this.generate(root, sys));
          }
        }
        this.fileAccess.generateFile(batchFile, this.generate2jpg(root));
        this.runDot2Jpg(path, batchFile);
      }
    }
  }
  
  private CharSequence generate2jpg(final Root root) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<SystemInstance> _systemInstances = root.getSystemInstances();
      for(final SystemInstance sys : _systemInstances) {
        _builder.append("dot -Tjpg -o ");
        String _name = sys.getName();
        _builder.append(_name);
        _builder.append("_instanceTree.jpg ");
        String _name_1 = sys.getName();
        _builder.append(_name_1);
        _builder.append("_instanceTree.dot");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence generate(final Root root, final SystemInstance sys) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph ");
    String _name = sys.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("rankdir=LR;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node [shape=box];");
    _builder.newLine();
    _builder.append("\t");
    String _pathName = this.roomExt.getPathName(sys.getPath());
    _builder.append(_pathName, "\t");
    _builder.append(" [label=\"");
    String _name_1 = sys.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\\n(");
    String _name_2 = sys.getName();
    _builder.append(_name_2, "\t");
    _builder.append(")\" style=filled color=red];");
    _builder.newLineIfNotEmpty();
    {
      EList<SubSystemInstance> _instances = sys.getInstances();
      for(final SubSystemInstance ssi : _instances) {
        _builder.append("\t");
        String _pathName_1 = this.roomExt.getPathName(ssi.getPath());
        _builder.append(_pathName_1, "\t");
        _builder.append(" [label=\"");
        String _name_3 = ssi.getName();
        _builder.append(_name_3, "\t");
        _builder.append("\\n(");
        String _name_4 = ssi.getSubSystemClass().getName();
        _builder.append(_name_4, "\t");
        _builder.append(")\" style=filled color=yellow];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _pathName_2 = this.roomExt.getPathName(sys.getPath());
        _builder.append(_pathName_2, "\t");
        _builder.append(" -> ");
        String _pathName_3 = this.roomExt.getPathName(ssi.getPath());
        _builder.append(_pathName_3, "\t");
        _builder.append(";  ");
        _builder.newLineIfNotEmpty();
        {
          EList<AbstractInstance> _instances_1 = ssi.getInstances();
          for(final AbstractInstance ai : _instances_1) {
            _builder.append("\t");
            String _instance = this.instance(ai);
            _builder.append(_instance, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String instance(final AbstractInstance ai) {
    String _xblockexpression = null;
    {
      EObject _eContainer = ai.eContainer();
      final StructureInstance parent = ((StructureInstance) _eContainer);
      final ETMapUtil.MappedThread pthread = ETMapUtil.getMappedThread(ai);
      String _xifexpression = null;
      boolean _equals = Objects.equal(pthread, null);
      if (_equals) {
        _xifexpression = "?";
      } else {
        _xifexpression = pthread.getThread().getName();
      }
      final String tname = _xifexpression;
      final NodeRef node = ETMapUtil.getNodeRef(ai);
      String _xifexpression_1 = null;
      boolean _equals_1 = Objects.equal(node, null);
      if (_equals_1) {
        _xifexpression_1 = "?";
      } else {
        _xifexpression_1 = node.getName();
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
        _xifexpression_3 = ((ActorInstance) ai).getActorClass().getName();
      } else {
        String _xifexpression_4 = null;
        if ((ai instanceof ActorInterfaceInstance)) {
          _xifexpression_4 = ((ActorInterfaceInstance) ai).getActorClass().getName();
        } else {
          _xifexpression_4 = "?";
        }
        _xifexpression_3 = _xifexpression_4;
      }
      final String clsname = _xifexpression_3;
      StringConcatenation _builder = new StringConcatenation();
      String _pathName = this.roomExt.getPathName(ai.getPath());
      _builder.append(_pathName);
      _builder.append(" [label=\"");
      _builder.append(optional);
      String _name = ai.getName();
      _builder.append(_name);
      _builder.append("\\n(");
      _builder.append(clsname);
      _builder.append(")\\n@");
      _builder.append(nname);
      _builder.append(":");
      _builder.append(tname);
      _builder.append("\"");
      {
        boolean _isEmpty = optional.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append(" color=blue style=dashed");
        }
      }
      _builder.append("];");
      _builder.newLineIfNotEmpty();
      String _pathName_1 = this.roomExt.getPathName(parent.getPath());
      _builder.append(_pathName_1);
      _builder.append(" -> ");
      String _pathName_2 = this.roomExt.getPathName(ai.getPath());
      _builder.append(_pathName_2);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        if ((ai instanceof StructureInstance)) {
          {
            EList<AbstractInstance> _instances = ((StructureInstance) ai).getInstances();
            for(final AbstractInstance sub_ai : _instances) {
              String _instance = this.instance(sub_ai);
              _builder.append(_instance);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private void runDot2Jpg(final String path, final String bat) {
    File wdir = new File(path);
    try {
      final Process p = Runtime.getRuntime().exec(("cmd /C " + bat), null, wdir);
      int _waitFor = p.waitFor();
      String _plus = ((bat + " finished with ") + Integer.valueOf(_waitFor));
      this.logger.logInfo(_plus);
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
