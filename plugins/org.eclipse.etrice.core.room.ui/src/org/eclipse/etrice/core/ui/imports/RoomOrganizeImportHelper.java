/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.ui.imports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.util.ImportHelpers;
import org.eclipse.etrice.core.common.ui.imports.IOrganizeImportHelper;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomOrganizeImportHelper implements IOrganizeImportHelper {
	
	@Inject
	ImportHelpers importHelpers;

	@Override
	public Multimap<EClass, EReference> getTypeReferences() {
		Multimap<EClass, EReference> result = ArrayListMultimap.create();
		Map<EClass,List<EClass>> subTypes = new HashMap<>();
		getSubTypes(RoomPackage.eINSTANCE, subTypes);
		RoomPackage.eINSTANCE.getEClassifiers().stream() //
				.filter(EClass.class::isInstance) //
				.map(EClass.class::cast) //
				.forEach(cls -> {
					List<EReference> refs = cls.getEReferences().stream() //
						.filter(ref -> !ref.isContainment() && typeNeedsImport(ref.getEReferenceType())) //
						.collect(Collectors.toList());
					if (!refs.isEmpty()) {
						result.putAll(cls, refs);
						List<EClass> subClasses = subTypes.get(cls);
						if (subClasses!=null) {
							for (EClass subClass : subClasses) {
								result.putAll(subClass, refs);
							}
						}
					}
				});
		return result;
	}

	@Override
	public QualifiedName getFullyQualifiedName(EObject object) {
		if (object instanceof RoomClass) {
			EObject root = EcoreUtil2.getRootContainer(object);
			if (root instanceof RoomModel) {
				QualifiedName result = QualifiedName.create(((RoomModel) root).getName().split("\\."));
				result = result.append(((RoomClass) object).getName());
				return result;
			}
		}
		else if (object instanceof RoomModel) {
			return QualifiedName.create(((RoomModel) object).getName().split("\\."));
		}
		return null;
	}

	@Override
	public List<QualifiedName> resolveFullyQualifiedName(String refText, EClass type, Resource resource) {
		return importHelpers.createModelPathImports(refText, resource, type, false).stream() //
			.map(imp -> importHelpers.toFQN(imp)).collect(Collectors.toList());
	}

	public ImportRegionResult getImportRegion(XtextResource resource) {
		ImportRegionResult importRegion = IOrganizeImportHelper.super.getImportRegion(resource);
		if (importRegion==null) {
			// there is no import yet: check annotation types
			if (resource.getContents().get(0) instanceof RoomModel) {
				RoomModel roomModel = (RoomModel) resource.getContents().get(0);
				EObject placeBefore = null;
				if (!roomModel.getAnnotationTypes().isEmpty()) {
					placeBefore = roomModel.getAnnotationTypes().get(0);
				}
				else if (!roomModel.getRoomClasses().isEmpty()) {
					placeBefore = roomModel.getRoomClasses().get(0);
				}
				if (placeBefore!=null) {
					ICompositeNode node = NodeModelUtils.findActualNodeFor(placeBefore);
					if (node!=null) {
						return new ImportRegionResult(node.getOffset(), 0, true);
					}
				}
			}
		}
		return importRegion;
	}
	
	private boolean typeNeedsImport(EClass type) {
		return RoomPackage.Literals.ROOM_CLASS.isSuperTypeOf(type);
	}
	
	// copied from org.eclipse.emf.cdo.common/src/org/eclipse/emf/cdo/common/model/CDOModelUtil.java
	private static void getSubTypes(EPackage ePackage, Map<EClass, List<EClass>> result) {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass eClass = (EClass) classifier;
				getSubType(eClass, EcorePackage.eINSTANCE.getEObject(), result);

				for (EClass eSuperType : eClass.getEAllSuperTypes()) {
					getSubType(eClass, eSuperType, result);
				}
			}
		}
	}

	private static void getSubType(EClass eClass, EClass eSuperType, Map<EClass, List<EClass>> result) {
		if (eSuperType.eIsProxy()) {
			// OM.LOG.warn("getSubTypes encountered a proxy EClass which will be ignored: "
			// + eSuperType);
			return;
		}

		List<EClass> list = result.get(eSuperType);
		if (list == null) {
			list = new ArrayList<>();
			result.put(eSuperType, list);
		}

		list.add(eClass);
	}
  }
