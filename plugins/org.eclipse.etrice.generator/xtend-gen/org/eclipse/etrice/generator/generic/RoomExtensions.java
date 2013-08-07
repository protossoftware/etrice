/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * collection of convenience functions for code generation
 */
@Singleton
@SuppressWarnings("all")
public class RoomExtensions {
  private static String genDir = "/src-gen/";
  
  private static String genInfoDir = "/src-gen-info/";
  
  private static String genDocDir = "/doc-gen/";
  
  public static String setDefaultGenDir() {
    String _genDir = RoomExtensions.genDir = "/src-gen/";
    return _genDir;
  }
  
  public static String setDefaultGenInfoDir() {
    String _genInfoDir = RoomExtensions.genInfoDir = "/src-gen-info/";
    return _genInfoDir;
  }
  
  public static String setDefaultGenDocDir() {
    String _genDocDir = RoomExtensions.genDocDir = "/doc-gen/";
    return _genDocDir;
  }
  
  public static String setGenDir(final String dir) {
    String _plus = ("/" + dir);
    String _plus_1 = (_plus + "/");
    String _genDir = RoomExtensions.genDir = _plus_1;
    return _genDir;
  }
  
  public static String setGenInfoDir(final String dir) {
    String _plus = ("/" + dir);
    String _plus_1 = (_plus + "/");
    String _genInfoDir = RoomExtensions.genInfoDir = _plus_1;
    return _genInfoDir;
  }
  
  public static String setGenDocDir(final String dir) {
    String _plus = ("/" + dir);
    String _plus_1 = (_plus + "/");
    String _genDocDir = RoomExtensions.genDocDir = _plus_1;
    return _genDocDir;
  }
  
  /**
   * the template type is T
   * @param l an iterable of type T
   * @param e a single element of type T
   * @return the union of the iterable and the element as new list
   */
  public <T extends Object> List<T> union(final Iterable<T> l, final T e) {
    ArrayList<T> _arrayList = new ArrayList<T>();
    ArrayList<T> ret = _arrayList;
    Iterables.<T>addAll(ret, l);
    ret.add(e);
    return ret;
  }
  
  /**
   * the template type is T
   * @param l1 an iterable of type T
   * @param l2 a second iterable of type T
   * @return the union of the two iterables as new list
   */
  public <T extends Object> List<T> union(final Iterable<T> l1, final Iterable<T> l2) {
    ArrayList<T> _arrayList = new ArrayList<T>();
    ArrayList<T> ret = _arrayList;
    Iterables.<T>addAll(ret, l1);
    Iterables.<T>addAll(ret, l2);
    return ret;
  }
  
  /**
   * a specialized version of {@link #union(Iterable, Iterable)}
   * @param l1 an iterable of type T
   * @param l2 a second iterable of type T
   * @return the union of the two iterables as new list
   */
  public List<Port> punion(final Iterable<Port> in1, final Iterable<ExternalPort> in2) {
    ArrayList<Port> _arrayList = new ArrayList<Port>();
    final ArrayList<Port> ret = _arrayList;
    final Procedure1<ExternalPort> _function = new Procedure1<ExternalPort>() {
        public void apply(final ExternalPort e) {
          Port _interfacePort = e.getInterfacePort();
          ret.add(_interfacePort);
        }
      };
    IterableExtensions.<ExternalPort>forEach(in2, _function);
    Iterables.<Port>addAll(ret, in1);
    return ret;
  }
  
  /**
   * the template type is T
   * @param l1 a list of elements of type T
   * @param l2 a second list of elements of type T
   * @return a new list with the contents of l1
   */
  public <T extends Object> List<T> minus(final List<T> l1, final List<T> l2) {
    ArrayList<T> _arrayList = new ArrayList<T>(l1);
    ArrayList<T> ret = _arrayList;
    ret.removeAll(l2);
    return ret;
  }
  
  /**
   * @return the relative path to the destination folder for the generated code
   */
  public String getGenerationPathSegment() {
    return RoomExtensions.genDir;
  }
  
  /**
   * @return the relative path to the destination folder for the generated code
   */
  public String getGenerationInfoSegment() {
    return RoomExtensions.genInfoDir;
  }
  
  /**
   * @return the relative path to the destination folder for the generated documentation
   */
  public String getDocGenerationPathSegment() {
    return RoomExtensions.genDocDir;
  }
  
