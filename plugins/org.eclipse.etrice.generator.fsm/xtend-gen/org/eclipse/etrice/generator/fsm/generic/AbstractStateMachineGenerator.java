/**
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.fsm.generic;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.util.FsmGenUtil;
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers;
import org.eclipse.etrice.generator.fsm.generic.FSMExtensions;
import org.eclipse.etrice.generator.fsm.generic.IDetailCodeTranslator;
import org.eclipse.etrice.generator.fsm.generic.IIfItemIdGenerator;
import org.eclipse.etrice.generator.fsm.generic.ILanguageExtensionBase;
import org.eclipse.etrice.generator.fsm.generic.IMessageIdGenerator;
import org.eclipse.etrice.generator.fsm.generic.TransitionChainGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Henrik Rentz-Reichert
 */
@SuppressWarnings("all")
public abstract class AbstractStateMachineGenerator {
  @Inject
  @Extension
  public FSMHelpers _fSMHelpers;
  
  @Inject
  @Extension
  public FsmGenUtil _fsmGenUtil;
  
  @Inject
  @Extension
  public CodegenHelpers _codegenHelpers;
  
  @Inject
  @Extension
  public FSMExtensions _fSMExtensions;
  
  @Inject
  public ILanguageExtensionBase langExt;
  
  @Inject
  public IMessageIdGenerator msgIdGen;
  
  @Inject
  public IIfItemIdGenerator itemIdGen;
  
  @Inject
  public TransitionChainGenerator transitionChainGenerator;
  
  @Inject
  public IDetailCodeTranslator translator;
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @return the generated code
   */
  public String genTriggerConstants(final ExpandedModelComponent xpmc) {
    boolean _usesInheritance = this.langExt.usesInheritance();
    return this.genTriggerConstants(xpmc, _usesInheritance);
  }
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param omitBase use <code>true</code> if no base class trigger constants are needed
   * 
   * @return the generated code
   */
  public String genTriggerConstants(final ExpandedModelComponent xpmc, final boolean omitBase) {
    List<MessageFromIf> _xifexpression = null;
    if (omitBase) {
      ModelComponent _modelComponent = xpmc.getModelComponent();
      _xifexpression = this._fSMHelpers.getOwnMessagesFromInterfaces(_modelComponent);
    } else {
      ModelComponent _modelComponent_1 = xpmc.getModelComponent();
      _xifexpression = this._fSMHelpers.getAllMessagesFromInterfaces(_modelComponent_1);
    }
    final List<MessageFromIf> triggers = _xifexpression;
    final ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    Pair<String, String> _pair = Tuples.<String, String>pair("POLLING", "0");
    list.add(_pair);
    for (final MessageFromIf mif : triggers) {
      AbstractInterfaceItem _from = mif.getFrom();
      boolean _isEventDriven = _from.isEventDriven();
      if (_isEventDriven) {
        String _triggerCodeName = xpmc.getTriggerCodeName(mif);
        AbstractInterfaceItem _from_1 = mif.getFrom();
        String _ifItemId = this.itemIdGen.getIfItemId(_from_1);
        String _plus = (_ifItemId + " + EVT_SHIFT*");
        String _messageID = this.msgIdGen.getMessageID(mif);
        String _plus_1 = (_plus + _messageID);
        Pair<String, String> _pair_1 = Tuples.<String, String>pair(_triggerCodeName, _plus_1);
        list.add(_pair_1);
      }
    }
    return this.langExt.genEnumeration("triggers", list);
  }
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @return the generated code
   */
  public String genStateIdConstants(final ExpandedModelComponent xpmc) {
    boolean _usesInheritance = this.langExt.usesInheritance();
    return this.genStateIdConstants(xpmc, _usesInheritance);
  }
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param omitBase use <code>true</code> if no base class state constants are needed
   * 
   * @return the generated code
   */
  public String genStateIdConstants(final ExpandedModelComponent xpmc, final boolean omitBase) {
    final ModelComponent mc = xpmc.getModelComponent();
    int _xifexpression = (int) 0;
    if (omitBase) {
      _xifexpression = this._fSMExtensions.getNumberOfInheritedBaseStates(mc);
    } else {
      _xifexpression = 0;
    }
    int offset = (2 + _xifexpression);
    List<State> _xifexpression_1 = null;
    if (omitBase) {
      StateGraph _stateMachine = mc.getStateMachine();
      _xifexpression_1 = this._fSMHelpers.getBaseStateList(_stateMachine);
    } else {
      StateGraph _stateMachine_1 = xpmc.getStateMachine();
      _xifexpression_1 = this._fSMHelpers.getBaseStateList(_stateMachine_1);
    }
    List<State> baseStates = _xifexpression_1;
    List<State> _leafStatesLast = this._fSMExtensions.getLeafStatesLast(baseStates);
    baseStates = _leafStatesLast;
    ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    if ((!omitBase)) {
      Pair<String, String> _pair = Tuples.<String, String>pair("NO_STATE", "0");
      list.add(_pair);
      Pair<String, String> _pair_1 = Tuples.<String, String>pair("STATE_TOP", "1");
      list.add(_pair_1);
    }
    for (final State state : baseStates) {
      {
        String _genStateId = this._codegenHelpers.getGenStateId(state);
        String _string = Integer.valueOf(offset).toString();
        Pair<String, String> _pair_2 = Tuples.<String, String>pair(_genStateId, _string);
        list.add(_pair_2);
        offset = (offset + 1);
      }
    }
    String _string = Integer.valueOf(offset).toString();
    Pair<String, String> _pair_2 = Tuples.<String, String>pair("STATE_MAX", _string);
    list.add(_pair_2);
    return this.langExt.genEnumeration("state_ids", list);
  }
  
