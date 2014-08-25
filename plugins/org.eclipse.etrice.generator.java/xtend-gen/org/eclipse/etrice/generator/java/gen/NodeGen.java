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
import java.util.Set;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
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
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
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
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
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
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    final Function1<WiredStructureClass, Boolean> _function = new Function1<WiredStructureClass, Boolean>() {
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
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(ssi, null));
          if (!_notEquals) {
            _and = false;
          } else {
            SubSystemClass _subSystemClass = ssi.getSubSystemClass();
            boolean _isValidGenerationLocation = this._fileSystemHelpers.isValidGenerationLocation(_subSystemClass);
            _and = _isValidGenerationLocation;
          }
          if (_and) {
            SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
            final WiredSubSystemClass wired = sscc2wired.get(_subSystemClass_1);
            SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
            String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass_2);
            SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
            String _path = this._roomExtensions.getPath(_subSystemClass_3);
            final String path = (_generationTargetPath + _path);
            SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
            String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_subSystemClass_4);
            SubSystemClass _subSystemClass_5 = ssi.getSubSystemClass();
            String _path_1 = this._roomExtensions.getPath(_subSystemClass_5);
            final String infopath = (_generationInfoPath + _path_1);
            final String file = this._javaExtensions.getJavaFileName(nr, ssi);
            this.checkDataPorts(ssi);
            final Set<PhysicalThread> usedThreads = ETMapUtil.getUsedThreads(nr, ssi);
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
  }
  
  /**
   * Recursively collect all possible interface instances below a given structure instance.
   */
  private HashSet<ActorClass> getOptionalActorClasses(final Root root, final StructureInstance si) {
    TreeIterator<EObject> _eAllContents = si.eAllContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject i) {
        return Boolean.valueOf((i instanceof ActorInterfaceInstance));
      }
    };
    Iterator<EObject> _filter = IteratorExtensions.<EObject>filter(_eAllContents, _function);
    final Function1<EObject, ActorInterfaceInstance> _function_1 = new Function1<EObject, ActorInterfaceInstance>() {
      public ActorInterfaceInstance apply(final EObject aii) {
        return ((ActorInterfaceInstance) aii);
      }
    };
    Iterator<ActorInterfaceInstance> _map = IteratorExtensions.<EObject, ActorInterfaceInstance>map(_filter, _function_1);
    final ArrayList<ActorInterfaceInstance> aifs = Lists.<ActorInterfaceInstance>newArrayList(_map);
    final Function1<ActorInterfaceInstance, ActorClass> _function_2 = new Function1<ActorInterfaceInstance, ActorClass>() {
      public ActorClass apply(final ActorInterfaceInstance aii) {
        return ((ActorInterfaceInstance) aii).getActorClass();
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
  
  public CharSequence generate(final Root root, final SubSystemInstance comp, final WiredSubSystemClass wired, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final SubSystemClass cc = comp.getSubSystemClass();
      final EList<RoomModel> models = root.getReferencedModels(cc);
      final NodeRef nr = ETMapUtil.getNodeRef(comp);
      final String clsname = this._javaExtensions.getJavaClassName(nr, comp);
      NodeClass _type = nr.getType();
      EList<PhysicalThread> _threads = _type.getThreads();
      final Function1<PhysicalThread, Boolean> _function = new Function1<PhysicalThread, Boolean>() {
        public Boolean apply(final PhysicalThread t) {
          return Boolean.valueOf(usedThreads.contains(t));
        }
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(_threads, _function);
      final HashSet<ActorClass> opt = this.getOptionalActorClasses(root, comp);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(cc);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.config.IVariableService;");
      _builder.newLine();
      {
        GlobalSettings _settings = Main.getSettings();
        boolean _generateMSCInstrumentation = _settings.generateMSCInstrumentation();
        if (_generateMSCInstrumentation) {
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
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(cc, 1, false);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(clsname, "");
      _builder.append(" extends SubSystemClassBase {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        Iterable<Indexed<PhysicalThread>> _indexed = Indexed.<PhysicalThread>indexed(threads);
        for(final Indexed<PhysicalThread> thread : _indexed) {
          _builder.append("\t");
          _builder.append("public static final int ");
          PhysicalThread _value = thread.getValue();
          String _threadId = this.getThreadId(_value);
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
      _builder.append("\t");
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
      {
        for(final PhysicalThread thread_1 : threads) {
          {
            boolean _or = false;
            ExecMode _execmode = thread_1.getExecmode();
            boolean _equals = Objects.equal(_execmode, ExecMode.POLLED);
            if (_equals) {
              _or = true;
            } else {
              ExecMode _execmode_1 = thread_1.getExecmode();
              boolean _equals_1 = Objects.equal(_execmode_1, ExecMode.MIXED);
              _or = _equals_1;
            }
            if (_or) {
              _builder.append("\t\t");
              _builder.append("msgService = new MessageService(this, MessageService.ExecMode.");
              ExecMode _execmode_2 = thread_1.getExecmode();
              String _name_1 = _execmode_2.getName();
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
              ExecMode _execmode_3 = thread_1.getExecmode();
              String _name_3 = _execmode_3.getName();
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
      _builder.append("\t\t");
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
            boolean _or_1 = false;
            boolean _isImplicit = mapped.isImplicit();
            if (_isImplicit) {
              _or_1 = true;
            } else {
              boolean _isAsParent = mapped.isAsParent();
              _or_1 = _isAsParent;
            }
            boolean _not = (!_or_1);
            if (_not) {
              _builder.append("\t\t");
              _builder.append("addPathToThread(\"");
              String _path = ai.getPath();
              _builder.append(_path, "\t\t");
              _builder.append("\", ");
              PhysicalThread _thread = mapped.getThread();
              String _threadId_3 = this.getThreadId(_thread);
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
                GlobalSettings _settings_1 = Main.getSettings();
                boolean _generateMSCInstrumentation_1 = _settings_1.generateMSCInstrumentation();
                if (_generateMSCInstrumentation_1) {
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                  String _name_5 = sub.getName();
                  _builder.append(_name_5, "\t\t\t");
                  _builder.append("_\"+i);");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("new ");
              ActorClass _type_1 = sub.getType();
              String _name_6 = _type_1.getName();
              _builder.append(_name_6, "\t\t\t");
              _builder.append("(this, \"");
              String _name_7 = sub.getName();
              _builder.append(_name_7, "\t\t\t");
              _builder.append("_\"+i);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              {
                GlobalSettings _settings_2 = Main.getSettings();
                boolean _generateMSCInstrumentation_2 = _settings_2.generateMSCInstrumentation();
                if (_generateMSCInstrumentation_2) {
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
              ActorClass _type_2 = sub.getType();
              String _name_9 = _type_2.getName();
              _builder.append(_name_9, "\t\t");
              _builder.append("(this, \"");
              String _name_10 = sub.getName();
              _builder.append(_name_10, "\t\t");
              _builder.append("\"); ");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// create service brokers in optional actor interfaces");
      _builder.newLine();
      {
        BasicEList<AbstractInstance> _allSubInstances = this._roomExtensions.getAllSubInstances(comp);
        final Function1<AbstractInstance, Boolean> _function_1 = new Function1<AbstractInstance, Boolean>() {
          public Boolean apply(final AbstractInstance inst) {
            return Boolean.valueOf((inst instanceof ActorInterfaceInstance));
          }
        };
        Iterable<AbstractInstance> _filter = IterableExtensions.<AbstractInstance>filter(_allSubInstances, _function_1);
        final Function1<AbstractInstance, ActorInterfaceInstance> _function_2 = new Function1<AbstractInstance, ActorInterfaceInstance>() {
          public ActorInterfaceInstance apply(final AbstractInstance inst) {
            return ((ActorInterfaceInstance) inst);
          }
        };
        Iterable<ActorInterfaceInstance> _map = IterableExtensions.<AbstractInstance, ActorInterfaceInstance>map(_filter, _function_2);
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
              ProtocolClass _protocol = svc.getProtocol();
              String _fullyQualifiedName = this._roomExtensions.getFullyQualifiedName(_protocol);
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
              ProtocolClass _protocol_1 = svc.getProtocol();
              String _fullyQualifiedName_1 = this._roomExtensions.getFullyQualifiedName(_protocol_1);
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
      _builder.append("\t\t");
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
          EList<String> _path1 = wire.getPath1();
          String _join = IterableExtensions.join(_path1, "/");
          _builder.append(_join, "\t\t");
          _builder.append("\", \"");
          EList<String> _path2 = wire.getPath2();
          String _join_1 = IterableExtensions.join(_path2, "/");
          _builder.append(_join_1, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
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
              ActorClass _actorClass = ai_1.getActorClass();
              String _name_11 = _actorClass.getName();
              _builder.append(_name_11, "\t\t\t");
              _builder.append(" inst = (");
              ActorClass _actorClass_1 = ai_1.getActorClass();
              String _name_12 = _actorClass_1.getName();
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void init(){");
      _builder.newLine();
      {
        GlobalSettings _settings_3 = Main.getSettings();
        boolean _generateMSCInstrumentation_3 = _settings_3.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_3) {
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
        GlobalSettings _settings_4 = Main.getSettings();
        boolean _generateMSCInstrumentation_4 = _settings_4.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_4) {
          _builder.append("\t\t");
          _builder.append("DebuggingService.getInstance().addVisibleComment(\"done sub system initialization\");");
          _builder.newLine();
        }
      }
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
        GlobalSettings _settings_5 = Main.getSettings();
        boolean _generateMSCInstrumentation_5 = _settings_5.generateMSCInstrumentation();
        if (_generateMSCInstrumentation_5) {
          _builder.append("\t");
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
          _builder.append("\t");
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
      _builder.append("\t");
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
            EList<ActorClass> _subClasses = root.getSubClasses(oa);
            List<ActorClass> _union = this._roomExtensions.<ActorClass>union(_subClasses, oa);
            final Function1<ActorClass, Boolean> _function_3 = new Function1<ActorClass, Boolean>() {
              public Boolean apply(final ActorClass s) {
                boolean _isAbstract = s.isAbstract();
                return Boolean.valueOf((!_isAbstract));
              }
            };
            Iterable<ActorClass> _filter_1 = IterableExtensions.<ActorClass>filter(_union, _function_3);
            for(final ActorClass subcls : _filter_1) {
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
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getThreadId(final PhysicalThread thread) {
    String _name = thread.getName();
    String _upperCase = _name.toUpperCase();
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
                    InterfaceItem _interfaceItem = pi.getInterfaceItem();
                    InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
                    EStructuralFeature _eContainingFeature = _interfaceItem_1.eContainingFeature();
                    this.diagnostician.error((pair + ": data ports placed on different threads (not supported yet)"), _interfaceItem, _eContainingFeature);
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
