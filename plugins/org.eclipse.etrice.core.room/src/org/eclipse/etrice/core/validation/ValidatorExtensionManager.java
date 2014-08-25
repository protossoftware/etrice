/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.etrice.core.common.validation.CustomValidatorManager;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Custom validator manager for room language, that provides registration via an
 * extension point.
 * 
 */
public class ValidatorExtensionManager extends CustomValidatorManager {

	public static class ValidatorInfo {
		public static final String SEP = "@";

		private ICustomValidator validator;
		private String id;

		public ValidatorInfo(ICustomValidator validator, String id) {
			super();
			this.validator = validator;
			this.id = id;
		}

		public ICustomValidator getValidator() {
			return validator;
		}

		public String getName() {
			return validator.getName();
		}

		public String getDescription() {
			return validator.getDescription();
		}

		public String getId() {
			return id;
		}
	}

	public static class Registry {

		private static final String IVALIDATOR_ID = "org.eclipse.etrice.core.room.validation";
		private static Registry instance = null;
		private HashMap<String, ArrayList<ICustomValidator>> fastClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private HashMap<String, ArrayList<ICustomValidator>> normalClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private HashMap<String, ArrayList<ICustomValidator>> expensiveClass2Ext = new HashMap<String, ArrayList<ICustomValidator>>();
		private ArrayList<ValidatorInfo> infos = new ArrayList<ValidatorInfo>();
		private ArrayList<ValidatorInfo> excludedInfos = new ArrayList<ValidatorInfo>();
		private HashSet<ICustomValidator> excluded = new HashSet<ICustomValidator>();

		public static Registry getInstance() {
			if (instance == null)
				instance = new Registry();

			return instance;
		}

		public static boolean isAvailable() {
			return EMFPlugin.IS_ECLIPSE_RUNNING && Platform.getExtensionRegistry() != null
					&& Platform.getExtensionRegistry().getExtensionPoint(IVALIDATOR_ID) != null;
		}