  /**
   * @param e an {@link EObject}
   * @return the URI of the EObject's resource as file string
   * 		(or an empty string if no such resource exists)
   */
  public String getModelPath(final EObject e) {
    Resource res = e.eResource();
    boolean _equals = Objects.equal(res, null);
    if (_equals) {
      return "";
    } else {
      URI _uRI = res.getURI();
      return _uRI.toFileString();
    }
  }
  
  /**
   * @param rc a {@link RoomClass}
   * @return the name of the room model which also serves as a package name
   */
  public String getPackage(final RoomClass rc) {
    EObject _eContainer = rc.eContainer();
    return ((RoomModel) _eContainer).getName();
  }
  
  /**
   * @param rc a {@link RoomClass}
   * @return the name of the room model followed by the class name and all . replaced with _
   */
  public String getFullyQualifiedName(final RoomClass rc) {
    String _package = this.getPackage(rc);
    String _replace = _package.replace(".", "_");
    String _plus = (_replace + "_");
    String _name = rc.getName();
    String _plus_1 = (_plus + _name);
    return _plus_1;
  }
  
  /**
   * @param packageName a dot (.) separated package anem
   * @return the input with dots replaced with slashes (/)
   */
  public String getPathFromPackage(final String packageName) {
    String _replaceAll = packageName.replaceAll("\\.", "/");
    return (_replaceAll + "/");
  }
  
  /**
   * @param rc a {@link RoomClass}
   * @return the relative folder path of the package
   * 		(as defined by the Java convention)
   */
  public String getPath(final RoomClass rc) {
    String _package = this.getPackage(rc);
    String _pathFromPackage = this.getPathFromPackage(_package);
    return _pathFromPackage;
  }
  
  /**
   * @param e an {@link EObject}
   * @return the path of the Eclipse project containing the EObject's resource
   */
  public String getProjectPath(final EObject e) {
    final Resource res = e.eResource();
    boolean _equals = Objects.equal(res, null);
    if (_equals) {
      return "";
    } else {
      URI _uRI = res.getURI();
      String _fileString = _uRI.toFileString();
      File _file = new File(_fileString);
      File tmpf = _file;
      boolean _isFile = tmpf.isFile();
      boolean _not = (!_isFile);
      if (_not) {
        return "";
      }
      boolean isProject = false;
      boolean _dowhile = false;
      do {
        {
          File _parentFile = tmpf.getParentFile();
          tmpf = _parentFile;
          String[] contents = tmpf.list();
          for (final String f : contents) {
            boolean _equals_1 = f.equals(".project");
            if (_equals_1) {
              isProject = true;
            }
          }
        }
        boolean _and = false;
        boolean _not_1 = (!isProject);
        if (!_not_1) {
          _and = false;
        } else {
          File _parentFile = tmpf.getParentFile();
          boolean _notEquals = (!Objects.equal(_parentFile, null));
          _and = (_not_1 && _notEquals);
        }
        _dowhile = _and;
      } while(_dowhile);
      return tmpf.getAbsolutePath();
    }
  }
  
  /**
   * @param e an {@link EObject}
   * @return the concatenation of the object's project path
   * 		with the {@link #getGenerationPathSegment()}
   */
  public String getGenerationTargetPath(final EObject e) {
    String _projectPath = this.getProjectPath(e);
    String _generationPathSegment = this.getGenerationPathSegment();
    return (_projectPath + _generationPathSegment);
  }
  
  /**
   * @param e an {@link EObject}
   * @return the concatenation of the object's project path
   * 		with the {@link #getGenerationInfoSegment()}
   */
  public String getGenerationInfoPath(final EObject e) {
    String _projectPath = this.getProjectPath(e);
    String _generationInfoSegment = this.getGenerationInfoSegment();
    return (_projectPath + _generationInfoSegment);
  }
  
  /**
   * @param e an {@link EObject}
   * @return the concatenation of the objects project path
   * 		with the {@link #getDocGenerationPathSegment()}
   */
  public String getDocGenerationTargetPath(final EObject e) {
    String _projectPath = this.getProjectPath(e);
    String _docGenerationPathSegment = this.getDocGenerationPathSegment();
    return (_projectPath + _docGenerationPathSegment);
  }
  
  /**
   * makes a valid identifier from a path string
   * @param path a slash (/) separated path
   * @return the path with slashes replaced by underscores (_)
   */
  public String getPathName(final String path) {
    String _replaceAll = path.replaceAll("/", "_");
    return _replaceAll;
  }
  
