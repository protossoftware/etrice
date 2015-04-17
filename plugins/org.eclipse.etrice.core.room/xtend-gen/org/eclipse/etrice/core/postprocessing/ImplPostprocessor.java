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
import org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class ImplPostprocessor {
  public boolean process(final GeneratedMetamodel metamodel) {
    boolean _xblockexpression = false;
    {
      final EPackage roomPackage = metamodel.getEPackage();
      final EClass port = PostprocessingHelpers.getClass(roomPackage, "Port");
      EAttribute _attribute = PostprocessingHelpers.getAttribute(port, "multiplicity");
      _attribute.setDefaultValueLiteral("1");
      EClassifier _eClassifier = EcorePackage.eINSTANCE.getEClassifier("EBoolean");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("return multiplicity>1 || multiplicity==-1;");
      PostprocessingHelpers.addOperation(port, "isReplicated", _eClassifier, Integer.valueOf(1), _builder.toString());
      final EClass actorRef = PostprocessingHelpers.getClass(roomPackage, "ActorRef");
      EAttribute _attribute_1 = PostprocessingHelpers.getAttribute(actorRef, "multiplicity");
      _attribute_1.setDefaultValueLiteral("1");
      final EClass interfaceItem = PostprocessingHelpers.getClass(roomPackage, "InterfaceItem");
      EClassifier _eClassifier_1 = roomPackage.getEClassifier("GeneralProtocolClass");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("if (this instanceof <%org.eclipse.etrice.core.room.Port%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((Port) this).getProtocol();");
      _builder_1.newLine();
      _builder_1.append("else if (this instanceof <%org.eclipse.etrice.core.room.SAP%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((SAP) this).getProtocol();");
      _builder_1.newLine();
      _builder_1.append("else if (this instanceof <%org.eclipse.etrice.core.room.SPP%>)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("return ((SPP) this).getProtocol();");
      _builder_1.newLine();
      _builder_1.append("return null;");
      _builder_1.newLine();
      PostprocessingHelpers.addOperation(interfaceItem, "getGeneralProtocol", _eClassifier_1, Integer.valueOf(1), _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("if (getGeneralProtocol() instanceof <%org.eclipse.etrice.core.room.ProtocolClass%>)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return ((ProtocolClass)getGeneralProtocol()).getSemantics();");
      _builder_2.newLine();
      _builder_2.append("else");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("return null;");
      _builder_2.newLine();
      PostprocessingHelpers.addOperation(interfaceItem, "getSemantics", FSMPackage.Literals.PROTOCOL_SEMANTICS, Integer.valueOf(1), _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, false));");
      _builder_3.newLine();
      PostprocessingHelpers.addOperation(interfaceItem, "getAllIncomingAbstractMessages", EcorePackage.Literals.EOBJECT, Integer.valueOf((-1)), _builder_3.toString());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, true));");
      _builder_4.newLine();
      PostprocessingHelpers.addOperation(interfaceItem, "getAllOutgoingAbstractMessages", EcorePackage.Literals.EOBJECT, Integer.valueOf((-1)), _builder_4.toString());
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("if (getGeneralProtocol() instanceof ProtocolClass)");
      _builder_5.newLine();
      _builder_5.append("    ");
      _builder_5.append("return ((ProtocolClass) getGeneralProtocol()).getCommType() == <%org.eclipse.etrice.core.room.CommunicationType%>.EVENT_DRIVEN;");
      _builder_5.newLine();
      _builder_5.append("else");
      _builder_5.newLine();
      _builder_5.append("    ");
      _builder_5.append("return false;");
      _builder_5.newLine();
      PostprocessingHelpers.addOperation(interfaceItem, "isEventDriven", EcorePackage.Literals.EBOOLEAN, Integer.valueOf(1), _builder_5.toString());
      final EClass actorClass = PostprocessingHelpers.getClass(roomPackage, "ActorClass");
      EClassifier _eClassifier_2 = roomPackage.getEClassifier("Port");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("EList<Port> ports = new BasicEList<Port>();");
      _builder_6.newLine();
      _builder_6.append("for (ExternalPort ep : getExternalPorts()) {");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("ports.add(ep.getInterfacePort());");
      _builder_6.newLine();
      _builder_6.append("}");
      _builder_6.newLine();
      _builder_6.append("return ports;");
      _builder_6.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getExternalEndPorts", _eClassifier_2, Integer.valueOf((-1)), _builder_6.toString());
      EClassifier _eClassifier_3 = roomPackage.getEClassifier("Port");
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("EList<Port> ports = new BasicEList<Port>(getInterfacePorts());");
      _builder_7.newLine();
      _builder_7.append("for (ExternalPort ep : getExternalPorts()) {");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append("ports.remove(ep.getInterfacePort());");
      _builder_7.newLine();
      _builder_7.append("}");
      _builder_7.newLine();
      _builder_7.append("return ports;");
      _builder_7.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getRelayPorts", _eClassifier_3, Integer.valueOf((-1)), _builder_7.toString());
      EClassifier _eClassifier_4 = roomPackage.getEClassifier("SPP");
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("EList<SPP> spps = new BasicEList<SPP>();");
      _builder_8.newLine();
      _builder_8.append("for (ServiceImplementation spp : getServiceImplementations()) {");
      _builder_8.newLine();
      _builder_8.append("\t");
      _builder_8.append("spps.add(spp.getSpp());");
      _builder_8.newLine();
      _builder_8.append("}");
      _builder_8.newLine();
      _builder_8.append("return spps;");
      _builder_8.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getImplementedSPPs", _eClassifier_4, Integer.valueOf((-1)), _builder_8.toString());
      EClassifier _eClassifier_5 = roomPackage.getEClassifier("ActorClass");
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("return (ActorClass)getBase();");
      _builder_9.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getActorBase", _eClassifier_5, Integer.valueOf(1), _builder_9.toString());
      EClassifier _eClassifier_6 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("return getName();");
      _builder_10.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getComponentName", _eClassifier_6, Integer.valueOf(1), _builder_10.toString());
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("return new <%org.eclipse.emf.common.util.BasicEList%><AbstractInterfaceItem>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getInterfaceItems(this));");
      _builder_11.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getAbstractInterfaceItems", FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM, Integer.valueOf((-1)), _builder_11.toString());
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("return new <%org.eclipse.emf.common.util.BasicEList%><AbstractInterfaceItem>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getAllInterfaceItems(this));");
      _builder_12.newLine();
      PostprocessingHelpers.addOperation(actorClass, "getAllAbstractInterfaceItems", FSMPackage.Literals.ABSTRACT_INTERFACE_ITEM, Integer.valueOf((-1)), _builder_12.toString());
      final EClass actorContainerRef = PostprocessingHelpers.getClass(roomPackage, "ActorContainerRef");
      EClassifier _eClassifier_7 = roomPackage.getEClassifier("StructureClass");
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append("if (this instanceof <%org.eclipse.etrice.core.room.ActorRef%>)");
      _builder_13.newLine();
      _builder_13.append("\t");
      _builder_13.append("return ((ActorRef)this).getType();");
      _builder_13.newLine();
      _builder_13.append("else if (this instanceof <%org.eclipse.etrice.core.room.SubSystemRef%>)");
      _builder_13.newLine();
      _builder_13.append("\t");
      _builder_13.append("return ((SubSystemRef)this).getType();");
      _builder_13.newLine();
      _builder_13.append("else");
      _builder_13.newLine();
      _builder_13.append("\t");
      _builder_13.append("return null;");
      _builder_13.newLine();
      PostprocessingHelpers.addOperation(actorContainerRef, "getStructureClass", _eClassifier_7, 
        Integer.valueOf(1), _builder_13.toString());
      final EClass refPath = PostprocessingHelpers.getClass(roomPackage, "RefPath");
      EClassifier _eClassifier_8 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append("StringBuilder sb = new StringBuilder();");
      _builder_14.newLine();
      _builder_14.append("for (RefSegment ref : getRefs()) {");
      _builder_14.newLine();
      _builder_14.append("\t");
      _builder_14.append("sb.append(\"/\"+ref.toString());");
      _builder_14.newLine();
      _builder_14.append("}");
      _builder_14.newLine();
      _builder_14.append("return sb.toString();");
      _builder_14.newLine();
      PostprocessingHelpers.addOperation(refPath, 
        "toString", _eClassifier_8, 
        Integer.valueOf(1), _builder_14.toString());
      final EClass refSeg = PostprocessingHelpers.getClass(roomPackage, "RefSegment");
      EAttribute _attribute_2 = PostprocessingHelpers.getAttribute(refSeg, "idx");
      _attribute_2.setDefaultValueLiteral("-1");
      EClassifier _eClassifier_9 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_15 = new StringConcatenation();
      _builder_15.append("return getRef() + ((getIdx()>=0)? \":\"+getIdx() : \"\");");
      _builder_15.newLine();
      PostprocessingHelpers.addOperation(refSeg, 
        "toString", _eClassifier_9, 
        Integer.valueOf(1), _builder_15.toString());
      final EClass enumLiteral = PostprocessingHelpers.getClass(roomPackage, "EnumLiteral");
      EClassifier _eClassifier_10 = EcorePackage.eINSTANCE.getEClassifier("ELong");
      StringConcatenation _builder_16 = new StringConcatenation();
      _builder_16.append("if (this.getLiteral() != null)");
      _builder_16.newLine();
      _builder_16.append("\t");
      _builder_16.append("return this.getLiteral().getValue();");
      _builder_16.newLine();
      _builder_16.newLine();
      _builder_16.append("// recursively from predecessor");
      _builder_16.newLine();
      _builder_16.append("<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());");
      _builder_16.newLine();
      _builder_16.append("int idx = et.getLiterals().indexOf(this);");
      _builder_16.newLine();
      _builder_16.append("if (idx > 0)");
      _builder_16.newLine();
      _builder_16.append("\t");
      _builder_16.append("return et.getLiterals().get(idx - 1).getLiteralValue() + 1;");
      _builder_16.newLine();
      _builder_16.newLine();
      _builder_16.append("return 0;");
      _builder_16.newLine();
      PostprocessingHelpers.addOperation(enumLiteral, 
        "getLiteralValue", _eClassifier_10, 
        Integer.valueOf(1), _builder_16.toString());
      EClassifier _eClassifier_11 = EcorePackage.eINSTANCE.getEClassifier("EString");
      StringConcatenation _builder_17 = new StringConcatenation();
      _builder_17.append("<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());");
      _builder_17.newLine();
      _builder_17.append("return et.getName() + \".\" + this.getName();");
      _builder_17.newLine();
      _xblockexpression = PostprocessingHelpers.addOperation(enumLiteral, 
        "getFullName", _eClassifier_11, 
        Integer.valueOf(1), _builder_17.toString());
    }
    return _xblockexpression;
  }
}
