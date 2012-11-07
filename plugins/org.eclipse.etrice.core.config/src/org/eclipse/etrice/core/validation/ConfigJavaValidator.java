/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
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
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.etrice.core.config.PortClassConfig;
import org.eclipse.etrice.core.config.PortInstanceConfig;
import org.eclipse.etrice.core.config.ProtocolClassConfig;
import org.eclipse.etrice.core.config.RealLiteral;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.StringLiteral;
import org.eclipse.etrice.core.config.SubSystemConfig;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.converter.ConfigValueConverterService;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.validation.Check;

public class ConfigJavaValidator extends AbstractConfigJavaValidator {

	private ConfigValueConverterService converter = new ConfigValueConverterService();

	@Check
	public void checkConfigModel(ConfigModel model) {
		// duplicate actor class config check
		Set<ActorClass> actorClasses = new HashSet<ActorClass>();
		for (ActorClassConfig classConfig : model.getActorClassConfigs()) {
			if (actorClasses.contains(classConfig.getActor()))
				error("duplicate class config", model,
						ConfigPackage.Literals.CONFIG_MODEL__CONFIG_ELEMENTS,
						model.getConfigElements().indexOf(classConfig));
			else
				actorClasses.add(classConfig.getActor());
		}
		// duplicate actor instance config check
		Set<String> actorRefs = new HashSet<String>();
		for (ActorInstanceConfig instanceConfig : model
				.getActorInstanceConfigs()) {
			String ref = instanceConfig.getRoot().getName()
					+ refPathToString(instanceConfig.getPath());
			if (actorRefs.contains(ref))
				error("duplicate actor instance config", model,
						ConfigPackage.Literals.CONFIG_MODEL__CONFIG_ELEMENTS,
						model.getConfigElements().indexOf(instanceConfig));
			else
				actorRefs.add(ref);
		}
		// duplicate protocol class config check
		Set<ProtocolClass> protocolClasses = new HashSet<ProtocolClass>();
		for (ProtocolClassConfig protocolConfig : model
				.getProtocolClassConfigs()) {
			if (protocolClasses.contains(protocolConfig.getProtocol()))
				error("duplicate protocol class config", model,
						ConfigPackage.Literals.CONFIG_MODEL__CONFIG_ELEMENTS,
						model.getConfigElements().indexOf(protocolConfig));
			else
				protocolClasses.add(protocolConfig.getProtocol());
		}
	}

