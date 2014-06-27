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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.StateMachineGen;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private CExtensions _cExtensions;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private StateMachineGen _stateMachineGen;
  
  @Inject
  protected ILanguageExtension langExt;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
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
        final String path = (_generationTargetPath + _path);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_actorClass_2);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _path_1 = this._roomExtensions.getPath(_actorClass_3);
        final String infopath = (_generationInfoPath + _path_1);
        ActorClass _actorClass_4 = xpac.getActorClass();
        String file = this._cExtensions.getCHeaderFileName(_actorClass_4);
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, xpac);
        this.fileIO.generateFile("generating ActorClass header", path, infopath, file, _generateHeaderFile);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String _cUtilsFileName = this._cExtensions.getCUtilsFileName(_actorClass_5);
        file = _cUtilsFileName;
        CharSequence _generateUtilsFile = this.generateUtilsFile(root, xpac);
        this.fileIO.generateFile("generating ActorClass utils", path, infopath, file, _generateUtilsFile);
        ActorClass _actorClass_6 = xpac.getActorClass();
        boolean _isBehaviorAnnotationPresent = RoomHelpers.isBehaviorAnnotationPresent(_actorClass_6, "BehaviorManual");
        if (_isBehaviorAnnotationPresent) {
          ActorClass _actorClass_7 = xpac.getActorClass();
          String _name = _actorClass_7.getName();
          String _plus = ("omitting ActorClass source for \'" + _name);
          String _plus_1 = (_plus + "\' since @BehaviorManual is specified");
          this.logger.logInfo(_plus_1);
        } else {
          ActorClass _actorClass_8 = xpac.getActorClass();
          String _cSourceFileName = this._cExtensions.getCSourceFileName(_actorClass_8);
          file = _cSourceFileName;
          CharSequence _generateSourceFile = this.generateSourceFile(root, xpac);
          this.fileIO.generateFile("generating ActorClass source", path, infopath, file, _generateSourceFile);
        }
      }
    }
  }
  
  private CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      List<Port> _allEndPorts = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
        }
      };
      final Iterable<Port> eventPorts = IterableExtensions.<Port>filter(_allEndPorts, _function);
      List<Port> _allEndPorts_1 = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function_1 = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          boolean _and = false;
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (!_equals) {
            _and = false;
          } else {
            boolean _isConjugated = p.isConjugated();
            _and = _isConjugated;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Port> sendPorts = IterableExtensions.<Port>filter(_allEndPorts_1, _function_1);
      List<Port> _allEndPorts_2 = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function_2 = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          boolean _and = false;
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (!_equals) {
            _and = false;
          } else {
            boolean _isConjugated = p.isConjugated();
            boolean _not = (!_isConjugated);
            _and = _not;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Port> recvPorts = IterableExtensions.<Port>filter(_allEndPorts_2, _function_2);
      ActorCommunicationType _commType = ac.getCommType();
      final boolean dataDriven = Objects.equal(_commType, ActorCommunicationType.DATA_DRIVEN);
      ActorCommunicationType _commType_1 = ac.getCommType();
      final boolean async = Objects.equal(_commType_1, ActorCommunicationType.ASYNCHRONOUS);
      boolean _or = false;
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _isEmpty = IterableExtensions.isEmpty(eventPorts);
      if (!_isEmpty) {
        _and_2 = false;
      } else {
        boolean _isEmpty_1 = IterableExtensions.isEmpty(recvPorts);
        _and_2 = _isEmpty_1;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        List<SAP> _allSAPs = RoomHelpers.getAllSAPs(ac);
        boolean _isEmpty_2 = _allSAPs.isEmpty();
        _and_1 = _isEmpty_2;
      }
      if (!_and_1) {
        _and = false;
      } else {
        List<ServiceImplementation> _allServiceImplementations = RoomHelpers.getAllServiceImplementations(ac);
        boolean _isEmpty_3 = _allServiceImplementations.isEmpty();
        _and = _isEmpty_3;
      }
      boolean _not = (!_and);
      if (_not) {
        _or = true;
      } else {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
        _or = _generateMSCInstrumentation;
      }
      final boolean hasConstData = _or;
      boolean _and_3 = false;
      boolean _and_4 = false;
      boolean _and_5 = false;
      boolean _isEmpty_4 = IterableExtensions.isEmpty(sendPorts);
      if (!_isEmpty_4) {
        _and_5 = false;
      } else {
        List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(ac);
        boolean _isEmpty_5 = _allAttributes.isEmpty();
        _and_5 = _isEmpty_5;
      }
      if (!_and_5) {
        _and_4 = false;
      } else {
        StateGraph _stateMachine = xpac.getStateMachine();
        boolean _isEmpty_6 = RoomHelpers.isEmpty(_stateMachine);
        _and_4 = _isEmpty_6;
      }
      if (!_and_4) {
        _and_3 = false;
      } else {
        _and_3 = (!hasConstData);
      }
      final boolean hasVarData = (!_and_3);
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
      _builder.append("* ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(ac);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.append("#include \"messaging/etMessage.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
        for(final DataClass dataClass : _referencedDataClasses) {
          _builder.append("#include ");
          String _includePath = this._cExtensions.getIncludePath(dataClass);
          _builder.append(_includePath, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<EnumerationType> _referencedEnumClasses = root.getReferencedEnumClasses(ac);
        for(final EnumerationType enumClass : _referencedEnumClasses) {
          _builder.append("#include ");
          String _includePath_1 = this._cExtensions.getIncludePath(enumClass);
          _builder.append(_includePath_1, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include ");
          String _includePath_2 = this._cExtensions.getIncludePath(pc);
          _builder.append(_includePath_2, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1, true);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("typedef struct ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append(" ");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* const part of ActorClass (ROM) */");
      _builder.newLine();
      {
        if (hasConstData) {
          _builder.append("typedef struct ");
          String _name_3 = ac.getName();
          _builder.append(_name_3, "");
          _builder.append("_const {");
          _builder.newLineIfNotEmpty();
          {
            GlobalGeneratorSettings _settings_1 = Main.getSettings();
            boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
            if (_generateMSCInstrumentation_1) {
              _builder.append("\t");
              _builder.append("const char* instName;");
              _builder.newLine();
              _builder.append("\t");
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
          _builder.append("\t");
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
            List<SAP> _allSAPs_1 = RoomHelpers.getAllSAPs(ac);
            for(final SAP sap : _allSAPs_1) {
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* replicated ports */");
          _builder.newLine();
          {
            List<Port> _allEndPorts_3 = RoomHelpers.getAllEndPorts(ac);
            for(final Port ep_2 : _allEndPorts_3) {
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* services */");
          _builder.newLine();
          {
            List<ServiceImplementation> _allServiceImplementations_1 = RoomHelpers.getAllServiceImplementations(ac);
            for(final ServiceImplementation svc : _allServiceImplementations_1) {
              _builder.append("\t");
              _builder.append("const etReplPort ");
              SPP _spp = svc.getSpp();
              String _name_8 = _spp.getName();
              _builder.append(_name_8, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("} ");
          String _name_9 = ac.getName();
          _builder.append(_name_9, "");
          _builder.append("_const;");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("/* this actor class has no ports and thus no constant data */");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        boolean _isEmpty_7 = RoomHelpers.isEmpty(_stateMachine_1);
        boolean _not_1 = (!_isEmpty_7);
        if (_not_1) {
          _builder.newLine();
          CharSequence _genHeaderConstants = this._stateMachineGen.genHeaderConstants(xpac);
          _builder.append(_genHeaderConstants, "");
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
          _builder.append(_name_10, "");
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
              _builder.append("\t");
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          List<Attribute> _allAttributes_1 = RoomHelpers.getAllAttributes(ac);
          CharSequence _attributes = this._procedureHelpers.attributes(_allAttributes_1);
          _builder.append(_attributes, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          {
            StateGraph _stateMachine_2 = xpac.getStateMachine();
            boolean _isEmpty_8 = RoomHelpers.isEmpty(_stateMachine_2);
            boolean _not_2 = (!_isEmpty_8);
            if (_not_2) {
              _builder.append("\t");
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
          _builder.append(_name_13, "");
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
      _builder.append(_name_14, "");
      _builder.append("_init(");
      String _name_15 = ac.getName();
      _builder.append(_name_15, "");
      _builder.append("* self);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _name_16 = ac.getName();
      _builder.append(_name_16, "");
      _builder.append("_receiveMessage(void* self, const void* ifitem, const etMessage* msg);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _or_1 = false;
        if (dataDriven) {
          _or_1 = true;
        } else {
          _or_1 = async;
        }
        if (_or_1) {
          _builder.append("void ");
          String _name_17 = ac.getName();
          _builder.append(_name_17, "");
          _builder.append("_execute(");
          String _name_18 = ac.getName();
          _builder.append(_name_18, "");
          _builder.append("* self);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      EList<StandardOperation> _operations = ac.getOperations();
      String _name_19 = ac.getName();
      CharSequence _operationsDeclaration = this._procedureHelpers.operationsDeclaration(_operations, _name_19);
      _builder.append(_operationsDeclaration, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2, true);
      _builder.append(_userCode_1, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(ac);
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateUtilsFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      List<Port> _allEndPorts = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
        }
      };
      final Iterable<Port> eventPorts = IterableExtensions.<Port>filter(_allEndPorts, _function);
      List<Port> _allEndPorts_1 = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function_1 = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          boolean _and = false;
          boolean _and_1 = false;
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (!_equals) {
            _and_1 = false;
          } else {
            boolean _isConjugated = p.isConjugated();
            _and_1 = _isConjugated;
          }
          if (!_and_1) {
            _and = false;
          } else {
            int _multiplicity = p.getMultiplicity();
            boolean _equals_1 = (_multiplicity == 1);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Port> sendPorts = IterableExtensions.<Port>filter(_allEndPorts_1, _function_1);
      List<Port> _allEndPorts_2 = RoomHelpers.getAllEndPorts(ac);
      final Function1<Port, Boolean> _function_2 = new Function1<Port, Boolean>() {
        public Boolean apply(final Port p) {
          boolean _and = false;
          boolean _and_1 = false;
          GeneralProtocolClass _protocol = p.getProtocol();
          CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (!_equals) {
            _and_1 = false;
          } else {
            boolean _isConjugated = p.isConjugated();
            boolean _not = (!_isConjugated);
            _and_1 = _not;
          }
          if (!_and_1) {
            _and = false;
          } else {
            int _multiplicity = p.getMultiplicity();
            boolean _equals_1 = (_multiplicity == 1);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<Port> recvPorts = IterableExtensions.<Port>filter(_allEndPorts_2, _function_2);
      EObject _eContainer = ac.eContainer();
      String _name = ((RoomModel) _eContainer).getName();
      String _replaceAll = _name.replaceAll("\\.", "_");
      String _plus = (_replaceAll + "_");
      String _name_1 = ac.getName();
      String _plus_1 = (_plus + _name_1);
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
      String _name_2 = ac.getName();
      _builder.append(_name_2, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(filename);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include ");
      String _includePath = this._cExtensions.getIncludePath(ac);
      _builder.append(_includePath, "");
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
        final Function1<Port, Boolean> _function_3 = new Function1<Port, Boolean>() {
          public Boolean apply(final Port it) {
            int _multiplicity = it.getMultiplicity();
            return Boolean.valueOf((_multiplicity == 1));
          }
        };
        Iterable<Port> _filter = IterableExtensions.<Port>filter(eventPorts, _function_3);
        for(final Port ep : _filter) {
          {
            List<Message> _outgoing = RoomHelpers.getOutgoing(ep);
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
              String _name_3 = ep.getName();
              _builder.append(_name_3, "");
              _builder.append("_");
              String _name_4 = msg.getName();
              _builder.append(_name_4, "");
              _builder.append("(");
              _builder.append(data1, "");
              _builder.append(") ");
              String _portClassName = this._roomExtensions.getPortClassName(ep);
              _builder.append(_portClassName, "");
              _builder.append("_");
              String _name_5 = msg.getName();
              _builder.append(_name_5, "");
              _builder.append("(&self->constData->");
              String _name_6 = ep.getName();
              _builder.append(_name_6, "");
              _builder.append(data2, "");
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
            List<Message> _incoming = RoomHelpers.getIncoming(ep_1);
            for(final Message msg_1 : _incoming) {
              _builder.append("#define ");
              String _name_7 = ep_1.getName();
              _builder.append(_name_7, "");
              _builder.append("_");
              String _name_8 = msg_1.getName();
              _builder.append(_name_8, "");
              _builder.append(" ");
              String _portClassName_1 = this._roomExtensions.getPortClassName(ep_1);
              _builder.append(_portClassName_1, "");
              _builder.append("_");
              String _name_9 = msg_1.getName();
              _builder.append(_name_9, "");
              _builder.append("_get(&self->constData->");
              String _name_10 = ep_1.getName();
              _builder.append(_name_10, "");
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
            List<Message> _outgoing_1 = RoomHelpers.getOutgoing(ep_2);
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
              String _name_11 = ep_2.getName();
              _builder.append(_name_11, "");
              _builder.append("_");
              String _name_12 = msg_2.getName();
              _builder.append(_name_12, "");
              _builder.append("(");
              _builder.append(data1_1, "");
              _builder.append(") ");
              String _portClassName_2 = this._roomExtensions.getPortClassName(ep_2);
              _builder.append(_portClassName_2, "");
              _builder.append("_");
              String _name_13 = msg_2.getName();
              _builder.append(_name_13, "");
              _builder.append("_set(&self->");
              String _name_14 = ep_2.getName();
              _builder.append(_name_14, "");
              _builder.append(data2_1, "");
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
        List<SAP> _allSAPs = RoomHelpers.getAllSAPs(ac);
        for(final SAP sap : _allSAPs) {
          {
            List<Message> _outgoing_2 = RoomHelpers.getOutgoing(sap);
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
              String _name_15 = sap.getName();
              _builder.append(_name_15, "");
              _builder.append("_");
              String _name_16 = msg_3.getName();
              _builder.append(_name_16, "");
              _builder.append("(");
              _builder.append(data1_2, "");
              _builder.append(") ");
              String _portClassName_3 = this._roomExtensions.getPortClassName(sap);
              _builder.append(_portClassName_3, "");
              _builder.append("_");
              String _name_17 = msg_3.getName();
              _builder.append(_name_17, "");
              _builder.append("(&self->constData->");
              String _name_18 = sap.getName();
              _builder.append(_name_18, "");
              _builder.append(data2_2, "");
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
        final Function1<Port, Boolean> _function_4 = new Function1<Port, Boolean>() {
          public Boolean apply(final Port it) {
            int _multiplicity = it.getMultiplicity();
            return Boolean.valueOf((_multiplicity != 1));
          }
        };
        Iterable<Port> _filter_1 = IterableExtensions.<Port>filter(eventPorts, _function_4);
        for(final Port ep_3 : _filter_1) {
          {
            List<Message> _outgoing_3 = RoomHelpers.getOutgoing(ep_3);
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
              String _name_19 = ep_3.getName();
              _builder.append(_name_19, "");
              _builder.append("_");
              String _name_20 = msg_4.getName();
              _builder.append(_name_20, "");
              _builder.append("_broadcast(");
              _builder.append(data1_3, "");
              _builder.append(") ");
              String _portClassName_4 = this._roomExtensions.getPortClassName(ep_3);
              _builder.append(_portClassName_4, "");
              _builder.append("_");
              String _name_21 = msg_4.getName();
              _builder.append(_name_21, "");
              _builder.append("_broadcast(&self->constData->");
              String _name_22 = ep_3.getName();
              _builder.append(_name_22, "");
              _builder.append(data2_3, "");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _name_23 = ep_3.getName();
              _builder.append(_name_23, "");
              _builder.append("_");
              String _name_24 = msg_4.getName();
              _builder.append(_name_24, "");
              _builder.append("(idx");
              _builder.append(data2_3, "");
              _builder.append(") ");
              String _portClassName_5 = this._roomExtensions.getPortClassName(ep_3);
              _builder.append(_portClassName_5, "");
              _builder.append("_");
              String _name_25 = msg_4.getName();
              _builder.append(_name_25, "");
              _builder.append("(&self->constData->");
              String _name_26 = ep_3.getName();
              _builder.append(_name_26, "");
              _builder.append(", idx");
              _builder.append(data2_3, "");
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
        List<ServiceImplementation> _allServiceImplementations = RoomHelpers.getAllServiceImplementations(ac);
        for(final ServiceImplementation svc : _allServiceImplementations) {
          {
            SPP _spp = svc.getSpp();
            List<Message> _outgoing_4 = RoomHelpers.getOutgoing(_spp);
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
              SPP _spp_1 = svc.getSpp();
              String _name_27 = _spp_1.getName();
              _builder.append(_name_27, "");
              _builder.append("_");
              String _name_28 = msg_5.getName();
              _builder.append(_name_28, "");
              _builder.append("_broadcast(");
              _builder.append(data1_4, "");
              _builder.append(") ");
              SPP _spp_2 = svc.getSpp();
              String _portClassName_6 = this._roomExtensions.getPortClassName(_spp_2);
              _builder.append(_portClassName_6, "");
              _builder.append("_");
              String _name_29 = msg_5.getName();
              _builder.append(_name_29, "");
              _builder.append("_broadcast(&self->constData->");
              SPP _spp_3 = svc.getSpp();
              String _name_30 = _spp_3.getName();
              _builder.append(_name_30, "");
              _builder.append(data2_4, "");
              _builder.append(")");
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              SPP _spp_4 = svc.getSpp();
              String _name_31 = _spp_4.getName();
              _builder.append(_name_31, "");
              _builder.append("_");
              String _name_32 = msg_5.getName();
              _builder.append(_name_32, "");
              _builder.append("(idx");
              _builder.append(data2_4, "");
              _builder.append(") ");
              SPP _spp_5 = svc.getSpp();
              String _portClassName_7 = this._roomExtensions.getPortClassName(_spp_5);
              _builder.append(_portClassName_7, "");
              _builder.append("_");
              String _name_33 = msg_5.getName();
              _builder.append(_name_33, "");
              _builder.append("(&self->constData->");
              SPP _spp_6 = svc.getSpp();
              String _name_34 = _spp_6.getName();
              _builder.append(_name_34, "");
              _builder.append(", idx");
              _builder.append(data2_4, "");
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
        List<Operation> _allOperations = RoomHelpers.getAllOperations(ac);
        for(final Operation op : _allOperations) {
          final CharSequence args = this.argList(op);
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _name_35 = op.getName();
          _builder.append(_name_35, "");
          _builder.append("(");
          _builder.append(args, "");
          _builder.append(") ");
          String _name_36 = ac.getName();
          _builder.append(_name_36, "");
          _builder.append("_");
          String _name_37 = op.getName();
          _builder.append(_name_37, "");
          _builder.append("(self");
          {
            EList<VarDecl> _arguments = op.getArguments();
            boolean _isEmpty = _arguments.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append(", ");
              _builder.append(args, "");
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
        List<Attribute> _allAttributes = RoomHelpers.getAllAttributes(ac);
        for(final Attribute a : _allAttributes) {
          _builder.append("#define ");
          String _name_38 = a.getName();
          _builder.append(_name_38, "");
          _builder.append(" (self->");
          String _name_39 = a.getName();
          _builder.append(_name_39, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(filename);
      _builder.append(_generateIncludeGuardEnd, "");
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
        _builder.append(_name, "");
      }
    }
    return _builder;
  }
  
  private CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      ActorCommunicationType _commType = ac.getCommType();
      final boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
      ActorCommunicationType _commType_1 = ac.getCommType();
      final boolean eventDriven = Objects.equal(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      ActorCommunicationType _commType_2 = ac.getCommType();
      final boolean dataDriven = Objects.equal(_commType_2, ActorCommunicationType.DATA_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = eventDriven;
      }
      final boolean handleEvents = _or;
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
      String _cHeaderFileName = this._cExtensions.getCHeaderFileName(ac);
      _builder.append(_cHeaderFileName, "");
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
          _builder.append(_includePath, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("#include \"");
      String _cUtilsFileName = this._cExtensions.getCUtilsFileName(ac);
      _builder.append(_cUtilsFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 3, true);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* interface item IDs */");
      _builder.newLine();
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
      _builder.append(_genInterfaceItemConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        boolean _isEmpty = RoomHelpers.isEmpty(_stateMachine);
        boolean _not = (!_isEmpty);
        if (_not) {
          CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac);
          _builder.append(_genStateMachine, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _name_1 = ac.getName();
      _builder.append(_name_1, "");
      _builder.append("_init(");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "");
      _builder.append("* self){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      String _name_3 = ac.getName();
      _builder.append(_name_3, "\t");
      _builder.append("\", \"init\")");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        boolean _isEmpty_1 = RoomHelpers.isEmpty(_stateMachine_1);
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
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
      _builder.append(_name_4, "");
      _builder.append("_receiveMessage(void* self, const void* ifitem, const etMessage* msg){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      String _name_5 = ac.getName();
      _builder.append(_name_5, "\t");
      _builder.append("\", \"_receiveMessage\")");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine_2 = xpac.getStateMachine();
        boolean _isEmpty_2 = RoomHelpers.isEmpty(_stateMachine_2);
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          String _name_6 = ac.getName();
          String _operationScope = this.langExt.operationScope(_name_6, false);
          _builder.append(_operationScope, "\t");
          _builder.append("receiveEvent(self");
          {
            if (handleEvents) {
              _builder.append(", (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage)))");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _or_1 = false;
        if (dataDriven) {
          _or_1 = true;
        } else {
          _or_1 = async;
        }
        if (_or_1) {
          _builder.append("void ");
          String _name_7 = ac.getName();
          _builder.append(_name_7, "");
          _builder.append("_execute(");
          String _name_8 = ac.getName();
          _builder.append(_name_8, "");
          _builder.append("* self) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
          String _name_9 = ac.getName();
          _builder.append(_name_9, "\t");
          _builder.append("\", \"_execute\")");
          _builder.newLineIfNotEmpty();
          {
            StateGraph _stateMachine_3 = xpac.getStateMachine();
            boolean _isEmpty_3 = RoomHelpers.isEmpty(_stateMachine_3);
            boolean _not_3 = (!_isEmpty_3);
            if (_not_3) {
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              String _name_10 = ac.getName();
              String _operationScope_1 = this.langExt.operationScope(_name_10, false);
              _builder.append(_operationScope_1, "\t");
              _builder.append("receiveEvent(self");
              {
                if (handleEvents) {
                  _builder.append(", NULL, 0, NULL");
                }
              }
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      EList<StandardOperation> _operations = ac.getOperations();
      String _name_11 = ac.getName();
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(_operations, _name_11);
      _builder.append(_operationsImplementation, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
