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

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestHierInheritedFSM extends FsmGenTestBase {
  private GraphContainer gc;
  
  private GraphContainer gc2;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("HierInheritedFSMExample.room", "TestActor");
    this.gc2 = this.getGraphContainer("HierInheritedFSMExample.room", "TestActor2");
    Assert.assertNotNull("graph context was created", this.gc);
    Assert.assertNotNull("graph context was created", this.gc2);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
    this.save(this.gc, "HierInheritedFSMExample");
    this.save(this.gc2, "HierInheritedFSMExample2");
  }
  
  @Test
  public void testHierInheritedFSMItemCounts() {
    Assert.assertEquals("number of nodes", 4, this.gc.getGraph().getNodes().size());
    Assert.assertEquals("number of links", 6, this.gc.getGraph().getLinks().size());
    Assert.assertEquals("number of states", 4, IterableExtensions.size(FsmGenExtensions.getStateNodes(this.gc.getGraph())));
    Assert.assertEquals("number of tr points", 0, IterableExtensions.size(FsmGenExtensions.getTrPointNodes(this.gc.getGraph())));
    Assert.assertEquals("number of choice points", 0, IterableExtensions.size(FsmGenExtensions.getChoicePointNodes(this.gc.getGraph())));
  }
  
  @Test
  public void testHierInheritedFSMDeepItemCounts() {
    Assert.assertEquals("number of nodes", 12, IteratorExtensions.size(FsmGenExtensions.getAllNodes(this.gc.getGraph())));
    Assert.assertEquals("number of links", 14, IteratorExtensions.size(FsmGenExtensions.getAllLinks(this.gc.getGraph())));
    Assert.assertEquals("number of states", 10, IteratorExtensions.size(FsmGenExtensions.getAllStateNodes(this.gc.getGraph())));
    Assert.assertEquals("number of tr points", 2, IteratorExtensions.size(FsmGenExtensions.getAllTrPointNodes(this.gc.getGraph())));
    Assert.assertEquals("number of choice points", 0, IteratorExtensions.size(FsmGenExtensions.getAllChoicePointNodes(this.gc.getGraph())));
  }
  
  @Test
  public void testHierInheritedFSMLinks() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(FsmGenExtensions.getName(it).equals("state1_0"));
      }
    };
    final Node s = IteratorExtensions.<Node>head(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(this.gc.getGraph()), _function));
    Assert.assertNotNull("state found", s);
    Assert.assertEquals("incoming links", 2, s.getIncoming().size());
    Assert.assertEquals("outgoing links", 1, s.getOutgoing().size());
  }
  
  @Test
  public void testOriginRefs() {
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        String _name = it.getStateGraphNode().getName();
        return Boolean.valueOf(Objects.equal(_name, "state0"));
      }
    };
    Iterable<Node> _filter = IterableExtensions.<Node>filter(this.gc2.getGraph().getNodes(), _function);
    final Procedure1<Iterable<Node>> _function_1 = new Procedure1<Iterable<Node>>() {
      @Override
      public void apply(final Iterable<Node> it) {
        Assert.assertEquals(1, IterableExtensions.size(it));
        Assert.assertEquals("RefinedState:TestActor2$state0", EcoreUtil.getURI(IterableExtensions.<Node>head(it).getStateGraphNode()).fragment());
      }
    };
    ObjectExtensions.<Iterable<Node>>operator_doubleArrow(_filter, _function_1);
    final Function1<Link, Boolean> _function_2 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        String _name = it.getTransition().getName();
        return Boolean.valueOf(Objects.equal(_name, "tr3"));
      }
    };
    Iterable<Link> _filter_1 = IterableExtensions.<Link>filter(this.gc2.getGraph().getLinks(), _function_2);
    final Procedure1<Iterable<Link>> _function_3 = new Procedure1<Iterable<Link>>() {
      @Override
      public void apply(final Iterable<Link> it) {
        Assert.assertEquals(1, IterableExtensions.size(it));
        Assert.assertEquals("RefinedTransition:TestActor2$tr3", EcoreUtil.getURI(IterableExtensions.<Link>head(it).getTransition()).fragment());
      }
    };
    ObjectExtensions.<Iterable<Link>>operator_doubleArrow(_filter_1, _function_3);
  }
}
