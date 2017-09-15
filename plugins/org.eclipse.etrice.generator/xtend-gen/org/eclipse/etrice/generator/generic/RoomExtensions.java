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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
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
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.generic.FSMExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * collection of convenience functions for code generation
 */
@Singleton
@SuppressWarnings("all")
public class RoomExtensions extends FSMExtensions {
  public final String NEWLINE = System.getProperty("line.separator");
  
  private static String genDir = "/src-gen/";
  
  private static String genInfoDir = "/src-gen-info/";
  
  private static String genDocDir = "/doc-gen/";
  
  @Inject
  @Extension
  protected RoomHelpers _roomHelpers;
  
  public static String setDefaultGenDir() {
    return RoomExtensions.genDir = "/src-gen/";
  }
  
  public static String setDefaultGenInfoDir() {
    return RoomExtensions.genInfoDir = "/src-gen-info/";
  }
  
  public static String setDefaultGenDocDir() {
    return RoomExtensions.genDocDir = "/doc-gen/";
  }
  
  public static String setGenDir(final String dir) {
    return RoomExtensions.genDir = (("/" + dir) + "/");
  }
  
  public static String setGenInfoDir(final String dir) {
    return RoomExtensions.genInfoDir = (("/" + dir) + "/");
  }
  
  public static String setGenDocDir(final String dir) {
    return RoomExtensions.genDocDir = (("/" + dir) + "/");
  }
  
