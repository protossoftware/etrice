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

import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.Transition;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public interface IPositionProvider {

	public static class Pos {
		private int x;
		private int y;
		
		

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}
	}
	
	public static class PosAndSize extends Pos {
		private int width;
		private int height;
		
		/**
		 * @param x
		 * @param y
		 * @param width
		 * @param height
		 */
		public PosAndSize(int x, int y, int width, int height) {
			super(x,y);
			this.width = width;
			this.height = height;
		}

		/**
		 * @return the width
		 */
		public int getWidth() {
			return width;
		}

		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}
	}

	public void setScale(double sx, double sy);

	public PosAndSize getPosition(StateGraphNode node);
	public <T extends StateGraphNode> List<PosAndSize> getPositions(List<T> items);
	public List<Pos> getPoints(Transition trans);
	/**
	 * 
	 * @param graph
	 * @return position of inital point
	 */
	public PosAndSize getPosition(StateGraph graph);
	
	/**
	 * @param graph
	 * @return BO of initial point's shape. A super graph or given graph itself.
	 */
	public StateGraph getInitialPoint(StateGraph graph);
}
