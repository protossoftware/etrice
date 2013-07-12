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
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IRoomGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class InstanceDiagramGen implements IRoomGenerator {
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
  
  public CharSequence generate2jpg(final Root root) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<SystemInstance> _systemInstances = root.getSystemInstances();
      for(final SystemInstance sys : _systemInstances) {
        _builder.append("dot -Tjpg -o ");
        String _name = sys.getName();
        _builder.append(_name, "");
        _builder.append("_instanceTree.jpg ");
        String _name_1 = sys.getName();
        _builder.append(_name_1, "");
        _builder.append("_instanceTree.dot");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generate(final Root root, final SystemInstance sys) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph ");
    String _name = sys.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("rankdir=TD;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node [shape=box];");
    _builder.newLine();
    _builder.append("\t");
    String _path = sys.getPath();
    String _pathName = this.roomExt.getPathName(_path);
    _builder.append(_pathName, "	");
    _builder.append(" [label=\"");
    String _name_1 = sys.getName();
    _builder.append(_name_1, "	");
    _builder.append("\\n(");
    String _name_2 = sys.getName();
    _builder.append(_name_2, "	");
    _builder.append(")\" style=filled color=red];");
    _builder.newLineIfNotEmpty();
    {
      EList<SubSystemInstance> _instances = sys.getInstances();
      for(final SubSystemInstance ssi : _instances) {
        _builder.append("\t");
        String _path_1 = ssi.getPath();
        String _pathName_1 = this.roomExt.getPathName(_path_1);
        _builder.append(_pathName_1, "	");
        _builder.append(" [label=\"");
        String _name_3 = ssi.getName();
        _builder.append(_name_3, "	");
        _builder.append("\\n(");
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        String _name_4 = _subSystemClass.getName();
        _builder.append(_name_4, "	");
        _builder.append(")\" style=filled color=yellow];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _path_2 = sys.getPath();
        String _pathName_2 = this.roomExt.getPathName(_path_2);
        _builder.append(_pathName_2, "	");
        _builder.append(" -> ");
        String _path_3 = ssi.getPath();
        String _pathName_3 = this.roomExt.getPathName(_path_3);
        _builder.append(_pathName_3, "	");
        _builder.append(";  ");
        _builder.newLineIfNotEmpty();
        {
          EList<ActorInstance> _instances_1 = ssi.getInstances();
          for(final ActorInstance ai : _instances_1) {
            _builder.append("\t");
            String _instance = this.instance(ai);
            _builder.append(_instance, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String instance(final ActorInstance ai) {
    String _xblockexpression = null;
    {
      EObject _eContainer = ai.eContainer();
      final StructureInstance parent = ((StructureInstance) _eContainer);
      final PhysicalThread pthread = ETMapUtil.getPhysicalThread(ai);
      String _xifexpression = null;
      boolean _equals = Objects.equal(pthread, null);
      if (_equals) {
        _xifexpression = "?";
      } else {
        String _name = pthread.getName();
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
      StringConcatenation _builder = new StringConcatenation();
      String _path = ai.getPath();
      String _pathName = this.roomExt.getPathName(_path);
      _builder.append(_pathName, "");
      _builder.append(" [label=\"");
      String _name_2 = ai.getName();
      _builder.append(_name_2, "");
      _builder.append("\\n(");
      ActorClass _actorClass = ai.getActorClass();
      String _name_3 = _actorClass.getName();
      _builder.append(_name_3, "");
      _builder.append(")\\n@");
      _builder.append(nname, "");
      _builder.append(":");
      _builder.append(tname, "");
      _builder.append("\"];");
      _builder.newLineIfNotEmpty();
      String _path_1 = parent.getPath();
      String _pathName_1 = this.roomExt.getPathName(_path_1);
      _builder.append(_pathName_1, "");
      _builder.append(" -> ");
      String _path_2 = ai.getPath();
      String _pathName_2 = this.roomExt.getPathName(_path_2);
      _builder.append(_pathName_2, "");
      _builder.append(";  ");
      _builder.newLineIfNotEmpty();
      {
        EList<ActorInstance> _instances = ai.getInstances();
        for(final ActorInstance sub_ai : _instances) {
          String _instance = this.instance(sub_ai);
          _builder.append(_instance, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public void runDot2Jpg(final String path, final String bat) {
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
