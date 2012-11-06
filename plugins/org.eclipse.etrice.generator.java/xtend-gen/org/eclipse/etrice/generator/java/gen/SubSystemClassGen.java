package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.java.gen.ConfigGenAddon;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.etrice.generator.java.gen.VariableServiceGen;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

@Singleton
@SuppressWarnings("all")
public class SubSystemClassGen {
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
  private VariableServiceGen varService;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance ssi : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
        String _path = this._roomExtensions.getPath(_subSystemClass_1);
        String path = (_generationTargetPath + _path);
        SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
        String file = this._javaExtensions.getJavaFileName(_subSystemClass_2);
        String _plus = ("generating SubSystemClass implementation: \'" + file);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
        CharSequence _generate = this.generate(root, ssi, _subSystemClass_3);
        this.fileAccess.generateFile(file, _generate);
        SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
        boolean _hasVariableService = this.dataConfigExt.hasVariableService(_subSystemClass_4);
        if (_hasVariableService) {
          this.varService.doGenerate(root, ssi);
        }
      }
    }
  }
  
  public CharSequence generate(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this._roomExtensions.getPackage(cc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _hasVariableService = this.dataConfigExt.hasVariableService(cc);
      if (_hasVariableService) {
        _builder.append("import org.eclipse.etrice.runtime.java.config.VariableService;");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;");
    _builder.newLine();
    _builder.newLine();
    EList<RoomModel> models = root.getReferencedModels(cc);
    _builder.newLineIfNotEmpty();
    {
      for(final RoomModel model : models) {
        _builder.append("import ");
        String _name = model.getName();
        _builder.append(_name, "");
        _builder.append(".*;");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    CharSequence _userCode = this._procedureHelpers.userCode(cc, 1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = comp.getName();
    _builder.append(_name_1, "");
    _builder.append(" extends SubSystemClassBase{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _userCode_1 = this._procedureHelpers.userCode(cc, 2);
    _builder.append(_userCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_2 = comp.getName();
    _builder.append(_name_2, "	");
    _builder.append("(String name) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(name);");
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
    _builder.append("public void instantiateMessageServices(){");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),\"MessageService_Main\"));");
    _builder.newLine();
    {
      EList<LogicalThread> _threads = cc.getThreads();
      for(final LogicalThread thread : _threads) {
        _builder.append("\t\t");
        _builder.append("RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, ");
        EList<LogicalThread> _threads_1 = cc.getThreads();
        int _indexOf = _threads_1.indexOf(thread);
        int _plus = (_indexOf + 1);
        _builder.append(_plus, "		");
        _builder.append(", 0),\"MessageService_");
        String _name_3 = thread.getName();
        _builder.append(_name_3, "		");
        _builder.append("\", ");
        int _prio = thread.getPrio();
        _builder.append(_prio, "		");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void instantiateActors(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// all addresses");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Addresses for the Subsystem Systemport");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
      int _maxObjId = comp.getMaxObjId();
      Iterable<Indexed<ActorInstance>> _indexed = Indexed.<ActorInstance>indexed(_allContainedInstances, _maxObjId);
      for(final Indexed<ActorInstance> ai : _indexed) {
        _builder.append("\t\t");
        _builder.append("Address addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_1 = comp.getAllContainedInstances();
        ActorInstance _value = ai.getValue();
        int _indexOf_1 = _allContainedInstances_1.indexOf(_value);
        _builder.append(_indexOf_1, "		");
        _builder.append(" = new Address(0,0,");
        int _index1 = ai.getIndex1();
        _builder.append(_index1, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_2 = comp.getAllContainedInstances();
      for(final ActorInstance ai_1 : _allContainedInstances_2) {
        _builder.append("\t\t");
        _builder.append("// actor instance ");
        String _path = ai_1.getPath();
        _builder.append(_path, "		");
        _builder.append(" itself => Systemport Address");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("Address addr_item_");
        String _path_1 = ai_1.getPath();
        String _pathName = this._roomExtensions.getPathName(_path_1);
        _builder.append(_pathName, "		");
        _builder.append(" = new Address(0,");
        int _threadId = ai_1.getThreadId();
        _builder.append(_threadId, "		");
        _builder.append(",");
        int _objId = ai_1.getObjId();
        _builder.append(_objId, "		");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("// interface items of ");
        String _path_2 = ai_1.getPath();
        _builder.append(_path_2, "		");
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
          for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
            {
              boolean _isReplicated = pi.isReplicated();
              if (_isReplicated) {
                {
                  EList<InterfaceItemInstance> _peers = pi.getPeers();
                  for(final InterfaceItemInstance peer : _peers) {
                    _builder.append("\t\t");
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    int i = _peers_1.indexOf(peer);
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("Address addr_item_");
                    String _path_3 = pi.getPath();
                    String _pathName_1 = this._roomExtensions.getPathName(_path_3);
                    _builder.append(_pathName_1, "		");
                    _builder.append("_");
                    _builder.append(i, "		");
                    _builder.append(" = new Address(0,");
                    int _threadId_1 = ai_1.getThreadId();
                    _builder.append(_threadId_1, "		");
                    _builder.append(",");
                    int _objId_1 = pi.getObjId();
                    int _plus_1 = (_objId_1 + i);
                    _builder.append(_plus_1, "		");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("Address addr_item_");
                String _path_4 = pi.getPath();
                String _pathName_2 = this._roomExtensions.getPathName(_path_4);
                _builder.append(_pathName_2, "		");
                _builder.append(" = new Address(0,");
                int _threadId_2 = ai_1.getThreadId();
                _builder.append(_threadId_2, "		");
                _builder.append(",");
                int _objId_2 = pi.getObjId();
                _builder.append(_objId_2, "		");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// instantiate all actor instances");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("instances = new ActorClassBase[");
    EList<ActorInstance> _allContainedInstances_3 = comp.getAllContainedInstances();
    int _size = _allContainedInstances_3.size();
    _builder.append(_size, "		");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_4 = comp.getAllContainedInstances();
      for(final ActorInstance ai_2 : _allContainedInstances_4) {
        _builder.append("\t\t");
        _builder.append("instances[");
        EList<ActorInstance> _allContainedInstances_5 = comp.getAllContainedInstances();
        int _indexOf_2 = _allContainedInstances_5.indexOf(ai_2);
        _builder.append(_indexOf_2, "		");
        _builder.append("] = new ");
        ActorClass _actorClass = ai_2.getActorClass();
        String _name_4 = _actorClass.getName();
        _builder.append(_name_4, "		");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          EObject _eContainer = ai_2.eContainer();
          if ((_eContainer instanceof SubSystemInstance)) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("this,");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("instances[");
            EList<ActorInstance> _allContainedInstances_6 = comp.getAllContainedInstances();
            EObject _eContainer_1 = ai_2.eContainer();
            int _indexOf_3 = _allContainedInstances_6.indexOf(_eContainer_1);
            _builder.append(_indexOf_3, "			");
            _builder.append("],");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("\"");
        String _name_5 = ai_2.getName();
        _builder.append(_name_5, "			");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// own interface item addresses");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("new Address[][] {{addr_item_");
        String _path_5 = ai_2.getPath();
        String _pathName_3 = this._roomExtensions.getPathName(_path_5);
        _builder.append(_pathName_3, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty = _orderedIfItemInstances_1.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_2 = ai_2.getOrderedIfItemInstances();
          boolean _hasElements = false;
          for(final InterfaceItemInstance pi_1 : _orderedIfItemInstances_2) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "				");
            }
            {
              boolean _isReplicated_1 = pi_1.isReplicated();
              if (_isReplicated_1) {
                {
                  EList<InterfaceItemInstance> _peers_2 = pi_1.getPeers();
                  boolean _isEmpty_1 = _peers_2.isEmpty();
                  if (_isEmpty_1) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("null");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("{");
                    _builder.newLine();
                    {
                      EList<InterfaceItemInstance> _peers_3 = pi_1.getPeers();
                      boolean _hasElements_1 = false;
                      for(final InterfaceItemInstance peer_1 : _peers_3) {
                        if (!_hasElements_1) {
                          _hasElements_1 = true;
                        } else {
                          _builder.appendImmediate(",", "					");
                        }
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("addr_item_");
                        String _path_6 = pi_1.getPath();
                        String _pathName_4 = this._roomExtensions.getPathName(_path_6);
                        _builder.append(_pathName_4, "					");
                        _builder.append("_");
                        EList<InterfaceItemInstance> _peers_4 = pi_1.getPeers();
                        int _indexOf_4 = _peers_4.indexOf(peer_1);
                        _builder.append(_indexOf_4, "					");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("addr_item_");
                String _path_7 = pi_1.getPath();
                String _pathName_5 = this._roomExtensions.getPathName(_path_7);
                _builder.append(_pathName_5, "					");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("},");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("// peer interface item addresses");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("new Address[][] {{addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_7 = comp.getAllContainedInstances();
        int _indexOf_5 = _allContainedInstances_7.indexOf(ai_2);
        _builder.append(_indexOf_5, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_3 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty_2 = _orderedIfItemInstances_3.isEmpty();
          boolean _not_1 = (!_isEmpty_2);
          if (_not_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_4 = ai_2.getOrderedIfItemInstances();
          boolean _hasElements_2 = false;
          for(final InterfaceItemInstance pi_2 : _orderedIfItemInstances_4) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",", "				");
            }
            {
              boolean _and = false;
              boolean _isReplicated_2 = pi_2.isReplicated();
              if (!_isReplicated_2) {
                _and = false;
              } else {
                EList<InterfaceItemInstance> _peers_5 = pi_2.getPeers();
                boolean _isEmpty_3 = _peers_5.isEmpty();
                _and = (_isReplicated_2 && _isEmpty_3);
              }
              if (_and) {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("null");
                _builder.newLine();
              } else {
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("{");
                _builder.newLine();
                {
                  EList<InterfaceItemInstance> _peers_6 = pi_2.getPeers();
                  boolean _isEmpty_4 = _peers_6.isEmpty();
                  if (_isEmpty_4) {
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("null");
                    _builder.newLine();
                  } else {
                    {
                      EList<InterfaceItemInstance> _peers_7 = pi_2.getPeers();
                      boolean _hasElements_3 = false;
                      for(final InterfaceItemInstance pp : _peers_7) {
                        if (!_hasElements_3) {
                          _hasElements_3 = true;
                        } else {
                          _builder.appendImmediate(",", "					");
                        }
                        {
                          boolean _isReplicated_3 = pp.isReplicated();
                          if (_isReplicated_3) {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("addr_item_");
                            String _path_8 = pp.getPath();
                            String _pathName_6 = this._roomExtensions.getPathName(_path_8);
                            _builder.append(_pathName_6, "					");
                            _builder.append("_");
                            EList<InterfaceItemInstance> _peers_8 = pp.getPeers();
                            int _indexOf_6 = _peers_8.indexOf(pi_2);
                            _builder.append(_indexOf_6, "					");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("addr_item_");
                            String _path_9 = pp.getPath();
                            String _pathName_7 = this._roomExtensions.getPathName(_path_9);
                            _builder.append(_pathName_7, "					");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          String _path_10 = ai_2.getPath();
          List<Attribute> _dynConfigWriteAttributes = this.dataConfigExt.getDynConfigWriteAttributes(_path_10);
          boolean _isEmpty_5 = _dynConfigWriteAttributes.isEmpty();
          boolean _not_2 = (!_isEmpty_5);
          if (_not_2) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append(", variableService");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("); ");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// apply instance attribute configurations");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_8 = comp.getAllContainedInstances();
      for(final ActorInstance ai_3 : _allContainedInstances_8) {
        _builder.append("\t\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        ActorClass _actorClass_1 = ai_3.getActorClass();
        String _name_6 = _actorClass_1.getName();
        _builder.append(_name_6, "			");
        _builder.append(" inst = (");
        ActorClass _actorClass_2 = ai_3.getActorClass();
        String _name_7 = _actorClass_2.getName();
        _builder.append(_name_7, "			");
        _builder.append(") instances[");
        EList<ActorInstance> _allContainedInstances_9 = comp.getAllContainedInstances();
        int _indexOf_7 = _allContainedInstances_9.indexOf(ai_3);
        _builder.append(_indexOf_7, "			");
        _builder.append("];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        CharSequence _genActorInstanceConfig = this.configGenAddon.genActorInstanceConfig(ai_3, "inst");
        _builder.append(_genActorInstanceConfig, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// create the subsystem system port\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, \"RTSystemPort\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("0, //local ID");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// own addresses");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("new Address[]{");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_10 = comp.getAllContainedInstances();
      boolean _hasElements_4 = false;
      for(final ActorInstance ai_4 : _allContainedInstances_10) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_11 = comp.getAllContainedInstances();
        int _indexOf_8 = _allContainedInstances_11.indexOf(ai_4);
        _builder.append(_indexOf_8, "					");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("},");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// peer addresses");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("new Address[]{");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_12 = comp.getAllContainedInstances();
      boolean _hasElements_5 = false;
      for(final ActorInstance ai_5 : _allContainedInstances_12) {
        if (!_hasElements_5) {
          _hasElements_5 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_");
        String _path_11 = ai_5.getPath();
        String _pathName_8 = this._roomExtensions.getPathName(_path_11);
        _builder.append(_pathName_8, "					");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _hasVariableService_1 = this.dataConfigExt.hasVariableService(cc);
      if (_hasVariableService_1) {
        _builder.append("\t\t");
        _builder.append("private VariableService variableService;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void init(){");
    _builder.newLine();
    {
      boolean _hasVariableService_2 = this.dataConfigExt.hasVariableService(cc);
      if (_hasVariableService_2) {
        _builder.append("\t\t\t");
        _builder.append("variableService = new ");
        String _name_8 = comp.getName();
        _builder.append(_name_8, "			");
        _builder.append("VariableService(this);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("super.init();");
    _builder.newLine();
    {
      boolean _hasVariableService_3 = this.dataConfigExt.hasVariableService(cc);
      if (_hasVariableService_3) {
        _builder.append("\t\t\t");
        _builder.append("variableService.init();");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void stop(){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super.stop();");
    _builder.newLine();
    {
      boolean _hasVariableService_4 = this.dataConfigExt.hasVariableService(cc);
      if (_hasVariableService_4) {
        _builder.append("\t\t\t");
        _builder.append("variableService.stop();");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
}
