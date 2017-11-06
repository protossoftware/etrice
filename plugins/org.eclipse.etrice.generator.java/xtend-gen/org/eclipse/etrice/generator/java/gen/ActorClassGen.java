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
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.StateMachineGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  protected IGeneratorFileIo fileIO;
  
  @Inject
  @Extension
  protected JavaExtensions _javaExtensions;
  
  @Inject
  @Extension
  protected RoomExtensions _roomExtensions;
  
  @Inject
  protected IDataConfiguration dataConfigExt;
  
  protected final ConfigGenAddon configGenAddon;
  
  @Inject
  @Extension
  protected ProcedureHelpers _procedureHelpers;
  
  @Inject
  @Extension
  protected Initialization _initialization;
  
  @Inject
  @Extension
  protected StateMachineGen _stateMachineGen;
  
  @Inject
  @Extension
  protected TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  protected FileSystemHelpers _fileSystemHelpers;
  
  @Inject
  public ActorClassGen(final ConfigGenAddon configGenAddon) {
    this.configGenAddon = configGenAddon;
  }
  
  public void doGenerate(final Root root) {
    final HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>();
    final Function1<WiredStructureClass, Boolean> _function = (WiredStructureClass w) -> {
      return Boolean.valueOf((w instanceof WiredActorClass));
    };
    final Consumer<WiredStructureClass> _function_1 = (WiredStructureClass w) -> {
      ac2wired.put(((WiredActorClass) w).getActorClass(), ((WiredActorClass) w));
    };
    IterableExtensions.<WiredStructureClass>filter(root.getWiredInstances(), _function).forEach(_function_1);
    final Function1<ActorClass, Boolean> _function_2 = (ActorClass it) -> {
      return Boolean.valueOf(this._fileSystemHelpers.isValidGenerationLocation(it));
    };
    final Function1<ActorClass, ExpandedActorClass> _function_3 = (ActorClass it) -> {
      return root.getExpandedActorClass(it);
    };
    Iterable<ExpandedActorClass> _map = IterableExtensions.<ActorClass, ExpandedActorClass>map(IterableExtensions.<ActorClass>filter(root.getActorClasses(), _function_2), _function_3);
    for (final ExpandedActorClass xpac : _map) {
      {
        final WiredActorClass wired = ac2wired.get(xpac.getActorClass());
        final boolean manualBehavior = this._roomHelpers.isBehaviorAnnotationPresent(xpac.getActorClass(), "BehaviorManual");
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(xpac.getActorClass());
        String _path = this._roomExtensions.getPath(xpac.getActorClass());
        final String path = (_generationTargetPath + _path);
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(xpac.getActorClass());
        String _path_1 = this._roomExtensions.getPath(xpac.getActorClass());
        final String infopath = (_generationInfoPath + _path_1);
        String file = this._javaExtensions.getJavaFileName(xpac.getActorClass());
        if (manualBehavior) {
          file = ("Abstract" + file);
        }
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, file, this.generate(root, xpac, wired, manualBehavior));
      }
    }
  }
  
  public CharSequence generate(final Root root, final ExpandedActorClass xpac, final WiredActorClass wired, final boolean manualBehavior) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      String _xifexpression = null;
      if (manualBehavior) {
        String _name = ac.getName();
        _xifexpression = ("Abstract" + _name);
      } else {
        _xifexpression = ac.getName();
      }
      final String clsname = _xifexpression;
      final EList<RoomModel> models = root.getReferencedModels(ac);
      String _xifexpression_1 = null;
      boolean _isGeneratePersistenceInterface = Main.getSettings().isGeneratePersistenceInterface();
      if (_isGeneratePersistenceInterface) {
        _xifexpression_1 = "implements IPersistable ";
      } else {
        _xifexpression_1 = "";
      }
      final String impPersist = _xifexpression_1;
      String _name_1 = ac.getName();
      final String dataObjClass = (_name_1 + "_DataObject");
      String _xifexpression_2 = null;
      ActorClass _actorBase = ac.getActorBase();
      boolean _notEquals = (!Objects.equal(_actorBase, null));
      if (_notEquals) {
        _xifexpression_2 = ac.getActorBase().getName();
      } else {
        String _xifexpression_3 = null;
        boolean _isEmpty = this._roomHelpers.getAttribute(ac, "ActorBaseClass", "class").isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _xifexpression_3 = this._roomHelpers.getAttribute(ac, "ActorBaseClass", "class");
        } else {
          String _xifexpression_4 = null;
          boolean _isGenerateStoreDataObj = Main.getSettings().isGenerateStoreDataObj();
          if (_isGenerateStoreDataObj) {
            _xifexpression_4 = "ActorClassFinalActionBase";
          } else {
            _xifexpression_4 = "ActorClassBase";
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression_2 = _xifexpression_3;
      }
      final String baseClass = _xifexpression_2;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        boolean _isEmpty_1 = this.dataConfigExt.getDynConfigReadAttributes(ac).isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("import org.eclipse.etrice.runtime.java.config.DynConfigLock;");
          _builder.newLine();
        }
      }
      {
        boolean _isGeneratePersistenceInterface_1 = Main.getSettings().isGeneratePersistenceInterface();
        if (_isGeneratePersistenceInterface_1) {
          _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IPersistable;");
          _builder.newLine();
          _builder.append("import java.io.IOException;");
          _builder.newLine();
          _builder.append("import java.io.ObjectInput;");
          _builder.newLine();
          _builder.append("import java.io.ObjectOutput;");
          _builder.newLine();
        }
      }
      {
        boolean _isGenerateStoreDataObj_1 = Main.getSettings().isGenerateStoreDataObj();
        if (_isGenerateStoreDataObj_1) {
          _builder.append("import java.util.Arrays;");
          _builder.newLine();
        }
      }
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.*;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.*;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.debugging.*;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
      _builder.newLine();
      _builder.newLine();
      {
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name_2 = model.getName();
          _builder.append(_name_2);
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("import ");
          String _package_1 = this._roomExtensions.getPackage(pc);
          _builder.append(_package_1);
          _builder.append(".");
          String _name_3 = pc.getName();
          _builder.append(_name_3);
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        final Function1<ActorRef, Boolean> _function = (ActorRef r) -> {
          ReferenceType _refType = r.getRefType();
          return Boolean.valueOf(Objects.equal(_refType, ReferenceType.OPTIONAL));
        };
        Iterable<ActorRef> _filter = IterableExtensions.<ActorRef>filter(ac.getActorRefs(), _function);
        for(final ActorRef sub : _filter) {
          _builder.append("import ");
          String _package_2 = this._roomExtensions.getPackage(sub.getType());
          _builder.append(_package_2);
          _builder.append(".");
          String _name_4 = sub.getType().getName();
          _builder.append(_name_4);
          _builder.append("Interface;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1, true);
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public ");
      {
        if ((manualBehavior || ac.isAbstract())) {
          _builder.append("abstract ");
        }
      }
      _builder.append("class ");
      _builder.append(clsname);
      _builder.append(" extends ");
      _builder.append(baseClass);
      _builder.append(" ");
      _builder.append(impPersist);
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2, false);
      _builder.append(_userCode_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- ports");
      _builder.newLine();
      {
        List<Port> _endPorts = this._roomHelpers.getEndPorts(ac);
        for(final Port ep : _endPorts) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName = this._roomExtensions.getPortClassName(ep);
          _builder.append(_portClassName, "\t");
          _builder.append(" ");
          String _name_5 = ep.getName();
          _builder.append(_name_5, "\t");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- saps");
      _builder.newLine();
      {
        EList<SAP> _serviceAccessPoints = ac.getServiceAccessPoints();
        for(final SAP sap : _serviceAccessPoints) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName_1 = this._roomExtensions.getPortClassName(sap);
          _builder.append(_portClassName_1, "\t");
          _builder.append(" ");
          String _name_6 = sap.getName();
          _builder.append(_name_6, "\t");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- services");
      _builder.newLine();
      {
        EList<ServiceImplementation> _serviceImplementations = ac.getServiceImplementations();
        for(final ServiceImplementation svc : _serviceImplementations) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName_2 = this._roomExtensions.getPortClassName(svc);
          _builder.append(_portClassName_2, "\t");
          _builder.append(" ");
          String _name_7 = svc.getSpp().getName();
          _builder.append(_name_7, "\t");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- optional actors");
      _builder.newLine();
      {
        final Function1<ActorRef, Boolean> _function_1 = (ActorRef r) -> {
          ReferenceType _refType = r.getRefType();
          return Boolean.valueOf(Objects.equal(_refType, ReferenceType.OPTIONAL));
        };
        Iterable<ActorRef> _filter_1 = IterableExtensions.<ActorRef>filter(ac.getActorRefs(), _function_1);
        for(final ActorRef sub_1 : _filter_1) {
          _builder.append("\t");
          _builder.append("protected ");
          String _name_8 = sub_1.getType().getName();
          _builder.append(_name_8, "\t");
          {
            int _multiplicity = sub_1.getMultiplicity();
            boolean _notEquals_1 = (_multiplicity != 1);
            if (_notEquals_1) {
              _builder.append("Replicated");
            }
          }
          _builder.append("Interface ");
          String _name_9 = sub_1.getName();
          _builder.append(_name_9, "\t");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
      _builder.append(_genInterfaceItemConstants, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      String _genMinMaxConstants = this.configGenAddon.genMinMaxConstants(ac);
      _builder.append(_genMinMaxConstants, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _attributes = this._procedureHelpers.attributes(ac.getAttributes());
      _builder.append(_attributes, "\t");
      _builder.newLineIfNotEmpty();
      {
        List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
        for(final Attribute a : _dynConfigReadAttributes) {
          _builder.append("\t");
          _builder.append("private DynConfigLock lock_");
          String _name_10 = a.getName();
          _builder.append(_name_10, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(ac.getOperations(), ac.getName());
      _builder.append(_operationsImplementation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "\t");
      _builder.append("(IRTObject parent, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("setClassName(\"");
      String _name_11 = ac.getName();
      _builder.append(_name_11, "\t\t");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(ac.getAttributes(), ac, false);
      _builder.append(_attributeInitialization, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own ports");
      _builder.newLine();
      {
        List<Port> _endPorts_1 = this._roomHelpers.getEndPorts(ac);
        for(final Port ep_1 : _endPorts_1) {
          _builder.append("\t\t");
          String _name_12 = ep_1.getName();
          _builder.append(_name_12, "\t\t");
          _builder.append(" = new ");
          String _portClassName_3 = this._roomExtensions.getPortClassName(ep_1);
          _builder.append(_portClassName_3, "\t\t");
          _builder.append("(this, \"");
          String _name_13 = ep_1.getName();
          _builder.append(_name_13, "\t\t");
          _builder.append("\", ");
          String _ifItemId = this.getIfItemId(ep_1);
          _builder.append(_ifItemId, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own saps");
      _builder.newLine();
      {
        EList<SAP> _serviceAccessPoints_1 = ac.getServiceAccessPoints();
        for(final SAP sap_1 : _serviceAccessPoints_1) {
          _builder.append("\t\t");
          String _name_14 = sap_1.getName();
          _builder.append(_name_14, "\t\t");
          _builder.append(" = new ");
          String _portClassName_4 = this._roomExtensions.getPortClassName(sap_1);
          _builder.append(_portClassName_4, "\t\t");
          _builder.append("(this, \"");
          String _name_15 = sap_1.getName();
          _builder.append(_name_15, "\t\t");
          _builder.append("\", ");
          String _ifItemId_1 = this.getIfItemId(sap_1);
          _builder.append(_ifItemId_1, "\t\t");
          _builder.append(", 0);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own service implementations");
      _builder.newLine();
      {
        EList<ServiceImplementation> _serviceImplementations_1 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_1 : _serviceImplementations_1) {
          _builder.append("\t\t");
          String _name_16 = svc_1.getSpp().getName();
          _builder.append(_name_16, "\t\t");
          _builder.append(" = new ");
          String _portClassName_5 = this._roomExtensions.getPortClassName(svc_1);
          _builder.append(_portClassName_5, "\t\t");
          _builder.append("(this, \"");
          String _name_17 = svc_1.getSpp().getName();
          _builder.append(_name_17, "\t\t");
          _builder.append("\", ");
          String _ifItemId_2 = this.getIfItemId(svc_1.getSpp());
          _builder.append(_ifItemId_2, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs = ac.getActorRefs();
        for(final ActorRef sub_2 : _actorRefs) {
          {
            ReferenceType _refType = sub_2.getRefType();
            boolean _equals = Objects.equal(_refType, ReferenceType.OPTIONAL);
            if (_equals) {
              _builder.append("\t\t");
              String _name_18 = sub_2.getName();
              _builder.append(_name_18, "\t\t");
              _builder.append(" = new ");
              String _name_19 = sub_2.getType().getName();
              _builder.append(_name_19, "\t\t");
              {
                int _multiplicity_1 = sub_2.getMultiplicity();
                boolean _notEquals_2 = (_multiplicity_1 != 1);
                if (_notEquals_2) {
                  _builder.append("Replicated");
                }
              }
              _builder.append("Interface(this, \"");
              String _name_20 = sub_2.getName();
              _builder.append(_name_20, "\t\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            } else {
              int _multiplicity_2 = sub_2.getMultiplicity();
              boolean _greaterThan = (_multiplicity_2 > 1);
              if (_greaterThan) {
                _builder.append("\t\t");
                _builder.append("for (int i=0; i<");
                int _multiplicity_3 = sub_2.getMultiplicity();
                _builder.append(_multiplicity_3, "\t\t");
                _builder.append("; ++i) {");
                _builder.newLineIfNotEmpty();
                {
                  boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
                  if (_isGenerateMSCInstrumentation) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_21 = sub_2.getName();
                    _builder.append(_name_21, "\t\t\t");
                    _builder.append(GenmodelConstants.INDEX_SEP, "\t\t\t");
                    _builder.append("\"+i);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("new ");
                String _name_22 = sub_2.getType().getName();
                _builder.append(_name_22, "\t\t\t");
                _builder.append("(this, \"");
                String _name_23 = sub_2.getName();
                _builder.append(_name_23, "\t\t\t");
                _builder.append(GenmodelConstants.INDEX_SEP, "\t\t\t");
                _builder.append("\"+i);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                {
                  boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
                  if (_isGenerateMSCInstrumentation_1) {
                    _builder.append("\t\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_24 = sub_2.getName();
                    _builder.append(_name_24, "\t\t");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("new ");
                String _name_25 = sub_2.getType().getName();
                _builder.append(_name_25, "\t\t");
                _builder.append("(this, \"");
                String _name_26 = sub_2.getName();
                _builder.append(_name_26, "\t\t");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
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
          String _xifexpression_5 = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression_5 = "DataPortBase";
          } else {
            _xifexpression_5 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_5, "\t\t");
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
      {
        if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
          _builder.append("\t\t");
          _builder.append("// activate polling for data-driven communication");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(getThread()).addPollingMessageReceiver(this);");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      String _userStructorBody = this._procedureHelpers.userStructorBody(ac, true);
      _builder.append(_userStructorBody, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if (((!this.dataConfigExt.getDynConfigReadAttributes(ac).isEmpty()) || (!this.dataConfigExt.getDynConfigWriteAttributes(ac).isEmpty()))) {
          {
            List<Attribute> _dynConfigReadAttributes_1 = this.dataConfigExt.getDynConfigReadAttributes(ac);
            for(final Attribute a_1 : _dynConfigReadAttributes_1) {
              _builder.append("\t\t");
              _builder.append("lock_");
              String _name_27 = a_1.getName();
              _builder.append(_name_27, "\t\t");
              _builder.append(" = new DynConfigLock();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(this._roomExtensions.<Attribute>minus(ac.getAttributes(), this.dataConfigExt.getDynConfigReadAttributes(ac)), ac.getName());
      _builder.append(_attributeSettersGettersImplementation, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genDynConfigGetterSetter = this.configGenAddon.genDynConfigGetterSetter(ac);
      _builder.append(_genDynConfigGetterSetter, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- port getters");
      _builder.newLine();
      {
        List<Port> _endPorts_2 = this._roomHelpers.getEndPorts(ac);
        for(final Port ep_2 : _endPorts_2) {
          _builder.append("\t");
          CharSequence _terImplementation = this._procedureHelpers.getterImplementation(this._roomExtensions.getPortClassName(ep_2), ep_2.getName(), ac.getName());
          _builder.append(_terImplementation, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<SAP> _serviceAccessPoints_2 = ac.getServiceAccessPoints();
        for(final SAP sap_2 : _serviceAccessPoints_2) {
          _builder.append("\t");
          CharSequence _terImplementation_1 = this._procedureHelpers.getterImplementation(this._roomExtensions.getPortClassName(sap_2), sap_2.getName(), ac.getName());
          _builder.append(_terImplementation_1, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ServiceImplementation> _serviceImplementations_2 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_2 : _serviceImplementations_2) {
          _builder.append("\t");
          CharSequence _terImplementation_2 = this._procedureHelpers.getterImplementation(this._roomExtensions.getPortClassName(svc_2), svc_2.getSpp().getName(), ac.getName());
          _builder.append(_terImplementation_2, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- lifecycle functions");
      _builder.newLine();
      {
        boolean _overridesStop = this._roomExtensions.overridesStop(ac);
        boolean _not_2 = (!_overridesStop);
        if (_not_2) {
          {
            if (manualBehavior) {
              _builder.append("\t");
              _builder.append("public abstract void stop();");
              _builder.newLine();
            } else {
              _builder.append("\t");
              _builder.append("public void stop(){");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super.stop();");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        if (manualBehavior) {
          _builder.append("\t");
          _builder.append("public abstract void destroy();");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("public void destroy(){");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          String _userStructorBody_1 = this._procedureHelpers.userStructorBody(ac, false);
          _builder.append(_userStructorBody_1, "\t\t");
          _builder.newLineIfNotEmpty();
          {
            boolean _isGenerateMSCInstrumentation_2 = Main.getSettings().isGenerateMSCInstrumentation();
            if (_isGenerateMSCInstrumentation_2) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this);");
              _builder.newLine();
            }
          }
          {
            if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(getThread()).removePollingMessageReceiver(this);");
              _builder.newLine();
            }
          }
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
      {
        if (manualBehavior) {
          _builder.append("\t");
          _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {");
          _builder.newLine();
          {
            List<InterfaceItem> _allInterfaceItems = this._roomHelpers.getAllInterfaceItems(ac);
            boolean _hasElements = false;
            for(final InterfaceItem ifitem : _allInterfaceItems) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate("else ", "\t\t");
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("if (ifitem==");
              String _name_28 = ifitem.getName();
              _builder.append(_name_28, "\t\t");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("switch (evt) {");
              _builder.newLine();
              {
                List<Message> _incoming = this._roomHelpers.getIncoming(ifitem);
                for(final Message msg : _incoming) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("case ");
                  String _name_29 = this._roomHelpers.getProtocolClass(msg).getName();
                  _builder.append(_name_29, "\t\t\t\t");
                  _builder.append(".");
                  String _xifexpression_6 = null;
                  boolean _isIncoming = this._roomExtensions.isIncoming(msg);
                  if (_isIncoming) {
                    _xifexpression_6 = "IN_";
                  } else {
                    _xifexpression_6 = "OUT_";
                  }
                  _builder.append(_xifexpression_6, "\t\t\t\t");
                  String _name_30 = msg.getName();
                  _builder.append(_name_30, "\t\t\t\t");
                  _builder.append(":");
                  _builder.newLineIfNotEmpty();
                  {
                    VarDecl _data = msg.getData();
                    boolean _notEquals_3 = (!Objects.equal(_data, null));
                    if (_notEquals_3) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("{");
                      String _typedDataDefinition = this._javaExtensions.getTypedDataDefinition(msg);
                      _builder.append(_typedDataDefinition, "\t\t\t\t\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("on_");
                  String _name_31 = ifitem.getName();
                  _builder.append(_name_31, "\t\t\t\t\t");
                  _builder.append("_");
                  String _name_32 = msg.getName();
                  _builder.append(_name_32, "\t\t\t\t\t");
                  _builder.append("(ifitem");
                  {
                    VarDecl _data_1 = msg.getData();
                    boolean _notEquals_4 = (!Objects.equal(_data_1, null));
                    if (_notEquals_4) {
                      _builder.append(", ");
                      String _name_33 = msg.getData().getName();
                      _builder.append(_name_33, "\t\t\t\t\t");
                    }
                  }
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("break;");
                  _builder.newLine();
                  {
                    VarDecl _data_2 = msg.getData();
                    boolean _notEquals_5 = (!Objects.equal(_data_2, null));
                    if (_notEquals_5) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          {
            List<InterfaceItem> _allInterfaceItems_1 = this._roomHelpers.getAllInterfaceItems(ac);
            for(final InterfaceItem ifitem_1 : _allInterfaceItems_1) {
              {
                List<Message> _incoming_1 = this._roomHelpers.getIncoming(ifitem_1);
                for(final Message msg_1 : _incoming_1) {
                  _builder.append("\t");
                  _builder.append("protected void on_");
                  String _name_34 = ifitem_1.getName();
                  _builder.append(_name_34, "\t");
                  _builder.append("_");
                  String _name_35 = msg_1.getName();
                  _builder.append(_name_35, "\t");
                  _builder.append("(InterfaceItemBase ifitem");
                  {
                    VarDecl _data_3 = msg_1.getData();
                    boolean _notEquals_6 = (!Objects.equal(_data_3, null));
                    if (_notEquals_6) {
                      String _get = this._javaExtensions.generateArglistAndTypedData(msg_1.getData())[2];
                      _builder.append(_get, "\t");
                    }
                  }
                  _builder.append(") {}");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public abstract void executeInitTransition();");
          _builder.newLine();
        } else {
          {
            boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine) {
              _builder.append("\t");
              CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac.getGraphContainer());
              _builder.append(_genStateMachine, "\t");
              _builder.newLineIfNotEmpty();
              {
                ComponentCommunicationType _commType = ac.getCommType();
                boolean _equals_1 = Objects.equal(_commType, ComponentCommunicationType.DATA_DRIVEN);
                if (_equals_1) {
                  _builder.append("\t");
                  _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("handleSystemEvent(ifitem, evt, generic_data);");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              {
                if ((Objects.equal(ac.getCommType(), ComponentCommunicationType.ASYNCHRONOUS) || Objects.equal(ac.getCommType(), ComponentCommunicationType.DATA_DRIVEN))) {
                  _builder.append("\t");
                  _builder.append("@Override");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("public void receive(Message msg) {");
                  _builder.newLine();
                  {
                    ComponentCommunicationType _commType_1 = ac.getCommType();
                    boolean _equals_2 = Objects.equal(_commType_1, ComponentCommunicationType.ASYNCHRONOUS);
                    if (_equals_2) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("receiveEvent(null, -1, null);");
                      _builder.newLine();
                    } else {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("receiveEventInternal();");
                      _builder.newLine();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            } else {
              boolean _isEmpty_2 = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
              if (_isEmpty_2) {
                _builder.append("\t");
                _builder.append("//--------------------- no state machine");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("handleSystemEvent(ifitem, evt, data);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void executeInitTransition() {}");
                _builder.newLine();
              }
            }
          }
        }
      }
      _builder.newLine();
      {
        boolean _isGeneratePersistenceInterface_2 = Main.getSettings().isGeneratePersistenceInterface();
        if (_isGeneratePersistenceInterface_2) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void saveObject(ObjectOutput output) throws IOException {");
          _builder.newLine();
          {
            boolean _isEmpty_3 = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
            boolean _not_3 = (!_isEmpty_3);
            if (_not_3) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("// state and history");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("output.writeInt(getState());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (int h: history) output.writeInt(h);");
              _builder.newLine();
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("saveAttributes(output);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void saveAttributes(ObjectOutput output) throws IOException {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genSaveImpl = this.genSaveImpl(xpac);
          _builder.append(_genSaveImpl, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {");
          _builder.newLine();
          {
            boolean _isEmpty_4 = FsmGenExtensions.isEmpty(xpac.getGraphContainer().getGraph());
            boolean _not_4 = (!_isEmpty_4);
            if (_not_4) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("// state and history");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("setState(input.readInt());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("for (int i=0; i<history.length; ++i) history[i] = input.readInt();");
              _builder.newLine();
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("loadAttributes(input);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genLoadImpl = this.genLoadImpl(xpac);
          _builder.append(_genLoadImpl, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        boolean _isGenerateStoreDataObj_2 = Main.getSettings().isGenerateStoreDataObj();
        if (_isGenerateStoreDataObj_2) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void store(IActorClassDataObject obj) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (!(obj instanceof ");
          _builder.append(dataObjClass, "\t\t");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(dataObjClass, "\t\t");
          _builder.append(" dataObject = (");
          _builder.append(dataObjClass, "\t\t");
          _builder.append(") obj;");
          _builder.newLineIfNotEmpty();
          {
            ActorClass _actorBase_1 = ac.getActorBase();
            boolean _notEquals_7 = (!Objects.equal(_actorBase_1, null));
            if (_notEquals_7) {
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super.store(dataObject);");
              _builder.newLine();
            }
          }
          {
            boolean _hasNonEmptyStateMachine_1 = this._roomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine_1) {
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("dataObject.setState(getState());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("dataObject.setHistory(Arrays.copyOf(history, history.length));");
              _builder.newLine();
            }
          }
          {
            boolean _isEmpty_5 = ac.getAttributes().isEmpty();
            boolean _not_5 = (!_isEmpty_5);
            if (_not_5) {
              _builder.newLine();
              {
                EList<Attribute> _attributes_1 = ac.getAttributes();
                for(final Attribute att : _attributes_1) {
                  {
                    boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(att.getType().getType());
                    if (_isEnumerationOrPrimitive) {
                      {
                        int _size = att.getSize();
                        boolean _greaterThan_1 = (_size > 1);
                        if (_greaterThan_1) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _firstUpper = StringExtensions.toFirstUpper(att.getName());
                          _builder.append(_firstUpper, "\t\t");
                          _builder.append("(Arrays.copyOf(");
                          String _name_36 = att.getName();
                          _builder.append(_name_36, "\t\t");
                          _builder.append(", ");
                          String _name_37 = att.getName();
                          _builder.append(_name_37, "\t\t");
                          _builder.append(".length));");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _firstUpper_1 = StringExtensions.toFirstUpper(att.getName());
                          _builder.append(_firstUpper_1, "\t\t");
                          _builder.append("(");
                          String _name_38 = att.getName();
                          _builder.append(_name_38, "\t\t");
                          _builder.append(");");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    } else {
                      {
                        int _size_1 = att.getSize();
                        boolean _greaterThan_2 = (_size_1 > 1);
                        if (_greaterThan_2) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("{");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          String _name_39 = att.getType().getType().getName();
                          _builder.append(_name_39, "\t\t\t");
                          _builder.append("[] arr = Arrays.copyOf(");
                          String _name_40 = att.getName();
                          _builder.append(_name_40, "\t\t\t");
                          _builder.append(", ");
                          String _name_41 = att.getName();
                          _builder.append(_name_41, "\t\t\t");
                          _builder.append(".length);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("for(int i=0; i<arr.length; ++i) arr[i] = arr[i].deepCopy();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _firstUpper_2 = StringExtensions.toFirstUpper(att.getName());
                          _builder.append(_firstUpper_2, "\t\t\t");
                          _builder.append("(arr);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _firstUpper_3 = StringExtensions.toFirstUpper(att.getName());
                          _builder.append(_firstUpper_3, "\t\t");
                          _builder.append("(");
                          String _name_42 = att.getName();
                          _builder.append(_name_42, "\t\t");
                          _builder.append(".deepCopy());");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void restore(IActorClassDataObject obj) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (!(obj instanceof ");
          _builder.append(dataObjClass, "\t\t");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(dataObjClass, "\t\t");
          _builder.append(" dataObject = (");
          _builder.append(dataObjClass, "\t\t");
          _builder.append(") obj;");
          _builder.newLineIfNotEmpty();
          {
            ActorClass _actorBase_2 = ac.getActorBase();
            boolean _notEquals_8 = (!Objects.equal(_actorBase_2, null));
            if (_notEquals_8) {
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super.restore(dataObject);");
              _builder.newLine();
            }
          }
          {
            boolean _hasNonEmptyStateMachine_2 = this._roomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine_2) {
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("setState(dataObject.getState());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("history = Arrays.copyOf(dataObject.getHistory(), dataObject.getHistory().length);");
              _builder.newLine();
            }
          }
          {
            boolean _isEmpty_6 = ac.getAttributes().isEmpty();
            boolean _not_6 = (!_isEmpty_6);
            if (_not_6) {
              _builder.newLine();
              {
                EList<Attribute> _attributes_2 = ac.getAttributes();
                for(final Attribute att_1 : _attributes_2) {
                  {
                    boolean _isEnumerationOrPrimitive_1 = this._typeHelpers.isEnumerationOrPrimitive(att_1.getType().getType());
                    if (_isEnumerationOrPrimitive_1) {
                      {
                        int _size_2 = att_1.getSize();
                        boolean _greaterThan_3 = (_size_2 > 1);
                        if (_greaterThan_3) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _firstUpper_4 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_4, "\t\t");
                          _builder.append("(Arrays.copyOf(dataObject.get");
                          String _firstUpper_5 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_5, "\t\t");
                          _builder.append("(), ");
                          String _name_43 = att_1.getName();
                          _builder.append(_name_43, "\t\t");
                          _builder.append(".length));");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _firstUpper_6 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_6, "\t\t");
                          _builder.append("(dataObject.get");
                          String _firstUpper_7 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_7, "\t\t");
                          _builder.append("());");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    } else {
                      {
                        int _size_3 = att_1.getSize();
                        boolean _greaterThan_4 = (_size_3 > 1);
                        if (_greaterThan_4) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("{");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          String _name_44 = att_1.getType().getType().getName();
                          _builder.append(_name_44, "\t\t\t");
                          _builder.append("[] arr = Arrays.copyOf(dataObject.get");
                          String _firstUpper_8 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_8, "\t\t\t");
                          _builder.append("(), ");
                          String _name_45 = att_1.getName();
                          _builder.append(_name_45, "\t\t\t");
                          _builder.append(".length);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("for(int i=0; i<arr.length; ++i) arr[i] = arr[i].deepCopy();");
                          _builder.newLine();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _firstUpper_9 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_9, "\t\t\t");
                          _builder.append("(arr);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _firstUpper_10 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_10, "\t\t");
                          _builder.append("(dataObject.get");
                          String _firstUpper_11 = StringExtensions.toFirstUpper(att_1.getName());
                          _builder.append(_firstUpper_11, "\t\t");
                          _builder.append("().deepCopy());");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(dataObjClass, "\t");
          _builder.append(" newDataObject() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return new ");
          _builder.append(dataObjClass, "\t\t");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence genSaveImpl(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      {
        ActorClass _actorBase = ac.getActorBase();
        boolean _notEquals = (!Objects.equal(_actorBase, null));
        if (_notEquals) {
          _builder.append("super.saveAttributes(output);");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        boolean _isEmpty = ac.getAttributes().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            EList<Attribute> _attributes = ac.getAttributes();
            for(final Attribute att : _attributes) {
              {
                boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(att.getType().getType());
                if (_isEnumerationOrPrimitive) {
                  String _genSavePrimitive = this.genSavePrimitive(att);
                  _builder.append(_genSavePrimitive);
                  _builder.newLineIfNotEmpty();
                } else {
                  {
                    int _size = att.getSize();
                    boolean _greaterThan = (_size > 1);
                    if (_greaterThan) {
                      _builder.append("for (");
                      String _name = att.getType().getType().getName();
                      _builder.append(_name);
                      _builder.append(" v: ");
                      String _name_1 = att.getName();
                      _builder.append(_name_1);
                      _builder.append(") output.writeObject(v);");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("output.writeObject(");
                      String _name_2 = att.getName();
                      _builder.append(_name_2);
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence genLoadImpl(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      {
        ActorClass _actorBase = ac.getActorBase();
        boolean _notEquals = (!Objects.equal(_actorBase, null));
        if (_notEquals) {
          _builder.append("super.loadAttributes(input);");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        boolean _isEmpty = ac.getAttributes().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            EList<Attribute> _attributes = ac.getAttributes();
            for(final Attribute att : _attributes) {
              {
                boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(att.getType().getType());
                if (_isEnumerationOrPrimitive) {
                  String _genLoadPrimitive = this.genLoadPrimitive(att);
                  _builder.append(_genLoadPrimitive);
                  _builder.newLineIfNotEmpty();
                } else {
                  {
                    int _size = att.getSize();
                    boolean _greaterThan = (_size > 1);
                    if (_greaterThan) {
                      _builder.append("for (int i=0; i< ");
                      String _name = att.getName();
                      _builder.append(_name);
                      _builder.append(".length; ++i) ");
                      String _name_1 = att.getName();
                      _builder.append(_name_1);
                      _builder.append("[i] = (");
                      String _name_2 = att.getType().getType().getName();
                      _builder.append(_name_2);
                      _builder.append(") input.readObject();");
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _name_3 = att.getName();
                      _builder.append(_name_3);
                      _builder.append(" = (");
                      String _name_4 = att.getType().getType().getName();
                      _builder.append(_name_4);
                      _builder.append(") input.readObject();");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String genSavePrimitive(final Attribute att) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if (((att.getType().getType() instanceof EnumerationType) && Objects.equal(((EnumerationType) att.getType().getType()).getPrimitiveType(), null))) {
        _xifexpression = "int";
      } else {
        _xifexpression = this._typeHelpers.typeName(att.getType().getType());
      }
      final String type = _xifexpression;
      final String method = this.getSaveMethod(type);
      String _xifexpression_1 = null;
      int _size = att.getSize();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _name = att.getName();
        String _plus = ((("for (" + type) + " v: ") + _name);
        String _plus_1 = (_plus + ") output.");
        String _plus_2 = (_plus_1 + method);
        _xifexpression_1 = (_plus_2 + "(v);");
      } else {
        String _name_1 = att.getName();
        String _plus_3 = ((("output." + method) + "(") + _name_1);
        _xifexpression_1 = (_plus_3 + ");");
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  private String getSaveMethod(final String type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case "boolean":
          _switchResult = "writeBoolean";
          break;
        case "char":
          _switchResult = "writeChar";
          break;
        case "byte":
          _switchResult = "writeByte";
          break;
        case "short":
          _switchResult = "writeShort";
          break;
        case "int":
          _switchResult = "write";
          break;
        case "long":
          _switchResult = "writeLong";
          break;
        case "float":
          _switchResult = "writeFloat";
          break;
        case "double":
          _switchResult = "writeDouble";
          break;
        case "String":
          _switchResult = "writeUTF";
          break;
      }
    }
    return _switchResult;
  }
  
  private String genLoadPrimitive(final Attribute att) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if (((att.getType().getType() instanceof EnumerationType) && Objects.equal(((EnumerationType) att.getType().getType()).getPrimitiveType(), null))) {
        _xifexpression = "int";
      } else {
        _xifexpression = this._typeHelpers.typeName(att.getType().getType());
      }
      final String type = _xifexpression;
      final String method = this.getLoadMethod(type);
      String _xifexpression_1 = null;
      int _size = att.getSize();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        String _name = att.getName();
        String _plus = ("for (int i=0; i<" + _name);
        String _plus_1 = (_plus + ".length; ++i) ");
        String _name_1 = att.getName();
        String _plus_2 = (_plus_1 + _name_1);
        String _plus_3 = (_plus_2 + "[i] = input.");
        String _plus_4 = (_plus_3 + method);
        _xifexpression_1 = (_plus_4 + "();");
      } else {
        String _name_2 = att.getName();
        String _plus_5 = (_name_2 + " = input.");
        String _plus_6 = (_plus_5 + method);
        _xifexpression_1 = (_plus_6 + "();");
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  private String getLoadMethod(final String type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case "boolean":
          _switchResult = "readBoolean";
          break;
        case "char":
          _switchResult = "readChar";
          break;
        case "byte":
          _switchResult = "readByte";
          break;
        case "short":
          _switchResult = "readShort";
          break;
        case "int":
          _switchResult = "read";
          break;
        case "long":
          _switchResult = "readLong";
          break;
        case "float":
          _switchResult = "readFloat";
          break;
        case "double":
          _switchResult = "readDouble";
          break;
        case "String":
          _switchResult = "readUTF";
          break;
      }
    }
    return _switchResult;
  }
}
