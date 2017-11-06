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

import com.google.inject.Singleton;
import java.util.Comparator;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class StateMachineGen extends GenericStateMachineGenerator {
  private static class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(final Node o1, final Node o2) {
      int _inheritanceLevel = o1.getInheritanceLevel();
      int _inheritanceLevel_1 = o2.getInheritanceLevel();
      boolean _equals = (_inheritanceLevel == _inheritanceLevel_1);
      if (_equals) {
        if ((FsmGenExtensions.isLeaf(o1) && FsmGenExtensions.isLeaf(o2))) {
          return 0;
        }
        boolean _isLeaf = FsmGenExtensions.isLeaf(o1);
        if (_isLeaf) {
          return 1;
        }
        boolean _isLeaf_1 = FsmGenExtensions.isLeaf(o2);
        if (_isLeaf_1) {
          return (-1);
        }
        return 0;
      } else {
        return Integer.compare(o1.getInheritanceLevel(), o1.getInheritanceLevel());
      }
    }
  }
  
  private final StateMachineGen.NodeComparator nodeComparator = new StateMachineGen.NodeComparator();
  
  @Override
  public CharSequence genExtra(final GraphContainer gc, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      ModelComponent ac = gc.getComponent();
      final String clsName = ac.getComponentName();
      final List<Node> orderedStateNodes = IterableExtensions.<Node>sortWith(IteratorExtensions.<Node>toList(FsmGenExtensions.getAllStateNodes(gc.getGraph())), this.nodeComparator);
      CharSequence _xifexpression = null;
      if (generateImplementation) {
        StringConcatenation _builder = new StringConcatenation();
        {
          if ((Main.getSettings().isGenerateMSCInstrumentation() || Main.getSettings().isGenerateWithVerboseOutput())) {
            _builder.append("// state names");
            _builder.newLine();
            _builder.append("const String ");
            _builder.append(clsName);
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
              for(final Node state : orderedStateNodes) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",", "\t");
                }
                _builder.append("\t");
                _builder.append("\"");
                StateGraphNode _stateGraphNode = state.getStateGraphNode();
                String _genStatePathName = this._codegenHelpers.getGenStatePathName(((State) _stateGraphNode));
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
        _builder.append(clsName);
        _builder.append("::s_numberOfStates = ");
        int _size = orderedStateNodes.size();
        int _plus = (2 + _size);
        _builder.append(_plus);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("void ");
        _builder.append(clsName);
        _builder.append("::setState(int new_state) {");
        _builder.newLineIfNotEmpty();
        {
          boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
          if (_isGenerateMSCInstrumentation) {
            _builder.append("\t");
            _builder.append("DebuggingService::getInstance().addActorState(*this, s_stateStrings[new_state].c_str());");
            _builder.newLine();
          }
        }
        {
          boolean _isGenerateWithVerboseOutput = Main.getSettings().isGenerateWithVerboseOutput();
          if (_isGenerateWithVerboseOutput) {
            _builder.append("\t");
            _builder.append("if (s_stateStrings[new_state] != \"Idle\") {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("std::cout << getInstancePath().c_str() << \" -> \" << s_stateStrings[new_state].c_str() << std::endl;");
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
            _builder_1.append("static const String s_stateStrings[];");
            _builder_1.newLine();
          }
        }
        _builder_1.append("static const int s_numberOfStates;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("int history[");
        int _size_1 = orderedStateNodes.size();
        int _plus_1 = (2 + _size_1);
        _builder_1.append(_plus_1);
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
