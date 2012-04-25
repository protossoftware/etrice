package org.eclipse.etrice.generator.c.gen;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.ILogger;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.etricegen.ActorInstance;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.generator.etricegen.PortInstance;
import org.eclipse.etrice.generator.etricegen.Root;
import org.eclipse.etrice.generator.etricegen.SubSystemInstance;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Singleton
public class SubSystemClassGen {
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  private CExtensions stdExt;
  
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
        String _cHeaderFileName = this.stdExt.getCHeaderFileName(_subSystemClass_2);
        String file = _cHeaderFileName;
        String _operator_plus_1 = StringExtensions.operator_plus("generating SubSystemClass declaration: \'", file);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "\' in \'");
        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, path);
        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\'");
        this.logger.logInfo(_operator_plus_4);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_3 = ssi.getSubSystemClass();
        StringConcatenation _generateHeaderFile = this.generateHeaderFile(root, ssi, _subSystemClass_3);
        this.fileAccess.generateFile(file, _generateHeaderFile);
        SubSystemClass _subSystemClass_4 = ssi.getSubSystemClass();
        String _cSourceFileName = this.stdExt.getCSourceFileName(_subSystemClass_4);
        file = _cSourceFileName;
        String _operator_plus_5 = StringExtensions.operator_plus("generating SubSystemClass implementation: \'", file);
        String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "\' in \'");
        String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, path);
        String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, "\'");
        this.logger.logInfo(_operator_plus_8);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_5 = ssi.getSubSystemClass();
        StringConcatenation _generateSourceFile = this.generateSourceFile(root, ssi, _subSystemClass_5);
        this.fileAccess.generateFile(file, _generateSourceFile);
        SubSystemClass _subSystemClass_6 = ssi.getSubSystemClass();
        String _instSourceFileName = this.stdExt.getInstSourceFileName(_subSystemClass_6);
        file = _instSourceFileName;
        String _operator_plus_9 = StringExtensions.operator_plus("generating SubSystemClass instance file: \'", file);
        String _operator_plus_10 = StringExtensions.operator_plus(_operator_plus_9, "\' in \'");
        String _operator_plus_11 = StringExtensions.operator_plus(_operator_plus_10, path);
        String _operator_plus_12 = StringExtensions.operator_plus(_operator_plus_11, "\'");
        this.logger.logInfo(_operator_plus_12);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_7 = ssi.getSubSystemClass();
        StringConcatenation _generateInstanceFile = this.generateInstanceFile(root, ssi, _subSystemClass_7);
        this.fileAccess.generateFile(file, _generateInstanceFile);
        SubSystemClass _subSystemClass_8 = ssi.getSubSystemClass();
        String _dispSourceFileName = this.stdExt.getDispSourceFileName(_subSystemClass_8);
        file = _dispSourceFileName;
        String _operator_plus_13 = StringExtensions.operator_plus("generating SubSystemClass dispatcher file: \'", file);
        String _operator_plus_14 = StringExtensions.operator_plus(_operator_plus_13, "\' in \'");
        String _operator_plus_15 = StringExtensions.operator_plus(_operator_plus_14, path);
        String _operator_plus_16 = StringExtensions.operator_plus(_operator_plus_15, "\'");
        this.logger.logInfo(_operator_plus_16);
        this.fileAccess.setOutputPath(path);
        SubSystemClass _subSystemClass_9 = ssi.getSubSystemClass();
        StringConcatenation _generateDispatcherFile = this.generateDispatcherFile(root, ssi, _subSystemClass_9);
        this.fileAccess.generateFile(file, _generateDispatcherFile);
      }
    }
  }
  
  private StringConcatenation generateHeaderFile(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Header File of SubSystemClass ");
    String _name = ssc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    String _name_1 = ssc.getName();
    StringConcatenation _generateIncludeGuardBegin = this.stdExt.generateIncludeGuardBegin(_name_1);
    _builder.append(_generateIncludeGuardBegin, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    DetailCode _userCode1 = ssc.getUserCode1();
    StringConcatenation _userCode = this.helpers.userCode(_userCode1);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* lifecycle functions");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* init -> start -> run (loop) -> stop -> destroy");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_2 = ssc.getName();
    _builder.append(_name_2, "");
    _builder.append("_init(void);\t\t/* lifecycle init  \t */");
    _builder.newLineIfNotEmpty();
    _builder.append("void ");
    String _name_3 = ssc.getName();
    _builder.append(_name_3, "");
    _builder.append("_start(void);\t/* lifecycle start \t */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_4 = ssc.getName();
    _builder.append(_name_4, "");
    _builder.append("_run(void);\t\t/* lifecycle run \t */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_5 = ssc.getName();
    _builder.append(_name_5, "");
    _builder.append("_stop(void); \t/* lifecycle stop\t */");
    _builder.newLineIfNotEmpty();
    _builder.append("void ");
    String _name_6 = ssc.getName();
    _builder.append(_name_6, "");
    _builder.append("_destroy(void); \t/* lifecycle destroy */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_7 = ssc.getName();
    _builder.append(_name_7, "");
    _builder.append("_shutdown(void);  /* shutdown the dispatcher loop */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    DetailCode _userCode2 = ssc.getUserCode2();
    StringConcatenation _userCode_1 = this.helpers.userCode(_userCode2);
    _builder.append(_userCode_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_8 = ssc.getName();
    StringConcatenation _generateIncludeGuardEnd = this.stdExt.generateIncludeGuardEnd(_name_8);
    _builder.append(_generateIncludeGuardEnd, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private StringConcatenation generateSourceFile(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Source File of SubSystemClass ");
    String _name = ssc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"");
    String _cHeaderFileName = this.stdExt.getCHeaderFileName(ssc);
    _builder.append(_cHeaderFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* include instances for all classes */");
    _builder.newLine();
    _builder.append("#include \"");
    String _instSourceFileName = this.stdExt.getInstSourceFileName(ssc);
    _builder.append(_instSourceFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("#include \"");
    String _dispSourceFileName = this.stdExt.getDispSourceFileName(ssc);
    _builder.append(_dispSourceFileName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include \"debugging/etLogger.h\"");
    _builder.newLine();
    _builder.append("#include \"debugging/etMSCLogger.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"platform/etTimer.h\"");
    _builder.newLine();
    _builder.append("#include \"etGlobalFlags.h\"");
    _builder.newLine();
    _builder.newLine();
    DetailCode _userCode3 = ssc.getUserCode3();
    StringConcatenation _userCode = this.helpers.userCode(_userCode3);
    _builder.append(_userCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/* data for SubSysten ");
    String _name_1 = ssc.getName();
    _builder.append(_name_1, "");
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    _builder.append("typedef struct ");
    String _name_2 = ssc.getName();
    _builder.append(_name_2, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("char *name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("volatile int shutdownRequest;");
    _builder.newLine();
    _builder.append("} ");
    String _name_3 = ssc.getName();
    _builder.append(_name_3, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("static ");
    String _name_4 = ssc.getName();
    _builder.append(_name_4, "");
    _builder.append(" ");
    String _name_5 = ssc.getName();
    _builder.append(_name_5, "");
    _builder.append("Inst = {\"");
    String _name_6 = ssc.getName();
    _builder.append(_name_6, "");
    _builder.append("\",0};");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_7 = ssc.getName();
    _builder.append(_name_7, "");
    _builder.append("_initActorInstances(void);");
    _builder.newLineIfNotEmpty();
    _builder.append("void ");
    String _name_8 = ssc.getName();
    _builder.append(_name_8, "");
    _builder.append("_constructActorInstances(void);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_9 = ssc.getName();
    _builder.append(_name_9, "");
    _builder.append("_init(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"init\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etLogger_logInfoF(\"%s_init\", ");
    String _name_10 = ssc.getName();
    _builder.append(_name_10, "	");
    _builder.append("Inst.name);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* construct all actors */");
    _builder.newLine();
    _builder.append("\t");
    String _name_11 = ssc.getName();
    _builder.append(_name_11, "	");
    _builder.append("_constructActorInstances();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* initialization of all message services */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etMessageService_init(&msgService_Thread1, msgBuffer_Thread1, MESSAGE_POOL_MAX, MESSAGE_BLOCK_SIZE, MsgDispatcher_Thread1_receiveMessage);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* init all actors */");
    _builder.newLine();
    _builder.append("\t");
    String _name_12 = ssc.getName();
    _builder.append(_name_12, "	");
    _builder.append("_initActorInstances();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_13 = ssc.getName();
    _builder.append(_name_13, "");
    _builder.append("_start(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"start\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etLogger_logInfoF(\"%s_start\", ");
    String _name_14 = ssc.getName();
    _builder.append(_name_14, "	");
    _builder.append("Inst.name);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_15 = ssc.getName();
    _builder.append(_name_15, "");
    _builder.append("_run(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"run\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ifdef ET_RUNTIME_ENDLESS");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("while(!(");
    String _name_16 = ssc.getName();
    _builder.append(_name_16, "		");
    _builder.append("Inst.shutdownRequest)){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (etTimer_executeNeeded()){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("etMessageService_execute(&msgService_Thread1);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    StringConcatenation _generateDatadrivenExecutes = this.generateDatadrivenExecutes(root, ssi);
    _builder.append(_generateDatadrivenExecutes, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#else");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("uint32 loopCounter = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("while(!(");
    String _name_17 = ssc.getName();
    _builder.append(_name_17, "		");
    _builder.append("Inst.shutdownRequest)){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (etTimer_executeNeeded()){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("etMessageService_execute(&msgService_Thread1);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    StringConcatenation _generateDatadrivenExecutes_1 = this.generateDatadrivenExecutes(root, ssi);
    _builder.append(_generateDatadrivenExecutes_1, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("etLogger_logInfo(\"Execute\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (loopCounter++ > ET_RUNTIME_MAXLOOP){");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#endif");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_18 = ssc.getName();
    _builder.append(_name_18, "");
    _builder.append("_stop(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"stop\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etLogger_logInfoF(\"%s_stop\", ");
    String _name_19 = ssc.getName();
    _builder.append(_name_19, "	");
    _builder.append("Inst.name);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_20 = ssc.getName();
    _builder.append(_name_20, "");
    _builder.append("_destroy(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"destroy\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etLogger_logInfoF(\"%s_destroy\", ");
    String _name_21 = ssc.getName();
    _builder.append(_name_21, "	");
    _builder.append("Inst.name);");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
      Iterable<ActorInstance> _reverseView = ListExtensions.<ActorInstance>reverseView(_allContainedInstances);
      for(final ActorInstance ai : _reverseView) {
        {
          ActorClass _actorClass = ai.getActorClass();
          EList<StandardOperation> _operations = _actorClass.getOperations();
          final Function1<StandardOperation,Boolean> _function = new Function1<StandardOperation,Boolean>() {
              public Boolean apply(final StandardOperation op) {
                boolean _isDestructor = op.isDestructor();
                return ((Boolean)_isDestructor);
              }
            };
          Iterable<StandardOperation> _filter = IterableExtensions.<StandardOperation>filter(_operations, _function);
          boolean _isEmpty = IterableExtensions.isEmpty(_filter);
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          if (_operator_not) {
            _builder.append("\t");
            ActorClass _actorClass_1 = ai.getActorClass();
            String _name_22 = _actorClass_1.getName();
            _builder.append(_name_22, "	");
            _builder.append("_dtor(&");
            String _path = ai.getPath();
            String _pathName = this.roomExt.getPathName(_path);
            _builder.append(_pathName, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_23 = ssc.getName();
    _builder.append(_name_23, "");
    _builder.append("_shutdown(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"SubSys\", \"shutdown\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("etLogger_logInfoF(\"%s_shutdown\", ");
    String _name_24 = ssc.getName();
    _builder.append(_name_24, "	");
    _builder.append("Inst.name);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _name_25 = ssc.getName();
    _builder.append(_name_25, "	");
    _builder.append("Inst.shutdownRequest = 1;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_26 = ssc.getName();
    _builder.append(_name_26, "");
    _builder.append("_constructActorInstances(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
    String _name_27 = ssc.getName();
    _builder.append(_name_27, "	");
    _builder.append("\", \"constructActorInstances\")");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
      for(final ActorInstance ai_1 : _allContainedInstances_1) {
        {
          ActorClass _actorClass_2 = ai_1.getActorClass();
          EList<StandardOperation> _operations_1 = _actorClass_2.getOperations();
          final Function1<StandardOperation,Boolean> _function_1 = new Function1<StandardOperation,Boolean>() {
              public Boolean apply(final StandardOperation op) {
                boolean _isConstructor = RoomHelpers.isConstructor(op);
                return ((Boolean)_isConstructor);
              }
            };
          Iterable<StandardOperation> _filter_1 = IterableExtensions.<StandardOperation>filter(_operations_1, _function_1);
          boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter_1);
          boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_1);
          if (_operator_not_1) {
            _builder.append("\t");
            ActorClass _actorClass_3 = ai_1.getActorClass();
            String _name_28 = _actorClass_3.getName();
            _builder.append(_name_28, "	");
            _builder.append("_ctor(&");
            String _path_1 = ai_1.getPath();
            String _pathName_1 = this.roomExt.getPathName(_path_1);
            _builder.append(_pathName_1, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("void ");
    String _name_29 = ssc.getName();
    _builder.append(_name_29, "");
    _builder.append("_initActorInstances(void){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
    String _name_30 = ssc.getName();
    _builder.append(_name_30, "	");
    _builder.append("\", \"initActorInstances\")");
    _builder.newLineIfNotEmpty();
    {
      EList<ActorInstance> _allContainedInstances_2 = ssi.getAllContainedInstances();
      for(final ActorInstance ai_2 : _allContainedInstances_2) {
        _builder.append("\t");
        ActorClass _actorClass_4 = ai_2.getActorClass();
        String _name_31 = _actorClass_4.getName();
        _builder.append(_name_31, "	");
        _builder.append("_init(&");
        String _path_2 = ai_2.getPath();
        String _pathName_2 = this.roomExt.getPathName(_path_2);
        _builder.append(_pathName_2, "	");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  private StringConcatenation generateInstanceFile(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Instance File of SubSystemClass ");
    String _name = ssc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* - instantiation of all actor instances and port instances");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* - configuration of data and connection of ports");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"messaging/etMessageService.h\"");
    _builder.newLine();
    _builder.append("#include \"platform/etMemory.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* instantiation of message services */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* MessageService for Thread1 */");
    _builder.newLine();
    _builder.append("static uint8 msgBuffer_Thread1[MESSAGE_POOL_MAX*MESSAGE_BLOCK_SIZE];");
    _builder.newLine();
    _builder.append("static etMessageService msgService_Thread1;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* include all used ActorClasses */");
    _builder.newLine();
    {
      EList<ActorClass> _usedActorClasses = root.getUsedActorClasses();
      for(final ActorClass actorClass : _usedActorClasses) {
        _builder.append("#include \"");
        String _name_1 = actorClass.getName();
        _builder.append(_name_1, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/* include all used ProtcolClasses */");
    _builder.newLine();
    {
      EList<ProtocolClass> _usedProtocolClasses = root.getUsedProtocolClasses();
      for(final ProtocolClass protocolClass : _usedProtocolClasses) {
        _builder.append("#include \"");
        String _name_2 = protocolClass.getName();
        _builder.append(_name_2, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* declarations of all ActorClass instances (const and variable structs) */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/* forward declaration of variable actor structs */");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
      for(final ActorInstance ai : _allContainedInstances) {
        _builder.append("static ");
        ActorClass _actorClass = ai.getActorClass();
        String _name_3 = _actorClass.getName();
        _builder.append(_name_3, "");
        _builder.append(" ");
        String _path = ai.getPath();
        String _pathName = this.roomExt.getPathName(_path);
        _builder.append(_pathName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/* forward declaration of variable port structs */\t\t");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
      for(final ActorInstance ai_1 : _allContainedInstances_1) {
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
          boolean _isEmpty = _orderedIfItemInstances.isEmpty();
          if (_isEmpty) {
            _builder.append("/*nothing to do */");
            _builder.newLine();
          } else {
            {
              EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai_1.getOrderedIfItemInstances();
              for(final InterfaceItemInstance pi : _orderedIfItemInstances_1) {
                {
                  InterfaceItem _interfaceItem = pi.getInterfaceItem();
                  ProtocolClass _protocol = _interfaceItem.getProtocol();
                  boolean _isConjugated = this.roomExt.isConjugated(pi);
                  PortClass _portClass = this.roomExt.getPortClass(_protocol, _isConjugated);
                  boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_portClass, null);
                  if (_operator_notEquals) {
                    {
                      InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
                      ProtocolClass _protocol_1 = _interfaceItem_1.getProtocol();
                      boolean _isConjugated_1 = this.roomExt.isConjugated(pi);
                      PortClass _portClass_1 = this.roomExt.getPortClass(_protocol_1, _isConjugated_1);
                      EList<Attribute> _attributes = _portClass_1.getAttributes();
                      boolean _isEmpty_1 = _attributes.isEmpty();
                      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
                      if (_operator_not) {
                        {
                          boolean _isReplicated = pi.isReplicated();
                          if (_isReplicated) {
                            _builder.append("static ");
                            InterfaceItem _interfaceItem_2 = pi.getInterfaceItem();
                            ProtocolClass _protocol_2 = _interfaceItem_2.getProtocol();
                            boolean _isConjugated_2 = this.roomExt.isConjugated(pi);
                            String _portClassName = this.roomExt.getPortClassName(_protocol_2, _isConjugated_2);
                            _builder.append(_portClassName, "");
                            _builder.append("_var ");
                            String _path_1 = pi.getPath();
                            String _pathName_1 = this.roomExt.getPathName(_path_1);
                            _builder.append(_pathName_1, "");
                            _builder.append("_var[");
                            EList<InterfaceItemInstance> _peers = pi.getPeers();
                            int _size = _peers.size();
                            _builder.append(_size, "");
                            _builder.append("];");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("static ");
                            InterfaceItem _interfaceItem_3 = pi.getInterfaceItem();
                            ProtocolClass _protocol_3 = _interfaceItem_3.getProtocol();
                            boolean _isConjugated_3 = this.roomExt.isConjugated(pi);
                            String _portClassName_1 = this.roomExt.getPortClassName(_protocol_3, _isConjugated_3);
                            _builder.append(_portClassName_1, "");
                            _builder.append("_var ");
                            String _path_2 = pi.getPath();
                            String _pathName_2 = this.roomExt.getPathName(_path_2);
                            _builder.append(_pathName_2, "");
                            _builder.append("_var;");
                            _builder.newLineIfNotEmpty();
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
      }
    }
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances_2 = ssi.getAllContainedInstances();
      for(final ActorInstance ai_2 : _allContainedInstances_2) {
        _builder.newLine();
        _builder.append("/* instance ");
        String _path_3 = ai_2.getPath();
        String _pathName_3 = this.roomExt.getPathName(_path_3);
        _builder.append(_pathName_3, "");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances_2 = ai_2.getOrderedIfItemInstances();
          boolean _isEmpty_2 = _orderedIfItemInstances_2.isEmpty();
          if (_isEmpty_2) {
            _builder.append("/* no ports/saps/services - nothing to initialize statically */");
            _builder.newLine();
          } else {
            StringConcatenation _genActorInstanceInitializer = this.genActorInstanceInitializer(root, ai_2);
            _builder.append(_genActorInstanceInitializer, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  private StringConcatenation genActorInstanceInitializer(final Root root, final ActorInstance ai) {
    StringConcatenation _xblockexpression = null;
    {
      String _path = ai.getPath();
      String _pathName = this.roomExt.getPathName(_path);
      String instName = _pathName;
      ArrayList<InterfaceItemInstance> _arrayList = new ArrayList<InterfaceItemInstance>();
      ArrayList<InterfaceItemInstance> replPorts = _arrayList;
      EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
      final Function1<InterfaceItemInstance,Boolean> _function = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance e) {
            boolean _isReplicated = e.isReplicated();
            return ((Boolean)_isReplicated);
          }
        };
      Iterable<InterfaceItemInstance> _filter = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances, _function);
      CollectionExtensions.<InterfaceItemInstance>addAll(replPorts, _filter);
      final Function1<InterfaceItemInstance,Boolean> _function_1 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance e) {
            EList<InterfaceItemInstance> _peers = e.getPeers();
            boolean _isEmpty = _peers.isEmpty();
            boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
            return ((Boolean)_operator_not);
          }
        };
      InterfaceItemInstance _findFirst = IterableExtensions.<InterfaceItemInstance>findFirst(replPorts, _function_1);
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_findFirst, null);
      boolean haveReplSubPorts = _operator_notEquals;
      EList<InterfaceItemInstance> _orderedIfItemInstances_1 = ai.getOrderedIfItemInstances();
      final Function1<InterfaceItemInstance,Boolean> _function_2 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance e) {
            boolean _isSimple = e.isSimple();
            return ((Boolean)_isSimple);
          }
        };
      Iterable<InterfaceItemInstance> _filter_1 = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances_1, _function_2);
      Iterable<InterfaceItemInstance> simplePorts = _filter_1;
      ArrayList<InterfaceItemInstance> _arrayList_1 = new ArrayList<InterfaceItemInstance>();
      ArrayList<InterfaceItemInstance> eventPorts = _arrayList_1;
      final Function1<InterfaceItemInstance,Boolean> _function_3 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance p) {
            InterfaceItem _interfaceItem = p.getInterfaceItem();
            ProtocolClass _protocol = _interfaceItem.getProtocol();
            CommunicationType _commType = _protocol.getCommType();
            boolean _operator_equals = ObjectExtensions.operator_equals(_commType, CommunicationType.EVENT_DRIVEN);
            return ((Boolean)_operator_equals);
          }
        };
      Iterable<InterfaceItemInstance> _filter_2 = IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_3);
      Iterable<InterfaceItemInstance> _union = this.roomExt.<InterfaceItemInstance>union(_filter_2, replPorts);
      CollectionExtensions.<InterfaceItemInstance>addAll(eventPorts, _union);
      final Function1<InterfaceItemInstance,Boolean> _function_4 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance p) {
            InterfaceItem _interfaceItem = p.getInterfaceItem();
            ProtocolClass _protocol = _interfaceItem.getProtocol();
            CommunicationType _commType = _protocol.getCommType();
            boolean _operator_equals = ObjectExtensions.operator_equals(_commType, CommunicationType.DATA_DRIVEN);
            return ((Boolean)_operator_equals);
          }
        };
      Iterable<InterfaceItemInstance> _filter_3 = IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_4);
      Iterable<InterfaceItemInstance> dataPorts = _filter_3;
      final Function1<InterfaceItemInstance,Boolean> _function_5 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance p) {
            boolean _operator_and = false;
            if (!(p instanceof PortInstance)) {
              _operator_and = false;
            } else {
              Port _port = ((PortInstance) p).getPort();
              boolean _isConjugated = _port.isConjugated();
              boolean _operator_not = BooleanExtensions.operator_not(_isConjugated);
              _operator_and = BooleanExtensions.operator_and((p instanceof PortInstance), _operator_not);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<InterfaceItemInstance> _filter_4 = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_5);
      Iterable<InterfaceItemInstance> recvPorts = _filter_4;
      final Function1<InterfaceItemInstance,Boolean> _function_6 = new Function1<InterfaceItemInstance,Boolean>() {
          public Boolean apply(final InterfaceItemInstance p) {
            boolean _operator_and = false;
            if (!(p instanceof PortInstance)) {
              _operator_and = false;
            } else {
              Port _port = ((PortInstance) p).getPort();
              boolean _isConjugated = _port.isConjugated();
              _operator_and = BooleanExtensions.operator_and((p instanceof PortInstance), _isConjugated);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<InterfaceItemInstance> _filter_5 = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_6);
      Iterable<InterfaceItemInstance> sendPorts = _filter_5;
      HashMap<InterfaceItemInstance,Integer> _hashMap = new HashMap<InterfaceItemInstance,Integer>();
      HashMap<InterfaceItemInstance,Integer> offsets = _hashMap;
      int offset = 0;
      for (final InterfaceItemInstance p : replPorts) {
        {
          offsets.put(p, ((Integer)offset));
          EList<InterfaceItemInstance> _peers = p.getPeers();
          int _size = _peers.size();
          int _operator_plus = IntegerExtensions.operator_plus(((Integer)offset), ((Integer)_size));
          offset = _operator_plus;
        }
      }
      String _xifexpression = null;
      if (haveReplSubPorts) {
        String _operator_plus_1 = StringExtensions.operator_plus(instName, "_repl_sub_ports");
        _xifexpression = _operator_plus_1;
      } else {
        _xifexpression = "NULL";
      }
      String replSubPortsArray = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      {
        if (haveReplSubPorts) {
          _builder.append("static const etReplSubPort ");
          _builder.append(replSubPortsArray, "");
          _builder.append("[");
          _builder.append(offset, "");
          _builder.append("] = {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("/* Replicated Sub Ports: {varData, msgService, peerAddress, localId, index} */");
          _builder.newLine();
          {
            boolean hasAnyElements = false;
            for(final InterfaceItemInstance pi : replPorts) {
              if (!hasAnyElements) {
                hasAnyElements = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              String _genReplSubPortInitializers = this.genReplSubPortInitializers(root, ai, pi);
              _builder.append(_genReplSubPortInitializers, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        }
      }
      {
        boolean _operator_and = false;
        boolean _isEmpty = eventPorts.isEmpty();
        if (!_isEmpty) {
          _operator_and = false;
        } else {
          boolean _isEmpty_1 = IterableExtensions.isEmpty(recvPorts);
          _operator_and = BooleanExtensions.operator_and(_isEmpty, _isEmpty_1);
        }
        boolean _operator_not = BooleanExtensions.operator_not(_operator_and);
        if (_operator_not) {
          _builder.append("static const ");
          ActorClass _actorClass = ai.getActorClass();
          String _name = _actorClass.getName();
          _builder.append(_name, "");
          _builder.append("_const ");
          _builder.append(instName, "");
          _builder.append("_const = {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("/* Ports: {varData, msgService, peerAddress, localId} */");
          _builder.newLine();
          {
            boolean hasAnyElements_1 = false;
            for(final InterfaceItemInstance pi_1 : eventPorts) {
              if (!hasAnyElements_1) {
                hasAnyElements_1 = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              {
                boolean _isSimple = pi_1.isSimple();
                if (_isSimple) {
                  _builder.append("\t");
                  String _genPortInitializer = this.genPortInitializer(root, ai, pi_1);
                  _builder.append(_genPortInitializer, "	");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("\t");
                  _builder.append("{");
                  EList<InterfaceItemInstance> _peers_1 = pi_1.getPeers();
                  int _size_1 = _peers_1.size();
                  _builder.append(_size_1, "	");
                  _builder.append(", ");
                  _builder.append(replSubPortsArray, "	");
                  _builder.append("+");
                  Integer _get = offsets.get(pi_1);
                  _builder.append(_get, "	");
                  _builder.append("}");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append("\t");
          {
            boolean _operator_and_1 = false;
            boolean _isEmpty_2 = eventPorts.isEmpty();
            boolean _operator_not_1 = BooleanExtensions.operator_not(_isEmpty_2);
            if (!_operator_not_1) {
              _operator_and_1 = false;
            } else {
              boolean _isEmpty_3 = IterableExtensions.isEmpty(recvPorts);
              boolean _operator_not_2 = BooleanExtensions.operator_not(_isEmpty_3);
              _operator_and_1 = BooleanExtensions.operator_and(_operator_not_1, _operator_not_2);
            }
            if (_operator_and_1) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* data receive ports */");
          _builder.newLine();
          {
            boolean hasAnyElements_2 = false;
            for(final InterfaceItemInstance pi_2 : recvPorts) {
              if (!hasAnyElements_2) {
                hasAnyElements_2 = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              String _genRecvPortInitializer = this.genRecvPortInitializer(root, ai, pi_2);
              _builder.append(_genRecvPortInitializer, "	");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
          _builder.append("static ");
          ActorClass _actorClass_1 = ai.getActorClass();
          String _name_1 = _actorClass_1.getName();
          _builder.append(_name_1, "");
          _builder.append(" ");
          _builder.append(instName, "");
          _builder.append(" = {&");
          _builder.append(instName, "");
          _builder.append("_const};");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String genPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      EList<InterfaceItemInstance> _peers = pi.getPeers();
      boolean _isEmpty = _peers.isEmpty();
      if (_isEmpty) {
        _xifexpression = "NULL";
      } else {
        ActorClass _actorClass = ai.getActorClass();
        String _name = _actorClass.getName();
        String _operator_plus = StringExtensions.operator_plus(_name, "_receiveMessage");
        _xifexpression = _operator_plus;
      }
      String recvMsg = _xifexpression;
      int _xifexpression_1 = (int) 0;
      EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
      boolean _isEmpty_1 = _peers_1.isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = 0;
      } else {
        EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
        InterfaceItemInstance _get = _peers_2.get(0);
        int _objId = _get.getObjId();
        _xifexpression_1 = _objId;
      }
      int objId = _xifexpression_1;
      int _xifexpression_2 = (int) 0;
      EList<InterfaceItemInstance> _peers_3 = pi.getPeers();
      boolean _isEmpty_2 = _peers_3.isEmpty();
      if (_isEmpty_2) {
        _xifexpression_2 = 0;
      } else {
        EList<InterfaceItemInstance> _peers_4 = pi.getPeers();
        InterfaceItemInstance _get_1 = _peers_4.get(0);
        EList<InterfaceItemInstance> _peers_5 = _get_1.getPeers();
        int _indexOf = _peers_5.indexOf(pi);
        _xifexpression_2 = _indexOf;
      }
      int idx = _xifexpression_2;
      String _interfaceItemInstanceData = this.getInterfaceItemInstanceData(pi);
      String _operator_plus_1 = StringExtensions.operator_plus("{", _interfaceItemInstanceData);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ",");
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "&msgService_Thread1, ");
      int _operator_plus_4 = IntegerExtensions.operator_plus(((Integer)objId), ((Integer)idx));
      String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_3, ((Integer)_operator_plus_4));
      String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, ", ");
      ExpandedActorClass _expandedActorClass = root.getExpandedActorClass(ai);
      InterfaceItem _interfaceItem = pi.getInterfaceItem();
      int _interfaceItemLocalId = _expandedActorClass.getInterfaceItemLocalId(_interfaceItem);
      int _operator_plus_7 = IntegerExtensions.operator_plus(((Integer)_interfaceItemLocalId), ((Integer)1));
      String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_6, ((Integer)_operator_plus_7));
      String _operator_plus_9 = StringExtensions.operator_plus(_operator_plus_8, "} /* Port ");
      String _name_1 = pi.getName();
      String _operator_plus_10 = StringExtensions.operator_plus(_operator_plus_9, _name_1);
      String _operator_plus_11 = StringExtensions.operator_plus(_operator_plus_10, " */");
      _xblockexpression = (_operator_plus_11);
    }
    return _xblockexpression;
  }
  
  private String getInterfaceItemInstanceData(final InterfaceItemInstance pi) {
      InterfaceItem _interfaceItem = pi.getInterfaceItem();
      ProtocolClass _protocol = _interfaceItem.getProtocol();
      boolean _isConjugated = this.roomExt.isConjugated(pi);
      PortClass _portClass = this.roomExt.getPortClass(_protocol, _isConjugated);
      boolean _operator_equals = ObjectExtensions.operator_equals(_portClass, null);
      if (_operator_equals) {
        return "0";
      }
      InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
      ProtocolClass _protocol_1 = _interfaceItem_1.getProtocol();
      boolean _isConjugated_1 = this.roomExt.isConjugated(pi);
      PortClass _portClass_1 = this.roomExt.getPortClass(_protocol_1, _isConjugated_1);
      EList<Attribute> _attributes = _portClass_1.getAttributes();
      boolean _isEmpty = _attributes.isEmpty();
      if (_isEmpty) {
        return "0";
      } else {
        String _path = pi.getPath();
        String _pathName = this.roomExt.getPathName(_path);
        String _operator_plus = StringExtensions.operator_plus("&", _pathName);
        String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "_var");
        return _operator_plus_1;
      }
  }
  
  private String genRecvPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      EList<InterfaceItemInstance> _peers = pi.getPeers();
      boolean _isEmpty = _peers.isEmpty();
      if (_isEmpty) {
        return "{NULL}";
      }
      EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
      InterfaceItemInstance _get = _peers_1.get(0);
      InterfaceItemInstance peer = _get;
      EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
      InterfaceItemInstance _get_1 = _peers_2.get(0);
      EObject _eContainer = _get_1.eContainer();
      ActorInstance peerInst = ((ActorInstance) _eContainer);
      String _path = peerInst.getPath();
      String _pathName = this.roomExt.getPathName(_path);
      String instName = _pathName;
      String _operator_plus = StringExtensions.operator_plus("{&", instName);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".");
      String _name = peer.getName();
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _name);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "}");
      _xblockexpression = (_operator_plus_3);
    }
    return _xblockexpression;
  }
  
  private String genReplSubPortInitializers(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
      String result = "";
      EList<InterfaceItemInstance> _peers = pi.getPeers();
      for (final InterfaceItemInstance p : _peers) {
        {
          EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
          int _indexOf = _peers_1.indexOf(p);
          int idx = _indexOf;
          String _xifexpression = null;
          EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
          int _size = _peers_2.size();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_size), ((Integer)1));
          boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(((Integer)idx), ((Integer)_operator_minus));
          if (_operator_lessThan) {
            _xifexpression = ",";
          } else {
            _xifexpression = "";
          }
          String comma = _xifexpression;
          String _interfaceItemInstanceData = this.getInterfaceItemInstanceData(pi);
          String iiiD = _interfaceItemInstanceData;
          String _xifexpression_1 = null;
          boolean _equals = iiiD.equals("0");
          if (_equals) {
            String _operator_plus = StringExtensions.operator_plus(iiiD, ",");
            _xifexpression_1 = _operator_plus;
          } else {
            String _operator_plus_1 = StringExtensions.operator_plus(iiiD, "[");
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ((Integer)idx));
            String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "],");
            _xifexpression_1 = _operator_plus_3;
          }
          iiiD = _xifexpression_1;
          String _operator_plus_4 = StringExtensions.operator_plus(result, "{");
          String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, iiiD);
          String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, "&msgService_Thread1, ");
          int _objId = p.getObjId();
          String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, ((Integer)_objId));
          String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, ", ");
          ExpandedActorClass _expandedActorClass = root.getExpandedActorClass(ai);
          InterfaceItem _interfaceItem = pi.getInterfaceItem();
          int _interfaceItemLocalId = _expandedActorClass.getInterfaceItemLocalId(_interfaceItem);
          int _operator_plus_9 = IntegerExtensions.operator_plus(((Integer)_interfaceItemLocalId), ((Integer)1));
          String _operator_plus_10 = StringExtensions.operator_plus(_operator_plus_8, ((Integer)_operator_plus_9));
          String _operator_plus_11 = StringExtensions.operator_plus(_operator_plus_10, ", ");
          String _operator_plus_12 = StringExtensions.operator_plus(_operator_plus_11, ((Integer)idx));
          String _operator_plus_13 = StringExtensions.operator_plus(_operator_plus_12, "}");
          String _operator_plus_14 = StringExtensions.operator_plus(_operator_plus_13, comma);
          String _operator_plus_15 = StringExtensions.operator_plus(_operator_plus_14, " /* Repl Sub Port ");
          String _name = pi.getName();
          String _operator_plus_16 = StringExtensions.operator_plus(_operator_plus_15, _name);
          String _operator_plus_17 = StringExtensions.operator_plus(_operator_plus_16, " idx +");
          String _operator_plus_18 = StringExtensions.operator_plus(_operator_plus_17, ((Integer)idx));
          String _operator_plus_19 = StringExtensions.operator_plus(_operator_plus_18, "*/\n");
          result = _operator_plus_19;
        }
      }
      return result;
  }
  
  private StringConcatenation generateDispatcherFile(final Root root, final SubSystemInstance ssi, final SubSystemClass ssc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author generated by eTrice");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Dispatcher File of SubSystemClass ");
    String _name = ssc.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* - one generated dispatcher for each MessageService (Thread)");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"messaging/etMessageReceiver.h\"");
    _builder.newLine();
    _builder.append("#include \"debugging/etLogger.h\"");
    _builder.newLine();
    _builder.append("#include \"debugging/etMSCLogger.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("static void MsgDispatcher_Thread1_receiveMessage(const etMessage* msg){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"MsgDispatcher_Thread1\", \"receiveMessage\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch(msg->address){");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
      for(final ActorInstance ai : _allContainedInstances) {
        _builder.append("\t\t");
        _builder.append("/* interface items of ");
        String _path = ai.getPath();
        _builder.append(_path, "		");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        {
          EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
          final Function1<InterfaceItemInstance,Boolean> _function = new Function1<InterfaceItemInstance,Boolean>() {
              public Boolean apply(final InterfaceItemInstance p) {
                InterfaceItem _interfaceItem = p.getInterfaceItem();
                ProtocolClass _protocol = _interfaceItem.getProtocol();
                CommunicationType _commType = _protocol.getCommType();
                boolean _operator_equals = ObjectExtensions.operator_equals(_commType, CommunicationType.EVENT_DRIVEN);
                return ((Boolean)_operator_equals);
              }
            };
          Iterable<InterfaceItemInstance> _filter = IterableExtensions.<InterfaceItemInstance>filter(_orderedIfItemInstances, _function);
          for(final InterfaceItemInstance pi : _filter) {
            {
              boolean _isReplicated = pi.isReplicated();
              if (_isReplicated) {
                {
                  EList<InterfaceItemInstance> _peers = pi.getPeers();
                  for(final InterfaceItemInstance peer : _peers) {
                    _builder.append("\t\t");
                    _builder.append("case ");
                    int _objId = pi.getObjId();
                    EList<InterfaceItemInstance> _peers_1 = pi.getPeers();
                    int _indexOf = _peers_1.indexOf(peer);
                    int _operator_plus = IntegerExtensions.operator_plus(((Integer)_objId), ((Integer)_indexOf));
                    _builder.append(_operator_plus, "		");
                    _builder.append(":");
                    _builder.newLineIfNotEmpty();
                    {
                      InterfaceItem _interfaceItem = pi.getInterfaceItem();
                      ProtocolClass _protocol = _interfaceItem.getProtocol();
                      boolean _isConjugated = this.roomExt.isConjugated(pi);
                      boolean _handlesReceive = this.roomExt.handlesReceive(_protocol, _isConjugated);
                      if (_handlesReceive) {
                        _builder.append("\t\t");
                        _builder.append("switch (msg->evtID){");
                        _builder.newLine();
                        {
                          InterfaceItem _interfaceItem_1 = pi.getInterfaceItem();
                          ProtocolClass _protocol_1 = _interfaceItem_1.getProtocol();
                          boolean _isConjugated_1 = this.roomExt.isConjugated(pi);
                          List<MessageHandler> _receiveHandlers = this.roomExt.getReceiveHandlers(_protocol_1, _isConjugated_1);
                          for(final MessageHandler h : _receiveHandlers) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("case ");
                            InterfaceItem _interfaceItem_2 = pi.getInterfaceItem();
                            ProtocolClass _protocol_2 = _interfaceItem_2.getProtocol();
                            String _name_1 = _protocol_2.getName();
                            _builder.append(_name_1, "			");
                            _builder.append("_");
                            Message _msg = h.getMsg();
                            String _codeName = this.roomExt.getCodeName(_msg);
                            _builder.append(_codeName, "			");
                            _builder.append(":");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            InterfaceItem _interfaceItem_3 = pi.getInterfaceItem();
                            ProtocolClass _protocol_3 = _interfaceItem_3.getProtocol();
                            boolean _isConjugated_2 = this.roomExt.isConjugated(pi);
                            String _portClassName = this.roomExt.getPortClassName(_protocol_3, _isConjugated_2);
                            _builder.append(_portClassName, "				");
                            _builder.append("_");
                            Message _msg_1 = h.getMsg();
                            String _name_2 = _msg_1.getName();
                            _builder.append(_name_2, "				");
                            _builder.append("_receiveHandler((etPort *)&");
                            String _path_1 = ai.getPath();
                            String _pathName = this.roomExt.getPathName(_path_1);
                            _builder.append(_pathName, "				");
                            _builder.append("_const.");
                            String _name_3 = pi.getName();
                            _builder.append(_name_3, "				");
                            _builder.append(".ports[");
                            EList<InterfaceItemInstance> _peers_2 = pi.getPeers();
                            int _indexOf_1 = _peers_2.indexOf(peer);
                            _builder.append(_indexOf_1, "				");
                            _builder.append("],msg,(void*)&");
                            String _path_2 = ai.getPath();
                            String _pathName_1 = this.roomExt.getPathName(_path_2);
                            _builder.append(_pathName_1, "				");
                            _builder.append(",");
                            ActorClass _actorClass = ai.getActorClass();
                            String _name_4 = _actorClass.getName();
                            _builder.append(_name_4, "				");
                            _builder.append("_receiveMessage);");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("break;");
                            _builder.newLine();
                          }
                        }
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("default: ");
                        ActorClass _actorClass_1 = ai.getActorClass();
                        String _name_5 = _actorClass_1.getName();
                        _builder.append(_name_5, "			");
                        _builder.append("_receiveMessage((void*)&");
                        String _path_3 = ai.getPath();
                        String _pathName_2 = this.roomExt.getPathName(_path_3);
                        _builder.append(_pathName_2, "			");
                        _builder.append(",(etPort*)&");
                        String _path_4 = ai.getPath();
                        String _pathName_3 = this.roomExt.getPathName(_path_4);
                        _builder.append(_pathName_3, "			");
                        _builder.append("_const.");
                        String _name_6 = pi.getName();
                        _builder.append(_name_6, "			");
                        _builder.append(".ports[");
                        EList<InterfaceItemInstance> _peers_3 = pi.getPeers();
                        int _indexOf_2 = _peers_3.indexOf(peer);
                        _builder.append(_indexOf_2, "			");
                        _builder.append("], msg);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("break;");
                        _builder.newLine();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        _builder.append("}\t\t\t\t\t\t\t\t\t\t");
                        _builder.newLine();
                      } else {
                        _builder.append("\t\t");
                        ActorClass _actorClass_2 = ai.getActorClass();
                        String _name_7 = _actorClass_2.getName();
                        _builder.append(_name_7, "		");
                        _builder.append("_receiveMessage((void*)&");
                        String _path_5 = ai.getPath();
                        String _pathName_4 = this.roomExt.getPathName(_path_5);
                        _builder.append(_pathName_4, "		");
                        _builder.append(",(etPort*)&");
                        String _path_6 = ai.getPath();
                        String _pathName_5 = this.roomExt.getPathName(_path_6);
                        _builder.append(_pathName_5, "		");
                        _builder.append("_const.");
                        String _name_8 = pi.getName();
                        _builder.append(_name_8, "		");
                        _builder.append(".ports[");
                        EList<InterfaceItemInstance> _peers_4 = pi.getPeers();
                        int _indexOf_3 = _peers_4.indexOf(peer);
                        _builder.append(_indexOf_3, "		");
                        _builder.append("], msg);");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("break;");
                    _builder.newLine();
                  }
                }
              } else {
                _builder.append("\t\t");
                _builder.append("case ");
                int _objId_1 = pi.getObjId();
                _builder.append(_objId_1, "		");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
                {
                  InterfaceItem _interfaceItem_4 = pi.getInterfaceItem();
                  ProtocolClass _protocol_4 = _interfaceItem_4.getProtocol();
                  boolean _isConjugated_3 = this.roomExt.isConjugated(pi);
                  boolean _handlesReceive_1 = this.roomExt.handlesReceive(_protocol_4, _isConjugated_3);
                  if (_handlesReceive_1) {
                    _builder.append("\t\t");
                    _builder.append("switch (msg->evtID){");
                    _builder.newLine();
                    {
                      InterfaceItem _interfaceItem_5 = pi.getInterfaceItem();
                      ProtocolClass _protocol_5 = _interfaceItem_5.getProtocol();
                      boolean _isConjugated_4 = this.roomExt.isConjugated(pi);
                      List<MessageHandler> _receiveHandlers_1 = this.roomExt.getReceiveHandlers(_protocol_5, _isConjugated_4);
                      for(final MessageHandler h_1 : _receiveHandlers_1) {
                        _builder.append("\t\t");
                        _builder.append("case ");
                        InterfaceItem _interfaceItem_6 = pi.getInterfaceItem();
                        ProtocolClass _protocol_6 = _interfaceItem_6.getProtocol();
                        String _name_9 = _protocol_6.getName();
                        _builder.append(_name_9, "		");
                        _builder.append("_");
                        Message _msg_2 = h_1.getMsg();
                        String _codeName_1 = this.roomExt.getCodeName(_msg_2);
                        _builder.append(_codeName_1, "		");
                        _builder.append(":");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("\t");
                        InterfaceItem _interfaceItem_7 = pi.getInterfaceItem();
                        ProtocolClass _protocol_7 = _interfaceItem_7.getProtocol();
                        boolean _isConjugated_5 = this.roomExt.isConjugated(pi);
                        String _portClassName_1 = this.roomExt.getPortClassName(_protocol_7, _isConjugated_5);
                        _builder.append(_portClassName_1, "			");
                        _builder.append("_");
                        Message _msg_3 = h_1.getMsg();
                        String _name_10 = _msg_3.getName();
                        _builder.append(_name_10, "			");
                        _builder.append("_receiveHandler((etPort *)&");
                        String _path_7 = ai.getPath();
                        String _pathName_6 = this.roomExt.getPathName(_path_7);
                        _builder.append(_pathName_6, "			");
                        _builder.append("_const.");
                        String _name_11 = pi.getName();
                        _builder.append(_name_11, "			");
                        _builder.append(",msg,(void*)&");
                        String _path_8 = ai.getPath();
                        String _pathName_7 = this.roomExt.getPathName(_path_8);
                        _builder.append(_pathName_7, "			");
                        _builder.append(",");
                        ActorClass _actorClass_3 = ai.getActorClass();
                        String _name_12 = _actorClass_3.getName();
                        _builder.append(_name_12, "			");
                        _builder.append("_receiveMessage);");
                        _builder.newLineIfNotEmpty();
                        _builder.append("\t\t");
                        _builder.append("break;");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("default: ");
                    ActorClass _actorClass_4 = ai.getActorClass();
                    String _name_13 = _actorClass_4.getName();
                    _builder.append(_name_13, "		");
                    _builder.append("_receiveMessage((void*)&");
                    String _path_9 = ai.getPath();
                    String _pathName_8 = this.roomExt.getPathName(_path_9);
                    _builder.append(_pathName_8, "		");
                    _builder.append(",(etPort*)&");
                    String _path_10 = ai.getPath();
                    String _pathName_9 = this.roomExt.getPathName(_path_10);
                    _builder.append(_pathName_9, "		");
                    _builder.append("_const.");
                    String _name_14 = pi.getName();
                    _builder.append(_name_14, "		");
                    _builder.append(", msg);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t");
                    _builder.append("break;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  } else {
                    _builder.append("\t\t");
                    ActorClass _actorClass_5 = ai.getActorClass();
                    String _name_15 = _actorClass_5.getName();
                    _builder.append(_name_15, "		");
                    _builder.append("_receiveMessage((void*)&");
                    String _path_11 = ai.getPath();
                    String _pathName_10 = this.roomExt.getPathName(_path_11);
                    _builder.append(_pathName_10, "		");
                    _builder.append(",(etPort*)&");
                    String _path_12 = ai.getPath();
                    String _pathName_11 = this.roomExt.getPathName(_path_12);
                    _builder.append(_pathName_11, "		");
                    _builder.append("_const.");
                    String _name_16 = pi.getName();
                    _builder.append(_name_16, "		");
                    _builder.append(", msg);");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("break;");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("etLogger_logErrorF(\"MessageService_Thread1_receiveMessage: address %d does not exist \", msg->address);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private StringConcatenation generateDatadrivenExecutes(final Root root, final SubSystemInstance ssi) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
      for(final ActorInstance ai : _allContainedInstances) {
        {
          boolean _operator_or = false;
          ActorClass _actorClass = ai.getActorClass();
          ActorCommunicationType _commType = _actorClass.getCommType();
          boolean _operator_equals = ObjectExtensions.operator_equals(_commType, ActorCommunicationType.ASYNCHRONOUS);
          if (_operator_equals) {
            _operator_or = true;
          } else {
            ActorClass _actorClass_1 = ai.getActorClass();
            ActorCommunicationType _commType_1 = _actorClass_1.getCommType();
            boolean _operator_equals_1 = ObjectExtensions.operator_equals(_commType_1, ActorCommunicationType.DATA_DRIVEN);
            _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
          }
          if (_operator_or) {
            ActorClass _actorClass_2 = ai.getActorClass();
            String _name = _actorClass_2.getName();
            _builder.append(_name, "");
            _builder.append("_execute(&");
            String _path = ai.getPath();
            String _pathName = this.roomExt.getPathName(_path);
            _builder.append(_pathName, "");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
