package org.eclipse.etrice.generator.generic;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
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
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.base.DetailCodeTranslator;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GenericStateMachineGenerator {
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  protected RoomExtensions roomExt;
  
  @Inject
  protected GenericProtocolClassGenerator pcGen;
  
  @Inject
  protected AbstractTransitionChainGenerator languageGen;
  
  @Inject
  protected ITranslationProvider translator;
  
  private String genStateIdConstants(final ExpandedActorClass xpac, final ActorClass ac) {
      int _xifexpression = (int) 0;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        int _numberOfInheritedBaseStates = this.roomExt.getNumberOfInheritedBaseStates(ac);
        _xifexpression = _numberOfInheritedBaseStates;
      } else {
        _xifexpression = 0;
      }
      int _operator_plus = IntegerExtensions.operator_plus(((Integer)2), ((Integer)_xifexpression));
      int offset = _operator_plus;
      List<State> _xifexpression_1 = null;
      boolean _usesInheritance_1 = this.langExt.usesInheritance();
      if (_usesInheritance_1) {
        StateGraph _stateMachine = ac.getStateMachine();
        List<State> _baseStateList = this.roomExt.getBaseStateList(_stateMachine);
        _xifexpression_1 = _baseStateList;
      } else {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<State> _baseStateList_1 = this.roomExt.getBaseStateList(_stateMachine_1);
        _xifexpression_1 = _baseStateList_1;
      }
      List<State> baseStates = _xifexpression_1;
      ArrayList<State> _leafStatesLast = this.roomExt.getLeafStatesLast(baseStates);
      baseStates = _leafStatesLast;
      ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
      ArrayList<Pair<String,String>> list = _arrayList;
      boolean _usesInheritance_2 = this.langExt.usesInheritance();
      boolean _operator_not = BooleanExtensions.operator_not(_usesInheritance_2);
      if (_operator_not) {
        {
          Pair<String,String> _pair = Tuples.<String, String>pair("NO_STATE", "0");
          list.add(_pair);
          Pair<String,String> _pair_1 = Tuples.<String, String>pair("STATE_TOP", "1");
          list.add(_pair_1);
        }
      }
      for (final State state : baseStates) {
        {
          String _stateId = this.roomExt.getStateId(state);
          String _string = ((Integer)offset).toString();
          Pair<String,String> _pair_2 = Tuples.<String, String>pair(_stateId, _string);
          list.add(_pair_2);
          int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)1));
          offset = _operator_plus_1;
        }
      }
      String _genEnumeration = this.langExt.genEnumeration("state_ids", list);
      return _genEnumeration;
  }
  
  private String genTransitionChainConstants(final ExpandedActorClass xpac, final ActorClass ac) {
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
        int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)_size_1));
        _xifexpression_1 = _operator_minus;
      } else {
        _xifexpression_1 = 0;
      }
      int offset = _xifexpression_1;
      ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
      ArrayList<Pair<String,String>> list = _arrayList;
      for (final TransitionChain chain : chains) {
        {
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)1));
          offset = _operator_plus;
          String _chainId = this.roomExt.getChainId(chain);
          String _string = ((Integer)offset).toString();
          Pair<String,String> _pair = Tuples.<String, String>pair(_chainId, _string);
          list.add(_pair);
        }
      }
      String _genEnumeration = this.langExt.genEnumeration("chain_ids", list);
      return _genEnumeration;
  }
  
  private String genTriggerConstants(final ExpandedActorClass xpac, final ActorClass ac) {
      EList<MessageFromIf> _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        EList<MessageFromIf> _ownTriggers = xpac.getOwnTriggers();
        _xifexpression = _ownTriggers;
      } else {
        EList<MessageFromIf> _triggers = xpac.getTriggers();
        _xifexpression = _triggers;
      }
      EList<MessageFromIf> triggers = _xifexpression;
      ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String,String>>();
      ArrayList<Pair<String,String>> list = _arrayList;
      Pair<String,String> _pair = Tuples.<String, String>pair("POLLING", "0");
      list.add(_pair);
      for (final MessageFromIf mif : triggers) {
        String _triggerCodeName = xpac.getTriggerCodeName(mif);
        InterfaceItem _from = mif.getFrom();
        String _name = _from.getName();
        String _operator_plus = StringExtensions.operator_plus("IFITEM_", _name);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, " + EVT_SHIFT*");
        String _messageID = this.pcGen.getMessageID(mif);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _messageID);
        Pair<String,String> _pair_1 = Tuples.<String, String>pair(_triggerCodeName, _operator_plus_2);
        list.add(_pair_1);
      }
      String _genEnumeration = this.langExt.genEnumeration("triggers", list);
      return _genEnumeration;
  }
  
  public StringConcatenation genStateMachine(final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _xblockexpression = null;
    {
      this.translator.setActorClass(ac);
      DetailCodeTranslator _detailCodeTranslator = new DetailCodeTranslator(ac, this.translator);
      DetailCodeTranslator dct = _detailCodeTranslator;
      ActorCommunicationType _commType = ac.getCommType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_commType, ActorCommunicationType.ASYNCHRONOUS);
      boolean async = _operator_equals;
      ActorCommunicationType _commType_1 = ac.getCommType();
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      boolean eventDriven = _operator_equals_1;
      ActorCommunicationType _commType_2 = ac.getCommType();
      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_commType_2, ActorCommunicationType.DATA_DRIVEN);
      boolean dataDriven = _operator_equals_2;
      boolean _operator_or = false;
      if (async) {
        _operator_or = true;
      } else {
        _operator_or = BooleanExtensions.operator_or(async, eventDriven);
      }
      boolean handleEvents = _operator_or;
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("/* state IDs */");
      _builder.newLine();
      String _genStateIdConstants = this.genStateIdConstants(xpac, ac);
      _builder.append(_genStateIdConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* transition chains */");
      _builder.newLine();
      String _genTransitionChainConstants = this.genTransitionChainConstants(xpac, ac);
      _builder.append(_genTransitionChainConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* triggers */");
      _builder.newLine();
      String _genTriggerConstants = this.genTriggerConstants(xpac, ac);
      _builder.append(_genTriggerConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      StringConcatenation _genExtra = this.genExtra(xpac, ac);
      _builder.append(_genExtra, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _stateList = this.roomExt.getStateList(_stateMachine);
        for(final State state : _stateList) {
          {
            boolean _operator_or_1 = false;
            boolean _usesInheritance = this.langExt.usesInheritance();
            boolean _operator_not = BooleanExtensions.operator_not(_usesInheritance);
            if (_operator_not) {
              _operator_or_1 = true;
            } else {
              boolean _isOwnObject = xpac.isOwnObject(state);
              _operator_or_1 = BooleanExtensions.operator_or(_operator_not, _isOwnObject);
            }
            if (_operator_or_1) {
              {
                boolean _hasEntryCode = this.roomExt.hasEntryCode(state);
                if (_hasEntryCode) {
                  String _accessLevelProtected = this.langExt.accessLevelProtected();
                  _builder.append(_accessLevelProtected, "");
                  _builder.append("void ");
                  String _entryCodeOperationName = CodegenHelpers.getEntryCodeOperationName(state);
                  _builder.append(_entryCodeOperationName, "");
                  _builder.append("(");
                  String _name = ac.getName();
                  String _selfPointer = this.langExt.selfPointer(_name, false);
                  _builder.append(_selfPointer, "");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _entryCode = this.roomExt.getEntryCode(xpac, state, dct);
                  _builder.append(_entryCode, "	");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              {
                boolean _hasExitCode = this.roomExt.hasExitCode(state);
                if (_hasExitCode) {
                  String _accessLevelProtected_1 = this.langExt.accessLevelProtected();
                  _builder.append(_accessLevelProtected_1, "");
                  _builder.append("void ");
                  String _exitCodeOperationName = CodegenHelpers.getExitCodeOperationName(state);
                  _builder.append(_exitCodeOperationName, "");
                  _builder.append("(");
                  String _name_1 = ac.getName();
                  String _selfPointer_1 = this.langExt.selfPointer(_name_1, false);
                  _builder.append(_selfPointer_1, "");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _exitCode = this.roomExt.getExitCode(xpac, state, dct);
                  _builder.append(_exitCode, "	");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              {
                boolean _hasDoCode = this.roomExt.hasDoCode(state);
                if (_hasDoCode) {
                  _builder.append("static void ");
                  String _doCodeOperationName = CodegenHelpers.getDoCodeOperationName(state);
                  _builder.append(_doCodeOperationName, "");
                  _builder.append("(");
                  String _name_2 = ac.getName();
                  String _selfPointer_2 = this.langExt.selfPointer(_name_2, false);
                  _builder.append(_selfPointer_2, "");
                  _builder.append(") {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  String _doCode = this.roomExt.getDoCode(xpac, state, dct);
                  _builder.append(_doCode, "	");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        List<Transition> _transitionList = this.roomExt.getTransitionList(_stateMachine_1);
        for(final Transition tr : _transitionList) {
          {
            boolean _operator_and = false;
            boolean _isOwnObject_1 = xpac.isOwnObject(tr);
            if (!_isOwnObject_1) {
              _operator_and = false;
            } else {
              boolean _hasActionCode = this.roomExt.hasActionCode(tr);
              _operator_and = BooleanExtensions.operator_and(_isOwnObject_1, _hasActionCode);
            }
            if (_operator_and) {
              TransitionChain _chain = xpac.getChain(tr);
              Transition _transition = _chain.getTransition();
              Transition start = _transition;
              _builder.newLineIfNotEmpty();
              boolean _operator_and_1 = false;
              if (!(start instanceof NonInitialTransition)) {
                _operator_and_1 = false;
              } else {
                boolean _operator_not_1 = BooleanExtensions.operator_not((start instanceof GuardedTransition));
                _operator_and_1 = BooleanExtensions.operator_and((start instanceof NonInitialTransition), _operator_not_1);
              }
              boolean hasArgs = _operator_and_1;
              _builder.newLineIfNotEmpty();
              String _accessLevelProtected_2 = this.langExt.accessLevelProtected();
              _builder.append(_accessLevelProtected_2, "");
              _builder.append("void ");
              String _actionCodeOperationName = CodegenHelpers.getActionCodeOperationName(tr);
              _builder.append(_actionCodeOperationName, "");
              _builder.append("(");
              String _name_3 = ac.getName();
              String _selfPointer_3 = this.langExt.selfPointer(_name_3, hasArgs);
              _builder.append(_selfPointer_3, "");
              {
                if (hasArgs) {
                  _builder.append("InterfaceItemBase ifitem");
                  String _generateArgumentList = this.languageGen.generateArgumentList(xpac, tr);
                  _builder.append(_generateArgumentList, "");
                }
              }
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              String _actionCode = this.roomExt.getActionCode(xpac, tr, dct);
              _builder.append(_actionCode, "	");
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
      String _accessLevelPrivate = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate, "");
      _builder.append("void exitTo(");
      String _name_4 = ac.getName();
      String _selfPointer_4 = this.langExt.selfPointer(_name_4, true);
      _builder.append(_selfPointer_4, "");
      _builder.append("int current, int to, boolean handler) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("while (current!=to) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch (current) {");
      _builder.newLine();
      {
        StateGraph _stateMachine_2 = xpac.getStateMachine();
        List<State> _baseStateList = this.roomExt.getBaseStateList(_stateMachine_2);
        for(final State state_1 : _baseStateList) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _stateId = this.roomExt.getStateId(state_1);
          _builder.append(_stateId, "			");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasExitCode_1 = this.roomExt.hasExitCode(state_1);
            if (_hasExitCode_1) {
              _builder.append("if (!handler) ");
              String _exitCodeOperationName_1 = CodegenHelpers.getExitCodeOperationName(state_1);
              _builder.append(_exitCodeOperationName_1, "				");
              _builder.append("(");
              String _selfPointer_5 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_5, "				");
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
          String _stateId_1 = this.roomExt.getStateId(state_1);
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
      String _accessLevelPrivate_1 = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate_1, "");
      _builder.append("int executeTransitionChain(");
      String _name_5 = ac.getName();
      String _selfPointer_6 = this.langExt.selfPointer(_name_5, true);
      _builder.append(_selfPointer_6, "");
      _builder.append("int chain");
      {
        if (handleEvents) {
          _builder.append(", InterfaceItemBase ifitem, ");
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
      EList<TransitionChain> _transitionChains = xpac.getTransitionChains();
      EList<TransitionChain> allchains = _transitionChains;
      _builder.newLineIfNotEmpty();
      {
        for(final TransitionChain tc : allchains) {
          _builder.append("\t\t");
          _builder.append("case ");
          String _chainId = this.roomExt.getChainId(tc);
          _builder.append(_chainId, "		");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          String _generateExecuteChain = this.languageGen.generateExecuteChain(xpac, tc, dct);
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
      String _accessLevelPrivate_2 = this.langExt.accessLevelPrivate();
      _builder.append(_accessLevelPrivate_2, "");
      _builder.append("int enterHistory(");
      String _name_6 = ac.getName();
      String _selfPointer_7 = this.langExt.selfPointer(_name_6, true);
      _builder.append(_selfPointer_7, "");
      _builder.append("int state, boolean handler, boolean skip_entry) {");
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
        List<State> _baseStateList_1 = this.roomExt.getBaseStateList(_stateMachine_3);
        for(final State state_2 : _baseStateList_1) {
          _builder.append("\t\t\t");
          _builder.append("case ");
          String _stateId_2 = this.roomExt.getStateId(state_2);
          _builder.append(_stateId_2, "			");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("\t");
          {
            boolean _hasEntryCode_1 = this.roomExt.hasEntryCode(state_2);
            if (_hasEntryCode_1) {
              _builder.append("if (!(skip_entry || handler)) ");
              String _entryCodeOperationName_1 = CodegenHelpers.getEntryCodeOperationName(state_2);
              _builder.append(_entryCodeOperationName_1, "				");
              _builder.append("(");
              String _selfPointer_8 = this.langExt.selfPointer(false);
              _builder.append(_selfPointer_8, "				");
              _builder.append(");");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            boolean _isLeaf = this.roomExt.isLeaf(state_2);
            if (_isLeaf) {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("// in leaf state: return state id");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("return ");
              String _stateId_3 = this.roomExt.getStateId(state_2);
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
                boolean _hasInitTransition = this.roomExt.hasInitTransition(_subgraph);
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
                  String _stateId_4 = this.roomExt.getStateId(state_2);
                  _builder.append(_stateId_4, "				");
                  _builder.append("]==NO_STATE) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  StateGraph _subgraph_1 = state_2.getSubgraph();
                  Transition _initTransition = this.roomExt.getInitTransition(_subgraph_1);
                  Transition sub_initt = _initTransition;
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("state = executeTransitionChain(");
                  String _selfPointer_9 = this.langExt.selfPointer(true);
                  _builder.append(_selfPointer_9, "					");
                  TransitionChain _chain_1 = xpac.getChain(sub_initt);
                  String _chainId_1 = this.roomExt.getChainId(_chain_1);
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
                  String _stateId_5 = this.roomExt.getStateId(state_2);
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
                  String _stateId_6 = this.roomExt.getStateId(state_2);
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
      {
        boolean _usesInheritance_1 = this.langExt.usesInheritance();
        if (_usesInheritance_1) {
          String _accessLevelPublic = this.langExt.accessLevelPublic();
          _builder.append(_accessLevelPublic, "");
        } else {
          String _accessLevelPrivate_3 = this.langExt.accessLevelPrivate();
          _builder.append(_accessLevelPrivate_3, "");
        }
      }
      _builder.append("void executeInitTransition(");
      String _name_7 = ac.getName();
      String _selfPointer_10 = this.langExt.selfPointer(_name_7, false);
      _builder.append(_selfPointer_10, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      StateGraph _stateMachine_4 = xpac.getStateMachine();
      Transition _initTransition_1 = this.roomExt.getInitTransition(_stateMachine_4);
      Transition initt = _initTransition_1;
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int chain = ");
      TransitionChain _chain_2 = xpac.getChain(initt);
      String _chainId_2 = this.roomExt.getChainId(_chain_2);
      _builder.append(_chainId_2, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int next = executeTransitionChain(");
      String _selfPointer_11 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_11, "	");
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
      _builder.append("next = enterHistory(");
      String _selfPointer_12 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_12, "	");
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
      String _selfPointer_13 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_13, "	");
      _builder.append("next);");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      {
        boolean _usesInheritance_2 = this.langExt.usesInheritance();
        if (_usesInheritance_2) {
          String _accessLevelPublic_1 = this.langExt.accessLevelPublic();
          _builder.append(_accessLevelPublic_1, "");
        } else {
          String _accessLevelPrivate_4 = this.langExt.accessLevelPrivate();
          _builder.append(_accessLevelPrivate_4, "");
        }
      }
      _builder.append("void receiveEvent(");
      String _name_8 = ac.getName();
      String _selfPointer_14 = this.langExt.selfPointer(_name_8, handleEvents);
      _builder.append(_selfPointer_14, "");
      {
        if (handleEvents) {
          _builder.append("InterfaceItemBase ifitem, int evt, ");
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
          _builder.append(")? POLLING : ");
          {
            boolean _usesInheritance_3 = this.langExt.usesInheritance();
            if (_usesInheritance_3) {
              _builder.append("ifitem.getLocalId()");
            } else {
              _builder.append("ifitem->localId");
            }
          }
          _builder.append(" + EVT_SHIFT*evt;");
          _builder.newLineIfNotEmpty();
        } else {
          if (eventDriven) {
            _builder.append("\t");
            _builder.append("int trigger = ");
            {
              boolean _usesInheritance_4 = this.langExt.usesInheritance();
              if (_usesInheritance_4) {
                _builder.append("ifitem.getLocalId()");
              } else {
                _builder.append("ifitem->localId");
              }
            }
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
      _builder.append("boolean is_handler = ");
      String _booleanConstant_4 = this.langExt.booleanConstant(false);
      _builder.append(_booleanConstant_4, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("boolean skip_entry = ");
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
          StringConcatenation _genStateSwitch = this.genStateSwitch(xpac, dct);
          _builder.append(_genStateSwitch, "		");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("\t");
          StringConcatenation _genStateSwitch_1 = this.genStateSwitch(xpac, dct);
          _builder.append(_genStateSwitch_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("if (chain != NOT_CAUGHT) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("exitTo(");
      String _selfPointer_15 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_15, "		");
      String _memberAccess_5 = this.langExt.memberAccess();
      _builder.append(_memberAccess_5, "		");
      _builder.append("state, catching_state, is_handler);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("int next = executeTransitionChain(");
      String _selfPointer_16 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_16, "		");
      _builder.append("chain");
      {
        if (handleEvents) {
          _builder.append(", ifitem, generic_data");
        }
      }
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("next = enterHistory(");
      String _selfPointer_17 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_17, "		");
      _builder.append("next, is_handler, skip_entry);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("setState(");
      String _selfPointer_18 = this.langExt.selfPointer(true);
      _builder.append(_selfPointer_18, "		");
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
  
  private StringConcatenation genStateSwitch(final ExpandedActorClass xpac, final DetailCodeTranslator dct) {
    StringConcatenation _xblockexpression = null;
    {
      ActorClass _actorClass = xpac.getActorClass();
      ActorCommunicationType _commType = _actorClass.getCommType();
      boolean _operator_equals = ObjectExtensions.operator_equals(_commType, ActorCommunicationType.ASYNCHRONOUS);
      boolean async = _operator_equals;
      ActorClass _actorClass_1 = xpac.getActorClass();
      ActorCommunicationType _commType_1 = _actorClass_1.getCommType();
      boolean _operator_equals_1 = ObjectExtensions.operator_equals(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      boolean eventDriven = _operator_equals_1;
      ActorClass _actorClass_2 = xpac.getActorClass();
      ActorCommunicationType _commType_2 = _actorClass_2.getCommType();
      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_commType_2, ActorCommunicationType.DATA_DRIVEN);
      boolean dataDriven = _operator_equals_2;
      boolean _operator_or = false;
      if (async) {
        _operator_or = true;
      } else {
        _operator_or = BooleanExtensions.operator_or(async, eventDriven);
      }
      boolean handleEvents = _operator_or;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (");
      String _memberAccess = this.langExt.memberAccess();
      _builder.append(_memberAccess, "");
      _builder.append("state) {");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        List<State> _leafStateList = this.roomExt.getLeafStateList(_stateMachine);
        for(final State state : _leafStateList) {
          _builder.append("\t");
          _builder.append("case ");
          String _stateId = this.roomExt.getStateId(state);
          _builder.append(_stateId, "	");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              _builder.append("\t");
              _builder.append("\t");
              EList<ActiveTrigger> _activeTriggers = xpac.getActiveTriggers(state);
              EList<ActiveTrigger> atlist = _activeTriggers;
              _builder.newLineIfNotEmpty();
              {
                boolean _isEmpty = atlist.isEmpty();
                boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
                if (_operator_not) {
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
                  StringConcatenation _genDataDrivenTriggers = this.genDataDrivenTriggers(xpac, state, dct);
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
                  StringConcatenation _genEventDrivenTriggers = this.genEventDrivenTriggers(xpac, state, atlist, dct);
                  _builder.append(_genEventDrivenTriggers, "			");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("\t");
                  StringConcatenation _genDataDrivenTriggers_1 = this.genDataDrivenTriggers(xpac, state, dct);
                  _builder.append(_genDataDrivenTriggers_1, "		");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (dataDriven) {
                _builder.append("\t");
                _builder.append("\t");
                StringConcatenation _genDataDrivenTriggers_2 = this.genDataDrivenTriggers(xpac, state, dct);
                _builder.append(_genDataDrivenTriggers_2, "		");
                _builder.newLineIfNotEmpty();
              } else {
                if (eventDriven) {
                  _builder.append("\t");
                  _builder.append("\t");
                  EList<ActiveTrigger> _activeTriggers_1 = xpac.getActiveTriggers(state);
                  EList<ActiveTrigger> atlist_1 = _activeTriggers_1;
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _isEmpty_1 = atlist_1.isEmpty();
                    boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
                    if (_operator_not_1) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("switch(trigger) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      StringConcatenation _genEventDrivenTriggers_1 = this.genEventDrivenTriggers(xpac, state, atlist_1, dct);
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
  
  private StringConcatenation genDataDrivenTriggers(final ExpandedActorClass xpac, final State state, final DetailCodeTranslator dct) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _genDoCodes = this.genDoCodes(state);
    _builder.append(_genDoCodes, "");
    _builder.newLineIfNotEmpty();
    List<Transition> _outgoingTransitionsHierarchical = this.roomExt.getOutgoingTransitionsHierarchical(xpac, state);
    final Function1<Transition,Boolean> _function = new Function1<Transition,Boolean>() {
        public Boolean apply(final Transition t) {
          return ((Boolean)(t instanceof GuardedTransition));
        }
      };
    Iterable<Transition> _filter = IterableExtensions.<Transition>filter(_outgoingTransitionsHierarchical, _function);
    Iterable<Transition> transitions = _filter;
    _builder.newLineIfNotEmpty();
    {
      for(final Transition tr : transitions) {
        _builder.append("if (");
        DetailCode _guard = ((GuardedTransition) tr).getGuard();
        String _translateDetailCode = dct.translateDetailCode(_guard);
        _builder.append(_translateDetailCode, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        TransitionChain _chain = xpac.getChain(tr);
        TransitionChain chain = _chain;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("chain = ");
        String _chainId = this.roomExt.getChainId(chain);
        _builder.append(_chainId, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("catching_state = ");
        String _contextId = this.roomExt.getContextId(chain);
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
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(tr, _last);
          if (_operator_notEquals) {
            _builder.append("else ");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  private StringConcatenation genEventDrivenTriggers(final ExpandedActorClass xpac, final State state, final List<ActiveTrigger> atlist, final DetailCodeTranslator dct) {
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
        boolean _hasGuard = this.roomExt.hasGuard(xpac, at);
        boolean needData = _hasGuard;
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
          boolean hasAnyElements = false;
          for(final TriggeredTransition tt : _transitions) {
            if (!hasAnyElements) {
              hasAnyElements = true;
            } else {
              _builder.appendImmediate(" else ", "	");
            }
            _builder.append("\t");
            TransitionChain _chain = xpac.getChain(tt);
            TransitionChain chain = _chain;
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            Transition _transition = chain.getTransition();
            String _trigger_1 = at.getTrigger();
            StringConcatenation _guard = this.guard(_transition, _trigger_1, xpac, dct);
            _builder.append(_guard, "	");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("chain = ");
            String _chainId = this.roomExt.getChainId(chain);
            _builder.append(_chainId, "		");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("catching_state = ");
            String _contextId = this.roomExt.getContextId(chain);
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
  
  public StringConcatenation genExtra(final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private StringConcatenation _guard(final TriggeredTransition tt, final String trigger, final ExpandedActorClass ac, final DetailCodeTranslator dct) {
    StringConcatenation _xblockexpression = null;
    {
      EList<Trigger> _triggers = tt.getTriggers();
      final Function1<Trigger,Boolean> _function = new Function1<Trigger,Boolean>() {
          public Boolean apply(final Trigger e) {
            boolean _isMatching = ac.isMatching(e, trigger);
            return ((Boolean)_isMatching);
          }
        };
      Trigger _findFirst = IterableExtensions.<Trigger>findFirst(_triggers, _function);
      Trigger tr = _findFirst;
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _hasGuard = this.roomExt.hasGuard(tr);
        if (_hasGuard) {
          _builder.append("if (");
          Guard _guard = tr.getGuard();
          DetailCode _guard_1 = _guard.getGuard();
          String _translateDetailCode = dct.translateDetailCode(_guard_1);
          _builder.append(_translateDetailCode, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private StringConcatenation _guard(final Transition t, final String trigger, final ExpandedActorClass ac, final DetailCodeTranslator dct) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* error */");
    _builder.newLine();
    return _builder;
  }
  
  private StringConcatenation genDoCodes(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasDoCode = this.roomExt.hasDoCode(state);
      if (_hasDoCode) {
        String _doCodeOperationName = CodegenHelpers.getDoCodeOperationName(state);
        _builder.append(_doCodeOperationName, "");
        _builder.append("(self);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EObject _eContainer = state.eContainer();
      EObject _eContainer_1 = _eContainer.eContainer();
      if ((_eContainer_1 instanceof State)) {
        EObject _eContainer_2 = state.eContainer();
        EObject _eContainer_3 = _eContainer_2.eContainer();
        StringConcatenation _genDoCodes = this.genDoCodes(((State) _eContainer_3));
        _builder.append(_genDoCodes, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private StringConcatenation guard(final Transition tt, final String trigger, final ExpandedActorClass ac, final DetailCodeTranslator dct) {
    if (tt instanceof TriggeredTransition) {
      return _guard((TriggeredTransition)tt, trigger, ac, dct);
    } else {
      return _guard(tt, trigger, ac, dct);
    }
  }
}
