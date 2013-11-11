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
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.gen.DataClassGen;
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
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ProtocolClass> _usedProtocolClasses = root.getUsedProtocolClasses();
    for (final ProtocolClass pc : _usedProtocolClasses) {
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
    _builder.append("package �pc.getPackage()�;");
    _builder.newLine();
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
    _builder.append("�IF Main::settings.generateMSCInstrumentation�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
    _builder.newLine();
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("�pc.userCode(1)�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("�var models = root.getReferencedModels(pc)�");
    _builder.newLine();
    _builder.append("�FOR model : models�import �model.name�.*;");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class �pc.name� {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// message IDs");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�genMessageIDs(pc)�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�pc.userCode(2)�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static String messageStrings[] = {\"MIN\", �FOR m : pc.getAllOutgoingMessages()�\"�m.name�\",�ENDFOR� �FOR m : pc.getAllIncomingMessages()�\"�m.name�\",�ENDFOR�\"MAX\"};");
    _builder.newLine();
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
    _builder.append("�portClass(pc, false)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�portClass(pc, true)�");
    _builder.newLine();
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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// port class");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("static public class �portClassName� extends PortBase {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF pclass!=null�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�pclass.userCode.userCode�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// constructors");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �portClassName�(IInterfaceItemOwner actor, String name, int localId) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("this(actor, name, localId, 0);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �portClassName�(IInterfaceItemOwner actor, String name, int localId, int idx) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("super(actor, name, localId, idx);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF pclass!=null�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�pclass.attributes.attributeInitialization(pclass, true)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addPortInstance(this);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("public void destroy() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().removePortInstance(this);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("super.destroy();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void receive(Message m) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (!(m instanceof EventMessage))");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("EventMessage msg = (EventMessage) m;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF pc.handlesReceive(conj)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("switch (msg.getEvtId()) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�FOR hdlr : pc.getReceiveHandlers(conj)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("case �hdlr.msg.getCodeName()�:");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�FOR command : hdlr.detailCode.lines�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("�command�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("default:");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
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
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF pc.handlesReceive(conj)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF pclass!=null�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�pclass.attributes.attributes�");
      _builder.newLine();
      _builder.append("���\t\t\t\t// TODO JH: Avoid collision attr getters/setter <-> user operations");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�attributeSettersGettersImplementation(pclass.attributes, null)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�pclass.operations.operationsImplementation(portClassName)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// sent messages");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR m : pc.getAllMessages(conj)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�sendMessage(m, conj)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// replicated port class");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("static public class �replPortClassName� extends ReplicatedPortBase {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �replPortClassName�(IInterfaceItemOwner actor, String name, int localId) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("super(actor, name, localId);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public int getReplication() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return getNInterfaceItems();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public int getIndexOf(InterfaceItemBase ifitem){");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return ifitem.getIdx();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �portClassName� get(int idx) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return (�portClassName�) getInterfaceItem(idx);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return new �portClassName�(rcv, name, lid, idx);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF conj�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// incoming messages");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR m : pc.getAllIncomingMessages()�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�messageSignature(m)�{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for (InterfaceItemBase item : getItems()) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("((�portClassName�)item).�messageCall(m)�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// outgoing messages");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR m : pc.getAllOutgoingMessages()�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�messageSignature(m)�{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("for (InterfaceItemBase item : getItems()) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("((�portClassName�)item).�messageCall(m)�;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("���\t\t// interface for port class");
      _builder.newLine();
      _builder.append("���\t\tpublic interface I�name�{");
      _builder.newLine();
      _builder.append("���\t\t\t�IF conj�");
      _builder.newLine();
      _builder.append("���\t\t\t// outgoing messages");
      _builder.newLine();
      _builder.append("���\t\t\t�FOR m : pc.getAllOutgoingMessages()� �messageSignature(m)�;");
      _builder.newLine();
      _builder.append("���\t\t\t�ENDFOR�");
      _builder.newLine();
      _builder.append("���\t\t\t�ELSE�");
      _builder.newLine();
      _builder.append("���\t\t\t// incoming messages");
      _builder.newLine();
      _builder.append("���\t\t\t�FOR m : pc.getAllIncomingMessages()� �messageSignature(m)�;");
      _builder.newLine();
      _builder.append("���\t\t\t�ENDFOR�");
      _builder.newLine();
      _builder.append("���\t\t\t�ENDIF�");
      _builder.newLine();
      _builder.append("���\t\t}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence messageSignature(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF m.priv�private�ELSE�public�ENDIF� void �m.name�(�IF m.data!=null��m.data.refType.type.typeName� �m.data.name��ENDIF�)");
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
      _builder.append("public void �m.name�(�dc.argList�)");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence messageCall(final Message m) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�m.name�(�IF m.data!=null� �m.data.name��ENDIF�)");
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
      _builder.append("�messageSignature(m)� {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF hdlr!=null�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR command : hdlr.detailCode.lines�\t�command�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[�dir�_�m.name�]);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (getPeerAddress()!=null)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF m.data==null�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), �dir�_�m.name�));");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), �dir�_�m.name�, �m.data.name��IF (!m.data.refType.ref && !(m.data.refType.type instanceof PrimitiveType))�.deepCopy()�ENDIF�));");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("�IF m.data!=null && m.data.refType.type instanceof DataClass�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�messageSignatureExplicit(m)� {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�m.name�(new �m.data.refType.type.name�(�(m.data.refType.type as DataClass).paramList�));");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
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
      _builder.append("package �pc.getPackage()�;");
      _builder.newLine();
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
      _builder.append("�pc.userCode(1)�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR model : models�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import �model.name�.*;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �pc.name� {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�pc.userCode(2)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// send port holds data");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static public class �pc.getPortClassName(true)� extends DataSendPort {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR msg : sentMsgs�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("private �msg.data.refType.type.typeName� �msg.name�;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// constructor");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public �pc.getPortClassName(true)�(IRTObject parent, String name, int localId) {");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.append("�FOR msg : sentMsgs�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void �msg.name�(�msg.data.refType.type.typeName� �msg.name�) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("this.�msg.name� = �msg.name�;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �msg.data.refType.type.typeName� �msg.name�() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return �msg.name�;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// receive port accesses send port");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static public class �pc.getPortClassName(false)� extends DataReceivePort {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private �pc.getPortClassName(true)� peer;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// constructor");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public �pc.getPortClassName(false)�(IRTObject parent, String name, int localId) {");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.append("�FOR msg : sentMsgs�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public �msg.data.refType.type.typeName� �msg.name�() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (peer==null)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return �msg.data.refType.type.defaultValue�;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return peer.�msg.name�();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void connect(DataSendPort dataSendPort) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (dataSendPort instanceof �pc.getPortClassName(true)�)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("peer = (�pc.getPortClassName(true)�)dataSendPort;");
      _builder.newLine();
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
