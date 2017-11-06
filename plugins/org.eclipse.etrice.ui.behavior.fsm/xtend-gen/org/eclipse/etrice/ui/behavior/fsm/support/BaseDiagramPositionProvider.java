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
package org.eclipse.etrice.ui.behavior.fsm.support;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.ui.behavior.fsm.provider.BaseDiagramProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.IPositionProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.StateSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.TrPointSupport;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * IPositionProvider based on {@linkplain BaseDiagramProvider}
 * 	Logic copied from DefaultPositionProvider
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BaseDiagramPositionProvider implements IPositionProvider {
  private final BaseDiagramProvider baseDiagram;
  
  public int getMargin(final StateGraphNode node) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (node instanceof State) {
      _matched=true;
      _switchResult = StateSupport.MARGIN;
    }
    if (!_matched) {
      if (node instanceof TrPoint) {
        _matched=true;
        _switchResult = TrPointSupport.MARGIN;
      }
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  public int getMargin(final StateGraph graph) {
    return 0;
  }
  
  private IPositionProvider.PosAndSize toPosAndSize(final PictogramElement pe, final int margin) {
    IPositionProvider.PosAndSize _xblockexpression = null;
    {
      EObject _eContainer = pe.eContainer();
      final GraphicsAlgorithm borderGa = IterableExtensions.<GraphicsAlgorithm>head(((PictogramElement) _eContainer).getGraphicsAlgorithm().getGraphicsAlgorithmChildren());
      final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
      int _x = ga.getX();
      int _width = borderGa.getWidth();
      double _divide = (_x / ((double) _width));
      double _multiply = (_divide * this.sx);
      final double x = (_multiply + margin);
      int _y = ga.getY();
      int _height = borderGa.getHeight();
      double _divide_1 = (_y / ((double) _height));
      double _multiply_1 = (_divide_1 * this.sy);
      final double y = (_multiply_1 + margin);
      int _width_1 = ga.getWidth();
      int _minus = (_width_1 - (2 * margin));
      int _width_2 = borderGa.getWidth();
      double _divide_2 = (_minus / ((double) _width_2));
      final double width = (_divide_2 * this.sx);
      int _height_1 = ga.getHeight();
      int _minus_1 = (_height_1 - (2 * margin));
      int _height_2 = borderGa.getHeight();
      double _divide_3 = (_minus_1 / ((double) _height_2));
      final double height = (_divide_3 * this.sy);
      _xblockexpression = new IPositionProvider.PosAndSize(((int) x), ((int) y), ((int) width), ((int) height));
    }
    return _xblockexpression;
  }
  
  @Override
  public IPositionProvider.PosAndSize getGraphPosAndSize(final StateGraph sg) {
    IPositionProvider.PosAndSize _xblockexpression = null;
    {
      final Function1<PictogramElement, Boolean> _function = (PictogramElement it) -> {
        EObject _parentBo = this.getParentBo(it);
        return Boolean.valueOf((_parentBo instanceof ModelComponent));
      };
      final PictogramElement pe = IterableExtensions.<PictogramElement>findFirst(this.baseDiagram.getPictograms(sg), _function);
      IPositionProvider.PosAndSize _xifexpression = null;
      boolean _notEquals = (!Objects.equal(pe, null));
      if (_notEquals) {
        IPositionProvider.PosAndSize _xblockexpression_1 = null;
        {
          final GraphicsAlgorithm visibleGa = IterableExtensions.<GraphicsAlgorithm>head(pe.getGraphicsAlgorithm().getGraphicsAlgorithmChildren());
          int _x = pe.getGraphicsAlgorithm().getX();
          int _y = pe.getGraphicsAlgorithm().getY();
          int _width = visibleGa.getWidth();
          int _height = visibleGa.getHeight();
          _xblockexpression_1 = new IPositionProvider.PosAndSize(_x, _y, _width, _height);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<IPositionProvider.Pos> getPoints(final Transition trans) {
    ArrayList<IPositionProvider.Pos> _xblockexpression = null;
    {
      PictogramElement _xifexpression = null;
      if ((trans instanceof RefinedTransition)) {
        _xifexpression = IterableExtensions.<PictogramElement>head(this.baseDiagram.getPictograms(((RefinedTransition)trans).getTarget()));
      } else {
        _xifexpression = IterableExtensions.<PictogramElement>head(this.baseDiagram.getPictograms(trans));
      }
      final PictogramElement pe = _xifexpression;
      ArrayList<IPositionProvider.Pos> _newArrayList = CollectionLiterals.<IPositionProvider.Pos>newArrayList();
      final Procedure1<ArrayList<IPositionProvider.Pos>> _function = (ArrayList<IPositionProvider.Pos> pointList) -> {
        if ((pe instanceof Connection)) {
          EObject _eContainer = trans.eContainer();
          final IPositionProvider.PosAndSize graphPosAndSize = this.getGraphPosAndSize(((StateGraph) _eContainer));
          final Function1<ConnectionDecorator, GraphicsAlgorithm> _function_1 = (ConnectionDecorator it) -> {
            return it.getGraphicsAlgorithm();
          };
          final Text text = IterableExtensions.<Text>head(Iterables.<Text>filter(ListExtensions.<ConnectionDecorator, GraphicsAlgorithm>map(((Connection)pe).getConnectionDecorators(), _function_1), Text.class));
          boolean _notEquals = (!Objects.equal(text, null));
          if (_notEquals) {
            int _x = text.getX();
            int _width = graphPosAndSize.getWidth();
            double _divide = (_x / ((double) _width));
            double _multiply = (_divide * this.sx);
            int _y = text.getY();
            int _height = graphPosAndSize.getHeight();
            double _divide_1 = (_y / ((double) _height));
            double _multiply_1 = (_divide_1 * this.sy);
            IPositionProvider.Pos _pos = new IPositionProvider.Pos(
              ((int) _multiply), 
              ((int) _multiply_1));
            pointList.add(_pos);
            if ((pe instanceof FreeFormConnection)) {
              final Function1<Point, IPositionProvider.Pos> _function_2 = (Point it) -> {
                int _x_1 = text.getX();
                int _width_1 = graphPosAndSize.getWidth();
                double _divide_2 = (_x_1 / ((double) _width_1));
                double _multiply_2 = (_divide_2 * this.sx);
                double _plus = (_multiply_2 + this.x);
                int _y_1 = text.getY();
                int _height_1 = graphPosAndSize.getHeight();
                double _divide_3 = (_y_1 / ((double) _height_1));
                double _multiply_3 = (_divide_3 * this.sy);
                double _plus_1 = (_multiply_3 + this.y);
                return new IPositionProvider.Pos(
                  ((int) _plus), 
                  ((int) _plus_1));
              };
              List<IPositionProvider.Pos> _map = ListExtensions.<Point, IPositionProvider.Pos>map(((FreeFormConnection)pe).getBendpoints(), _function_2);
              Iterables.<IPositionProvider.Pos>addAll(pointList, _map);
            }
          }
        }
      };
      _xblockexpression = ObjectExtensions.<ArrayList<IPositionProvider.Pos>>operator_doubleArrow(_newArrayList, _function);
    }
    return _xblockexpression;
  }
  
  @Override
  public IPositionProvider.PosAndSize getPosition(final StateGraphNode node) {
    final Function1<EObject, IPositionProvider.PosAndSize> _function = (EObject it) -> {
      final Function1<PictogramElement, Boolean> _function_1 = (PictogramElement it_1) -> {
        EObject _parentBo = this.getParentBo(it_1);
        return Boolean.valueOf((_parentBo instanceof StateGraph));
      };
      PictogramElement _findFirst = IterableExtensions.<PictogramElement>findFirst(this.baseDiagram.getPictograms(it), _function_1);
      IPositionProvider.PosAndSize _posAndSize = null;
      if (_findFirst!=null) {
        _posAndSize=this.toPosAndSize(_findFirst, this.getMargin(node));
      }
      return _posAndSize;
    };
    final Function1<EObject, IPositionProvider.PosAndSize> getBasePos = _function;
    IPositionProvider.PosAndSize _xifexpression = null;
    if ((node instanceof RefinedState)) {
      IPositionProvider.PosAndSize _elvis = null;
      IPositionProvider.PosAndSize _apply = getBasePos.apply(node);
      if (_apply != null) {
        _elvis = _apply;
      } else {
        IPositionProvider.PosAndSize _apply_1 = getBasePos.apply(((RefinedState)node).getTarget());
        _elvis = _apply_1;
      }
      _xifexpression = _elvis;
    } else {
      _xifexpression = getBasePos.apply(node);
    }
    return _xifexpression;
  }
  
  @Override
  public StateGraph getInitialPoint(final StateGraph stateGraph) {
    final PictogramElement initTransPe = IterableExtensions.<PictogramElement>head(this.baseDiagram.getPictograms(IterableExtensions.<InitialTransition>head(Iterables.<InitialTransition>filter(stateGraph.getTransitions(), InitialTransition.class))));
    if ((initTransPe instanceof Connection)) {
      final EObject sourceAnchorBo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(((Connection)initTransPe).getStart());
      if ((sourceAnchorBo instanceof StateGraph)) {
        return ((StateGraph)sourceAnchorBo);
      }
    }
    return null;
  }
  
  @Override
  public IPositionProvider.PosAndSize getPosition(final StateGraph graph) {
    final Function1<PictogramElement, Boolean> _function = (PictogramElement it) -> {
      EObject _parentBo = this.getParentBo(it);
      return Boolean.valueOf((_parentBo instanceof StateGraph));
    };
    PictogramElement _findFirst = IterableExtensions.<PictogramElement>findFirst(this.baseDiagram.getPictograms(graph), _function);
    IPositionProvider.PosAndSize _posAndSize = null;
    if (_findFirst!=null) {
      _posAndSize=this.toPosAndSize(_findFirst, this.getMargin(graph));
    }
    return _posAndSize;
  }
  
  @Override
  public <T extends StateGraphNode> List<IPositionProvider.PosAndSize> getPositions(final List<T> items) {
    final Function1<T, IPositionProvider.PosAndSize> _function = (T it) -> {
      PictogramElement _head = IterableExtensions.<PictogramElement>head(this.baseDiagram.getPictograms(it));
      IPositionProvider.PosAndSize _posAndSize = null;
      if (_head!=null) {
        _posAndSize=this.toPosAndSize(_head, this.getMargin(it));
      }
      return _posAndSize;
    };
    return ListExtensions.<T, IPositionProvider.PosAndSize>map(items, _function);
  }
  
  @Override
  public double[] getSubPosition(final StateGraphNode subNode) {
    final Function1<PictogramElement, Boolean> _function = (PictogramElement it) -> {
      EObject _parentBo = this.getParentBo(it);
      return Boolean.valueOf((_parentBo instanceof State));
    };
    final PictogramElement pe = IterableExtensions.<PictogramElement>findFirst(this.baseDiagram.getPictograms(subNode), _function);
    boolean _notEquals = (!Objects.equal(pe, null));
    if (_notEquals) {
      EObject _eContainer = pe.eContainer();
      final PictogramElement parentPe = ((PictogramElement) _eContainer);
      int _x = pe.getGraphicsAlgorithm().getX();
      int _width = parentPe.getGraphicsAlgorithm().getWidth();
      int _minus = (_width - (2 * StateSupport.MARGIN));
      final double relX = (((double) _x) / _minus);
      int _y = pe.getGraphicsAlgorithm().getY();
      int _height = parentPe.getGraphicsAlgorithm().getHeight();
      int _minus_1 = (_height - (2 * StateSupport.MARGIN));
      final double relY = (((double) _y) / _minus_1);
      return new double[] { relX, relY };
    }
    return null;
  }
  
  private int x;
  
  private int y;
  
  @Override
  public void setPosition(final int x, final int y) {
    this.x = x;
    this.y = y;
  }
  
  private double sx;
  
  private double sy;
  
  @Override
  public void setScale(final double sx, final double sy) {
    this.sx = sx;
    this.sy = sy;
  }
  
  private EObject getParentBo(final PictogramElement pe) {
    EObject _eContainer = pe.eContainer();
    return Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(((PictogramElement) _eContainer));
  }
  
  public BaseDiagramPositionProvider(final BaseDiagramProvider baseDiagram) {
    super();
    this.baseDiagram = baseDiagram;
  }
}
