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
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ValidatorExtensionManager extends AbstractDeclarativeValidator {
	
	public static class ValidatorInfo {
		public static final String SEP = "@";
		
		private IRoomValidator validator;
		private String id;
		
		public ValidatorInfo(IRoomValidator validator, String id) {
			super();
			this.validator = validator;
			this.id = id;
		}
		
		public IRoomValidator getValidator() {
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
		
		private static final String PACKAGE = RoomPackage.class.getPackage().getName()+".";
		private static final String IVALIDATOR_ID = "org.eclipse.etrice.core.room.validation";
		private static Registry instance = null;
		private HashMap<String, ArrayList<IRoomValidator>> fastClass2Ext = new HashMap<String, ArrayList<IRoomValidator>>();
		private HashMap<String, ArrayList<IRoomValidator>> normalClass2Ext = new HashMap<String, ArrayList<IRoomValidator>>();
		private HashMap<String, ArrayList<IRoomValidator>> expensiveClass2Ext = new HashMap<String, ArrayList<IRoomValidator>>();
		private ArrayList<ValidatorInfo> infos = new ArrayList<ValidatorExtensionManager.ValidatorInfo>();
		private ArrayList<ValidatorInfo> excludedInfos = new ArrayList<ValidatorExtensionManager.ValidatorInfo>();
		private HashSet<IRoomValidator> excluded = new HashSet<IRoomValidator>();
		
		public static Registry getInstance() {
			if (instance==null)
				instance = new Registry();
			
			return instance;
		}
		
		public void loadValidatorExtensions() {
			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(IVALIDATOR_ID);
			
			// compute all sub classes for all classes of the Room package 
			HashMap<String, ArrayList<String>> cls2sub = new HashMap<String, ArrayList<String>>();
			for (EClassifier cls : RoomPackage.eINSTANCE.getEClassifiers()) {
				if (cls instanceof EClass) {
					EList<EClass> superTypes = ((EClass) cls).getESuperTypes();
					for (EClass sup : superTypes) {
						put(sup.getName(), ((EClass) cls).getName(), cls2sub);
					}
				}
			}
			
			// now we add each extension to our maps
			for (IConfigurationElement e : config) {
				try {
					final Object ext = e.createExecutableExtension("class");
					if (ext instanceof IRoomValidator) {
						IRoomValidator validator = (IRoomValidator) ext;
						infos.add(new ValidatorInfo(
								validator,
								e.getName()+ValidatorInfo.SEP+e.getNamespaceIdentifier()
							));
						String mode = e.getAttribute("mode");
						String classToCheck = e.getAttribute("classToCheck");
						if (classToCheck.startsWith(PACKAGE))
							classToCheck = classToCheck.substring(PACKAGE.length());
						EClassifier cls = RoomPackage.eINSTANCE.getEClassifier(classToCheck);
						if (cls instanceof EClass) {
							HashMap<String,ArrayList<IRoomValidator>> map = getMap(mode);
							if (map!=null) {
								put(map, ((EClass) cls).getName(), (IRoomValidator) ext);
								ArrayList<String> subTypes = cls2sub.get(cls.getName());
								if (subTypes!=null)
									for (String type : subTypes) {
										put(map, type, (IRoomValidator) ext);
									}
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

		public ArrayList<ValidatorInfo> getInfos() {
			return infos;
		}

		public ArrayList<ValidatorInfo> getExcludedInfos() {
			return excludedInfos;
		}
		
		public void validate(EObject object, CheckMode checkMode, ValidationMessageAcceptor messageAcceptor) {
			
			// we initialize the set of executed validators with the excluded ones
			HashSet<IRoomValidator> executed = new HashSet<IRoomValidator>(excluded);
			
			if (checkMode.shouldCheck(CheckType.FAST))
				validate(object, messageAcceptor, fastClass2Ext, executed);
			if (checkMode.shouldCheck(CheckType.NORMAL))
				validate(object, messageAcceptor, normalClass2Ext, executed);
			if (checkMode.shouldCheck(CheckType.EXPENSIVE))
				validate(object, messageAcceptor, expensiveClass2Ext, executed);
		}

		private void validate(EObject object,
				ValidationMessageAcceptor messageAcceptor,
				HashMap<String, ArrayList<IRoomValidator>> map, HashSet<IRoomValidator> executed) {
			ArrayList<IRoomValidator> validators = map.get(object.eClass().getName());
			if (validators!=null)
				for (IRoomValidator validator : validators) {
					if (!executed.contains(validator)) {
						executed.add(validator);
						executeExtension(validator, object, messageAcceptor);
					}
				}
		}
		
		private void put(String cls, String sub,
				HashMap<String,ArrayList<String>> cls2sub) {
			
			ArrayList<String> list = cls2sub.get(cls);
			if (list==null) {
				list = new ArrayList<String>();
				cls2sub.put(cls, list);
			}
			list.add(sub);
		}

		private void put(HashMap<String, ArrayList<IRoomValidator>> map, String cls, IRoomValidator val) {
			ArrayList<IRoomValidator> list = map.get(cls);
			if (list==null) {
				list = new ArrayList<IRoomValidator>();
				map.put(cls, list);
			}
			list.add(val);
		}
		
		private HashMap<String, ArrayList<IRoomValidator>> getMap(String mode) {
			if (mode.equals(CheckType.FAST.name()))
				return fastClass2Ext;
			else if (mode.equals(CheckType.NORMAL.name()))
				return normalClass2Ext;
			else if (mode.equals(CheckType.EXPENSIVE.name()))
				return normalClass2Ext;
			else
				return null;
		}
		
		private void executeExtension(
				final IRoomValidator validator,
				final EObject object,
				final ValidationMessageAcceptor messageAcceptor) {
			
			ISafeRunnable runnable = new ISafeRunnable() {
				@Override
				public void handleException(Throwable exception) {
					System.out.println("Exception in IRoomValidator " + validator.getName());
				}

				@Override
				public void run() throws Exception {
					validator.validate(object, messageAcceptor);
				}
			};
			SafeRunner.run(runnable);
		}
	}

	public ValidatorExtensionManager() {
		
	}
	
	@Check
	public void checkObject(EObject object) {
		//EcoreUtil.resolveAll(object.eResource().getResourceSet());
		Registry.getInstance().validate(object, getCheckMode(), getMessageAcceptor());
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// HOWTO: if this validator is registered for the RoomPackage then it is called twice
	}

//	@Override
//	protected List<EPackage> getEPackages() {
//	    List<EPackage> result = new ArrayList<EPackage>();
//	    result.add(RoomPackage.eINSTANCE);
//	    return result;
//	}

}