	@Check
	public void checkActorClassConfig(ActorClassConfig config) {
		if (config.getActor().isAbstract())
			error("abstract actor classes not supported",
					ConfigPackage.Literals.ACTOR_CLASS_CONFIG__ACTOR);
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
							ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__PATH);
				else {
					ActorRef aRef = ConfigUtil.getLastActorRef(root, path);
					if (aRef != null) {
						if (aRef.getSize() > 1)
							error("no arrays of actor references supported",
									ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__PATH);
					} else
						error("invalid actor reference",
								ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__PATH);
				}
			}
		}
		// duplicate port instance config check
		Set<InterfaceItem> items = new HashSet<InterfaceItem>();
		for (PortInstanceConfig portConfig : config.getPorts()) {
			InterfaceItem item = portConfig.getItem();
			if (items.contains(item))
				error("duplicate port instance config",
						ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__PORTS,
						config.getPorts().indexOf(portConfig));
			else
				items.add(item);
		}

		checkDuplicateAttributes(config.getAttributes(),
				ConfigPackage.Literals.ACTOR_INSTANCE_CONFIG__ATTRIBUTES);
	}

	@Check
	public void checkPortClassConfig(PortClassConfig config) {
		checkDuplicateAttributes(config.getAttributes(),
				ConfigPackage.Literals.PORT_CLASS_CONFIG__ATTRIBUTES);
	}

	@Check
	public void checkPortInstanceConfig(PortInstanceConfig config) {
		checkDuplicateAttributes(config.getAttributes(),
				ConfigPackage.Literals.PORT_INSTANCE_CONFIG__ATTRIBUTES);
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
		Attribute a = config.getAttribute();
		if (a == null)
			return;

		DataType type = a.getRefType().getType();
		if (type instanceof PrimitiveType) {
			PrimitiveType primitive = (PrimitiveType) type;
			checkAttrConfigValue(primitive, config);
		} else if (type instanceof DataType) {
			if (config.getValue() != null)
				error("not available",
						ConfigPackage.Literals.ATTR_CONFIG__VALUE);
			if (a.getSize() > 0)
				error("DataClass arrays not supported",
						ConfigPackage.Literals.ATTR_CLASS_CONFIG__ATTRIBUTES);
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
		Attribute attr = config.getAttribute();
		if (attr == null)
			return;

		EStructuralFeature feature = ConfigPackage.eINSTANCE
				.getAttrInstanceConfig_DynConfig();
		if (config.isDynConfig()) {
			if (!(config.eContainer() instanceof ActorInstanceConfig))
				error("dynamic configuration only at root attributes", feature);
			if (config.eContainer() instanceof ActorInstanceConfig) {
				SubSystemClass ssc = ((ActorInstanceConfig) config.eContainer())
						.getRoot();
				ConfigModel model = getConfigModel(config);
				boolean found = false;
				for (SubSystemConfig c : model.getSubSystemConfigs())
					if (c.getSubSystem().equals(ssc)) {
						if (c.getDynConfig() == null)
							error("no source for dynamic config in SubSystemConfig",
									feature);
						found = true;
					}
				if (!found)
					error("no SubSystemConfig found", feature);

			}
		}

	}

	private void checkAttrConfigValue(PrimitiveType primitive, AttrConfig config) {
		if (config.getValue() == null)
			return;

		List<Literal> values = config.getValue().getLiterals();
		EReference valueRef = ConfigPackage.eINSTANCE.getAttrConfig_Value();
		EReference arrayRef = ConfigPackage.eINSTANCE
				.getLiteralArray_Literals();
		LiteralType type = primitive.getType();
		Attribute attribute = config.getAttribute();
		int attrMult = (attribute.getSize() > 0) ? attribute.getSize() : 1;
		if (type != LiteralType.CHAR) {
			if (values.size() > attrMult)
				error("too many values, multiplicity is " + attrMult, valueRef);
			if (values.size() > 1 && values.size() < attrMult)
				error("not enough values, multiplicity is " + attrMult,
						valueRef);
		}
		// type check
		for (Literal value : values) {
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
					if (values.size() > 1)
						error("multiplicity must be one", valueRef);
					StringLiteral strValue = (StringLiteral) value;
					if (attribute.getSize() > 0
							&& attrMult < strValue.getValue().length())
						error("too many characters - maximal length is "
								+ attrMult, valueRef);
				}
				break;
			}
		}

		// numeric check
		if ((type == LiteralType.INT || type == LiteralType.REAL)) {
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
				for (Literal value : values) {
					if (!(value instanceof NumberLiteral))
						continue;

					if (value instanceof RealLiteral) {
						double dbValue = ((RealLiteral) value).getValue();
						if (min instanceof RealLiteral) {
							double dbMin = ((RealLiteral) min).getValue();
							if (dbMin > dbValue)
								error("value is less than minimum",
										config.getValue(), arrayRef,
										values.indexOf(value));
						}
						if (max instanceof RealLiteral) {
							double dbMax = ((RealLiteral) max).getValue();
							if (dbMax < dbValue)
								error("value exceeds maximum",
										config.getValue(), arrayRef,
										values.indexOf(value));
						}
					} else if (value instanceof IntLiteral) {
						long lValue = ((IntLiteral) value).getValue();
						if (min instanceof IntLiteral) {
							long lMin = ((IntLiteral) min).getValue();
							if (lMin > lValue)
								error("value is less than minimum",
										config.getValue(), arrayRef,
										values.indexOf(value));
						}
						if (max instanceof IntLiteral) {
							long lMax = ((IntLiteral) max).getValue();
							if (lMax < lValue)
								error("value exceeds maximum",
										config.getValue(), arrayRef,
										values.indexOf(value));
						}
					}
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

		if (type == LiteralType.INT || type == LiteralType.REAL) {
			if (primitive.getType() == LiteralType.INT) {
				if (!(min instanceof IntLiteral))
					error("incompatible datatype: maximum is not int", minRef);
			} else if (primitive.getType() == LiteralType.REAL) {
				if (!(min instanceof RealLiteral))
					error("incompatible datatype: maximum is not real", minRef);
			}
			// check room default if config default is not set
			String defaultValue = config.getAttribute()
					.getDefaultValueLiteral();
			if (config.getValue() == null && defaultValue != null) {
				if (type == LiteralType.INT) {
					if (min instanceof IntLiteral) {
						try {
							long lDefaultValue = converter.getLongConverter()
									.toValue(defaultValue, null);
							long lMax = ((IntLiteral) min).getValue();
							if (lMax < lDefaultValue)
								error("default value in ROOM model is less than this maximum",
										minRef);
						} catch (ValueConverterException e) {
							warning("could not compare with int value in ROOM model (parse error)",
									minRef);
						}
					} else
						warning("could not compare with int value in ROOM model (incompatible datatypes)",
								minRef);
				} else if (type == LiteralType.REAL) {
					if (min instanceof RealLiteral) {
						try {
							double dbDefaultValue = converter
									.getRealConverter().toValue(defaultValue,
											null);
							double dbMax = ((RealLiteral) min).getValue();
							if (dbMax < dbDefaultValue)
								error("default value in ROOM model is less than this maximum",
										minRef);
						} catch (ValueConverterException e1) {
							warning("could not compare with real value in ROOM model (parse error)",
									minRef);
						}
					} else
						warning("could not compare with real value in ROOM model (incompatible datatypes)",
								minRef);
				}

			}
		}

	}

	private void checkAttrConfigMax(PrimitiveType primitive,
			AttrClassConfig config) {
		NumberLiteral max = config.getMax();
		if (max == null)
			return;

		EReference maxRef = ConfigPackage.eINSTANCE.getAttrClassConfig_Max();
		LiteralType type = primitive.getType();

		if (type == LiteralType.INT || type == LiteralType.REAL) {
			if (primitive.getType() == LiteralType.INT) {
				if (!(max instanceof IntLiteral))
					error("incompatible datatype: maximum is not int", maxRef);
			} else if (primitive.getType() == LiteralType.REAL) {
				if (!(max instanceof RealLiteral))
					error("incompatible datatype: maximum is not real", maxRef);
			}
			// check room default if config default is not set
			String defaultValue = config.getAttribute()
					.getDefaultValueLiteral();
			if (config.getValue() == null && defaultValue != null) {
				if (type == LiteralType.INT) {
					if (max instanceof IntLiteral) {
						try {
							long lDefaultValue = converter.getLongConverter()
									.toValue(defaultValue, null);
							long lMax = ((IntLiteral) max).getValue();
							if (lMax < lDefaultValue)
								error("default value in ROOM model exceeds this maximum",
										maxRef);
						} catch (ValueConverterException e) {
							warning("could not compare with int value in ROOM model (parse error)",
									maxRef);
						}
					} else
						warning("could not compare with int value in ROOM model (incompatible datatypes)",
								maxRef);
				} else if (type == LiteralType.REAL) {
					if (max instanceof RealLiteral) {
						try {
							double dbDefaultValue = converter
									.getRealConverter().toValue(defaultValue,
											null);
							double dbMax = ((RealLiteral) max).getValue();
							if (dbMax < dbDefaultValue)
								error("default value in ROOM model exceeds this maximum",
										maxRef);
						} catch (ValueConverterException e1) {
							warning("could not compare with real value in ROOM model (parse error)",
									maxRef);
						}
					} else
						warning("could not compare with real value in ROOM model (incompatible datatypes)",
								maxRef);
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
