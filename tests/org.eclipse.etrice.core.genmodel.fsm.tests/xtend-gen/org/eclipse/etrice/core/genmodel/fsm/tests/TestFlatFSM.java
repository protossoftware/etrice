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

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
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
public class TestFlatFSM extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("FlatFSMExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
  }
  
  @Test
  public void testFlatFSMItemCounts() {
    Assert.assertEquals("number of nodes", 6, this.gc.getGraph().getNodes().size());
    Assert.assertEquals("number of links", 6, this.gc.getGraph().getLinks().size());
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof State));
      }
    };
    Assert.assertEquals("number of states", 4, IterableExtensions.size(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function)));
    final Function1<Node, Boolean> _function_1 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof TrPoint));
      }
    };
    Assert.assertEquals("number of tr points", 1, IterableExtensions.size(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function_1)));
    final Function1<Node, Boolean> _function_2 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return Boolean.valueOf((_stateGraphNode instanceof ChoicePoint));
      }
    };
    Assert.assertEquals("number of choice points", 1, IterableExtensions.size(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function_2)));
  }
  
  @Test
  public void testFlatFSMState1Connections() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state1"));
      }
    };
    final Node s1 = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(FsmGenExtensions.getStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s1);
    Assert.assertEquals("incoming links", 1, s1.getIncoming().size());
    Assert.assertEquals("outgoing links", 1, s1.getOutgoing().size());
  }
  
  @Test
  public void testFlatFSMState3Connections() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state3"));
      }
    };
    final Node s3 = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(FsmGenExtensions.getStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s3);
    Assert.assertEquals("incoming links", 1, s3.getIncoming().size());
    Assert.assertEquals("outgoing links", 0, s3.getOutgoing().size());
  }
  
  @Test
  public void testFlatFSMCPConnections() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("cp0"));
      }
    };
    final Node cp = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(FsmGenExtensions.getChoicePointNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("choice point found", cp);
    Assert.assertEquals("incoming links", 1, cp.getIncoming().size());
    Assert.assertEquals("outgoing links", 2, cp.getOutgoing().size());
  }
}
