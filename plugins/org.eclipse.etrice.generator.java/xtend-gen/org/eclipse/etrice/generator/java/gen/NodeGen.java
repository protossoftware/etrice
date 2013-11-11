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
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etmap.util.ETMapUtil.MappedThread;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.VariableServiceGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  private IGeneratorFileIo fileIO;
  
  @Inject
  private VariableServiceGen varService;
  
  @Inject
  private IDiagnostician diagnostician;
  
  public void doGenerate(final Root root) {
    HashMap<SubSystemClass,WiredSubSystemClass> _hashMap = new HashMap<SubSystemClass, WiredSubSystemClass>();
    final HashMap<SubSystemClass,WiredSubSystemClass> sscc2wired = _hashMap;
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    final Function1<WiredStructureClass,Boolean> _function = new Function1<WiredStructureClass,Boolean>() {
      public Boolean apply(final WiredStructureClass w) {
        return Boolean.valueOf((w instanceof WiredSubSystemClass));
      }
    };
    Iterable<WiredStructureClass> _filter = IterableExtensions.<WiredStructureClass>filter(_wiredInstances, _function);
    final Procedure1<WiredStructureClass> _function_1 = new Procedure1<WiredStructureClass>() {
      public void apply(final WiredStructureClass w) {
        SubSystemClass _subSystemClass = ((WiredSubSystemClass) w).getSubSystemClass();
        sscc2wired.put(_subSystemClass, ((WiredSubSystemClass) w));
      }
    };
    IterableExtensions.<WiredStructureClass>forEach(_filter, _function_1);
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          SubSystemClass _subSystemClass = ssi.getSubSystemClass();
          final WiredSubSystemClass wired = sscc2wired.get(_subSystemClass);
          SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
          String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass_1);
          SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
          String _path = this._roomExtensions.getPath(_subSystemClass_2);
          final String path = (_generationTargetPath + _path);
          SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
          String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_subSystemClass_3);
          SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
          String _path_1 = this._roomExtensions.getPath(_subSystemClass_4);
          final String infopath = (_generationInfoPath + _path_1);
          final String file = this._javaExtensions.getJavaFileName(nr, ssi);
          this.checkDataPorts(ssi);
          HashSet<PhysicalThread> _hashSet = new HashSet<PhysicalThread>();
          final HashSet<PhysicalThread> usedThreads = _hashSet;
          NodeClass _type = nr.getType();
          EList<PhysicalThread> _threads = _type.getThreads();
          for (final PhysicalThread thread : _threads) {
            {
              EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
              final Function1<ActorInstance,Boolean> _function_2 = new Function1<ActorInstance,Boolean>() {
                public Boolean apply(final ActorInstance ai) {
                  MappedThread _mappedThread = ETMapUtil.getMappedThread(ai);
                  PhysicalThread _thread = _mappedThread.getThread();
                  boolean _equals = Objects.equal(_thread, thread);
                  return Boolean.valueOf(_equals);
                }
              };
              final Iterable<ActorInstance> instancesOnThread = IterableExtensions.<ActorInstance>filter(_allContainedInstances, _function_2);
              boolean _isEmpty = IterableExtensions.isEmpty(instancesOnThread);
              boolean _not = (!_isEmpty);
              if (_not) {
                usedThreads.add(thread);
              }
            }
          }
          CharSequence _generate = this.generate(root, ssi, wired, usedThreads);
          this.fileIO.generateFile("generating Node implementation", path, infopath, file, _generate);
          boolean _hasVariableService = this.dataConfigExt.hasVariableService(ssi);
          if (_hasVariableService) {
            this.varService.doGenerate(root, ssi);
          }
        }
      }
    }
  }
  
  /**
   * Recursively collect all possible interface instances below a given structure instance.
   */
  private HashSet<ActorClass> getOptionalActorClasses(final Root root, final StructureInstance si) {
    TreeIterator<EObject> _eAllContents = si.eAllContents();
    final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
      public Boolean apply(final EObject i) {
        return Boolean.valueOf((i instanceof ActorInterfaceInstance));
      }
    };
    Iterator<EObject> _filter = IteratorExtensions.<EObject>filter(_eAllContents, _function);
    final Function1<EObject,ActorInterfaceInstance> _function_1 = new Function1<EObject,ActorInterfaceInstance>() {
      public ActorInterfaceInstance apply(final EObject aii) {
        return ((ActorInterfaceInstance) aii);
      }
    };
    Iterator<ActorInterfaceInstance> _map = IteratorExtensions.<EObject, ActorInterfaceInstance>map(_filter, _function_1);
    final ArrayList<ActorInterfaceInstance> aifs = Lists.<ActorInterfaceInstance>newArrayList(_map);
    final Function1<ActorInterfaceInstance,ActorClass> _function_2 = new Function1<ActorInterfaceInstance,ActorClass>() {
      public ActorClass apply(final ActorInterfaceInstance aii) {
        ActorClass _actorClass = ((ActorInterfaceInstance) aii).getActorClass();
        return _actorClass;
      }
    };
    List<ActorClass> _map_1 = ListExtensions.<ActorInterfaceInstance, ActorClass>map(aifs, _function_2);
    final HashSet<ActorClass> result = Sets.<ActorClass>newHashSet(_map_1);
    for (final ActorInterfaceInstance ai : aifs) {
      EList<OptionalActorInstance> _optionalInstances = ai.getOptionalInstances();
      for (final OptionalActorInstance oi : _optionalInstances) {
        HashSet<ActorClass> _optionalActorClasses = this.getOptionalActorClasses(root, oi);
        result.addAll(_optionalActorClasses);
      }
    }
    return result;
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final HashSet<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._javaExtensions.getJavaClassName(nr, comp);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread,Boolean> _function = new Function1<PhysicalThread,Boolean>() {
        public Boolean apply(final PhysicalThread t) {
          boolean _contains = usedThreads.contains(t);
          return Boolean.valueOf(_contains);
        }
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      final HashSet<ActorClass> opt = this.getOptionalActorClasses(root, comp);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �cc.getPackage()�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.IVariableService;");
      _builder.newLine();
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
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
      _builder.append("�FOR model : models�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import �model.name�.*;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�cc.userCode(1, false)�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class �clsname� extends SubSystemClassBase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR thread : threads.indexed�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public static final int �thread.value.threadId� = �thread.index0�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�cc.userCode(2, false)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �clsname�(IRTObject parent, String name) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void instantiateMessageServices() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("IMessageService msgService;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR thread: threads�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF thread.execmode==ExecMode::POLLED || thread.execmode==ExecMode::MIXED�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("msgService = new MessageService(this, MessageService.ExecMode.�thread.execmode.name�, �thread.time�, 0, �thread.threadId�, \"MessageService_�thread.name�\" /*, thread_prio */);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("msgService = new MessageService(this, MessageService.ExecMode.�thread.execmode.name�, 0, �thread.threadId�, \"MessageService_�thread.name�\" /*, thread_prio */);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// thread mappings");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ai : comp.allContainedInstances�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�val mapped = ETMapUtil::getMappedThread(ai)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF !(mapped.implicit || mapped.asParent)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("addPathToThread(\"�ai.path�\", �mapped.thread.threadId�);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR sub : cc.actorRefs�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF sub.multiplicity>1�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (int i=0; i<�sub.multiplicity�; ++i) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"�sub.name�_\"+i);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("new �sub.type.name�(this, \"�sub.name�_\"+i);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"�sub.name�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("new �sub.type.name�(this, \"�sub.name�\"); ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// create service brokers in optional actor interfaces");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR aii: comp.allSubInstances.filter(inst|inst instanceof ActorInterfaceInstance).map(inst|inst as ActorInterfaceInstance)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("OptionalActorInterfaceBase oai = (OptionalActorInterfaceBase) getObject(\"�aii.getPath()�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR svc: aii.providedServices�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("new InterfaceItemBroker(oai, \"�svc.protocol.fullyQualifiedName�\", 0);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("InterfaceItemBase.connect(this, \"�svc.path�\", \"�aii.getPath()+InstanceBase::pathDelim+svc.protocol.fullyQualifiedName�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
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
      _builder.append("// wiring");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR wire: wired.wires�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�if (wire.dataDriven) \"DataPortBase\" else \"InterfaceItemBase\"�.connect(this, \"�wire.path1.join(\'/\')�\", \"�wire.path2.join(\'/\')�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// apply instance attribute configurations");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ai: comp.allContainedInstances�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�val cfg = configGenAddon.genActorInstanceConfig(ai, \"inst\")�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF cfg.length>0�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ai.actorClass.name� inst = (�ai.actorClass.name�) getObject(\"�ai.path�\");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("if (inst!=null) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�cfg�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
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
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void init(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addVisibleComment(\"begin sub system initialization\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF dataConfigExt.hasVariableService(comp)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("variableService = new �clsname�VariableService(this);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.init();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF dataConfigExt.hasVariableService(comp)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("variableService.init();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addVisibleComment(\"done sub system initialization\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
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
      _builder.append("\t\t");
      _builder.append("�IF dataConfigExt.hasVariableService(comp)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("variableService.stop();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public boolean hasGeneratedMSCInstrumentation() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public void destroy() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addVisibleComment(\"begin sub system destruction\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super.destroy();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addVisibleComment(\"done sub system destruction\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�val else1 = new IntelligentSeparator(\"else \")�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR oa : opt�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�else1�if (optionalActorClass.equals(\"�oa.name�\")) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�val else2 = new IntelligentSeparator(\"else \")�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR subcls : root.getSubClasses(oa).union(oa).filter(s|!s.abstract)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�else2�if (\"�subcls.name�\".equals(actorClass)) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("return new �subcls.javaFactoryName�();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
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
      _builder.append("return null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _name = thread.getName();
    String _upperCase = _name.toUpperCase();
    String _plus = ("THREAD_" + _upperCase);
    return _plus;
  }
  
  private void checkDataPorts(final SubSystemInstance comp) {
    HashSet<String> _hashSet = new HashSet<String>();
    final HashSet<String> found = _hashSet;
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    for (final ActorInstance ai : _allContainedInstances) {
      {
        final int thread = ai.getThreadId();
        EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
        for (final InterfaceItemInstance pi : _orderedIfItemInstances) {
          ProtocolClass _protocol = pi.getProtocol();
          CommunicationType _commType = _protocol.getCommType();
          boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
          if (_equals) {
            EList<InterfaceItemInstance> _peers = pi.getPeers();
            for (final InterfaceItemInstance peer : _peers) {
              {
                EObject _eContainer = peer.eContainer();
                final ActorInstance peer_ai = ((ActorInstance) _eContainer);
                final int peer_thread = peer_ai.getThreadId();
                boolean _notEquals = (thread != peer_thread);
                if (_notEquals) {
                  final String path = pi.getPath();
                  final String ppath = peer.getPath();
                  String _xifexpression = null;
                  int _compareTo = path.compareTo(ppath);
                  boolean _lessThan = (_compareTo < 0);
                  if (_lessThan) {
                    String _plus = (path + " and ");
                    String _plus_1 = (_plus + ppath);
                    _xifexpression = _plus_1;
                  } else {
                    String _plus_2 = (ppath + " and ");
                    String _plus_3 = (_plus_2 + path);
                    _xifexpression = _plus_3;
                  }
                  final String pair = _xifexpression;
                  boolean _contains = found.contains(pair);
                  boolean _not = (!_contains);
                  if (_not) {
                    found.add(pair);
                    String _plus_4 = (pair + ": data ports placed on different threads (not supported yet)");
                    InterfaceItem _interfaceItem = pi.getInterfaceItem();
                    InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
                    EStructuralFeature _eContainingFeature = _interfaceItem_1.eContainingFeature();
                    this.diagnostician.error(_plus_4, _interfaceItem, _eContainingFeature);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean isKindOf(final ActorClass ac, final HashSet<ActorClass> classes) {
    boolean _xblockexpression = false;
    {
      ActorClass a = ac;
      boolean _notEquals = (!Objects.equal(a, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          boolean _contains = classes.contains(a);
          if (_contains) {
            return true;
          }
          ActorClass _base = a.getBase();
          a = _base;
        }
        boolean _notEquals_1 = (!Objects.equal(a, null));
        _while = _notEquals_1;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
}
