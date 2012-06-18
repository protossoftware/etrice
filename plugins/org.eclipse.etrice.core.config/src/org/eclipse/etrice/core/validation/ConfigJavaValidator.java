/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.AttrConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.BooleanLiteral;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.IntLiteral;
import org.eclipse.etrice.core.config.Literal;
import org.eclipse.etrice.core.config.NumberLiteral;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.xtext.validation.Check;

public class ConfigJavaValidator extends AbstractConfigJavaValidator {

	@Check
	public void checkConfigModel(ConfigModel model) {
		// duplicate class config check
		Set<ActorClass> actorClasses = new HashSet<ActorClass>();
		for (ActorClassConfig classConfig : model.getActorClassConfigs()) {
			if (actorClasses.contains(classConfig.getActor()))
				error("duplicate class config", model,
						ConfigPackage.Literals.CONFIG_MODEL__CONFIG_ELEMENTS,
						model.getConfigElements().indexOf(classConfig));
			else
				actorClasses.add(classConfig.getActor());
		}
		// duplicate instance config check
		Set<String> instanceRefs = new HashSet<String>();
		for (ActorInstanceConfig instanceConfig : model
				.getActorInstanceConfigs()) {
			String ref = instanceConfig.getRoot().getName()
					+ refPathToString(instanceConfig.getPath());
			if (instanceRefs.contains(ref))
				error("duplicate instance config", model,
						ConfigPackage.Literals.CONFIG_MODEL__CONFIG_ELEMENTS,
						model.getConfigElements().indexOf(instanceConfig));
			else
				instanceRefs.add(ref);
		}
	}

	@Check
	public void checkActorClassConfig(ActorClassConfig config) {
		checkDuplicateAttributes(config.getAttributes(),
				ConfigPackage.Literals.ACTOR_CLASS_CONFIG__ATTRIBUTES);

	}

	@Check
	public void checkActorInstanceConfig(ActorInstanceConfig config) {
		ActorContainerClass root = config.getRoot();
		if (root != null && !root.eIsProxy()) {
			RefPath path = config.getPath();
			if (path != null) {
				String invalidSegment = ConfigUtil.checkPath(root, path);
				if (invalidSegment != null)
					error("no match for segment '" + invalidSegment + "'",
							ConfigPackage.eINSTANCE
									.getActorInstanceConfig_Path());
			}
		}

		checkDuplicateAttributes(config.getAttributes(),
				ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__ATTRIBUTES);
	}

	private void checkDuplicateAttributes(
			List<? extends AttrConfig> attrConfigs, EReference ref) {
		Set<Attribute> attributes = new HashSet<Attribute>();
		for (AttrConfig config : attrConfigs) {
			if (attributes.contains(config.getAttribute()))
				error("duplicate attribute entry", ref,
						attrConfigs.indexOf(config));
			else
				attributes.add(config.getAttribute());
		}
	}

	@Check
	public void checkAttrConfig(AttrConfig config) {
		Attribute attr = config.getAttribute();
		if (attr == null)
			return;

		DataType type = attr.getRefType().getType();
		if (type instanceof PrimitiveType) {
			PrimitiveType primitive = (PrimitiveType) type;

			checkAttrConfigValue(primitive, config);
		}
	}

	@Check
	public void checkAttrClassConfig(AttrClassConfig config) {
		Attribute attr = config.getAttribute();
		if (attr == null)
			return;

		DataType type = attr.getRefType().getType();
		if (type instanceof PrimitiveType) {
			PrimitiveType primitive = (PrimitiveType) type;

			checkAttrConfigMin(primitive, config);
			checkAttrConfigMax(primitive, config);
		}
	}

	@Check
	public void checkAttrInstanceConfig(AttrInstanceConfig config) {

	}

