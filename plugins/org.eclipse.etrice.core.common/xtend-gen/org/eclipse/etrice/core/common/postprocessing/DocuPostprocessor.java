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
  }
}
