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
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
  
  @Inject
  public FSMNameProvider fsmNameProvider;
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param gc the {@link GraphContainer}
   * @return the generated code
   */
  public String genTriggerConstants(final GraphContainer gc) {
    return this.genTriggerConstants(gc, this.langExt.usesInheritance());
  }
  
  /**
   * generates trigger IDs.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param gc the {@link GraphContainer}
   * @param omitBase use <code>true</code> if no base class trigger constants are needed
   * 
   * @return the generated code
   */
  public String genTriggerConstants(final GraphContainer gc, final boolean omitBase) {
    List<MessageFromIf> _xifexpression = null;
    if (omitBase) {
      _xifexpression = this._fSMHelpers.getOwnMessagesFromInterfaces(gc.getComponent());
    } else {
      _xifexpression = this._fSMHelpers.getAllMessagesFromInterfaces(gc.getComponent());
    }
    final List<MessageFromIf> triggers = _xifexpression;
    final ArrayList<Pair<String, String>> list = CollectionLiterals.<Pair<String, String>>newArrayList();
    list.add(Tuples.<String, String>pair("POLLING", "0"));
    for (final MessageFromIf mif : triggers) {
      boolean _isEventDriven = mif.getFrom().isEventDriven();
      if (_isEventDriven) {
        String _triggerCodeName = this.getTriggerCodeName(mif);
        String _ifItemId = this.itemIdGen.getIfItemId(mif.getFrom());
        String _plus = (_ifItemId + " + EVT_SHIFT*");
        String _messageID = this.msgIdGen.getMessageID(mif);
        String _plus_1 = (_plus + _messageID);
        list.add(Tuples.<String, String>pair(_triggerCodeName, _plus_1));
      }
    }
    return this.langExt.genEnumeration("triggers", list);
  }
  
  public String getTriggerCodeName(final MessageFromIf mif) {
    String _name = mif.getFrom().getName();
    String _plus = ("TRIG_" + _name);
    String _plus_1 = (_plus + "__");
    String _messageName = this.fsmNameProvider.getMessageName(mif.getMessage());
    return (_plus_1 + _messageName);
  }
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param gc the {@link GraphContainer}
   * @return the generated code
   */
  public String genStateIdConstants(final GraphContainer gc) {
    return this.genStateIdConstants(gc, this.langExt.usesInheritance());
  }
  
  /**
   * generates state ID constants.
   * Inheritance (if available) is used for base class IDs.
   * 
   * @param gc the {@link GraphContainer}
   * @param omitBase use <code>true</code> if no base class state constants are needed
   * 
   * @return the generated code
   */
  public String genStateIdConstants(final GraphContainer gc, final boolean omitBase) {
    final List<Node> allStateNodes = IteratorExtensions.<Node>toList(FsmGenExtensions.getAllStateNodes(gc.getGraph()));
    int _xifexpression = (int) 0;
    if (omitBase) {
      final Function1<Node, Boolean> _function = (Node it) -> {
        return Boolean.valueOf(it.isInherited());
      };
      _xifexpression = IterableExtensions.size(IterableExtensions.<Node>filter(allStateNodes, _function));
    } else {
      _xifexpression = 0;
    }
    int offset = (2 + _xifexpression);
    Iterable<Node> _xifexpression_1 = null;
    if (omitBase) {
      final Function1<Node, Boolean> _function_1 = (Node it) -> {
        boolean _isInherited = it.isInherited();
        return Boolean.valueOf((!_isInherited));
      };
      _xifexpression_1 = IterableExtensions.<Node>filter(allStateNodes, _function_1);
    } else {
      _xifexpression_1 = allStateNodes;
    }
    final Function1<Node, StateGraphNode> _function_2 = (Node it) -> {
      return it.getStateGraphNode();
    };
    List<State> baseStates = IterableExtensions.<State>toList(Iterables.<State>filter(IterableExtensions.<Node, StateGraphNode>map(_xifexpression_1, _function_2), State.class));
    baseStates = IterableExtensions.<State>toList(this._fSMExtensions.getLeafStatesLast(baseStates));
    ArrayList<Pair<String, String>> list = CollectionLiterals.<Pair<String, String>>newArrayList();
    if ((!omitBase)) {
      list.add(Tuples.<String, String>pair("NO_STATE", "0"));
      list.add(Tuples.<String, String>pair("STATE_TOP", "1"));
    }
    for (final State state : baseStates) {
      {
        list.add(Tuples.<String, String>pair(this._codegenHelpers.getGenStateId(state), Integer.valueOf(offset).toString()));
        offset = (offset + 1);
      }
    }
    list.add(Tuples.<String, String>pair("STATE_MAX", Integer.valueOf(offset).toString()));
    return this.langExt.genEnumeration("state_ids", list);
  }
  
  /**
   * generates transition chain ID constants.
   * Inheritance can't be used used for base class IDs because of corner cases
   * where base class and derived class chain IDs deviate (see bug 501354).
   * 
   * @param gc the {@link GraphContainer}
   * 
   * @return the generated code
   */
  public String genTransitionChainConstants(final GraphContainer gc) {
    return this.genTransitionChainConstants(gc, false);
  }
  
  /**
   * generates transition chain ID constants.<br/><br/>
   * 
   * <b>Note:</b> Inheritance can't be used used for base class IDs because of corner cases
   * where base class and derived class chain IDs deviate.
   * 
   * @param gc the {@link GraphContainer}
   * @param omitBase use <code>true</code> if no base class transition chain constants are needed
   * 
   * @return the generated code
   */
  public String genTransitionChainConstants(final GraphContainer gc, final boolean omitBase) {
    Iterator<Link> _xifexpression = null;
    if (omitBase) {
      final Function1<Link, Boolean> _function = (Link it) -> {
        boolean _isInherited = it.isInherited();
        return Boolean.valueOf((!_isInherited));
      };
      _xifexpression = IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(gc.getGraph()), _function);
    } else {
      _xifexpression = FsmGenExtensions.getAllLinks(gc.getGraph());
    }
    final Function1<Link, TransitionBase> _function_1 = (Link it) -> {
      return it.getTransition();
    };
    final Function1<TransitionBase, Boolean> _function_2 = (TransitionBase it) -> {
      return Boolean.valueOf(FsmGenExtensions.isChainHead(it));
    };
    final List<Transition> chains = IteratorExtensions.<Transition>toList(Iterators.<Transition>filter(IteratorExtensions.<TransitionBase>filter(IteratorExtensions.<Link, TransitionBase>map(_xifexpression, _function_1), _function_2), Transition.class));
    int _xifexpression_1 = (int) 0;
    if (omitBase) {
      final Function1<Link, Boolean> _function_3 = (Link it) -> {
        return Boolean.valueOf(it.isInherited());
      };
      _xifexpression_1 = IteratorExtensions.size(IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(gc.getGraph()), _function_3));
    } else {
      _xifexpression_1 = 0;
    }
    int offset = _xifexpression_1;
    ArrayList<Pair<String, String>> list = CollectionLiterals.<Pair<String, String>>newArrayList();
    for (final Transition chain : chains) {
      {
        offset = (offset + 1);
        list.add(Tuples.<String, String>pair(this._codegenHelpers.getGenChainId(chain), Integer.valueOf(offset).toString()));
      }
    }
    return this.langExt.genEnumeration("ChainIDs", list);
  }
  
  /**
   * generates entry and exit code for states
   * 
   * @param gc the {@link GraphContainer}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * 
   * @return the generated code
   */
  public String genEntryAndExitCodes(final GraphContainer gc, final boolean generateImplementation) {
    return this.genEntryAndExitCodes(gc, generateImplementation, this.langExt.usesInheritance());
  }
  
  /**
   * generates entry and exit code for states
   * 
   * @param gc the {@link GraphContainer}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * @param omitBase use <code>true</code> if no base class entry and exit codes are needed
   * 
   * @return the generated code
   */
  public String genEntryAndExitCodes(final GraphContainer gc, final boolean generateImplementation, final boolean omitBase) {
    String _xblockexpression = null;
    {
      final Function1<Node, Boolean> _function = (Node it) -> {
        return Boolean.valueOf(((!omitBase) || (!it.isInherited())));
      };
      final List<Node> states = IteratorExtensions.<Node>toList(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(gc.getGraph()), _function));
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Node state : states) {
          String _genActionCodeMethods = this.genActionCodeMethods(gc, state, generateImplementation);
          _builder.append(_genActionCodeMethods);
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * generates transition action codes
   * 
   * @param gc the {@link GraphContainer}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * 
   * @return the generated code
   */
  public String genActionCodes(final GraphContainer gc, final boolean generateImplementation) {
    return this.genActionCodes(gc, generateImplementation, this.langExt.usesInheritance());
  }
  
  /**
   * generates transition action codes
   * 
   * @param gc the {@link GraphContainer}
   * @param generateImplementation if <code>true</code> the implementation is generated, else the declaration
   * @param omitBase use <code>true</code> if no base class action codes are needed
   * 
   * @return the generated code
   */
  public String genActionCodes(final GraphContainer gc, final boolean generateImplementation, final boolean omitBase) {
    String _xblockexpression = null;
    {
      final Function1<Link, Boolean> _function = (Link it) -> {
        return Boolean.valueOf(((!omitBase) || (!it.isInherited())));
      };
      final Function1<Link, Boolean> _function_1 = (Link it) -> {
        return Boolean.valueOf(this._fSMHelpers.hasDetailCode(it.getTransition().getAction()));
      };
      final List<Link> transitions = IteratorExtensions.<Link>toList(IteratorExtensions.<Link>filter(IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(gc.getGraph()), _function), _function_1));
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final Link tr : transitions) {
          String _genActionCodeMethod = this.genActionCodeMethod(gc, tr, generateImplementation);
          _builder.append(_genActionCodeMethod);
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String genStateSwitchMethods(final GraphContainer gc, final boolean generateImplementation) {
    String _xblockexpression = null;
    {
      final ModelComponent mc = gc.getComponent();
      ComponentCommunicationType _commType = mc.getCommType();
      final boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = mc.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      String _interfaceItemType = this.interfaceItemType();
      String _pointerLiteral = this.langExt.pointerLiteral();
      final String ifItemPtr = (_interfaceItemType + _pointerLiteral);
      final boolean handleEvents = (async || eventDriven);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        String _className = this.getClassName(mc);
        String _scopeSeparator = this.langExt.scopeSeparator();
        _xifexpression = (_className + _scopeSeparator);
      } else {
        _xifexpression = "";
      }
      final String chainIDScope = _xifexpression;
      final String opScope = this.langExt.operationScope(this.getClassName(mc), (!generateImplementation));
      String _xifexpression_1 = null;
      boolean _usesInheritance_1 = this.langExt.usesInheritance();
      if (_usesInheritance_1) {
        _xifexpression_1 = opScope;
      } else {
        _xifexpression_1 = "";
      }
      final String opScopePriv = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _usesInheritance_2 = this.langExt.usesInheritance();
      if (_usesInheritance_2) {
        _xifexpression_2 = this.langExt.accessLevelPublic();
      } else {
        _xifexpression_2 = this.langExt.accessLevelPrivate();
      }
      final String publicIf = _xifexpression_2;
      final String privAccess = this.langExt.accessLevelPrivate();
      final String selfPtr = this.langExt.selfPointer(this.getClassName(mc), true);
      final String selfOnly = this.langExt.selfPointer(this.getClassName(mc), false);
      String _xifexpression_3 = null;
      boolean _usesInheritance_3 = this.langExt.usesInheritance();
      if (_usesInheritance_3) {
        String _xifexpression_4 = null;
        boolean _usesPointers = this.langExt.usesPointers();
        if (_usesPointers) {
          _xifexpression_4 = "->getLocalId()";
        } else {
          _xifexpression_4 = ".getLocalId()";
        }
        _xifexpression_3 = _xifexpression_4;
      } else {
        _xifexpression_3 = "->localId";
      }
      final String getLocalId = _xifexpression_3;
      String _xifexpression_5 = null;
      boolean _usesPointers_1 = this.langExt.usesPointers();
      if (_usesPointers_1) {
        _xifexpression_5 = ("const " + ifItemPtr);
      } else {
        _xifexpression_5 = ifItemPtr;
      }
      final String constIfItemPtr = _xifexpression_5;
      final boolean usesHdlr = this.usesHandlerTrPoints(gc);
      final Function1<Node, String> _function = (Node it) -> {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return this._codegenHelpers.getGenStateId(((State) _stateGraphNode));
      };
      final List<Node> nodes = IterableExtensions.<Node, String>sortBy(IteratorExtensions.<Node>toList(FsmGenExtensions.getAllStateNodes(gc.getGraph())), _function);
      final HashMap<State, Node> state2node = CollectionLiterals.<State, Node>newHashMap();
      final Consumer<Node> _function_1 = (Node it) -> {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        state2node.put(((State) _stateGraphNode), it);
      };
      nodes.forEach(_function_1);
      final Function1<Node, StateGraphNode> _function_2 = (Node it) -> {
        return it.getStateGraphNode();
      };
      final List<State> states = IterableExtensions.<State>toList(Iterables.<State>filter(ListExtensions.<Node, StateGraphNode>map(nodes, _function_2), State.class));
      final Function1<Link, Boolean> _function_3 = (Link it) -> {
        return Boolean.valueOf(FsmGenExtensions.isChainHead(it));
      };
      final Function1<Link, String> _function_4 = (Link it) -> {
        return this._codegenHelpers.getGenChainId(it.getTransition());
      };
      final List<Link> transitionChains = IterableExtensions.<Link, String>sortBy(IteratorExtensions.<Link>toList(IteratorExtensions.<Link>filter(FsmGenExtensions.getAllLinks(gc.getGraph()), _function_3)), _function_4);
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
          _builder.append(privAccess);
          _builder.append("void ");
          _builder.append(opScopePriv);
          _builder.append("exitTo(");
          _builder.append(selfPtr);
          String _stateType = this.stateType();
          _builder.append(_stateType);
          _builder.append(" current__et, ");
          String _stateType_1 = this.stateType();
          _builder.append(_stateType_1);
          _builder.append(" to");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType = this.boolType();
              _builder.append(_boolType);
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
            for(final State state : states) {
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
              String _setHistory = this.setHistory(this._codegenHelpers.getParentStateId(state), this._codegenHelpers.getGenStateId(state));
              _builder.append(_setHistory, "\t\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("current__et = ");
              String _parentStateId = this._codegenHelpers.getParentStateId(state);
              _builder.append(_parentStateId, "\t\t\t\t");
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
          _builder.append(selfPtr);
          String _stateType_2 = this.stateType();
          _builder.append(_stateType_2);
          _builder.append(" current__et, ");
          String _stateType_3 = this.stateType();
          _builder.append(_stateType_3);
          _builder.append(" to");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_1 = this.boolType();
              _builder.append(_boolType_1);
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
          _builder.append(privAccess);
          String _stateType_4 = this.stateType();
          _builder.append(_stateType_4);
          _builder.append(" ");
          _builder.append(opScopePriv);
          _builder.append("executeTransitionChain(");
          _builder.append(selfPtr);
          _builder.append("int chain__et");
          {
            if (handleEvents) {
              _builder.append(", ");
              _builder.append(constIfItemPtr);
              _builder.append(" ifitem, ");
              String _voidPointer = this.langExt.voidPointer();
              _builder.append(_voidPointer);
              _builder.append(" generic_data__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("switch (chain__et) {");
          _builder.newLine();
          {
            for(final Link tc : transitionChains) {
              _builder.append("\t\t");
              _builder.append("case ");
              _builder.append(chainIDScope, "\t\t");
              String _genChainId = this._codegenHelpers.getGenChainId(tc.getTransition());
              _builder.append(_genChainId, "\t\t");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              String _generateExecuteChain = this.transitionChainGenerator.generateExecuteChain(gc, tc);
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
          _builder.append(_stateType_5);
          _builder.append(" executeTransitionChain(");
          _builder.append(selfPtr);
          _builder.append("int chain__et");
          {
            if (handleEvents) {
              _builder.append(", ");
              _builder.append(constIfItemPtr);
              _builder.append(" ifitem, ");
              String _voidPointer_1 = this.langExt.voidPointer();
              _builder.append(_voidPointer_1);
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
          _builder.append(privAccess);
          String _stateType_6 = this.stateType();
          _builder.append(_stateType_6);
          _builder.append(" ");
          _builder.append(opScopePriv);
          _builder.append("enterHistory(");
          _builder.append(selfPtr);
          String _stateType_7 = this.stateType();
          _builder.append(_stateType_7);
          _builder.append(" state__et");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_2 = this.boolType();
              _builder.append(_boolType_2);
              _builder.append(" handler__et");
            }
          }
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<State, Boolean> _function_5 = (State s) -> {
            return Boolean.valueOf(this._fSMHelpers.hasEntryCode(s, true));
          };
          boolean _isEmpty = IterableExtensions.isEmpty(IterableExtensions.<State>filter(states, _function_5));
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
            boolean _usesInheritance_4 = this.langExt.usesInheritance();
            boolean _not = (!_usesInheritance_4);
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
            for(final State state_1 : states) {
              _builder.append("\t\t\t");
              _builder.append("case ");
              String _genStateId_1 = this._codegenHelpers.getGenStateId(state_1);
              _builder.append(_genStateId_1, "\t\t\t");
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
                  String _genStateId_2 = this._codegenHelpers.getGenStateId(state_1);
                  _builder.append(_genStateId_2, "\t\t\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("/* state has a sub graph */");
                  _builder.newLine();
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  InitialTransition sub_initt = FsmGenExtensions.getInitialTransition(state2node.get(state_1).getSubgraph());
                  _builder.newLineIfNotEmpty();
                  {
                    if ((sub_initt != null)) {
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("/* with init transition */");
                      _builder.newLine();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("if (");
                      String _history = this.getHistory(this._codegenHelpers.getGenStateId(state_1));
                      _builder.append(_history, "\t\t\t\t");
                      _builder.append("==NO_STATE) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("state__et = executeTransitionChain(");
                      String _selfPointer_2 = this.langExt.selfPointer(true);
                      _builder.append(_selfPointer_2, "\t\t\t\t\t");
                      _builder.append(chainIDScope, "\t\t\t\t\t");
                      String _genChainId_1 = this._codegenHelpers.getGenChainId(sub_initt);
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
                      String _history_1 = this.getHistory(this._codegenHelpers.getGenStateId(state_1));
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
                      String _history_2 = this.getHistory(this._codegenHelpers.getGenStateId(state_1));
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
          _builder.append(_stateType_9);
          _builder.append(" enterHistory(");
          _builder.append(selfPtr);
          String _stateType_10 = this.stateType();
          _builder.append(_stateType_10);
          _builder.append(" state__et");
          {
            if (usesHdlr) {
              _builder.append(", ");
              String _boolType_4 = this.boolType();
              _builder.append(_boolType_4);
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
          _builder.append(publicIf);
          _builder.append("void ");
          _builder.append(opScope);
          _builder.append("executeInitTransition(");
          _builder.append(selfOnly);
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          InitialTransition initt = FsmGenExtensions.getInitialTransition(gc.getGraph());
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("int chain__et = ");
          _builder.append(chainIDScope, "\t");
          String _genChainId_2 = this._codegenHelpers.getGenChainId(initt);
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
          _builder.append(opScope);
          _builder.append("executeInitTransition(");
          _builder.append(selfOnly);
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* receiveEvent contains the main implementation of the FSM */");
      _builder.newLine();
      {
        if (generateImplementation) {
          _builder.append(publicIf);
          _builder.append("void ");
          _builder.append(opScope);
          _builder.append("receiveEventInternal(");
          String _selfPointer_6 = this.langExt.selfPointer(this.getClassName(mc), handleEvents);
          _builder.append(_selfPointer_6);
          {
            if (handleEvents) {
              _builder.append(ifItemPtr);
              _builder.append(" ifitem, int localId, int evt, ");
              String _voidPointer_2 = this.langExt.voidPointer();
              _builder.append(_voidPointer_2);
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
            if ((async || eventDriven)) {
              _builder.append("\t");
              CharSequence _markVariableUsed = this.markVariableUsed("trigger__et");
              _builder.append(_markVariableUsed, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          {
            if (handleEvents) {
              _builder.append("\t");
              _builder.append("if (!handleSystemEvent(ifitem, evt, generic_data__et)) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              CharSequence _genStateSwitch = this.genStateSwitch(gc, usesHdlr);
              _builder.append(_genStateSwitch, "\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("\t");
              CharSequence _genStateSwitch_1 = this.genStateSwitch(gc, usesHdlr);
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
          _builder.append(opScope);
          _builder.append("receiveEventInternal(");
          String _selfPointer_12 = this.langExt.selfPointer(this.getClassName(mc), handleEvents);
          _builder.append(_selfPointer_12);
          {
            if (handleEvents) {
              _builder.append(ifItemPtr);
              _builder.append(" ifitem, int localId, int evt, ");
              String _voidPointer_3 = this.langExt.voidPointer();
              _builder.append(_voidPointer_3);
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
              _builder.append(publicIf);
              _builder.append("void ");
              _builder.append(opScope);
              _builder.append("receiveEvent(");
              String _selfPointer_13 = this.langExt.selfPointer(this.getClassName(mc), true);
              _builder.append(_selfPointer_13);
              _builder.append(ifItemPtr);
              _builder.append(" ifitem, int evt, ");
              String _voidPointer_4 = this.langExt.voidPointer();
              _builder.append(_voidPointer_4);
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
              _builder.append(opScope);
              _builder.append("receiveEvent(");
              String _selfPointer_15 = this.langExt.selfPointer(true);
              _builder.append(_selfPointer_15);
              _builder.append(ifItemPtr);
              _builder.append(" ifitem, int evt, ");
              String _voidPointer_5 = this.langExt.voidPointer();
              _builder.append(_voidPointer_5);
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
        _builder.append(_doCodeOperationName);
        _builder.append("(");
        String _selfPointer = this.langExt.selfPointer(false);
        _builder.append(_selfPointer);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EObject _eContainer = state.eContainer().eContainer();
      if ((_eContainer instanceof State)) {
        EObject _eContainer_1 = state.eContainer().eContainer();
        String _genDoCodes = this.genDoCodes(((State) _eContainer_1));
        _builder.append(_genDoCodes);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * helper method which generates the state switch.
   * Asynchronous, data driven and event driven state machines are distinguished
   * 
   * @param gc the {@link GraphContainer}
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoint}s
   * 	  at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genStateSwitch(final GraphContainer gc, final boolean usesHdlr) {
    CharSequence _xblockexpression = null;
    {
      ComponentCommunicationType _commType = gc.getComponent().getCommType();
      boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = gc.getComponent().getCommType();
      boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      ComponentCommunicationType _commType_2 = gc.getComponent().getCommType();
      boolean dataDriven = Objects.equal(_commType_2, ComponentCommunicationType.DATA_DRIVEN);
      final Function1<Node, Boolean> _function = (Node it) -> {
        return Boolean.valueOf(FsmGenExtensions.isLeaf(it));
      };
      final Function1<Node, String> _function_1 = (Node it) -> {
        StateGraphNode _stateGraphNode = it.getStateGraphNode();
        return this._codegenHelpers.getGenStateId(((State) _stateGraphNode));
      };
      final List<Node> allLeafStateNodes = IterableExtensions.<Node, String>sortBy(IteratorExtensions.<Node>toList(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllStateNodes(gc.getGraph()), _function)), _function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (getState(");
      String _selfPointer = this.langExt.selfPointer(false);
      _builder.append(_selfPointer);
      _builder.append(")) {");
      _builder.newLineIfNotEmpty();
      {
        for(final Node stateNode : allLeafStateNodes) {
          _builder.append("\t");
          StateGraphNode _stateGraphNode = stateNode.getStateGraphNode();
          final State state = ((State) _stateGraphNode);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("case ");
          String _genStateId = this._codegenHelpers.getGenStateId(state);
          _builder.append(_genStateId, "\t");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          final EList<CommonTrigger> caughtTriggers = stateNode.getCaughtTriggers();
          _builder.newLineIfNotEmpty();
          {
            if (async) {
              {
                boolean _isEmpty = caughtTriggers.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("switch(trigger__et) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("case POLLING:");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  CharSequence _genDataDrivenTriggers = this.genDataDrivenTriggers(gc, stateNode, usesHdlr);
                  _builder.append(_genDataDrivenTriggers, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("break;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genEventDrivenTriggers = this.genEventDrivenTriggers(gc, stateNode, usesHdlr);
                  _builder.append(_genEventDrivenTriggers, "\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("\t");
                  CharSequence _genDataDrivenTriggers_1 = this.genDataDrivenTriggers(gc, stateNode, usesHdlr);
                  _builder.append(_genDataDrivenTriggers_1, "\t\t");
                  _builder.newLineIfNotEmpty();
                }
              }
            } else {
              if (dataDriven) {
                _builder.append("\t");
                _builder.append("\t");
                CharSequence _genDataDrivenTriggers_2 = this.genDataDrivenTriggers(gc, stateNode, usesHdlr);
                _builder.append(_genDataDrivenTriggers_2, "\t\t");
                _builder.newLineIfNotEmpty();
              } else {
                if (eventDriven) {
                  {
                    boolean _isEmpty_1 = caughtTriggers.isEmpty();
                    boolean _not_1 = (!_isEmpty_1);
                    if (_not_1) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("switch(trigger__et) {");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t");
                      CharSequence _genEventDrivenTriggers_1 = this.genEventDrivenTriggers(gc, stateNode, usesHdlr);
                      _builder.append(_genEventDrivenTriggers_1, "\t\t\t");
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
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the data driven triggers
   * 
   * @param gc the {@link GraphContainer}
   * @param state the {@link State} for which the trigger if-else switch should be generated
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 	  at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genDataDrivenTriggers(final GraphContainer gc, final Node stateNode, final boolean usesHdlr) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        String _className = this.getClassName(gc);
        String _scopeSeparator = this.langExt.scopeSeparator();
        _xifexpression = (_className + _scopeSeparator);
      } else {
        _xifexpression = "";
      }
      final String chainIDScope = _xifexpression;
      StateGraphNode _stateGraphNode = stateNode.getStateGraphNode();
      final State state = ((State) _stateGraphNode);
      StringConcatenation _builder = new StringConcatenation();
      String _genDoCodes = this.genDoCodes(state);
      _builder.append(_genDoCodes);
      _builder.newLineIfNotEmpty();
      final Function1<Link, Boolean> _function = (Link it) -> {
        TransitionBase _transition = it.getTransition();
        return Boolean.valueOf((_transition instanceof GuardedTransition));
      };
      Iterable<Link> links = IterableExtensions.<Link>filter(FsmGenExtensions.getOutgoingLinksHierarchically(stateNode), _function);
      _builder.newLineIfNotEmpty();
      {
        for(final Link l : links) {
          _builder.append("if (");
          String _genGuardedTransitionGuard = this.genGuardedTransitionGuard(l, "", gc);
          _builder.append(_genGuardedTransitionGuard);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("chain__et = ");
          _builder.append(chainIDScope, "\t");
          String _genChainId = this._codegenHelpers.getGenChainId(l.getTransition());
          _builder.append(_genChainId, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("catching_state__et = ");
          String _genStateId = this._codegenHelpers.getGenStateId(this._fSMHelpers.getSuperState(l.getTransition()));
          _builder.append(_genStateId, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          {
            if ((FsmGenExtensions.isHandler(l) && usesHdlr)) {
              _builder.append("\t");
              _builder.append("is_handler__et = TRUE;");
              _builder.newLine();
            }
          }
          _builder.append("}");
          _builder.newLine();
          {
            Link _last = IterableExtensions.<Link>last(links);
            boolean _notEquals = (!Objects.equal(l, _last));
            if (_notEquals) {
              _builder.append("else");
              _builder.newLine();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * helper method which generates the event driven triggers
   * 
   * @param gc the {@link GraphContainer}
   * @param state the {@link State} for which the trigger switch should be generated
   * @param usesHdlr if the state machine uses no handler {@link TransitionPoints}
   * 	  at all then unused variables can be avoided by passing <code>true</code>
   * @return the generated code
   */
  public CharSequence genEventDrivenTriggers(final GraphContainer gc, final Node stateNode, final boolean usesHdlr) {
    CharSequence _xblockexpression = null;
    {
      EList<CommonTrigger> _caughtTriggers = stateNode.getCaughtTriggers();
      final Function1<CommonTrigger, String> _function = (CommonTrigger it) -> {
        return this.getTriggerCodeName(it);
      };
      final List<CommonTrigger> caughtTriggers = IterableExtensions.<CommonTrigger, String>sortBy(new ArrayList<CommonTrigger>(_caughtTriggers), _function);
      String _xifexpression = null;
      boolean _usesInheritance = this.langExt.usesInheritance();
      if (_usesInheritance) {
        String _className = this.getClassName(gc);
        String _scopeSeparator = this.langExt.scopeSeparator();
        _xifexpression = (_className + _scopeSeparator);
      } else {
        _xifexpression = "";
      }
      final String chainIDScope = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final CommonTrigger ct : caughtTriggers) {
          _builder.append("case ");
          String _triggerCodeName = this.getTriggerCodeName(ct);
          _builder.append(_triggerCodeName);
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          boolean needData = ct.isHasGuard();
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (needData) {
              _builder.append("{ ");
              String _typedDataDefinition = this.langExt.getTypedDataDefinition(ct.getMsg());
              _builder.append(_typedDataDefinition, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            EList<Link> _links = ct.getLinks();
            boolean _hasElements = false;
            for(final Link link : _links) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(" else ", "\t");
              }
              _builder.append("\t");
              String _genTriggeredTransitionGuard = this.genTriggeredTransitionGuard(link, ct.getTrigger(), gc);
              _builder.append(_genTriggeredTransitionGuard, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("chain__et = ");
              _builder.append(chainIDScope, "\t\t");
              String _genChainId = this._codegenHelpers.getGenChainId(link.getTransition());
              _builder.append(_genChainId, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("catching_state__et = ");
              String _genStateId = this._codegenHelpers.getGenStateId(this._fSMHelpers.getSuperState(link.getTransition()));
              _builder.append(_genStateId, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              {
                if ((FsmGenExtensions.isHandler(link) && usesHdlr)) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("is_handler__et = ");
                  String _booleanConstant = this.langExt.booleanConstant(true);
                  _builder.append(_booleanConstant, "\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
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
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* should not occur */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("break;");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String getClassName(final GraphContainer gc) {
    return this.getClassName(gc.getComponent());
  }
  
  public String getClassName(final ModelComponent mc) {
    return mc.getComponentName();
  }
  
  public String getTriggerCodeName(final CommonTrigger tr) {
    final String[] parts = tr.getTrigger().split(TriggerExtensions.TRIGGER_SEP);
    String _get = parts[0];
    String _plus = ("TRIG_" + _get);
    String _plus_1 = (_plus + "__");
    String _get_1 = parts[1];
    return (_plus_1 + _get_1);
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
   * helper method to determine whether this state machine uses handler transitions
   * points at all
   * 
   * @param xpax the {@link GraphContainer}
   * @return <code>true</code> if the state machine uses handler transition points
   */
  public boolean usesHandlerTrPoints(final GraphContainer gc) {
    final Function1<Node, Boolean> _function = (Node t) -> {
      StateGraphNode _stateGraphNode = t.getStateGraphNode();
      return Boolean.valueOf(((TransitionPoint) _stateGraphNode).isHandler());
    };
    boolean _isEmpty = IteratorExtensions.isEmpty(IteratorExtensions.<Node>filter(FsmGenExtensions.getAllTransitionPointNodes(gc.getGraph()), _function));
    return (!_isEmpty);
  }
  
  public abstract String genTriggeredTransitionGuard(final Link link, final String trigger, final GraphContainer mc);
  
  public abstract String genGuardedTransitionGuard(final Link link, final String trigger, final GraphContainer mc);
  
  public abstract String genActionCodeMethod(final GraphContainer gc, final Link link, final boolean generateImplementation);
  
  public abstract String genActionCodeMethods(final GraphContainer gc, final Node node, final boolean generateImplementation);
}
