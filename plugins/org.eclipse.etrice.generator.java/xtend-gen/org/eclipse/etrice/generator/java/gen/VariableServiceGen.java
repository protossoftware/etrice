/**
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class VariableServiceGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private JavaExtensions stdExt;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  private IDataConfiguration configExt;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  @Extension
  private /* TypeHelpers */Object _typeHelpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root, final SubSystemInstance ssi) {
    SubSystemClass _subSystemClass = ssi.getSubSystemClass();
    String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
    SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
    String _path = this.roomExt.getPath(_subSystemClass_1);
    String path = (_generationTargetPath + _path);
    SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
    String _name = _subSystemClass_2.getName();
    String file = (_name + "VariableService.java");
    String _plus = ("generating VariableService implementation: \'" + file);
    String _plus_1 = (_plus + "\' in \'");
    String _plus_2 = (_plus_1 + path);
    String _plus_3 = (_plus_2 + "\'");
    this.logger.logInfo(_plus_3);
    this.fileAccess.setOutputPath(path);
    CharSequence _generate = this.generate(root, ssi);
    this.fileAccess.generateFile(file, _generate);
  }
  
  private CharSequence generate(final Root root, final SubSystemInstance comp) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method allAttributes is undefined for the type VariableServiceGen"
      + "\nThe method refType is undefined for the type VariableServiceGen"
      + "\nThe method name is undefined for the type VariableServiceGen"
      + "\nThe method name is undefined for the type VariableServiceGen"
      + "\nThe method name is undefined for the type VariableServiceGen"
      + "\nThe method name is undefined for the type VariableServiceGen"
      + "\nType mismatch: cannot convert from Object to Iterable<?>"
      + "\nType mismatch: cannot convert from Object to Iterable<?>"
      + "\nprimitive cannot be resolved"
      + "\ntype cannot be resolved");
  }
  
  private CharSequence genMinMaxCheck(final List<Attribute> path, final ActorClass ac) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method typeName is undefined for the type VariableServiceGen");
  }
  
  private HashSet<DataClass> getDynConfigDataClasses(final Iterable<ActorInstance> ais) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method dataClass is undefined for the type VariableServiceGen");
  }
  
  private HashSet<DataClass> getAllDataClasses(final Iterable<DataClass> dcs) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method allAttributes is undefined for the type VariableServiceGen"
      + "\nThe method refType is undefined for the type VariableServiceGen"
      + "\nThe method refType is undefined for the type VariableServiceGen"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nforEach cannot be resolved"
      + "\ndataClass cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntype cannot be resolved");
  }
  
  private HashSet<RoomModel> getRoomModels(final Collection<ActorInstance> ais) {
    HashSet<RoomModel> _hashSet = new HashSet<RoomModel>();
    final HashSet<RoomModel> models = _hashSet;
    final Procedure1<ActorInstance> _function = new Procedure1<ActorInstance>() {
        public void apply(final ActorInstance ai) {
          ActorClass _actorClass = ai.getActorClass();
          EObject _eContainer = _actorClass.eContainer();
          models.add(((RoomModel) _eContainer));
        }
      };
    IterableExtensions.<ActorInstance>forEach(ais, _function);
    return models;
  }
  
  private String toAbsolutePath(final List<Attribute> path, final String pathDelim) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Attribute p : path) {
        _builder.append(pathDelim, "");
        String _name = p.getName();
        _builder.append(_name, "");
      }
    }
    String _string = _builder.toString();
    return _string;
  }
  
  private CharSequence getVarName(final ActorInstance ai) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _path = ai.getPath();
      String[] _split = _path.split("/");
      Iterable<String> _drop = IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(_split)), 2);
      boolean _hasElements = false;
      for(final String p : _drop) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("_", "");
        }
        _builder.append(p, "");
      }
    }
    return _builder;
  }
  
  private CharSequence genGetAttributeValues(final List<Attribute> path, final ActorInstance ai) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method primitive is undefined for the type VariableServiceGen"
      + "\nThe method dataClass is undefined for the type VariableServiceGen"
      + "\nThe method allAttributes is undefined for the type VariableServiceGen");
  }
  
  private CharSequence genSetAttributeValues1(final List<Attribute> path, final ActorInstance ai) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method primitive is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method typeName is undefined for the type VariableServiceGen"
      + "\nThe method dataClass is undefined for the type VariableServiceGen"
      + "\nThe method allAttributes is undefined for the type VariableServiceGen"
      + "\ntoWrapper cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\ntoWrapper cannot be resolved");
  }
  
  private CharSequence genSetAttributeValues2(final List<Attribute> path, final ActorInstance ai) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method primitive is undefined for the type VariableServiceGen"
      + "\nThe method dataClass is undefined for the type VariableServiceGen"
      + "\nThe method allAttributes is undefined for the type VariableServiceGen");
  }
}
