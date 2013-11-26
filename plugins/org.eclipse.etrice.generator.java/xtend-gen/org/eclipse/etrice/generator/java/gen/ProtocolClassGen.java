/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.DataClassGen;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ProtocolClassGen extends GenericProtocolClassGenerator {
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
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
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private DataClassGen _dataClassGen;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ProtocolClass> _usedProtocolClasses = root.getUsedProtocolClasses();
    final Function1<ProtocolClass,Boolean> _function = new Function1<ProtocolClass,Boolean>() {
        public Boolean apply(final ProtocolClass cl) {
          boolean _isValidGenerationLocation = ProtocolClassGen.this._fileSystemHelpers.isValidGenerationLocation(cl);
          return Boolean.valueOf(_isValidGenerationLocation);
        }
      };
    Iterable<ProtocolClass> _filter = IterableExtensions.<ProtocolClass>filter(_usedProtocolClasses, _function);
    for (final ProtocolClass pc : _filter) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(pc);
        String _path = this._roomExtensions.getPath(pc);
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(pc);
        String _path_1 = this._roomExtensions.getPath(pc);
        final String infopath = (_generationInfoPath + _path_1);
        final String file = this._javaExtensions.getJavaFileName(pc);
        CharSequence _switchResult = null;
        CommunicationType _commType = pc.getCommType();
        final CommunicationType _switchValue = _commType;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,CommunicationType.EVENT_DRIVEN)) {
            _matched=true;
            CharSequence _generate = this.generate(root, pc);
            _switchResult = _generate;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,CommunicationType.DATA_DRIVEN)) {
            _matched=true;
            CharSequence _generateDataDriven = this.generateDataDriven(root, pc);
            _switchResult = _generateDataDriven;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,CommunicationType.SYNCHRONOUS)) {
            _matched=true;
            _switchResult = "";
          }
        }
        final CharSequence contents = _switchResult;
        String _string = contents.toString();
        boolean _isEmpty = _string.isEmpty();
        if (_isEmpty) {
          this.logger.logError("synchronous protocols not supported yet", pc);
        } else {
          this.fileIO.generateFile("generating ProtocolClass implementation", path, infopath, file, contents);
        }
      }
    }
  }
  
  public CharSequence generate(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this._roomExtensions.getPackage(pc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Message;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.EventMessage;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.PortBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;");
    _builder.newLine();
    {
      GlobalSettings _settings = Main.getSettings();
      boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
      if (_generateMSCInstrumentation) {
        _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
        _builder.newLine();
      }
    }
    _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _userCode = this._procedureHelpers.userCode(pc, 1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    EList<RoomModel> models = root.getReferencedModels(pc);
    _builder.newLineIfNotEmpty();
    {
      for(final RoomModel model : models) {
        _builder.append("import ");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = pc.getName();
    _builder.append(_name_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("// message IDs");
    _builder.newLine();
    _builder.append("\t");
    String _genMessageIDs = this.genMessageIDs(pc);
    _builder.append(_genMessageIDs, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _userCode_1 = this._procedureHelpers.userCode(pc, 2);
    _builder.append(_userCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String messageStrings[] = {\"MIN\", ");
    {
      List<Message> _allOutgoingMessages = RoomHelpers.getAllOutgoingMessages(pc);
      for(final Message m : _allOutgoingMessages) {
        _builder.append("\"");
        String _name_2 = m.getName();
        _builder.append(_name_2, "	");
        _builder.append("\",");
      }
    }
    _builder.append(" ");
    {
      List<Message> _allIncomingMessages = RoomHelpers.getAllIncomingMessages(pc);
      for(final Message m_1 : _allIncomingMessages) {
        _builder.append("\"");
        String _name_3 = m_1.getName();
        _builder.append(_name_3, "	");
        _builder.append("\",");
      }
    }
    _builder.append("\"MAX\"};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getMessageString(int msg_id) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (msg_id<MSG_MIN || msg_id>MSG_MAX+1){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// id out of range");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"Message ID out of range\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return messageStrings[msg_id];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _portClass = this.portClass(pc, Boolean.valueOf(false));
    _builder.append(_portClass, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _portClass_1 = this.portClass(pc, Boolean.valueOf(true));
    _builder.append(_portClass_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence portClass(final ProtocolClass pc, final Boolean conj) {
    CharSequence _xblockexpression = null;
    {
      PortClass pclass = this._roomExtensions.getPortClass(pc, (conj).booleanValue());
      String portClassName = this._roomExtensions.getPortClassName(pc, (conj).booleanValue());
      String replPortClassName = this._roomExtensions.getPortClassName(pc, (conj).booleanValue(), true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// port class");
      _builder.newLine();
      _builder.append("static public class ");
      _builder.append(portClassName, "");
      _builder.append(" extends PortBase {");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(pclass, null));
        if (_notEquals) {
          _builder.append("\t");
          DetailCode _userCode = pclass.getUserCode();
          CharSequence _userCode_1 = this._procedureHelpers.userCode(_userCode);
          _builder.append(_userCode_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("// constructors");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(portClassName, "	");
      _builder.append("(IInterfaceItemOwner actor, String name, int localId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("this(actor, name, localId, 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(portClassName, "	");
      _builder.append("(IInterfaceItemOwner actor, String name, int localId, int idx) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(actor, name, localId, idx);");
      _builder.newLine();
      {
        boolean _notEquals_1 = (!Objects.equal(pclass, null));
        if (_notEquals_1) {
          _builder.append("\t\t");
          EList<Attribute> _attributes = pclass.getAttributes();
          CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes, pclass, true);
          _builder.append(_attributeInitialization, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        GlobalSettings _settings = Main.getSettings();
        boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
        if (_generateMSCInstrumentation) {
          _builder.append("\t\t");
          _builder.append("DebuggingService.getInstance().addPortInstance(this);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        GlobalSettings _settings_1 = Main.getSettings();
        boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void destroy() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().removePortInstance(this);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.destroy();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void receive(Message m) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!(m instanceof EventMessage))");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("EventMessage msg = (EventMessage) m;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {");
      _builder.newLine();
      {
        GlobalSettings _settings_2 = Main.getSettings();
        boolean _generateMSCInstrumentation_2 = _settings_2.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_2) {
          _builder.append("\t\t\t");
          _builder.append("DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);");
          _builder.newLine();
        }
      }
      {
        boolean _handlesReceive = this._roomExtensions.handlesReceive(pc, (conj).booleanValue());
        if (_handlesReceive) {
          _builder.append("\t\t\t");
          _builder.append("switch (msg.getEvtId()) {");
          _builder.newLine();
          {
            List<MessageHandler> _receiveHandlers = this._roomExtensions.getReceiveHandlers(pc, (conj).booleanValue());
            for(final MessageHandler hdlr : _receiveHandlers) {
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("case ");
              Message _msg = hdlr.getMsg();
              String _codeName = this._roomExtensions.getCodeName(_msg);
              _builder.append(_codeName, "				");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("{");
              _builder.newLine();
              {
                DetailCode _detailCode = hdlr.getDetailCode();
                EList<String> _lines = _detailCode.getLines();
                for(final String command : _lines) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append(command, "					");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t");
          _builder.append("\t");
          _builder.append("default:");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("if (msg instanceof EventWithDataMessage)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("getActor().receiveEvent(this, msg.getEvtId(), null);");
      _builder.newLine();
      {
        boolean _handlesReceive_1 = this._roomExtensions.handlesReceive(pc, (conj).booleanValue());
        if (_handlesReceive_1) {
          _builder.append("\t\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _notEquals_2 = (!Objects.equal(pclass, null));
        if (_notEquals_2) {
          _builder.append("\t");
          EList<Attribute> _attributes_1 = pclass.getAttributes();
          CharSequence _attributes_2 = this._procedureHelpers.attributes(_attributes_1);
          _builder.append(_attributes_2, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          EList<Attribute> _attributes_3 = pclass.getAttributes();
          CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_attributes_3, null);
          _builder.append(_attributeSettersGettersImplementation, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          EList<PortOperation> _operations = pclass.getOperations();
          CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(_operations, portClassName);
          _builder.append(_operationsImplementation, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// sent messages");
      _builder.newLine();
      {
        List<Message> _allMessages = RoomHelpers.getAllMessages(pc, (conj).booleanValue());
        for(final Message m : _allMessages) {
          _builder.append("\t");
          CharSequence _sendMessage = this.sendMessage(m, (conj).booleanValue());
          _builder.append(_sendMessage, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// replicated port class");
      _builder.newLine();
      _builder.append("static public class ");
      _builder.append(replPortClassName, "");
      _builder.append(" extends ReplicatedPortBase {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(replPortClassName, "	");
      _builder.append("(IInterfaceItemOwner actor, String name, int localId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(actor, name, localId);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int getReplication() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return getNInterfaceItems();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int getIndexOf(InterfaceItemBase ifitem){");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return ifitem.getIdx();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(portClassName, "	");
      _builder.append(" get(int idx) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return (");
      _builder.append(portClassName, "		");
      _builder.append(") getInterfaceItem(idx);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new ");
      _builder.append(portClassName, "		");
      _builder.append("(rcv, name, lid, idx);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        if ((conj).booleanValue()) {
          _builder.append("\t");
          _builder.append("// incoming messages");
          _builder.newLine();
          {
            List<Message> _allIncomingMessages = RoomHelpers.getAllIncomingMessages(pc);
            for(final Message m_1 : _allIncomingMessages) {
              _builder.append("\t");
              CharSequence _messageSignature = this.messageSignature(m_1);
              _builder.append(_messageSignature, "	");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (InterfaceItemBase item : getItems()) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("((");
              _builder.append(portClassName, "			");
              _builder.append(")item).");
              CharSequence _messageCall = this.messageCall(m_1);
              _builder.append(_messageCall, "			");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        } else {
          _builder.append("\t");
          _builder.append("// outgoing messages");
          _builder.newLine();
          {
            List<Message> _allOutgoingMessages = RoomHelpers.getAllOutgoingMessages(pc);
            for(final Message m_2 : _allOutgoingMessages) {
              _builder.append("\t");
              CharSequence _messageSignature_1 = this.messageSignature(m_2);
              _builder.append(_messageSignature_1, "	");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (InterfaceItemBase item : getItems()) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("((");
              _builder.append(portClassName, "			");
              _builder.append(")item).");
              CharSequence _messageCall_1 = this.messageCall(m_2);
              _builder.append(_messageCall_1, "			");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence messageSignature(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isPriv = m.isPriv();
      if (_isPriv) {
        _builder.append("private");
      } else {
        _builder.append("public");
      }
    }
    _builder.append(" void ");
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      VarDecl _data = m.getData();
      boolean _notEquals = (!Objects.equal(_data, null));
      if (_notEquals) {
        VarDecl _data_1 = m.getData();
        RefableType _refType = _data_1.getRefType();
        DataType _type = _refType.getType();
        String _typeName = this._typeHelpers.typeName(_type);
        _builder.append(_typeName, "");
        _builder.append(" ");
        VarDecl _data_2 = m.getData();
        String _name_1 = _data_2.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence messageSignatureExplicit(final Message m) {
    CharSequence _xblockexpression = null;
    {
      VarDecl _data = m.getData();
      RefableType _refType = _data.getRefType();
      DataType _type = _refType.getType();
      DataClass dc = ((DataClass) _type);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public void ");
      String _name = m.getName();
      _builder.append(_name, "");
      _builder.append("(");
      String _argList = this._dataClassGen.argList(dc);
      _builder.append(_argList, "");
      _builder.append(")");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence messageCall(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = m.getName();
    _builder.append(_name, "");
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
  
  public CharSequence sendMessage(final Message m, final boolean conj) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      if (conj) {
        _xifexpression = "IN";
      } else {
        _xifexpression = "OUT";
      }
      String dir = _xifexpression;
      MessageHandler hdlr = this._roomExtensions.getSendHandler(m, conj);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _messageSignature = this.messageSignature(m);
      _builder.append(_messageSignature, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equal(hdlr, null));
        if (_notEquals) {
          _builder.append("\t");
          {
            DetailCode _detailCode = hdlr.getDetailCode();
            EList<String> _lines = _detailCode.getLines();
            for(final String command : _lines) {
              _builder.append("\t");
              _builder.append(command, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          {
            GlobalSettings _settings = Main.getSettings();
            boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
            if (_generateMSCInstrumentation) {
              _builder.append("\t");
              _builder.append("DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[");
              _builder.append(dir, "	");
              _builder.append("_");
              String _name = m.getName();
              _builder.append(_name, "	");
              _builder.append("]);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("if (getPeerAddress()!=null)");
          _builder.newLine();
          {
            VarDecl _data = m.getData();
            boolean _equals = Objects.equal(_data, null);
            if (_equals) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), ");
              _builder.append(dir, "		");
              _builder.append("_");
              String _name_1 = m.getName();
              _builder.append(_name_1, "		");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), ");
              _builder.append(dir, "		");
              _builder.append("_");
              String _name_2 = m.getName();
              _builder.append(_name_2, "		");
              _builder.append(", ");
              VarDecl _data_1 = m.getData();
              String _name_3 = _data_1.getName();
              _builder.append(_name_3, "		");
              {
                boolean _and = false;
                VarDecl _data_2 = m.getData();
                RefableType _refType = _data_2.getRefType();
                boolean _isRef = _refType.isRef();
                boolean _not = (!_isRef);
                if (!_not) {
                  _and = false;
                } else {
                  VarDecl _data_3 = m.getData();
                  RefableType _refType_1 = _data_3.getRefType();
                  DataType _type = _refType_1.getType();
                  boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(_type);
                  boolean _not_1 = (!_isEnumerationOrPrimitive);
                  _and = (_not && _not_1);
                }
                if (_and) {
                  _builder.append(".deepCopy()");
                }
              }
              _builder.append("));");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      {
        boolean _and_1 = false;
        VarDecl _data_4 = m.getData();
        boolean _notEquals_1 = (!Objects.equal(_data_4, null));
        if (!_notEquals_1) {
          _and_1 = false;
        } else {
          VarDecl _data_5 = m.getData();
          RefableType _refType_2 = _data_5.getRefType();
          DataType _type_1 = _refType_2.getType();
          _and_1 = (_notEquals_1 && (_type_1 instanceof DataClass));
        }
        if (_and_1) {
          CharSequence _messageSignatureExplicit = this.messageSignatureExplicit(m);
          _builder.append(_messageSignatureExplicit, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _name_4 = m.getName();
          _builder.append(_name_4, "	");
          _builder.append("(new ");
          VarDecl _data_6 = m.getData();
          RefableType _refType_3 = _data_6.getRefType();
          DataType _type_2 = _refType_3.getType();
          String _name_5 = _type_2.getName();
          _builder.append(_name_5, "	");
          _builder.append("(");
          VarDecl _data_7 = m.getData();
          RefableType _refType_4 = _data_7.getRefType();
          DataType _type_3 = _refType_4.getType();
          String _paramList = this._dataClassGen.paramList(((DataClass) _type_3));
          _builder.append(_paramList, "	");
          _builder.append("));");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateDataDriven(final Root root, final ProtocolClass pc) {
    CharSequence _xblockexpression = null;
    {
      List<Message> _allIncomingMessages = RoomHelpers.getAllIncomingMessages(pc);
      final Function1<Message,Boolean> _function = new Function1<Message,Boolean>() {
          public Boolean apply(final Message m) {
            VarDecl _data = m.getData();
            boolean _notEquals = (!Objects.equal(_data, null));
            return Boolean.valueOf(_notEquals);
          }
        };
      final Iterable<Message> sentMsgs = IterableExtensions.<Message>filter(_allIncomingMessages, _function);
      final EList<RoomModel> models = root.getReferencedModels(pc);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(pc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.DataReceivePort;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.DataSendPort;");
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
      _builder.newLine();
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(pc, 1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      String _name_1 = pc.getName();
      _builder.append(_name_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(pc, 2);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// send port holds data");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static public class ");
      String _portClassName = this._roomExtensions.getPortClassName(pc, true);
      _builder.append(_portClassName, "	");
      _builder.append(" extends DataSendPort {");
      _builder.newLineIfNotEmpty();
      {
        for(final Message msg : sentMsgs) {
          _builder.append("\t\t");
          _builder.append("private ");
          VarDecl _data = msg.getData();
          RefableType _refType = _data.getRefType();
          DataType _type = _refType.getType();
          String _typeName = this._typeHelpers.typeName(_type);
          _builder.append(_typeName, "		");
          _builder.append(" ");
          String _name_2 = msg.getName();
          _builder.append(_name_2, "		");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// constructor");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public ");
      String _portClassName_1 = this._roomExtensions.getPortClassName(pc, true);
      _builder.append(_portClassName_1, "		");
      _builder.append("(IRTObject parent, String name, int localId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("super(parent, name, localId);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// getters and setters");
      _builder.newLine();
      {
        for(final Message msg_1 : sentMsgs) {
          _builder.append("\t\t");
          _builder.append("public void ");
          String _name_3 = msg_1.getName();
          _builder.append(_name_3, "		");
          _builder.append("(");
          VarDecl _data_1 = msg_1.getData();
          RefableType _refType_1 = _data_1.getRefType();
          DataType _type_1 = _refType_1.getType();
          String _typeName_1 = this._typeHelpers.typeName(_type_1);
          _builder.append(_typeName_1, "		");
          _builder.append(" ");
          String _name_4 = msg_1.getName();
          _builder.append(_name_4, "		");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("this.");
          String _name_5 = msg_1.getName();
          _builder.append(_name_5, "			");
          _builder.append(" = ");
          String _name_6 = msg_1.getName();
          _builder.append(_name_6, "			");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("public ");
          VarDecl _data_2 = msg_1.getData();
          RefableType _refType_2 = _data_2.getRefType();
          DataType _type_2 = _refType_2.getType();
          String _typeName_2 = this._typeHelpers.typeName(_type_2);
          _builder.append(_typeName_2, "		");
          _builder.append(" ");
          String _name_7 = msg_1.getName();
          _builder.append(_name_7, "		");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("return ");
          String _name_8 = msg_1.getName();
          _builder.append(_name_8, "			");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// receive port accesses send port");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static public class ");
      String _portClassName_2 = this._roomExtensions.getPortClassName(pc, false);
      _builder.append(_portClassName_2, "	");
      _builder.append(" extends DataReceivePort {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("private ");
      String _portClassName_3 = this._roomExtensions.getPortClassName(pc, true);
      _builder.append(_portClassName_3, "		");
      _builder.append(" peer;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// constructor");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public ");
      String _portClassName_4 = this._roomExtensions.getPortClassName(pc, false);
      _builder.append(_portClassName_4, "		");
      _builder.append("(IRTObject parent, String name, int localId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("super(parent, name, localId);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// getters");
      _builder.newLine();
      {
        for(final Message msg_2 : sentMsgs) {
          _builder.append("\t\t");
          _builder.append("public ");
          VarDecl _data_3 = msg_2.getData();
          RefableType _refType_3 = _data_3.getRefType();
          DataType _type_3 = _refType_3.getType();
          String _typeName_3 = this._typeHelpers.typeName(_type_3);
          _builder.append(_typeName_3, "		");
          _builder.append(" ");
          String _name_9 = msg_2.getName();
          _builder.append(_name_9, "		");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("if (peer==null)");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("return ");
          VarDecl _data_4 = msg_2.getData();
          RefableType _refType_4 = _data_4.getRefType();
          DataType _type_4 = _refType_4.getType();
          String _defaultValue = this._javaExtensions.defaultValue(_type_4);
          _builder.append(_defaultValue, "				");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("return peer.");
          String _name_10 = msg_2.getName();
          _builder.append(_name_10, "			");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void connect(DataSendPort dataSendPort) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (dataSendPort instanceof ");
      String _portClassName_5 = this._roomExtensions.getPortClassName(pc, true);
      _builder.append(_portClassName_5, "			");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("peer = (");
      String _portClassName_6 = this._roomExtensions.getPortClassName(pc, true);
      _builder.append(_portClassName_6, "				");
      _builder.append(")dataSendPort;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
