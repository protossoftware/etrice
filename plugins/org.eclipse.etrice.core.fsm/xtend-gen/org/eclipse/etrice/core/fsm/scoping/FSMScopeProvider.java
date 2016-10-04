/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.fsm.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class FSMScopeProvider extends AbstractDeclarativeScopeProvider {
  @Inject
  @Extension
  private FSMHelpers _fSMHelpers;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  /**
   * returns a flat list of State scopes for a {@link StateTerminal}
   * @param st - the transition endpoint or terminal
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_StateTerminal_state(final StateTerminal st, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    final StateGraph parent = this.getStateGraph(st);
    this.getStateScopes(parent, scopes);
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of TransitionPoint scopes for a {@link TrPointTerminal}
   * @param ep - the transition endpoint or terminal
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_TrPointTerminal_trPoint(final TrPointTerminal ep, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    final StateGraph parent = this.getStateGraph(ep);
    final List<TrPoint> tps = this._fSMHelpers.getAllTrPoints(parent);
    for (final TrPoint tp : tps) {
      String _name = tp.getName();
      IEObjectDescription _create = EObjectDescription.create(_name, tp);
      scopes.add(_create);
    }
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of TransitionPoint scopes for a {@link SubStateTrPointTerminal}
   * @param ep - the transition endpoint or terminal
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_SubStateTrPointTerminal_trPoint(final SubStateTrPointTerminal ep, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    final StateGraph parent = this.getStateGraph(ep);
    State _state = ep.getState();
    boolean _notEquals = (!Objects.equal(_state, null));
    if (_notEquals) {
      State epState = ep.getState();
      State _refinedStateFor = this._fSMHelpers.getRefinedStateFor(parent, epState);
      epState = _refinedStateFor;
      StateGraph _subgraph = epState.getSubgraph();
      boolean _notEquals_1 = (!Objects.equal(_subgraph, null));
      if (_notEquals_1) {
        StateGraph _subgraph_1 = epState.getSubgraph();
        final List<TrPoint> tps = this._fSMHelpers.getAllTrPoints(_subgraph_1);
        for (final TrPoint tp : tps) {
          String _name = tp.getName();
          IEObjectDescription _create = EObjectDescription.create(_name, tp);
          scopes.add(_create);
        }
      }
    }
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of State scopes for a {@link SubStateTrPointTerminal}
   * @param st - the transition endpoint or terminal
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_SubStateTrPointTerminal_state(final SubStateTrPointTerminal st, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    final StateGraph parent = this.getStateGraph(st);
    this.getStateScopes(parent, scopes);
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of Choicepoint scopes for a {@link SubStateTrPointTerminal}
   * @param ct - the transition endpoint or terminal
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_ChoicepointTerminal_cp(final ChoicepointTerminal ct, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    final StateGraph parent = this.getStateGraph(ct);
    final List<ChoicePoint> choicePoints = this._fSMHelpers.getAllChoicePoints(parent);
    for (final ChoicePoint cp : choicePoints) {
      String _name = cp.getName();
      IEObjectDescription _create = EObjectDescription.create(_name, cp);
      scopes.add(_create);
    }
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of BaseState scopes for a {@link RefinedState}
   * @param rs - the refined state
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_RefinedState_target(final RefinedState rs, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    StateGraph sg = this.getStateGraph(rs);
    EObject _eContainer = sg.eContainer();
    if ((_eContainer instanceof ModelComponent)) {
      EObject _eContainer_1 = sg.eContainer();
      ModelComponent comp = ((ModelComponent) _eContainer_1);
      if (((!Objects.equal(comp.getBase(), null)) && (!this._fSMHelpers.isCircularClassHierarchy(comp)))) {
        ModelComponent _base = comp.getBase();
        comp = _base;
        final HashSet<State> covered = CollectionLiterals.<State>newHashSet();
        final ArrayList<State> states = CollectionLiterals.<State>newArrayList();
        while ((!Objects.equal(comp, null))) {
          {
            StateGraph _stateMachine = comp.getStateMachine();
            this.recursivelyAddStates(_stateMachine, covered, states);
            ModelComponent _base_1 = comp.getBase();
            comp = _base_1;
          }
        }
        for (final State s : states) {
          QualifiedName _statePath = this.getStatePath(s);
          IEObjectDescription _create = EObjectDescription.create(_statePath, s);
          scopes.add(_create);
        }
      }
    } else {
      EObject _eContainer_2 = sg.eContainer();
      if ((_eContainer_2 instanceof RefinedState)) {
        EObject _eContainer_3 = sg.eContainer();
        State _target = ((RefinedState) _eContainer_3).getTarget();
        StateGraph _subgraph = _target.getSubgraph();
        sg = _subgraph;
        boolean _notEquals = (!Objects.equal(sg, null));
        if (_notEquals) {
          EList<State> _states = sg.getStates();
          for (final State s_1 : _states) {
            String _name = s_1.getName();
            IEObjectDescription _create_1 = EObjectDescription.create(_name, s_1);
            scopes.add(_create_1);
          }
        }
      }
    }
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * returns a flat list of Transition scopes for a {@link RefinedTransition}
   * @param trans - the refined transition
   * @param ref - not used
   * @return a list of scopes
   */
  public IScope scope_RefinedTransition_target(final RefinedTransition trans, final EReference ref) {
    final List<IEObjectDescription> scopes = CollectionLiterals.<IEObjectDescription>newArrayList();
    EObject _eContainer = trans.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    ModelComponent comp = ((ModelComponent) _eContainer_1);
    boolean _isCircularClassHierarchy = this._fSMHelpers.isCircularClassHierarchy(comp);
    boolean _not = (!_isCircularClassHierarchy);
    if (_not) {
      ModelComponent _base = comp.getBase();
      comp = _base;
      while ((!Objects.equal(comp, null))) {
        {
          StateGraph _stateMachine = comp.getStateMachine();
          boolean _notEquals = (!Objects.equal(_stateMachine, null));
          if (_notEquals) {
            QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(comp);
            final int acNameSegments = _fullyQualifiedName.getSegmentCount();
            StateGraph _stateMachine_1 = comp.getStateMachine();
            final TreeIterator<EObject> iter = _stateMachine_1.eAllContents();
            while (iter.hasNext()) {
              {
                final EObject obj = iter.next();
                if ((obj instanceof Transition)) {
                  QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(obj);
                  QualifiedName _skipFirst = _fullyQualifiedName_1.skipFirst((acNameSegments + 1));
                  IEObjectDescription _create = EObjectDescription.create(_skipFirst, obj);
                  scopes.add(_create);
                }
              }
            }
          }
          ModelComponent _base_1 = comp.getBase();
          comp = _base_1;
        }
      }
    }
    return new SimpleScope(IScope.NULLSCOPE, scopes);
  }
  
  /**
   * @param sg
   * @param covered
   * @param states
   */
  private void recursivelyAddStates(final StateGraph sg, final HashSet<State> covered, final ArrayList<State> states) {
    EList<State> _states = sg.getStates();
    for (final State s : _states) {
      if (((s instanceof SimpleState) && (!covered.contains(s)))) {
        states.add(s);
      } else {
        if (((s instanceof RefinedState) && (!covered.contains(s)))) {
          states.add(s);
          State _target = ((RefinedState) s).getTarget();
          covered.add(_target);
        }
      }
    }
    EList<State> _states_1 = sg.getStates();
    for (final State s_1 : _states_1) {
      StateGraph _subgraph = s_1.getSubgraph();
      boolean _notEquals = (!Objects.equal(_subgraph, null));
      if (_notEquals) {
        StateGraph _subgraph_1 = s_1.getSubgraph();
        this.recursivelyAddStates(_subgraph_1, covered, states);
      }
    }
  }
  
  /**
   * first container of type {@link StateGraph} ({@link State}, {@link StateMachine})
   * @param obj
   * @return StateGraph Container
   */
  private StateGraph getStateGraph(final EObject obj) {
    EObject ctx = obj.eContainer();
    while (((!(ctx instanceof StateGraph)) && (!Objects.equal(ctx.eContainer(), null)))) {
      EObject _eContainer = ctx.eContainer();
      ctx = _eContainer;
    }
    if ((ctx instanceof StateGraph)) {
      return ((StateGraph)ctx);
    }
    return null;
  }
  
  /**
   * compute the path of a {@link BaseState}
   * @param bs
   * @return the path
   */
  private QualifiedName getStatePath(final State bs) {
    EObject _eContainer = bs.eContainer();
    final EObject parent = _eContainer.eContainer();
    if ((parent instanceof SimpleState)) {
      QualifiedName _statePath = this.getStatePath(((SimpleState) parent));
      String _name = bs.getName();
      return _statePath.append(_name);
    } else {
      if ((parent instanceof RefinedState)) {
        final State target = ((RefinedState) parent).getTarget();
        boolean _notEquals = (!Objects.equal(target, null));
        if (_notEquals) {
          QualifiedName _statePath_1 = this.getStatePath(target);
          String _name_1 = bs.getName();
          return _statePath_1.append(_name_1);
        }
      }
    }
    String _name_2 = bs.getName();
    return QualifiedName.create(_name_2);
  }
  
  /**
   * @param parent
   * @param scopes
   */
  private void getStateScopes(final StateGraph parent, final List<IEObjectDescription> scopes) {
    final List<State> states = this._fSMHelpers.getAllStates(parent);
    final HashMap<String, SimpleState> name2state = CollectionLiterals.<String, SimpleState>newHashMap();
    for (final State s : states) {
      String _name = s.getName();
      SimpleState _baseState = this._fSMHelpers.getBaseState(s);
      name2state.put(_name, _baseState);
    }
    Set<Map.Entry<String, SimpleState>> _entrySet = name2state.entrySet();
    for (final Map.Entry<String, SimpleState> entry : _entrySet) {
      String _key = entry.getKey();
      SimpleState _value = entry.getValue();
      IEObjectDescription _create = EObjectDescription.create(_key, _value);
      scopes.add(_create);
    }
  }
}
