package org.eclipse.etrice.generator.java.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.base.Indexed;
import org.eclipse.etrice.generator.etricegen.ActorInstance;
import org.eclipse.etrice.generator.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.etricegen.SubSystemInstance;
import org.eclipse.etrice.generator.extensions.RoomExtensions;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class SubSystemClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private JavaExtensions stdExt;
  
  @Inject
  private RoomExtensions roomExt;
  
  @Inject
  private ProcedureHelpers helpers;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<SubSystemInstance> _subSystemInstances = root.getSubSystemInstances();
    for (final SubSystemInstance ssi : _subSystemInstances) {
      {
        SubSystemClass _subSystemClass = ssi.getSubSystemClass();
        String _generationTargetPath = this.roomExt.getGenerationTargetPath(_subSystemClass);
        SubSystemClass _subSystemClass_1 = ssi.getSubSystemClass();
        String _path = this.roomExt.getPath(_subSystemClass_1);
        String _operator_plus = StringExtensions.operator_plus(_generationTargetPath, _path);
        String path = _operator_plus;
        SubSystemClass _subSystemClass_2 = ssi.getSubSystemClass();
        String _javaFileName = this.stdExt.getJavaFileName(_subSystemClass_2);
        String file = _javaFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating SubSystemClass implementation: \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
        StringConcatenation _generate = this.generate(root, ssi, _subSystemClass_3);
        this.fileAccess.generateFile(file, _generate);
      }
    }
  }
  
  public StringConcatenation generate(final Root root, final SubSystemInstance comp, final SubSystemClass cc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _package = this.roomExt.getPackage(cc);
    _builder.append(_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.MessageService;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.RTServices;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.Address;");
    _builder.newLine();
    _builder.append("import org.eclipse.etrice.runtime.java.messaging.IRTObject;");
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
    EList<RoomModel> _referencedModels = root.getReferencedModels(cc);
    EList<RoomModel> models = _referencedModels;
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
    DetailCode _userCode1 = cc.getUserCode1();
    StringConcatenation _userCode = this.helpers.userCode(_userCode1);
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
    DetailCode _userCode2 = cc.getUserCode2();
    StringConcatenation _userCode_1 = this.helpers.userCode(_userCode2);
    _builder.append(_userCode_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_2 = comp.getName();
    _builder.append(_name_2, "	");
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
        int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf), ((Integer)1));
        _builder.append(_operator_plus, "		");
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
        _builder.append("// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Address addr_item_");
        String _path_1 = ai_1.getPath();
        String _pathName = this.roomExt.getPathName(_path_1);
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
                    int _indexOf_2 = _peers_1.indexOf(peer);
                    int i = _indexOf_2;
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("Address addr_item_");
                    String _path_3 = pi.getPath();
                    String _pathName_1 = this.roomExt.getPathName(_path_3);
                    _builder.append(_pathName_1, "		");
                    _builder.append("_");
                    _builder.append(i, "		");
                    _builder.append(" = new Address(0,");
                    int _threadId_1 = pi.getThreadId();
                    _builder.append(_threadId_1, "		");
                    _builder.append(",");
                    int _objId_1 = pi.getObjId();
                    int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_objId_1), ((Integer)i));
                    _builder.append(_operator_plus_1, "		");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("Address addr_item_");
                String _path_4 = pi.getPath();
                String _pathName_2 = this.roomExt.getPathName(_path_4);
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
        int _indexOf_3 = _allContainedInstances_5.indexOf(ai_2);
        _builder.append(_indexOf_3, "		");
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
            int _indexOf_4 = _allContainedInstances_6.indexOf(_eContainer_1);
            _builder.append(_indexOf_4, "			");
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
        String _pathName_3 = this.roomExt.getPathName(_path_5);
        _builder.append(_pathName_3, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty = _orderedIfItemInstances_1.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          if (_operator_not) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_2 = ai_2.getOrderedIfItemInstances();
          boolean hasAnyElements = false;
          for(final InterfaceItemInstance pi_1 : _orderedIfItemInstances_2) {
            if (!hasAnyElements) {
              hasAnyElements = true;
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
                      boolean hasAnyElements_1 = false;
                      for(final InterfaceItemInstance peer_1 : _peers_3) {
                        if (!hasAnyElements_1) {
                          hasAnyElements_1 = true;
                        } else {
                          _builder.appendImmediate(",", "					");
                        }
                        _builder.append("\t\t");
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("addr_item_");
                        String _path_6 = pi_1.getPath();
                        String _pathName_4 = this.roomExt.getPathName(_path_6);
                        _builder.append(_pathName_4, "					");
                        _builder.append("_");
                        EList<InterfaceItemInstance> _peers_4 = pi_1.getPeers();
                        int _indexOf_5 = _peers_4.indexOf(peer_1);
                        _builder.append(_indexOf_5, "					");
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
                String _pathName_5 = this.roomExt.getPathName(_path_7);
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
        int _indexOf_6 = _allContainedInstances_7.indexOf(ai_2);
        _builder.append(_indexOf_6, "			");
        _builder.append("}");
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_3 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty_2 = _orderedIfItemInstances_3.isEmpty();
          boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_2);
          if (_operator_not_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_4 = ai_2.getOrderedIfItemInstances();
          boolean hasAnyElements_2 = false;
          for(final InterfaceItemInstance pi_2 : _orderedIfItemInstances_4) {
            if (!hasAnyElements_2) {
              hasAnyElements_2 = true;
            } else {
              _builder.appendImmediate(",", "				");
            }
            {
              boolean _operator_and = false;
              boolean _isReplicated_2 = pi_2.isReplicated();
              if (!_isReplicated_2) {
                _operator_and = false;
              } else {
                EList<InterfaceItemInstance> _peers_5 = pi_2.getPeers();
                boolean _isEmpty_3 = _peers_5.isEmpty();
                _operator_and = BooleanExtensions.operator_and(_isReplicated_2, _isEmpty_3);
              }
              if (_operator_and) {
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
                      boolean hasAnyElements_3 = false;
                      for(final InterfaceItemInstance pp : _peers_7) {
                        if (!hasAnyElements_3) {
                          hasAnyElements_3 = true;
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
                            String _pathName_6 = this.roomExt.getPathName(_path_8);
                            _builder.append(_pathName_6, "					");
                            _builder.append("_");
                            EList<InterfaceItemInstance> _peers_8 = pp.getPeers();
                            int _indexOf_7 = _peers_8.indexOf(pi_2);
                            _builder.append(_indexOf_7, "					");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("addr_item_");
                            String _path_9 = pp.getPath();
                            String _pathName_7 = this.roomExt.getPathName(_path_9);
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
        _builder.append("\t\t");
        _builder.append("); ");
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
      EList<ActorInstance> _allContainedInstances_8 = comp.getAllContainedInstances();
      boolean hasAnyElements_4 = false;
      for(final ActorInstance ai_3 : _allContainedInstances_8) {
        if (!hasAnyElements_4) {
          hasAnyElements_4 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_SystemPort_");
        EList<ActorInstance> _allContainedInstances_9 = comp.getAllContainedInstances();
        int _indexOf_8 = _allContainedInstances_9.indexOf(ai_3);
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
      EList<ActorInstance> _allContainedInstances_10 = comp.getAllContainedInstances();
      boolean hasAnyElements_5 = false;
      for(final ActorInstance ai_4 : _allContainedInstances_10) {
        if (!hasAnyElements_5) {
          hasAnyElements_5 = true;
        } else {
          _builder.appendImmediate(",", "					");
        }
        _builder.append("\t\t\t\t\t");
        _builder.append("addr_item_");
        String _path_10 = ai_4.getPath();
        String _pathName_8 = this.roomExt.getPathName(_path_10);
        _builder.append(_pathName_8, "					");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
}
