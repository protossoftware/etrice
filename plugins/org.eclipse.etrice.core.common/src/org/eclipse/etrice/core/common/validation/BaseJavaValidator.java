/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.validation;

import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.xtext.validation.Check;

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class BaseJavaValidator extends org.eclipse.etrice.core.common.validation.AbstractBaseJavaValidator {
	
	public static final String MANDATORY_ATTRIBUTE_MISSING = "BaseJavaValidator.MandatoryAttributeMissing";
	public static final String DUPLICATE_ANNOTATION_TARGETS = "BaseJavaValidator.DuplicateAnnotationTargets";
	public static final String UNDEFINED_ANNOTATION_ATTRIBUTE = "BaseJavaValidator.UndfinedAnnotationAttribute";
	public static final String UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE = "BaseJavaValidator.UndfinedAnnotationAttributeValue";
	public static final String DUPLICATE_ANNOTATION_ATTRIBUTE = "BaseJavaValidator.DuplicateAnnotationAttribute";
	
	@Check
	public void checkDocumentation(Documentation doc) {
		if (doc.getLines().isEmpty())
			error("documentation must not be empty", doc, BasePackage.Literals.DOCUMENTATION__LINES);
	}
	
	@Check
	public void checkAnnotationTypeTargetsUnique(AnnotationType at) {
		HashSet<String> targets = new HashSet<String>();
		for (String tgt : at.getTargets()) {
			if (!targets.add(tgt)) {
				error("The target "+tgt+" is defined more than once",
						at,
						BasePackage.Literals.ANNOTATION_TYPE__TARGETS,
						DUPLICATE_ANNOTATION_TARGETS,
						tgt);
			}
		}
	}
	
	@Check
	public void checkAnnotationAttributeMandatory(Annotation a) {
		for (AnnotationAttribute att : a.getType().getAttributes()) {
			if (!att.isOptional()) {
				boolean isDefined = false;
				for (KeyValue kv : a.getAttributes()) {
					if (kv.getKey().equals(att.getName())) {
						isDefined = true;
						break;
					}
				}
				if (!isDefined) {
					error("mandatory attribute "+att.getName()+" is missing",
							a,
							BasePackage.Literals.ANNOTATION__ATTRIBUTES,
							MANDATORY_ATTRIBUTE_MISSING,
							att.getName());
				}
			}
		}
	}
	
	@Check
	public void checkAnnotationAttributeType(Annotation a) {
		HashSet<String> names = new HashSet<String>();
		for (KeyValue kv : a.getAttributes()) {
			int idx = a.getAttributes().indexOf(kv);
			
			if (!names.add(kv.getKey())) {
				error("duplicate attribute "+kv.getKey(),
						a,
						BasePackage.Literals.ANNOTATION__ATTRIBUTES,
						idx,
						DUPLICATE_ANNOTATION_ATTRIBUTE,
						kv.getKey()
					);
			}
			boolean isAllowed = false;
			for (AnnotationAttribute att : a.getType().getAttributes()) {
				if (att.getName().equals(kv.getKey())) {
					isAllowed = true;
					
					// check also value of enum attribute
					if (kv.getValue()!=null) {
						if (att instanceof EnumAnnotationAttribute) {
							EList<String> values = ((EnumAnnotationAttribute) att).getValues();
							if (kv.getValue() instanceof StringLiteral) {
								boolean valueAllowed = false;
								String value = ((StringLiteral)kv.getValue()).getValue();
								for (String val : values) {
									if (val.equals(value)) {
										valueAllowed = true;
										break;
									}
								}
								if (!valueAllowed) {
									error("choose one of the allowed enum values",
											kv,
											BasePackage.Literals.KEY_VALUE__VALUE,
											UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE,
											values.toArray(new String[values.size()]));
								}
							}
							else {
								error("choose one of the allowed enum values (values has to be a string)",
										kv,
										BasePackage.Literals.KEY_VALUE__VALUE,
										UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE,
										values.toArray(new String[values.size()]));
							}
						}
					}
					else if (att instanceof SimpleAnnotationAttribute) {
						switch (((SimpleAnnotationAttribute) att).getType()) {
							case BOOL :
								if (!(kv.getValue() instanceof BooleanLiteral))
									error("boolean literal expected", kv, BasePackage.Literals.KEY_VALUE__VALUE);
								break;
							case CHAR :
								if (!(kv.getValue() instanceof StringLiteral))
									error("char/string literal expected", kv, BasePackage.Literals.KEY_VALUE__VALUE);
								break;
							case INT :
								if (!(kv.getValue() instanceof IntLiteral))
									error("integer literal expected", kv, BasePackage.Literals.KEY_VALUE__VALUE);
								break;
							case REAL :
								if (!(kv.getValue() instanceof RealLiteral))
									error("real literal expected", kv, BasePackage.Literals.KEY_VALUE__VALUE);
								break;
							default :
								break;
						}
					}
					break;
				}
			}
			if (!isAllowed) {
				error("Attribute "+kv.getKey()+" is undefined",
						a,
						BasePackage.Literals.ANNOTATION__ATTRIBUTES,
						idx,
						UNDEFINED_ANNOTATION_ATTRIBUTE,
						kv.getKey());
			}
		}
	}
}
