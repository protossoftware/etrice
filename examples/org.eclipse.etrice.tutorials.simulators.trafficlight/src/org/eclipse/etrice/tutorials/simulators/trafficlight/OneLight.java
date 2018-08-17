/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz(initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.tutorials.simulators.trafficlight;

import java.awt.Color;
import java.awt.Graphics;

public class OneLight {
	public OneLight(int lightColor, int x, int y, int width, int height){
		this.lightColor = lightColor;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public void setState(int state){
		this.state = state;
	}

	public void draw(Graphics g){
		g.setColor(colorTable[lightColor][state]);
		g.fillOval(x, y, width, height);
		g.setColor(Color.black);
		g.drawOval(x, y, width-1, height-1);
	}

	public static final int NONE=0;
	public static final int RED=1;
	public static final int YELLOW=2;
	public static final int GREEN=3;

	private Color lightGrey = new Color(200,200,200);
	private Color darkGrey = new Color (127,127,127);
	private Color lightRed = new Color(255,0,0);
	private Color darkRed = new Color (127,0,0);
	private Color lightYellow = new Color (255,255,0);
	private Color darkYellow = new Color (127,127,0);
	private Color lightGreen = new Color (0,255,0);
	private Color darkGreen = new Color (0,127,0);
	
	private Color colorTable [][] = {
			{darkGrey, lightGrey},
			{darkRed, lightRed},
			{darkYellow, lightYellow},
			{darkGreen, lightGreen}
	};

	private int state = 0;
	private int x, y, width, height;
	
	private int lightColor = NONE;  
}
