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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestMultipleConnectedChoicepoint extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    this.gc = this.getGraphContainer("MultipleConnectedChoicepointExample.room", "TestActor");
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    Assert.assertFalse("logger has no errors", logger.hasErrors());
    this.builder.withCommonData(this.builder.withChainHeads(this.builder.withTriggersInStates(this.gc)));
    Assert.assertFalse("diagnostician has no errors", this.diagnostician.isFailed());
  }
  
  @Test
  public void testObjectNumbers() {
    Assert.assertEquals("Number of states", 6, IteratorExtensions.size(FsmGenExtensions.getAllStateNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of choice points", 1, IteratorExtensions.size(FsmGenExtensions.getAllChoicePointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of transition points", 0, IteratorExtensions.size(FsmGenExtensions.getAllTransitionPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of entry points", 1, IteratorExtensions.size(FsmGenExtensions.getAllEntryPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of exit points", 1, IteratorExtensions.size(FsmGenExtensions.getAllExitPointNodes(this.gc.getGraph())));
    Assert.assertEquals("Number of initial transitions", 1, IteratorExtensions.size(FsmGenExtensions.getAllInitialTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of triggered transitions", 5, IteratorExtensions.size(FsmGenExtensions.getAllTriggeredTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of continuation transitions", 3, IteratorExtensions.size(FsmGenExtensions.getAllContinuationTranisitionLinks(this.gc.getGraph())));
    Assert.assertEquals("Number of cpbranch transitions", 1, IteratorExtensions.size(FsmGenExtensions.getAllCPBranchTranisitionLinks(this.gc.getGraph())));
  }
  
  @Test
  public void testChainsAndTriggers() {
    Assert.assertEquals("transition chains", 6, IteratorExtensions.size(FsmGenExtensions.getAllChainHeads(this.gc.getGraph())));
  }
  
  @Test
  public void testData() {
    final Function1<Link, Boolean> _function = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr0"));
      }
    };
    Link tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(this.gc.getGraph().getLinks(), _function));
    Assert.assertNotNull("transition found", tr);
    TransitionBase _transition = tr.getTransition();
    Assert.assertTrue("transition is TriggeredTransition", (_transition instanceof TriggeredTransition));
    EObject _commonData = tr.getCommonData();
    VarDecl data = ((VarDecl) _commonData);
    DataType _type = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type instanceof DataClass));
    Assert.assertEquals("data is of type", "DC2", data.getRefType().getType().getName());
    final Function1<Node, Boolean> _function_1 = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        return Boolean.valueOf(it.getStateGraphNode().getName().equals("state1"));
      }
    };
    final Node s = IterableExtensions.<Node>head(IterableExtensions.<Node>filter(this.gc.getGraph().getNodes(), _function_1));
    Assert.assertNotNull("state found", s);
    final Function1<Link, Boolean> _function_2 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr2"));
      }
    };
    tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(s.getSubgraph().getLinks(), _function_2));
    TransitionBase _transition_1 = tr.getTransition();
    Assert.assertTrue("transition is TriggeredTransition", (_transition_1 instanceof TriggeredTransition));
    EObject _commonData_1 = tr.getCommonData();
    data = ((VarDecl) _commonData_1);
    DataType _type_1 = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type_1 instanceof DataClass));
    Assert.assertEquals("data is of type", "DC2", data.getRefType().getType().getName());
    final Function1<Link, Boolean> _function_3 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr3"));
      }
    };
    tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(s.getSubgraph().getLinks(), _function_3));
    TransitionBase _transition_2 = tr.getTransition();
    Assert.assertTrue("transition is TriggeredTransition", (_transition_2 instanceof TriggeredTransition));
    EObject _commonData_2 = tr.getCommonData();
    data = ((VarDecl) _commonData_2);
    DataType _type_2 = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type_2 instanceof DataClass));
    Assert.assertEquals("data is of type", "DC4", data.getRefType().getType().getName());
    final Function1<Link, Boolean> _function_4 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr1"));
      }
    };
    tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(this.gc.getGraph().getLinks(), _function_4));
    Assert.assertNotNull("transition found", tr);
    TransitionBase _transition_3 = tr.getTransition();
    Assert.assertTrue("transition is TriggeredTransition", (_transition_3 instanceof TriggeredTransition));
    EObject _commonData_3 = tr.getCommonData();
    data = ((VarDecl) _commonData_3);
    DataType _type_3 = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type_3 instanceof DataClass));
    Assert.assertEquals("data is of type", "DC3", data.getRefType().getType().getName());
    final Function1<Link, Boolean> _function_5 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr3"));
      }
    };
    tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(this.gc.getGraph().getLinks(), _function_5));
    Assert.assertNotNull("transition found", tr);
    TransitionBase _transition_4 = tr.getTransition();
    Assert.assertTrue("transition is ContinuationTransition", (_transition_4 instanceof ContinuationTransition));
    EObject _commonData_4 = tr.getCommonData();
    data = ((VarDecl) _commonData_4);
    DataType _type_4 = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type_4 instanceof DataClass));
    Assert.assertEquals("data is of type", "DC", data.getRefType().getType().getName());
    final Function1<Link, Boolean> _function_6 = new Function1<Link, Boolean>() {
      @Override
      public Boolean apply(final Link it) {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf(((Transition) _transition).getName().equals("tr4"));
      }
    };
    tr = IterableExtensions.<Link>head(IterableExtensions.<Link>filter(this.gc.getGraph().getLinks(), _function_6));
    Assert.assertNotNull("transition found", tr);
    TransitionBase _transition_5 = tr.getTransition();
    Assert.assertTrue("transition is CPBranchTransition", (_transition_5 instanceof CPBranchTransition));
    EObject _commonData_5 = tr.getCommonData();
    data = ((VarDecl) _commonData_5);
    DataType _type_5 = data.getRefType().getType();
    Assert.assertTrue("data is DataClass", (_type_5 instanceof DataClass));
    Assert.assertEquals("data is of type", "DC", data.getRefType().getType().getName());
  }
}
