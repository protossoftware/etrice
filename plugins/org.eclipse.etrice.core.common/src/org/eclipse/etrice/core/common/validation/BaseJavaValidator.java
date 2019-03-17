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
 * 		Eyrak Paen (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.validation;

import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationAttribute;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.EnumAnnotationAttribute;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.etrice.generator.base.io.IModelPathProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.validation.Check;

import com.google.common.base.Predicates;
import com.google.inject.Inject;

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
	public static final String DEPRECATED_IMPORT_URI = "BaseJavaValidator.DeprecatedImportUri";
	
	@Inject ImportUriResolver importUriResolver;
	@Inject IGlobalScopeProvider globalScopeProvider;
	@Inject IQualifiedNameConverter nameConverter;
	@Inject IModelPathProvider modelPathProvider;
	
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
					error("Mandatory attribute "+att.getName()+" is missing",
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
									error("Choose one of the allowed enum values",
											kv,
											BasePackage.Literals.KEY_VALUE__VALUE,
											UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE,
											values.toArray(new String[values.size()]));
								}
							}
							else {
								error("Choose one of the allowed enum values (values has to be a string)",
										kv,
										BasePackage.Literals.KEY_VALUE__VALUE,
										UNDEFINED_ANNOTATION_ATTRIBUTE_VALUE,
										values.toArray(new String[values.size()]));
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

	@Check
	public void checkImportedURI(Import imp) {
		if(imp.getImportURI() == null) {
			return;
		}
		
		Resource resource = imp.eResource();
		if(!modelPathProvider.get(resource).isEmpty()) {
			warning("import statements using uris are deprecated", BasePackage.Literals.IMPORT__IMPORT_URI, DEPRECATED_IMPORT_URI);
		}
		
		String uriString = importUriResolver.resolve(imp);
		if (uriString == null) {
			warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
			return;
		}

		URI uri = URI.createURI(uriString);
				
		if(resource.getResourceSet() instanceof ResourceSetImpl) {
			ResourceSetImpl rs = (ResourceSetImpl) resource.getResourceSet();
			if(rs.getURIResourceMap().containsKey(uri)) {
				return;
			}
		}

		try {			
			Resource importedResource = new ResourceSetImpl().getResource(uri, true);
			if (importedResource == null)
				return;

			if (importedResource.getContents().isEmpty()) {
				// importedResource is empty after being loaded the first time (<=> RuntimeException below)
				warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
		} catch (RuntimeException re) {
			warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
	}
	
	/**
	 * Check that the imported namespace can be found by the global scope provider.
	 * 
	 * @param imp the import to check
	 */
	@Check
	public void checkImportedNamespace(Import imp) {
		if(imp.getImportURI() == null) {
			if(modelPathProvider.get(imp.eResource()).isEmpty()) {
				error("no modelpath definition present", BasePackage.Literals.IMPORT__IMPORTED_NAMESPACE);
			}
			else {
				String name = imp.getImportedNamespace();
				if(name != null) {
					QualifiedName importedNamespace = nameConverter.toQualifiedName(name);
					if(!importedNamespace.getLastSegment().equals("*")) {
						Resource context = imp.eResource();
						EReference reference = EcoreFactory.eINSTANCE.createEReference();
						reference.setEType(EcorePackage.eINSTANCE.getEObject());
						IScope scope = globalScopeProvider.getScope(context, reference, Predicates.alwaysTrue());
						IEObjectDescription eod = scope.getSingleElement(importedNamespace);
						if(eod == null) {
							error("could not find imported namespace " + importedNamespace, BasePackage.Literals.IMPORT__IMPORTED_NAMESPACE);
						}
					}
				}
			}
		}
	}
}
