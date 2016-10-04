/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Override
  public CharSequence genExtra(final ExpandedModelComponent xpac, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final ArrayList<State> states = CollectionLiterals.<State>newArrayList();
      ModelComponent ac = xpac.getModelComponent();
      ModelComponent _modelComponent = xpac.getModelComponent();
      final String clsName = _modelComponent.getComponentName();
      while ((!Objects.equal(ac, null))) {
        {
          List<State> _allBaseStates = this._fSMHelpers.getAllBaseStates(ac);
          List<State> _leafStatesLast = this._roomExtensions.getLeafStatesLast(_allBaseStates);
          states.addAll(0, _leafStatesLast);
          ModelComponent _base = ac.getBase();
          ac = _base;
        }
      }
      CharSequence _xifexpression = null;
      if (generateImplementation) {
        StringConcatenation _builder = new StringConcatenation();
        {
          if ((Main.getSettings().isGenerateMSCInstrumentation() || Main.getSettings().isGenerateWithVerboseOutput())) {
            _builder.append("// state names");
            _builder.newLine();
            _builder.append("const std::string ");
            _builder.append(clsName, "");
            _builder.append("::s_stateStrings[] = {");
            _builder.newLineIfNotEmpty();
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
          }
        }
        _builder.append("const int ");
        _builder.append(clsName, "");
        _builder.append("::s_numberOfStates = ");
        int _size = states.size();
        int _plus = (2 + _size);
        _builder.append(_plus, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("void ");
        _builder.append(clsName, "");
        _builder.append("::setState(int new_state) {");
        _builder.newLineIfNotEmpty();
        {
          GlobalGeneratorSettings _settings = Main.getSettings();
          boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
          if (_isGenerateMSCInstrumentation) {
            _builder.append("\t");
            _builder.append("DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state]);");
            _builder.newLine();
          }
        }
        {
          GlobalGeneratorSettings _settings_1 = Main.getSettings();
          boolean _isGenerateWithVerboseOutput = _settings_1.isGenerateWithVerboseOutput();
          if (_isGenerateWithVerboseOutput) {
            _builder.append("\t");
            _builder.append("if (s_stateStrings[new_state] != \"Idle\") {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("std::cout << getInstancePath() << \" -> \" << s_stateStrings[new_state] << std::endl;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("m_state = new_state;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          if ((Main.getSettings().isGenerateMSCInstrumentation() || Main.getSettings().isGenerateWithVerboseOutput())) {
            _builder_1.append("static const std::string s_stateStrings[];");
            _builder_1.newLine();
          }
        }
        _builder_1.append("static const int s_numberOfStates;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("int history[");
        int _size_1 = states.size();
        int _plus_1 = (2 + _size_1);
        _builder_1.append(_plus_1, "");
        _builder_1.append("];");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("void setState(int new_state);");
        _builder_1.newLine();
        _xifexpression = _builder_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String stateType() {
    return "etInt16";
  }
  
  @Override
  public String boolType() {
    return "etBool";
  }
}
