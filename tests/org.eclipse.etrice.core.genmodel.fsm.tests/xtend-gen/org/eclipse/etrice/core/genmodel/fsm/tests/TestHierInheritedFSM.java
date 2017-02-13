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

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.genmodel.fsm.tests.FsmGenTestBase;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestHierInheritedFSM extends FsmGenTestBase {
  private GraphContainer gc;
  
  @Before
  public void SetUp() {
    GraphContainer _graphContainer = this.getGraphContainer("HierInheritedFSMExample.room", "TestActor");
    this.gc = _graphContainer;
    Assert.assertNotNull("graph context was created", this.gc);
    final NullLogger logger = new NullLogger();
    FsmGenChecker.check(this.gc, logger);
    boolean _hasErrors = logger.hasErrors();
    Assert.assertFalse("logger has no errors", _hasErrors);
    this.save(this.gc, "HierInheritedFSMExample");
  }
  
  @Test
  public void testHierInheritedFSMItemCounts() {
    Graph _graph = this.gc.getGraph();
    EList<Node> _nodes = _graph.getNodes();
    int _size = _nodes.size();
    Assert.assertEquals("number of nodes", 4, _size);
    Graph _graph_1 = this.gc.getGraph();
    EList<Link> _links = _graph_1.getLinks();
    int _size_1 = _links.size();
    Assert.assertEquals("number of links", 6, _size_1);
    Graph _graph_2 = this.gc.getGraph();
    Iterable<Node> _stateNodes = FsmGenExtensions.getStateNodes(_graph_2);
    int _size_2 = IterableExtensions.size(_stateNodes);
    Assert.assertEquals("number of states", 4, _size_2);
    Graph _graph_3 = this.gc.getGraph();
    Iterable<Node> _trPointNodes = FsmGenExtensions.getTrPointNodes(_graph_3);
    int _size_3 = IterableExtensions.size(_trPointNodes);
    Assert.assertEquals("number of tr points", 0, _size_3);
    Graph _graph_4 = this.gc.getGraph();
    Iterable<Node> _choicePointNodes = FsmGenExtensions.getChoicePointNodes(_graph_4);
    int _size_4 = IterableExtensions.size(_choicePointNodes);
    Assert.assertEquals("number of choice points", 0, _size_4);
  }
  
  @Test
  public void testHierInheritedFSMDeepItemCounts() {
    Graph _graph = this.gc.getGraph();
    Iterator<Node> _allNodes = FsmGenExtensions.getAllNodes(_graph);
    int _size = IteratorExtensions.size(_allNodes);
    Assert.assertEquals("number of nodes", 12, _size);
    Graph _graph_1 = this.gc.getGraph();
    Iterator<Link> _allLinks = FsmGenExtensions.getAllLinks(_graph_1);
    int _size_1 = IteratorExtensions.size(_allLinks);
    Assert.assertEquals("number of links", 14, _size_1);
    Graph _graph_2 = this.gc.getGraph();
    Iterator<Node> _allStateNodes = FsmGenExtensions.getAllStateNodes(_graph_2);
    int _size_2 = IteratorExtensions.size(_allStateNodes);
    Assert.assertEquals("number of states", 10, _size_2);
    Graph _graph_3 = this.gc.getGraph();
    Iterator<Node> _allTrPointNodes = FsmGenExtensions.getAllTrPointNodes(_graph_3);
    int _size_3 = IteratorExtensions.size(_allTrPointNodes);
    Assert.assertEquals("number of tr points", 2, _size_3);
    Graph _graph_4 = this.gc.getGraph();
    Iterator<Node> _allChoicePointNodes = FsmGenExtensions.getAllChoicePointNodes(_graph_4);
    int _size_4 = IteratorExtensions.size(_allChoicePointNodes);
    Assert.assertEquals("number of choice points", 0, _size_4);
  }
  
  @Test
  public void testHierInheritedFSMLinks() {
    Graph _graph = this.gc.getGraph();
    Iterator<Node> _allStateNodes = FsmGenExtensions.getAllStateNodes(_graph);
    final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
      @Override
      public Boolean apply(final Node it) {
        String _name = FsmGenExtensions.getName(it);
        return Boolean.valueOf(_name.equals("state1_0"));
      }
    };
    Iterator<Node> _filter = IteratorExtensions.<Node>filter(_allStateNodes, _function);
    final Node s = IteratorExtensions.<Node>head(_filter);
    Assert.assertNotNull("state found", s);
    EList<Link> _incoming = s.getIncoming();
    int _size = _incoming.size();
    Assert.assertEquals("incoming links", 2, _size);
    EList<Link> _outgoing = s.getOutgoing();
    int _size_1 = _outgoing.size();
    Assert.assertEquals("outgoing links", 1, _size_1);
  }
}
