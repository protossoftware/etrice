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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.generic.PrepareFileSystem;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.ActorClassDataGen;
import org.eclipse.etrice.generator.java.gen.ActorClassGen;
import org.eclipse.etrice.generator.java.gen.DataClassGen;
import org.eclipse.etrice.generator.java.gen.EnumerationTypeGen;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.NodeGen;
import org.eclipse.etrice.generator.java.gen.NodeRunnerGen;
import org.eclipse.etrice.generator.java.gen.OptionalActorFactoryGen;
import org.eclipse.etrice.generator.java.gen.OptionalActorInterfaceGen;
import org.eclipse.etrice.generator.java.gen.ProtocolClassGen;

@Singleton
@SuppressWarnings("all")
public class MainGen {
  @Inject
  private DataClassGen dataClassGen;
  
  @Inject
  private EnumerationTypeGen enumTypeGen;
  
  @Inject
  private ProtocolClassGen protocolClassGen;
  
  @Inject
  private ActorClassGen actorClassGen;
  
  @Inject
  private ActorClassDataGen actorClassDataGen;
  
  @Inject
  private OptionalActorInterfaceGen optionalActorInterfaceGen;
  
  @Inject
  private OptionalActorFactoryGen optionalActorFactoryGen;
  
  @Inject
  private NodeGen nodeGen;
  
  @Inject
  private NodeRunnerGen nodeRunnerGen;
  
  @Inject
  private PrepareFileSystem prepFS;
  
  public void doGenerate(final Resource resource) {
    this.prepFS.prepareCodeTargetPaths(resource);
    EList<EObject> _contents = resource.getContents();
    for (final EObject e : _contents) {
      if ((e instanceof Root)) {
        this.doGenerate(((Root) e));
      }
    }
  }
  
  public void doGenerate(final Root e) {
    this.dataClassGen.doGenerate(e);
    this.enumTypeGen.doGenerate(e);
    this.protocolClassGen.doGenerate(e);
    this.actorClassGen.doGenerate(e);
    GlobalSettings _settings = Main.getSettings();
    boolean _isGenerateStoreDataObj = _settings.isGenerateStoreDataObj();
    if (_isGenerateStoreDataObj) {
      this.actorClassDataGen.doGenerate(e);
    }
    this.optionalActorInterfaceGen.doGenerate(e);
    this.optionalActorFactoryGen.doGenerate(e);
    this.nodeGen.doGenerate(e);
    boolean _isLibrary = e.isLibrary();
    boolean _not = (!_isLibrary);
    if (_not) {
      this.nodeRunnerGen.doGenerate(e);
    }
  }
}
