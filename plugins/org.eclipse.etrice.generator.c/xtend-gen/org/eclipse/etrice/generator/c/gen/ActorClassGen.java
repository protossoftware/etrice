package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.StateMachineGen;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private CExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private StateMachineGen stateMachineGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this.roomExt.getPath(_actorClass_1);
        String path = (_generationTargetPath + _path);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(_actorClass_2);
        String _plus = ("generating ActorClass header \'" + _cHeaderFileName);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        CharSequence _generateHeaderFile = this.generateHeaderFile(root, xpac, _actorClass_4);
        this.fileAccess.generateFile(_cHeaderFileName_1, _generateHeaderFile);
        boolean _hasBehaviorAnnotation = this.hasBehaviorAnnotation(xpac, "BehaviorManual");
        if (_hasBehaviorAnnotation) {
          ActorClass _actorClass_5 = xpac.getActorClass();
          String _name = _actorClass_5.getName();
          String _plus_4 = ("omitting ActorClass source for \'" + _name);
          String _plus_5 = (_plus_4 + "\' since @BehaviorManual is specified");
          this.logger.logInfo(_plus_5);
        } else {
          ActorClass _actorClass_6 = xpac.getActorClass();
          String _cSourceFileName = this.stdExt.getCSourceFileName(_actorClass_6);
          String _plus_6 = ("generating ActorClass source \'" + _cSourceFileName);
          String _plus_7 = (_plus_6 + "\' in \'");
          String _plus_8 = (_plus_7 + path);
          String _plus_9 = (_plus_8 + "\'");
          this.logger.logInfo(_plus_9);
          this.fileAccess.setOutputPath(path);
          ActorClass _actorClass_7 = xpac.getActorClass();
          String _cSourceFileName_1 = this.stdExt.getCSourceFileName(_actorClass_7);
          ActorClass _actorClass_8 = xpac.getActorClass();
          CharSequence _generateSourceFile = this.generateSourceFile(root, xpac, _actorClass_8);
          this.fileAccess.generateFile(_cSourceFileName_1, _generateSourceFile);
        }
      }
    }
  }
  
  private boolean hasBehaviorAnnotation(final ExpandedActorClass xpac, final String annotation) {
    ActorClass _actorClass = xpac.getActorClass();
    EList<Annotation> _behaviorAnnotations = _actorClass.getBehaviorAnnotations();
    boolean _notEquals = (!Objects.equal(_behaviorAnnotations, null));
    if (_notEquals) {
      ActorClass _actorClass_1 = xpac.getActorClass();
      EList<Annotation> _behaviorAnnotations_1 = _actorClass_1.getBehaviorAnnotations();
      final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
          public Boolean apply(final Annotation e) {
            String _name = e.getName();
            boolean _equals = Objects.equal(_name, annotation);
            return Boolean.valueOf(_equals);
          }
        };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_behaviorAnnotations_1, _function);
      boolean _notEquals_1 = (!Objects.equal(_findFirst, null));
      if (_notEquals_1) {
        return true;
      }
    }
    return false;
  }
  
  private CharSequence generateHeaderFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      List<Port> _allEndPorts = this.roomExt.getAllEndPorts(ac);
      final Function1<Port,Boolean> _function = new Function1<Port,Boolean>() {
          public Boolean apply(final Port p) {
            GeneralProtocolClass _protocol = p.getProtocol();
            CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
            boolean _equals = Objects.equal(_commType, CommunicationType.EVENT_DRIVEN);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<Port> eventPorts = IterableExtensions.<Port>filter(_allEndPorts, _function);
      List<Port> _allEndPorts_1 = this.roomExt.getAllEndPorts(ac);
      final Function1<Port,Boolean> _function_1 = new Function1<Port,Boolean>() {
          public Boolean apply(final Port p) {
            boolean _and = false;
            GeneralProtocolClass _protocol = p.getProtocol();
            CommunicationType _commType = ((ProtocolClass) _protocol).getCommType();
            boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
            if (!_equals) {
              _and = false;
            } else {
              boolean _isConjugated = p.isConjugated();
              _and = (_equals && _isConjugated);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<Port> sendPorts = IterableExtensions.<Port>filter(_allEndPorts_1, _function_1);
      List<Port> _allEndPorts_2 = this.roomExt.getAllEndPorts(ac);
      final Function1<Port,Boolean> _function_2 = new Function1<Port,Boolean>() {
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
              _and = (_equals && _not);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<Port> recvPorts = IterableExtensions.<Port>filter(_allEndPorts_2, _function_2);
      ActorCommunicationType _commType = ac.getCommType();
      boolean dataDriven = Objects.equal(_commType, ActorCommunicationType.DATA_DRIVEN);
      ActorCommunicationType _commType_1 = ac.getCommType();
      boolean async = Objects.equal(_commType_1, ActorCommunicationType.ASYNCHRONOUS);
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
      String _name_1 = ac.getName();
      CharSequence _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(_name_1);
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.append("#include \"messaging/etMessage.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        HashSet<DataClass> _referencedDataClasses = root.getReferencedDataClasses(ac);
        for(final DataClass dataClass : _referencedDataClasses) {
          _builder.append("#include \"");
          String _name_2 = dataClass.getName();
          _builder.append(_name_2, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include \"");
          String _name_3 = pc.getName();
          _builder.append(_name_3, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      DetailCode _userCode1 = ac.getUserCode1();
      CharSequence _userCode = this.helpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("typedef struct ");
      String _name_4 = ac.getName();
      _builder.append(_name_4, "");
      _builder.append(" ");
      String _name_5 = ac.getName();
      _builder.append(_name_5, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* const part of ActorClass (ROM) */");
      _builder.newLine();
      {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        boolean _isEmpty = IterableExtensions.isEmpty(eventPorts);
        if (!_isEmpty) {
          _and_2 = false;
        } else {
          boolean _isEmpty_1 = IterableExtensions.isEmpty(recvPorts);
          _and_2 = (_isEmpty && _isEmpty_1);
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          List<SAPRef> _allSAPs = this.roomExt.getAllSAPs(ac);
          boolean _isEmpty_2 = _allSAPs.isEmpty();
          _and_1 = (_and_2 && _isEmpty_2);
        }
        if (!_and_1) {
          _and = false;
        } else {
          List<ServiceImplementation> _allServiceImplementations = this.roomExt.getAllServiceImplementations(ac);
          boolean _isEmpty_3 = _allServiceImplementations.isEmpty();
          _and = (_and_1 && _isEmpty_3);
        }
        if (_and) {
          _builder.append("/* this actor class has no ports and thus no constant data */");
          _builder.newLine();
        } else {
          _builder.append("typedef struct ");
          String _name_6 = ac.getName();
          _builder.append(_name_6, "");
          _builder.append("_const {");
          _builder.newLineIfNotEmpty();
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
                  String _portClassName = this.roomExt.getPortClassName(ep);
                  _builder.append(_portClassName, "	");
                  _builder.append(" ");
                  String _name_7 = ep.getName();
                  _builder.append(_name_7, "	");
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
                  String _portClassName_1 = this.roomExt.getPortClassName(ep_1);
                  _builder.append(_portClassName_1, "	");
                  _builder.append(" ");
                  String _name_8 = ep_1.getName();
                  _builder.append(_name_8, "	");
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
            List<SAPRef> _allSAPs_1 = this.roomExt.getAllSAPs(ac);
            for(final SAPRef sap : _allSAPs_1) {
              _builder.append("\t");
              _builder.append("const ");
              String _portClassName_2 = this.roomExt.getPortClassName(sap);
              _builder.append(_portClassName_2, "	");
              _builder.append(" ");
              String _name_9 = sap.getName();
              _builder.append(_name_9, "	");
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
            List<Port> _allEndPorts_3 = this.roomExt.getAllEndPorts(ac);
            for(final Port ep_2 : _allEndPorts_3) {
              {
                int _multiplicity_2 = ep_2.getMultiplicity();
                boolean _notEquals = (_multiplicity_2 != 1);
                if (_notEquals) {
                  _builder.append("\t");
                  _builder.append("const etReplPort ");
                  String _name_10 = ep_2.getName();
                  _builder.append(_name_10, "	");
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
            List<ServiceImplementation> _allServiceImplementations_1 = this.roomExt.getAllServiceImplementations(ac);
            for(final ServiceImplementation svc : _allServiceImplementations_1) {
              _builder.append("\t");
              _builder.append("const etReplPort ");
              SPPRef _spp = svc.getSpp();
              String _name_11 = _spp.getName();
              _builder.append(_name_11, "	");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("} ");
          String _name_12 = ac.getName();
          _builder.append(_name_12, "");
          _builder.append("_const;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        boolean _isEmpty_4 = RoomHelpers.isEmpty(_stateMachine);
        boolean _not = (!_isEmpty_4);
        if (_not) {
          _builder.newLine();
          CharSequence _genHeaderConstants = this.stateMachineGen.genHeaderConstants(xpac, ac);
          _builder.append(_genHeaderConstants, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* variable part of ActorClass (RAM) */");
      _builder.newLine();
      _builder.append("struct ");
      String _name_13 = ac.getName();
      _builder.append(_name_13, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _and_3 = false;
        boolean _and_4 = false;
        boolean _and_5 = false;
        boolean _isEmpty_5 = IterableExtensions.isEmpty(eventPorts);
        if (!_isEmpty_5) {
          _and_5 = false;
        } else {
          boolean _isEmpty_6 = IterableExtensions.isEmpty(recvPorts);
          _and_5 = (_isEmpty_5 && _isEmpty_6);
        }
        if (!_and_5) {
          _and_4 = false;
        } else {
          List<SAPRef> _allSAPs_2 = this.roomExt.getAllSAPs(ac);
          boolean _isEmpty_7 = _allSAPs_2.isEmpty();
          _and_4 = (_and_5 && _isEmpty_7);
        }
        if (!_and_4) {
          _and_3 = false;
        } else {
          List<ServiceImplementation> _allServiceImplementations_2 = this.roomExt.getAllServiceImplementations(ac);
          boolean _isEmpty_8 = _allServiceImplementations_2.isEmpty();
          _and_3 = (_and_4 && _isEmpty_8);
        }
        boolean _not_1 = (!_and_3);
        if (_not_1) {
          _builder.append("\t");
          _builder.append("const ");
          String _name_14 = ac.getName();
          _builder.append(_name_14, "	");
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
              String _portClassName_3 = this.roomExt.getPortClassName(ep_3);
              _builder.append(_portClassName_3, "	");
              _builder.append(" ");
              String _name_15 = ep_3.getName();
              _builder.append(_name_15, "	");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      List<Attribute> _allAttributes = this.roomExt.getAllAttributes(ac);
      CharSequence _attributes = this.helpers.attributes(_allAttributes);
      _builder.append(_attributes, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        List<Attribute> _allAttributes_1 = this.roomExt.getAllAttributes(ac);
        for(final Attribute a : _allAttributes_1) {
          {
            String _defaultValueLiteral = a.getDefaultValueLiteral();
            boolean _notEquals_1 = (!Objects.equal(_defaultValueLiteral, null));
            if (_notEquals_1) {
              String _name_16 = ac.getName();
              String _plus = (_name_16 + " ");
              String _name_17 = a.getName();
              String _plus_1 = (_plus + _name_17);
              String _plus_2 = (_plus_1 + ": Attribute initialization not supported in C");
              this.logger.logInfo(_plus_2);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        boolean _isEmpty_9 = RoomHelpers.isEmpty(_stateMachine_1);
        boolean _not_2 = (!_isEmpty_9);
        if (_not_2) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genDataMembers = this.stateMachineGen.genDataMembers(xpac, ac);
          _builder.append(_genDataMembers, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      String _name_18 = ac.getName();
      _builder.append(_name_18, "");
      _builder.append("_init(");
      String _name_19 = ac.getName();
      _builder.append(_name_19, "");
      _builder.append("* self);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _name_20 = ac.getName();
      _builder.append(_name_20, "");
      _builder.append("_receiveMessage(void* self, void* ifitem, const etMessage* msg);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _or = false;
        if (dataDriven) {
          _or = true;
        } else {
          _or = (dataDriven || async);
        }
        if (_or) {
          _builder.append("void ");
          String _name_21 = ac.getName();
          _builder.append(_name_21, "");
          _builder.append("_execute(");
          String _name_22 = ac.getName();
          _builder.append(_name_22, "");
          _builder.append("* self);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      EList<StandardOperation> _operations = ac.getOperations();
      String _name_23 = ac.getName();
      CharSequence _operationsDeclaration = this.helpers.operationsDeclaration(_operations, _name_23);
      _builder.append(_operationsDeclaration, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      DetailCode _userCode2 = ac.getUserCode2();
      CharSequence _userCode_1 = this.helpers.userCode(_userCode2);
      _builder.append(_userCode_1, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _name_24 = ac.getName();
      CharSequence _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(_name_24);
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateSourceFile(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      ActorCommunicationType _commType = ac.getCommType();
      boolean async = Objects.equal(_commType, ActorCommunicationType.ASYNCHRONOUS);
      ActorCommunicationType _commType_1 = ac.getCommType();
      boolean eventDriven = Objects.equal(_commType_1, ActorCommunicationType.EVENT_DRIVEN);
      ActorCommunicationType _commType_2 = ac.getCommType();
      boolean dataDriven = Objects.equal(_commType_2, ActorCommunicationType.DATA_DRIVEN);
      boolean _or = false;
      if (async) {
        _or = true;
      } else {
        _or = (async || eventDriven);
      }
      boolean handleEvents = _or;
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
      String _cHeaderFileName = this.stdExt.getCHeaderFileName(ac);
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
      _builder.append("#include \"platform/etMemory.h\"");
      _builder.newLine();
      _builder.newLine();
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("#include \"");
          String _cHeaderFileName_1 = this.stdExt.getCHeaderFileName(pc);
          _builder.append(_cHeaderFileName_1, "");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      DetailCode _userCode3 = ac.getUserCode3();
      CharSequence _userCode = this.helpers.userCode(_userCode3);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* interface item IDs */");
      _builder.newLine();
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac, ac);
      _builder.append(_genInterfaceItemConstants, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        StateGraph _stateMachine = xpac.getStateMachine();
        boolean _isEmpty = RoomHelpers.isEmpty(_stateMachine);
        boolean _not = (!_isEmpty);
        if (_not) {
          CharSequence _genStateMachine = this.stateMachineGen.genStateMachine(xpac, ac);
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
      _builder.append(_name_3, "	");
      _builder.append("\", \"init\")");
      _builder.newLineIfNotEmpty();
      {
        StateGraph _stateMachine_1 = xpac.getStateMachine();
        boolean _isEmpty_1 = RoomHelpers.isEmpty(_stateMachine_1);
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\t");
          CharSequence _genInitialization = this.stateMachineGen.genInitialization(xpac, ac);
          _builder.append(_genInitialization, "	");
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
      _builder.append("_receiveMessage(void* self, void* ifitem, const etMessage* msg){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      String _name_5 = ac.getName();
      _builder.append(_name_5, "	");
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
          _or_1 = (dataDriven || async);
        }
        if (_or_1) {
          _builder.append("void ");
          String _name_6 = ac.getName();
          _builder.append(_name_6, "");
          _builder.append("_execute(");
          String _name_7 = ac.getName();
          _builder.append(_name_7, "");
          _builder.append("* self) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
          String _name_8 = ac.getName();
          _builder.append(_name_8, "	");
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
      CharSequence _operationsImplementation = this.helpers.operationsImplementation(ac);
      _builder.append(_operationsImplementation, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
