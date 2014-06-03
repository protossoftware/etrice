/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 */
package org.eclipse.etrice.generator.ui.wizard;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.etrice.core.etphys.util.ETPhysUtil;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Henrik Rentz-Reichert
 */
@SuppressWarnings("all")
public class ProjectFileFragments {
  public static String getBasicRoomModel(final String baseName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("RoomModel ");
    _builder.append(baseName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("LogicalSystem ");
    _builder.append(baseName, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("SubSystemRef main: MainSubSystem");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("SubSystemClass MainSubSystem {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ActorRef appl: Application");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LogicalThread defaultThread");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ActorClass Application {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * @see ETPhysUtil
   */
  public static String getBasicPhysicalModel(final String baseName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("PhysicalModel ");
    _builder.append(baseName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("PhysicalSystem PhysSys1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("NodeRef nodeRef1 : NodeClass1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NodeClass NodeClass1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("runtime = RuntimeClass1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("priomin = -10");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("priomax = 10");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("DefaultThread PhysicalThread1 {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("execmode = mixed");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("interval = 100ms");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("prio = 0");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("stacksize = 1024");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("msgblocksize = 32");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("msgpoolsize = 10");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("RuntimeClass RuntimeClass1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("model = multiThreaded");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getBasicMappingModel(final String baseName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MappingModel ");
    _builder.append(baseName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("import ");
    _builder.append(baseName, "\t");
    _builder.append(".* from \"");
    _builder.append(baseName, "\t");
    _builder.append(".room\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("import ");
    _builder.append(baseName, "\t");
    _builder.append(".* from \"");
    _builder.append(baseName, "\t");
    _builder.append(".etphys\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Mapping ");
    _builder.append(baseName, "\t");
    _builder.append(" -> PhysSys1 {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("SubSystemMapping main -> nodeRef1 {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("ThreadMapping defaultThread -> PhysicalThread1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getGeneratorLaunchConfig(final String targetLanguage, final String modelPath, final String baseName, final String[] addLines) {
    String _xblockexpression = null;
    {
      final ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
      final boolean useTranslation = prefStore.getBoolean(PreferenceConstants.GEN_USE_TRANSLATION);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder.newLine();
      _builder.append("<launchConfiguration type=\"org.eclipse.etrice.generator.launch.");
      _builder.append(targetLanguage, "");
      _builder.append(".launchConfigurationType\">");
      _builder.newLineIfNotEmpty();
      _builder.append("<booleanAttribute key=\"MSC\" value=\"true\"/>");
      _builder.newLine();
      _builder.append("<booleanAttribute key=\"UseTranslation\" value=\"");
      _builder.append(useTranslation, "");
      _builder.append("\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("<listAttribute key=\"ModelFiles\">");
      _builder.newLine();
      _builder.append("<listEntry value=\"${workspace_loc:");
      _builder.append(modelPath, "");
      _builder.append("/");
      _builder.append(baseName, "");
      _builder.append(".etmap}\"/>");
      _builder.newLineIfNotEmpty();
      _builder.append("</listAttribute>");
      _builder.newLine();
      _builder.append("<listAttribute key=\"org.eclipse.debug.ui.favoriteGroups\">");
      _builder.newLine();
      _builder.append("<listEntry value=\"org.eclipse.debug.ui.launchGroup.run\"/>");
      _builder.newLine();
      _builder.append("</listAttribute>");
      _builder.newLine();
      {
        for(final String line : addLines) {
          _builder.append(line, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("</launchConfiguration>");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public static String getLaunchJavaApplicationConfig(final String project, final String mdlName, final String mainClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"/");
    _builder.append(project, "");
    _builder.append("/src-gen/");
    String _replace = mdlName.replace(".", "/");
    _builder.append(_replace, "");
    _builder.append("/");
    _builder.append(mainClass, "");
    _builder.append(".java\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"1\"/>");
    _builder.newLine();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"");
    _builder.append(mdlName, "");
    _builder.append(".");
    _builder.append(mainClass, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"");
    _builder.append(project, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getLaunchCApplicationConfig(final String project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.cdt.launch.applicationLaunchType\">");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"org.eclipse.cdt.debug.mi.core.verboseMode\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<intAttribute key=\"org.eclipse.cdt.launch.ATTR_BUILD_BEFORE_LAUNCH_ATTR\" value=\"2\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.cdt.launch.DEBUGGER_START_MODE\" value=\"run\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.cdt.launch.PROGRAM_NAME\" value=\"Debug/");
    _builder.append(project, "");
    _builder.append(".exe\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"org.eclipse.cdt.launch.PROJECT_ATTR\" value=\"");
    _builder.append(project, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<booleanAttribute key=\"org.eclipse.cdt.launch.use_terminal\" value=\"true\"/>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"/");
    _builder.append(project, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">");
    _builder.newLine();
    _builder.append("<listEntry value=\"4\"/>");
    _builder.newLine();
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getMavenPOM(final String project, final String mdlName, final String mainClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<modelVersion>4.0.0</modelVersion>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<groupId>");
    _builder.append(project, "\t");
    _builder.append("</groupId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<artifactId>");
    _builder.append(mdlName, "\t");
    _builder.append("</artifactId>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<version>1.0.0</version>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<repositories>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<repository>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<id>repo.eclipse.org-snapshots</id>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>eTrice Repository - Snapshots</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<url>https://repo.eclipse.org/content/repositories/etrice-snapshots/</url>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</repository>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</repositories>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<pluginRepositories>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<pluginRepository>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<id>repo.eclipse.org-snapshots</id>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>eTrice Repository - Snapshots</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<url>https://repo.eclipse.org/content/repositories/etrice-snapshots/</url>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</pluginRepository>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</pluginRepositories>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<build>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<sourceDirectory>src-gen</sourceDirectory>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<resources>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<resource>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<directory>src-gen</directory>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<excludes>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<exclude>**/*.java</exclude>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</excludes>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</resource>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</resources>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<plugins>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.codehaus.mojo</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>build-helper-maven-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>1.7</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<id>add-source</id>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<phase>generate-sources</phase>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<goal>add-source</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<sources>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<source>src</source>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("</sources>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</executions>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<groupId>org.eclipse.etrice</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>org.eclipse.etrice.generator.java.mvn</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>0.4.0-SNAPSHOT</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<goal>eTriceJavaGenerator</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t          ");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- allowed switches for the generator (not complete) -->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate the store/restore interface using POJO data objects");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-storeDataObj</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate MSC instrumentation");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-msc_instr</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate the persistence interface for dynamic actors");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-persistable</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate all ROOM classes as library");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-lib</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate documentation");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-genDocu</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<!-- generate files incrementally (overwrite only if contents changed)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<param>-inc</param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("-->");
    _builder.newLine();
    _builder.append("\t\t\t\t          \t");
    _builder.append("<param>model/");
    _builder.append(mdlName, "\t\t\t\t          \t");
    _builder.append(".etmap</param>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t          ");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t\t\t        ");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<!-- put the modellib on the class path to allow resolution of models by the generator -->");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<groupId>org.eclipse.etrice</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<artifactId>org.eclipse.etrice.modellib.java</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<version>0.4.0-SNAPSHOT</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>maven-compiler-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<version>3.1</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<source>1.6</source>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<target>1.6</target>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<artifactId>maven-assembly-plugin</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<phase>package</phase>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<goal>single</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</execution>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</executions>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<descriptorRefs>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<descriptorRef>jar-with-dependencies</descriptorRef>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</descriptorRefs>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<archive>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<manifest>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<mainClass>");
    _builder.append(mdlName, "\t\t\t\t\t\t\t");
    _builder.append(".");
    _builder.append(mainClass, "\t\t\t\t\t\t\t");
    _builder.append("</mainClass>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</manifest>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</archive>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</plugins>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<pluginManagement>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<plugins>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<!--This plugin\'s configuration is used to store Eclipse m2e settings only. It has no influence on the Maven build itself.-->");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<groupId>org.eclipse.m2e</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<artifactId>lifecycle-mapping</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<version>1.0.0</version>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("<lifecycleMappingMetadata>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("<pluginExecutions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("org.eclipse.etrice");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("org.eclipse.etrice.generator.java.mvn");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("[0.4.0-SNAPSHOT,)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("eTriceJavaGenerator");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<ignore></ignore>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("org.codehaus.mojo");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("build-helper-maven-plugin");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("[1.7,)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</versionRange>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<goal>add-source</goal>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("</goals>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecutionFilter>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("<action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("<ignore></ignore>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("</action>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("</pluginExecution>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("</pluginExecutions>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("</lifecycleMappingMetadata>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</configuration>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("</plugin>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</plugins>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</pluginManagement>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</build>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<groupId>org.eclipse.etrice</groupId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<artifactId>org.eclipse.etrice.runtime.java</artifactId>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<version>0.4.0-SNAPSHOT</version>");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("<groupId>org.eclipse.etrice</groupId>");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("<artifactId>org.eclipse.etrice.modellib.java</artifactId>");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("<version>0.4.0-SNAPSHOT</version>");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.append("</project>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getMavenBuilder(final String project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.m2e.Maven2LaunchConfigurationType\">");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_DEBUG_OUTPUT\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"M2_GOALS\" value=\"package\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_NON_RECURSIVE\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_OFFLINE\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"M2_PROFILES\" value=\"\"/>");
    _builder.newLine();
    _builder.append("<listAttribute key=\"M2_PROPERTIES\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"M2_RUNTIME\" value=\"EMBEDDED\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_SKIP_TESTS\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<intAttribute key=\"M2_THREADS\" value=\"1\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_UPDATE_SNAPSHOTS\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<booleanAttribute key=\"M2_WORKSPACE_RESOLUTION\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.WORKING_DIRECTORY\" value=\"${workspace_loc:/");
    _builder.append(project, "");
    _builder.append("}\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String getMavenLauncher(final String project, final String mdlName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<launchConfiguration type=\"org.eclipse.ui.externaltools.ProgramLaunchConfigurationType\">");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_LOCATION\" value=\"${env_var:JAVA_HOME}/bin/java.exe\"/>");
    _builder.newLine();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS\" value=\"-jar target/");
    _builder.append(mdlName, "");
    _builder.append("-1.0.0-jar-with-dependencies.jar\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("<stringAttribute key=\"org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY\" value=\"${workspace_loc:/");
    _builder.append(project, "");
    _builder.append("}\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder.toString();
  }
}
