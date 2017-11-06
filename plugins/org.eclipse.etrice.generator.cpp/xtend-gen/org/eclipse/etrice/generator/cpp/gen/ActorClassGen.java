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
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
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

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  protected IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  protected CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  protected ProcedureHelpers _procedureHelpers;
  
  @Inject
  protected Initialization initHelper;
  
  @Inject
  @Extension
  protected StateMachineGen _stateMachineGen;
  
  @Inject
  @Extension
  protected FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    final Map<ActorClass, WiredActorClass> ac2wired = CollectionLiterals.<ActorClass, WiredActorClass>newHashMap();
    final Consumer<WiredActorClass> _function = (WiredActorClass it) -> {
      ac2wired.put(it.getActorClass(), it);
    };
    Iterables.<WiredActorClass>filter(root.getWiredInstances(), WiredActorClass.class).forEach(_function);
    final Function1<ActorClass, Boolean> _function_1 = (ActorClass it) -> {
      return Boolean.valueOf(this._fileSystemHelpers.isValidGenerationLocation(it));
    };
    final Function1<ActorClass, ExpandedActorClass> _function_2 = (ActorClass it) -> {
      return root.getExpandedActorClass(it);
    };
    Iterable<ExpandedActorClass> _map = IterableExtensions.<ActorClass, ExpandedActorClass>map(IterableExtensions.<ActorClass>filter(root.getActorClasses(), _function_1), _function_2);
    for (final ExpandedActorClass xpac : _map) {
      {
        final WiredActorClass wired = ac2wired.get(xpac.getActorClass());
        final boolean manualBehavior = this._roomHelpers.isBehaviorAnnotationPresent(xpac.getActorClass(), "BehaviorManual");
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(xpac.getActorClass());
        String _path = this._roomExtensions.getPath(xpac.getActorClass());
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(xpac.getActorClass());
        String _path_1 = this._roomExtensions.getPath(xpac.getActorClass());
        final String infopath = (_generationInfoPath + _path_1);
        String _xifexpression = null;
        if (manualBehavior) {
          _xifexpression = "Abstract";
        } else {
          _xifexpression = "";
        }
        String file = _xifexpression;
        String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(xpac.getActorClass());
        String _plus = (file + _cppHeaderFileName);
        this.fileIO.generateFile("generating ActorClass declaration", path, infopath, _plus, this.generateHeaderFile(root, xpac, wired, manualBehavior));
        String _cppSourceFileName = this._cppExtensions.getCppSourceFileName(xpac.getActorClass());
        String _plus_1 = (file + _cppSourceFileName);
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, _plus_1, this.generateSourceFile(root, xpac, wired, manualBehavior));
      }
    }
  }
  
  protected CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired, final boolean manualBehavior) {
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
      CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(ac, "");
      _builder.append(_generateIncludeGuardBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/etDatatypesCpp.hpp\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/IRTObject.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/PortBase.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/ReplicatedActorClassBase.h\"");
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
      _builder.newLine();
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include \"");
          String _path = this._roomExtensions.getPath(pc);
          _builder.append(_path);
          String _name_2 = pc.getName();
          _builder.append(_name_2);
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
        for(final DataClass dc : _referencedDataClasses) {
          _builder.append("#include \"");
          String _path_1 = this._roomExtensions.getPath(dc);
          _builder.append(_path_1);
          String _name_3 = dc.getName();
          _builder.append(_name_3);
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
          String _path_2 = this._roomExtensions.getPath(ac.getActorBase());
          _builder.append(_path_2);
          String _name_4 = ac.getActorBase().getName();
          _builder.append(_name_4);
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ActorRef> _actorRefs = ac.getActorRefs();
        for(final ActorRef ar : _actorRefs) {
          _builder.append("#include \"");
          String _actorIncludePath = this._cppExtensions.getActorIncludePath(ar.getType());
          _builder.append(_actorIncludePath);
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac.getUserCode1());
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(ac);
      _builder.append(_generateNamespaceBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      _builder.append(clsname);
      _builder.append(" : public ");
      _builder.append(rtBaseClassName);
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
      _builder.append("//--------------------- sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_1 = ac.getActorRefs();
        for(final ActorRef sub : _actorRefs_1) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t\t");
              _builder.append("Replicated");
              String _implementationClassName = this._cppExtensions.getImplementationClassName(sub.getType());
              _builder.append(_implementationClassName, "\t\t");
              _builder.append(" ");
              String _name_6 = sub.getName();
              _builder.append(_name_6, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              String _implementationClassName_1 = this._cppExtensions.getImplementationClassName(sub.getType());
              _builder.append(_implementationClassName_1, "\t\t");
              _builder.append(" ");
              String _name_7 = sub.getName();
              _builder.append(_name_7, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
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
          String _name_8 = sap.getName();
          _builder.append(_name_8, "\t\t");
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
          String _name_9 = svc.getSpp().getName();
          _builder.append(_name_9, "\t\t");
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
      CharSequence _attributes = this._procedureHelpers.attributes(ac.getAttributes());
      _builder.append(_attributes, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      CharSequence _operationsDeclaration = this._procedureHelpers.operationsDeclaration(ac.getOperations(), ac.getName());
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
      String _name_10 = ac.getName();
      _builder.append(_name_10, "\t\t");
      _builder.append("(etRuntime::IRTObject* parent, const String& name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("void initialize(void);");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t\t");
          _builder.append("void setProbesActive(bool recursive, bool active);");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//--------------------- port getters");
      _builder.newLine();
      _builder.append("\t\t");
      final Function1<Port, CharSequence> _function = (Port it) -> {
        String _portClassName_3 = this._roomExtensions.getPortClassName(it);
        String _plus = (_portClassName_3 + "&");
        return this._procedureHelpers.getterImplementation(_plus, it.getName(), clsname);
      };
      String _join = IterableExtensions.join(ListExtensions.<Port, CharSequence>map(this._roomHelpers.getEndPorts(ac), _function), this._roomExtensions.NEWLINE);
      _builder.append(_join, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      final Function1<SAP, CharSequence> _function_1 = (SAP it) -> {
        String _portClassName_3 = this._roomExtensions.getPortClassName(it);
        String _plus = (_portClassName_3 + "&");
        return this._procedureHelpers.getterImplementation(_plus, it.getName(), clsname);
      };
      String _join_1 = IterableExtensions.join(ListExtensions.<SAP, CharSequence>map(ac.getServiceAccessPoints(), _function_1), this._roomExtensions.NEWLINE);
      _builder.append(_join_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      final Function1<ServiceImplementation, CharSequence> _function_2 = (ServiceImplementation it) -> {
        String _portClassName_3 = this._roomExtensions.getPortClassName(it);
        String _plus = (_portClassName_3 + "&");
        return this._procedureHelpers.getterImplementation(_plus, it.getSpp().getName(), clsname);
      };
      String _join_2 = IterableExtensions.join(ListExtensions.<ServiceImplementation, CharSequence>map(ac.getServiceImplementations(), _function_2), this._roomExtensions.NEWLINE);
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
          CharSequence _genStateMachineConstants = this._stateMachineGen.genStateMachineConstants(xpac.getGraphContainer());
          _builder.append(_genStateMachineConstants, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t\t");
          CharSequence _genStateMachineMethods = this._stateMachineGen.genStateMachineMethods(xpac.getGraphContainer(), false);
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
            if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
              _builder.append("\t\t");
              _builder.append("virtual void receive(const etRuntime::Message* msg);");
              _builder.newLine();
            }
          }
        } else {
          boolean _isEmpty = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
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
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac.getUserCode2());
      _builder.append(_userCode_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Replicated");
      _builder.append(clsname);
      _builder.append(" : public ReplicatedActorClassBase {");
      _builder.newLineIfNotEmpty();
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Replicated");
      _builder.append(clsname, "\t");
      _builder.append("(IRTObject* parent, const String& name) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("ReplicatedActorClassBase(parent, name) {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("protected:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ActorClassBase* createActor(IRTObject* parent, const String& name) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new ");
      _builder.append(clsname, "\t\t");
      _builder.append("(parent, name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(ac);
      _builder.append(_generateNamespaceEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(ac, "");
      _builder.append(_generateIncludeGuardEnd);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateConstructorInitalizerList(final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      ArrayList<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
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
      _builder.append(_elvis);
      _builder.append("(parent, name)");
      initList.add(_builder.toString());
      final Function1<Port, String> _function = (Port it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(this, \"");
        String _name_2 = it.getName();
        _builder_1.append(_name_2);
        _builder_1.append("\", IFITEM_");
        String _name_3 = it.getName();
        _builder_1.append(_name_3);
        _builder_1.append(")");
        return _builder_1.toString();
      };
      List<String> _map = ListExtensions.<Port, String>map(this._roomHelpers.getEndPorts(ac), _function);
      Iterables.<CharSequence>addAll(initList, _map);
      final Function1<ActorRef, String> _function_1 = (ActorRef it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(this, \"");
        String _name_2 = it.getName();
        _builder_1.append(_name_2);
        _builder_1.append("\")");
        return _builder_1.toString();
      };
      List<String> _map_1 = ListExtensions.<ActorRef, String>map(ac.getActorRefs(), _function_1);
      Iterables.<CharSequence>addAll(initList, _map_1);
      final Function1<SAP, String> _function_2 = (SAP it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(this, \"");
        String _name_2 = it.getName();
        _builder_1.append(_name_2);
        _builder_1.append("\", IFITEM_");
        String _name_3 = it.getName();
        _builder_1.append(_name_3);
        _builder_1.append(")");
        return _builder_1.toString();
      };
      List<String> _map_2 = ListExtensions.<SAP, String>map(ac.getServiceAccessPoints(), _function_2);
      Iterables.<CharSequence>addAll(initList, _map_2);
      final Function1<ServiceImplementation, String> _function_3 = (ServiceImplementation it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getSpp().getName();
        _builder_1.append(_name_1);
        _builder_1.append("(this, \"");
        String _name_2 = it.getSpp().getName();
        _builder_1.append(_name_2);
        _builder_1.append("\", IFITEM_");
        String _name_3 = it.getSpp().getName();
        _builder_1.append(_name_3);
        _builder_1.append(")");
        return _builder_1.toString();
      };
      List<String> _map_3 = ListExtensions.<ServiceImplementation, String>map(ac.getServiceImplementations(), _function_3);
      Iterables.<CharSequence>addAll(initList, _map_3);
      final Function1<Attribute, String> _function_4 = (Attribute it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("(");
        String _initializerListValue = initHelper.getInitializerListValue(it);
        _builder_1.append(_initializerListValue);
        _builder_1.append(")");
        return _builder_1.toString();
      };
      List<String> _map_4 = ListExtensions.<Attribute, String>map(ac.getAttributes(), _function_4);
      Iterables.<CharSequence>addAll(initList, _map_4);
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired, final boolean manualBehavior) {
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
      _builder.append(_cppHeaderFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTObject.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTServices.h\"");
      _builder.newLine();
      _builder.append("#include \"common/debugging/DebuggingService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/debugging/MSCFunctionObject.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(ac);
      _builder.append(_generateNamespaceBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac.getUserCode3());
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(clsname);
      _builder.append("::");
      _builder.append(clsname);
      _builder.append("(etRuntime::IRTObject* parent, const String& name)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      CharSequence _generateConstructorInitalizerList = this.generateConstructorInitalizerList(ac);
      _builder.append(_generateConstructorInitalizerList, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"Constructor\");");
          _builder.newLine();
        }
      }
      _builder.append("\t");
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
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = ac.getActorRefs();
        for(final ActorRef sub : _actorRefs) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t");
              String _name_4 = sub.getName();
              _builder.append(_name_4, "\t");
              _builder.append(".createSubActors(");
              int _multiplicity_1 = sub.getMultiplicity();
              _builder.append(_multiplicity_1, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genExtraInitializers = this.initHelper.genExtraInitializers(ac.getAttributes());
      _builder.append(_genExtraInitializers, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _userStructorBody = this._procedureHelpers.userStructorBody(ac, true);
      _builder.append(_userStructorBody, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_5 = ac.getName();
      _builder.append(_name_5);
      _builder.append("::initialize() {");
      _builder.newLineIfNotEmpty();
      {
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"initialize()\");");
          _builder.newLine();
          {
            EList<ActorRef> _actorRefs_1 = ac.getActorRefs();
            for(final ActorRef sub_1 : _actorRefs_1) {
              {
                int _multiplicity_2 = sub_1.getMultiplicity();
                boolean _greaterThan_1 = (_multiplicity_2 > 1);
                if (_greaterThan_1) {
                  _builder.append("\t");
                  _builder.append("for (int i=0; i<");
                  int _multiplicity_3 = sub_1.getMultiplicity();
                  _builder.append(_multiplicity_3, "\t");
                  _builder.append("; ++i) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, ");
                  String _name_6 = sub_1.getName();
                  _builder.append(_name_6, "\t\t");
                  _builder.append(".getSubActor(i)->getName());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_7 = sub_1.getName();
                  _builder.append(_name_7, "\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ActorClassBase::initialize();");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_2 = ac.getActorRefs();
        for(final ActorRef sub_2 : _actorRefs_2) {
          _builder.append("\t");
          String _name_8 = sub_2.getName();
          _builder.append(_name_8, "\t");
          _builder.append(".initialize();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
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
          String _join = IterableExtensions.join(wire.getPath1(), "/");
          _builder.append(_join, "\t");
          _builder.append("\", \"");
          String _join_1 = IterableExtensions.join(wire.getPath2(), "/");
          _builder.append(_join_1, "\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
          _builder.append("\t");
          _builder.append("// activate polling for data-driven communication");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(getThread())->addPollingMessageReceiver(*this);");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_2 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_2) {
          _builder.append("void ");
          String _name_9 = ac.getName();
          _builder.append(_name_9);
          _builder.append("::setProbesActive(bool recursive, bool active) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addPortInstance(m_RTSystemPort);");
          _builder.newLine();
          {
            int _size = ac.getActorRefs().size();
            boolean _greaterThan_2 = (_size > 0);
            if (_greaterThan_2) {
              _builder.append("\t");
              _builder.append("if(recursive) {");
              _builder.newLine();
              {
                EList<ActorRef> _actorRefs_3 = ac.getActorRefs();
                for(final ActorRef sub_3 : _actorRefs_3) {
                  _builder.append("\t");
                  _builder.append("\t");
                  String _name_10 = sub_3.getName();
                  _builder.append(_name_10, "\t\t");
                  _builder.append(".setProbesActive(recursive, active);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          {
            List<Port> _endPorts = this._roomHelpers.getEndPorts(ac);
            for(final Port ep : _endPorts) {
              {
                boolean _isDataDriven_1 = this._roomHelpers.isDataDriven(ep);
                boolean _not = (!_isDataDriven_1);
                if (_not) {
                  {
                    boolean _isReplicated = ep.isReplicated();
                    if (_isReplicated) {
                      _builder.append("\t");
                      _builder.append("for(int i = 0; i < ");
                      String _name_11 = ep.getName();
                      _builder.append(_name_11, "\t");
                      _builder.append(".getNInterfaceItems(); i++)");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("DebuggingService::getInstance().addPortInstance(*(");
                      String _name_12 = ep.getName();
                      _builder.append(_name_12, "\t\t");
                      _builder.append(".getInterfaceItem(i)));");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("\t");
                      _builder.append("DebuggingService::getInstance().addPortInstance(");
                      String _name_13 = ep.getName();
                      _builder.append(_name_13, "\t");
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
          {
            EList<SAP> _serviceAccessPoints = ac.getServiceAccessPoints();
            for(final SAP sap : _serviceAccessPoints) {
              _builder.append("\t");
              _builder.append("DebuggingService::getInstance().addPortInstance(");
              String _name_14 = sap.getName();
              _builder.append(_name_14, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            EList<SPP> _serviceProvisionPoints = ac.getServiceProvisionPoints();
            for(final SPP spp : _serviceProvisionPoints) {
              _builder.append("\t");
              _builder.append("for(int i = 0; i < ");
              String _name_15 = spp.getName();
              _builder.append(_name_15, "\t");
              _builder.append(".getNInterfaceItems(); i++)");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("DebuggingService::getInstance().addPortInstance(*(");
              String _name_16 = spp.getName();
              _builder.append(_name_16, "\t\t\t");
              _builder.append(".getInterfaceItem(i)));");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _name_17 = ac.getName();
      _builder.append(_name_17);
      _builder.append("::destroy(){");
      _builder.newLineIfNotEmpty();
      {
        boolean _isGenerateMSCInstrumentation_3 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_3) {
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"destroy()\");");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      String _userStructorBody_1 = this._procedureHelpers.userStructorBody(ac, false);
      _builder.append(_userStructorBody_1, "\t");
      _builder.newLineIfNotEmpty();
      {
        boolean _isGenerateMSCInstrumentation_4 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_4) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addMessageActorDestroy(*this);");
          _builder.newLine();
        }
      }
      {
        if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
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
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(ac.getOperations(), ac.getName());
      _builder.append(_operationsImplementation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine_1 = this._roomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine_1) {
          CharSequence _genStateMachineMethods = this._stateMachineGen.genStateMachineMethods(xpac.getGraphContainer(), true);
          _builder.append(_genStateMachineMethods);
          _builder.newLineIfNotEmpty();
          {
            ComponentCommunicationType _commType = ac.getCommType();
            boolean _equals = Objects.equal(_commType, ComponentCommunicationType.DATA_DRIVEN);
            if (_equals) {
              _builder.append("void ");
              String _name_18 = ac.getName();
              _builder.append(_name_18);
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
            if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
              _builder.append("void ");
              String _name_19 = ac.getName();
              _builder.append(_name_19);
              _builder.append("::receive(const Message* msg) {");
              _builder.newLineIfNotEmpty();
              {
                ComponentCommunicationType _commType_1 = ac.getCommType();
                boolean _equals_1 = Objects.equal(_commType_1, ComponentCommunicationType.ASYNCHRONOUS);
                if (_equals_1) {
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
          boolean _isEmpty = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
          if (_isEmpty) {
            _builder.append("//--------------------- no state machine");
            _builder.newLine();
            _builder.append("void ");
            String _name_20 = ac.getName();
            _builder.append(_name_20);
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
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(ac);
      _builder.append(_generateNamespaceEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
