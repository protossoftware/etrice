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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.cpp.GeneratorOptions;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.cpp.gen.StateMachineGen;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Peter Karlitschek
 */
@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private CppExtensions _cppExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private Initialization _initialization;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private StateMachineGen _stateMachineGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_1);
        String path = (_generationTargetPath + _path);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(_actorClass_2);
        String _plus = ("generating ActorClass header \'" + _cppHeaderFileName);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _cppHeaderFileName_1 = this._cppExtensions.getCppHeaderFileName(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, xpac, _actorClass_4);
        this.fileAccess.generateFile(_cppHeaderFileName_1, _generateHeaderFile);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String _cppSourceFileName = this._cppExtensions.getCppSourceFileName(_actorClass_5);
        String _plus_4 = ("generating ActorClass source \'" + _cppSourceFileName);
        String _plus_5 = (_plus_4 + "\' in \'");
        String _plus_6 = (_plus_5 + path);
        String _plus_7 = (_plus_6 + "\'");
        this.logger.logInfo(_plus_7);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_6 = xpac.getActorClass();
        String _cppSourceFileName_1 = this._cppExtensions.getCppSourceFileName(_actorClass_6);
        ActorClass _actorClass_7 = xpac.getActorClass();
        CharSequence _generateSourceFile = this.generateSourceFile(root, xpac, _actorClass_7);
        this.fileAccess.generateFile(_cppSourceFileName_1, _generateSourceFile);
      }
    }
  }
  
  private CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Header File of ActorClass ");
    String _name = ac.getName();
    _builder.append(_name, "	 ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    String _name_1 = ac.getName();
    CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(_name_1);
    _builder.append(_generateIncludeGuardBegin, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"platforms/generic/etDatatypes.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/IRTObject.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/PortBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/ActorClassBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/modelbase/SubSystemClassBase.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/Address.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/messaging/IMessageReceiver.h\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include \"common/debugging/DebuggingService.h\"");
    _builder.newLine();
    {
      boolean _isUseEtUnit = GeneratorOptions.isUseEtUnit();
      if (_isUseEtUnit) {
        _builder.append("\t");
        _builder.append("extern \"C\" {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("#include \"etUnit.h\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("#include <string>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#include <vector>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<RoomModel> _referencedModels = root.getReferencedModels(ac);
      for(final RoomModel model : _referencedModels) {
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
      for(final ProtocolClass pc : _referencedProtocolClasses) {
        _builder.append("\t");
        _builder.append("#include \"");
        String _path = this._roomExtensions.getPath(pc);
        _builder.append(_path, "	");
        String _name_2 = pc.getName();
        _builder.append(_name_2, "	");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
      for(final DataClass dc : _referencedDataClasses) {
        _builder.append("\t");
        _builder.append("#include \"");
        String _path_1 = this._roomExtensions.getPath(dc);
        _builder.append(_path_1, "	");
        String _name_3 = dc.getName();
        _builder.append(_name_3, "	");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _userCode = this._procedureHelpers.userCode(ac, 1);
    _builder.append(_userCode, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class ");
    String _name_4 = ac.getName();
    _builder.append(_name_4, "	");
    _builder.append(" : public ");
    {
      ActorClass _base = ac.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        ActorClass _base_1 = ac.getBase();
        String _name_5 = _base_1.getName();
        _builder.append(_name_5, "	");
      } else {
        _builder.append("etRuntime::ActorClassBase");
      }
    }
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- ports");
    _builder.newLine();
    _builder.append("\t\t\t");
    List<Port> _endPorts = RoomHelpers.getEndPorts(ac);
    final Function1<Port,String> _function = new Function1<Port,String>() {
        public String apply(final Port port) {
          StringConcatenation _builder = new StringConcatenation();
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(port);
          _builder.append(_portClassName, "");
          _builder.append(" ");
          String _name = port.getName();
          _builder.append(_name, "");
          _builder.append(";");
          return _builder.toString();
        }
      };
    List<String> _map = ListExtensions.<Port, String>map(_endPorts, _function);
    String _join = IterableExtensions.join(_map, "\n");
    _builder.append(_join, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- saps");
    _builder.newLine();
    _builder.append("\t\t\t");
    EList<SAPRef> _strSAPs = ac.getStrSAPs();
    final Function1<SAPRef,String> _function_1 = new Function1<SAPRef,String>() {
        public String apply(final SAPRef sap) {
          StringConcatenation _builder = new StringConcatenation();
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(sap);
          _builder.append(_portClassName, "");
          _builder.append(" ");
          String _name = sap.getName();
          _builder.append(_name, "");
          _builder.append(";");
          return _builder.toString();
        }
      };
    List<String> _map_1 = ListExtensions.<SAPRef, String>map(_strSAPs, _function_1);
    String _join_1 = IterableExtensions.join(_map_1, "\n");
    _builder.append(_join_1, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- services");
    _builder.newLine();
    _builder.append("\t\t\t");
    EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
    final Function1<ServiceImplementation,String> _function_2 = new Function1<ServiceImplementation,String>() {
        public String apply(final ServiceImplementation svc) {
          StringConcatenation _builder = new StringConcatenation();
          String _portClassName = ActorClassGen.this._roomExtensions.getPortClassName(svc);
          _builder.append(_portClassName, "");
          _builder.append(" ");
          SPPRef _spp = svc.getSpp();
          String _name = _spp.getName();
          _builder.append(_name, "");
          _builder.append(";");
          return _builder.toString();
        }
      };
    List<String> _map_2 = ListExtensions.<ServiceImplementation, String>map(_serviceImplementations, _function_2);
    String _join_2 = IterableExtensions.join(_map_2, "\n");
    _builder.append(_join_2, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- interface item IDs");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
    _builder.append(_genInterfaceItemConstants, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    EList<Attribute> _attributes = ac.getAttributes();
    CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
    _builder.append(_attributes_1, "			");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(ac);
    _builder.append(_operationsImplementation, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- construction");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _name_6 = ac.getName();
    _builder.append(_name_6, "			");
    _builder.append("(etRuntime::IRTObject* parent, std::string name, const std::vector<std::vector<etRuntime::Address> >& port_addr, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ");
    _builder.append("const std::vector<std::vector<etRuntime::Address> >& peer_addr);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//--------------------- port getters");
    _builder.newLine();
    {
      List<Port> _endPorts_1 = RoomHelpers.getEndPorts(ac);
      for(final Port ep : _endPorts_1) {
        _builder.append("\t\t");
        String _portClassName = this._roomExtensions.getPortClassName(ep);
        String _name_7 = ep.getName();
        String _name_8 = ac.getName();
        CharSequence _terImplementation = this._procedureHelpers.getterImplementation(_portClassName, _name_7, _name_8);
        _builder.append(_terImplementation, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<SAPRef> _strSAPs_1 = ac.getStrSAPs();
      for(final SAPRef sap : _strSAPs_1) {
        _builder.append("\t\t");
        String _portClassName_1 = this._roomExtensions.getPortClassName(sap);
        String _name_9 = sap.getName();
        String _name_10 = ac.getName();
        CharSequence _terImplementation_1 = this._procedureHelpers.getterImplementation(_portClassName_1, _name_9, _name_10);
        _builder.append(_terImplementation_1, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ServiceImplementation> _serviceImplementations_1 = ac.getServiceImplementations();
      for(final ServiceImplementation svc : _serviceImplementations_1) {
        _builder.append("\t\t");
        String _portClassName_2 = this._roomExtensions.getPortClassName(svc);
        SPPRef _spp = svc.getSpp();
        String _name_11 = _spp.getName();
        String _name_12 = ac.getName();
        CharSequence _terImplementation_2 = this._procedureHelpers.getterImplementation(_portClassName_2, _name_11, _name_12);
        _builder.append(_terImplementation_2, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//--------------------- lifecycle functions");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("virtual void init();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("virtual void start();");
    _builder.newLine();
    {
      boolean _overridesStop = this._roomExtensions.overridesStop(ac);
      boolean _not = (!_overridesStop);
      if (_not) {
        _builder.append("\t\t");
        _builder.append("virtual void stop();");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("virtual void destroy();\t\t\t");
    _builder.newLine();
    {
      boolean _hasNonEmptyStateMachine = RoomHelpers.hasNonEmptyStateMachine(ac);
      if (_hasNonEmptyStateMachine) {
        _builder.append("\t\t");
        CharSequence _genStateMachineMethodDeclarations = this._stateMachineGen.genStateMachineMethodDeclarations(xpac);
        _builder.append(_genStateMachineMethodDeclarations, "		");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _hasStateMachine = xpac.hasStateMachine();
        boolean _not_1 = (!_hasStateMachine);
        if (_not_1) {
          _builder.append("\t\t");
          _builder.append("public: ");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("//--------------------- no state machine");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("virtual void executeInitTransition();");
          _builder.newLine();
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2);
    _builder.append(_userCode_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _name_13 = ac.getName();
    CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(_name_13);
    _builder.append(_generateIncludeGuardEnd, "	");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private String generateConstructorInitalizerList(final ActorClass ac) {
    ArrayList<CharSequence> _arrayList = new ArrayList<CharSequence>();
    ArrayList<CharSequence> initializerList = _arrayList;
    ActorClass _base = ac.getBase();
    boolean _equals = Objects.equal(_base, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("ActorClassBase( parent, name, port_addr[0][0], peer_addr[0][0])");
      initializerList.add(_builder);
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      ActorClass _base_1 = ac.getBase();
      String _name = _base_1.getName();
      _builder_1.append(_name, "");
      _builder_1.append("(*this, parent, name, port_addr, peer_addr)");
      initializerList.add(_builder_1);
    }
    List<Port> _endPorts = RoomHelpers.getEndPorts(ac);
    for (final Port ep : _endPorts) {
      StringConcatenation _builder_2 = new StringConcatenation();
      String _name_1 = ep.getName();
      _builder_2.append(_name_1, "");
      _builder_2.append("(*this, this, \"");
      String _name_2 = ep.getName();
      _builder_2.append(_name_2, "");
      _builder_2.append("\", IFITEM_");
      String _name_3 = ep.getName();
      _builder_2.append(_name_3, "");
      _builder_2.append(", ");
      {
        int _multiplicity = ep.getMultiplicity();
        boolean _equals_1 = (_multiplicity == 1);
        if (_equals_1) {
          _builder_2.append("0, ");
        }
      }
      _builder_2.append("port_addr[IFITEM_");
      String _name_4 = ep.getName();
      _builder_2.append(_name_4, "");
      _builder_2.append("]");
      {
        int _multiplicity_1 = ep.getMultiplicity();
        boolean _equals_2 = (_multiplicity_1 == 1);
        if (_equals_2) {
          _builder_2.append("[0]");
        }
      }
      _builder_2.append(", peer_addr[IFITEM_");
      String _name_5 = ep.getName();
      _builder_2.append(_name_5, "");
      _builder_2.append("]");
      {
        int _multiplicity_2 = ep.getMultiplicity();
        boolean _equals_3 = (_multiplicity_2 == 1);
        if (_equals_3) {
          _builder_2.append("[0]");
        }
      }
      _builder_2.append(")");
      initializerList.add(_builder_2);
    }
    EList<SAPRef> _strSAPs = ac.getStrSAPs();
    for (final SAPRef sap : _strSAPs) {
      StringConcatenation _builder_3 = new StringConcatenation();
      String _name_6 = sap.getName();
      _builder_3.append(_name_6, "");
      _builder_3.append("(*this, this, \"");
      String _name_7 = sap.getName();
      _builder_3.append(_name_7, "");
      _builder_3.append("\", IFITEM_");
      String _name_8 = sap.getName();
      _builder_3.append(_name_8, "");
      _builder_3.append(", 0, port_addr[IFITEM_");
      String _name_9 = sap.getName();
      _builder_3.append(_name_9, "");
      _builder_3.append("][0], peer_addr[IFITEM_");
      String _name_10 = sap.getName();
      _builder_3.append(_name_10, "");
      _builder_3.append("][0])");
      initializerList.add(_builder_3);
    }
    EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
    for (final ServiceImplementation svc : _serviceImplementations) {
      StringConcatenation _builder_4 = new StringConcatenation();
      SPPRef _spp = svc.getSpp();
      String _name_11 = _spp.getName();
      _builder_4.append(_name_11, "");
      _builder_4.append("(*this, this, \"");
      SPPRef _spp_1 = svc.getSpp();
      String _name_12 = _spp_1.getName();
      _builder_4.append(_name_12, "");
      _builder_4.append("\", IFITEM_");
      SPPRef _spp_2 = svc.getSpp();
      String _name_13 = _spp_2.getName();
      _builder_4.append(_name_13, "");
      _builder_4.append(", port_addr[IFITEM_");
      SPPRef _spp_3 = svc.getSpp();
      String _name_14 = _spp_3.getName();
      _builder_4.append(_name_14, "");
      _builder_4.append("], peer_addr[IFITEM_");
      SPPRef _spp_4 = svc.getSpp();
      String _name_15 = _spp_4.getName();
      _builder_4.append(_name_15, "");
      _builder_4.append("])");
      initializerList.add(_builder_4);
    }
    EList<Attribute> _attributes = ac.getAttributes();
    for (final Attribute attrib : _attributes) {
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(attrib, false);
      initializerList.add(_attributeInitialization);
    }
    StringConcatenation _builder_5 = new StringConcatenation();
    String _join = IterableExtensions.join(initializerList, ",\n");
    _builder_5.append(_join, "");
    _builder_5.newLineIfNotEmpty();
    return _builder_5.toString();
  }
  
  private CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      EList<StandardOperation> _operations = ac.getOperations();
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isConstructor = RoomHelpers.isConstructor(op);
            return Boolean.valueOf(_isConstructor);
          }
        };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      EList<StandardOperation> _operations_1 = ac.getOperations();
      final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isDestructor = op.isDestructor();
            return Boolean.valueOf(_isDestructor);
          }
        };
      Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
      final StandardOperation dtor = IterableExtensions.<StandardOperation>head(_filter_1);
      ActorClass _actorClass = xpac.getActorClass();
      ActorCommunicationType _commType = _actorClass.getCommType();
      final boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
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
      String _name = ac.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* ");
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
      _builder.append("#include \"common/debugging/DebuggingService.h\"");
      _builder.newLine();
      _builder.append("#include <iostream>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append("::");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "");
      _builder.append("(etRuntime::IRTObject* parent, std::string name, const std::vector<std::vector<etRuntime::Address> >& port_addr, ");
      _builder.newLineIfNotEmpty();
      _builder.append(" \t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t\t ");
      _builder.append("const std::vector<std::vector<etRuntime::Address> >& peer_addr)");
      _builder.newLine();
      _builder.append(":  ");
      String _generateConstructorInitalizerList = this.generateConstructorInitalizerList(ac);
      _builder.append(_generateConstructorInitalizerList, "");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine = RoomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\t");
          _builder.append("history = new int[s_numberOfStates];");
          _builder.newLine();
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
      _builder.append(_name_3, "	");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes, false);
      _builder.append(_attributeInitialization, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if (async) {
          _builder.append("\t");
          _builder.append("getMsgsvc()->addAsyncActor(*this);");
          _builder.newLine();
        }
      }
      {
        boolean _notEquals = (!Objects.equal(ctor, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("// user defined constructor body");
          _builder.newLine();
          _builder.append("\t");
          AbstractGenerator _instance = AbstractGenerator.getInstance();
          DetailCode _detailCode = ctor.getDetailCode();
          String _translatedCode = _instance.getTranslatedCode(_detailCode);
          _builder.append(_translatedCode, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_4 = ac.getName();
      _builder.append(_name_4, "");
      _builder.append("::init(){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("initUser();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_5 = ac.getName();
      _builder.append(_name_5, "");
      _builder.append("::start(){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("startUser();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _overridesStop = this._roomExtensions.overridesStop(ac);
        boolean _not = (!_overridesStop);
        if (_not) {
          _builder.append("void ");
          String _name_6 = ac.getName();
          _builder.append(_name_6, "");
          _builder.append("::stop(){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("stopUser();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _name_7 = ac.getName();
      _builder.append(_name_7, "");
      _builder.append("::destroy(){");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals_1 = (!Objects.equal(dtor, null));
        if (_notEquals_1) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("// user defined destructor body");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          AbstractGenerator _instance_1 = AbstractGenerator.getInstance();
          DetailCode _detailCode_1 = dtor.getDetailCode();
          String _translatedCode_1 = _instance_1.getTranslatedCode(_detailCode_1);
          _builder.append(_translatedCode_1, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine_1 = RoomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine_1) {
          CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac, false);
          _builder.append(_genStateMachine, "");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _hasStateMachine = xpac.hasStateMachine();
          boolean _not_1 = (!_hasStateMachine);
          if (_not_1) {
            _builder.append("//--------------------- no state machine");
            _builder.newLine();
            _builder.append("void ");
            String _name_8 = ac.getName();
            _builder.append(_name_8, "");
            _builder.append("::receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("handleSystemEvent(ifitem, evt, data);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
            _builder.append("void ");
            String _name_9 = ac.getName();
            _builder.append(_name_9, "");
            _builder.append("::executeInitTransition(){");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
