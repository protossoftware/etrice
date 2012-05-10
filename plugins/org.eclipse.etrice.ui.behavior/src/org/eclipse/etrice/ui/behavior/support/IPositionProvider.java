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

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public interface IPositionProvider {

	public static class PosAndSize {
		private int x;
		private int y;
		private int width;
		private int height;
		
		/**
		 * @param x
		 * @param y
		 * @param width
		 * @param height
		 */
		public PosAndSize(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
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

	public <T extends StateGraphNode> List<PosAndSize> getPositions(List<T> items);
}
