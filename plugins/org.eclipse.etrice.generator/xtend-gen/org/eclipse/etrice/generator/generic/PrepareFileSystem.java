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
package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * A class that is used to recursively erase all folders receiving generated code
 * an to place a readme file into those folders.
 */
@Singleton
@SuppressWarnings("all")
public class PrepareFileSystem {
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private ILogger logger;
  
  public void prepareCodeTargetPaths(final Resource resource) {
    HashSet<String> _hashSet = new HashSet<String>();
    Set<String> pathes = _hashSet;
    EList<EObject> _contents = resource.getContents();
    for (final EObject e : _contents) {
      if ((e instanceof Root)) {
        EList<RoomModel> _usedRoomModels = ((Root) e).getUsedRoomModels();
        for (final RoomModel mdl : _usedRoomModels) {
          {
            final String tgtpath = this._roomExtensions.getGenerationTargetPath(mdl);
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(tgtpath, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _isEmpty = tgtpath.isEmpty();
              boolean _not = (!_isEmpty);
              _and = (_notEquals && _not);
            }
            if (_and) {
              pathes.add(tgtpath);
            }
          }
        }
      }
    }
    this.prepare(pathes);
  }
  
  public void prepareDocTargetPaths(final Resource resource) {
    HashSet<String> _hashSet = new HashSet<String>();
    Set<String> pathes = _hashSet;
    EList<EObject> _contents = resource.getContents();
    for (final EObject e : _contents) {
      if ((e instanceof Root)) {
        EList<RoomModel> _usedRoomModels = ((Root) e).getUsedRoomModels();
        for (final RoomModel mdl : _usedRoomModels) {
          {
            final String tgtpath = this._roomExtensions.getDocGenerationTargetPath(mdl);
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(tgtpath, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _isEmpty = tgtpath.isEmpty();
              boolean _not = (!_isEmpty);
              _and = (_notEquals && _not);
            }
            if (_and) {
              pathes.add(tgtpath);
            }
          }
        }
      }
    }
    this.prepare(pathes);
  }
  
  /**
   * Recursively erase all folders receiving generated code
   * and place a readme file in those folders.
   * The folders are determined from the used models of every generator
   * model found in the resource.
   * 
   * @param resource a {@link Resource}
   */
  public void prepare(final Collection<String> pathes) {
    for (final String path : pathes) {
      {
        String _plus = ("clearing " + path);
        this.logger.logInfo(_plus);
        File _file = new File(path);
        File f = _file;
        this.eraseContents(f);
        this.fileAccess.setOutputPath(path);
        CharSequence _readmeText = this.readmeText();
        this.fileAccess.generateFile("readme.txt", _readmeText);
      }
    }
  }
  
  private void eraseContents(final File f) {
    boolean _isDirectory = f.isDirectory();
    if (_isDirectory) {
      File[] children = f.listFiles();
      for (final File child : children) {
        {
          this.eraseContents(child);
          child.delete();
        }
      }
    }
  }
  
  private CharSequence readmeText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("This directory is an eTrice code generation target.");
    _builder.newLine();
    _builder.append("It will be erased every time the generator is executed.");
    _builder.newLine();
    _builder.newLine();
    _builder.append("DO NOT PLACE OTHER FILES HERE!");
    _builder.newLine();
    return _builder;
  }
}
