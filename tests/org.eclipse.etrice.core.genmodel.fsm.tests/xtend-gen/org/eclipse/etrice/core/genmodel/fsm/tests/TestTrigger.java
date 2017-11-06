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

import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestTrigger extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("TriggerExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
    this.builder.withTriggersInStates(this.gc);
    Assert.assertFalse("diagnostician has no errors", this.diagnostician.isFailed());
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state0_0"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertEquals("leave state triggers", 3, s.getCaughtTriggers().size());
  }
  
  @Test
  public void testNoTrigger() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state0"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("non-leave state has no caught triggers", 0, s.getCaughtTriggers().size());
  }
  
  @Test
  public void testTrigger_state0_0() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state0_0"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("leave state triggers", 3, s.getCaughtTriggers().size());
    Assert.assertEquals("1st trigger", this.trigger("in3"), s.getCaughtTriggers().get(0).getTrigger());
    Assert.assertEquals("1st trigger, transitions", 1, s.getCaughtTriggers().get(0).getLinks().size());
    Assert.assertEquals("2nd trigger", this.trigger("in1"), s.getCaughtTriggers().get(1).getTrigger());
    Assert.assertEquals("2nd trigger, transitions", 1, s.getCaughtTriggers().get(1).getLinks().size());
    Assert.assertEquals("3rd trigger", this.trigger("in2"), s.getCaughtTriggers().get(2).getTrigger());
    Assert.assertEquals("3rd trigger, transitions", 1, s.getCaughtTriggers().get(2).getLinks().size());
  }
  
  @Test
  public void testTrigger_state0_1() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state0_1"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("leave state triggers", 2, s.getCaughtTriggers().size());
    Assert.assertEquals("1st trigger", this.trigger("in2"), s.getCaughtTriggers().get(0).getTrigger());
    Assert.assertEquals("1st trigger, transitions", 1, s.getCaughtTriggers().get(0).getLinks().size());
    Assert.assertEquals("2nd trigger", this.trigger("in1"), s.getCaughtTriggers().get(1).getTrigger());
    Assert.assertEquals("2nd trigger, transitions", 1, s.getCaughtTriggers().get(1).getLinks().size());
  }
  
  @Test
  public void testTrigger_state1_0() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state1_0"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("leave state triggers", 2, s.getCaughtTriggers().size());
    Assert.assertEquals("1st trigger", this.trigger("in1"), s.getCaughtTriggers().get(0).getTrigger());
    Assert.assertEquals("1st trigger, transitions", 1, s.getCaughtTriggers().get(0).getLinks().size());
    Assert.assertEquals("2nd trigger", this.trigger("in2"), s.getCaughtTriggers().get(1).getTrigger());
    Assert.assertEquals("2nd trigger, transitions", 1, s.getCaughtTriggers().get(1).getLinks().size());
  }
  
  @Test
  public void testTrigger_state1_1() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state1_1"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("leave state triggers", 2, s.getCaughtTriggers().size());
    Assert.assertEquals("1st trigger", this.trigger("in1"), s.getCaughtTriggers().get(0).getTrigger());
    Assert.assertEquals("1st trigger, transitions", 3, s.getCaughtTriggers().get(0).getLinks().size());
    Assert.assertEquals("2nd trigger", this.trigger("in2"), s.getCaughtTriggers().get(1).getTrigger());
    Assert.assertEquals("2nd trigger, transitions", 1, s.getCaughtTriggers().get(1).getLinks().size());
  }
  
  public String trigger(final String msg) {
    return (("p0" + TriggerExtensions.TRIGGER_SEP) + msg);
  }
}
