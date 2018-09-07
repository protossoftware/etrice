/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Eyrak Pean (initial contribution)
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.gnuplot

import com.google.inject.Inject
import org.eclipse.etrice.core.common.base.Annotation
import org.eclipse.etrice.core.common.base.IntLiteral
import org.eclipse.etrice.core.common.base.KeyValue
import org.eclipse.etrice.core.common.base.RealLiteral
import org.eclipse.etrice.core.common.base.StringLiteral
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import com.google.inject.Singleton

@Singleton
class GnuplotScriptGenerator { 
	@Inject
	IGeneratorFileIO fileIo

	def doGenerate(Root root) {
		if (root.subSystemInstances.empty)
			return;

		// TODO: warning more than one ssi
		val ssi = root.subSystemInstances.head
		if(!ssi.subSystemClass.annotations.exists[a |a.type.name == "Gnuplot"])
			return;
		
		try {
			fileIo.generateFile("Generating gnuplot script for subsystem " + ssi.name, "/gnuplot/main.data.csv-script.plt", ssi.generatePlotScript)
			fileIo.generateFile("Generating gnuplot launch configuration", "/gnuplot/create_gnuplot.launch", gnuPlotLaunchFile)
		} catch (Exception e) {
			//e.printStackTrace
		}

	}

	def protected gnuPlotLaunchFile() '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<launchConfiguration type="org.eclipse.ui.externaltools.ProgramLaunchConfigurationType">
		<stringAttribute key="org.eclipse.ui.externaltools.ATTR_LAUNCH_CONFIGURATION_BUILD_SCOPE" value="${none}"/>
		<stringAttribute key="org.eclipse.ui.externaltools.ATTR_LOCATION" value="${system_path:gnuplot}"/>
		<stringAttribute key="org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS" value="${project_loc}/src-gen/gnuplot/main.data.csv-script.plt"/>
		<stringAttribute key="org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY" value="${project_loc}"/>
		</launchConfiguration>

	'''

	def protected getAttribute(Annotation anno, String name) {
		anno.attributes.findFirst[attr|attr.key == name]
	}

	def protected asString(KeyValue kv) {
		if (kv.value instanceof StringLiteral)
			(kv.value as StringLiteral).value
		else
			null
	}

	def protected asReal(KeyValue kv) {
		if (kv.value instanceof RealLiteral)
			(kv.value as RealLiteral).value
		else if (kv.value instanceof IntLiteral)
			(kv.value as IntLiteral).value as double
		else
			null
	}

	def protected asInteger(KeyValue kv) {
		if (kv.value instanceof IntLiteral)
			(kv.value as IntLiteral).value
		else
			null
	}

	def protected generatePlotScript(SubSystemInstance ssi) {

		// TODO: warn if more than one GnuPlot annotation
		val plotAnnotation = ssi.subSystemClass.annotations.filter [ a |
			a.type.name == "Gnuplot"
		].head

		val defaultFontsize = 10

		// TODO: error checking
		val format = plotAnnotation?.getAttribute("format")?.asString
		val outputfile = plotAnnotation?.getAttribute("outputfile")?.asString
		val width = plotAnnotation?.getAttribute("width")?.asInteger
		val height = plotAnnotation?.getAttribute("height")?.asInteger
		val fontsize = plotAnnotation?.getAttribute("fontsize")?.asInteger ?: defaultFontsize

		val graphAnnotations = ssi.subSystemClass.annotations.filter [ a |
			a.type.name == "GnuplotGraph"
		].toList

		'''
			#!/gnuplot
			
			# Color Brewer set1 5-set
			set linetype 1 lc rgb '#e41a1c' lw 1
			set linetype 2 lc rgb '#377eb8' lw 1
			set linetype 3 lc rgb '#4daf4a' lw 1
			set linetype 4 lc rgb '#984ea3' lw 1
			set linetype 5 lc rgb '#ff7f00' lw 1
			set linetype cycle 5
			
			cd 'log'
			set datafile separator comma
			set terminal «format» size «width»,«height» font ",«fontsize»" background "white"
			set output '«outputfile»'
			set size 1,1
			set multiplot layout «graphAnnotations.size»,1
			set grid
			show grid
			set format y "% 5.3f"
			«var i = 0»
			«FOR a : graphAnnotations»
				
				«ssi.generateGraph(a, i++, graphAnnotations.size)»
			«ENDFOR»
			
			unset multiplot
			unset output
			
		'''
	}

	def protected generateGraph(SubSystemInstance ssi, Annotation graph, int index, int total) {

		// TODO: handle multiple paths in the same graph
		val paths = graph.getAttribute("paths")?.asString

		// TODO: take interval from physical thread associated with actor instance instead of annotation attribute
		val interval = graph.getAttribute("interval")?.asInteger ?: 20
		val xtics = graph.getAttribute("xtics")?.asReal ?: 100
		val mxtics = graph.getAttribute("mxtics")?.asInteger ?: 4
		val ymin = graph.getAttribute("ymin")?.asReal
		val ymax = graph.getAttribute("ymax")?.asReal

		val vertOrigin = ((total - (index + 1)) as double) / total
		val vertSize = 1.0F / total

		'''
			set yrange [«ymin ?: "*"» : «ymax ?: "*"»]
			set xtics rotate «xtics»
			set mxtics «mxtics»
			set ylabel
			set xlabel "time (ms)"
			timeInMs(x) = «interval» * x
			set origin 0,«vertOrigin»
			set size 1,«vertSize»
			plot 'main.data.csv' using (timeInMs(column(1))):(column("«paths»")) with lines
		'''
	}
}
