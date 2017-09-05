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
package org.eclipse.etrice.generator.launch;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.scoping.ModelLocator;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GeneratorLaunchHelper {
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Inject
  private ModelLocator modelLocator;
  
  /**
   * @return all transitive dependencies from .etmap files within their projects
   */
  public static Collection<String> getAllDependenciesWithinProjects(final Iterable<String> models) {
    LinkedHashSet<String> _xblockexpression = null;
    {
      GeneratorLaunchHelper _generatorLaunchHelper = new GeneratorLaunchHelper();
      final Procedure1<GeneratorLaunchHelper> _function = (GeneratorLaunchHelper it) -> {
        Injector _injector = RoomUiModule.getInjector();
        _injector.injectMembers(it);
      };
      final GeneratorLaunchHelper helper = ObjectExtensions.<GeneratorLaunchHelper>operator_doubleArrow(_generatorLaunchHelper, _function);
      LinkedHashSet<String> _newLinkedHashSet = CollectionLiterals.<String>newLinkedHashSet();
      final Procedure1<LinkedHashSet<String>> _function_1 = (LinkedHashSet<String> it) -> {
        Iterables.<String>addAll(it, models);
        final Function1<String, Iterable<String>> _function_2 = (String it_1) -> {
          return helper.getAllDependencies(it_1);
        };
        Iterable<Iterable<String>> _map = IterableExtensions.<String, Iterable<String>>map(models, _function_2);
        Iterable<String> _flatten = Iterables.<String>concat(_map);
        Iterables.<String>addAll(it, _flatten);
      };
      _xblockexpression = ObjectExtensions.<LinkedHashSet<String>>operator_doubleArrow(_newLinkedHashSet, _function_1);
    }
    return _xblockexpression;
  }
  
  public Iterable<String> getAllDependencies(final String filePath) {
    Iterable<String> _xblockexpression = null;
    {
      String _elvis = null;
      String _resolve = this.modelLocator.resolve(filePath, null);
      if (_resolve != null) {
        _elvis = _resolve;
      } else {
        _elvis = "";
      }
      final URI uri = URI.createURI(_elvis);
      String _fileExtension = null;
      if (uri!=null) {
        _fileExtension=uri.fileExtension();
      }
      boolean _equalsIgnoreCase = "etmap".equalsIgnoreCase(_fileExtension);
      boolean _not = (!_equalsIgnoreCase);
      if (_not) {
        return CollectionLiterals.<String>emptyList();
      }
      final ResourceSet rs = this.resourceSetProvider.get();
      Resource _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = rs.getResource(uri, true);
      } catch (final Throwable _t) {
        if (_t instanceof RuntimeException) {
          final RuntimeException e = (RuntimeException)_t;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Resource res = _xtrycatchfinallyexpression;
      EList<EObject> _contents = null;
      if (res!=null) {
        _contents=res.getContents();
      }
      EObject _head = null;
      if (_contents!=null) {
        _head=IterableExtensions.<EObject>head(_contents);
      }
      boolean _tripleEquals = (_head == null);
      if (_tripleEquals) {
        return CollectionLiterals.<String>emptyList();
      }
      EList<EObject> _contents_1 = res.getContents();
      EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
      final URI projectURI = FileSystemHelpers.getProjectURI(_head_1);
      if ((((projectURI == null) || (!projectURI.isFile())) || projectURI.isRelative())) {
        return CollectionLiterals.<String>emptyList();
      }
      String _fileString = projectURI.toFileString();
      final Path projectPath = Paths.get(_fileString);
      EcoreUtil.resolveAll(rs);
      EList<Resource> _resources = rs.getResources();
      final Function1<Resource, String> _function = (Resource it) -> {
        String _switchResult = null;
        URI _uRI = it.getURI();
        final URI it_1 = _uRI;
        boolean _matched = false;
        boolean _isPlatformResource = it_1.isPlatformResource();
        if (_isPlatformResource) {
          _matched=true;
          String _xblockexpression_1 = null;
          {
            IWorkspace _workspace = ResourcesPlugin.getWorkspace();
            IWorkspaceRoot _root = _workspace.getRoot();
            String _platformString = it_1.toPlatformString(false);
            org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(_platformString);
            final IResource platformMember = _root.findMember(_path);
            IPath _location = null;
            if (platformMember!=null) {
              _location=platformMember.getLocation();
            }
            String _oSString = null;
            if (_location!=null) {
              _oSString=_location.toOSString();
            }
            final String location = _oSString;
            String _xifexpression = null;
            if (((location != null) && Paths.get(location).startsWith(projectPath))) {
              _xifexpression = location;
            }
            _xblockexpression_1 = _xifexpression;
          }
          _switchResult = _xblockexpression_1;
        }
        if (!_matched) {
          boolean _isFile = it_1.isFile();
          if (_isFile) {
            _matched=true;
            String _xifexpression = null;
            String _fileString_1 = it_1.toFileString();
            Path _get = Paths.get(_fileString_1);
            boolean _startsWith = _get.startsWith(projectPath);
            if (_startsWith) {
              _xifexpression = it_1.toFileString();
            }
            _switchResult = _xifexpression;
          }
        }
        return _switchResult;
      };
      List<String> _map = ListExtensions.<Resource, String>map(_resources, _function);
      _xblockexpression = IterableExtensions.<String>filterNull(_map);
    }
    return _xblockexpression;
  }
}
