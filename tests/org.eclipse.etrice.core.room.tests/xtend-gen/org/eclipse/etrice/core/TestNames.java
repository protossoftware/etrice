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
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.TestBase;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestNames extends TestBase {
  private final Map<EObject, Boolean> nameErrorMap = Maps.<EObject, Boolean>newHashMap();
  
  private Resource res;
  
  @Before
  public void SetUp() {
    this.prepare();
    Resource _resource = this.getResource("NamesAreUnique.room");
    this.res = _resource;
    EList<EObject> _contents = this.res.getContents();
    final EObject model = IterableExtensions.<EObject>head(_contents);
    final Diagnostic diag = this.getDiag(model);
    List<Diagnostic> _children = diag.getChildren();
    final Procedure1<Diagnostic> _function = new Procedure1<Diagnostic>() {
      public void apply(final Diagnostic it) {
        if ((it instanceof AbstractValidationDiagnostic)) {
          final EObject obj = ((AbstractValidationDiagnostic)it).getSourceEObject();
          Boolean nameError = TestNames.this.nameErrorMap.get(obj);
          boolean _equals = Objects.equal(nameError, null);
          if (_equals) {
            nameError = Boolean.valueOf(false);
          }
          boolean _or = false;
          if ((nameError).booleanValue()) {
            _or = true;
          } else {
            boolean _isNameErrorMessage = TestNames.this.isNameErrorMessage(it);
            _or = _isNameErrorMessage;
          }
          TestNames.this.nameErrorMap.put(obj, Boolean.valueOf(_or));
        }
      }
    };
    IterableExtensions.<Diagnostic>forEach(_children, _function);
  }
  
  @Test
  public void RoomClassNames() {
    EObject _eObject = this.res.getEObject("ActorClass:ClassDuplicate1");
    boolean _hasNameErrorMessage = this.hasNameErrorMessage(_eObject);
    Assert.assertTrue(_hasNameErrorMessage);
    EObject _eObject_1 = this.res.getEObject("LogicalSystem:ClassDuplicate1");
    boolean _hasNameErrorMessage_1 = this.hasNameErrorMessage(_eObject_1);
    Assert.assertTrue(_hasNameErrorMessage_1);
    EObject _eObject_2 = this.res.getEObject("AnnotationType:ClassDuplicate1");
    boolean _hasNameErrorMessage_2 = this.hasNameErrorMessage(_eObject_2);
    Assert.assertTrue(_hasNameErrorMessage_2);
    EObject _eObject_3 = this.res.getEObject("EnumerationType:ClassDuplicate1");
    boolean _hasNameErrorMessage_3 = this.hasNameErrorMessage(_eObject_3);
    Assert.assertTrue(_hasNameErrorMessage_3);
    EObject _eObject_4 = this.res.getEObject("PrimitiveType:ClassDuplicate1");
    boolean _hasNameErrorMessage_4 = this.hasNameErrorMessage(_eObject_4);
    Assert.assertTrue(_hasNameErrorMessage_4);
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
    int _size = items.size();
    Assert.assertEquals("Unexpected item count", 15, _size);
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      public void apply(final EObject it) {
        boolean _hasNameErrorMessage = TestNames.this.hasNameErrorMessage(it);
        Assert.assertFalse(("expected no name error: " + it), _hasNameErrorMessage);
      }
    };
    IterableExtensions.<EObject>forEach(items, _function);
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
    int _size = items.size();
    Assert.assertEquals("Unexpected item count", 9, _size);
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      public void apply(final EObject it) {
        boolean _hasNameErrorMessage = TestNames.this.hasNameErrorMessage(it);
        Assert.assertFalse(("expected no name error: " + it), _hasNameErrorMessage);
      }
    };
    IterableExtensions.<EObject>forEach(items, _function);
  }
  
  @Test
  public void InheritedNames() {
    final EObject ac = this.res.getEObject("ActorClass:Sub");
    final EObject dc = this.res.getEObject("DataClass:DSub");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList();
    EList<EObject> _eContents = ac.eContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject it) {
        return Boolean.valueOf((!(it instanceof ExternalPort)));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_eContents, _function);
    Iterables.<EObject>addAll(items, _filter);
    EList<EObject> _eContents_1 = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents_1);
    int _size = items.size();
    Assert.assertEquals("Unexpected item count", 13, _size);
    final Procedure1<EObject> _function_1 = new Procedure1<EObject>() {
      public void apply(final EObject it) {
        boolean _hasNameErrorMessage = TestNames.this.hasNameErrorMessage(it);
        Assert.assertTrue(("expected name error: " + it), _hasNameErrorMessage);
      }
    };
    IterableExtensions.<EObject>forEach(items, _function_1);
  }
  
  @Test
  public void FlatNames() {
    final EObject ac = this.res.getEObject("ActorClass:Flat");
    final EObject dc = this.res.getEObject("DataClass:DFlat");
    final EObject lc = this.res.getEObject("DataClass:LFlat");
    final EObject sc = this.res.getEObject("DataClass:SFlat");
    final EObject enum_ = this.res.getEObject("DataClass:EnumFlat");
    final ArrayList<EObject> items = CollectionLiterals.<EObject>newArrayList();
    EList<EObject> _eContents = ac.eContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject it) {
        return Boolean.valueOf((!(it instanceof ExternalPort)));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_eContents, _function);
    Iterables.<EObject>addAll(items, _filter);
    EList<EObject> _eContents_1 = dc.eContents();
    Iterables.<EObject>addAll(items, _eContents_1);
    EList<EObject> _eContents_2 = lc.eContents();
    Iterables.<EObject>addAll(items, _eContents_2);
    EList<EObject> _eContents_3 = sc.eContents();
    Iterables.<EObject>addAll(items, _eContents_3);
    EList<EObject> _eContents_4 = enum_.eContents();
    Iterables.<EObject>addAll(items, _eContents_4);
    int _size = items.size();
    Assert.assertEquals("Unexpected item count", 16, _size);
    final Procedure1<EObject> _function_1 = new Procedure1<EObject>() {
      public void apply(final EObject it) {
        boolean _hasNameErrorMessage = TestNames.this.hasNameErrorMessage(it);
        Assert.assertTrue(("expected name error: " + it), _hasNameErrorMessage);
      }
    };
    IterableExtensions.<EObject>forEach(items, _function_1);
  }
  
  private boolean hasNameErrorMessage(final EObject obj) {
    boolean _and = false;
    boolean _containsKey = this.nameErrorMap.containsKey(obj);
    if (!_containsKey) {
      _and = false;
    } else {
      Boolean _get = this.nameErrorMap.get(obj);
      _and = (_get).booleanValue();
    }
    return _and;
  }
  
  protected boolean isNameErrorMessage(final Diagnostic diag) {
    final String message = diag.getMessage();
    boolean _and = false;
    int _severity = diag.getSeverity();
    boolean _greaterEqualsThan = (_severity >= Diagnostic.ERROR);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _contains = message.contains("Duplicate name");
      if (_contains) {
        _or = true;
      } else {
        boolean _and_1 = false;
        boolean _contains_1 = message.contains("Name");
        if (!_contains_1) {
          _and_1 = false;
        } else {
          boolean _contains_2 = message.contains("is already assigned to");
          _and_1 = _contains_2;
        }
        _or = _and_1;
      }
      _and = _or;
    }
    return _and;
  }
}
