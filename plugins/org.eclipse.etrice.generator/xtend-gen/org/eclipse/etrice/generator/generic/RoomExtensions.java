package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * collection of convenience functions for code generation
 */
@Singleton
@SuppressWarnings("all")
public class RoomExtensions {
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
          Port _ifport = e.getIfport();
          ret.add(_ifport);
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
    return "/src-gen/";
  }
  
  /**
   * @return the relative path to the destination folder for the generated documentation
   */
  public String getDocGenerationPathSegment() {
    return "/doc-gen/";
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
   * @return the concatenation of the objects project path
   * 		with the {@link #getGenerationPathSegment()}
   */
  public String getGenerationTargetPath(final EObject e) {
    String _projectPath = this.getProjectPath(e);
    String _generationPathSegment = this.getGenerationPathSegment();
    return (_projectPath + _generationPathSegment);
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
    Port _ifport = p.getIfport();
    return this.getPortClassName(_ifport);
  }
  
  /**
   * @param sap a {@link SAPRef}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final SAPRef sap) {
    ProtocolClass _protocol = sap.getProtocol();
    return this.getPortClassName(_protocol, true);
  }
  
  /**
   * @param spp a {@link SPPRef}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final SPPRef spp) {
    ProtocolClass _protocol = spp.getProtocol();
    return this.getPortClassName(_protocol, false, true);
  }
  
  /**
   * @param svc a {@link ServiceImplementation}
   * @return a name for the associated port class
   */
  protected String _getPortClassName(final ServiceImplementation svc) {
    SPPRef _spp = svc.getSpp();
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
  
  public List<Message> getAllIncomingMessages(final ProtocolClass pc) {
    ProtocolClass _base = pc.getBase();
    boolean _notEquals = (!Objects.equal(_base, null));
    if (_notEquals) {
      ProtocolClass _base_1 = pc.getBase();
      List<Message> _allIncomingMessages = this.getAllIncomingMessages(_base_1);
      EList<Message> _incomingMessages = pc.getIncomingMessages();
      return this.<Message>union(_allIncomingMessages, _incomingMessages);
    } else {
      return pc.getIncomingMessages();
    }
  }
  
  public List<Message> getAllOutgoingMessages(final ProtocolClass pc) {
    EList<Message> _xifexpression = null;
    ProtocolClass _base = pc.getBase();
    boolean _notEquals = (!Objects.equal(_base, null));
    if (_notEquals) {
      ProtocolClass _base_1 = pc.getBase();
      List<Message> _allOutgoingMessages = this.getAllOutgoingMessages(_base_1);
      EList<Message> _outgoingMessages = pc.getOutgoingMessages();
      return this.<Message>union(_allOutgoingMessages, _outgoingMessages);
    } else {
      EList<Message> _outgoingMessages_1 = pc.getOutgoingMessages();
      _xifexpression = _outgoingMessages_1;
    }
    return _xifexpression;
  }
  
  public List<Message> getIncoming(final ProtocolClass pc, final boolean conj) {
    if (conj) {
      return this.getAllOutgoingMessages(pc);
    } else {
      return this.getAllIncomingMessages(pc);
    }
  }
  
  public List<Message> getOutgoing(final ProtocolClass pc, final boolean conj) {
    if (conj) {
      return this.getAllIncomingMessages(pc);
    } else {
      return this.getAllOutgoingMessages(pc);
    }
  }
  
  public List<Message> getIncoming(final InterfaceItem p) {
    List<Message> _xifexpression = null;
    ProtocolClass _protocol = RoomHelpers.getProtocol(p);
    boolean _notEquals = (!Objects.equal(_protocol, null));
    if (_notEquals) {
      ProtocolClass _protocol_1 = RoomHelpers.getProtocol(p);
      boolean _isConjugated = this.isConjugated(p);
      List<Message> _incoming = this.getIncoming(_protocol_1, _isConjugated);
      _xifexpression = _incoming;
    } else {
      List<Message> _emptyList = Collections.<Message>emptyList();
      _xifexpression = _emptyList;
    }
    return _xifexpression;
  }
  
  public List<Message> getOutgoing(final InterfaceItem p) {
    List<Message> _xifexpression = null;
    ProtocolClass _protocol = RoomHelpers.getProtocol(p);
    boolean _notEquals = (!Objects.equal(_protocol, null));
    if (_notEquals) {
      ProtocolClass _protocol_1 = RoomHelpers.getProtocol(p);
      boolean _isConjugated = this.isConjugated(p);
      List<Message> _outgoing = this.getOutgoing(_protocol_1, _isConjugated);
      _xifexpression = _outgoing;
    } else {
      List<Message> _emptyList = Collections.<Message>emptyList();
      _xifexpression = _emptyList;
    }
    return _xifexpression;
  }
  
  public boolean isOnlyOutgoing(final InterfaceItem p) {
    List<Message> _incoming = this.getIncoming(p);
    boolean _isEmpty = _incoming.isEmpty();
    return _isEmpty;
  }
  
  public boolean isOnlyIncoming(final InterfaceItem p) {
    List<Message> _outgoing = this.getOutgoing(p);
    boolean _isEmpty = _outgoing.isEmpty();
    return _isEmpty;
  }
  
  public PortClass getPortClass(final ProtocolClass pc, final boolean conj) {
    if (conj) {
      return pc.getConjugate();
    } else {
      return pc.getRegular();
    }
  }
  
  public boolean handlesSend(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return false;
    } else {
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        List<Message> _outgoing = this.getOutgoing(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _outgoing.contains(_msg);
        if (_contains) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean handlesReceive(final ProtocolClass pc, final boolean conj) {
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return false;
    } else {
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      for (final MessageHandler hdlr : _msgHandlers) {
        List<Message> _incoming = this.getIncoming(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _incoming.contains(_msg);
        if (_contains) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isConjugated(final InterfaceItem iii) {
    if ((iii instanceof Port)) {
      return ((Port) iii).isConjugated();
    } else {
      if ((iii instanceof SAPRef)) {
        return true;
      } else {
        if ((iii instanceof SPPRef)) {
          return false;
        } else {
          return false;
        }
      }
    }
  }
  
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
        List<Message> _incoming = this.getIncoming(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _incoming.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
      return res;
    }
  }
  
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
        List<Message> _outgoing = this.getOutgoing(pc, conj);
        Message _msg = hdlr.getMsg();
        boolean _contains = _outgoing.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
      return res;
    }
  }
  
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
  
  public boolean isIncoming(final Message m) {
    EObject _eContainer = m.eContainer();
    List<Message> _allIncomingMessages = this.getAllIncomingMessages(((ProtocolClass) _eContainer));
    return _allIncomingMessages.contains(m);
  }
  
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
  
  public boolean isLeaf(final State s) {
    StateGraph _subgraph = s.getSubgraph();
    boolean _equals = Objects.equal(_subgraph, null);
    return _equals;
  }
  
  public List<State> getLeafStateList(final StateGraph sg) {
    ArrayList<State> _arrayList = new ArrayList<State>();
    ArrayList<State> res = _arrayList;
    boolean _notEquals = (!Objects.equal(sg, null));
    if (_notEquals) {
      EList<State> _states = sg.getStates();
      for (final State s : _states) {
        List<State> _leafStateList = this.getLeafStateList(s);
        res.addAll(_leafStateList);
      }
    }
    return res;
  }
  
  public List<State> getLeafStateList(final State s) {
    boolean _isLeaf = this.isLeaf(s);
    if (_isLeaf) {
      ArrayList<State> _arrayList = new ArrayList<State>();
      ArrayList<State> res = _arrayList;
      res.add(s);
      return res;
    } else {
      StateGraph _subgraph = s.getSubgraph();
      return this.getLeafStateList(_subgraph);
    }
  }
  
  public List<State> getStateList(final StateGraph sg) {
    ArrayList<State> _arrayList = new ArrayList<State>();
    ArrayList<State> ret = _arrayList;
    boolean _notEquals = (!Objects.equal(sg, null));
    if (_notEquals) {
      EList<State> _states = sg.getStates();
      for (final State e : _states) {
        {
          ret.add(e);
          StateGraph _subgraph = e.getSubgraph();
          boolean _notEquals_1 = (!Objects.equal(_subgraph, null));
          if (_notEquals_1) {
            StateGraph _subgraph_1 = e.getSubgraph();
            List<State> _stateList = this.getStateList(_subgraph_1);
            ret.addAll(_stateList);
          }
        }
      }
    }
    return ret;
  }
  
  public List<State> getBaseStateList(final StateGraph sg) {
    ArrayList<State> _arrayList = new ArrayList<State>();
    ArrayList<State> ret = _arrayList;
    boolean _notEquals = (!Objects.equal(sg, null));
    if (_notEquals) {
      List<State> _stateList = this.getStateList(sg);
      for (final State e : _stateList) {
        if ((e instanceof SimpleState)) {
          ret.add(e);
        }
      }
    }
    return ret;
  }
  
  public ArrayList<State> getLeafStatesLast(final List<State> states) {
    ArrayList<State> _arrayList = new ArrayList<State>();
    ArrayList<State> leaf = _arrayList;
    ArrayList<State> _arrayList_1 = new ArrayList<State>();
    ArrayList<State> nonLeaf = _arrayList_1;
    for (final State state : states) {
      boolean _isLeaf = this.isLeaf(state);
      if (_isLeaf) {
        leaf.add(state);
      } else {
        nonLeaf.add(state);
      }
    }
    nonLeaf.addAll(leaf);
    return nonLeaf;
  }
  
  public List<State> getAllBaseStates(final ActorClass ac) {
    List<State> _xifexpression = null;
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      StateGraph _stateMachine = ac.getStateMachine();
      return this.getBaseStateList(_stateMachine);
    } else {
      ActorClass _base_1 = ac.getBase();
      List<State> _allBaseStates = this.getAllBaseStates(_base_1);
      StateGraph _stateMachine_1 = ac.getStateMachine();
      List<State> _baseStateList = this.getBaseStateList(_stateMachine_1);
      List<State> _union = this.<State>union(_allBaseStates, _baseStateList);
      _xifexpression = _union;
    }
    return _xifexpression;
  }
  
  public List<State> getAllBaseStatesLeavesLast(final ActorClass ac) {
    List<State> _xifexpression = null;
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      StateGraph _stateMachine = ac.getStateMachine();
      List<State> _baseStateList = this.getBaseStateList(_stateMachine);
      return this.getLeafStatesLast(_baseStateList);
    } else {
      ActorClass _base_1 = ac.getBase();
      List<State> _allBaseStates = this.getAllBaseStates(_base_1);
      ArrayList<State> _leafStatesLast = this.getLeafStatesLast(_allBaseStates);
      StateGraph _stateMachine_1 = ac.getStateMachine();
      List<State> _baseStateList_1 = this.getBaseStateList(_stateMachine_1);
      ArrayList<State> _leafStatesLast_1 = this.getLeafStatesLast(_baseStateList_1);
      List<State> _union = this.<State>union(_leafStatesLast, _leafStatesLast_1);
      _xifexpression = _union;
    }
    return _xifexpression;
  }
  
  public List<State> getAllLeafStates(final ActorClass ac) {
    List<State> _xifexpression = null;
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      StateGraph _stateMachine = ac.getStateMachine();
      return this.getLeafStateList(_stateMachine);
    } else {
      ActorClass _base_1 = ac.getBase();
      List<State> _allLeafStates = this.getAllLeafStates(_base_1);
      StateGraph _stateMachine_1 = ac.getStateMachine();
      List<State> _leafStateList = this.getLeafStateList(_stateMachine_1);
      List<State> _union = this.<State>union(_allLeafStates, _leafStateList);
      _xifexpression = _union;
    }
    return _xifexpression;
  }
  
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
            RefableType _returntype = e.getReturntype();
            boolean _equals_1 = Objects.equal(_returntype, null);
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
  
  public int getNumberOfInheritedStates(final ActorClass ac) {
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ActorClass _base_1 = ac.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _stateList = this.getStateList(_stateMachine);
      int _size = _stateList.size();
      ActorClass _base_2 = ac.getBase();
      int _numberOfInheritedStates = this.getNumberOfInheritedStates(_base_2);
      return (_size + _numberOfInheritedStates);
    }
  }
  
  public int getNumberOfInheritedBaseStates(final ActorClass ac) {
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      return 0;
    } else {
      ActorClass _base_1 = ac.getBase();
      StateGraph _stateMachine = _base_1.getStateMachine();
      List<State> _baseStateList = this.getBaseStateList(_stateMachine);
      int _size = _baseStateList.size();
      ActorClass _base_2 = ac.getBase();
      int _numberOfInheritedBaseStates = this.getNumberOfInheritedBaseStates(_base_2);
      return (_size + _numberOfInheritedBaseStates);
    }
  }
  
  public String getStateId(final State s) {
    return CodegenHelpers.getGenStateId(s);
  }
  
  public String getStatePathName(final State s) {
    return CodegenHelpers.getGenStatePathName(s);
  }
  
  public String getChainId(final TransitionChain t) {
    return CodegenHelpers.getGenChainId(t);
  }
  
  public boolean hasGuard(final Trigger tr) {
    boolean _and = false;
    boolean _and_1 = false;
    Guard _guard = tr.getGuard();
    boolean _notEquals = (!Objects.equal(_guard, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      Guard _guard_1 = tr.getGuard();
      DetailCode _guard_2 = _guard_1.getGuard();
      boolean _notEquals_1 = (!Objects.equal(_guard_2, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      Guard _guard_3 = tr.getGuard();
      DetailCode _guard_4 = _guard_3.getGuard();
      EList<String> _commands = _guard_4.getCommands();
      int _size = _commands.size();
      boolean _greaterThan = (_size > 0);
      _and = (_and_1 && _greaterThan);
    }
    return _and;
  }
  
  public boolean hasGuard(final ExpandedActorClass ac, final ActiveTrigger at) {
    boolean hasGuard = false;
    EList<TriggeredTransition> _transitions = at.getTransitions();
    for (final TriggeredTransition t : _transitions) {
      EList<Trigger> _triggers = t.getTriggers();
      final Function1<Trigger,Boolean> _function = new Function1<Trigger,Boolean>() {
          public Boolean apply(final Trigger e) {
            boolean _and = false;
            String _trigger = at.getTrigger();
            boolean _isMatching = ac.isMatching(e, _trigger);
            if (!_isMatching) {
              _and = false;
            } else {
              boolean _hasGuard = RoomExtensions.this.hasGuard(e);
              _and = (_isMatching && _hasGuard);
            }
            return Boolean.valueOf(_and);
          }
        };
      boolean _exists = IterableExtensions.<Trigger>exists(_triggers, _function);
      if (_exists) {
        hasGuard = true;
      }
    }
    return hasGuard;
  }
  
  public boolean empty(final DetailCode dc) {
    String _detailCode = RoomHelpers.getDetailCode(dc);
    boolean _equals = Objects.equal(_detailCode, "");
    return _equals;
  }
  
  public boolean hasEntryCode(final State s) {
    DetailCode _entryCode = s.getEntryCode();
    boolean _empty = this.empty(_entryCode);
    boolean _not = (!_empty);
    if (_not) {
      return true;
    }
    if ((s instanceof ExpandedRefinedState)) {
      DetailCode _inheritedEntry = ((ExpandedRefinedState) s).getInheritedEntry();
      boolean _empty_1 = this.empty(_inheritedEntry);
      return (!_empty_1);
    }
    return false;
  }
  
  public boolean hasExitCode(final State s) {
    DetailCode _exitCode = s.getExitCode();
    boolean _empty = this.empty(_exitCode);
    boolean _not = (!_empty);
    if (_not) {
      return true;
    }
    if ((s instanceof ExpandedRefinedState)) {
      DetailCode _inheritedExit = ((ExpandedRefinedState) s).getInheritedExit();
      boolean _empty_1 = this.empty(_inheritedExit);
      return (!_empty_1);
    }
    return false;
  }
  
  public boolean hasDoCode(final State s) {
    DetailCode _doCode = s.getDoCode();
    boolean _empty = this.empty(_doCode);
    boolean _not = (!_empty);
    if (_not) {
      return true;
    }
    if ((s instanceof ExpandedRefinedState)) {
      DetailCode _inheritedDo = ((ExpandedRefinedState) s).getInheritedDo();
      boolean _empty_1 = this.empty(_inheritedDo);
      return (!_empty_1);
    }
    return false;
  }
  
  public boolean hasActionCode(final Transition t) {
    boolean _and = false;
    DetailCode _action = t.getAction();
    boolean _notEquals = (!Objects.equal(_action, null));
    if (!_notEquals) {
      _and = false;
    } else {
      DetailCode _action_1 = t.getAction();
      EList<String> _commands = _action_1.getCommands();
      int _size = _commands.size();
      boolean _greaterThan = (_size > 0);
      _and = (_notEquals && _greaterThan);
    }
    return _and;
  }
  
  public String getContextId(final TransitionChain tc) {
    State _stateContext = tc.getStateContext();
    String _stateId = this.getStateId(_stateContext);
    return _stateId;
  }
  
  public Transition getInitTransition(final StateGraph sg) {
    EList<Transition> _transitions = sg.getTransitions();
    for (final Transition tr : _transitions) {
      if ((tr instanceof InitialTransition)) {
        return tr;
      }
    }
    return null;
  }
  
  public boolean hasInitTransition(final StateGraph sg) {
    EList<Transition> _transitions = sg.getTransitions();
    for (final Transition tr : _transitions) {
      if ((tr instanceof InitialTransition)) {
        return true;
      }
    }
    return false;
  }
  
  public List<Transition> getTransitionList(final State s) {
    boolean _isLeaf = this.isLeaf(s);
    if (_isLeaf) {
      ArrayList<Transition> _arrayList = new ArrayList<Transition>();
      return _arrayList;
    } else {
      StateGraph _subgraph = s.getSubgraph();
      return this.getTransitionList(_subgraph);
    }
  }
  
  public List<Transition> getTransitionList(final StateGraph sg) {
    EList<Transition> _transitions = sg.getTransitions();
    ArrayList<Transition> _arrayList = new ArrayList<Transition>(_transitions);
    ArrayList<Transition> res = _arrayList;
    EList<State> _states = sg.getStates();
    for (final State s : _states) {
      List<Transition> _transitionList = this.getTransitionList(s);
      res.addAll(_transitionList);
    }
    return res;
  }
  
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
  
  public String getPortClassName(final EObject p) {
    if (p instanceof Port) {
      return _getPortClassName((Port)p);
    } else if (p instanceof SAPRef) {
      return _getPortClassName((SAPRef)p);
    } else if (p instanceof SPPRef) {
      return _getPortClassName((SPPRef)p);
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
