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
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.Initialization;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.StateMachineGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  public void doGenerate(final Root root) {
    EList<ExpandedActorClass> _xpActorClasses = root.getXpActorClasses();
    for (final ExpandedActorClass xpac : _xpActorClasses) {
      {
        ActorClass _actorClass = xpac.getActorClass();
        final boolean manualBehavior = RoomHelpers.isBehaviorAnnotationPresent(_actorClass, "BehaviorManual");
        ActorClass _actorClass_1 = xpac.getActorClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_actorClass_1);
        ActorClass _actorClass_2 = xpac.getActorClass();
        String _path = this._roomExtensions.getPath(_actorClass_2);
        final String path = (_generationTargetPath + _path);
        ActorClass _actorClass_3 = xpac.getActorClass();
        String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(_actorClass_3);
        ActorClass _actorClass_4 = xpac.getActorClass();
        String _path_1 = this._roomExtensions.getPath(_actorClass_4);
        final String infopath = (_generationInfoPath + _path_1);
        ActorClass _actorClass_5 = xpac.getActorClass();
        String file = this._javaExtensions.getJavaFileName(_actorClass_5);
        if (manualBehavior) {
          String _plus = ("Abstract" + file);
          file = _plus;
        }
        CharSequence _generate = this.generate(root, xpac, manualBehavior);
        this.fileIO.generateFile("generating ActorClass implementation", path, infopath, file, _generate);
      }
    }
  }
  
  public CharSequence generate(final Root root, final ExpandedActorClass xpac, final boolean manualBehavior) {
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
          _builder.newLine();
        }
      }
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
        for(final RoomModel model : models) {
          _builder.append("import ");
          String _name_2 = model.getName();
          _builder.append(_name_2, "");
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
          String _name_3 = pc.getName();
          _builder.append(_name_3, "");
          _builder.append(".*;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
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
          String _name_4 = _type_1.getName();
          _builder.append(_name_4, "");
          _builder.append("Interface;");
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
      {
        ActorClass _base = ac.getBase();
        boolean _notEquals = (!Objects.equal(_base, null));
        if (_notEquals) {
          ActorClass _base_1 = ac.getBase();
          String _name_5 = _base_1.getName();
          _builder.append(_name_5, "");
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
          String _name_6 = ep.getName();
          _builder.append(_name_6, "	");
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
          String _name_7 = sap.getName();
          _builder.append(_name_7, "	");
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
          String _name_8 = _spp.getName();
          _builder.append(_name_8, "	");
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
          String _name_9 = _type_2.getName();
          _builder.append(_name_9, "	");
          {
            int _size = sub_1.getSize();
            boolean _notEquals_1 = (_size != 1);
            if (_notEquals_1) {
              _builder.append("Replicated");
            }
          }
          _builder.append("Interface ");
          String _name_10 = sub_1.getName();
          _builder.append(_name_10, "	");
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
          String _name_11 = a.getName();
          _builder.append(_name_11, "	");
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
      String _name_12 = ac.getName();
      _builder.append(_name_12, "		");
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
          String _name_13 = ep_1.getName();
          _builder.append(_name_13, "		");
          _builder.append(" = new ");
          String _portClassName_3 = this._roomExtensions.getPortClassName(ep_1);
          _builder.append(_portClassName_3, "		");
          _builder.append("(this, \"");
          String _name_14 = ep_1.getName();
          _builder.append(_name_14, "		");
          _builder.append("\", IFITEM_");
          String _name_15 = ep_1.getName();
          _builder.append(_name_15, "		");
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
        EList<SAPRef> _strSAPs_1 = ac.getStrSAPs();
        for(final SAPRef sap_1 : _strSAPs_1) {
          _builder.append("\t\t");
          String _name_16 = sap_1.getName();
          _builder.append(_name_16, "		");
          _builder.append(" = new ");
          String _portClassName_4 = this._roomExtensions.getPortClassName(sap_1);
          _builder.append(_portClassName_4, "		");
          _builder.append("(this, \"");
          String _name_17 = sap_1.getName();
          _builder.append(_name_17, "		");
          _builder.append("\", IFITEM_");
          String _name_18 = sap_1.getName();
          _builder.append(_name_18, "		");
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
          SPPRef _spp_1 = svc_1.getSpp();
          String _name_19 = _spp_1.getName();
          _builder.append(_name_19, "		");
          _builder.append(" = new ");
          String _portClassName_5 = this._roomExtensions.getPortClassName(svc_1);
          _builder.append(_portClassName_5, "		");
          _builder.append("(this, \"");
          SPPRef _spp_2 = svc_1.getSpp();
          String _name_20 = _spp_2.getName();
          _builder.append(_name_20, "		");
          _builder.append("\", IFITEM_");
          SPPRef _spp_3 = svc_1.getSpp();
          String _name_21 = _spp_3.getName();
          _builder.append(_name_21, "		");
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
              String _name_22 = sub_2.getName();
              _builder.append(_name_22, "		");
              _builder.append(" = new ");
              ActorClass _type_3 = sub_2.getType();
              String _name_23 = _type_3.getName();
              _builder.append(_name_23, "		");
              {
                int _size_1 = sub_2.getSize();
                boolean _notEquals_2 = (_size_1 != 1);
                if (_notEquals_2) {
                  _builder.append("Replicated");
                }
              }
              _builder.append("Interface(this, \"");
              String _name_24 = sub_2.getName();
              _builder.append(_name_24, "		");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            } else {
              int _size_2 = sub_2.getSize();
              boolean _greaterThan = (_size_2 > 1);
              if (_greaterThan) {
                _builder.append("\t\t");
                _builder.append("for (int i=0; i<");
                int _size_3 = sub_2.getSize();
                _builder.append(_size_3, "		");
                _builder.append("; ++i) {");
                _builder.newLineIfNotEmpty();
                {
                  boolean _generateMSCInstrumentation = GlobalSettings.generateMSCInstrumentation();
                  if (_generateMSCInstrumentation) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_25 = sub_2.getName();
                    _builder.append(_name_25, "			");
                    _builder.append("_\"+i);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("new ");
                ActorClass _type_4 = sub_2.getType();
                String _name_26 = _type_4.getName();
                _builder.append(_name_26, "			");
                _builder.append("(this, \"");
                String _name_27 = sub_2.getName();
                _builder.append(_name_27, "			");
                _builder.append("_\"+i);");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                {
                  boolean _generateMSCInstrumentation_1 = GlobalSettings.generateMSCInstrumentation();
                  if (_generateMSCInstrumentation_1) {
                    _builder.append("\t\t");
                    _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"");
                    String _name_28 = sub_2.getName();
                    _builder.append(_name_28, "		");
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("new ");
                ActorClass _type_5 = sub_2.getType();
                String _name_29 = _type_5.getName();
                _builder.append(_name_29, "		");
                _builder.append("(this, \"");
                String _name_30 = sub_2.getName();
                _builder.append(_name_30, "		");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
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
        boolean _isEmpty_1 = _dynConfigReadAttributes_2.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _or_1 = true;
        } else {
          List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(ac);
          boolean _isEmpty_2 = _dynConfigWriteAttributes.isEmpty();
          boolean _not_2 = (!_isEmpty_2);
          _or_1 = (_not_1 || _not_2);
        }
        if (_or_1) {
          {
            List<Attribute> _dynConfigReadAttributes_3 = this.dataConfigExt.getDynConfigReadAttributes(ac);
            for(final Attribute a_1 : _dynConfigReadAttributes_3) {
              _builder.append("\t\t");
              _builder.append("lock_");
              String _name_31 = a_1.getName();
              _builder.append(_name_31, "		");
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
      String _name_32 = ac.getName();
      CharSequence _attributeSettersGettersImplementation = this._procedureHelpers.attributeSettersGettersImplementation(_minus, _name_32);
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
          String _name_33 = ep_2.getName();
          String _name_34 = ac.getName();
          CharSequence _terImplementation = this._procedureHelpers.getterImplementation(_portClassName_6, _name_33, _name_34);
          _builder.append(_terImplementation, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<SAPRef> _strSAPs_2 = ac.getStrSAPs();
        for(final SAPRef sap_2 : _strSAPs_2) {
          _builder.append("\t");
          String _portClassName_7 = this._roomExtensions.getPortClassName(sap_2);
          String _name_35 = sap_2.getName();
          String _name_36 = ac.getName();
          CharSequence _terImplementation_1 = this._procedureHelpers.getterImplementation(_portClassName_7, _name_35, _name_36);
          _builder.append(_terImplementation_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ServiceImplementation> _serviceImplementations_2 = ac.getServiceImplementations();
        for(final ServiceImplementation svc_2 : _serviceImplementations_2) {
          _builder.append("\t");
          String _portClassName_8 = this._roomExtensions.getPortClassName(svc_2);
          SPPRef _spp_4 = svc_2.getSpp();
          String _name_37 = _spp_4.getName();
          String _name_38 = ac.getName();
          CharSequence _terImplementation_2 = this._procedureHelpers.getterImplementation(_portClassName_8, _name_37, _name_38);
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
        boolean _not_3 = (!_overridesStop);
        if (_not_3) {
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
              String _name_39 = ac.getName();
              String _destructorCall = this._procedureHelpers.destructorCall(_name_39);
              _builder.append(_destructorCall, "		");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              {
                boolean _generateMSCInstrumentation_2 = GlobalSettings.generateMSCInstrumentation();
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
          boolean _generateMSCInstrumentation_3 = GlobalSettings.generateMSCInstrumentation();
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
          _builder.append("public abstract void receiveEvent(InterfaceItemBase ifitem, int evt, Object data);");
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
              boolean _hasStateMachine = xpac.hasStateMachine();
              boolean _not_4 = (!_hasStateMachine);
              if (_not_4) {
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
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
