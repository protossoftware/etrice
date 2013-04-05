/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private CExtensions _cExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private /* StateMachineGen */Object _stateMachineGen;
  
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_1);
        String path = (_generationTargetPath + _path);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _cHeaderFileName = this._cExtensions.getCHeaderFileName(_actorClass_2);
        String _plus = ("generating ActorClass header \'" + _cHeaderFileName);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _cHeaderFileName_1 = this._cExtensions.getCHeaderFileName(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, xpac, _actorClass_4);
        this.fileAccess.generateFile(_cHeaderFileName_1, _generateHeaderFile);
        boolean _hasBehaviorAnnotation = this.hasBehaviorAnnotation(xpac, "BehaviorManual");
        if (_hasBehaviorAnnotation) {
          ActorClass _actorClass_5 = xpac.getActorClass();
          String _name = _actorClass_5.getName();
          String _plus_4 = ("omitting ActorClass source for \'" + _name);
          String _plus_5 = (_plus_4 + "\' since @BehaviorManual is specified");
          this.logger.logInfo(_plus_5);
        } else {
          ActorClass _actorClass_6 = xpac.getActorClass();
          String _cSourceFileName = this._cExtensions.getCSourceFileName(_actorClass_6);
          String _plus_6 = ("generating ActorClass source \'" + _cSourceFileName);
          String _plus_7 = (_plus_6 + "\' in \'");
          String _plus_8 = (_plus_7 + path);
          String _plus_9 = (_plus_8 + "\'");
          this.logger.logInfo(_plus_9);
          this.fileAccess.setOutputPath(path);
          ActorClass _actorClass_7 = xpac.getActorClass();
          String _cSourceFileName_1 = this._cExtensions.getCSourceFileName(_actorClass_7);
          ActorClass _actorClass_8 = xpac.getActorClass();
          CharSequence _generateSourceFile = this.generateSourceFile(root, xpac, _actorClass_8);
          this.fileAccess.generateFile(_cSourceFileName_1, _generateSourceFile);
        }
      }
    }
  }
  
  private boolean hasBehaviorAnnotation(final ExpandedActorClass xpac, final String annotation) {
    ActorClass _actorClass = xpac.getActorClass();
    EList<Annotation> _behaviorAnnotations = _actorClass.getBehaviorAnnotations();
    boolean _notEquals = (!Objects.equal(_behaviorAnnotations, null));
    if (_notEquals) {
      ActorClass _actorClass_1 = xpac.getActorClass();
      EList<Annotation> _behaviorAnnotations_1 = _actorClass_1.getBehaviorAnnotations();
      final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
          public Boolean apply(final Annotation e) {
            String _name = e.getName();
            boolean _equals = Objects.equal(_name, annotation);
            return Boolean.valueOf(_equals);
          }
        };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_behaviorAnnotations_1, _function);
      boolean _notEquals_1 = (!Objects.equal(_findFirst, null));
      if (_notEquals_1) {
        return true;
      }
    }
    return false;
  }
  
  private CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method genHeaderConstants is undefined for the type ActorClassGen"
      + "\nThe method genDataMembers is undefined for the type ActorClassGen");
  }
  
  private CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method genStateMachine is undefined for the type ActorClassGen"
      + "\nThe method genInitialization is undefined for the type ActorClassGen");
  }
}
