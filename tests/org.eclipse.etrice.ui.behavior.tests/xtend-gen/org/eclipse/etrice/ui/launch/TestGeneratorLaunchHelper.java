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
package org.eclipse.etrice.ui.launch;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.etrice.generator.launch.GeneratorLaunchHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestGeneratorLaunchHelper {
  private List<String> get(final Iterable<String> list) {
    Collection<String> _allDependenciesWithinProjects = GeneratorLaunchHelper.getAllDependenciesWithinProjects(list);
    return IterableExtensions.<String>toList(_allDependenciesWithinProjects);
  }
  
  @Test
  public void notExisting() {
    final Procedure1<List<String>> _function = new Procedure1<List<String>>() {
      @Override
      public void apply(final List<String> models) {
        List<String> _get = TestGeneratorLaunchHelper.this.get(models);
        Assert.assertEquals(models, _get);
      }
    };
    ObjectExtensions.<List<String>>operator_doubleArrow(
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), _function);
    final Procedure1<List<String>> _function_1 = new Procedure1<List<String>>() {
      @Override
      public void apply(final List<String> models) {
        List<String> _get = TestGeneratorLaunchHelper.this.get(models);
        Assert.assertEquals(models, _get);
      }
    };
    ObjectExtensions.<List<String>>operator_doubleArrow(
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("1", ".0ß+/§`}]\"°")), _function_1);
    final Procedure1<List<String>> _function_2 = new Procedure1<List<String>>() {
      @Override
      public void apply(final List<String> models) {
        List<String> _get = TestGeneratorLaunchHelper.this.get(models);
        Assert.assertEquals(models, _get);
      }
    };
    ObjectExtensions.<List<String>>operator_doubleArrow(
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("1.room", "2.etphys", "3.etmap", "4.etconfig", "5.unknown")), _function_2);
  }
  
  @Test
  public void project() {
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String file) {
        Path _get = Paths.get("models/generatorLaunchHelper", file);
        Path _absolutePath = _get.toAbsolutePath();
        return _absolutePath.toString();
      }
    };
    final Function1<? super String, ? extends String> toAbsolutePath = _function;
    final Function1<String, String> _function_1 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return toAbsolutePath.apply(it);
      }
    };
    List<String> _map = ListExtensions.<String, String>map(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("project1/System.etmap", "project1/NotMapped.room", "project1/Physical.etphys", "project1/Dep.room")), _function_1);
    final Function1<String, String> _function_2 = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        return toAbsolutePath.apply(it);
      }
    };
    List<String> _map_1 = ListExtensions.<String, String>map(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("project1/System.etmap", "project1/NotMapped.room")), _function_2);
    List<String> _get = this.get(_map_1);
    Assert.assertEquals(_map, _get);
  }
}
