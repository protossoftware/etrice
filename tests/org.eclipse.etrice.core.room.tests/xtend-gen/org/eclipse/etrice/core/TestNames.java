/**
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.core;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.CoreTestsActivator;
import org.eclipse.etrice.core.TestBase;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestNames extends TestBase {
  private final Map<EObject, Boolean> nameErrorMap = Maps.<EObject, Boolean>newHashMap();
  
  private Resource res;
  
  @Before
  public void SetUp() {
    this.prepare(CoreTestsActivator.getInstance().getBundle());
    this.res = this.getResource("NamesAreUnique.room");
    final EObject model = IterableExtensions.<EObject>head(this.res.getContents());
    final Diagnostic diag = this.getDiag(model);
    final Consumer<Diagnostic> _function = (Diagnostic it) -> {
      if ((it instanceof AbstractValidationDiagnostic)) {
        final EObject obj = ((AbstractValidationDiagnostic)it).getSourceEObject();
        Boolean nameError = this.nameErrorMap.get(obj);
        boolean _equals = Objects.equal(nameError, null);
        if (_equals) {
          nameError = Boolean.valueOf(false);
        }
        this.nameErrorMap.put(obj, Boolean.valueOf(((nameError).booleanValue() || this.isNameErrorMessage(it))));
      }
    };
    diag.getChildren().forEach(_function);
  }
  
  @Test
  public void RoomClassNames() {
    Assert.assertTrue(this.hasNameErrorMessage(this.res.getEObject("ActorClass:ClassDuplicate1")));
    Assert.assertTrue(this.hasNameErrorMessage(this.res.getEObject("LogicalSystem:ClassDuplicate1")));
    Assert.assertTrue(this.hasNameErrorMessage(this.res.getEObject("AnnotationType:ClassDuplicate1")));
    Assert.assertTrue(this.hasNameErrorMessage(this.res.getEObject("EnumerationType:ClassDuplicate1")));
    Assert.assertTrue(this.hasNameErrorMessage(this.res.getEObject("PrimitiveType:ClassDuplicate1")));
  }
  
  @Test
  public void BaseClassNames() {
    final EObject ac = this.res.getEObject("ActorClass:Base");
    final EObject dc = this.res.getEObject("DataClass:DBase");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList(ac, dc);
    EList<EObject> _eContents = ac.eContents();
    Iterables.<EObject>addAll(items, _eContents);
    EList<EObject> _eContents_1 = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents_1);
    Assert.assertEquals("Unexpected item count", 15, items.size());
    final Consumer<EObject> _function = (EObject it) -> {
      Assert.assertFalse(("expected no name error: " + it), this.hasNameErrorMessage(it));
    };
    items.forEach(_function);
  }
  
  @Test
  public void OverrideNames() {
    final EObject ac = this.res.getEObject("ActorClass:Override");
    final EObject dc = this.res.getEObject("DataClass:DOverride");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList(ac, dc);
    EList<EObject> _eContents = ac.eContents();
    Iterables.<EObject>addAll(items, _eContents);
    EList<EObject> _eContents_1 = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents_1);
    Assert.assertEquals("Unexpected item count", 9, items.size());
    final Consumer<EObject> _function = (EObject it) -> {
      Assert.assertFalse(("expected no name error: " + it), this.hasNameErrorMessage(it));
    };
    items.forEach(_function);
  }
  
  @Test
  public void InheritedNames() {
    final EObject ac = this.res.getEObject("ActorClass:Sub");
    final EObject dc = this.res.getEObject("DataClass:DSub");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList();
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((!(it instanceof ExternalPort)));
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(ac.eContents(), _function);
    Iterables.<EObject>addAll(items, _filter);
    EList<EObject> _eContents = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents);
    Assert.assertEquals("Unexpected item count", 13, items.size());
    final Consumer<EObject> _function_1 = (EObject it) -> {
      Assert.assertTrue(("expected name error: " + it), this.hasNameErrorMessage(it));
    };
    items.forEach(_function_1);
  }
  
  @Test
  public void FlatNames() {
    final EObject ac = this.res.getEObject("ActorClass:Flat");
    final EObject dc = this.res.getEObject("DataClass:DFlat");
    final EObject lc = this.res.getEObject("DataClass:LFlat");
    final EObject sc = this.res.getEObject("DataClass:SFlat");
    final EObject enum_ = this.res.getEObject("DataClass:EnumFlat");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList();
    final Function1<EObject, Boolean> _function = (EObject it) -> {
      return Boolean.valueOf((!(it instanceof ExternalPort)));
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(ac.eContents(), _function);
    Iterables.<EObject>addAll(items, _filter);
    EList<EObject> _eContents = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents);
    EList<EObject> _eContents_1 = lc.eContents();
    Iterables.<EObject>addAll(items, _eContents_1);
    EList<EObject> _eContents_2 = sc.eContents();
    Iterables.<EObject>addAll(items, _eContents_2);
    EList<EObject> _eContents_3 = enum_.eContents();
    Iterables.<EObject>addAll(items, _eContents_3);
    Assert.assertEquals("Unexpected item count", 16, items.size());
    final Consumer<EObject> _function_1 = (EObject it) -> {
      Assert.assertTrue(("expected name error: " + it), this.hasNameErrorMessage(it));
    };
    items.forEach(_function_1);
  }
  
  private boolean hasNameErrorMessage(final EObject obj) {
    return (this.nameErrorMap.containsKey(obj) && (this.nameErrorMap.get(obj)).booleanValue());
  }
  
  protected boolean isNameErrorMessage(final Diagnostic diag) {
    final String message = diag.getMessage();
    return ((diag.getSeverity() >= Diagnostic.ERROR) && (message.contains("Duplicate name") || (message.contains("Name") && message.contains("is already assigned to"))));
  }
}