  /**
   * generates transition chain ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * 
   * @return the generated code
   */
  public String genTransitionChainConstants(final ExpandedModelComponent xpmc) {
    boolean _usesInheritance = this.langExt.usesInheritance();
    return this.genTransitionChainConstants(xpmc, _usesInheritance);
  }
  
  /**
   * generates transition chain ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param omitBase use <code>true</code> if no base class transition chain constants are needed
   * 
   * @return the generated code
   */
  public String genTransitionChainConstants(final ExpandedModelComponent xpmc, final boolean omitBase) {
    EList<TransitionChain> _xifexpression = null;
    if (omitBase) {
      _xifexpression = xpmc.getOwnTransitionChains();
    } else {
      _xifexpression = xpmc.getTransitionChains();
    }
    EList<TransitionChain> chains = _xifexpression;
    int _xifexpression_1 = (int) 0;
    if (omitBase) {
      EList<TransitionChain> _transitionChains = xpmc.getTransitionChains();
      int _size = _transitionChains.size();
      int _size_1 = chains.size();
      _xifexpression_1 = (_size - _size_1);
    } else {
      _xifexpression_1 = 0;
    }
    int offset = _xifexpression_1;
    ArrayList<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
    for (final TransitionChain chain : chains) {
      {
        offset = (offset + 1);
        String _genChainId = this._codegenHelpers.getGenChainId(chain);
        String _string = Integer.valueOf(offset).toString();
        Pair<String, String> _pair = Tuples.<String, String>pair(_genChainId, _string);
        list.add(_pair);
      }
    }
    return this.langExt.genEnumeration("chain_ids", list);
  }
  
  /**
   * generates entry and exit code for states
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * 
   * @return the generated code
   */
  public String genEntryAndExitCodes(final ExpandedModelComponent xpmc, final boolean generateImplementation) {
    boolean _usesInheritance = this.langExt.usesInheritance();
    return this.genEntryAndExitCodes(xpmc, generateImplementation, _usesInheritance);
  }
  
