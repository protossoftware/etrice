/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Jung, Thomas Schuetz (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.doc.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.File
import java.util.List
import java.util.Set
import org.eclipse.etrice.core.common.base.Documentation
import org.eclipse.etrice.core.common.base.util.RelativePathHelpers
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.CompoundProtocolClass
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.LogicalSystem
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.StandardOperation
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.fsm.base.CodegenHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.core.genmodel.fsm.ILogger

@Singleton
class DocGen {

	@Inject extension RoomHelpers
	@Inject extension CodegenHelpers
	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	@Inject ILogger logger
	
	final val IMGDIR_DEFAULT = "./images"
	final val IMGWIDTH_DEFAULT = "1.0\\textwidth"
	
	static class DocGenContext {
		val Root root
		val RoomModel model
		
		new(Root r, RoomModel m) {
			root = r
			model = m
		}
		
	}
	
	def doGenerate(Root root) {
		for (model: root.models) {
			val ctx = new DocGen.DocGenContext(root,model)
			var path = model.docGenerationTargetPath
			var file = model.name+".tex"
			val Set<RoomModel> referencedModels = newHashSet
			logger.logInfo("generating LaTeX documentation: '"+file+"' in '"+path+"'")
			
			// Save documentation fragments for RoomModel children
			fileAccess.setOutputPath(path+model.name)
			model.systems.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.systems.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			model.subSystemClasses.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.subSystemClasses.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			model.protocolClasses.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.protocolClasses.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			model.enumerationTypes.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.enumerationTypes.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			model.dataClasses.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.dataClasses.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			model.actorClasses.forEach[generateDoc(ctx).saveAs(docFragmentName)]
			model.actorClasses.forEach[referencedModels.addAll(root.getReferencedModels(it))]
			
			// Save top-level documentation for RoomModel
			fileAccess.setOutputPath(path)
			generateModelDoc(ctx, referencedModels).saveAs(file)
			
//			logger.logInfo("main path "+model.docGenerationTargetPath)
//			referencedModels.forEach[logger.logInfo("ref path "+docGenerationTargetPath+" - "
//				+RelativePathHelpers.getRelativePath(
//					model.docGenerationTargetPath.removeLast, docGenerationTargetPath.removeLast, true)
//			)]
		}
	}
	
	def private removeLast(String str) {
		str.substring(0, str.length-1)
	}
	
	def private appendIfNotEmpty(String txt, String suffix) {
		if (txt.empty)
			txt
		else
			txt+suffix
	}
	
	def private generateModelDoc(DocGen.DocGenContext ctx, Set<RoomModel> referencedModels) {
		var model = ctx.model
		'''
		\documentclass[titlepage]{article}
		\usepackage{import}
		\usepackage{graphicx}
		\usepackage{xr}
		\usepackage{hyperref}
		\IfFileExists{../doc/userinputs.tex}{\subimport{../doc/}{userinputs.tex}}{} %hook for conditional user-specific inputs, includes, macros, ... 
		\usepackage[a4paper,text={160mm,255mm},centering,headsep=5mm,footskip=10mm]{geometry}
		\usepackage{nonfloat}
		\parindent 0pt
		\makeatletter
		\newcommand\level[1]{%
		   \ifcase#1\relax\expandafter\chapter\or
		     \expandafter\section\or
		     \expandafter\subsection\or
		     \expandafter\subsubsection\else
		     \def\next{\@level{#1}}\expandafter\next
		   \fi}
		
		\newcommand{\@level}[1]{%
		\@startsection{level#1}
		     {#1}
		     {\z@}%
		     {-3.25ex\@plus -1ex \@minus -.2ex}%
		     {1.5ex \@plus .2ex}%
		     {\normalfont\normalsize\bfseries}}
		
		\newdimen\@leveldim
		 \newdimen\@dotsdim
		 {\normalfont\normalsize
		  \sbox\z@{0}\global\@leveldim=\wd\z@
		  \sbox\z@{.}\global\@dotsdim=\wd\z@
		 }  
		\newcounter{level4}[subsubsection]
		 \@namedef{thelevel4}{\thesubsubsection.\arabic{level4}}
		 \@namedef{level4mark}#1{}
		 \def\l@section{\@dottedtocline{1}{0pt}{\dimexpr\@leveldim*4+\@dotsdim*1+6pt\relax}}
		 \def\l@subsection{\@dottedtocline{2}{0pt}{\dimexpr\@leveldim*5+\@dotsdim*2+6pt\relax}}
		 \def\l@subsubsection{\@dottedtocline{3}{0pt}{\dimexpr\@leveldim*6+\@dotsdim*3+6pt\relax}}
		 \@namedef{l@level4}{\@dottedtocline{4}{0pt}{\dimexpr\@leveldim*7+\@dotsdim*4+6pt\relax}}
		
		\count@=4
		 \def\@ncp#1{\number\numexpr\count@+#1\relax}
		 \loop\ifnum\count@<100
		   \begingroup\edef\x{\endgroup
		     \noexpand\newcounter{level\@ncp{1}}[level\number\count@]
		     \noexpand\@namedef{thelevel\@ncp{1}}{%
		       \noexpand\@nameuse{thelevel\@ncp{0}}.\noexpand\arabic{level\@ncp{0}}}
		     \noexpand\@namedef{level\@ncp{1}mark}####1{}%
		     \noexpand\@namedef{l@level\@ncp{1}}%
		       {\noexpand\@dottedtocline{\@ncp{1}}{0pt}{\the\dimexpr\@leveldim*\@ncp{5}+\@dotsdim*\@ncp{0}\relax}}}%
		   \x
		   \advance\count@\@ne
		 \repeat
		 \makeatother
		 \setcounter{secnumdepth}{100}
		 \setcounter{tocdepth}{100}


		\title{«model.name.escapedString» Model Documentation}
		\date{\today}
		\author{generated by eTrice}
		
		\begin{document}
		
		\pagestyle{plain}
		\maketitle
		\tableofcontents

		\newpage
		\listoffigures
		\newpage
		\section{Model Description}
		
		«IF !referencedModels.empty»
			\section{Referenced Models}
			
			\begin{itemize}
			«FOR refModel : referencedModels.sortBy[name]»
				«val relPath = RelativePathHelpers.getRelativePath(
					model.docGenerationTargetPath.removeLast, refModel.docGenerationTargetPath.removeLast, true).appendIfNotEmpty("/")»
				\item \href{«(relPath.replace("\\", "/")+refModel.name).escapedString».pdf}{«refModel.name.escapedString»}
			«ENDFOR»
			\end{itemize}
			\newpage
		«ENDIF»
		
		«IF !model.systems.empty»
			\section{Logical System Classes}
			«FOR s : model.systems»
				«s.generateImport(model.name)»
			«ENDFOR»
			\newpage
		«ENDIF»
		
		«IF !model.subSystemClasses.empty»
			\section{Subsystem Classes}
			«FOR s : model.subSystemClasses»
				«s.generateImport(model.name)»
			«ENDFOR»
			\newpage
		«ENDIF»
		
		«IF !model.protocolClasses.empty»
			\section{Protocol Classes}
			«FOR c : model.protocolClasses»
				«c.generateImport(model.name)»
			«ENDFOR»
			\newpage
		«ENDIF»
		
		«IF !model.enumerationTypes.empty»
			\section{Enumeration Types}
			«FOR e : model.enumerationTypes»
				«e.generateImport(model.name)»
			«ENDFOR»
			\newpage
		«ENDIF»
		
		«IF !model.dataClasses.empty»
			\section{Data Classes}
			«FOR c : model.dataClasses»
				«c.generateImport(model.name)»
			«ENDFOR»
			\newpage
		«ENDIF»
		
		«IF !model.actorClasses.empty»
			\section{Actor Classes}
			«FOR c : model.actorClasses»
				«c.generateImport(model.name)»
			«ENDFOR»
		«ENDIF»
		\end{document}
	'''
	}
	
	def private dispatch generateDoc(LogicalSystem system, DocGen.DocGenContext ctx) {
		val filename = system.name + "_instanceTree.jpg"
		'''
		\level{2}{«system.name.escapedString»}
		«system.docu.generateDocText»
		\level{3}{Instance Tree}
		«IF ctx.model.fileExists(filename.imagePath).equals("true")»
			«includeGraphics(filename.imagePath,IMGWIDTH_DEFAULT,system.name + " Instance Tree")»
		«ENDIF»
		'''
	}
	
	def private dispatch generateDoc(SubSystemClass ssc, DocGen.DocGenContext ctx) {
		val filename = ssc.name.escapedString + "_structure.jpg"
		
		'''
		\level{2}{«ssc.name.escapedString»}
		«ssc.docu.generateDocText»
		\level{3}{Structure}
		«IF ctx.model.fileExists(filename.imagePath).equals("true")»
			«includeGraphics(filename.imagePath,IMGWIDTH_DEFAULT,ssc.name + " Structure")»
		«ENDIF»
		'''
	}
	
	def private dispatch generateDoc(EnumerationType dc, DocGen.DocGenContext ctx) {
	'''
		\level{2} {«dc.name.escapedString»}
		«dc.docu.generateDocText»
		«IF dc.primitiveType!==null»
			The literals of this enumeration are based on PrimitiveType «dc.primitiveType.name.escapedString».
		«ELSE»
			The literals of this enumeration are of type \texttt{int}.
		«ENDIF»
		\level{3}{Literals}
		\begin{tabular}[ht]{|l|r|r|r|}
		\hline
		\textbf{Name} & \textbf{Value} & \textbf{Hex Value} & \textbf{Binary Value}\\
		«FOR lit: dc.literals»
			\hline
			«lit.name.escapedString» & «lit.literalValue» & 0x«Long.toHexString(lit.literalValue)» & «Long.toBinaryString(lit.literalValue)»\\
		«ENDFOR»
		\hline
		\end{tabular}
	'''	
	}
	
	def private dispatch generateDoc(DataClass dc, DocGen.DocGenContext ctx) {'''
		\level{2} {«dc.name.escapedString»}
		«dc.docu.generateDocText»
		\level{3}{Attributes}
		«dc.attributes.generateAttributesDoc»
		
		\level{3}{Operations}
		«dc.operations.generateOperationsDoc»
	'''	
	}
	
	def private dispatch generateDoc(ProtocolClass pc, DocGen.DocGenContext ctx) {'''
		\level{2} {«pc.name.escapedString»}
		«pc.docu.generateDocText»
		«IF !pc.allIncomingMessages.empty»
			\level{3}{Incoming Messages}
			
			\begin{tabular}[ht]{|l|l|p{8cm}|}
			\hline
			Message & Type & Description\\
			«FOR ims : pc.allIncomingMessages»
				\hline
				«ims.name.escapedString» & «IF ims.data !== null» «ims.data.refType.type.name.escapedString» «ENDIF» & «ims.docu.generateDocText»\\
			«ENDFOR»
			\hline
			\end{tabular}
		«ENDIF»
		«IF !pc.allOutgoingMessages.empty»
			\level{3}{Outgoing Messages}
			\begin{tabular}[ht]{|l|l|p{8cm}|}
			\hline
			Message & Type & Description\\
			«FOR oms : pc.allOutgoingMessages»
				\hline
				«oms.name.escapedString» & «IF oms.data !== null» «oms.data.refType.type.name.escapedString» «ENDIF» & «oms.docu.generateDocText»\\
			«ENDFOR»
			\hline
			\end{tabular}
		«ENDIF»
	'''	
	}
	
	def private dispatch generateDoc(CompoundProtocolClass pc, DocGen.DocGenContext ctx) {'''
		\level{2} {«pc.name.escapedString»}
		«pc.docu.generateDocText»
		\level{3}{Sub Protocols}
		
		\begin{tabular}[ht]{|l|l|}
		\hline
		\textbf{Name} & \textbf{Protocol}\\
		«FOR sub : pc.subProtocols»
			\hline
			«sub.name.escapedString» & «sub.protocol.name.escapedString»\\
		«ENDFOR»
		\hline
		\end{tabular}
	'''
	}
	
	def dispatch private generateDoc(ActorClass ac, DocGen.DocGenContext ctx) {
		val filename = ac.name + "_structure.jpg"
		'''
		\level{2}{«ac.name.escapedString»}
		«ac.docu.generateDocText»
		
		«IF ctx.model.fileExists(filename.imagePath).equals("true") && (!ac.allInterfaceItems.empty || !ac.actorRefs.empty)»
			\level{3}{Structure}
			«ac.structureDocu.generateDocText»
			«includeGraphics(filename.imagePath,IMGWIDTH_DEFAULT,ac.name + " Structure")»
		«ELSEIF ac.structureDocu !== null»
			\level{3}{Structure}
			«ac.structureDocu.generateDocText»
		«ENDIF»
		
		«IF !ac.allPorts.empty»
			\level{3}{Ports}
			«generatePortDoc(ac)»
		«ENDIF»
		
		«IF ac.isBehaviorAnnotationPresent("BehaviorManual")»
			\level{3}{Behavior}
			«ac.behaviorDocu.generateDocText»
			The behavior for ActorClass «ac.name» is implemented manually.
		«ELSEIF ac.hasNonEmptyStateMachine»
			\level{3}{Behavior}
			«ac.behaviorDocu.generateDocText»
			«generateFsmDoc(ctx.model, ac)»
		«ELSEIF ac.behaviorDocu !== null»
			\level{3}{Behavior}
			«ac.behaviorDocu.generateDocText»
		«ENDIF»
		
		«IF !ac.attributes.empty»
			\level{3}{Attributes}
			«ac.attributes.generateAttributesDoc»
		«ENDIF»
		
		«IF !ac.operations.empty»
			\level{3}{Operations}
			«ac.operations.generateOperationsDoc»
		«ENDIF»
		'''
	}

	def private generateFsmDoc(RoomModel model, ActorClass ac){
		val filename = ac.name + "_behavior.jpg"
		'''
		\level{4}{Top Level}
		«IF model.fileExists(filename.imagePath).equals("true")»
			«includeGraphics(filename.imagePath,IMGWIDTH_DEFAULT,ac.name + " Top State")»
		«ENDIF»
		
		\begin{par}
		«FOR s : ac.stateMachine.states»
			«IF s.docu !== null»	
				\textbf{State description} \textit{«s.genStatePathName.replaceAll("_","\\\\_")»}:
				\newline
				«generateDocText(s.docu)»
				\newline\newline
			«ENDIF»
		«ENDFOR»

		«FOR c : ac.stateMachine.chPoints»
			«IF c.docu !== null»
				\textbf{Choicepoint description} \textit{«c.name.escapedString»}:
				\newline
				«generateDocText(c.docu)»
				\newline\newline
			«ENDIF»
		«ENDFOR»
		\end{par}
		
		«FOR s : ac.stateMachine.states»	
			«IF !s.isLeaf»
				«generateStateDoc(model, ac, s)»
			«ENDIF»
		«ENDFOR»		
		'''
	}
	
	def private getType(Port p) {
		if (p.conjugated) "conj." else "reg."
	}
	
	def private getKind(Port p) {
		if (p.internal)
			"internal"
		else if (p.external)
			"external"
		else if (p.relay)
			"relay"
		else
			"?"
	}
	
	def private String getMultAsText(Port p) {
		if (p.multiplicity==-1)
			"*"
		else
			p.multiplicity.toString
	}
	
	def private String generatePortDoc(ActorClass ac) {
		'''
			\begin{tabular}[ht]{|l|l|l|l|l|p{5cm}|}
			\hline
			\textbf{Name} & \textbf{Protocol} & \textbf{Type} & \textbf{Kind} & \textbf{Multiplicity} & \textbf{Description}\\
			«FOR at : ac.allPorts»
				\hline
				«at.name.escapedString» & «at.protocol.name.escapedString» & «at.type» & «at.kind» & «at.multAsText» & «generateDocText(at.docu)»\\
			«ENDFOR»	
			\hline
			\end{tabular}
		'''
	}
	
	def private String generateStateDoc(RoomModel model, ActorClass ac, State state){
		val filename = ac.name + "_" + state.genStatePathName + "_behavior.jpg"

		logger.logInfo("Gen Filename: " + filename); 
		'''
		\level{4}{Subgraph «state.genStatePathName.replaceAll("_","\\\\_")»}
		«IF model.fileExists(filename.imagePath).equals("true")»
			«includeGraphics(filename.imagePath,IMGWIDTH_DEFAULT,ac.name + "_" + state.genStatePathName)»
		«ENDIF»
		
		\begin{par}
		«FOR s : state.subgraph.states»
			«IF s.docu !== null»	
				\textbf{State description} \textit{«s.genStatePathName.replaceAll("_","\\\\_")»}:
				\newline
				«generateDocText(s.docu)»
				\newline\newline
			«ENDIF»
		«ENDFOR»

		«FOR c : state.subgraph.chPoints»
			«IF c.docu !== null»
				\textbf{Choicepoint description} \textit{«c.name.escapedString»}:
				\newline
				«generateDocText(c.docu)»
				\newline\newline
			«ENDIF»
		«ENDFOR»
		\end{par}
			
		«FOR s : state.subgraph.states»	
			«IF !s.isLeaf»
				«generateStateDoc(model, ac, s)»
			«ENDIF»
		«ENDFOR»		
		'''		
	}

	def private generateAttributesDoc(List<Attribute> attributes) {
		'''
		«IF !attributes.empty»
			\begin{tabular}[ht]{|l|l|p{8cm}|}
			\hline
			\textbf{Name} & \textbf{Type} & \textbf{Description}\\
			«FOR at : attributes»
			\hline
			«at.name.escapedString» & «at.type.type.name.escapedString» & «generateDocText(at.docu)»\\
			«ENDFOR»	
			\hline
			\end{tabular}
		«ENDIF»	
		'''
		}
	
	def private generateOperationsDoc(List<StandardOperation> operations) {
		'''
		«FOR op : operations»
			\begin{tabular}[ht]{|l|l|}
			\hline		
				Name: & «op.name.escapedString»\\
				\hline
				ReturnType: &  «IF op.returnType !== null»«op.returnType.type.name.escapedString»«ELSE»void«ENDIF»\\
				\hline
				Arguments: & «FOR pa : op.arguments SEPARATOR ", "»«pa.name.escapedString»:«pa.refType.type.name.escapedString»«ENDFOR»\\
				«IF op.docu !== null»
					\hline
					«IF op.docu.toString.length > 85»
						\multicolumn{2} {|p{13cm}|} {«generateDocText(op.docu)»}\\
					«ELSE»
						\multicolumn{2} {|l|} {«generateDocText(op.docu)»}\\
					«ENDIF»
				«ENDIF»
				\hline
			\end{tabular}
			\newline\newline\newline
		«ENDFOR»
		'''
	}
	
	def private generateDocText(Documentation doc){
		'''
		«IF doc!==null»
			% begin text from user Documentation
			«FOR line: doc.lines»
				«line.escapedString»
			«ENDFOR»
			% end text from user Documentation
		«ENDIF»
		'''
	}
	
	def private fileExists(RoomModel model, String f){
		val absPath = model.docGenerationTargetPath + f
		val file = new File(absPath);
		val exist = file.exists();
			if (exist == true) {
				// File or directory exists
				logger.logInfo("File found ! " + f); 
				return "true"
			} else {
				// File or directory does not exist
				logger.logInfo("File not found ! " + f);
				return "false"
		}
	}
	
	def private includeGraphics(String filename, String width, String caption){
		var latexCaption = caption.replaceAll("_","\\\\_");
		'''
			{
			\centering{}
			\includegraphics[width=«width»]{«filename»}
			\figcaption{«latexCaption»}
			}
		'''
	}
	
	def private escapedString(String text) {
		text.replace("_","\\_")
	}
	
	def private getImagePath(String filename) {
		var filenamei = IMGDIR_DEFAULT + "/" + filename
		filenamei = filenamei.replaceAll("\\\\","/")
		return filenamei
	}
	
	def private saveAs(CharSequence content, String filename) {
		fileAccess.generateFile(filename, content)
	}
	
	def private docFragmentName(RoomClass rc) {
		rc.name + ".tex"
	}
	
	def private generateImport(RoomClass rc, String dir)
		'''«rc.docFragmentName.generateImport(dir)»'''
	
	def private generateImport(String name, String dir)
		'''\subimport*{«dir»/}{«name»}'''
}
