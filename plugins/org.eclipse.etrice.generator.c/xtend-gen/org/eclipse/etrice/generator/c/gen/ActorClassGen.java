/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.StateMachineGen;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  protected CExtensions _cExtensions;
  
  @Inject
  @Extension
  protected ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  protected StateMachineGen _stateMachineGen;
  
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  protected IGeneratorFileIo fileIO;
  
  @Inject
  protected ILogger logger;
  
  public void doGenerate(final Root root) {
    final Function1<ActorClass, ExpandedActorClass> _function = (ActorClass it) -> {
      return root.getExpandedActorClass(it);
    };
    List<ExpandedActorClass> _map = ListExtensions.<ActorClass, ExpandedActorClass>map(root.getActorClasses(), _function);
    for (final ExpandedActorClass xpac : _map) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(xpac.getActorClass());
        String _path = this._roomExtensions.getPath(xpac.getActorClass());
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(xpac.getActorClass());
        String _path_1 = this._roomExtensions.getPath(xpac.getActorClass());
        final String infopath = (_generationInfoPath + _path_1);
        String file = this._cExtensions.getCHeaderFileName(xpac.getActorClass());
        this.fileIO.generateFile("generating ActorClass header", path, infopath, file, this.generateHeaderFile(root, xpac));
        file = this._cExtensions.getCUtilsFileName(xpac.getActorClass());
        this.fileIO.generateFile("generating ActorClass utils", path, infopath, file, this.generateUtilsFile(root, xpac));
        boolean _isBehaviorAnnotationPresent = this._roomHelpers.isBehaviorAnnotationPresent(xpac.getActorClass(), "BehaviorManual");
        if (_isBehaviorAnnotationPresent) {
          String _name = xpac.getActorClass().getName();
          String _plus = ("omitting ActorClass source for \'" + _name);
          String _plus_1 = (_plus + "\' since @BehaviorManual is specified");
          this.logger.logInfo(_plus_1);
        } else {
          file = this._cExtensions.getCSourceFileName(xpac.getActorClass());
          this.fileIO.generateFile("generating ActorClass source", path, infopath, file, this.generateSourceFile(root, xpac));
        }
      }
    }
  }
  
  protected CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      final Function1<Port, Boolean> _function = (Port p) -> {
        GeneralProtocolClass _protocol = p.getProtocol();
        CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
        return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
      };
      final Iterable<Port> eventPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function);
      final Function1<Port, Boolean> _function_1 = (Port p) -> {
        return Boolean.valueOf((Objects.equal(((ProtocolClass) p.getProtocol()).getCommType(), CommunicationType.DATA_DRIVEN) && p.isConjugated()));
      };
      final Iterable<Port> sendPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function_1);
      final Function1<Port, Boolean> _function_2 = (Port p) -> {
        return Boolean.valueOf((Objects.equal(((ProtocolClass) p.getProtocol()).getCommType(), CommunicationType.DATA_DRIVEN) && (!p.isConjugated())));
      };
      final Iterable<Port> recvPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function_2);
      ComponentCommunicationType _commType = ac.getCommType();
      final boolean dataDriven = Objects.equal(_commType, ComponentCommunicationType.DATA_DRIVEN);
      ComponentCommunicationType _commType_1 = ac.getCommType();
      final boolean async = Objects.equal(_commType_1, ComponentCommunicationType.ASYNCHRONOUS);
      final boolean hasConstData = ((!(((IterableExtensions.isEmpty(eventPorts) && IterableExtensions.isEmpty(recvPorts)) && this._roomHelpers.getAllSAPs(ac).isEmpty()) && this._roomHelpers.getAllServiceImplementations(ac).isEmpty())) || Main.getSettings().isGenerateMSCInstrumentation());
      final boolean isEmptyStateGraph = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
      final boolean hasVarData = (!(((IterableExtensions.isEmpty(sendPorts) && this._roomHelpers.getAllAttributes(ac).isEmpty()) && isEmptyStateGraph) && (!hasConstData)));
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
      String _name = ac.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(ac);
      _builder.append(_generateIncludeGuardBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.append("#include \"messaging/etMessage.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* include all referenced room classes */");
      _builder.newLine();
      {
        EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
        EList<EnumerationType> _referencedEnumClasses = root.getReferencedEnumClasses(ac);
        Iterable<DataType> _plus = Iterables.<DataType>concat(_referencedDataClasses, _referencedEnumClasses);
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        final Function1<RoomClass, String> _function_3 = (RoomClass it) -> {
          return it.getName();
        };
        List<RoomClass> _sortBy = IterableExtensions.<RoomClass, String>sortBy(Iterables.<RoomClass>concat(_plus, _referencedProtocolClasses), _function_3);
        for(final RoomClass rc : _sortBy) {
          _builder.append("#include ");
          String _includePath = this._cExtensions.getIncludePath(rc);
          _builder.append(_includePath);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1, true);
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("typedef struct ");
      String _name_1 = ac.getName();
      _builder.append(_name_1);
      _builder.append(" ");
      String _name_2 = ac.getName();
      _builder.append(_name_2);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* const part of ActorClass (ROM) */");
      _builder.newLine();
      {
        if (hasConstData) {
          _builder.append("typedef struct ");
          String _name_3 = ac.getName();
          _builder.append(_name_3);
          _builder.append("_const {");
          _builder.newLineIfNotEmpty();
          {
            boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
            if (_isGenerateMSCInstrumentation) {
              _builder.append("\t");
              _builder.append("const char* instName;");
              _builder.newLine();
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("/* simple ports */");
          _builder.newLine();
          {
            for(final Port ep : eventPorts) {
              {
                int _multiplicity = ep.getMultiplicity();
                boolean _equals = (_multiplicity == 1);
                if (_equals) {
                  _builder.append("\t");
                  _builder.append("const ");
                  String _portClassName = this._roomExtensions.getPortClassName(ep);
                  _builder.append(_portClassName, "\t");
                  _builder.append(" ");
                  String _name_4 = ep.getName();
                  _builder.append(_name_4, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* data receive ports */");
          _builder.newLine();
          {
            for(final Port ep_1 : recvPorts) {
              {
                int _multiplicity_1 = ep_1.getMultiplicity();
                boolean _equals_1 = (_multiplicity_1 == 1);
                if (_equals_1) {
                  _builder.append("\t");
                  _builder.append("const ");
                  String _portClassName_1 = this._roomExtensions.getPortClassName(ep_1);
                  _builder.append(_portClassName_1, "\t");
                  _builder.append(" ");
                  String _name_5 = ep_1.getName();
                  _builder.append(_name_5, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* saps */");
          _builder.newLine();
          {
            List<SAP> _allSAPs = this._roomHelpers.getAllSAPs(ac);
            for(final SAP sap : _allSAPs) {
              _builder.append("\t");
              _builder.append("const ");
              String _portClassName_2 = this._roomExtensions.getPortClassName(sap);
              _builder.append(_portClassName_2, "\t");
              _builder.append(" ");
              String _name_6 = sap.getName();
              _builder.append(_name_6, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* replicated ports */");
          _builder.newLine();
          {
            List<Port> _allEndPorts = this._roomHelpers.getAllEndPorts(ac);
            for(final Port ep_2 : _allEndPorts) {
              {
                int _multiplicity_2 = ep_2.getMultiplicity();
                boolean _notEquals = (_multiplicity_2 != 1);
                if (_notEquals) {
                  _builder.append("\t");
                  _builder.append("const etReplPort ");
                  String _name_7 = ep_2.getName();
                  _builder.append(_name_7, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* services */");
          _builder.newLine();
          {
            List<ServiceImplementation> _allServiceImplementations = this._roomHelpers.getAllServiceImplementations(ac);
            for(final ServiceImplementation svc : _allServiceImplementations) {
              _builder.append("\t");
              _builder.append("const etReplPort ");
              String _name_8 = svc.getSpp().getName();
              _builder.append(_name_8, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("} ");
          String _name_9 = ac.getName();
          _builder.append(_name_9);
          _builder.append("_const;");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("/* this actor class has no ports and thus no constant data */");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        if ((!isEmptyStateGraph)) {
          _builder.newLine();
          CharSequence _genHeaderConstants = this._stateMachineGen.genHeaderConstants(xpac);
          _builder.append(_genHeaderConstants);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* variable part of ActorClass (RAM) */");
      _builder.newLine();
      {
        if (hasVarData) {
          _builder.append("struct ");
          String _name_10 = ac.getName();
          _builder.append(_name_10);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          {
            if (hasConstData) {
              _builder.append("\t");
              _builder.append("const ");
              String _name_11 = ac.getName();
              _builder.append(_name_11, "\t");
              _builder.append("_const* const constData;");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("/* data send ports */");
          _builder.newLine();
          {
            for(final Port ep_3 : sendPorts) {
              {
                int _multiplicity_3 = ep_3.getMultiplicity();
                boolean _equals_2 = (_multiplicity_3 == 1);
                if (_equals_2) {
                  _builder.append("\t");
                  String _portClassName_3 = this._roomExtensions.getPortClassName(ep_3);
                  _builder.append(_portClassName_3, "\t");
                  _builder.append(" ");
                  String _name_12 = ep_3.getName();
                  _builder.append(_name_12, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          CharSequence _attributes = this._procedureHelpers.attributes(this._roomHelpers.getAllAttributes(ac));
          _builder.append(_attributes, "\t");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            if ((!isEmptyStateGraph)) {
              _builder.newLine();
              _builder.append("\t");
              CharSequence _genDataMembers = this._stateMachineGen.genDataMembers(xpac);
              _builder.append(_genDataMembers, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        } else {
          _builder.append("struct ");
          String _name_13 = ac.getName();
          _builder.append(_name_13);
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("/* This actor class has no data at all.");
          _builder.newLine();
          _builder.append("\t   ");
          _builder.append("But the private actor instance data is passed to all life cycle functions.");
          _builder.newLine();
          _builder.append("\t   ");
          _builder.append("By introducing the dummy data we keep this case simple");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("int dummy;");
          _builder.newLine();
          _builder.append("};");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _name_14 = ac.getName();
      _builder.append(_name_14);
      _builder.append("_init(");
      String _name_15 = ac.getName();
      _builder.append(_name_15);
      _builder.append("* self);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _name_16 = ac.getName();
      _builder.append(_name_16);
      _builder.append("_receiveMessage(void* self, const void* ifitem, const etMessage* msg);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if ((dataDriven || async)) {
          _builder.append("void ");
          String _name_17 = ac.getName();
          _builder.append(_name_17);
          _builder.append("_execute(");
          String _name_18 = ac.getName();
          _builder.append(_name_18);
          _builder.append("* self);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      String _userStructorsDeclaration = this._procedureHelpers.userStructorsDeclaration(ac);
      _builder.append(_userStructorsDeclaration);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _operationsDeclaration = this._procedureHelpers.operationsDeclaration(this._roomHelpers.getLatestOperations(ac), ac.getName());
      _builder.append(_operationsDeclaration);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2, true);
      _builder.append(_userCode_1);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(ac);
      _builder.append(_generateIncludeGuardEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateUtilsFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      final Function1<Port, Boolean> _function = (Port p) -> {
        GeneralProtocolClass _protocol = p.getProtocol();
        CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
        return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
      };
      final Iterable<Port> eventPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function);
      final Function1<Port, Boolean> _function_1 = (Port it) -> {
        int _multiplicity = it.getMultiplicity();
        return Boolean.valueOf((_multiplicity != 1));
      };
      final Iterable<Port> replEventPorts = IterableExtensions.<Port>filter(eventPorts, _function_1);
      final Function1<Port, Boolean> _function_2 = (Port p) -> {
        return Boolean.valueOf(((Objects.equal(((ProtocolClass) p.getProtocol()).getCommType(), CommunicationType.DATA_DRIVEN) && p.isConjugated()) && (p.getMultiplicity() == 1)));
      };
      final Iterable<Port> sendPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function_2);
      final Function1<Port, Boolean> _function_3 = (Port p) -> {
        return Boolean.valueOf(((Objects.equal(((ProtocolClass) p.getProtocol()).getCommType(), CommunicationType.DATA_DRIVEN) && (!p.isConjugated())) && (p.getMultiplicity() == 1)));
      };
      final Iterable<Port> recvPorts = IterableExtensions.<Port>filter(this._roomHelpers.getAllEndPorts(ac), _function_3);
      final Function1<InterfaceItem, Boolean> _function_4 = (InterfaceItem p) -> {
        return Boolean.valueOf(((!Objects.equal(this._roomHelpers.getPortClass(p), null)) && (this._roomHelpers.getPortClass(p).getOperations().size() > 0)));
      };
      final Iterable<InterfaceItem> portsWithOperations = IterableExtensions.<InterfaceItem>filter(this._roomHelpers.getAllInterfaceItems(ac), _function_4);
      EObject _eContainer = ac.eContainer();
      String _replaceAll = ((RoomModel) _eContainer).getName().replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name = ac.getName();
      String _plus_1 = (_plus + _name);
      final String filename = (_plus_1 + "_Utils");
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
      _builder.append("* Utils File of ActorClass ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(filename);
      _builder.append(_generateIncludeGuardBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include ");
      String _includePath = this._cExtensions.getIncludePath(ac);
      _builder.append(_includePath);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* access macros for ports, operations and attributes");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/* simple event ports */");
      _builder.newLine();
      {
        final Function1<Port, Boolean> _function_5 = (Port it) -> {
          int _multiplicity = it.getMultiplicity();
          return Boolean.valueOf((_multiplicity == 1));
        };
        Iterable<Port> _filter = IterableExtensions.<Port>filter(eventPorts, _function_5);
        for(final Port ep : _filter) {
          {
            List<Message> _outgoing = this._roomHelpers.getOutgoing(ep);
            for(final Message msg : _outgoing) {
              String _xifexpression = null;
              VarDecl _data = msg.getData();
              boolean _notEquals = (!Objects.equal(_data, null));
              if (_notEquals) {
                _xifexpression = "data";
              } else {
                _xifexpression = "";
              }
              final String data1 = _xifexpression;
              _builder.newLineIfNotEmpty();
              String _xifexpression_1 = null;
              VarDecl _data_1 = msg.getData();
              boolean _notEquals_1 = (!Objects.equal(_data_1, null));
              if (_notEquals_1) {
                _xifexpression_1 = ", data";
              } else {
                _xifexpression_1 = "";
              }
              final String data2 = _xifexpression_1;
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_2 = ep.getName();
              _builder.append(_name_2);
              _builder.append("_");
              String _name_3 = msg.getName();
              _builder.append(_name_3);
              _builder.append("(");
              _builder.append(data1);
              _builder.append(") ");
              String _portClassName = this._roomExtensions.getPortClassName(ep);
              _builder.append(_portClassName);
              _builder.append("_");
              String _name_4 = msg.getName();
              _builder.append(_name_4);
              _builder.append("(&self->constData->");
              String _name_5 = ep.getName();
              _builder.append(_name_5);
              _builder.append(data2);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* data receive ports */");
      _builder.newLine();
      {
        for(final Port ep_1 : recvPorts) {
          {
            List<Message> _incoming = this._roomHelpers.getIncoming(ep_1);
            for(final Message msg_1 : _incoming) {
              _builder.append("#define ");
              String _name_6 = ep_1.getName();
              _builder.append(_name_6);
              _builder.append("_");
              String _name_7 = msg_1.getName();
              _builder.append(_name_7);
              _builder.append(" ");
              String _portClassName_1 = this._roomExtensions.getPortClassName(ep_1);
              _builder.append(_portClassName_1);
              _builder.append("_");
              String _name_8 = msg_1.getName();
              _builder.append(_name_8);
              _builder.append("_get(&self->constData->");
              String _name_9 = ep_1.getName();
              _builder.append(_name_9);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* data send ports */");
      _builder.newLine();
      {
        for(final Port ep_2 : sendPorts) {
          {
            List<Message> _outgoing_1 = this._roomHelpers.getOutgoing(ep_2);
            for(final Message msg_2 : _outgoing_1) {
              String _xifexpression_2 = null;
              VarDecl _data_2 = msg_2.getData();
              boolean _notEquals_2 = (!Objects.equal(_data_2, null));
              if (_notEquals_2) {
                _xifexpression_2 = "data";
              } else {
                _xifexpression_2 = "";
              }
              final String data1_1 = _xifexpression_2;
              _builder.newLineIfNotEmpty();
              String _xifexpression_3 = null;
              VarDecl _data_3 = msg_2.getData();
              boolean _notEquals_3 = (!Objects.equal(_data_3, null));
              if (_notEquals_3) {
                _xifexpression_3 = ", data";
              } else {
                _xifexpression_3 = "";
              }
              final String data2_1 = _xifexpression_3;
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_10 = ep_2.getName();
              _builder.append(_name_10);
              _builder.append("_");
              String _name_11 = msg_2.getName();
              _builder.append(_name_11);
              _builder.append("(");
              _builder.append(data1_1);
              _builder.append(") ");
              String _portClassName_2 = this._roomExtensions.getPortClassName(ep_2);
              _builder.append(_portClassName_2);
              _builder.append("_");
              String _name_12 = msg_2.getName();
              _builder.append(_name_12);
              _builder.append("_set(&self->");
              String _name_13 = ep_2.getName();
              _builder.append(_name_13);
              _builder.append(data2_1);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* saps */");
      _builder.newLine();
      {
        List<SAP> _allSAPs = this._roomHelpers.getAllSAPs(ac);
        for(final SAP sap : _allSAPs) {
          {
            List<Message> _outgoing_2 = this._roomHelpers.getOutgoing(sap);
            for(final Message msg_3 : _outgoing_2) {
              String _xifexpression_4 = null;
              VarDecl _data_4 = msg_3.getData();
              boolean _notEquals_4 = (!Objects.equal(_data_4, null));
              if (_notEquals_4) {
                _xifexpression_4 = "data";
              } else {
                _xifexpression_4 = "";
              }
              final String data1_2 = _xifexpression_4;
              _builder.newLineIfNotEmpty();
              String _xifexpression_5 = null;
              VarDecl _data_5 = msg_3.getData();
              boolean _notEquals_5 = (!Objects.equal(_data_5, null));
              if (_notEquals_5) {
                _xifexpression_5 = ", data";
              } else {
                _xifexpression_5 = "";
              }
              final String data2_2 = _xifexpression_5;
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_14 = sap.getName();
              _builder.append(_name_14);
              _builder.append("_");
              String _name_15 = msg_3.getName();
              _builder.append(_name_15);
              _builder.append("(");
              _builder.append(data1_2);
              _builder.append(") ");
              String _portClassName_3 = this._roomExtensions.getPortClassName(sap);
              _builder.append(_portClassName_3);
              _builder.append("_");
              String _name_16 = msg_3.getName();
              _builder.append(_name_16);
              _builder.append("(&self->constData->");
              String _name_17 = sap.getName();
              _builder.append(_name_17);
              _builder.append(data2_2);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* replicated event ports */");
      _builder.newLine();
      {
        boolean _isEmpty = IterableExtensions.isEmpty(replEventPorts);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("#define ifitem_index (((etReplSubPort*)ifitem)->index)");
          _builder.newLine();
        }
      }
      {
        for(final Port ep_3 : replEventPorts) {
          {
            List<Message> _outgoing_3 = this._roomHelpers.getOutgoing(ep_3);
            for(final Message msg_4 : _outgoing_3) {
              String _xifexpression_6 = null;
              VarDecl _data_6 = msg_4.getData();
              boolean _notEquals_6 = (!Objects.equal(_data_6, null));
              if (_notEquals_6) {
                _xifexpression_6 = "data";
              } else {
                _xifexpression_6 = "";
              }
              final String data1_3 = _xifexpression_6;
              _builder.newLineIfNotEmpty();
              String _xifexpression_7 = null;
              VarDecl _data_7 = msg_4.getData();
              boolean _notEquals_7 = (!Objects.equal(_data_7, null));
              if (_notEquals_7) {
                _xifexpression_7 = ", data";
              } else {
                _xifexpression_7 = "";
              }
              final String data2_3 = _xifexpression_7;
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_18 = ep_3.getName();
              _builder.append(_name_18);
              _builder.append("_");
              String _name_19 = msg_4.getName();
              _builder.append(_name_19);
              _builder.append("_broadcast(");
              _builder.append(data1_3);
              _builder.append(") ");
              String _portClassName_4 = this._roomExtensions.getPortClassName(ep_3);
              _builder.append(_portClassName_4);
              _builder.append("_");
              String _name_20 = msg_4.getName();
              _builder.append(_name_20);
              _builder.append("_broadcast(&self->constData->");
              String _name_21 = ep_3.getName();
              _builder.append(_name_21);
              _builder.append(data2_3);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_22 = ep_3.getName();
              _builder.append(_name_22);
              _builder.append("_");
              String _name_23 = msg_4.getName();
              _builder.append(_name_23);
              _builder.append("(idx");
              _builder.append(data2_3);
              _builder.append(") ");
              String _portClassName_5 = this._roomExtensions.getPortClassName(ep_3);
              _builder.append(_portClassName_5);
              _builder.append("_");
              String _name_24 = msg_4.getName();
              _builder.append(_name_24);
              _builder.append("(&self->constData->");
              String _name_25 = ep_3.getName();
              _builder.append(_name_25);
              _builder.append(", idx");
              _builder.append(data2_3);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* services */");
      _builder.newLine();
      {
        List<ServiceImplementation> _allServiceImplementations = this._roomHelpers.getAllServiceImplementations(ac);
        for(final ServiceImplementation svc : _allServiceImplementations) {
          {
            List<Message> _outgoing_4 = this._roomHelpers.getOutgoing(svc.getSpp());
            for(final Message msg_5 : _outgoing_4) {
              String _xifexpression_8 = null;
              VarDecl _data_8 = msg_5.getData();
              boolean _notEquals_8 = (!Objects.equal(_data_8, null));
              if (_notEquals_8) {
                _xifexpression_8 = "data";
              } else {
                _xifexpression_8 = "";
              }
              final String data1_4 = _xifexpression_8;
              _builder.newLineIfNotEmpty();
              String _xifexpression_9 = null;
              VarDecl _data_9 = msg_5.getData();
              boolean _notEquals_9 = (!Objects.equal(_data_9, null));
              if (_notEquals_9) {
                _xifexpression_9 = ", data";
              } else {
                _xifexpression_9 = "";
              }
              final String data2_4 = _xifexpression_9;
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_26 = svc.getSpp().getName();
              _builder.append(_name_26);
              _builder.append("_");
              String _name_27 = msg_5.getName();
              _builder.append(_name_27);
              _builder.append("_broadcast(");
              _builder.append(data1_4);
              _builder.append(") ");
              String _portClassName_6 = this._roomExtensions.getPortClassName(svc.getSpp());
              _builder.append(_portClassName_6);
              _builder.append("_");
              String _name_28 = msg_5.getName();
              _builder.append(_name_28);
              _builder.append("_broadcast(&self->constData->");
              String _name_29 = svc.getSpp().getName();
              _builder.append(_name_29);
              _builder.append(data2_4);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_30 = svc.getSpp().getName();
              _builder.append(_name_30);
              _builder.append("_");
              String _name_31 = msg_5.getName();
              _builder.append(_name_31);
              _builder.append("(idx");
              _builder.append(data2_4);
              _builder.append(") ");
              String _portClassName_7 = this._roomExtensions.getPortClassName(svc.getSpp());
              _builder.append(_portClassName_7);
              _builder.append("_");
              String _name_32 = msg_5.getName();
              _builder.append(_name_32);
              _builder.append("(&self->constData->");
              String _name_33 = svc.getSpp().getName();
              _builder.append(_name_33);
              _builder.append(", idx");
              _builder.append(data2_4);
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("/* operations */");
      _builder.newLine();
      {
        List<StandardOperation> _latestOperations = this._roomHelpers.getLatestOperations(ac);
        for(final StandardOperation op : _latestOperations) {
          final CharSequence args = this.argList(op);
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _name_34 = op.getName();
          _builder.append(_name_34);
          _builder.append("(");
          _builder.append(args);
          _builder.append(") ");
          String _name_35 = ac.getName();
          _builder.append(_name_35);
          _builder.append("_");
          String _name_36 = op.getName();
          _builder.append(_name_36);
          _builder.append("(self");
          {
            boolean _isEmpty_1 = op.getArguments().isEmpty();
            boolean _not_1 = (!_isEmpty_1);
            if (_not_1) {
              _builder.append(", ");
              _builder.append(args);
            }
          }
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* attributes */");
      _builder.newLine();
      {
        List<Attribute> _allAttributes = this._roomHelpers.getAllAttributes(ac);
        for(final Attribute a : _allAttributes) {
          _builder.append("#define ");
          String _name_37 = a.getName();
          _builder.append(_name_37);
          _builder.append(" (self->");
          String _name_38 = a.getName();
          _builder.append(_name_38);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* port operations */");
      _builder.newLine();
      {
        for(final InterfaceItem p : portsWithOperations) {
          {
            EList<PortOperation> _operations = this._roomHelpers.getPortClass(p).getOperations();
            for(final PortOperation op_1 : _operations) {
              final CharSequence args_1 = this.argList(op_1);
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_39 = p.getName();
              _builder.append(_name_39);
              _builder.append("_");
              String _name_40 = op_1.getName();
              _builder.append(_name_40);
              _builder.append("(");
              _builder.append(args_1);
              _builder.append(") ");
              String _portClassName_8 = this._roomExtensions.getPortClassName(p);
              _builder.append(_portClassName_8);
              _builder.append("_");
              String _name_41 = op_1.getName();
              _builder.append(_name_41);
              _builder.append("((");
              String _portClassName_9 = this._roomExtensions.getPortClassName(p);
              _builder.append(_portClassName_9);
              _builder.append("*)&self->constData->");
              String _name_42 = p.getName();
              _builder.append(_name_42);
              {
                boolean _isEmpty_2 = op_1.getArguments().isEmpty();
                boolean _not_2 = (!_isEmpty_2);
                if (_not_2) {
                  _builder.append(", ");
                  _builder.append(args_1);
                }
              }
              _builder.append(")");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(filename);
      _builder.append(_generateIncludeGuardEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence argList(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<VarDecl> _arguments = op.getArguments();
      boolean _hasElements = false;
      for(final VarDecl a : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = a.getName();
        _builder.append(_name);
      }
    }
    return _builder;
  }
  
  protected CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ComponentCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ComponentCommunicationType.ASYNCHRONOUS);
      ComponentCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ComponentCommunicationType.EVENT_DRIVEN);
      ComponentCommunicationType _commType_2 = ac.getCommType();
      final boolean dataDriven = Objects.equal(_commType_2, ComponentCommunicationType.DATA_DRIVEN);
      final boolean handleEvents = (async || eventDriven);
      final boolean isEmptyStateGraph = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
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
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cHeaderFileName = this._cExtensions.getCHeaderFileName(ac);
      _builder.append(_cHeaderFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"modelbase/etActor.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etMSCLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"etUnit/etUnit.h\"");
      _builder.newLine();
      _builder.append("#include \"base/etMemory.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include ");
          String _includePath = this._cExtensions.getIncludePath(pc);
          _builder.append(_includePath);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("#include \"");
      String _cUtilsFileName = this._cExtensions.getCUtilsFileName(ac);
      _builder.append(_cUtilsFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 3, true);
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* interface item IDs */");
      _builder.newLine();
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
      _builder.append(_genInterfaceItemConstants);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if ((!isEmptyStateGraph)) {
          CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac.getGraphContainer());
          _builder.append(_genStateMachine);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _name_1 = ac.getName();
      _builder.append(_name_1);
      _builder.append("_init(");
      String _name_2 = ac.getName();
      _builder.append(_name_2);
      _builder.append("* self){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "\t");
      _builder.append("\", \"init\")");
      _builder.newLineIfNotEmpty();
      {
        if ((!isEmptyStateGraph)) {
          _builder.append("\t");
          CharSequence _genInitialization = this._stateMachineGen.genInitialization(xpac);
          _builder.append(_genInitialization, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_4 = ac.getName();
      _builder.append(_name_4);
      _builder.append("_receiveMessage(void* self, const void* ifitem, const etMessage* msg){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      String _name_5 = ac.getName();
      _builder.append(_name_5, "\t");
      _builder.append("\", \"_receiveMessage\")");
      _builder.newLineIfNotEmpty();
      {
        if ((!isEmptyStateGraph)) {
          {
            if (handleEvents) {
              _builder.append("\t");
              String _operationScope = this.langExt.operationScope(ac.getName(), false);
              _builder.append(_operationScope, "\t");
              _builder.append("receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              String _operationScope_1 = this.langExt.operationScope(ac.getName(), false);
              _builder.append(_operationScope_1, "\t");
              _builder.append("receiveEventInternal(self);");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        if ((dataDriven || async)) {
          _builder.append("void ");
          String _name_6 = ac.getName();
          _builder.append(_name_6);
          _builder.append("_execute(");
          String _name_7 = ac.getName();
          _builder.append(_name_7);
          _builder.append("* self) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
          String _name_8 = ac.getName();
          _builder.append(_name_8, "\t");
          _builder.append("\", \"_execute\")");
          _builder.newLineIfNotEmpty();
          {
            if ((!isEmptyStateGraph)) {
              _builder.newLine();
              {
                if (handleEvents) {
                  _builder.append("\t");
                  String _operationScope_2 = this.langExt.operationScope(ac.getName(), false);
                  _builder.append(_operationScope_2, "\t");
                  _builder.append("receiveEvent(self, NULL, 0, NULL);");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t");
                  String _operationScope_3 = this.langExt.operationScope(ac.getName(), false);
                  _builder.append(_operationScope_3, "\t");
                  _builder.append("receiveEventInternal(self);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      String _userStructorsImplementation = this._procedureHelpers.userStructorsImplementation(ac);
      _builder.append(_userStructorsImplementation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(this._roomHelpers.getLatestOperations(ac), ac.getName());
      _builder.append(_operationsImplementation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