  /**
   * @param p a {@link Port}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final Port p) {
    String _xifexpression = null;
    GeneralProtocolClass _protocol = p.getProtocol();
    if ((_protocol instanceof ProtocolClass)) {
      GeneralProtocolClass _protocol_1 = p.getProtocol();
      boolean _isConjugated = p.isConjugated();
      boolean _isReplicated = p.isReplicated();
      String _portClassName = this.getPortClassName(((ProtocolClass) _protocol_1), _isConjugated, _isReplicated);
      _xifexpression = _portClassName;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  /**
   * @param p a {@link ExternalPort}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final ExternalPort p) {
    Port _interfacePort = p.getInterfacePort();
    return this.getPortClassName(_interfacePort);
  }
  
  /**
   * @param sap a {@link SAP}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final SAP sap) {
    ProtocolClass _protocol = sap.getProtocol();
    return this.getPortClassName(_protocol, true);
  }
  
  /**
   * @param spp a {@link SPP}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final SPP spp) {
    ProtocolClass _protocol = spp.getProtocol();
    return this.getPortClassName(_protocol, false, true);
  }
  
  /**
   * @param svc a {@link ServiceImplementation}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final ServiceImplementation svc) {
    SPP _spp = svc.getSpp();
    ProtocolClass _protocol = _spp.getProtocol();
    return this.getPortClassName(_protocol, false, true);
  }
  
  /**
   * @param p a {@link ProtocolClass}
   * @param conj if <code>true</code> consider conjugate port, else regular
   * @return a name for the associated port class
   */
  public String getPortClassName(final ProtocolClass p, final boolean conj) {
    String _portClassName = this.getPortClassName(p, conj, false);
    return _portClassName;
  }
  
