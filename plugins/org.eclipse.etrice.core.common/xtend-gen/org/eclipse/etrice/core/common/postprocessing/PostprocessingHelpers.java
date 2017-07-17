/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 */
package org.eclipse.etrice.core.common.postprocessing;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PostprocessingHelpers {
  public static int UNBOUNDED_MULTIPLICITY = ETypedElement.UNBOUNDED_MULTIPLICITY;
  
  public static String JAVADOC_NEWLINE = "<br>";
  
  public static EClass getClass(final EPackage pckg, final String name) {
    EClassifier _eClassifier = pckg.getEClassifier(name);
    return ((EClass) _eClassifier);
  }
  
  public static void setDocumentation(final EModelElement eModelElement, final String documentation) {
    EcoreUtil.setDocumentation(eModelElement, (PostprocessingHelpers.JAVADOC_NEWLINE + documentation));
  }
  
  public static EAttribute getAttribute(final EClass cls, final String name) {
    EList<EAttribute> _eAllAttributes = cls.getEAllAttributes();
    final Function1<EAttribute, Boolean> _function = (EAttribute a) -> {
      String _name = a.getName();
      return Boolean.valueOf(_name.equals(name));
    };
    return IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
  }
  
  public static EReference getReference(final EClass cls, final String name) {
    EList<EReference> _eAllReferences = cls.getEAllReferences();
    final Function1<EReference, Boolean> _function = (EReference a) -> {
      String _name = a.getName();
      return Boolean.valueOf(_name.equals(name));
    };
    return IterableExtensions.<EReference>findFirst(_eAllReferences, _function);
  }
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type) {
    return PostprocessingHelpers.addOperation(owner, name, type, Integer.valueOf(1), null);
  }
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type, final String body) {
    return PostprocessingHelpers.addOperation(owner, name, type, Integer.valueOf(1), body);
  }
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type, final Integer upperBound, final String body) {
    boolean _xblockexpression = false;
    {
      final EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setName(name);
      op.setEType(type);
      op.setUpperBound((upperBound).intValue());
      boolean _notEquals = (!Objects.equal(body, null));
      if (_notEquals) {
        final EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
        anno.setSource("http://www.eclipse.org/emf/2002/GenModel");
        EMap<String, String> _details = anno.getDetails();
        _details.put("body", body);
        EList<EAnnotation> _eAnnotations = op.getEAnnotations();
        _eAnnotations.add(anno);
      }
      EList<EOperation> _eOperations = owner.getEOperations();
      _xblockexpression = _eOperations.add(op);
    }
    return _xblockexpression;
  }
  
  public static EClass addClass(final EPackage pck, final String name) {
    final EClass cls = EcoreFactory.eINSTANCE.createEClass();
    cls.setName(name);
    EList<EClassifier> _eClassifiers = pck.getEClassifiers();
    _eClassifiers.add(cls);
    return cls;
  }
}
