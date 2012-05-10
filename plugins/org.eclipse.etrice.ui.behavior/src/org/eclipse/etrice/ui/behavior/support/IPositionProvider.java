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

package org.eclipse.etrice.ui.behavior.support;

import java.util.List;

import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.graphiti.mm.algorithms.styles.Point;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public interface IPositionProvider {

	public void setScale(double sx, double sy);

	public <T extends StateGraphNode> List<Point> getPositions(List<T> items);
	public Point getPosition(StateGraphNode node);
}
