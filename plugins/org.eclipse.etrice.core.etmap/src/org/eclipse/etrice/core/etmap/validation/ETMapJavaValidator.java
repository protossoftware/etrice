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

package org.eclipse.etrice.core.etmap.validation;

import org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping;
import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.RefPath;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.xtext.validation.Check;
 

public class ETMapJavaValidator extends AbstractETMapJavaValidator {

	@Check
	public void checkActorInstanceConfig(ActorInstanceMapping aim) {
		ActorContainerClass root = ETMapUtil.getParentContainer(aim);
		if (root != null && !root.eIsProxy()) {
			RefPath path = aim.getPath();
			if (path != null) {
				String invalidSegment = ETMapUtil.checkPath(root, path);
				if (invalidSegment != null)
					error("no match for segment '" + invalidSegment + "'",
							ETMapPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				else {
					ActorRef aRef = ETMapUtil.getLastActorRef(root, path);
					if (aRef != null) {
						if (aRef.getSize() > 1)
							error("no arrays of actor references supported",
									ETMapPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
					} else
						error("invalid actor reference",
								ETMapPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				}
			}
		}
	}

}
