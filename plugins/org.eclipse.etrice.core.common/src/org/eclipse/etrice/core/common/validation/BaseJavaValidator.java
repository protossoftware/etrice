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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.xtext.validation.Check;

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class BaseJavaValidator extends org.eclipse.etrice.core.common.validation.AbstractBaseJavaValidator {
	@Check
	public void checkDocumentation(Documentation doc) {
		if (doc.getLines().isEmpty())
			error("documentation must not be empty", doc, BasePackage.Literals.DOCUMENTATION__LINES);
	}
	
	@Check
	public void checkAnnotationTypeTargetsUnique(AnnotationType at) {
		Set<String> targets = new HashSet<String>();
		int i = 0;
		for(String t : at.getTargets()) {
			if(targets.add(t) == false) {
				error("duplicate target "+t, at, BasePackage.Literals.ANNOTATION_TYPE__TARGETS, i);
			}
			i++;
		}
	}
	
	@Check
	public void checkAnnotationAttributeKeys(Annotation a) {
		EList<AnnotationAttribute> validAttrList = a.getType().getAttributes();
		EList<KeyValue> attrList = a.getAttributes();
		Set<String> validAttrNames = new HashSet<String>();
		for(AnnotationAttribute attr : validAttrList) {
			validAttrNames.add(attr.getName());
		}
		for(int i = 0; i < attrList.size(); i++) {
			if(!validAttrNames.contains(attrList.get(i).getKey())) {
				error("Annotation contains undefined attribute", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
			}
		}
	}
	
	@Check
	public void checkAnnotationAttributeMandatory(Annotation a) {
		Set<String> mandatoryAttrNames = new HashSet<String>();
		Set<String> annoAttrNames = new HashSet<String>();
		for(AnnotationAttribute attr : a.getType().getAttributes()) {
			if(!attr.isOptional()) mandatoryAttrNames.add(attr.getName());
		}
		for(KeyValue kv : a.getAttributes()) {
			annoAttrNames.add(kv.getKey());
		}
		mandatoryAttrNames.removeAll(annoAttrNames);
		if(!mandatoryAttrNames.isEmpty()) {
			error("Annotation is missing mandatory attributes " + mandatoryAttrNames.toString(), a, null);
		}
	}
	
	@Check
	public void checkAnnotationAttributeType(Annotation a) {
		Map<String, AnnotationAttribute> attrDefs = new HashMap<String, AnnotationAttribute>();
		for(AnnotationAttribute annoAttr : a.getType().getAttributes()) {
			attrDefs.put(annoAttr.getName(), annoAttr);
		}
		for(int i = 0; i < a.getAttributes().size(); i++) {
			KeyValue kv = a.getAttributes().get(i);
			if(attrDefs.containsKey(kv.getKey())) {
				Literal val = kv.getValue();
				AnnotationAttribute attr = attrDefs.get(kv.getKey());
				if(BasePackage.Literals.SIMPLE_ANNOTATION_ATTRIBUTE.isInstance(attr)) {
					SimpleAnnotationAttribute simpleAttrDef = (SimpleAnnotationAttribute)attr;
					switch(simpleAttrDef.getType()) {
					case BOOL:
						if(!(val instanceof BooleanLiteral)) {
							error("Expected boolean attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case INT:
						if(!(val instanceof IntLiteral)) {
							error("Expected integer number attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case REAL:
						if(!(val instanceof RealLiteral)) {
							error("Expected real number attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case CHAR:
						if(!(val instanceof StringLiteral)) {
							error("Expected character string attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					}
				}
				else if(BasePackage.Literals.ENUM_ANNOTATION_ATTRIBUTE.isInstance(attr)) {
					if(!(val instanceof StringLiteral)) {
						error("Expected enum attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
					}
					else {
						EnumAnnotationAttribute enumAttrDef = (EnumAnnotationAttribute)attr;
						String strVal = ((StringLiteral)val).getValue(); 
						if(!enumAttrDef.getValues().contains(strVal)) {
							error("Invalid enum attribute value", a, BasePackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
					}
				}
			}
		}
	}
}
