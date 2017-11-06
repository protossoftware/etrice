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
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestCodeInheritance extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Extension
  private FSMHelpers fsmHelpers = new FSMHelpers();
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("CodeInheritanceExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
    Assert.assertFalse("diagnostician has no errors", this.diagnostician.isFailed());
  }
  
  @Test
  public void testActionCodes_BaseEntryExit() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("BaseEntryExit"));
      }
    };
    final Node s = IteratorExtensions.<Node>findFirst(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function);
    Assert.assertNotNull("state found", s);
    StateGraphNode _stateGraphNode = s.getStateGraphNode();
    Assert.assertTrue("refined state", (_stateGraphNode instanceof RefinedState));
    StateGraphNode _stateGraphNode_1 = s.getStateGraphNode();
    final RefinedState rs = ((RefinedState) _stateGraphNode_1);
    Assert.assertEquals("entry code", "// derived entry\n", this.fsmHelpers.getDetailCode(rs.getEntryCode()));
    Assert.assertNull("exit code", rs.getExitCode());
    Assert.assertEquals("inherited entry", "// base entry\n", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedEntryCode(rs)));
    Assert.assertEquals("inherited exit", "// base exit\n", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedExitCode(rs)));
  }
  
  @Test
  public void testActionCodes_Base() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("Base"));
      }
    };
    final Node s = IteratorExtensions.<Node>findFirst(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function);
    Assert.assertNotNull("state found", s);
    StateGraphNode _stateGraphNode = s.getStateGraphNode();
    Assert.assertTrue("refined state", (_stateGraphNode instanceof RefinedState));
    StateGraphNode _stateGraphNode_1 = s.getStateGraphNode();
    final RefinedState rs = ((RefinedState) _stateGraphNode_1);
    Assert.assertNull("entry code", rs.getEntryCode());
    Assert.assertEquals("exit code", "// derived exit\n", this.fsmHelpers.getDetailCode(rs.getExitCode()));
    Assert.assertEquals("inherited entry", "", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedEntryCode(rs)));
    Assert.assertEquals("inherited exit", "", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedExitCode(rs)));
  }
  
  @Test
  public void testActionCodes_BaseSub() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("BaseSub"));
      }
    };
    final Node s = IteratorExtensions.<Node>findFirst(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function);
    Assert.assertNotNull("state found", s);
    StateGraphNode _stateGraphNode = s.getStateGraphNode();
    Assert.assertTrue("refined state", (_stateGraphNode instanceof RefinedState));
    StateGraphNode _stateGraphNode_1 = s.getStateGraphNode();
    final RefinedState rs = ((RefinedState) _stateGraphNode_1);
    Assert.assertEquals("entry code", "// derived entry\n", this.fsmHelpers.getDetailCode(rs.getEntryCode()));
    Assert.assertNull("exit code", rs.getExitCode());
    Assert.assertEquals("inherited entry", "", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedEntryCode(rs)));
    Assert.assertEquals("inherited exit", "", this.fsmHelpers.getDetailCode(this.fsmHelpers.getInheritedExitCode(rs)));
  }
}
