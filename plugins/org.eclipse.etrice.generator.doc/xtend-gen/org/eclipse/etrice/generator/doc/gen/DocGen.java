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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.generator.base.CodegenHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class DocGen {
  @Inject
  @Extension
  private JavaIoFileSystemAccess fileAccess;
  
  @Inject
  @Extension
  private RoomExtensions roomExt;
  
  @Inject
  private ILogger logger;
  
  public void doGenerate(final Root root) {
    EList<RoomModel> _models = root.getModels();
    for (final RoomModel model : _models) {
      {
        String path = this.roomExt.getDocGenerationTargetPath(model);
        String _name = model.getName();
        String file = (_name + ".tex");
        String _plus = ("generating LaTeX documentation: \'" + file);
        String _plus_1 = (_plus + "\' in \'");
        String _plus_2 = (_plus_1 + path);
        String _plus_3 = (_plus_2 + "\'");
        this.logger.logInfo(_plus_3);
        this.fileAccess.setOutputPath(path);
        CharSequence _generateModelDoc = this.generateModelDoc(root, model);
        this.fileAccess.generateFile(file, _generateModelDoc);
      }
    }
  }
  
  private CharSequence generateModelDoc(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\documentclass[titlepage]{article}");
    _builder.newLine();
    _builder.append("\\usepackage{graphicx}");
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
    _builder.append("\\title{�model.name� Model Documentation}");
    _builder.newLine();
    _builder.append("\\date{\\today}");
    _builder.newLine();
    _builder.append("\\author{generated by eTrice}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{document}");
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
    _builder.append("�model.docu.generateDocText�");
    _builder.newLine();
    _builder.append("\\section{Logical System Description}");
    _builder.newLine();
    _builder.append("�root.generateAllLogicalSystemDocs(model)�");
    _builder.newLine();
    _builder.append("\\section{Subsystem Description}");
    _builder.newLine();
    _builder.append("�root.generateAllSubSysClassDocs(model)�");
    _builder.newLine();
    _builder.append("\\section{Protocol Class Description}");
    _builder.newLine();
    _builder.append("�root.generateAllProtocolClassDocs(model)�");
    _builder.newLine();
    _builder.append("\\section{Data Class Description}");
    _builder.newLine();
    _builder.append("�root.generateAllDataClassDocs(model)�");
    _builder.newLine();
    _builder.append("\\section{Actor Class Description}");
    _builder.newLine();
    _builder.append("�root.generateAllActorClassDocs(model)�");
    _builder.newLine();
    _builder.append("\\end{document}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateAllLogicalSystemDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR sys : model.systems�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�root.generateLogicalSystemDoc(model, sys)�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateLogicalSystemDoc(final Root root, final RoomModel model, final LogicalSystem system) {
    CharSequence _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _plus = (_docGenerationTargetPath + "images\\");
      String _name = system.getName();
      String _plus_1 = (_plus + _name);
      String filenamei = (_plus_1 + "_instanceTree.jpg");
      String _replaceAll = filenamei.replaceAll("\\\\", "/");
      filenamei = _replaceAll;
      String latexFilenamei = filenamei.replaceAll("/", "//");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{�system.name�}");
      _builder.newLine();
      _builder.append("�system.docu.generateDocText�");
      _builder.newLine();
      _builder.append("\\level{3}{Instance Tree}");
      _builder.newLine();
      _builder.append("�IF fileExists(filenamei).equals(\"true\")�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�includeGraphics(latexFilenamei,\"0.5\",system.name + \" Instance Tree\")�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateAllSubSysClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR ssc : model.subSystemClasses�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�root.generateSubSysClassDoc(model, ssc)�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateSubSysClassDoc(final Root root, final RoomModel model, final SubSystemClass ssc) {
    CharSequence _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _plus = (_docGenerationTargetPath + "images\\");
      String _name = ssc.getName();
      String _plus_1 = (_plus + _name);
      String filename = (_plus_1 + "_structure.jpg");
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String latexFilename = filename.replaceAll("/", "//");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{�ssc.name�}");
      _builder.newLine();
      _builder.append("�ssc.docu.generateDocText�");
      _builder.newLine();
      _builder.append("\\level{3}{Structure}");
      _builder.newLine();
      _builder.append("�IF fileExists(filename).equals(\"true\")�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�includeGraphics(latexFilename,\"0.4\",ssc.name + \" Structure\")�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateAllDataClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR dc : model.dataClasses�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�root.generateDataClassDoc(dc)�");
    _builder.newLine();
    _builder.append("�ENDFOR�\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateDataClassDoc(final Root root, final DataClass dc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {�dc.name�}");
    _builder.newLine();
    _builder.append("�dc.docu.generateDocText�");
    _builder.newLine();
    _builder.append("\\level{3}{Attributes}");
    _builder.newLine();
    _builder.append("�dc.attributes.generateAttributesDoc�");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\level{3}{Operations}");
    _builder.newLine();
    _builder.append("�dc.operations.generateOperationsDoc�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateAllProtocolClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR pc : model.protocolClasses�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�root.generateProtocolClassDoc(pc)�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateProtocolClassDoc(final Root root, final ProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {�pc.name�}");
    _builder.newLine();
    _builder.append("�pc.docu.generateDocText�");
    _builder.newLine();
    _builder.append("\\level{3}{Incoming Messages}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("Message & Data & Description\\\\");
    _builder.newLine();
    _builder.append("�FOR ims : pc.allIncomingMessages�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ims.name� & �IF ims.data != null� �ims.data.name� �ENDIF� & �ims.docu.generateDocText�\\\\");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\level{3}{Outgoing Messages}");
    _builder.newLine();
    _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("Message & Data & Description\\\\");
    _builder.newLine();
    _builder.append("�FOR oms : pc.allOutgoingMessages�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�oms.name� & �IF oms.data != null� �oms.data.name� �ENDIF� & �oms.docu.generateDocText�\\\\");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}\t\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateProtocolClassDoc(final Root root, final CompoundProtocolClass pc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\level{2} {�pc.name�}");
    _builder.newLine();
    _builder.append("�pc.docu.generateDocText�");
    _builder.newLine();
    _builder.append("\\level{3}{Sub Protocols}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{tabular}[ht]{|l|l|}");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("Name & Protocol\\\\");
    _builder.newLine();
    _builder.append("�FOR sub : pc.subProtocols�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�sub.name� & �sub.protocol.name�\\\\");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\\end{tabular}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateAllActorClassDocs(final Root root, final RoomModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR ac : model.actorClasses�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�root.generateActorClassDoc(model,ac)�");
    _builder.newLine();
    _builder.append("�ENDFOR�\t\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateActorClassDoc(final Root root, final RoomModel model, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _plus = (_docGenerationTargetPath + "images\\");
      String _name = ac.getName();
      String _plus_1 = (_plus + _name);
      String filename = (_plus_1 + "_structure.jpg");
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String latexFilename = filename.replaceAll("/", "//");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{2}{�ac.name�}");
      _builder.newLine();
      _builder.append("�ac.docu.generateDocText�");
      _builder.newLine();
      _builder.append("\\level{3}{Structure}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�IF fileExists(filename).equals(\"true\")�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�includeGraphics(latexFilename,\"0.4\",ac.name + \" Structure\")�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\level{3}{Attributes}");
      _builder.newLine();
      _builder.append("�ac.attributes.generateAttributesDoc�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\level{3}{Operations}");
      _builder.newLine();
      _builder.append("�ac.operations.generateOperationsDoc�");
      _builder.newLine();
      _builder.append("�IF ac.hasNonEmptyStateMachine�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("\\level{3}{Statemachine}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�generateFsmDoc(model, ac)�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFsmDoc(final RoomModel model, final ActorClass ac) {
    CharSequence _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _plus = (_docGenerationTargetPath + "images\\");
      String _name = ac.getName();
      String _plus_1 = (_plus + _name);
      String filename = (_plus_1 + "_behavior.jpg");
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String latexFilename = filename.replaceAll("/", "//");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Top Level}");
      _builder.newLine();
      _builder.append("�IF fileExists(filename).equals(\"true\")�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�includeGraphics(latexFilename,\"0.4\",ac.name + \" Top State\")�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      _builder.append("�FOR s : ac.stateMachine.states�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF s.docu != null�\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\textbf{State description} \\textit{�s.genStatePathName.replaceAll(\"_\",\"\\\\\\\\_\")�}:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateDocText(s.docu)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline\\newline");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR c : ac.stateMachine.chPoints�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF c.docu != null�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\textbf{Choicepoint description} \\textit{�c.name�}:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateDocText(c.docu)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline\\newline");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR s : ac.stateMachine.states�\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF !s.isLeaf�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateStateDoc(model, ac, s)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�\t\t");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private String generateStateDoc(final RoomModel model, final ActorClass ac, final State state) {
    String _xblockexpression = null;
    {
      String _docGenerationTargetPath = this.roomExt.getDocGenerationTargetPath(model);
      String _plus = (_docGenerationTargetPath + "images\\");
      String _name = ac.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + "_");
      String _genStatePathName = CodegenHelpers.getGenStatePathName(state);
      String _plus_3 = (_plus_2 + _genStatePathName);
      String filename = (_plus_3 + "_behavior.jpg");
      String _replaceAll = filename.replaceAll("\\\\", "/");
      filename = _replaceAll;
      String latexFilename = filename.replaceAll("/", "//");
      String _plus_4 = ("Gen Filename: " + filename);
      this.logger.logInfo(_plus_4);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\level{4}{Subgraph �state.genStatePathName.replaceAll(\"_\",\"\\\\\\\\_\")�}");
      _builder.newLine();
      _builder.append("�IF fileExists(filename).equals(\"true\")�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�includeGraphics(latexFilename,\"0.4\",ac.name + \"_\" + state.genStatePathName)�");
      _builder.newLine();
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\\begin{par}");
      _builder.newLine();
      _builder.append("�FOR s : state.subgraph.states�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF s.docu != null�\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\textbf{State description} \\textit{�s.genStatePathName.replaceAll(\"_\",\"\\\\\\\\_\")�}:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateDocText(s.docu)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline\\newline");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.newLine();
      _builder.append("�FOR c : state.subgraph.chPoints�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF c.docu != null�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\textbf{Choicepoint description} \\textit{�c.name�}:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateDocText(c.docu)�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\\newline\\newline");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�");
      _builder.newLine();
      _builder.append("\\end{par}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("�FOR s : state.subgraph.states�\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�IF !s.isLeaf�");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("�generateStateDoc(model, ac, s)�");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("�ENDIF�");
      _builder.newLine();
      _builder.append("�ENDFOR�\t\t");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  private CharSequence generateAttributesDoc(final List<Attribute> attributes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF !attributes.empty�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\begin{tabular}[ht]{|l|l|l|}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Name & Type & Description\\\\");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR at : attributes�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�at.name� & �at.type.type.name� & �generateDocText(at.docu)�\\\\");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\end{tabular}");
    _builder.newLine();
    _builder.append("�ENDIF�\t");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateOperationsDoc(final List<StandardOperation> operations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�FOR op : operations�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\begin{tabular}[ht]{|l|l|}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\hline\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Name: & �op.name�\\\\");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ReturnType: &  �IF op.returnType != null��op.returnType.type.name��ELSE�void�ENDIF�\\\\");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Arguments: & �FOR pa : op.arguments SEPARATOR \", \"��pa.name�:�pa.refType.type.name��ENDFOR�\\\\");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�IF op.docu != null�");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�IF op.docu.toString.length > 85�");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\\multicolumn{2} {|p{13cm}|} {�generateDocText(op.docu)�}\\\\");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�ELSE�");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\\multicolumn{2} {|l|} {�generateDocText(op.docu)�}\\\\");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDIF�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\\hline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\end{tabular}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\newline\\newline\\newline");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateDocText(final Documentation doc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�IF doc!=null�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�doc.lines.join()�");
    _builder.newLine();
    _builder.append("�ENDIF�\t\t");
    _builder.newLine();
    return _builder;
  }
  
  private String fileExists(final String f) {
    File _file = new File(f);
    final File file = _file;
    final boolean exist = file.exists();
    boolean _equals = (exist == true);
    if (_equals) {
      String _plus = ("File found ! " + f);
      this.logger.logInfo(_plus);
      return "true";
    } else {
      String _plus_1 = ("File not found ! " + f);
      this.logger.logInfo(_plus_1);
      return "false";
    }
  }
  
  private CharSequence includeGraphics(final String filename, final String scale, final String caption) {
    CharSequence _xblockexpression = null;
    {
      String latexCaption = caption.replaceAll("_", "\\\\_");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\begin{center}");
      _builder.newLine();
      _builder.append("\\includegraphics[scale=�scale�]{�filename�}");
      _builder.newLine();
      _builder.append("\\figcaption{�latexCaption�}");
      _builder.newLine();
      _builder.append("\\end{center}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateProtocolClassDoc(final Root root, final GeneralProtocolClass pc) {
    if (pc instanceof CompoundProtocolClass) {
      return _generateProtocolClassDoc(root, (CompoundProtocolClass)pc);
    } else if (pc instanceof ProtocolClass) {
      return _generateProtocolClassDoc(root, (ProtocolClass)pc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(root, pc).toString());
    }
  }
}
