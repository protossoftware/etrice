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
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassDataGen {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  public void doGenerate(final Root root) {
    final HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>();
    final Function1<WiredStructureClass, Boolean> _function = (WiredStructureClass w) -> {
      return Boolean.valueOf((w instanceof WiredActorClass));
    };
    final Consumer<WiredStructureClass> _function_1 = (WiredStructureClass w) -> {
      ac2wired.put(((WiredActorClass) w).getActorClass(), ((WiredActorClass) w));
    };
    IterableExtensions.<WiredStructureClass>filter(root.getWiredInstances(), _function).forEach(_function_1);
    final Function1<ActorClass, Boolean> _function_2 = (ActorClass it) -> {
      return Boolean.valueOf(this._fileSystemHelpers.isValidGenerationLocation(it));
    };
    final Function1<ActorClass, ExpandedActorClass> _function_3 = (ActorClass it) -> {
      return root.getExpandedActorClass(it);
    };
    Iterable<ExpandedActorClass> _map = IterableExtensions.<ActorClass, ExpandedActorClass>map(IterableExtensions.<ActorClass>filter(root.getActorClasses(), _function_2), _function_3);
    for (final ExpandedActorClass xpac : _map) {
      {
        final WiredActorClass wired = ac2wired.get(xpac.getActorClass());
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(xpac.getActorClass());
        String _path = this._roomExtensions.getPath(xpac.getActorClass());
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(xpac.getActorClass());
        String _path_1 = this._roomExtensions.getPath(xpac.getActorClass());
        final String infopath = (_generationInfoPath + _path_1);
        String _name = xpac.getActorClass().getName();
        String file = (_name + "_DataObject.java");
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, file, this.generate(root, xpac, wired));
      }
    }
  }
  
  public CharSequence generate(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      String _name = ac.getName();
      final String clsname = (_name + "_DataObject");
      final EList<RoomModel> models = root.getReferencedModels(ac);
      String _xifexpression = null;
      ModelComponent _base = ac.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        String _name_1 = ac.getActorBase().getName();
        String _plus = ("extends " + _name_1);
        _xifexpression = (_plus + "_DataObject ");
      } else {
        _xifexpression = "";
      }
      final String baseClass = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IActorClassDataObject;");
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name_2 = model.getName();
          _builder.append(_name_2);
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname);
      _builder.append(" ");
      _builder.append(baseClass);
      _builder.append("implements IActorClassDataObject {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\t");
          _builder.append("// state and history");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("private int state;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("private int[] history;");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      CharSequence _attributes = this._procedureHelpers.attributes(ac.getAttributes());
      _builder.append(_attributes, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine_1 = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine_1) {
          _builder.append("\t");
          _builder.append("public int getState() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return state;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void setState(int state) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.state = state;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public int[] getHistory() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return history;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void setHistory(int[] history)  {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.history = history;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(ac.getAttributes(), ac.getName());
      _builder.append(_attributeSettersGettersImplementation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
