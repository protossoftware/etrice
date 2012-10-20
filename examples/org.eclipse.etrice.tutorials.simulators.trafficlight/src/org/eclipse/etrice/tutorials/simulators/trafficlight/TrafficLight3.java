/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung (initial contribution)
 *    Thomas Schuetz
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class TrafficLight3 extends Canvas {
	private static final long serialVersionUID = 1L;
	// Traffic light has 4 states
	public final int RED = 0;
	public final int YELLOWRED = 1;
	public final int GREEN = 2;
	public final int YELLOW = 3;
	public final int OFF = 4;
	
	private int state;
	
	public TrafficLight3(int state){
		this.state = state;
	}
	public TrafficLight3(){
		this.state = 0;
	}

	private int singleLightSize = 20;
	private int xPosition = 5;
	private int gap = 5;
	
	public void paint(Graphics g){
		Color lightRed = new Color(255,0,0);
		Color darkRed = new Color (127,0,0);
		Color lightGreen = new Color (0,255,0);
		Color darkGreen = new Color (0,127,0);
		Color lightYellow = new Color (255,255,0);
		Color darkYellow = new Color (127,127,0);
		
		Color colors [][] = {
				{lightRed,darkYellow,darkGreen},
				{lightRed,lightYellow,darkGreen},
				{darkRed,darkYellow,lightGreen},
				{darkRed,lightYellow,darkGreen},
				{darkRed,darkYellow,darkGreen}
		};
		
		
		// set Background
		g.setColor(Color.lightGray);
		g.fillRect(0,0,getSize().width,getSize().height);
		// draw boarder
		g.setColor(Color.BLACK);
		g.drawRect(0,0,getSize().width-1,getSize().height-1);
		
		for (int i = 0; i<3; i++) {
			g.setColor(colors[state][i]);
			g.fillOval(xPosition,i*singleLightSize+gap,singleLightSize,singleLightSize);
			g.setColor(Color.black);
			g.drawOval(xPosition,i*singleLightSize+gap,singleLightSize-1,singleLightSize-1);
		}
	}

	 public Dimension getPreferredSize(){
	     return new Dimension(singleLightSize + 2 * gap, singleLightSize * 3 + 2 * gap);
	   }
	 
	   public Dimension getMinimumSize()
	   {
	     return new Dimension(singleLightSize + 2 * gap, singleLightSize * 3 + 2 * gap);
	   }	

	   public void setState(int state)
	   {
		   if (state < 5){
			   this.state = state;
			   repaint();			   
		   }
	   }	
}
