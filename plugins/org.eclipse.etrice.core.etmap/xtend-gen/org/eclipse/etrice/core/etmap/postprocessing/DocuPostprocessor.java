/**
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.core.etmap.postprocessing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GeneratedMetamodel;

@SuppressWarnings("all")
public class DocuPostprocessor {
  public void process(final GeneratedMetamodel metamodel) {
    final EPackage pckg = metamodel.getEPackage();
    EClass cls = PostprocessingHelpers.getClass(pckg, "MappingModel");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The root object for the mapping model. It gives access to the mappings defined.");
    _builder.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder.toString());
    EAttribute _attribute = PostprocessingHelpers.getAttribute(cls, "name");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("The model name is a dot separated fully qualified name and is");
    _builder_1.newLine();
    _builder_1.append("used to provide a name space.");
    _builder_1.newLine();
    PostprocessingHelpers.setDocumentation(_attribute, _builder_1.toString());
    EReference _reference = PostprocessingHelpers.getReference(cls, "imports");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("A list of all imported models.");
    _builder_2.newLine();
    PostprocessingHelpers.setDocumentation(_reference, _builder_2.toString());
    EReference _reference_1 = PostprocessingHelpers.getReference(cls, "mappings");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("A list of all defined mappings.");
    _builder_3.newLine();
    PostprocessingHelpers.setDocumentation(_reference_1, _builder_3.toString());
    EClass _class = PostprocessingHelpers.getClass(pckg, "Mapping");
    cls = _class;
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("This is the mapping of a logical system (defined in a ROOM model) to a");
    _builder_4.newLine();
    _builder_4.append("physical system (defined in a physical model).");
    _builder_4.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_4.toString());
    EReference _reference_2 = PostprocessingHelpers.getReference(cls, "logicalSys");
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("This is the logical system being mapped.");
    _builder_5.newLine();
    PostprocessingHelpers.setDocumentation(_reference_2, _builder_5.toString());
    EReference _reference_3 = PostprocessingHelpers.getReference(cls, "physicalSys");
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("This is the physical system being mapped to.");
    _builder_6.newLine();
    PostprocessingHelpers.setDocumentation(_reference_3, _builder_6.toString());
    EReference _reference_4 = PostprocessingHelpers.getReference(cls, "subsysMappings");
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("This is a list of nested mappings of the sub systems of this system.");
    _builder_7.newLine();
    PostprocessingHelpers.setDocumentation(_reference_4, _builder_7.toString());
    EClass _class_1 = PostprocessingHelpers.getClass(pckg, "SubSystemMapping");
    cls = _class_1;
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("This is the mapping of a sub system (defined in a ROOM model) to a");
    _builder_8.newLine();
    _builder_8.append("node (defined in a physical model).");
    _builder_8.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_8.toString());
    EReference _reference_5 = PostprocessingHelpers.getReference(cls, "logicalSubSys");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("This is the logical sub system being mapped.");
    _builder_9.newLine();
    PostprocessingHelpers.setDocumentation(_reference_5, _builder_9.toString());
    EReference _reference_6 = PostprocessingHelpers.getReference(cls, "node");
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("This is the node being mapped to.");
    _builder_10.newLine();
    PostprocessingHelpers.setDocumentation(_reference_6, _builder_10.toString());
    EReference _reference_7 = PostprocessingHelpers.getReference(cls, "threadMappings");
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("This is a list of nested mappings of logical to physical threads.");
    _builder_11.newLine();
    PostprocessingHelpers.setDocumentation(_reference_7, _builder_11.toString());
    EClass _class_2 = PostprocessingHelpers.getClass(pckg, "ThreadMapping");
    cls = _class_2;
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("This is the mapping of a logical thread (defined in a ROOM model) to a");
    _builder_12.newLine();
    _builder_12.append("physical thread (defined in a physical model).");
    _builder_12.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_12.toString());
    EReference _reference_8 = PostprocessingHelpers.getReference(cls, "logicalThread");
    StringConcatenation _builder_13 = new StringConcatenation();
    _builder_13.append("This is the logical thread being mapped.");
    _builder_13.newLine();
    PostprocessingHelpers.setDocumentation(_reference_8, _builder_13.toString());
    EReference _reference_9 = PostprocessingHelpers.getReference(cls, "physicalThread");
    StringConcatenation _builder_14 = new StringConcatenation();
    _builder_14.append("This is the physical thread being mapped to.");
    _builder_14.newLine();
    PostprocessingHelpers.setDocumentation(_reference_9, _builder_14.toString());
  }
}
