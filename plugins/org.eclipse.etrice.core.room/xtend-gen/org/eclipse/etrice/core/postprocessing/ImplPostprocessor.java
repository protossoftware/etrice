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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.etrice.core.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostprocessor {
  public boolean process(final GeneratedMetamodel metamodel) {
    boolean _xblockexpression = false;
    {
      EPackage roomPackage = metamodel.getEPackage();
      EClass port = PostprocessingHelpers.getClass(roomPackage, "Port");
      EAttribute _attribute = PostprocessingHelpers.getAttribute(port, "multiplicity");
      _attribute.setDefaultValueLiteral("1");
      EClassifier _eClassifier = EcorePackage.eINSTANCE.getEClassifier("EBoolean");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return multiplicity>1 || multiplicity==-1;");
      PostprocessingHelpers.addOperation(port, "isReplicated", _eClassifier, Integer.valueOf(1), _builder.toString());
      EClass actorRef = PostprocessingHelpers.getClass(roomPackage, "ActorRef");
      EAttribute _attribute_1 = PostprocessingHelpers.getAttribute(actorRef, "size");
      _attribute_1.setDefaultValueLiteral("1");
      EClass state = PostprocessingHelpers.getClass(roomPackage, "State");
      EClassifier _eClassifier_1 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("return (this instanceof org.eclipse.etrice.core.room.SimpleState)? ((org.eclipse.etrice.core.room.SimpleState)this).getName() :(this instanceof org.eclipse.etrice.core.room.RefinedState)? (((org.eclipse.etrice.core.room.RefinedState)this).getTarget()==null? \"\":((org.eclipse.etrice.core.room.RefinedState)this).getTarget().getName()) :\"\";");
      PostprocessingHelpers.addOperation(state, "getName", _eClassifier_1, Integer.valueOf(1), _builder_1.toString());
      EClass stateGraphItem = PostprocessingHelpers.getClass(roomPackage, "StateGraphItem");
      EClassifier _eClassifier_2 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("if (this instanceof org.eclipse.etrice.core.room.State) ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return ((org.eclipse.etrice.core.room.State)this).getName();");
      _builder_2.newLine();
      _builder_2.append("else if (this instanceof org.eclipse.etrice.core.room.TrPoint)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return ((org.eclipse.etrice.core.room.TrPoint)this).getName();");
      _builder_2.newLine();
      _builder_2.append("else if (this instanceof org.eclipse.etrice.core.room.ChoicePoint)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return ((org.eclipse.etrice.core.room.ChoicePoint)this).getName();");
      _builder_2.newLine();
      _builder_2.append("else if (this instanceof org.eclipse.etrice.core.room.Transition)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return ((org.eclipse.etrice.core.room.Transition)this).getName();");
      _builder_2.newLine();
      _builder_2.append("return \"\";");
      _builder_2.newLine();
      PostprocessingHelpers.addOperation(stateGraphItem, "getName", _eClassifier_2, Integer.valueOf(1), _builder_2.toString());
      EClass interfaceItem = PostprocessingHelpers.getClass(roomPackage, "InterfaceItem");
      EClassifier _eClassifier_3 = roomPackage.getEClassifier("GeneralProtocolClass");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("if (this instanceof org.eclipse.etrice.core.room.Port)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("return ((org.eclipse.etrice.core.room.Port) this).getProtocol();");
      _builder_3.newLine();
      _builder_3.append("else if (this instanceof org.eclipse.etrice.core.room.SAPRef)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("return ((org.eclipse.etrice.core.room.SAPRef) this).getProtocol();");
      _builder_3.newLine();
      _builder_3.append("else if (this instanceof org.eclipse.etrice.core.room.SPPRef)");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("return ((org.eclipse.etrice.core.room.SPPRef) this).getProtocol();");
      _builder_3.newLine();
      _builder_3.append("return null;");
      _builder_3.newLine();
      boolean _addOperation = PostprocessingHelpers.addOperation(interfaceItem, "getGeneralProtocol", _eClassifier_3, Integer.valueOf(1), _builder_3.toString());
      _xblockexpression = (_addOperation);
    }
    return _xblockexpression;
  }
}
