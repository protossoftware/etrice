/**
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Jung, Thomas Schuetz (initial contribution)
 */
package org.eclipse.etrice.generator.doc.gen;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.util.RelativePathHelpers;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class DocGen {
  public static class DocGenContext {
    private final Root root;
    
    private final RoomModel model;
    
    public DocGenContext(final Root r, final RoomModel m) {
      this.root = r;
      this.model = m;
    }
  }
  
  @Inject
  @Extension
  private RoomHelpers _roomHelpers;
  
  @Inject
  @Extension
  private CodegenHelpers _codegenHelpers;
  
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  private ILogger logger;
  
  private final String IMGDIR_DEFAULT = "./images";
  
  private final String IMGWIDTH_DEFAULT = "1.0\\textwidth";
  
  public void doGenerate(final Root root) {
    EList<RoomModel> _models = root.getModels();
    for (final RoomModel model : _models) {
      {
        final DocGen.DocGenContext ctx = new DocGen.DocGenContext(root, model);
        String path = this.roomExt.getDocGenerationTargetPath(model);
        String _name = model.getName();
        String file = (_name + ".tex");
        final Set<RoomModel> referencedModels = CollectionLiterals.<RoomModel>newHashSet();
        this.logger.logInfo((((("generating LaTeX documentation: \'" + file) + "\' in \'") + path) + "\'"));
        String _name_1 = model.getName();
        String _plus = (path + _name_1);
        this.fileAccess.setOutputPath(_plus);
        EList<LogicalSystem> _systems = model.getSystems();
        final Consumer<LogicalSystem> _function = (LogicalSystem it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _systems.forEach(_function);
        EList<LogicalSystem> _systems_1 = model.getSystems();
        final Consumer<LogicalSystem> _function_1 = (LogicalSystem it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _systems_1.forEach(_function_1);
        EList<SubSystemClass> _subSystemClasses = model.getSubSystemClasses();
        final Consumer<SubSystemClass> _function_2 = (SubSystemClass it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _subSystemClasses.forEach(_function_2);
        EList<SubSystemClass> _subSystemClasses_1 = model.getSubSystemClasses();
        final Consumer<SubSystemClass> _function_3 = (SubSystemClass it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _subSystemClasses_1.forEach(_function_3);
        EList<GeneralProtocolClass> _protocolClasses = model.getProtocolClasses();
        final Consumer<GeneralProtocolClass> _function_4 = (GeneralProtocolClass it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _protocolClasses.forEach(_function_4);
        EList<GeneralProtocolClass> _protocolClasses_1 = model.getProtocolClasses();
        final Consumer<GeneralProtocolClass> _function_5 = (GeneralProtocolClass it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _protocolClasses_1.forEach(_function_5);
        EList<EnumerationType> _enumerationTypes = model.getEnumerationTypes();
        final Consumer<EnumerationType> _function_6 = (EnumerationType it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _enumerationTypes.forEach(_function_6);
        EList<EnumerationType> _enumerationTypes_1 = model.getEnumerationTypes();
        final Consumer<EnumerationType> _function_7 = (EnumerationType it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _enumerationTypes_1.forEach(_function_7);
        EList<DataClass> _dataClasses = model.getDataClasses();
        final Consumer<DataClass> _function_8 = (DataClass it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _dataClasses.forEach(_function_8);
        EList<DataClass> _dataClasses_1 = model.getDataClasses();
        final Consumer<DataClass> _function_9 = (DataClass it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _dataClasses_1.forEach(_function_9);
        EList<ActorClass> _actorClasses = model.getActorClasses();
        final Consumer<ActorClass> _function_10 = (ActorClass it) -> {
          CharSequence _generateDoc = this.generateDoc(it, ctx);
          String _docFragmentName = this.docFragmentName(it);
          this.saveAs(_generateDoc, _docFragmentName);
        };
        _actorClasses.forEach(_function_10);
        EList<ActorClass> _actorClasses_1 = model.getActorClasses();
        final Consumer<ActorClass> _function_11 = (ActorClass it) -> {
          EList<RoomModel> _referencedModels = root.getReferencedModels(it);
          referencedModels.addAll(_referencedModels);
        };
        _actorClasses_1.forEach(_function_11);
        this.fileAccess.setOutputPath(path);
        CharSequence _generateModelDoc = this.generateModelDoc(ctx, referencedModels);
        this.saveAs(_generateModelDoc, file);
      }
    }
  }
  
  private String removeLast(final String str) {
    int _length = str.length();
    int _minus = (_length - 1);
    return str.substring(0, _minus);
  }
  
  private String appendIfNotEmpty(final String txt, final String suffix) {
    String _xifexpression = null;
    boolean _isEmpty = txt.isEmpty();
    if (_isEmpty) {
      _xifexpression = txt;
    } else {
      _xifexpression = (txt + suffix);
    }
    return _xifexpression;
  }
  
  private CharSequence generateModelDoc(final DocGen.DocGenContext ctx, final Set<RoomModel> referencedModels) {
    CharSequence _xblockexpression = null;
    {
      RoomModel model = ctx.model;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\documentclass[titlepage]{article}");
      _builder.newLine();
      _builder.append("\\usepackage{import}");
      _builder.newLine();
      _builder.append("\\usepackage{graphicx}");
      _builder.newLine();
      _builder.append("\\usepackage{xr}");
      _builder.newLine();
      _builder.append("\\usepackage{hyperref}");
      _builder.newLine();
      _builder.append("\\IfFileExists{../doc/userinputs.tex}{\\subimport{../doc/}{userinputs.tex}}{} %hook for conditional user-specific inputs, includes, macros, ... ");
      _builder.newLine();
      _builder.append("\\usepackage[a4paper,text={160mm,255mm},centering,headsep=5mm,footskip=10mm]{geometry}");
      _builder.newLine();
      _builder.append("\\usepackage{nonfloat}");
      _builder.newLine();
      _builder.append("\\parindent 0pt");
      _builder.newLine();
      _builder.append("\\makeatletter");
      _builder.newLine();
      _builder.append("\\newcommand\\level[1]{%");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("\\ifcase#1\\relax\\expandafter\\chapter\\or");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\expandafter\\section\\or");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\expandafter\\subsection\\or");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\expandafter\\subsubsection\\else");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\def\\next{\\@level{#1}}\\expandafter\\next");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("\\fi}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\newcommand{\\@level}[1]{%");
      _builder.newLine();
      _builder.append("\\@startsection{level#1}");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("{#1}");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("{\\z@}%");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("{-3.25ex\\@plus -1ex \\@minus -.2ex}%");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("{1.5ex \\@plus .2ex}%");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("{\\normalfont\\normalsize\\bfseries}}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\newdimen\\@leveldim");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\newdimen\\@dotsdim");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("{\\normalfont\\normalsize");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\\sbox\\z@{0}\\global\\@leveldim=\\wd\\z@");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\\sbox\\z@{.}\\global\\@dotsdim=\\wd\\z@");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("}  ");
      _builder.newLine();
      _builder.append("\\newcounter{level4}[subsubsection]");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\@namedef{thelevel4}{\\thesubsubsection.\\arabic{level4}}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\@namedef{level4mark}#1{}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\def\\l@section{\\@dottedtocline{1}{0pt}{\\dimexpr\\@leveldim*4+\\@dotsdim*1+6pt\\relax}}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\def\\l@subsection{\\@dottedtocline{2}{0pt}{\\dimexpr\\@leveldim*5+\\@dotsdim*2+6pt\\relax}}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\def\\l@subsubsection{\\@dottedtocline{3}{0pt}{\\dimexpr\\@leveldim*6+\\@dotsdim*3+6pt\\relax}}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\@namedef{l@level4}{\\@dottedtocline{4}{0pt}{\\dimexpr\\@leveldim*7+\\@dotsdim*4+6pt\\relax}}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\count@=4");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\def\\@ncp#1{\\number\\numexpr\\count@+#1\\relax}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\loop\\ifnum\\count@<100");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("\\begingroup\\edef\\x{\\endgroup");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\noexpand\\newcounter{level\\@ncp{1}}[level\\number\\count@]");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\noexpand\\@namedef{thelevel\\@ncp{1}}{%");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("\\noexpand\\@nameuse{thelevel\\@ncp{0}}.\\noexpand\\arabic{level\\@ncp{0}}}");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\noexpand\\@namedef{level\\@ncp{1}mark}####1{}%");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("\\noexpand\\@namedef{l@level\\@ncp{1}}%");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("{\\noexpand\\@dottedtocline{\\@ncp{1}}{0pt}{\\the\\dimexpr\\@leveldim*\\@ncp{5}+\\@dotsdim*\\@ncp{0}\\relax}}}%");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("\\x");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("\\advance\\count@\\@ne");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\repeat");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\makeatother");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\setcounter{secnumdepth}{100}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\\setcounter{tocdepth}{100}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\title{");
      String _name = model.getName();
      String _escapedString = this.escapedString(_name);
      _builder.append(_escapedString, "");
      _builder.append(" Model Documentation}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\date{\\today}");
      _builder.newLine();
      _builder.append("\\author{generated by eTrice}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\begin{document}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\pagestyle{plain}");
      _builder.newLine();
      _builder.append("\\maketitle");
      _builder.newLine();
      _builder.append("\\tableofcontents");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\newpage");
      _builder.newLine();
      _builder.append("\\listoffigures");
      _builder.newLine();
      _builder.append("\\newpage");
      _builder.newLine();
      _builder.append("\\section{Model Description}");
      _builder.newLine();
      _builder.newLine();
      {
        boolean _isEmpty = referencedModels.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("\\section{Referenced Models}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\\begin{itemize}");
          _builder.newLine();
          {
            final Function1<RoomModel, String> _function = (RoomModel it) -> {
              return it.getName();
            };
            List<RoomModel> _sortBy = IterableExtensions.<RoomModel, String>sortBy(referencedModels, _function);
            for(final RoomModel refModel : _sortBy) {
              String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
              String _removeLast = this.removeLast(_docGenerationTargetPath);
              String _docGenerationTargetPath_1 = this.roomExt.getDocGenerationTargetPath(refModel);
              String _removeLast_1 = this.removeLast(_docGenerationTargetPath_1);
              String _relativePath = RelativePathHelpers.getRelativePath(_removeLast, _removeLast_1, true);
              final String relPath = this.appendIfNotEmpty(_relativePath, "/");
              _builder.newLineIfNotEmpty();
              _builder.append("\\item \\href{");
              String _replace = relPath.replace("\\", "/");
              String _name_1 = refModel.getName();
              String _plus = (_replace + _name_1);
              String _escapedString_1 = this.escapedString(_plus);
              _builder.append(_escapedString_1, "");
              _builder.append(".pdf}{");
              String _name_2 = refModel.getName();
              String _escapedString_2 = this.escapedString(_name_2);
              _builder.append(_escapedString_2, "");
              _builder.append("}");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\end{itemize}");
          _builder.newLine();
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<LogicalSystem> _systems = model.getSystems();
        boolean _isEmpty_1 = _systems.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\\section{Logical System Classes}");
          _builder.newLine();
          {
            EList<LogicalSystem> _systems_1 = model.getSystems();
            for(final LogicalSystem s : _systems_1) {
              String _name_3 = model.getName();
              CharSequence _generateImport = this.generateImport(s, _name_3);
              _builder.append(_generateImport, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<SubSystemClass> _subSystemClasses = model.getSubSystemClasses();
        boolean _isEmpty_2 = _subSystemClasses.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.append("\\section{Subsystem Classes}");
          _builder.newLine();
          {
            EList<SubSystemClass> _subSystemClasses_1 = model.getSubSystemClasses();
            for(final SubSystemClass s_1 : _subSystemClasses_1) {
              String _name_4 = model.getName();
              CharSequence _generateImport_1 = this.generateImport(s_1, _name_4);
              _builder.append(_generateImport_1, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<GeneralProtocolClass> _protocolClasses = model.getProtocolClasses();
        boolean _isEmpty_3 = _protocolClasses.isEmpty();
        boolean _not_3 = (!_isEmpty_3);
        if (_not_3) {
          _builder.append("\\section{Protocol Classes}");
          _builder.newLine();
          {
            EList<GeneralProtocolClass> _protocolClasses_1 = model.getProtocolClasses();
            for(final GeneralProtocolClass c : _protocolClasses_1) {
              String _name_5 = model.getName();
              CharSequence _generateImport_2 = this.generateImport(c, _name_5);
              _builder.append(_generateImport_2, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<EnumerationType> _enumerationTypes = model.getEnumerationTypes();
        boolean _isEmpty_4 = _enumerationTypes.isEmpty();
        boolean _not_4 = (!_isEmpty_4);
        if (_not_4) {
          _builder.append("\\section{Enumeration Types}");
          _builder.newLine();
          {
            EList<EnumerationType> _enumerationTypes_1 = model.getEnumerationTypes();
            for(final EnumerationType e : _enumerationTypes_1) {
              String _name_6 = model.getName();
              CharSequence _generateImport_3 = this.generateImport(e, _name_6);
              _builder.append(_generateImport_3, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<DataClass> _dataClasses = model.getDataClasses();
        boolean _isEmpty_5 = _dataClasses.isEmpty();
        boolean _not_5 = (!_isEmpty_5);
        if (_not_5) {
          _builder.append("\\section{Data Classes}");
          _builder.newLine();
          {
            EList<DataClass> _dataClasses_1 = model.getDataClasses();
            for(final DataClass c_1 : _dataClasses_1) {
              String _name_7 = model.getName();
              CharSequence _generateImport_4 = this.generateImport(c_1, _name_7);
              _builder.append(_generateImport_4, "");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        EList<ActorClass> _actorClasses = model.getActorClasses();
        boolean _isEmpty_6 = _actorClasses.isEmpty();
        boolean _not_6 = (!_isEmpty_6);
        if (_not_6) {
          _builder.append("\\section{Actor Classes}");
          _builder.newLine();
          {
            EList<ActorClass> _actorClasses_1 = model.getActorClasses();
            for(final ActorClass c_2 : _actorClasses_1) {
              String _name_8 = model.getName();
              CharSequence _generateImport_5 = this.generateImport(c_2, _name_8);
              _builder.append(_generateImport_5, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\\end{document}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence _generateDoc(final LogicalSystem system, final DocGen.DocGenContext ctx) {
    CharSequence _xblockexpression = null;
    {
      String _name = system.getName();
      final String filename = (_name + "_instanceTree.jpg");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{");
      String _name_1 = system.getName();
      String _escapedString = this.escapedString(_name_1);
      _builder.append(_escapedString, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      Documentation _docu = system.getDocu();
      CharSequence _generateDocText = this.generateDocText(_docu);
      _builder.append(_generateDocText, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\level{3}{Instance Tree}");
      _builder.newLine();
      {
        String _imagePath = this.getImagePath(filename);
        String _fileExists = this.fileExists(ctx.model, _imagePath);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _imagePath_1 = this.getImagePath(filename);
          String _name_2 = system.getName();
          String _plus = (_name_2 + " Instance Tree");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath_1, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence _generateDoc(final SubSystemClass ssc, final DocGen.DocGenContext ctx) {
    CharSequence _xblockexpression = null;
    {
      String _name = ssc.getName();
      String _escapedString = this.escapedString(_name);
      final String filename = (_escapedString + "_structure.jpg");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{");
      String _name_1 = ssc.getName();
      String _escapedString_1 = this.escapedString(_name_1);
      _builder.append(_escapedString_1, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      Documentation _docu = ssc.getDocu();
      CharSequence _generateDocText = this.generateDocText(_docu);
      _builder.append(_generateDocText, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\level{3}{Structure}");
      _builder.newLine();
      {
        String _imagePath = this.getImagePath(filename);
        String _fileExists = this.fileExists(ctx.model, _imagePath);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _imagePath_1 = this.getImagePath(filename);
          String _name_2 = ssc.getName();
          String _plus = (_name_2 + " Structure");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath_1, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence _generateDoc(final EnumerationType dc, final DocGen.DocGenContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _name = dc.getName();
    String _escapedString = this.escapedString(_name);
    _builder.append(_escapedString, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    Documentation _docu = dc.getDocu();
    CharSequence _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    {
      PrimitiveType _primitiveType = dc.getPrimitiveType();
      boolean _notEquals = (!Objects.equal(_primitiveType, null));
      if (_notEquals) {
        _builder.append("The literals of this enumeration are based on PrimitiveType ");
        PrimitiveType _primitiveType_1 = dc.getPrimitiveType();
        String _name_1 = _primitiveType_1.getName();
        String _escapedString_1 = this.escapedString(_name_1);
        _builder.append(_escapedString_1, "");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("The literals of this enumeration are of type \\texttt{int}.");
        _builder.newLine();
      }
    }
    _builder.append("\\level{3}{Literals}");
    _builder.newLine();
    _builder.append("\\begin{tabular}[ht]{|l|r|r|r|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\textbf{Name} & \\textbf{Value} & \\textbf{Hex Value} & \\textbf{Binary Value}\\\\");
    _builder.newLine();
    {
      EList<EnumLiteral> _literals = dc.getLiterals();
      for(final EnumLiteral lit : _literals) {
        _builder.append("\\hline");
        _builder.newLine();
        String _name_2 = lit.getName();
        String _escapedString_2 = this.escapedString(_name_2);
        _builder.append(_escapedString_2, "");
        _builder.append(" & ");
        long _literalValue = lit.getLiteralValue();
        _builder.append(_literalValue, "");
        _builder.append(" & 0x");
        long _literalValue_1 = lit.getLiteralValue();
        String _hexString = Long.toHexString(_literalValue_1);
        _builder.append(_hexString, "");
        _builder.append(" & ");
        long _literalValue_2 = lit.getLiteralValue();
        String _binaryString = Long.toBinaryString(_literalValue_2);
        _builder.append(_binaryString, "");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateDoc(final DataClass dc, final DocGen.DocGenContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _name = dc.getName();
    String _escapedString = this.escapedString(_name);
    _builder.append(_escapedString, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    Documentation _docu = dc.getDocu();
    CharSequence _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\level{3}{Attributes}");
    _builder.newLine();
    EList<Attribute> _attributes = dc.getAttributes();
    CharSequence _generateAttributesDoc = this.generateAttributesDoc(_attributes);
    _builder.append(_generateAttributesDoc, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\level{3}{Operations}");
    _builder.newLine();
    EList<StandardOperation> _operations = dc.getOperations();
    CharSequence _generateOperationsDoc = this.generateOperationsDoc(_operations);
    _builder.append(_generateOperationsDoc, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _generateDoc(final ProtocolClass pc, final DocGen.DocGenContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _name = pc.getName();
    String _escapedString = this.escapedString(_name);
    _builder.append(_escapedString, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    Documentation _docu = pc.getDocu();
    CharSequence _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    {
      List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
      boolean _isEmpty = _allIncomingMessages.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("\\level{3}{Incoming Messages}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\\begin{tabular}[ht]{|l|l|l|p{8cm}|}");
        _builder.newLine();
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("Message & Data & Type & Description\\\\");
        _builder.newLine();
        {
          List<Message> _allIncomingMessages_1 = this._roomHelpers.getAllIncomingMessages(pc);
          for(final Message ims : _allIncomingMessages_1) {
            _builder.append("\\hline");
            _builder.newLine();
            String _name_1 = ims.getName();
            String _escapedString_1 = this.escapedString(_name_1);
            _builder.append(_escapedString_1, "");
            _builder.append(" & ");
            {
              VarDecl _data = ims.getData();
              boolean _notEquals = (!Objects.equal(_data, null));
              if (_notEquals) {
                _builder.append(" ");
                VarDecl _data_1 = ims.getData();
                String _name_2 = _data_1.getName();
                String _escapedString_2 = this.escapedString(_name_2);
                _builder.append(_escapedString_2, "");
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            {
              VarDecl _data_2 = ims.getData();
              boolean _notEquals_1 = (!Objects.equal(_data_2, null));
              if (_notEquals_1) {
                _builder.append(" ");
                VarDecl _data_3 = ims.getData();
                RefableType _refType = _data_3.getRefType();
                DataType _type = _refType.getType();
                String _name_3 = _type.getName();
                String _escapedString_3 = this.escapedString(_name_3);
                _builder.append(_escapedString_3, "");
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            Documentation _docu_1 = ims.getDocu();
            CharSequence _generateDocText_1 = this.generateDocText(_docu_1);
            _builder.append(_generateDocText_1, "");
            _builder.append("\\\\");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
      }
    }
    {
      List<Message> _allOutgoingMessages = this._roomHelpers.getAllOutgoingMessages(pc);
      boolean _isEmpty_1 = _allOutgoingMessages.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("\\level{3}{Outgoing Messages}");
        _builder.newLine();
        _builder.append("\\begin{tabular}[ht]{|l|l|l|p{8cm}|}");
        _builder.newLine();
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("Message & Data & Type & Description\\\\");
        _builder.newLine();
        {
          List<Message> _allOutgoingMessages_1 = this._roomHelpers.getAllOutgoingMessages(pc);
          for(final Message oms : _allOutgoingMessages_1) {
            _builder.append("\\hline");
            _builder.newLine();
            String _name_4 = oms.getName();
            String _escapedString_4 = this.escapedString(_name_4);
            _builder.append(_escapedString_4, "");
            _builder.append(" & ");
            {
              VarDecl _data_4 = oms.getData();
              boolean _notEquals_2 = (!Objects.equal(_data_4, null));
              if (_notEquals_2) {
                _builder.append(" ");
                VarDecl _data_5 = oms.getData();
                String _name_5 = _data_5.getName();
                String _escapedString_5 = this.escapedString(_name_5);
                _builder.append(_escapedString_5, "");
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            {
              VarDecl _data_6 = oms.getData();
              boolean _notEquals_3 = (!Objects.equal(_data_6, null));
              if (_notEquals_3) {
                _builder.append(" ");
                VarDecl _data_7 = oms.getData();
                RefableType _refType_1 = _data_7.getRefType();
                DataType _type_1 = _refType_1.getType();
                String _name_6 = _type_1.getName();
                String _escapedString_6 = this.escapedString(_name_6);
                _builder.append(_escapedString_6, "");
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            Documentation _docu_2 = oms.getDocu();
            CharSequence _generateDocText_2 = this.generateDocText(_docu_2);
            _builder.append(_generateDocText_2, "");
            _builder.append("\\\\");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence _generateDoc(final CompoundProtocolClass pc, final DocGen.DocGenContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _name = pc.getName();
    String _escapedString = this.escapedString(_name);
    _builder.append(_escapedString, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    Documentation _docu = pc.getDocu();
    CharSequence _generateDocText = this.generateDocText(_docu);
    _builder.append(_generateDocText, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\level{3}{Sub Protocols}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{tabular}[ht]{|l|l|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\textbf{Name} & \\textbf{Protocol}\\\\");
    _builder.newLine();
    {
      EList<SubProtocol> _subProtocols = pc.getSubProtocols();
      for(final SubProtocol sub : _subProtocols) {
        _builder.append("\\hline");
        _builder.newLine();
        String _name_1 = sub.getName();
        String _escapedString_1 = this.escapedString(_name_1);
        _builder.append(_escapedString_1, "");
        _builder.append(" & ");
        GeneralProtocolClass _protocol = sub.getProtocol();
        String _name_2 = _protocol.getName();
        String _escapedString_2 = this.escapedString(_name_2);
        _builder.append(_escapedString_2, "");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateDoc(final ActorClass ac, final DocGen.DocGenContext ctx) {
    CharSequence _xblockexpression = null;
    {
      String _name = ac.getName();
      final String filename = (_name + "_structure.jpg");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{");
      String _name_1 = ac.getName();
      String _escapedString = this.escapedString(_name_1);
      _builder.append(_escapedString, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      Documentation _docu = ac.getDocu();
      CharSequence _generateDocText = this.generateDocText(_docu);
      _builder.append(_generateDocText, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if ((this.fileExists(ctx.model, this.getImagePath(filename)).equals("true") && ((!this._roomHelpers.getAllInterfaceItems(ac).isEmpty()) || (!ac.getActorRefs().isEmpty())))) {
          _builder.append("\\level{3}{Structure}");
          _builder.newLine();
          Documentation _structureDocu = ac.getStructureDocu();
          CharSequence _generateDocText_1 = this.generateDocText(_structureDocu);
          _builder.append(_generateDocText_1, "");
          _builder.newLineIfNotEmpty();
          String _imagePath = this.getImagePath(filename);
          String _name_2 = ac.getName();
          String _plus = (_name_2 + " Structure");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        } else {
          Documentation _structureDocu_1 = ac.getStructureDocu();
          boolean _notEquals = (!Objects.equal(_structureDocu_1, null));
          if (_notEquals) {
            _builder.append("\\level{3}{Structure}");
            _builder.newLine();
            Documentation _structureDocu_2 = ac.getStructureDocu();
            CharSequence _generateDocText_2 = this.generateDocText(_structureDocu_2);
            _builder.append(_generateDocText_2, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.newLine();
      {
        List<Port> _allPorts = this._roomHelpers.getAllPorts(ac);
        boolean _isEmpty = _allPorts.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("\\level{3}{Ports}");
          _builder.newLine();
          String _generatePortDoc = this.generatePortDoc(ac);
          _builder.append(_generatePortDoc, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        boolean _isBehaviorAnnotationPresent = this._roomHelpers.isBehaviorAnnotationPresent(ac, "BehaviorManual");
        if (_isBehaviorAnnotationPresent) {
          _builder.append("\\level{3}{Behavior}");
          _builder.newLine();
          Documentation _behaviorDocu = ac.getBehaviorDocu();
          CharSequence _generateDocText_3 = this.generateDocText(_behaviorDocu);
          _builder.append(_generateDocText_3, "");
          _builder.newLineIfNotEmpty();
          _builder.append("The behavior for ActorClass ");
          String _name_3 = ac.getName();
          _builder.append(_name_3, "");
          _builder.append(" is implemented manually.");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
          if (_hasNonEmptyStateMachine) {
            _builder.append("\\level{3}{Behavior}");
            _builder.newLine();
            Documentation _behaviorDocu_1 = ac.getBehaviorDocu();
            CharSequence _generateDocText_4 = this.generateDocText(_behaviorDocu_1);
            _builder.append(_generateDocText_4, "");
            _builder.newLineIfNotEmpty();
            CharSequence _generateFsmDoc = this.generateFsmDoc(ctx.model, ac);
            _builder.append(_generateFsmDoc, "");
            _builder.newLineIfNotEmpty();
          } else {
            Documentation _behaviorDocu_2 = ac.getBehaviorDocu();
            boolean _notEquals_1 = (!Objects.equal(_behaviorDocu_2, null));
            if (_notEquals_1) {
              _builder.append("\\level{3}{Behavior}");
              _builder.newLine();
              Documentation _behaviorDocu_3 = ac.getBehaviorDocu();
              CharSequence _generateDocText_5 = this.generateDocText(_behaviorDocu_3);
              _builder.append(_generateDocText_5, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      {
        EList<Attribute> _attributes = ac.getAttributes();
        boolean _isEmpty_1 = _attributes.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\\level{3}{Attributes}");
          _builder.newLine();
          EList<Attribute> _attributes_1 = ac.getAttributes();
          CharSequence _generateAttributesDoc = this.generateAttributesDoc(_attributes_1);
          _builder.append(_generateAttributesDoc, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        EList<StandardOperation> _operations = ac.getOperations();
        boolean _isEmpty_2 = _operations.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.append("\\level{3}{Operations}");
          _builder.newLine();
          EList<StandardOperation> _operations_1 = ac.getOperations();
          CharSequence _generateOperationsDoc = this.generateOperationsDoc(_operations_1);
          _builder.append(_generateOperationsDoc, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFsmDoc(final RoomModel model, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      String _name = ac.getName();
      final String filename = (_name + "_behavior.jpg");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Top Level}");
      _builder.newLine();
      {
        String _imagePath = this.getImagePath(filename);
        String _fileExists = this.fileExists(model, _imagePath);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _imagePath_1 = this.getImagePath(filename);
          String _name_1 = ac.getName();
          String _plus = (_name_1 + " Top State");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath_1, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        StateGraph _stateMachine = ac.getStateMachine();
        EList<State> _states = _stateMachine.getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _notEquals = (!Objects.equal(_docu, null));
            if (_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _genStatePathName = this._codegenHelpers.getGenStatePathName(s);
              String _replaceAll = _genStatePathName.replaceAll("_", "\\\\_");
              _builder.append(_replaceAll, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_1 = s.getDocu();
              CharSequence _generateDocText = this.generateDocText(_docu_1);
              _builder.append(_generateDocText, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        StateGraph _stateMachine_1 = ac.getStateMachine();
        EList<ChoicePoint> _chPoints = _stateMachine_1.getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_2 = c.getDocu();
            boolean _notEquals_1 = (!Objects.equal(_docu_2, null));
            if (_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _name_2 = c.getName();
              String _escapedString = this.escapedString(_name_2);
              _builder.append(_escapedString, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_3 = c.getDocu();
              CharSequence _generateDocText_1 = this.generateDocText(_docu_3);
              _builder.append(_generateDocText_1, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.newLine();
      {
        StateGraph _stateMachine_2 = ac.getStateMachine();
        EList<State> _states_1 = _stateMachine_2.getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this._roomHelpers.isLeaf(s_1);
            boolean _not = (!_isLeaf);
            if (_not) {
              String _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String getType(final Port p) {
    String _xifexpression = null;
    boolean _isConjugated = p.isConjugated();
    if (_isConjugated) {
      _xifexpression = "conj.";
    } else {
      _xifexpression = "reg.";
    }
    return _xifexpression;
  }
  
  private String getKind(final Port p) {
    String _xifexpression = null;
    boolean _isInternal = this._roomHelpers.isInternal(p);
    if (_isInternal) {
      _xifexpression = "internal";
    } else {
      String _xifexpression_1 = null;
      boolean _isExternal = this._roomHelpers.isExternal(p);
      if (_isExternal) {
        _xifexpression_1 = "external";
      } else {
        String _xifexpression_2 = null;
        boolean _isRelay = this._roomHelpers.isRelay(p);
        if (_isRelay) {
          _xifexpression_2 = "relay";
        } else {
          _xifexpression_2 = "?";
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private String getMultAsText(final Port p) {
    String _xifexpression = null;
    int _multiplicity = p.getMultiplicity();
    boolean _equals = (_multiplicity == (-1));
    if (_equals) {
      _xifexpression = "*";
    } else {
      int _multiplicity_1 = p.getMultiplicity();
      _xifexpression = Integer.valueOf(_multiplicity_1).toString();
    }
    return _xifexpression;
  }
  
  private String generatePortDoc(final ActorClass ac) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\begin{tabular}[ht]{|l|l|l|l|l|p{5cm}|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\textbf{Name} & \\textbf{Protocol} & \\textbf{Type} & \\textbf{Kind} & \\textbf{Multiplicity} & \\textbf{Description}\\\\");
    _builder.newLine();
    {
      List<Port> _allPorts = this._roomHelpers.getAllPorts(ac);
      for(final Port at : _allPorts) {
        _builder.append("\\hline");
        _builder.newLine();
        String _name = at.getName();
        String _escapedString = this.escapedString(_name);
        _builder.append(_escapedString, "");
        _builder.append(" & ");
        GeneralProtocolClass _protocol = at.getProtocol();
        String _name_1 = _protocol.getName();
        String _escapedString_1 = this.escapedString(_name_1);
        _builder.append(_escapedString_1, "");
        _builder.append(" & ");
        String _type = this.getType(at);
        _builder.append(_type, "");
        _builder.append(" & ");
        String _kind = this.getKind(at);
        _builder.append(_kind, "");
        _builder.append(" & ");
        String _multAsText = this.getMultAsText(at);
        _builder.append(_multAsText, "");
        _builder.append(" & ");
        Documentation _docu = at.getDocu();
        CharSequence _generateDocText = this.generateDocText(_docu);
        _builder.append(_generateDocText, "");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String generateStateDoc(final RoomModel model, final ActorClass ac, final State state) {
    String _xblockexpression = null;
    {
      String _name = ac.getName();
      String _plus = (_name + "_");
      String _genStatePathName = this._codegenHelpers.getGenStatePathName(state);
      String _plus_1 = (_plus + _genStatePathName);
      final String filename = (_plus_1 + "_behavior.jpg");
      this.logger.logInfo(("Gen Filename: " + filename));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Subgraph ");
      String _genStatePathName_1 = this._codegenHelpers.getGenStatePathName(state);
      String _replaceAll = _genStatePathName_1.replaceAll("_", "\\\\_");
      _builder.append(_replaceAll, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      {
        String _imagePath = this.getImagePath(filename);
        String _fileExists = this.fileExists(model, _imagePath);
        boolean _equals = _fileExists.equals("true");
        if (_equals) {
          String _imagePath_1 = this.getImagePath(filename);
          String _name_1 = ac.getName();
          String _plus_2 = (_name_1 + "_");
          String _genStatePathName_2 = this._codegenHelpers.getGenStatePathName(state);
          String _plus_3 = (_plus_2 + _genStatePathName_2);
          CharSequence _includeGraphics = this.includeGraphics(_imagePath_1, this.IMGWIDTH_DEFAULT, _plus_3);
          _builder.append(_includeGraphics, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        StateGraph _subgraph = state.getSubgraph();
        EList<State> _states = _subgraph.getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _notEquals = (!Objects.equal(_docu, null));
            if (_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _genStatePathName_3 = this._codegenHelpers.getGenStatePathName(s);
              String _replaceAll_1 = _genStatePathName_3.replaceAll("_", "\\\\_");
              _builder.append(_replaceAll_1, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_1 = s.getDocu();
              CharSequence _generateDocText = this.generateDocText(_docu_1);
              _builder.append(_generateDocText, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        StateGraph _subgraph_1 = state.getSubgraph();
        EList<ChoicePoint> _chPoints = _subgraph_1.getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_2 = c.getDocu();
            boolean _notEquals_1 = (!Objects.equal(_docu_2, null));
            if (_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _name_2 = c.getName();
              String _escapedString = this.escapedString(_name_2);
              _builder.append(_escapedString, "");
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              Documentation _docu_3 = c.getDocu();
              CharSequence _generateDocText_1 = this.generateDocText(_docu_3);
              _builder.append(_generateDocText_1, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        StateGraph _subgraph_2 = state.getSubgraph();
        EList<State> _states_1 = _subgraph_2.getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this._roomHelpers.isLeaf(s_1);
            boolean _not = (!_isLeaf);
            if (_not) {
              String _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private CharSequence generateAttributesDoc(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = attributes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("\\begin{tabular}[ht]{|l|l|p{8cm}|}");
        _builder.newLine();
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\textbf{Name} & \\textbf{Type} & \\textbf{Description}\\\\");
        _builder.newLine();
        {
          for(final Attribute at : attributes) {
            _builder.append("\\hline");
            _builder.newLine();
            String _name = at.getName();
            String _escapedString = this.escapedString(_name);
            _builder.append(_escapedString, "");
            _builder.append(" & ");
            RefableType _type = at.getType();
            DataType _type_1 = _type.getType();
            String _name_1 = _type_1.getName();
            String _escapedString_1 = this.escapedString(_name_1);
            _builder.append(_escapedString_1, "");
            _builder.append(" & ");
            Documentation _docu = at.getDocu();
            CharSequence _generateDocText = this.generateDocText(_docu);
            _builder.append(_generateDocText, "");
            _builder.append("\\\\");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence generateOperationsDoc(final List<StandardOperation> operations) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final StandardOperation op : operations) {
        _builder.append("\\begin{tabular}[ht]{|l|l|}");
        _builder.newLine();
        _builder.append("\\hline\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Name: & ");
        String _name = op.getName();
        String _escapedString = this.escapedString(_name);
        _builder.append(_escapedString, "\t");
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("ReturnType: &  ");
        {
          RefableType _returnType = op.getReturnType();
          boolean _notEquals = (!Objects.equal(_returnType, null));
          if (_notEquals) {
            RefableType _returnType_1 = op.getReturnType();
            DataType _type = _returnType_1.getType();
            String _name_1 = _type.getName();
            String _escapedString_1 = this.escapedString(_name_1);
            _builder.append(_escapedString_1, "\t");
          } else {
            _builder.append("void");
          }
        }
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Arguments: & ");
        {
          EList<VarDecl> _arguments = op.getArguments();
          boolean _hasElements = false;
          for(final VarDecl pa : _arguments) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            String _name_2 = pa.getName();
            String _escapedString_2 = this.escapedString(_name_2);
            _builder.append(_escapedString_2, "\t");
            _builder.append(":");
            RefableType _refType = pa.getRefType();
            DataType _type_1 = _refType.getType();
            String _name_3 = _type_1.getName();
            String _escapedString_3 = this.escapedString(_name_3);
            _builder.append(_escapedString_3, "\t");
          }
        }
        _builder.append("\\\\");
        _builder.newLineIfNotEmpty();
        {
          Documentation _docu = op.getDocu();
          boolean _notEquals_1 = (!Objects.equal(_docu, null));
          if (_notEquals_1) {
            _builder.append("\t");
            _builder.append("\\hline");
            _builder.newLine();
            {
              Documentation _docu_1 = op.getDocu();
              String _string = _docu_1.toString();
              int _length = _string.length();
              boolean _greaterThan = (_length > 85);
              if (_greaterThan) {
                _builder.append("\t");
                _builder.append("\\multicolumn{2} {|p{13cm}|} {");
                Documentation _docu_2 = op.getDocu();
                CharSequence _generateDocText = this.generateDocText(_docu_2);
                _builder.append(_generateDocText, "\t");
                _builder.append("}\\\\");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\\multicolumn{2} {|l|} {");
                Documentation _docu_3 = op.getDocu();
                CharSequence _generateDocText_1 = this.generateDocText(_docu_3);
                _builder.append(_generateDocText_1, "\t");
                _builder.append("}\\\\");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("\\hline");
        _builder.newLine();
        _builder.append("\\end{tabular}");
        _builder.newLine();
        _builder.append("\\newline\\newline\\newline");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence generateDocText(final Documentation doc) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(doc, null));
      if (_notEquals) {
        _builder.append("% begin text from user Documentation");
        _builder.newLine();
        {
          EList<String> _lines = doc.getLines();
          for(final String line : _lines) {
            String _escapedString = this.escapedString(line);
            _builder.append(_escapedString, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("% end text from user Documentation");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private String fileExists(final RoomModel model, final String f) {
    String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
    final String absPath = (_docGenerationTargetPath + f);
    final File file = new File(absPath);
    final boolean exist = file.exists();
    if ((exist == true)) {
      this.logger.logInfo(("File found ! " + f));
      return "true";
    } else {
      this.logger.logInfo(("File not found ! " + f));
      return "false";
    }
  }
  
  private CharSequence includeGraphics(final String filename, final String width, final String caption) {
    CharSequence _xblockexpression = null;
    {
      String latexCaption = caption.replaceAll("_", "\\\\_");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\\centering{}");
      _builder.newLine();
      _builder.append("\\includegraphics[width=");
      _builder.append(width, "");
      _builder.append("]{");
      _builder.append(filename, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\figcaption{");
      _builder.append(latexCaption, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String escapedString(final String text) {
    return text.replace("_", "\\_");
  }
  
  private String getImagePath(final String filename) {
    String filenamei = ((this.IMGDIR_DEFAULT + "/") + filename);
    String _replaceAll = filenamei.replaceAll("\\\\", "/");
    filenamei = _replaceAll;
    return filenamei;
  }
  
  private void saveAs(final CharSequence content, final String filename) {
    this.fileAccess.generateFile(filename, content);
  }
  
  private String docFragmentName(final RoomClass rc) {
    String _name = rc.getName();
    return (_name + ".tex");
  }
  
  private CharSequence generateImport(final RoomClass rc, final String dir) {
    StringConcatenation _builder = new StringConcatenation();
    String _docFragmentName = this.docFragmentName(rc);
    CharSequence _generateImport = this.generateImport(_docFragmentName, dir);
    _builder.append(_generateImport, "");
    return _builder;
  }
  
  private CharSequence generateImport(final String name, final String dir) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\subimport*{");
    _builder.append(dir, "");
    _builder.append("/}{");
    _builder.append(name, "");
    _builder.append("}");
    return _builder;
  }
  
  private CharSequence generateDoc(final RoomClass ac, final DocGen.DocGenContext ctx) {
    if (ac instanceof ActorClass) {
      return _generateDoc((ActorClass)ac, ctx);
    } else if (ac instanceof DataClass) {
      return _generateDoc((DataClass)ac, ctx);
    } else if (ac instanceof SubSystemClass) {
      return _generateDoc((SubSystemClass)ac, ctx);
    } else if (ac instanceof CompoundProtocolClass) {
      return _generateDoc((CompoundProtocolClass)ac, ctx);
    } else if (ac instanceof EnumerationType) {
      return _generateDoc((EnumerationType)ac, ctx);
    } else if (ac instanceof LogicalSystem) {
      return _generateDoc((LogicalSystem)ac, ctx);
    } else if (ac instanceof ProtocolClass) {
      return _generateDoc((ProtocolClass)ac, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ac, ctx).toString());
    }
  }
}
