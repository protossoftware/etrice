package org.eclipse.etrice.generator.java.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.StateMachineGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class ActorClassGen extends GenericActorClassGenerator {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions _javaExtensions;
  
  @Inject
  private RoomExtensions _roomExtensions;
  
  @Inject
  private IDataConfiguration dataConfigExt;
  
  @Inject
  private ConfigGenAddon configGenAddon;
  
  @Inject
  private ProcedureHelpers _procedureHelpers;
  
  @Inject
  private Initialization _initialization;
  
  @Inject
  private StateMachineGen _stateMachineGen;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass);
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_1);
        String path = (_generationTargetPath + _path);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String file = this._javaExtensions.getJavaFileName(_actorClass_2);
        String _plus = ("generating ActorClass implementation \'" + file);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        CharSequence _generate = this.generate(root, xpac, _actorClass_3);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final ExpandedActorClass xpac, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
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
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _package = this._roomExtensions.getPackage(ac);
      _builder.append(_package, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        List<Attribute> _dynConfigReadAttributes = this.dataConfigExt.getDynConfigReadAttributes(ac);
        boolean _isEmpty = _dynConfigReadAttributes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("import org.eclipse.etrice.runtime.java.config.DynConfigLock;");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        boolean _or = false;
        List<Attribute> _dynConfigReadAttributes_1 = this.dataConfigExt.getDynConfigReadAttributes(ac);
        boolean _isEmpty_1 = _dynConfigReadAttributes_1.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _or = true;
        } else {
          List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
          boolean _isEmpty_2 = _dynConfigWriteAttributes.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          _or = (_not_1 || _not_2);
        }
        if (_or) {
          _builder.append("import org.eclipse.etrice.runtime.java.config.VariableService;");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
      _builder.newLine();
      _builder.newLine();
      {
        EList<RoomModel> _referencedModels = root.getReferencedModels(ac);
        for(final RoomModel model : _referencedModels) {
          _builder.append("import ");
          String _name = model.getName();
          _builder.append(_name, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ac);
        for(final ProtocolClass pc : _referencedProtocolClasses) {
          _builder.append("import ");
          String _package_1 = this._roomExtensions.getPackage(pc);
          _builder.append(_package_1, "");
          _builder.append(".");
          String _name_1 = pc.getName();
          _builder.append(_name_1, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      CharSequence _userCode = this._procedureHelpers.userCode(ac, 1);
      _builder.append(_userCode, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public ");
      {
        boolean _isAbstract = ac.isAbstract();
        if (_isAbstract) {
          _builder.append("abstract ");
        }
      }
      _builder.append("class ");
      String _name_2 = ac.getName();
      _builder.append(_name_2, "");
      _builder.append(" extends ");
      {
        ActorClass _base = ac.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          ActorClass _base_1 = ac.getBase();
          String _name_3 = _base_1.getName();
          _builder.append(_name_3, "");
        } else {
          _builder.append("ActorClassBase");
        }
      }
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _userCode_1 = this._procedureHelpers.userCode(ac, 2);
      _builder.append(_userCode_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        List<Attribute> _dynConfigWriteAttributes_1 = this.dataConfigExt.getDynConfigWriteAttributes(ac);
        boolean _isEmpty_3 = _dynConfigWriteAttributes_1.isEmpty();
        boolean _not_3 = (!_isEmpty_3);
        if (_not_3) {
          _builder.append("\t");
          _builder.append("private VariableService variableService;");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- ports");
      _builder.newLine();
      {
        List<Port> _endPorts = this._roomExtensions.getEndPorts(ac);
        for(final Port ep : _endPorts) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName = this._roomExtensions.getPortClassName(ep);
          _builder.append(_portClassName, "	");
          _builder.append(" ");
          String _name_4 = ep.getName();
          _builder.append(_name_4, "	");
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
        EList<SAPRef> _strSAPs = ac.getStrSAPs();
        for(final SAPRef sap : _strSAPs) {
          _builder.append("\t");
          _builder.append("protected ");
          String _portClassName_1 = this._roomExtensions.getPortClassName(sap);
          _builder.append(_portClassName_1, "	");
          _builder.append(" ");
          String _name_5 = sap.getName();
          _builder.append(_name_5, "	");
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
          SPPRef _spp = svc.getSpp();
          String _name_6 = _spp.getName();
          _builder.append(_name_6, "	");
          _builder.append(" = null;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      String _genInterfaceItemConstants = this.genInterfaceItemConstants(xpac, ac);
      _builder.append(_genInterfaceItemConstants, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      CharSequence _genMinMaxConstants = this.configGenAddon.genMinMaxConstants(ac);
      _builder.append(_genMinMaxConstants, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      EList<Attribute> _attributes = ac.getAttributes();
      CharSequence _attributes_1 = this._procedureHelpers.attributes(_attributes);
      _builder.append(_attributes_1, "	");
      _builder.newLineIfNotEmpty();
      {
        List<Attribute> _dynConfigReadAttributes_2 = this.dataConfigExt.getDynConfigReadAttributes(ac);
        for(final Attribute a : _dynConfigReadAttributes_2) {
          _builder.append("\t");
          _builder.append("private DynConfigLock lock_");
          String _name_7 = a.getName();
          _builder.append(_name_7, "	");
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
      String _name_8 = ac.getName();
      _builder.append(_name_8, "	");
      _builder.append("(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){");
      _builder.newLineIfNotEmpty();
      {
        ActorClass _base_2 = ac.getBase();
        boolean _equals = Objects.equal(_base_2, null);
        if (_equals) {
          _builder.append("\t\t");
          _builder.append("super(parent, name, port_addr[0][0], peer_addr[0][0]);");
          _builder.newLine();
        } else {
          _builder.append("\t\t");
          _builder.append("super(parent, name, port_addr, peer_addr);");
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("setClassName(\"");
      String _name_9 = ac.getName();
      _builder.append(_name_9, "		");
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
        List<Port> _endPorts_1 = this._roomExtensions.getEndPorts(ac);
        for(final Port ep_1 : _endPorts_1) {
          _builder.append("\t\t");
          String _name_10 = ep_1.getName();
          _builder.append(_name_10, "		");
          _builder.append(" = new ");
          String _portClassName_3 = this._roomExtensions.getPortClassName(ep_1);
          _builder.append(_portClassName_3, "		");
          _builder.append("(this, \"");
          String _name_11 = ep_1.getName();
          _builder.append(_name_11, "		");
          _builder.append("\", IFITEM_");
          String _name_12 = ep_1.getName();
          _builder.append(_name_12, "		");
          _builder.append(", ");
          {
            int _multiplicity = ep_1.getMultiplicity();
            boolean _equals_1 = (_multiplicity == 1);
            if (_equals_1) {
              _builder.append("0, ");
            }
          }
          _builder.append("port_addr[IFITEM_");
          String _name_13 = ep_1.getName();
          _builder.append(_name_13, "		");
          _builder.append("]");
          {
            int _multiplicity_1 = ep_1.getMultiplicity();
            boolean _equals_2 = (_multiplicity_1 == 1);
            if (_equals_2) {
              _builder.append("[0]");
            }
          }
          _builder.append(", peer_addr[IFITEM_");
          String _name_14 = ep_1.getName();
          _builder.append(_name_14, "		");
          _builder.append("]");
          {
            int _multiplicity_2 = ep_1.getMultiplicity();
            boolean _equals_3 = (_multiplicity_2 == 1);
            if (_equals_3) {
              _builder.append("[0]");
            }
          }
          _builder.append("); ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own saps");
      _builder.newLine();
      {
        EList<SAPRef> _strSAPs_1 = ac.getStrSAPs();
        for(final SAPRef sap_1 : _strSAPs_1) {
          _builder.append("\t\t");
          String _name_15 = sap_1.getName();
          _builder.append(_name_15, "		");
          _builder.append(" = new ");
          String _portClassName_4 = this._roomExtensions.getPortClassName(sap_1);
          _builder.append(_portClassName_4, "		");
          _builder.append("(this, \"");
          String _name_16 = sap_1.getName();
          _builder.append(_name_16, "		");
          _builder.append("\", IFITEM_");
          String _name_17 = sap_1.getName();
          _builder.append(_name_17, "		");
          _builder.append(", 0, port_addr[IFITEM_");
          String _name_18 = sap_1.getName();
          _builder.append(_name_18, "		");
          _builder.append("][0], peer_addr[IFITEM_");
          String _name_19 = sap_1.getName();
          _builder.append(_name_19, "		");
          _builder.append("][0]); ");
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
          SPPRef _spp_1 = svc_1.getSpp();
          String _name_20 = _spp_1.getName();
          _builder.append(_name_20, "		");
          _builder.append(" = new ");
          String _portClassName_5 = this._roomExtensions.getPortClassName(svc_1);
          _builder.append(_portClassName_5, "		");
          _builder.append("(this, \"");
          SPPRef _spp_2 = svc_1.getSpp();
          String _name_21 = _spp_2.getName();
          _builder.append(_name_21, "		");
          _builder.append("\", IFITEM_");
          SPPRef _spp_3 = svc_1.getSpp();
          String _name_22 = _spp_3.getName();
          _builder.append(_name_22, "		");
          _builder.append(", port_addr[IFITEM_");
          SPPRef _spp_4 = svc_1.getSpp();
          String _name_23 = _spp_4.getName();
          _builder.append(_name_23, "		");
          _builder.append("], peer_addr[IFITEM_");
          SPPRef _spp_5 = svc_1.getSpp();
          String _name_24 = _spp_5.getName();
          _builder.append(_name_24, "		");
          _builder.append("]); ");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _notEquals_1 = (!Objects.equal(ctor, null));
        if (_notEquals_1) {
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
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _or_1 = false;
        List<Attribute> _dynConfigReadAttributes_3 = this.dataConfigExt.getDynConfigReadAttributes(ac);
        boolean _isEmpty_4 = _dynConfigReadAttributes_3.isEmpty();
        boolean _not_4 = (!_isEmpty_4);
        if (_not_4) {
          _or_1 = true;
        } else {
          List<Attribute> _dynConfigWriteAttributes_2 = this.dataConfigExt.getDynConfigWriteAttributes(ac);
          boolean _isEmpty_5 = _dynConfigWriteAttributes_2.isEmpty();
          boolean _not_5 = (!_isEmpty_5);
          _or_1 = (_not_4 || _not_5);
        }
        if (_or_1) {
          _builder.append("\t");
          _builder.append("public ");
          String _name_25 = ac.getName();
          _builder.append(_name_25, "	");
          _builder.append("(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr, VariableService variableService){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this(parent, name, port_addr, peer_addr);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.newLine();
          {
            List<Attribute> _dynConfigWriteAttributes_3 = this.dataConfigExt.getDynConfigWriteAttributes(ac);
            boolean _isEmpty_6 = _dynConfigWriteAttributes_3.isEmpty();
            boolean _not_6 = (!_isEmpty_6);
            if (_not_6) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("this.variableService = variableService;");
              _builder.newLine();
            }
          }
          {
            List<Attribute> _dynConfigReadAttributes_4 = this.dataConfigExt.getDynConfigReadAttributes(ac);
            for(final Attribute a_1 : _dynConfigReadAttributes_4) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("lock_");
              String _name_26 = a_1.getName();
              _builder.append(_name_26, "		");
              _builder.append(" = new DynConfigLock();");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Attribute> _attributes_3 = ac.getAttributes();
      List<Attribute> _dynConfigReadAttributes_5 = this.dataConfigExt.getDynConfigReadAttributes(ac);
      List<Attribute> _minus = this._roomExtensions.<Attribute>minus(_attributes_3, _dynConfigReadAttributes_5);
      String _name_27 = ac.getName();
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_minus, _name_27);
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
        List<Port> _endPorts_2 = this._roomExtensions.getEndPorts(ac);
        for(final Port ep_2 : _endPorts_2) {
          _builder.append("\t");
          String _portClassName_6 = this._roomExtensions.getPortClassName(ep_2);
          String _name_28 = ep_2.getName();
          String _name_29 = ac.getName();
          CharSequence _terImplementation = this._procedureHelpers.getterImplementation(_portClassName_6, _name_28, _name_29);
          _builder.append(_terImplementation, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<SAPRef> _strSAPs_2 = ac.getStrSAPs();
        for(final SAPRef sap_2 : _strSAPs_2) {
          _builder.append("\t");
          String _portClassName_7 = this._roomExtensions.getPortClassName(sap_2);
          String _name_30 = sap_2.getName();
          String _name_31 = ac.getName();
          CharSequence _terImplementation_1 = this._procedureHelpers.getterImplementation(_portClassName_7, _name_30, _name_31);
          _builder.append(_terImplementation_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ServiceImplementation> _serviceImplementations_2 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_2 : _serviceImplementations_2) {
          _builder.append("\t");
          String _portClassName_8 = this._roomExtensions.getPortClassName(svc_2);
          SPPRef _spp_6 = svc_2.getSpp();
          String _name_32 = _spp_6.getName();
          String _name_33 = ac.getName();
          CharSequence _terImplementation_2 = this._procedureHelpers.getterImplementation(_portClassName_8, _name_32, _name_33);
          _builder.append(_terImplementation_2, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- lifecycle functions");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void init(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("initUser();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void start(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("startUser();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _overridesStop = this._roomExtensions.overridesStop(ac);
        boolean _not_7 = (!_overridesStop);
        if (_not_7) {
          _builder.append("\t");
          _builder.append("public void stop(){");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("stopUser();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void destroy(){");
      _builder.newLine();
      {
        boolean _notEquals_2 = (!Objects.equal(dtor, null));
        if (_notEquals_2) {
          _builder.append("\t\t");
          String _name_34 = ac.getName();
          String _destructorCall = this._procedureHelpers.destructorCall(_name_34);
          _builder.append(_destructorCall, "		");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _hasNonEmptyStateMachine = RoomHelpers.hasNonEmptyStateMachine(ac);
        if (_hasNonEmptyStateMachine) {
          _builder.append("\t");
          CharSequence _genStateMachine = this._stateMachineGen.genStateMachine(xpac);
          _builder.append(_genStateMachine, "	");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _hasStateMachine = xpac.hasStateMachine();
          boolean _not_8 = (!_hasStateMachine);
          if (_not_8) {
            _builder.append("\t");
            _builder.append("//--------------------- no state machine");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("handleSystemEvent(ifitem, evt, data);");
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
            _builder.append("public void executeInitTransition(){");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
