package org.eclipse.etrice.core.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PostprocessingHelpers {
  public static EClass getClass(final EPackage pckg, final String name) {
    EClassifier _eClassifier = pckg.getEClassifier(name);
    return ((EClass) _eClassifier);
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
  
  public static boolean addOperation(final EClass owner, final String name, final EClassifier type, final Integer upperBound, final String body) {
    boolean _xblockexpression = false;
    {
      EOperation op = EcoreFactory.eINSTANCE.createEOperation();
      op.setName(name);
      op.setEType(type);
      op.setUpperBound((upperBound).intValue());
      EAnnotation anno = EcoreFactory.eINSTANCE.createEAnnotation();
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
