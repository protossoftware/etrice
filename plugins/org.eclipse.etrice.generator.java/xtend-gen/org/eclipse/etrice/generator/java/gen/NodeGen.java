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
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.fsm.base.Indexed;
import org.eclipse.etrice.generator.fsm.base.IntelligentSeparator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.VariableServiceGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class NodeGen {
  @Inject
  @Extension
  private JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ConfigGenAddon configGenAddon;
  
  @Inject
  @Extension
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private VariableServiceGen varService;
  
  @Inject
  private IDiagnostician diagnostician;
  
  public void doGenerate(final Root root) {
    final HashMap<SubSystemClass, WiredSubSystemClass> sscc2wired = new HashMap<SubSystemClass, WiredSubSystemClass>();
    final Function1<WiredStructureClass, Boolean> _function = (WiredStructureClass w) -> {
      return Boolean.valueOf((w instanceof WiredSubSystemClass));
    };
    final Consumer<WiredStructureClass> _function_1 = (WiredStructureClass w) -> {
      sscc2wired.put(((WiredSubSystemClass) w).getSubSystemClass(), ((WiredSubSystemClass) w));
    };
    IterableExtensions.<WiredStructureClass>filter(root.getWiredInstances(), _function).forEach(_function_1);
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
            final String file = this._javaExtensions.getJavaFileName(nr, ssi);
            this.checkDataPorts(ssi);
            final Set<PhysicalThread> usedThreads = ETMapUtil.getUsedThreads(nr, ssi);
            this.fileIO.generateFile("generating Node implementation", path, infopath, file, this.generate(root, ssi, wired, usedThreads));
            boolean _hasVariableService = this.dataConfigExt.hasVariableService(ssi);
            if (_hasVariableService) {
              this.varService.doGenerate(root, ssi);
            }
          }
        }
      }
    }
  }
  
  /**
   * Recursively collect all possible interface instances below a given structure instance.
   */
  private HashSet<ActorClass> getOptionalActorClasses(final Root root, final StructureInstance si) {
    final Function1<EObject, Boolean> _function = (EObject i) -> {
      return Boolean.valueOf((i instanceof ActorInterfaceInstance));
    };
    final Function1<EObject, ActorInterfaceInstance> _function_1 = (EObject aii) -> {
      return ((ActorInterfaceInstance) aii);
    };
    final ArrayList<ActorInterfaceInstance> aifs = Lists.<ActorInterfaceInstance>newArrayList(IteratorExtensions.<EObject, ActorInterfaceInstance>map(IteratorExtensions.<EObject>filter(si.eAllContents(), _function), _function_1));
    final Function1<ActorInterfaceInstance, ActorClass> _function_2 = (ActorInterfaceInstance aii) -> {
      return ((ActorInterfaceInstance) aii).getActorClass();
    };
    final HashSet<ActorClass> result = Sets.<ActorClass>newHashSet(ListExtensions.<ActorInterfaceInstance, ActorClass>map(aifs, _function_2));
    for (final ActorInterfaceInstance ai : aifs) {
      EList<OptionalActorInstance> _optionalInstances = ai.getOptionalInstances();
      for (final OptionalActorInstance oi : _optionalInstances) {
        result.addAll(this.getOptionalActorClasses(root, oi));
      }
    }
    return result;
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._javaExtensions.getJavaClassName(nr, comp);
      final Function1<PhysicalThread, Boolean> _function = (PhysicalThread t) -> {
        return Boolean.valueOf(usedThreads.contains(t));
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function);
      final HashSet<ActorClass> opt = this.getOptionalActorClasses(root, comp);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(cc);
      _builder.append(_package);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.IVariableService;");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation) {
          _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
          _builder.newLine();
        }
      }
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IMessageService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;");
      _builder.newLine();
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name);
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(cc, 1, false);
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname);
      _builder.append(" extends SubSystemClassBase {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("\t");
          _builder.append("public static final int ");
          String _threadId = this.getThreadId(thread.getValue());
          _builder.append(_threadId, "\t");
          _builder.append(" = ");
          int _index0 = thread.getIndex0();
          _builder.append(_index0, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(cc, 2, false);
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "\t");
      _builder.append("(IRTObject parent, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void instantiateMessageServices() {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("IMessageService msgService;");
      _builder.newLine();
      {
        final Function1<PhysicalThread, Long> _function_1 = (PhysicalThread it) -> {
          long _prio = it.getPrio();
          return Long.valueOf((-_prio));
        };
        List<PhysicalThread> _sortBy = IterableExtensions.<PhysicalThread, Long>sortBy(threads, _function_1);
        for(final PhysicalThread thread_1 : _sortBy) {
          {
            if ((Objects.equal(thread_1.getExecmode(), ExecMode.POLLED) || Objects.equal(thread_1.getExecmode(), ExecMode.MIXED))) {
              _builder.append("\t\t");
              _builder.append("msgService = new MessageService(this, MessageService.ExecMode.");
              String _name_1 = thread_1.getExecmode().getName();
              _builder.append(_name_1, "\t\t");
              _builder.append(", ");
              long _time = thread_1.getTime();
              _builder.append(_time, "\t\t");
              _builder.append("L, 0, ");
              String _threadId_1 = this.getThreadId(thread_1);
              _builder.append(_threadId_1, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_2 = thread_1.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append("\" /*, thread_prio */);");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("msgService = new MessageService(this, MessageService.ExecMode.");
              String _name_3 = thread_1.getExecmode().getName();
              _builder.append(_name_3, "\t\t");
              _builder.append(", 0, ");
              String _threadId_2 = this.getThreadId(thread_1);
              _builder.append(_threadId_2, "\t\t");
              _builder.append(", \"MessageService_");
              String _name_4 = thread_1.getName();
              _builder.append(_name_4, "\t\t");
              _builder.append("\" /*, thread_prio */);");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void instantiateActors() {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("\t\t");
          final ETMapUtil.MappedThread mapped = ETMapUtil.getMappedThread(ai);
          _builder.newLineIfNotEmpty();
          {
            boolean _not = (!(mapped.isImplicit() || mapped.isAsParent()));
            if (_not) {
              _builder.append("\t\t");
              _builder.append("addPathToThread(\"");
              String _path = ai.getPath();
              _builder.append(_path, "\t\t");
              _builder.append("\", ");
              String _threadId_3 = this.getThreadId(mapped.getThread());
              _builder.append(_threadId_3, "\t\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
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
              _builder.append("for (int i=0; i<");
              int _multiplicity_1 = sub.getMultiplicity();
              _builder.append(_multiplicity_1, "\t\t");
              _builder.append("; ++i) {");
              _builder.newLineIfNotEmpty();
              {
                boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation_1) {
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                  String _name_5 = sub.getName();
                  _builder.append(_name_5, "\t\t\t");
                  _builder.append(GenmodelConstants.INDEX_SEP, "\t\t\t");
                  _builder.append("\"+i);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("new ");
              String _name_6 = sub.getType().getName();
              _builder.append(_name_6, "\t\t\t");
              _builder.append("(this, \"");
              String _name_7 = sub.getName();
              _builder.append(_name_7, "\t\t\t");
              _builder.append(GenmodelConstants.INDEX_SEP, "\t\t\t");
              _builder.append("\"+i);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              {
                boolean _isGenerateMSCInstrumentation_2 = Main.getSettings().isGenerateMSCInstrumentation();
                if (_isGenerateMSCInstrumentation_2) {
                  _builder.append("\t\t");
                  _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                  String _name_8 = sub.getName();
                  _builder.append(_name_8, "\t\t");
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t");
              _builder.append("new ");
              String _name_9 = sub.getType().getName();
              _builder.append(_name_9, "\t\t");
              _builder.append("(this, \"");
              String _name_10 = sub.getName();
              _builder.append(_name_10, "\t\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// create service brokers in optional actor interfaces");
      _builder.newLine();
      {
        final Function1<AbstractInstance, Boolean> _function_2 = (AbstractInstance inst) -> {
          return Boolean.valueOf((inst instanceof ActorInterfaceInstance));
        };
        final Function1<AbstractInstance, ActorInterfaceInstance> _function_3 = (AbstractInstance inst) -> {
          return ((ActorInterfaceInstance) inst);
        };
        Iterable<ActorInterfaceInstance> _map = IterableExtensions.<AbstractInstance, ActorInterfaceInstance>map(IterableExtensions.<AbstractInstance>filter(this._roomExtensions.getAllSubInstances(comp), _function_2), _function_3);
        for(final ActorInterfaceInstance aii : _map) {
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("OptionalActorInterfaceBase oai = (OptionalActorInterfaceBase) getObject(\"");
          String _path_1 = aii.getPath();
          _builder.append(_path_1, "\t\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
          {
            EList<ServiceImplInstance> _providedServices = aii.getProvidedServices();
            for(final ServiceImplInstance svc : _providedServices) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("new InterfaceItemBroker(oai, \"");
              String _fullyQualifiedName = this._roomExtensions.getFullyQualifiedName(svc.getProtocol());
              _builder.append(_fullyQualifiedName, "\t\t\t");
              _builder.append("\", 0);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("InterfaceItemBase.connect(this, \"");
              String _path_2 = svc.getPath();
              _builder.append(_path_2, "\t\t\t");
              _builder.append("\", \"");
              String _path_3 = aii.getPath();
              String _plus = (_path_3 + Character.valueOf(InstanceBase.pathDelim));
              String _fullyQualifiedName_1 = this._roomExtensions.getFullyQualifiedName(svc.getProtocol());
              String _plus_1 = (_plus + _fullyQualifiedName_1);
              _builder.append(_plus_1, "\t\t\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// wiring");
      _builder.newLine();
      {
        EList<Wire> _wires = wired.getWires();
        for(final Wire wire : _wires) {
          _builder.append("\t\t");
          String _xifexpression = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression = "DataPortBase";
          } else {
            _xifexpression = "InterfaceItemBase";
          }
          _builder.append(_xifexpression, "\t\t");
          _builder.append(".connect(this, \"");
          String _join = IterableExtensions.join(wire.getPath1(), "/");
          _builder.append(_join, "\t\t");
          _builder.append("\", \"");
          String _join_1 = IterableExtensions.join(wire.getPath2(), "/");
          _builder.append(_join_1, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// apply instance attribute configurations");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = comp.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          _builder.append("\t\t");
          final CharSequence cfg = this.configGenAddon.genActorInstanceConfig(ai_1, "inst");
          _builder.newLineIfNotEmpty();
          {
            int _length = cfg.length();
            boolean _greaterThan_1 = (_length > 0);
            if (_greaterThan_1) {
              _builder.append("\t\t");
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t");
              String _name_11 = ai_1.getActorClass().getName();
              _builder.append(_name_11, "\t\t\t");
              _builder.append(" inst = (");
              String _name_12 = ai_1.getActorClass().getName();
              _builder.append(_name_12, "\t\t\t");
              _builder.append(") getObject(\"");
              String _path_4 = ai_1.getPath();
              _builder.append(_path_4, "\t\t\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("if (inst!=null) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("\t\t");
              _builder.append(cfg, "\t\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void init(){");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_3 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_3) {
          _builder.append("\t\t");
          _builder.append("DebuggingService.getInstance().addVisibleComment(\"begin sub system initialization\");");
          _builder.newLine();
        }
      }
      {
        boolean _hasVariableService = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService) {
          _builder.append("\t\t");
          _builder.append("variableService = new ");
          _builder.append(clsname, "\t\t");
          _builder.append("VariableService(this);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("super.init();");
      _builder.newLine();
      {
        boolean _hasVariableService_1 = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService_1) {
          _builder.append("\t\t");
          _builder.append("variableService.init();");
          _builder.newLine();
        }
      }
      {
        boolean _isGenerateMSCInstrumentation_4 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_4) {
          _builder.append("\t\t");
          _builder.append("DebuggingService.getInstance().addVisibleComment(\"done sub system initialization\");");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void stop(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.stop();");
      _builder.newLine();
      {
        boolean _hasVariableService_2 = this.dataConfigExt.hasVariableService(comp);
        if (_hasVariableService_2) {
          _builder.append("\t\t");
          _builder.append("variableService.stop();");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        boolean _isGenerateMSCInstrumentation_5 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_5) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public boolean hasGeneratedMSCInstrumentation() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return true;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void destroy() {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addVisibleComment(\"begin sub system destruction\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super.destroy();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("DebuggingService.getInstance().addVisibleComment(\"done sub system destruction\");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {");
      _builder.newLine();
      _builder.append("\t\t");
      final IntelligentSeparator else1 = new IntelligentSeparator("else ");
      _builder.newLineIfNotEmpty();
      {
        for(final ActorClass oa : opt) {
          _builder.append("\t\t");
          _builder.append(else1, "\t\t");
          _builder.append("if (optionalActorClass.equals(\"");
          String _name_13 = oa.getName();
          _builder.append(_name_13, "\t\t");
          _builder.append("\")) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          final IntelligentSeparator else2 = new IntelligentSeparator("else ");
          _builder.newLineIfNotEmpty();
          {
            final Function1<ActorClass, Boolean> _function_4 = (ActorClass s) -> {
              boolean _isAbstract = s.isAbstract();
              return Boolean.valueOf((!_isAbstract));
            };
            Iterable<ActorClass> _filter = IterableExtensions.<ActorClass>filter(this._roomExtensions.<ActorClass>union(root.getSubClasses(oa), oa), _function_4);
            for(final ActorClass subcls : _filter) {
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append(else2, "\t\t\t");
              _builder.append("if (\"");
              String _name_14 = subcls.getName();
              _builder.append(_name_14, "\t\t\t");
              _builder.append("\".equals(actorClass)) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return new ");
              String _javaFactoryName = this._javaExtensions.getJavaFactoryName(subcls);
              _builder.append(_javaFactoryName, "\t\t\t\t");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _upperCase = thread.getName().toUpperCase();
    return ("THREAD_" + _upperCase);
  }
  
  private void checkDataPorts(final SubSystemInstance comp) {
    final HashSet<String> found = new HashSet<String>();
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    for (final ActorInstance ai : _allContainedInstances) {
      {
        final int thread = ai.getThreadId();
        EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
        for (final InterfaceItemInstance pi : _orderedIfItemInstances) {
          CommunicationType _commType = pi.getProtocol().getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (_equals) {
            EList<InterfaceItemInstance> _peers = pi.getPeers();
            for (final InterfaceItemInstance peer : _peers) {
              {
                EObject _eContainer = peer.eContainer();
                final ActorInstance peer_ai = ((ActorInstance) _eContainer);
                final int peer_thread = peer_ai.getThreadId();
                if ((thread != peer_thread)) {
                  final String path = pi.getPath();
                  final String ppath = peer.getPath();
                  String _xifexpression = null;
                  int _compareTo = path.compareTo(ppath);
                  boolean _lessThan = (_compareTo < 0);
                  if (_lessThan) {
                    _xifexpression = ((path + " and ") + ppath);
                  } else {
                    _xifexpression = ((ppath + " and ") + path);
                  }
                  final String pair = _xifexpression;
                  boolean _contains = found.contains(pair);
                  boolean _not = (!_contains);
                  if (_not) {
                    found.add(pair);
                    this.diagnostician.error((pair + ": data ports placed on different threads (not supported yet)"), 
                      pi.getInterfaceItem(), pi.getInterfaceItem().eContainingFeature());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
