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
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.CompoundProtocolClass
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.Documentation
import org.eclipse.etrice.core.room.LogicalSystem
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.StandardOperation
import org.eclipse.etrice.core.room.State
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import static extension org.eclipse.etrice.generator.base.CodegenHelpers.*

@Singleton
class DocGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (model: root.models) {
			var path = model.docGenerationTargetPath
			var file = model.name+".tex"
			logger.logInfo("generating LaTeX documentation: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generateModelDoc(model))
		}
	}
	
	def private generateModelDoc(Root root, RoomModel model) {'''
		\documentclass[titlepage]{article}
		\usepackage{graphicx}
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


		\title{�model.name� Model Documentation}
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
		�model.docu.generateDocText�
		\section{Logical System Description}
		�root.generateAllLogicalSystemDocs(model)�
		\section{Subsystem Description}
		�root.generateAllSubSysClassDocs(model)�
		\section{Protocol Class Description}
		�root.generateAllProtocolClassDocs(model)�
		\section{Data Class Description}
		�root.generateAllDataClassDocs(model)�
		\section{Actor Class Description}
		�root.generateAllActorClassDocs(model)�
		\end{document}
	'''
	}
	
	def private generateAllLogicalSystemDocs(Root root, RoomModel model){'''
	�FOR sys : model.systems�
		�root.generateLogicalSystemDoc(model, sys)�
	�ENDFOR�
	'''
	}
	
	def private generateLogicalSystemDoc(Root root, RoomModel model, LogicalSystem system) {
		var filenamei = model.docGenerationTargetPath + "images\\" + system.name + "_instanceTree.jpg"
		filenamei = filenamei.replaceAll("\\\\","/");
		var latexFilenamei = filenamei.replaceAll("/","//") 
		'''
		\level{2}{�system.name�}
		�system.docu.generateDocText�
		\level{3}{Instance Tree}
		�IF fileExists(filenamei).equals("true")�
			�includeGraphics(latexFilenamei,"0.5",system.name + " Instance Tree")�
		�ENDIF�
		'''
	}
	
	def private generateAllSubSysClassDocs(Root root, RoomModel model){'''
	�FOR ssc : model.subSystemClasses�
		�root.generateSubSysClassDoc(model, ssc)�
	�ENDFOR�
	'''
	}

	def private generateSubSysClassDoc(Root root, RoomModel model, SubSystemClass ssc) {
		var filename = model.docGenerationTargetPath + "images\\" + ssc.name + "_structure.jpg"
		filename = filename.replaceAll("\\\\","/");
		var latexFilename = filename.replaceAll("/","//")
		
		'''
		\level{2}{�ssc.name�}
		�ssc.docu.generateDocText�
		\level{3}{Structure}
		�IF fileExists(filename).equals("true")�
			�includeGraphics(latexFilename,"0.4",ssc.name + " Structure")�
		�ENDIF�
		'''
	}
	
	def private generateAllDataClassDocs(Root root, RoomModel model){'''
		�FOR dc : model.dataClasses�
			�root.generateDataClassDoc(dc)�
		�ENDFOR�		
	'''}

	def private generateDataClassDoc(Root root, DataClass dc) {'''
		\level{2} {�dc.name�}
		�dc.docu.generateDocText�
		\level{3}{Attributes}
		�dc.attributes.generateAttributesDoc�
		
		\level{3}{Operations}
		�dc.operations.generateOperationsDoc�
	'''	
	}

	def private generateAllProtocolClassDocs(Root root, RoomModel model) {'''
		�FOR pc : model.protocolClasses�
			�root.generateProtocolClassDoc(pc)�
		�ENDFOR�
	'''	
	}
	
	def private dispatch generateProtocolClassDoc(Root root, ProtocolClass pc) {'''
		\level{2} {�pc.name�}
		�pc.docu.generateDocText�
		\level{3}{Incoming Messages}
	
		\begin{tabular}[ht]{|l|l|l|}
		\hline
		Message & Data & Description\\
		�FOR ims : pc.allIncomingMessages�
			\hline
			�ims.name� & �IF ims.data != null� �ims.data.name� �ENDIF� & �ims.docu.generateDocText�\\
		�ENDFOR�
		\hline
		\end{tabular}
		
		\level{3}{Outgoing Messages}
		\begin{tabular}[ht]{|l|l|l|}
		\hline
		Message & Data & Description\\
		�FOR oms : pc.allOutgoingMessages�
			\hline
			�oms.name� & �IF oms.data != null� �oms.data.name� �ENDIF� & �oms.docu.generateDocText�\\
		�ENDFOR�
		\hline
		\end{tabular}			
	'''	
	}
	
	def private dispatch generateProtocolClassDoc(Root root, CompoundProtocolClass pc) {'''
		\level{2} {�pc.name�}
		�pc.docu.generateDocText�
		\level{3}{Sub Protocols}
		
		\begin{tabular}[ht]{|l|l|}
		\hline
		Name & Protocol\\
		�FOR sub : pc.subProtocols�
			\hline
			�sub.name� & �sub.protocol.name�\\
		�ENDFOR�
		\hline
		\end{tabular}
	'''
	}
	
	def private generateAllActorClassDocs(Root root, RoomModel model) {'''
		�FOR ac : model.actorClasses�
			�root.generateActorClassDoc(model,ac)�
		�ENDFOR�			
		'''
	}
	
	def private generateActorClassDoc(Root root, RoomModel model, ActorClass ac) {
		var filename = model.docGenerationTargetPath + "images\\" + ac.name + "_structure.jpg"
		filename = filename.replaceAll("\\\\","/");
		var latexFilename = filename.replaceAll("/","//") 
		'''
		\level{2}{�ac.name�}
		�ac.docu.generateDocText�
		\level{3}{Structure}
		
		�IF fileExists(filename).equals("true")�
			�includeGraphics(latexFilename,"0.4",ac.name + " Structure")�
		�ENDIF�
		
		\level{3}{Attributes}
		�ac.attributes.generateAttributesDoc�
		
		\level{3}{Operations}
		�ac.operations.generateOperationsDoc�
		�IF ac.hasNonEmptyStateMachine�
			\level{3}{Statemachine}
			�generateFsmDoc(model, ac)�
		�ENDIF�
		'''
	}

	def private generateFsmDoc(RoomModel model, ActorClass ac){
		var filename = model.docGenerationTargetPath + "images\\" + ac.name + "_behavior.jpg"
		filename = filename.replaceAll("\\\\","/");
		var latexFilename = filename.replaceAll("/","//")
		 
		'''
		\level{4}{Top Level}
		�IF fileExists(filename).equals("true")�
			�includeGraphics(latexFilename,"0.4",ac.name + " Top State")�
		�ENDIF�
		
		\begin{par}
		�FOR s : ac.stateMachine.states�
			�IF s.docu != null�	
				\textbf{State description} \textit{�s.genStatePathName.replaceAll("_","\\\\_")�}:
				\newline
				�generateDocText(s.docu)�
				\newline\newline
			�ENDIF�
		�ENDFOR�

		�FOR c : ac.stateMachine.chPoints�
			�IF c.docu != null�
				\textbf{Choicepoint description} \textit{�c.name�}:
				\newline
				�generateDocText(c.docu)�
				\newline\newline
			�ENDIF�
		�ENDFOR�
		\end{par}
		
		�FOR s : ac.stateMachine.states�	
			�IF !s.isLeaf�
				�generateStateDoc(model, ac, s)�
			�ENDIF�
		�ENDFOR�		
		'''
	}
		
	def private String generateStateDoc(RoomModel model, ActorClass ac, State state){
		var filename = model.docGenerationTargetPath + "images\\" + ac.name + "_" + state.genStatePathName + "_behavior.jpg"
		filename = filename.replaceAll("\\\\","/");
		var latexFilename = filename.replaceAll("/","//"); 

		logger.logInfo("Gen Filename: " + filename); 
		'''
		\level{4}{Subgraph �state.genStatePathName.replaceAll("_","\\\\_")�}
		�IF fileExists(filename).equals("true")�
			�includeGraphics(latexFilename,"0.4",ac.name + "_" + state.genStatePathName)�
		�ENDIF�
		
		\begin{par}
		�FOR s : state.subgraph.states�
			�IF s.docu != null�	
				\textbf{State description} \textit{�s.genStatePathName.replaceAll("_","\\\\_")�}:
				\newline
				�generateDocText(s.docu)�
				\newline\newline
			�ENDIF�
		�ENDFOR�

		�FOR c : state.subgraph.chPoints�
			�IF c.docu != null�
				\textbf{Choicepoint description} \textit{�c.name�}:
				\newline
				�generateDocText(c.docu)�
				\newline\newline
			�ENDIF�
		�ENDFOR�
		\end{par}
			
		�FOR s : state.subgraph.states�	
			�IF !s.isLeaf�
				�generateStateDoc(model, ac, s)�
			�ENDIF�
		�ENDFOR�		
		'''		
	}

	def private generateAttributesDoc(List<Attribute> attributes) {
		'''
		�IF !attributes.empty�
			\begin{tabular}[ht]{|l|l|l|}
			\hline
			Name & Type & Description\\
			�FOR at : attributes�
			\hline
			�at.name� & �at.type.type.name� & �generateDocText(at.docu)�\\
			�ENDFOR�	
			\hline
			\end{tabular}
		�ENDIF�	
		'''
		}
	
	def private generateOperationsDoc(List<StandardOperation> operations) {
		'''
		�FOR op : operations�
			\begin{tabular}[ht]{|l|l|}
			\hline		
				Name: & �op.name�\\
				\hline
				ReturnType: &  �IF op.returnType != null��op.returnType.type.name��ELSE�void�ENDIF�\\
				\hline
				Arguments: & �FOR pa : op.arguments SEPARATOR ", "��pa.name�:�pa.refType.type.name��ENDFOR�\\
				�IF op.docu != null�
					\hline
					�IF op.docu.toString.length > 85�
						\multicolumn{2} {|p{13cm}|} {�generateDocText(op.docu)�}\\
					�ELSE�
						\multicolumn{2} {|l|} {�generateDocText(op.docu)�}\\
					�ENDIF�
				�ENDIF�
				\hline
			\end{tabular}
			\newline\newline\newline
		�ENDFOR�
		'''
	}
	
	def private generateDocText(Documentation doc){'''
		�IF doc!=null�
			�doc.lines.join()�
		�ENDIF�		
		'''
	}
	
	def private fileExists(String f){
		val file = new File(f);
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
		
	def private includeGraphics(String filename, String scale, String caption){
		var latexCaption = caption.replaceAll("_","\\\\_");
		'''
			\begin{center}
			\includegraphics[scale=�scale�]{�filename�}
			\figcaption{�latexCaption�}
			\end{center}
		'''
	}
}