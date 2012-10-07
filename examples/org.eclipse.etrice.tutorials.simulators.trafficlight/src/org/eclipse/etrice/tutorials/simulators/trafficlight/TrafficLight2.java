/*******************************************************************************
 * Copyright (c) 2012 tieto deutschland gmbh (http://www.tieto.com)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thomas Jung
 *******************************************************************************/ 


package org.eclipse.etrice.tutorials.simulators.trafficlight;
import java.awt.*;
import java.awt.event.*;


public class TrafficLight2 extends Canvas {
	// Traffic light has 4 states
	// 0 = red
	// 1 = yellowRed
	// 2 = green
	// 3 = yellow
	
	private int state;
	
	public TrafficLight2(int state){
		this.state = state;
	}
	public TrafficLight2(){
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
		
		Color colors [][] = {
				{lightRed,darkGreen},
				{darkRed,lightGreen},
				{darkRed,darkGreen}
		};
		
		// set Background
		g.setColor(Color.lightGray);
		g.fillRect(0,0,getSize().width,getSize().height);
		// draw boarder
		g.setColor(Color.BLACK);
		g.drawRect(0,0,getSize().width-1,getSize().height-1);
		
		for (int i = 0; i<2; i++) {
			g.setColor(colors[state][i]);
			g.fillOval(xPosition,i*singleLightSize+gap,singleLightSize,singleLightSize);
			g.setColor(Color.black);
			g.drawOval(xPosition,i*singleLightSize+gap,singleLightSize-1,singleLightSize-1);
		}
	}

	 public Dimension getPreferredSize(){
	     return new Dimension(singleLightSize + 2 * gap, singleLightSize * 2 + 2 * gap);
	   }
	 
	   public Dimension getMinimumSize()
	   {
	     return new Dimension(singleLightSize + 2 * gap, singleLightSize * 2 + 2 * gap);
	   }	

	   public void setState(int state)
	   {
		   // avoid array error
		   if (state < 3){
			   this.state = state;
			   repaint();
		   }
	   }	

}
