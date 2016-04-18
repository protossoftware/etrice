/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Juergen Haug
 */
package org.eclipse.etrice.generator.base;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class GlobalGeneratorSettings {
  private final List<String> inputModelURIs = CollectionLiterals.<String>newArrayList();
  
  private boolean generateAsLibrary = false;
  
  private boolean generateMSCInstrumentation = false;
  
  private boolean generateDataInstrumentation = false;
  
  private boolean noTranslation = false;
  
  private String mainMethodName = "main";
  
  private String generatorModelPath = null;
  
  private boolean generateDocumentation = false;
  
  private boolean generateWithVerboseOutput = false;
  
  private boolean debugMode = false;
  
  @Pure
  public List<String> getInputModelURIs() {
    return this.inputModelURIs;
  }
  
  @Pure
  public boolean isGenerateAsLibrary() {
    return this.generateAsLibrary;
  }
  
  public void setGenerateAsLibrary(final boolean generateAsLibrary) {
    this.generateAsLibrary = generateAsLibrary;
  }
  
  @Pure
  public boolean isGenerateMSCInstrumentation() {
    return this.generateMSCInstrumentation;
  }
  
  public void setGenerateMSCInstrumentation(final boolean generateMSCInstrumentation) {
    this.generateMSCInstrumentation = generateMSCInstrumentation;
  }
  
  @Pure
  public boolean isGenerateDataInstrumentation() {
    return this.generateDataInstrumentation;
  }
  
  public void setGenerateDataInstrumentation(final boolean generateDataInstrumentation) {
    this.generateDataInstrumentation = generateDataInstrumentation;
  }
  
  @Pure
  public boolean isNoTranslation() {
    return this.noTranslation;
  }
  
  public void setNoTranslation(final boolean noTranslation) {
    this.noTranslation = noTranslation;
  }
  
  @Pure
  public String getMainMethodName() {
    return this.mainMethodName;
  }
  
  public void setMainMethodName(final String mainMethodName) {
    this.mainMethodName = mainMethodName;
  }
  
  @Pure
  public String getGeneratorModelPath() {
    return this.generatorModelPath;
  }
  
  public void setGeneratorModelPath(final String generatorModelPath) {
    this.generatorModelPath = generatorModelPath;
  }
  
  @Pure
  public boolean isGenerateDocumentation() {
    return this.generateDocumentation;
  }
  
  public void setGenerateDocumentation(final boolean generateDocumentation) {
    this.generateDocumentation = generateDocumentation;
  }
  
  @Pure
  public boolean isGenerateWithVerboseOutput() {
    return this.generateWithVerboseOutput;
  }
  
  public void setGenerateWithVerboseOutput(final boolean generateWithVerboseOutput) {
    this.generateWithVerboseOutput = generateWithVerboseOutput;
  }
  
  @Pure
  public boolean isDebugMode() {
    return this.debugMode;
  }
  
  public void setDebugMode(final boolean debugMode) {
    this.debugMode = debugMode;
  }
}
