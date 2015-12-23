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
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  /**
   * @param generateImplementation NOT used
   */
  public CharSequence genExtra(final ExpandedModelComponent xpac, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final ArrayList<State> states = new ArrayList<State>();
      ModelComponent ac = xpac.getModelComponent();
      while ((!Objects.equal(ac, null))) {
        {
          List<State> _allBaseStates = this._fSMHelpers.getAllBaseStates(ac);
          List<State> _leafStatesLast = this._fSMExtensions.getLeafStatesLast(_allBaseStates);
          states.addAll(0, _leafStatesLast);
          ModelComponent _base = ac.getBase();
          ac = _base;
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _or = false;
        GlobalSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _or = true;
        } else {
          GlobalSettings _settings_1 = Main.getSettings();
          boolean _isGenerateWithVerboseOutput = _settings_1.isGenerateWithVerboseOutput();
          _or = _isGenerateWithVerboseOutput;
        }
        if (_or) {
          _builder.append("// state names");
          _builder.newLine();
          _builder.append("protected static final String stateStrings[] = {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"<no state>\",");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"<top>\",");
          _builder.newLine();
          {
            boolean _hasElements = false;
            for(final State state : states) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              _builder.append("\"");
              String _genStatePathName = this._codegenHelpers.getGenStatePathName(state);
              _builder.append(_genStatePathName, "\t");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
          _builder.newLine();
        }
      }
      _builder.append("// history");
      _builder.newLine();
      _builder.append("protected int history[] = {NO_STATE, NO_STATE");
      {
        for(final State state_1 : states) {
          _builder.append(", NO_STATE");
        }
      }
      _builder.append("};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("private void setState(int new_state) {");
      _builder.newLine();
      {
        GlobalSettings _settings_2 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_1 = _settings_2.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);");
          _builder.newLine();
        }
      }
      {
        GlobalSettings _settings_3 = Main.getSettings();
        boolean _isGenerateWithVerboseOutput_1 = _settings_3.isGenerateWithVerboseOutput();
        if (_isGenerateWithVerboseOutput_1) {
          _builder.append("\t");
          _builder.append("if (stateStrings[new_state]!=\"Idle\") {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("System.out.println(\"state switch of \"+getInstancePath() + \": \"");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t\t");
          _builder.append("+ stateStrings[this.state] + \" -> \" + stateStrings[new_state]);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("this.state = new_state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * if {@code -storeDataObj} is set then a call to {@code finalAction()} is generated
   */
  public CharSequence finalAction() {
    StringConcatenation _builder = new StringConcatenation();
    {
      GlobalSettings _settings = Main.getSettings();
      boolean _isGenerateStoreDataObj = _settings.isGenerateStoreDataObj();
      if (_isGenerateStoreDataObj) {
        _builder.append("finalAction();");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public int getHistorySize(final ExpandedActorClass xpac) {
    ActorClass _actorClass = xpac.getActorClass();
    List<State> _allBaseStates = this._fSMHelpers.getAllBaseStates(_actorClass);
    int _size = _allBaseStates.size();
    return (_size + 2);
  }
}
