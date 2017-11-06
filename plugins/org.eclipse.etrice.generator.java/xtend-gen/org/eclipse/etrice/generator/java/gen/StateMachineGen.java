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

import com.google.inject.Singleton;
import java.util.Comparator;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator;
import org.eclipse.etrice.generator.java.Main;
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
  
  /**
   * @param generateImplementation NOT used
   */
  @Override
  public CharSequence genExtra(final GraphContainer gc, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final List<Node> orderedStateNodes = IterableExtensions.<Node>sortWith(IteratorExtensions.<Node>toList(FsmGenExtensions.getAllStateNodes(gc.getGraph())), this.nodeComparator);
      StringConcatenation _builder = new StringConcatenation();
      {
        if ((Main.getSettings().isGenerateMSCInstrumentation() || Main.getSettings().isGenerateWithVerboseOutput())) {
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
            for(final Node node : orderedStateNodes) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              _builder.append("\"");
              StateGraphNode _stateGraphNode = node.getStateGraphNode();
              String _genStatePathName = this._codegenHelpers.getGenStatePathName(((State) _stateGraphNode));
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
        for(final Node state : orderedStateNodes) {
          _builder.append(", NO_STATE");
        }
      }
      _builder.append("};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("private void setState(int new_state) {");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);");
          _builder.newLine();
        }
      }
      {
        boolean _isGenerateWithVerboseOutput = Main.getSettings().isGenerateWithVerboseOutput();
        if (_isGenerateWithVerboseOutput) {
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
  @Override
  public CharSequence finalAction() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isGenerateStoreDataObj = Main.getSettings().isGenerateStoreDataObj();
      if (_isGenerateStoreDataObj) {
        _builder.append("finalAction();");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public int getHistorySize(final ExpandedActorClass xpac) {
    int _size = this._fSMHelpers.getAllBaseStates(xpac.getActorClass()).size();
    return (_size + 2);
  }
}