		public void loadValidatorExtensions() {
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(IVALIDATOR_ID);

			// we use parent-package.class-name as key in our tables
			
			// compute all sub classes for all classes of the Room package
			HashMap<String, ArrayList<String>> cls2sub = new HashMap<String, ArrayList<String>>();
			for (EClassifier cls : RoomPackage.eINSTANCE.getEClassifiers()) {
				if (cls instanceof EClass) {
					EList<EClass> superTypes = ((EClass) cls).getESuperTypes();
					if (cls.getName().equals("ActorClass")) {
						for (EClass sup : superTypes) {
							EPackage pckg = (EPackage) sup.eContainer();
							String path = pckg.getName();
							put(path+"."+sup.getName(), ((EClass) cls).getName(), cls2sub);
						}
					}
				}
			}

			// now we add each extension to our maps
			for (IConfigurationElement e : config) {
				try {
					final Object ext = e.createExecutableExtension("class");
					if (ext instanceof ICustomValidator) {
						ICustomValidator validator = (ICustomValidator) ext;
						infos.add(new ValidatorInfo(validator, e.getName() + ValidatorInfo.SEP
								+ e.getNamespaceIdentifier()));
						String mode = e.getAttribute("mode");
						String classToCheck = e.getAttribute("classToCheck");
						int pos = classToCheck.lastIndexOf('.');
						if (pos>=0) {
							pos = classToCheck.lastIndexOf('.', pos-1);
							if (pos>=0) {
								classToCheck = classToCheck.substring(pos+1);
							}
						}
						HashMap<String, ArrayList<ICustomValidator>> map = getMap(mode);
						if (map != null) {
							put(map, classToCheck, (ICustomValidator) ext);
							ArrayList<String> subTypes = cls2sub.get(classToCheck);
							if (subTypes != null)
								for (String type : subTypes) {
									put(map, type, (ICustomValidator) ext);
								}
						}
					}
					else {
						System.out.println("ValidatorExtensionManager: unexpected extension");
					}
				}
				catch (CoreException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

		public void exclude(ValidatorInfo info) {
			excludedInfos.add(info);
			excluded.add(info.getValidator());
		}

		public void include(ValidatorInfo info) {
			excludedInfos.remove(info);
			excluded.remove(info.getValidator());
		}

		public void setIncluded(Collection<ValidatorInfo> includedInfos) {
			excluded.clear();
			excludedInfos.clear();

			Set<ValidatorInfo> toExclude = new HashSet<ValidatorInfo>(infos);
			toExclude.removeAll(includedInfos);
			excludedInfos.addAll(toExclude);

			for (ValidatorInfo info : excludedInfos)
				excluded.add(info.getValidator());
		}

		public List<ValidatorInfo> getInfos() {
			return Collections.unmodifiableList(infos);
		}

		public List<ValidatorInfo> getExcludedInfos() {
			return Collections.unmodifiableList(excludedInfos);
		}

		public List<ICustomValidator> getValidatorsToExecute(EObject object, CheckMode checkMode,
				ValidationMessageAcceptor messageAcceptor) {
			// we initialize the set of executed validators with the excluded
			// ones
			HashSet<ICustomValidator> executed = new HashSet<ICustomValidator>(excluded);

			if (checkMode.shouldCheck(CheckType.FAST))
				return validate(object, messageAcceptor, fastClass2Ext, executed);
			if (checkMode.shouldCheck(CheckType.NORMAL))
				return validate(object, messageAcceptor, normalClass2Ext, executed);
			if (checkMode.shouldCheck(CheckType.EXPENSIVE))
				return validate(object, messageAcceptor, expensiveClass2Ext, executed);

			assert (false) : "unexpected CheckType";
			return new ArrayList<ICustomValidator>();
		}

		private List<ICustomValidator> validate(EObject object, ValidationMessageAcceptor messageAcceptor,
				HashMap<String, ArrayList<ICustomValidator>> map, HashSet<ICustomValidator> executed) {
			ArrayList<ICustomValidator> result = new ArrayList<ICustomValidator>();

			ArrayList<ICustomValidator> validators = map.get(object.eClass().getName());
			if (validators != null)
				for (ICustomValidator validator : validators) {
					if (!executed.contains(validator)) {
						executed.add(validator);
						result.add(validator);
					}
				}

			return result;
		}

		private void put(String cls, String sub, HashMap<String, ArrayList<String>> cls2sub) {

			ArrayList<String> list = cls2sub.get(cls);
			if (list == null) {
				list = new ArrayList<String>();
				cls2sub.put(cls, list);
			}
			list.add(sub);
		}

		private void put(HashMap<String, ArrayList<ICustomValidator>> map, String cls, ICustomValidator val) {
			ArrayList<ICustomValidator> list = map.get(cls);
			if (list == null) {
				list = new ArrayList<ICustomValidator>();
				map.put(cls, list);
			}
			list.add(val);
		}

		private HashMap<String, ArrayList<ICustomValidator>> getMap(String mode) {
			if (mode.equals(CheckType.FAST.name()))
				return fastClass2Ext;
			else if (mode.equals(CheckType.NORMAL.name()))
				return normalClass2Ext;
			else if (mode.equals(CheckType.EXPENSIVE.name()))
				return normalClass2Ext;
			else
				return null;
		}
	}

	protected boolean isRegistryAvailable;
	
	public ValidatorExtensionManager(){
		super();
		isRegistryAvailable = Registry.isAvailable();
	}
	
	@Check
	public void checkObject(EObject object) {
		if (isRegistryAvailable) {
			ICustomValidator.ValidationContext context = new ValidationContextImpl(isStandalone(), isGeneration(),
					getCheckMode());
			for (ICustomValidator val : Registry.getInstance().getValidatorsToExecute(object, getCheckMode(),
					getMessageAcceptor()))
				executeValidator(val, object, null, getMessageAcceptor(), context);

		}
		else
			// use default registry
			super.checkObject(object);
	}

}