  /**
   * @param p a {@link ProtocolClass}
   * @param conj if <code>true</code> consider conjugate port, else regular
   * @param repl if <code>true</code> class name for replicated port
   * 		else for plain port
   * @return a name for the associated port class
   */
  public String getPortClassName(final ProtocolClass p, final boolean conj, final boolean repl) {
    String _name = p.getName();
    String _xifexpression = null;
    if (conj) {
      _xifexpression = "Conj";
    } else {
      _xifexpression = "";
    }
    String _plus = (_name + _xifexpression);
    String _xifexpression_1 = null;
    if (repl) {
      _xifexpression_1 = "Repl";
    } else {
      _xifexpression_1 = "";
    }
    String _plus_1 = (_plus + _xifexpression_1);
    String _plus_2 = (_plus_1 + "Port");
    return _plus_2;
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired {@link PortClass}
   * @return the port class
   */
  public PortClass getPortClass(final ProtocolClass pc, final boolean conj) {
    if (conj) {
      return pc.getConjugated();
    } else {
      return pc.getRegular();
    }
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired communication direction
   * @return <code>true</code> if a send handler is specified for this direction
   */
  public boolean handlesSend(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return false;
    } else {
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        List<Message> _allMessages = RoomHelpers.getAllMessages(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _allMessages.contains(_msg);
        if (_contains) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired communication direction
   * @return <code>true</code> if a receive handler is specified for this direction
   */
  public boolean handlesReceive(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return false;
    } else {
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        boolean _not = (!conj);
        List<Message> _allMessages = RoomHelpers.getAllMessages(pc, _not);
        Message _msg = hdlr.getMsg();
        boolean _contains = _allMessages.contains(_msg);
        if (_contains) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * @param iii an {@link InterfaceItemInstance}
   * @return <code>true</code> if the interface item instance is logically conjugate
   */
  public boolean isConjugated(final InterfaceItemInstance iii) {
    if ((iii instanceof PortInstance)) {
      Port _port = ((PortInstance) iii).getPort();
      return _port.isConjugated();
    } else {
      if ((iii instanceof SAPInstance)) {
        return true;
      } else {
        if ((iii instanceof ServiceImplInstance)) {
          return false;
        } else {
          return false;
        }
      }
    }
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired communication direction
   * @return a list of defined receive {@link MessageHandler} for this direction
   */
  public List<MessageHandler> getReceiveHandlers(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      ArrayList<MessageHandler> _arrayList = new ArrayList<MessageHandler>();
      return _arrayList;
    } else {
      ArrayList<MessageHandler> _arrayList_1 = new ArrayList<MessageHandler>();
      ArrayList<MessageHandler> res = _arrayList_1;
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        boolean _not = (!conj);
        List<Message> _allMessages = RoomHelpers.getAllMessages(pc, _not);
        Message _msg = hdlr.getMsg();
        boolean _contains = _allMessages.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
      return res;
    }
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired communication direction
   * @return a list of defined send {@link MessageHandler} for this direction
   */
  public List<MessageHandler> getSendHandlers(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      ArrayList<MessageHandler> _arrayList = new ArrayList<MessageHandler>();
      return _arrayList;
    } else {
      ArrayList<MessageHandler> _arrayList_1 = new ArrayList<MessageHandler>();
      ArrayList<MessageHandler> res = _arrayList_1;
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        List<Message> _allMessages = RoomHelpers.getAllMessages(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _allMessages.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
      return res;
    }
  }
  
  /**
   * @param m a {@link Message}
   * @param conj flag indicating the desired communication direction
   * @return a send {@link MessageHandler} for this direction if it is defined, <code>null</code> else
   */
  public MessageHandler getSendHandler(final Message m, final boolean conj) {
    EObject _eContainer = m.eContainer();
    List<MessageHandler> _sendHandlers = this.getSendHandlers(((ProtocolClass) _eContainer), conj);
    final Function1<MessageHandler,Boolean> _function = new Function1<MessageHandler,Boolean>() {
        public Boolean apply(final MessageHandler e) {
          Message _msg = e.getMsg();
          boolean _equals = Objects.equal(_msg, m);
          return Boolean.valueOf(_equals);
        }
      };
    return IterableExtensions.<MessageHandler>findFirst(_sendHandlers, _function);
  }
  
  /**
   * @param m a {@link Message}
   * @return <code>true</code> if this message is an incoming message
   */
  public boolean isIncoming(final Message m) {
    EObject _eContainer = m.eContainer();
    List<Message> _allIncomingMessages = RoomHelpers.getAllIncomingMessages(((ProtocolClass) _eContainer));
    return _allIncomingMessages.contains(m);
  }
  
  /**
   * @param m a {@link Message}
   * @return a string that can be used as identifier for the message. It is prefixed with IN_ or OUT_
   * 		to avoid ambiguities
   */
  public String getCodeName(final Message m) {
    boolean _isIncoming = this.isIncoming(m);
    if (_isIncoming) {
      String _name = m.getName();
      return ("IN_" + _name);
    } else {
      String _name_1 = m.getName();
      return ("OUT_" + _name_1);
    }
  }
  
  /**
   * @param states a list of {@link State}s
   * @return a list ordered such that leaf states are last
   */
  public List<State> getLeafStatesLast(final List<State> states) {
    List<State> _xblockexpression = null;
    {
      final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
          public Boolean apply(final State s) {
            boolean _isLeaf = RoomHelpers.isLeaf(s);
            return Boolean.valueOf(_isLeaf);
          }
        };
      final Iterable<State> leaf = IterableExtensions.<State>filter(states, _function);
      final Function1<State,Boolean> _function_1 = new Function1<State,Boolean>() {
          public Boolean apply(final State s) {
            boolean _isLeaf = RoomHelpers.isLeaf(s);
            boolean _not = (!_isLeaf);
            return Boolean.valueOf(_not);
          }
        };
      final Iterable<State> nonLeaf = IterableExtensions.<State>filter(states, _function_1);
      List<State> _union = this.<State>union(nonLeaf, leaf);
      _xblockexpression = (_union);
    }
    return _xblockexpression;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return a list of all leaf states
   */
  public List<State> getAllLeafStates(final ActorClass ac) {
    StateGraph _stateMachine = ac.getStateMachine();
    List<State> _leafStateList = RoomHelpers.getLeafStateList(_stateMachine);
    return _leafStateList;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return a list of simple states with leaf states last
   */
  public List<State> getAllBaseStatesLeavesLast(final ActorClass ac) {
    List<State> _allBaseStates = RoomHelpers.getAllBaseStates(ac);
    List<State> _leafStatesLast = this.getLeafStatesLast(_allBaseStates);
    return _leafStatesLast;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return <code>true</code> if an operation named 'stop' is defined with a void argument list and
   * 		void return type
   */
  public boolean overridesStop(final ActorClass ac) {
    boolean _or = false;
    EList<StandardOperation> _operations = ac.getOperations();
    final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
        public Boolean apply(final StandardOperation e) {
          boolean _and = false;
          boolean _and_1 = false;
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, "stop");
          if (!_equals) {
            _and_1 = false;
          } else {
            EList<VarDecl> _arguments = e.getArguments();
            boolean _isEmpty = _arguments.isEmpty();
            _and_1 = (_equals && _isEmpty);
          }
          if (!_and_1) {
            _and = false;
          } else {
            RefableType _returnType = e.getReturnType();
            boolean _equals_1 = Objects.equal(_returnType, null);
            _and = (_and_1 && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    boolean _exists = IterableExtensions.<StandardOperation>exists(_operations, _function);
    if (_exists) {
      _or = true;
    } else {
      boolean _and = false;
      ActorClass _base = ac.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (!_notEquals) {
        _and = false;
      } else {
        ActorClass _base_1 = ac.getBase();
        boolean _overridesStop = this.overridesStop(_base_1);
        _and = (_notEquals && _overridesStop);
      }
      _or = (_exists || _and);
    }
    return _or;
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return the number of all inherited states
   */
  public int getNumberOfInheritedStates(final ActorClass ac) {
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ActorClass _base_1 = ac.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _stateList = RoomHelpers.getStateList(_stateMachine);
      int _size = _stateList.size();
      ActorClass _base_2 = ac.getBase();
      int _numberOfInheritedStates = this.getNumberOfInheritedStates(_base_2);
      return (_size + _numberOfInheritedStates);
    }
  }
  
  /**
   * @param ac an {@link ActorClass}
   * @return the number of all inherited base (or simple) states
   */
  public int getNumberOfInheritedBaseStates(final ActorClass ac) {
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ActorClass _base_1 = ac.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _baseStateList = RoomHelpers.getBaseStateList(_stateMachine);
      int _size = _baseStateList.size();
      ActorClass _base_2 = ac.getBase();
      int _numberOfInheritedBaseStates = this.getNumberOfInheritedBaseStates(_base_2);
      return (_size + _numberOfInheritedBaseStates);
    }
  }
  
  /**
   * @param ac an {@link ExpandedActorClass}
   * @param s a {@link State}
   * @return a list of {@link Transition}s starting at the state and going up in the hierarchy
   * 		following the logic of evaluation of firing conditions
   */
  public List<Transition> getOutgoingTransitionsHierarchical(final ExpandedActorClass ac, final State s) {
    ArrayList<Transition> _arrayList = new ArrayList<Transition>();
    ArrayList<Transition> result = _arrayList;
    EList<Transition> _outgoingTransitions = ac.getOutgoingTransitions(s);
    result.addAll(_outgoingTransitions);
    EObject _eContainer = s.eContainer();
    StateGraph sg = ((StateGraph) _eContainer);
    EList<TrPoint> _trPoints = sg.getTrPoints();
    for (final TrPoint tp : _trPoints) {
      if ((tp instanceof TransitionPoint)) {
        EList<Transition> _outgoingTransitions_1 = ac.getOutgoingTransitions(tp);
        result.addAll(_outgoingTransitions_1);
      }
    }
    EObject _eContainer_1 = sg.eContainer();
    if ((_eContainer_1 instanceof State)) {
      EObject _eContainer_2 = sg.eContainer();
      List<Transition> _outgoingTransitionsHierarchical = this.getOutgoingTransitionsHierarchical(ac, ((State) _eContainer_2));
      result.addAll(_outgoingTransitionsHierarchical);
    }
    return result;
  }
  
  public BasicEList<AbstractInstance> getAllSubInstances(final StructureInstance ssi) {
    BasicEList<AbstractInstance> _basicEList = new BasicEList<AbstractInstance>();
    final BasicEList<AbstractInstance> result = _basicEList;
    final TreeIterator<EObject> it = ssi.eAllContents();
    boolean _hasNext = it.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        final EObject obj = it.next();
        if ((obj instanceof AbstractInstance)) {
          result.add(((AbstractInstance) obj));
        }
      }
      boolean _hasNext_1 = it.hasNext();
      _while = _hasNext_1;
    }
    return result;
  }
  
  public String getPortClassName(final EObject p) {
    if (p instanceof Port) {
      return _getPortClassName((Port)p);
    } else if (p instanceof SAP) {
      return _getPortClassName((SAP)p);
    } else if (p instanceof SPP) {
      return _getPortClassName((SPP)p);
    } else if (p instanceof ExternalPort) {
      return _getPortClassName((ExternalPort)p);
    } else if (p instanceof ServiceImplementation) {
      return _getPortClassName((ServiceImplementation)p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p).toString());
    }
  }
}
