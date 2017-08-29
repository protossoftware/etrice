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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class ProtocolClassGen extends GenericProtocolClassGenerator {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private CppExtensions stdExt;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private Initialization initHelper;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ProtocolClass> _protocolClasses = root.getProtocolClasses();
    final Function1<ProtocolClass, Boolean> _function = (ProtocolClass cl) -> {
      return Boolean.valueOf(this._fileSystemHelpers.isValidGenerationLocation(cl));
    };
    Iterable<ProtocolClass> _filter = IterableExtensions.<ProtocolClass>filter(_protocolClasses, _function);
    for (final ProtocolClass pc : _filter) {
      {
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(pc);
        String _path = this.roomExt.getPath(pc);
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this.roomExt.getGenerationInfoPath(pc);
        String _path_1 = this.roomExt.getPath(pc);
        final String infopath = (_generationInfoPath + _path_1);
        CommunicationType _commType = pc.getCommType();
        if (_commType != null) {
          switch (_commType) {
            case EVENT_DRIVEN:
              String _cppHeaderFileName = this.stdExt.getCppHeaderFileName(pc);
              CharSequence _generateHeaderFile = this.generateHeaderFile(root, pc);
              this.fileIO.generateFile("generating ProtocolClass declaration", path, infopath, _cppHeaderFileName, _generateHeaderFile);
              String _cppSourceFileName = this.stdExt.getCppSourceFileName(pc);
              CharSequence _generateSourceFile = this.generateSourceFile(root, pc);
              this.fileIO.generateFile("generating ProtocolClass implementation", path, infopath, _cppSourceFileName, _generateSourceFile);
              break;
            case DATA_DRIVEN:
              String _cppHeaderFileName_1 = this.stdExt.getCppHeaderFileName(pc);
              CharSequence _generateDataDrivenHeaderFile = this.generateDataDrivenHeaderFile(root, pc);
              this.fileIO.generateFile("generating ProtocolClass declaration", path, infopath, _cppHeaderFileName_1, _generateDataDrivenHeaderFile);
              String _cppSourceFileName_1 = this.stdExt.getCppSourceFileName(pc);
              CharSequence _generateDataDrivenSourceFile = this.generateDataDrivenSourceFile(root, pc);
              this.fileIO.generateFile("generating ProtocolClass implementation", path, infopath, _cppSourceFileName_1, _generateDataDrivenSourceFile);
              break;
            case SYNCHRONOUS:
              this.logger.logError("synchronous protocols not supported yet", pc);
              break;
            default:
              break;
          }
        }
      }
    }
  }
  
  protected CharSequence generateHeaderFile(final Root root, final ProtocolClass pc) {
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
    _builder.append("* Header File of ProtocolClass ");
    String _name = pc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(pc, "");
    _builder.append(_generateIncludeGuardBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
    _builder.newLine();
    _builder.append("#include \"common/modelbase/PortBase.h\"");
    _builder.newLine();
    _builder.append("#include \"common/modelbase/ReplicatedInterfaceItemBase.h\"");
    _builder.newLine();
    _builder.append("#include \"common/modelbase/ReplicatedPortBase.h\"");
    _builder.newLine();
    _builder.append("#include \"common/etDatatypesCpp.hpp\"");
    _builder.newLine();
    _builder.newLine();
    {
      EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(pc);
      for(final DataClass dataClass : _referencedDataClasses) {
        _builder.append("#include \"");
        String _path = this.roomExt.getPath(dataClass);
        _builder.append(_path, "");
        String _name_1 = dataClass.getName();
        _builder.append(_name_1, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    DetailCode _userCode1 = pc.getUserCode1();
    CharSequence _userCode = this.helpers.userCode(_userCode1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(pc);
    _builder.append(_generateNamespaceBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _name_2 = pc.getName();
    _builder.append(_name_2, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("public:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/* message IDs */");
    _builder.newLine();
    _builder.append("\t\t");
    String _genMessageIDs = this.genMessageIDs(pc);
    _builder.append(_genMessageIDs, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _userCode_1 = this.helpers.userCode(pc, 2);
    _builder.append(_userCode_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static bool isValidEvtID(int evtId) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ((MSG_MIN < evtId) && (evtId < MSG_MAX));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static bool isValidOutgoingEvtID(int evtId) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ((MSG_MIN < evtId) && (evtId < ");
    {
      EList<Message> _incomingMessages = pc.getIncomingMessages();
      int _size = _incomingMessages.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        _builder.append("MSG_MAX");
      } else {
        _builder.append("IN_");
        EList<Message> _incomingMessages_1 = pc.getIncomingMessages();
        Message _get = _incomingMessages_1.get(0);
        String _name_3 = _get.getName();
        _builder.append(_name_3, "\t\t\t");
      }
    }
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static bool isValidIncomingEvtID(int evtId) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ((");
    {
      EList<Message> _incomingMessages_2 = pc.getIncomingMessages();
      int _size_1 = _incomingMessages_2.size();
      boolean _equals_1 = (_size_1 == 0);
      if (_equals_1) {
        _builder.append("MSG_MAX");
      } else {
        _builder.append("IN_");
        EList<Message> _incomingMessages_3 = pc.getIncomingMessages();
        Message _get_1 = _incomingMessages_3.get(0);
        String _name_4 = _get_1.getName();
        _builder.append(_name_4, "\t\t\t");
      }
    }
    _builder.append(" <= evtId) && (evtId < MSG_MAX));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static const etRuntime::String& getMessageString(int msg_id);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static const etRuntime::String s_messageStrings[];");
    _builder.newLine();
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    CharSequence _portClassDeclaration = this.portClassDeclaration(pc, false);
    _builder.append(_portClassDeclaration, "");
    _builder.newLineIfNotEmpty();
    CharSequence _portClassDeclaration_1 = this.portClassDeclaration(pc, true);
    _builder.append(_portClassDeclaration_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(pc);
    _builder.append(_generateNamespaceEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(pc, "");
    _builder.append(_generateIncludeGuardEnd, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence portClassDeclaration(final ProtocolClass pc, final boolean conj) {
    CharSequence _xblockexpression = null;
    {
      PortClass pclass = this.roomExt.getPortClass(pc, conj);
      String portClassName = this.roomExt.getPortClassName(pc, conj);
      String replPortClassName = this.roomExt.getPortClassName(pc, conj, true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("// ");
      {
        if (conj) {
          _builder.append("conjugated ");
        }
      }
      _builder.append("port class");
      _builder.newLineIfNotEmpty();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("class ");
      _builder.append(portClassName, "");
      _builder.append(" : public etRuntime::PortBase {");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(pclass, null));
        if (_notEquals) {
          _builder.append("\t");
          DetailCode _userCode = pclass.getUserCode();
          CharSequence _userCode_1 = this.helpers.userCode(_userCode);
          _builder.append(_userCode_1, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("   ");
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append(portClassName, "\t ");
      _builder.append("(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t ");
      _builder.append(portClassName, "\t ");
      _builder.append("(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId, int idx);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t");
          _builder.append("virtual void destroy();");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("virtual void receive(const etRuntime::Message* m);");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _notEquals_1 = (!Objects.equal(pclass, null));
        if (_notEquals_1) {
          _builder.append("\t");
          EList<Attribute> _attributes = pclass.getAttributes();
          CharSequence _attributes_1 = this.helpers.attributes(_attributes);
          _builder.append(_attributes_1, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          EList<PortOperation> _operations = pclass.getOperations();
          CharSequence _operationsDeclaration = this.helpers.operationsDeclaration(_operations, portClassName);
          _builder.append(_operationsDeclaration, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("// sent messages");
      _builder.newLine();
      {
        List<Message> _allMessages = this._roomHelpers.getAllMessages(pc, conj);
        for(final Message m : _allMessages) {
          _builder.append("\t");
          CharSequence _messageSignature = this.messageSignature(m, false);
          _builder.append(_messageSignature, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _messageSignature_1 = this.messageSignature(m, true);
          _builder.append(_messageSignature_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("// ");
      {
        if (conj) {
          _builder.append("conjugated ");
        }
      }
      _builder.append("replicated port class");
      _builder.newLineIfNotEmpty();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("class ");
      _builder.append(replPortClassName, "");
      _builder.append(" : public etRuntime::ReplicatedPortBase {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(replPortClassName, "\t\t");
      _builder.append("(etRuntime::IInterfaceItemOwner* actor, const etRuntime::String& name, int localId);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int getReplication() const { return getNInterfaceItems(); }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int getIndexOf(const etRuntime::InterfaceItemBase& ifitem) const { return ifitem.getIdx(); }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(portClassName, "\t\t");
      _builder.append("& get(int idx) const { return *dynamic_cast<");
      _builder.append(portClassName, "\t\t");
      _builder.append("*>(getInterfaceItem(idx)); }");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if (conj) {
          _builder.append("\t\t");
          _builder.append("// incoming messages");
          _builder.newLine();
          {
            List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
            for(final Message m_1 : _allIncomingMessages) {
              _builder.append("\t\t");
              CharSequence _messageSignature_2 = this.messageSignature(m_1, false);
              _builder.append(_messageSignature_2, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          _builder.append("\t\t");
          _builder.append("// outgoing messages");
          _builder.newLine();
          {
            List<Message> _allOutgoingMessages = this._roomHelpers.getAllOutgoingMessages(pc);
            for(final Message m_2 : _allOutgoingMessages) {
              _builder.append("\t\t");
              CharSequence _messageSignature_3 = this.messageSignature(m_2, false);
              _builder.append(_messageSignature_3, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual etRuntime::InterfaceItemBase* createInterfaceItem(etRuntime::IInterfaceItemOwner* rcv, const etRuntime::String& name, int lid, int idx) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return new ");
      _builder.append(portClassName, "\t\t\t");
      _builder.append("(rcv, name, lid, idx);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateSourceFile(final Root root, final ProtocolClass pc) {
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
    _builder.append("* Source File of ProtocolClass ");
    String _name = pc.getName();
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
    String _cppHeaderFileName = this.stdExt.getCppHeaderFileName(pc);
    _builder.append(_cppHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"common/debugging/DebuggingService.h\"");
    _builder.newLine();
    _builder.append("#include \"common/debugging/MSCFunctionObject.h\"");
    _builder.newLine();
    _builder.append("#include \"common/messaging/AbstractMessageReceiver.h\"");
    _builder.newLine();
    _builder.append("#include \"common/messaging/Address.h\"");
    _builder.newLine();
    _builder.append("#include \"common/messaging/Message.h\"");
    _builder.newLine();
    _builder.append("#include \"common/modelbase/IEventReceiver.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("using namespace etRuntime;");
    _builder.newLine();
    _builder.newLine();
    String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(pc);
    _builder.append(_generateNamespaceBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _userCode = this.helpers.userCode(pc, 3);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* message names as strings for debugging (generate MSC) */");
    _builder.newLine();
    _builder.append("const String ");
    String _name_1 = pc.getName();
    _builder.append(_name_1, "");
    _builder.append("::s_messageStrings[] = {\"MIN\", ");
    {
      List<Message> _allOutgoingMessages = this._roomHelpers.getAllOutgoingMessages(pc);
      for(final Message m : _allOutgoingMessages) {
        _builder.append("\"");
        String _name_2 = m.getName();
        _builder.append(_name_2, "");
        _builder.append("\",");
      }
    }
    _builder.append(" ");
    {
      List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
      for(final Message m_1 : _allIncomingMessages) {
        _builder.append("\"");
        String _name_3 = m_1.getName();
        _builder.append(_name_3, "");
        _builder.append("\",");
      }
    }
    _builder.append("\"MAX\"};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const String& ");
    String _name_4 = pc.getName();
    _builder.append(_name_4, "");
    _builder.append("::getMessageString(int msg_id) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return s_messageStrings[msg_id];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// id out of range");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static const String errorMsg = \"Message ID out of range\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return errorMsg;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _portClassImplementation = this.portClassImplementation(pc, false);
    _builder.append(_portClassImplementation, "");
    _builder.newLineIfNotEmpty();
    CharSequence _portClassImplementation_1 = this.portClassImplementation(pc, true);
    _builder.append(_portClassImplementation_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(pc);
    _builder.append(_generateNamespaceEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence portClassImplementation(final ProtocolClass pc, final boolean conj) {
    CharSequence _xblockexpression = null;
    {
      PortClass pclass = this.roomExt.getPortClass(pc, conj);
      String portClassName = this.roomExt.getPortClassName(pc, conj);
      String replPortClassName = this.roomExt.getPortClassName(pc, conj, true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("// ");
      {
        if (conj) {
          _builder.append("conjugated ");
        }
      }
      _builder.append("port class");
      _builder.newLineIfNotEmpty();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.newLine();
      _builder.append(portClassName, "");
      _builder.append("::");
      _builder.append(portClassName, "");
      _builder.append("(IInterfaceItemOwner* actor, const String& name, int localId)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _generateConstructorInitalizerList = this.generateConstructorInitalizerList(pclass, "0");
      _builder.append(_generateConstructorInitalizerList, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append(portClassName, "");
      _builder.append("::");
      _builder.append(portClassName, "");
      _builder.append("(IInterfaceItemOwner* actor, const String& name, int localId, int idx)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _generateConstructorInitalizerList_1 = this.generateConstructorInitalizerList(pclass, "idx");
      _builder.append(_generateConstructorInitalizerList_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      {
        boolean _notEquals = (!Objects.equal(pclass, null));
        if (_notEquals) {
          EList<Attribute> _attributes = pclass.getAttributes();
          CharSequence _genExtraInitializers = this.initHelper.genExtraInitializers(_attributes);
          _builder.append(_genExtraInitializers, "\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.newLine();
          _builder.append("void ");
          _builder.append(portClassName, "");
          _builder.append("::destroy() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().removePortInstance(*this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("PortBase::destroy();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      _builder.append(portClassName, "");
      _builder.append("::receive(const Message* msg) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// TODO JH further");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (! ");
      String _name = pc.getName();
      _builder.append(_name, "\t");
      _builder.append("::");
      {
        if (conj) {
          _builder.append("isValidOutgoingEvtID");
        } else {
          _builder.append("isValidIncomingEvtID");
        }
      }
      _builder.append("(msg->getEvtId())) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("//std::cout << \"unknown\" << std::endl;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        GlobalGeneratorSettings _settings_1 = Main.getSettings();
        boolean _isGenerateMSCInstrumentation_1 = _settings_1.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), ");
          String _name_1 = pc.getName();
          _builder.append(_name_1, "\t");
          _builder.append("::getMessageString(msg->getEvtId()).c_str());");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        boolean _handlesReceive = this.roomExt.handlesReceive(pc, conj);
        if (_handlesReceive) {
          _builder.append("\t");
          _builder.append("switch (msg->getEvtId()) {");
          _builder.newLine();
          {
            List<MessageHandler> _receiveHandlers = this.roomExt.getReceiveHandlers(pc, conj);
            for(final MessageHandler hdlr : _receiveHandlers) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("case ");
              String _name_2 = pc.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append("::");
              Message _msg = hdlr.getMsg();
              String _codeName = this.roomExt.getCodeName(_msg);
              _builder.append(_codeName, "\t\t");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("{");
              _builder.newLine();
              {
                DetailCode _detailCode = hdlr.getDetailCode();
                EList<String> _lines = _detailCode.getLines();
                for(final String command : _lines) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append(command, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("default:");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("getActor()->receiveEvent(this, msg->getEvtId(),\tmsg->getData());");
      _builder.newLine();
      {
        boolean _handlesReceive_1 = this.roomExt.handlesReceive(pc, conj);
        if (_handlesReceive_1) {
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("break;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _notEquals_1 = (!Objects.equal(pclass, null));
        if (_notEquals_1) {
          EList<PortOperation> _operations = pclass.getOperations();
          CharSequence _operationsImplementation = this.helpers.operationsImplementation(_operations, portClassName);
          _builder.append(_operationsImplementation, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("// sent messages");
      _builder.newLine();
      {
        List<Message> _allMessages = this._roomHelpers.getAllMessages(pc, conj);
        for(final Message m : _allMessages) {
          String _name_3 = pc.getName();
          CharSequence _sendMessage = this.sendMessage(m, _name_3, portClassName, conj);
          _builder.append(_sendMessage, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append("// ");
      {
        if (conj) {
          _builder.append("conjugated ");
        }
      }
      _builder.append("replicated port class");
      _builder.newLineIfNotEmpty();
      _builder.append("//------------------------------------------------------------------------------------------------------------");
      _builder.newLine();
      _builder.append(replPortClassName, "");
      _builder.append("::");
      _builder.append(replPortClassName, "");
      _builder.append("(IInterfaceItemOwner* actor, const String& name, int localId) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("ReplicatedPortBase(actor, name, localId)");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        if (conj) {
          _builder.append("// incoming messages");
          _builder.newLine();
          {
            List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
            for(final Message m_1 : _allIncomingMessages) {
              CharSequence _messageSignatureDefinition = this.messageSignatureDefinition(m_1, replPortClassName, false);
              _builder.append(_messageSignatureDefinition, "");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("for (Vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("(dynamic_cast<");
              _builder.append(portClassName, "\t\t");
              _builder.append("*>(*it))->");
              CharSequence _messageCall = this.messageCall(m_1, false);
              _builder.append(_messageCall, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            }
          }
        } else {
          _builder.append("// outgoing messages");
          _builder.newLine();
          {
            List<Message> _allOutgoingMessages = this._roomHelpers.getAllOutgoingMessages(pc);
            for(final Message m_2 : _allOutgoingMessages) {
              CharSequence _messageSignatureDefinition_1 = this.messageSignatureDefinition(m_2, replPortClassName, false);
              _builder.append(_messageSignatureDefinition_1, "");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("for (Vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("(dynamic_cast<");
              _builder.append(portClassName, "\t\t");
              _builder.append("*>(*it))->");
              CharSequence _messageCall_1 = this.messageCall(m_2, false);
              _builder.append(_messageCall_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateConstructorInitalizerList(final PortClass pc, final String index) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      final List<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PortBase(actor, name, localId, ");
      _builder.append(index, "");
      _builder.append(")");
      initList.add(_builder.toString());
      boolean _notEquals = (!Objects.equal(pc, null));
      if (_notEquals) {
        EList<Attribute> _attributes = pc.getAttributes();
        final Function1<Attribute, String> _function = (Attribute it) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name = it.getName();
          _builder_1.append(_name, "");
          _builder_1.append("(");
          String _initializerListValue = initHelper.getInitializerListValue(it);
          _builder_1.append(_initializerListValue, "");
          _builder_1.append(")");
          return _builder_1.toString();
        };
        List<String> _map = ListExtensions.<Attribute, String>map(_attributes, _function);
        Iterables.<CharSequence>addAll(initList, _map);
      }
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  protected CharSequence messageCall(final Message m, final boolean impl) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = m.getName();
    _builder.append(_name, "");
    {
      if (impl) {
        _builder.append("_impl");
      }
    }
    _builder.append("(");
    {
      VarDecl _data = m.getData();
      boolean _notEquals = (!Objects.equal(_data, null));
      if (_notEquals) {
        _builder.append(" ");
        VarDecl _data_1 = m.getData();
        String _name_1 = _data_1.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence messageSignature(final Message m, final boolean impl) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((m.isPriv() || impl)) {
        _builder.append("private:");
      } else {
        _builder.append("public:");
      }
    }
    _builder.append(" void ");
    String _name = m.getName();
    _builder.append(_name, "");
    {
      if (impl) {
        _builder.append("_impl");
      }
    }
    _builder.append("(");
    {
      VarDecl _data = m.getData();
      boolean _notEquals = (!Objects.equal(_data, null));
      if (_notEquals) {
        VarDecl _data_1 = m.getData();
        RefableType _refType = _data_1.getRefType();
        String _signatureString = this.helpers.signatureString(_refType);
        _builder.append(_signatureString, "");
        _builder.append(" ");
        VarDecl _data_2 = m.getData();
        String _name_1 = _data_2.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence messageSignatureDefinition(final Message m, final String classPrefix, final boolean impl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    _builder.append(classPrefix, "");
    _builder.append("::");
    String _name = m.getName();
    _builder.append(_name, "");
    {
      if (impl) {
        _builder.append("_impl");
      }
    }
    _builder.append("(");
    {
      VarDecl _data = m.getData();
      boolean _notEquals = (!Objects.equal(_data, null));
      if (_notEquals) {
        VarDecl _data_1 = m.getData();
        RefableType _refType = _data_1.getRefType();
        String _signatureString = this.helpers.signatureString(_refType);
        _builder.append(_signatureString, "");
        _builder.append(" ");
        VarDecl _data_2 = m.getData();
        String _name_1 = _data_2.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence sendMessage(final Message m, final String portClassName, final String classPrefix, final boolean conj) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      if (conj) {
        _xifexpression = "IN";
      } else {
        _xifexpression = "OUT";
      }
      String dir = _xifexpression;
      MessageHandler hdlr = this.roomExt.getSendHandler(m, conj);
      String _xifexpression_1 = null;
      VarDecl _data = m.getData();
      boolean _notEquals = (!Objects.equal(_data, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(", ");
        VarDecl _data_1 = m.getData();
        String _name = _data_1.getName();
        _builder.append(_name, "");
        _xifexpression_1 = _builder.toString();
      }
      final String dataArg = _xifexpression_1;
      String _xifexpression_2 = null;
      if (((!Objects.equal(m.getData(), null)) && (!m.getData().getRefType().isRef()))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("DataMessage<");
        VarDecl _data_2 = m.getData();
        RefableType _refType = _data_2.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder_1.append(_typeName, "");
        _builder_1.append(">");
        _xifexpression_2 = _builder_1.toString();
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Message");
        _xifexpression_2 = _builder_2.toString();
      }
      final String messageType = _xifexpression_2;
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("new (buffer) ");
      _builder_3.append(messageType, "");
      _builder_3.append("(getPeerAddress(), ");
      _builder_3.append(portClassName, "");
      _builder_3.append("::");
      _builder_3.append(dir, "");
      _builder_3.append("_");
      String _name_1 = m.getName();
      _builder_3.append(_name_1, "");
      String _elvis = null;
      if (dataArg != null) {
        _elvis = dataArg;
      } else {
        _elvis = "";
      }
      _builder_3.append(_elvis, "");
      _builder_3.append(")");
      final String message = _builder_3.toString();
      StringConcatenation _builder_4 = new StringConcatenation();
      CharSequence _messageSignatureDefinition = this.messageSignatureDefinition(m, classPrefix, false);
      _builder_4.append(_messageSignatureDefinition, "");
      _builder_4.append(" {");
      _builder_4.newLineIfNotEmpty();
      {
        boolean _notEquals_1 = (!Objects.equal(hdlr, null));
        if (_notEquals_1) {
          _builder_4.append("\t");
          {
            DetailCode _detailCode = hdlr.getDetailCode();
            EList<String> _lines = _detailCode.getLines();
            for(final String command : _lines) {
              _builder_4.append("\t");
              _builder_4.append(command, "\t");
              _builder_4.newLineIfNotEmpty();
            }
          }
        } else {
          _builder_4.append("\t");
          CharSequence _messageCall = this.messageCall(m, true);
          _builder_4.append(_messageCall, "\t");
          _builder_4.append(";");
          _builder_4.newLineIfNotEmpty();
        }
      }
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.newLine();
      CharSequence _messageSignatureDefinition_1 = this.messageSignatureDefinition(m, classPrefix, true);
      _builder_4.append(_messageSignatureDefinition_1, "");
      _builder_4.append(" {");
      _builder_4.newLineIfNotEmpty();
      {
        GlobalGeneratorSettings _settings = Main.getSettings();
        boolean _isGenerateMSCInstrumentation = _settings.isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder_4.append("\t");
          _builder_4.append("DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),");
          _builder_4.newLine();
          _builder_4.append("\t");
          _builder_4.append("\t");
          _builder_4.append(portClassName, "\t\t");
          _builder_4.append("::getMessageString(");
          _builder_4.append(portClassName, "\t\t");
          _builder_4.append("::");
          _builder_4.append(dir, "\t\t");
          _builder_4.append("_");
          String _name_2 = m.getName();
          _builder_4.append(_name_2, "\t\t");
          _builder_4.append(").c_str());");
          _builder_4.newLineIfNotEmpty();
        }
      }
      _builder_4.append("\t");
      _builder_4.append("if (getPeerAddress().isValid()) {");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Message* buffer = dynamic_cast<IMessageService*>(getPeerMsgReceiver())->getMessageBuffer(sizeof(");
      _builder_4.append(messageType, "\t\t");
      _builder_4.append("));");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("\t\t");
      _builder_4.append("if (buffer) {");
      _builder_4.newLine();
      _builder_4.append("\t\t\t");
      _builder_4.append("getPeerMsgReceiver()->receive(");
      _builder_4.append(message, "\t\t\t");
      _builder_4.append(");");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("\t\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      _xblockexpression = _builder_4;
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateDataDrivenHeaderFile(final Root root, final ProtocolClass pc) {
    CharSequence _xblockexpression = null;
    {
      List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
      final Function1<Message, Boolean> _function = (Message m) -> {
        VarDecl _data = m.getData();
        return Boolean.valueOf((!Objects.equal(_data, null)));
      };
      final Iterable<Message> sentMsgs = IterableExtensions.<Message>filter(_allIncomingMessages, _function);
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
      _builder.append("* Header File of ProtocolClass ");
      String _name = pc.getName();
      _builder.append(_name, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(pc, "");
      _builder.append(_generateIncludeGuardBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/etDatatypesCpp.hpp\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/DataPort.h\"");
      _builder.newLine();
      {
        EList<DataClass> _referencedDataClasses = root.getReferencedDataClasses(pc);
        for(final DataClass dataClass : _referencedDataClasses) {
          _builder.append("#include \"");
          String _path = this.roomExt.getPath(dataClass);
          _builder.append(_path, "");
          String _name_1 = dataClass.getName();
          _builder.append(_name_1, "");
          _builder.append(".h\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      DetailCode _userCode1 = pc.getUserCode1();
      CharSequence _userCode = this.helpers.userCode(_userCode1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(pc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name_2 = pc.getName();
      _builder.append(_name_2, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      DetailCode _userCode2 = pc.getUserCode2();
      CharSequence _userCode_1 = this.helpers.userCode(_userCode2);
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// send port holds data");
      _builder.newLine();
      _builder.append("class ");
      String _portClassName = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName, "");
      _builder.append(" : public etRuntime::DataSendPort {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t");
      String _portClassName_1 = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName_1, "\t");
      _builder.append("(etRuntime::IRTObject* parent, const etRuntime::String& name, int localId);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// getters and setters");
      _builder.newLine();
      {
        for(final Message msg : sentMsgs) {
          _builder.append("\t");
          _builder.append("void ");
          String _name_3 = msg.getName();
          _builder.append(_name_3, "\t");
          _builder.append("(");
          VarDecl _data = msg.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          String _typeName = this._typeHelpers.typeName(_type);
          _builder.append(_typeName, "\t");
          _builder.append(" ");
          String _name_4 = msg.getName();
          _builder.append(_name_4, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("m_");
          String _name_5 = msg.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append(" = ");
          String _name_6 = msg.getName();
          _builder.append(_name_6, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          VarDecl _data_1 = msg.getData();
          RefableType _refType_1 = _data_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          String _typeName_1 = this._typeHelpers.typeName(_type_1);
          _builder.append(_typeName_1, "\t");
          _builder.append(" ");
          String _name_7 = msg.getName();
          _builder.append(_name_7, "\t");
          _builder.append("() const {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return m_");
          String _name_8 = msg.getName();
          _builder.append(_name_8, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("private:");
      _builder.newLine();
      {
        for(final Message msg_1 : sentMsgs) {
          _builder.append("\t");
          VarDecl _data_2 = msg_1.getData();
          RefableType _refType_2 = _data_2.getRefType();
          DataType _type_2 = _refType_2.getType();
          String _typeName_2 = this._typeHelpers.typeName(_type_2);
          _builder.append(_typeName_2, "\t");
          _builder.append(" m_");
          String _name_9 = msg_1.getName();
          _builder.append(_name_9, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// receive port accesses send port");
      _builder.newLine();
      _builder.append("class ");
      String _portClassName_2 = this.roomExt.getPortClassName(pc, false);
      _builder.append(_portClassName_2, "");
      _builder.append(" : public etRuntime::DataReceivePort {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public:");
      _builder.newLine();
      _builder.append("\t");
      String _portClassName_3 = this.roomExt.getPortClassName(pc, false);
      _builder.append(_portClassName_3, "\t");
      _builder.append("(etRuntime::IRTObject* parent, const etRuntime::String& name, int localId);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// getters");
      _builder.newLine();
      {
        for(final Message msg_2 : sentMsgs) {
          _builder.append("\t");
          VarDecl _data_3 = msg_2.getData();
          RefableType _refType_3 = _data_3.getRefType();
          DataType _type_3 = _refType_3.getType();
          String _typeName_3 = this._typeHelpers.typeName(_type_3);
          _builder.append(_typeName_3, "\t");
          _builder.append(" ");
          String _name_10 = msg_2.getName();
          _builder.append(_name_10, "\t");
          _builder.append("() const;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("protected:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("virtual void connect(etRuntime::DataSendPort* dataSendPort);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("private:");
      _builder.newLine();
      _builder.append("\t");
      String _portClassName_4 = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName_4, "\t");
      _builder.append("* m_peer;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(pc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(pc, "");
      _builder.append(_generateIncludeGuardEnd, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateDataDrivenSourceFile(final Root root, final ProtocolClass pc) {
    CharSequence _xblockexpression = null;
    {
      List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
      final Function1<Message, Boolean> _function = (Message m) -> {
        VarDecl _data = m.getData();
        return Boolean.valueOf((!Objects.equal(_data, null)));
      };
      final Iterable<Message> sentMsgs = IterableExtensions.<Message>filter(_allIncomingMessages, _function);
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
      _builder.append("* Source File of ProtocolClass ");
      String _name = pc.getName();
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
      String _cppHeaderFileName = this.stdExt.getCppHeaderFileName(pc);
      _builder.append(_cppHeaderFileName, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this.stdExt.generateNamespaceBegin(pc);
      _builder.append(_generateNamespaceBegin, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      DetailCode _userCode3 = pc.getUserCode3();
      CharSequence _userCode = this.helpers.userCode(_userCode3);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("// send port holds data");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// constructor");
      _builder.newLine();
      String _portClassName = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName, "");
      _builder.append("::");
      String _portClassName_1 = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName_1, "");
      _builder.append("(IRTObject* parent, const String& name, int localId) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("DataSendPort(parent, name, localId)");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// receive port accesses send port");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// constructor");
      _builder.newLine();
      String _portClassName_2 = this.roomExt.getPortClassName(pc, false);
      _builder.append(_portClassName_2, "");
      _builder.append("::");
      String _portClassName_3 = this.roomExt.getPortClassName(pc, false);
      _builder.append(_portClassName_3, "");
      _builder.append("(IRTObject* parent, const String& name, int localId) :");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("DataReceivePort(parent, name, localId),");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("m_peer(0)");
      _builder.newLine();
      _builder.append("{");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// getters");
      _builder.newLine();
      {
        for(final Message msg : sentMsgs) {
          VarDecl _data = msg.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          String _typeName = this._typeHelpers.typeName(_type);
          _builder.append(_typeName, "");
          _builder.append(" ");
          String _portClassName_4 = this.roomExt.getPortClassName(pc, false);
          _builder.append(_portClassName_4, "");
          _builder.append("::");
          String _name_1 = msg.getName();
          _builder.append(_name_1, "");
          _builder.append("() const {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("// TODO needs default value");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("//if (m_peer == 0)");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/*\treturn ");
          VarDecl _data_1 = msg.getData();
          RefableType _refType_1 = _data_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          String _defaultValue = this.stdExt.defaultValue(_type_1);
          _builder.append(_defaultValue, "\t");
          _builder.append("; */");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("return m_peer->");
          String _name_2 = msg.getName();
          _builder.append(_name_2, "\t");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      String _portClassName_5 = this.roomExt.getPortClassName(pc, false);
      _builder.append(_portClassName_5, "");
      _builder.append("::connect(DataSendPort* dataSendPort) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _portClassName_6 = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName_6, "\t");
      _builder.append("* peer = dynamic_cast<");
      String _portClassName_7 = this.roomExt.getPortClassName(pc, true);
      _builder.append(_portClassName_7, "\t");
      _builder.append("*>(dataSendPort);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("if (peer != 0)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("m_peer = peer;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this.stdExt.generateNamespaceEnd(pc);
      _builder.append(_generateNamespaceEnd, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getMessageID(final Message msg, final InterfaceItem item) {
    if ((item instanceof Port)) {
      Port p = ((Port) item);
      String _xifexpression = null;
      boolean _isConjugated = p.isConjugated();
      if (_isConjugated) {
        _xifexpression = "OUT_";
      } else {
        _xifexpression = "IN_";
      }
      String direction = _xifexpression;
      GeneralProtocolClass _protocol = p.getProtocol();
      String _name = _protocol.getName();
      String _name_1 = msg.getName();
      String _plus = (direction + _name_1);
      return this.enumInUse(_name, _plus);
    } else {
      if ((item instanceof SAP)) {
        SAP sap = ((SAP) item);
        ProtocolClass _protocol_1 = sap.getProtocol();
        String _name_2 = _protocol_1.getName();
        String _name_3 = msg.getName();
        String _plus_1 = ("OUT_" + _name_3);
        return this.enumInUse(_name_2, _plus_1);
      } else {
        if ((item instanceof SPP)) {
          SPP spp = ((SPP) item);
          ProtocolClass _protocol_2 = spp.getProtocol();
          String _name_4 = _protocol_2.getName();
          String _name_5 = msg.getName();
          String _plus_2 = ("IN_" + _name_5);
          return this.enumInUse(_name_4, _plus_2);
        }
      }
    }
    return "unknown interface item";
  }
  
  protected String enumInUse(final String namespace, final String member) {
    return ((namespace + "::") + member);
  }
}
