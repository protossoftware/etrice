/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.Indexed;
import org.eclipse.etrice.generator.fsm.generic.IIfItemIdGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Target language independent part of an actor class generator.
 * It uses the {@link ILanguageExtension}.
 */
@SuppressWarnings("all")
public class GenericActorClassGenerator implements IIfItemIdGenerator {
  @Inject
  @Extension
  protected RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected ILanguageExtension langExt;
  
  /**
   * Generate constants for the local IDs of all interface items of an actor
   * class.
   * 
   * @param xpac an {@link ExpandedActorClass}
   * @return the generated code
   */
  public String genInterfaceItemConstants(final ExpandedActorClass xpac) {
    final ActorClass ac = xpac.getActorClass();
    List<Port> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      _xifexpression = this._roomHelpers.getEndPorts(ac);
    } else {
      _xifexpression = this._roomHelpers.getAllEndPorts(ac);
    }
    final List<Port> endPorts = _xifexpression;
    List<SAP> _xifexpression_1 = null;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      _xifexpression_1 = ac.getServiceAccessPoints();
    } else {
      _xifexpression_1 = this._roomHelpers.getAllSAPs(ac);
    }
    final List<SAP> strSAPs = _xifexpression_1;
    List<ServiceImplementation> _xifexpression_2 = null;
    boolean _usesInheritance_2 = this.langExt.usesInheritance();
    if (_usesInheritance_2) {
      _xifexpression_2 = ac.getServiceImplementations();
    } else {
      _xifexpression_2 = this._roomHelpers.getAllServiceImplementations(ac);
    }
    final List<ServiceImplementation> svcImpls = _xifexpression_2;
    final ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    for (final Port ep : endPorts) {
      String _ifItemId = this.getIfItemId(ep);
      int _interfaceItemLocalId = xpac.getInterfaceItemLocalId(ep);
      int _plus = (1 + _interfaceItemLocalId);
      String _string = Integer.valueOf(_plus).toString();
      Pair<String, String> _pair = Tuples.<String, String>pair(_ifItemId, _string);
      list.add(_pair);
    }
    for (final SAP sap : strSAPs) {
      String _ifItemId_1 = this.getIfItemId(sap);
      int _interfaceItemLocalId_1 = xpac.getInterfaceItemLocalId(sap);
      int _plus_1 = (1 + _interfaceItemLocalId_1);
      String _string_1 = Integer.valueOf(_plus_1).toString();
      Pair<String, String> _pair_1 = Tuples.<String, String>pair(_ifItemId_1, _string_1);
      list.add(_pair_1);
    }
    for (final ServiceImplementation svc : svcImpls) {
      SPP _spp = svc.getSpp();
      String _ifItemId_2 = this.getIfItemId(_spp);
      SPP _spp_1 = svc.getSpp();
      int _interfaceItemLocalId_2 = xpac.getInterfaceItemLocalId(_spp_1);
      int _plus_2 = (1 + _interfaceItemLocalId_2);
      String _string_2 = Integer.valueOf(_plus_2).toString();
      Pair<String, String> _pair_2 = Tuples.<String, String>pair(_ifItemId_2, _string_2);
      list.add(_pair_2);
    }
    return this.langExt.genEnumeration("interface_items", list);
  }
  
  public String genInterfaceItemConstantsForOptionalActor(final ActorClass ac) {
    final List<Port> ports = this._roomHelpers.getAllInterfacePorts(ac);
    final ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    Iterable<Indexed<Port>> _indexed = Indexed.<Port>indexed(ports);
    for (final Indexed<Port> ep : _indexed) {
      Port _value = ep.getValue();
      String _ifItemId = this.getIfItemId(_value);
      int _index1 = ep.getIndex1();
      String _string = Integer.valueOf(_index1).toString();
      Pair<String, String> _pair = Tuples.<String, String>pair(_ifItemId, _string);
      list.add(_pair);
    }
    return this.langExt.genEnumeration("interface_items", list);
  }
  
  @Override
  public String getIfItemId(final AbstractInterfaceItem item) {
    String _name = item.getName();
    return ("IFITEM_" + _name);
  }
}
