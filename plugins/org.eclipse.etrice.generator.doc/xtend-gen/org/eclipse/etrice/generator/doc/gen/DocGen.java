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
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
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
        final Consumer<LogicalSystem> _function = (LogicalSystem it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getSystems().forEach(_function);
        final Consumer<LogicalSystem> _function_1 = (LogicalSystem it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getSystems().forEach(_function_1);
        final Consumer<SubSystemClass> _function_2 = (SubSystemClass it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getSubSystemClasses().forEach(_function_2);
        final Consumer<SubSystemClass> _function_3 = (SubSystemClass it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getSubSystemClasses().forEach(_function_3);
        final Consumer<GeneralProtocolClass> _function_4 = (GeneralProtocolClass it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getProtocolClasses().forEach(_function_4);
        final Consumer<GeneralProtocolClass> _function_5 = (GeneralProtocolClass it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getProtocolClasses().forEach(_function_5);
        final Consumer<EnumerationType> _function_6 = (EnumerationType it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getEnumerationTypes().forEach(_function_6);
        final Consumer<EnumerationType> _function_7 = (EnumerationType it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getEnumerationTypes().forEach(_function_7);
        final Consumer<DataClass> _function_8 = (DataClass it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getDataClasses().forEach(_function_8);
        final Consumer<DataClass> _function_9 = (DataClass it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getDataClasses().forEach(_function_9);
        final Consumer<ActorClass> _function_10 = (ActorClass it) -> {
          this.saveAs(this.generateDoc(it, ctx), this.docFragmentName(it));
        };
        model.getActorClasses().forEach(_function_10);
        final Consumer<ActorClass> _function_11 = (ActorClass it) -> {
          referencedModels.addAll(root.getReferencedModels(it));
        };
        model.getActorClasses().forEach(_function_11);
        this.fileAccess.setOutputPath(path);
        this.saveAs(this.generateModelDoc(ctx, referencedModels), file);
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
      String _escapedString = this.escapedString(model.getName());
      _builder.append(_escapedString);
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
              final String relPath = this.appendIfNotEmpty(RelativePathHelpers.getRelativePath(
                this.removeLast(this.roomExt.getDocGenerationTargetPath(model)), this.removeLast(this.roomExt.getDocGenerationTargetPath(refModel)), true), "/");
              _builder.newLineIfNotEmpty();
              _builder.append("\\item \\href{");
              String _replace = relPath.replace("\\", "/");
              String _name = refModel.getName();
              String _escapedString_1 = this.escapedString((_replace + _name));
              _builder.append(_escapedString_1);
              _builder.append(".pdf}{");
              String _escapedString_2 = this.escapedString(refModel.getName());
              _builder.append(_escapedString_2);
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
        boolean _isEmpty_1 = model.getSystems().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\\section{Logical System Classes}");
          _builder.newLine();
          {
            EList<LogicalSystem> _systems = model.getSystems();
            for(final LogicalSystem s : _systems) {
              CharSequence _generateImport = this.generateImport(s, model.getName());
              _builder.append(_generateImport);
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_2 = model.getSubSystemClasses().isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.append("\\section{Subsystem Classes}");
          _builder.newLine();
          {
            EList<SubSystemClass> _subSystemClasses = model.getSubSystemClasses();
            for(final SubSystemClass s_1 : _subSystemClasses) {
              CharSequence _generateImport_1 = this.generateImport(s_1, model.getName());
              _builder.append(_generateImport_1);
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_3 = model.getProtocolClasses().isEmpty();
        boolean _not_3 = (!_isEmpty_3);
        if (_not_3) {
          _builder.append("\\section{Protocol Classes}");
          _builder.newLine();
          {
            EList<GeneralProtocolClass> _protocolClasses = model.getProtocolClasses();
            for(final GeneralProtocolClass c : _protocolClasses) {
              CharSequence _generateImport_2 = this.generateImport(c, model.getName());
              _builder.append(_generateImport_2);
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_4 = model.getEnumerationTypes().isEmpty();
        boolean _not_4 = (!_isEmpty_4);
        if (_not_4) {
          _builder.append("\\section{Enumeration Types}");
          _builder.newLine();
          {
            EList<EnumerationType> _enumerationTypes = model.getEnumerationTypes();
            for(final EnumerationType e : _enumerationTypes) {
              CharSequence _generateImport_3 = this.generateImport(e, model.getName());
              _builder.append(_generateImport_3);
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_5 = model.getDataClasses().isEmpty();
        boolean _not_5 = (!_isEmpty_5);
        if (_not_5) {
          _builder.append("\\section{Data Classes}");
          _builder.newLine();
          {
            EList<DataClass> _dataClasses = model.getDataClasses();
            for(final DataClass c_1 : _dataClasses) {
              CharSequence _generateImport_4 = this.generateImport(c_1, model.getName());
              _builder.append(_generateImport_4);
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\\newpage");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_6 = model.getActorClasses().isEmpty();
        boolean _not_6 = (!_isEmpty_6);
        if (_not_6) {
          _builder.append("\\section{Actor Classes}");
          _builder.newLine();
          {
            EList<ActorClass> _actorClasses = model.getActorClasses();
            for(final ActorClass c_2 : _actorClasses) {
              CharSequence _generateImport_5 = this.generateImport(c_2, model.getName());
              _builder.append(_generateImport_5);
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
      String _escapedString = this.escapedString(system.getName());
      _builder.append(_escapedString);
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      CharSequence _generateDocText = this.generateDocText(system.getDocu());
      _builder.append(_generateDocText);
      _builder.newLineIfNotEmpty();
      _builder.append("\\level{3}{Instance Tree}");
      _builder.newLine();
      {
        boolean _equals = this.fileExists(ctx.model, this.getImagePath(filename)).equals("true");
        if (_equals) {
          String _imagePath = this.getImagePath(filename);
          String _name_1 = system.getName();
          String _plus = (_name_1 + " Instance Tree");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics);
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
      String _escapedString = this.escapedString(ssc.getName());
      final String filename = (_escapedString + "_structure.jpg");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{");
      String _escapedString_1 = this.escapedString(ssc.getName());
      _builder.append(_escapedString_1);
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      CharSequence _generateDocText = this.generateDocText(ssc.getDocu());
      _builder.append(_generateDocText);
      _builder.newLineIfNotEmpty();
      _builder.append("\\level{3}{Structure}");
      _builder.newLine();
      {
        boolean _equals = this.fileExists(ctx.model, this.getImagePath(filename)).equals("true");
        if (_equals) {
          String _imagePath = this.getImagePath(filename);
          String _name = ssc.getName();
          String _plus = (_name + " Structure");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics);
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
    String _escapedString = this.escapedString(dc.getName());
    _builder.append(_escapedString);
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    CharSequence _generateDocText = this.generateDocText(dc.getDocu());
    _builder.append(_generateDocText);
    _builder.newLineIfNotEmpty();
    {
      PrimitiveType _primitiveType = dc.getPrimitiveType();
      boolean _notEquals = (!Objects.equal(_primitiveType, null));
      if (_notEquals) {
        _builder.append("The literals of this enumeration are based on PrimitiveType ");
        String _escapedString_1 = this.escapedString(dc.getPrimitiveType().getName());
        _builder.append(_escapedString_1);
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
        String _escapedString_2 = this.escapedString(lit.getName());
        _builder.append(_escapedString_2);
        _builder.append(" & ");
        long _literalValue = lit.getLiteralValue();
        _builder.append(_literalValue);
        _builder.append(" & 0x");
        String _hexString = Long.toHexString(lit.getLiteralValue());
        _builder.append(_hexString);
        _builder.append(" & ");
        String _binaryString = Long.toBinaryString(lit.getLiteralValue());
        _builder.append(_binaryString);
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
    String _escapedString = this.escapedString(dc.getName());
    _builder.append(_escapedString);
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    CharSequence _generateDocText = this.generateDocText(dc.getDocu());
    _builder.append(_generateDocText);
    _builder.newLineIfNotEmpty();
    _builder.append("\\level{3}{Attributes}");
    _builder.newLine();
    CharSequence _generateAttributesDoc = this.generateAttributesDoc(dc.getAttributes());
    _builder.append(_generateAttributesDoc);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\level{3}{Operations}");
    _builder.newLine();
    CharSequence _generateOperationsDoc = this.generateOperationsDoc(dc.getOperations());
    _builder.append(_generateOperationsDoc);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _generateDoc(final ProtocolClass pc, final DocGen.DocGenContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {");
    String _escapedString = this.escapedString(pc.getName());
    _builder.append(_escapedString);
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    CharSequence _generateDocText = this.generateDocText(pc.getDocu());
    _builder.append(_generateDocText);
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = this._roomHelpers.getAllIncomingMessages(pc).isEmpty();
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
          List<Message> _allIncomingMessages = this._roomHelpers.getAllIncomingMessages(pc);
          for(final Message ims : _allIncomingMessages) {
            _builder.append("\\hline");
            _builder.newLine();
            String _escapedString_1 = this.escapedString(ims.getName());
            _builder.append(_escapedString_1);
            _builder.append(" & ");
            {
              VarDecl _data = ims.getData();
              boolean _notEquals = (!Objects.equal(_data, null));
              if (_notEquals) {
                _builder.append(" ");
                String _escapedString_2 = this.escapedString(ims.getData().getName());
                _builder.append(_escapedString_2);
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            {
              VarDecl _data_1 = ims.getData();
              boolean _notEquals_1 = (!Objects.equal(_data_1, null));
              if (_notEquals_1) {
                _builder.append(" ");
                String _escapedString_3 = this.escapedString(ims.getData().getRefType().getType().getName());
                _builder.append(_escapedString_3);
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            CharSequence _generateDocText_1 = this.generateDocText(ims.getDocu());
            _builder.append(_generateDocText_1);
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
      boolean _isEmpty_1 = this._roomHelpers.getAllOutgoingMessages(pc).isEmpty();
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
          List<Message> _allOutgoingMessages = this._roomHelpers.getAllOutgoingMessages(pc);
          for(final Message oms : _allOutgoingMessages) {
            _builder.append("\\hline");
            _builder.newLine();
            String _escapedString_4 = this.escapedString(oms.getName());
            _builder.append(_escapedString_4);
            _builder.append(" & ");
            {
              VarDecl _data_2 = oms.getData();
              boolean _notEquals_2 = (!Objects.equal(_data_2, null));
              if (_notEquals_2) {
                _builder.append(" ");
                String _escapedString_5 = this.escapedString(oms.getData().getName());
                _builder.append(_escapedString_5);
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            {
              VarDecl _data_3 = oms.getData();
              boolean _notEquals_3 = (!Objects.equal(_data_3, null));
              if (_notEquals_3) {
                _builder.append(" ");
                String _escapedString_6 = this.escapedString(oms.getData().getRefType().getType().getName());
                _builder.append(_escapedString_6);
                _builder.append(" ");
              }
            }
            _builder.append(" & ");
            CharSequence _generateDocText_2 = this.generateDocText(oms.getDocu());
            _builder.append(_generateDocText_2);
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
    String _escapedString = this.escapedString(pc.getName());
    _builder.append(_escapedString);
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    CharSequence _generateDocText = this.generateDocText(pc.getDocu());
    _builder.append(_generateDocText);
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
        String _escapedString_1 = this.escapedString(sub.getName());
        _builder.append(_escapedString_1);
        _builder.append(" & ");
        String _escapedString_2 = this.escapedString(sub.getProtocol().getName());
        _builder.append(_escapedString_2);
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
      String _escapedString = this.escapedString(ac.getName());
      _builder.append(_escapedString);
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      CharSequence _generateDocText = this.generateDocText(ac.getDocu());
      _builder.append(_generateDocText);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        if ((this.fileExists(ctx.model, this.getImagePath(filename)).equals("true") && ((!this._roomHelpers.getAllInterfaceItems(ac).isEmpty()) || (!ac.getActorRefs().isEmpty())))) {
          _builder.append("\\level{3}{Structure}");
          _builder.newLine();
          CharSequence _generateDocText_1 = this.generateDocText(ac.getStructureDocu());
          _builder.append(_generateDocText_1);
          _builder.newLineIfNotEmpty();
          String _imagePath = this.getImagePath(filename);
          String _name_1 = ac.getName();
          String _plus = (_name_1 + " Structure");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics);
          _builder.newLineIfNotEmpty();
        } else {
          Documentation _structureDocu = ac.getStructureDocu();
          boolean _notEquals = (!Objects.equal(_structureDocu, null));
          if (_notEquals) {
            _builder.append("\\level{3}{Structure}");
            _builder.newLine();
            CharSequence _generateDocText_2 = this.generateDocText(ac.getStructureDocu());
            _builder.append(_generateDocText_2);
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty = this._roomHelpers.getAllPorts(ac).isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("\\level{3}{Ports}");
          _builder.newLine();
          String _generatePortDoc = this.generatePortDoc(ac);
          _builder.append(_generatePortDoc);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        boolean _isBehaviorAnnotationPresent = this._roomHelpers.isBehaviorAnnotationPresent(ac, "BehaviorManual");
        if (_isBehaviorAnnotationPresent) {
          _builder.append("\\level{3}{Behavior}");
          _builder.newLine();
          CharSequence _generateDocText_3 = this.generateDocText(ac.getBehaviorDocu());
          _builder.append(_generateDocText_3);
          _builder.newLineIfNotEmpty();
          _builder.append("The behavior for ActorClass ");
          String _name_2 = ac.getName();
          _builder.append(_name_2);
          _builder.append(" is implemented manually.");
          _builder.newLineIfNotEmpty();
        } else {
          boolean _hasNonEmptyStateMachine = this._roomHelpers.hasNonEmptyStateMachine(ac);
          if (_hasNonEmptyStateMachine) {
            _builder.append("\\level{3}{Behavior}");
            _builder.newLine();
            CharSequence _generateDocText_4 = this.generateDocText(ac.getBehaviorDocu());
            _builder.append(_generateDocText_4);
            _builder.newLineIfNotEmpty();
            CharSequence _generateFsmDoc = this.generateFsmDoc(ctx.model, ac);
            _builder.append(_generateFsmDoc);
            _builder.newLineIfNotEmpty();
          } else {
            Documentation _behaviorDocu = ac.getBehaviorDocu();
            boolean _notEquals_1 = (!Objects.equal(_behaviorDocu, null));
            if (_notEquals_1) {
              _builder.append("\\level{3}{Behavior}");
              _builder.newLine();
              CharSequence _generateDocText_5 = this.generateDocText(ac.getBehaviorDocu());
              _builder.append(_generateDocText_5);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_1 = ac.getAttributes().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("\\level{3}{Attributes}");
          _builder.newLine();
          CharSequence _generateAttributesDoc = this.generateAttributesDoc(ac.getAttributes());
          _builder.append(_generateAttributesDoc);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        boolean _isEmpty_2 = ac.getOperations().isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.append("\\level{3}{Operations}");
          _builder.newLine();
          CharSequence _generateOperationsDoc = this.generateOperationsDoc(ac.getOperations());
          _builder.append(_generateOperationsDoc);
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
        boolean _equals = this.fileExists(model, this.getImagePath(filename)).equals("true");
        if (_equals) {
          String _imagePath = this.getImagePath(filename);
          String _name_1 = ac.getName();
          String _plus = (_name_1 + " Top State");
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus);
          _builder.append(_includeGraphics);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        EList<State> _states = ac.getStateMachine().getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _notEquals = (!Objects.equal(_docu, null));
            if (_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _replaceAll = this._codegenHelpers.getGenStatePathName(s).replaceAll("_", "\\\\_");
              _builder.append(_replaceAll);
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              CharSequence _generateDocText = this.generateDocText(s.getDocu());
              _builder.append(_generateDocText);
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        EList<ChoicePoint> _chPoints = ac.getStateMachine().getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_1 = c.getDocu();
            boolean _notEquals_1 = (!Objects.equal(_docu_1, null));
            if (_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _escapedString = this.escapedString(c.getName());
              _builder.append(_escapedString);
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              CharSequence _generateDocText_1 = this.generateDocText(c.getDocu());
              _builder.append(_generateDocText_1);
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
        EList<State> _states_1 = ac.getStateMachine().getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this._roomHelpers.isLeaf(s_1);
            boolean _not = (!_isLeaf);
            if (_not) {
              String _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc);
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
      _xifexpression = Integer.valueOf(p.getMultiplicity()).toString();
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
        String _escapedString = this.escapedString(at.getName());
        _builder.append(_escapedString);
        _builder.append(" & ");
        String _escapedString_1 = this.escapedString(at.getProtocol().getName());
        _builder.append(_escapedString_1);
        _builder.append(" & ");
        String _type = this.getType(at);
        _builder.append(_type);
        _builder.append(" & ");
        String _kind = this.getKind(at);
        _builder.append(_kind);
        _builder.append(" & ");
        String _multAsText = this.getMultAsText(at);
        _builder.append(_multAsText);
        _builder.append(" & ");
        CharSequence _generateDocText = this.generateDocText(at.getDocu());
        _builder.append(_generateDocText);
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
      String _replaceAll = this._codegenHelpers.getGenStatePathName(state).replaceAll("_", "\\\\_");
      _builder.append(_replaceAll);
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      {
        boolean _equals = this.fileExists(model, this.getImagePath(filename)).equals("true");
        if (_equals) {
          String _imagePath = this.getImagePath(filename);
          String _name_1 = ac.getName();
          String _plus_2 = (_name_1 + "_");
          String _genStatePathName_1 = this._codegenHelpers.getGenStatePathName(state);
          String _plus_3 = (_plus_2 + _genStatePathName_1);
          CharSequence _includeGraphics = this.includeGraphics(_imagePath, this.IMGWIDTH_DEFAULT, _plus_3);
          _builder.append(_includeGraphics);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      {
        EList<State> _states = state.getSubgraph().getStates();
        for(final State s : _states) {
          {
            Documentation _docu = s.getDocu();
            boolean _notEquals = (!Objects.equal(_docu, null));
            if (_notEquals) {
              _builder.append("\\textbf{State description} \\textit{");
              String _replaceAll_1 = this._codegenHelpers.getGenStatePathName(s).replaceAll("_", "\\\\_");
              _builder.append(_replaceAll_1);
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              CharSequence _generateDocText = this.generateDocText(s.getDocu());
              _builder.append(_generateDocText);
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline\\newline");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      {
        EList<ChoicePoint> _chPoints = state.getSubgraph().getChPoints();
        for(final ChoicePoint c : _chPoints) {
          {
            Documentation _docu_1 = c.getDocu();
            boolean _notEquals_1 = (!Objects.equal(_docu_1, null));
            if (_notEquals_1) {
              _builder.append("\\textbf{Choicepoint description} \\textit{");
              String _escapedString = this.escapedString(c.getName());
              _builder.append(_escapedString);
              _builder.append("}:");
              _builder.newLineIfNotEmpty();
              _builder.append("\\newline");
              _builder.newLine();
              CharSequence _generateDocText_1 = this.generateDocText(c.getDocu());
              _builder.append(_generateDocText_1);
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
        EList<State> _states_1 = state.getSubgraph().getStates();
        for(final State s_1 : _states_1) {
          {
            boolean _isLeaf = this._roomHelpers.isLeaf(s_1);
            boolean _not = (!_isLeaf);
            if (_not) {
              String _generateStateDoc = this.generateStateDoc(model, ac, s_1);
              _builder.append(_generateStateDoc);
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
            String _escapedString = this.escapedString(at.getName());
            _builder.append(_escapedString);
            _builder.append(" & ");
            String _escapedString_1 = this.escapedString(at.getType().getType().getName());
            _builder.append(_escapedString_1);
            _builder.append(" & ");
            CharSequence _generateDocText = this.generateDocText(at.getDocu());
            _builder.append(_generateDocText);
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
        String _escapedString = this.escapedString(op.getName());
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
            String _escapedString_1 = this.escapedString(op.getReturnType().getType().getName());
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
            String _escapedString_2 = this.escapedString(pa.getName());
            _builder.append(_escapedString_2, "\t");
            _builder.append(":");
            String _escapedString_3 = this.escapedString(pa.getRefType().getType().getName());
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
              int _length = op.getDocu().toString().length();
              boolean _greaterThan = (_length > 85);
              if (_greaterThan) {
                _builder.append("\t");
                _builder.append("\\multicolumn{2} {|p{13cm}|} {");
                CharSequence _generateDocText = this.generateDocText(op.getDocu());
                _builder.append(_generateDocText, "\t");
                _builder.append("}\\\\");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("\\multicolumn{2} {|l|} {");
                CharSequence _generateDocText_1 = this.generateDocText(op.getDocu());
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
            _builder.append(_escapedString);
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
      _builder.append(width);
      _builder.append("]{");
      _builder.append(filename);
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.append("\\figcaption{");
      _builder.append(latexCaption);
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
    filenamei = filenamei.replaceAll("\\\\", "/");
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
    CharSequence _generateImport = this.generateImport(this.docFragmentName(rc), dir);
    _builder.append(_generateImport);
    return _builder;
  }
  
  private CharSequence generateImport(final String name, final String dir) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\subimport*{");
    _builder.append(dir);
    _builder.append("/}{");
    _builder.append(name);
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
