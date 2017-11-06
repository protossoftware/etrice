/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.commands;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.eclipse.etrice.core.TestBase;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.ui.behavior.BehaviorTestActivator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestFSMGenModel extends TestBase {
  private final Injector injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
  
  protected IDiagnostician diagnostician = new NullDiagnostician();
  
  @Extension
  protected ExtendedFsmGenBuilder builder = new ExtendedFsmGenBuilder(this.injector, this.diagnostician);
  
  protected ResourceSet createResourceSetWithGc(final String roomFile, final String actorName) {
    this.prepare(BehaviorTestActivator.getDefault().getBundle());
    final Resource res = this.getResource(roomFile);
    EObject _get = res.getContents().get(0);
    final Function1<ActorClass, Boolean> _function = (ActorClass it) -> {
      return Boolean.valueOf(it.getName().equals(actorName));
    };
    final ActorClass actor = IterableExtensions.<ActorClass>findFirst(((RoomModel) _get).getActorClasses(), _function);
    GraphContainer _createTransformedModel = this.builder.createTransformedModel(actor);
    final Procedure1<GraphContainer> _function_1 = (GraphContainer gc) -> {
      Assert.assertNotNull("graph context was created", gc);
      final NullLogger logger = new NullLogger();
      FsmGenChecker.check(gc, logger);
      Assert.assertFalse("logger has no errors", logger.hasErrors());
      this.save(gc, actor.getName());
    };
    final GraphContainer gc = ObjectExtensions.<GraphContainer>operator_doubleArrow(_createTransformedModel, _function_1);
    Resource _createResource = res.getResourceSet().createResource(URI.createURI((("dummy://" + actorName) + ".fsmgen")));
    final Procedure1<Resource> _function_2 = (Resource it) -> {
      EList<EObject> _contents = it.getContents();
      _contents.add(gc);
    };
    ObjectExtensions.<Resource>operator_doubleArrow(_createResource, _function_2);
    return res.getResourceSet();
  }
  
  protected void save(final GraphContainer gc, final String fileName) {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      final URI uri = URI.createFileURI((("./output/" + fileName) + ".fsmgen"));
      final Resource res = rs.createResource(uri);
      res.getContents().add(gc);
      res.save(CollectionLiterals.<Object, Object>newHashMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBaseClass() {
    final ResourceSet rs = this.createResourceSetWithGc("InheritedStateMachine.room", "Base");
    final Function1<ActorClass, Boolean> _function = (ActorClass it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, "Base"));
    };
    final List<ActorClass> actorClasses = IteratorExtensions.<ActorClass>toList(IteratorExtensions.<ActorClass>filter(Iterators.<ActorClass>filter(EcoreUtil.<Object>getAllContents(rs, true), ActorClass.class), _function));
    final Function1<Resource, EList<EObject>> _function_1 = (Resource it) -> {
      return it.getContents();
    };
    final GraphContainer gc = IterableExtensions.<GraphContainer>head(Iterables.<GraphContainer>filter(Iterables.<EObject>concat(ListExtensions.<Resource, EList<EObject>>map(rs.getResources(), _function_1)), GraphContainer.class));
    this.checkAgainstRoom(gc, actorClasses);
  }
  
  @Test
  public void testDerivedClass() {
    final ResourceSet rs = this.createResourceSetWithGc("InheritedStateMachine.room", "Derived");
    final Function1<ActorClass, Boolean> _function = (ActorClass it) -> {
      return Boolean.valueOf((Objects.equal(it.getName(), "Base") || Objects.equal(it.getName(), "Derived")));
    };
    final List<ActorClass> actorClasses = IteratorExtensions.<ActorClass>toList(IteratorExtensions.<ActorClass>filter(Iterators.<ActorClass>filter(EcoreUtil.<Object>getAllContents(rs, true), ActorClass.class), _function));
    final Function1<Resource, EList<EObject>> _function_1 = (Resource it) -> {
      return it.getContents();
    };
    final GraphContainer gc = IterableExtensions.<GraphContainer>head(Iterables.<GraphContainer>filter(Iterables.<EObject>concat(ListExtensions.<Resource, EList<EObject>>map(rs.getResources(), _function_1)), GraphContainer.class));
    this.checkAgainstRoom(gc, actorClasses);
  }
  
  @Test
  public void testDoubleDerivedClass() {
    final ResourceSet rs = this.createResourceSetWithGc("InheritedStateMachine.room", "DoubleDerived");
    final Function1<ActorClass, Boolean> _function = (ActorClass it) -> {
      return Boolean.valueOf(((Objects.equal(it.getName(), "Base") || Objects.equal(it.getName(), "Derived")) || Objects.equal(it.getName(), "DoubleDerived")));
    };
    final List<ActorClass> actorClasses = IteratorExtensions.<ActorClass>toList(IteratorExtensions.<ActorClass>filter(Iterators.<ActorClass>filter(EcoreUtil.<Object>getAllContents(rs, true), ActorClass.class), _function));
    final Function1<Resource, EList<EObject>> _function_1 = (Resource it) -> {
      return it.getContents();
    };
    final GraphContainer gc = IterableExtensions.<GraphContainer>head(Iterables.<GraphContainer>filter(Iterables.<EObject>concat(ListExtensions.<Resource, EList<EObject>>map(rs.getResources(), _function_1)), GraphContainer.class));
    this.checkAgainstRoom(gc, actorClasses);
  }
  
  public void checkAgainstRoom(final GraphContainer gc, final List<ActorClass> actorClasses) {
    final Function1<Node, StateGraphNode> _function = (Node it) -> {
      return it.getStateGraphNode();
    };
    Iterator<StateGraphNode> _map = IteratorExtensions.<Node, StateGraphNode>map(Iterators.<Node>filter(EcoreUtil.<Object>getAllContents(gc, true), Node.class), _function);
    final Function1<Link, TransitionBase> _function_1 = (Link it) -> {
      return it.getTransition();
    };
    Iterator<TransitionBase> _map_1 = IteratorExtensions.<Link, TransitionBase>map(Iterators.<Link>filter(EcoreUtil.<Object>getAllContents(gc, true), Link.class), _function_1);
    final Set<StateGraphItem> genModelRefs = IteratorExtensions.<StateGraphItem>toSet(Iterators.<StateGraphItem>concat(_map, _map_1));
    final Procedure1<StateGraphItem> _function_2 = (StateGraphItem it) -> {
      URI _uRI = EcoreUtil.getURI(it);
      String _plus = ("missing " + _uRI);
      Assert.assertTrue(_plus, genModelRefs.contains(it));
    };
    IteratorExtensions.<StateGraphItem>forEach(Iterators.<StateGraphItem>filter(EcoreUtil.<Object>getAllContents(IterableExtensions.<ActorClass>last(actorClasses), false), StateGraphItem.class), _function_2);
    final Function1<StateGraphItem, String> _function_3 = (StateGraphItem it) -> {
      return it.getName();
    };
    final TreeSet<String> stateGraphItemsNames = this.<String>toSortedSet(IteratorExtensions.<String>toIterable(IteratorExtensions.<StateGraphItem, String>map(Iterators.<StateGraphItem>filter(EcoreUtil.<Object>getAllContents(actorClasses, true), StateGraphItem.class), _function_3)));
    final Function1<StateGraphItem, String> _function_4 = (StateGraphItem it) -> {
      return it.getName();
    };
    final TreeSet<String> namesFromGenModel = this.<String>toSortedSet(IterableExtensions.<StateGraphItem, String>map(genModelRefs, _function_4));
    Assert.assertEquals(stateGraphItemsNames, namesFromGenModel);
  }
  
  private <T extends Comparable> TreeSet<T> toSortedSet(final Iterable<T> iterable) {
    return Sets.<T>newTreeSet(iterable);
  }
}
