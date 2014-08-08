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
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    final Function1<WiredStructureClass, Boolean> _function = new Function1<WiredStructureClass, Boolean>() {
      public Boolean apply(final WiredStructureClass w) {
        return Boolean.valueOf((w instanceof WiredActorClass));
      }
    };
    Iterable<WiredStructureClass> _filter = IterableExtensions.<WiredStructureClass>filter(_wiredInstances, _function);
    final Procedure1<WiredStructureClass> _function_1 = new Procedure1<WiredStructureClass>() {
      public void apply(final WiredStructureClass w) {
        ActorClass _actorClass = ((WiredActorClass) w).getActorClass();
        ac2wired.put(_actorClass, ((WiredActorClass) w));
      }
    };
    IterableExtensions.<WiredStructureClass>forEach(_filter, _function_1);
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    final Function1<ExpandedActorClass, Boolean> _function_2 = new Function1<ExpandedActorClass, Boolean>() {
      public Boolean apply(final ExpandedActorClass cl) {
        ActorClass _actorClass = cl.getActorClass();
        return Boolean.valueOf(ActorClassDataGen.this._fileSystemHelpers.isValidGenerationLocation(_actorClass));
      }
    };
    Iterable<ExpandedActorClass> _filter_1 = IterableExtensions.<ExpandedActorClass>filter(_xpActorClasses, _function_2);
    for (final ExpandedActorClass xpac : _filter_1) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        final WiredActorClass wired = ac2wired.get(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass_1);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_2);
        final String path = (_generationTargetPath + _path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        String _path_1 = this._roomExtensions.getPath(_actorClass_4);
        final String infopath = (_generationInfoPath + _path_1);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String _name = _actorClass_5.getName();
        String file = (_name + "_DataObject.java");
        CharSequence _generate = this.generate(root, xpac, wired);
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, file, _generate);
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
        ActorClass _actorBase = ac.getActorBase();
        String _name_1 = _actorBase.getName();
        String _plus = ("extends " + _name_1);
        _xifexpression = (_plus + "_DataObject ");
      } else {
        _xifexpression = "";
      }
      final String baseClass = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IActorClassDataObject;");
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name_2 = model.getName();
          _builder.append(_name_2, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname, "");
      _builder.append(" ");
      _builder.append(baseClass, "");
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
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
      _builder.append(_attributes_1, "\t");
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
      EList<Attribute> _attributes_2 = ac.getAttributes();
      String _name_3 = ac.getName();
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_attributes_2, _name_3);
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