  /**
   * a specialized version of {@link #union(Iterable, Iterable)}
   * @param in1 an iterable of type T
   * @param in2 a second iterable of type T
   * @return the union of the two iterables as new list
   */
  public List<Port> punion(final Iterable<Port> in1, final Iterable<ExternalPort> in2) {
    final ArrayList<Port> ret = new ArrayList<Port>();
    final Procedure1<ExternalPort> _function = new Procedure1<ExternalPort>() {
      @Override
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
    return (_plus + _name);
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
    return this.getPathFromPackage(_package);
  }
  
  /**
   * @param e an {@link EObject}
   * @return the path of the Eclipse project containing the EObject's resource
   */
  public String getProjectPath(final EObject e) {
    final URI res = FileSystemHelpers.getProjectURI(e);
    boolean _equals = Objects.equal(res, null);
    if (_equals) {
      return "";
    }
    return res.toFileString();
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
   * @return the path with slashes (and colons as in replicated actors) replaced by underscores (_)
   */
  public String getPathName(final String path) {
    String _replaceAll = path.replaceAll("/", "_");
    return _replaceAll.replaceAll(":", "_");
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
      _xifexpression = this.getPortClassName(((ProtocolClass) _protocol_1), _isConjugated, _isReplicated);
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
    return this.getPortClassName(p, conj, false);
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
    return (_plus_1 + "Port");
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
   * @param conj flag indicating the desired {@link PortClass}
   * @return the port class
   */
  public List<PortClass> getAllPortClasses(final ProtocolClass pc, final boolean conj) {
    final ArrayList<PortClass> result = CollectionLiterals.<PortClass>newArrayList();
    ProtocolClass protocol = pc;
    while ((!Objects.equal(protocol, null))) {
      {
        if (conj) {
          PortClass _conjugated = protocol.getConjugated();
          boolean _notEquals = (!Objects.equal(_conjugated, null));
          if (_notEquals) {
            PortClass _conjugated_1 = protocol.getConjugated();
            result.add(_conjugated_1);
          }
        } else {
          PortClass _regular = protocol.getRegular();
          boolean _notEquals_1 = (!Objects.equal(_regular, null));
          if (_notEquals_1) {
            PortClass _regular_1 = protocol.getRegular();
            result.add(_regular_1);
          }
        }
        ProtocolClass _base = protocol.getBase();
        protocol = _base;
      }
    }
    return result;
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
      final List<Message> allMessages = this._roomHelpers.getAllMessages(pc, conj);
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMessages.contains(_msg);
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
      final List<Message> allMessages = this._roomHelpers.getAllMessages(pc, (!conj));
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMessages.contains(_msg);
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
   * @return <code>true</code> if a receive handler is specified for this direction including base classes
   */
  public boolean handlesReceiveIncludingSuper(final ProtocolClass pc, final boolean conj) {
    final List<PortClass> allPortClasses = this.getAllPortClasses(pc, conj);
    final List<Message> allMessages = this._roomHelpers.getAllMessages(pc, (!conj));
    for (final PortClass p : allPortClasses) {
      EList<MessageHandler> _msgHandlers = p.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMessages.contains(_msg);
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
    final ArrayList<MessageHandler> res = new ArrayList<MessageHandler>();
    PortClass _portClass = this.getPortClass(pc, conj);
    boolean _notEquals = (!Objects.equal(_portClass, null));
    if (_notEquals) {
      final List<Message> allMessages = this._roomHelpers.getAllMessages(pc, (!conj));
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMessages.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
    }
    return res;
  }
  
  /**
   * @param pc a {@link ProtocolClass}
   * @param conj flag indicating the desired communication direction
   * @return a list of defined receive {@link MessageHandler} for this direction including base classes
   */
  public List<MessageHandler> getReceiveHandlersIncludingSuper(final ProtocolClass pc, final boolean conj) {
    final ArrayList<MessageHandler> res = new ArrayList<MessageHandler>();
    final List<PortClass> allPortClasses = this.getAllPortClasses(pc, conj);
    final List<Message> allMsgs = this._roomHelpers.getAllMessages(pc, (!conj));
    for (final PortClass p : allPortClasses) {
      EList<MessageHandler> _msgHandlers = p.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMsgs.contains(_msg);
        if (_contains) {
          res.add(hdlr);
        }
      }
    }
    return res;
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
      return Collections.<MessageHandler>emptyList();
    } else {
      final ArrayList<MessageHandler> res = new ArrayList<MessageHandler>();
      final List<Message> allMessages = this._roomHelpers.getAllMessages(pc, conj);
      PortClass _portClass_1 = this.getPortClass(pc, conj);
      EList<MessageHandler> _msgHandlers = _portClass_1.getMsgHandlers();
      List<MessageHandler> _safeList = RoomExtensions.getSafeList(_msgHandlers);
      for (final MessageHandler hdlr : _safeList) {
        Message _msg = hdlr.getMsg();
        boolean _contains = allMessages.contains(_msg);
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
    final Function1<MessageHandler, Boolean> _function = new Function1<MessageHandler, Boolean>() {
      @Override
      public Boolean apply(final MessageHandler e) {
        Message _msg = e.getMsg();
        return Boolean.valueOf(Objects.equal(_msg, m));
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
    List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(((ProtocolClass) _eContainer));
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
   * @param ac an {@link ActorClass}
   * @return <code>true</code> if an operation named 'stop' is defined with a void argument list and
   * 		void return type
   */
  public boolean overridesStop(final ActorClass ac) {
    return (IterableExtensions.<StandardOperation>exists(ac.getOperations(), new Function1<StandardOperation, Boolean>() {
      @Override
      public Boolean apply(final StandardOperation e) {
        return Boolean.valueOf(((Objects.equal(e.getName(), "stop") && e.getArguments().isEmpty()) && Objects.equal(e.getReturnType(), null)));
      }
    }) || ((!Objects.equal(ac.getActorBase(), null)) && this.overridesStop(ac.getActorBase())));
  }
  
  public BasicEList<AbstractInstance> getAllSubInstances(final StructureInstance ssi) {
    final BasicEList<AbstractInstance> result = new BasicEList<AbstractInstance>();
    final TreeIterator<EObject> it = ssi.eAllContents();
    while (it.hasNext()) {
      {
        final EObject obj = it.next();
        if ((obj instanceof AbstractInstance)) {
          result.add(((AbstractInstance) obj));
        }
      }
    }
    return result;
  }
  
  public static List<MessageHandler> getSafeList(final List<MessageHandler> msgHandlers) {
    List<MessageHandler> _xifexpression = null;
    boolean _equals = Objects.equal(msgHandlers, null);
    if (_equals) {
      _xifexpression = Collections.<MessageHandler>emptyList();
    } else {
      _xifexpression = msgHandlers;
    }
    return _xifexpression;
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
