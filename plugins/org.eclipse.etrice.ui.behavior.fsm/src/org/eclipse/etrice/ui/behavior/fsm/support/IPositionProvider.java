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

package org.eclipse.etrice.ui.behavior.fsm.support;

import java.util.List;

import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.Transition;

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

	/**
	 * Set the size of the state graph to which coordinates should be mapped.
	 * 
	 * @param sx scale in x direction
	 * @param sy scale in y direction
	 */
	public void setScale(double sx, double sy);
	
	/**
	 * Set the position of the state graph to which coordinates should be mapped.
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y);

	/**
	 * @param sg a {@link StateGraph}
	 * @return the size of the state graph
	 */
	public PosAndSize getGraphPosAndSize(StateGraph sg);
	
	/**
	 * @param node a {@link StateGraphNode}
	 * @return the position of the node
	 */
	public PosAndSize getPosition(StateGraphNode node);
	
	/**
	 * @param items a list of {@link StateGraphNode}
	 * @return the positions of the nodes
	 */
	public <T extends StateGraphNode> List<PosAndSize> getPositions(List<T> items);
	
	/**
	 * @param trans a transition
	 * @return a list of {@link Pos positions}, the first is the label position further are bend point positions
	 */
	public List<Pos> getPoints(Transition trans);
	
	/**
	 * @param graph a {@link StateGraph}
	 * @return position of inital point
	 */
	public PosAndSize getPosition(StateGraph graph);
	
	/**
	 * @param graph a {@link StateGraph}
	 * @return BO of initial point's shape. A super graph of one of the base classes
	 * or given graph itself.
	 */
	public StateGraph getInitialPoint(StateGraph graph);
	
	/**
	 * @param subNode sub level item of a StateGraphNode parent
	 * @return relative position to parent (no size)
	 */
	public double[] getSubPosition(StateGraphNode subNode);
}