	private void checkAttrConfigValue(PrimitiveType primitive, AttrConfig config) {
		Literal value = config.getValue();
		if (value == null)
			return;

		EReference valueRef = ConfigPackage.eINSTANCE.getAttrConfig_Value();
		LiteralType type = primitive.getType();
		Attribute attribute = config.getAttribute();
		// type check
		switch (type) {
		case BOOL:
			if (!(value instanceof BooleanLiteral))
				error("must be boolean value", valueRef);
			break;
		case REAL:
			if (!(value instanceof NumberLiteral))
				error("must be an integer or real value", valueRef);
			break;
		case INT:
			if (!(value instanceof IntLiteral))
				error("must be an integer", valueRef);
			break;
		case CHAR:
			if (!(value instanceof StringLiteral))
				error("must be a string", valueRef);
			else {
				StringLiteral strValue = (StringLiteral) value;
				int maxLength = attribute.getSize() + 1;
				if (maxLength < strValue.getValue().length())
					error("too many characters - maximal length is "
							+ maxLength, valueRef);
			}
			break;
		}

		// numeric check
		if ((type == LiteralType.INT || type == LiteralType.REAL)
				&& value instanceof NumberLiteral) {
			ActorClassConfig classConfig = null;
			if (config.eContainer() instanceof ActorInstanceConfig) {
				ActorInstanceConfig actorConfig = (ActorInstanceConfig) config
						.eContainer();
				ActorContainerClass actorClass = ConfigUtil.resolve(
						actorConfig.getRoot(), actorConfig.getPath());
				// find ActorClassConfig
				ConfigModel model = getConfigModel(actorConfig);
				for (ActorClassConfig cf : model.getActorClassConfigs()) {
					if (cf.getActor().equals(actorClass)) {
						classConfig = cf;
						break;
					}
				}
			} else if (config.eContainer() instanceof ActorClassConfig)
				classConfig = (ActorClassConfig) config.eContainer();

			AttrClassConfig attrClassConfig = null;
			if (classConfig != null) {
				for (AttrClassConfig acf : classConfig.getAttributes())
					if (config.getAttribute().equals(acf.getAttribute())) {
						attrClassConfig = acf;
						break;
					}
			}

			if (attrClassConfig != null) {
				NumberLiteral min = attrClassConfig.getMin();
				NumberLiteral max = attrClassConfig.getMax();
				double dValue = ConfigUtil
						.literalToDouble((NumberLiteral) value);

				if (min != null) {
					double dMin = ConfigUtil.literalToDouble(min);
					if (dMin > dValue)
						error("value is less than minimum", valueRef);
				}
				if (max != null) {
					double dMax = ConfigUtil.literalToDouble(max);
					if (dMax < dValue)
						error("value exceeds maximum", valueRef);
				}
			}
		}
	}

	private void checkAttrConfigMin(PrimitiveType primitive,
			AttrClassConfig config) {
		NumberLiteral min = config.getMin();
		if (min == null)
			return;

		EReference minRef = ConfigPackage.eINSTANCE.getAttrClassConfig_Min();
		LiteralType type = primitive.getType();
		switch (type) {
		case INT:
			if (config instanceof RealLiteral)
				error("must be an integer", minRef);
			break;
		default:
			if (config != null)
				error("no minimum allowed", minRef);
		}

		if (type == LiteralType.INT || type == LiteralType.REAL) {
			// check room default if config default is not set
			if (config.getValue() == null) {
				double dMin = ConfigUtil.literalToDouble(min);
				String defaultValue = config.getAttribute()
						.getDefaultValueLiteral();
				try {
					double dDefaulValue = Double.parseDouble(defaultValue);
					if (dMin > dDefaulValue)
						error("default value in ROOM model is less than this minimun",
								minRef);
				} catch (NumberFormatException e) {
				}
			}
		}

	}

	private void checkAttrConfigMax(PrimitiveType primitive,
			AttrClassConfig config) {
		NumberLiteral max = config.getMin();
		if (max == null)
			return;

		EReference maxRef = ConfigPackage.eINSTANCE.getAttrClassConfig_Max();
		LiteralType type = primitive.getType();
		switch (type) {
		case INT:
			if (max instanceof RealLiteral)
				error("must be an integer", maxRef);
			break;
		default:
			if (max != null)
				error("no maximum allowed", maxRef);
		}

		if (type == LiteralType.INT || type == LiteralType.REAL) {
			// check room default if config default is not set
			if (config.getValue() == null) {
				double dMax = ConfigUtil.literalToDouble(max);
				String defaultValue = config.getAttribute()
						.getDefaultValueLiteral();
				try {
					double dDefaulValue = Double.parseDouble(defaultValue);
					if (dMax < dDefaulValue)
						error("default value in ROOM model exceeds this maximum",
								maxRef);
				} catch (NumberFormatException e) {
				}
			}
		}
	}

	private ConfigModel getConfigModel(EObject object) {
		EObject root = object;
		while (root.eContainer() != null)
			root = root.eContainer();

		return (ConfigModel) root;
	}

	private String refPathToString(RefPath path) {
		String str = "";
		for (String s : path.getRefs())
			str += "/" + s;

		return str;
	}
}
