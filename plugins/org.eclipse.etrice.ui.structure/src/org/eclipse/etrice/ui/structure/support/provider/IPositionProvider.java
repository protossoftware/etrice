/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.provider;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface IPositionProvider {
	public static class Pos {

		private int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public static class PosAndSize extends Pos {

		private int w, h;
		
		public PosAndSize(int x, int y, int w, int h) {
			super(x, y);
			this.w = w;
			this.h = h;
		}

		public int getW() {
			return w;
		}

		public int getH() {
			return h;
		}

	}

	/**
	 * Returns a new position provider.
	 * parent determines align and scaling
	 * 
	 * @param parent
	 * @param invisibleRect
	 * @param innerRect
	 * @return
	 */
	public IPositionProvider setNewParent(EObject parent, PosAndSize invisibleRect, PosAndSize innerRect);
	
	public boolean contains(EObject obj);
	public PosAndSize getDiagramPosition();
	public PosAndSize getPosition(EObject bo);
	public Pos getConnectionText(EObject bo);
	public List<Pos> getConnectionBendpoints(EObject bo);
}