  /**
   * generates entry and exit code for states
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * @param omitBase use <code>true</code> if no base class entry and exit codes are needed
   * 
   * @return the generated code
   */
  public String genEntryAndExitCodes(final ExpandedModelComponent xpmc, final boolean generateImplementation, final boolean omitBase) {
    StringConcatenation _builder = new StringConcatenation();
    {
      StateGraph _stateMachine = xpmc.getStateMachine();
      List<State> _stateList = this._fSMHelpers.getStateList(_stateMachine);
      for(final State state : _stateList) {
        {
          boolean _or = false;
          if ((!omitBase)) {
            _or = true;
          } else {
            boolean _isOwnObject = xpmc.isOwnObject(state);
            _or = _isOwnObject;
          }
          if (_or) {
            String _genActionCodeMethods = this.genActionCodeMethods(xpmc, state, generateImplementation);
            _builder.append(_genActionCodeMethods, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  /**
   * generates transition action codes
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * 
   * @return the generated code
   */
  public String genActionCodes(final ExpandedModelComponent xpmc, final boolean generateImplementation) {
    boolean _usesInheritance = this.langExt.usesInheritance();
    return this.genActionCodes(xpmc, generateImplementation, _usesInheritance);
  }
  
  /**
   * generates transition action codes
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * @param omitBase use <code>true</code> if no base class action codes are needed
   * 
   * @return the generated code
   */
  public String genActionCodes(final ExpandedModelComponent xpmc, final boolean generateImplementation, final boolean omitBase) {
    StringConcatenation _builder = new StringConcatenation();
    {
      StateGraph _stateMachine = xpmc.getStateMachine();
      List<Transition> _allTransitionsRecursive = this._fSMHelpers.getAllTransitionsRecursive(_stateMachine);
      for(final Transition tr : _allTransitionsRecursive) {
        {
          boolean _and = false;
          boolean _or = false;
          if ((!omitBase)) {
            _or = true;
          } else {
            boolean _isOwnObject = xpmc.isOwnObject(tr);
            _or = _isOwnObject;
          }
          if (!_or) {
            _and = false;
          } else {
            DetailCode _action = tr.getAction();
            boolean _hasDetailCode = this._fSMHelpers.hasDetailCode(_action);
            _and = _hasDetailCode;
          }
          if (_and) {
            String _genActionCodeMethod = this.genActionCodeMethod(xpmc, tr, generateImplementation);
            _builder.append(_genActionCodeMethod, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  public String genStateSwitchMethods(final ExpandedModelComponent xpmc, final boolean generateImplementation) {
    String _xblockexpression = null;
    {
      final ModelComponent mc = xpmc.getModelComponent();
      ComponentCommunicationType _commType = mc.getCommType();
      final boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = mc.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      String _interfaceItemType = this.interfaceItemType();
      String _pointerLiteral = this.langExt.pointerLiteral();
      final String ifItemPtr = (_interfaceItemType + _pointerLiteral);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = eventDriven;
      }
      final boolean handleEvents = _or;
      String _className = this.getClassName(mc);
      final String opScope = this.langExt.operationScope(_className, (!generateImplementation));
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
        _xifexpression_1 = this.langExt.accessLevelPublic();
      } else {
        _xifexpression_1 = this.langExt.accessLevelPrivate();
      }
      final String publicIf = _xifexpression_1;
      final String privAccess = this.langExt.accessLevelPrivate();
      String _className_1 = this.getClassName(mc);
      final String selfPtr = this.langExt.selfPointer(_className_1, true);
      String _className_2 = this.getClassName(mc);
      final String selfOnly = this.langExt.selfPointer(_className_2, false);
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
      String _xifexpression_4 = null;
      boolean _usesPointers_1 = this.langExt.usesPointers();
      if (_usesPointers_1) {
        _xifexpression_4 = ("const " + ifItemPtr);
      } else {
        _xifexpression_4 = ifItemPtr;
      }
      final String constIfItemPtr = _xifexpression_4;
      final boolean usesHdlr = this.usesHandlerTrPoints(xpmc);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls exit codes while exiting from the current state to one of its");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* parent states while remembering the history");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param current__et - the current state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param to - the final parent state");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append("* @param handler__et - entry and exit codes are called only if not handler (for handler TransitionPoints)");
          _builder.newLine();
        }
      }
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(privAccess, "");
          _builder.append("void ");
          _builder.append(opScopePriv, "");
          _builder.append("exitTo(");
          _builder.append(selfPtr, "");
          String _stateType = this.stateType();
          _builder.append(_stateType, "");
          _builder.append(" current__et, ");
          String _stateType_1 = this.stateType();
          _builder.append(_stateType_1, "");
          _builder.append(" to");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType = this.boolType();
              _builder.append(_boolType, "");
              _builder.append(" handler__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("while (current__et!=to) {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("switch (current__et) {");
          _builder.newLine();
          {
            StateGraph _stateMachine = xpmc.getStateMachine();
            List<State> _baseStateList = this._fSMHelpers.getBaseStateList(_stateMachine);
            for(final State state : _baseStateList) {
              _builder.append("\t\t\t");
              _builder.append("case ");
              String _genStateId = this._codegenHelpers.getGenStateId(state);
              _builder.append(_genStateId, "\t\t\t");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              {
                boolean _hasExitCode = this._fSMHelpers.hasExitCode(state, true);
                if (_hasExitCode) {
                  {
                    if (usesHdlr) {
                      _builder.append("if (!handler__et) ");
                    }
                  }
                  String _exitCodeOperationName = this._codegenHelpers.getExitCodeOperationName(state);
                  _builder.append(_exitCodeOperationName, "\t\t\t\t");
                  _builder.append("(");
                  String _selfPointer = this.langExt.selfPointer(false);
                  _builder.append(_selfPointer, "\t\t\t\t");
                  _builder.append(");");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              String _parentStateId = this._codegenHelpers.getParentStateId(state);
              String _genStateId_1 = this._codegenHelpers.getGenStateId(state);
              String _setHistory = this.setHistory(_parentStateId, _genStateId_1);
              _builder.append(_setHistory, "\t\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("current__et = ");
              String _parentStateId_1 = this._codegenHelpers.getParentStateId(state);
              _builder.append(_parentStateId_1, "\t\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
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
        } else {
          _builder.append("void exitTo(");
          _builder.append(selfPtr, "");
          String _stateType_2 = this.stateType();
          _builder.append(_stateType_2, "");
          _builder.append(" current__et, ");
          String _stateType_3 = this.stateType();
          _builder.append(_stateType_3, "");
          _builder.append(" to");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_1 = this.boolType();
              _builder.append(_boolType_1, "");
              _builder.append(" handler__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
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
      _builder.append("* @param chain__et - the chain ID");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param generic_data__et - the generic data pointer");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @return the +/- ID of the final state either with a positive sign, that indicates to execute the state\'s entry code, or a negative sign vice versa");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(privAccess, "");
          String _stateType_4 = this.stateType();
          _builder.append(_stateType_4, "");
          _builder.append(" ");
          _builder.append(opScopePriv, "");
          _builder.append("executeTransitionChain(");
          _builder.append(selfPtr, "");
          _builder.append("int chain__et");
          {
            if (handleEvents) {
              _builder.append(", ");
              _builder.append(constIfItemPtr, "");
              _builder.append(" ifitem, ");
              String _voidPointer = this.langExt.voidPointer();
              _builder.append(_voidPointer, "");
              _builder.append(" generic_data__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("switch (chain__et) {");
          _builder.newLine();
          _builder.append("\t\t");
          EList<TransitionChain> allchains = xpmc.getTransitionChains();
          _builder.newLineIfNotEmpty();
          {
            for(final TransitionChain tc : allchains) {
              _builder.append("\t\t");
              _builder.append("case ");
              String _genChainId = this._codegenHelpers.getGenChainId(tc);
              _builder.append(_genChainId, "\t\t");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              String _generateExecuteChain = this.transitionChainGenerator.generateExecuteChain(xpmc, tc);
              _builder.append(_generateExecuteChain, "\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
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
        } else {
          String _stateType_5 = this.stateType();
          _builder.append(_stateType_5, "");
          _builder.append(" executeTransitionChain(");
          _builder.append(selfPtr, "");
          _builder.append("int chain__et");
          {
            if (handleEvents) {
              _builder.append(", ");
              _builder.append(constIfItemPtr, "");
              _builder.append(" ifitem, ");
              String _voidPointer_1 = this.langExt.voidPointer();
              _builder.append(_voidPointer_1, "");
              _builder.append(" generic_data__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* calls entry codes while entering a state\'s history. The ID of the final leaf state is returned");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @param state__et - the state which is entered");
      _builder.newLine();
      {
        if (usesHdlr) {
          _builder.append("* @param handler__et - entry code is executed if not handler");
          _builder.newLine();
        }
      }
      _builder.append(" ");
      _builder.append("* @return - the ID of the final leaf state");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(privAccess, "");
          String _stateType_6 = this.stateType();
          _builder.append(_stateType_6, "");
          _builder.append(" ");
          _builder.append(opScopePriv, "");
          _builder.append("enterHistory(");
          _builder.append(selfPtr, "");
          String _stateType_7 = this.stateType();
          _builder.append(_stateType_7, "");
          _builder.append(" state__et");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_2 = this.boolType();
              _builder.append(_boolType_2, "");
              _builder.append(" handler__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          StateGraph _stateMachine_1 = xpmc.getStateMachine();
          final List<State> baseStateList = this._fSMHelpers.getBaseStateList(_stateMachine_1);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<State, Boolean> _function = new Function1<State, Boolean>() {
            public Boolean apply(final State s) {
              return Boolean.valueOf(AbstractStateMachineGenerator.this._fSMHelpers.hasEntryCode(s, true));
            }
          };
          Iterable<State> _filter = IterableExtensions.<State>filter(baseStateList, _function);
          boolean _isEmpty = IterableExtensions.isEmpty(_filter);
          final boolean needsSkipVar = (!_isEmpty);
          _builder.newLineIfNotEmpty();
          {
            if (needsSkipVar) {
              _builder.append("\t");
              String _boolType_3 = this.boolType();
              _builder.append(_boolType_3, "\t");
              _builder.append(" skip_entry__et = ");
              String _booleanConstant = this.langExt.booleanConstant(false);
              _builder.append(_booleanConstant, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("if (state__et >= STATE_MAX) {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("state__et = ");
          {
            boolean _usesInheritance_3 = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance_3);
            if (_not) {
              _builder.append("(");
              String _stateType_8 = this.stateType();
              _builder.append(_stateType_8, "\t\t");
              _builder.append(")");
            }
          }
          _builder.append(" (state__et - STATE_MAX);");
          _builder.newLineIfNotEmpty();
          {
            if (needsSkipVar) {
              _builder.append("\t\t");
              _builder.append("skip_entry__et = ");
              String _booleanConstant_1 = this.langExt.booleanConstant(true);
              _builder.append(_booleanConstant_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("while (");
          String _booleanConstant_2 = this.langExt.booleanConstant(true);
          _builder.append(_booleanConstant_2, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("switch (state__et) {");
          _builder.newLine();
          {
            for(final State state_1 : baseStateList) {
              _builder.append("\t\t\t");
              _builder.append("case ");
              String _genStateId_2 = this._codegenHelpers.getGenStateId(state_1);
              _builder.append(_genStateId_2, "\t\t\t");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              {
                boolean _hasEntryCode = this._fSMHelpers.hasEntryCode(state_1, true);
                if (_hasEntryCode) {
                  _builder.append("if (!(skip_entry__et");
                  {
                    if (usesHdlr) {
                      _builder.append(" || handler__et");
                    }
                  }
                  _builder.append(")) ");
                  String _entryCodeOperationName = this._codegenHelpers.getEntryCodeOperationName(state_1);
                  _builder.append(_entryCodeOperationName, "\t\t\t\t");
                  _builder.append("(");
                  String _selfPointer_1 = this.langExt.selfPointer(false);
                  _builder.append(_selfPointer_1, "\t\t\t\t");
                  _builder.append(");");
                }
              }
              _builder.newLineIfNotEmpty();
              {
                boolean _isLeaf = this._fSMHelpers.isLeaf(state_1);
                if (_isLeaf) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("/* in leaf state: return state id */");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("return ");
                  String _genStateId_3 = this._codegenHelpers.getGenStateId(state_1);
                  _builder.append(_genStateId_3, "\t\t\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("/* state has a sub graph */");
                  _builder.newLine();
                  {
                    StateGraph _subgraph = state_1.getSubgraph();
                    boolean _hasInitTransition = this._fSMHelpers.hasInitTransition(_subgraph);
                    if (_hasInitTransition) {
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("/* with init transition */");
                      _builder.newLine();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("if (");
                      String _genStateId_4 = this._codegenHelpers.getGenStateId(state_1);
                      String _history = this.getHistory(_genStateId_4);
                      _builder.append(_history, "\t\t\t\t");
                      _builder.append("==NO_STATE) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      StateGraph _subgraph_1 = state_1.getSubgraph();
                      Transition sub_initt = this._fSMHelpers.getInitTransition(_subgraph_1);
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("state__et = executeTransitionChain(");
                      String _selfPointer_2 = this.langExt.selfPointer(true);
                      _builder.append(_selfPointer_2, "\t\t\t\t\t");
                      TransitionChain _chain = xpmc.getChain(sub_initt);
                      String _genChainId_1 = this._codegenHelpers.getGenChainId(_chain);
                      _builder.append(_genChainId_1, "\t\t\t\t\t");
                      {
                        if (handleEvents) {
                          _builder.append(", ");
                          String _nullPointer = this.langExt.nullPointer();
                          _builder.append(_nullPointer, "\t\t\t\t\t");
                          _builder.append(", ");
                          String _nullPointer_1 = this.langExt.nullPointer();
                          _builder.append(_nullPointer_1, "\t\t\t\t\t");
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
                      _builder.append("state__et = ");
                      String _genStateId_5 = this._codegenHelpers.getGenStateId(state_1);
                      String _history_1 = this.getHistory(_genStateId_5);
                      _builder.append(_history_1, "\t\t\t\t\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    } else {
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("/* without init transition */");
                      _builder.newLine();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("state__et = ");
                      String _genStateId_6 = this._codegenHelpers.getGenStateId(state_1);
                      String _history_2 = this.getHistory(_genStateId_6);
                      _builder.append(_history_2, "\t\t\t\t");
                      _builder.append(";");
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
          _builder.append("state__et = ");
          String _history_3 = this.getHistory("STATE_TOP");
          _builder.append(_history_3, "\t\t\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
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
          {
            if (needsSkipVar) {
              _builder.append("\t\t");
              _builder.append("skip_entry__et = ");
              String _booleanConstant_3 = this.langExt.booleanConstant(false);
              _builder.append(_booleanConstant_3, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          String _unreachableReturn = this.unreachableReturn();
          _builder.append(_unreachableReturn, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          String _stateType_9 = this.stateType();
          _builder.append(_stateType_9, "");
          _builder.append(" enterHistory(");
          _builder.append(selfPtr, "");
          String _stateType_10 = this.stateType();
          _builder.append(_stateType_10, "");
          _builder.append(" state__et");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_4 = this.boolType();
              _builder.append(_boolType_4, "");
              _builder.append(" handler__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(publicIf, "");
          _builder.append("void ");
          _builder.append(opScope, "");
          _builder.append("executeInitTransition(");
          _builder.append(selfOnly, "");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          StateGraph _stateMachine_2 = xpmc.getStateMachine();
          Transition initt = this._fSMHelpers.getInitTransition(_stateMachine_2);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("int chain__et = ");
          TransitionChain _chain_1 = xpmc.getChain(initt);
          String _genChainId_2 = this._codegenHelpers.getGenChainId(_chain_1);
          _builder.append(_genChainId_2, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _stateType_11 = this.stateType();
          _builder.append(_stateType_11, "\t");
          _builder.append(" next__et = ");
          _builder.append(opScopePriv, "\t");
          _builder.append("executeTransitionChain(");
          String _selfPointer_3 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_3, "\t");
          _builder.append("chain__et");
          {
            if (handleEvents) {
              _builder.append(", ");
              String _nullPointer_2 = this.langExt.nullPointer();
              _builder.append(_nullPointer_2, "\t");
              _builder.append(", ");
              String _nullPointer_3 = this.langExt.nullPointer();
              _builder.append(_nullPointer_3, "\t");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("next__et = ");
          _builder.append(opScopePriv, "\t");
          _builder.append("enterHistory(");
          String _selfPointer_4 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_4, "\t");
          _builder.append("next__et");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _booleanConstant_4 = this.langExt.booleanConstant(false);
              _builder.append(_booleanConstant_4, "\t");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("setState(");
          String _selfPointer_5 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_5, "\t");
          _builder.append("next__et);");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("void ");
          _builder.append(opScope, "");
          _builder.append("executeInitTransition(");
          _builder.append(selfOnly, "");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(publicIf, "");
          _builder.append("void ");
          _builder.append(opScope, "");
          _builder.append("receiveEventInternal(");
          String _className_3 = this.getClassName(mc);
          String _selfPointer_6 = this.langExt.selfPointer(_className_3, handleEvents);
          _builder.append(_selfPointer_6, "");
          {
            if (handleEvents) {
              _builder.append(ifItemPtr, "");
              _builder.append(" ifitem, int localId, int evt, ");
              String _voidPointer_2 = this.langExt.voidPointer();
              _builder.append(_voidPointer_2, "");
              _builder.append(" generic_data__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              _builder.append("\t");
              _builder.append("int trigger__et = (ifitem==");
              String _nullPointer_4 = this.langExt.nullPointer();
              _builder.append(_nullPointer_4, "\t");
              _builder.append(")? POLLING : localId + EVT_SHIFT*evt;");
              _builder.newLineIfNotEmpty();
            } else {
              if (eventDriven) {
                _builder.append("\t");
                _builder.append("int trigger__et = localId + EVT_SHIFT*evt;");
                _builder.newLine();
              }
            }
          }
          _builder.append("\t");
          _builder.append("int chain__et = NOT_CAUGHT;");
          _builder.newLine();
          _builder.append("\t");
          String _stateType_12 = this.stateType();
          _builder.append(_stateType_12, "\t");
          _builder.append(" catching_state__et = NO_STATE;");
          _builder.newLineIfNotEmpty();
          {
            if (usesHdlr) {
              _builder.append("\t");
              String _boolType_5 = this.boolType();
              _builder.append(_boolType_5, "\t");
              _builder.append(" is_handler__et = ");
              String _booleanConstant_5 = this.langExt.booleanConstant(false);
              _builder.append(_booleanConstant_5, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            boolean _or_1 = false;
            if (async) {
              _or_1 = true;
            } else {
              _or_1 = eventDriven;
            }
            if (_or_1) {
              _builder.append("\t");
              CharSequence _markVariableUsed = this.markVariableUsed("trigger__et");
              _builder.append(_markVariableUsed, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          {
            if (handleEvents) {
              _builder.append("\t");
              _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data__et)) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              CharSequence _genStateSwitch = this.genStateSwitch(xpmc, usesHdlr);
              _builder.append(_genStateSwitch, "\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("\t");
              CharSequence _genStateSwitch_1 = this.genStateSwitch(xpmc, usesHdlr);
              _builder.append(_genStateSwitch_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("if (chain__et != NOT_CAUGHT) {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append(opScopePriv, "\t\t");
          _builder.append("exitTo(");
          String _selfPointer_7 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_7, "\t\t");
          _builder.append("getState(");
          String _selfPointer_8 = this.langExt.selfPointer(false);
          _builder.append(_selfPointer_8, "\t\t");
          _builder.append("), catching_state__et");
          {
            if (usesHdlr) {
              _builder.append(", is_handler__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t\t");
          String _stateType_13 = this.stateType();
          _builder.append(_stateType_13, "\t\t\t");
          _builder.append(" next__et = ");
          _builder.append(opScopePriv, "\t\t\t");
          _builder.append("executeTransitionChain(");
          String _selfPointer_9 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_9, "\t\t\t");
          _builder.append("chain__et");
          {
            if (handleEvents) {
              _builder.append(", ifitem, generic_data__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("next__et = ");
          _builder.append(opScopePriv, "\t\t\t");
          _builder.append("enterHistory(");
          String _selfPointer_10 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_10, "\t\t\t");
          _builder.append("next__et");
          {
            if (usesHdlr) {
              _builder.append(", is_handler__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("setState(");
          String _selfPointer_11 = this.langExt.selfPointer(true);
          _builder.append(_selfPointer_11, "\t\t\t");
          _builder.append("next__et);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          CharSequence _finalAction = this.finalAction();
          _builder.append(_finalAction, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        } else {
          _builder.append("void ");
          _builder.append(opScope, "");
          _builder.append("receiveEventInternal(");
          String _className_4 = this.getClassName(mc);
          String _selfPointer_12 = this.langExt.selfPointer(_className_4, handleEvents);
          _builder.append(_selfPointer_12, "");
          {
            if (handleEvents) {
              _builder.append(ifItemPtr, "");
              _builder.append(" ifitem, int localId, int evt, ");
              String _voidPointer_3 = this.langExt.voidPointer();
              _builder.append(_voidPointer_3, "");
              _builder.append(" generic_data__et");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if (handleEvents) {
          {
            if (generateImplementation) {
              _builder.append(publicIf, "");
              _builder.append("void ");
              _builder.append(opScope, "");
              _builder.append("receiveEvent(");
              String _className_5 = this.getClassName(mc);
              String _selfPointer_13 = this.langExt.selfPointer(_className_5, true);
              _builder.append(_selfPointer_13, "");
              _builder.append(ifItemPtr, "");
              _builder.append(" ifitem, int evt, ");
              String _voidPointer_4 = this.langExt.voidPointer();
              _builder.append(_voidPointer_4, "");
              _builder.append(" generic_data__et) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("int localId = (ifitem==");
              String _nullPointer_5 = this.langExt.nullPointer();
              _builder.append(_nullPointer_5, "\t");
              _builder.append(")? 0 : ifitem");
              _builder.append(getLocalId, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append(opScope, "\t");
              _builder.append("receiveEventInternal(");
              String _selfPointer_14 = this.langExt.selfPointer(true);
              _builder.append(_selfPointer_14, "\t");
              _builder.append("ifitem, localId, evt, generic_data__et);");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("void ");
              _builder.append(opScope, "");
              _builder.append("receiveEvent(");
              String _selfPointer_15 = this.langExt.selfPointer(true);
              _builder.append(_selfPointer_15, "");
              _builder.append(ifItemPtr, "");
              _builder.append(" ifitem, int evt, ");
              String _voidPointer_5 = this.langExt.voidPointer();
              _builder.append(_voidPointer_5, "");
              _builder.append(" generic_data__et);");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * generate the do code calls for a given state
   * 
   * @param state the {@link State}
   * @return the generated code
   */
  public String genDoCodes(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasDoCode = this._fSMHelpers.hasDoCode(state, true);
      if (_hasDoCode) {
        String _doCodeOperationName = this._codegenHelpers.getDoCodeOperationName(state);
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
        String _genDoCodes = this.genDoCodes(((State) _eContainer_3));
        _builder.append(_genDoCodes, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * helper method which generates the state switch.
   * Asynchronous, data driven and event driven state machines are distinguished
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoint}s
   *      at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genStateSwitch(final ExpandedModelComponent xpmc, final boolean usesHdlr) {
    CharSequence _xblockexpression = null;
    {
      ModelComponent _modelComponent = xpmc.getModelComponent();
      ComponentCommunicationType _commType = _modelComponent.getCommType();
      boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ModelComponent _modelComponent_1 = xpmc.getModelComponent();
      ComponentCommunicationType _commType_1 = _modelComponent_1.getCommType();
      boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      ModelComponent _modelComponent_2 = xpmc.getModelComponent();
      ComponentCommunicationType _commType_2 = _modelComponent_2.getCommType();
      boolean dataDriven = Objects.equal(_commType_2, ComponentCommunicationType.DATA_DRIVEN);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (getState(");
      String _selfPointer = this.langExt.selfPointer(false);
      _builder.append(_selfPointer, "");
      _builder.append(")) {");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine = xpmc.getStateMachine();
        List<State> _leafStateList = this._fSMHelpers.getLeafStateList(_stateMachine);
        for(final State state : _leafStateList) {
          _builder.append("    ");
          _builder.append("case ");
          String _genStateId = this._codegenHelpers.getGenStateId(state);
          _builder.append(_genStateId, "    ");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              _builder.append("    ");
              _builder.append("    ");
              EList<ActiveTrigger> atlist = xpmc.getActiveTriggers(state);
              _builder.newLineIfNotEmpty();
              {
                boolean _isEmpty = atlist.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("switch(trigger__et) {");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("case POLLING:");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("        ");
                  CharSequence _genDataDrivenTriggers = this.genDataDrivenTriggers(xpmc, state, usesHdlr);
                  _builder.append(_genDataDrivenTriggers, "                ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("        ");
                  _builder.append("break;");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("    ");
                  CharSequence _genEventDrivenTriggers = this.genEventDrivenTriggers(xpmc, state, atlist, usesHdlr);
                  _builder.append(_genEventDrivenTriggers, "            ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("    ");
                  _builder.append("    ");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("    ");
                  _builder.append("    ");
                  CharSequence _genDataDrivenTriggers_1 = this.genDataDrivenTriggers(xpmc, state, usesHdlr);
                  _builder.append(_genDataDrivenTriggers_1, "        ");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (dataDriven) {
                _builder.append("    ");
                _builder.append("    ");
                CharSequence _genDataDrivenTriggers_2 = this.genDataDrivenTriggers(xpmc, state, usesHdlr);
                _builder.append(_genDataDrivenTriggers_2, "        ");
                _builder.newLineIfNotEmpty();
              } else {
                if (eventDriven) {
                  _builder.append("    ");
                  _builder.append("    ");
                  EList<ActiveTrigger> atlist_1 = xpmc.getActiveTriggers(state);
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _isEmpty_1 = atlist_1.isEmpty();
                    boolean _not_1 = (!_isEmpty_1);
                    if (_not_1) {
                      _builder.append("    ");
                      _builder.append("    ");
                      _builder.append("switch(trigger__et) {");
                      _builder.newLine();
                      _builder.append("    ");
                      _builder.append("    ");
                      _builder.append("        ");
                      CharSequence _genEventDrivenTriggers_1 = this.genEventDrivenTriggers(xpmc, state, atlist_1, usesHdlr);
                      _builder.append(_genEventDrivenTriggers_1, "                ");
                      _builder.newLineIfNotEmpty();
                      _builder.append("    ");
                      _builder.append("    ");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder.append("    ");
          _builder.append("    ");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("    ");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the data driven triggers
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param state the {@link State} for which the trigger if-else switch should be generated
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   *      at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genDataDrivenTriggers(final ExpandedModelComponent xpmc, final State state, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    String _genDoCodes = this.genDoCodes(state);
    _builder.append(_genDoCodes, "");
    _builder.newLineIfNotEmpty();
    List<Transition> _outgoingTransitionsHierarchical = this._fSMExtensions.getOutgoingTransitionsHierarchical(xpmc, state);
    final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition t) {
        return Boolean.valueOf((t instanceof GuardedTransition));
      }
    };
    Iterable<Transition> transitions = IterableExtensions.<Transition>filter(_outgoingTransitionsHierarchical, _function);
    _builder.newLineIfNotEmpty();
    {
      for(final Transition tr : transitions) {
        _builder.append("if (");
        String _guard = this.guard(((GuardedTransition) tr), "", xpmc);
        _builder.append(_guard, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("    ");
        TransitionChain chain = xpmc.getChain(tr);
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("chain__et = ");
        String _genChainId = this._codegenHelpers.getGenChainId(chain);
        _builder.append(_genChainId, "    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("catching_state__et = ");
        State _stateContext = chain.getStateContext();
        String _genStateId = this._codegenHelpers.getGenStateId(_stateContext);
        _builder.append(_genStateId, "    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        {
          boolean _and = false;
          boolean _isHandler = chain.isHandler();
          if (!_isHandler) {
            _and = false;
          } else {
            _and = usesHdlr;
          }
          if (_and) {
            _builder.append("    ");
            _builder.append("is_handler__et = TRUE;");
            _builder.newLine();
          }
        }
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
  
  /**
   * helper method which generates the event driven triggers
   * 
   * @param xpmc the {@link ExpandedModelComponent}
   * @param state the {@link State} for which the trigger switch should be generated
   * @param atlist the list of {@link ActiveTrigger}s of this state
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   *      at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genEventDrivenTriggers(final ExpandedModelComponent xpmc, final State state, final List<ActiveTrigger> atlist, final boolean usesHdlr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final ActiveTrigger at : atlist) {
        _builder.append("case ");
        String _triggerCodeName = xpmc.getTriggerCodeName(at);
        _builder.append(_triggerCodeName, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        boolean needData = this._fsmGenUtil.hasGuard(at);
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        {
          if (needData) {
            _builder.append("{ ");
            EObject _msg = at.getMsg();
            String _typedDataDefinition = this.langExt.getTypedDataDefinition(_msg);
            _builder.append(_typedDataDefinition, "    ");
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
              _builder.appendImmediate(" else ", "    ");
            }
            _builder.append("    ");
            TransitionChain chain = xpmc.getChain(tt);
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            Transition _transition = chain.getTransition();
            String _trigger = at.getTrigger();
            String _guard = this.guard(((TriggeredTransition) _transition), _trigger, xpmc);
            _builder.append(_guard, "    ");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("    ");
            _builder.append("chain__et = ");
            String _genChainId = this._codegenHelpers.getGenChainId(chain);
            _builder.append(_genChainId, "        ");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("    ");
            _builder.append("catching_state__et = ");
            State _stateContext = chain.getStateContext();
            String _genStateId = this._codegenHelpers.getGenStateId(_stateContext);
            _builder.append(_genStateId, "        ");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            {
              boolean _and = false;
              boolean _isHandler = chain.isHandler();
              if (!_isHandler) {
                _and = false;
              } else {
                _and = usesHdlr;
              }
              if (_and) {
                _builder.append("    ");
                _builder.append("    ");
                _builder.append("is_handler__et = ");
                String _booleanConstant = this.langExt.booleanConstant(true);
                _builder.append(_booleanConstant, "        ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("    ");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("    ");
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
    _builder.append("default:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("/* should not occur */");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("break;");
    _builder.newLine();
    return _builder;
  }
  
  public String getClassName(final ExpandedModelComponent xpmc) {
    ModelComponent _modelComponent = xpmc.getModelComponent();
    return this.getClassName(_modelComponent);
  }
  
  public String getClassName(final ModelComponent mc) {
    return mc.getComponentName();
  }
  
  /**
   * getter for history array
   * 
   * @param state the ID of the history state
   * @return the generated code
   */
  public String getHistory(final String state) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    return (_plus_1 + "]");
  }
  
  /**
   * setter for history array
   * 
   * @param state the ID of the state whose history should be set
   * @param historyState the ID of the state that should be assigned
   * @return the generated code
   */
  public String setHistory(final String state, final String historyState) {
    String _memberAccess = this.langExt.memberAccess();
    String _plus = (_memberAccess + "history[");
    String _plus_1 = (_plus + state);
    String _plus_2 = (_plus_1 + "] = ");
    return (_plus_2 + historyState);
  }
  
  /**
   * @return the type of (temporary) state variables (defaults to "int")
   * and has to be signed
   */
  public String stateType() {
    return "int";
  }
  
  /**
   * allow target language dependent generation of unreachable return in generated enterHistory method.
   * The default is just a comment.
   * @return the generated code
   */
  public String unreachableReturn() {
    return "/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */";
  }
  
  /**
   * type of (temporary) boolean variables (defaults to "boolean")
   * @return the generated code
   */
  public String boolType() {
    return "boolean";
  }
  
  /**
   * empty, but may be overridden
   */
  public CharSequence finalAction() {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * the type of the interface item passed into the receiveEvent() method
   */
  public String interfaceItemType() {
    return "InterfaceItemBase";
  }
  
  /**
   * empty, but may be overridden
   */
  public CharSequence markVariableUsed(final String varname) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * let derived class add extra code after definition of constants
   * 
   * @param xpmc an expanded actor class
   * @return the generated code
   */
  public CharSequence genExtra(final ExpandedModelComponent xpmc) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * let derived class add extra code after definition of constants in header (if applicable)
   * 
   * @param xpmc an expanded actor class
   * @return the generated code
   */
  public CharSequence genExtraDecl(final ExpandedModelComponent xpmc) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * helper method to determine whether this state machine uses handler transitions
   * points at all
   * 
   * @param xpax the {@link ExpandedModelComponent}
   * @return <code>true</code> if the state machine uses handler transition points
   */
  public boolean usesHandlerTrPoints(final ExpandedModelComponent xpmc) {
    boolean _xblockexpression = false;
    {
      StateGraph _stateMachine = xpmc.getStateMachine();
      boolean _isEmpty = this._fSMHelpers.isEmpty(_stateMachine);
      if (_isEmpty) {
        return false;
      }
      StateGraph _stateMachine_1 = xpmc.getStateMachine();
      List<TrPoint> _allTrPointsRecursive = this._fSMHelpers.getAllTrPointsRecursive(_stateMachine_1);
      final Function1<TrPoint, Boolean> _function = new Function1<TrPoint, Boolean>() {
        public Boolean apply(final TrPoint t) {
          boolean _and = false;
          if (!(t instanceof TransitionPoint)) {
            _and = false;
          } else {
            boolean _isHandler = ((TransitionPoint) t).isHandler();
            _and = _isHandler;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterable<TrPoint> _filter = IterableExtensions.<TrPoint>filter(_allTrPointsRecursive, _function);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
      _xblockexpression = (!_isEmpty_1);
    }
    return _xblockexpression;
  }
  
  public abstract String guard(final TriggeredTransition tt, final String trigger, final ExpandedModelComponent mc);
  
  public abstract String guard(final GuardedTransition tt, final String trigger, final ExpandedModelComponent mc);
  
  public abstract String genActionCodeMethod(final ExpandedModelComponent xpmc, final Transition tr, final boolean generateImplementation);
  
  public abstract String genActionCodeMethods(final ExpandedModelComponent xpmc, final State state, final boolean generateImplementation);
}
