/**
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrentz (initial contribution)
 */
package org.eclipse.etrice.core.common.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author hrentz
 */
@SuppressWarnings("all")
public class ValidationHelpers {
  public static class NamedObject {
    private String _name;
    
    public String getName() {
      return this._name;
    }
    
    public void setName(final String name) {
      this._name = name;
    }
    
    private EObject _obj;
    
    public EObject getObj() {
      return this._obj;
    }
    
    public void setObj(final EObject obj) {
      this._obj = obj;
    }
    
    private EStructuralFeature _feature;
    
    public EStructuralFeature getFeature() {
      return this._feature;
    }
    
    public void setFeature(final EStructuralFeature feature) {
      this._feature = feature;
    }
    
    public NamedObject(final String name, final EObject obj, final EStructuralFeature feature) {
      this.setName(name);
      this.setObj(obj);
      this.setFeature(feature);
    }
  }
  
  public static class NamedObjectList extends ArrayList<ValidationHelpers.NamedObject> {
    public void addAll(final List<? extends EObject> items, final EStructuralFeature feature) {
      final Procedure1<EObject> _function = new Procedure1<EObject>() {
        public void apply(final EObject it) {
          Object _eGet = it.eGet(feature);
          ValidationHelpers.NamedObject _namedObject = new ValidationHelpers.NamedObject(((String) _eGet), it, feature);
          NamedObjectList.this.add(_namedObject);
        }
      };
      IterableExtensions.forEach(items, _function);
    }
  }
  
  public static Iterable<ValidationHelpers.NamedObject> removeUniques(final List<ValidationHelpers.NamedObject> items) {
    Iterable<ValidationHelpers.NamedObject> _xblockexpression = null;
    {
      final Set<String> allOfName = CollectionLiterals.<String>newHashSet();
      final Set<String> duplicateNames = CollectionLiterals.<String>newHashSet();
      for (final ValidationHelpers.NamedObject i : items) {
        String _name = i.getName();
        boolean _contains = allOfName.contains(_name);
        if (_contains) {
          String _name_1 = i.getName();
          duplicateNames.add(_name_1);
        } else {
          String _name_2 = i.getName();
          allOfName.add(_name_2);
        }
      }
      final Function1<ValidationHelpers.NamedObject, Boolean> _function = new Function1<ValidationHelpers.NamedObject, Boolean>() {
        public Boolean apply(final ValidationHelpers.NamedObject i) {
          String _name = i.getName();
          return Boolean.valueOf(duplicateNames.contains(_name));
        }
      };
      _xblockexpression = IterableExtensions.<ValidationHelpers.NamedObject>filter(items, _function);
    }
    return _xblockexpression;
  }
  
  public static Iterable<ValidationHelpers.NamedObject> inSameResource(final Iterable<ValidationHelpers.NamedObject> items, final Resource resource) {
    final Function1<ValidationHelpers.NamedObject, Boolean> _function = new Function1<ValidationHelpers.NamedObject, Boolean>() {
      public Boolean apply(final ValidationHelpers.NamedObject i) {
        EObject _obj = i.getObj();
        Resource _eResource = _obj.eResource();
        return Boolean.valueOf(Objects.equal(_eResource, resource));
      }
    };
    return IterableExtensions.<ValidationHelpers.NamedObject>filter(items, _function);
  }
}
