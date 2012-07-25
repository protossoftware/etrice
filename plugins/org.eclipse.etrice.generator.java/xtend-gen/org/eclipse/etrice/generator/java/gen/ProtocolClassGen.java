package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.DataClassGen;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class ProtocolClassGen extends GenericProtocolClassGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions _javaExtensions;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private TypeHelpers _typeHelpers;
  
  @Inject
  private DataClassGen _dataClassGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ProtocolClass> _usedProtocolClasses = root.getUsedProtocolClasses();
    for (final ProtocolClass pc : _usedProtocolClasses) {
      {
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(pc);
        String _path = this._roomExtensions.getPath(pc);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        String _javaFileName = this._javaExtensions.getJavaFileName(pc);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating ProtocolClass implementation \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        StringConcatenation _generate = this.generate(root, pc);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this._roomExtensions.getPackage(pc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Message;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
    _builder.newLine();
    _builder.newLine();
    StringConcatenation _userCode = this._procedureHelpers.userCode(pc, 1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    EList<RoomModel> _referencedModels = root.getReferencedModels(pc);
    EList<RoomModel> models = _referencedModels;
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
    StringConcatenation _userCode_1 = this._procedureHelpers.userCode(pc, 2);
    _builder.append(_userCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String messageStrings[] = {\"MIN\", ");
    {
      List<Message> _allOutgoingMessages = this._roomExtensions.getAllOutgoingMessages(pc);
      for(final Message m : _allOutgoingMessages) {
        _builder.append("\"");
        String _name_2 = m.getName();
        _builder.append(_name_2, "	");
        _builder.append("\",");
      }
    }
    _builder.append(" ");
    {
      List<Message> _allIncomingMessages = this._roomExtensions.getAllIncomingMessages(pc);
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
    StringConcatenation _portClass = this.portClass(pc, ((Boolean)false));
    _builder.append(_portClass, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    StringConcatenation _portClass_1 = this.portClass(pc, ((Boolean)true));
    _builder.append(_portClass_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation portClass(final ProtocolClass pc, final Boolean conj) {
    StringConcatenation _xblockexpression = null;
    {
      PortClass _portClass = this._roomExtensions.getPortClass(pc, conj);
      PortClass pclass = _portClass;
      String _portClassName = this._roomExtensions.getPortClassName(pc, conj);
      String portClassName = _portClassName;
      String _portClassName_1 = this._roomExtensions.getPortClassName(pc, conj, true);
      String replPortClassName = _portClassName_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// port class");
      _builder.newLine();
      _builder.append("static public class ");
      _builder.append(portClassName, "");
      _builder.append(" extends PortBase {");
      _builder.newLineIfNotEmpty();
      {
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(pclass, null);
        if (_operator_notEquals) {
          _builder.append("\t");
          DetailCode _userCode = pclass.getUserCode();
          StringConcatenation _userCode_1 = this._procedureHelpers.userCode(_userCode);
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
      _builder.append("(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("this(actor, name, localId, 0, addr, peerAddress);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("DebuggingService.getInstance().addPortInstance(this);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(portClassName, "	");
      _builder.append("(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(actor, name, localId, idx, addr, peerAddress);");
      _builder.newLine();
      {
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(pclass, null);
        if (_operator_notEquals_1) {
          _builder.append("\t\t");
          EList<Attribute> _attributes = pclass.getAttributes();
          StringConcatenation _attributeInitialization = this._procedureHelpers.attributeInitialization(_attributes, true);
          _builder.append(_attributeInitialization, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("DebuggingService.getInstance().addPortInstance(this);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void receive(Message m) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (!(m instanceof EventMessage))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("EventMessage msg = (EventMessage) m;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("System.out.println(\"unknown\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (messageStrings[msg.getEvtId()] != \"timerTick\"){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      {
        boolean _handlesReceive = this._roomExtensions.handlesReceive(pc, conj);
        if (_handlesReceive) {
          _builder.append("\t\t\t\t");
          _builder.append("switch (msg.getEvtId()) {");
          _builder.newLine();
          {
            List<MessageHandler> _receiveHandlers = this._roomExtensions.getReceiveHandlers(pc, conj);
            for(final MessageHandler hdlr : _receiveHandlers) {
              _builder.append("\t\t\t\t");
              _builder.append("\t");
              _builder.append("case ");
              Message _msg = hdlr.getMsg();
              String _codeName = this._roomExtensions.getCodeName(_msg);
              _builder.append(_codeName, "					");
              _builder.append(":");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t");
              _builder.append("\t");
              _builder.append("{");
              _builder.newLine();
              {
                DetailCode _detailCode = hdlr.getDetailCode();
                EList<String> _commands = _detailCode.getCommands();
                for(final String command : _commands) {
                  _builder.append("\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append(command, "						");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t\t\t");
              _builder.append("\t");
              _builder.append("break;");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("default:");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t\t\t");
      _builder.append("if (msg instanceof EventWithDataMessage)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("getActor().receiveEvent(this, msg.getEvtId(), null);");
      _builder.newLine();
      {
        boolean _handlesReceive_1 = this._roomExtensions.handlesReceive(pc, conj);
        if (_handlesReceive_1) {
          _builder.append("\t\t\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(pclass, null);
        if (_operator_notEquals_2) {
          _builder.append("\t");
          EList<Attribute> _attributes_1 = pclass.getAttributes();
          StringConcatenation _attributes_2 = this._procedureHelpers.attributes(_attributes_1);
          _builder.append(_attributes_2, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("// TODO JH: Avoid collision attr getters/setter <-> user operations");
          _builder.newLine();
          _builder.append("\t");
          EList<Attribute> _attributes_3 = pclass.getAttributes();
          StringConcatenation _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_attributes_3, null);
          _builder.append(_attributeSettersGettersImplementation, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          EList<PortOperation> _operations = pclass.getOperations();
          StringConcatenation _operationsImplementation = this._procedureHelpers.operationsImplementation(_operations, portClassName);
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
        List<Message> _outgoing = this._roomExtensions.getOutgoing(pc, conj);
        for(final Message m : _outgoing) {
          _builder.append("\t");
          StringConcatenation _sendMessage = this.sendMessage(m, conj);
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
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("private ArrayList<");
      _builder.append(portClassName, "	");
      _builder.append("> ports;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("private int replication;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(replPortClassName, "	");
      _builder.append("(IEventReceiver actor, String name, int localId, Address[] addr,");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("Address[] peerAddress) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("replication = addr==null? 0:addr.length;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ports = new ArrayList<");
      String _name = pc.getName();
      _builder.append(_name, "		");
      _builder.append(".");
      _builder.append(portClassName, "		");
      _builder.append(">(replication);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("for (int i=0; i<replication; ++i) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ports.add(new ");
      _builder.append(portClassName, "			");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("actor, name+i, localId, i, addr[i], peerAddress[i]));");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
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
      _builder.append("return replication;");
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
      _builder.append(" get(int i) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return ports.get(i);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        if (conj) {
          _builder.append("\t");
          _builder.append("// incoming messages");
          _builder.newLine();
          {
            List<Message> _allIncomingMessages = this._roomExtensions.getAllIncomingMessages(pc);
            for(final Message m_1 : _allIncomingMessages) {
              _builder.append("\t");
              StringConcatenation _messageSignature = this.messageSignature(m_1);
              _builder.append(_messageSignature, "	");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (int i=0; i<replication; ++i) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("ports.get(i).");
              StringConcatenation _messageCall = this.messageCall(m_1);
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
            List<Message> _allOutgoingMessages = this._roomExtensions.getAllOutgoingMessages(pc);
            for(final Message m_2 : _allOutgoingMessages) {
              _builder.append("\t");
              StringConcatenation _messageSignature_1 = this.messageSignature(m_2);
              _builder.append(_messageSignature_1, "	");
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (int i=0; i<replication; ++i) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("ports.get(i).");
              StringConcatenation _messageCall_1 = this.messageCall(m_2);
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
  
  public StringConcatenation messageSignature(final Message m) {
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
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
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
  
  public StringConcatenation messageSignatureExplicit(final Message m) {
    StringConcatenation _xblockexpression = null;
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
  
  public StringConcatenation messageCall(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = m.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      VarDecl _data = m.getData();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_data, null);
      if (_operator_notEquals) {
        _builder.append(" ");
        VarDecl _data_1 = m.getData();
        String _name_1 = _data_1.getName();
        _builder.append(_name_1, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  public StringConcatenation sendMessage(final Message m, final boolean conj) {
    StringConcatenation _xblockexpression = null;
    {
      String _xifexpression = null;
      if (conj) {
        _xifexpression = "IN";
      } else {
        _xifexpression = "OUT";
      }
      String dir = _xifexpression;
      MessageHandler _sendHandler = this._roomExtensions.getSendHandler(m, conj);
      MessageHandler hdlr = _sendHandler;
      StringConcatenation _builder = new StringConcatenation();
      StringConcatenation _messageSignature = this.messageSignature(m);
      _builder.append(_messageSignature, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(hdlr, null);
        if (_operator_notEquals) {
          _builder.append("\t");
          {
            DetailCode _detailCode = hdlr.getDetailCode();
            EList<String> _commands = _detailCode.getCommands();
            for(final String command : _commands) {
              _builder.append("\t");
              _builder.append(command, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          _builder.append("\t");
          _builder.append("if (messageStrings[ ");
          _builder.append(dir, "	");
          _builder.append("_");
          String _name = m.getName();
          _builder.append(_name, "	");
          _builder.append("] != \"timerTick\"){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[");
          _builder.append(dir, "	");
          _builder.append("_");
          String _name_1 = m.getName();
          _builder.append(_name_1, "	");
          _builder.append("]);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if (getPeerAddress()!=null)");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          {
            VarDecl _data = m.getData();
            boolean _operator_equals = ObjectExtensions.operator_equals(_data, null);
            if (_operator_equals) {
              _builder.append("getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), ");
              _builder.append(dir, "		");
              _builder.append("_");
              String _name_2 = m.getName();
              _builder.append(_name_2, "		");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
            } else {
              _builder.append("getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), ");
              _builder.append(dir, "		");
              _builder.append("_");
              String _name_3 = m.getName();
              _builder.append(_name_3, "		");
              _builder.append(", ");
              VarDecl _data_1 = m.getData();
              String _name_4 = _data_1.getName();
              _builder.append(_name_4, "		");
              {
                boolean _operator_and = false;
                VarDecl _data_2 = m.getData();
                RefableType _refType = _data_2.getRefType();
                boolean _isRef = _refType.isRef();
                boolean _operator_not = BooleanExtensions.operator_not(_isRef);
                if (!_operator_not) {
                  _operator_and = false;
                } else {
                  VarDecl _data_3 = m.getData();
                  RefableType _refType_1 = _data_3.getRefType();
                  DataType _type = _refType_1.getType();
                  boolean _operator_not_1 = BooleanExtensions.operator_not((_type instanceof PrimitiveType));
                  _operator_and = BooleanExtensions.operator_and(_operator_not, _operator_not_1);
                }
                if (_operator_and) {
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
        boolean _operator_and_1 = false;
        VarDecl _data_4 = m.getData();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_data_4, null);
        if (!_operator_notEquals_1) {
          _operator_and_1 = false;
        } else {
          VarDecl _data_5 = m.getData();
          RefableType _refType_2 = _data_5.getRefType();
          DataType _type_1 = _refType_2.getType();
          _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_1, (_type_1 instanceof DataClass));
        }
        if (_operator_and_1) {
          StringConcatenation _messageSignatureExplicit = this.messageSignatureExplicit(m);
          _builder.append(_messageSignatureExplicit, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _name_5 = m.getName();
          _builder.append(_name_5, "	");
          _builder.append("(new ");
          VarDecl _data_6 = m.getData();
          RefableType _refType_3 = _data_6.getRefType();
          DataType _type_2 = _refType_3.getType();
          String _name_6 = _type_2.getName();
          _builder.append(_name_6, "	");
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
}
