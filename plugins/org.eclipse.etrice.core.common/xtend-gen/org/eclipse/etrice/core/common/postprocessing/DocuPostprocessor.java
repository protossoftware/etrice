/**
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 		Eyrak Paen
 */
package org.eclipse.etrice.core.common.postprocessing;

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
    EClass cls = PostprocessingHelpers.getClass(pckg, "LiteralArray");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Aggregates one or more {@link Literal literals}.\t\t");
    _builder.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder.toString());
    EReference _reference = PostprocessingHelpers.getReference(cls, "literals");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("This is a list of literals.");
    _builder_1.newLine();
    PostprocessingHelpers.setDocumentation(_reference, _builder_1.toString());
    EClass _class = PostprocessingHelpers.getClass(pckg, "Literal");
    cls = _class;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("It is the super class of");
    _builder_2.newLine();
    _builder_2.append("<ul>");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("<li>{@link BooleanLiteral}</li>");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("<li>{@link NumberLiteral}</li>");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("<li>{@link StringLiteral}</li>");
    _builder_2.newLine();
    _builder_2.append("</ul>");
    _builder_2.newLine();
    _builder_2.append("that represents a primitive value.");
    _builder_2.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_2.toString());
    EClass _class_1 = PostprocessingHelpers.getClass(pckg, "Documentation");
    cls = _class_1;
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("A piece of documentation that can be optionally attached at");
    _builder_3.newLine();
    _builder_3.append("certain places in the model.");
    _builder_3.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_3.toString());
    EAttribute _attribute = PostprocessingHelpers.getAttribute(cls, "lines");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("This is the documentation\'s contents.");
    _builder_4.newLine();
    PostprocessingHelpers.setDocumentation(_attribute, _builder_4.toString());
    EClass _class_2 = PostprocessingHelpers.getClass(pckg, "Annotation");
    cls = _class_2;
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("An annotation similar to Java annotations that can be used");
    _builder_5.newLine();
    _builder_5.append("to add {@link KeyValue} pairs to certain model items. The structure ");
    _builder_5.newLine();
    _builder_5.append("of Annotations are defined by {@link AnnotationType}s.");
    _builder_5.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_5.toString());
    EReference _reference_1 = PostprocessingHelpers.getReference(cls, "type");
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("The {@link AnnotationType} that defines the structure of ");
    _builder_6.newLine();
    _builder_6.append("the annotation.");
    _builder_6.newLine();
    PostprocessingHelpers.setDocumentation(_reference_1, _builder_6.toString());
    EReference _reference_2 = PostprocessingHelpers.getReference(cls, "attributes");
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("This is a list of key/value pairs.");
    _builder_7.newLine();
    PostprocessingHelpers.setDocumentation(_reference_2, _builder_7.toString());
    EClass _class_3 = PostprocessingHelpers.getClass(pckg, "KeyValue");
    cls = _class_3;
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("A key/value pair.");
    _builder_8.newLine();
    PostprocessingHelpers.setDocumentation(cls, _builder_8.toString());
    EAttribute _attribute_1 = PostprocessingHelpers.getAttribute(cls, "key");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("This is the key of the pair.");
    _builder_9.newLine();
    PostprocessingHelpers.setDocumentation(_attribute_1, _builder_9.toString());
    EReference _reference_3 = PostprocessingHelpers.getReference(cls, "value");
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("This is the value of the pair.");
    _builder_10.newLine();
    PostprocessingHelpers.setDocumentation(_reference_3, _builder_10.toString());
    EClass _class_4 = PostprocessingHelpers.getClass(pckg, "AnnotationType");
    cls = _class_4;
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("Defines the structure of {@link Annotation}s.");
    PostprocessingHelpers.setDocumentation(cls, _builder_11.toString());
    EAttribute _attribute_2 = PostprocessingHelpers.getAttribute(cls, "name");
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("The name of the AnnotationType");
    PostprocessingHelpers.setDocumentation(_attribute_2, _builder_12.toString());
    EAttribute _attribute_3 = PostprocessingHelpers.getAttribute(cls, "targets");
    StringConcatenation _builder_13 = new StringConcatenation();
    _builder_13.append("A list of names representing the locations in which ");
    _builder_13.newLine();
    _builder_13.append("\t\t\t");
    _builder_13.append("{@link Annotation}s of this AnnotationType can occur");
    PostprocessingHelpers.setDocumentation(_attribute_3, _builder_13.toString());
    EReference _reference_4 = PostprocessingHelpers.getReference(cls, "docu");
    StringConcatenation _builder_14 = new StringConcatenation();
    _builder_14.append("Optional model-level documentation");
    PostprocessingHelpers.setDocumentation(_reference_4, _builder_14.toString());
    EReference _reference_5 = PostprocessingHelpers.getReference(cls, "attributes");
    StringConcatenation _builder_15 = new StringConcatenation();
    _builder_15.append("Defines the {@link AnnotationAttribute}s that are required or allowed in ");
    _builder_15.newLine();
    _builder_15.append("\t\t\t");
    _builder_15.append("{@link Annotation} instances of this AnnotationType");
    PostprocessingHelpers.setDocumentation(_reference_5, _builder_15.toString());
    EClass _class_5 = PostprocessingHelpers.getClass(pckg, "AnnotationAttribute");
    cls = _class_5;
    StringConcatenation _builder_16 = new StringConcatenation();
    _builder_16.append("Defines an attribute in an {@link AnnotationType}. This attribute ");
    _builder_16.newLine();
    _builder_16.append("\t\t\t");
    _builder_16.append("can then be declared in respective {@link Annotation} instances.");
    PostprocessingHelpers.setDocumentation(cls, _builder_16.toString());
    EAttribute _attribute_4 = PostprocessingHelpers.getAttribute(cls, "optional");
    StringConcatenation _builder_17 = new StringConcatenation();
    _builder_17.append("Specifies whether the attribute should be optional or not. If the ");
    _builder_17.newLine();
    _builder_17.append("\t\t\t");
    _builder_17.append("attribute is optional, it can be omitted by {@link Annotation}s of ");
    _builder_17.newLine();
    _builder_17.append("\t\t\t");
    _builder_17.append("the same {@link AnnotationType}.");
    _builder_17.newLine();
    PostprocessingHelpers.setDocumentation(_attribute_4, _builder_17.toString());
    EAttribute _attribute_5 = PostprocessingHelpers.getAttribute(cls, "name");
    StringConcatenation _builder_18 = new StringConcatenation();
    _builder_18.append("The name of the attribute");
    PostprocessingHelpers.setDocumentation(_attribute_5, _builder_18.toString());
    EClass _class_6 = PostprocessingHelpers.getClass(pckg, "SimpleAnnotationAttribute");
    cls = _class_6;
    StringConcatenation _builder_19 = new StringConcatenation();
    _builder_19.append("An {@link AnnotationAttribute} that is associated with a ");
    _builder_19.newLine();
    _builder_19.append("\t\t\t");
    _builder_19.append("{@link LiteralType}.");
    PostprocessingHelpers.setDocumentation(cls, _builder_19.toString());
    EAttribute _attribute_6 = PostprocessingHelpers.getAttribute(cls, "type");
    StringConcatenation _builder_20 = new StringConcatenation();
    _builder_20.append("The type of the attribute");
    PostprocessingHelpers.setDocumentation(_attribute_6, _builder_20.toString());
    EClass _class_7 = PostprocessingHelpers.getClass(pckg, "EnumAnnotationAttribute");
    cls = _class_7;
    StringConcatenation _builder_21 = new StringConcatenation();
    _builder_21.append("An {@link AnnotationAttribute} whose possible values are defined ");
    _builder_21.newLine();
    _builder_21.append("\t\t\t");
    _builder_21.append("by a list of String values.");
    PostprocessingHelpers.setDocumentation(cls, _builder_21.toString());
    EAttribute _attribute_7 = PostprocessingHelpers.getAttribute(cls, "values");
    StringConcatenation _builder_22 = new StringConcatenation();
    _builder_22.append("A list of values that define the enumeration");
    PostprocessingHelpers.setDocumentation(_attribute_7, _builder_22.toString());
  }
}
