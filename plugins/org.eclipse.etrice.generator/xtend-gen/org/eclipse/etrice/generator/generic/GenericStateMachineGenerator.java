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

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TransitionChainGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A target language independent generator of the state machine implementation-
 */
@SuppressWarnings("all")
public class GenericStateMachineGenerator {
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  protected GenericProtocolClassGenerator pcGen;
  
  @Inject
  protected TransitionChainGenerator transitionChainGenerator;
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genStateIdConstants(final ExpandedActorClass xpac) {
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
      List<State> _baseStateList = RoomHelpers.getBaseStateList(_stateMachine);
      _xifexpression_1 = _baseStateList;
    } else {
      StateGraph _stateMachine_1 = xpac.getStateMachine();
      List<State> _baseStateList_1 = RoomHelpers.getBaseStateList(_stateMachine_1);
      _xifexpression_1 = _baseStateList_1;
    }
    List<State> baseStates = _xifexpression_1;
    List<State> _leafStatesLast = this._roomExtensions.getLeafStatesLast(baseStates);
    baseStates = _leafStatesLast;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String, String>>();
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
        String _genStateId = CodegenHelpers.getGenStateId(state);
        String _string = Integer.valueOf(offset).toString();
        Pair<String,String> _pair_2 = Tuples.<String, String>pair(_genStateId, _string);
        list.add(_pair_2);
        int _plus = (offset + 1);
        offset = _plus;
      }
    }
    String _string = Integer.valueOf(offset).toString();
    Pair<String,String> _pair_2 = Tuples.<String, String>pair("STATE_MAX", _string);
    list.add(_pair_2);
    return this.langExt.genEnumeration("state_ids", list);
  }
  
  /**
   * generates transition chain ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genTransitionChainConstants(final ExpandedActorClass xpac) {
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
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String, String>>();
    ArrayList<Pair<String,String>> list = _arrayList;
    for (final TransitionChain chain : chains) {
      {
        int _plus = (offset + 1);
        offset = _plus;
        String _genChainId = CodegenHelpers.getGenChainId(chain);
        String _string = Integer.valueOf(offset).toString();
        Pair<String,String> _pair = Tuples.<String, String>pair(_genChainId, _string);
        list.add(_pair);
      }
    }
    return this.langExt.genEnumeration("chain_ids", list);
  }
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   */
  protected String genTriggerConstants(final ExpandedActorClass xpac) {
    List<MessageFromIf> _xifexpression = null;
    boolean _usesInheritance = this.langExt.usesInheritance();
    if (_usesInheritance) {
      ActorClass _actorClass = xpac.getActorClass();
      List<MessageFromIf> _ownMessagesFromInterfaces = RoomHelpers.getOwnMessagesFromInterfaces(_actorClass);
      _xifexpression = _ownMessagesFromInterfaces;
    } else {
      ActorClass _actorClass_1 = xpac.getActorClass();
      List<MessageFromIf> _allMessagesFromInterfaces = RoomHelpers.getAllMessagesFromInterfaces(_actorClass_1);
      _xifexpression = _allMessagesFromInterfaces;
    }
    final List<MessageFromIf> triggers = _xifexpression;
    ArrayList<Pair<String,String>> _arrayList = new ArrayList<Pair<String, String>>();
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
  
  /**
   * generates the code of the whole state machine
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @return the generated code
   * 
   * @see {@link #genStateMachine}
   */
  public CharSequence genStateMachine(final ExpandedActorClass xpac) {
    CharSequence _genStateMachine = this.genStateMachine(xpac, true);
    return _genStateMachine;
  }
  
  /**
   * generates the code of the whole state machine
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param shallGenerateOneFile if <code>true</code> the generation of state IDs and
   * 		other constants is skipped (and left for the header file)
   * @return the generated code
   */
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
      String _pointerLiteral = this.langExt.pointerLiteral();
      final String ifItemPtr = ("InterfaceItemBase" + _pointerLiteral);
      String _xifexpression_4 = null;
      boolean _usesPointers_1 = this.langExt.usesPointers();
      if (_usesPointers_1) {
        String _plus = ("const " + ifItemPtr);
        _xifexpression_4 = _plus;
      } else {
        _xifexpression_4 = ifItemPtr;
      }
      final String constIfItemPtr = _xifexpression_4;
      final boolean usesHdlr = this.usesHandlerTrPoints(xpac);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�IF shallGenerateOneFile�");
      _builder.newLine();
      _builder.append("/* state IDs */");
      _builder.newLine();
      _builder.append("�xpac.genStateIdConstants�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* transition chains */");
      _builder.newLine();
      _builder.append("�xpac.genTransitionChainConstants�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* triggers */");
      _builder.newLine();
      _builder.append("�xpac.genTriggerConstants�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�genExtra(xpac)�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      _builder.append("�FOR state : xpac.stateMachine.getStateList()�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF !langExt.usesInheritance || xpac.isOwnObject(state)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�xpac.genActionCodeMethods(state)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      _builder.append("�FOR tr : xpac.stateMachine.allTransitionsRecursive�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF (!langExt.usesInheritance || xpac.isOwnObject(tr)) && tr.action.hasDetailCode�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�var start = xpac.getChain(tr)?.transition�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�var hasArgs = start instanceof NonInitialTransition && !(start instanceof GuardedTransition)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�langExt.accessLevelProtected�void �opScopePriv��tr.getActionCodeOperationName()�(�langExt.selfPointer(ac.name, hasArgs)��IF hasArgs��constIfItemPtr� ifitem�transitionChainGenerator.generateArgumentList(xpac, tr)��ENDIF�) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�AbstractGenerator::getInstance().getTranslatedCode(tr.action)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("�IF usesHdlr�");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("�privAccess�void �opScopePriv�exitTo(�self��stateType� current, �stateType� to�IF usesHdlr�, �boolType� handler�ENDIF�) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("while (current!=to) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch (current) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR state : xpac.stateMachine.getBaseStateList()�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("case �state.getGenStateId()�:");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF state.hasExitCode(true)��IF usesHdlr�if (!handler) �ENDIF��state.getExitCodeOperationName()�(�langExt.selfPointer(false)�);�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�setHistory(state.getParentStateId(), state.getGenStateId())�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("current = �state.getParentStateId()�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
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
      _builder.append("* @return the +/- ID of the final state either with a positive sign, that indicates to execute the state\'s entry code, or a negative sign vice versa");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("�privAccess��stateType� �opScopePriv�executeTransitionChain(�self�int chain�IF handleEvents�, �constIfItemPtr� ifitem, �langExt.voidPointer� generic_data�ENDIF�) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (chain) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�var allchains = xpac.getTransitionChains()�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR tc : allchains�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case �tc.genChainId�:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�transitionChainGenerator.generateExecuteChain(xpac, tc)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
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
      _builder.append("�IF usesHdlr�");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param handler - entry code is executed if not handler");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("�privAccess��stateType� �opScopePriv�enterHistory(�self��stateType� state�IF usesHdlr�, �boolType� handler�ENDIF�) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�boolType� skip_entry = �langExt.booleanConstant(false)�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (state >= STATE_MAX) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("state = �IF !langExt.usesInheritance�(�stateType�)�ENDIF� (state - STATE_MAX);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("skip_entry = �langExt.booleanConstant(true)�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("while (�langExt.booleanConstant(true)�) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch (state) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR state : xpac.stateMachine.getBaseStateList()�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case �state.getGenStateId()�:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF state.hasEntryCode(true)�if (!(skip_entry�IF usesHdlr� || handler�ENDIF�)) �state.getEntryCodeOperationName()�(�langExt.selfPointer(false)�);�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF state.isLeaf()�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("/* in leaf state: return state id */");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return �state.getGenStateId()�;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("/* state has a sub graph */");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF state.subgraph.hasInitTransition()�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("/* with init transition */");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("if (�getHistory(state.getGenStateId())�==NO_STATE) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("�var sub_initt = state.subgraph.getInitTransition()�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("state = executeTransitionChain(�langExt.selfPointer(true)��xpac.getChain(sub_initt).genChainId��IF handleEvents�, �langExt.nullPointer�, �langExt.nullPointer��ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("state = �getHistory(state.getGenStateId())�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("/* without init transition */");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("state = �getHistory(state.getGenStateId())�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case STATE_TOP:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("state = �getHistory(\"STATE_TOP\")�;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("skip_entry = �langExt.booleanConstant(false)�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�unreachableReturn�");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�publicIf�void �opScope�executeInitTransition(�selfOnly�) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�var initt = xpac.stateMachine.getInitTransition()�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int chain = �xpac.getChain(initt).genChainId�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�stateType� next = �opScopePriv�executeTransitionChain(�langExt.selfPointer(true)�chain�IF handleEvents�, �langExt.nullPointer�, �langExt.nullPointer��ENDIF�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("next = �opScopePriv�enterHistory(�langExt.selfPointer(true)�next�IF usesHdlr�, �langExt.booleanConstant(false)��ENDIF�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("setState(�langExt.selfPointer(true)�next);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append("�publicIf�void �opScope�receiveEvent(�langExt.selfPointer(ac.name, handleEvents)��IF handleEvents��ifItemPtr� ifitem, int evt, �langExt.voidPointer� generic_data�ENDIF�) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF async�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int trigger = (ifitem==�langExt.nullPointer�)? POLLING : ifitem�getLocalId� + EVT_SHIFT*evt;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSEIF eventDriven�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int trigger = ifitem�getLocalId� + EVT_SHIFT*evt;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int chain = NOT_CAUGHT;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�stateType� catching_state = NO_STATE;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF usesHdlr�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�boolType� is_handler = �langExt.booleanConstant(false)�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF handleEvents�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data)) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�genStateSwitch(xpac, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�genStateSwitch(xpac, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (chain != NOT_CAUGHT) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�opScopePriv�exitTo(�langExt.selfPointer(true)�getState(�langExt.selfPointer(false)�), catching_state�IF usesHdlr�, is_handler�ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�stateType� next = �opScopePriv�executeTransitionChain(�langExt.selfPointer(true)�chain�IF handleEvents�, ifitem, generic_data�ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("next = �opScopePriv�enterHistory(�langExt.selfPointer(true)�next�IF usesHdlr�, is_handler�ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("setState(�langExt.selfPointer(true)�next);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the state switch.
   * Asynchronous, data driven and event driven state machines are distinguished
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genStateSwitch(final ExpandedActorClass xpac, final boolean usesHdlr) {
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
      _builder.append("switch (getState(�langExt.selfPointer(false)�)) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR state : xpac.stateMachine.getLeafStateList()�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("case �state.getGenStateId()�:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF async�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�var atlist =  xpac.getActiveTriggers(state)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF !atlist.isEmpty�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("switch(trigger) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("case POLLING:");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�genDataDrivenTriggers(xpac, state, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�genEventDrivenTriggers(xpac, state, atlist, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�genDataDrivenTriggers(xpac, state, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSEIF dataDriven�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�genDataDrivenTriggers(xpac, state, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSEIF eventDriven�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�var atlist =  xpac.getActiveTriggers(state)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF !atlist.isEmpty�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("switch(trigger) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�genEventDrivenTriggers(xpac, state, atlist, usesHdlr)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the data driven triggers
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param state the {@link State} for which the trigger if-else switch should be generated
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genDataDrivenTriggers(final ExpandedActorClass xpac, final State state, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�genDoCodes(state)�");
    _builder.newLine();
    _builder.append("�var transitions = xpac.getOutgoingTransitionsHierarchical(state).filter(t|t instanceof GuardedTransition)�");
    _builder.newLine();
    _builder.append("�FOR tr : transitions�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (�AbstractGenerator::getInstance().getTranslatedCode((tr as GuardedTransition).guard)�)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�var chain = xpac.getChain(tr)�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("chain = �chain.genChainId�;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("catching_state = �chain.stateContext.genStateId�;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�IF chain.isHandler() && usesHdlr�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("is_handler = TRUE;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF tr!=transitions.last�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * helper method which generates the event driven triggers
   * 
   * @param xpac the {@link ExpandedActorClass}
   * @param state the {@link State} for which the trigger switch should be generated
   * @param atlist the list of {@link ActiveTrigger}s of this state
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 		at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  protected CharSequence genEventDrivenTriggers(final ExpandedActorClass xpac, final State state, final List<ActiveTrigger> atlist, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR at : atlist�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case �xpac.getTriggerCodeName(at)�:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�var needData = at.hasGuard�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�IF needData�{ �langExt.getTypedDataDefinition(at.msg)��ENDIF�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�FOR tt : at.transitions SEPARATOR \" else \"�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�var chain = xpac.getChain(tt)�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�guard(chain.transition, at.trigger, xpac)�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("chain = �chain.genChainId�;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("catching_state = �chain.stateContext.genStateId�;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("�IF chain.isHandler() && usesHdlr�");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("is_handler = �langExt.booleanConstant(true)�;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�IF needData�}�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* should not occur */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("break;");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * getter for history array
   * 
   * @param state the ID of the history state
   * @return the generated code
   */
  protected String getHistory(final String state) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    String _plus_2 = (_plus_1 + "]");
    return _plus_2;
  }
  
  /**
   * setter for history array
   * 
   * @param the ID of the state whose history should be set
   * @param the ID of the state that should be assigned
   * @return the generated code
   */
  protected String setHistory(final String state, final String historyState) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    String _plus_2 = (_plus_1 + "] = ");
    String _plus_3 = (_plus_2 + historyState);
    return _plus_3;
  }
  
  /**
   * @return the type of (temporary) state variables (defaults to "int")
   * and has to be signed
   */
  protected String stateType() {
    return "int";
  }
  
  /**
   * allow target language dependent generation of unreachable return in generated enterHistory method.
   * The default is just a comment.
   * @return the generated code
   */
  protected String unreachableReturn() {
    return "/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */";
  }
  
  /**
   * type of (temporary) boolean variables (defaults to "boolean")
   * @return the generated code
   */
  protected String boolType() {
    return "boolean";
  }
  
  /**
   * let derived class add extra code after definition of constants
   * 
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence genExtra(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * let derived class add extra code after definition of constants in header (if applicable)
   * 
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence genExtraDecl(final ExpandedActorClass xpac) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * generate a transition guard if applicable
   * 
   * @param tt a {@link TriggeredTransition}
   * @param trigger a trigger string
   * @param xpac an expanded actor class
   * @return the generated code
   */
  protected CharSequence _guard(final TriggeredTransition tt, final String trigger, final ExpandedActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      EList<Trigger> _triggers = tt.getTriggers();
      final Function1<Trigger,Boolean> _function = new Function1<Trigger,Boolean>() {
        public Boolean apply(final Trigger e) {
          boolean _isMatching = ac.isMatching(e, trigger);
          return Boolean.valueOf(_isMatching);
        }
      };
      final Trigger tr = IterableExtensions.<Trigger>findFirst(_triggers, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("�IF tr.hasGuard()�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (�AbstractGenerator::getInstance().getTranslatedCode(tr.guard.guard)�)");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  /**
   * (necessary for completeness of the dispatching, never called)
   */
  protected CharSequence _guard(final Transition t, final String trigger, final ExpandedActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* error */");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * generate the do code calls for a given state
   * 
   * @param state the {@link State}
   * @return the generated code
   */
  protected String genDoCodes(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF state.hasDoCode(true)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�state.getDoCodeOperationName()�(�langExt.selfPointer(false)�);");
    _builder.newLine();
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("�IF state.eContainer.eContainer instanceof State�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�genDoCodes(state.eContainer.eContainer as State)�");
    _builder.newLine();
    _builder.append("�ENDIF�");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * generate action code method implementations
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @param state the {@link State}
   * @return the generated code
   */
  protected CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state) {
    CharSequence _genActionCodeMethods = this.genActionCodeMethods(xpac, state, true);
    return _genActionCodeMethods;
  }
  
  /**
   * generate action code method implementations or declarations
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @param state the {@link State}
   * @param generateImplementation if only declarations should be generated then <code>false</code> has to be passed
   * @return the generated code
   */
  protected CharSequence genActionCodeMethods(final ExpandedActorClass xpac, final State state, final boolean generateImplementation) {
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
          boolean _hasDetailCode = RoomHelpers.hasDetailCode(_inheritedEntry_1);
          if (_hasDetailCode) {
            String _superCall = this.langExt.superCall(baseName, entryOp, "");
            String _plus = (_superCall + entry);
            entry = _plus;
          }
          DetailCode _inheritedExit_1 = rs.getInheritedExit();
          boolean _hasDetailCode_1 = RoomHelpers.hasDetailCode(_inheritedExit_1);
          if (_hasDetailCode_1) {
            String _superCall_1 = this.langExt.superCall(baseName, exitOp, "");
            String _plus_1 = (exit + _superCall_1);
            exit = _plus_1;
          }
          DetailCode _inheritedDo_1 = rs.getInheritedDo();
          boolean _hasDetailCode_2 = RoomHelpers.hasDetailCode(_inheritedDo_1);
          if (_hasDetailCode_2) {
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
      _builder.append("�IF !entry.empty�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF generateImplementation�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected�void �opScopePriv��entryOp�(�selfPtr�) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�entry�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected�void �entryOp�(�selfPtr�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�IF !exit.empty�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF generateImplementation�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected�void �opScopePriv��exitOp�(�selfPtr�) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�exit�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected�void �exitOp�(�selfPtr�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�IF !docode.empty�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF generateImplementation�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected� void �opScopePriv��doOp�(�selfPtr�) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�docode�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�langExt.accessLevelProtected�void �doOp�(�selfPtr�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  /**
   * @param classname the name of the type
   * @return the type name for a constant pointer
   */
  protected String constPointer(final String classname) {
    return classname;
  }
  
  /**
   * generate all method declarations
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @return the generated code
   */
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
      final boolean usesHdlr = this.usesHandlerTrPoints(xpac);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("/* state IDs */");
      _builder.newLine();
      _builder.append("�xpac.genStateIdConstants�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* transition chains */");
      _builder.newLine();
      _builder.append("�xpac.genTransitionChainConstants�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* triggers */");
      _builder.newLine();
      _builder.append("�xpac.genTriggerConstants�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�genExtraDecl(xpac)�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* Entry and Exit Codes */");
      _builder.newLine();
      _builder.append("�FOR state : xpac.stateMachine.getStateList()�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF !langExt.usesInheritance || xpac.isOwnObject(state)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�xpac.genActionCodeMethods(state, false)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* Action Codes */");
      _builder.newLine();
      _builder.append("�FOR tr : xpac.stateMachine.allTransitionsRecursive�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF (!langExt.usesInheritance || xpac.isOwnObject(tr)) && tr.action.hasDetailCode�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�var start = xpac.getChain(tr).transition�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�var hasArgs = start instanceof NonInitialTransition && !(start instanceof GuardedTransition)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�langExt.accessLevelProtected�void �tr.getActionCodeOperationName()�(�langExt.selfPointer(ac.name, hasArgs)��IF hasArgs��constPointer(\"etRuntime::InterfaceItemBase\")� ifitem�transitionChainGenerator.generateArgumentList(xpac, tr)��ENDIF�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("�IF usesHdlr�");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void exitTo(�self�int current, int to�IF usesHdlr�, �boolType� handler�ENDIF�);");
      _builder.newLine();
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
      _builder.append("int executeTransitionChain(�self�int chain�IF handleEvents�, �constPointer(\"etRuntime::InterfaceItemBase\")� ifitem, �langExt.voidPointer� generic_data�ENDIF�);");
      _builder.newLine();
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
      _builder.append("�IF usesHdlr�");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @param handler - entry code is executed if not handler");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int enterHistory(�self�int state�IF usesHdlr�, �boolType� handler�ENDIF�);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void executeInitTransition(�langExt.selfPointer(ac.name, false)�);");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("void receiveEvent(�langExt.selfPointer(ac.name, handleEvents)��IF handleEvents�etRuntime::InterfaceItemBase* ifitem, int evt, �langExt.voidPointer� generic_data�ENDIF�);");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  /**
   * helper method to determine whether this state machine uses handler transitions
   * points at all
   * 
   * @param xpax the {@link ExpandedActorClass}
   * @return <code>true</code> if the state machine uses handler transition points
   */
  private boolean usesHandlerTrPoints(final ExpandedActorClass xpac) {
    boolean _xblockexpression = false;
    {
      StateGraph _stateMachine = xpac.getStateMachine();
      boolean _isEmpty = RoomHelpers.isEmpty(_stateMachine);
      if (_isEmpty) {
        return false;
      }
      StateGraph _stateMachine_1 = xpac.getStateMachine();
      List<TrPoint> _allTrPointsRecursive = RoomHelpers.getAllTrPointsRecursive(_stateMachine_1);
      final Function1<TrPoint,Boolean> _function = new Function1<TrPoint,Boolean>() {
        public Boolean apply(final TrPoint t) {
          boolean _and = false;
          if (!(t instanceof TransitionPoint)) {
            _and = false;
          } else {
            boolean _isHandler = ((TransitionPoint) t).isHandler();
            _and = ((t instanceof TransitionPoint) && _isHandler);
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<TrPoint> _filter = IterableExtensions.<TrPoint>filter(_allTrPointsRecursive, _function);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
      boolean _not = (!_isEmpty_1);
      _xblockexpression = (_not);
    }
    return _xblockexpression;
  }
  
  protected CharSequence guard(final Transition tt, final String trigger, final ExpandedActorClass ac) {
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
