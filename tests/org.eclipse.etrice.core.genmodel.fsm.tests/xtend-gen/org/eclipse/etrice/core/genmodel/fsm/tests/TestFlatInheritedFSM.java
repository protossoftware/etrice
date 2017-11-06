/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm.tests;

import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestFlatInheritedFSM extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("FlatInheritedFSMExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
  }
  
  @Test
  public void testFlatInheritedFSMItemCounts() {
    Assert.assertEquals("number of nodes", 6, this.gc.getGraph().getNodes().size());
    Assert.assertEquals("number of links", 6, this.gc.getGraph().getLinks().size());
    Assert.assertEquals("number of states", 6, IterableExtensions.size(FsmGenExtensions.getStateNodes(this.gc.getGraph())));
    Assert.assertEquals("number of tr points", 0, IterableExtensions.size(FsmGenExtensions.getTrPointNodes(this.gc.getGraph())));
    Assert.assertEquals("number of choice points", 0, IterableExtensions.size(FsmGenExtensions.getChoicePointNodes(this.gc.getGraph())));
  }
  
  @Test
  public void testFlatInheritedFSMState0Connections() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state0"));
      }
    };
    final Node s = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(FsmGenExtensions.getStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("incoming links", 1, s.getIncoming().size());
    Assert.assertEquals("outgoing links", 1, s.getOutgoing().size());
  }
  
  @Test
  public void testHierFSMPointersIntoOriginalFSM() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state1"));
      }
    };
    final Node n = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(FsmGenExtensions.getStateNodes(this.gc.getGraph()), _function));
    final Function1<State, Boolean> _function_1 = new Function1<State, Boolean>() {
      @Override
      public Boolean apply(final State it) {
        return Boolean.valueOf(it.getName().equals("state1"));
      }
    };
    final State s = IterableExtensions.<State>head(IterableExtensions.<State>filter(this.actor.getStateMachine().getStates(), _function_1));
    Assert.assertNotNull("node found", n);
    Assert.assertNotNull("state found", s);
    StateGraphNode _stateGraphNode = n.getStateGraphNode();
    Assert.assertTrue("RefinedState expected", (_stateGraphNode instanceof RefinedState));
    Assert.assertEquals("correct target", s, n.getStateGraphNode());
  }
}
