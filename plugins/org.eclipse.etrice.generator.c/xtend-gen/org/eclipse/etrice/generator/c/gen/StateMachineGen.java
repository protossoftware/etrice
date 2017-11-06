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
package org.eclipse.etrice.generator.c.gen;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  public CharSequence genHeaderConstants(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      final Function1<Node, Boolean> _function = (Node it) -> {
        boolean _isInherited = it.isInherited();
        return Boolean.valueOf((!_isInherited));
      };
      int _size = IteratorExtensions.size(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(xpac.getGraphContainer().getGraph()), _function));
      final Function1<Node, Boolean> _function_1 = (Node it) -> {
        return Boolean.valueOf(FsmGenExtensions.isLeaf(it));
      };
      int _size_1 = IteratorExtensions.size(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(xpac.getGraphContainer().getGraph()), _function_1));
      int _minus = (_size - _size_1);
      final int historySize = (_minus + 2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* constant for state machine data */");
      _builder.newLine();
      _builder.append("#define ");
      String _upperCase = ac.getName().toUpperCase();
      _builder.append(_upperCase);
      _builder.append("_HISTORY_SIZE ");
      _builder.append(historySize);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence genDataMembers(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/* state machine variables */");
      _builder.newLine();
      _builder.append("etInt16 state;");
      _builder.newLine();
      _builder.append("etInt16 history[");
      String _upperCase = ac.getName().toUpperCase();
      _builder.append(_upperCase);
      _builder.append("_HISTORY_SIZE];");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence genInitialization(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("self->state = STATE_TOP;");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int i;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (i=0; i<");
      String _upperCase = ac.getName().toUpperCase();
      _builder.append(_upperCase, "\t");
      _builder.append("_HISTORY_SIZE; ++i)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("self->history[i] = NO_STATE;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String _operationScope = this.langExt.operationScope(ac.getName(), false);
      _builder.append(_operationScope);
      _builder.append("executeInitTransition(self);");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * @param generateImplementation NOT used
   */
  @Override
  public CharSequence genExtra(final GraphContainer gc, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final ModelComponent mc = gc.getComponent();
      final Function1<Node, StateGraphNode> _function = (Node it) -> {
        return it.getStateGraphNode();
      };
      final List<State> allStates = IteratorExtensions.<State>toList(Iterators.<State>filter(IteratorExtensions.<Node, StateGraphNode>map(FsmGenExtensions.getAllStateNodes(gc.getGraph()), _function), State.class));
      final Iterable<State> states = this._roomExtensions.getLeafStatesLast(allStates);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("/* state names */");
          _builder.newLine();
          _builder.append("static char* stateStrings[] = {\"<no state>\",\"<top>\",");
          {
            boolean _hasElements = false;
            for(final State state : states) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "");
              }
              _builder.append("\"");
              String _genStatePathName = this._codegenHelpers.getGenStatePathName(state);
              _builder.append(_genStatePathName);
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      String _accessLevelPrivate = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate);
      _builder.append("void setState(");
      String _componentName = mc.getComponentName();
      _builder.append(_componentName);
      _builder.append("* self, ");
      String _stateType = this.stateType();
      _builder.append(_stateType);
      _builder.append(" new_state) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("self->state = new_state;");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_CHANGE_STATE(self->constData->instName, stateStrings[new_state])");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _accessLevelPrivate_1 = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate_1);
      String _stateType_1 = this.stateType();
      _builder.append(_stateType_1);
      _builder.append(" getState(");
      String _componentName_1 = mc.getComponentName();
      _builder.append(_componentName_1);
      _builder.append("* self) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("return self->state;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
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
  
  @Override
  public CharSequence markVariableUsed(final String varname) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((void)trigger__et);\t/* avoids unused warning */");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public String unreachableReturn() {
    return "/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */";
  }
}
