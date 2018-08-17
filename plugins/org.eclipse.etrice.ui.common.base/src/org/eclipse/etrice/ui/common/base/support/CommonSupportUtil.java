/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.support;

import java.util.Iterator;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 *
 */
public class CommonSupportUtil {

	/**
	 * @param container
	 */
	public static void deleteConnectionsRecursive(ContainerShape container, IFeatureProvider fp) {
		for (Iterator<Anchor> iter = container.getAnchors().iterator(); iter.hasNext();) {
			Anchor anchor = iter.next();
			for (Iterator<Connection> iterator = Graphiti.getPeService().getAllConnections(anchor).iterator(); iterator.hasNext();) {
				Connection connection = iterator.next();
				DeleteContext ctx = new DeleteContext(connection);
				ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
				IDeleteFeature deleteFeature = fp.getDeleteFeature(ctx);
				if (deleteFeature!=null)
					deleteFeature.delete(ctx);
			}
		}
		
		// recursion
		for (Shape child : container.getChildren()) {
			if (child instanceof ContainerShape)
				deleteConnectionsRecursive((ContainerShape) child, fp);
		}
	}

}
