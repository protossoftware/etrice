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
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.FileSystemHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.StateMachineGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private IGeneratorFileIo fileIO;
  
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
  private Initialization _initialization;
  
  @Inject
  @Extension
  private StateMachineGen _stateMachineGen;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private FileSystemHelpers _fileSystemHelpers;
  
  public void doGenerate(final Root root) {
    HashMap<ActorClass,WiredActorClass> _hashMap = new HashMap<ActorClass,WiredActorClass>();
    final HashMap<ActorClass,WiredActorClass> ac2wired = _hashMap;
    EList<WiredStructureClass> _wiredInstances = root.getWiredInstances();
    final Function1<WiredStructureClass,Boolean> _function = new Function1<WiredStructureClass,Boolean>() {
        public Boolean apply(final WiredStructureClass w) {
          return Boolean.valueOf((w instanceof WiredActorClass));
        }
      };
    Iterable<WiredStructureClass> _filter = IterableExtensions.<WiredStructureClass>filter(_wiredInstances, _function);
    final Procedure1<WiredStructureClass> _function_1 = new Procedure1<WiredStructureClass>() {
        public void apply(final WiredStructureClass w) {
          ActorClass _actorClass = ((WiredActorClass) w).getActorClass();
          ac2wired.put(_actorClass, ((WiredActorClass) w));
        }
      };
    IterableExtensions.<WiredStructureClass>forEach(_filter, _function_1);
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    final Function1<ExpandedActorClass,Boolean> _function_2 = new Function1<ExpandedActorClass,Boolean>() {
      public Boolean apply(final ExpandedActorClass cl) {
        ActorClass _actorClass = cl.getActorClass();
        boolean _isValidGenerationLocation = ActorClassGen.this._fileSystemHelpers.isValidGenerationLocation(_actorClass);
        return Boolean.valueOf(_isValidGenerationLocation);
      }
    };
    Iterable<ExpandedActorClass> _filter_1 = IterableExtensions.<ExpandedActorClass>filter(_xpActorClasses, _function_2);
    for (final ExpandedActorClass xpac : _filter_1) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        final WiredActorClass wired = ac2wired.get(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        final boolean manualBehavior = RoomHelpers.isBehaviorAnnotationPresent(_actorClass_1, "BehaviorManual");
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass_2);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_3);
        final String path = (_generationTargetPath + _path);
        ActorClass _actorClass_4 = xpac.getActorClass();
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_actorClass_4);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String _path_1 = this._roomExtensions.getPath(_actorClass_5);
        final String infopath = (_generationInfoPath + _path_1);
        ActorClass _actorClass_6 = xpac.getActorClass();
        String file = this._javaExtensions.getJavaFileName(_actorClass_6);
        if (manualBehavior) {
          String _plus = ("Abstract" + file);
          file = _plus;
        }
        CharSequence _generate = this.generate(root, xpac, wired, manualBehavior);
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, file, _generate);
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
        String _plus = ("Abstract" + _name);
        _xifexpression = _plus;
      } else {
        String _name_1 = ac.getName();
        _xifexpression = _name_1;
      }
      final String clsname = _xifexpression;
      EList<StandardOperation> _operations = ac.getOperations();
      final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isConstructor = RoomHelpers.isConstructor(op);
            return Boolean.valueOf(_isConstructor);
          }
        };
      Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
      final StandardOperation ctor = IterableExtensions.<StandardOperation>head(_filter);
      EList<StandardOperation> _operations_1 = ac.getOperations();
      final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
          public Boolean apply(final StandardOperation op) {
            boolean _isDestructor = op.isDestructor();
            return Boolean.valueOf(_isDestructor);
          }
        };
      Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
      final StandardOperation dtor = IterableExtensions.<StandardOperation>head(_filter_1);
      final EList<RoomModel> models = root.getReferencedModels(ac);
      String _xifexpression_1 = null;
      GlobalSettings _settings = Main.getSettings();
      boolean _isGeneratePersistenceInterface = _settings.isGeneratePersistenceInterface();
      if (_isGeneratePersistenceInterface) {
        _xifexpression_1 = "implements IPersistable ";
      } else {
        _xifexpression_1 = "";
      }
      final String impPersist = _xifexpression_1;
      String _name_2 = ac.getName();
      final String dataObjClass = (_name_2 + "_DataObject");
      String _xifexpression_2 = null;
      ActorClass _base = ac.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        ActorClass _base_1 = ac.getBase();
        String _name_3 = _base_1.getName();
        _xifexpression_2 = _name_3;
      } else {
        String _xifexpression_3 = null;
        String _attribute = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
        boolean _isEmpty = _attribute.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          String _attribute_1 = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
          _xifexpression_3 = _attribute_1;
        } else {
          String _xifexpression_4 = null;
          GlobalSettings _settings_1 = Main.getSettings();
          boolean _isGenerateStoreDataObj = _settings_1.isGenerateStoreDataObj();
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
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
        boolean _isEmpty_1 = _dynConfigReadAttributes.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("import org.eclipse.etrice.runtime.java.config.DynConfigLock;");
          _builder.newLine();
        }
      }
      {
        GlobalSettings _settings_2 = Main.getSettings();
        boolean _isGeneratePersistenceInterface_1 = _settings_2.isGeneratePersistenceInterface();
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
        GlobalSettings _settings_3 = Main.getSettings();
        boolean _isGenerateStoreDataObj_1 = _settings_3.isGenerateStoreDataObj();
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
          String _name_4 = model.getName();
          _builder.append(_name_4, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("import ");
          String _package_1 = this._roomExtensions.getPackage(pc);
          _builder.append(_package_1, "");
          _builder.append(".");
          String _name_5 = pc.getName();
          _builder.append(_name_5, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ActorRef> _actorRefs = ac.getActorRefs();
        final Function1<ActorRef,Boolean> _function_2 = new Function1<ActorRef,Boolean>() {
            public Boolean apply(final ActorRef r) {
              ReferenceType _refType = r.getRefType();
              boolean _equals = Objects.equal(_refType, ReferenceType.OPTIONAL);
              return Boolean.valueOf(_equals);
            }
          };
        Iterable<ActorRef> _filter_2 = IterableExtensions.<ActorRef>filter(_actorRefs, _function_2);
        for(final ActorRef sub : _filter_2) {
          _builder.append("import ");
          ActorClass _type = sub.getType();
          String _package_2 = this._roomExtensions.getPackage(_type);
          _builder.append(_package_2, "");
          _builder.append(".");
          ActorClass _type_1 = sub.getType();
          String _name_6 = _type_1.getName();
          _builder.append(_name_6, "");
          _builder.append("Interface;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1, true);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public ");
      {
        boolean _or = false;
        if (manualBehavior) {
          _or = true;
        } else {
          boolean _isAbstract = ac.isAbstract();
          _or = (manualBehavior || _isAbstract);
        }
        if (_or) {
          _builder.append("abstract ");
        }
      }
      _builder.append("class ");
      _builder.append(clsname, "");
      _builder.append(" extends ");
      _builder.append(baseClass, "");
      _builder.append(" ");
      _builder.append(impPersist, "");
      _builder.append("{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2, false);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- ports");
      _builder.newLine();
      {
        List<Port> _endPorts = RoomHelpers.getEndPorts(ac);
        for(final Port ep : _endPorts) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName = this._roomExtensions.getPortClassName(ep);
          _builder.append(_portClassName, "	");
          _builder.append(" ");
          String _name_7 = ep.getName();
          _builder.append(_name_7, "	");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
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
          _builder.append(_portClassName_1, "	");
          _builder.append(" ");
          String _name_8 = sap.getName();
          _builder.append(_name_8, "	");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
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
          _builder.append(_portClassName_2, "	");
          _builder.append(" ");
          SPP _spp = svc.getSpp();
          String _name_9 = _spp.getName();
          _builder.append(_name_9, "	");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- optional actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_1 = ac.getActorRefs();
        final Function1<ActorRef,Boolean> _function_3 = new Function1<ActorRef,Boolean>() {
            public Boolean apply(final ActorRef r) {
              ReferenceType _refType = r.getRefType();
              boolean _equals = Objects.equal(_refType, ReferenceType.OPTIONAL);
              return Boolean.valueOf(_equals);
            }
          };
        Iterable<ActorRef> _filter_3 = IterableExtensions.<ActorRef>filter(_actorRefs_1, _function_3);
        for(final ActorRef sub_1 : _filter_3) {
          _builder.append("\t");
          _builder.append("protected ");
          ActorClass _type_2 = sub_1.getType();
          String _name_10 = _type_2.getName();
          _builder.append(_name_10, "	");
          {
            int _multiplicity = sub_1.getMultiplicity();
            boolean _notEquals_1 = (_multiplicity != 1);
            if (_notEquals_1) {
              _builder.append("Replicated");
            }
          }
          _builder.append("Interface ");
          String _name_11 = sub_1.getName();
          _builder.append(_name_11, "	");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac);
      _builder.append(_genInterfaceItemConstants, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      String _genMinMaxConstants = this.configGenAddon.genMinMaxConstants(ac);
      _builder.append(_genMinMaxConstants, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
      _builder.append(_attributes_1, "	");
      _builder.newLineIfNotEmpty();
      {
        List<Attribute> _dynConfigReadAttributes_1 = this.dataConfigExt.getDynConfigReadAttributes(ac);
        for(final Attribute a : _dynConfigReadAttributes_1) {
          _builder.append("\t");
          _builder.append("private DynConfigLock lock_");
          String _name_12 = a.getName();
          _builder.append(_name_12, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      CharSequence _operationsImplementation = this._procedureHelpers.operationsImplementation(ac);
      _builder.append(_operationsImplementation, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(clsname, "	");
      _builder.append("(IRTObject parent, String name) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("setClassName(\"");
      String _name_13 = ac.getName();
      _builder.append(_name_13, "		");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      EList<Attribute> _attributes_2 = ac.getAttributes();
      CharSequence _attributeInitialization = this._initialization.attributeInitialization(_attributes_2, ac, false);
      _builder.append(_attributeInitialization, "		");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own ports");
      _builder.newLine();
      {
        List<Port> _endPorts_1 = RoomHelpers.getEndPorts(ac);
        for(final Port ep_1 : _endPorts_1) {
          _builder.append("\t\t");
          String _name_14 = ep_1.getName();
          _builder.append(_name_14, "		");
          _builder.append(" = new ");
          String _portClassName_3 = this._roomExtensions.getPortClassName(ep_1);
          _builder.append(_portClassName_3, "		");
          _builder.append("(this, \"");
          String _name_15 = ep_1.getName();
          _builder.append(_name_15, "		");
          _builder.append("\", IFITEM_");
          String _name_16 = ep_1.getName();
          _builder.append(_name_16, "		");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own saps");
      _builder.newLine();
      {
        EList<SAP> _serviceAccessPoints_1 = ac.getServiceAccessPoints();
        for(final SAP sap_1 : _serviceAccessPoints_1) {
          _builder.append("\t\t");
          String _name_17 = sap_1.getName();
          _builder.append(_name_17, "		");
          _builder.append(" = new ");
          String _portClassName_4 = this._roomExtensions.getPortClassName(sap_1);
          _builder.append(_portClassName_4, "		");
          _builder.append("(this, \"");
          String _name_18 = sap_1.getName();
          _builder.append(_name_18, "		");
          _builder.append("\", IFITEM_");
          String _name_19 = sap_1.getName();
          _builder.append(_name_19, "		");
          _builder.append(", 0);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own service implementations");
      _builder.newLine();
      {
        EList<ServiceImplementation> _serviceImplementations_1 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_1 : _serviceImplementations_1) {
          _builder.append("\t\t");
          SPP _spp_1 = svc_1.getSpp();
          String _name_20 = _spp_1.getName();
          _builder.append(_name_20, "		");
          _builder.append(" = new ");
          String _portClassName_5 = this._roomExtensions.getPortClassName(svc_1);
          _builder.append(_portClassName_5, "		");
          _builder.append("(this, \"");
          SPP _spp_2 = svc_1.getSpp();
          String _name_21 = _spp_2.getName();
          _builder.append(_name_21, "		");
          _builder.append("\", IFITEM_");
          SPP _spp_3 = svc_1.getSpp();
          String _name_22 = _spp_3.getName();
          _builder.append(_name_22, "		");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      {
        EList<ActorRef> _actorRefs_2 = ac.getActorRefs();
        for(final ActorRef sub_2 : _actorRefs_2) {
          {
            ReferenceType _refType = sub_2.getRefType();
            boolean _equals = Objects.equal(_refType, ReferenceType.OPTIONAL);
            if (_equals) {
              _builder.append("\t\t");
              String _name_23 = sub_2.getName();
              _builder.append(_name_23, "		");
              _builder.append(" = new ");
              ActorClass _type_3 = sub_2.getType();
              String _name_24 = _type_3.getName();
              _builder.append(_name_24, "		");
              {
                int _multiplicity_1 = sub_2.getMultiplicity();
                boolean _notEquals_2 = (_multiplicity_1 != 1);
                if (_notEquals_2) {
                  _builder.append("Replicated");
                }
              }
              _builder.append("Interface(this, \"");
              String _name_25 = sub_2.getName();
              _builder.append(_name_25, "		");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            } else {
              int _multiplicity_2 = sub_2.getMultiplicity();
              boolean _greaterThan = (_multiplicity_2 > 1);
              if (_greaterThan) {
                _builder.append("\t\t");
                _builder.append("for (int i=0; i<");
                int _multiplicity_3 = sub_2.getMultiplicity();
                _builder.append(_multiplicity_3, "		");
                _builder.append("; ++i) {");
                _builder.newLineIfNotEmpty();
                {
                  GlobalSettings _settings_4 = Main.getSettings();
                  boolean _generateMSCInstrumentation = _settings_4.generateMSCInstrumentation();
                  if (_generateMSCInstrumentation) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_26 = sub_2.getName();
                    _builder.append(_name_26, "			");
                    _builder.append(GenmodelConstants.INDEX_SEP, "			");
                    _builder.append("\"+i);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("new ");
                ActorClass _type_4 = sub_2.getType();
                String _name_27 = _type_4.getName();
                _builder.append(_name_27, "			");
                _builder.append("(this, \"");
                String _name_28 = sub_2.getName();
                _builder.append(_name_28, "			");
                _builder.append(GenmodelConstants.INDEX_SEP, "			");
                _builder.append("\"+i);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                {
                  GlobalSettings _settings_5 = Main.getSettings();
                  boolean _generateMSCInstrumentation_1 = _settings_5.generateMSCInstrumentation();
                  if (_generateMSCInstrumentation_1) {
                    _builder.append("\t\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_29 = sub_2.getName();
                    _builder.append(_name_29, "		");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("new ");
                ActorClass _type_5 = sub_2.getType();
                String _name_30 = _type_5.getName();
                _builder.append(_name_30, "		");
                _builder.append("(this, \"");
                String _name_31 = sub_2.getName();
                _builder.append(_name_31, "		");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
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
          String _xifexpression_5 = null;
          boolean _isDataDriven = wire.isDataDriven();
          if (_isDataDriven) {
            _xifexpression_5 = "DataPortBase";
          } else {
            _xifexpression_5 = "InterfaceItemBase";
          }
          _builder.append(_xifexpression_5, "		");
          _builder.append(".connect(this, \"");
          EList<String> _path1 = wire.getPath1();
          String _join = IterableExtensions.join(_path1, "/");
          _builder.append(_join, "		");
          _builder.append("\", \"");
          EList<String> _path2 = wire.getPath2();
          String _join_1 = IterableExtensions.join(_path2, "/");
          _builder.append(_join_1, "		");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        boolean _notEquals_3 = (!Objects.equal(ctor, null));
        if (_notEquals_3) {
          _builder.append("\t\t");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("// user defined constructor body");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          AbstractGenerator _instance = AbstractGenerator.getInstance();
          DetailCode _detailCode = ctor.getDetailCode();
          String _translatedCode = _instance.getTranslatedCode(_detailCode);
          _builder.append(_translatedCode, "			");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _or_1 = false;
        List<Attribute> _dynConfigReadAttributes_2 = this.dataConfigExt.getDynConfigReadAttributes(ac);
        boolean _isEmpty_2 = _dynConfigReadAttributes_2.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _or_1 = true;
        } else {
          List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
          boolean _isEmpty_3 = _dynConfigWriteAttributes.isEmpty();
          boolean _not_3 = (!_isEmpty_3);
          _or_1 = (_not_2 || _not_3);
        }
        if (_or_1) {
          {
            List<Attribute> _dynConfigReadAttributes_3 = this.dataConfigExt.getDynConfigReadAttributes(ac);
            for(final Attribute a_1 : _dynConfigReadAttributes_3) {
              _builder.append("\t\t");
              _builder.append("lock_");
              String _name_32 = a_1.getName();
              _builder.append(_name_32, "		");
              _builder.append(" = new DynConfigLock();");
              _builder.newLineIfNotEmpty();
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
      EList<Attribute> _attributes_3 = ac.getAttributes();
      List<Attribute> _dynConfigReadAttributes_4 = this.dataConfigExt.getDynConfigReadAttributes(ac);
      List<Attribute> _minus = this._roomExtensions.<Attribute>minus(_attributes_3, _dynConfigReadAttributes_4);
      String _name_33 = ac.getName();
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_minus, _name_33);
      _builder.append(_attributeSettersGettersImplementation, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genDynConfigGetterSetter = this.configGenAddon.genDynConfigGetterSetter(ac);
      _builder.append(_genDynConfigGetterSetter, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- port getters");
      _builder.newLine();
      {
        List<Port> _endPorts_2 = RoomHelpers.getEndPorts(ac);
        for(final Port ep_2 : _endPorts_2) {
          _builder.append("\t");
          String _portClassName_6 = this._roomExtensions.getPortClassName(ep_2);
          String _name_34 = ep_2.getName();
          String _name_35 = ac.getName();
          CharSequence _terImplementation = this._procedureHelpers.getterImplementation(_portClassName_6, _name_34, _name_35);
          _builder.append(_terImplementation, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<SAP> _serviceAccessPoints_2 = ac.getServiceAccessPoints();
        for(final SAP sap_2 : _serviceAccessPoints_2) {
          _builder.append("\t");
          String _portClassName_7 = this._roomExtensions.getPortClassName(sap_2);
          String _name_36 = sap_2.getName();
          String _name_37 = ac.getName();
          CharSequence _terImplementation_1 = this._procedureHelpers.getterImplementation(_portClassName_7, _name_36, _name_37);
          _builder.append(_terImplementation_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ServiceImplementation> _serviceImplementations_2 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_2 : _serviceImplementations_2) {
          _builder.append("\t");
          String _portClassName_8 = this._roomExtensions.getPortClassName(svc_2);
          SPP _spp_4 = svc_2.getSpp();
          String _name_38 = _spp_4.getName();
          String _name_39 = ac.getName();
          CharSequence _terImplementation_2 = this._procedureHelpers.getterImplementation(_portClassName_8, _name_38, _name_39);
          _builder.append(_terImplementation_2, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- lifecycle functions");
      _builder.newLine();
      {
        boolean _overridesStop = this._roomExtensions.overridesStop(ac);
        boolean _not_4 = (!_overridesStop);
        if (_not_4) {
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
              _builder.append("stopUser();");
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
      _builder.append("\t");
      _builder.newLine();
      {
        boolean _notEquals_4 = (!Objects.equal(dtor, null));
        if (_notEquals_4) {
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
              String _name_40 = ac.getName();
              String _destructorCall = this._procedureHelpers.destructorCall(_name_40);
              _builder.append(_destructorCall, "		");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              {
                GlobalSettings _settings_6 = Main.getSettings();
                boolean _generateMSCInstrumentation_2 = _settings_6.generateMSCInstrumentation();
                if (_generateMSCInstrumentation_2) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this);");
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
        } else {
          GlobalSettings _settings_7 = Main.getSettings();
          boolean _generateMSCInstrumentation_3 = _settings_7.generateMSCInstrumentation();
          if (_generateMSCInstrumentation_3) {
            _builder.append("\t");
            _builder.append("public void destroy() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this);");
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
      }
      _builder.newLine();
      {
        if (manualBehavior) {
          _builder.append("\t");
          _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {");
          _builder.newLine();
          {
            List<InterfaceItem> _allInterfaceItems = RoomHelpers.getAllInterfaceItems(ac);
            boolean _hasElements = false;
            for(final InterfaceItem ifitem : _allInterfaceItems) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate("else ", "		");
              }
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("if (ifitem==");
              String _name_41 = ifitem.getName();
              _builder.append(_name_41, "		");
              _builder.append(") {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("switch (evt) {");
              _builder.newLine();
              {
                List<Message> _incoming = RoomHelpers.getIncoming(ifitem);
                for(final Message msg : _incoming) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("case ");
                  ProtocolClass _protocolClass = RoomHelpers.getProtocolClass(msg);
                  String _name_42 = _protocolClass.getName();
                  _builder.append(_name_42, "				");
                  _builder.append(".");
                  String _xifexpression_6 = null;
                  boolean _isIncoming = this._roomExtensions.isIncoming(msg);
                  if (_isIncoming) {
                    _xifexpression_6 = "IN_";
                  } else {
                    _xifexpression_6 = "OUT_";
                  }
                  _builder.append(_xifexpression_6, "				");
                  String _name_43 = msg.getName();
                  _builder.append(_name_43, "				");
                  _builder.append(":");
                  _builder.newLineIfNotEmpty();
                  {
                    VarDecl _data = msg.getData();
                    boolean _notEquals_5 = (!Objects.equal(_data, null));
                    if (_notEquals_5) {
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("{");
                      String _typedDataDefinition = this._javaExtensions.getTypedDataDefinition(msg);
                      _builder.append(_typedDataDefinition, "					");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("on_");
                  String _name_44 = ifitem.getName();
                  _builder.append(_name_44, "					");
                  _builder.append("_");
                  String _name_45 = msg.getName();
                  _builder.append(_name_45, "					");
                  _builder.append("(ifitem");
                  {
                    VarDecl _data_1 = msg.getData();
                    boolean _notEquals_6 = (!Objects.equal(_data_1, null));
                    if (_notEquals_6) {
                      _builder.append(", ");
                      VarDecl _data_2 = msg.getData();
                      String _name_46 = _data_2.getName();
                      _builder.append(_name_46, "					");
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
                    VarDecl _data_3 = msg.getData();
                    boolean _notEquals_7 = (!Objects.equal(_data_3, null));
                    if (_notEquals_7) {
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
            List<InterfaceItem> _allInterfaceItems_1 = RoomHelpers.getAllInterfaceItems(ac);
            for(final InterfaceItem ifitem_1 : _allInterfaceItems_1) {
              {
                List<Message> _incoming_1 = RoomHelpers.getIncoming(ifitem_1);
                for(final Message msg_1 : _incoming_1) {
                  _builder.append("\t");
                  _builder.append("protected void on_");
                  String _name_47 = ifitem_1.getName();
                  _builder.append(_name_47, "	");
                  _builder.append("_");
                  String _name_48 = msg_1.getName();
                  _builder.append(_name_48, "	");
                  _builder.append("(InterfaceItemBase ifitem");
                  {
                    VarDecl _data_4 = msg_1.getData();
                    boolean _notEquals_8 = (!Objects.equal(_data_4, null));
                    if (_notEquals_8) {
                      VarDecl _data_5 = msg_1.getData();
                      String[] _generateArglistAndTypedData = this._javaExtensions.generateArglistAndTypedData(_data_5);
                      String _get = _generateArglistAndTypedData[2];
                      _builder.append(_get, "	");
                    }
                  }
                  _builder.append(") {}");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public abstract void executeInitTransition();");
          _builder.newLine();
        } else {
          {
            boolean _hasNonEmptyStateMachine = RoomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine) {
              _builder.append("\t");
              CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac);
              _builder.append(_genStateMachine, "	");
              _builder.newLineIfNotEmpty();
            } else {
              StateGraph _stateMachine = xpac.getStateMachine();
              boolean _isEmpty_4 = RoomHelpers.isEmpty(_stateMachine);
              if (_isEmpty_4) {
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
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void executeInitTransition() {}");
                _builder.newLine();
              }
            }
          }
        }
      }
      {
        GlobalSettings _settings_8 = Main.getSettings();
        boolean _isGeneratePersistenceInterface_2 = _settings_8.isGeneratePersistenceInterface();
        if (_isGeneratePersistenceInterface_2) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void saveObject(ObjectOutput output) throws IOException {");
          _builder.newLine();
          {
            boolean _hasStateMachine = xpac.hasStateMachine();
            if (_hasStateMachine) {
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
              _builder.append("\t");
              _builder.append("\t");
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void saveAttributes(ObjectOutput output) throws IOException {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genSaveImpl = this.genSaveImpl(xpac);
          _builder.append(_genSaveImpl, "		");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {");
          _builder.newLine();
          {
            boolean _hasStateMachine_1 = xpac.hasStateMachine();
            if (_hasStateMachine_1) {
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
              _builder.append("\t");
              _builder.append("\t");
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _genLoadImpl = this.genLoadImpl(xpac);
          _builder.append(_genLoadImpl, "		");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      {
        GlobalSettings _settings_9 = Main.getSettings();
        boolean _isGenerateStoreDataObj_2 = _settings_9.isGenerateStoreDataObj();
        if (_isGenerateStoreDataObj_2) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void store(IActorClassDataObject obj) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (!(obj instanceof ");
          _builder.append(dataObjClass, "		");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(dataObjClass, "		");
          _builder.append(" dataObject = (");
          _builder.append(dataObjClass, "		");
          _builder.append(") obj;");
          _builder.newLineIfNotEmpty();
          {
            ActorClass _base_2 = ac.getBase();
            boolean _notEquals_9 = (!Objects.equal(_base_2, null));
            if (_notEquals_9) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super.store(dataObject);");
              _builder.newLine();
            }
          }
          {
            boolean _hasNonEmptyStateMachine_1 = RoomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine_1) {
              _builder.append("\t");
              _builder.append("\t");
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
            EList<Attribute> _attributes_4 = ac.getAttributes();
            boolean _isEmpty_5 = _attributes_4.isEmpty();
            boolean _not_5 = (!_isEmpty_5);
            if (_not_5) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.newLine();
              {
                EList<Attribute> _attributes_5 = ac.getAttributes();
                for(final Attribute att : _attributes_5) {
                  {
                    RefableType _type_6 = att.getType();
                    DataType _type_7 = _type_6.getType();
                    boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(_type_7);
                    if (_isEnumerationOrPrimitive) {
                      {
                        int _size = att.getSize();
                        boolean _greaterThan_1 = (_size > 1);
                        if (_greaterThan_1) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _name_49 = att.getName();
                          String _firstUpper = StringExtensions.toFirstUpper(_name_49);
                          _builder.append(_firstUpper, "		");
                          _builder.append("(Arrays.copyOf(");
                          String _name_50 = att.getName();
                          _builder.append(_name_50, "		");
                          _builder.append(", ");
                          String _name_51 = att.getName();
                          _builder.append(_name_51, "		");
                          _builder.append(".length));");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("dataObject.set");
                          String _name_52 = att.getName();
                          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_52);
                          _builder.append(_firstUpper_1, "		");
                          _builder.append("(");
                          String _name_53 = att.getName();
                          _builder.append(_name_53, "		");
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
                          RefableType _type_8 = att.getType();
                          DataType _type_9 = _type_8.getType();
                          String _name_54 = _type_9.getName();
                          _builder.append(_name_54, "			");
                          _builder.append("[] arr = Arrays.copyOf(");
                          String _name_55 = att.getName();
                          _builder.append(_name_55, "			");
                          _builder.append(", ");
                          String _name_56 = att.getName();
                          _builder.append(_name_56, "			");
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
                          String _name_57 = att.getName();
                          String _firstUpper_2 = StringExtensions.toFirstUpper(_name_57);
                          _builder.append(_firstUpper_2, "			");
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
                          String _name_58 = att.getName();
                          String _firstUpper_3 = StringExtensions.toFirstUpper(_name_58);
                          _builder.append(_firstUpper_3, "		");
                          _builder.append("(");
                          String _name_59 = att.getName();
                          _builder.append(_name_59, "		");
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void restore(IActorClassDataObject obj) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (!(obj instanceof ");
          _builder.append(dataObjClass, "		");
          _builder.append("))");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("return;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(dataObjClass, "		");
          _builder.append(" dataObject = (");
          _builder.append(dataObjClass, "		");
          _builder.append(") obj;");
          _builder.newLineIfNotEmpty();
          {
            ActorClass _base_3 = ac.getBase();
            boolean _notEquals_10 = (!Objects.equal(_base_3, null));
            if (_notEquals_10) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super.restore(dataObject);");
              _builder.newLine();
            }
          }
          {
            boolean _hasNonEmptyStateMachine_2 = RoomHelpers.hasNonEmptyStateMachine(ac);
            if (_hasNonEmptyStateMachine_2) {
              _builder.append("\t");
              _builder.append("\t");
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
            EList<Attribute> _attributes_6 = ac.getAttributes();
            boolean _isEmpty_6 = _attributes_6.isEmpty();
            boolean _not_6 = (!_isEmpty_6);
            if (_not_6) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.newLine();
              {
                EList<Attribute> _attributes_7 = ac.getAttributes();
                for(final Attribute att_1 : _attributes_7) {
                  {
                    RefableType _type_10 = att_1.getType();
                    DataType _type_11 = _type_10.getType();
                    boolean _isEnumerationOrPrimitive_1 = this._typeHelpers.isEnumerationOrPrimitive(_type_11);
                    if (_isEnumerationOrPrimitive_1) {
                      {
                        int _size_2 = att_1.getSize();
                        boolean _greaterThan_3 = (_size_2 > 1);
                        if (_greaterThan_3) {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _name_60 = att_1.getName();
                          String _firstUpper_4 = StringExtensions.toFirstUpper(_name_60);
                          _builder.append(_firstUpper_4, "		");
                          _builder.append("(Arrays.copyOf(dataObject.get");
                          String _name_61 = att_1.getName();
                          String _firstUpper_5 = StringExtensions.toFirstUpper(_name_61);
                          _builder.append(_firstUpper_5, "		");
                          _builder.append("(), ");
                          String _name_62 = att_1.getName();
                          _builder.append(_name_62, "		");
                          _builder.append(".length));");
                          _builder.newLineIfNotEmpty();
                        } else {
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("set");
                          String _name_63 = att_1.getName();
                          String _firstUpper_6 = StringExtensions.toFirstUpper(_name_63);
                          _builder.append(_firstUpper_6, "		");
                          _builder.append("(dataObject.get");
                          String _name_64 = att_1.getName();
                          String _firstUpper_7 = StringExtensions.toFirstUpper(_name_64);
                          _builder.append(_firstUpper_7, "		");
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
                          RefableType _type_12 = att_1.getType();
                          DataType _type_13 = _type_12.getType();
                          String _name_65 = _type_13.getName();
                          _builder.append(_name_65, "			");
                          _builder.append("[] arr = Arrays.copyOf(dataObject.get");
                          String _name_66 = att_1.getName();
                          String _firstUpper_8 = StringExtensions.toFirstUpper(_name_66);
                          _builder.append(_firstUpper_8, "			");
                          _builder.append("(), ");
                          String _name_67 = att_1.getName();
                          _builder.append(_name_67, "			");
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
                          String _name_68 = att_1.getName();
                          String _firstUpper_9 = StringExtensions.toFirstUpper(_name_68);
                          _builder.append(_firstUpper_9, "			");
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
                          String _name_69 = att_1.getName();
                          String _firstUpper_10 = StringExtensions.toFirstUpper(_name_69);
                          _builder.append(_firstUpper_10, "		");
                          _builder.append("(dataObject.get");
                          String _name_70 = att_1.getName();
                          String _firstUpper_11 = StringExtensions.toFirstUpper(_name_70);
                          _builder.append(_firstUpper_11, "		");
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
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(dataObjClass, "	");
          _builder.append(" newDataObject() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return new ");
          _builder.append(dataObjClass, "		");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genSaveImpl(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      {
        ActorClass _base = ac.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          _builder.append("super.saveAttributes(output);");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        EList<Attribute> _attributes = ac.getAttributes();
        boolean _isEmpty = _attributes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            EList<Attribute> _attributes_1 = ac.getAttributes();
            for(final Attribute att : _attributes_1) {
              {
                RefableType _type = att.getType();
                DataType _type_1 = _type.getType();
                boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(_type_1);
                if (_isEnumerationOrPrimitive) {
                  String _genSavePrimitive = this.genSavePrimitive(att);
                  _builder.append(_genSavePrimitive, "");
                  _builder.newLineIfNotEmpty();
                } else {
                  {
                    int _size = att.getSize();
                    boolean _greaterThan = (_size > 1);
                    if (_greaterThan) {
                      _builder.append("for (");
                      RefableType _type_2 = att.getType();
                      DataType _type_3 = _type_2.getType();
                      String _name = _type_3.getName();
                      _builder.append(_name, "");
                      _builder.append(" v: ");
                      String _name_1 = att.getName();
                      _builder.append(_name_1, "");
                      _builder.append(") output.writeObject(v);");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("output.writeObject(");
                      String _name_2 = att.getName();
                      _builder.append(_name_2, "");
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
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genLoadImpl(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      {
        ActorClass _base = ac.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          _builder.append("super.loadAttributes(input);");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        EList<Attribute> _attributes = ac.getAttributes();
        boolean _isEmpty = _attributes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            EList<Attribute> _attributes_1 = ac.getAttributes();
            for(final Attribute att : _attributes_1) {
              {
                RefableType _type = att.getType();
                DataType _type_1 = _type.getType();
                boolean _isEnumerationOrPrimitive = this._typeHelpers.isEnumerationOrPrimitive(_type_1);
                if (_isEnumerationOrPrimitive) {
                  String _genLoadPrimitive = this.genLoadPrimitive(att);
                  _builder.append(_genLoadPrimitive, "");
                  _builder.newLineIfNotEmpty();
                } else {
                  {
                    int _size = att.getSize();
                    boolean _greaterThan = (_size > 1);
                    if (_greaterThan) {
                      _builder.append("for (int i=0; i< ");
                      String _name = att.getName();
                      _builder.append(_name, "");
                      _builder.append(".length; ++i) ");
                      String _name_1 = att.getName();
                      _builder.append(_name_1, "");
                      _builder.append("[i] = (");
                      RefableType _type_2 = att.getType();
                      DataType _type_3 = _type_2.getType();
                      String _name_2 = _type_3.getName();
                      _builder.append(_name_2, "");
                      _builder.append(") input.readObject();");
                      _builder.newLineIfNotEmpty();
                    } else {
                      String _name_3 = att.getName();
                      _builder.append(_name_3, "");
                      _builder.append(" = (");
                      RefableType _type_4 = att.getType();
                      DataType _type_5 = _type_4.getType();
                      String _name_4 = _type_5.getName();
                      _builder.append(_name_4, "");
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
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String genSavePrimitive(final Attribute att) {
    String _xblockexpression = null;
    {
      RefableType _type = att.getType();
      DataType _type_1 = _type.getType();
      final String type = this._typeHelpers.typeName(_type_1);
      final String method = this.getSaveMethod(type);
      String _xifexpression = null;
      int _size = att.getSize();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        String _plus = ("for (" + type);
        String _plus_1 = (_plus + " v: ");
        String _name = att.getName();
        String _plus_2 = (_plus_1 + _name);
        String _plus_3 = (_plus_2 + ") output.");
        String _plus_4 = (_plus_3 + method);
        String _plus_5 = (_plus_4 + "(v);");
        _xifexpression = _plus_5;
      } else {
        String _plus_6 = ("output." + method);
        String _plus_7 = (_plus_6 + "(");
        String _name_1 = att.getName();
        String _plus_8 = (_plus_7 + _name_1);
        String _plus_9 = (_plus_8 + ");");
        _xifexpression = _plus_9;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String getSaveMethod(final String type) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type,"boolean")) {
        _matched=true;
        _switchResult = "writeBoolean";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"char")) {
        _matched=true;
        _switchResult = "writeChar";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"byte")) {
        _matched=true;
        _switchResult = "writeByte";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"short")) {
        _matched=true;
        _switchResult = "writeShort";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"int")) {
        _matched=true;
        _switchResult = "write";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"long")) {
        _matched=true;
        _switchResult = "writeLong";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"float")) {
        _matched=true;
        _switchResult = "writeFloat";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"double")) {
        _matched=true;
        _switchResult = "writeDouble";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"String")) {
        _matched=true;
        _switchResult = "writeUTF";
      }
    }
    return _switchResult;
  }
  
  private String genLoadPrimitive(final Attribute att) {
    String _xblockexpression = null;
    {
      RefableType _type = att.getType();
      DataType _type_1 = _type.getType();
      final String type = this._typeHelpers.typeName(_type_1);
      final String method = this.getLoadMethod(type);
      String _xifexpression = null;
      int _size = att.getSize();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        String _name = att.getName();
        String _plus = ("for (int i=0; i<" + _name);
        String _plus_1 = (_plus + ".length; ++i) ");
        String _name_1 = att.getName();
        String _plus_2 = (_plus_1 + _name_1);
        String _plus_3 = (_plus_2 + "[i] = input.");
        String _plus_4 = (_plus_3 + method);
        String _plus_5 = (_plus_4 + "();");
        _xifexpression = _plus_5;
      } else {
        String _name_2 = att.getName();
        String _plus_6 = (_name_2 + " = input.");
        String _plus_7 = (_plus_6 + method);
        String _plus_8 = (_plus_7 + "();");
        _xifexpression = _plus_8;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private String getLoadMethod(final String type) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type,"boolean")) {
        _matched=true;
        _switchResult = "readBoolean";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"char")) {
        _matched=true;
        _switchResult = "readChar";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"byte")) {
        _matched=true;
        _switchResult = "readByte";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"short")) {
        _matched=true;
        _switchResult = "readShort";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"int")) {
        _matched=true;
        _switchResult = "read";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"long")) {
        _matched=true;
        _switchResult = "readLong";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"float")) {
        _matched=true;
        _switchResult = "readFloat";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"double")) {
        _matched=true;
        _switchResult = "readDouble";
      }
    }
    if (!_matched) {
      if (Objects.equal(type,"String")) {
        _matched=true;
        _switchResult = "readUTF";
      }
    }
    return _switchResult;
  }
}
