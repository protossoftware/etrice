package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TransitionChainGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GenericStateMachineGenerator {
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected GenericProtocolClassGenerator pcGen;
  
  @Inject
  protected TransitionChainGenerator transitionChainGenerator;
  
  private String genStateIdConstants(final ExpandedActorClass xpac) {
    final ActorClass ac = xpac.getActorClass();
    int _xifexpression = (int) 0;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      int _numberOfInheritedBaseStates = this._roomExtensions.getNumberOfInheritedBaseStates(ac);
      _xifexpression = _numberOfInheritedBaseStates;
    } else {
      _xifexpression = 0;
    }
    int offset = (2 + _xifexpression);
    List<State> _xifexpression_1 = null;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      StateGraph _stateMachine = ac.getStateMachine();
      List<State> _baseStateList = this._roomExtensions.getBaseStateList(_stateMachine);
      _xifexpression_1 = _baseStateList;
    } else {
      StateGraph _stateMachine_1 = xpac.getStateMachine();
      List<State> _baseStateList_1 = this._roomExtensions.getBaseStateList(_stateMachine_1);
      _xifexpression_1 = _baseStateList_1;
    }
    List<State> baseStates = _xifexpression_1;
    ArrayList<State> _leafStatesLast = this._roomExtensions.getLeafStatesLast(baseStates);
    baseStates = _leafStatesLast;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
    ArrayList<Pair<String,String>> list = _arrayList;
    boolean _usesInheritance_2 = this.langExt.usesInheritance();
    boolean _not = (!_usesInheritance_2);
    if (_not) {
      Pair<String,String> _pair = Tuples.<String, String>pair("NO_STATE", "0");
      list.add(_pair);
      Pair<String,String> _pair_1 = Tuples.<String, String>pair("STATE_TOP", "1");
      list.add(_pair_1);
    }
    for (final State state : baseStates) {
      {
        String _stateId = this._roomExtensions.getStateId(state);
        String _string = Integer.valueOf(offset).toString();
        Pair<String,String> _pair_2 = Tuples.<String, String>pair(_stateId, _string);
        list.add(_pair_2);
        int _plus = (offset + 1);
        offset = _plus;
      }
    }
    return this.langExt.genEnumeration("state_ids", list);
  }
  
  private String genTransitionChainConstants(final ExpandedActorClass xpac) {
    EList<TransitionChain> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      EList<TransitionChain> _ownTransitionChains = xpac.getOwnTransitionChains();
      _xifexpression = _ownTransitionChains;
    } else {
      EList<TransitionChain> _transitionChains = xpac.getTransitionChains();
      _xifexpression = _transitionChains;
    }
    EList<TransitionChain> chains = _xifexpression;
    int _xifexpression_1 = (int) 0;
    boolean _usesInheritance_1 = this.langExt.usesInheritance();
    if (_usesInheritance_1) {
      EList<TransitionChain> _transitionChains_1 = xpac.getTransitionChains();
      int _size = _transitionChains_1.size();
      int _size_1 = chains.size();
      int _minus = (_size - _size_1);
      _xifexpression_1 = _minus;
    } else {
      _xifexpression_1 = 0;
    }
    int offset = _xifexpression_1;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
    ArrayList<Pair<String,String>> list = _arrayList;
    for (final TransitionChain chain : chains) {
      {
        int _plus = (offset + 1);
        offset = _plus;
        String _chainId = this._roomExtensions.getChainId(chain);
        String _string = Integer.valueOf(offset).toString();
        Pair<String,String> _pair = Tuples.<String, String>pair(_chainId, _string);
        list.add(_pair);
      }
    }
    return this.langExt.genEnumeration("chain_ids", list);
  }
  
  public String genTriggerConstants(final ExpandedActorClass xpac) {
    EList<MessageFromIf> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      EList<MessageFromIf> _ownTriggers = xpac.getOwnTriggers();
      _xifexpression = _ownTriggers;
    } else {
      EList<MessageFromIf> _triggers = xpac.getTriggers();
      _xifexpression = _triggers;
    }
    final EList<MessageFromIf> triggers = _xifexpression;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
    final ArrayList<Pair<String,String>> list = _arrayList;
    Pair<String,String> _pair = Tuples.<String, String>pair("POLLING", "0");
    list.add(_pair);
    for (final MessageFromIf mif : triggers) {
      String _triggerCodeName = xpac.getTriggerCodeName(mif);
      InterfaceItem _from = mif.getFrom();
      String _name = _from.getName();
      String _plus = ("IFITEM_" + _name);
      String _plus_1 = (_plus + " + EVT_SHIFT*");
      String _messageID = this.pcGen.getMessageID(mif);
      String _plus_2 = (_plus_1 + _messageID);
      Pair<String,String> _pair_1 = Tuples.<String, String>pair(_triggerCodeName, _plus_2);
      list.add(_pair_1);
    }
    return this.langExt.genEnumeration("triggers", list);
  }
  
  public CharSequence genStateMachine(final ExpandedActorClass xpac) {
    CharSequence _genStateMachine = this.genStateMachine(xpac, true);
    return _genStateMachine;
  }
  
  public CharSequence genStateMachine(final ExpandedActorClass xpac, final boolean shallGenerateOneFile) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ActorCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
      ActorCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = (async || eventDriven);
      }
      final boolean handleEvents = _or;
      String _name = ac.getName();
      final String opScope = this.langExt.operationScope(_name, false);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        _xifexpression = opScope;
      } else {
        _xifexpression = "";
      }
      final String opScopePriv = _xifexpression;
      String _xifexpression_1 = null;
      boolean _usesInheritance_1 = this.langExt.usesInheritance();
      if (_usesInheritance_1) {
        String _accessLevelPublic = this.langExt.accessLevelPublic();
        _xifexpression_1 = _accessLevelPublic;
      } else {
        String _accessLevelPrivate = this.langExt.accessLevelPrivate();
        _xifexpression_1 = _accessLevelPrivate;
      }
      final String publicIf = _xifexpression_1;
      final String privAccess = this.langExt.accessLevelPrivate();
      String _name_1 = ac.getName();
      final String self = this.langExt.selfPointer(_name_1, true);
      String _name_2 = ac.getName();
      final String selfOnly = this.langExt.selfPointer(_name_2, false);
      String _xifexpression_2 = null;
      boolean _usesInheritance_2 = this.langExt.usesInheritance();
      if (_usesInheritance_2) {
        String _xifexpression_3 = null;
        boolean _usesPointers = this.langExt.usesPointers();
        if (_usesPointers) {
          _xifexpression_3 = "->getLocalId()";
        } else {
          _xifexpression_3 = ".getLocalId()";
        }
        _xifexpression_2 = _xifexpression_3;
      } else {
        _xifexpression_2 = "->localId";
      }
      final String getLocalId = _xifexpression_2;
      StringConcatenation _builder = new StringConcatenation();
      {
        if (shallGenerateOneFile) {
          _builder.append("/* state IDs */");
          _builder.newLine();
          String _genStateIdConstants = this.genStateIdConstants(xpac);
          _builder.append(_genStateIdConstants, "");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("/* transition chains */");
          _builder.newLine();
          String _genTransitionChainConstants = this.genTransitionChainConstants(xpac);
          _builder.append(_genTransitionChainConstants, "");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("/* triggers */");
          _builder.newLine();
          String _genTriggerConstants = this.genTriggerConstants(xpac);
          _builder.append(_genTriggerConstants, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _genExtra = this.genExtra(xpac);
      _builder.append(_genExtra, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _stateList = this._roomExtensions.getStateList(_stateMachine);
        for(final State state : _stateList) {
          {
            boolean _or_1 = false;
            boolean _usesInheritance_3 = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance_3);
            if (_not) {
              _or_1 = true;
            } else {
              boolean _isOwnObject = xpac.isOwnObject(state);
              _or_1 = (_not || _isOwnObject);
            }
            if (_or_1) {
              CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state);
              _builder.append(_genActionCodeMethods, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<Transition> _transitionList = this._roomExtensions.getTransitionList(_stateMachine_1);
        for(final Transition tr : _transitionList) {
          {
            boolean _and = false;
            boolean _or_2 = false;
            boolean _usesInheritance_4 = this.langExt.usesInheritance();
            boolean _not_1 = (!_usesInheritance_4);
            if (_not_1) {
              _or_2 = true;
            } else {
              boolean _isOwnObject_1 = xpac.isOwnObject(tr);
              _or_2 = (_not_1 || _isOwnObject_1);
            }
            if (!_or_2) {
              _and = false;
            } else {
              boolean _hasActionCode = this._roomExtensions.hasActionCode(tr);
              _and = (_or_2 && _hasActionCode);
            }
            if (_and) {
              TransitionChain _chain = xpac.getChain(tr);
              Transition start = _chain.getTransition();
              _builder.newLineIfNotEmpty();
              boolean _and_1 = false;
              if (!(start instanceof NonInitialTransition)) {
                _and_1 = false;
              } else {
                boolean _not_2 = (!(start instanceof GuardedTransition));
                _and_1 = ((start instanceof NonInitialTransition) && _not_2);
              }
              boolean hasArgs = _and_1;
              _builder.newLineIfNotEmpty();
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              String _actionCodeOperationName = CodegenHelpers.getActionCodeOperationName(tr);
              _builder.append(_actionCodeOperationName, "");
              _builder.append("(");
              String _name_3 = ac.getName();
              String _selfPointer = this.langExt.selfPointer(_name_3, hasArgs);
              _builder.append(_selfPointer, "");
              {
                if (hasArgs) {
                  _builder.append("InterfaceItemBase");
                  String _pointerLiteral = this.langExt.pointerLiteral();
                  _builder.append(_pointerLiteral, "");
                  _builder.append(" ifitem");
                  String _generateArgumentList = this.transitionChainGenerator.generateArgumentList(xpac, tr);
                  _builder.append(_generateArgumentList, "");
                }
              }
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              AbstractGenerator _instance = AbstractGenerator.getInstance();
              DetailCode _action = tr.getAction();
              String _translatedCode = _instance.getTranslatedCode(_action);
              _builder.append(_translatedCode, "	");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls exit codes while exiting from the current state to one of its");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* parent states while remembering the history");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param current - the current state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param to - the final parent state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      _builder.append("void ");
      _builder.append(opScopePriv, "");
      _builder.append("exitTo(");
      _builder.append(self, "");
      _builder.append("int current, int to, ");
      String _boolType = this.boolType();
      _builder.append(_boolType, "");
      _builder.append(" handler) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("while (current!=to) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch (current) {");
      _builder.newLine();
      {
        StateGraph _stateMachine_2 = xpac.getStateMachine();
        List<State> _baseStateList = this._roomExtensions.getBaseStateList(_stateMachine_2);
        for(final State state_1 : _baseStateList) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _stateId = this._roomExtensions.getStateId(state_1);
          _builder.append(_stateId, "			");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasExitCode = this._roomExtensions.hasExitCode(state_1);
            if (_hasExitCode) {
              _builder.append("if (!handler) ");
              String _exitCodeOperationName = CodegenHelpers.getExitCodeOperationName(state_1);
              _builder.append(_exitCodeOperationName, "				");
              _builder.append("(");
              String _selfPointer_1 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_1, "				");
              _builder.append(");");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          String _memberAccess = this.langExt.memberAccess();
          _builder.append(_memberAccess, "				");
          _builder.append("history[");
          String _parentStateId = CodegenHelpers.getParentStateId(state_1);
          _builder.append(_parentStateId, "				");
          _builder.append("] = ");
          String _stateId_1 = this._roomExtensions.getStateId(state_1);
          _builder.append(_stateId_1, "				");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          _builder.append("current = ");
          String _parentStateId_1 = CodegenHelpers.getParentStateId(state_1);
          _builder.append(_parentStateId_1, "				");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls action, entry and exit codes along a transition chain. The generic data are cast to typed data");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* matching the trigger of this chain. The ID of the final state is returned");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param chain - the chain ID");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param generic_data - the generic data pointer");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @return the ID of the final state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      _builder.append("int ");
      _builder.append(opScopePriv, "");
      _builder.append("executeTransitionChain(");
      _builder.append(self, "");
      _builder.append("int chain");
      {
        if (handleEvents) {
          _builder.append(", InterfaceItemBase");
          String _pointerLiteral_1 = this.langExt.pointerLiteral();
          _builder.append(_pointerLiteral_1, "");
          _builder.append(" ifitem, ");
          String _voidPointer = this.langExt.voidPointer();
          _builder.append(_voidPointer, "");
          _builder.append(" generic_data");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("switch (chain) {");
      _builder.newLine();
      _builder.append("\t\t");
      EList<TransitionChain> allchains = xpac.getTransitionChains();
      _builder.newLineIfNotEmpty();
      {
        for(final TransitionChain tc : allchains) {
          _builder.append("\t\t");
          _builder.append("case ");
          String _chainId = this._roomExtensions.getChainId(tc);
          _builder.append(_chainId, "		");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          String _generateExecuteChain = this.transitionChainGenerator.generateExecuteChain(xpac, tc);
          _builder.append(_generateExecuteChain, "			");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return NO_STATE;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param state - the state which is entered");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param handler - entry code is executed if not handler");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append(privAccess, "");
      _builder.append("int ");
      _builder.append(opScopePriv, "");
      _builder.append("enterHistory(");
      _builder.append(self, "");
      _builder.append("int state, ");
      String _boolType_1 = this.boolType();
      _builder.append(_boolType_1, "");
      _builder.append(" handler, ");
      String _boolType_2 = this.boolType();
      _builder.append(_boolType_2, "");
      _builder.append(" skip_entry) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("while (");
      String _booleanConstant = this.langExt.booleanConstant(true);
      _builder.append(_booleanConstant, "	");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("switch (state) {");
      _builder.newLine();
      {
        StateGraph _stateMachine_3 = xpac.getStateMachine();
        List<State> _baseStateList_1 = this._roomExtensions.getBaseStateList(_stateMachine_3);
        for(final State state_2 : _baseStateList_1) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _stateId_2 = this._roomExtensions.getStateId(state_2);
          _builder.append(_stateId_2, "			");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasEntryCode = this._roomExtensions.hasEntryCode(state_2);
            if (_hasEntryCode) {
              _builder.append("if (!(skip_entry || handler)) ");
              String _entryCodeOperationName = CodegenHelpers.getEntryCodeOperationName(state_2);
              _builder.append(_entryCodeOperationName, "				");
              _builder.append("(");
              String _selfPointer_2 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_2, "				");
              _builder.append(");");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            boolean _isLeaf = this._roomExtensions.isLeaf(state_2);
            if (_isLeaf) {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("// in leaf state: return state id");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("return ");
              String _stateId_3 = this._roomExtensions.getStateId(state_2);
              _builder.append(_stateId_3, "				");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("// state has a sub graph");
              _builder.newLine();
              {
                StateGraph _subgraph = state_2.getSubgraph();
                boolean _hasInitTransition = this._roomExtensions.hasInitTransition(_subgraph);
                if (_hasInitTransition) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("// with init transition");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("if (");
                  String _memberAccess_1 = this.langExt.memberAccess();
                  _builder.append(_memberAccess_1, "				");
                  _builder.append("history[");
                  String _stateId_4 = this._roomExtensions.getStateId(state_2);
                  _builder.append(_stateId_4, "				");
                  _builder.append("]==NO_STATE) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  StateGraph _subgraph_1 = state_2.getSubgraph();
                  Transition sub_initt = this._roomExtensions.getInitTransition(_subgraph_1);
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("state = executeTransitionChain(");
                  String _selfPointer_3 = this.langExt.selfPointer(true);
                  _builder.append(_selfPointer_3, "					");
                  TransitionChain _chain_1 = xpac.getChain(sub_initt);
                  String _chainId_1 = this._roomExtensions.getChainId(_chain_1);
                  _builder.append(_chainId_1, "					");
                  {
                    if (handleEvents) {
                      _builder.append(", ");
                      String _nullPointer = this.langExt.nullPointer();
                      _builder.append(_nullPointer, "					");
                      _builder.append(", ");
                      String _nullPointer_1 = this.langExt.nullPointer();
                      _builder.append(_nullPointer_1, "					");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("else {");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("state = ");
                  String _memberAccess_2 = this.langExt.memberAccess();
                  _builder.append(_memberAccess_2, "					");
                  _builder.append("history[");
                  String _stateId_5 = this._roomExtensions.getStateId(state_2);
                  _builder.append(_stateId_5, "					");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("// without init transition");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("state = ");
                  String _memberAccess_3 = this.langExt.memberAccess();
                  _builder.append(_memberAccess_3, "				");
                  _builder.append("history[");
                  String _stateId_6 = this._roomExtensions.getStateId(state_2);
                  _builder.append(_stateId_6, "				");
                  _builder.append("];");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t\t");
      _builder.append("case STATE_TOP:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("state = ");
      String _memberAccess_4 = this.langExt.memberAccess();
      _builder.append(_memberAccess_4, "				");
      _builder.append("history[STATE_TOP];");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("skip_entry = ");
      String _booleanConstant_1 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_1, "		");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append(publicIf, "");
      _builder.append("void ");
      _builder.append(opScope, "");
      _builder.append("executeInitTransition(");
      _builder.append(selfOnly, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      StateGraph _stateMachine_4 = xpac.getStateMachine();
      Transition initt = this._roomExtensions.getInitTransition(_stateMachine_4);
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int chain = ");
      TransitionChain _chain_2 = xpac.getChain(initt);
      String _chainId_2 = this._roomExtensions.getChainId(_chain_2);
      _builder.append(_chainId_2, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int next = ");
      _builder.append(opScopePriv, "	");
      _builder.append("executeTransitionChain(");
      String _selfPointer_4 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_4, "	");
      _builder.append("chain");
      {
        if (handleEvents) {
          _builder.append(", ");
          String _nullPointer_2 = this.langExt.nullPointer();
          _builder.append(_nullPointer_2, "	");
          _builder.append(", ");
          String _nullPointer_3 = this.langExt.nullPointer();
          _builder.append(_nullPointer_3, "	");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("next = ");
      _builder.append(opScopePriv, "	");
      _builder.append("enterHistory(");
      String _selfPointer_5 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_5, "	");
      _builder.append("next, ");
      String _booleanConstant_2 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_2, "	");
      _builder.append(", ");
      String _booleanConstant_3 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_3, "	");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("setState(");
      String _selfPointer_6 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_6, "	");
      _builder.append("next);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append(publicIf, "");
      _builder.append("void ");
      _builder.append(opScope, "");
      _builder.append("receiveEvent(");
      String _name_4 = ac.getName();
      String _selfPointer_7 = this.langExt.selfPointer(_name_4, handleEvents);
      _builder.append(_selfPointer_7, "");
      {
        if (handleEvents) {
          _builder.append("InterfaceItemBase");
          String _pointerLiteral_2 = this.langExt.pointerLiteral();
          _builder.append(_pointerLiteral_2, "");
          _builder.append(" ifitem, int evt, ");
          String _voidPointer_1 = this.langExt.voidPointer();
          _builder.append(_voidPointer_1, "");
          _builder.append(" generic_data");
        }
      }
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        if (async) {
          _builder.append("\t");
          _builder.append("int trigger = (ifitem==");
          String _nullPointer_4 = this.langExt.nullPointer();
          _builder.append(_nullPointer_4, "	");
          _builder.append(")? POLLING : ifitem");
          _builder.append(getLocalId, "	");
          _builder.append(" + EVT_SHIFT*evt;");
          _builder.newLineIfNotEmpty();
        } else {
          if (eventDriven) {
            _builder.append("\t");
            _builder.append("int trigger = ifitem");
            _builder.append(getLocalId, "	");
            _builder.append(" + EVT_SHIFT*evt;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.append("\t");
      _builder.append("int chain = NOT_CAUGHT;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int catching_state = NO_STATE;");
      _builder.newLine();
      _builder.append("\t");
      String _boolType_3 = this.boolType();
      _builder.append(_boolType_3, "	");
      _builder.append(" is_handler = ");
      String _booleanConstant_4 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_4, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _boolType_4 = this.boolType();
      _builder.append(_boolType_4, "	");
      _builder.append(" skip_entry = ");
      String _booleanConstant_5 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_5, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        if (handleEvents) {
          _builder.append("\t");
          _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data)) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genStateSwitch = this.genStateSwitch(xpac);
          _builder.append(_genStateSwitch, "		");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          CharSequence _genStateSwitch_1 = this.genStateSwitch(xpac);
          _builder.append(_genStateSwitch_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("if (chain != NOT_CAUGHT) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(opScopePriv, "		");
      _builder.append("exitTo(");
      String _selfPointer_8 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_8, "		");
      _builder.append("getState(");
      String _selfPointer_9 = this.langExt.selfPointer(false);
      _builder.append(_selfPointer_9, "		");
      _builder.append("), catching_state, is_handler);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("int next = ");
      _builder.append(opScopePriv, "		");
      _builder.append("executeTransitionChain(");
      String _selfPointer_10 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_10, "		");
      _builder.append("chain");
      {
        if (handleEvents) {
          _builder.append(", ifitem, generic_data");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("next = ");
      _builder.append(opScopePriv, "		");
      _builder.append("enterHistory(");
      String _selfPointer_11 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_11, "		");
      _builder.append("next, is_handler, skip_entry);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("setState(");
      String _selfPointer_12 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_12, "		");
      _builder.append("next);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t ");
      _builder.newLine();
      _builder.append("//******************************************");
      _builder.newLine();
      _builder.append("// END of generated code for FSM");
      _builder.newLine();
      _builder.append("//******************************************");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genStateSwitch(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      ActorClass _actorClass = xpac.getActorClass();
      ActorCommunicationType _commType = _actorClass.getCommType();
      boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
      ActorClass _actorClass_1 = xpac.getActorClass();
      ActorCommunicationType _commType_1 = _actorClass_1.getCommType();
      boolean eventDriven = Objects.equal(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      ActorClass _actorClass_2 = xpac.getActorClass();
      ActorCommunicationType _commType_2 = _actorClass_2.getCommType();
      boolean dataDriven = Objects.equal(_commType_2, ActorCommunicationType.DATA_DRIVEN);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (getState(");
      String _selfPointer = this.langExt.selfPointer(false);
      _builder.append(_selfPointer, "");
      _builder.append(")) {");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _leafStateList = this._roomExtensions.getLeafStateList(_stateMachine);
        for(final State state : _leafStateList) {
          _builder.append("\t");
          _builder.append("case ");
          String _stateId = this._roomExtensions.getStateId(state);
          _builder.append(_stateId, "	");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              _builder.append("\t");
              _builder.append("\t");
              EList<ActiveTrigger> atlist = xpac.getActiveTriggers(state);
              _builder.newLineIfNotEmpty();
              {
                boolean _isEmpty = atlist.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("switch(trigger) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("case POLLING:");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genDataDrivenTriggers = this.genDataDrivenTriggers(xpac, state);
                  _builder.append(_genDataDrivenTriggers, "			");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("break;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genEventDrivenTriggers = this.genEventDrivenTriggers(xpac, state, atlist);
                  _builder.append(_genEventDrivenTriggers, "			");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genDataDrivenTriggers_1 = this.genDataDrivenTriggers(xpac, state);
                  _builder.append(_genDataDrivenTriggers_1, "		");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (dataDriven) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _genDataDrivenTriggers_2 = this.genDataDrivenTriggers(xpac, state);
                _builder.append(_genDataDrivenTriggers_2, "		");
                _builder.newLineIfNotEmpty();
              } else {
                if (eventDriven) {
                  _builder.append("\t");
                  _builder.append("\t");
                  EList<ActiveTrigger> atlist_1 = xpac.getActiveTriggers(state);
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _isEmpty_1 = atlist_1.isEmpty();
                    boolean _not_1 = (!_isEmpty_1);
                    if (_not_1) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("switch(trigger) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      CharSequence _genEventDrivenTriggers_1 = this.genEventDrivenTriggers(xpac, state, atlist_1);
                      _builder.append(_genEventDrivenTriggers_1, "			");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genDataDrivenTriggers(final ExpandedActorClass xpac, final State state) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _genDoCodes = this.genDoCodes(state);
    _builder.append(_genDoCodes, "");
    _builder.newLineIfNotEmpty();
    List<Transition> _outgoingTransitionsHierarchical = this._roomExtensions.getOutgoingTransitionsHierarchical(xpac, state);
    final Function1<Transition,Boolean> _function = new Function1<Transition,Boolean>() {
        public Boolean apply(final Transition t) {
          return Boolean.valueOf((t instanceof GuardedTransition));
        }
      };
    Iterable<Transition> transitions = IterableExtensions.<Transition>filter(_outgoingTransitionsHierarchical, _function);
    _builder.newLineIfNotEmpty();
    {
      for(final Transition tr : transitions) {
        _builder.append("if (");
        AbstractGenerator _instance = AbstractGenerator.getInstance();
        DetailCode _guard = ((GuardedTransition) tr).getGuard();
        String _translatedCode = _instance.getTranslatedCode(_guard);
        _builder.append(_translatedCode, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        TransitionChain chain = xpac.getChain(tr);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("chain = ");
        String _chainId = this._roomExtensions.getChainId(chain);
        _builder.append(_chainId, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("catching_state = ");
        String _contextId = this._roomExtensions.getContextId(chain);
        _builder.append(_contextId, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          boolean _isHandler = chain.isHandler();
          if (_isHandler) {
            _builder.append("is_handler = TRUE;");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          boolean _isSkipEntry = chain.isSkipEntry();
          if (_isSkipEntry) {
            _builder.append("skip_entry = TRUE;");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        {
          Transition _last = IterableExtensions.<Transition>last(transitions);
          boolean _notEquals = (!Objects.equal(tr, _last));
          if (_notEquals) {
            _builder.append("else ");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private CharSequence genEventDrivenTriggers(final ExpandedActorClass xpac, final State state, final List<ActiveTrigger> atlist) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final ActiveTrigger at : atlist) {
        _builder.append("case ");
        String _trigger = at.getTrigger();
        String _triggerCodeName = xpac.getTriggerCodeName(_trigger);
        _builder.append(_triggerCodeName, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        boolean needData = this._roomExtensions.hasGuard(xpac, at);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          if (needData) {
            _builder.append("{ ");
            Message _msg = at.getMsg();
            String _typedDataDefinition = this.langExt.getTypedDataDefinition(_msg);
            _builder.append(_typedDataDefinition, "	");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<TriggeredTransition> _transitions = at.getTransitions();
          boolean _hasElements = false;
          for(final TriggeredTransition tt : _transitions) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(" else ", "	");
            }
            _builder.append("\t");
            TransitionChain chain = xpac.getChain(tt);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            Transition _transition = chain.getTransition();
            String _trigger_1 = at.getTrigger();
            CharSequence _guard = this.guard(_transition, _trigger_1, xpac);
            _builder.append(_guard, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("chain = ");
            String _chainId = this._roomExtensions.getChainId(chain);
            _builder.append(_chainId, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("catching_state = ");
            String _contextId = this._roomExtensions.getContextId(chain);
            _builder.append(_contextId, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            {
              boolean _isHandler = chain.isHandler();
              if (_isHandler) {
                _builder.append("is_handler = ");
                String _booleanConstant = this.langExt.booleanConstant(true);
                _builder.append(_booleanConstant, "		");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            {
              boolean _isSkipEntry = chain.isSkipEntry();
              if (_isSkipEntry) {
                _builder.append("skip_entry = ");
                String _booleanConstant_1 = this.langExt.booleanConstant(true);
                _builder.append(_booleanConstant_1, "		");
                _builder.append(";");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        {
          if (needData) {
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("break;");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence genExtra(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genExtraDecl(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _guard(final TriggeredTransition tt, final String trigger, final ExpandedActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      EList<Trigger> _triggers = tt.getTriggers();
      final Function1<Trigger,Boolean> _function = new Function1<Trigger,Boolean>() {
          public Boolean apply(final Trigger e) {
            boolean _isMatching = ac.isMatching(e, trigger);
            return Boolean.valueOf(_isMatching);
          }
        };
      Trigger tr = IterableExtensions.<Trigger>findFirst(_triggers, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasGuard = this._roomExtensions.hasGuard(tr);
        if (_hasGuard) {
          _builder.append("if (");
          AbstractGenerator _instance = AbstractGenerator.getInstance();
          Guard _guard = tr.getGuard();
          DetailCode _guard_1 = _guard.getGuard();
          String _translatedCode = _instance.getTranslatedCode(_guard_1);
          _builder.append(_translatedCode, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence _guard(final Transition t, final String trigger, final ExpandedActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* error */");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence genDoCodes(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasDoCode = this._roomExtensions.hasDoCode(state);
      if (_hasDoCode) {
        String _doCodeOperationName = CodegenHelpers.getDoCodeOperationName(state);
        _builder.append(_doCodeOperationName, "");
        _builder.append("(");
        String _selfPointer = this.langExt.selfPointer(false);
        _builder.append(_selfPointer, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EObject _eContainer = state.eContainer();
      EObject _eContainer_1 = _eContainer.eContainer();
      if ((_eContainer_1 instanceof State)) {
        EObject _eContainer_2 = state.eContainer();
        EObject _eContainer_3 = _eContainer_2.eContainer();
        CharSequence _genDoCodes = this.genDoCodes(((State) _eContainer_3));
        _builder.append(_genDoCodes, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state) {
    CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state, true);
    return _genActionCodeMethods;
  }
  
  private CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state, final boolean generateImplementation) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ActorClass _actorClass = xpac.getActorClass();
      String _name = _actorClass.getName();
      final String selfPtr = this.langExt.selfPointer(_name, false);
      String _name_1 = ac.getName();
      final String opScope = this.langExt.operationScope(_name_1, false);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        _xifexpression = opScope;
      } else {
        _xifexpression = "";
      }
      final String opScopePriv = _xifexpression;
      final String entryOp = CodegenHelpers.getEntryCodeOperationName(state);
      final String exitOp = CodegenHelpers.getExitCodeOperationName(state);
      final String doOp = CodegenHelpers.getDoCodeOperationName(state);
      AbstractGenerator _instance = AbstractGenerator.getInstance();
      DetailCode _entryCode = state.getEntryCode();
      String entry = _instance.getTranslatedCode(_entryCode);
      AbstractGenerator _instance_1 = AbstractGenerator.getInstance();
      DetailCode _exitCode = state.getExitCode();
      String exit = _instance_1.getTranslatedCode(_exitCode);
      AbstractGenerator _instance_2 = AbstractGenerator.getInstance();
      DetailCode _doCode = state.getDoCode();
      String docode = _instance_2.getTranslatedCode(_doCode);
      if ((state instanceof ExpandedRefinedState)) {
        final ExpandedRefinedState rs = ((ExpandedRefinedState) state);
        AbstractGenerator _instance_3 = AbstractGenerator.getInstance();
        DetailCode _inheritedEntry = rs.getInheritedEntry();
        final String inhEntry = _instance_3.getTranslatedCode(_inheritedEntry);
        AbstractGenerator _instance_4 = AbstractGenerator.getInstance();
        DetailCode _inheritedExit = rs.getInheritedExit();
        final String inhExit = _instance_4.getTranslatedCode(_inheritedExit);
        AbstractGenerator _instance_5 = AbstractGenerator.getInstance();
        DetailCode _inheritedDo = rs.getInheritedDo();
        final String inhDo = _instance_5.getTranslatedCode(_inheritedDo);
        boolean _usesInheritance_1 = this.langExt.usesInheritance();
        if (_usesInheritance_1) {
          ActorClass _actorClass_1 = xpac.getActorClass();
          ActorClass _base = _actorClass_1.getBase();
          final String baseName = _base.getName();
          DetailCode _inheritedEntry_1 = rs.getInheritedEntry();
          boolean _empty = this._roomExtensions.empty(_inheritedEntry_1);
          boolean _not = (!_empty);
          if (_not) {
            String _superCall = this.langExt.superCall(baseName, entryOp, "");
            String _plus = (_superCall + entry);
            entry = _plus;
          }
          DetailCode _inheritedExit_1 = rs.getInheritedExit();
          boolean _empty_1 = this._roomExtensions.empty(_inheritedExit_1);
          boolean _not_1 = (!_empty_1);
          if (_not_1) {
            String _superCall_1 = this.langExt.superCall(baseName, exitOp, "");
            String _plus_1 = (exit + _superCall_1);
            exit = _plus_1;
          }
          DetailCode _inheritedDo_1 = rs.getInheritedDo();
          boolean _empty_2 = this._roomExtensions.empty(_inheritedDo_1);
          boolean _not_2 = (!_empty_2);
          if (_not_2) {
            String _superCall_2 = this.langExt.superCall(baseName, doOp, "");
            String _plus_2 = (_superCall_2 + docode);
            docode = _plus_2;
          }
        } else {
          String _plus_3 = (inhEntry + entry);
          entry = _plus_3;
          String _plus_4 = (exit + inhExit);
          exit = _plus_4;
          String _plus_5 = (inhDo + docode);
          docode = _plus_5;
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = entry.isEmpty();
        boolean _not_3 = (!_isEmpty);
        if (_not_3) {
          {
            if (generateImplementation) {
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              _builder.append(entryOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(entry, "	");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_1 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_1, "");
              _builder.append("void ");
              _builder.append(entryOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        boolean _isEmpty_1 = exit.isEmpty();
        boolean _not_4 = (!_isEmpty_1);
        if (_not_4) {
          {
            if (generateImplementation) {
              String _accessLevelProtected_2 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_2, "");
              _builder.append("void ");
              _builder.append(opScopePriv, "");
              _builder.append(exitOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(exit, "	");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_3 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_3, "");
              _builder.append("void ");
              _builder.append(exitOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        boolean _isEmpty_2 = docode.isEmpty();
        boolean _not_5 = (!_isEmpty_2);
        if (_not_5) {
          {
            if (generateImplementation) {
              String _accessLevelProtected_4 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_4, "");
              _builder.append(" void ");
              _builder.append(opScopePriv, "");
              _builder.append(doOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(docode, "	");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              String _accessLevelProtected_5 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_5, "");
              _builder.append("void ");
              _builder.append(doOp, "");
              _builder.append("(");
              _builder.append(selfPtr, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public String constPointer(final String classname) {
    return classname;
  }
  
  public String boolType() {
    return "boolean";
  }
  
  public CharSequence genStateMachineMethodDeclarations(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ActorCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
      ActorCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = (async || eventDriven);
      }
      final boolean handleEvents = _or;
      String _name = ac.getName();
      final String self = this.langExt.selfPointer(_name, true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("/* state IDs */");
      _builder.newLine();
      String _genStateIdConstants = this.genStateIdConstants(xpac);
      _builder.append(_genStateIdConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* transition chains */");
      _builder.newLine();
      String _genTransitionChainConstants = this.genTransitionChainConstants(xpac);
      _builder.append(_genTransitionChainConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* triggers */");
      _builder.newLine();
      String _genTriggerConstants = this.genTriggerConstants(xpac);
      _builder.append(_genTriggerConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _genExtraDecl = this.genExtraDecl(xpac);
      _builder.append(_genExtraDecl, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _stateList = this._roomExtensions.getStateList(_stateMachine);
        for(final State state : _stateList) {
          {
            boolean _or_1 = false;
            boolean _usesInheritance = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance);
            if (_not) {
              _or_1 = true;
            } else {
              boolean _isOwnObject = xpac.isOwnObject(state);
              _or_1 = (_not || _isOwnObject);
            }
            if (_or_1) {
              CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state, false);
              _builder.append(_genActionCodeMethods, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<Transition> _transitionList = this._roomExtensions.getTransitionList(_stateMachine_1);
        for(final Transition tr : _transitionList) {
          {
            boolean _and = false;
            boolean _or_2 = false;
            boolean _usesInheritance_1 = this.langExt.usesInheritance();
            boolean _not_1 = (!_usesInheritance_1);
            if (_not_1) {
              _or_2 = true;
            } else {
              boolean _isOwnObject_1 = xpac.isOwnObject(tr);
              _or_2 = (_not_1 || _isOwnObject_1);
            }
            if (!_or_2) {
              _and = false;
            } else {
              boolean _hasActionCode = this._roomExtensions.hasActionCode(tr);
              _and = (_or_2 && _hasActionCode);
            }
            if (_and) {
              TransitionChain _chain = xpac.getChain(tr);
              Transition start = _chain.getTransition();
              _builder.newLineIfNotEmpty();
              boolean _and_1 = false;
              if (!(start instanceof NonInitialTransition)) {
                _and_1 = false;
              } else {
                boolean _not_2 = (!(start instanceof GuardedTransition));
                _and_1 = ((start instanceof NonInitialTransition) && _not_2);
              }
              boolean hasArgs = _and_1;
              _builder.newLineIfNotEmpty();
              String _accessLevelProtected = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected, "");
              _builder.append("void ");
              String _actionCodeOperationName = CodegenHelpers.getActionCodeOperationName(tr);
              _builder.append(_actionCodeOperationName, "");
              _builder.append("(");
              String _name_1 = ac.getName();
              String _selfPointer = this.langExt.selfPointer(_name_1, hasArgs);
              _builder.append(_selfPointer, "");
              {
                if (hasArgs) {
                  String _constPointer = this.constPointer("etRuntime::InterfaceItemBase");
                  _builder.append(_constPointer, "");
                  _builder.append(" ifitem");
                  String _generateArgumentList = this.transitionChainGenerator.generateArgumentList(xpac, tr);
                  _builder.append(_generateArgumentList, "");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("private:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls exit codes while exiting from the current state to one of its");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* parent states while remembering the history");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param current - the current state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param to - the final parent state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void exitTo(");
      _builder.append(self, "	");
      _builder.append("int current, int to, ");
      String _boolType = this.boolType();
      _builder.append(_boolType, "	");
      _builder.append(" handler);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls action, entry and exit codes along a transition chain. The generic data are cast to typed data");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* matching the trigger of this chain. The ID of the final state is returned");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param chain - the chain ID");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param generic_data - the generic data pointer");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return the ID of the final state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int executeTransitionChain(");
      _builder.append(self, "	");
      _builder.append("int chain");
      {
        if (handleEvents) {
          _builder.append(", ");
          String _constPointer_1 = this.constPointer("etRuntime::InterfaceItemBase");
          _builder.append(_constPointer_1, "	");
          _builder.append(" ifitem, ");
          String _voidPointer = this.langExt.voidPointer();
          _builder.append(_voidPointer, "	");
          _builder.append(" generic_data");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param state - the state which is entered");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param handler - entry code is executed if not handler");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int enterHistory(");
      _builder.append(self, "	");
      _builder.append("int state, ");
      String _boolType_1 = this.boolType();
      _builder.append(_boolType_1, "	");
      _builder.append(" handler, ");
      String _boolType_2 = this.boolType();
      _builder.append(_boolType_2, "	");
      _builder.append(" skip_entry);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void executeInitTransition(");
      String _name_2 = ac.getName();
      String _selfPointer_1 = this.langExt.selfPointer(_name_2, false);
      _builder.append(_selfPointer_1, "	");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void receiveEvent(");
      String _name_3 = ac.getName();
      String _selfPointer_2 = this.langExt.selfPointer(_name_3, handleEvents);
      _builder.append(_selfPointer_2, "	");
      {
        if (handleEvents) {
          _builder.append("etRuntime::InterfaceItemBase* ifitem, int evt, ");
          String _voidPointer_1 = this.langExt.voidPointer();
          _builder.append(_voidPointer_1, "	");
          _builder.append(" generic_data");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence guard(final Transition tt, final String trigger, final ExpandedActorClass ac) {
    if (tt instanceof TriggeredTransition) {
      return _guard((TriggeredTransition)tt, trigger, ac);
    } else if (tt != null) {
      return _guard(tt, trigger, ac);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tt, trigger, ac).toString());
    }
  }
}
