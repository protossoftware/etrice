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
package org.eclipse.etrice.core.postprocessing;

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
    String _plus = (PostprocessingHelpers.JAVADOC_NEWLINE + documentation);
    EcoreUtil.setDocumentation(eModelElement, _plus);
  }
  
  public static EAttribute getAttribute(final EClass cls, final String name) {
    EList<EAttribute> _eAllAttributes = cls.getEAllAttributes();
    final Function1<EAttribute,Boolean> _function = new Function1<EAttribute,Boolean>() {
        public Boolean apply(final EAttribute a) {
          String _name = a.getName();
          boolean _equals = _name.equals(name);
          return Boolean.valueOf(_equals);
        }
      };
    EAttribute _findFirst = IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
    return _findFirst;
  }
  
  public static EReference getReference(final EClass cls, final String name) {
    EList<EReference> _eAllReferences = cls.getEAllReferences();
    final Function1<EReference,Boolean> _function = new Function1<EReference,Boolean>() {
        public Boolean apply(final EReference a) {
          String _name = a.getName();
          boolean _equals = _name.equals(name);
          return Boolean.valueOf(_equals);
        }
      };
    EReference _findFirst = IterableExtensions.<EReference>findFirst(_eAllReferences, _function);
    return _findFirst;
  }
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type, final String body) {
    boolean _addOperation = PostprocessingHelpers.addOperation(owner, name, type, Integer.valueOf(1), body);
    return _addOperation;
  }
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type, final Integer upperBound, final String body) {
    boolean _xblockexpression = false;
    {
      final EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setName(name);
      op.setEType(type);
      op.setUpperBound((upperBound).intValue());
      final EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
      anno.setSource("http://www.eclipse.org/emf/2002/GenModel");
      EMap<String,String> _details = anno.getDetails();
      _details.put("body", body);
      EList<EAnnotation> _eAnnotations = op.getEAnnotations();
      _eAnnotations.add(anno);
      EList<EOperation> _eOperations = owner.getEOperations();
      boolean _add = _eOperations.add(op);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}
