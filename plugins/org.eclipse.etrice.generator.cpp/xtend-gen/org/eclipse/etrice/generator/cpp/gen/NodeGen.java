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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.converter.TimeConverter;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.cpp.gen.CppExtensions;
import org.eclipse.etrice.generator.cpp.gen.Initialization;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.fsm.base.Indexed;
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
public class NodeGen {
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
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private Initialization initHelper;
  
  public void doGenerate(final Root root) {
    final Map<SubSystemClass, WiredSubSystemClass> sscc2wired = CollectionLiterals.<SubSystemClass, WiredSubSystemClass>newHashMap();
    final Consumer<WiredSubSystemClass> _function = (WiredSubSystemClass it) -> {
      sscc2wired.put(it.getSubSystemClass(), it);
    };
    Iterables.<WiredSubSystemClass>filter(root.getWiredInstances(), WiredSubSystemClass.class).forEach(_function);
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          if (((!Objects.equal(ssi, null)) && this._fileSystemHelpers.isValidGenerationLocation(ssi.getSubSystemClass()))) {
            final WiredSubSystemClass wired = sscc2wired.get(ssi.getSubSystemClass());
            String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(ssi.getSubSystemClass());
            String _path = this._roomExtensions.getPath(ssi.getSubSystemClass());
            final String path = (_generationTargetPath + _path);
            String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(ssi.getSubSystemClass());
            String _path_1 = this._roomExtensions.getPath(ssi.getSubSystemClass());
            final String infopath = (_generationInfoPath + _path_1);
            final Set<PhysicalThread> usedThreads = ETMapUtil.getUsedThreads(nr, ssi);
            this.fileIO.generateFile("generating Node declaration", path, infopath, this._cppExtensions.getCppHeaderFileName(nr, ssi), this.generateHeaderFile(root, ssi, wired, usedThreads));
            this.fileIO.generateFile("generating Node implementation", path, infopath, this._cppExtensions.getCppSourceFileName(nr, ssi), this.generateSourceFile(root, ssi, wired, usedThreads));
          }
        }
      }
    }
  }
  
  public CharSequence generateHeaderFile(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._cppExtensions.getCppClassName(nr, comp);
      final Function1<PhysicalThread, Boolean> _function = (PhysicalThread t) -> {
        return Boolean.valueOf(usedThreads.contains(t));
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function);
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
      _builder.append("* Header File of SubSystemClass ");
      _builder.append(clsname, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cppExtensions.generateIncludeGuardBegin(cc, "");
      _builder.append(_generateIncludeGuardBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/messaging/IMessageService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/SubSystemClassBase.h\"");
      _builder.newLine();
      {
        EList<ActorInstance> _actorInstances = comp.getActorInstances();
        for(final ActorInstance ai : _actorInstances) {
          _builder.append("#include \"");
          String _actorIncludePath = this._cppExtensions.getActorIncludePath(ai.getActorClass());
          _builder.append(_actorIncludePath);
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(cc.getUserCode1());
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      _builder.append(clsname);
      _builder.append(" : public etRuntime::SubSystemClassBase{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(cc.getUserCode2());
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public:");
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("\t\t");
          _builder.append("static const int ");
          String _threadId = this.getThreadId(thread.getValue());
          _builder.append(_threadId, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = cc.getActorRefs();
        for(final ActorRef sub : _actorRefs) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t\t");
              _builder.append("Replicated");
              String _implementationClassName = this._cppExtensions.getImplementationClassName(sub.getType());
              _builder.append(_implementationClassName, "\t\t");
              _builder.append(" ");
              String _name = sub.getName();
              _builder.append(_name, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              String _implementationClassName_1 = this._cppExtensions.getImplementationClassName(sub.getType());
              _builder.append(_implementationClassName_1, "\t\t");
              _builder.append(" ");
              String _name_1 = sub.getName();
              _builder.append(_name_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("(IRTObject* parent, const String& name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("~");
      _builder.append(clsname, "\t\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void instantiateMessageServices();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void mapThreads(void);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void initialize(void);");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("\t\t");
          _builder.append("virtual void setProbesActive(bool recursive, bool active);");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("virtual void init();");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t\t");
          _builder.append("etBool hasGeneratedMSCInstrumentation() const { return true; }");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("virtual void destroy();");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// MessageServices");
      _builder.newLine();
      {
        for(final PhysicalThread thread_1 : threads) {
          _builder.append("\t\t");
          _builder.append("IMessageService* msgSvc_");
          String _name_2 = thread_1.getName();
          _builder.append(_name_2, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("(");
      _builder.append(clsname, "\t\t");
      _builder.append(" const&);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(clsname, "\t\t");
      _builder.append("& operator=(");
      _builder.append(clsname, "\t\t");
      _builder.append(" const&);");
      _builder.newLineIfNotEmpty();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cppExtensions.generateIncludeGuardEnd(cc, "");
      _builder.append(_generateIncludeGuardEnd);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _upperCase = thread.getName().toUpperCase();
    return ("THREAD_" + _upperCase);
  }
  
  private CharSequence generateConstructorInitalizerList(final SubSystemClass cc) {
    CharSequence _xblockexpression = null;
    {
      @Extension
      final Initialization initHelper = this.initHelper;
      ArrayList<CharSequence> initList = CollectionLiterals.<CharSequence>newArrayList();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("SubSystemClassBase(parent, name)");
      initList.add(_builder.toString());
      final Function1<ActorRef, String> _function = (ActorRef it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _name = it.getName();
        _builder_1.append(_name);
        _builder_1.append("(this, \"");
        String _name_1 = it.getName();
        _builder_1.append(_name_1);
        _builder_1.append("\")");
        return _builder_1.toString();
      };
      List<String> _map = ListExtensions.<ActorRef, String>map(cc.getActorRefs(), _function);
      Iterables.<CharSequence>addAll(initList, _map);
      _xblockexpression = initHelper.generateCtorInitializerList(initList);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateSourceFile(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._cppExtensions.getCppClassName(nr, comp);
      final Function1<PhysicalThread, Boolean> _function = (PhysicalThread t) -> {
        return Boolean.valueOf(usedThreads.contains(t));
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function);
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
      _builder.append("* Source File of SubsystemClass ");
      _builder.append(clsname, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cppHeaderFileName = this._cppExtensions.getCppHeaderFileName(nr, comp);
      _builder.append(_cppHeaderFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"common/debugging/DebuggingService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/debugging/MSCFunctionObject.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/IMessageService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/MessageService.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/MessageServiceController.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/RTServices.h\"");
      _builder.newLine();
      _builder.append("#include \"common/messaging/StaticMessageMemory.h\"");
      _builder.newLine();
      _builder.append("#include \"common/modelbase/InterfaceItemBase.h\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("using namespace etRuntime;");
      _builder.newLine();
      _builder.newLine();
      String _generateNamespaceBegin = this._cppExtensions.generateNamespaceBegin(cc);
      _builder.append(_generateNamespaceBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("const int ");
          _builder.append(clsname);
          _builder.append("::");
          String _threadId = this.getThreadId(thread.getValue());
          _builder.append(_threadId);
          _builder.append(" = ");
          int _index0 = thread.getIndex0();
          _builder.append(_index0);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append(clsname);
      _builder.append("::");
      _builder.append(clsname);
      _builder.append("(IRTObject* parent, const String& name)");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      CharSequence _generateConstructorInitalizerList = this.generateConstructorInitalizerList(cc);
      _builder.append(_generateConstructorInitalizerList, "\t\t");
      _builder.newLineIfNotEmpty();
      {
        for(final PhysicalThread thread_1 : threads) {
          _builder.append("\t\t");
          _builder.append(", msgSvc_");
          String _name = thread_1.getName();
          _builder.append(_name, "\t\t");
          _builder.append("(NULL)");
          _builder.newLineIfNotEmpty();
        }
      }
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
      {
        EList<ActorRef> _actorRefs = cc.getActorRefs();
        for(final ActorRef sub : _actorRefs) {
          {
            int _multiplicity = sub.getMultiplicity();
            boolean _greaterThan = (_multiplicity > 1);
            if (_greaterThan) {
              _builder.append("\t");
              String _name_1 = sub.getName();
              _builder.append(_name_1, "\t");
              _builder.append(".createSubActors(");
              int _multiplicity_1 = sub.getMultiplicity();
              _builder.append(_multiplicity_1, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append(clsname);
      _builder.append("::~");
      _builder.append(clsname);
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      {
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"Destructor\");");
          _builder.newLine();
        }
      }
      {
        for(final PhysicalThread thread_2 : threads) {
          _builder.append("\t");
          _builder.append("delete msgSvc_");
          String _name_2 = thread_2.getName();
          _builder.append(_name_2, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data){");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("::instantiateMessageServices(){");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_2 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_2) {
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"instantiateMessageServices()\");");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("IMessageMemory* msgMemory;");
      _builder.newLine();
      {
        final Function1<PhysicalThread, Long> _function_1 = (PhysicalThread it) -> {
          long _prio = it.getPrio();
          return Long.valueOf((-_prio));
        };
        List<PhysicalThread> _sortBy = IterableExtensions.<PhysicalThread, Long>sortBy(threads, _function_1);
        for(final PhysicalThread thread_3 : _sortBy) {
          _builder.append("\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("msgMemory = new StaticMessageMemory(this, \"MessageMemory_");
          String _name_3 = thread_3.getName();
          _builder.append(_name_3, "\t\t");
          _builder.append("\", ");
          int _msgblocksize = thread_3.getMsgblocksize();
          _builder.append(_msgblocksize, "\t\t");
          _builder.append(", ");
          int _msgpoolsize = thread_3.getMsgpoolsize();
          _builder.append(_msgpoolsize, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          {
            if ((Objects.equal(thread_3.getExecmode(), ExecMode.POLLED) || Objects.equal(thread_3.getExecmode(), ExecMode.MIXED))) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("etTime interval;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("interval.sec = ");
              long _split = TimeConverter.split(thread_3.getTime(), TimeConverter.SEC, true);
              _builder.append(_split, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("interval.nSec = ");
              long _split_1 = TimeConverter.split(thread_3.getTime(), TimeConverter.MILLI_SEC, false);
              _builder.append(_split_1, "\t\t");
              _builder.append("L;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("msgSvc_");
              String _name_4 = thread_3.getName();
              _builder.append(_name_4, "\t\t");
              _builder.append(" = new MessageService(this, IMessageService::");
              String _name_5 = thread_3.getExecmode().getName();
              _builder.append(_name_5, "\t\t");
              _builder.append(", interval, 0, ");
              String _threadId_1 = this.getThreadId(thread_3);
              _builder.append(_threadId_1, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_6 = thread_3.getName();
              _builder.append(_name_6, "\t\t");
              _builder.append("\", msgMemory, ");
              long _prio = thread_3.getPrio();
              _builder.append(_prio, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("msgSvc_");
              String _name_7 = thread_3.getName();
              _builder.append(_name_7, "\t\t");
              _builder.append(" = new MessageService(this, IMessageService::");
              String _name_8 = thread_3.getExecmode().getName();
              _builder.append(_name_8, "\t\t");
              _builder.append(", 0, ");
              String _threadId_2 = this.getThreadId(thread_3);
              _builder.append(_threadId_2, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_9 = thread_3.getName();
              _builder.append(_name_9, "\t\t");
              _builder.append("\", msgMemory, ");
              long _prio_1 = thread_3.getPrio();
              _builder.append(_prio_1, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("RTServices::getInstance().getMsgSvcCtrl().addMsgSvc(*msgSvc_");
          String _name_10 = thread_3.getName();
          _builder.append(_name_10, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("::mapThreads() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("\t");
          final ETMapUtil.MappedThread mapped = ETMapUtil.getMappedThread(ai);
          _builder.newLineIfNotEmpty();
          {
            boolean _not = (!(mapped.isImplicit() || mapped.isAsParent()));
            if (_not) {
              _builder.append("\t");
              _builder.append("addPathToThread(\"");
              String _path = ai.getPath();
              _builder.append(_path, "\t");
              _builder.append("\", ");
              String _threadId_3 = this.getThreadId(mapped.getThread());
              _builder.append(_threadId_3, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("::initialize() {");
      _builder.newLineIfNotEmpty();
      {
        boolean _isGenerateMSCInstrumentation_3 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_3) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().getSyncLogger().addVisibleComment(\"starting initialization\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"initialize()\");");
          _builder.newLine();
          {
            EList<ActorRef> _actorRefs_1 = cc.getActorRefs();
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
                  String _name_11 = sub_1.getName();
                  _builder.append(_name_11, "\t\t");
                  _builder.append(".getSubActor(i)->getName());");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("DebuggingService::getInstance().addMessageActorCreate(*this, \"");
                  String _name_12 = sub_1.getName();
                  _builder.append(_name_12, "\t");
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
      _builder.append("// wiring");
      _builder.newLine();
      {
        EList<Wire> _wires = wired.getWires();
        for(final Wire wire : _wires) {
          _builder.append("\t");
          String _xifexpression = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression = "DataPortBase";
          } else {
            _xifexpression = "InterfaceItemBase";
          }
          _builder.append(_xifexpression, "\t");
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// call initialize of sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_2 = cc.getActorRefs();
        for(final ActorRef sub_2 : _actorRefs_2) {
          _builder.append("\t");
          String _name_13 = sub_2.getName();
          _builder.append(_name_13, "\t");
          _builder.append(".initialize();");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_4 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_4) {
          _builder.append("void ");
          _builder.append(clsname);
          _builder.append("::setProbesActive(bool recursive, bool active) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("for(int i = 0; i < m_RTSystemPort.getNInterfaceItems(); i++)");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("DebuggingService::getInstance().addPortInstance(*(m_RTSystemPort.getInterfaceItem(i)));");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("if(recursive) {");
          _builder.newLine();
          {
            EList<ActorRef> _actorRefs_3 = cc.getActorRefs();
            for(final ActorRef sub_3 : _actorRefs_3) {
              _builder.append("\t\t");
              String _name_14 = sub_3.getName();
              _builder.append(_name_14, "\t\t");
              _builder.append(".setProbesActive(recursive, active);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("::init(){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("SubSystemClassBase::init();");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_5 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_5) {
          _builder.append("\t");
          _builder.append("DebuggingService::getInstance().addVisibleComment(\"done sub system initialization\");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_6 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_6) {
          _builder.newLine();
          _builder.append("void ");
          _builder.append(clsname);
          _builder.append("::destroy() {");
          _builder.newLineIfNotEmpty();
          {
            boolean _isGenerateMSCInstrumentation_7 = Main.getSettings().isGenerateMSCInstrumentation();
            if (_isGenerateMSCInstrumentation_7) {
              _builder.append("\t");
              _builder.append("DebuggingService::getInstance().getSyncLogger().addVisibleComment(\"starting destruction\");");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("MSCFunctionObject mscFunctionObject(getInstancePathName(), \"destroy()\");");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("DebuggingService::getInstance().addVisibleComment(\"begin sub system destruction\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("SubSystemClassBase::destroy();");
          _builder.newLine();
          {
            boolean _isGenerateMSCInstrumentation_8 = Main.getSettings().isGenerateMSCInstrumentation();
            if (_isGenerateMSCInstrumentation_8) {
              _builder.append("\t");
              _builder.append("DebuggingService::getInstance().addVisibleComment(\"done sub system destruction\");");
              _builder.newLine();
            }
          }
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      String _generateNamespaceEnd = this._cppExtensions.generateNamespaceEnd(cc);
      _builder.append(_generateNamespaceEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
