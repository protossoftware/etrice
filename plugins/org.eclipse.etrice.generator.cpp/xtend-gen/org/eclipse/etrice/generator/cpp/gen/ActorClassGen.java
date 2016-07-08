/**
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 */
package org.eclipse.etrice.generator.cpp.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.cpp.gen.StateMachineGen;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private Initialization _initialization;
  
  @Inject
  @Extension
  private StateMachineGen _stateMachineGen;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    final Map<ActorClass, WiredActorClass> ac2wired = CollectionLiterals.<ActorClass, WiredActorClass>newHashMap();
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    Iterable<WiredActorClass> _filter = Iterables.<WiredActorClass>filter(_wiredInstances, WiredActorClass.class);
    final Procedure1<WiredActorClass> _function = new Procedure1<WiredActorClass>() {
      public void apply(final WiredActorClass it) {
        ActorClass _actorClass = it.getActorClass();
        ac2wired.put(_actorClass, it);
      }
    };
    IterableExtensions.<WiredActorClass>forEach(_filter, _function);
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    final Function1<ExpandedActorClass, Boolean> _function_1 = new Function1<ExpandedActorClass, Boolean>() {
      public Boolean apply(final ExpandedActorClass cl) {
        ActorClass _actorClass = cl.getActorClass();
        return Boolean.valueOf(ActorClassGen.this._fileSystemHelpers.isValidGenerationLocation(_actorClass));
      }
    };
    Iterable<ExpandedActorClass> _filter_1 = IterableExtensions.<ExpandedActorClass>filter(_xpActorClasses, _function_1);
    for (final ExpandedActorClass xpac : _filter_1) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        final WiredActorClass wired = ac2wired.get(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        final boolean manualBehavior = this._roomHelpers.isBehaviorAnnotationPresent(_actorClass_1, "BehaviorManual");
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass_2);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_3);
        final String path = (_generationTargetPath + _path);
        ActorClass _actorClass_4 = xpac.getActorClass();
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_actorClass_4);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String _path_1 = this._roomExtensions.getPath(_actorClass_5);
        final String infopath = (_generationInfoPath + _path_1);
        String _xifexpression = null;
        if (manualBehavior) {
          _xifexpression = "Abstract";
        } else {
          _xifexpression = "";
        }
        String file = _xifexpression;
        ActorClass _actorClass_6 = xpac.getActorClass();
        String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(_actorClass_6);
        String _plus = (file + _cppHeaderFileName);
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, xpac, wired, manualBehavior);
        this.fileIO.generateFile("generating ActorClass declaration", path, infopath, _plus, _generateHeaderFile);
        ActorClass _actorClass_7 = xpac.getActorClass();
        String _cppSourceFileName = this._cppExtensions.getCppSourceFileName(_actorClass_7);
        String _plus_1 = (file + _cppSourceFileName);
        CharSequence _generateSourceFile = this.generateSourceFile(root, xpac, wired, manualBehavior);
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, _plus_1, _generateSourceFile);
      }
    }
  }
  
  private CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired, final boolean manualBehavior) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      String _xifexpression = null;
      if (manualBehavior) {
        String _name = ac.getName();
        _xifexpression = ("Abstract" + _name);
      } else {
        _xifexpression = ac.getName();
      }
      final String clsname = _xifexpression;
      String _elvis = null;
      ActorClass _actorBase = ac.getActorBase();
      String _name_1 = null;
      if (_actorBase!=null) {
        _name_1=_actorBase.getName();
      }
      if (_name_1 != null) {
        _elvis = _name_1;
      } else {
        _elvis = "etRuntime::ActorClassBase";
      }
      final String rtBaseClassName = _elvis;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Header File of ActorClass ");
      _builder.append(clsname, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(clsname);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/IRTObject.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/PortBase.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/SubSystemClassBase.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/Address.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/IMessageReceiver.h\"");
      _builder.newLine();
      _builder.append("#include \"common/debugging/DebuggingService.h\"");
      _builder.newLine();
      _builder.append("#include <string>");
      _builder.newLine();
      _builder.append("#include <vector>");
      _builder.newLine();
      _builder.newLine();
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include \"");
          String _path = this._roomExtensions.getPath(pc);
          _builder.append(_path, "");
          String _name_2 = pc.getName();
          _builder.append(_name_2, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
        for(final DataClass dc : _referencedDataClasses) {
          _builder.append("#include \"");
          String _path_1 = this._roomExtensions.getPath(dc);
          _builder.append(_path_1, "");
          String _name_3 = dc.getName();
          _builder.append(_name_3, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        ActorClass _actorBase_1 = ac.getActorBase();
        boolean _equals = Objects.equal(_actorBase_1, null);
        if (_equals) {
          _builder.append("#include \"common/modelbase/ActorClassBase.h\"");
          _builder.newLine();
        } else {
          _builder.append("#include \"");
          ActorClass _actorBase_2 = ac.getActorBase();
          String _name_4 = _actorBase_2.getName();
          _builder.append(_name_4, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("using namespace etRuntime; //TODO JH remove");
      _builder.newLine();
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1, true);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      _builder.append(clsname, "");
      _builder.append(" : public ");
      _builder.append(rtBaseClassName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- ports");
      _builder.newLine();
      {
        List<Port> _endPorts = this._roomHelpers.getEndPorts(ac);
        for(final Port ep : _endPorts) {
          _builder.append("\t\t");
          String _portClassName = this._roomExtensions.getPortClassName(ep);
          _builder.append(_portClassName, "\t\t");
          _builder.append(" ");
          String _name_5 = ep.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- saps");
      _builder.newLine();
      {
        EList<SAP> _serviceAccessPoints = ac.getServiceAccessPoints();
        for(final SAP sap : _serviceAccessPoints) {
          _builder.append("\t\t");
          String _portClassName_1 = this._roomExtensions.getPortClassName(sap);
          _builder.append(_portClassName_1, "\t\t");
          _builder.append(" ");
          String _name_6 = sap.getName();
          _builder.append(_name_6, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- services");
      _builder.newLine();
      {
        EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
        for(final ServiceImplementation svc : _serviceImplementations) {
          _builder.append("\t\t");
          String _portClassName_2 = this._roomExtensions.getPortClassName(svc);
          _builder.append(_portClassName_2, "\t\t");
          _builder.append(" ");
          SPP _spp = svc.getSpp();
          String _name_7 = _spp.getName();
          _builder.append(_name_7, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t\t");
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
      _builder.append(_genInterfaceItemConstants, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
      _builder.append(_attributes_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      EList<StandardOperation> _operations = ac.getOperations();
      String _name_8 = ac.getName();
      CharSequence _operationsDeclaration = this._procedureHelpers.operationsDeclaration(_operations, _name_8);
      _builder.append(_operationsDeclaration, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t\t");
      String _name_9 = ac.getName();
      _builder.append(_name_9, "\t\t");
      _builder.append("(etRuntime::IRTObject* parent, const std::string& name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- port getters");
      _builder.newLine();
      _builder.append("\t\t");
      List<Port> _endPorts_1 = this._roomHelpers.getEndPorts(ac);
      final Function1<Port, CharSequence> _function = new Function1<Port, CharSequence>() {
        public CharSequence apply(final Port it) {
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(it);
          String _plus = (_portClassName + "&");
          String _name = it.getName();
          return ActorClassGen.this._procedureHelpers.getterImplementation(_plus, _name, clsname);
        }
      };
      List<CharSequence> _map = ListExtensions.<Port, CharSequence>map(_endPorts_1, _function);
      String _join = IterableExtensions.join(_map, this._roomExtensions.NEWLINE);
      _builder.append(_join, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      EList<SAP> _serviceAccessPoints_1 = ac.getServiceAccessPoints();
      final Function1<SAP, CharSequence> _function_1 = new Function1<SAP, CharSequence>() {
        public CharSequence apply(final SAP it) {
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(it);
          String _plus = (_portClassName + "&");
          String _name = it.getName();
          return ActorClassGen.this._procedureHelpers.getterImplementation(_plus, _name, clsname);
        }
      };
      List<CharSequence> _map_1 = ListExtensions.<SAP, CharSequence>map(_serviceAccessPoints_1, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, this._roomExtensions.NEWLINE);
      _builder.append(_join_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      EList<ServiceImplementation> _serviceImplementations_1 = ac.getServiceImplementations();
      final Function1<ServiceImplementation, CharSequence> _function_2 = new Function1<ServiceImplementation, CharSequence>() {
        public CharSequence apply(final ServiceImplementation it) {
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(it);
          String _plus = (_portClassName + "&");
          SPP _spp = it.getSpp();
          String _name = _spp.getName();
          return ActorClassGen.this._procedureHelpers.getterImplementation(_plus, _name, clsname);
        }
      };
      List<CharSequence> _map_2 = ListExtensions.<ServiceImplementation, CharSequence>map(_serviceImplementations_1, _function_2);
      String _join_2 = IterableExtensions.join(_map_2, this._roomExtensions.NEWLINE);
      _builder.append(_join_2, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- lifecycle functions");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void destroy();");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\t\t");
          CharSequence _genStateMachineConstants = this._stateMachineGen.genStateMachineConstants(xpac);
          _builder.append(_genStateMachineConstants, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t\t");
          CharSequence _genStateMachineMethods = this._stateMachineGen.genStateMachineMethods(xpac, false);
          _builder.append(_genStateMachineMethods, "\t\t");
          _builder.newLineIfNotEmpty();
          {
            ComponentCommunicationType _commType = ac.getCommType();
            boolean _equals_1 = Objects.equal(_commType, ComponentCommunicationType.DATA_DRIVEN);
            if (_equals_1) {
              _builder.append("\t\t");
              _builder.append("void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* generic_data);");
              _builder.newLine();
            }
          }
          {
            boolean _or = false;
            ComponentCommunicationType _commType_1 = ac.getCommType();
            boolean _equals_2 = Objects.equal(_commType_1, ComponentCommunicationType.ASYNCHRONOUS);
            if (_equals_2) {
              _or = true;
            } else {
              ComponentCommunicationType _commType_2 = ac.getCommType();
              boolean _equals_3 = Objects.equal(_commType_2, ComponentCommunicationType.DATA_DRIVEN);
              _or = _equals_3;
            }
            if (_or) {
              _builder.append("\t\t");
              _builder.append("virtual void receive(const etRuntime::Message* msg);");
              _builder.newLine();
            }
          }
        } else {
          StateGraph _stateMachine = xpac.getStateMachine();
          boolean _isEmpty = this._roomHelpers.isEmpty(_stateMachine);
          if (_isEmpty) {
            _builder.append("\t\t");
            _builder.append("//--------------------- no state machine");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("virtual void executeInitTransition() {}");
            _builder.newLine();
          }
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2, false);
      _builder.append(_userCode_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      String _name_10 = ac.getName();
      CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(_name_10);
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String generateConstructorInitalizerList(final ActorClass ac) {
    String _xblockexpression = null;
    {
      ArrayList<CharSequence> initializerList = new ArrayList<CharSequence>();
      StringConcatenation _builder = new StringConcatenation();
      String _elvis = null;
      ActorClass _actorBase = ac.getActorBase();
      String _name = null;
      if (_actorBase!=null) {
        _name=_actorBase.getName();
      }
      if (_name != null) {
        _elvis = _name;
      } else {
        _elvis = "ActorClassBase";
      }
      _builder.append(_elvis, "");
      _builder.append("(parent, name)");
      initializerList.add(_builder);
      List<Port> _endPorts = this._roomHelpers.getEndPorts(ac);
      for (final Port ep : _endPorts) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = ep.getName();
        _builder_1.append(_name_1, "");
        _builder_1.append("(this, \"");
        String _name_2 = ep.getName();
        _builder_1.append(_name_2, "");
        _builder_1.append("\", IFITEM_");
        String _name_3 = ep.getName();
        _builder_1.append(_name_3, "");
        _builder_1.append(")");
        initializerList.add(_builder_1);
      }
      EList<SAP> _serviceAccessPoints = ac.getServiceAccessPoints();
      for (final SAP sap : _serviceAccessPoints) {
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_4 = sap.getName();
        _builder_2.append(_name_4, "");
        _builder_2.append("(this, \"");
        String _name_5 = sap.getName();
        _builder_2.append(_name_5, "");
        _builder_2.append("\", IFITEM_");
        String _name_6 = sap.getName();
        _builder_2.append(_name_6, "");
        _builder_2.append(")");
        initializerList.add(_builder_2);
      }
      EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
      for (final ServiceImplementation svc : _serviceImplementations) {
        StringConcatenation _builder_3 = new StringConcatenation();
        SPP _spp = svc.getSpp();
        String _name_7 = _spp.getName();
        _builder_3.append(_name_7, "");
        _builder_3.append("(this, \"");
        SPP _spp_1 = svc.getSpp();
        String _name_8 = _spp_1.getName();
        _builder_3.append(_name_8, "");
        _builder_3.append("\", IFITEM_");
        SPP _spp_2 = svc.getSpp();
        String _name_9 = _spp_2.getName();
        _builder_3.append(_name_9, "");
        _builder_3.append(")");
        initializerList.add(_builder_3);
      }
      EList<Attribute> _attributes = ac.getAttributes();
      for (final Attribute attrib : _attributes) {
        CharSequence _attributeInitialization = this._initialization.attributeInitialization(attrib, false);
        initializerList.add(_attributeInitialization);
      }
      _xblockexpression = IterableExtensions.join(initializerList, ("," + this._roomExtensions.NEWLINE));
    }
    return _xblockexpression;
  }
  
  private CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired, final boolean manualBehavior) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      String _xifexpression = null;
      if (manualBehavior) {
        String _name = ac.getName();
        _xifexpression = ("Abstract" + _name);
      } else {
        _xifexpression = ac.getName();
      }
      final String clsname = _xifexpression;
      String _elvis = null;
      ActorClass _actorBase = ac.getActorBase();
      String _name_1 = null;
      if (_actorBase!=null) {
        _name_1=_actorBase.getName();
      }
      if (_name_1 != null) {
        _elvis = _name_1;
      } else {
        _elvis = "ActorClassBase";
      }
      final String rtBaseClassName = _elvis;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @author generated by eTrice");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Source File of ActorClass ");
      String _name_2 = ac.getName();
      _builder.append(_name_2, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(ac);
      _builder.append(_cppHeaderFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTObject.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTServices.h\"");
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.append("#include \"etUnit/etUnit.h\"");
      _builder.newLine();
      _builder.append("#include <iostream>");
      _builder.newLine();
      _builder.append("#include <string>");
      _builder.newLine();
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = ac.getActorRefs();
        for(final ActorRef ar : _actorRefs) {
          _builder.append("#include \"");
          ActorClass _type = ar.getType();
          String _actorIncludePath = this._cppExtensions.getActorIncludePath(_type);
          _builder.append(_actorIncludePath, "");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append(clsname, "");
      _builder.append("::");
      _builder.append(clsname, "");
      _builder.append("(etRuntime::IRTObject* parent, const std::string& name) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      String _generateConstructorInitalizerList = this.generateConstructorInitalizerList(ac);
      _builder.append(_generateConstructorInitalizerList, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\t");
          _builder.append("for (int i = 0; i < s_numberOfStates; i++) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("history[i] = NO_STATE;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("setClassName(\"");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "\t");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes, false);
      _builder.append(_attributeInitialization, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_1 = ac.getActorRefs();
        for(final ActorRef sub : _actorRefs_1) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t");
              _builder.append("for (int i=0; i<");
              int _multiplicity_1 = sub.getMultiplicity();
              _builder.append(_multiplicity_1, "\t");
              _builder.append("; ++i) {");
              _builder.newLineIfNotEmpty();
              {
                GlobalGeneratorSettings _settings = Main.getSettings();
                boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_4 = sub.getName();
                  _builder.append(_name_4, "\t\t");
                  _builder.append(GenmodelConstants.INDEX_SEP, "\t\t");
                  _builder.append("\"+i);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_1 = sub.getType();
              String _implementationClassName = this._cppExtensions.getImplementationClassName(_type_1);
              _builder.append(_implementationClassName, "\t\t");
              _builder.append("(this, \"");
              String _name_5 = sub.getName();
              _builder.append(_name_5, "\t\t");
              _builder.append(GenmodelConstants.INDEX_SEP, "\t\t");
              _builder.append("\"+i);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              {
                GlobalGeneratorSettings _settings_1 = Main.getSettings();
                boolean _isGenerateMSCInstrumentation_1 = _settings_1.isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation_1) {
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_6 = sub.getName();
                  _builder.append(_name_6, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_2 = sub.getType();
              String _implementationClassName_1 = this._cppExtensions.getImplementationClassName(_type_2);
              _builder.append(_implementationClassName_1, "\t");
              _builder.append("(this, \"");
              String _name_7 = sub.getName();
              _builder.append(_name_7, "\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// wiring");
      _builder.newLine();
      {
        EList<Wire> _wires = wired.getWires();
        for(final Wire wire : _wires) {
          _builder.append("\t");
          String _xifexpression_1 = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression_1 = "DataPortBase";
          } else {
            _xifexpression_1 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_1, "\t");
          _builder.append("::connect(this, \"");
          EList<String> _path1 = wire.getPath1();
          String _join = IterableExtensions.join(_path1, "/");
          _builder.append(_join, "\t");
          _builder.append("\", \"");
          EList<String> _path2 = wire.getPath2();
          String _join_1 = IterableExtensions.join(_path2, "/");
          _builder.append(_join_1, "\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        boolean _or = false;
        ComponentCommunicationType _commType = ac.getCommType();
        boolean _equals = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
        if (_equals) {
          _or = true;
        } else {
          ComponentCommunicationType _commType_1 = ac.getCommType();
          boolean _equals_1 = Objects.equal(_commType_1, ComponentCommunicationType.DATA_DRIVEN);
          _or = _equals_1;
        }
        if (_or) {
          _builder.append("\t");
          _builder.append("// activate polling for data-driven communication");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(getThread())->addPollingMessageReceiver(*this);");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      String _userStructorBody = this._procedureHelpers.userStructorBody(ac, true);
      _builder.append(_userStructorBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_8 = ac.getName();
      _builder.append(_name_8, "");
      _builder.append("::destroy(){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _userStructorBody_1 = this._procedureHelpers.userStructorBody(ac, false);
      _builder.append(_userStructorBody_1, "\t");
      _builder.newLineIfNotEmpty();
      {
        GlobalGeneratorSettings _settings_2 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_2 = _settings_2.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_2) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addMessageActorDestroy(*this);");
          _builder.newLine();
        }
      }
      {
        boolean _or_1 = false;
        ComponentCommunicationType _commType_2 = ac.getCommType();
        boolean _equals_2 = Objects.equal(_commType_2, ComponentCommunicationType.ASYNCHRONOUS);
        if (_equals_2) {
          _or_1 = true;
        } else {
          ComponentCommunicationType _commType_3 = ac.getCommType();
          boolean _equals_3 = Objects.equal(_commType_3, ComponentCommunicationType.DATA_DRIVEN);
          _or_1 = _equals_3;
        }
        if (_or_1) {
          _builder.append("\t");
          _builder.append("RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(getThread())->removePollingMessageReceiver(*this);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append(rtBaseClassName, "\t");
      _builder.append("::destroy();");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      EList<StandardOperation> _operations = ac.getOperations();
      String _name_9 = ac.getName();
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(_operations, _name_9);
      _builder.append(_operationsImplementation, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine_1 = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine_1) {
          CharSequence _genStateMachineMethods = this._stateMachineGen.genStateMachineMethods(xpac, true);
          _builder.append(_genStateMachineMethods, "");
          _builder.newLineIfNotEmpty();
          {
            ComponentCommunicationType _commType_4 = ac.getCommType();
            boolean _equals_4 = Objects.equal(_commType_4, ComponentCommunicationType.DATA_DRIVEN);
            if (_equals_4) {
              _builder.append("void ");
              String _name_10 = ac.getName();
              _builder.append(_name_10, "");
              _builder.append("::receiveEvent(InterfaceItemBase* ifitem, int evt, void* generic_data) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("handleSystemEvent(ifitem, evt, generic_data);");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            }
          }
          {
            boolean _or_2 = false;
            ComponentCommunicationType _commType_5 = ac.getCommType();
            boolean _equals_5 = Objects.equal(_commType_5, ComponentCommunicationType.ASYNCHRONOUS);
            if (_equals_5) {
              _or_2 = true;
            } else {
              ComponentCommunicationType _commType_6 = ac.getCommType();
              boolean _equals_6 = Objects.equal(_commType_6, ComponentCommunicationType.DATA_DRIVEN);
              _or_2 = _equals_6;
            }
            if (_or_2) {
              _builder.append("void ");
              String _name_11 = ac.getName();
              _builder.append(_name_11, "");
              _builder.append("::receive(const Message* msg) {");
              _builder.newLineIfNotEmpty();
              {
                ComponentCommunicationType _commType_7 = ac.getCommType();
                boolean _equals_7 = Objects.equal(_commType_7, ComponentCommunicationType.ASYNCHRONOUS);
                if (_equals_7) {
                  _builder.append("\t");
                  _builder.append("receiveEvent(0, -1, 0);");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("receiveEventInternal();");
                  _builder.newLine();
                }
              }
              _builder.append("}");
              _builder.newLine();
            }
          }
        } else {
          StateGraph _stateMachine = xpac.getStateMachine();
          boolean _isEmpty = this._roomHelpers.isEmpty(_stateMachine);
          if (_isEmpty) {
            _builder.append("//--------------------- no state machine");
            _builder.newLine();
            _builder.append("void ");
            String _name_12 = ac.getName();
            _builder.append(_name_12, "");
            _builder.append("::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("handleSystemEvent(ifitem, evt, data);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
