/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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
import com.google.inject.Injector;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.BasicFsmGenBuilder;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FSMGenElement;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GenModelProvider {
  private final BasicFsmGenBuilder builder;
  
  private final IDiagramTypeProvider fsmDiagramProvider;
  
  private Map<EObject, FSMGenElement> graphMap = CollectionLiterals.<EObject, FSMGenElement>newHashMap();
  
  private GraphContainer modelInstance = null;
  
  public GenModelProvider(final AbstractFSMDiagramTypeProvider fsmDiagramProvider) {
    this.fsmDiagramProvider = fsmDiagramProvider;
    Injector _injector = fsmDiagramProvider.getInjector();
    BasicFsmGenBuilder _basicFsmGenBuilder = new BasicFsmGenBuilder(_injector);
    this.builder = _basicFsmGenBuilder;
  }
  
  public void updateModel() {
    EObject _businessObjectForLinkedPictogramElement = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(this.fsmDiagramProvider.getDiagram());
    final Procedure1<EObject> _function = (EObject it) -> {
      GraphContainer _xifexpression = null;
      if ((it instanceof ModelComponent)) {
        _xifexpression = this.builder.createTransformedModel(((ModelComponent)it));
      } else {
        _xifexpression = null;
      }
      this.modelInstance = _xifexpression;
    };
    ObjectExtensions.<EObject>operator_doubleArrow(_businessObjectForLinkedPictogramElement, _function);
    boolean _notEquals = (!Objects.equal(this.modelInstance, null));
    if (_notEquals) {
      this.graphMap.clear();
      final Procedure1<EObject> _function_1 = (EObject it) -> {
        boolean _matched = false;
        if (it instanceof Graph) {
          _matched=true;
          this.graphMap.put(((Graph)it).getStateGraph(), ((FSMGenElement)it));
        }
        if (!_matched) {
          if (it instanceof Node) {
            _matched=true;
            this.graphMap.put(((Node)it).getStateGraphNode(), ((FSMGenElement)it));
          }
        }
        if (!_matched) {
          if (it instanceof Link) {
            _matched=true;
            this.graphMap.put(((Link)it).getTransition(), ((FSMGenElement)it));
          }
        }
      };
      IteratorExtensions.<EObject>forEach(this.modelInstance.eAllContents(), _function_1);
    }
  }
  
  public GraphContainer getModel() {
    boolean _equals = Objects.equal(this.modelInstance, null);
    if (_equals) {
      this.updateModel();
    }
    return this.modelInstance;
  }
  
  public <T extends FSMGenElement> T getCasted(final EObject roomObj) {
    FSMGenElement _get = this.graphMap.get(roomObj);
    return ((T) _get);
  }
}
