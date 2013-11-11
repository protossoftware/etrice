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
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
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
    HashMap<ActorClass,WiredActorClass> _hashMap = new HashMap<ActorClass, WiredActorClass>();
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
    for (final ExpandedActorClass xpac : _xpActorClasses) {
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
      String _xifexpression_2 = null;
      ActorClass _base = ac.getBase();
      boolean _notEquals = (!Objects.equal(_base, null));
      if (_notEquals) {
        ActorClass _base_1 = ac.getBase();
        String _name_2 = _base_1.getName();
        _xifexpression_2 = _name_2;
      } else {
        String _xifexpression_3 = null;
        String _attribute = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
        boolean _isEmpty = _attribute.isEmpty();
        if (_isEmpty) {
          _xifexpression_3 = "ActorClassBase";
        } else {
          String _attribute_1 = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
          _xifexpression_3 = _attribute_1;
        }
        _xifexpression_2 = _xifexpression_3;
      }
      final String baseClass = _xifexpression_2;
      String _xifexpression_4 = null;
      String _attribute_2 = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
      boolean _isEmpty_1 = _attribute_2.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_4 = "org.eclipse.etrice.runtime.java.modelbase.ActorClassBase";
      } else {
        String _attribute_3 = RoomHelpers.getAttribute(ac, "ActorBaseClass", "package");
        String _plus_1 = (_attribute_3 + ".");
        String _attribute_4 = RoomHelpers.getAttribute(ac, "ActorBaseClass", "class");
        String _plus_2 = (_plus_1 + _attribute_4);
        _xifexpression_4 = _plus_2;
      }
      final String baseClassImport = _xifexpression_4;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package �ac.getPackage�;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�IF !dataConfigExt.getDynConfigReadAttributes(ac).empty�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import org.eclipse.etrice.runtime.java.config.DynConfigLock;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�IF Main::settings.generatePersistenceInterface�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.IPersistable;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import java.io.IOException;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import java.io.ObjectInput;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import java.io.ObjectOutput;");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;");
      _builder.newLine();
      _builder.append("import �baseClassImport�;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
      _builder.newLine();
      _builder.append("import org.eclipse.etrice.runtime.java.debugging.DebuggingService;");
      _builder.newLine();
      _builder.append("import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;");
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
      _builder.append("�FOR pc : root.getReferencedProtocolClasses(ac)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import �pc.package�.�pc.name�.*;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR sub : ac.actorRefs.filter(r|r.refType==ReferenceType.OPTIONAL)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("import �sub.type.package�.�sub.type.name�Interface;");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�ac.userCode(1, true)�");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public �IF manualBehavior || ac.^abstract�abstract �ENDIF�class �clsname� extends �baseClass� �impPersist�{");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ac.userCode(2, false)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- ports");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR ep : ac.getEndPorts()�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected �ep.getPortClassName()� �ep.name� = null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- saps");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR sap : ac.serviceAccessPoints�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected �sap.getPortClassName()� �sap.name� = null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- services");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR svc : ac.serviceImplementations�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected �svc.getPortClassName()� �svc.spp.name� = null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- optional actors");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR sub : ac.actorRefs.filter(r|r.refType==ReferenceType.OPTIONAL)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected �sub.type.name��IF sub.multiplicity!=1�Replicated�ENDIF�Interface �sub.name� = null;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- interface item IDs");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�xpac.genInterfaceItemConstants�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�configGenAddon.genMinMaxConstants(ac)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ac.attributes.attributes�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR a : dataConfigExt.getDynConfigReadAttributes(ac)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private DynConfigLock lock_�a.name�;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ac.operationsImplementation�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- construction");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public �clsname�(IRTObject parent, String name) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super(parent, name);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("setClassName(\"�ac.name�\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ac.attributes.attributeInitialization(ac, false)�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own ports");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ep : ac.getEndPorts()�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ep.name� = new �ep.getPortClassName()�(this, \"�ep.name�\", IFITEM_�ep.name�);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own saps");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR sap : ac.serviceAccessPoints�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�sap.name� = new �sap.getPortClassName()�(this, \"�sap.name�\", IFITEM_�sap.name�, 0);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// own service implementations");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR svc : ac.serviceImplementations�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�svc.spp.name� = new �svc.getPortClassName()�(this, \"�svc.spp.name�\", IFITEM_�svc.spp.name�);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// sub actors");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR sub : ac.actorRefs�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF sub.refType==ReferenceType.OPTIONAL�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�sub.name� = new �sub.type.name��IF sub.multiplicity!=1�Replicated�ENDIF�Interface(this, \"�sub.name�\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ELSEIF sub.multiplicity>1�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (int i=0; i<�sub.multiplicity�; ++i) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorCreate(this, \"�sub.name��GenmodelConstants::INDEX_SEP�\"+i);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("new �sub.type.name�(this, \"�sub.name��GenmodelConstants::INDEX_SEP�\"+i);");
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
      _builder.append("new �sub.type.name�(this, \"�sub.name�\");");
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
      _builder.append("�IF ctor!=null�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// user defined constructor body");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�AbstractGenerator::getInstance().getTranslatedCode(ctor.detailCode)�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF !dataConfigExt.getDynConfigReadAttributes(ac).empty || !dataConfigExt.getDynConfigWriteAttributes(ac).empty�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR a : dataConfigExt.getDynConfigReadAttributes(ac)�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("lock_�a.name� = new DynConfigLock();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�attributeSettersGettersImplementation(ac.attributes.minus(dataConfigExt.getDynConfigReadAttributes(ac)), ac.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�configGenAddon.genDynConfigGetterSetter(ac)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- port getters");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR ep : ac.getEndPorts()�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ep.portClassName.getterImplementation(ep.name, ac.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR sap : ac.serviceAccessPoints�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�sap.portClassName.getterImplementation(sap.name, ac.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�FOR svc : ac.serviceImplementations�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�svc.portClassName.getterImplementation(svc.spp.name, ac.name)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//--------------------- lifecycle functions");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF !ac.overridesStop()�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF manualBehavior�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public abstract void stop();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void stop(){");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("stopUser();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("super.stop();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF dtor!=null�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF manualBehavior�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public abstract void destroy();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void destroy(){");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ac.name.destructorCall�;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�IF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("super.destroy();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSEIF Main::settings.generateMSCInstrumentation�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public void destroy() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("DebuggingService.getInstance().addMessageActorDestroy(this);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super.destroy();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF manualBehavior�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR ifitem : ac.allInterfaceItems SEPARATOR \"else \"�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (ifitem==�ifitem.name�) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("switch (evt) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�FOR msg: ifitem.incoming�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("case �msg.protocolClass.name�.�if (msg.incoming) \"IN_\" else \"OUT_\"��msg.name�:");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�IF (msg.data!=null)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("{�msg.typedDataDefinition�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("on_�ifitem.name�_�msg.name�(ifitem�IF (msg.data!=null)�, �msg.data.name��ENDIF�);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�IF (msg.data!=null)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�FOR ifitem : ac.allInterfaceItems�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�FOR msg: ifitem.incoming�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("protected void on_�ifitem.name�_�msg.name�(InterfaceItemBase ifitem�IF msg.data!=null��msg.data.generateArglistAndTypedData.get(2)��ENDIF�) {}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public abstract void executeInitTransition();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�IF ac.hasNonEmptyStateMachine�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�xpac.genStateMachine()�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ELSEIF !xpac.hasStateMachine()�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("//--------------------- no state machine");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("handleSystemEvent(ifitem, evt, data);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void executeInitTransition() {}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF Main::settings.generatePersistenceInterface�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public void saveObject(ObjectOutput output) throws IOException {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF xpac.hasStateMachine()�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// state and history");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("output.writeInt(getState());");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (int h: history) output.writeInt(h);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("saveAttributes(output);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void saveAttributes(ObjectOutput output) throws IOException {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�xpac.genSaveImpl�");
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
      _builder.append("public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF xpac.hasStateMachine()�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("// state and history");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("setState(input.readInt());");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (int i=0; i<history.length; ++i) history[i] = input.readInt();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("loadAttributes(input);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�xpac.genLoadImpl�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
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
      _builder.append("\t\t\t");
      _builder.append("�IF ac.base!=null�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super.saveAttributes(output);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF !ac.attributes.empty�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR att : ac.attributes�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF att.type.type instanceof PrimitiveType�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�genSavePrimitive(att)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("���\t\t\t\t\t\tDataClass and ExternalType (the latter one has to implement Serializable)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�IF att.size>1�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("for (�att.type.type.name� v: �att.name�) output.writeObject(v);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("output.writeObject(�att.name�);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence genLoadImpl(final ExpandedActorClass xpac) {
    CharSequence _xblockexpression = null;
    {
      final ActorClass ac = xpac.getActorClass();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t\t");
      _builder.append("�IF ac.base!=null�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("super.loadAttributes(input);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�IF !ac.attributes.empty�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�FOR att : ac.attributes�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�IF att.type.type instanceof PrimitiveType�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�genLoadPrimitive(att)�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("���\t\t\t\t\t\tDataClass and ExternalType (the latter one has to implement Serializable)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�IF att.size>1�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("for (int i=0; i< �att.name�.length; ++i) �att.name�[i] = (�att.type.type.name�) input.readObject();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ELSE�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("�att.name� = (�att.type.type.name�) input.readObject();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String genSavePrimitive(final Attribute att) {
    String _xblockexpression = null;
    {
      RefableType _type = att.getType();
      DataType _type_1 = _type.getType();
      final String type = ((PrimitiveType) _type_1).getTargetName();
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
      final String type = ((PrimitiveType) _type_1).getTargetName();
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
