/**
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert
 */
package org.eclipse.etrice.core.fsm.postprocessing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostprocessor {
  public boolean process(final GeneratedMetamodel metamodel) {
    boolean _xblockexpression = false;
    {
      final EPackage fsmPackage = metamodel.getEPackage();
      final EClass state = PostprocessingHelpers.getClass(fsmPackage, "State");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return (this instanceof <%org.eclipse.etrice.core.fsm.fSM.SimpleState%>)? ((SimpleState)this).getName() :(this instanceof <%org.eclipse.etrice.core.fsm.fSM.RefinedState%>)? (((RefinedState)this).getTarget()==null? \"\":((RefinedState)this).getTarget().getName()) :\"\";");
      PostprocessingHelpers.addOperation(state, "getName", EcorePackage.Literals.ESTRING, Integer.valueOf(1), _builder.toString());
      final EClass stateGraphItem = PostprocessingHelpers.getClass(fsmPackage, "StateGraphItem");
      EClassifier _eClassifier = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.State%>) ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((State)this).getName();");
      _builder_1.newLine();
      _builder_1.append("else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.TrPoint%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((TrPoint)this).getName();");
      _builder_1.newLine();
      _builder_1.append("else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.ChoicePoint%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((ChoicePoint)this).getName();");
      _builder_1.newLine();
      _builder_1.append("else if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.Transition%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((Transition)this).getName();");
      _builder_1.newLine();
      _builder_1.append("return \"\";");
      _builder_1.newLine();
      PostprocessingHelpers.addOperation(stateGraphItem, "getName", _eClassifier, Integer.valueOf(1), _builder_1.toString());
      final EClass ifItem = PostprocessingHelpers.getClass(fsmPackage, "AbstractInterfaceItem");
      EClassifier _eClassifier_1 = fsmPackage.getEClassifier("ProtocolSemantics");
      PostprocessingHelpers.addOperation(ifItem, "getSemantics", _eClassifier_1);
      PostprocessingHelpers.addOperation(ifItem, "getAllIncomingAbstractMessages", EcorePackage.Literals.EOBJECT, Integer.valueOf((-1)), null);
      PostprocessingHelpers.addOperation(ifItem, "getAllOutgoingAbstractMessages", EcorePackage.Literals.EOBJECT, Integer.valueOf((-1)), null);
      final EClass itemOwner = PostprocessingHelpers.addClass(fsmPackage, "IInterfaceItemOwner");
      itemOwner.setAbstract(true);
      itemOwner.setInterface(true);
      EClassifier _eClassifier_2 = fsmPackage.getEClassifier("AbstractInterfaceItem");
      PostprocessingHelpers.addOperation(itemOwner, "getAbstractInterfaceItems", _eClassifier_2, Integer.valueOf((-1)), null);
      EClassifier _eClassifier_3 = fsmPackage.getEClassifier("AbstractInterfaceItem");
      PostprocessingHelpers.addOperation(itemOwner, "getAllAbstractInterfaceItems", _eClassifier_3, Integer.valueOf((-1)), null);
      final EClass comp = PostprocessingHelpers.getClass(fsmPackage, "ModelComponent");
      EList<EClass> _eSuperTypes = comp.getESuperTypes();
      _xblockexpression = _eSuperTypes.add(itemOwner);
    }
    return _xblockexpression;
  }
}
