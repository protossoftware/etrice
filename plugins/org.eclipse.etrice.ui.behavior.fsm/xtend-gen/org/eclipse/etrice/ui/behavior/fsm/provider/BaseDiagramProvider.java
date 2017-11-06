/**
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.fsm.provider;

import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.util.FSMSupportUtil;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Provides the {@linkplain PictogramElement} objects of the base class diagram.
 *  This is a reverse mapping from room business objects to linked base diagram pictograms.
 * 
 *  TODO: use fsmgenmodel instead
 */
@SuppressWarnings("all")
public class BaseDiagramProvider {
  private final Multimap<EObject, PictogramElement> baseDiagramBusinessObjs = ArrayListMultimap.<EObject, PictogramElement>create();
  
  private final FSMHelpers fsmHelpers = FSMSupportUtil.getInstance().getFSMHelpers();
  
  public BaseDiagramProvider(final AbstractFSMDiagramTypeProvider diagramTypeProvider) {
    final DiagramAccessBase diagramAccess = diagramTypeProvider.getInjector().<DiagramAccessBase>getInstance(DiagramAccessBase.class);
    EObject _businessObjectForLinkedPictogramElement = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagramTypeProvider.getDiagram());
    final ModelComponent mc = ((ModelComponent) _businessObjectForLinkedPictogramElement);
    final ResourceSet rs = diagramTypeProvider.getDiagram().eResource().getResourceSet();
    ArrayList<ModelComponent> _newArrayList = CollectionLiterals.<ModelComponent>newArrayList();
    final Procedure1<ArrayList<ModelComponent>> _function = (ArrayList<ModelComponent> it) -> {
      ModelComponent base = mc.getBase();
      while (((base != null) && it.add(base))) {
        base = base.getBase();
      }
    };
    final ArrayList<ModelComponent> baseClasses = ObjectExtensions.<ArrayList<ModelComponent>>operator_doubleArrow(_newArrayList, _function);
    final Consumer<ModelComponent> _function_1 = (ModelComponent base) -> {
      final Diagram baseDiagram = diagramAccess.getDiagram(base, rs);
      boolean _notEquals = (!Objects.equal(baseDiagram, null));
      if (_notEquals) {
        final BiConsumer<EObject, Collection<EStructuralFeature.Setting>> _function_2 = (EObject targetEObj, Collection<EStructuralFeature.Setting> eFeatureSetting) -> {
          final Function1<EStructuralFeature.Setting, EObject> _function_3 = (EStructuralFeature.Setting it) -> {
            return it.getEObject();
          };
          final Function1<PictogramLink, PictogramElement> _function_4 = (PictogramLink it) -> {
            return it.getPictogramElement();
          };
          final Consumer<PictogramElement> _function_5 = (PictogramElement pe) -> {
            this.put(mc, targetEObj, pe);
          };
          IterableExtensions.<PictogramLink, PictogramElement>map(Iterables.<PictogramLink>filter(IterableExtensions.<EStructuralFeature.Setting, EObject>map(eFeatureSetting, _function_3), PictogramLink.class), _function_4).forEach(_function_5);
        };
        EcoreUtil.ExternalCrossReferencer.find(baseDiagram).forEach(_function_2);
        rs.getResources().remove(baseDiagram.eResource());
      }
    };
    ListExtensions.<ModelComponent>reverseView(baseClasses).forEach(_function_1);
  }
  
  private boolean put(final ModelComponent mc, final EObject obj, final PictogramElement value) {
    boolean _xblockexpression = false;
    {
      if ((obj instanceof StateGraph)) {
        boolean _isTopLevel = this.fsmHelpers.isTopLevel(((StateGraph)obj));
        if (_isTopLevel) {
          this.baseDiagramBusinessObjs.put(mc.getStateMachine(), value);
        }
      }
      _xblockexpression = this.baseDiagramBusinessObjs.put(obj, value);
    }
    return _xblockexpression;
  }
  
  public Collection<PictogramElement> getPictograms(final EObject roomObj) {
    Collection<PictogramElement> _xifexpression = null;
    boolean _equals = Objects.equal(roomObj, null);
    if (_equals) {
      _xifexpression = CollectionLiterals.<PictogramElement>emptyList();
    } else {
      _xifexpression = this.baseDiagramBusinessObjs.get(roomObj);
    }
    return _xifexpression;
  }
}
