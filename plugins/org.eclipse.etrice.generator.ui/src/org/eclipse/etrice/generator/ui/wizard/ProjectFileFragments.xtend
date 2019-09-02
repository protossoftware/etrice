/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard

import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants
import org.eclipse.ui.preferences.ScopedPreferenceStore

/**
 * @author Henrik Rentz-Reichert
 *
 */
class ProjectFileFragments {
	
	def static String getBasicRoomModel(String baseName) {
		'''
			RoomModel «baseName» {
				LogicalSystem «baseName» {
					SubSystemRef main: MainSubSystem
				}
				SubSystemClass MainSubSystem {
					ActorRef appl: Application
					LogicalThread defaultThread
				}
				ActorClass Application {
				}
			}
		'''
	}
	
	/**
	 * @see ETPhysUtil
	 */
	def static String getBasicPhysicalModel(String baseName) {
		'''
			PhysicalModel «baseName» {
				
				PhysicalSystem PhysSys1 {
					NodeRef nodeRef1 : NodeClass1
				}
				
				NodeClass NodeClass1 {
					runtime = RuntimeClass1
					priomin = -10
					priomax = 10
					
					DefaultThread PhysicalThread1 {
						execmode = mixed
						interval = 100ms
						prio = 0
						stacksize = 1024
						msgblocksize = 32
						msgpoolsize = 10
					}
				}
			
				RuntimeClass RuntimeClass1 {
					model = multiThreaded
				} 
			}
		'''
	}
	
	def static String getBasicMappingModel(String baseName) {
		'''
			MappingModel «baseName» {
				import «baseName».* from "«baseName».room"
				import «baseName».* from "«baseName».etphys"
				Mapping «baseName» -> PhysSys1 {
					SubSystemMapping main -> nodeRef1 {
						ThreadMapping defaultThread -> PhysicalThread1
					}
				}
			}
		'''
	}
	
	def static String getGeneratorLaunchConfig(String targetLanguage, String modelPath, String mappingName, String mainMethodName, String[] addLines) {
		val prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		val useTranslation = prefStore.getBoolean(PreferenceConstants::GEN_USE_TRANSLATION)
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.etrice.generator.launch.«targetLanguage».launchConfigurationType">
			<booleanAttribute key="MSC" value="true"/>
			<booleanAttribute key="DataLogging" value="true"/>
			<booleanAttribute key="UseTranslation" value="«useTranslation»"/>
			<stringAttribute key="MainMethodName" value="«mainMethodName»"/>
			<listAttribute key="ModelFiles">
			<listEntry value="${workspace_loc:«modelPath»/«mappingName».etmap}"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.ui.favoriteGroups">
			<listEntry value="org.eclipse.debug.ui.launchGroup.run"/>
			</listAttribute>
			«FOR line : addLines»
				«line»
			«ENDFOR»
			</launchConfiguration>
		'''
	}
	
	def static String getLaunchJavaApplicationConfig(String project, String mdlName, String mainClass) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.jdt.launching.localJavaApplication">
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
			<listEntry value="/«project»/src-gen/«mdlName.replace('.', '/')»/«mainClass».java"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
			<listEntry value="1"/>
			</listAttribute>
			<booleanAttribute key="org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD" value="true"/>
			<stringAttribute key="org.eclipse.jdt.launching.MAIN_TYPE" value="«mdlName».«mainClass»"/>
			<stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="«project»"/>
			</launchConfiguration>
		'''
	}
	
	def static String getLaunchCApplicationConfig(String project) {
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<launchConfiguration type="org.eclipse.cdt.launch.applicationLaunchType">
			<booleanAttribute key="org.eclipse.cdt.debug.mi.core.verboseMode" value="false"/>
			<intAttribute key="org.eclipse.cdt.launch.ATTR_BUILD_BEFORE_LAUNCH_ATTR" value="2"/>
			<stringAttribute key="org.eclipse.cdt.launch.DEBUGGER_START_MODE" value="run"/>
			<stringAttribute key="org.eclipse.cdt.launch.PROGRAM_NAME" value="Debug/«project».exe"/>
			<stringAttribute key="org.eclipse.cdt.launch.PROJECT_ATTR" value="«project»"/>
			<booleanAttribute key="org.eclipse.cdt.launch.use_terminal" value="true"/>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
			<listEntry value="/«project»"/>
			</listAttribute>
			<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
			<listEntry value="4"/>
			</listAttribute>
			</launchConfiguration>
		'''
	}
	
	def static String getModelpathDescription(Iterable<String> srcDirs, Iterable<String> projects) '''
		«FOR s : srcDirs»
			srcDir «s»
		«ENDFOR»
		
		«FOR p : projects»
			project «p»
		«ENDFOR»
	'''
}