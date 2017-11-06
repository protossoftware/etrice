/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 */
package org.eclipse.etrice.generator.c.gen;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.common.converter.TimeConverter;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.c.Main;
import org.eclipse.etrice.generator.c.gen.CExtensions;
import org.eclipse.etrice.generator.c.gen.Initialization;
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo;
import org.eclipse.etrice.generator.fsm.base.IntelligentSeparator;
import org.eclipse.etrice.generator.generic.ProcedureHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.etrice.generator.generic.TypeHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class NodeGen {
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private CExtensions _cExtensions;
  
  @Inject
  @Extension
  private RoomExtensions _roomExtensions;
  
  @Inject
  @Extension
  private TypeHelpers _typeHelpers;
  
  @Inject
  @Extension
  private ProcedureHelpers helpers;
  
  @Inject
  private IGeneratorFileIo fileIO;
  
  @Inject
  private Initialization attrInitGenAddon;
  
  @Inject
  private IDiagnostician diagnostician;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    Collection<NodeRef> _nodeRefs = ETMapUtil.getNodeRefs();
    for (final NodeRef nr : _nodeRefs) {
      List<String> _subSystemInstancePaths = ETMapUtil.getSubSystemInstancePaths(nr);
      for (final String instpath : _subSystemInstancePaths) {
        {
          StructureInstance _instance = root.getInstance(instpath);
          final SubSystemInstance ssi = ((SubSystemInstance) _instance);
          boolean _notEquals = (!Objects.equal(ssi, null));
          if (_notEquals) {
            String _generationTargetPath = this._roomExtensions.getGenerationTargetPath(ssi.getSubSystemClass());
            String _path = this._roomExtensions.getPath(ssi.getSubSystemClass());
            final String filepath = (_generationTargetPath + _path);
            String _generationInfoPath = this._roomExtensions.getGenerationInfoPath(ssi.getSubSystemClass());
            String _path_1 = this._roomExtensions.getPath(ssi.getSubSystemClass());
            final String infopath = (_generationInfoPath + _path_1);
            String file = this._cExtensions.getCHeaderFileName(nr, ssi);
            this.checkDataPorts(ssi);
            final Set<PhysicalThread> usedThreads = ETMapUtil.getUsedThreads(nr, ssi);
            this.fileIO.generateFile("generating Node declaration", filepath, infopath, file, this.generateHeaderFile(root, ssi));
            file = this._cExtensions.getCSourceFileName(nr, ssi);
            this.fileIO.generateFile("generating Node implementation", filepath, infopath, file, this.generateSourceFile(root, ssi, usedThreads));
            file = this._cExtensions.getInstSourceFileName(nr, ssi);
            this.fileIO.generateFile("generating Node instance file", filepath, infopath, file, this.generateInstanceFile(root, ssi, usedThreads));
            file = this._cExtensions.getDispSourceFileName(nr, ssi);
            this.fileIO.generateFile("generating Node dispatcher file", filepath, infopath, file, this.generateDispatcherFile(root, ssi, usedThreads));
          }
        }
      }
    }
  }
  
  private CharSequence generateHeaderFile(final Root root, final SubSystemInstance ssi) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final SubSystemClass ssc = ssi.getSubSystemClass();
      String _name = nr.getName();
      String _plus = (_name + "_");
      String _name_1 = ssi.getName();
      final String clsname = (_plus + _name_1);
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
      _builder.append("* Header File of Node ");
      String _name_2 = nr.getName();
      _builder.append(_name_2, " ");
      _builder.append(" with SubSystem ");
      String _name_3 = ssi.getName();
      _builder.append(_name_3, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      CharSequence _generateIncludeGuardBegin = this._cExtensions.generateIncludeGuardBegin(clsname);
      _builder.append(_generateIncludeGuardBegin);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"etDatatypes.h\"");
      _builder.newLine();
      _builder.newLine();
      CharSequence _userCode = this.helpers.userCode(ssc.getUserCode1());
      _builder.append(_userCode);
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
      _builder.append(clsname);
      _builder.append("_init(void);\t\t/* lifecycle init  \t */");
      _builder.newLineIfNotEmpty();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_start(void);\t/* lifecycle start \t */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_run(etBool runAsTest);\t\t/* lifecycle run \t */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_stop(void); \t/* lifecycle stop\t */");
      _builder.newLineIfNotEmpty();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_destroy(void); \t/* lifecycle destroy */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_shutdown(void);  /* shutdown the dispatcher loop */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _userCode_1 = this.helpers.userCode(ssc.getUserCode2());
      _builder.append(_userCode_1);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _generateIncludeGuardEnd = this._cExtensions.generateIncludeGuardEnd(clsname);
      _builder.append(_generateIncludeGuardEnd);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateSourceFile(final Root root, final SubSystemInstance ssi, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final SubSystemClass ssc = ssi.getSubSystemClass();
      String _name = nr.getName();
      String _plus = (_name + "_");
      String _name_1 = ssi.getName();
      final String clsname = (_plus + _name_1);
      final Function1<PhysicalThread, Boolean> _function = (PhysicalThread t) -> {
        return Boolean.valueOf(usedThreads.contains(t));
      };
      final Iterable<PhysicalThread> threads = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function);
      final boolean logData = (Main.getSettings().isGenerateDataInstrumentation() && this._roomHelpers.isAnnotationPresent(ssc.getAnnotations(), "DataLogging"));
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
      _builder.append("* Source File of Node ");
      String _name_2 = nr.getName();
      _builder.append(_name_2, " ");
      _builder.append(" with SubSystem ");
      String _name_3 = ssi.getName();
      _builder.append(_name_3, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include <stdio.h>");
      _builder.newLine();
      _builder.append("#include <string.h>");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _cHeaderFileName = this._cExtensions.getCHeaderFileName(nr, ssi);
      _builder.append(_cHeaderFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include \"debugging/etLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etMSCLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"debugging/etDataLogger.h\"");
      _builder.newLine();
      _builder.append("#include \"messaging/etSystemProtocol.h\"");
      _builder.newLine();
      _builder.append("#include \"osal/etTimer.h\"");
      _builder.newLine();
      _builder.append("#include \"osal/etSema.h\"");
      _builder.newLine();
      _builder.append("#include \"runtime/etRuntime.h\"");
      _builder.newLine();
      _builder.append("#include \"etRuntimeConfig.h\"");
      _builder.newLine();
      _builder.newLine();
      CharSequence _userCode = this.helpers.userCode(ssc.getUserCode3());
      _builder.append(_userCode);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* data for Node ");
      String _name_4 = nr.getName();
      _builder.append(_name_4);
      _builder.append(" with SubSystem ");
      String _name_5 = ssi.getName();
      _builder.append(_name_5);
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _builder.append("typedef struct ");
      _builder.append(clsname);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("char *name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("volatile int shutdownRequest;");
      _builder.newLine();
      _builder.append("} ");
      _builder.append(clsname);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static ");
      _builder.append(clsname);
      _builder.append(" ");
      _builder.append(clsname);
      _builder.append("Inst = {\"");
      _builder.append(clsname);
      _builder.append("\", 0};");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_initActorInstances(void);");
      _builder.newLineIfNotEmpty();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_constructActorInstances(void);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("/* include instances for all classes */");
      _builder.newLine();
      _builder.append("#include \"");
      String _instSourceFileName = this._cExtensions.getInstSourceFileName(nr, ssi);
      _builder.append(_instSourceFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("#include \"");
      String _dispSourceFileName = this._cExtensions.getDispSourceFileName(nr, ssi);
      _builder.append(_dispSourceFileName);
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_initMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"initMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("etTime interval;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("/* initialization of all message services */");
      _builder.newLine();
      {
        final Function1<PhysicalThread, Long> _function_1 = (PhysicalThread it) -> {
          long _prio = it.getPrio();
          return Long.valueOf((-_prio));
        };
        List<PhysicalThread> _sortBy = IterableExtensions.<PhysicalThread, Long>sortBy(threads, _function_1);
        for(final PhysicalThread thread : _sortBy) {
          {
            if ((Objects.equal(thread.getExecmode(), ExecMode.POLLED) || Objects.equal(thread.getExecmode(), ExecMode.MIXED))) {
              _builder.append("\t\t");
              _builder.append("interval.sec = ");
              long _split = TimeConverter.split(thread.getTime(), TimeConverter.SEC, true);
              _builder.append(_split, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("interval.nSec = ");
              long _split_1 = TimeConverter.split(thread.getTime(), TimeConverter.MILLI_SEC, false);
              _builder.append(_split_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("etMessageService_init(");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("&msgService_");
          String _name_6 = thread.getName();
          _builder.append(_name_6, "\t\t\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("msgBuffer_");
          String _name_7 = thread.getName();
          _builder.append(_name_7, "\t\t\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          String _upperCase = thread.getName().toUpperCase();
          _builder.append(_upperCase, "\t\t\t");
          _builder.append("_POOL_SIZE,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          String _upperCase_1 = thread.getName().toUpperCase();
          _builder.append(_upperCase_1, "\t\t\t");
          _builder.append("_BLOCK_SIZE,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          int _stacksize = thread.getStacksize();
          _builder.append(_stacksize, "\t\t\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          long _prio = thread.getPrio();
          _builder.append(_prio, "\t\t\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("interval,");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("MsgDispatcher_");
          String _name_8 = thread.getName();
          _builder.append(_name_8, "\t\t\t");
          _builder.append("_receiveMessage,");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("EXECMODE_");
          String _upperCase_2 = thread.getExecmode().toString().toUpperCase();
          _builder.append(_upperCase_2, "\t\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_startMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"startMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        final Function1<PhysicalThread, Long> _function_2 = (PhysicalThread it) -> {
          long _prio_1 = it.getPrio();
          return Long.valueOf((-_prio_1));
        };
        List<PhysicalThread> _sortBy_1 = IterableExtensions.<PhysicalThread, Long>sortBy(threads, _function_2);
        for(final PhysicalThread thread_1 : _sortBy_1) {
          _builder.append("\t");
          _builder.append("etMessageService_start(&msgService_");
          String _name_9 = thread_1.getName();
          _builder.append(_name_9, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_stopMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"stopMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final PhysicalThread thread_2 : threads) {
          _builder.append("\t");
          _builder.append("etMessageService_stop(&msgService_");
          String _name_10 = thread_2.getName();
          _builder.append(_name_10, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_destroyMessageServices(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"destroyMessageServices\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final PhysicalThread thread_3 : threads) {
          _builder.append("\t");
          _builder.append("etMessageService_destroy(&msgService_");
          String _name_11 = thread_3.getName();
          _builder.append(_name_11, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_init(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"init\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_init\", ");
      _builder.append(clsname, "\t");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* construct all actors */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_constructActorInstances();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* initialization of all message services */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_initMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* init all actors */");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_initActorInstances();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if (logData) {
          {
            for(final PhysicalThread thread_4 : threads) {
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_12 = thread_4.getName();
              _builder.append(_name_12, "\t");
              _builder.append("_logDataHeaders();");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            for(final PhysicalThread thread_5 : threads) {
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_13 = thread_5.getName();
              _builder.append(_name_13, "\t");
              _builder.append("_logData();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_start(void) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"start\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_start\", ");
      _builder.append(clsname, "\t");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_startMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_run(etBool runAsTest) {");
      _builder.newLineIfNotEmpty();
      _builder.append("#ifdef ET_RUNNER_ACTIVATE");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"run\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (runAsTest) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("etSema_waitForWakeup(etRuntime_getTerminateSemaphore());");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("else {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("printf(\"type quit to exit\\n\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("fflush(stdout);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("while (ET_TRUE) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("char line[64];");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (fgets(line, 64, stdin) != NULL) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (strncmp(line, \"quit\", 4)==0)");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("break;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("#endif");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_stop(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"stop\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_stop\", ");
      _builder.append(clsname, "\t");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_stopMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_destroy(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"destroy\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_destroy\", ");
      _builder.append(clsname, "\t");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances = ssi.getAllContainedInstances();
        for(final ActorInstance ai : _allContainedInstances) {
          _builder.append("\t");
          ActorClass _actorClass = ai.getActorClass();
          String _pathName = this._roomExtensions.getPathName(ai.getPath());
          String _plus_1 = ("&" + _pathName);
          String _invokeUserStructor = this.helpers.invokeUserStructor(_actorClass, _plus_1, false);
          _builder.append(_invokeUserStructor, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("_destroyMessageServices();");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void ");
      _builder.append(clsname);
      _builder.append("_shutdown(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"shutdown\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("etLogger_logInfoF(\"%s_shutdown\", ");
      _builder.append(clsname, "\t");
      _builder.append("Inst.name);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append(clsname, "\t");
      _builder.append("Inst.shutdownRequest = 1;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_constructActorInstances(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"constructActorInstances\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          _builder.append("\t");
          ActorClass _actorClass_1 = ai_1.getActorClass();
          String _pathName_1 = this._roomExtensions.getPathName(ai_1.getPath());
          String _plus_2 = ("&" + _pathName_1);
          String _invokeUserStructor_1 = this.helpers.invokeUserStructor(_actorClass_1, _plus_2, true);
          _builder.append(_invokeUserStructor_1, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static void ");
      _builder.append(clsname);
      _builder.append("_initActorInstances(void){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"");
      _builder.append(clsname, "\t");
      _builder.append("\", \"initActorInstances\")");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_2 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_2 : _allContainedInstances_2) {
          _builder.append("\t");
          String _name_14 = ai_2.getActorClass().getName();
          _builder.append(_name_14, "\t");
          _builder.append("_init(&");
          String _pathName_2 = this._roomExtensions.getPathName(ai_2.getPath());
          _builder.append(_pathName_2, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateInstanceFile(final Root root, final SubSystemInstance ssi, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
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
      _builder.append("* Instance File of Node ");
      String _name = nr.getName();
      _builder.append(_name, " ");
      _builder.append(" with SubSystem ");
      String _name_1 = ssi.getName();
      _builder.append(_name_1, " ");
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
      _builder.newLine();
      _builder.append("/* include all referenced room classes */");
      _builder.newLine();
      {
        EList<ActorClass> _referencedActorClasses = root.getReferencedActorClasses(ssi.getSubSystemClass());
        EList<ProtocolClass> _referencedProtocolClasses = root.getReferencedProtocolClasses(ssi.getSubSystemClass());
        final Function1<RoomClass, String> _function = (RoomClass it) -> {
          return it.getName();
        };
        List<RoomClass> _sortBy = IterableExtensions.<RoomClass, String>sortBy(Iterables.<RoomClass>concat(_referencedActorClasses, _referencedProtocolClasses), _function);
        for(final RoomClass dc : _sortBy) {
          _builder.append("#include ");
          String _includePath = this._cExtensions.getIncludePath(dc);
          _builder.append(_includePath);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* instantiation of message services and message buffers */");
      _builder.newLine();
      {
        final Function1<PhysicalThread, Boolean> _function_1 = (PhysicalThread t) -> {
          return Boolean.valueOf(usedThreads.contains(t));
        };
        Iterable<PhysicalThread> _filter = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function_1);
        for(final PhysicalThread thread : _filter) {
          _builder.append("/* ");
          String _name_2 = thread.getName();
          _builder.append(_name_2);
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _upperCase = thread.getName().toUpperCase();
          _builder.append(_upperCase);
          _builder.append("_POOL_SIZE\t\t");
          int _msgpoolsize = thread.getMsgpoolsize();
          _builder.append(_msgpoolsize);
          _builder.newLineIfNotEmpty();
          _builder.append("#define ");
          String _upperCase_1 = thread.getName().toUpperCase();
          _builder.append(_upperCase_1);
          _builder.append("_BLOCK_SIZE\t");
          int _msgblocksize = thread.getMsgblocksize();
          _builder.append(_msgblocksize);
          _builder.newLineIfNotEmpty();
          _builder.append("static uint8 msgBuffer_");
          String _name_3 = thread.getName();
          _builder.append(_name_3);
          _builder.append("[");
          String _upperCase_2 = thread.getName().toUpperCase();
          _builder.append(_upperCase_2);
          _builder.append("_POOL_SIZE * ");
          String _upperCase_3 = thread.getName().toUpperCase();
          _builder.append(_upperCase_3);
          _builder.append("_BLOCK_SIZE];");
          _builder.newLineIfNotEmpty();
          _builder.append("static etMessageService msgService_");
          String _name_4 = thread.getName();
          _builder.append(_name_4);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
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
          String _name_5 = ai.getActorClass().getName();
          _builder.append(_name_5);
          _builder.append(" ");
          String _pathName = this._roomExtensions.getPathName(ai.getPath());
          _builder.append(_pathName);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("/* forward declaration of variable port structs */");
      _builder.newLine();
      {
        EList<ActorInstance> _allContainedInstances_1 = ssi.getAllContainedInstances();
        for(final ActorInstance ai_1 : _allContainedInstances_1) {
          {
            boolean _isEmpty = ai_1.getOrderedIfItemInstances().isEmpty();
            if (_isEmpty) {
              _builder.append("/* nothing to do */");
              _builder.newLine();
            } else {
              {
                EList<InterfaceItemInstance> _orderedIfItemInstances = ai_1.getOrderedIfItemInstances();
                for(final InterfaceItemInstance pi : _orderedIfItemInstances) {
                  {
                    PortClass _portClass = this._roomExtensions.getPortClass(pi.getProtocol(), this._roomExtensions.isConjugated(pi));
                    EList<Attribute> _attributes = null;
                    if (_portClass!=null) {
                      _attributes=_portClass.getAttributes();
                    }
                    int _size = 0;
                    if (_attributes!=null) {
                      _size=_attributes.size();
                    }
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("static ");
                      String _portClassName = this._roomExtensions.getPortClassName(pi.getProtocol(), this._roomExtensions.isConjugated(pi));
                      _builder.append(_portClassName);
                      _builder.append("_var ");
                      String _pathName_1 = this._roomExtensions.getPathName(pi.getPath());
                      _builder.append(_pathName_1);
                      _builder.append("_var");
                      {
                        boolean _isReplicated = pi.isReplicated();
                        if (_isReplicated) {
                          _builder.append("[");
                          int _size_1 = pi.getPeers().size();
                          _builder.append(_size_1);
                          _builder.append("]");
                        }
                      }
                      _builder.append("={");
                      _builder.newLineIfNotEmpty();
                      {
                        int _xifexpression = (int) 0;
                        int _size_2 = pi.getPeers().size();
                        boolean _equals = (_size_2 == 0);
                        if (_equals) {
                          _xifexpression = 1;
                        } else {
                          _xifexpression = pi.getPeers().size();
                        }
                        IntegerRange _upTo = new IntegerRange(1, _xifexpression);
                        boolean _hasElements = false;
                        for(final Integer i : _upTo) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder.appendImmediate(", ", "\t");
                          }
                          _builder.append("\t");
                          CharSequence _generateAttributeInit = this.attrInitGenAddon.generateAttributeInit(pi, this._roomHelpers.getPortClass(pi.getInterfaceItem()).getAttributes());
                          _builder.append(_generateAttributeInit, "\t");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t\t\t\t\t\t");
                        }
                      }
                      _builder.append("};");
                      _builder.newLineIfNotEmpty();
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
          String _pathName_2 = this._roomExtensions.getPathName(ai_2.getPath());
          _builder.append(_pathName_2);
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            if (((!Main.getSettings().isGenerateMSCInstrumentation()) && ai_2.getOrderedIfItemInstances().isEmpty())) {
              _builder.append("/* no ports/saps/services - nothing to initialize statically */");
              _builder.newLine();
            } else {
              CharSequence _genActorInstanceInitializer = this.genActorInstanceInitializer(root, ai_2);
              _builder.append(_genActorInstanceInitializer);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence genActorInstanceInitializer(final Root root, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      final String instName = this._roomExtensions.getPathName(ai.getPath());
      final ArrayList<InterfaceItemInstance> replEventItems = new ArrayList<InterfaceItemInstance>();
      final Function1<InterfaceItemInstance, Boolean> _function = (InterfaceItemInstance e) -> {
        return Boolean.valueOf(e.isReplicated());
      };
      Iterables.<InterfaceItemInstance>addAll(replEventItems, IterableExtensions.<InterfaceItemInstance>filter(ai.getOrderedIfItemInstances(), _function));
      final Function1<InterfaceItemInstance, Boolean> _function_1 = (InterfaceItemInstance e) -> {
        boolean _isEmpty = e.getPeers().isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      InterfaceItemInstance _findFirst = IterableExtensions.<InterfaceItemInstance>findFirst(replEventItems, _function_1);
      final boolean haveReplSubItems = (!Objects.equal(_findFirst, null));
      final Function1<InterfaceItemInstance, Boolean> _function_2 = (InterfaceItemInstance i) -> {
        InterfaceItem _interfaceItem = i.getInterfaceItem();
        return Boolean.valueOf((_interfaceItem instanceof Port));
      };
      final Iterable<InterfaceItemInstance> replEventPorts = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_2);
      final Function1<InterfaceItemInstance, Boolean> _function_3 = (InterfaceItemInstance i) -> {
        InterfaceItem _interfaceItem = i.getInterfaceItem();
        return Boolean.valueOf((_interfaceItem instanceof SPP));
      };
      final Iterable<InterfaceItemInstance> replEventSPPs = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_3);
      final Function1<InterfaceItemInstance, Boolean> _function_4 = (InterfaceItemInstance e) -> {
        return Boolean.valueOf(e.isSimple());
      };
      final Iterable<InterfaceItemInstance> simplePorts = IterableExtensions.<InterfaceItemInstance>filter(ai.getOrderedIfItemInstances(), _function_4);
      final ArrayList<InterfaceItemInstance> simpleEventItems = new ArrayList<InterfaceItemInstance>();
      final Function1<InterfaceItemInstance, Boolean> _function_5 = (InterfaceItemInstance p) -> {
        CommunicationType _commType = p.getProtocol().getCommType();
        return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
      };
      Iterables.<InterfaceItemInstance>addAll(simpleEventItems, IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_5));
      final Function1<InterfaceItemInstance, Boolean> _function_6 = (InterfaceItemInstance i) -> {
        InterfaceItem _interfaceItem = i.getInterfaceItem();
        return Boolean.valueOf((_interfaceItem instanceof Port));
      };
      final Iterable<InterfaceItemInstance> simpleEventPorts = IterableExtensions.<InterfaceItemInstance>filter(simpleEventItems, _function_6);
      final Function1<InterfaceItemInstance, Boolean> _function_7 = (InterfaceItemInstance i) -> {
        InterfaceItem _interfaceItem = i.getInterfaceItem();
        return Boolean.valueOf((_interfaceItem instanceof SAP));
      };
      final Iterable<InterfaceItemInstance> simpleEventSAPs = IterableExtensions.<InterfaceItemInstance>filter(simpleEventItems, _function_7);
      final Function1<InterfaceItemInstance, Boolean> _function_8 = (InterfaceItemInstance p) -> {
        CommunicationType _commType = p.getProtocol().getCommType();
        return Boolean.valueOf(Objects.equal(_commType, CommunicationType.DATA_DRIVEN));
      };
      final Iterable<InterfaceItemInstance> dataPorts = IterableExtensions.<InterfaceItemInstance>filter(simplePorts, _function_8);
      final Function1<InterfaceItemInstance, Boolean> _function_9 = (InterfaceItemInstance p) -> {
        return Boolean.valueOf(((p instanceof PortInstance) && (!((PortInstance) p).getPort().isConjugated())));
      };
      final Iterable<InterfaceItemInstance> recvPorts = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_9);
      final Function1<InterfaceItemInstance, Boolean> _function_10 = (InterfaceItemInstance p) -> {
        return Boolean.valueOf(((p instanceof PortInstance) && ((PortInstance) p).getPort().isConjugated()));
      };
      final Iterable<InterfaceItemInstance> sendPorts = IterableExtensions.<InterfaceItemInstance>filter(dataPorts, _function_10);
      final HashMap<InterfaceItemInstance, Integer> offsets = new HashMap<InterfaceItemInstance, Integer>();
      int offset = 0;
      for (final InterfaceItemInstance p : replEventItems) {
        {
          offsets.put(p, Integer.valueOf(offset));
          int _size = p.getPeers().size();
          int _plus = (offset + _size);
          offset = _plus;
        }
      }
      String _xifexpression = null;
      if (haveReplSubItems) {
        _xifexpression = (instName + "_repl_sub_ports");
      } else {
        _xifexpression = "NULL";
      }
      String replSubPortsArray = _xifexpression;
      final boolean haveConstData = ((((!simpleEventItems.isEmpty()) || (!IterableExtensions.isEmpty(recvPorts))) || (!replEventItems.isEmpty())) || Main.getSettings().isGenerateMSCInstrumentation());
      final IntelligentSeparator sep = new IntelligentSeparator(",");
      String _xifexpression_1 = null;
      boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
      if (_isGenerateMSCInstrumentation) {
        _xifexpression_1 = "/*const*/";
      } else {
        _xifexpression_1 = "const";
      }
      final String const_ = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          CharSequence _genPeerPortArrays = this.genPeerPortArrays(root, ai);
          _builder.append(_genPeerPortArrays);
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if (haveReplSubItems) {
          _builder.append("static const etReplSubPort ");
          _builder.append(replSubPortsArray);
          _builder.append("[");
          _builder.append(offset);
          _builder.append("] = {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("/* Replicated Sub Ports: {varData, msgService, peerAddress, localId, index} */");
          _builder.newLine();
          {
            final Function1<InterfaceItemInstance, Boolean> _function_11 = (InterfaceItemInstance e) -> {
              boolean _isEmpty = e.getPeers().isEmpty();
              return Boolean.valueOf((!_isEmpty));
            };
            Iterable<InterfaceItemInstance> _filter = IterableExtensions.<InterfaceItemInstance>filter(replEventItems, _function_11);
            boolean _hasElements = false;
            for(final InterfaceItemInstance pi : _filter) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              String _genReplSubPortInitializers = this.genReplSubPortInitializers(root, ai, pi);
              _builder.append(_genReplSubPortInitializers, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        }
      }
      {
        if (haveConstData) {
          _builder.append("static ");
          _builder.append(const_);
          _builder.append(" ");
          String _name = ai.getActorClass().getName();
          _builder.append(_name);
          _builder.append("_const ");
          _builder.append(instName);
          _builder.append("_const = {");
          _builder.newLineIfNotEmpty();
          {
            boolean _isGenerateMSCInstrumentation_2 = Main.getSettings().isGenerateMSCInstrumentation();
            if (_isGenerateMSCInstrumentation_2) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              _builder.append("\"");
              String _path = ai.getPath();
              _builder.append(_path, "\t");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("/* Ports: {varData, msgService, peerAddress, localId} */");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* simple ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_1 : simpleEventPorts) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              String _genPortInitializer = this.genPortInitializer(root, ai, pi_1);
              _builder.append(_genPortInitializer, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* data receive ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_2 : recvPorts) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              String _genRecvPortInitializer = this.genRecvPortInitializer(root, ai, pi_2);
              _builder.append(_genRecvPortInitializer, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* saps */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_3 : simpleEventSAPs) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              String _genPortInitializer_1 = this.genPortInitializer(root, ai, pi_3);
              _builder.append(_genPortInitializer_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* replicated ports */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_4 : replEventPorts) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              _builder.append("{");
              int _size = pi_4.getPeers().size();
              _builder.append(_size, "\t");
              _builder.append(", ");
              _builder.append(replSubPortsArray, "\t");
              _builder.append("+");
              Integer _get = offsets.get(pi_4);
              _builder.append(_get, "\t");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* services */");
          _builder.newLine();
          {
            for(final InterfaceItemInstance pi_5 : replEventSPPs) {
              _builder.append("\t");
              _builder.append(sep, "\t");
              _builder.append("{");
              int _size_1 = pi_5.getPeers().size();
              _builder.append(_size_1, "\t");
              _builder.append(", ");
              _builder.append(replSubPortsArray, "\t");
              _builder.append("+");
              Integer _get_1 = offsets.get(pi_5);
              _builder.append(_get_1, "\t");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("};");
          _builder.newLine();
        }
      }
      _builder.append("static ");
      String _name_1 = ai.getActorClass().getName();
      _builder.append(_name_1);
      _builder.append(" ");
      _builder.append(instName);
      _builder.append(" = {");
      _builder.newLineIfNotEmpty();
      {
        if (haveConstData) {
          _builder.append("\t");
          _builder.append("&");
          _builder.append(instName, "\t");
          _builder.append("_const,");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("/* data send ports */");
      _builder.newLine();
      {
        for(final InterfaceItemInstance pi_6 : sendPorts) {
          _builder.append("\t");
          CharSequence _genSendPortInitializer = this.genSendPortInitializer(pi_6);
          _builder.append(_genSendPortInitializer, "\t");
          _builder.append(",");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* attributes */");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _generateAttributeInit = this.attrInitGenAddon.generateAttributeInit(ai, this._roomHelpers.getAllAttributes(ai.getActorClass()));
      _builder.append(_generateAttributeInit, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/* state and history are initialized in init function */");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence genPeerPortArrays(final Root root, final ActorInstance ai) {
    CharSequence _xblockexpression = null;
    {
      final Function1<InterfaceItemInstance, Boolean> _function = (InterfaceItemInstance e) -> {
        return Boolean.valueOf((e.isSimple() && (e instanceof PortInstance)));
      };
      final Function1<InterfaceItemInstance, PortInstance> _function_1 = (InterfaceItemInstance inst) -> {
        return ((PortInstance) inst);
      };
      final Iterable<PortInstance> simplePorts = IterableExtensions.<InterfaceItemInstance, PortInstance>map(IterableExtensions.<InterfaceItemInstance>filter(ai.getOrderedIfItemInstances(), _function), _function_1);
      final Function1<PortInstance, Boolean> _function_2 = (PortInstance p) -> {
        return Boolean.valueOf((p.getPort().isConjugated() && Objects.equal(p.getProtocol().getCommType(), CommunicationType.DATA_DRIVEN)));
      };
      final Iterable<PortInstance> sendPorts = IterableExtensions.<PortInstance>filter(simplePorts, _function_2);
      final Function1<PortInstance, Boolean> _function_3 = (PortInstance p) -> {
        final Function1<Message, Boolean> _function_4 = (Message m) -> {
          return Boolean.valueOf((this._typeHelpers.isEnumeration(m.getData().getRefType().getType()) || this._typeHelpers.isBoolean(m.getData().getRefType().getType())));
        };
        boolean _isEmpty = IterableExtensions.isEmpty(IterableExtensions.<Message>filter(this._roomHelpers.getOutgoing(p.getPort()), _function_4));
        return Boolean.valueOf((!_isEmpty));
      };
      final Iterable<PortInstance> loggedPorts = IterableExtensions.<PortInstance>filter(sendPorts, _function_3);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty = IterableExtensions.isEmpty(loggedPorts);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE");
          _builder.newLine();
          {
            for(final PortInstance pi : loggedPorts) {
              _builder.append("static const char* ");
              String _pathName = this._roomExtensions.getPathName(pi.getPath());
              _builder.append(_pathName);
              _builder.append("_peers[");
              int _size = pi.getPeers().size();
              int _plus = (_size + 1);
              _builder.append(_plus);
              _builder.append("] = {");
              _builder.newLineIfNotEmpty();
              {
                EList<InterfaceItemInstance> _peers = pi.getPeers();
                for(final InterfaceItemInstance peer : _peers) {
                  _builder.append("\t");
                  _builder.append("\"");
                  EObject _eContainer = peer.eContainer();
                  String _path = ((ActorInstance) _eContainer).getPath();
                  _builder.append(_path, "\t");
                  _builder.append("\",");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("NULL");
              _builder.newLine();
              _builder.append("};");
              _builder.newLine();
            }
          }
          _builder.append("#endif");
          _builder.newLine();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String genPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      int _xifexpression = (int) 0;
      boolean _isEmpty = pi.getPeers().isEmpty();
      if (_isEmpty) {
        _xifexpression = 0;
      } else {
        _xifexpression = pi.getPeers().get(0).getObjId();
      }
      final int objId = _xifexpression;
      int _xifexpression_1 = (int) 0;
      boolean _isEmpty_1 = pi.getPeers().isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = 0;
      } else {
        _xifexpression_1 = pi.getPeers().get(0).getPeers().indexOf(pi);
      }
      final int idx = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isEmpty_2 = pi.getPeers().isEmpty();
      if (_isEmpty_2) {
        _xifexpression_2 = "NULL";
      } else {
        EObject _eContainer = pi.getPeers().get(0).eContainer();
        String _name = ETMapUtil.getMappedThread(((ActorInstance) _eContainer)).getThread().getName();
        _xifexpression_2 = ("&msgService_" + _name);
      }
      final String msgSvc = _xifexpression_2;
      String myInst = "";
      String peerInst = "";
      boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
      if (_isGenerateMSCInstrumentation) {
        EObject _eContainer_1 = pi.eContainer();
        String _path = ((ActorInstance) _eContainer_1).getPath();
        String _plus = ("\n#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE\n,\"" + _path);
        String _plus_1 = (_plus + "\",");
        myInst = _plus_1;
        String _xifexpression_3 = null;
        boolean _isEmpty_3 = pi.getPeers().isEmpty();
        boolean _not = (!_isEmpty_3);
        if (_not) {
          EObject _eContainer_2 = pi.getPeers().get(0).eContainer();
          String _path_1 = ((ActorInstance) _eContainer_2).getPath();
          String _plus_2 = ("\"" + _path_1);
          _xifexpression_3 = (_plus_2 + "\"\n#endif\n");
        } else {
          _xifexpression_3 = "\n#endif\n";
        }
        peerInst = _xifexpression_3;
      }
      String _interfaceItemInstanceData = this.getInterfaceItemInstanceData(pi);
      String _plus_3 = ("{" + _interfaceItemInstanceData);
      String _plus_4 = (_plus_3 + ", ");
      String _plus_5 = (_plus_4 + msgSvc);
      String _plus_6 = (_plus_5 + ", ");
      String _plus_7 = (_plus_6 + Integer.valueOf((objId + idx)));
      String _plus_8 = (_plus_7 + "+BASE_ADDRESS, ");
      int _interfaceItemLocalId = root.getExpandedActorClass(ai).getInterfaceItemLocalId(pi.getInterfaceItem());
      int _plus_9 = (_interfaceItemLocalId + 1);
      String _plus_10 = (_plus_8 + Integer.valueOf(_plus_9));
      String _plus_11 = (_plus_10 + myInst);
      String _plus_12 = (_plus_11 + peerInst);
      String _plus_13 = (_plus_12 + "} /* Port ");
      String _name_1 = pi.getName();
      String _plus_14 = (_plus_13 + _name_1);
      _xblockexpression = (_plus_14 + " */");
    }
    return _xblockexpression;
  }
  
  private CharSequence genSendPortInitializer(final InterfaceItemInstance pi) {
    CharSequence _xblockexpression = null;
    {
      GeneralProtocolClass _protocol = ((PortInstance) pi).getPort().getProtocol();
      final ProtocolClass pc = ((ProtocolClass) _protocol);
      final Function1<Message, Boolean> _function = (Message m) -> {
        VarDecl _data = m.getData();
        return Boolean.valueOf((!Objects.equal(_data, null)));
      };
      Iterable<Message> messages = IterableExtensions.<Message>filter(this._roomHelpers.getAllIncomingMessages(pc), _function);
      final Function1<Message, Boolean> _function_1 = (Message m) -> {
        return Boolean.valueOf(this._typeHelpers.isEnumeration(m.getData().getRefType().getType()));
      };
      final Iterable<Message> enumMsgs = IterableExtensions.<Message>filter(messages, _function_1);
      final Function1<Message, Boolean> _function_2 = (Message m) -> {
        return Boolean.valueOf(this._typeHelpers.isBoolean(m.getData().getRefType().getType()));
      };
      final Iterable<Message> boolMsgs = IterableExtensions.<Message>filter(messages, _function_2);
      final boolean usesMSC = (Main.getSettings().isGenerateMSCInstrumentation() && (!(IterableExtensions.isEmpty(enumMsgs) && IterableExtensions.isEmpty(boolMsgs))));
      EObject _eContainer = pi.eContainer();
      final String instName = ((ActorInstance) _eContainer).getPath();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      {
        EList<Message> _incomingMessages = pc.getIncomingMessages();
        boolean _hasElements = false;
        for(final Message m : _incomingMessages) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t");
          }
          _builder.append("\t");
          String _defaultValue = this._cExtensions.defaultValue(m.getData().getRefType().getType());
          _builder.append(_defaultValue, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if (usesMSC) {
          _builder.append("\t");
          _builder.append("#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(", \"");
          _builder.append(instName, "\t\t");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          String _pathName = this._roomExtensions.getPathName(pi.getPath());
          _builder.append(_pathName, "\t\t");
          _builder.append("_peers");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("#endif");
          _builder.newLine();
        }
      }
      _builder.append("} /* send port ");
      String _name = pi.getName();
      _builder.append(_name);
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getInterfaceItemInstanceData(final InterfaceItemInstance pi) {
    PortClass _portClass = this._roomExtensions.getPortClass(pi.getProtocol(), this._roomExtensions.isConjugated(pi));
    boolean _equals = Objects.equal(_portClass, null);
    if (_equals) {
      return "NULL";
    }
    boolean _isEmpty = this._roomExtensions.getPortClass(pi.getProtocol(), this._roomExtensions.isConjugated(pi)).getAttributes().isEmpty();
    if (_isEmpty) {
      return "NULL";
    } else {
      String _pathName = this._roomExtensions.getPathName(pi.getPath());
      String _plus = ("&" + _pathName);
      return (_plus + "_var");
    }
  }
  
  private String genRecvPortInitializer(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String _xblockexpression = null;
    {
      final Function1<Message, Boolean> _function = (Message m) -> {
        VarDecl _data = m.getData();
        return Boolean.valueOf((!Objects.equal(_data, null)));
      };
      Iterable<Message> sentMsgs = IterableExtensions.<Message>filter(this._roomHelpers.getIncoming(pi.getInterfaceItem()), _function);
      final Function1<Message, Boolean> _function_1 = (Message m) -> {
        return Boolean.valueOf(this._typeHelpers.isEnumeration(m.getData().getRefType().getType()));
      };
      final Iterable<Message> enumMsgs = IterableExtensions.<Message>filter(sentMsgs, _function_1);
      final Function1<Message, Boolean> _function_2 = (Message m) -> {
        return Boolean.valueOf(this._typeHelpers.isBoolean(m.getData().getRefType().getType()));
      };
      final Iterable<Message> boolMsgs = IterableExtensions.<Message>filter(sentMsgs, _function_2);
      final boolean usesMSC = (Main.getSettings().isGenerateMSCInstrumentation() && (!(IterableExtensions.isEmpty(enumMsgs) && IterableExtensions.isEmpty(boolMsgs))));
      String enumVal = "";
      if (usesMSC) {
        String _path = ai.getPath();
        String _plus = ("\n, \"" + _path);
        String _plus_1 = (_plus + "\"");
        enumVal = _plus_1;
        for (final Message msg : enumMsgs) {
          String _defaultValue = this._cExtensions.defaultValue(msg.getData().getRefType().getType());
          String _plus_2 = ((enumVal + "\n, ") + _defaultValue);
          enumVal = _plus_2;
        }
        for (final Message msg_1 : boolMsgs) {
          String _defaultValue_1 = this._cExtensions.defaultValue(msg_1.getData().getRefType().getType());
          String _plus_3 = ((enumVal + "\n, ") + _defaultValue_1);
          enumVal = _plus_3;
        }
        enumVal = (("\n#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE" + enumVal) + "\n#endif\n");
      }
      boolean _isEmpty = pi.getPeers().isEmpty();
      if (_isEmpty) {
        return (("{NULL" + enumVal) + "}");
      }
      InterfaceItemInstance peer = pi.getPeers().get(0);
      EObject _eContainer = pi.getPeers().get(0).eContainer();
      ActorInstance peerInst = ((ActorInstance) _eContainer);
      String instName = this._roomExtensions.getPathName(peerInst.getPath());
      String _name = peer.getName();
      String _plus_4 = ((("{&" + instName) + ".") + _name);
      String _plus_5 = (_plus_4 + enumVal);
      _xblockexpression = (_plus_5 + "}");
    }
    return _xblockexpression;
  }
  
  private String genReplSubPortInitializers(final Root root, final ActorInstance ai, final InterfaceItemInstance pi) {
    String result = "";
    String _xifexpression = null;
    boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
    if (_isGenerateMSCInstrumentation) {
      EObject _eContainer = pi.eContainer();
      String _path = ((ActorInstance) _eContainer).getPath();
      String _plus = ("\n#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE\n,\"" + _path);
      _xifexpression = (_plus + "\"\n");
    } else {
      _xifexpression = "";
    }
    final String myInst = _xifexpression;
    EList<InterfaceItemInstance> _peers = pi.getPeers();
    for (final InterfaceItemInstance p : _peers) {
      {
        final int idx = pi.getPeers().indexOf(p);
        String _xifexpression_1 = null;
        int _size = pi.getPeers().size();
        int _minus = (_size - 1);
        boolean _lessThan = (idx < _minus);
        if (_lessThan) {
          _xifexpression_1 = ",";
        } else {
          _xifexpression_1 = "";
        }
        final String comma = _xifexpression_1;
        EObject _eContainer_1 = p.eContainer();
        final String thread = ETMapUtil.getMappedThread(((ActorInstance) _eContainer_1)).getThread().getName();
        String iiiD = this.getInterfaceItemInstanceData(pi);
        String _xifexpression_2 = null;
        boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
        if (_isGenerateMSCInstrumentation_1) {
          EObject _eContainer_2 = p.eContainer();
          String _path_1 = ((ActorInstance) _eContainer_2).getPath();
          String _plus_1 = (",\"" + _path_1);
          _xifexpression_2 = (_plus_1 + "\"\n#endif\n");
        } else {
          _xifexpression_2 = "";
        }
        final String peerInst = _xifexpression_2;
        String _xifexpression_3 = null;
        boolean _equals = iiiD.equals("NULL");
        if (_equals) {
          _xifexpression_3 = (iiiD + ",");
        } else {
          _xifexpression_3 = (((iiiD + "[") + Integer.valueOf(idx)) + "],");
        }
        iiiD = _xifexpression_3;
        int _objId = p.getObjId();
        String _plus_2 = ((((((result + 
          "{{") + iiiD) + "&msgService_") + thread) + ", ") + Integer.valueOf(_objId));
        String _plus_3 = (_plus_2 + "+BASE_ADDRESS, ");
        int _interfaceItemLocalId = root.getExpandedActorClass(ai).getInterfaceItemLocalId(pi.getInterfaceItem());
        int _plus_4 = (_interfaceItemLocalId + 1);
        String _plus_5 = (_plus_3 + Integer.valueOf(_plus_4));
        String _plus_6 = (_plus_5 + myInst);
        String _plus_7 = (_plus_6 + peerInst);
        String _plus_8 = (_plus_7 + "},");
        String _plus_9 = (_plus_8 + Integer.valueOf(idx));
        String _plus_10 = (_plus_9 + "}");
        String _plus_11 = (_plus_10 + comma);
        String _plus_12 = (_plus_11 + " /* Repl Sub Port ");
        String _name = pi.getName();
        String _plus_13 = (_plus_12 + _name);
        String _plus_14 = (_plus_13 + " idx +");
        String _plus_15 = (_plus_14 + Integer.valueOf(idx));
        String _plus_16 = (_plus_15 + "*/\n");
        result = _plus_16;
      }
    }
    return result;
  }
  
  private CharSequence generateDispatcherFile(final Root root, final SubSystemInstance ssi, final Collection<PhysicalThread> usedThreads) {
    CharSequence _xblockexpression = null;
    {
      final NodeRef nr = ETMapUtil.getNodeRef(ssi);
      final boolean logData = (Main.getSettings().isGenerateDataInstrumentation() && this._roomHelpers.isAnnotationPresent(ssi.getSubSystemClass().getAnnotations(), "DataLogging"));
      ArrayList<PortInstance> _xifexpression = null;
      if (logData) {
        _xifexpression = this.loggedPorts(ssi);
      } else {
        _xifexpression = CollectionLiterals.<PortInstance>newArrayList();
      }
      final ArrayList<PortInstance> loggedPorts = _xifexpression;
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
      _builder.append("* Dispatcher File of Node ");
      String _name = nr.getName();
      _builder.append(_name, " ");
      _builder.append(" with SubSystem ");
      String _name_1 = ssi.getName();
      _builder.append(_name_1, " ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("* contains a generated message dispatcher (receiveMessage) for each MessageService (Thread)");
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
      {
        final Function1<PhysicalThread, Boolean> _function = (PhysicalThread t) -> {
          return Boolean.valueOf(usedThreads.contains(t));
        };
        Iterable<PhysicalThread> _filter = IterableExtensions.<PhysicalThread>filter(nr.getType().getThreads(), _function);
        boolean _hasElements = false;
        for(final PhysicalThread thread : _filter) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          final Function1<ActorInstance, Boolean> _function_1 = (ActorInstance ai) -> {
            PhysicalThread _thread = ETMapUtil.getMappedThread(ai).getThread();
            return Boolean.valueOf(Objects.equal(_thread, thread));
          };
          final Iterable<ActorInstance> instancesOnThread = IterableExtensions.<ActorInstance>filter(ssi.getAllContainedInstances(), _function_1);
          _builder.newLineIfNotEmpty();
          final Function1<ActorInstance, Boolean> _function_2 = (ActorInstance ai) -> {
            return Boolean.valueOf((Objects.equal(ai.getActorClass().getCommType(), ComponentCommunicationType.EVENT_DRIVEN) || Objects.equal(ai.getActorClass().getCommType(), ComponentCommunicationType.ASYNCHRONOUS)));
          };
          final Iterable<ActorInstance> dispatchedInstances = IterableExtensions.<ActorInstance>filter(instancesOnThread, _function_2);
          _builder.newLineIfNotEmpty();
          final Function1<ActorInstance, Boolean> _function_3 = (ActorInstance ai) -> {
            return Boolean.valueOf((Objects.equal(ai.getActorClass().getCommType(), ComponentCommunicationType.DATA_DRIVEN) || Objects.equal(ai.getActorClass().getCommType(), ComponentCommunicationType.ASYNCHRONOUS)));
          };
          final Iterable<ActorInstance> executedInstances = IterableExtensions.<ActorInstance>filter(instancesOnThread, _function_3);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          {
            int _size = IterableExtensions.size(executedInstances);
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("/**");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* generated execute function for all cyclic execute calls for the async or datadriven actor instances of thread \"");
              String _name_2 = thread.getName();
              _builder.append(_name_2, " ");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append(" ");
              _builder.append("*/");
              _builder.newLine();
              _builder.append("static void MsgDispatcher_");
              String _name_3 = thread.getName();
              _builder.append(_name_3);
              _builder.append("_poll(void){");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"MsgDispatcher_");
              String _name_4 = thread.getName();
              _builder.append(_name_4, "\t");
              _builder.append("\", \"execute\")");
              _builder.newLineIfNotEmpty();
              {
                for(final ActorInstance ai : executedInstances) {
                  _builder.append("\t");
                  String _name_5 = ai.getActorClass().getName();
                  _builder.append(_name_5, "\t");
                  _builder.append("_execute((void*)&");
                  String _pathName = this._roomExtensions.getPathName(ai.getPath());
                  _builder.append(_pathName, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
              {
                if (logData) {
                  _builder.append("static void MsgDispatcher_");
                  String _name_6 = thread.getName();
                  _builder.append(_name_6);
                  _builder.append("_logDataHeaders(void){");
                  _builder.newLineIfNotEmpty();
                  {
                    for(final PortInstance pi : loggedPorts) {
                      _builder.append("\t");
                      _builder.append("ET_DATA_LOGGER_LOG_STRING(\"");
                      String _path = pi.getPath();
                      _builder.append(_path, "\t");
                      _builder.append("\")");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("static void MsgDispatcher_");
                  String _name_7 = thread.getName();
                  _builder.append(_name_7);
                  _builder.append("_logData(void){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("ET_DATA_LOGGER_NEW_ROW");
                  _builder.newLine();
                  {
                    for(final PortInstance pi_1 : loggedPorts) {
                      _builder.append("\t");
                      String _createLoggerCall = this.createLoggerCall(pi_1);
                      _builder.append(_createLoggerCall, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
          _builder.newLine();
          _builder.append("/**");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* generated dispatch function for all messages for the thread \"");
          String _name_8 = thread.getName();
          _builder.append(_name_8, " ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.append("static etBool MsgDispatcher_");
          String _name_9 = thread.getName();
          _builder.append(_name_9);
          _builder.append("_receiveMessage(const etMessage* msg){");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_ENTRY(\"MsgDispatcher_");
          String _name_10 = thread.getName();
          _builder.append(_name_10, "\t");
          _builder.append("\", \"receiveMessage\")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("switch(msg->address){");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("case MESSAGESERVICE_ADDRESS:");
          _builder.newLine();
          {
            boolean _isEmpty = IterableExtensions.isEmpty(executedInstances);
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append("\t\t\t");
              _builder.append("if (msg->evtID == etSystemProtocol_IN_poll) {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("\t");
              _builder.append("MsgDispatcher_");
              String _name_11 = thread.getName();
              _builder.append(_name_11, "\t\t\t\t");
              _builder.append("_poll();");
              _builder.newLineIfNotEmpty();
              {
                if (logData) {
                  _builder.append("\t\t\t");
                  _builder.append("\t");
                  _builder.append("MsgDispatcher_");
                  String _name_12 = thread.getName();
                  _builder.append(_name_12, "\t\t\t\t");
                  _builder.append("_logData();");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("else");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t");
          _builder.append("if (msg->evtID == etSystemProtocol_IN_terminate)");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("return ET_FALSE;");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("break;");
          _builder.newLine();
          {
            for(final ActorInstance ai_1 : dispatchedInstances) {
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("/* interface items of ");
              String _path_1 = ai_1.getPath();
              _builder.append(_path_1, "\t\t");
              _builder.append(" */");
              _builder.newLineIfNotEmpty();
              {
                final Function1<InterfaceItemInstance, Boolean> _function_4 = (InterfaceItemInstance p) -> {
                  CommunicationType _commType = p.getProtocol().getCommType();
                  return Boolean.valueOf(Objects.equal(_commType, CommunicationType.EVENT_DRIVEN));
                };
                Iterable<InterfaceItemInstance> _filter_1 = IterableExtensions.<InterfaceItemInstance>filter(ai_1.getOrderedIfItemInstances(), _function_4);
                for(final InterfaceItemInstance pi_2 : _filter_1) {
                  {
                    boolean _isReplicated = pi_2.isReplicated();
                    if (_isReplicated) {
                      {
                        EList<InterfaceItemInstance> _peers = pi_2.getPeers();
                        for(final InterfaceItemInstance peer : _peers) {
                          _builder.append("\t\t");
                          _builder.append("case ");
                          int _objId = pi_2.getObjId();
                          int _indexOf = pi_2.getPeers().indexOf(peer);
                          int _plus = (_objId + _indexOf);
                          _builder.append(_plus, "\t\t");
                          _builder.append("+BASE_ADDRESS:");
                          _builder.newLineIfNotEmpty();
                          {
                            boolean _handlesReceive = this._roomExtensions.handlesReceive(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                            if (_handlesReceive) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("switch (msg->evtID){");
                              _builder.newLine();
                              {
                                List<MessageHandler> _receiveHandlers = this._roomExtensions.getReceiveHandlers(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                                for(final MessageHandler h : _receiveHandlers) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("case ");
                                  String _name_13 = pi_2.getProtocol().getName();
                                  _builder.append(_name_13, "\t\t\t\t");
                                  _builder.append("_");
                                  String _codeName = this._roomExtensions.getCodeName(h.getMsg());
                                  _builder.append(_codeName, "\t\t\t\t");
                                  _builder.append(":");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _portClassName = this._roomExtensions.getPortClassName(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                                  _builder.append(_portClassName, "\t\t\t\t\t");
                                  _builder.append("_");
                                  String _name_14 = h.getMsg().getName();
                                  _builder.append(_name_14, "\t\t\t\t\t");
                                  _builder.append("_receiveHandler((etPort *)&");
                                  String _pathName_1 = this._roomExtensions.getPathName(ai_1.getPath());
                                  _builder.append(_pathName_1, "\t\t\t\t\t");
                                  _builder.append("_const.");
                                  String _name_15 = pi_2.getName();
                                  _builder.append(_name_15, "\t\t\t\t\t");
                                  _builder.append(".ports[");
                                  int _indexOf_1 = pi_2.getPeers().indexOf(peer);
                                  _builder.append(_indexOf_1, "\t\t\t\t\t");
                                  _builder.append("],msg,(void*)&");
                                  String _pathName_2 = this._roomExtensions.getPathName(ai_1.getPath());
                                  _builder.append(_pathName_2, "\t\t\t\t\t");
                                  _builder.append(",");
                                  String _name_16 = ai_1.getActorClass().getName();
                                  _builder.append(_name_16, "\t\t\t\t\t");
                                  _builder.append("_receiveMessage);");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append("break;");
                                  _builder.newLine();
                                }
                              }
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("default: ");
                              String _name_17 = ai_1.getActorClass().getName();
                              _builder.append(_name_17, "\t\t\t\t");
                              _builder.append("_receiveMessage((void*)&");
                              String _pathName_3 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_3, "\t\t\t\t");
                              _builder.append(",(etPort*)&");
                              String _pathName_4 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_4, "\t\t\t\t");
                              _builder.append("_const.");
                              String _name_18 = pi_2.getName();
                              _builder.append(_name_18, "\t\t\t\t");
                              _builder.append(".ports[");
                              int _indexOf_2 = pi_2.getPeers().indexOf(peer);
                              _builder.append(_indexOf_2, "\t\t\t\t");
                              _builder.append("], msg);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t\t");
                              _builder.append("break;");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("}");
                              _builder.newLine();
                            } else {
                              {
                                boolean _isGenerateMSCInstrumentation = Main.getSettings().isGenerateMSCInstrumentation();
                                if (_isGenerateMSCInstrumentation) {
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("ET_MSC_LOGGER_ASYNC_IN(");
                                  _builder.newLine();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _pathName_5 = this._roomExtensions.getPathName(ai_1.getPath());
                                  _builder.append(_pathName_5, "\t\t\t\t");
                                  _builder.append("_const.");
                                  String _name_19 = pi_2.getName();
                                  _builder.append(_name_19, "\t\t\t\t");
                                  _builder.append(".ports[");
                                  int _indexOf_3 = pi_2.getPeers().indexOf(peer);
                                  _builder.append(_indexOf_3, "\t\t\t\t");
                                  _builder.append("].port.peerInstName,");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _name_20 = pi_2.getProtocol().getName();
                                  _builder.append(_name_20, "\t\t\t\t");
                                  _builder.append("_getMessageString(msg->evtID),");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  String _pathName_6 = this._roomExtensions.getPathName(ai_1.getPath());
                                  _builder.append(_pathName_6, "\t\t\t\t");
                                  _builder.append("_const.");
                                  String _name_21 = pi_2.getName();
                                  _builder.append(_name_21, "\t\t\t\t");
                                  _builder.append(".ports[");
                                  int _indexOf_4 = pi_2.getPeers().indexOf(peer);
                                  _builder.append(_indexOf_4, "\t\t\t\t");
                                  _builder.append("].port.myInstName");
                                  _builder.newLineIfNotEmpty();
                                  _builder.append("\t\t");
                                  _builder.append("\t");
                                  _builder.append("\t");
                                  _builder.append(")");
                                  _builder.newLine();
                                }
                              }
                              _builder.append("\t\t");
                              _builder.append("\t");
                              String _name_22 = ai_1.getActorClass().getName();
                              _builder.append(_name_22, "\t\t\t");
                              _builder.append("_receiveMessage((void*)&");
                              String _pathName_7 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_7, "\t\t\t");
                              _builder.append(",&");
                              String _pathName_8 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_8, "\t\t\t");
                              _builder.append("_const.");
                              String _name_23 = pi_2.getName();
                              _builder.append(_name_23, "\t\t\t");
                              _builder.append(".ports[");
                              int _indexOf_5 = pi_2.getPeers().indexOf(peer);
                              _builder.append(_indexOf_5, "\t\t\t");
                              _builder.append("].port, msg);");
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
                      int _objId_1 = pi_2.getObjId();
                      _builder.append(_objId_1, "\t\t");
                      _builder.append("+BASE_ADDRESS:");
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _handlesReceive_1 = this._roomExtensions.handlesReceive(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                        if (_handlesReceive_1) {
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("switch (msg->evtID){");
                          _builder.newLine();
                          {
                            List<MessageHandler> _receiveHandlers_1 = this._roomExtensions.getReceiveHandlers(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                            for(final MessageHandler h_1 : _receiveHandlers_1) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("case ");
                              String _name_24 = pi_2.getProtocol().getName();
                              _builder.append(_name_24, "\t\t\t\t");
                              _builder.append("_");
                              String _codeName_1 = this._roomExtensions.getCodeName(h_1.getMsg());
                              _builder.append(_codeName_1, "\t\t\t\t");
                              _builder.append(":");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              String _portClassName_1 = this._roomExtensions.getPortClassName(pi_2.getProtocol(), this._roomExtensions.isConjugated(pi_2));
                              _builder.append(_portClassName_1, "\t\t\t\t\t");
                              _builder.append("_");
                              String _name_25 = h_1.getMsg().getName();
                              _builder.append(_name_25, "\t\t\t\t\t");
                              _builder.append("_receiveHandler((etPort *)&");
                              String _pathName_9 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_9, "\t\t\t\t\t");
                              _builder.append("_const.");
                              String _name_26 = pi_2.getName();
                              _builder.append(_name_26, "\t\t\t\t\t");
                              _builder.append(",msg,(void*)&");
                              String _pathName_10 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_10, "\t\t\t\t\t");
                              _builder.append(",");
                              String _name_27 = ai_1.getActorClass().getName();
                              _builder.append(_name_27, "\t\t\t\t\t");
                              _builder.append("_receiveMessage);");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("break;");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t");
                          _builder.append("default: ");
                          String _name_28 = ai_1.getActorClass().getName();
                          _builder.append(_name_28, "\t\t\t\t");
                          _builder.append("_receiveMessage((void*)&");
                          String _pathName_11 = this._roomExtensions.getPathName(ai_1.getPath());
                          _builder.append(_pathName_11, "\t\t\t\t");
                          _builder.append(",(etPort*)&");
                          String _pathName_12 = this._roomExtensions.getPathName(ai_1.getPath());
                          _builder.append(_pathName_12, "\t\t\t\t");
                          _builder.append("_const.");
                          String _name_29 = pi_2.getName();
                          _builder.append(_name_29, "\t\t\t\t");
                          _builder.append(", msg);");
                          _builder.newLineIfNotEmpty();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("\t\t");
                          _builder.append("break;");
                          _builder.newLine();
                          _builder.append("\t\t");
                          _builder.append("\t");
                          _builder.append("}");
                          _builder.newLine();
                        } else {
                          {
                            boolean _isGenerateMSCInstrumentation_1 = Main.getSettings().isGenerateMSCInstrumentation();
                            if (_isGenerateMSCInstrumentation_1) {
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("ET_MSC_LOGGER_ASYNC_IN(");
                              _builder.newLine();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("((etPort*)&");
                              String _pathName_13 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_13, "\t\t\t\t");
                              _builder.append("_const.");
                              String _name_30 = pi_2.getName();
                              _builder.append(_name_30, "\t\t\t\t");
                              _builder.append(")->peerInstName,");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              String _name_31 = pi_2.getProtocol().getName();
                              _builder.append(_name_31, "\t\t\t\t");
                              _builder.append("_getMessageString(msg->evtID),");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append("((etPort*)&");
                              String _pathName_14 = this._roomExtensions.getPathName(ai_1.getPath());
                              _builder.append(_pathName_14, "\t\t\t\t");
                              _builder.append("_const.");
                              String _name_32 = pi_2.getName();
                              _builder.append(_name_32, "\t\t\t\t");
                              _builder.append(")->myInstName");
                              _builder.newLineIfNotEmpty();
                              _builder.append("\t\t");
                              _builder.append("\t");
                              _builder.append("\t");
                              _builder.append(")");
                              _builder.newLine();
                            }
                          }
                          _builder.append("\t\t");
                          _builder.append("\t");
                          String _name_33 = ai_1.getActorClass().getName();
                          _builder.append(_name_33, "\t\t\t");
                          _builder.append("_receiveMessage((void*)&");
                          String _pathName_15 = this._roomExtensions.getPathName(ai_1.getPath());
                          _builder.append(_pathName_15, "\t\t\t");
                          _builder.append(",(etPort*)&");
                          String _pathName_16 = this._roomExtensions.getPathName(ai_1.getPath());
                          _builder.append(_pathName_16, "\t\t\t");
                          _builder.append("_const.");
                          String _name_34 = pi_2.getName();
                          _builder.append(_name_34, "\t\t\t");
                          _builder.append(", msg);");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t");
                      _builder.append("\t");
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
          _builder.append("etLogger_logErrorF(\"MessageService_");
          String _name_35 = thread.getName();
          _builder.append(_name_35, "\t\t\t");
          _builder.append("_receiveMessage: address %d does not exist \", msg->address);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("break;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("ET_MSC_LOGGER_SYNC_EXIT");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("return ET_TRUE;");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String createLoggerCall(final PortInstance pi) {
    String _xblockexpression = null;
    {
      final Function1<Message, Boolean> _function = (Message m) -> {
        return Boolean.valueOf(((!Objects.equal(m.getData(), null)) && this._typeHelpers.isEnumerationOrPrimitive(m.getData().getRefType().getType())));
      };
      final Message msg = ((Message[])Conversions.unwrapArray(IterableExtensions.<Message>filter(pi.getProtocol().getIncomingMessages(), _function), Message.class))[0];
      EObject _eContainer = pi.eContainer();
      final ActorInstance ai = ((ActorInstance) _eContainer);
      String _pathName = this._roomExtensions.getPathName(ai.getPath());
      String _plus = (_pathName + ".");
      String _name = pi.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      String _name_1 = msg.getName();
      final String data = (_plus_2 + _name_1);
      LiteralType _xifexpression = null;
      DataType _type = msg.getData().getRefType().getType();
      if ((_type instanceof EnumerationType)) {
        _xifexpression = LiteralType.INT;
      } else {
        DataType _type_1 = msg.getData().getRefType().getType();
        _xifexpression = ((PrimitiveType) _type_1).getType();
      }
      final LiteralType type = _xifexpression;
      String _switchResult = null;
      if (type != null) {
        switch (type) {
          case BOOL:
            _switchResult = (("ET_DATA_LOGGER_LOG_BOOL((int)" + data) + ")");
            break;
          case CHAR:
            _switchResult = (("ET_DATA_LOGGER_LOG_INT((int)" + data) + ")");
            break;
          case INT:
            _switchResult = (("ET_DATA_LOGGER_LOG_INT((int)" + data) + ")");
            break;
          case REAL:
            _switchResult = (("ET_DATA_LOGGER_LOG_DOUBLE((double)" + data) + ")");
            break;
          default:
            _switchResult = "internal error: unknown primitive type";
            break;
        }
      } else {
        _switchResult = "internal error: unknown primitive type";
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  private ArrayList<PortInstance> loggedPorts(final SubSystemInstance ssi) {
    final ArrayList<PortInstance> result = CollectionLiterals.<PortInstance>newArrayList();
    boolean _isAnnotationPresent = this._roomHelpers.isAnnotationPresent(ssi.getSubSystemClass().getAnnotations(), "DataLogging");
    if (_isAnnotationPresent) {
      this.logger.logInfo("Data Logging is configured by annotation");
      final String filters = this._roomHelpers.getAttribute(ssi.getSubSystemClass().getAnnotations(), "DataLogging", "pathlist");
      final String[] filterList = filters.split(",");
      for (final String filter : filterList) {
        this.logger.logInfo(("  filter: " + filter));
      }
      final ArrayList<String> notLogged = CollectionLiterals.<String>newArrayList();
      this.logger.logInfo("  logged ports:");
      TreeIterator<EObject> iter = ssi.eAllContents();
      while (iter.hasNext()) {
        {
          final EObject obj = iter.next();
          if ((obj instanceof PortInstance)) {
            final PortInstance pi = ((PortInstance) obj);
            boolean _isRelay = this._roomHelpers.isRelay(pi.getPort());
            boolean _not = (!_isRelay);
            if (_not) {
              CommunicationType _commType = pi.getProtocol().getCommType();
              boolean _equals = Objects.equal(_commType, CommunicationType.DATA_DRIVEN);
              if (_equals) {
                boolean _isConjugated = pi.getPort().isConjugated();
                if (_isConjugated) {
                  final String path = pi.getPath();
                  boolean matched = false;
                  boolean primitive = false;
                  for (final String filter_1 : filterList) {
                    boolean _matches = path.matches(filter_1);
                    if (_matches) {
                      matched = true;
                      final Function1<Message, Boolean> _function = (Message m) -> {
                        return Boolean.valueOf(((!Objects.equal(m.getData(), null)) && this._typeHelpers.isEnumerationOrPrimitive(m.getData().getRefType().getType())));
                      };
                      boolean _isEmpty = IterableExtensions.isEmpty(IterableExtensions.<Message>filter(pi.getProtocol().getIncomingMessages(), _function));
                      boolean _not_1 = (!_isEmpty);
                      if (_not_1) {
                        result.add(pi);
                        primitive = true;
                        String _path = pi.getPath();
                        String _plus = ("    data driven port " + _path);
                        String _plus_1 = (_plus + " (matched ");
                        String _plus_2 = (_plus_1 + filter_1);
                        String _plus_3 = (_plus_2 + ")");
                        this.logger.logInfo(_plus_3);
                      }
                    }
                  }
                  if ((!primitive)) {
                    if (matched) {
                      String _path_1 = pi.getPath();
                      String _plus_4 = ("    data driven port " + _path_1);
                      String _plus_5 = (_plus_4 + " (matched but contains no primitive data)");
                      notLogged.add(_plus_5);
                    } else {
                      String _path_2 = pi.getPath();
                      String _plus_6 = ("    data driven port " + _path_2);
                      String _plus_7 = (_plus_6 + " (no match found)");
                      notLogged.add(_plus_7);
                    }
                  }
                } else {
                  String _path_3 = pi.getPath();
                  String _plus_8 = ("    data driven port " + _path_3);
                  String _plus_9 = (_plus_8 + " (receive port)");
                  notLogged.add(_plus_9);
                }
              }
            }
          }
        }
      }
      this.logger.logInfo("  NOT logged ports:");
      for (final String nl : notLogged) {
        this.logger.logInfo(nl);
      }
    }
    return result;
  }
  
  private void checkDataPorts(final SubSystemInstance comp) {
    final HashSet<String> found = new HashSet<String>();
    EList<ActorInstance> _allContainedInstances = comp.getAllContainedInstances();
    for (final ActorInstance ai : _allContainedInstances) {
      {
        final int thread = ai.getThreadId();
        EList<InterfaceItemInstance> _orderedIfItemInstances = ai.getOrderedIfItemInstances();
        for (final InterfaceItemInstance pi : _orderedIfItemInstances) {
          CommunicationType _commType = pi.getProtocol().getCommType();
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
                    this.diagnostician.error((pair + ": data ports placed on different threads (not supported yet)"), 
                      pi.getInterfaceItem(), pi.getInterfaceItem().eContainingFeature());
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
