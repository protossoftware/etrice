/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrr@protos.de (initial contribution)
 */
package org.eclipse.etrice.core.genmodel.fsm.tests;

import com.google.inject.Injector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.eclipse.etrice.core.TestBase;
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.tests.FSMGenModelTestsActivator;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FsmGenTestBase extends TestBase {
  protected Resource res = null;
  
  protected ActorClass actor;
  
  protected IDiagnostician diagnostician = new NullDiagnostician();
  
  @Extension
  protected ExtendedFsmGenBuilder builder;
  
  protected GraphContainer getGraphContainer(final String roomFile, final String actorName) {
    GraphContainer _xblockexpression = null;
    {
      this.prepare(FSMGenModelTestsActivator.getInstance().getBundle());
      this.res = this.getResource(roomFile);
      EObject _get = this.res.getContents().get(0);
      final Function1<ActorClass, Boolean> _function = new Function1<ActorClass, Boolean>() {
        @Override
        public Boolean apply(final ActorClass it) {
          return Boolean.valueOf(it.getName().equals(actorName));
        }
      };
      this.actor = IterableExtensions.<ActorClass>findFirst(((RoomModel) _get).getActorClasses(), _function);
      final Injector injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
      ExtendedFsmGenBuilder _extendedFsmGenBuilder = new ExtendedFsmGenBuilder(injector, this.diagnostician);
      this.builder = _extendedFsmGenBuilder;
      _xblockexpression = this.builder.createTransformedModel(this.actor);
    }
    return _xblockexpression;
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
}
